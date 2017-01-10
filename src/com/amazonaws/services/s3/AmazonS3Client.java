package com.amazonaws.services.s3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonServiceException.ErrorType;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.DefaultRequest;
import com.amazonaws.HttpMethod;
import com.amazonaws.Request;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SystemPropertiesCredentialsProvider;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.handlers.RequestHandler;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.javax.xml.XMLConstants;
import com.amazonaws.services.s3.internal.BucketNameUtils;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazonaws.services.s3.internal.InputSubstream;
import com.amazonaws.services.s3.internal.MD5DigestCalculatingInputStream;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.amazonaws.services.s3.internal.ObjectExpirationHeaderHandler;
import com.amazonaws.services.s3.internal.ProgressReportingInputStream;
import com.amazonaws.services.s3.internal.RepeatableFileInputStream;
import com.amazonaws.services.s3.internal.RepeatableInputStream;
import com.amazonaws.services.s3.internal.ResponseHeaderHandlerChain;
import com.amazonaws.services.s3.internal.S3ErrorResponseHandler;
import com.amazonaws.services.s3.internal.S3MetadataResponseHandler;
import com.amazonaws.services.s3.internal.S3ObjectResponseHandler;
import com.amazonaws.services.s3.internal.S3QueryStringSigner;
import com.amazonaws.services.s3.internal.S3Signer;
import com.amazonaws.services.s3.internal.S3StringResponseHandler;
import com.amazonaws.services.s3.internal.S3VersionHeaderHandler;
import com.amazonaws.services.s3.internal.S3XmlResponseHandler;
import com.amazonaws.services.s3.internal.ServerSideEncryptionHeaderHandler;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazonaws.services.s3.model.BucketPolicy;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazonaws.services.s3.model.CopyPartResult;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.DeleteBucketPolicyRequest;
import com.amazonaws.services.s3.model.DeleteBucketRequest;
import com.amazonaws.services.s3.model.DeleteBucketWebsiteConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.DeleteVersionRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GenericBucketRequest;
import com.amazonaws.services.s3.model.GetBucketAclRequest;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.GetBucketPolicyRequest;
import com.amazonaws.services.s3.model.GetBucketWebsiteConfigurationRequest;
import com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.Grant;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListBucketsRequest;
import com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ListPartsRequest;
import com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazonaws.services.s3.model.MultiFactorAuthentication;
import com.amazonaws.services.s3.model.MultiObjectDeleteException;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.ProgressListener;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.Region;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.SetBucketAclRequest;
import com.amazonaws.services.s3.model.SetBucketLoggingConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketNotificationConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketPolicyRequest;
import com.amazonaws.services.s3.model.SetBucketVersioningConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketWebsiteConfigurationRequest;
import com.amazonaws.services.s3.model.StorageClass;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import com.amazonaws.services.s3.model.VersionListing;
import com.amazonaws.services.s3.model.transform.AclXmlFactory;
import com.amazonaws.services.s3.model.transform.BucketConfigurationXmlFactory;
import com.amazonaws.services.s3.model.transform.MultiObjectDeleteXmlFactory;
import com.amazonaws.services.s3.model.transform.RequestXmlFactory;
import com.amazonaws.services.s3.model.transform.Unmarshallers.AccessControlListUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.BucketCrossOriginConfigurationUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.BucketLifecycleConfigurationUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.BucketLocationUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.BucketLoggingConfigurationnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.BucketNotificationConfigurationUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.BucketTaggingConfigurationUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.BucketVersioningConfigurationUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.BucketWebsiteConfigurationUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.CompleteMultipartUploadResultUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.CopyObjectUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.DeleteObjectsResultUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.InitiateMultipartUploadResultUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.ListBucketsOwnerUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.ListBucketsUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.ListMultipartUploadsResultUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.ListObjectsUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.ListPartsResultUnmarshaller;
import com.amazonaws.services.s3.model.transform.Unmarshallers.VersionListUnmarshaller;
import com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.CompleteMultipartUploadHandler;
import com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.CopyObjectResultHandler;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.Md5Utils;
import com.google.api.client.xml.XmlHttpParser;
import com.google.common.net.HttpHeaders;
import com.google.gdata.client.GDataProtocol.Header;
import com.google.gdata.util.common.base.StringUtil;
import com.google.protobuf.CodedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.xml.sax.helpers.XMLReaderFactory;

public class AmazonS3Client extends AmazonWebServiceClient implements AmazonS3 {
    private static final BucketConfigurationXmlFactory bucketConfigurationXmlFactory;
    private static Log log;
    private AWSCredentialsProvider awsCredentialsProvider;
    private final BucketNameUtils bucketNameUtils;
    private S3ErrorResponseHandler errorResponseHandler;
    private S3XmlResponseHandler<Void> voidResponseHandler;

    /* renamed from: com.amazonaws.services.s3.AmazonS3Client.1 */
    class C00621 extends AWSCredentialsProviderChain {
        C00621(AWSCredentialsProvider... aWSCredentialsProviderArr) {
            super(aWSCredentialsProviderArr);
        }

        public AWSCredentials getCredentials() {
            try {
                return super.getCredentials();
            } catch (AmazonClientException e) {
                AmazonS3Client.log.debug("No credentials available; falling back to anonymous access");
                return null;
            }
        }
    }

    static {
        log = LogFactory.getLog(AmazonS3Client.class);
        bucketConfigurationXmlFactory = new BucketConfigurationXmlFactory();
    }

    public AmazonS3Client() {
        this(new C00621(new SystemPropertiesCredentialsProvider(), new ClasspathPropertiesFileCredentialsProvider()));
    }

    public AmazonS3Client(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonS3Client(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.errorResponseHandler = new S3ErrorResponseHandler();
        this.voidResponseHandler = new S3XmlResponseHandler(null);
        this.bucketNameUtils = new BucketNameUtils();
        System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
        try {
            XMLReaderFactory.createXMLReader();
        } catch (Throwable e) {
            log.warn("Unable to load XMLReader " + e.getMessage(), e);
        }
        this.awsCredentialsProvider = new StaticCredentialsProvider(aWSCredentials);
        init();
    }

    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.errorResponseHandler = new S3ErrorResponseHandler();
        this.voidResponseHandler = new S3XmlResponseHandler(null);
        this.bucketNameUtils = new BucketNameUtils();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private static void addAclHeaders(Request<? extends AmazonWebServiceRequest> request, AccessControlList accessControlList) {
        Set<Grant> grants = accessControlList.getGrants();
        Map hashMap = new HashMap();
        for (Grant grant : grants) {
            if (!hashMap.containsKey(grant.getPermission())) {
                hashMap.put(grant.getPermission(), new LinkedList());
            }
            ((Collection) hashMap.get(grant.getPermission())).add(grant.getGrantee());
        }
        for (Permission permission : Permission.values()) {
            if (hashMap.containsKey(permission)) {
                Collection<Grantee> collection = (Collection) hashMap.get(permission);
                StringBuilder stringBuilder = new StringBuilder();
                Object obj = null;
                for (Grantee grantee : collection) {
                    if (obj == null) {
                        obj = 1;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(grantee.getTypeIdentifier()).append("=").append("\"").append(grantee.getIdentifier()).append("\"");
                }
                request.addHeader(permission.getHeaderName(), stringBuilder.toString());
            }
        }
    }

    private static void addDateHeader(Request<?> request, String str, Date date) {
        if (date != null) {
            request.addHeader(str, ServiceUtils.formatRfc822Date(date));
        }
    }

    private static void addResponseHeaderParameters(Request<?> request, ResponseHeaderOverrides responseHeaderOverrides) {
        if (responseHeaderOverrides != null) {
            if (responseHeaderOverrides.getCacheControl() != null) {
                request.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CACHE_CONTROL, responseHeaderOverrides.getCacheControl());
            }
            if (responseHeaderOverrides.getContentDisposition() != null) {
                request.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_DISPOSITION, responseHeaderOverrides.getContentDisposition());
            }
            if (responseHeaderOverrides.getContentEncoding() != null) {
                request.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_ENCODING, responseHeaderOverrides.getContentEncoding());
            }
            if (responseHeaderOverrides.getContentLanguage() != null) {
                request.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_LANGUAGE, responseHeaderOverrides.getContentLanguage());
            }
            if (responseHeaderOverrides.getContentType() != null) {
                request.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_TYPE, responseHeaderOverrides.getContentType());
            }
            if (responseHeaderOverrides.getExpires() != null) {
                request.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_EXPIRES, responseHeaderOverrides.getExpires());
            }
        }
    }

    private static void addStringListHeader(Request<?> request, String str, List<String> list) {
        if (list != null && !list.isEmpty()) {
            request.addHeader(str, ServiceUtils.join(list));
        }
    }

    private void assertParameterNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    private URI convertToVirtualHostEndpoint(String str) {
        try {
            return new URI(this.endpoint.getScheme() + "://" + str + "." + this.endpoint.getAuthority());
        } catch (Throwable e) {
            throw new AmazonClientException("Can't turn bucket name into a URI: " + e.getMessage(), e);
        }
    }

    private void fireProgressEvent(ProgressListener progressListener, int i) {
        if (progressListener != null) {
            ProgressEvent progressEvent = new ProgressEvent(0);
            progressEvent.setEventCode(i);
            progressListener.progressChanged(progressEvent);
        }
    }

    private AccessControlList getAcl(String str, String str2, String str3, AmazonWebServiceRequest amazonWebServiceRequest) {
        if (amazonWebServiceRequest == null) {
            amazonWebServiceRequest = new GenericBucketRequest(str);
        }
        Request createRequest = createRequest(str, str2, amazonWebServiceRequest, HttpMethodName.GET);
        createRequest.addParameter("acl", null);
        if (str3 != null) {
            createRequest.addParameter("versionId", str3);
        }
        return (AccessControlList) invoke(createRequest, new AccessControlListUnmarshaller(), str, str2);
    }

    private void init() {
        setEndpoint(Constants.S3_HOSTNAME);
        this.requestHandlers.addAll(new HandlerChainFactory().newRequestHandlerChain("/com/amazonaws/services/s3/request.handlers"));
    }

    private <X, Y extends AmazonWebServiceRequest> X invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> httpResponseHandler, String str, String str2) {
        for (Entry entry : request.getOriginalRequest().copyPrivateRequestParameters().entrySet()) {
            request.addParameter((String) entry.getKey(), (String) entry.getValue());
        }
        if (request.getHeaders().get(HttpHeaders.CONTENT_TYPE) == null) {
            request.addHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=utf-8");
        }
        AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (!(originalRequest == null || originalRequest.getRequestCredentials() == null)) {
            credentials = originalRequest.getRequestCredentials();
        }
        ExecutionContext createExecutionContext = createExecutionContext();
        createExecutionContext.setSigner(createSigner(request, str, str2));
        createExecutionContext.setCredentials(credentials);
        return this.client.execute(request, httpResponseHandler, this.errorResponseHandler, createExecutionContext);
    }

    private <X, Y extends AmazonWebServiceRequest> X invoke(Request<Y> request, Unmarshaller<X, InputStream> unmarshaller, String str, String str2) {
        return invoke((Request) request, new S3XmlResponseHandler(unmarshaller), str, str2);
    }

    protected static void populateRequestMetadata(Request<?> request, ObjectMetadata objectMetadata) {
        Map rawMetadata = objectMetadata.getRawMetadata();
        if (rawMetadata != null) {
            for (Entry entry : rawMetadata.entrySet()) {
                request.addHeader((String) entry.getKey(), entry.getValue().toString());
            }
        }
        rawMetadata = objectMetadata.getUserMetadata();
        if (rawMetadata != null) {
            for (Entry entry2 : rawMetadata.entrySet()) {
                String str = (String) entry2.getKey();
                String str2 = (String) entry2.getValue();
                if (str != null) {
                    str = str.trim();
                }
                if (str2 != null) {
                    str2 = str2.trim();
                }
                request.addHeader(Headers.S3_USER_METADATA_PREFIX + str, str2);
            }
        }
    }

    private static void populateRequestWithCopyObjectParameters(Request<? extends AmazonWebServiceRequest> request, CopyObjectRequest copyObjectRequest) {
        String str = "/" + ServiceUtils.urlEncode(copyObjectRequest.getSourceBucketName()) + "/" + ServiceUtils.urlEncode(copyObjectRequest.getSourceKey());
        if (copyObjectRequest.getSourceVersionId() != null) {
            str = str + "?versionId=" + copyObjectRequest.getSourceVersionId();
        }
        request.addHeader("x-amz-copy-source", str);
        addDateHeader(request, Headers.COPY_SOURCE_IF_MODIFIED_SINCE, copyObjectRequest.getModifiedSinceConstraint());
        addDateHeader(request, Headers.COPY_SOURCE_IF_UNMODIFIED_SINCE, copyObjectRequest.getUnmodifiedSinceConstraint());
        addStringListHeader(request, Headers.COPY_SOURCE_IF_MATCH, copyObjectRequest.getMatchingETagConstraints());
        addStringListHeader(request, Headers.COPY_SOURCE_IF_NO_MATCH, copyObjectRequest.getNonmatchingETagConstraints());
        if (copyObjectRequest.getAccessControlList() != null) {
            addAclHeaders(request, copyObjectRequest.getAccessControlList());
        } else if (copyObjectRequest.getCannedAccessControlList() != null) {
            request.addHeader(Headers.S3_CANNED_ACL, copyObjectRequest.getCannedAccessControlList().toString());
        }
        if (copyObjectRequest.getStorageClass() != null) {
            request.addHeader(Headers.STORAGE_CLASS, copyObjectRequest.getStorageClass());
        }
        ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
        if (newObjectMetadata != null) {
            request.addHeader(Headers.METADATA_DIRECTIVE, "REPLACE");
            populateRequestMetadata(request, newObjectMetadata);
        }
    }

    private static void populateRequestWithCopyPartParameters(Request<?> request, CopyPartRequest copyPartRequest) {
        String str = "/" + ServiceUtils.urlEncode(copyPartRequest.getSourceBucketName()) + "/" + ServiceUtils.urlEncode(copyPartRequest.getSourceKey());
        if (copyPartRequest.getSourceVersionId() != null) {
            str = str + "?versionId=" + copyPartRequest.getSourceVersionId();
        }
        request.addHeader("x-amz-copy-source", str);
        addDateHeader(request, Headers.COPY_SOURCE_IF_MODIFIED_SINCE, copyPartRequest.getModifiedSinceConstraint());
        addDateHeader(request, Headers.COPY_SOURCE_IF_UNMODIFIED_SINCE, copyPartRequest.getUnmodifiedSinceConstraint());
        addStringListHeader(request, Headers.COPY_SOURCE_IF_MATCH, copyPartRequest.getMatchingETagConstraints());
        addStringListHeader(request, Headers.COPY_SOURCE_IF_NO_MATCH, copyPartRequest.getNonmatchingETagConstraints());
        if (copyPartRequest.getFirstByte() != null && copyPartRequest.getLastByte() != null) {
            request.addHeader(Headers.COPY_PART_RANGE, "bytes=" + copyPartRequest.getFirstByte() + "-" + copyPartRequest.getLastByte());
        }
    }

    private void populateRequestWithMfaDetails(Request<?> request, MultiFactorAuthentication multiFactorAuthentication) {
        if (multiFactorAuthentication != null) {
            String uri = request.getEndpoint().toString();
            if (uri.startsWith("http://")) {
                request.setEndpoint(URI.create(uri.replace("http://", "https://")));
                log.info("Overriding current endpoint to use HTTPS as required by S3 for requests containing an MFA header");
            }
            request.addHeader(Headers.S3_MFA, multiFactorAuthentication.getDeviceSerialNumber() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + multiFactorAuthentication.getToken());
        }
    }

    private void setAcl(String str, String str2, String str3, AccessControlList accessControlList, AmazonWebServiceRequest amazonWebServiceRequest) {
        if (amazonWebServiceRequest == null) {
            amazonWebServiceRequest = new GenericBucketRequest(str);
        }
        Request createRequest = createRequest(str, str2, amazonWebServiceRequest, HttpMethodName.PUT);
        createRequest.addParameter("acl", null);
        if (str3 != null) {
            createRequest.addParameter("versionId", str3);
        }
        byte[] convertToXmlByteArray = new AclXmlFactory().convertToXmlByteArray(accessControlList);
        createRequest.addHeader(HttpHeaders.CONTENT_TYPE, "text/plain");
        createRequest.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(convertToXmlByteArray.length));
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        invoke(createRequest, this.voidResponseHandler, str, str2);
    }

    private void setAcl(String str, String str2, String str3, CannedAccessControlList cannedAccessControlList, AmazonWebServiceRequest amazonWebServiceRequest) {
        if (amazonWebServiceRequest == null) {
            amazonWebServiceRequest = new GenericBucketRequest(str);
        }
        Request createRequest = createRequest(str, str2, amazonWebServiceRequest, HttpMethodName.PUT);
        createRequest.addParameter("acl", null);
        createRequest.addHeader(Headers.S3_CANNED_ACL, cannedAccessControlList.toString());
        if (str3 != null) {
            createRequest.addParameter("versionId", str3);
        }
        invoke(createRequest, this.voidResponseHandler, str, str2);
    }

    private boolean validIP(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }
        int length = split.length;
        int i = 0;
        while (i < length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                if (parseInt < 0 || parseInt > 255) {
                    return false;
                }
                i++;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(abortMultipartUploadRequest, "The request parameter must be specified when aborting a multipart upload");
        assertParameterNotNull(abortMultipartUploadRequest.getBucketName(), "The bucket name parameter must be specified when aborting a multipart upload");
        assertParameterNotNull(abortMultipartUploadRequest.getKey(), "The key parameter must be specified when aborting a multipart upload");
        assertParameterNotNull(abortMultipartUploadRequest.getUploadId(), "The upload ID parameter must be specified when aborting a multipart upload");
        String bucketName = abortMultipartUploadRequest.getBucketName();
        String key = abortMultipartUploadRequest.getKey();
        Request createRequest = createRequest(bucketName, key, abortMultipartUploadRequest, HttpMethodName.DELETE);
        createRequest.addParameter("uploadId", abortMultipartUploadRequest.getUploadId());
        invoke(createRequest, this.voidResponseHandler, bucketName, key);
    }

    public void addRequestHandler(RequestHandler requestHandler) {
        this.requestHandlers.add(requestHandler);
    }

    public void changeObjectStorageClass(String str, String str2, StorageClass storageClass) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(str, "The bucketName parameter must be specified when changing an object's storage class");
        assertParameterNotNull(str2, "The key parameter must be specified when changing an object's storage class");
        assertParameterNotNull(storageClass, "The newStorageClass parameter must be specified when changing an object's storage class");
        copyObject(new CopyObjectRequest(str, str2, str, str2).withStorageClass(storageClass.toString()));
    }

    public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(completeMultipartUploadRequest, "The request parameter must be specified when completing a multipart upload");
        String bucketName = completeMultipartUploadRequest.getBucketName();
        String key = completeMultipartUploadRequest.getKey();
        String uploadId = completeMultipartUploadRequest.getUploadId();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when completing a multipart upload");
        assertParameterNotNull(key, "The key parameter must be specified when completing a multipart upload");
        assertParameterNotNull(uploadId, "The upload ID parameter must be specified when completing a multipart upload");
        assertParameterNotNull(completeMultipartUploadRequest.getPartETags(), "The part ETags parameter must be specified when completing a multipart upload");
        Request createRequest = createRequest(bucketName, key, completeMultipartUploadRequest, HttpMethodName.POST);
        createRequest.addParameter("uploadId", uploadId);
        byte[] convertToXmlByteArray = RequestXmlFactory.convertToXmlByteArray(completeMultipartUploadRequest.getPartETags());
        createRequest.addHeader(HttpHeaders.CONTENT_TYPE, "text/plain");
        createRequest.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(convertToXmlByteArray.length));
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        HttpResponseHandler responseHeaderHandlerChain = new ResponseHeaderHandlerChain(new CompleteMultipartUploadResultUnmarshaller(), new ServerSideEncryptionHeaderHandler(), new ObjectExpirationHeaderHandler());
        CompleteMultipartUploadHandler completeMultipartUploadHandler = (CompleteMultipartUploadHandler) invoke(createRequest, responseHeaderHandlerChain, bucketName, key);
        if (completeMultipartUploadHandler.getCompleteMultipartUploadResult() != null) {
            completeMultipartUploadHandler.getCompleteMultipartUploadResult().setVersionId((String) responseHeaderHandlerChain.getResponseHeaders().get(Headers.S3_VERSION_ID));
            return completeMultipartUploadHandler.getCompleteMultipartUploadResult();
        }
        throw completeMultipartUploadHandler.getAmazonS3Exception();
    }

    public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(copyObjectRequest.getSourceBucketName(), "The source bucket name must be specified when copying an object");
        assertParameterNotNull(copyObjectRequest.getSourceKey(), "The source object key must be specified when copying an object");
        assertParameterNotNull(copyObjectRequest.getDestinationBucketName(), "The destination bucket name must be specified when copying an object");
        assertParameterNotNull(copyObjectRequest.getDestinationKey(), "The destination object key must be specified when copying an object");
        String destinationKey = copyObjectRequest.getDestinationKey();
        String destinationBucketName = copyObjectRequest.getDestinationBucketName();
        Request createRequest = createRequest(destinationBucketName, destinationKey, copyObjectRequest, HttpMethodName.PUT);
        populateRequestWithCopyObjectParameters(createRequest, copyObjectRequest);
        createRequest.getHeaders().remove(HttpHeaders.CONTENT_LENGTH);
        try {
            CopyObjectResultHandler copyObjectResultHandler = (CopyObjectResultHandler) invoke(createRequest, new ResponseHeaderHandlerChain(new CopyObjectUnmarshaller(), new ServerSideEncryptionHeaderHandler(), new S3VersionHeaderHandler(), new ObjectExpirationHeaderHandler()), destinationBucketName, destinationKey);
            if (copyObjectResultHandler.getErrorCode() != null) {
                destinationBucketName = copyObjectResultHandler.getErrorCode();
                String errorMessage = copyObjectResultHandler.getErrorMessage();
                String errorRequestId = copyObjectResultHandler.getErrorRequestId();
                destinationKey = copyObjectResultHandler.getErrorHostId();
                AmazonS3Exception amazonS3Exception = new AmazonS3Exception(errorMessage);
                amazonS3Exception.setErrorCode(destinationBucketName);
                amazonS3Exception.setErrorType(ErrorType.Service);
                amazonS3Exception.setRequestId(errorRequestId);
                amazonS3Exception.setExtendedRequestId(destinationKey);
                amazonS3Exception.setServiceName(createRequest.getServiceName());
                amazonS3Exception.setStatusCode(200);
                throw amazonS3Exception;
            }
            CopyObjectResult copyObjectResult = new CopyObjectResult();
            copyObjectResult.setETag(copyObjectResultHandler.getETag());
            copyObjectResult.setLastModifiedDate(copyObjectResultHandler.getLastModified());
            copyObjectResult.setVersionId(copyObjectResultHandler.getVersionId());
            copyObjectResult.setServerSideEncryption(copyObjectResultHandler.getServerSideEncryption());
            copyObjectResult.setExpirationTime(copyObjectResultHandler.getExpirationTime());
            copyObjectResult.setExpirationTimeRuleId(copyObjectResultHandler.getExpirationTimeRuleId());
            return copyObjectResult;
        } catch (AmazonS3Exception e) {
            if (e.getStatusCode() == Constants.FAILED_PRECONDITION_STATUS_CODE) {
                return null;
            }
            throw e;
        }
    }

    public CopyObjectResult copyObject(String str, String str2, String str3, String str4) throws AmazonClientException, AmazonServiceException {
        return copyObject(new CopyObjectRequest(str, str2, str3, str4));
    }

    public CopyPartResult copyPart(CopyPartRequest copyPartRequest) {
        assertParameterNotNull(copyPartRequest.getSourceBucketName(), "The source bucket name must be specified when copying a part");
        assertParameterNotNull(copyPartRequest.getSourceKey(), "The source object key must be specified when copying a part");
        assertParameterNotNull(copyPartRequest.getDestinationBucketName(), "The destination bucket name must be specified when copying a part");
        assertParameterNotNull(copyPartRequest.getUploadId(), "The upload id must be specified when copying a part");
        assertParameterNotNull(copyPartRequest.getDestinationKey(), "The destination object key must be specified when copying a part");
        assertParameterNotNull(Integer.valueOf(copyPartRequest.getPartNumber()), "The part number must be specified when copying a part");
        String destinationKey = copyPartRequest.getDestinationKey();
        String destinationBucketName = copyPartRequest.getDestinationBucketName();
        Request createRequest = createRequest(destinationBucketName, destinationKey, copyPartRequest, HttpMethodName.PUT);
        populateRequestWithCopyPartParameters(createRequest, copyPartRequest);
        createRequest.addParameter("uploadId", copyPartRequest.getUploadId());
        createRequest.addParameter("partNumber", Integer.toString(copyPartRequest.getPartNumber()));
        createRequest.getHeaders().remove(HttpHeaders.CONTENT_LENGTH);
        try {
            CopyObjectResultHandler copyObjectResultHandler = (CopyObjectResultHandler) invoke(createRequest, new ResponseHeaderHandlerChain(new CopyObjectUnmarshaller(), new ServerSideEncryptionHeaderHandler(), new S3VersionHeaderHandler()), destinationBucketName, destinationKey);
            if (copyObjectResultHandler.getErrorCode() != null) {
                destinationBucketName = copyObjectResultHandler.getErrorCode();
                String errorMessage = copyObjectResultHandler.getErrorMessage();
                String errorRequestId = copyObjectResultHandler.getErrorRequestId();
                destinationKey = copyObjectResultHandler.getErrorHostId();
                AmazonS3Exception amazonS3Exception = new AmazonS3Exception(errorMessage);
                amazonS3Exception.setErrorCode(destinationBucketName);
                amazonS3Exception.setErrorType(ErrorType.Service);
                amazonS3Exception.setRequestId(errorRequestId);
                amazonS3Exception.setExtendedRequestId(destinationKey);
                amazonS3Exception.setServiceName(createRequest.getServiceName());
                amazonS3Exception.setStatusCode(200);
                throw amazonS3Exception;
            }
            CopyPartResult copyPartResult = new CopyPartResult();
            copyPartResult.setETag(copyObjectResultHandler.getETag());
            copyPartResult.setPartNumber(copyPartRequest.getPartNumber());
            copyPartResult.setLastModifiedDate(copyObjectResultHandler.getLastModified());
            copyPartResult.setVersionId(copyObjectResultHandler.getVersionId());
            copyPartResult.setServerSideEncryption(copyObjectResultHandler.getServerSideEncryption());
            return copyPartResult;
        } catch (AmazonS3Exception e) {
            if (e.getStatusCode() == Constants.FAILED_PRECONDITION_STATUS_CODE) {
                return null;
            }
            throw e;
        }
    }

    public Bucket createBucket(CreateBucketRequest createBucketRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(createBucketRequest, "The CreateBucketRequest parameter must be specified when creating a bucket");
        String bucketName = createBucketRequest.getBucketName();
        String region = createBucketRequest.getRegion();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when creating a bucket");
        if (bucketName != null) {
            bucketName = bucketName.trim();
        }
        this.bucketNameUtils.validateBucketName(bucketName);
        Request createRequest = createRequest(bucketName, null, createBucketRequest, HttpMethodName.PUT);
        if (createBucketRequest.getAccessControlList() != null) {
            addAclHeaders(createRequest, createBucketRequest.getAccessControlList());
        } else if (createBucketRequest.getCannedAcl() != null) {
            createRequest.addHeader(Headers.S3_CANNED_ACL, createBucketRequest.getCannedAcl().toString());
        }
        if (region == null) {
            String host = this.endpoint.getHost();
            if (host.contains("us-west-1")) {
                region = Region.US_West.toString();
            } else if (host.contains("us-west-2")) {
                region = Region.US_West_2.toString();
            } else if (host.contains("eu-west-1")) {
                region = Region.EU_Ireland.toString();
            } else if (host.contains("ap-southeast-1")) {
                region = Region.AP_Singapore.toString();
            } else if (host.contains("ap-northeast-1")) {
                region = Region.AP_Tokyo.toString();
            } else if (host.contains("sa-east-1")) {
                region = Region.SA_SaoPaulo.toString();
            }
        }
        if (!(region == null || region.toUpperCase().equals(Region.US_Standard.toString()))) {
            XmlWriter xmlWriter = new XmlWriter();
            xmlWriter.start("CreateBucketConfiguration", XMLConstants.XMLNS_ATTRIBUTE, Constants.XML_NAMESPACE);
            xmlWriter.start("LocationConstraint").value(region).end();
            xmlWriter.end();
            createRequest.setContent(new ByteArrayInputStream(xmlWriter.getBytes()));
        }
        invoke(createRequest, this.voidResponseHandler, bucketName, null);
        return new Bucket(bucketName);
    }

    public Bucket createBucket(String str) throws AmazonClientException, AmazonServiceException {
        return createBucket(new CreateBucketRequest(str));
    }

    public Bucket createBucket(String str, Region region) throws AmazonClientException, AmazonServiceException {
        return createBucket(new CreateBucketRequest(str, region));
    }

    public Bucket createBucket(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return createBucket(new CreateBucketRequest(str, str2));
    }

    protected <X extends AmazonWebServiceRequest> Request<X> createRequest(String str, String str2, X x, HttpMethodName httpMethodName) {
        Request<X> defaultRequest = new DefaultRequest(x, Constants.S3_SERVICE_NAME);
        defaultRequest.setHttpMethod(httpMethodName);
        if (!this.bucketNameUtils.isDNSBucketName(str) || validIP(this.endpoint.getHost())) {
            defaultRequest.setEndpoint(this.endpoint);
            if (str != null) {
                defaultRequest.setResourcePath(str + "/" + (str2 != null ? ServiceUtils.urlEncode(str2) : StringUtil.EMPTY_STRING));
            }
        } else {
            defaultRequest.setEndpoint(convertToVirtualHostEndpoint(str));
            defaultRequest.setResourcePath(ServiceUtils.urlEncode(str2));
        }
        return defaultRequest;
    }

    protected Signer createSigner(Request<?> request, String str, String str2) {
        return new S3Signer(request.getHttpMethod().toString(), "/" + (str != null ? str + "/" : StringUtil.EMPTY_STRING) + (str2 != null ? ServiceUtils.urlEncode(str2) : StringUtil.EMPTY_STRING));
    }

    public void deleteBucket(DeleteBucketRequest deleteBucketRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(deleteBucketRequest, "The DeleteBucketRequest parameter must be specified when deleting a bucket");
        String bucketName = deleteBucketRequest.getBucketName();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when deleting a bucket");
        invoke(createRequest(bucketName, null, deleteBucketRequest, HttpMethodName.DELETE), this.voidResponseHandler, bucketName, null);
    }

    public void deleteBucket(String str) throws AmazonClientException, AmazonServiceException {
        deleteBucket(new DeleteBucketRequest(str));
    }

    public void deleteBucketCrossOriginConfiguration(String str) {
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.DELETE);
        createRequest.addParameter("cors", null);
        invoke(createRequest, this.voidResponseHandler, str, null);
    }

    public void deleteBucketLifecycleConfiguration(String str) {
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.DELETE);
        createRequest.addParameter("lifecycle", null);
        invoke(createRequest, this.voidResponseHandler, str, null);
    }

    public void deleteBucketPolicy(DeleteBucketPolicyRequest deleteBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(deleteBucketPolicyRequest, "The request object must be specified when deleting a bucket policy");
        String bucketName = deleteBucketPolicyRequest.getBucketName();
        assertParameterNotNull(bucketName, "The bucket name must be specified when deleting a bucket policy");
        Request createRequest = createRequest(bucketName, null, deleteBucketPolicyRequest, HttpMethodName.DELETE);
        createRequest.addParameter("policy", null);
        invoke(createRequest, this.voidResponseHandler, bucketName, null);
    }

    public void deleteBucketPolicy(String str) throws AmazonClientException, AmazonServiceException {
        deleteBucketPolicy(new DeleteBucketPolicyRequest(str));
    }

    public void deleteBucketTaggingConfiguration(String str) {
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.DELETE);
        createRequest.addParameter("tagging", null);
        invoke(createRequest, this.voidResponseHandler, str, null);
    }

    public void deleteBucketWebsiteConfiguration(DeleteBucketWebsiteConfigurationRequest deleteBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        String bucketName = deleteBucketWebsiteConfigurationRequest.getBucketName();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when deleting a bucket's website configuration");
        Request createRequest = createRequest(bucketName, null, deleteBucketWebsiteConfigurationRequest, HttpMethodName.DELETE);
        createRequest.addParameter("website", null);
        createRequest.addHeader(HttpHeaders.CONTENT_TYPE, XmlHttpParser.CONTENT_TYPE);
        invoke(createRequest, this.voidResponseHandler, bucketName, null);
    }

    public void deleteBucketWebsiteConfiguration(String str) throws AmazonClientException, AmazonServiceException {
        deleteBucketWebsiteConfiguration(new DeleteBucketWebsiteConfigurationRequest(str));
    }

    public void deleteObject(DeleteObjectRequest deleteObjectRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(deleteObjectRequest, "The delete object request must be specified when deleting an object");
        assertParameterNotNull(deleteObjectRequest.getBucketName(), "The bucket name must be specified when deleting an object");
        assertParameterNotNull(deleteObjectRequest.getKey(), "The key must be specified when deleting an object");
        invoke(createRequest(deleteObjectRequest.getBucketName(), deleteObjectRequest.getKey(), deleteObjectRequest, HttpMethodName.DELETE), this.voidResponseHandler, deleteObjectRequest.getBucketName(), deleteObjectRequest.getKey());
    }

    public void deleteObject(String str, String str2) throws AmazonClientException, AmazonServiceException {
        deleteObject(new DeleteObjectRequest(str, str2));
    }

    public DeleteObjectsResult deleteObjects(DeleteObjectsRequest deleteObjectsRequest) {
        Request createRequest = createRequest(deleteObjectsRequest.getBucketName(), null, deleteObjectsRequest, HttpMethodName.POST);
        createRequest.addParameter("delete", null);
        if (deleteObjectsRequest.getMfa() != null) {
            populateRequestWithMfaDetails(createRequest, deleteObjectsRequest.getMfa());
        }
        byte[] convertToXmlByteArray = new MultiObjectDeleteXmlFactory().convertToXmlByteArray(deleteObjectsRequest);
        createRequest.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(convertToXmlByteArray.length));
        createRequest.addHeader(HttpHeaders.CONTENT_TYPE, XmlHttpParser.CONTENT_TYPE);
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        try {
            createRequest.addHeader(HttpHeaders.CONTENT_MD5, BinaryUtils.toBase64(Md5Utils.computeMD5Hash(convertToXmlByteArray)));
            DeleteObjectsResponse deleteObjectsResponse = (DeleteObjectsResponse) invoke(createRequest, new DeleteObjectsResultUnmarshaller(), deleteObjectsRequest.getBucketName(), null);
            if (deleteObjectsResponse.getErrors().isEmpty()) {
                return new DeleteObjectsResult(deleteObjectsResponse.getDeletedObjects());
            }
            throw new MultiObjectDeleteException(deleteObjectsResponse.getErrors(), deleteObjectsResponse.getDeletedObjects());
        } catch (Throwable e) {
            throw new AmazonClientException("Couldn't compute md5 sum", e);
        }
    }

    public void deleteVersion(DeleteVersionRequest deleteVersionRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(deleteVersionRequest, "The delete version request object must be specified when deleting a version");
        String bucketName = deleteVersionRequest.getBucketName();
        String key = deleteVersionRequest.getKey();
        String versionId = deleteVersionRequest.getVersionId();
        assertParameterNotNull(bucketName, "The bucket name must be specified when deleting a version");
        assertParameterNotNull(key, "The key must be specified when deleting a version");
        assertParameterNotNull(versionId, "The version ID must be specified when deleting a version");
        Request createRequest = createRequest(bucketName, key, deleteVersionRequest, HttpMethodName.DELETE);
        if (versionId != null) {
            createRequest.addParameter("versionId", versionId);
        }
        if (deleteVersionRequest.getMfa() != null) {
            populateRequestWithMfaDetails(createRequest, deleteVersionRequest.getMfa());
        }
        invoke(createRequest, this.voidResponseHandler, bucketName, key);
    }

    public void deleteVersion(String str, String str2, String str3) throws AmazonClientException, AmazonServiceException {
        deleteVersion(new DeleteVersionRequest(str, str2, str3));
    }

    public boolean doesBucketExist(String str) throws AmazonClientException, AmazonServiceException {
        try {
            listObjects(new ListObjectsRequest(str, null, null, null, Integer.valueOf(0)));
            return true;
        } catch (AmazonServiceException e) {
            if (this.awsCredentialsProvider.getCredentials() == null) {
                throw e;
            } else if (e.getErrorCode().equalsIgnoreCase("InvalidAccessKeyId") || e.getErrorCode().equalsIgnoreCase("SignatureDoesNotMatch")) {
                throw e;
            } else {
                switch (e.getStatusCode()) {
                    case 403:
                        return true;
                    case 404:
                        return false;
                    default:
                        throw e;
                }
            }
        }
    }

    public URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws AmazonClientException {
        assertParameterNotNull(generatePresignedUrlRequest, "The request parameter must be specified when generating a pre-signed URL");
        String bucketName = generatePresignedUrlRequest.getBucketName();
        String key = generatePresignedUrlRequest.getKey();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when generating a pre-signed URL");
        assertParameterNotNull(generatePresignedUrlRequest.getMethod(), "The HTTP method request parameter must be specified when generating a pre-signed URL");
        if (generatePresignedUrlRequest.getExpiration() == null) {
            generatePresignedUrlRequest.setExpiration(new Date(System.currentTimeMillis() + 900000));
        }
        Request createRequest = createRequest(bucketName, key, generatePresignedUrlRequest, HttpMethodName.valueOf(generatePresignedUrlRequest.getMethod().toString()));
        for (Entry entry : generatePresignedUrlRequest.getRequestParameters().entrySet()) {
            createRequest.addParameter((String) entry.getKey(), (String) entry.getValue());
        }
        if (generatePresignedUrlRequest.getContentType() != null) {
            createRequest.addHeader("content-type", generatePresignedUrlRequest.getContentType());
        }
        addResponseHeaderParameters(createRequest, generatePresignedUrlRequest.getResponseHeaders());
        presignRequest(createRequest, generatePresignedUrlRequest.getMethod(), bucketName, key, generatePresignedUrlRequest.getExpiration(), null);
        return ServiceUtils.convertRequestToUrl(createRequest);
    }

    public URL generatePresignedUrl(String str, String str2, Date date) throws AmazonClientException {
        return generatePresignedUrl(str, str2, date, HttpMethod.GET);
    }

    public URL generatePresignedUrl(String str, String str2, Date date, HttpMethod httpMethod) throws AmazonClientException {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(str, str2, httpMethod);
        generatePresignedUrlRequest.setExpiration(date);
        return generatePresignedUrl(generatePresignedUrlRequest);
    }

    public AccessControlList getBucketAcl(GetBucketAclRequest getBucketAclRequest) throws AmazonClientException, AmazonServiceException {
        String bucketName = getBucketAclRequest.getBucketName();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when requesting a bucket's ACL");
        return getAcl(bucketName, null, null, getBucketAclRequest);
    }

    public AccessControlList getBucketAcl(String str) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(str, "The bucket name parameter must be specified when requesting a bucket's ACL");
        return getAcl(str, null, null, null);
    }

    public BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(String str) {
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.GET);
        createRequest.addParameter("cors", null);
        try {
            return (BucketCrossOriginConfiguration) invoke(createRequest, new BucketCrossOriginConfigurationUnmarshaller(), str, null);
        } catch (AmazonServiceException e) {
            switch (e.getStatusCode()) {
                case 404:
                    return null;
                default:
                    throw e;
            }
        }
    }

    public BucketLifecycleConfiguration getBucketLifecycleConfiguration(String str) {
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.GET);
        createRequest.addParameter("lifecycle", null);
        try {
            return (BucketLifecycleConfiguration) invoke(createRequest, new BucketLifecycleConfigurationUnmarshaller(), str, null);
        } catch (AmazonServiceException e) {
            switch (e.getStatusCode()) {
                case 404:
                    return null;
                default:
                    throw e;
            }
        }
    }

    public String getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(getBucketLocationRequest, "The request parameter must be specified when requesting a bucket's location");
        String bucketName = getBucketLocationRequest.getBucketName();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when requesting a bucket's location");
        Request createRequest = createRequest(bucketName, null, getBucketLocationRequest, HttpMethodName.GET);
        createRequest.addParameter("location", null);
        return (String) invoke(createRequest, new BucketLocationUnmarshaller(), bucketName, null);
    }

    public String getBucketLocation(String str) throws AmazonClientException, AmazonServiceException {
        return getBucketLocation(new GetBucketLocationRequest(str));
    }

    public BucketLoggingConfiguration getBucketLoggingConfiguration(String str) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(str, "The bucket name parameter must be specified when requesting a bucket's logging status");
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.GET);
        createRequest.addParameter("logging", null);
        return (BucketLoggingConfiguration) invoke(createRequest, new BucketLoggingConfigurationnmarshaller(), str, null);
    }

    public BucketNotificationConfiguration getBucketNotificationConfiguration(String str) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(str, "The bucket name parameter must be specified when querying notification configuration");
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.GET);
        createRequest.addParameter("notification", null);
        return (BucketNotificationConfiguration) invoke(createRequest, new BucketNotificationConfigurationUnmarshaller(), str, null);
    }

    public BucketPolicy getBucketPolicy(GetBucketPolicyRequest getBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(getBucketPolicyRequest, "The request object must be specified when getting a bucket policy");
        String bucketName = getBucketPolicyRequest.getBucketName();
        assertParameterNotNull(bucketName, "The bucket name must be specified when getting a bucket policy");
        Request createRequest = createRequest(bucketName, null, getBucketPolicyRequest, HttpMethodName.GET);
        createRequest.addParameter("policy", null);
        BucketPolicy bucketPolicy = new BucketPolicy();
        try {
            bucketPolicy.setPolicyText((String) invoke(createRequest, new S3StringResponseHandler(), bucketName, null));
            return bucketPolicy;
        } catch (AmazonServiceException e) {
            if (e.getErrorCode().equals("NoSuchBucketPolicy")) {
                return bucketPolicy;
            }
            throw e;
        }
    }

    public BucketPolicy getBucketPolicy(String str) throws AmazonClientException, AmazonServiceException {
        return getBucketPolicy(new GetBucketPolicyRequest(str));
    }

    public BucketTaggingConfiguration getBucketTaggingConfiguration(String str) {
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.GET);
        createRequest.addParameter("tagging", null);
        try {
            return (BucketTaggingConfiguration) invoke(createRequest, new BucketTaggingConfigurationUnmarshaller(), str, null);
        } catch (AmazonServiceException e) {
            switch (e.getStatusCode()) {
                case 404:
                    return null;
                default:
                    throw e;
            }
        }
    }

    public BucketVersioningConfiguration getBucketVersioningConfiguration(String str) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(str, "The bucket name parameter must be specified when querying versioning configuration");
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.GET);
        createRequest.addParameter("versioning", null);
        return (BucketVersioningConfiguration) invoke(createRequest, new BucketVersioningConfigurationUnmarshaller(), str, null);
    }

    public BucketWebsiteConfiguration getBucketWebsiteConfiguration(GetBucketWebsiteConfigurationRequest getBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        String bucketName = getBucketWebsiteConfigurationRequest.getBucketName();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when requesting a bucket's website configuration");
        Request createRequest = createRequest(bucketName, null, getBucketWebsiteConfigurationRequest, HttpMethodName.GET);
        createRequest.addParameter("website", null);
        createRequest.addHeader(HttpHeaders.CONTENT_TYPE, XmlHttpParser.CONTENT_TYPE);
        try {
            return (BucketWebsiteConfiguration) invoke(createRequest, new BucketWebsiteConfigurationUnmarshaller(), bucketName, null);
        } catch (AmazonServiceException e) {
            if (e.getStatusCode() == 404) {
                return null;
            }
            throw e;
        }
    }

    public BucketWebsiteConfiguration getBucketWebsiteConfiguration(String str) throws AmazonClientException, AmazonServiceException {
        return getBucketWebsiteConfiguration(new GetBucketWebsiteConfigurationRequest(str));
    }

    public S3ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return (S3ResponseMetadata) this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    public ObjectMetadata getObject(GetObjectRequest getObjectRequest, File file) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(file, "The destination file parameter must be specified when downloading an object directly to a file");
        S3Object object = getObject(getObjectRequest);
        if (object == null) {
            return null;
        }
        ServiceUtils.downloadObjectToFile(object, file, getObjectRequest.getRange() == null);
        return object.getObjectMetadata();
    }

    public S3Object getObject(GetObjectRequest getObjectRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(getObjectRequest, "The GetObjectRequest parameter must be specified when requesting an object");
        assertParameterNotNull(getObjectRequest.getBucketName(), "The bucket name parameter must be specified when requesting an object");
        assertParameterNotNull(getObjectRequest.getKey(), "The key parameter must be specified when requesting an object");
        Request createRequest = createRequest(getObjectRequest.getBucketName(), getObjectRequest.getKey(), getObjectRequest, HttpMethodName.GET);
        if (getObjectRequest.getVersionId() != null) {
            createRequest.addParameter("versionId", getObjectRequest.getVersionId());
        }
        if (getObjectRequest.getRange() != null) {
            long[] range = getObjectRequest.getRange();
            createRequest.addHeader(HttpHeaders.RANGE, "bytes=" + Long.toString(range[0]) + "-" + Long.toString(range[1]));
        }
        addResponseHeaderParameters(createRequest, getObjectRequest.getResponseHeaders());
        addDateHeader(createRequest, Header.IF_MODIFIED_SINCE, getObjectRequest.getModifiedSinceConstraint());
        addDateHeader(createRequest, Header.IF_UNMODIFIED_SINCE, getObjectRequest.getUnmodifiedSinceConstraint());
        addStringListHeader(createRequest, Header.IF_MATCH, getObjectRequest.getMatchingETagConstraints());
        addStringListHeader(createRequest, Header.IF_NONE_MATCH, getObjectRequest.getNonmatchingETagConstraints());
        ProgressListener progressListener = getObjectRequest.getProgressListener();
        try {
            S3Object s3Object = (S3Object) invoke(createRequest, new S3ObjectResponseHandler(), getObjectRequest.getBucketName(), getObjectRequest.getKey());
            s3Object.setBucketName(getObjectRequest.getBucketName());
            s3Object.setKey(getObjectRequest.getKey());
            if (progressListener == null) {
                return s3Object;
            }
            InputStream objectContent = s3Object.getObjectContent();
            InputStream progressReportingInputStream = new ProgressReportingInputStream(objectContent, progressListener);
            progressReportingInputStream.setFireCompletedEvent(true);
            s3Object.setObjectContent(new S3ObjectInputStream(progressReportingInputStream, objectContent.getHttpRequest()));
            fireProgressEvent(progressListener, 1);
            return s3Object;
        } catch (AmazonS3Exception e) {
            if (e.getStatusCode() == Constants.FAILED_PRECONDITION_STATUS_CODE || e.getStatusCode() == 304) {
                fireProgressEvent(progressListener, 8);
                return null;
            }
            fireProgressEvent(progressListener, 4);
            throw e;
        }
    }

    public S3Object getObject(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return getObject(new GetObjectRequest(str, str2));
    }

    public AccessControlList getObjectAcl(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return getObjectAcl(str, str2, null);
    }

    public AccessControlList getObjectAcl(String str, String str2, String str3) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(str, "The bucket name parameter must be specified when requesting an object's ACL");
        assertParameterNotNull(str2, "The key parameter must be specified when requesting an object's ACL");
        return getAcl(str, str2, str3, null);
    }

    public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(getObjectMetadataRequest, "The GetObjectMetadataRequest parameter must be specified when requesting an object's metadata");
        String bucketName = getObjectMetadataRequest.getBucketName();
        String key = getObjectMetadataRequest.getKey();
        String versionId = getObjectMetadataRequest.getVersionId();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when requesting an object's metadata");
        assertParameterNotNull(key, "The key parameter must be specified when requesting an object's metadata");
        Request createRequest = createRequest(bucketName, key, getObjectMetadataRequest, HttpMethodName.HEAD);
        if (versionId != null) {
            createRequest.addParameter("versionId", versionId);
        }
        return (ObjectMetadata) invoke(createRequest, new S3MetadataResponseHandler(), bucketName, key);
    }

    public ObjectMetadata getObjectMetadata(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return getObjectMetadata(new GetObjectMetadataRequest(str, str2));
    }

    public String getResourceUrl(String str, String str2) {
        URI convertToVirtualHostEndpoint;
        String urlEncode;
        if (this.bucketNameUtils.isDNSBucketName(str)) {
            convertToVirtualHostEndpoint = convertToVirtualHostEndpoint(str);
            urlEncode = ServiceUtils.urlEncode(str2);
        } else {
            convertToVirtualHostEndpoint = this.endpoint;
            if (str != null) {
                urlEncode = str + "/" + (str2 != null ? ServiceUtils.urlEncode(str2) : StringUtil.EMPTY_STRING);
            } else {
                urlEncode = null;
            }
        }
        try {
            return new URI(convertToVirtualHostEndpoint.getScheme(), convertToVirtualHostEndpoint.getHost(), "/" + urlEncode, null).toURL().toString();
        } catch (Exception e) {
            return null;
        }
    }

    public Owner getS3AccountOwner() throws AmazonClientException, AmazonServiceException {
        return (Owner) invoke(createRequest(null, null, new ListBucketsRequest(), HttpMethodName.GET), new ListBucketsOwnerUnmarshaller(), null, null);
    }

    public InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(initiateMultipartUploadRequest, "The request parameter must be specified when initiating a multipart upload");
        assertParameterNotNull(initiateMultipartUploadRequest.getBucketName(), "The bucket name parameter must be specified when initiating a multipart upload");
        assertParameterNotNull(initiateMultipartUploadRequest.getKey(), "The key parameter must be specified when initiating a multipart upload");
        Request createRequest = createRequest(initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey(), initiateMultipartUploadRequest, HttpMethodName.POST);
        createRequest.addParameter("uploads", null);
        if (initiateMultipartUploadRequest.getStorageClass() != null) {
            createRequest.addHeader(Headers.STORAGE_CLASS, initiateMultipartUploadRequest.getStorageClass().toString());
        }
        if (initiateMultipartUploadRequest.getAccessControlList() != null) {
            addAclHeaders(createRequest, initiateMultipartUploadRequest.getAccessControlList());
        } else if (initiateMultipartUploadRequest.getCannedACL() != null) {
            createRequest.addHeader(Headers.S3_CANNED_ACL, initiateMultipartUploadRequest.getCannedACL().toString());
        }
        if (initiateMultipartUploadRequest.objectMetadata != null) {
            populateRequestMetadata(createRequest, initiateMultipartUploadRequest.objectMetadata);
        }
        createRequest.getHeaders().remove(HttpHeaders.CONTENT_LENGTH);
        createRequest.setContent(new ByteArrayInputStream(new byte[0]));
        return (InitiateMultipartUploadResult) invoke(createRequest, new ResponseHeaderHandlerChain(new InitiateMultipartUploadResultUnmarshaller(), new ServerSideEncryptionHeaderHandler()), initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey());
    }

    public List<Bucket> listBuckets() throws AmazonClientException, AmazonServiceException {
        return listBuckets(new ListBucketsRequest());
    }

    public List<Bucket> listBuckets(ListBucketsRequest listBucketsRequest) throws AmazonClientException, AmazonServiceException {
        return (List) invoke(createRequest(null, null, listBucketsRequest, HttpMethodName.GET), new ListBucketsUnmarshaller(), null, null);
    }

    public MultipartUploadListing listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(listMultipartUploadsRequest, "The request parameter must be specified when listing multipart uploads");
        assertParameterNotNull(listMultipartUploadsRequest.getBucketName(), "The bucket name parameter must be specified when listing multipart uploads");
        Request createRequest = createRequest(listMultipartUploadsRequest.getBucketName(), null, listMultipartUploadsRequest, HttpMethodName.GET);
        createRequest.addParameter("uploads", null);
        if (listMultipartUploadsRequest.getKeyMarker() != null) {
            createRequest.addParameter("key-marker", listMultipartUploadsRequest.getKeyMarker());
        }
        if (listMultipartUploadsRequest.getMaxUploads() != null) {
            createRequest.addParameter("max-uploads", listMultipartUploadsRequest.getMaxUploads().toString());
        }
        if (listMultipartUploadsRequest.getUploadIdMarker() != null) {
            createRequest.addParameter("upload-id-marker", listMultipartUploadsRequest.getUploadIdMarker());
        }
        if (listMultipartUploadsRequest.getDelimiter() != null) {
            createRequest.addParameter("delimiter", listMultipartUploadsRequest.getDelimiter());
        }
        if (listMultipartUploadsRequest.getPrefix() != null) {
            createRequest.addParameter("prefix", listMultipartUploadsRequest.getPrefix());
        }
        return (MultipartUploadListing) invoke(createRequest, new ListMultipartUploadsResultUnmarshaller(), listMultipartUploadsRequest.getBucketName(), null);
    }

    public ObjectListing listNextBatchOfObjects(ObjectListing objectListing) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(objectListing, "The previous object listing parameter must be specified when listing the next batch of objects in a bucket");
        if (objectListing.isTruncated()) {
            return listObjects(new ListObjectsRequest(objectListing.getBucketName(), objectListing.getPrefix(), objectListing.getNextMarker(), objectListing.getDelimiter(), new Integer(objectListing.getMaxKeys())));
        }
        ObjectListing objectListing2 = new ObjectListing();
        objectListing2.setBucketName(objectListing.getBucketName());
        objectListing2.setDelimiter(objectListing.getDelimiter());
        objectListing2.setMarker(objectListing.getNextMarker());
        objectListing2.setMaxKeys(objectListing.getMaxKeys());
        objectListing2.setPrefix(objectListing.getPrefix());
        objectListing2.setTruncated(false);
        return objectListing2;
    }

    public VersionListing listNextBatchOfVersions(VersionListing versionListing) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(versionListing, "The previous version listing parameter must be specified when listing the next batch of versions in a bucket");
        if (versionListing.isTruncated()) {
            return listVersions(new ListVersionsRequest(versionListing.getBucketName(), versionListing.getPrefix(), versionListing.getNextKeyMarker(), versionListing.getNextVersionIdMarker(), versionListing.getDelimiter(), new Integer(versionListing.getMaxKeys())));
        }
        VersionListing versionListing2 = new VersionListing();
        versionListing2.setBucketName(versionListing.getBucketName());
        versionListing2.setDelimiter(versionListing.getDelimiter());
        versionListing2.setKeyMarker(versionListing.getNextKeyMarker());
        versionListing2.setVersionIdMarker(versionListing.getNextVersionIdMarker());
        versionListing2.setMaxKeys(versionListing.getMaxKeys());
        versionListing2.setPrefix(versionListing.getPrefix());
        versionListing2.setTruncated(false);
        return versionListing2;
    }

    public ObjectListing listObjects(ListObjectsRequest listObjectsRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(listObjectsRequest.getBucketName(), "The bucket name parameter must be specified when listing objects in a bucket");
        Request createRequest = createRequest(listObjectsRequest.getBucketName(), null, listObjectsRequest, HttpMethodName.GET);
        if (listObjectsRequest.getPrefix() != null) {
            createRequest.addParameter("prefix", listObjectsRequest.getPrefix());
        }
        if (listObjectsRequest.getMarker() != null) {
            createRequest.addParameter("marker", listObjectsRequest.getMarker());
        }
        if (listObjectsRequest.getDelimiter() != null) {
            createRequest.addParameter("delimiter", listObjectsRequest.getDelimiter());
        }
        if (listObjectsRequest.getMaxKeys() != null && listObjectsRequest.getMaxKeys().intValue() >= 0) {
            createRequest.addParameter("max-keys", listObjectsRequest.getMaxKeys().toString());
        }
        return (ObjectListing) invoke(createRequest, new ListObjectsUnmarshaller(), listObjectsRequest.getBucketName(), null);
    }

    public ObjectListing listObjects(String str) throws AmazonClientException, AmazonServiceException {
        return listObjects(new ListObjectsRequest(str, null, null, null, null));
    }

    public ObjectListing listObjects(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return listObjects(new ListObjectsRequest(str, str2, null, null, null));
    }

    public PartListing listParts(ListPartsRequest listPartsRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(listPartsRequest, "The request parameter must be specified when listing parts");
        assertParameterNotNull(listPartsRequest.getBucketName(), "The bucket name parameter must be specified when listing parts");
        assertParameterNotNull(listPartsRequest.getKey(), "The key parameter must be specified when listing parts");
        assertParameterNotNull(listPartsRequest.getUploadId(), "The upload ID parameter must be specified when listing parts");
        Request createRequest = createRequest(listPartsRequest.getBucketName(), listPartsRequest.getKey(), listPartsRequest, HttpMethodName.GET);
        createRequest.addParameter("uploadId", listPartsRequest.getUploadId());
        if (listPartsRequest.getMaxParts() != null) {
            createRequest.addParameter("max-parts", listPartsRequest.getMaxParts().toString());
        }
        if (listPartsRequest.getPartNumberMarker() != null) {
            createRequest.addParameter("part-number-marker", listPartsRequest.getPartNumberMarker().toString());
        }
        return (PartListing) invoke(createRequest, new ListPartsResultUnmarshaller(), listPartsRequest.getBucketName(), listPartsRequest.getKey());
    }

    public VersionListing listVersions(ListVersionsRequest listVersionsRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(listVersionsRequest.getBucketName(), "The bucket name parameter must be specified when listing versions in a bucket");
        Request createRequest = createRequest(listVersionsRequest.getBucketName(), null, listVersionsRequest, HttpMethodName.GET);
        createRequest.addParameter("versions", null);
        if (listVersionsRequest.getPrefix() != null) {
            createRequest.addParameter("prefix", listVersionsRequest.getPrefix());
        }
        if (listVersionsRequest.getKeyMarker() != null) {
            createRequest.addParameter("key-marker", listVersionsRequest.getKeyMarker());
        }
        if (listVersionsRequest.getVersionIdMarker() != null) {
            createRequest.addParameter("version-id-marker", listVersionsRequest.getVersionIdMarker());
        }
        if (listVersionsRequest.getDelimiter() != null) {
            createRequest.addParameter("delimiter", listVersionsRequest.getDelimiter());
        }
        if (listVersionsRequest.getMaxResults() != null && listVersionsRequest.getMaxResults().intValue() >= 0) {
            createRequest.addParameter("max-keys", listVersionsRequest.getMaxResults().toString());
        }
        return (VersionListing) invoke(createRequest, new VersionListUnmarshaller(), listVersionsRequest.getBucketName(), null);
    }

    public VersionListing listVersions(String str, String str2) throws AmazonClientException, AmazonServiceException {
        return listVersions(new ListVersionsRequest(str, str2, null, null, null, null));
    }

    public VersionListing listVersions(String str, String str2, String str3, String str4, String str5, Integer num) throws AmazonClientException, AmazonServiceException {
        return listVersions(new ListVersionsRequest().withBucketName(str).withPrefix(str2).withDelimiter(str5).withKeyMarker(str3).withVersionIdMarker(str4).withMaxResults(num));
    }

    protected <T> void presignRequest(Request<T> request, HttpMethod httpMethod, String str, String str2, Date date, String str3) {
        if (this.requestHandlers != null) {
            for (RequestHandler beforeRequest : this.requestHandlers) {
                beforeRequest.beforeRequest(request);
            }
        }
        String str4 = "/" + (str != null ? str + "/" : StringUtil.EMPTY_STRING) + (str2 != null ? ServiceUtils.urlEncode(str2) : StringUtil.EMPTY_STRING) + (str3 != null ? "?" + str3 : StringUtil.EMPTY_STRING);
        AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (!(originalRequest == null || originalRequest.getRequestCredentials() == null)) {
            credentials = originalRequest.getRequestCredentials();
        }
        new S3QueryStringSigner(httpMethod.toString(), str4, date).sign(request, credentials);
        if (request.getHeaders().containsKey(Headers.SECURITY_TOKEN)) {
            request.addParameter(Headers.SECURITY_TOKEN, (String) request.getHeaders().get(Headers.SECURITY_TOKEN));
            request.getHeaders().remove(Headers.SECURITY_TOKEN);
        }
    }

    public PutObjectResult putObject(PutObjectRequest putObjectRequest) throws AmazonClientException, AmazonServiceException {
        InputStream repeatableFileInputStream;
        Throwable e;
        InputStream inputStream;
        MD5DigestCalculatingInputStream mD5DigestCalculatingInputStream;
        InputStream inputStream2;
        String contentMD5;
        FileInputStream fileInputStream = null;
        assertParameterNotNull(putObjectRequest, "The PutObjectRequest parameter must be specified when uploading an object");
        String bucketName = putObjectRequest.getBucketName();
        String key = putObjectRequest.getKey();
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        InputStream inputStream3 = putObjectRequest.getInputStream();
        ProgressListener progressListener = putObjectRequest.getProgressListener();
        ObjectMetadata objectMetadata = metadata == null ? new ObjectMetadata() : metadata;
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when uploading an object");
        assertParameterNotNull(key, "The key parameter must be specified when uploading an object");
        if (putObjectRequest.getFile() != null) {
            File file = putObjectRequest.getFile();
            objectMetadata.setContentLength(file.length());
            if (objectMetadata.getContentType() == null) {
                objectMetadata.setContentType(Mimetypes.getInstance().getMimetype(file));
            }
            try {
                inputStream3 = new FileInputStream(file);
                try {
                    objectMetadata.setContentMD5(BinaryUtils.toBase64(Md5Utils.computeMD5Hash(inputStream3)));
                    try {
                        inputStream3.close();
                    } catch (Exception e2) {
                    }
                    try {
                        repeatableFileInputStream = new RepeatableFileInputStream(file);
                    } catch (Throwable e3) {
                        throw new AmazonClientException("Unable to find file to upload", e3);
                    }
                } catch (Exception e4) {
                    e3 = e4;
                    inputStream = inputStream3;
                    try {
                        throw new AmazonClientException("Unable to calculate MD5 hash: " + e3.getMessage(), e3);
                    } catch (Throwable th) {
                        e3 = th;
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                        }
                        throw e3;
                    }
                } catch (Throwable th2) {
                    e3 = th2;
                    inputStream = inputStream3;
                    fileInputStream.close();
                    throw e3;
                }
            } catch (Exception e6) {
                e3 = e6;
                throw new AmazonClientException("Unable to calculate MD5 hash: " + e3.getMessage(), e3);
            }
        }
        repeatableFileInputStream = inputStream3;
        Request createRequest = createRequest(bucketName, key, putObjectRequest, HttpMethodName.PUT);
        if (putObjectRequest.getAccessControlList() != null) {
            addAclHeaders(createRequest, putObjectRequest.getAccessControlList());
        } else if (putObjectRequest.getCannedAcl() != null) {
            createRequest.addHeader(Headers.S3_CANNED_ACL, putObjectRequest.getCannedAcl().toString());
        }
        if (putObjectRequest.getStorageClass() != null) {
            createRequest.addHeader(Headers.STORAGE_CLASS, putObjectRequest.getStorageClass());
        }
        if (objectMetadata.getRawMetadata().get(HttpHeaders.CONTENT_LENGTH) == null) {
            log.warn("No content length specified for stream data.  Stream contents will be buffered in memory and could result in out of memory errors.");
        }
        if (progressListener != null) {
            inputStream3 = new ProgressReportingInputStream(repeatableFileInputStream, progressListener);
            fireProgressEvent(progressListener, 1);
            repeatableFileInputStream = inputStream3;
        }
        if (!repeatableFileInputStream.markSupported()) {
            int i = Constants.DEFAULT_STREAM_BUFFER_SIZE;
            String property = System.getProperty("com.amazonaws.sdk.s3.defaultStreamBufferSize");
            if (property != null) {
                try {
                    i = Integer.parseInt(property);
                } catch (Exception e7) {
                    log.warn("Unable to parse buffer size override from value: " + property);
                }
            }
            repeatableFileInputStream = new RepeatableInputStream(repeatableFileInputStream, i);
        }
        if (objectMetadata.getContentMD5() == null) {
            try {
                mD5DigestCalculatingInputStream = new MD5DigestCalculatingInputStream(repeatableFileInputStream);
                inputStream2 = mD5DigestCalculatingInputStream;
            } catch (Throwable e8) {
                log.warn("No MD5 digest algorithm available.  Unable to calculate checksum and verify data integrity.", e8);
            }
            if (objectMetadata.getContentType() == null) {
                objectMetadata.setContentType(Mimetypes.MIMETYPE_OCTET_STREAM);
            }
            populateRequestMetadata(createRequest, objectMetadata);
            createRequest.setContent(inputStream2);
            metadata = (ObjectMetadata) invoke(createRequest, new S3MetadataResponseHandler(), bucketName, key);
            inputStream2.close();
            contentMD5 = objectMetadata.getContentMD5();
            if (mD5DigestCalculatingInputStream != null) {
                contentMD5 = BinaryUtils.toBase64(mD5DigestCalculatingInputStream.getMd5Digest());
            }
            if (metadata != null || r1 == null || Arrays.equals(BinaryUtils.fromBase64(r1), BinaryUtils.fromHex(metadata.getETag()))) {
                fireProgressEvent(progressListener, 2);
                PutObjectResult putObjectResult = new PutObjectResult();
                putObjectResult.setETag(metadata.getETag());
                putObjectResult.setVersionId(metadata.getVersionId());
                putObjectResult.setServerSideEncryption(metadata.getServerSideEncryption());
                putObjectResult.setExpirationTime(metadata.getExpirationTime());
                putObjectResult.setExpirationTimeRuleId(metadata.getExpirationTimeRuleId());
                return putObjectResult;
            }
            fireProgressEvent(progressListener, 4);
            throw new AmazonClientException("Unable to verify integrity of data upload.  Client calculated content hash didn't match hash calculated by Amazon S3.  You may need to delete the data stored in Amazon S3.");
        }
        mD5DigestCalculatingInputStream = null;
        inputStream2 = repeatableFileInputStream;
        if (objectMetadata.getContentType() == null) {
            objectMetadata.setContentType(Mimetypes.MIMETYPE_OCTET_STREAM);
        }
        populateRequestMetadata(createRequest, objectMetadata);
        createRequest.setContent(inputStream2);
        try {
            metadata = (ObjectMetadata) invoke(createRequest, new S3MetadataResponseHandler(), bucketName, key);
            try {
                inputStream2.close();
            } catch (Throwable e9) {
                log.warn("Unable to cleanly close input stream: " + e9.getMessage(), e9);
            }
            contentMD5 = objectMetadata.getContentMD5();
            if (mD5DigestCalculatingInputStream != null) {
                contentMD5 = BinaryUtils.toBase64(mD5DigestCalculatingInputStream.getMd5Digest());
            }
            if (metadata != null) {
            }
            fireProgressEvent(progressListener, 2);
            PutObjectResult putObjectResult2 = new PutObjectResult();
            putObjectResult2.setETag(metadata.getETag());
            putObjectResult2.setVersionId(metadata.getVersionId());
            putObjectResult2.setServerSideEncryption(metadata.getServerSideEncryption());
            putObjectResult2.setExpirationTime(metadata.getExpirationTime());
            putObjectResult2.setExpirationTimeRuleId(metadata.getExpirationTimeRuleId());
            return putObjectResult2;
        } catch (AmazonClientException e10) {
            fireProgressEvent(progressListener, 4);
            throw e10;
        } catch (Throwable th3) {
            try {
                inputStream2.close();
            } catch (Throwable e11) {
                log.warn("Unable to cleanly close input stream: " + e11.getMessage(), e11);
            }
        }
    }

    public PutObjectResult putObject(String str, String str2, File file) throws AmazonClientException, AmazonServiceException {
        return putObject(new PutObjectRequest(str, str2, file).withMetadata(new ObjectMetadata()));
    }

    public PutObjectResult putObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) throws AmazonClientException, AmazonServiceException {
        return putObject(new PutObjectRequest(str, str2, inputStream, objectMetadata));
    }

    public void setBucketAcl(SetBucketAclRequest setBucketAclRequest) throws AmazonClientException, AmazonServiceException {
        String bucketName = setBucketAclRequest.getBucketName();
        AccessControlList acl = setBucketAclRequest.getAcl();
        CannedAccessControlList cannedAcl = setBucketAclRequest.getCannedAcl();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when setting a bucket's ACL");
        if (acl != null) {
            setAcl(bucketName, null, null, acl, (AmazonWebServiceRequest) setBucketAclRequest);
        } else if (cannedAcl != null) {
            setAcl(bucketName, null, null, cannedAcl, (AmazonWebServiceRequest) setBucketAclRequest);
        } else {
            assertParameterNotNull(null, "The ACL parameter must be specified when setting a bucket's ACL");
        }
    }

    public void setBucketAcl(String str, AccessControlList accessControlList) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(str, "The bucket name parameter must be specified when setting a bucket's ACL");
        assertParameterNotNull(accessControlList, "The ACL parameter must be specified when setting a bucket's ACL");
        setAcl(str, null, null, accessControlList, null);
    }

    public void setBucketAcl(String str, CannedAccessControlList cannedAccessControlList) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(str, "The bucket name parameter must be specified when setting a bucket's ACL");
        assertParameterNotNull(cannedAccessControlList, "The ACL parameter must be specified when setting a bucket's ACL");
        setAcl(str, null, null, cannedAccessControlList, null);
    }

    public void setBucketCrossOriginConfiguration(String str, BucketCrossOriginConfiguration bucketCrossOriginConfiguration) {
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.PUT);
        createRequest.addParameter("cors", null);
        byte[] convertToXmlByteArray = new BucketConfigurationXmlFactory().convertToXmlByteArray(bucketCrossOriginConfiguration);
        createRequest.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(convertToXmlByteArray.length));
        createRequest.addHeader(HttpHeaders.CONTENT_TYPE, XmlHttpParser.CONTENT_TYPE);
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        try {
            createRequest.addHeader(HttpHeaders.CONTENT_MD5, BinaryUtils.toBase64(Md5Utils.computeMD5Hash(convertToXmlByteArray)));
            invoke(createRequest, this.voidResponseHandler, str, null);
        } catch (Throwable e) {
            throw new AmazonClientException("Couldn't compute md5 sum", e);
        }
    }

    public void setBucketLifecycleConfiguration(String str, BucketLifecycleConfiguration bucketLifecycleConfiguration) {
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.PUT);
        createRequest.addParameter("lifecycle", null);
        byte[] convertToXmlByteArray = new BucketConfigurationXmlFactory().convertToXmlByteArray(bucketLifecycleConfiguration);
        createRequest.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(convertToXmlByteArray.length));
        createRequest.addHeader(HttpHeaders.CONTENT_TYPE, XmlHttpParser.CONTENT_TYPE);
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        try {
            createRequest.addHeader(HttpHeaders.CONTENT_MD5, BinaryUtils.toBase64(Md5Utils.computeMD5Hash(convertToXmlByteArray)));
            invoke(createRequest, this.voidResponseHandler, str, null);
        } catch (Throwable e) {
            throw new AmazonClientException("Couldn't compute md5 sum", e);
        }
    }

    public void setBucketLoggingConfiguration(SetBucketLoggingConfigurationRequest setBucketLoggingConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(setBucketLoggingConfigurationRequest, "The set bucket logging configuration request object must be specified when enabling server access logging");
        String bucketName = setBucketLoggingConfigurationRequest.getBucketName();
        BucketLoggingConfiguration loggingConfiguration = setBucketLoggingConfigurationRequest.getLoggingConfiguration();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when enabling server access logging");
        assertParameterNotNull(bucketName, "The logging configuration parameter must be specified when enabling server access logging");
        Request createRequest = createRequest(bucketName, null, setBucketLoggingConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter("logging", null);
        createRequest.setContent(new ByteArrayInputStream(bucketConfigurationXmlFactory.convertToXmlByteArray(loggingConfiguration)));
        invoke(createRequest, this.voidResponseHandler, bucketName, null);
    }

    public void setBucketNotificationConfiguration(String str, BucketNotificationConfiguration bucketNotificationConfiguration) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(str, "The bucket name parameter must be specified when setting notification configuration");
        assertParameterNotNull(bucketNotificationConfiguration, "The bucket notification parameter must be specified when setting notification configuration");
        Request createRequest = createRequest(str, null, new SetBucketNotificationConfigurationRequest(bucketNotificationConfiguration, str), HttpMethodName.PUT);
        createRequest.addParameter("notification", null);
        createRequest.setContent(new ByteArrayInputStream(bucketConfigurationXmlFactory.convertToXmlByteArray(bucketNotificationConfiguration)));
        invoke(createRequest, this.voidResponseHandler, str, null);
    }

    public void setBucketPolicy(SetBucketPolicyRequest setBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(setBucketPolicyRequest, "The request object must be specified when setting a bucket policy");
        String bucketName = setBucketPolicyRequest.getBucketName();
        String policyText = setBucketPolicyRequest.getPolicyText();
        assertParameterNotNull(bucketName, "The bucket name must be specified when setting a bucket policy");
        assertParameterNotNull(policyText, "The policy text must be specified when setting a bucket policy");
        Request createRequest = createRequest(bucketName, null, setBucketPolicyRequest, HttpMethodName.PUT);
        createRequest.addParameter("policy", null);
        createRequest.setContent(new ByteArrayInputStream(ServiceUtils.toByteArray(policyText)));
        invoke(createRequest, this.voidResponseHandler, bucketName, null);
    }

    public void setBucketPolicy(String str, String str2) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(str, "The bucket name must be specified when setting a bucket policy");
        assertParameterNotNull(str2, "The policy text must be specified when setting a bucket policy");
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.PUT);
        createRequest.addParameter("policy", null);
        createRequest.setContent(new ByteArrayInputStream(ServiceUtils.toByteArray(str2)));
        invoke(createRequest, this.voidResponseHandler, str, null);
    }

    public void setBucketTaggingConfiguration(String str, BucketTaggingConfiguration bucketTaggingConfiguration) {
        Request createRequest = createRequest(str, null, new GenericBucketRequest(str), HttpMethodName.PUT);
        createRequest.addParameter("tagging", null);
        byte[] convertToXmlByteArray = new BucketConfigurationXmlFactory().convertToXmlByteArray(bucketTaggingConfiguration);
        createRequest.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(convertToXmlByteArray.length));
        createRequest.addHeader(HttpHeaders.CONTENT_TYPE, XmlHttpParser.CONTENT_TYPE);
        createRequest.setContent(new ByteArrayInputStream(convertToXmlByteArray));
        try {
            createRequest.addHeader(HttpHeaders.CONTENT_MD5, BinaryUtils.toBase64(Md5Utils.computeMD5Hash(convertToXmlByteArray)));
            invoke(createRequest, this.voidResponseHandler, str, null);
        } catch (Throwable e) {
            throw new AmazonClientException("Couldn't compute md5 sum", e);
        }
    }

    public void setBucketVersioningConfiguration(SetBucketVersioningConfigurationRequest setBucketVersioningConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(setBucketVersioningConfigurationRequest, "The SetBucketVersioningConfigurationRequest object must be specified when setting versioning configuration");
        String bucketName = setBucketVersioningConfigurationRequest.getBucketName();
        BucketVersioningConfiguration versioningConfiguration = setBucketVersioningConfigurationRequest.getVersioningConfiguration();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when setting versioning configuration");
        assertParameterNotNull(versioningConfiguration, "The bucket versioning parameter must be specified when setting versioning configuration");
        if (versioningConfiguration.isMfaDeleteEnabled() != null) {
            assertParameterNotNull(setBucketVersioningConfigurationRequest.getMfa(), "The MFA parameter must be specified when changing MFA Delete status in the versioning configuration");
        }
        Request createRequest = createRequest(bucketName, null, setBucketVersioningConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter("versioning", null);
        if (!(versioningConfiguration.isMfaDeleteEnabled() == null || setBucketVersioningConfigurationRequest.getMfa() == null)) {
            populateRequestWithMfaDetails(createRequest, setBucketVersioningConfigurationRequest.getMfa());
        }
        createRequest.setContent(new ByteArrayInputStream(bucketConfigurationXmlFactory.convertToXmlByteArray(versioningConfiguration)));
        invoke(createRequest, this.voidResponseHandler, bucketName, null);
    }

    public void setBucketWebsiteConfiguration(SetBucketWebsiteConfigurationRequest setBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException {
        String bucketName = setBucketWebsiteConfigurationRequest.getBucketName();
        BucketWebsiteConfiguration configuration = setBucketWebsiteConfigurationRequest.getConfiguration();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when setting a bucket's website configuration");
        assertParameterNotNull(configuration, "The bucket website configuration parameter must be specified when setting a bucket's website configuration");
        assertParameterNotNull(configuration.getIndexDocumentSuffix(), "The bucket website configuration parameter must specify the index document suffix when setting a bucket's website configuration");
        Request createRequest = createRequest(bucketName, null, setBucketWebsiteConfigurationRequest, HttpMethodName.PUT);
        createRequest.addParameter("website", null);
        createRequest.addHeader(HttpHeaders.CONTENT_TYPE, XmlHttpParser.CONTENT_TYPE);
        createRequest.setContent(new ByteArrayInputStream(bucketConfigurationXmlFactory.convertToXmlByteArray(configuration)));
        invoke(createRequest, this.voidResponseHandler, bucketName, null);
    }

    public void setBucketWebsiteConfiguration(String str, BucketWebsiteConfiguration bucketWebsiteConfiguration) throws AmazonClientException, AmazonServiceException {
        setBucketWebsiteConfiguration(new SetBucketWebsiteConfigurationRequest(str, bucketWebsiteConfiguration));
    }

    public void setObjectAcl(String str, String str2, AccessControlList accessControlList) throws AmazonClientException, AmazonServiceException {
        setObjectAcl(str, str2, null, accessControlList);
    }

    public void setObjectAcl(String str, String str2, CannedAccessControlList cannedAccessControlList) throws AmazonClientException, AmazonServiceException {
        setObjectAcl(str, str2, null, cannedAccessControlList);
    }

    public void setObjectAcl(String str, String str2, String str3, AccessControlList accessControlList) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(str, "The bucket name parameter must be specified when setting an object's ACL");
        assertParameterNotNull(str2, "The key parameter must be specified when setting an object's ACL");
        assertParameterNotNull(accessControlList, "The ACL parameter must be specified when setting an object's ACL");
        setAcl(str, str2, str3, accessControlList, null);
    }

    public void setObjectAcl(String str, String str2, String str3, CannedAccessControlList cannedAccessControlList) throws AmazonClientException, AmazonServiceException {
        assertParameterNotNull(str, "The bucket name parameter must be specified when setting an object's ACL");
        assertParameterNotNull(str2, "The key parameter must be specified when setting an object's ACL");
        assertParameterNotNull(cannedAccessControlList, "The ACL parameter must be specified when setting an object's ACL");
        setAcl(str, str2, str3, cannedAccessControlList, null);
    }

    public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws AmazonClientException, AmazonServiceException {
        InputStream inputStream;
        MD5DigestCalculatingInputStream mD5DigestCalculatingInputStream;
        ProgressListener progressListener;
        InputStream progressReportingInputStream;
        ObjectMetadata objectMetadata;
        assertParameterNotNull(uploadPartRequest, "The request parameter must be specified when uploading a part");
        String bucketName = uploadPartRequest.getBucketName();
        String key = uploadPartRequest.getKey();
        String uploadId = uploadPartRequest.getUploadId();
        int partNumber = uploadPartRequest.getPartNumber();
        long partSize = uploadPartRequest.getPartSize();
        assertParameterNotNull(bucketName, "The bucket name parameter must be specified when uploading a part");
        assertParameterNotNull(key, "The key parameter must be specified when uploading a part");
        assertParameterNotNull(uploadId, "The upload ID parameter must be specified when uploading a part");
        assertParameterNotNull(Integer.valueOf(partNumber), "The part number parameter must be specified when uploading a part");
        assertParameterNotNull(Long.valueOf(partSize), "The part size parameter must be specified when uploading a part");
        Request createRequest = createRequest(bucketName, key, uploadPartRequest, HttpMethodName.PUT);
        createRequest.addParameter("uploadId", uploadId);
        createRequest.addParameter("partNumber", Integer.toString(partNumber));
        if (uploadPartRequest.getMd5Digest() != null) {
            createRequest.addHeader(HttpHeaders.CONTENT_MD5, uploadPartRequest.getMd5Digest());
        }
        createRequest.addHeader(HttpHeaders.CONTENT_LENGTH, Long.toString(partSize));
        if (uploadPartRequest.getInputStream() != null) {
            inputStream = uploadPartRequest.getInputStream();
        } else if (uploadPartRequest.getFile() != null) {
            try {
                inputStream = new InputSubstream(new RepeatableFileInputStream(uploadPartRequest.getFile()), uploadPartRequest.getFileOffset(), partSize, true);
            } catch (Throwable e) {
                throw new IllegalArgumentException("The specified file doesn't exist", e);
            }
        } else {
            throw new IllegalArgumentException("A File or InputStream must be specified when uploading part");
        }
        if (uploadPartRequest.getMd5Digest() == null) {
            try {
                mD5DigestCalculatingInputStream = new MD5DigestCalculatingInputStream(inputStream);
                inputStream = mD5DigestCalculatingInputStream;
            } catch (Throwable e2) {
                log.warn("No MD5 digest algorithm available.  Unable to calculate checksum and verify data integrity.", e2);
            }
            progressListener = uploadPartRequest.getProgressListener();
            if (progressListener == null) {
                progressReportingInputStream = new ProgressReportingInputStream(inputStream, progressListener);
                fireProgressEvent(progressListener, ProgressEvent.PART_STARTED_EVENT_CODE);
            } else {
                progressReportingInputStream = inputStream;
            }
            createRequest.setContent(progressReportingInputStream);
            objectMetadata = (ObjectMetadata) invoke(createRequest, new S3MetadataResponseHandler(), bucketName, key);
            if (objectMetadata != null || r1 == null || Arrays.equals(BinaryUtils.fromBase64(BinaryUtils.toBase64(r1.getMd5Digest())), BinaryUtils.fromHex(objectMetadata.getETag()))) {
                fireProgressEvent(progressListener, ProgressEvent.PART_COMPLETED_EVENT_CODE);
                UploadPartResult uploadPartResult = new UploadPartResult();
                uploadPartResult.setETag(objectMetadata.getETag());
                uploadPartResult.setPartNumber(partNumber);
                uploadPartResult.setServerSideEncryption(objectMetadata.getServerSideEncryption());
                if (progressReportingInputStream != null) {
                    try {
                        progressReportingInputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return uploadPartResult;
            }
            fireProgressEvent(progressListener, 4);
            throw new AmazonClientException("Unable to verify integrity of data upload.  Client calculated content hash didn't match hash calculated by Amazon S3.  You may need to delete the data stored in Amazon S3.");
        }
        mD5DigestCalculatingInputStream = null;
        progressListener = uploadPartRequest.getProgressListener();
        if (progressListener == null) {
            progressReportingInputStream = inputStream;
        } else {
            progressReportingInputStream = new ProgressReportingInputStream(inputStream, progressListener);
            fireProgressEvent(progressListener, ProgressEvent.PART_STARTED_EVENT_CODE);
        }
        try {
            createRequest.setContent(progressReportingInputStream);
            objectMetadata = (ObjectMetadata) invoke(createRequest, new S3MetadataResponseHandler(), bucketName, key);
            if (objectMetadata != null) {
            }
            fireProgressEvent(progressListener, ProgressEvent.PART_COMPLETED_EVENT_CODE);
            UploadPartResult uploadPartResult2 = new UploadPartResult();
            uploadPartResult2.setETag(objectMetadata.getETag());
            uploadPartResult2.setPartNumber(partNumber);
            uploadPartResult2.setServerSideEncryption(objectMetadata.getServerSideEncryption());
            if (progressReportingInputStream != null) {
                progressReportingInputStream.close();
            }
            return uploadPartResult2;
        } catch (AmazonClientException e4) {
            fireProgressEvent(progressListener, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            throw e4;
        } catch (Throwable th) {
            if (progressReportingInputStream != null) {
                try {
                    progressReportingInputStream.close();
                } catch (Exception e5) {
                }
            }
        }
    }
}
