package com.google.gdata.data.docs;

import com.google.gdata.client.DocumentQuery;
import com.google.gdata.client.GDataProtocol.Query;
import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.AttributeHelper.EnumToAttributeValue;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.util.ParseException;

@Default(localName = "query", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class QueryParameter extends ExtensionPoint {
    private static final String TYPE = "type";
    private static final EnumToAttributeValue<Type> TYPE_ENUM_TO_ATTRIBUTE_VALUE;
    private static final String VALUE = "value";
    static final String XML_NAME = "query";
    private Type type;
    private String value;

    /* renamed from: com.google.gdata.data.docs.QueryParameter.1 */
    static class C07291 implements EnumToAttributeValue<Type> {
        C07291() {
        }

        public String getAttributeValue(Type enumValue) {
            return enumValue.toValue();
        }
    }

    public enum Type {
        AUTHOR(Query.AUTHOR),
        CATEGORY(Query.CATEGORY),
        OPENED_MAX("opened-max"),
        OPENED_MIN("opened-min"),
        OWNER("owner"),
        Q(Query.FULL_TEXT),
        READER("reader"),
        TITLE(DocumentQuery.TITLE_SORT),
        TITLE_EXACT(DocumentQuery.TITLE_EXACT),
        UPDATED_MAX(Query.UPDATED_MAX),
        UPDATED_MIN(Query.UPDATED_MIN),
        WRITER("writer");
        
        private final String value;

        private Type(String value) {
            this.value = value;
        }

        public String toValue() {
            return this.value;
        }
    }

    static {
        TYPE_ENUM_TO_ATTRIBUTE_VALUE = new C07291();
    }

    public QueryParameter() {
        this.type = null;
        this.value = null;
    }

    public QueryParameter(Type type, String value) {
        this.type = null;
        this.value = null;
        setType(type);
        setValue(value);
        setImmutable(true);
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        throwExceptionIfImmutable();
        this.type = type;
    }

    public boolean hasType() {
        return getType() != null;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        throwExceptionIfImmutable();
        this.value = value;
    }

    public boolean hasValue() {
        return getValue() != null;
    }

    protected void validate() {
        if (this.type == null) {
            AbstractExtension.throwExceptionForMissingAttribute(TYPE);
        }
        if (this.value == null) {
            AbstractExtension.throwExceptionForMissingAttribute(VALUE);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(QueryParameter.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(TYPE, this.type, TYPE_ENUM_TO_ATTRIBUTE_VALUE);
        generator.put(VALUE, this.value);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.type = (Type) helper.consumeEnum(TYPE, true, Type.class, null, TYPE_ENUM_TO_ATTRIBUTE_VALUE);
        this.value = helper.consume(VALUE, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        QueryParameter other = (QueryParameter) obj;
        if (AbstractExtension.eq(this.type, other.type) && AbstractExtension.eq(this.value, other.value)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.type != null) {
            result = (result * 37) + this.type.hashCode();
        }
        if (this.value != null) {
            return (result * 37) + this.value.hashCode();
        }
        return result;
    }

    public String toString() {
        return "{QueryParameter type=" + this.type + " value=" + this.value + "}";
    }
}
