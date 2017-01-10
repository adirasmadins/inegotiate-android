package com.amazonaws.util;

import com.amazonaws.javax.xml.transform.OutputKeys;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.google.gdata.util.common.base.StringUtil;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class VersionInfoUtils {
    private static final String VERSION_INFO_FILE = "com/amazonaws/sdk/versionInfo.properties";
    private static Log log;
    private static String platform;
    private static String userAgent;
    private static String version;

    static {
        version = null;
        platform = null;
        userAgent = null;
        log = LogFactory.getLog(VersionInfoUtils.class);
    }

    public static String getPlatform() {
        if (platform == null) {
            initializeVersion();
        }
        return platform;
    }

    public static String getUserAgent() {
        if (userAgent == null) {
            initializeUserAgent();
        }
        return userAgent;
    }

    public static String getVersion() {
        if (version == null) {
            initializeVersion();
        }
        return version;
    }

    private static void initializeUserAgent() {
        StringBuilder stringBuilder = new StringBuilder(ProgressEvent.PART_STARTED_EVENT_CODE);
        stringBuilder.append("aws-sdk-" + getPlatform().toLowerCase() + "/");
        stringBuilder.append(getVersion());
        stringBuilder.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        stringBuilder.append(System.getProperty("os.name").replace(' ', '_') + "/" + System.getProperty("os.version").replace(' ', '_'));
        stringBuilder.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        stringBuilder.append(System.getProperty("java.vm.name").replace(' ', '_') + "/" + System.getProperty("java.vm.version").replace(' ', '_'));
        String str = StringUtil.EMPTY_STRING;
        try {
            str = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + System.getProperty("user.language").replace(' ', '_') + "_" + System.getProperty("user.region").replace(' ', '_');
        } catch (Exception e) {
        }
        stringBuilder.append(str);
        userAgent = stringBuilder.toString();
    }

    private static void initializeVersion() {
        InputStream resourceAsStream = VersionInfoUtils.class.getClassLoader().getResourceAsStream(VERSION_INFO_FILE);
        Properties properties = new Properties();
        if (resourceAsStream == null) {
            try {
                throw new Exception("com/amazonaws/sdk/versionInfo.properties not found on classpath");
            } catch (Exception e) {
                log.info("Unable to load version information for the running SDK: " + e.getMessage());
                version = "unknown-version";
                platform = "java";
                return;
            }
        }
        properties.load(resourceAsStream);
        version = properties.getProperty(OutputKeys.VERSION);
        platform = properties.getProperty("platform");
    }
}
