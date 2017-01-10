package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.InputSubstream;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.amazonaws.services.s3.internal.RepeatableFileInputStream;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsAccessor;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import com.google.gdata.util.common.base.StringUtil;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class EncryptionUtils {
    private static final String INSTRUCTION_SUFFIX = ".instruction";

    public static S3Object adjustOutputToDesiredRange(S3Object s3Object, long[] jArr) {
        if (jArr != null && jArr[0] <= jArr[1]) {
            try {
                InputStream objectContent = s3Object.getObjectContent();
                s3Object.setObjectContent(new S3ObjectInputStream(new AdjustedRangeInputStream(objectContent, jArr[0], jArr[1]), objectContent.getHttpRequest()));
            } catch (IOException e) {
                throw new AmazonClientException("Error adjusting output to desired byte range: " + e.getMessage());
            }
        }
        return s3Object;
    }

    @Deprecated
    public static EncryptionInstruction buildInstructionFromInstructionFile(S3Object s3Object, EncryptionMaterials encryptionMaterials, Provider provider) {
        return buildInstructionFromInstructionFile(s3Object, new StaticEncryptionMaterialsProvider(encryptionMaterials), provider);
    }

    public static EncryptionInstruction buildInstructionFromInstructionFile(S3Object s3Object, EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider) {
        JSONObject parseJSONInstruction = parseJSONInstruction(s3Object);
        try {
            byte[] bytes = parseJSONInstruction.getString(Headers.CRYPTO_KEY).getBytes();
            byte[] bytes2 = parseJSONInstruction.getString(Headers.CRYPTO_IV).getBytes();
            Map convertJSONToMap = convertJSONToMap(parseJSONInstruction.getString(Headers.MATERIALS_DESCRIPTION));
            bytes = Base64.decodeBase64(bytes);
            bytes2 = Base64.decodeBase64(bytes2);
            if (bytes == null || bytes2 == null || convertJSONToMap == null) {
                throw new AmazonClientException(String.format("Necessary encryption info not found in the instruction file '%s' in bucket '%s'", new Object[]{s3Object.getKey(), s3Object.getBucketName()}));
            }
            EncryptionMaterials retrieveOriginalMaterials = retrieveOriginalMaterials(convertJSONToMap, encryptionMaterialsProvider);
            if (retrieveOriginalMaterials == null) {
                throw new AmazonClientException(String.format("Unable to retrieve the encryption materials that originally encrypted object corresponding to instruction file '%s' in bucket '%s'.", new Object[]{s3Object.getKey(), s3Object.getBucketName()}));
            }
            SecretKey decryptedSymmetricKey = getDecryptedSymmetricKey(bytes, retrieveOriginalMaterials, provider);
            return new EncryptionInstruction(convertJSONToMap, bytes, decryptedSymmetricKey, createSymmetricCipher(decryptedSymmetricKey, 2, provider, bytes2));
        } catch (JSONException e) {
            throw new AmazonClientException("Unable to parse retrieved instruction file : " + e.getMessage());
        }
    }

    @Deprecated
    public static EncryptionInstruction buildInstructionFromObjectMetadata(S3Object s3Object, EncryptionMaterials encryptionMaterials, Provider provider) {
        return buildInstructionFromObjectMetadata(s3Object, new StaticEncryptionMaterialsProvider(encryptionMaterials), provider);
    }

    public static EncryptionInstruction buildInstructionFromObjectMetadata(S3Object s3Object, EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider) {
        ObjectMetadata objectMetadata = s3Object.getObjectMetadata();
        byte[] cryptoBytesFromMetadata = getCryptoBytesFromMetadata(Headers.CRYPTO_KEY, objectMetadata);
        byte[] cryptoBytesFromMetadata2 = getCryptoBytesFromMetadata(Headers.CRYPTO_IV, objectMetadata);
        Map convertJSONToMap = convertJSONToMap(getStringFromMetadata(Headers.MATERIALS_DESCRIPTION, objectMetadata));
        if (cryptoBytesFromMetadata == null || cryptoBytesFromMetadata2 == null || convertJSONToMap == null) {
            throw new AmazonClientException(String.format("Necessary encryption info not found in the headers of file '%s' in bucket '%s'", new Object[]{s3Object.getKey(), s3Object.getBucketName()}));
        }
        EncryptionMaterials retrieveOriginalMaterials = retrieveOriginalMaterials(convertJSONToMap, encryptionMaterialsProvider);
        if (retrieveOriginalMaterials == null) {
            throw new AmazonClientException(String.format("Unable to retrieve the encryption materials that originally encrypted file '%s' in bucket '%s'.", new Object[]{s3Object.getKey(), s3Object.getBucketName()}));
        }
        SecretKey decryptedSymmetricKey = getDecryptedSymmetricKey(cryptoBytesFromMetadata, retrieveOriginalMaterials, provider);
        return new EncryptionInstruction(convertJSONToMap, cryptoBytesFromMetadata, decryptedSymmetricKey, createSymmetricCipher(decryptedSymmetricKey, 2, provider, cryptoBytesFromMetadata2));
    }

    private static long calculateCryptoContentLength(Cipher cipher, PutObjectRequest putObjectRequest, ObjectMetadata objectMetadata) {
        long unencryptedContentLength = getUnencryptedContentLength(putObjectRequest, objectMetadata);
        if (unencryptedContentLength == 0) {
            return 0;
        }
        if (unencryptedContentLength < 0) {
            return -1;
        }
        long blockSize = (long) cipher.getBlockSize();
        return (blockSize - (unencryptedContentLength % blockSize)) + unencryptedContentLength;
    }

    public static long calculateCryptoContentLength(Cipher cipher, UploadPartRequest uploadPartRequest) {
        long partSize;
        if (uploadPartRequest.getFile() != null) {
            partSize = uploadPartRequest.getPartSize() > 0 ? uploadPartRequest.getPartSize() : uploadPartRequest.getFile().length();
        } else if (uploadPartRequest.getInputStream() == null) {
            return -1;
        } else {
            partSize = uploadPartRequest.getPartSize();
        }
        long blockSize = (long) cipher.getBlockSize();
        return partSize + (blockSize - (partSize % blockSize));
    }

    private static JSONObject convertInstructionToJSONObject(EncryptionInstruction encryptionInstruction) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(encryptionInstruction.getMaterialsDescription());
            byte[] encodeBase64 = Base64.encodeBase64(encryptionInstruction.getSymmetricCipher().getIV());
            byte[] encodeBase642 = Base64.encodeBase64(encryptionInstruction.getEncryptedSymmetricKey());
            jSONObject.put(Headers.MATERIALS_DESCRIPTION, jSONObject2.toString());
            jSONObject.put(Headers.CRYPTO_KEY, new String(encodeBase642));
            jSONObject.put(Headers.CRYPTO_IV, new String(encodeBase64));
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    private static Map<String, String> convertJSONToMap(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            Map<String, String> hashMap = new HashMap();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, jSONObject.getString(str2));
            }
            return hashMap;
        } catch (JSONException e) {
            throw new AmazonClientException("Unable to parse encryption materials description from metadata :" + e.getMessage());
        }
    }

    private static String convertStreamToString(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return StringUtil.EMPTY_STRING;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
            }
            return stringBuilder.toString();
        } finally {
            inputStream.close();
        }
    }

    public static DeleteObjectRequest createInstructionDeleteObjectRequest(DeleteObjectRequest deleteObjectRequest) {
        return new DeleteObjectRequest(deleteObjectRequest.getBucketName(), deleteObjectRequest.getKey() + INSTRUCTION_SUFFIX);
    }

    public static GetObjectRequest createInstructionGetRequest(GetObjectRequest getObjectRequest) {
        return new GetObjectRequest(getObjectRequest.getBucketName(), getObjectRequest.getKey() + INSTRUCTION_SUFFIX, getObjectRequest.getVersionId());
    }

    public static PutObjectRequest createInstructionPutRequest(PutObjectRequest putObjectRequest, EncryptionInstruction encryptionInstruction) {
        byte[] bytes = convertInstructionToJSONObject(encryptionInstruction).toString().getBytes();
        InputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        metadata.setContentLength((long) bytes.length);
        metadata.addUserMetadata(Headers.CRYPTO_INSTRUCTION_FILE, StringUtil.EMPTY_STRING);
        putObjectRequest.setKey(putObjectRequest.getKey() + INSTRUCTION_SUFFIX);
        putObjectRequest.setMetadata(metadata);
        putObjectRequest.setInputStream(byteArrayInputStream);
        return putObjectRequest;
    }

    public static PutObjectRequest createInstructionPutRequest(String str, String str2, EncryptionInstruction encryptionInstruction) {
        byte[] bytes = convertInstructionToJSONObject(encryptionInstruction).toString().getBytes();
        InputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength((long) bytes.length);
        objectMetadata.addUserMetadata(Headers.CRYPTO_INSTRUCTION_FILE, StringUtil.EMPTY_STRING);
        return new PutObjectRequest(str, str2 + INSTRUCTION_SUFFIX, byteArrayInputStream, objectMetadata);
    }

    public static Cipher createSymmetricCipher(SecretKey secretKey, int i, Provider provider, byte[] bArr) {
        Cipher instance;
        if (provider != null) {
            try {
                instance = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD, provider);
            } catch (Throwable e) {
                throw new AmazonClientException("Unable to build cipher with the provided algorithm and padding: " + e.getMessage(), e);
            }
        }
        instance = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
        if (bArr != null) {
            instance.init(i, secretKey, new IvParameterSpec(bArr));
        } else {
            instance.init(i, secretKey);
        }
        return instance;
    }

    public static S3Object decryptObjectUsingInstruction(S3Object s3Object, EncryptionInstruction encryptionInstruction) {
        InputStream objectContent = s3Object.getObjectContent();
        s3Object.setObjectContent(new S3ObjectInputStream(new CipherInputStream(objectContent, encryptionInstruction.getSymmetricCipher()), objectContent.getHttpRequest()));
        return s3Object;
    }

    @Deprecated
    public static S3Object decryptObjectUsingMetadata(S3Object s3Object, EncryptionMaterials encryptionMaterials, Provider provider) {
        return decryptObjectUsingInstruction(s3Object, buildInstructionFromObjectMetadata(s3Object, encryptionMaterials, provider));
    }

    public static PutObjectRequest encryptRequestUsingInstruction(PutObjectRequest putObjectRequest, EncryptionInstruction encryptionInstruction) {
        Cipher symmetricCipher = encryptionInstruction.getSymmetricCipher();
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        if (metadata == null) {
            metadata = new ObjectMetadata();
        }
        if (metadata.getContentMD5() != null) {
            metadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_MD5, metadata.getContentMD5());
        }
        long unencryptedContentLength = getUnencryptedContentLength(putObjectRequest, metadata);
        if (unencryptedContentLength >= 0) {
            metadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_LENGTH, Long.toString(unencryptedContentLength));
        }
        unencryptedContentLength = calculateCryptoContentLength(encryptionInstruction.getSymmetricCipher(), putObjectRequest, metadata);
        if (unencryptedContentLength >= 0) {
            metadata.setContentLength(unencryptedContentLength);
        }
        putObjectRequest.setMetadata(metadata);
        putObjectRequest.setInputStream(getEncryptedInputStream(putObjectRequest, symmetricCipher));
        putObjectRequest.setFile(null);
        return putObjectRequest;
    }

    @Deprecated
    public static PutObjectRequest encryptRequestUsingMetadata(PutObjectRequest putObjectRequest, EncryptionMaterials encryptionMaterials, Provider provider) {
        EncryptionInstruction generateInstruction = generateInstruction(encryptionMaterials, provider);
        PutObjectRequest encryptRequestUsingInstruction = encryptRequestUsingInstruction(putObjectRequest, generateInstruction);
        updateMetadataWithEncryptionInstruction(putObjectRequest, generateInstruction);
        return encryptRequestUsingInstruction;
    }

    @Deprecated
    public static EncryptionInstruction generateInstruction(EncryptionMaterials encryptionMaterials, Provider provider) {
        return generateInstruction(new StaticEncryptionMaterialsProvider(encryptionMaterials), provider);
    }

    public static EncryptionInstruction generateInstruction(EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider) {
        SecretKey generateOneTimeUseSymmetricKey = generateOneTimeUseSymmetricKey();
        Cipher createSymmetricCipher = createSymmetricCipher(generateOneTimeUseSymmetricKey, 1, provider, null);
        EncryptionMaterials encryptionMaterials = encryptionMaterialsProvider.getEncryptionMaterials();
        return new EncryptionInstruction(encryptionMaterials.getMaterialsDescription(), getEncryptedSymmetricKey(generateOneTimeUseSymmetricKey, encryptionMaterials, provider), generateOneTimeUseSymmetricKey, createSymmetricCipher);
    }

    public static SecretKey generateOneTimeUseSymmetricKey() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            instance.init(JceEncryptionConstants.SYMMETRIC_KEY_LENGTH, new SecureRandom());
            return instance.generateKey();
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to generate envelope symmetric key:" + e.getMessage(), e);
        }
    }

    public static long[] getAdjustedCryptoRange(long[] jArr) {
        if (jArr == null || jArr[0] > jArr[1]) {
            return null;
        }
        return new long[]{getCipherBlockLowerBound(jArr[0]), getCipherBlockUpperBound(jArr[1])};
    }

    private static long getCipherBlockLowerBound(long j) {
        long j2 = (long) JceEncryptionConstants.SYMMETRIC_CIPHER_BLOCK_SIZE;
        j2 = (j - (j % j2)) - j2;
        return j2 < 0 ? 0 : j2;
    }

    private static long getCipherBlockUpperBound(long j) {
        long j2 = (long) JceEncryptionConstants.SYMMETRIC_CIPHER_BLOCK_SIZE;
        return j2 + ((j2 - (j % j2)) + j);
    }

    private static byte[] getCryptoBytesFromMetadata(String str, ObjectMetadata objectMetadata) throws NullPointerException {
        Map userMetadata = objectMetadata.getUserMetadata();
        return (userMetadata == null || !userMetadata.containsKey(str)) ? null : Base64.decodeBase64(((String) userMetadata.get(str)).getBytes());
    }

    private static SecretKey getDecryptedSymmetricKey(byte[] bArr, EncryptionMaterials encryptionMaterials, Provider provider) {
        Key key;
        Cipher instance;
        if (encryptionMaterials.getKeyPair() != null) {
            key = encryptionMaterials.getKeyPair().getPrivate();
        } else {
            Object symmetricKey = encryptionMaterials.getSymmetricKey();
        }
        if (provider != null) {
            try {
                instance = Cipher.getInstance(key.getAlgorithm(), provider);
            } catch (Throwable e) {
                throw new AmazonClientException("Unable to decrypt symmetric key from object metadata : " + e.getMessage(), e);
            }
        }
        instance = Cipher.getInstance(key.getAlgorithm());
        instance.init(2, key);
        return new SecretKeySpec(instance.doFinal(bArr), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
    }

    private static InputStream getEncryptedInputStream(PutObjectRequest putObjectRequest, Cipher cipher) {
        try {
            InputStream inputStream = putObjectRequest.getInputStream();
            if (putObjectRequest.getFile() != null) {
                inputStream = new RepeatableFileInputStream(putObjectRequest.getFile());
            }
            return new CipherInputStream(inputStream, cipher);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to create cipher input stream: " + e.getMessage(), e);
        }
    }

    public static InputStream getEncryptedInputStream(UploadPartRequest uploadPartRequest, Cipher cipher) {
        try {
            InputStream inputStream = uploadPartRequest.getInputStream();
            if (uploadPartRequest.getFile() != null) {
                inputStream = new InputSubstream(new RepeatableFileInputStream(uploadPartRequest.getFile()), uploadPartRequest.getFileOffset(), uploadPartRequest.getPartSize(), uploadPartRequest.isLastPart());
            }
            InputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
            if (!uploadPartRequest.isLastPart()) {
                cipherInputStream = new InputSubstream(cipherInputStream, 0, uploadPartRequest.getPartSize(), false);
            }
            long partSize = uploadPartRequest.getPartSize();
            return new ByteRangeCapturingInputStream(cipherInputStream, partSize - ((long) cipher.getBlockSize()), partSize);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to create cipher input stream: " + e.getMessage(), e);
        }
    }

    public static byte[] getEncryptedSymmetricKey(SecretKey secretKey, EncryptionMaterials encryptionMaterials, Provider provider) {
        if (encryptionMaterials.getKeyPair() != null) {
            Key key = encryptionMaterials.getKeyPair().getPublic();
        } else {
            Object symmetricKey = encryptionMaterials.getSymmetricKey();
        }
        try {
            byte[] encoded = secretKey.getEncoded();
            Cipher instance = provider != null ? Cipher.getInstance(key.getAlgorithm(), provider) : Cipher.getInstance(key.getAlgorithm());
            instance.init(1, key);
            return instance.doFinal(encoded);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to encrypt symmetric key: " + e.getMessage(), e);
        }
    }

    private static String getStringFromMetadata(String str, ObjectMetadata objectMetadata) throws NullPointerException {
        Map userMetadata = objectMetadata.getUserMetadata();
        return (userMetadata == null || !userMetadata.containsKey(str)) ? null : (String) userMetadata.get(str);
    }

    private static long getUnencryptedContentLength(PutObjectRequest putObjectRequest, ObjectMetadata objectMetadata) {
        return putObjectRequest.getFile() != null ? putObjectRequest.getFile().length() : (putObjectRequest.getInputStream() == null || objectMetadata.getContentLength() <= 0) ? -1 : objectMetadata.getContentLength();
    }

    public static boolean isEncryptionInfoInInstructionFile(S3Object s3Object) {
        if (s3Object == null) {
            return false;
        }
        Map userMetadata = s3Object.getObjectMetadata().getUserMetadata();
        return userMetadata != null ? userMetadata.containsKey(Headers.CRYPTO_INSTRUCTION_FILE) : false;
    }

    public static boolean isEncryptionInfoInMetadata(S3Object s3Object) {
        Map userMetadata = s3Object.getObjectMetadata().getUserMetadata();
        return userMetadata != null && userMetadata.containsKey(Headers.CRYPTO_IV) && userMetadata.containsKey(Headers.CRYPTO_KEY) && userMetadata.containsKey(Headers.MATERIALS_DESCRIPTION);
    }

    private static JSONObject parseJSONInstruction(S3Object s3Object) {
        try {
            return new JSONObject(convertStreamToString(s3Object.getObjectContent()));
        } catch (Exception e) {
            throw new AmazonClientException("Error parsing JSON instruction file: " + e.getMessage());
        }
    }

    private static EncryptionMaterials retrieveOriginalMaterials(Map<String, String> map, EncryptionMaterialsAccessor encryptionMaterialsAccessor) {
        return encryptionMaterialsAccessor == null ? null : encryptionMaterialsAccessor.getEncryptionMaterials(map);
    }

    private static void updateMetadata(ObjectMetadata objectMetadata, byte[] bArr, Cipher cipher, Map<String, String> map) {
        if (bArr != null) {
            objectMetadata.addUserMetadata(Headers.CRYPTO_KEY, new String(Base64.encodeBase64(bArr)));
        }
        objectMetadata.addUserMetadata(Headers.CRYPTO_IV, new String(Base64.encodeBase64(cipher.getIV())));
        objectMetadata.addUserMetadata(Headers.MATERIALS_DESCRIPTION, new JSONObject((Map) map).toString());
    }

    public static ObjectMetadata updateMetadataWithEncryptionInfo(InitiateMultipartUploadRequest initiateMultipartUploadRequest, byte[] bArr, Cipher cipher, Map<String, String> map) {
        ObjectMetadata objectMetadata = initiateMultipartUploadRequest.getObjectMetadata();
        if (objectMetadata == null) {
            objectMetadata = new ObjectMetadata();
        }
        updateMetadata(objectMetadata, bArr, cipher, map);
        return objectMetadata;
    }

    public static void updateMetadataWithEncryptionInstruction(PutObjectRequest putObjectRequest, EncryptionInstruction encryptionInstruction) {
        byte[] encryptedSymmetricKey = encryptionInstruction.getEncryptedSymmetricKey();
        Cipher symmetricCipher = encryptionInstruction.getSymmetricCipher();
        Map materialsDescription = encryptionInstruction.getMaterialsDescription();
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        if (metadata == null) {
            metadata = new ObjectMetadata();
        }
        if (putObjectRequest.getFile() != null) {
            metadata.setContentType(Mimetypes.getInstance().getMimetype(putObjectRequest.getFile()));
        }
        updateMetadata(metadata, encryptedSymmetricKey, symmetricCipher, materialsDescription);
        putObjectRequest.setMetadata(metadata);
    }
}
