package com.google.protobuf;

import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.MessageLite.Builder;
import com.google.protobuf.WireFormat.FieldType;
import com.google.protobuf.WireFormat.JavaType;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;

final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private static final FieldSet DEFAULT_INSTANCE;
    private final SmallSortedMap<FieldDescriptorType, Object> fields;
    private boolean isImmutable;

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        EnumLiteMap<?> getEnumType();

        JavaType getLiteJavaType();

        FieldType getLiteType();

        int getNumber();

        Builder internalMergeFrom(Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    /* renamed from: com.google.protobuf.FieldSet.1 */
    static /* synthetic */ class C08471 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[FieldType.values().length];
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT32.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT64.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = new int[JavaType.values().length];
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError e26) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError e27) {
            }
        }
    }

    private FieldSet() {
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    private FieldSet(boolean dummy) {
        this.fields = SmallSortedMap.newFieldMap(0);
        makeImmutable();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    static {
        DEFAULT_INSTANCE = new FieldSet(true);
    }

    public void makeImmutable() {
        if (!this.isImmutable) {
            this.fields.makeImmutable();
            this.isImmutable = true;
        }
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public FieldSet<FieldDescriptorType> clone() {
        FieldSet<FieldDescriptorType> clone = newFieldSet();
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Entry<FieldDescriptorType, Object> entry = this.fields.getArrayEntryAt(i);
            clone.setField((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        for (Entry<FieldDescriptorType, Object> entry2 : this.fields.getOverflowEntries()) {
            clone.setField((FieldDescriptorLite) entry2.getKey(), entry2.getValue());
        }
        return clone;
    }

    public void clear() {
        this.fields.clear();
    }

    public Map<FieldDescriptorType, Object> getAllFields() {
        return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
    }

    public Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        return this.fields.entrySet().iterator();
    }

    public boolean hasField(FieldDescriptorType descriptor) {
        if (!descriptor.isRepeated()) {
            return this.fields.get(descriptor) != null;
        } else {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
    }

    public Object getField(FieldDescriptorType descriptor) {
        return this.fields.get(descriptor);
    }

    public void setField(FieldDescriptorType descriptor, Object value) {
        if (!descriptor.isRepeated()) {
            verifyType(descriptor.getLiteType(), value);
        } else if (value instanceof List) {
            List<Object> newList = new ArrayList();
            newList.addAll((List) value);
            for (Object element : newList) {
                verifyType(descriptor.getLiteType(), element);
            }
            value = newList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        this.fields.put((Comparable) descriptor, value);
    }

    public void clearField(FieldDescriptorType descriptor) {
        this.fields.remove(descriptor);
    }

    public int getRepeatedFieldCount(FieldDescriptorType descriptor) {
        if (descriptor.isRepeated()) {
            Object value = this.fields.get(descriptor);
            if (value == null) {
                return 0;
            }
            return ((List) value).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public Object getRepeatedField(FieldDescriptorType descriptor, int index) {
        if (descriptor.isRepeated()) {
            Object value = this.fields.get(descriptor);
            if (value != null) {
                return ((List) value).get(index);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void setRepeatedField(FieldDescriptorType descriptor, int index, Object value) {
        if (descriptor.isRepeated()) {
            Object list = this.fields.get(descriptor);
            if (list == null) {
                throw new IndexOutOfBoundsException();
            }
            verifyType(descriptor.getLiteType(), value);
            ((List) list).set(index, value);
            return;
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void addRepeatedField(FieldDescriptorType descriptor, Object value) {
        if (descriptor.isRepeated()) {
            List list;
            verifyType(descriptor.getLiteType(), value);
            Object existingValue = this.fields.get(descriptor);
            if (existingValue == null) {
                list = new ArrayList();
                this.fields.put((Comparable) descriptor, (Object) list);
            } else {
                list = (List) existingValue;
            }
            list.add(value);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    private static void verifyType(FieldType type, Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        boolean isValid = false;
        switch (C08471.$SwitchMap$com$google$protobuf$WireFormat$JavaType[type.getJavaType().ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                isValid = value instanceof Integer;
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                isValid = value instanceof Long;
                break;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                isValid = value instanceof Float;
                break;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                isValid = value instanceof Double;
                break;
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                isValid = value instanceof Boolean;
                break;
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                isValid = value instanceof String;
                break;
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
                isValid = value instanceof ByteString;
                break;
            case PayPalActivity.VIEW_TEST /*8*/:
                isValid = value instanceof EnumLite;
                break;
            case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                isValid = value instanceof MessageLite;
                break;
        }
        if (!isValid) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public boolean isInitialized() {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            if (!isInitialized(this.fields.getArrayEntryAt(i))) {
                return false;
            }
        }
        for (Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            if (!isInitialized(entry)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInitialized(Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite descriptor = (FieldDescriptorLite) entry.getKey();
        if (descriptor.getLiteJavaType() == JavaType.MESSAGE) {
            if (descriptor.isRepeated()) {
                for (MessageLite element : (List) entry.getValue()) {
                    if (!element.isInitialized()) {
                        return false;
                    }
                }
            } else if (!((MessageLite) entry.getValue()).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    static int getWireFormatForFieldType(FieldType type, boolean isPacked) {
        if (isPacked) {
            return 2;
        }
        return type.getWireType();
    }

    public void mergeFrom(FieldSet<FieldDescriptorType> other) {
        for (int i = 0; i < other.fields.getNumArrayEntries(); i++) {
            mergeFromField(other.fields.getArrayEntryAt(i));
        }
        for (Entry<FieldDescriptorType, Object> entry : other.fields.getOverflowEntries()) {
            mergeFromField(entry);
        }
    }

    private void mergeFromField(Entry<FieldDescriptorType, Object> entry) {
        Comparable descriptor = (FieldDescriptorLite) entry.getKey();
        Object otherValue = entry.getValue();
        Object value;
        if (descriptor.isRepeated()) {
            value = this.fields.get(descriptor);
            if (value == null) {
                this.fields.put(descriptor, new ArrayList((List) otherValue));
            } else {
                ((List) value).addAll((List) otherValue);
            }
        } else if (descriptor.getLiteJavaType() == JavaType.MESSAGE) {
            value = this.fields.get(descriptor);
            if (value == null) {
                this.fields.put(descriptor, otherValue);
            } else {
                this.fields.put(descriptor, descriptor.internalMergeFrom(((MessageLite) value).toBuilder(), (MessageLite) otherValue).build());
            }
        } else {
            this.fields.put(descriptor, otherValue);
        }
    }

    public static Object readPrimitiveField(CodedInputStream input, FieldType type) throws IOException {
        switch (C08471.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return Double.valueOf(input.readDouble());
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return Float.valueOf(input.readFloat());
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return Long.valueOf(input.readInt64());
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                return Long.valueOf(input.readUInt64());
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                return Integer.valueOf(input.readInt32());
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                return Long.valueOf(input.readFixed64());
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
                return Integer.valueOf(input.readFixed32());
            case PayPalActivity.VIEW_TEST /*8*/:
                return Boolean.valueOf(input.readBool());
            case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                return input.readString();
            case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                return input.readBytes();
            case PayPal.PAYMENT_SUBTYPE_REMITTANCES /*11*/:
                return Integer.valueOf(input.readUInt32());
            case PayPal.PAYMENT_SUBTYPE_RENT /*12*/:
                return Integer.valueOf(input.readSFixed32());
            case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                return Long.valueOf(input.readSFixed64());
            case PayPal.PAYMENT_SUBTYPE_MEDICAL /*14*/:
                return Integer.valueOf(input.readSInt32());
            case PayPal.PAYMENT_SUBTYPE_CHILDCARE /*15*/:
                return Long.valueOf(input.readSInt64());
            case Segment.TOKENS_PER_SEGMENT /*16*/:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case PayPal.PAYMENT_SUBTYPE_CONTRACTORS /*17*/:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Entry<FieldDescriptorType, Object> entry = this.fields.getArrayEntryAt(i);
            writeField((FieldDescriptorLite) entry.getKey(), entry.getValue(), output);
        }
        for (Entry<FieldDescriptorType, Object> entry2 : this.fields.getOverflowEntries()) {
            writeField((FieldDescriptorLite) entry2.getKey(), entry2.getValue(), output);
        }
    }

    public void writeMessageSetTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            writeMessageSetTo(this.fields.getArrayEntryAt(i), output);
        }
        for (Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            writeMessageSetTo(entry, output);
        }
    }

    private void writeMessageSetTo(Entry<FieldDescriptorType, Object> entry, CodedOutputStream output) throws IOException {
        FieldDescriptorLite descriptor = (FieldDescriptorLite) entry.getKey();
        if (descriptor.getLiteJavaType() != JavaType.MESSAGE || descriptor.isRepeated() || descriptor.isPacked()) {
            writeField(descriptor, entry.getValue(), output);
        } else {
            output.writeMessageSetExtension(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) entry.getValue());
        }
    }

    private static void writeElement(CodedOutputStream output, FieldType type, int number, Object value) throws IOException {
        if (type == FieldType.GROUP) {
            output.writeGroup(number, (MessageLite) value);
            return;
        }
        output.writeTag(number, getWireFormatForFieldType(type, false));
        writeElementNoTag(output, type, value);
    }

    private static void writeElementNoTag(CodedOutputStream output, FieldType type, Object value) throws IOException {
        switch (C08471.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                output.writeDoubleNoTag(((Double) value).doubleValue());
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                output.writeFloatNoTag(((Float) value).floatValue());
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                output.writeInt64NoTag(((Long) value).longValue());
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                output.writeUInt64NoTag(((Long) value).longValue());
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                output.writeInt32NoTag(((Integer) value).intValue());
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                output.writeFixed64NoTag(((Long) value).longValue());
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
                output.writeFixed32NoTag(((Integer) value).intValue());
            case PayPalActivity.VIEW_TEST /*8*/:
                output.writeBoolNoTag(((Boolean) value).booleanValue());
            case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                output.writeStringNoTag((String) value);
            case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                output.writeBytesNoTag((ByteString) value);
            case PayPal.PAYMENT_SUBTYPE_REMITTANCES /*11*/:
                output.writeUInt32NoTag(((Integer) value).intValue());
            case PayPal.PAYMENT_SUBTYPE_RENT /*12*/:
                output.writeSFixed32NoTag(((Integer) value).intValue());
            case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                output.writeSFixed64NoTag(((Long) value).longValue());
            case PayPal.PAYMENT_SUBTYPE_MEDICAL /*14*/:
                output.writeSInt32NoTag(((Integer) value).intValue());
            case PayPal.PAYMENT_SUBTYPE_CHILDCARE /*15*/:
                output.writeSInt64NoTag(((Long) value).longValue());
            case Segment.TOKENS_PER_SEGMENT /*16*/:
                output.writeGroupNoTag((MessageLite) value);
            case PayPal.PAYMENT_SUBTYPE_CONTRACTORS /*17*/:
                output.writeMessageNoTag((MessageLite) value);
            case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                output.writeEnumNoTag(((EnumLite) value).getNumber());
            default:
        }
    }

    public static void writeField(FieldDescriptorLite<?> descriptor, Object value, CodedOutputStream output) throws IOException {
        FieldType type = descriptor.getLiteType();
        int number = descriptor.getNumber();
        if (descriptor.isRepeated()) {
            List<?> valueList = (List) value;
            if (descriptor.isPacked()) {
                output.writeTag(number, 2);
                int dataSize = 0;
                for (Object element : valueList) {
                    dataSize += computeElementSizeNoTag(type, element);
                }
                output.writeRawVarint32(dataSize);
                for (Object element2 : valueList) {
                    writeElementNoTag(output, type, element2);
                }
                return;
            }
            for (Object element22 : valueList) {
                writeElement(output, type, number, element22);
            }
            return;
        }
        writeElement(output, type, number, value);
    }

    public int getSerializedSize() {
        int size = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Entry<FieldDescriptorType, Object> entry = this.fields.getArrayEntryAt(i);
            size += computeFieldSize((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        for (Entry<FieldDescriptorType, Object> entry2 : this.fields.getOverflowEntries()) {
            size += computeFieldSize((FieldDescriptorLite) entry2.getKey(), entry2.getValue());
        }
        return size;
    }

    public int getMessageSetSerializedSize() {
        int size = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            size += getMessageSetSerializedSize(this.fields.getArrayEntryAt(i));
        }
        for (Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            size += getMessageSetSerializedSize(entry);
        }
        return size;
    }

    private int getMessageSetSerializedSize(Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite descriptor = (FieldDescriptorLite) entry.getKey();
        if (descriptor.getLiteJavaType() != JavaType.MESSAGE || descriptor.isRepeated() || descriptor.isPacked()) {
            return computeFieldSize(descriptor, entry.getValue());
        }
        return CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) entry.getValue());
    }

    private static int computeElementSize(FieldType type, int number, Object value) {
        int tagSize = CodedOutputStream.computeTagSize(number);
        if (type == FieldType.GROUP) {
            tagSize *= 2;
        }
        return computeElementSizeNoTag(type, value) + tagSize;
    }

    private static int computeElementSizeNoTag(FieldType type, Object value) {
        switch (C08471.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) value).doubleValue());
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) value).floatValue());
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) value).longValue());
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) value).longValue());
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) value).intValue());
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) value).longValue());
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) value).intValue());
            case PayPalActivity.VIEW_TEST /*8*/:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) value).booleanValue());
            case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                return CodedOutputStream.computeStringSizeNoTag((String) value);
            case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
            case PayPal.PAYMENT_SUBTYPE_REMITTANCES /*11*/:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) value).intValue());
            case PayPal.PAYMENT_SUBTYPE_RENT /*12*/:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) value).intValue());
            case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) value).longValue());
            case PayPal.PAYMENT_SUBTYPE_MEDICAL /*14*/:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) value).intValue());
            case PayPal.PAYMENT_SUBTYPE_CHILDCARE /*15*/:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) value).longValue());
            case Segment.TOKENS_PER_SEGMENT /*16*/:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) value);
            case PayPal.PAYMENT_SUBTYPE_CONTRACTORS /*17*/:
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite) value);
            case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                return CodedOutputStream.computeEnumSizeNoTag(((EnumLite) value).getNumber());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> descriptor, Object value) {
        FieldType type = descriptor.getLiteType();
        int number = descriptor.getNumber();
        if (!descriptor.isRepeated()) {
            return computeElementSize(type, number, value);
        }
        if (descriptor.isPacked()) {
            int dataSize = 0;
            for (Object element : (List) value) {
                dataSize += computeElementSizeNoTag(type, element);
            }
            return (CodedOutputStream.computeTagSize(number) + dataSize) + CodedOutputStream.computeRawVarint32Size(dataSize);
        }
        int size = 0;
        for (Object element2 : (List) value) {
            size += computeElementSize(type, number, element2);
        }
        return size;
    }
}
