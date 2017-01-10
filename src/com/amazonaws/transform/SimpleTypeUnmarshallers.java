package com.amazonaws.transform;

import com.amazonaws.util.XpathUtils;
import java.nio.ByteBuffer;
import java.util.Date;
import org.w3c.dom.Node;

public class SimpleTypeUnmarshallers {

    public static class BooleanUnmarshaller implements Unmarshaller<Boolean, Node> {
        private static BooleanUnmarshaller instance;

        public static BooleanUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BooleanUnmarshaller();
            }
            return instance;
        }

        public Boolean unmarshall(Node node) throws Exception {
            return XpathUtils.asBoolean(".", node);
        }
    }

    public static class ByteBufferUnmarshaller implements Unmarshaller<ByteBuffer, Node> {
        private static ByteBufferUnmarshaller instance;

        public static ByteBufferUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteBufferUnmarshaller();
            }
            return instance;
        }

        public ByteBuffer unmarshall(Node node) throws Exception {
            return XpathUtils.asByteBuffer(".", node);
        }
    }

    public static class ByteUnmarshaller implements Unmarshaller<Byte, Node> {
        private static ByteUnmarshaller instance;

        public static ByteUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteUnmarshaller();
            }
            return instance;
        }

        public Byte unmarshall(Node node) throws Exception {
            return XpathUtils.asByte(".", node);
        }
    }

    public static class DateUnmarshaller implements Unmarshaller<Date, Node> {
        private static DateUnmarshaller instance;

        public static DateUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DateUnmarshaller();
            }
            return instance;
        }

        public Date unmarshall(Node node) throws Exception {
            return XpathUtils.asDate(".", node);
        }
    }

    public static class DoubleUnmarshaller implements Unmarshaller<Double, Node> {
        private static DoubleUnmarshaller instance;

        public static DoubleUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DoubleUnmarshaller();
            }
            return instance;
        }

        public Double unmarshall(Node node) throws Exception {
            return XpathUtils.asDouble(".", node);
        }
    }

    public static class FloatUnmarshaller implements Unmarshaller<Float, Node> {
        private static FloatUnmarshaller instance;

        public static FloatUnmarshaller getInstance() {
            if (instance == null) {
                instance = new FloatUnmarshaller();
            }
            return instance;
        }

        public Float unmarshall(Node node) throws Exception {
            return XpathUtils.asFloat(".", node);
        }
    }

    public static class IntegerUnmarshaller implements Unmarshaller<Integer, Node> {
        private static IntegerUnmarshaller instance;

        public static IntegerUnmarshaller getInstance() {
            if (instance == null) {
                instance = new IntegerUnmarshaller();
            }
            return instance;
        }

        public Integer unmarshall(Node node) throws Exception {
            return XpathUtils.asInteger(".", node);
        }
    }

    public static class LongUnmarshaller implements Unmarshaller<Long, Node> {
        private static LongUnmarshaller instance;

        public static LongUnmarshaller getInstance() {
            if (instance == null) {
                instance = new LongUnmarshaller();
            }
            return instance;
        }

        public Long unmarshall(Node node) throws Exception {
            return XpathUtils.asLong(".", node);
        }
    }

    public static class StringUnmarshaller implements Unmarshaller<String, Node> {
        private static StringUnmarshaller instance;

        public static StringUnmarshaller getInstance() {
            if (instance == null) {
                instance = new StringUnmarshaller();
            }
            return instance;
        }

        public String unmarshall(Node node) throws Exception {
            return XpathUtils.asString(".", node);
        }
    }
}
