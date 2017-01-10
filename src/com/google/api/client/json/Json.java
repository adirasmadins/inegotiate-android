package com.google.api.client.json;

import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.DataUtil;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.paypal.android.MEP.PayPalActivity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.impl.JsonWriteContext;

public class Json {
    public static final String CONTENT_TYPE = "application/json";
    public static final JsonFactory JSON_FACTORY;

    /* renamed from: com.google.api.client.json.Json.1 */
    static /* synthetic */ class C03291 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$JsonToken;

        static {
            $SwitchMap$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.START_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.START_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NULL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    static {
        JSON_FACTORY = new JsonFactory().configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true).configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
    }

    public static String toString(Object item) {
        OutputStream byteStream = new ByteArrayOutputStream();
        JsonGenerator generator;
        try {
            generator = JSON_FACTORY.createJsonGenerator(byteStream, JsonEncoding.UTF8);
            serialize(generator, item);
            generator.close();
        } catch (IOException e) {
            e.printStackTrace(new PrintStream(byteStream));
        } catch (Throwable th) {
            generator.close();
        }
        return byteStream.toString();
    }

    public static void serialize(JsonGenerator generator, Object value) throws IOException {
        if (value == null) {
            generator.writeNull();
        }
        if ((value instanceof String) || (value instanceof Long) || (value instanceof Double) || (value instanceof BigInteger) || (value instanceof BigDecimal)) {
            generator.writeString(value.toString());
        } else if (value instanceof Boolean) {
            generator.writeBoolean(((Boolean) value).booleanValue());
        } else if ((value instanceof Integer) || (value instanceof Short) || (value instanceof Byte)) {
            generator.writeNumber(((Number) value).intValue());
        } else if (value instanceof Float) {
            generator.writeNumber(((Float) value).floatValue());
        } else if (value instanceof DateTime) {
            generator.writeString(((DateTime) value).toStringRfc3339());
        } else if (value instanceof List) {
            generator.writeStartArray();
            List<Object> listValue = (List) value;
            int size = listValue.size();
            for (int i = 0; i < size; i++) {
                serialize(generator, listValue.get(i));
            }
            generator.writeEndArray();
        } else {
            generator.writeStartObject();
            for (Entry<String, Object> entry : DataUtil.mapOf(value).entrySet()) {
                Object fieldValue = entry.getValue();
                if (fieldValue != null) {
                    generator.writeFieldName((String) entry.getKey());
                    serialize(generator, fieldValue);
                }
            }
            generator.writeEndObject();
        }
    }

    public static <T> T parseAndClose(JsonParser parser, Class<T> destinationClass, CustomizeJsonParser customizeParser) throws IOException {
        Object newInstance = ClassInfo.newInstance(destinationClass);
        parseAndClose(parser, newInstance, customizeParser);
        return newInstance;
    }

    public static void skipToKey(JsonParser parser, String keyToFind) throws IOException {
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String key = parser.getCurrentName();
            parser.nextToken();
            if (!keyToFind.equals(key)) {
                parser.skipChildren();
            } else {
                return;
            }
        }
    }

    public static void parseAndClose(JsonParser parser, Object destination, CustomizeJsonParser customizeParser) throws IOException {
        try {
            parse(parser, destination, customizeParser);
        } finally {
            parser.close();
        }
    }

    public static <T> T parse(JsonParser parser, Class<T> destinationClass, CustomizeJsonParser customizeParser) throws IOException {
        Object newInstance = ClassInfo.newInstance(destinationClass);
        parse(parser, newInstance, customizeParser);
        return newInstance;
    }

    public static void parse(JsonParser parser, Object destination, CustomizeJsonParser customizeParser) throws IOException {
        Class<?> destinationClass = destination.getClass();
        ClassInfo classInfo = ClassInfo.of(destinationClass);
        boolean isGenericData = GenericData.class.isAssignableFrom(destinationClass);
        if (isGenericData || !Map.class.isAssignableFrom(destinationClass)) {
            while (parser.nextToken() != JsonToken.END_OBJECT) {
                String key = parser.getCurrentName();
                JsonToken curToken = parser.nextToken();
                if (customizeParser == null || !customizeParser.stopAt(destination, key)) {
                    FieldInfo fieldInfo = classInfo.getFieldInfo(key);
                    if (fieldInfo != null) {
                        if (!fieldInfo.isFinal || fieldInfo.isPrimitive) {
                            Field field = fieldInfo.field;
                            FieldInfo.setFieldValue(field, destination, parseValue(parser, curToken, field, fieldInfo.type, destination, customizeParser));
                        } else {
                            throw new IllegalArgumentException("final array/object fields are not supported");
                        }
                    } else if (isGenericData) {
                        GenericData genericData = (GenericData) destination;
                        object.set(key, parseValue(parser, curToken, null, null, destination, customizeParser));
                    } else {
                        if (customizeParser != null) {
                            customizeParser.handleUnrecognizedKey(destination, key);
                        }
                        parser.skipChildren();
                    }
                } else {
                    return;
                }
            }
            return;
        }
        parseMap(parser, (Map) destination, ClassInfo.getMapValueParameter(destinationClass.getGenericSuperclass()), customizeParser);
    }

    public static <T> Collection<T> parseArrayAndClose(JsonParser parser, Class<?> destinationCollectionClass, Class<T> destinationItemClass, CustomizeJsonParser customizeParser) throws IOException {
        try {
            Collection<T> parseArray = parseArray(parser, (Class) destinationCollectionClass, (Class) destinationItemClass, customizeParser);
            return parseArray;
        } finally {
            parser.close();
        }
    }

    public static <T> void parseArrayAndClose(JsonParser parser, Collection<? super T> destinationCollection, Class<T> destinationItemClass, CustomizeJsonParser customizeParser) throws IOException {
        try {
            parseArray(parser, (Collection) destinationCollection, (Class) destinationItemClass, customizeParser);
        } finally {
            parser.close();
        }
    }

    public static <T> Collection<T> parseArray(JsonParser parser, Class<?> destinationCollectionClass, Class<T> destinationItemClass, CustomizeJsonParser customizeParser) throws IOException {
        Collection destinationCollection = ClassInfo.newCollectionInstance(destinationCollectionClass);
        parseArray(parser, destinationCollection, (Class) destinationItemClass, customizeParser);
        return destinationCollection;
    }

    public static <T> void parseArray(JsonParser parser, Collection<? super T> destinationCollection, Class<T> destinationItemClass, CustomizeJsonParser customizeParser) throws IOException {
        while (true) {
            JsonToken listToken = parser.nextToken();
            if (listToken != JsonToken.END_ARRAY) {
                destinationCollection.add(parseValue(parser, listToken, null, destinationItemClass, destinationCollection, customizeParser));
            } else {
                return;
            }
        }
    }

    private static void parseMap(JsonParser parser, Map<String, Object> destinationMap, Class<?> valueClass, CustomizeJsonParser customizeParser) throws IOException {
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String key = parser.getCurrentName();
            JsonToken curToken = parser.nextToken();
            if (customizeParser == null || !customizeParser.stopAt(destinationMap, key)) {
                destinationMap.put(key, parseValue(parser, curToken, null, valueClass, destinationMap, customizeParser));
            } else {
                return;
            }
        }
    }

    private static Object parseValue(JsonParser parser, JsonToken token, Field field, Class<?> fieldClass, Object destination, CustomizeJsonParser customizeParser) throws IOException {
        switch (C03291.$SwitchMap$org$codehaus$jackson$JsonToken[token.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                if (fieldClass == null || Collection.class.isAssignableFrom(fieldClass)) {
                    Collection collectionValue = null;
                    if (!(customizeParser == null || field == null)) {
                        collectionValue = customizeParser.newInstanceForArray(destination, field);
                    }
                    if (collectionValue == null) {
                        collectionValue = ClassInfo.newCollectionInstance(fieldClass);
                    }
                    parseArray(parser, collectionValue, ClassInfo.getCollectionParameter(field), customizeParser);
                    return collectionValue;
                }
                throw new IllegalArgumentException("expected field type that implements Collection but got " + fieldClass + " for field " + field);
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                Object obj;
                Object newInstance = null;
                boolean isMap = fieldClass == null || Map.class.isAssignableFrom(fieldClass);
                if (!(fieldClass == null || customizeParser == null)) {
                    newInstance = customizeParser.newInstanceForObject(destination, fieldClass);
                }
                if (newInstance != null) {
                    obj = newInstance;
                } else if (isMap) {
                    obj = ClassInfo.newMapInstance(fieldClass);
                } else {
                    obj = ClassInfo.newInstance(fieldClass);
                }
                if (isMap && fieldClass != null) {
                    Class<?> valueClass;
                    if (field != null) {
                        valueClass = ClassInfo.getMapValueParameter(field);
                    } else {
                        valueClass = ClassInfo.getMapValueParameter(fieldClass.getGenericSuperclass());
                    }
                    if (valueClass != null) {
                        parseMap(parser, (Map) obj, valueClass, customizeParser);
                        return obj;
                    }
                }
                parse(parser, obj, customizeParser);
                return obj;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                if (fieldClass == null || fieldClass == Boolean.class || fieldClass == Boolean.TYPE) {
                    return token == JsonToken.VALUE_TRUE ? Boolean.TRUE : Boolean.FALSE;
                } else {
                    throw new IllegalArgumentException(parser.getCurrentName() + ": expected type Boolean or boolean but got " + fieldClass + " for field " + field);
                }
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                if (fieldClass == null || fieldClass == Float.class || fieldClass == Float.TYPE) {
                    return Float.valueOf(parser.getFloatValue());
                }
                throw new IllegalArgumentException(parser.getCurrentName() + ": expected type Float or float but got " + fieldClass + " for field " + field);
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                if (fieldClass == null || fieldClass == Integer.class || fieldClass == Integer.TYPE) {
                    return Integer.valueOf(parser.getIntValue());
                }
                if (fieldClass == Short.class || fieldClass == Short.TYPE) {
                    return Short.valueOf(parser.getShortValue());
                }
                if (fieldClass == Byte.class || fieldClass == Byte.TYPE) {
                    return Byte.valueOf(parser.getByteValue());
                }
                throw new IllegalArgumentException(parser.getCurrentName() + ": expected type Integer/int/Short/short/Byte/byte but got " + fieldClass + " for field " + field);
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
                try {
                    return FieldInfo.parsePrimitiveValue(fieldClass, parser.getText());
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(parser.getCurrentName() + " for field " + field, e);
                }
            case PayPalActivity.VIEW_TEST /*8*/:
                return null;
            default:
                throw new IllegalArgumentException(parser.getCurrentName() + ": unexpected JSON node type: " + token);
        }
    }
}
