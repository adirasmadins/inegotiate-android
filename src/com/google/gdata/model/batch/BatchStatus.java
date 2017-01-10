package com.google.gdata.model.batch;

import com.doviknissim.inegotiate.app.DBAdapter;
import com.google.gdata.data.batch.IBatchStatus;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ServiceException;

public class BatchStatus extends Element implements IBatchStatus {
    public static final AttributeKey<Integer> CODE;
    public static final AttributeKey<ContentType> CONTENT_TYPE;
    public static final ElementKey<String, BatchStatus> KEY;
    public static final AttributeKey<String> REASON;

    static {
        KEY = ElementKey.of(new QName(Namespaces.batchNs, DBAdapter.STATUS), String.class, BatchStatus.class);
        CODE = AttributeKey.of(new QName("code"), Integer.class);
        CONTENT_TYPE = AttributeKey.of(new QName("content-type"), ContentType.class);
        REASON = AttributeKey.of(new QName("reason"));
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY).setContentRequired(false);
            builder.addAttribute(CODE).setRequired(true);
            builder.addAttribute(CONTENT_TYPE);
            builder.addAttribute(REASON).setRequired(true);
        }
    }

    public static BatchStatus createSuccessStatus() {
        BatchStatus status = new BatchStatus();
        status.setCode(Integer.valueOf(200));
        status.setReason("Success");
        return status;
    }

    public static BatchStatus createCreatedStatus() {
        BatchStatus status = new BatchStatus();
        status.setCode(Integer.valueOf(201));
        status.setReason("Created");
        return status;
    }

    public BatchStatus() {
        super(KEY);
    }

    public BatchStatus(ServiceException e) {
        this();
        int code = e.getHttpErrorCodeOverride();
        if (code == -1) {
            code = 500;
        }
        setCode(Integer.valueOf(code));
        setReason(e.getMessage());
        setContentType(e.getResponseContentType());
        setContent(e.getResponseBody());
    }

    public int getCode() {
        Integer code = (Integer) getAttributeValue(CODE);
        return code == null ? 0 : code.intValue();
    }

    public BatchStatus setCode(Integer code) {
        setAttributeValue(CODE, (Object) code);
        return this;
    }

    public boolean hasCode() {
        return getCode() != 0;
    }

    public String getContent() {
        return (String) getTextValue(KEY);
    }

    public BatchStatus setContent(String content) {
        setTextValue(content);
        return this;
    }

    public boolean hasContent() {
        return hasTextValue();
    }

    public ContentType getContentType() {
        return (ContentType) getAttributeValue(CONTENT_TYPE);
    }

    public BatchStatus setContentType(ContentType contentType) {
        setAttributeValue(CONTENT_TYPE, contentType == null ? null : new ContentType(contentType.getMediaType()));
        return this;
    }

    public boolean hasContentType() {
        return getContentType() != null;
    }

    public String getReason() {
        return (String) getAttributeValue(REASON);
    }

    public BatchStatus setReason(String reason) {
        setAttributeValue(REASON, (Object) reason);
        return this;
    }

    public boolean hasReason() {
        return getReason() != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        BatchStatus other = (BatchStatus) obj;
        if (Element.eq(Integer.valueOf(getCode()), Integer.valueOf(other.getCode())) && Element.eq(getContent(), other.getContent()) && Element.eq(getContentType(), other.getContentType()) && Element.eq(getReason(), other.getReason())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = (getClass().hashCode() * 37) + getCode();
        if (getContent() != null) {
            result = (result * 37) + getContent().hashCode();
        }
        if (getContentType() != null) {
            result = (result * 37) + getContentType().hashCode();
        }
        if (getReason() != null) {
            return (result * 37) + getReason().hashCode();
        }
        return result;
    }

    public String toString() {
        return "{BatchStatus code=" + getAttributeValue(CODE) + " content=" + getTextValue() + " contentType=" + getAttributeValue(CONTENT_TYPE) + " reason=" + ((String) getAttributeValue(REASON)) + "}";
    }
}
