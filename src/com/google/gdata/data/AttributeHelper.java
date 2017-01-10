package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.util.ParseException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xml.sax.Attributes;

public class AttributeHelper {
    protected final Map<String, String> attrs;
    private String content;
    private boolean contentConsumed;
    private Set<String> dups;

    public interface EnumToAttributeValue<T extends Enum<T>> {
        String getAttributeValue(T t);
    }

    public static class LowerCaseEnumToAttributeValue<T extends Enum<T>> implements EnumToAttributeValue<T> {
        public String getAttributeValue(T enumValue) {
            return enumValue.name().toLowerCase();
        }
    }

    public AttributeHelper(Attributes attrs) {
        this.attrs = new HashMap();
        this.dups = new HashSet();
        this.contentConsumed = false;
        this.content = null;
        for (int i = 0; i < attrs.getLength(); i++) {
            if (attrs.getURI(i).length() != 0) {
                String attrLocalName = attrs.getLocalName(i);
                if (this.attrs.put(attrLocalName, attrs.getValue(i)) != null) {
                    this.dups.add(attrLocalName);
                }
            } else {
                this.attrs.put(attrs.getQName(i), attrs.getValue(i));
            }
        }
    }

    public String consumeContent(boolean required) throws ParseException {
        return consume(null, required);
    }

    public String consume(String name, boolean required) throws ParseException {
        if (name != null) {
            String value = (String) this.attrs.get(name);
            if (value != null) {
                this.attrs.remove(name);
                return value;
            } else if (!required) {
                return null;
            } else {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.missingAttribute);
                pe.setInternalReason("Missing attribute: '" + name + "'");
                throw pe;
            }
        } else if (this.content == null && required) {
            throw new ParseException(CoreErrorDomain.ERR.missingRequiredContent);
        } else {
            this.contentConsumed = true;
            return this.content;
        }
    }

    public byte consumeByte(String name, boolean required, byte defaultValue) throws ParseException {
        String value = consume(name, required);
        if (value != null) {
            try {
                defaultValue = Byte.parseByte(value);
            } catch (NumberFormatException e) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidByteAttribute);
                pe.setInternalReason("Invalid byte value for attribute: '" + name + "'");
                throw pe;
            }
        }
        return defaultValue;
    }

    public byte consumeByte(String name, boolean required) throws ParseException {
        return consumeByte(name, required, (byte) 0);
    }

    public short consumeShort(String name, boolean required, short defaultValue) throws ParseException {
        String value = consume(name, required);
        if (value != null) {
            try {
                defaultValue = Short.parseShort(value);
            } catch (NumberFormatException e) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidShortAttribute);
                pe.setInternalReason("Invalid short value for attribute: '" + name + "'");
                throw pe;
            }
        }
        return defaultValue;
    }

    public short consumeShort(String name, boolean required) throws ParseException {
        return consumeShort(name, required, (short) 0);
    }

    public int consumeInteger(String name, boolean required, int defaultValue) throws ParseException {
        String value = consume(name, required);
        if (value != null) {
            try {
                defaultValue = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidIntegerAttribute);
                pe.setInternalReason("Invalid integer value for attribute: '" + name + "'");
                throw pe;
            }
        }
        return defaultValue;
    }

    public int consumeInteger(String name, boolean required) throws ParseException {
        return consumeInteger(name, required, 0);
    }

    public long consumeLong(String name, boolean required, long defaultValue) throws ParseException {
        String value = consume(name, required);
        if (value != null) {
            try {
                defaultValue = Long.parseLong(value);
            } catch (Throwable e) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidLongAttribute, e);
                pe.setInternalReason("Invalid long value for attribute: '" + name + "'");
                throw pe;
            }
        }
        return defaultValue;
    }

    public long consumeLong(String name, boolean required) throws ParseException {
        return consumeLong(name, required, 0);
    }

    public BigInteger consumeBigInteger(String name, boolean required, BigInteger defaultValue) throws ParseException {
        String value = consume(name, required);
        if (value != null) {
            try {
                defaultValue = new BigInteger(value);
            } catch (NumberFormatException e) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidBigIntegerAttribute);
                pe.setInternalReason("Invalid big integer value for attribute: '" + name + "'");
                throw pe;
            }
        }
        return defaultValue;
    }

    public BigInteger consumeBigInteger(String name, boolean required) throws ParseException {
        return consumeBigInteger(name, required, BigInteger.ZERO);
    }

    public BigDecimal consumeBigDecimal(String name, boolean required, BigDecimal defaultValue) throws ParseException {
        String value = consume(name, required);
        if (value != null) {
            try {
                defaultValue = new BigDecimal(value);
            } catch (NumberFormatException e) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidBigDecimalAttribute);
                pe.setInternalReason("Invalid big decimal value for attribute: '" + name + "'");
                throw pe;
            }
        }
        return defaultValue;
    }

    public BigDecimal consumeBigDecimal(String name, boolean required) throws ParseException {
        return consumeBigDecimal(name, required, BigDecimal.ZERO);
    }

    public double consumeDouble(String name, boolean required, double defaultValue) throws ParseException {
        String value = consume(name, required);
        if (value == null) {
            return defaultValue;
        }
        if ("INF".equals(value)) {
            return Double.POSITIVE_INFINITY;
        }
        if ("-INF".equals(value)) {
            return Double.NEGATIVE_INFINITY;
        }
        try {
            return Double.parseDouble(value);
        } catch (Throwable e) {
            ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidDoubleAttribute, e);
            pe.setInternalReason("Invalid double value for attribute: '" + name + "'");
            throw pe;
        }
    }

    public double consumeDouble(String name, boolean required) throws ParseException {
        return consumeDouble(name, required, 0.0d);
    }

    public float consumeFloat(String name, boolean required, float defaultValue) throws ParseException {
        String value = consume(name, required);
        if (value == null) {
            return defaultValue;
        }
        if ("INF".equals(value)) {
            return Float.POSITIVE_INFINITY;
        }
        if ("-INF".equals(value)) {
            return Float.NEGATIVE_INFINITY;
        }
        try {
            return Float.parseFloat(value);
        } catch (Throwable e) {
            ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidFloatAttribute, e);
            pe.setInternalReason("Invalid float value for attribute: '" + name + "'");
            throw pe;
        }
    }

    public float consumeFloat(String name, boolean required) throws ParseException {
        return consumeFloat(name, required, 0.0f);
    }

    public boolean consumeBoolean(String name, boolean required, boolean defaultValue) throws ParseException {
        String value = consume(name, required);
        if (value == null) {
            return defaultValue;
        }
        if ("true".equals(value) || "1".equals(value)) {
            return true;
        }
        if ("false".equals(value) || "0".equals(value)) {
            return false;
        }
        ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidBooleanAttribute);
        pe.setInternalReason("Invalid boolean value for attribute: '" + name + "'");
        throw pe;
    }

    public boolean consumeBoolean(String name, boolean required) throws ParseException {
        return consumeBoolean(name, required, false);
    }

    public DateTime consumeDateTime(String name, boolean required) throws ParseException {
        String value = consume(name, required);
        if (value == null) {
            return null;
        }
        try {
            return DateTime.parseDateTimeChoice(value);
        } catch (Throwable e) {
            ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidDatetime, e);
            pe.setInternalReason("Badly formatted datetime in attribute: " + name);
            throw pe;
        }
    }

    public <T extends Enum<T>> T consumeEnum(String name, boolean required, Class<T> enumClass, T defaultValue, EnumToAttributeValue<T> enumToAttributeValue) throws ParseException {
        String value = consume(name, required);
        if (value == null) {
            return defaultValue;
        }
        for (T enumValue : (Enum[]) enumClass.getEnumConstants()) {
            if (enumToAttributeValue.getAttributeValue(enumValue).equals(value)) {
                return enumValue;
            }
        }
        ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidAttributeValue);
        pe.setInternalReason("Invalid value for attribute : '" + name + "'");
        throw pe;
    }

    public <T extends Enum<T>> T consumeEnum(String name, boolean required, Class<T> enumClass, T defaultValue) throws ParseException {
        String value = consume(name, required);
        if (value != null) {
            try {
                defaultValue = Enum.valueOf(enumClass, value.toUpperCase());
            } catch (Throwable e) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidAttributeValue, e);
                pe.setInternalReason("Invalid value for attribute : '" + name + "'");
                throw pe;
            }
        }
        return defaultValue;
    }

    public <T extends Enum<T>> T consumeEnum(String name, boolean required, Class<T> enumClass) throws ParseException {
        return consumeEnum(name, required, enumClass, null);
    }

    public void assertAllConsumed() throws ParseException {
        StringBuffer message = new StringBuffer();
        if (!this.attrs.isEmpty()) {
            message.append("Unknown attribute");
            if (this.attrs.size() > 1) {
                message.append('s');
            }
            message.append(':');
            for (String name : this.attrs.keySet()) {
                message.append(" '");
                message.append(name);
                message.append("' ");
            }
        }
        if (!this.dups.isEmpty()) {
            message.append("Duplicate attribute");
            if (this.dups.size() > 1) {
                message.append('s');
            }
            message.append(':');
            for (String dup : this.dups) {
                message.append(" '");
                message.append(dup);
                message.append("' ");
            }
        }
        if (!(this.contentConsumed || this.content == null || this.content.length() == 0)) {
            message.append("Unexpected text content ");
        }
        if (message.length() != 0) {
            throw new ParseException(message.toString());
        }
    }

    void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
