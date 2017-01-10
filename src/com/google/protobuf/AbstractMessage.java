package com.google.protobuf;

import com.google.gdata.util.common.base.StringUtil;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;
import com.google.protobuf.ExtensionRegistry.ExtensionInfo;
import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.UnknownFieldSet.Field;
import com.google.protobuf.WireFormat.FieldType;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.codehaus.jackson.impl.JsonWriteContext;

public abstract class AbstractMessage extends AbstractMessageLite implements Message {
    private int memoizedSize;

    /* renamed from: com.google.protobuf.AbstractMessage.1 */
    static /* synthetic */ class C08371 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        static {
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = new int[Type.values().length];
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.ENUM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static abstract class Builder<BuilderType extends Builder> extends com.google.protobuf.AbstractMessageLite.Builder<BuilderType> implements com.google.protobuf.Message.Builder {
        public abstract BuilderType clone();

        public BuilderType clear() {
            for (Entry<FieldDescriptor, Object> entry : getAllFields().entrySet()) {
                clearField((FieldDescriptor) entry.getKey());
            }
            return this;
        }

        public BuilderType mergeFrom(Message other) {
            if (other.getDescriptorForType() != getDescriptorForType()) {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
            for (Entry<FieldDescriptor, Object> entry : other.getAllFields().entrySet()) {
                FieldDescriptor field = (FieldDescriptor) entry.getKey();
                if (field.isRepeated()) {
                    for (Object element : (List) entry.getValue()) {
                        addRepeatedField(field, element);
                    }
                } else if (field.getJavaType() == JavaType.MESSAGE) {
                    Message existingValue = (Message) getField(field);
                    if (existingValue == existingValue.getDefaultInstanceForType()) {
                        setField(field, entry.getValue());
                    } else {
                        setField(field, existingValue.newBuilderForType().mergeFrom(existingValue).mergeFrom((Message) entry.getValue()).build());
                    }
                } else {
                    setField(field, entry.getValue());
                }
            }
            mergeUnknownFields(other.getUnknownFields());
            return this;
        }

        public BuilderType mergeFrom(CodedInputStream input) throws IOException {
            return mergeFrom(input, ExtensionRegistry.getEmptyRegistry());
        }

        public BuilderType mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
            int tag;
            do {
                tag = input.readTag();
                if (tag == 0) {
                    break;
                }
            } while (mergeFieldFrom(input, unknownFields, extensionRegistry, this, tag));
            setUnknownFields(unknownFields.build());
            return this;
        }

        static boolean mergeFieldFrom(CodedInputStream input, com.google.protobuf.UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, com.google.protobuf.Message.Builder builder, int tag) throws IOException {
            Descriptor type = builder.getDescriptorForType();
            if (type.getOptions().getMessageSetWireFormat() && tag == WireFormat.MESSAGE_SET_ITEM_TAG) {
                mergeMessageSetExtensionFromCodedStream(input, unknownFields, extensionRegistry, builder);
                return true;
            }
            FieldDescriptor field;
            int wireType = WireFormat.getTagWireType(tag);
            int fieldNumber = WireFormat.getTagFieldNumber(tag);
            Message defaultInstance = null;
            if (!type.isExtensionNumber(fieldNumber)) {
                field = type.findFieldByNumber(fieldNumber);
            } else if (extensionRegistry instanceof ExtensionRegistry) {
                ExtensionInfo extension = ((ExtensionRegistry) extensionRegistry).findExtensionByNumber(type, fieldNumber);
                if (extension == null) {
                    field = null;
                } else {
                    field = extension.descriptor;
                    defaultInstance = extension.defaultInstance;
                    if (defaultInstance == null && field.getJavaType() == JavaType.MESSAGE) {
                        throw new IllegalStateException("Message-typed extension lacked default instance: " + field.getFullName());
                    }
                }
            } else {
                field = null;
            }
            boolean unknown = false;
            boolean packed = false;
            if (field == null) {
                unknown = true;
            } else if (wireType == FieldSet.getWireFormatForFieldType(field.getLiteType(), false)) {
                packed = false;
            } else if (field.isPackable() && wireType == FieldSet.getWireFormatForFieldType(field.getLiteType(), true)) {
                packed = true;
            } else {
                unknown = true;
            }
            if (unknown) {
                return unknownFields.mergeFieldFrom(tag, input);
            }
            int rawValue;
            if (packed) {
                int limit = input.pushLimit(input.readRawVarint32());
                if (field.getLiteType() == FieldType.ENUM) {
                    while (input.getBytesUntilLimit() > 0) {
                        rawValue = input.readEnum();
                        EnumValueDescriptor value = field.getEnumType().findValueByNumber(rawValue);
                        if (value == null) {
                            return true;
                        }
                        builder.addRepeatedField(field, value);
                    }
                } else {
                    while (input.getBytesUntilLimit() > 0) {
                        builder.addRepeatedField(field, FieldSet.readPrimitiveField(input, field.getLiteType()));
                    }
                }
                input.popLimit(limit);
            } else {
                Object value2;
                com.google.protobuf.Message.Builder subBuilder;
                switch (C08371.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[field.getType().ordinal()]) {
                    case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                        if (defaultInstance != null) {
                            subBuilder = defaultInstance.newBuilderForType();
                        } else {
                            subBuilder = builder.newBuilderForField(field);
                        }
                        if (!field.isRepeated()) {
                            subBuilder.mergeFrom((Message) builder.getField(field));
                        }
                        input.readGroup(field.getNumber(), subBuilder, extensionRegistry);
                        value2 = subBuilder.build();
                        break;
                    case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                        if (defaultInstance != null) {
                            subBuilder = defaultInstance.newBuilderForType();
                        } else {
                            subBuilder = builder.newBuilderForField(field);
                        }
                        if (!field.isRepeated()) {
                            subBuilder.mergeFrom((Message) builder.getField(field));
                        }
                        input.readMessage(subBuilder, extensionRegistry);
                        value2 = subBuilder.build();
                        break;
                    case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                        rawValue = input.readEnum();
                        value2 = field.getEnumType().findValueByNumber(rawValue);
                        if (value2 == null) {
                            unknownFields.mergeVarintField(fieldNumber, rawValue);
                            return true;
                        }
                        break;
                    default:
                        value2 = FieldSet.readPrimitiveField(input, field.getLiteType());
                        break;
                }
                if (field.isRepeated()) {
                    builder.addRepeatedField(field, value2);
                } else {
                    builder.setField(field, value2);
                }
            }
            return true;
        }

        private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream input, com.google.protobuf.UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, com.google.protobuf.Message.Builder builder) throws IOException {
            Descriptor type = builder.getDescriptorForType();
            int typeId = 0;
            ByteString rawBytes = null;
            com.google.protobuf.Message.Builder subBuilder = null;
            FieldDescriptor field = null;
            while (true) {
                int tag = input.readTag();
                if (tag == 0) {
                    break;
                } else if (tag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                    typeId = input.readUInt32();
                    if (typeId != 0) {
                        ExtensionInfo extension;
                        if (extensionRegistry instanceof ExtensionRegistry) {
                            extension = ((ExtensionRegistry) extensionRegistry).findExtensionByNumber(type, typeId);
                        } else {
                            extension = null;
                        }
                        if (extension != null) {
                            field = extension.descriptor;
                            subBuilder = extension.defaultInstance.newBuilderForType();
                            Message originalMessage = (Message) builder.getField(field);
                            if (originalMessage != null) {
                                subBuilder.mergeFrom(originalMessage);
                            }
                            if (rawBytes != null) {
                                subBuilder.mergeFrom(CodedInputStream.newInstance(rawBytes.newInput()));
                                rawBytes = null;
                            }
                        } else if (rawBytes != null) {
                            unknownFields.mergeField(typeId, Field.newBuilder().addLengthDelimited(rawBytes).build());
                            rawBytes = null;
                        }
                    }
                } else if (tag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                    if (typeId == 0) {
                        rawBytes = input.readBytes();
                    } else if (subBuilder == null) {
                        unknownFields.mergeField(typeId, Field.newBuilder().addLengthDelimited(input.readBytes()).build());
                    } else {
                        input.readMessage(subBuilder, extensionRegistry);
                    }
                } else if (!input.skipField(tag)) {
                    break;
                }
            }
            input.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (subBuilder != null) {
                builder.setField(field, subBuilder.build());
            }
        }

        public BuilderType mergeUnknownFields(UnknownFieldSet unknownFields) {
            setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(unknownFields).build());
            return this;
        }

        protected static UninitializedMessageException newUninitializedMessageException(Message message) {
            return new UninitializedMessageException(findMissingFields(message));
        }

        private static List<String> findMissingFields(Message message) {
            List<String> results = new ArrayList();
            findMissingFields(message, StringUtil.EMPTY_STRING, results);
            return results;
        }

        private static void findMissingFields(Message message, String prefix, List<String> results) {
            FieldDescriptor field;
            for (FieldDescriptor field2 : message.getDescriptorForType().getFields()) {
                if (field2.isRequired() && !message.hasField(field2)) {
                    results.add(prefix + field2.getName());
                }
            }
            for (Entry<FieldDescriptor, Object> entry : message.getAllFields().entrySet()) {
                field2 = (FieldDescriptor) entry.getKey();
                Object value = entry.getValue();
                if (field2.getJavaType() == JavaType.MESSAGE) {
                    if (field2.isRepeated()) {
                        int i = 0;
                        for (Message findMissingFields : (List) value) {
                            int i2 = i + 1;
                            findMissingFields(findMissingFields, subMessagePrefix(prefix, field2, i), results);
                            i = i2;
                        }
                    } else if (message.hasField(field2)) {
                        findMissingFields((Message) value, subMessagePrefix(prefix, field2, -1), results);
                    }
                }
            }
        }

        private static String subMessagePrefix(String prefix, FieldDescriptor field, int index) {
            StringBuilder result = new StringBuilder(prefix);
            if (field.isExtension()) {
                result.append('(').append(field.getFullName()).append(')');
            } else {
                result.append(field.getName());
            }
            if (index != -1) {
                result.append('[').append(index).append(']');
            }
            result.append('.');
            return result.toString();
        }

        public BuilderType mergeFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(data);
        }

        public BuilderType mergeFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(data, extensionRegistry);
        }

        public BuilderType mergeFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(data);
        }

        public BuilderType mergeFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(data, off, len);
        }

        public BuilderType mergeFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(data, extensionRegistry);
        }

        public BuilderType mergeFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(data, off, len, extensionRegistry);
        }

        public BuilderType mergeFrom(InputStream input) throws IOException {
            return (Builder) super.mergeFrom(input);
        }

        public BuilderType mergeFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Builder) super.mergeFrom(input, extensionRegistry);
        }

        public boolean mergeDelimitedFrom(InputStream input) throws IOException {
            return super.mergeDelimitedFrom(input);
        }

        public boolean mergeDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return super.mergeDelimitedFrom(input, extensionRegistry);
        }
    }

    public AbstractMessage() {
        this.memoizedSize = -1;
    }

    public boolean isInitialized() {
        for (FieldDescriptor field : getDescriptorForType().getFields()) {
            FieldDescriptor field2;
            if (field2.isRequired() && !hasField(field2)) {
                return false;
            }
        }
        for (Entry<FieldDescriptor, Object> entry : getAllFields().entrySet()) {
            field2 = (FieldDescriptor) entry.getKey();
            if (field2.getJavaType() == JavaType.MESSAGE) {
                if (field2.isRepeated()) {
                    for (Message element : (List) entry.getValue()) {
                        if (!element.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (!((Message) entry.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final String toString() {
        return TextFormat.printToString((Message) this);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        boolean isMessageSet = getDescriptorForType().getOptions().getMessageSetWireFormat();
        for (Entry<FieldDescriptor, Object> entry : getAllFields().entrySet()) {
            FieldDescriptor field = (FieldDescriptor) entry.getKey();
            Object value = entry.getValue();
            if (isMessageSet && field.isExtension() && field.getType() == Type.MESSAGE && !field.isRepeated()) {
                output.writeMessageSetExtension(field.getNumber(), (Message) value);
            } else {
                FieldSet.writeField(field, value, output);
            }
        }
        UnknownFieldSet unknownFields = getUnknownFields();
        if (isMessageSet) {
            unknownFields.writeAsMessageSetTo(output);
        } else {
            unknownFields.writeTo(output);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSize;
        if (size != -1) {
            return size;
        }
        size = 0;
        boolean isMessageSet = getDescriptorForType().getOptions().getMessageSetWireFormat();
        for (Entry<FieldDescriptor, Object> entry : getAllFields().entrySet()) {
            FieldDescriptor field = (FieldDescriptor) entry.getKey();
            Object value = entry.getValue();
            if (isMessageSet && field.isExtension() && field.getType() == Type.MESSAGE && !field.isRepeated()) {
                size += CodedOutputStream.computeMessageSetExtensionSize(field.getNumber(), (Message) value);
            } else {
                size += FieldSet.computeFieldSize(field, value);
            }
        }
        UnknownFieldSet unknownFields = getUnknownFields();
        if (isMessageSet) {
            size += unknownFields.getSerializedSizeAsMessageSet();
        } else {
            size += unknownFields.getSerializedSize();
        }
        this.memoizedSize = size;
        return size;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message otherMessage = (Message) other;
        if (getDescriptorForType() != otherMessage.getDescriptorForType()) {
            return false;
        }
        if (getAllFields().equals(otherMessage.getAllFields()) && getUnknownFields().equals(otherMessage.getUnknownFields())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (hashFields(getDescriptorForType().hashCode() + 779, getAllFields()) * 29) + getUnknownFields().hashCode();
    }

    protected int hashFields(int hash, Map<FieldDescriptor, Object> map) {
        for (Entry<FieldDescriptor, Object> entry : map.entrySet()) {
            FieldDescriptor field = (FieldDescriptor) entry.getKey();
            List<? extends EnumLite> value = entry.getValue();
            hash = (hash * 37) + field.getNumber();
            if (field.getType() != Type.ENUM) {
                hash = (hash * 53) + value.hashCode();
            } else if (field.isRepeated()) {
                hash = (hash * 53) + hashEnumList(value);
            } else {
                hash = (hash * 53) + hashEnum((EnumLite) value);
            }
        }
        return hash;
    }

    protected static int hashLong(long n) {
        return (int) ((n >>> 32) ^ n);
    }

    protected static int hashBoolean(boolean b) {
        return b ? 1231 : 1237;
    }

    protected static int hashEnum(EnumLite e) {
        return e.getNumber();
    }

    protected static int hashEnumList(List<? extends EnumLite> list) {
        int hash = 1;
        for (EnumLite e : list) {
            hash = (hash * 31) + hashEnum(e);
        }
        return hash;
    }
}
