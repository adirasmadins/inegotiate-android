package com.amazonaws.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.util.DateUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleTypeJsonUnmarshallers {
    private static DateUtils dateUtils;
    private static Log log;

    public static class BigDecimalJsonUnmarshaller implements Unmarshaller<BigDecimal, JsonUnmarshallerContext> {
        private static BigDecimalJsonUnmarshaller instance;

        public static BigDecimalJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigDecimalJsonUnmarshaller();
            }
            return instance;
        }

        public BigDecimal unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String readText = jsonUnmarshallerContext.readText();
            return readText == null ? null : new BigDecimal(readText);
        }
    }

    public static class BigIntegerJsonUnmarshaller implements Unmarshaller<BigInteger, JsonUnmarshallerContext> {
        private static BigIntegerJsonUnmarshaller instance;

        public static BigIntegerJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigIntegerJsonUnmarshaller();
            }
            return instance;
        }

        public BigInteger unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String readText = jsonUnmarshallerContext.readText();
            return readText == null ? null : new BigInteger(readText);
        }
    }

    public static class BooleanJsonUnmarshaller implements Unmarshaller<Boolean, JsonUnmarshallerContext> {
        private static BooleanJsonUnmarshaller instance;

        public static BooleanJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BooleanJsonUnmarshaller();
            }
            return instance;
        }

        public Boolean unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String readText = jsonUnmarshallerContext.readText();
            return readText == null ? null : Boolean.valueOf(Boolean.parseBoolean(readText));
        }
    }

    public static class ByteBufferJsonUnmarshaller implements Unmarshaller<ByteBuffer, JsonUnmarshallerContext> {
        private static ByteBufferJsonUnmarshaller instance;

        public static ByteBufferJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteBufferJsonUnmarshaller();
            }
            return instance;
        }

        public ByteBuffer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String readText = jsonUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            try {
                return ByteBuffer.wrap(Base64.decodeBase64(readText.getBytes(StringEncodings.UTF8)));
            } catch (Throwable e) {
                throw new AmazonClientException("Unable to unmarshall XML data into a ByteBuffer", e);
            }
        }
    }

    public static class ByteJsonUnmarshaller implements Unmarshaller<Byte, JsonUnmarshallerContext> {
        private static ByteJsonUnmarshaller instance;

        public static ByteJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteJsonUnmarshaller();
            }
            return instance;
        }

        public Byte unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String readText = jsonUnmarshallerContext.readText();
            return readText == null ? null : Byte.valueOf(readText);
        }
    }

    public static class DateJsonUnmarshaller implements Unmarshaller<Date, JsonUnmarshallerContext> {
        private static DateJsonUnmarshaller instance;

        public static DateJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DateJsonUnmarshaller();
            }
            return instance;
        }

        public Date unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String readText = jsonUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            try {
                return new Date(DecimalFormat.getInstance(new Locale("en")).parse(readText).longValue() * 1000);
            } catch (Throwable e) {
                throw new AmazonClientException("Unable to parse date '" + readText + "':  " + e.getMessage(), e);
            }
        }
    }

    public static class DoubleJsonUnmarshaller implements Unmarshaller<Double, JsonUnmarshallerContext> {
        private static DoubleJsonUnmarshaller instance;

        public static DoubleJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DoubleJsonUnmarshaller();
            }
            return instance;
        }

        public Double unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String readText = jsonUnmarshallerContext.readText();
            return readText == null ? null : Double.valueOf(Double.parseDouble(readText));
        }
    }

    public static class FloatJsonUnmarshaller implements Unmarshaller<Float, JsonUnmarshallerContext> {
        private static FloatJsonUnmarshaller instance;

        public static FloatJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new FloatJsonUnmarshaller();
            }
            return instance;
        }

        public Float unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String readText = jsonUnmarshallerContext.readText();
            return readText == null ? null : Float.valueOf(readText);
        }
    }

    public static class IntegerJsonUnmarshaller implements Unmarshaller<Integer, JsonUnmarshallerContext> {
        private static IntegerJsonUnmarshaller instance;

        public static IntegerJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new IntegerJsonUnmarshaller();
            }
            return instance;
        }

        public Integer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String readText = jsonUnmarshallerContext.readText();
            return readText == null ? null : Integer.valueOf(Integer.parseInt(readText));
        }
    }

    public static class LongJsonUnmarshaller implements Unmarshaller<Long, JsonUnmarshallerContext> {
        private static LongJsonUnmarshaller instance;

        public static LongJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new LongJsonUnmarshaller();
            }
            return instance;
        }

        public Long unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String readText = jsonUnmarshallerContext.readText();
            return readText == null ? null : Long.valueOf(Long.parseLong(readText));
        }
    }

    public static class StringJsonUnmarshaller implements Unmarshaller<String, JsonUnmarshallerContext> {
        private static StringJsonUnmarshaller instance;

        public static StringJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new StringJsonUnmarshaller();
            }
            return instance;
        }

        public String unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            return jsonUnmarshallerContext.readText();
        }
    }

    static {
        dateUtils = new DateUtils();
        log = LogFactory.getLog(SimpleTypeJsonUnmarshallers.class);
    }
}
