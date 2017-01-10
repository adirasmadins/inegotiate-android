package com.google.gdata.model.batch;

import com.google.gdata.data.batch.IBatchInterrupted;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ServiceException;

public class BatchInterrupted extends Element implements IBatchInterrupted {
    public static final AttributeKey<ContentType> CONTENT_TYPE;
    public static final AttributeKey<Integer> ERROR_COUNT;
    public static final ElementKey<String, BatchInterrupted> KEY;
    public static final AttributeKey<String> REASON;
    public static final AttributeKey<Integer> SKIPPED_COUNT;
    public static final AttributeKey<Integer> SUCCESS_COUNT;
    public static final AttributeKey<Integer> TOTAL_COUNT;

    static {
        KEY = ElementKey.of(new QName(Namespaces.batchNs, "interrupted"), String.class, BatchInterrupted.class);
        CONTENT_TYPE = AttributeKey.of(new QName("content-type"), ContentType.class);
        ERROR_COUNT = AttributeKey.of(new QName("error"), Integer.class);
        REASON = AttributeKey.of(new QName("reason"));
        SKIPPED_COUNT = AttributeKey.of(new QName("unprocessed"), Integer.class);
        SUCCESS_COUNT = AttributeKey.of(new QName("success"), Integer.class);
        TOTAL_COUNT = AttributeKey.of(new QName("parsed"), Integer.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY).setContentRequired(false);
            builder.addAttribute(CONTENT_TYPE);
            builder.addAttribute(ERROR_COUNT).setRequired(true);
            builder.addAttribute(TOTAL_COUNT).setRequired(true);
            builder.addAttribute(REASON);
            builder.addAttribute(SUCCESS_COUNT).setRequired(true);
            builder.addAttribute(SKIPPED_COUNT).setRequired(true);
        }
    }

    public BatchInterrupted() {
        super(KEY);
    }

    public BatchInterrupted(String reason, int totalCount, int successCount, int errorCount) {
        this();
        if (totalCount < successCount - errorCount) {
            throw new IllegalArgumentException("total < success + error. total = " + totalCount + " success=" + successCount + " error=" + errorCount);
        }
        setReason(reason);
        setTotalCount(Integer.valueOf(totalCount));
        setSuccessCount(Integer.valueOf(successCount));
        setErrorCount(Integer.valueOf(errorCount));
        setSkippedCount(Integer.valueOf(totalCount - (successCount + errorCount)));
    }

    public BatchInterrupted(Throwable cause, int totalCount, int successCount, int errorCount) {
        this(getReasonFromException(cause), totalCount, successCount, errorCount);
        if (cause instanceof ServiceException) {
            ServiceException se = (ServiceException) cause;
            setContent(se.getResponseBody());
            setContentType(se.getResponseContentType());
        }
    }

    public String getContent() {
        return (String) getTextValue(KEY);
    }

    public BatchInterrupted setContent(String content) {
        setTextValue(content);
        return this;
    }

    public boolean hasContent() {
        return hasTextValue();
    }

    public ContentType getContentType() {
        return (ContentType) getAttributeValue(CONTENT_TYPE);
    }

    public BatchInterrupted setContentType(ContentType contentType) {
        setAttributeValue(CONTENT_TYPE, contentType == null ? null : new ContentType(contentType.getMediaType()));
        return this;
    }

    public boolean hasContentType() {
        return getContentType() != null;
    }

    public int getErrorCount() {
        Integer count = (Integer) getAttributeValue(ERROR_COUNT);
        return count == null ? 0 : count.intValue();
    }

    public BatchInterrupted setErrorCount(Integer errorCount) {
        setAttributeValue(ERROR_COUNT, (Object) errorCount);
        return this;
    }

    public boolean hasErrorCount() {
        return getErrorCount() != 0;
    }

    public String getReason() {
        return (String) getAttributeValue(REASON);
    }

    public BatchInterrupted setReason(String reason) {
        setAttributeValue(REASON, (Object) reason);
        return this;
    }

    public boolean hasReason() {
        return getReason() != null;
    }

    public int getSkippedCount() {
        Integer count = (Integer) getAttributeValue(SKIPPED_COUNT);
        return count == null ? 0 : count.intValue();
    }

    public BatchInterrupted setSkippedCount(Integer skippedCount) {
        setAttributeValue(SKIPPED_COUNT, (Object) skippedCount);
        return this;
    }

    public boolean hasSkippedCount() {
        return getSkippedCount() != 0;
    }

    public int getSuccessCount() {
        Integer count = (Integer) getAttributeValue(SUCCESS_COUNT);
        return count == null ? 0 : count.intValue();
    }

    public BatchInterrupted setSuccessCount(Integer successCount) {
        setAttributeValue(SUCCESS_COUNT, (Object) successCount);
        return this;
    }

    public boolean hasSuccessCount() {
        return getSuccessCount() != 0;
    }

    public int getTotalCount() {
        Integer count = (Integer) getAttributeValue(TOTAL_COUNT);
        return count == null ? 0 : count.intValue();
    }

    public BatchInterrupted setTotalCount(Integer totalCount) {
        setAttributeValue(TOTAL_COUNT, (Object) totalCount);
        return this;
    }

    public boolean hasTotalCount() {
        return getTotalCount() != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        BatchInterrupted other = (BatchInterrupted) obj;
        if (Element.eq(getContent(), other.getContent()) && Element.eq(getContentType(), other.getContentType()) && Element.eq(Integer.valueOf(getErrorCount()), Integer.valueOf(other.getErrorCount())) && Element.eq(getReason(), other.getReason()) && Element.eq(Integer.valueOf(getSkippedCount()), Integer.valueOf(other.getSkippedCount())) && Element.eq(Integer.valueOf(getSuccessCount()), Integer.valueOf(other.getSuccessCount())) && Element.eq(Integer.valueOf(getTotalCount()), Integer.valueOf(other.getTotalCount()))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getContent() != null) {
            result = (result * 37) + getContent().hashCode();
        }
        if (getContentType() != null) {
            result = (result * 37) + getContentType().hashCode();
        }
        result = (result * 37) + getErrorCount();
        if (getReason() != null) {
            result = (result * 37) + getReason().hashCode();
        }
        return (((((result * 37) + getSkippedCount()) * 37) + getSuccessCount()) * 37) + getTotalCount();
    }

    public String toString() {
        return "{BatchInterrupted content=" + getTextValue() + " contentType=" + getAttributeValue(CONTENT_TYPE) + " errorCount=" + getAttributeValue(ERROR_COUNT) + " reason=" + ((String) getAttributeValue(REASON)) + " skippedCount=" + getAttributeValue(SKIPPED_COUNT) + " successCount=" + getAttributeValue(SUCCESS_COUNT) + " totalCount=" + getAttributeValue(TOTAL_COUNT) + "}";
    }

    private static String getReasonFromException(Throwable cause) {
        String message = cause.getMessage();
        if (message == null) {
            return "Unexpected error";
        }
        return message;
    }
}
