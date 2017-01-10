package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.Md5Utils;
import com.google.gdata.util.common.base.StringUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServiceUtils {
    protected static final DateUtils dateUtils;
    private static final Log log;

    static {
        log = LogFactory.getLog(ServiceUtils.class);
        dateUtils = new DateUtils();
    }

    public static URL convertRequestToUrl(Request<?> request) {
        String str = request.getEndpoint() + "/" + request.getResourcePath();
        String str2 = str;
        Object obj = 1;
        for (String str3 : request.getParameters().keySet()) {
            Object obj2;
            String str4;
            if (obj != null) {
                obj2 = null;
                str4 = str2 + "?";
            } else {
                str4 = str2 + "&";
                obj2 = obj;
            }
            obj = obj2;
            str2 = str4 + str3 + "=" + urlEncode((String) request.getParameters().get(str3));
        }
        try {
            return new URL(str2);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to convert request to well formed URL: " + e.getMessage(), e);
        }
    }

    public static void downloadObjectToFile(S3Object s3Object, File file, boolean z) {
        byte[] bArr;
        Throwable th;
        Throwable th2;
        Throwable e;
        byte[] bArr2 = null;
        File parentFile = file.getParentFile();
        if (!(parentFile == null || parentFile.exists())) {
            parentFile.mkdirs();
        }
        OutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr3 = new byte[10240];
                while (true) {
                    int read = s3Object.getObjectContent().read(bArr3);
                    if (read > -1) {
                        bufferedOutputStream.write(bArr3, 0, read);
                    } else {
                        try {
                            break;
                        } catch (Exception e2) {
                        }
                    }
                }
                bufferedOutputStream.close();
                try {
                    s3Object.getObjectContent().close();
                } catch (Exception e3) {
                }
                try {
                    if (isMultipartUploadETag(s3Object.getObjectMetadata().getETag())) {
                        bArr = bArr2;
                    } else {
                        bArr = Md5Utils.computeMD5Hash(new FileInputStream(file));
                        try {
                            bArr2 = BinaryUtils.fromHex(s3Object.getObjectMetadata().getETag());
                        } catch (Throwable e4) {
                            th = e4;
                            bArr3 = bArr;
                            th2 = th;
                            log.warn("Unable to calculate MD5 hash to validate download: " + th2.getMessage(), th2);
                            bArr = bArr3;
                            if (z) {
                                return;
                            }
                            return;
                        }
                    }
                } catch (Exception e5) {
                    th2 = e5;
                    bArr3 = bArr2;
                    log.warn("Unable to calculate MD5 hash to validate download: " + th2.getMessage(), th2);
                    bArr = bArr3;
                    if (z) {
                        return;
                    }
                    return;
                }
                if (z && r1 != null && r0 != null && !Arrays.equals(r1, r0)) {
                    throw new AmazonClientException("Unable to verify integrity of data download.  Client calculated content hash didn't match hash calculated by Amazon S3.  The data stored in '" + file.getAbsolutePath() + "' may be corrupt.");
                }
            } catch (IOException e6) {
                e = e6;
                try {
                    s3Object.getObjectContent().abort();
                } catch (IOException e7) {
                    log.warn("Couldn't abort stream", e);
                } catch (Throwable th3) {
                    e = th3;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e8) {
                    }
                    try {
                        s3Object.getObjectContent().close();
                    } catch (Exception e9) {
                    }
                    throw e;
                }
                throw new AmazonClientException("Unable to store object contents to disk: " + e.getMessage(), e);
            }
        } catch (Throwable th22) {
            th = th22;
            bufferedOutputStream = bArr2;
            e = th;
            s3Object.getObjectContent().abort();
            throw new AmazonClientException("Unable to store object contents to disk: " + e.getMessage(), e);
        } catch (Throwable th222) {
            th = th222;
            bufferedOutputStream = bArr2;
            e = th;
            bufferedOutputStream.close();
            s3Object.getObjectContent().close();
            throw e;
        }
    }

    public static String formatIso8601Date(Date date) {
        return dateUtils.formatIso8601Date(date);
    }

    public static String formatRfc822Date(Date date) {
        return dateUtils.formatRfc822Date(date);
    }

    public static boolean isMultipartUploadETag(String str) {
        return str.contains("-");
    }

    public static String join(List<String> list) {
        String str = StringUtil.EMPTY_STRING;
        Object obj = 1;
        for (String str2 : list) {
            if (obj == null) {
                str = str + ", ";
            }
            str = str + str2;
            obj = null;
        }
        return str;
    }

    public static Date parseIso8601Date(String str) throws ParseException {
        return dateUtils.parseIso8601Date(str);
    }

    public static Date parseRfc822Date(String str) throws ParseException {
        return dateUtils.parseRfc822Date(str);
    }

    public static String removeQuotes(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("\"")) {
            trim = trim.substring(1);
        }
        return trim.endsWith("\"") ? trim.substring(0, trim.length() - 1) : trim;
    }

    public static byte[] toByteArray(String str) {
        try {
            return str.getBytes(Constants.DEFAULT_ENCODING);
        } catch (Throwable e) {
            log.warn("Encoding " + Constants.DEFAULT_ENCODING + " is not supported", e);
            return str.getBytes();
        }
    }

    public static String urlEncode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, Constants.DEFAULT_ENCODING).replaceAll("\\+", "%20");
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to encode path: " + str, e);
        }
    }
}
