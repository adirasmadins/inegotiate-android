package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.javax.xml.XMLConstants;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.internal.XmlWriter;
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
import com.amazonaws.services.s3.model.TagSet;
import com.google.gdata.util.common.base.StringUtil;

public class BucketConfigurationXmlFactory {
    private void writeRule(XmlWriter xmlWriter, Rule rule) {
        xmlWriter.start("Rule");
        if (rule.getId() != null) {
            xmlWriter.start("ID").value(rule.getId()).end();
        }
        xmlWriter.start("Prefix").value(rule.getPrefix()).end();
        xmlWriter.start("Status").value(rule.getStatus()).end();
        xmlWriter.start("Expiration");
        xmlWriter.start("Days").value(StringUtil.EMPTY_STRING + rule.getExpirationInDays()).end();
        xmlWriter.end();
        xmlWriter.end();
    }

    private void writeRule(XmlWriter xmlWriter, CORSRule cORSRule) {
        xmlWriter.start("CORSRule");
        if (cORSRule.getId() != null) {
            xmlWriter.start("ID").value(cORSRule.getId()).end();
        }
        if (cORSRule.getAllowedOrigins() != null) {
            for (String value : cORSRule.getAllowedOrigins()) {
                xmlWriter.start("AllowedOrigin").value(value).end();
            }
        }
        if (cORSRule.getAllowedMethods() != null) {
            for (AllowedMethods allowedMethods : cORSRule.getAllowedMethods()) {
                xmlWriter.start("AllowedMethod").value(allowedMethods.toString()).end();
            }
        }
        if (cORSRule.getMaxAgeSeconds() != 0) {
            xmlWriter.start("MaxAgeSeconds").value(Integer.toString(cORSRule.getMaxAgeSeconds())).end();
        }
        if (cORSRule.getExposedHeaders() != null) {
            for (String value2 : cORSRule.getExposedHeaders()) {
                xmlWriter.start("ExposeHeader").value(value2).end();
            }
        }
        if (cORSRule.getAllowedHeaders() != null) {
            for (String value22 : cORSRule.getAllowedHeaders()) {
                xmlWriter.start("AllowedHeader").value(value22).end();
            }
        }
        xmlWriter.end();
    }

    private void writeRule(XmlWriter xmlWriter, TagSet tagSet) {
        xmlWriter.start("TagSet");
        for (String str : tagSet.getAllTags().keySet()) {
            xmlWriter.start("Tag");
            xmlWriter.start("Key").value(str).end();
            xmlWriter.start("Value").value(tagSet.getTag(str)).end();
            xmlWriter.end();
        }
        xmlWriter.end();
    }

    public byte[] convertToXmlByteArray(BucketCrossOriginConfiguration bucketCrossOriginConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("CORSConfiguration", XMLConstants.XMLNS_ATTRIBUTE, Constants.XML_NAMESPACE);
        for (CORSRule writeRule : bucketCrossOriginConfiguration.getRules()) {
            writeRule(xmlWriter, writeRule);
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketLifecycleConfiguration bucketLifecycleConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("LifecycleConfiguration");
        for (Rule writeRule : bucketLifecycleConfiguration.getRules()) {
            writeRule(xmlWriter, writeRule);
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketLoggingConfiguration bucketLoggingConfiguration) {
        if (bucketLoggingConfiguration.getLogFilePrefix() == null) {
            String str = StringUtil.EMPTY_STRING;
        }
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("BucketLoggingStatus", XMLConstants.XMLNS_ATTRIBUTE, Constants.XML_NAMESPACE);
        if (bucketLoggingConfiguration.isLoggingEnabled()) {
            xmlWriter.start("LoggingEnabled");
            xmlWriter.start("TargetBucket").value(bucketLoggingConfiguration.getDestinationBucketName()).end();
            xmlWriter.start("TargetPrefix").value(bucketLoggingConfiguration.getLogFilePrefix()).end();
            xmlWriter.end();
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketNotificationConfiguration bucketNotificationConfiguration) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("NotificationConfiguration", XMLConstants.XMLNS_ATTRIBUTE, Constants.XML_NAMESPACE);
        for (TopicConfiguration topicConfiguration : bucketNotificationConfiguration.getTopicConfigurations()) {
            xmlWriter.start("TopicConfiguration");
            xmlWriter.start("Topic").value(topicConfiguration.getTopic()).end();
            xmlWriter.start("Event").value(topicConfiguration.getEvent()).end();
            xmlWriter.end();
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketTaggingConfiguration bucketTaggingConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("Tagging");
        for (TagSet writeRule : bucketTaggingConfiguration.getAllTagSets()) {
            writeRule(xmlWriter, writeRule);
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketVersioningConfiguration bucketVersioningConfiguration) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("VersioningConfiguration", XMLConstants.XMLNS_ATTRIBUTE, Constants.XML_NAMESPACE);
        xmlWriter.start("Status").value(bucketVersioningConfiguration.getStatus()).end();
        Boolean isMfaDeleteEnabled = bucketVersioningConfiguration.isMfaDeleteEnabled();
        if (isMfaDeleteEnabled != null) {
            if (isMfaDeleteEnabled.booleanValue()) {
                xmlWriter.start("MfaDelete").value(BucketVersioningConfiguration.ENABLED).end();
            } else {
                xmlWriter.start("MfaDelete").value(BucketLifecycleConfiguration.DISABLED).end();
            }
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketWebsiteConfiguration bucketWebsiteConfiguration) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("WebsiteConfiguration", XMLConstants.XMLNS_ATTRIBUTE, Constants.XML_NAMESPACE);
        if (bucketWebsiteConfiguration.getIndexDocumentSuffix() != null) {
            XmlWriter start = xmlWriter.start("IndexDocument");
            start.start("Suffix").value(bucketWebsiteConfiguration.getIndexDocumentSuffix()).end();
            start.end();
        }
        if (bucketWebsiteConfiguration.getErrorDocument() != null) {
            start = xmlWriter.start("ErrorDocument");
            start.start("Key").value(bucketWebsiteConfiguration.getErrorDocument()).end();
            start.end();
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }
}
