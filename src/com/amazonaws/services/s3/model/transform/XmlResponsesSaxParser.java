package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.javax.xml.stream.xerces.impl.io.UCSReader;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration.Rule;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazonaws.services.s3.model.BucketNotificationConfiguration.TopicConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CORSRule;
import com.amazonaws.services.s3.model.CORSRule.AllowedMethods;
import com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.DeleteObjectsResult.DeletedObject;
import com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.MultiObjectDeleteException.DeleteError;
import com.amazonaws.services.s3.model.MultipartUpload;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.PartSummary;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.TagSet;
import com.amazonaws.services.s3.model.VersionListing;
import com.google.common.net.HttpHeaders;
import com.google.gdata.client.GDataProtocol.Header;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class XmlResponsesSaxParser {
    private static final Log log;
    private boolean sanitizeXmlDocument;
    private XMLReader xr;

    public class AccessControlListHandler extends DefaultHandler {
        private AccessControlList accessControlList;
        private StringBuilder currText;
        private Grantee currentGrantee;
        private Permission currentPermission;
        private boolean insideACL;
        private Owner owner;

        public AccessControlListHandler() {
            this.accessControlList = null;
            this.owner = null;
            this.currentGrantee = null;
            this.currentPermission = null;
            this.currText = null;
            this.insideACL = false;
            this.currText = new StringBuilder();
        }

        public void characters(char[] cArr, int i, int i2) {
            this.currText.append(cArr, i, i2);
        }

        public void endDocument() {
        }

        public void endElement(String str, String str2, String str3) {
            String stringBuilder = this.currText.toString();
            if (str2.equals("ID") && !this.insideACL) {
                this.owner.setId(stringBuilder);
            } else if (str2.equals("DisplayName") && !this.insideACL) {
                this.owner.setDisplayName(stringBuilder);
            } else if (str2.equals("ID")) {
                this.currentGrantee.setIdentifier(stringBuilder);
            } else if (str2.equals("EmailAddress")) {
                this.currentGrantee.setIdentifier(stringBuilder);
            } else if (str2.equals("URI")) {
                this.currentGrantee = GroupGrantee.parseGroupGrantee(stringBuilder);
            } else if (str2.equals("DisplayName")) {
                ((CanonicalGrantee) this.currentGrantee).setDisplayName(stringBuilder);
            } else if (str2.equals("Permission")) {
                this.currentPermission = Permission.parsePermission(stringBuilder);
            } else if (str2.equals("Grant")) {
                this.accessControlList.grantPermission(this.currentGrantee, this.currentPermission);
                this.currentGrantee = null;
                this.currentPermission = null;
            } else if (str2.equals("AccessControlList")) {
                this.insideACL = false;
            }
            this.currText = new StringBuilder();
        }

        public AccessControlList getAccessControlList() {
            return this.accessControlList;
        }

        public void startDocument() {
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("Owner")) {
                this.owner = new Owner();
            } else if (str2.equals("AccessControlList")) {
                this.accessControlList = new AccessControlList();
                this.accessControlList.setOwner(this.owner);
                this.insideACL = true;
            } else if (str2.equals("Grantee")) {
                String access$400 = XmlResponsesSaxParser.findAttributeValue("xsi:type", attributes);
                if ("AmazonCustomerByEmail".equals(access$400)) {
                    this.currentGrantee = new EmailAddressGrantee(null);
                } else if ("CanonicalUser".equals(access$400)) {
                    this.currentGrantee = new CanonicalGrantee(null);
                } else if (!"Group".equals(access$400)) {
                }
            }
        }
    }

    public class BucketCrossOriginConfigurationHandler extends DefaultHandler {
        private List<String> allowedHeaders;
        private List<AllowedMethods> allowedMethods;
        private List<String> allowedOrigins;
        private List<String> exposedHeaders;
        private CORSRule rule;
        private List<CORSRule> rules;
        private StringBuilder text;

        public BucketCrossOriginConfigurationHandler() {
            this.rules = new LinkedList();
            this.allowedMethods = null;
            this.allowedOrigins = null;
            this.exposedHeaders = null;
            this.allowedHeaders = null;
        }

        public void characters(char[] cArr, int i, int i2) {
            this.text.append(cArr, i, i2);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (!str2.equals("CORSConfiguration")) {
                if (str2.equals("CORSRule")) {
                    this.rule.setAllowedHeaders(this.allowedHeaders);
                    this.rule.setAllowedMethods(this.allowedMethods);
                    this.rule.setAllowedOrigins(this.allowedOrigins);
                    this.rule.setExposedHeaders(this.exposedHeaders);
                    this.allowedHeaders = null;
                    this.allowedMethods = null;
                    this.allowedOrigins = null;
                    this.exposedHeaders = null;
                    this.rules.add(this.rule);
                    this.rule = null;
                } else if (str2.equals("ID")) {
                    this.rule.setId(this.text.toString());
                } else if (str2.equals("AllowedOrigin")) {
                    this.allowedOrigins.add(this.text.toString());
                } else if (str2.equals("AllowedMethod")) {
                    this.allowedMethods.add(AllowedMethods.fromValue(this.text.toString()));
                } else if (str2.equals("MaxAgeSeconds")) {
                    this.rule.setMaxAgeSeconds(Integer.parseInt(this.text.toString()));
                } else if (str2.equals("ExposeHeader")) {
                    this.exposedHeaders.add(this.text.toString());
                } else if (str2.equals("AllowedHeader")) {
                    this.allowedHeaders.add(this.text.toString());
                } else {
                    XmlResponsesSaxParser.log.warn("Unexpected tag: " + str2);
                }
            }
        }

        public BucketCrossOriginConfiguration getConfiguration() {
            return new BucketCrossOriginConfiguration(this.rules);
        }

        public void startDocument() {
            this.text = new StringBuilder();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (!str2.equals("CORSConfiguration")) {
                if (str2.equals("CORSRule")) {
                    this.rule = new CORSRule();
                } else if (!str2.equals("ID")) {
                    if (str2.equals("AllowedOrigin")) {
                        if (this.allowedOrigins == null) {
                            this.allowedOrigins = new LinkedList();
                        }
                    } else if (str2.equals("AllowedMethod")) {
                        if (this.allowedMethods == null) {
                            this.allowedMethods = new LinkedList();
                        }
                    } else if (!str2.equals("MaxAgeSeconds")) {
                        if (str2.equals("ExposeHeader")) {
                            if (this.exposedHeaders == null) {
                                this.exposedHeaders = new LinkedList();
                            }
                        } else if (!str2.equals("AllowedHeader")) {
                            XmlResponsesSaxParser.log.warn("Unexpected tag: " + str2);
                        } else if (this.allowedHeaders == null) {
                            this.allowedHeaders = new LinkedList();
                        }
                    }
                }
            }
            this.text.setLength(0);
        }
    }

    public class BucketLifecycleConfigurationHandler extends DefaultHandler {
        private Rule rule;
        private List<Rule> rules;
        private StringBuilder text;

        public BucketLifecycleConfigurationHandler() {
            this.rules = new LinkedList();
        }

        public void characters(char[] cArr, int i, int i2) {
            this.text.append(cArr, i, i2);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (!str2.equals("LifecycleConfiguration")) {
                if (str2.equals("Rule")) {
                    this.rules.add(this.rule);
                    this.rule = null;
                } else if (str2.equals("ID")) {
                    this.rule.setId(this.text.toString());
                } else if (str2.equals("Prefix")) {
                    this.rule.setPrefix(this.text.toString());
                } else if (str2.equals("Status")) {
                    this.rule.setStatus(this.text.toString());
                } else if (!str2.equals("Expiration")) {
                    if (str2.equals("Days")) {
                        this.rule.setExpirationInDays(Integer.parseInt(this.text.toString()));
                    } else {
                        XmlResponsesSaxParser.log.warn("Unexpected tag: " + str2);
                    }
                }
            }
        }

        public BucketLifecycleConfiguration getConfiguration() {
            return new BucketLifecycleConfiguration(this.rules);
        }

        public void startDocument() {
            this.text = new StringBuilder();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (!str2.equals("LifecycleConfiguration")) {
                if (str2.equals("Rule")) {
                    this.rule = new Rule();
                } else if (!(str2.equals("ID") || str2.equals("Prefix") || str2.equals("Status") || str2.equals("Expiration") || str2.equals("Days"))) {
                    XmlResponsesSaxParser.log.warn("Unexpected tag: " + str2);
                }
            }
            this.text.setLength(0);
        }
    }

    public class BucketLocationHandler extends DefaultHandler {
        private StringBuilder currText;
        private String location;

        public BucketLocationHandler() {
            this.location = null;
            this.currText = null;
            this.currText = new StringBuilder();
        }

        public void characters(char[] cArr, int i, int i2) {
            this.currText.append(cArr, i, i2);
        }

        public void endDocument() {
        }

        public void endElement(String str, String str2, String str3) {
            String stringBuilder = this.currText.toString();
            if (str2.equals("LocationConstraint")) {
                if (stringBuilder.length() == 0) {
                    this.location = null;
                } else {
                    this.location = stringBuilder;
                }
            }
            this.currText = new StringBuilder();
        }

        public String getLocation() {
            return this.location;
        }

        public void startDocument() {
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (!str2.equals("CreateBucketConfiguration")) {
            }
        }
    }

    public class BucketLoggingConfigurationHandler extends DefaultHandler {
        private BucketLoggingConfiguration bucketLoggingConfiguration;
        private StringBuilder currText;
        private String targetBucket;
        private String targetPrefix;

        public BucketLoggingConfigurationHandler() {
            this.bucketLoggingConfiguration = null;
            this.targetBucket = null;
            this.targetPrefix = null;
            this.currText = null;
            this.currText = new StringBuilder();
        }

        public void characters(char[] cArr, int i, int i2) {
            this.currText.append(cArr, i, i2);
        }

        public void endDocument() {
        }

        public void endElement(String str, String str2, String str3) {
            String stringBuilder = this.currText.toString();
            if (str2.equals("TargetBucket")) {
                this.targetBucket = stringBuilder;
            } else if (str2.equals("TargetPrefix")) {
                this.targetPrefix = stringBuilder;
            } else if (str2.equals("LoggingEnabled")) {
                this.bucketLoggingConfiguration.setDestinationBucketName(this.targetBucket);
                this.bucketLoggingConfiguration.setLogFilePrefix(this.targetPrefix);
            }
            this.currText = new StringBuilder();
        }

        public BucketLoggingConfiguration getBucketLoggingConfiguration() {
            return this.bucketLoggingConfiguration;
        }

        public void startDocument() {
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("BucketLoggingStatus")) {
                this.bucketLoggingConfiguration = new BucketLoggingConfiguration();
            }
        }
    }

    public class BucketNotificationConfigurationHandler extends DefaultHandler {
        private BucketNotificationConfiguration configuration;
        private String event;
        private StringBuilder text;
        private String topic;
        private List<TopicConfiguration> topicConfigurations;

        public BucketNotificationConfigurationHandler() {
            this.configuration = new BucketNotificationConfiguration();
        }

        public void characters(char[] cArr, int i, int i2) {
            this.text.append(cArr, i, i2);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (str2.equals("Topic")) {
                this.topic = this.text.toString();
            } else if (str2.equals("Event")) {
                this.event = this.text.toString();
            } else if (str2.equals("TopicConfiguration")) {
                if (!(this.topic == null || this.event == null)) {
                    this.topicConfigurations.add(new TopicConfiguration(this.topic, this.event));
                }
            } else if (str2.equals("NotificationConfiguration")) {
                this.configuration.setTopicConfigurations(this.topicConfigurations);
            }
            this.text.setLength(0);
        }

        public BucketNotificationConfiguration getConfiguration() {
            return this.configuration;
        }

        public void startDocument() {
            this.text = new StringBuilder();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("NotificationConfiguration")) {
                this.topicConfigurations = new ArrayList(1);
            } else if (str2.equals("TopicConfiguration")) {
                this.topic = null;
                this.event = null;
            } else if (str2.equals("Topic")) {
                this.text.setLength(0);
            } else if (str2.equals("Event")) {
                this.text.setLength(0);
            } else {
                XmlResponsesSaxParser.log.warn("Ignoring unexpected tag <" + str2 + ">");
            }
        }
    }

    public class BucketTaggingConfigurationHandler extends DefaultHandler {
        private BucketTaggingConfiguration configuration;
        private String tagKey;
        private List<TagSet> tagSets;
        private String tagValue;
        private Map<String, String> tags;
        private StringBuilder text;

        public BucketTaggingConfigurationHandler() {
            this.configuration = new BucketTaggingConfiguration();
        }

        public void characters(char[] cArr, int i, int i2) {
            this.text.append(cArr, i, i2);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (str2.equals("Key")) {
                this.tagKey = this.text.toString();
            } else if (str2.equals("Value")) {
                this.tagValue = this.text.toString();
            } else if (str2.equals("Tag")) {
                if (!(this.tagKey == null || this.tagValue == null)) {
                    this.tags.put(this.tagKey, this.tagValue);
                }
            } else if (str2.equals("TagSet")) {
                this.tagSets.add(new TagSet(this.tags));
            } else if (str2.equals("Tagging")) {
                this.configuration.setTagSets(this.tagSets);
            }
            this.text.setLength(0);
        }

        public BucketTaggingConfiguration getConfiguration() {
            return this.configuration;
        }

        public void startDocument() {
            this.text = new StringBuilder();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("Tagging")) {
                this.tagSets = new ArrayList(1);
            } else if (str2.equals("TagSet")) {
                this.tags = new HashMap(1);
            } else if (str2.equals("Tag")) {
                this.tagKey = null;
                this.tagValue = null;
            } else if (str2.equals("Key")) {
                this.text.setLength(0);
            } else if (str2.equals("Value")) {
                this.text.setLength(0);
            } else {
                XmlResponsesSaxParser.log.warn("Ignoring unexpected tag <" + str2 + ">");
            }
        }
    }

    public class BucketVersioningConfigurationHandler extends DefaultHandler {
        private BucketVersioningConfiguration configuration;
        private StringBuilder text;

        public BucketVersioningConfigurationHandler() {
            this.configuration = new BucketVersioningConfiguration();
        }

        public void characters(char[] cArr, int i, int i2) {
            this.text.append(cArr, i, i2);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (str2.equals("Status")) {
                this.configuration.setStatus(this.text.toString());
            } else if (str2.equals("MfaDelete")) {
                String stringBuilder = this.text.toString();
                if (stringBuilder.equals(BucketLifecycleConfiguration.DISABLED)) {
                    this.configuration.setMfaDeleteEnabled(Boolean.valueOf(false));
                } else if (stringBuilder.equals(BucketVersioningConfiguration.ENABLED)) {
                    this.configuration.setMfaDeleteEnabled(Boolean.valueOf(true));
                } else {
                    this.configuration.setMfaDeleteEnabled(null);
                }
            }
            this.text.setLength(0);
        }

        public BucketVersioningConfiguration getConfiguration() {
            return this.configuration;
        }

        public void startDocument() {
            this.text = new StringBuilder();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (!str2.equals("VersioningConfiguration")) {
                if (str2.equals("Status")) {
                    this.text.setLength(0);
                } else if (str2.equals("MfaDelete")) {
                    this.text.setLength(0);
                } else {
                    XmlResponsesSaxParser.log.warn("Ignoring unexpected tag <" + str2 + ">");
                }
            }
        }
    }

    public class BucketWebsiteConfigurationHandler extends DefaultHandler {
        private BucketWebsiteConfiguration configuration;
        boolean inErrorDocumentElement;
        boolean inIndexDocumentElement;
        private StringBuilder text;

        public BucketWebsiteConfigurationHandler() {
            this.configuration = new BucketWebsiteConfiguration(null);
            this.inIndexDocumentElement = false;
            this.inErrorDocumentElement = false;
        }

        public void characters(char[] cArr, int i, int i2) {
            this.text.append(cArr, i, i2);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (!str2.equals("WebsiteConfiguration")) {
                if (str2.equals("IndexDocument")) {
                    this.inIndexDocumentElement = false;
                } else if (str2.equals("Suffix") && this.inIndexDocumentElement) {
                    this.configuration.setIndexDocumentSuffix(this.text.toString());
                } else if (str2.equals("ErrorDocument")) {
                    this.inErrorDocumentElement = false;
                } else if (str2.equals("Key") && this.inErrorDocumentElement) {
                    this.configuration.setErrorDocument(this.text.toString());
                }
            }
            this.text.setLength(0);
        }

        public BucketWebsiteConfiguration getConfiguration() {
            return this.configuration;
        }

        public void startDocument() {
            this.text = new StringBuilder();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (!str2.equals("WebsiteConfiguration")) {
                if (str2.equals("IndexDocument")) {
                    this.inIndexDocumentElement = true;
                } else if (!str2.equals("Suffix") || !this.inIndexDocumentElement) {
                    if (str2.equals("ErrorDocument")) {
                        this.inErrorDocumentElement = true;
                    } else if (!str2.equals("Key") || !this.inErrorDocumentElement) {
                        XmlResponsesSaxParser.log.warn("Ignoring unexpected tag <" + str2 + ">");
                    }
                }
            }
        }
    }

    public class CompleteMultipartUploadHandler extends DefaultHandler implements ServerSideEncryptionResult, ObjectExpirationResult {
        private AmazonS3Exception ase;
        private String errorCode;
        private String hostId;
        private String requestId;
        private CompleteMultipartUploadResult result;
        private StringBuilder text;

        public void characters(char[] cArr, int i, int i2) {
            this.text.append(cArr, i, i2);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (this.result != null) {
                if (!str2.equals("CompleteMultipartUploadResult")) {
                    if (str2.equals(HttpHeaders.LOCATION)) {
                        this.result.setLocation(this.text.toString());
                    } else if (str2.equals("Bucket")) {
                        this.result.setBucketName(this.text.toString());
                    } else if (str2.equals("Key")) {
                        this.result.setKey(this.text.toString());
                    } else if (str2.equals(Header.ETAG)) {
                        this.result.setETag(ServiceUtils.removeQuotes(this.text.toString()));
                    }
                }
            } else if (str2.equals("Error")) {
                this.ase.setErrorCode(this.errorCode);
                this.ase.setRequestId(this.requestId);
                this.ase.setExtendedRequestId(this.hostId);
            } else if (str2.equals("Code")) {
                this.errorCode = this.text.toString();
            } else if (str2.equals("Message")) {
                this.ase = new AmazonS3Exception(this.text.toString());
            } else if (str2.equals("RequestId")) {
                this.requestId = this.text.toString();
            } else if (str2.equals("HostId")) {
                this.hostId = this.text.toString();
            }
        }

        public AmazonS3Exception getAmazonS3Exception() {
            return this.ase;
        }

        public CompleteMultipartUploadResult getCompleteMultipartUploadResult() {
            return this.result;
        }

        public Date getExpirationTime() {
            return this.result != null ? this.result.getExpirationTime() : null;
        }

        public String getExpirationTimeRuleId() {
            return this.result != null ? this.result.getExpirationTimeRuleId() : null;
        }

        public String getServerSideEncryption() {
            return this.result != null ? this.result.getServerSideEncryption() : null;
        }

        public void setExpirationTime(Date date) {
            if (this.result != null) {
                this.result.setExpirationTime(date);
            }
        }

        public void setExpirationTimeRuleId(String str) {
            if (this.result != null) {
                this.result.setExpirationTimeRuleId(str);
            }
        }

        public void setServerSideEncryption(String str) {
            if (this.result != null) {
                this.result.setServerSideEncryption(str);
            }
        }

        public void startDocument() {
            this.text = new StringBuilder();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("CompleteMultipartUploadResult")) {
                this.result = new CompleteMultipartUploadResult();
            } else if (!(str2.equals(HttpHeaders.LOCATION) || str2.equals("Bucket") || str2.equals("Key") || !str2.equals(Header.ETAG))) {
            }
            if (!(str2.equals("Error") || str2.equals("Code") || str2.equals("Message") || str2.equals("RequestId") || !str2.equals("HostId"))) {
            }
            this.text.setLength(0);
        }
    }

    public class CopyObjectResultHandler extends DefaultHandler implements ServerSideEncryptionResult, ObjectExpirationResult {
        private StringBuilder currText;
        private String errorCode;
        private String errorHostId;
        private String errorMessage;
        private String errorRequestId;
        private String etag;
        private Date expirationTime;
        private String expirationTimeRuleId;
        private Date lastModified;
        private boolean receivedErrorResponse;
        private String serverSideEncryption;
        private String versionId;

        public CopyObjectResultHandler() {
            this.etag = null;
            this.lastModified = null;
            this.versionId = null;
            this.errorCode = null;
            this.errorMessage = null;
            this.errorRequestId = null;
            this.errorHostId = null;
            this.receivedErrorResponse = false;
            this.currText = null;
            this.currText = new StringBuilder();
        }

        public void characters(char[] cArr, int i, int i2) {
            this.currText.append(cArr, i, i2);
        }

        public void endDocument() {
        }

        public void endElement(String str, String str2, String str3) {
            String stringBuilder = this.currText.toString();
            if (str2.equals("LastModified")) {
                try {
                    this.lastModified = ServiceUtils.parseIso8601Date(stringBuilder);
                } catch (Throwable e) {
                    throw new RuntimeException("Non-ISO8601 date for LastModified in copy object output: " + stringBuilder, e);
                }
            } else if (str2.equals(Header.ETAG)) {
                this.etag = ServiceUtils.removeQuotes(stringBuilder);
            } else if (str2.equals("Code")) {
                this.errorCode = stringBuilder;
            } else if (str2.equals("Message")) {
                this.errorMessage = stringBuilder;
            } else if (str2.equals("RequestId")) {
                this.errorRequestId = stringBuilder;
            } else if (str2.equals("HostId")) {
                this.errorHostId = stringBuilder;
            }
            this.currText = new StringBuilder();
        }

        public String getETag() {
            return this.etag;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getErrorHostId() {
            return this.errorHostId;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }

        public String getErrorRequestId() {
            return this.errorRequestId;
        }

        public Date getExpirationTime() {
            return this.expirationTime;
        }

        public String getExpirationTimeRuleId() {
            return this.expirationTimeRuleId;
        }

        public Date getLastModified() {
            return this.lastModified;
        }

        public String getServerSideEncryption() {
            return this.serverSideEncryption;
        }

        public String getVersionId() {
            return this.versionId;
        }

        public boolean isErrorResponse() {
            return this.receivedErrorResponse;
        }

        public void setExpirationTime(Date date) {
            this.expirationTime = date;
        }

        public void setExpirationTimeRuleId(String str) {
            this.expirationTimeRuleId = str;
        }

        public void setServerSideEncryption(String str) {
            this.serverSideEncryption = str;
        }

        public void setVersionId(String str) {
            this.versionId = str;
        }

        public void startDocument() {
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("CopyObjectResult")) {
                this.receivedErrorResponse = false;
            } else if (str2.equals("Error")) {
                this.receivedErrorResponse = true;
            }
        }
    }

    public class DeleteObjectsHandler extends DefaultHandler {
        private List<DeleteError> deleteErrors;
        private DeletedObject deletedObject;
        private List<DeletedObject> deletedObjects;
        private DeleteError error;
        private StringBuilder text;

        public DeleteObjectsHandler() {
            this.deletedObject = null;
            this.error = null;
            this.deletedObjects = new LinkedList();
            this.deleteErrors = new LinkedList();
        }

        public void characters(char[] cArr, int i, int i2) {
            this.text.append(cArr, i, i2);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (str2.equals("Deleted")) {
                this.deletedObjects.add(this.deletedObject);
                this.deletedObject = null;
            } else if (str2.equals("Error")) {
                this.deleteErrors.add(this.error);
                this.error = null;
            } else if (str2.equals("Key")) {
                if (this.deletedObject != null) {
                    this.deletedObject.setKey(this.text.toString());
                } else if (this.error != null) {
                    this.error.setKey(this.text.toString());
                }
            } else if (str2.equals("VersionId")) {
                if (this.deletedObject != null) {
                    this.deletedObject.setVersionId(this.text.toString());
                } else if (this.error != null) {
                    this.error.setVersionId(this.text.toString());
                }
            } else if (str2.equals("Code")) {
                if (this.error != null) {
                    this.error.setCode(this.text.toString());
                }
            } else if (str2.equals("Message")) {
                if (this.error != null) {
                    this.error.setMessage(this.text.toString());
                }
            } else if (str2.equals("DeleteMarker")) {
                if (this.deletedObject != null) {
                    this.deletedObject.setDeleteMarker(this.text.toString().equals("true"));
                }
            } else if (str2.equals("DeleteMarkerVersionId") && this.deletedObject != null) {
                this.deletedObject.setDeleteMarkerVersionId(this.text.toString());
            }
        }

        public DeleteObjectsResponse getDeleteObjectResult() {
            return new DeleteObjectsResponse(this.deletedObjects, this.deleteErrors);
        }

        public void startDocument() {
            this.text = new StringBuilder();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("Deleted")) {
                this.deletedObject = new DeletedObject();
            } else if (str2.equals("Error")) {
                this.error = new DeleteError();
            } else if (!(str2.equals("Key") || str2.equals("VersionId") || str2.equals("Code") || str2.equals("Message") || str2.equals("DeleteMarker") || str2.equals("DeleteMarkerVersionId") || str2.equals("DeleteResult"))) {
                XmlResponsesSaxParser.log.warn("Unexpected tag: " + str2);
            }
            this.text.setLength(0);
        }
    }

    public class InitiateMultipartUploadHandler extends DefaultHandler {
        private InitiateMultipartUploadResult result;
        private StringBuilder text;

        public void characters(char[] cArr, int i, int i2) {
            this.text.append(cArr, i, i2);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (!str2.equals("InitiateMultipartUploadResult")) {
                if (str2.equals("Bucket")) {
                    this.result.setBucketName(this.text.toString());
                } else if (str2.equals("Key")) {
                    this.result.setKey(this.text.toString());
                } else if (str2.equals("UploadId")) {
                    this.result.setUploadId(this.text.toString());
                }
            }
        }

        public InitiateMultipartUploadResult getInitiateMultipartUploadResult() {
            return this.result;
        }

        public void startDocument() {
            this.text = new StringBuilder();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("InitiateMultipartUploadResult")) {
                this.result = new InitiateMultipartUploadResult();
            } else if (!(str2.equals("Bucket") || str2.equals("Key") || !str2.equals("UploadId"))) {
            }
            this.text.setLength(0);
        }
    }

    public class ListAllMyBucketsHandler extends DefaultHandler {
        private List<Bucket> buckets;
        private Owner bucketsOwner;
        private StringBuilder currText;
        private Bucket currentBucket;

        public ListAllMyBucketsHandler() {
            this.bucketsOwner = null;
            this.currentBucket = null;
            this.currText = null;
            this.buckets = null;
            this.buckets = new ArrayList();
            this.currText = new StringBuilder();
        }

        public void characters(char[] cArr, int i, int i2) {
            this.currText.append(cArr, i, i2);
        }

        public void endDocument() {
        }

        public void endElement(String str, String str2, String str3) {
            String stringBuilder = this.currText.toString();
            if (str2.equals("ID")) {
                this.bucketsOwner.setId(stringBuilder);
            } else if (str2.equals("DisplayName")) {
                this.bucketsOwner.setDisplayName(stringBuilder);
            } else if (str2.equals("Bucket")) {
                this.currentBucket.setOwner(this.bucketsOwner);
                this.buckets.add(this.currentBucket);
            } else if (str2.equals("Name")) {
                this.currentBucket.setName(stringBuilder);
            } else if (str2.equals("CreationDate")) {
                String str4 = stringBuilder + ".000Z";
                try {
                    this.currentBucket.setCreationDate(ServiceUtils.parseIso8601Date(str4));
                } catch (Throwable e) {
                    throw new RuntimeException("Non-ISO8601 date for CreationDate in list buckets output: " + str4, e);
                }
            }
            this.currText = new StringBuilder();
        }

        public List<Bucket> getBuckets() {
            return this.buckets;
        }

        public Owner getOwner() {
            return this.bucketsOwner;
        }

        public void startDocument() {
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("Bucket")) {
                this.currentBucket = new Bucket();
            } else if (str2.equals("Owner")) {
                this.bucketsOwner = new Owner();
            }
        }
    }

    public class ListBucketHandler extends DefaultHandler {
        private String bucketName;
        private List<String> commonPrefixes;
        private StringBuilder currText;
        private S3ObjectSummary currentObject;
        private Owner currentOwner;
        private boolean insideCommonPrefixes;
        private String lastKey;
        private boolean listingTruncated;
        private String nextMarker;
        private ObjectListing objectListing;
        private String requestDelimiter;
        private String requestMarker;
        private int requestMaxKeys;
        private String requestPrefix;

        public ListBucketHandler() {
            this.currentObject = null;
            this.currentOwner = null;
            this.currText = null;
            this.insideCommonPrefixes = false;
            this.objectListing = new ObjectListing();
            this.commonPrefixes = new ArrayList();
            this.bucketName = null;
            this.requestPrefix = null;
            this.requestMarker = null;
            this.requestMaxKeys = 0;
            this.requestDelimiter = null;
            this.listingTruncated = false;
            this.lastKey = null;
            this.nextMarker = null;
            this.currText = new StringBuilder();
        }

        public void characters(char[] cArr, int i, int i2) {
            this.currText.append(cArr, i, i2);
        }

        public void endDocument() {
        }

        public void endElement(String str, String str2, String str3) {
            String stringBuilder = this.currText.toString();
            if (str2.equals("Name")) {
                this.bucketName = stringBuilder;
                if (XmlResponsesSaxParser.log.isDebugEnabled()) {
                    XmlResponsesSaxParser.log.debug("Examining listing for bucket: " + this.bucketName);
                }
            } else if (!this.insideCommonPrefixes && str2.equals("Prefix")) {
                this.requestPrefix = XmlResponsesSaxParser.this.checkForEmptyString(stringBuilder);
            } else if (str2.equals("Marker")) {
                this.requestMarker = XmlResponsesSaxParser.this.checkForEmptyString(stringBuilder);
            } else if (str2.equals("NextMarker")) {
                this.nextMarker = stringBuilder;
            } else if (str2.equals("MaxKeys")) {
                this.requestMaxKeys = XmlResponsesSaxParser.this.parseInt(stringBuilder);
            } else if (str2.equals("Delimiter")) {
                this.requestDelimiter = XmlResponsesSaxParser.this.checkForEmptyString(stringBuilder);
            } else if (str2.equals("IsTruncated")) {
                String toLowerCase = stringBuilder.toLowerCase(Locale.getDefault());
                if (toLowerCase.startsWith("false")) {
                    this.listingTruncated = false;
                } else if (toLowerCase.startsWith("true")) {
                    this.listingTruncated = true;
                } else {
                    throw new RuntimeException("Invalid value for IsTruncated field: " + toLowerCase);
                }
            } else if (str2.equals("Contents")) {
                this.objectListing.getObjectSummaries().add(this.currentObject);
            } else if (str2.equals("Key")) {
                this.currentObject.setKey(stringBuilder);
                this.lastKey = stringBuilder;
            } else if (str2.equals("LastModified")) {
                try {
                    this.currentObject.setLastModified(ServiceUtils.parseIso8601Date(stringBuilder));
                } catch (Throwable e) {
                    throw new RuntimeException("Non-ISO8601 date for LastModified in bucket's object listing output: " + stringBuilder, e);
                }
            } else if (str2.equals(Header.ETAG)) {
                this.currentObject.setETag(ServiceUtils.removeQuotes(stringBuilder));
            } else if (str2.equals("Size")) {
                this.currentObject.setSize(XmlResponsesSaxParser.this.parseLong(stringBuilder));
            } else if (str2.equals("StorageClass")) {
                this.currentObject.setStorageClass(stringBuilder);
            } else if (str2.equals("ID")) {
                if (this.currentOwner == null) {
                    this.currentOwner = new Owner();
                    this.currentObject.setOwner(this.currentOwner);
                }
                this.currentOwner.setId(stringBuilder);
            } else if (str2.equals("DisplayName")) {
                this.currentOwner.setDisplayName(stringBuilder);
            } else if (this.insideCommonPrefixes && str2.equals("Prefix")) {
                this.commonPrefixes.add(stringBuilder);
            } else if (str2.equals("CommonPrefixes")) {
                this.insideCommonPrefixes = false;
            }
            this.currText = new StringBuilder();
        }

        public String[] getCommonPrefixes() {
            return (String[]) this.commonPrefixes.toArray(new String[this.commonPrefixes.size()]);
        }

        public String getMarkerForNextListing() {
            if (!this.listingTruncated) {
                return null;
            }
            if (this.nextMarker != null) {
                return this.nextMarker;
            }
            if (this.lastKey != null) {
                return this.lastKey;
            }
            if (!XmlResponsesSaxParser.log.isWarnEnabled()) {
                return null;
            }
            XmlResponsesSaxParser.log.warn("Unable to find Next Marker or Last Key for truncated listing");
            return null;
        }

        public String getNextMarker() {
            return this.nextMarker;
        }

        public ObjectListing getObjectListing() {
            this.objectListing.setBucketName(this.bucketName);
            this.objectListing.setCommonPrefixes(this.commonPrefixes);
            this.objectListing.setDelimiter(this.requestDelimiter);
            this.objectListing.setMarker(this.requestMarker);
            this.objectListing.setMaxKeys(this.requestMaxKeys);
            this.objectListing.setPrefix(this.requestPrefix);
            this.objectListing.setTruncated(this.listingTruncated);
            if (this.nextMarker != null) {
                this.objectListing.setNextMarker(this.nextMarker);
            } else if (this.listingTruncated) {
                String str = null;
                if (!this.objectListing.getObjectSummaries().isEmpty()) {
                    str = ((S3ObjectSummary) this.objectListing.getObjectSummaries().get(this.objectListing.getObjectSummaries().size() - 1)).getKey();
                } else if (this.objectListing.getCommonPrefixes().isEmpty()) {
                    XmlResponsesSaxParser.log.error("S3 response indicates truncated results, but contains no object summaries or common prefixes.");
                } else {
                    str = (String) this.objectListing.getCommonPrefixes().get(this.objectListing.getCommonPrefixes().size() - 1);
                }
                this.objectListing.setNextMarker(str);
            }
            return this.objectListing;
        }

        public List<S3ObjectSummary> getObjects() {
            return this.objectListing.getObjectSummaries();
        }

        public String getRequestMarker() {
            return this.requestMarker;
        }

        public long getRequestMaxKeys() {
            return (long) this.requestMaxKeys;
        }

        public String getRequestPrefix() {
            return this.requestPrefix;
        }

        public boolean isListingTruncated() {
            return this.listingTruncated;
        }

        public void startDocument() {
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("Contents")) {
                this.currentObject = new S3ObjectSummary();
                this.currentObject.setBucketName(this.bucketName);
            } else if (str2.equals("Owner")) {
                this.currentOwner = new Owner();
                this.currentObject.setOwner(this.currentOwner);
            } else if (str2.equals("CommonPrefixes")) {
                this.insideCommonPrefixes = true;
            }
        }
    }

    public class ListMultipartUploadsHandler extends DefaultHandler {
        private Owner currentInitiator;
        private MultipartUpload currentMultipartUpload;
        private Owner currentOwner;
        boolean inCommonPrefixes;
        private MultipartUploadListing result;
        private StringBuilder text;

        public ListMultipartUploadsHandler() {
            this.inCommonPrefixes = false;
        }

        public void characters(char[] cArr, int i, int i2) {
            this.text.append(cArr, i, i2);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (!str2.equals("ListMultipartUploadsResult")) {
                if (str2.equals("Bucket")) {
                    this.result.setBucketName(this.text.toString());
                } else if (str2.equals("KeyMarker")) {
                    this.result.setKeyMarker(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("Delimiter")) {
                    this.result.setDelimiter(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("Prefix") && !this.inCommonPrefixes) {
                    this.result.setPrefix(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("Prefix") && this.inCommonPrefixes) {
                    this.result.getCommonPrefixes().add(this.text.toString());
                } else if (str2.equals("UploadIdMarker")) {
                    this.result.setUploadIdMarker(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("NextKeyMarker")) {
                    this.result.setNextKeyMarker(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("NextUploadIdMarker")) {
                    this.result.setNextUploadIdMarker(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("MaxUploads")) {
                    this.result.setMaxUploads(Integer.parseInt(this.text.toString()));
                } else if (str2.equals("IsTruncated")) {
                    this.result.setTruncated(Boolean.parseBoolean(this.text.toString()));
                } else if (str2.equals("Upload")) {
                    this.result.getMultipartUploads().add(this.currentMultipartUpload);
                } else if (str2.equals("Key")) {
                    this.currentMultipartUpload.setKey(this.text.toString());
                } else if (str2.equals("UploadId")) {
                    this.currentMultipartUpload.setUploadId(this.text.toString());
                } else if (str2.equals("Owner")) {
                    this.currentMultipartUpload.setOwner(this.currentOwner);
                    this.currentOwner = null;
                } else if (str2.equals("Initiator")) {
                    this.currentMultipartUpload.setInitiator(this.currentInitiator);
                    this.currentInitiator = null;
                } else if (str2.equals("ID") && this.currentOwner != null) {
                    this.currentOwner.setId(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("DisplayName") && this.currentOwner != null) {
                    this.currentOwner.setDisplayName(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("ID") && this.currentInitiator != null) {
                    this.currentInitiator.setId(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("DisplayName") && this.currentInitiator != null) {
                    this.currentInitiator.setDisplayName(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("StorageClass")) {
                    this.currentMultipartUpload.setStorageClass(this.text.toString());
                } else if (str2.equals("Initiated")) {
                    try {
                        this.currentMultipartUpload.setInitiated(ServiceUtils.parseIso8601Date(this.text.toString()));
                    } catch (Exception e) {
                        throw new SAXException("Non-ISO8601 date for Initiated in initiate multipart upload result: " + this.text.toString(), e);
                    }
                } else if (str2.equals("CommonPrefixes")) {
                    this.inCommonPrefixes = false;
                }
            }
        }

        public MultipartUploadListing getListMultipartUploadsResult() {
            return this.result;
        }

        public void startDocument() {
            this.text = new StringBuilder();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("ListMultipartUploadsResult")) {
                this.result = new MultipartUploadListing();
            } else if (!(str2.equals("Bucket") || str2.equals("KeyMarker") || str2.equals("Delimiter") || str2.equals("UploadIdMarker") || str2.equals("NextKeyMarker") || str2.equals("NextUploadIdMarker") || str2.equals("MaxUploads") || str2.equals("IsTruncated"))) {
                if (str2.equals("Upload")) {
                    this.currentMultipartUpload = new MultipartUpload();
                } else if (!(str2.equals("Key") || str2.equals("UploadId"))) {
                    if (str2.equals("Owner")) {
                        this.currentOwner = new Owner();
                    } else if (str2.equals("Initiator")) {
                        this.currentInitiator = new Owner();
                    } else if (!(str2.equals("ID") || str2.equals("DisplayName") || str2.equals("StorageClass") || str2.equals("Initiated") || !str2.equals("CommonPrefixes"))) {
                        this.inCommonPrefixes = true;
                    }
                }
            }
            this.text.setLength(0);
        }
    }

    public class ListPartsHandler extends DefaultHandler {
        private Owner currentInitiator;
        private Owner currentOwner;
        private PartSummary currentPart;
        private PartListing result;
        private StringBuilder text;

        private Integer parseInteger(String str) {
            String access$100 = XmlResponsesSaxParser.this.checkForEmptyString(str.toString());
            return access$100 == null ? null : Integer.valueOf(Integer.parseInt(access$100));
        }

        public void characters(char[] cArr, int i, int i2) {
            this.text.append(cArr, i, i2);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (!str2.equals("ListPartsResult")) {
                if (str2.equals("Bucket")) {
                    this.result.setBucketName(this.text.toString());
                } else if (str2.equals("Key")) {
                    this.result.setKey(this.text.toString());
                } else if (str2.equals("UploadId")) {
                    this.result.setUploadId(this.text.toString());
                } else if (str2.equals("Owner")) {
                    this.result.setOwner(this.currentOwner);
                    this.currentOwner = null;
                } else if (str2.equals("Initiator")) {
                    this.result.setInitiator(this.currentInitiator);
                    this.currentInitiator = null;
                } else if (str2.equals("ID") && this.currentOwner != null) {
                    this.currentOwner.setId(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("DisplayName") && this.currentOwner != null) {
                    this.currentOwner.setDisplayName(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("ID") && this.currentInitiator != null) {
                    this.currentInitiator.setId(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("DisplayName") && this.currentInitiator != null) {
                    this.currentInitiator.setDisplayName(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
                } else if (str2.equals("StorageClass")) {
                    this.result.setStorageClass(this.text.toString());
                } else if (str2.equals("PartNumberMarker")) {
                    this.result.setPartNumberMarker(parseInteger(this.text.toString()).intValue());
                } else if (str2.equals("NextPartNumberMarker")) {
                    this.result.setNextPartNumberMarker(parseInteger(this.text.toString()).intValue());
                } else if (str2.equals("MaxParts")) {
                    this.result.setMaxParts(parseInteger(this.text.toString()).intValue());
                } else if (str2.equals("IsTruncated")) {
                    this.result.setTruncated(Boolean.parseBoolean(this.text.toString()));
                } else if (str2.equals("Part")) {
                    this.result.getParts().add(this.currentPart);
                } else if (str2.equals("PartNumber")) {
                    this.currentPart.setPartNumber(Integer.parseInt(this.text.toString()));
                } else if (str2.equals("LastModified")) {
                    try {
                        this.currentPart.setLastModified(ServiceUtils.parseIso8601Date(this.text.toString()));
                    } catch (Exception e) {
                        throw new SAXException("Non-ISO8601 date for LastModified in list parts result: " + this.text.toString(), e);
                    }
                } else if (str2.equals(Header.ETAG)) {
                    this.currentPart.setETag(ServiceUtils.removeQuotes(this.text.toString()));
                } else if (str2.equals("Size")) {
                    this.currentPart.setSize(Long.parseLong(this.text.toString()));
                }
            }
        }

        public PartListing getListPartsResult() {
            return this.result;
        }

        public void startDocument() {
            this.text = new StringBuilder();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("ListPartsResult")) {
                this.result = new PartListing();
            } else if (!(str2.equals("Bucket") || str2.equals("Key") || str2.equals("UploadId"))) {
                if (str2.equals("Owner")) {
                    this.currentOwner = new Owner();
                } else if (str2.equals("Initiator")) {
                    this.currentInitiator = new Owner();
                } else if (!(str2.equals("ID") || str2.equals("DisplayName") || str2.equals("StorageClass") || str2.equals("PartNumberMarker") || str2.equals("NextPartNumberMarker") || str2.equals("MaxParts") || str2.equals("IsTruncated"))) {
                    if (str2.equals("Part")) {
                        this.currentPart = new PartSummary();
                    } else if (!(str2.equals("PartNumber") || str2.equals("LastModified") || str2.equals(Header.ETAG) || !str2.equals("Size"))) {
                    }
                }
            }
            this.text.setLength(0);
        }
    }

    public class ListVersionsHandler extends DefaultHandler {
        static final /* synthetic */ boolean $assertionsDisabled;
        private S3VersionSummary currentVersionSummary;
        private boolean insideCommonPrefixes;
        private Owner owner;
        private StringBuilder text;
        private VersionListing versionListing;
        private List<S3VersionSummary> versionSummaries;

        static {
            $assertionsDisabled = !XmlResponsesSaxParser.class.desiredAssertionStatus();
        }

        public ListVersionsHandler() {
            this.insideCommonPrefixes = false;
        }

        public void characters(char[] cArr, int i, int i2) {
            this.text.append(cArr, i, i2);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (str2.equals("ListVersionsResult")) {
                this.versionListing.setVersionSummaries(this.versionSummaries);
            } else if (str2.equals("Name")) {
                this.versionListing.setBucketName(this.text.toString());
            } else if (!this.insideCommonPrefixes && str2.equals("Prefix")) {
                this.versionListing.setPrefix(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
            } else if (this.insideCommonPrefixes && str2.equals("Prefix")) {
                this.versionListing.getCommonPrefixes().add(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
            } else if (str2.equals("CommonPrefixes")) {
                this.insideCommonPrefixes = false;
            } else if (str2.equals("KeyMarker")) {
                this.versionListing.setKeyMarker(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
            } else if (str2.equals("VersionIdMarker")) {
                this.versionListing.setVersionIdMarker(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
            } else if (str2.equals("MaxKeys")) {
                this.versionListing.setMaxKeys(Integer.parseInt(this.text.toString()));
            } else if (str2.equals("Delimiter")) {
                this.versionListing.setDelimiter(XmlResponsesSaxParser.this.checkForEmptyString(this.text.toString()));
            } else if (str2.equals("NextKeyMarker")) {
                this.versionListing.setNextKeyMarker(this.text.toString());
            } else if (str2.equals("NextVersionIdMarker")) {
                this.versionListing.setNextVersionIdMarker(this.text.toString());
            } else if (str2.equals("IsTruncated")) {
                this.versionListing.setTruncated("true".equals(this.text.toString()));
            } else if (str2.equals("Version")) {
                if ($assertionsDisabled || this.currentVersionSummary != null) {
                    this.versionSummaries.add(this.currentVersionSummary);
                    this.currentVersionSummary = null;
                } else {
                    throw new AssertionError();
                }
            } else if (str2.equals("DeleteMarker")) {
                if ($assertionsDisabled || this.currentVersionSummary != null) {
                    this.versionSummaries.add(this.currentVersionSummary);
                    this.currentVersionSummary = null;
                } else {
                    throw new AssertionError();
                }
            } else if (str2.equals("Key")) {
                if ($assertionsDisabled || this.currentVersionSummary != null) {
                    this.currentVersionSummary.setKey(this.text.toString());
                } else {
                    throw new AssertionError();
                }
            } else if (str2.equals("VersionId")) {
                if ($assertionsDisabled || this.currentVersionSummary != null) {
                    this.currentVersionSummary.setVersionId(this.text.toString());
                } else {
                    throw new AssertionError();
                }
            } else if (str2.equals("IsLatest")) {
                if ($assertionsDisabled || this.currentVersionSummary != null) {
                    this.currentVersionSummary.setIsLatest("true".equals(this.text.toString()));
                } else {
                    throw new AssertionError();
                }
            } else if (str2.equals("LastModified")) {
                if ($assertionsDisabled || this.currentVersionSummary != null) {
                    try {
                        this.currentVersionSummary.setLastModified(ServiceUtils.parseIso8601Date(this.text.toString()));
                    } catch (Exception e) {
                        throw new SAXException("Non-ISO8601 date for LastModified in copy object output: " + this.text.toString(), e);
                    }
                }
                throw new AssertionError();
            } else if (str2.equals(Header.ETAG)) {
                if (!$assertionsDisabled && this.currentVersionSummary == null) {
                    throw new AssertionError();
                } else if ($assertionsDisabled || !this.currentVersionSummary.isDeleteMarker()) {
                    this.currentVersionSummary.setETag(ServiceUtils.removeQuotes(this.text.toString()));
                } else {
                    throw new AssertionError();
                }
            } else if (str2.equals("Size")) {
                if (!$assertionsDisabled && this.currentVersionSummary == null) {
                    throw new AssertionError();
                } else if ($assertionsDisabled || !this.currentVersionSummary.isDeleteMarker()) {
                    this.currentVersionSummary.setSize(Long.parseLong(this.text.toString()));
                } else {
                    throw new AssertionError();
                }
            } else if (str2.equals("Owner")) {
                this.currentVersionSummary.setOwner(this.owner);
                this.owner = null;
            } else if (str2.equals("StorageClass")) {
                if (!$assertionsDisabled && this.currentVersionSummary == null) {
                    throw new AssertionError();
                } else if ($assertionsDisabled || !this.currentVersionSummary.isDeleteMarker()) {
                    this.currentVersionSummary.setStorageClass(this.text.toString());
                } else {
                    throw new AssertionError();
                }
            } else if (str2.equals("ID")) {
                if ($assertionsDisabled || this.owner != null) {
                    this.owner.setId(this.text.toString());
                } else {
                    throw new AssertionError();
                }
            } else if (!str2.equals("DisplayName")) {
                XmlResponsesSaxParser.log.warn("Ignoring unexpected tag <" + str2 + ">");
            } else if ($assertionsDisabled || this.owner != null) {
                this.owner.setDisplayName(this.text.toString());
            } else {
                throw new AssertionError();
            }
            this.text.setLength(0);
        }

        public VersionListing getListing() {
            return this.versionListing;
        }

        public void startDocument() {
            this.versionListing = new VersionListing();
            this.versionSummaries = new ArrayList();
            this.text = new StringBuilder();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (!str2.equals("ListVersionsResult")) {
                if (str2.equals("CommonPrefixes")) {
                    this.insideCommonPrefixes = true;
                } else if (!(str2.equals("Name") || str2.equals("Prefix") || str2.equals("Delimiter") || str2.equals("KeyMarker") || str2.equals("VersionIdMarker") || str2.equals("MaxKeys") || str2.equals("NextKeyMarker") || str2.equals("NextVersionIdMarker") || str2.equals("IsTruncated"))) {
                    if (str2.equals("Version")) {
                        this.currentVersionSummary = new S3VersionSummary();
                        this.currentVersionSummary.setBucketName(this.versionListing.getBucketName());
                    } else if (str2.equals("DeleteMarker")) {
                        this.currentVersionSummary = new S3VersionSummary();
                        this.currentVersionSummary.setBucketName(this.versionListing.getBucketName());
                        this.currentVersionSummary.setIsDeleteMarker(true);
                    } else if (!(str2.equals("Key") || str2.equals("VersionId") || str2.equals("IsLatest") || str2.equals("LastModified") || str2.equals(Header.ETAG) || str2.equals("Size"))) {
                        if (str2.equals("Owner")) {
                            this.owner = new Owner();
                        } else if (!(str2.equals("StorageClass") || str2.equals("ID") || str2.equals("DisplayName"))) {
                            XmlResponsesSaxParser.log.warn("Ignoring unexpected tag <" + str2 + ">");
                        }
                    }
                }
            }
            this.text.setLength(0);
        }
    }

    public class RequestPaymentConfigurationHandler extends DefaultHandler {
        private StringBuilder currText;
        private String payer;

        public RequestPaymentConfigurationHandler() {
            this.payer = null;
            this.currText = null;
            this.currText = new StringBuilder();
        }

        public void characters(char[] cArr, int i, int i2) {
            this.currText.append(cArr, i, i2);
        }

        public void endDocument() {
        }

        public void endElement(String str, String str2, String str3) {
            String stringBuilder = this.currText.toString();
            if (str2.equals("Payer")) {
                this.payer = stringBuilder;
            }
            this.currText = new StringBuilder();
        }

        public boolean isRequesterPays() {
            return "Requester".equals(this.payer);
        }

        public void startDocument() {
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (!str2.equals("RequestPaymentConfiguration")) {
            }
        }
    }

    static {
        log = LogFactory.getLog(XmlResponsesSaxParser.class);
    }

    public XmlResponsesSaxParser() throws AmazonClientException {
        this.xr = null;
        this.sanitizeXmlDocument = true;
        try {
            this.xr = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.setProperty("org.xml.sax.driver", "org.apache.crimson.parser.XMLReaderImpl");
            try {
                this.xr = XMLReaderFactory.createXMLReader();
            } catch (SAXException e2) {
                throw new AmazonClientException("Couldn't initialize a sax driver for the XMLReader");
            }
        }
    }

    private String checkForEmptyString(String str) {
        return str == null ? null : str.length() == 0 ? null : str;
    }

    private static String findAttributeValue(String str, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (attributes.getQName(i).trim().equalsIgnoreCase(str.trim())) {
                return attributes.getValue(i);
            }
        }
        return null;
    }

    private int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable e) {
            log.error("Unable to parse integer value '" + str + "'", e);
            return -1;
        }
    }

    private long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable e) {
            log.error("Unable to parse long value '" + str + "'", e);
            return -1;
        }
    }

    public AccessControlListHandler parseAccessControlListResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler accessControlListHandler = new AccessControlListHandler();
        parseXmlInputStream(accessControlListHandler, inputStream);
        return accessControlListHandler;
    }

    public BucketCrossOriginConfigurationHandler parseBucketCrossOriginConfigurationResponse(InputStream inputStream) {
        DefaultHandler bucketCrossOriginConfigurationHandler = new BucketCrossOriginConfigurationHandler();
        parseXmlInputStream(bucketCrossOriginConfigurationHandler, inputStream);
        return bucketCrossOriginConfigurationHandler;
    }

    public BucketLifecycleConfigurationHandler parseBucketLifecycleConfigurationResponse(InputStream inputStream) {
        DefaultHandler bucketLifecycleConfigurationHandler = new BucketLifecycleConfigurationHandler();
        parseXmlInputStream(bucketLifecycleConfigurationHandler, inputStream);
        return bucketLifecycleConfigurationHandler;
    }

    public String parseBucketLocationResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler bucketLocationHandler = new BucketLocationHandler();
        parseXmlInputStream(bucketLocationHandler, inputStream);
        return bucketLocationHandler.getLocation();
    }

    public CompleteMultipartUploadHandler parseCompleteMultipartUploadResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler completeMultipartUploadHandler = new CompleteMultipartUploadHandler();
        parseXmlInputStream(completeMultipartUploadHandler, inputStream);
        return completeMultipartUploadHandler;
    }

    public CopyObjectResultHandler parseCopyObjectResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler copyObjectResultHandler = new CopyObjectResultHandler();
        parseXmlInputStream(copyObjectResultHandler, inputStream);
        return copyObjectResultHandler;
    }

    public DeleteObjectsHandler parseDeletedObjectsResult(InputStream inputStream) {
        DefaultHandler deleteObjectsHandler = new DeleteObjectsHandler();
        parseXmlInputStream(deleteObjectsHandler, inputStream);
        return deleteObjectsHandler;
    }

    public InitiateMultipartUploadHandler parseInitiateMultipartUploadResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler initiateMultipartUploadHandler = new InitiateMultipartUploadHandler();
        parseXmlInputStream(initiateMultipartUploadHandler, inputStream);
        return initiateMultipartUploadHandler;
    }

    public ListBucketHandler parseListBucketObjectsResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler listBucketHandler = new ListBucketHandler();
        parseXmlInputStream(listBucketHandler, sanitizeXmlDocument(listBucketHandler, inputStream));
        return listBucketHandler;
    }

    public ListMultipartUploadsHandler parseListMultipartUploadsResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler listMultipartUploadsHandler = new ListMultipartUploadsHandler();
        parseXmlInputStream(listMultipartUploadsHandler, inputStream);
        return listMultipartUploadsHandler;
    }

    public ListAllMyBucketsHandler parseListMyBucketsResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler listAllMyBucketsHandler = new ListAllMyBucketsHandler();
        parseXmlInputStream(listAllMyBucketsHandler, sanitizeXmlDocument(listAllMyBucketsHandler, inputStream));
        return listAllMyBucketsHandler;
    }

    public ListPartsHandler parseListPartsResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler listPartsHandler = new ListPartsHandler();
        parseXmlInputStream(listPartsHandler, inputStream);
        return listPartsHandler;
    }

    public ListVersionsHandler parseListVersionsResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler listVersionsHandler = new ListVersionsHandler();
        parseXmlInputStream(listVersionsHandler, sanitizeXmlDocument(listVersionsHandler, inputStream));
        return listVersionsHandler;
    }

    public BucketLoggingConfigurationHandler parseLoggingStatusResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler bucketLoggingConfigurationHandler = new BucketLoggingConfigurationHandler();
        parseXmlInputStream(bucketLoggingConfigurationHandler, inputStream);
        return bucketLoggingConfigurationHandler;
    }

    public BucketNotificationConfigurationHandler parseNotificationConfigurationResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler bucketNotificationConfigurationHandler = new BucketNotificationConfigurationHandler();
        parseXmlInputStream(bucketNotificationConfigurationHandler, inputStream);
        return bucketNotificationConfigurationHandler;
    }

    public boolean parseRequestPaymentConfigurationResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler requestPaymentConfigurationHandler = new RequestPaymentConfigurationHandler();
        parseXmlInputStream(requestPaymentConfigurationHandler, inputStream);
        return requestPaymentConfigurationHandler.isRequesterPays();
    }

    public BucketTaggingConfigurationHandler parseTaggingConfigurationResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler bucketTaggingConfigurationHandler = new BucketTaggingConfigurationHandler();
        parseXmlInputStream(bucketTaggingConfigurationHandler, inputStream);
        return bucketTaggingConfigurationHandler;
    }

    public BucketVersioningConfigurationHandler parseVersioningConfigurationResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler bucketVersioningConfigurationHandler = new BucketVersioningConfigurationHandler();
        parseXmlInputStream(bucketVersioningConfigurationHandler, inputStream);
        return bucketVersioningConfigurationHandler;
    }

    public BucketWebsiteConfigurationHandler parseWebsiteConfigurationResponse(InputStream inputStream) throws AmazonClientException {
        DefaultHandler bucketWebsiteConfigurationHandler = new BucketWebsiteConfigurationHandler();
        parseXmlInputStream(bucketWebsiteConfigurationHandler, inputStream);
        return bucketWebsiteConfigurationHandler;
    }

    protected void parseXmlInputStream(DefaultHandler defaultHandler, InputStream inputStream) throws AmazonClientException {
        try {
            if (log.isDebugEnabled()) {
                log.debug("Parsing XML response document with handler: " + defaultHandler.getClass());
            }
            Reader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Constants.DEFAULT_ENCODING));
            this.xr.setContentHandler(defaultHandler);
            this.xr.setErrorHandler(defaultHandler);
            this.xr.parse(new InputSource(bufferedReader));
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Throwable e) {
                if (log.isErrorEnabled()) {
                    log.error("Unable to close response InputStream up after XML parse failure", e);
                }
            }
            AmazonClientException amazonClientException = new AmazonClientException("Failed to parse XML document with handler " + defaultHandler.getClass(), th);
        }
    }

    protected InputStream sanitizeXmlDocument(DefaultHandler defaultHandler, InputStream inputStream) throws AmazonClientException {
        if (!this.sanitizeXmlDocument) {
            return inputStream;
        }
        if (log.isDebugEnabled()) {
            log.debug("Sanitizing XML document destined for handler " + defaultHandler.getClass());
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Constants.DEFAULT_ENCODING));
            char[] cArr = new char[UCSReader.DEFAULT_BUFFER_SIZE];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    stringBuilder.append(cArr, 0, read);
                } else {
                    bufferedReader.close();
                    return new ByteArrayInputStream(stringBuilder.toString().replaceAll("\r", "&#013;").getBytes(Constants.DEFAULT_ENCODING));
                }
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Throwable e) {
                if (log.isErrorEnabled()) {
                    log.error("Unable to close response InputStream after failure sanitizing XML document", e);
                }
            }
            AmazonClientException amazonClientException = new AmazonClientException("Failed to sanitize XML document destined for handler " + defaultHandler.getClass(), th);
        }
    }
}
