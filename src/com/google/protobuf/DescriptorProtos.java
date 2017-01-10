package com.google.protobuf;

import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.google.ads.AdSize;
import com.google.common.net.HttpHeaders;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.html.HtmlToText;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.google.protobuf.GeneratedMessage.ExtendableBuilder;
import com.google.protobuf.GeneratedMessage.ExtendableMessage;
import com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.Internal.EnumLiteMap;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.codehaus.jackson.io.CharacterEscapes;

public final class DescriptorProtos {
    private static FileDescriptor descriptor;
    private static Descriptor f444x1458f8d;
    private static FieldAccessorTable f445xf366d90b;
    private static Descriptor internal_static_google_protobuf_DescriptorProto_descriptor;
    private static FieldAccessorTable f446x907d0bf0;
    private static Descriptor internal_static_google_protobuf_EnumDescriptorProto_descriptor;
    private static FieldAccessorTable f447x9945f651;
    private static Descriptor internal_static_google_protobuf_EnumOptions_descriptor;
    private static FieldAccessorTable internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
    private static Descriptor f448xf18031a8;
    private static FieldAccessorTable f449xfb173026;
    private static Descriptor internal_static_google_protobuf_EnumValueOptions_descriptor;
    private static FieldAccessorTable f450xdf65a421;
    private static Descriptor internal_static_google_protobuf_FieldDescriptorProto_descriptor;
    private static FieldAccessorTable f451x4734b330;
    private static Descriptor internal_static_google_protobuf_FieldOptions_descriptor;
    private static FieldAccessorTable internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
    private static Descriptor internal_static_google_protobuf_FileDescriptorProto_descriptor;
    private static FieldAccessorTable f452x4b52780c;
    private static Descriptor internal_static_google_protobuf_FileDescriptorSet_descriptor;
    private static FieldAccessorTable f453x15a6a952;
    private static Descriptor internal_static_google_protobuf_FileOptions_descriptor;
    private static FieldAccessorTable internal_static_google_protobuf_FileOptions_fieldAccessorTable;
    private static Descriptor internal_static_google_protobuf_MessageOptions_descriptor;
    private static FieldAccessorTable f454x9c0b3d38;
    private static Descriptor internal_static_google_protobuf_MethodDescriptorProto_descriptor;
    private static FieldAccessorTable f455xc5331ef1;
    private static Descriptor internal_static_google_protobuf_MethodOptions_descriptor;
    private static FieldAccessorTable internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
    private static Descriptor f456x158c73ed;
    private static FieldAccessorTable f457xee335d6b;
    private static Descriptor internal_static_google_protobuf_ServiceOptions_descriptor;
    private static FieldAccessorTable f458x371e666;
    private static Descriptor f459xb210d08d;
    private static FieldAccessorTable f460x9611a0b;
    private static Descriptor internal_static_google_protobuf_SourceCodeInfo_descriptor;
    private static FieldAccessorTable f461x532209f9;
    private static Descriptor f462xb111d23c;
    private static FieldAccessorTable f463x1698fcba;
    private static Descriptor internal_static_google_protobuf_UninterpretedOption_descriptor;
    private static FieldAccessorTable f464x2101041;

    /* renamed from: com.google.protobuf.DescriptorProtos.1 */
    static class C08391 implements InternalDescriptorAssigner {
        C08391() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            DescriptorProtos.descriptor = root;
            DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(0);
            DescriptorProtos.f453x15a6a952 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor, new String[]{"File"}, FileDescriptorSet.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(1);
            DescriptorProtos.f452x4b52780c = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor, new String[]{"Name", "Package", "Dependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo"}, FileDescriptorProto.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(2);
            DescriptorProtos.f446x907d0bf0 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor, new String[]{"Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "Options"}, DescriptorProto.class, Builder.class);
            DescriptorProtos.f444x1458f8d = (Descriptor) DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor.getNestedTypes().get(0);
            DescriptorProtos.f445xf366d90b = new FieldAccessorTable(DescriptorProtos.f444x1458f8d, new String[]{"Start", "End"}, ExtensionRange.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(3);
            DescriptorProtos.f451x4734b330 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor, new String[]{"Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "Options"}, FieldDescriptorProto.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(4);
            DescriptorProtos.f447x9945f651 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor, new String[]{"Name", "Value", "Options"}, EnumDescriptorProto.class, Builder.class);
            DescriptorProtos.f448xf18031a8 = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(5);
            DescriptorProtos.f449xfb173026 = new FieldAccessorTable(DescriptorProtos.f448xf18031a8, new String[]{"Name", "Number", "Options"}, EnumValueDescriptorProto.class, Builder.class);
            DescriptorProtos.f456x158c73ed = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(6);
            DescriptorProtos.f457xee335d6b = new FieldAccessorTable(DescriptorProtos.f456x158c73ed, new String[]{"Name", "Method", "Options"}, ServiceDescriptorProto.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(7);
            DescriptorProtos.f455xc5331ef1 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor, new String[]{"Name", "InputType", "OutputType", "Options"}, MethodDescriptorProto.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(8);
            DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor, new String[]{"JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "OptimizeFor", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "UninterpretedOption"}, FileOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(9);
            DescriptorProtos.f454x9c0b3d38 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor, new String[]{"MessageSetWireFormat", "NoStandardDescriptorAccessor", "UninterpretedOption"}, MessageOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(10);
            DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor, new String[]{"Ctype", "Packed", "Deprecated", "ExperimentalMapKey", "UninterpretedOption"}, FieldOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(11);
            DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor, new String[]{"UninterpretedOption"}, EnumOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(12);
            DescriptorProtos.f450xdf65a421 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor, new String[]{"UninterpretedOption"}, EnumValueOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(13);
            DescriptorProtos.f458x371e666 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor, new String[]{"UninterpretedOption"}, ServiceOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(14);
            DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor, new String[]{"UninterpretedOption"}, MethodOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(15);
            DescriptorProtos.f464x2101041 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor, new String[]{"Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"}, UninterpretedOption.class, Builder.class);
            DescriptorProtos.f462xb111d23c = (Descriptor) DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor.getNestedTypes().get(0);
            DescriptorProtos.f463x1698fcba = new FieldAccessorTable(DescriptorProtos.f462xb111d23c, new String[]{"NamePart", "IsExtension"}, NamePart.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(16);
            DescriptorProtos.f461x532209f9 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor, new String[]{HttpHeaders.LOCATION}, SourceCodeInfo.class, Builder.class);
            DescriptorProtos.f459xb210d08d = (Descriptor) DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor.getNestedTypes().get(0);
            DescriptorProtos.f460x9611a0b = new FieldAccessorTable(DescriptorProtos.f459xb210d08d, new String[]{"Path", "Span"}, Location.class, Builder.class);
            return null;
        }
    }

    public interface DescriptorProtoOrBuilder extends MessageOrBuilder {
        EnumDescriptorProto getEnumType(int i);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i);

        List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList();

        FieldDescriptorProto getExtension(int i);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i);

        List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList();

        ExtensionRange getExtensionRange(int i);

        int getExtensionRangeCount();

        List<ExtensionRange> getExtensionRangeList();

        ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int i);

        List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList();

        FieldDescriptorProto getField(int i);

        int getFieldCount();

        List<FieldDescriptorProto> getFieldList();

        FieldDescriptorProtoOrBuilder getFieldOrBuilder(int i);

        List<? extends FieldDescriptorProtoOrBuilder> getFieldOrBuilderList();

        String getName();

        DescriptorProto getNestedType(int i);

        int getNestedTypeCount();

        List<DescriptorProto> getNestedTypeList();

        DescriptorProtoOrBuilder getNestedTypeOrBuilder(int i);

        List<? extends DescriptorProtoOrBuilder> getNestedTypeOrBuilderList();

        MessageOptions getOptions();

        MessageOptionsOrBuilder getOptionsOrBuilder();

        boolean hasName();

        boolean hasOptions();
    }

    public static final class DescriptorProto extends GeneratedMessage implements DescriptorProtoOrBuilder {
        public static final int ENUM_TYPE_FIELD_NUMBER = 4;
        public static final int EXTENSION_FIELD_NUMBER = 6;
        public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NESTED_TYPE_FIELD_NUMBER = 3;
        public static final int OPTIONS_FIELD_NUMBER = 7;
        private static final DescriptorProto defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<EnumDescriptorProto> enumType_;
        private List<ExtensionRange> extensionRange_;
        private List<FieldDescriptorProto> extension_;
        private List<FieldDescriptorProto> field_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private List<DescriptorProto> nestedType_;
        private MessageOptions options_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements DescriptorProtoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<EnumDescriptorProto, Builder, EnumDescriptorProtoOrBuilder> enumTypeBuilder_;
            private List<EnumDescriptorProto> enumType_;
            private RepeatedFieldBuilder<FieldDescriptorProto, Builder, FieldDescriptorProtoOrBuilder> extensionBuilder_;
            private RepeatedFieldBuilder<ExtensionRange, Builder, ExtensionRangeOrBuilder> extensionRangeBuilder_;
            private List<ExtensionRange> extensionRange_;
            private List<FieldDescriptorProto> extension_;
            private RepeatedFieldBuilder<FieldDescriptorProto, Builder, FieldDescriptorProtoOrBuilder> fieldBuilder_;
            private List<FieldDescriptorProto> field_;
            private Object name_;
            private RepeatedFieldBuilder<DescriptorProto, Builder, DescriptorProtoOrBuilder> nestedTypeBuilder_;
            private List<DescriptorProto> nestedType_;
            private SingleFieldBuilder<MessageOptions, Builder, MessageOptionsOrBuilder> optionsBuilder_;
            private MessageOptions options_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f446x907d0bf0;
            }

            private Builder() {
                this.name_ = StringUtil.EMPTY_STRING;
                this.field_ = Collections.emptyList();
                this.extension_ = Collections.emptyList();
                this.nestedType_ = Collections.emptyList();
                this.enumType_ = Collections.emptyList();
                this.extensionRange_ = Collections.emptyList();
                this.options_ = MessageOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.name_ = StringUtil.EMPTY_STRING;
                this.field_ = Collections.emptyList();
                this.extension_ = Collections.emptyList();
                this.nestedType_ = Collections.emptyList();
                this.enumType_ = Collections.emptyList();
                this.extensionRange_ = Collections.emptyList();
                this.options_ = MessageOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getFieldFieldBuilder();
                    getExtensionFieldBuilder();
                    getNestedTypeFieldBuilder();
                    getEnumTypeFieldBuilder();
                    getExtensionRangeFieldBuilder();
                    getOptionsFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.name_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -2;
                if (this.fieldBuilder_ == null) {
                    this.field_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.fieldBuilder_.clear();
                }
                if (this.extensionBuilder_ == null) {
                    this.extension_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.extensionBuilder_.clear();
                }
                if (this.nestedTypeBuilder_ == null) {
                    this.nestedType_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.nestedTypeBuilder_.clear();
                }
                if (this.enumTypeBuilder_ == null) {
                    this.enumType_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.enumTypeBuilder_.clear();
                }
                if (this.extensionRangeBuilder_ == null) {
                    this.extensionRange_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                } else {
                    this.extensionRangeBuilder_.clear();
                }
                if (this.optionsBuilder_ == null) {
                    this.options_ = MessageOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return DescriptorProto.getDescriptor();
            }

            public DescriptorProto getDefaultInstanceForType() {
                return DescriptorProto.getDefaultInstance();
            }

            public DescriptorProto build() {
                DescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private DescriptorProto buildParsed() throws InvalidProtocolBufferException {
                DescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public DescriptorProto buildPartial() {
                DescriptorProto result = new DescriptorProto();
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & DescriptorProto.NAME_FIELD_NUMBER) == DescriptorProto.NAME_FIELD_NUMBER) {
                    to_bitField0_ = 0 | DescriptorProto.NAME_FIELD_NUMBER;
                }
                result.name_ = this.name_;
                if (this.fieldBuilder_ == null) {
                    if ((this.bitField0_ & DescriptorProto.FIELD_FIELD_NUMBER) == DescriptorProto.FIELD_FIELD_NUMBER) {
                        this.field_ = Collections.unmodifiableList(this.field_);
                        this.bitField0_ &= -3;
                    }
                    result.field_ = this.field_;
                } else {
                    result.field_ = this.fieldBuilder_.build();
                }
                if (this.extensionBuilder_ == null) {
                    if ((this.bitField0_ & DescriptorProto.ENUM_TYPE_FIELD_NUMBER) == DescriptorProto.ENUM_TYPE_FIELD_NUMBER) {
                        this.extension_ = Collections.unmodifiableList(this.extension_);
                        this.bitField0_ &= -5;
                    }
                    result.extension_ = this.extension_;
                } else {
                    result.extension_ = this.extensionBuilder_.build();
                }
                if (this.nestedTypeBuilder_ == null) {
                    if ((this.bitField0_ & 8) == 8) {
                        this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
                        this.bitField0_ &= -9;
                    }
                    result.nestedType_ = this.nestedType_;
                } else {
                    result.nestedType_ = this.nestedTypeBuilder_.build();
                }
                if (this.enumTypeBuilder_ == null) {
                    if ((this.bitField0_ & 16) == 16) {
                        this.enumType_ = Collections.unmodifiableList(this.enumType_);
                        this.bitField0_ &= -17;
                    }
                    result.enumType_ = this.enumType_;
                } else {
                    result.enumType_ = this.enumTypeBuilder_.build();
                }
                if (this.extensionRangeBuilder_ == null) {
                    if ((this.bitField0_ & 32) == 32) {
                        this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
                        this.bitField0_ &= -33;
                    }
                    result.extensionRange_ = this.extensionRange_;
                } else {
                    result.extensionRange_ = this.extensionRangeBuilder_.build();
                }
                if ((from_bitField0_ & 64) == 64) {
                    to_bitField0_ |= DescriptorProto.FIELD_FIELD_NUMBER;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (MessageOptions) this.optionsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DescriptorProto) {
                    return mergeFrom((DescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DescriptorProto other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != DescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (this.fieldBuilder_ == null) {
                        if (!other.field_.isEmpty()) {
                            if (this.field_.isEmpty()) {
                                this.field_ = other.field_;
                                this.bitField0_ &= -3;
                            } else {
                                ensureFieldIsMutable();
                                this.field_.addAll(other.field_);
                            }
                            onChanged();
                        }
                    } else if (!other.field_.isEmpty()) {
                        if (this.fieldBuilder_.isEmpty()) {
                            this.fieldBuilder_.dispose();
                            this.fieldBuilder_ = null;
                            this.field_ = other.field_;
                            this.bitField0_ &= -3;
                            this.fieldBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getFieldFieldBuilder() : null;
                        } else {
                            this.fieldBuilder_.addAllMessages(other.field_);
                        }
                    }
                    if (this.extensionBuilder_ == null) {
                        if (!other.extension_.isEmpty()) {
                            if (this.extension_.isEmpty()) {
                                this.extension_ = other.extension_;
                                this.bitField0_ &= -5;
                            } else {
                                ensureExtensionIsMutable();
                                this.extension_.addAll(other.extension_);
                            }
                            onChanged();
                        }
                    } else if (!other.extension_.isEmpty()) {
                        if (this.extensionBuilder_.isEmpty()) {
                            this.extensionBuilder_.dispose();
                            this.extensionBuilder_ = null;
                            this.extension_ = other.extension_;
                            this.bitField0_ &= -5;
                            this.extensionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getExtensionFieldBuilder() : null;
                        } else {
                            this.extensionBuilder_.addAllMessages(other.extension_);
                        }
                    }
                    if (this.nestedTypeBuilder_ == null) {
                        if (!other.nestedType_.isEmpty()) {
                            if (this.nestedType_.isEmpty()) {
                                this.nestedType_ = other.nestedType_;
                                this.bitField0_ &= -9;
                            } else {
                                ensureNestedTypeIsMutable();
                                this.nestedType_.addAll(other.nestedType_);
                            }
                            onChanged();
                        }
                    } else if (!other.nestedType_.isEmpty()) {
                        if (this.nestedTypeBuilder_.isEmpty()) {
                            this.nestedTypeBuilder_.dispose();
                            this.nestedTypeBuilder_ = null;
                            this.nestedType_ = other.nestedType_;
                            this.bitField0_ &= -9;
                            this.nestedTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getNestedTypeFieldBuilder() : null;
                        } else {
                            this.nestedTypeBuilder_.addAllMessages(other.nestedType_);
                        }
                    }
                    if (this.enumTypeBuilder_ == null) {
                        if (!other.enumType_.isEmpty()) {
                            if (this.enumType_.isEmpty()) {
                                this.enumType_ = other.enumType_;
                                this.bitField0_ &= -17;
                            } else {
                                ensureEnumTypeIsMutable();
                                this.enumType_.addAll(other.enumType_);
                            }
                            onChanged();
                        }
                    } else if (!other.enumType_.isEmpty()) {
                        if (this.enumTypeBuilder_.isEmpty()) {
                            this.enumTypeBuilder_.dispose();
                            this.enumTypeBuilder_ = null;
                            this.enumType_ = other.enumType_;
                            this.bitField0_ &= -17;
                            this.enumTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getEnumTypeFieldBuilder() : null;
                        } else {
                            this.enumTypeBuilder_.addAllMessages(other.enumType_);
                        }
                    }
                    if (this.extensionRangeBuilder_ == null) {
                        if (!other.extensionRange_.isEmpty()) {
                            if (this.extensionRange_.isEmpty()) {
                                this.extensionRange_ = other.extensionRange_;
                                this.bitField0_ &= -33;
                            } else {
                                ensureExtensionRangeIsMutable();
                                this.extensionRange_.addAll(other.extensionRange_);
                            }
                            onChanged();
                        }
                    } else if (!other.extensionRange_.isEmpty()) {
                        if (this.extensionRangeBuilder_.isEmpty()) {
                            this.extensionRangeBuilder_.dispose();
                            this.extensionRangeBuilder_ = null;
                            this.extensionRange_ = other.extensionRange_;
                            this.bitField0_ &= -33;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getExtensionRangeFieldBuilder();
                            }
                            this.extensionRangeBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.extensionRangeBuilder_.addAllMessages(other.extensionRange_);
                        }
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getFieldCount(); i += DescriptorProto.NAME_FIELD_NUMBER) {
                    if (!getField(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getExtensionCount(); i += DescriptorProto.NAME_FIELD_NUMBER) {
                    if (!getExtension(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getNestedTypeCount(); i += DescriptorProto.NAME_FIELD_NUMBER) {
                    if (!getNestedType(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getEnumTypeCount(); i += DescriptorProto.NAME_FIELD_NUMBER) {
                    if (!getEnumType(i).isInitialized()) {
                        return false;
                    }
                }
                if (!hasOptions() || getOptions().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    Builder subBuilder;
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                            this.bitField0_ |= DescriptorProto.NAME_FIELD_NUMBER;
                            this.name_ = input.readBytes();
                            continue;
                        case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                            subBuilder = FieldDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addField(subBuilder.buildPartial());
                            continue;
                        case 26:
                            Builder subBuilder2 = DescriptorProto.newBuilder();
                            input.readMessage(subBuilder2, extensionRegistry);
                            addNestedType(subBuilder2.buildPartial());
                            continue;
                        case 34:
                            Builder subBuilder3 = EnumDescriptorProto.newBuilder();
                            input.readMessage(subBuilder3, extensionRegistry);
                            addEnumType(subBuilder3.buildPartial());
                            continue;
                        case 42:
                            Builder subBuilder4 = ExtensionRange.newBuilder();
                            input.readMessage(subBuilder4, extensionRegistry);
                            addExtensionRange(subBuilder4.buildPartial());
                            continue;
                        case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                            subBuilder = FieldDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addExtension(subBuilder.buildPartial());
                            continue;
                        case 58:
                            Builder subBuilder5 = MessageOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder5.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder5, extensionRegistry);
                            setOptions(subBuilder5.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasName() {
                return (this.bitField0_ & DescriptorProto.NAME_FIELD_NUMBER) == DescriptorProto.NAME_FIELD_NUMBER;
            }

            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= DescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = DescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= DescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
            }

            private void ensureFieldIsMutable() {
                if ((this.bitField0_ & DescriptorProto.FIELD_FIELD_NUMBER) != DescriptorProto.FIELD_FIELD_NUMBER) {
                    this.field_ = new ArrayList(this.field_);
                    this.bitField0_ |= DescriptorProto.FIELD_FIELD_NUMBER;
                }
            }

            public List<FieldDescriptorProto> getFieldList() {
                if (this.fieldBuilder_ == null) {
                    return Collections.unmodifiableList(this.field_);
                }
                return this.fieldBuilder_.getMessageList();
            }

            public int getFieldCount() {
                if (this.fieldBuilder_ == null) {
                    return this.field_.size();
                }
                return this.fieldBuilder_.getCount();
            }

            public FieldDescriptorProto getField(int index) {
                if (this.fieldBuilder_ == null) {
                    return (FieldDescriptorProto) this.field_.get(index);
                }
                return (FieldDescriptorProto) this.fieldBuilder_.getMessage(index);
            }

            public Builder setField(int index, FieldDescriptorProto value) {
                if (this.fieldBuilder_ != null) {
                    this.fieldBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFieldIsMutable();
                    this.field_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setField(int index, Builder builderForValue) {
                if (this.fieldBuilder_ == null) {
                    ensureFieldIsMutable();
                    this.field_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fieldBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addField(FieldDescriptorProto value) {
                if (this.fieldBuilder_ != null) {
                    this.fieldBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFieldIsMutable();
                    this.field_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addField(int index, FieldDescriptorProto value) {
                if (this.fieldBuilder_ != null) {
                    this.fieldBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFieldIsMutable();
                    this.field_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addField(Builder builderForValue) {
                if (this.fieldBuilder_ == null) {
                    ensureFieldIsMutable();
                    this.field_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.fieldBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addField(int index, Builder builderForValue) {
                if (this.fieldBuilder_ == null) {
                    ensureFieldIsMutable();
                    this.field_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fieldBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllField(Iterable<? extends FieldDescriptorProto> values) {
                if (this.fieldBuilder_ == null) {
                    ensureFieldIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.field_);
                    onChanged();
                } else {
                    this.fieldBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearField() {
                if (this.fieldBuilder_ == null) {
                    this.field_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.fieldBuilder_.clear();
                }
                return this;
            }

            public Builder removeField(int index) {
                if (this.fieldBuilder_ == null) {
                    ensureFieldIsMutable();
                    this.field_.remove(index);
                    onChanged();
                } else {
                    this.fieldBuilder_.remove(index);
                }
                return this;
            }

            public Builder getFieldBuilder(int index) {
                return (Builder) getFieldFieldBuilder().getBuilder(index);
            }

            public FieldDescriptorProtoOrBuilder getFieldOrBuilder(int index) {
                if (this.fieldBuilder_ == null) {
                    return (FieldDescriptorProtoOrBuilder) this.field_.get(index);
                }
                return (FieldDescriptorProtoOrBuilder) this.fieldBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends FieldDescriptorProtoOrBuilder> getFieldOrBuilderList() {
                if (this.fieldBuilder_ != null) {
                    return this.fieldBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.field_);
            }

            public Builder addFieldBuilder() {
                return (Builder) getFieldFieldBuilder().addBuilder(FieldDescriptorProto.getDefaultInstance());
            }

            public Builder addFieldBuilder(int index) {
                return (Builder) getFieldFieldBuilder().addBuilder(index, FieldDescriptorProto.getDefaultInstance());
            }

            public List<Builder> getFieldBuilderList() {
                return getFieldFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<FieldDescriptorProto, Builder, FieldDescriptorProtoOrBuilder> getFieldFieldBuilder() {
                if (this.fieldBuilder_ == null) {
                    this.fieldBuilder_ = new RepeatedFieldBuilder(this.field_, (this.bitField0_ & DescriptorProto.FIELD_FIELD_NUMBER) == DescriptorProto.FIELD_FIELD_NUMBER, getParentForChildren(), isClean());
                    this.field_ = null;
                }
                return this.fieldBuilder_;
            }

            private void ensureExtensionIsMutable() {
                if ((this.bitField0_ & DescriptorProto.ENUM_TYPE_FIELD_NUMBER) != DescriptorProto.ENUM_TYPE_FIELD_NUMBER) {
                    this.extension_ = new ArrayList(this.extension_);
                    this.bitField0_ |= DescriptorProto.ENUM_TYPE_FIELD_NUMBER;
                }
            }

            public List<FieldDescriptorProto> getExtensionList() {
                if (this.extensionBuilder_ == null) {
                    return Collections.unmodifiableList(this.extension_);
                }
                return this.extensionBuilder_.getMessageList();
            }

            public int getExtensionCount() {
                if (this.extensionBuilder_ == null) {
                    return this.extension_.size();
                }
                return this.extensionBuilder_.getCount();
            }

            public FieldDescriptorProto getExtension(int index) {
                if (this.extensionBuilder_ == null) {
                    return (FieldDescriptorProto) this.extension_.get(index);
                }
                return (FieldDescriptorProto) this.extensionBuilder_.getMessage(index);
            }

            public Builder setExtension(int index, FieldDescriptorProto value) {
                if (this.extensionBuilder_ != null) {
                    this.extensionBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtensionIsMutable();
                    this.extension_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setExtension(int index, Builder builderForValue) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extensionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExtension(FieldDescriptorProto value) {
                if (this.extensionBuilder_ != null) {
                    this.extensionBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtensionIsMutable();
                    this.extension_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtension(int index, FieldDescriptorProto value) {
                if (this.extensionBuilder_ != null) {
                    this.extensionBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtensionIsMutable();
                    this.extension_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtension(Builder builderForValue) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.extensionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExtension(int index, Builder builderForValue) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extensionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> values) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.extension_);
                    onChanged();
                } else {
                    this.extensionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExtension() {
                if (this.extensionBuilder_ == null) {
                    this.extension_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.extensionBuilder_.clear();
                }
                return this;
            }

            public Builder removeExtension(int index) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.remove(index);
                    onChanged();
                } else {
                    this.extensionBuilder_.remove(index);
                }
                return this;
            }

            public Builder getExtensionBuilder(int index) {
                return (Builder) getExtensionFieldBuilder().getBuilder(index);
            }

            public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index) {
                if (this.extensionBuilder_ == null) {
                    return (FieldDescriptorProtoOrBuilder) this.extension_.get(index);
                }
                return (FieldDescriptorProtoOrBuilder) this.extensionBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
                if (this.extensionBuilder_ != null) {
                    return this.extensionBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.extension_);
            }

            public Builder addExtensionBuilder() {
                return (Builder) getExtensionFieldBuilder().addBuilder(FieldDescriptorProto.getDefaultInstance());
            }

            public Builder addExtensionBuilder(int index) {
                return (Builder) getExtensionFieldBuilder().addBuilder(index, FieldDescriptorProto.getDefaultInstance());
            }

            public List<Builder> getExtensionBuilderList() {
                return getExtensionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<FieldDescriptorProto, Builder, FieldDescriptorProtoOrBuilder> getExtensionFieldBuilder() {
                if (this.extensionBuilder_ == null) {
                    this.extensionBuilder_ = new RepeatedFieldBuilder(this.extension_, (this.bitField0_ & DescriptorProto.ENUM_TYPE_FIELD_NUMBER) == DescriptorProto.ENUM_TYPE_FIELD_NUMBER, getParentForChildren(), isClean());
                    this.extension_ = null;
                }
                return this.extensionBuilder_;
            }

            private void ensureNestedTypeIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.nestedType_ = new ArrayList(this.nestedType_);
                    this.bitField0_ |= 8;
                }
            }

            public List<DescriptorProto> getNestedTypeList() {
                if (this.nestedTypeBuilder_ == null) {
                    return Collections.unmodifiableList(this.nestedType_);
                }
                return this.nestedTypeBuilder_.getMessageList();
            }

            public int getNestedTypeCount() {
                if (this.nestedTypeBuilder_ == null) {
                    return this.nestedType_.size();
                }
                return this.nestedTypeBuilder_.getCount();
            }

            public DescriptorProto getNestedType(int index) {
                if (this.nestedTypeBuilder_ == null) {
                    return (DescriptorProto) this.nestedType_.get(index);
                }
                return (DescriptorProto) this.nestedTypeBuilder_.getMessage(index);
            }

            public Builder setNestedType(int index, DescriptorProto value) {
                if (this.nestedTypeBuilder_ != null) {
                    this.nestedTypeBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNestedTypeIsMutable();
                    this.nestedType_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setNestedType(int index, Builder builderForValue) {
                if (this.nestedTypeBuilder_ == null) {
                    ensureNestedTypeIsMutable();
                    this.nestedType_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addNestedType(DescriptorProto value) {
                if (this.nestedTypeBuilder_ != null) {
                    this.nestedTypeBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNestedTypeIsMutable();
                    this.nestedType_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addNestedType(int index, DescriptorProto value) {
                if (this.nestedTypeBuilder_ != null) {
                    this.nestedTypeBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNestedTypeIsMutable();
                    this.nestedType_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addNestedType(Builder builderForValue) {
                if (this.nestedTypeBuilder_ == null) {
                    ensureNestedTypeIsMutable();
                    this.nestedType_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addNestedType(int index, Builder builderForValue) {
                if (this.nestedTypeBuilder_ == null) {
                    ensureNestedTypeIsMutable();
                    this.nestedType_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllNestedType(Iterable<? extends DescriptorProto> values) {
                if (this.nestedTypeBuilder_ == null) {
                    ensureNestedTypeIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.nestedType_);
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearNestedType() {
                if (this.nestedTypeBuilder_ == null) {
                    this.nestedType_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.clear();
                }
                return this;
            }

            public Builder removeNestedType(int index) {
                if (this.nestedTypeBuilder_ == null) {
                    ensureNestedTypeIsMutable();
                    this.nestedType_.remove(index);
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.remove(index);
                }
                return this;
            }

            public Builder getNestedTypeBuilder(int index) {
                return (Builder) getNestedTypeFieldBuilder().getBuilder(index);
            }

            public DescriptorProtoOrBuilder getNestedTypeOrBuilder(int index) {
                if (this.nestedTypeBuilder_ == null) {
                    return (DescriptorProtoOrBuilder) this.nestedType_.get(index);
                }
                return (DescriptorProtoOrBuilder) this.nestedTypeBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends DescriptorProtoOrBuilder> getNestedTypeOrBuilderList() {
                if (this.nestedTypeBuilder_ != null) {
                    return this.nestedTypeBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.nestedType_);
            }

            public Builder addNestedTypeBuilder() {
                return (Builder) getNestedTypeFieldBuilder().addBuilder(DescriptorProto.getDefaultInstance());
            }

            public Builder addNestedTypeBuilder(int index) {
                return (Builder) getNestedTypeFieldBuilder().addBuilder(index, DescriptorProto.getDefaultInstance());
            }

            public List<Builder> getNestedTypeBuilderList() {
                return getNestedTypeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<DescriptorProto, Builder, DescriptorProtoOrBuilder> getNestedTypeFieldBuilder() {
                if (this.nestedTypeBuilder_ == null) {
                    this.nestedTypeBuilder_ = new RepeatedFieldBuilder(this.nestedType_, (this.bitField0_ & 8) == 8, getParentForChildren(), isClean());
                    this.nestedType_ = null;
                }
                return this.nestedTypeBuilder_;
            }

            private void ensureEnumTypeIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.enumType_ = new ArrayList(this.enumType_);
                    this.bitField0_ |= 16;
                }
            }

            public List<EnumDescriptorProto> getEnumTypeList() {
                if (this.enumTypeBuilder_ == null) {
                    return Collections.unmodifiableList(this.enumType_);
                }
                return this.enumTypeBuilder_.getMessageList();
            }

            public int getEnumTypeCount() {
                if (this.enumTypeBuilder_ == null) {
                    return this.enumType_.size();
                }
                return this.enumTypeBuilder_.getCount();
            }

            public EnumDescriptorProto getEnumType(int index) {
                if (this.enumTypeBuilder_ == null) {
                    return (EnumDescriptorProto) this.enumType_.get(index);
                }
                return (EnumDescriptorProto) this.enumTypeBuilder_.getMessage(index);
            }

            public Builder setEnumType(int index, EnumDescriptorProto value) {
                if (this.enumTypeBuilder_ != null) {
                    this.enumTypeBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEnumTypeIsMutable();
                    this.enumType_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setEnumType(int index, Builder builderForValue) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.enumTypeBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto value) {
                if (this.enumTypeBuilder_ != null) {
                    this.enumTypeBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addEnumType(int index, EnumDescriptorProto value) {
                if (this.enumTypeBuilder_ != null) {
                    this.enumTypeBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addEnumType(Builder builderForValue) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addEnumType(int index, Builder builderForValue) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> values) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.enumType_);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEnumType() {
                if (this.enumTypeBuilder_ == null) {
                    this.enumType_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.enumTypeBuilder_.clear();
                }
                return this;
            }

            public Builder removeEnumType(int index) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.remove(index);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.remove(index);
                }
                return this;
            }

            public Builder getEnumTypeBuilder(int index) {
                return (Builder) getEnumTypeFieldBuilder().getBuilder(index);
            }

            public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index) {
                if (this.enumTypeBuilder_ == null) {
                    return (EnumDescriptorProtoOrBuilder) this.enumType_.get(index);
                }
                return (EnumDescriptorProtoOrBuilder) this.enumTypeBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
                if (this.enumTypeBuilder_ != null) {
                    return this.enumTypeBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.enumType_);
            }

            public Builder addEnumTypeBuilder() {
                return (Builder) getEnumTypeFieldBuilder().addBuilder(EnumDescriptorProto.getDefaultInstance());
            }

            public Builder addEnumTypeBuilder(int index) {
                return (Builder) getEnumTypeFieldBuilder().addBuilder(index, EnumDescriptorProto.getDefaultInstance());
            }

            public List<Builder> getEnumTypeBuilderList() {
                return getEnumTypeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<EnumDescriptorProto, Builder, EnumDescriptorProtoOrBuilder> getEnumTypeFieldBuilder() {
                if (this.enumTypeBuilder_ == null) {
                    this.enumTypeBuilder_ = new RepeatedFieldBuilder(this.enumType_, (this.bitField0_ & 16) == 16, getParentForChildren(), isClean());
                    this.enumType_ = null;
                }
                return this.enumTypeBuilder_;
            }

            private void ensureExtensionRangeIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.extensionRange_ = new ArrayList(this.extensionRange_);
                    this.bitField0_ |= 32;
                }
            }

            public List<ExtensionRange> getExtensionRangeList() {
                if (this.extensionRangeBuilder_ == null) {
                    return Collections.unmodifiableList(this.extensionRange_);
                }
                return this.extensionRangeBuilder_.getMessageList();
            }

            public int getExtensionRangeCount() {
                if (this.extensionRangeBuilder_ == null) {
                    return this.extensionRange_.size();
                }
                return this.extensionRangeBuilder_.getCount();
            }

            public ExtensionRange getExtensionRange(int index) {
                if (this.extensionRangeBuilder_ == null) {
                    return (ExtensionRange) this.extensionRange_.get(index);
                }
                return (ExtensionRange) this.extensionRangeBuilder_.getMessage(index);
            }

            public Builder setExtensionRange(int index, ExtensionRange value) {
                if (this.extensionRangeBuilder_ != null) {
                    this.extensionRangeBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setExtensionRange(int index, Builder builderForValue) {
                if (this.extensionRangeBuilder_ == null) {
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExtensionRange(ExtensionRange value) {
                if (this.extensionRangeBuilder_ != null) {
                    this.extensionRangeBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtensionRange(int index, ExtensionRange value) {
                if (this.extensionRangeBuilder_ != null) {
                    this.extensionRangeBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtensionRange(Builder builderForValue) {
                if (this.extensionRangeBuilder_ == null) {
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExtensionRange(int index, Builder builderForValue) {
                if (this.extensionRangeBuilder_ == null) {
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExtensionRange(Iterable<? extends ExtensionRange> values) {
                if (this.extensionRangeBuilder_ == null) {
                    ensureExtensionRangeIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.extensionRange_);
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExtensionRange() {
                if (this.extensionRangeBuilder_ == null) {
                    this.extensionRange_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.clear();
                }
                return this;
            }

            public Builder removeExtensionRange(int index) {
                if (this.extensionRangeBuilder_ == null) {
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.remove(index);
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.remove(index);
                }
                return this;
            }

            public Builder getExtensionRangeBuilder(int index) {
                return (Builder) getExtensionRangeFieldBuilder().getBuilder(index);
            }

            public ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int index) {
                if (this.extensionRangeBuilder_ == null) {
                    return (ExtensionRangeOrBuilder) this.extensionRange_.get(index);
                }
                return (ExtensionRangeOrBuilder) this.extensionRangeBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList() {
                if (this.extensionRangeBuilder_ != null) {
                    return this.extensionRangeBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.extensionRange_);
            }

            public Builder addExtensionRangeBuilder() {
                return (Builder) getExtensionRangeFieldBuilder().addBuilder(ExtensionRange.getDefaultInstance());
            }

            public Builder addExtensionRangeBuilder(int index) {
                return (Builder) getExtensionRangeFieldBuilder().addBuilder(index, ExtensionRange.getDefaultInstance());
            }

            public List<Builder> getExtensionRangeBuilderList() {
                return getExtensionRangeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ExtensionRange, Builder, ExtensionRangeOrBuilder> getExtensionRangeFieldBuilder() {
                if (this.extensionRangeBuilder_ == null) {
                    this.extensionRangeBuilder_ = new RepeatedFieldBuilder(this.extensionRange_, (this.bitField0_ & 32) == 32, getParentForChildren(), isClean());
                    this.extensionRange_ = null;
                }
                return this.extensionRangeBuilder_;
            }

            public boolean hasOptions() {
                return (this.bitField0_ & 64) == 64;
            }

            public MessageOptions getOptions() {
                if (this.optionsBuilder_ == null) {
                    return this.options_;
                }
                return (MessageOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(MessageOptions value) {
                if (this.optionsBuilder_ != null) {
                    this.optionsBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.options_ = value;
                    onChanged();
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeOptions(MessageOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & 64) != 64 || this.options_ == MessageOptions.getDefaultInstance()) {
                        this.options_ = value;
                    } else {
                        this.options_ = MessageOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = MessageOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -65;
                return this;
            }

            public Builder getOptionsBuilder() {
                this.bitField0_ |= 64;
                onChanged();
                return (Builder) getOptionsFieldBuilder().getBuilder();
            }

            public MessageOptionsOrBuilder getOptionsOrBuilder() {
                if (this.optionsBuilder_ != null) {
                    return (MessageOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder();
                }
                return this.options_;
            }

            private SingleFieldBuilder<MessageOptions, Builder, MessageOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }
        }

        public interface ExtensionRangeOrBuilder extends MessageOrBuilder {
            int getEnd();

            int getStart();

            boolean hasEnd();

            boolean hasStart();
        }

        public static final class ExtensionRange extends GeneratedMessage implements ExtensionRangeOrBuilder {
            public static final int END_FIELD_NUMBER = 2;
            public static final int START_FIELD_NUMBER = 1;
            private static final ExtensionRange defaultInstance;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int start_;

            public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements ExtensionRangeOrBuilder {
                private int bitField0_;
                private int end_;
                private int start_;

                public static final Descriptor getDescriptor() {
                    return DescriptorProtos.f444x1458f8d;
                }

                protected FieldAccessorTable internalGetFieldAccessorTable() {
                    return DescriptorProtos.f445xf366d90b;
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (!GeneratedMessage.alwaysUseFieldBuilders) {
                    }
                }

                private static Builder create() {
                    return new Builder();
                }

                public Builder clear() {
                    super.clear();
                    this.start_ = 0;
                    this.bitField0_ &= -2;
                    this.end_ = 0;
                    this.bitField0_ &= -3;
                    return this;
                }

                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Descriptor getDescriptorForType() {
                    return ExtensionRange.getDescriptor();
                }

                public ExtensionRange getDefaultInstanceForType() {
                    return ExtensionRange.getDefaultInstance();
                }

                public ExtensionRange build() {
                    ExtensionRange result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
                }

                private ExtensionRange buildParsed() throws InvalidProtocolBufferException {
                    ExtensionRange result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
                }

                public ExtensionRange buildPartial() {
                    ExtensionRange result = new ExtensionRange();
                    int from_bitField0_ = this.bitField0_;
                    int to_bitField0_ = 0;
                    if ((from_bitField0_ & ExtensionRange.START_FIELD_NUMBER) == ExtensionRange.START_FIELD_NUMBER) {
                        to_bitField0_ = 0 | ExtensionRange.START_FIELD_NUMBER;
                    }
                    result.start_ = this.start_;
                    if ((from_bitField0_ & ExtensionRange.END_FIELD_NUMBER) == ExtensionRange.END_FIELD_NUMBER) {
                        to_bitField0_ |= ExtensionRange.END_FIELD_NUMBER;
                    }
                    result.end_ = this.end_;
                    result.bitField0_ = to_bitField0_;
                    onBuilt();
                    return result;
                }

                public Builder mergeFrom(Message other) {
                    if (other instanceof ExtensionRange) {
                        return mergeFrom((ExtensionRange) other);
                    }
                    super.mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(ExtensionRange other) {
                    if (other != ExtensionRange.getDefaultInstance()) {
                        if (other.hasStart()) {
                            setStart(other.getStart());
                        }
                        if (other.hasEnd()) {
                            setEnd(other.getEnd());
                        }
                        mergeUnknownFields(other.getUnknownFields());
                    }
                    return this;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                    while (true) {
                        int tag = input.readTag();
                        switch (tag) {
                            case CharacterEscapes.ESCAPE_NONE /*0*/:
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            case PayPalActivity.VIEW_TEST /*8*/:
                                this.bitField0_ |= ExtensionRange.START_FIELD_NUMBER;
                                this.start_ = input.readInt32();
                                continue;
                            case Segment.TOKENS_PER_SEGMENT /*16*/:
                                this.bitField0_ |= ExtensionRange.END_FIELD_NUMBER;
                                this.end_ = input.readInt32();
                                continue;
                            default:
                                if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    setUnknownFields(unknownFields.build());
                                    onChanged();
                                    break;
                                }
                                continue;
                        }
                        return this;
                    }
                }

                public boolean hasStart() {
                    return (this.bitField0_ & ExtensionRange.START_FIELD_NUMBER) == ExtensionRange.START_FIELD_NUMBER;
                }

                public int getStart() {
                    return this.start_;
                }

                public Builder setStart(int value) {
                    this.bitField0_ |= ExtensionRange.START_FIELD_NUMBER;
                    this.start_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearStart() {
                    this.bitField0_ &= -2;
                    this.start_ = 0;
                    onChanged();
                    return this;
                }

                public boolean hasEnd() {
                    return (this.bitField0_ & ExtensionRange.END_FIELD_NUMBER) == ExtensionRange.END_FIELD_NUMBER;
                }

                public int getEnd() {
                    return this.end_;
                }

                public Builder setEnd(int value) {
                    this.bitField0_ |= ExtensionRange.END_FIELD_NUMBER;
                    this.end_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearEnd() {
                    this.bitField0_ &= -3;
                    this.end_ = 0;
                    onChanged();
                    return this;
                }
            }

            private ExtensionRange(Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            private ExtensionRange(boolean noInit) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            public static ExtensionRange getDefaultInstance() {
                return defaultInstance;
            }

            public ExtensionRange getDefaultInstanceForType() {
                return defaultInstance;
            }

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.f444x1458f8d;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f445xf366d90b;
            }

            public boolean hasStart() {
                return (this.bitField0_ & START_FIELD_NUMBER) == START_FIELD_NUMBER;
            }

            public int getStart() {
                return this.start_;
            }

            public boolean hasEnd() {
                return (this.bitField0_ & END_FIELD_NUMBER) == END_FIELD_NUMBER;
            }

            public int getEnd() {
                return this.end_;
            }

            private void initFields() {
                this.start_ = 0;
                this.end_ = 0;
            }

            public final boolean isInitialized() {
                byte isInitialized = this.memoizedIsInitialized;
                if (isInitialized == -1) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                } else if (isInitialized == (byte) 1) {
                    return true;
                } else {
                    return false;
                }
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & START_FIELD_NUMBER) == START_FIELD_NUMBER) {
                    output.writeInt32(START_FIELD_NUMBER, this.start_);
                }
                if ((this.bitField0_ & END_FIELD_NUMBER) == END_FIELD_NUMBER) {
                    output.writeInt32(END_FIELD_NUMBER, this.end_);
                }
                getUnknownFields().writeTo(output);
            }

            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                size = 0;
                if ((this.bitField0_ & START_FIELD_NUMBER) == START_FIELD_NUMBER) {
                    size = 0 + CodedOutputStream.computeInt32Size(START_FIELD_NUMBER, this.start_);
                }
                if ((this.bitField0_ & END_FIELD_NUMBER) == END_FIELD_NUMBER) {
                    size += CodedOutputStream.computeInt32Size(END_FIELD_NUMBER, this.end_);
                }
                size += getUnknownFields().getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }

            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static ExtensionRange parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            public static ExtensionRange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            public static ExtensionRange parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            public static ExtensionRange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            public static ExtensionRange parseFrom(InputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static ExtensionRange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
            }

            public static ExtensionRange parseDelimitedFrom(InputStream input) throws IOException {
                Builder builder = newBuilder();
                if (builder.mergeDelimitedFrom(input)) {
                    return builder.buildParsed();
                }
                return null;
            }

            public static ExtensionRange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Builder builder = newBuilder();
                if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                    return builder.buildParsed();
                }
                return null;
            }

            public static ExtensionRange parseFrom(CodedInputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static ExtensionRange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(ExtensionRange prototype) {
                return newBuilder().mergeFrom(prototype);
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }

            protected Builder newBuilderForType(BuilderParent parent) {
                return new Builder(null);
            }

            static {
                defaultInstance = new ExtensionRange(true);
                defaultInstance.initFields();
            }
        }

        private DescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private DescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static DescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public DescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f446x907d0bf0;
        }

        public boolean hasName() {
            return (this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER;
        }

        public String getName() {
            ByteString ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        public List<FieldDescriptorProto> getFieldList() {
            return this.field_;
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getFieldOrBuilderList() {
            return this.field_;
        }

        public int getFieldCount() {
            return this.field_.size();
        }

        public FieldDescriptorProto getField(int index) {
            return (FieldDescriptorProto) this.field_.get(index);
        }

        public FieldDescriptorProtoOrBuilder getFieldOrBuilder(int index) {
            return (FieldDescriptorProtoOrBuilder) this.field_.get(index);
        }

        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        public int getExtensionCount() {
            return this.extension_.size();
        }

        public FieldDescriptorProto getExtension(int index) {
            return (FieldDescriptorProto) this.extension_.get(index);
        }

        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index) {
            return (FieldDescriptorProtoOrBuilder) this.extension_.get(index);
        }

        public List<DescriptorProto> getNestedTypeList() {
            return this.nestedType_;
        }

        public List<? extends DescriptorProtoOrBuilder> getNestedTypeOrBuilderList() {
            return this.nestedType_;
        }

        public int getNestedTypeCount() {
            return this.nestedType_.size();
        }

        public DescriptorProto getNestedType(int index) {
            return (DescriptorProto) this.nestedType_.get(index);
        }

        public DescriptorProtoOrBuilder getNestedTypeOrBuilder(int index) {
            return (DescriptorProtoOrBuilder) this.nestedType_.get(index);
        }

        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        public EnumDescriptorProto getEnumType(int index) {
            return (EnumDescriptorProto) this.enumType_.get(index);
        }

        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index) {
            return (EnumDescriptorProtoOrBuilder) this.enumType_.get(index);
        }

        public List<ExtensionRange> getExtensionRangeList() {
            return this.extensionRange_;
        }

        public List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList() {
            return this.extensionRange_;
        }

        public int getExtensionRangeCount() {
            return this.extensionRange_.size();
        }

        public ExtensionRange getExtensionRange(int index) {
            return (ExtensionRange) this.extensionRange_.get(index);
        }

        public ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int index) {
            return (ExtensionRangeOrBuilder) this.extensionRange_.get(index);
        }

        public boolean hasOptions() {
            return (this.bitField0_ & FIELD_FIELD_NUMBER) == FIELD_FIELD_NUMBER;
        }

        public MessageOptions getOptions() {
            return this.options_;
        }

        public MessageOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        private void initFields() {
            this.name_ = StringUtil.EMPTY_STRING;
            this.field_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.nestedType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.extensionRange_ = Collections.emptyList();
            this.options_ = MessageOptions.getDefaultInstance();
        }

        public final boolean isInitialized() {
            boolean z = true;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                if (isInitialized != (byte) 1) {
                    z = false;
                }
                return z;
            }
            int i = 0;
            while (i < getFieldCount()) {
                if (getField(i).isInitialized()) {
                    i += NAME_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getExtensionCount()) {
                if (getExtension(i).isInitialized()) {
                    i += NAME_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getNestedTypeCount()) {
                if (getNestedType(i).isInitialized()) {
                    i += NAME_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getEnumTypeCount()) {
                if (getEnumType(i).isInitialized()) {
                    i += NAME_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            int i;
            getSerializedSize();
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                output.writeBytes(NAME_FIELD_NUMBER, getNameBytes());
            }
            for (i = 0; i < this.field_.size(); i += NAME_FIELD_NUMBER) {
                output.writeMessage(FIELD_FIELD_NUMBER, (MessageLite) this.field_.get(i));
            }
            for (i = 0; i < this.nestedType_.size(); i += NAME_FIELD_NUMBER) {
                output.writeMessage(NESTED_TYPE_FIELD_NUMBER, (MessageLite) this.nestedType_.get(i));
            }
            for (i = 0; i < this.enumType_.size(); i += NAME_FIELD_NUMBER) {
                output.writeMessage(ENUM_TYPE_FIELD_NUMBER, (MessageLite) this.enumType_.get(i));
            }
            for (i = 0; i < this.extensionRange_.size(); i += NAME_FIELD_NUMBER) {
                output.writeMessage(EXTENSION_RANGE_FIELD_NUMBER, (MessageLite) this.extensionRange_.get(i));
            }
            for (i = 0; i < this.extension_.size(); i += NAME_FIELD_NUMBER) {
                output.writeMessage(EXTENSION_FIELD_NUMBER, (MessageLite) this.extension_.get(i));
            }
            if ((this.bitField0_ & FIELD_FIELD_NUMBER) == FIELD_FIELD_NUMBER) {
                output.writeMessage(OPTIONS_FIELD_NUMBER, this.options_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int i;
            size = 0;
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeBytesSize(NAME_FIELD_NUMBER, getNameBytes());
            }
            for (i = 0; i < this.field_.size(); i += NAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(FIELD_FIELD_NUMBER, (MessageLite) this.field_.get(i));
            }
            for (i = 0; i < this.nestedType_.size(); i += NAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(NESTED_TYPE_FIELD_NUMBER, (MessageLite) this.nestedType_.get(i));
            }
            for (i = 0; i < this.enumType_.size(); i += NAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(ENUM_TYPE_FIELD_NUMBER, (MessageLite) this.enumType_.get(i));
            }
            for (i = 0; i < this.extensionRange_.size(); i += NAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(EXTENSION_RANGE_FIELD_NUMBER, (MessageLite) this.extensionRange_.get(i));
            }
            for (i = 0; i < this.extension_.size(); i += NAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(EXTENSION_FIELD_NUMBER, (MessageLite) this.extension_.get(i));
            }
            if ((this.bitField0_ & FIELD_FIELD_NUMBER) == FIELD_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(OPTIONS_FIELD_NUMBER, this.options_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static DescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static DescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static DescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static DescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static DescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static DescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static DescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static DescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static DescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new DescriptorProto(true);
            defaultInstance.initFields();
        }
    }

    public interface EnumDescriptorProtoOrBuilder extends MessageOrBuilder {
        String getName();

        EnumOptions getOptions();

        EnumOptionsOrBuilder getOptionsOrBuilder();

        EnumValueDescriptorProto getValue(int i);

        int getValueCount();

        List<EnumValueDescriptorProto> getValueList();

        EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int i);

        List<? extends EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList();

        boolean hasName();

        boolean hasOptions();
    }

    public static final class EnumDescriptorProto extends GeneratedMessage implements EnumDescriptorProtoOrBuilder {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final EnumDescriptorProto defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private EnumOptions options_;
        private List<EnumValueDescriptorProto> value_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements EnumDescriptorProtoOrBuilder {
            private int bitField0_;
            private Object name_;
            private SingleFieldBuilder<EnumOptions, Builder, EnumOptionsOrBuilder> optionsBuilder_;
            private EnumOptions options_;
            private RepeatedFieldBuilder<EnumValueDescriptorProto, Builder, EnumValueDescriptorProtoOrBuilder> valueBuilder_;
            private List<EnumValueDescriptorProto> value_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f447x9945f651;
            }

            private Builder() {
                this.name_ = StringUtil.EMPTY_STRING;
                this.value_ = Collections.emptyList();
                this.options_ = EnumOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.name_ = StringUtil.EMPTY_STRING;
                this.value_ = Collections.emptyList();
                this.options_ = EnumOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getValueFieldBuilder();
                    getOptionsFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.name_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -2;
                if (this.valueBuilder_ == null) {
                    this.value_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.valueBuilder_.clear();
                }
                if (this.optionsBuilder_ == null) {
                    this.options_ = EnumOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return EnumDescriptorProto.getDescriptor();
            }

            public EnumDescriptorProto getDefaultInstanceForType() {
                return EnumDescriptorProto.getDefaultInstance();
            }

            public EnumDescriptorProto build() {
                EnumDescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private EnumDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                EnumDescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public EnumDescriptorProto buildPartial() {
                EnumDescriptorProto result = new EnumDescriptorProto();
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & EnumDescriptorProto.NAME_FIELD_NUMBER) == EnumDescriptorProto.NAME_FIELD_NUMBER) {
                    to_bitField0_ = 0 | EnumDescriptorProto.NAME_FIELD_NUMBER;
                }
                result.name_ = this.name_;
                if (this.valueBuilder_ == null) {
                    if ((this.bitField0_ & EnumDescriptorProto.VALUE_FIELD_NUMBER) == EnumDescriptorProto.VALUE_FIELD_NUMBER) {
                        this.value_ = Collections.unmodifiableList(this.value_);
                        this.bitField0_ &= -3;
                    }
                    result.value_ = this.value_;
                } else {
                    result.value_ = this.valueBuilder_.build();
                }
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= EnumDescriptorProto.VALUE_FIELD_NUMBER;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (EnumOptions) this.optionsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof EnumDescriptorProto) {
                    return mergeFrom((EnumDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnumDescriptorProto other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != EnumDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (this.valueBuilder_ == null) {
                        if (!other.value_.isEmpty()) {
                            if (this.value_.isEmpty()) {
                                this.value_ = other.value_;
                                this.bitField0_ &= -3;
                            } else {
                                ensureValueIsMutable();
                                this.value_.addAll(other.value_);
                            }
                            onChanged();
                        }
                    } else if (!other.value_.isEmpty()) {
                        if (this.valueBuilder_.isEmpty()) {
                            this.valueBuilder_.dispose();
                            this.valueBuilder_ = null;
                            this.value_ = other.value_;
                            this.bitField0_ &= -3;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getValueFieldBuilder();
                            }
                            this.valueBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.valueBuilder_.addAllMessages(other.value_);
                        }
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getValueCount(); i += EnumDescriptorProto.NAME_FIELD_NUMBER) {
                    if (!getValue(i).isInitialized()) {
                        return false;
                    }
                }
                if (!hasOptions() || getOptions().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                            this.bitField0_ |= EnumDescriptorProto.NAME_FIELD_NUMBER;
                            this.name_ = input.readBytes();
                            continue;
                        case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                            Builder subBuilder = EnumValueDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addValue(subBuilder.buildPartial());
                            continue;
                        case 26:
                            Builder subBuilder2 = EnumOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder2.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder2, extensionRegistry);
                            setOptions(subBuilder2.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasName() {
                return (this.bitField0_ & EnumDescriptorProto.NAME_FIELD_NUMBER) == EnumDescriptorProto.NAME_FIELD_NUMBER;
            }

            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= EnumDescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = EnumDescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= EnumDescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
            }

            private void ensureValueIsMutable() {
                if ((this.bitField0_ & EnumDescriptorProto.VALUE_FIELD_NUMBER) != EnumDescriptorProto.VALUE_FIELD_NUMBER) {
                    this.value_ = new ArrayList(this.value_);
                    this.bitField0_ |= EnumDescriptorProto.VALUE_FIELD_NUMBER;
                }
            }

            public List<EnumValueDescriptorProto> getValueList() {
                if (this.valueBuilder_ == null) {
                    return Collections.unmodifiableList(this.value_);
                }
                return this.valueBuilder_.getMessageList();
            }

            public int getValueCount() {
                if (this.valueBuilder_ == null) {
                    return this.value_.size();
                }
                return this.valueBuilder_.getCount();
            }

            public EnumValueDescriptorProto getValue(int index) {
                if (this.valueBuilder_ == null) {
                    return (EnumValueDescriptorProto) this.value_.get(index);
                }
                return (EnumValueDescriptorProto) this.valueBuilder_.getMessage(index);
            }

            public Builder setValue(int index, EnumValueDescriptorProto value) {
                if (this.valueBuilder_ != null) {
                    this.valueBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureValueIsMutable();
                    this.value_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setValue(int index, Builder builderForValue) {
                if (this.valueBuilder_ == null) {
                    ensureValueIsMutable();
                    this.value_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.valueBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addValue(EnumValueDescriptorProto value) {
                if (this.valueBuilder_ != null) {
                    this.valueBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureValueIsMutable();
                    this.value_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addValue(int index, EnumValueDescriptorProto value) {
                if (this.valueBuilder_ != null) {
                    this.valueBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureValueIsMutable();
                    this.value_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addValue(Builder builderForValue) {
                if (this.valueBuilder_ == null) {
                    ensureValueIsMutable();
                    this.value_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.valueBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addValue(int index, Builder builderForValue) {
                if (this.valueBuilder_ == null) {
                    ensureValueIsMutable();
                    this.value_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.valueBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllValue(Iterable<? extends EnumValueDescriptorProto> values) {
                if (this.valueBuilder_ == null) {
                    ensureValueIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.value_);
                    onChanged();
                } else {
                    this.valueBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearValue() {
                if (this.valueBuilder_ == null) {
                    this.value_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.valueBuilder_.clear();
                }
                return this;
            }

            public Builder removeValue(int index) {
                if (this.valueBuilder_ == null) {
                    ensureValueIsMutable();
                    this.value_.remove(index);
                    onChanged();
                } else {
                    this.valueBuilder_.remove(index);
                }
                return this;
            }

            public Builder getValueBuilder(int index) {
                return (Builder) getValueFieldBuilder().getBuilder(index);
            }

            public EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int index) {
                if (this.valueBuilder_ == null) {
                    return (EnumValueDescriptorProtoOrBuilder) this.value_.get(index);
                }
                return (EnumValueDescriptorProtoOrBuilder) this.valueBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList() {
                if (this.valueBuilder_ != null) {
                    return this.valueBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.value_);
            }

            public Builder addValueBuilder() {
                return (Builder) getValueFieldBuilder().addBuilder(EnumValueDescriptorProto.getDefaultInstance());
            }

            public Builder addValueBuilder(int index) {
                return (Builder) getValueFieldBuilder().addBuilder(index, EnumValueDescriptorProto.getDefaultInstance());
            }

            public List<Builder> getValueBuilderList() {
                return getValueFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<EnumValueDescriptorProto, Builder, EnumValueDescriptorProtoOrBuilder> getValueFieldBuilder() {
                if (this.valueBuilder_ == null) {
                    this.valueBuilder_ = new RepeatedFieldBuilder(this.value_, (this.bitField0_ & EnumDescriptorProto.VALUE_FIELD_NUMBER) == EnumDescriptorProto.VALUE_FIELD_NUMBER, getParentForChildren(), isClean());
                    this.value_ = null;
                }
                return this.valueBuilder_;
            }

            public boolean hasOptions() {
                return (this.bitField0_ & 4) == 4;
            }

            public EnumOptions getOptions() {
                if (this.optionsBuilder_ == null) {
                    return this.options_;
                }
                return (EnumOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(EnumOptions value) {
                if (this.optionsBuilder_ != null) {
                    this.optionsBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.options_ = value;
                    onChanged();
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeOptions(EnumOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 4 || this.options_ == EnumOptions.getDefaultInstance()) {
                        this.options_ = value;
                    } else {
                        this.options_ = EnumOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = EnumOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            public Builder getOptionsBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return (Builder) getOptionsFieldBuilder().getBuilder();
            }

            public EnumOptionsOrBuilder getOptionsOrBuilder() {
                if (this.optionsBuilder_ != null) {
                    return (EnumOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder();
                }
                return this.options_;
            }

            private SingleFieldBuilder<EnumOptions, Builder, EnumOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }
        }

        private EnumDescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private EnumDescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static EnumDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public EnumDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f447x9945f651;
        }

        public boolean hasName() {
            return (this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER;
        }

        public String getName() {
            ByteString ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        public List<EnumValueDescriptorProto> getValueList() {
            return this.value_;
        }

        public List<? extends EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList() {
            return this.value_;
        }

        public int getValueCount() {
            return this.value_.size();
        }

        public EnumValueDescriptorProto getValue(int index) {
            return (EnumValueDescriptorProto) this.value_.get(index);
        }

        public EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int index) {
            return (EnumValueDescriptorProtoOrBuilder) this.value_.get(index);
        }

        public boolean hasOptions() {
            return (this.bitField0_ & VALUE_FIELD_NUMBER) == VALUE_FIELD_NUMBER;
        }

        public EnumOptions getOptions() {
            return this.options_;
        }

        public EnumOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        private void initFields() {
            this.name_ = StringUtil.EMPTY_STRING;
            this.value_ = Collections.emptyList();
            this.options_ = EnumOptions.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getValueCount()) {
                    if (getValue(i).isInitialized()) {
                        i += NAME_FIELD_NUMBER;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!hasOptions() || getOptions().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                output.writeBytes(NAME_FIELD_NUMBER, getNameBytes());
            }
            for (int i = 0; i < this.value_.size(); i += NAME_FIELD_NUMBER) {
                output.writeMessage(VALUE_FIELD_NUMBER, (MessageLite) this.value_.get(i));
            }
            if ((this.bitField0_ & VALUE_FIELD_NUMBER) == VALUE_FIELD_NUMBER) {
                output.writeMessage(OPTIONS_FIELD_NUMBER, this.options_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeBytesSize(NAME_FIELD_NUMBER, getNameBytes());
            }
            for (int i = 0; i < this.value_.size(); i += NAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(VALUE_FIELD_NUMBER, (MessageLite) this.value_.get(i));
            }
            if ((this.bitField0_ & VALUE_FIELD_NUMBER) == VALUE_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(OPTIONS_FIELD_NUMBER, this.options_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static EnumDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new EnumDescriptorProto(true);
            defaultInstance.initFields();
        }
    }

    public interface EnumOptionsOrBuilder extends ExtendableMessageOrBuilder<EnumOptions> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    }

    public static final class EnumOptions extends ExtendableMessage<EnumOptions> implements EnumOptionsOrBuilder {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final EnumOptions defaultInstance;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<EnumOptions, Builder> implements EnumOptionsOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
            }

            private Builder() {
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return EnumOptions.getDescriptor();
            }

            public EnumOptions getDefaultInstanceForType() {
                return EnumOptions.getDefaultInstance();
            }

            public EnumOptions build() {
                EnumOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private EnumOptions buildParsed() throws InvalidProtocolBufferException {
                EnumOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public EnumOptions buildPartial() {
                EnumOptions result = new EnumOptions();
                int from_bitField0_ = this.bitField0_;
                if (this.uninterpretedOptionBuilder_ == null) {
                    if ((this.bitField0_ & 1) == 1) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -2;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                } else {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof EnumOptions) {
                    return mergeFrom((EnumOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnumOptions other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != EnumOptions.getDefaultInstance()) {
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -2;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getUninterpretedOptionFieldBuilder();
                            }
                            this.uninterpretedOptionBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 1;
                }
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return Collections.unmodifiableList(this.uninterpretedOption_);
                }
                return this.uninterpretedOptionBuilder_.getMessageList();
            }

            public int getUninterpretedOptionCount() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return this.uninterpretedOption_.size();
                }
                return this.uninterpretedOptionBuilder_.getCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOption) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public Builder getUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                if (this.uninterpretedOptionBuilder_ != null) {
                    return this.uninterpretedOptionBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public Builder addUninterpretedOptionBuilder() {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public Builder addUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                boolean z = true;
                if (this.uninterpretedOptionBuilder_ == null) {
                    List list = this.uninterpretedOption_;
                    if ((this.bitField0_ & 1) != 1) {
                        z = false;
                    }
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        private EnumOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private EnumOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static EnumOptions getDefaultInstance() {
            return defaultInstance;
        }

        public EnumOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getUninterpretedOptionCount()) {
                    if (getUninterpretedOption(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            ExtensionWriter extensionWriter = newExtensionWriter();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            extensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static EnumOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static EnumOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static EnumOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new EnumOptions(true);
            defaultInstance.initFields();
        }
    }

    public interface EnumValueDescriptorProtoOrBuilder extends MessageOrBuilder {
        String getName();

        int getNumber();

        EnumValueOptions getOptions();

        EnumValueOptionsOrBuilder getOptionsOrBuilder();

        boolean hasName();

        boolean hasNumber();

        boolean hasOptions();
    }

    public static final class EnumValueDescriptorProto extends GeneratedMessage implements EnumValueDescriptorProtoOrBuilder {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static final EnumValueDescriptorProto defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private int number_;
        private EnumValueOptions options_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements EnumValueDescriptorProtoOrBuilder {
            private int bitField0_;
            private Object name_;
            private int number_;
            private SingleFieldBuilder<EnumValueOptions, Builder, EnumValueOptionsOrBuilder> optionsBuilder_;
            private EnumValueOptions options_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.f448xf18031a8;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f449xfb173026;
            }

            private Builder() {
                this.name_ = StringUtil.EMPTY_STRING;
                this.options_ = EnumValueOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.name_ = StringUtil.EMPTY_STRING;
                this.options_ = EnumValueOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getOptionsFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.name_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -2;
                this.number_ = 0;
                this.bitField0_ &= -3;
                if (this.optionsBuilder_ == null) {
                    this.options_ = EnumValueOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return EnumValueDescriptorProto.getDescriptor();
            }

            public EnumValueDescriptorProto getDefaultInstanceForType() {
                return EnumValueDescriptorProto.getDefaultInstance();
            }

            public EnumValueDescriptorProto build() {
                EnumValueDescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private EnumValueDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                EnumValueDescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public EnumValueDescriptorProto buildPartial() {
                EnumValueDescriptorProto result = new EnumValueDescriptorProto();
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & EnumValueDescriptorProto.NAME_FIELD_NUMBER) == EnumValueDescriptorProto.NAME_FIELD_NUMBER) {
                    to_bitField0_ = 0 | EnumValueDescriptorProto.NAME_FIELD_NUMBER;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & EnumValueDescriptorProto.NUMBER_FIELD_NUMBER) == EnumValueDescriptorProto.NUMBER_FIELD_NUMBER) {
                    to_bitField0_ |= EnumValueDescriptorProto.NUMBER_FIELD_NUMBER;
                }
                result.number_ = this.number_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (EnumValueOptions) this.optionsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof EnumValueDescriptorProto) {
                    return mergeFrom((EnumValueDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnumValueDescriptorProto other) {
                if (other != EnumValueDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasNumber()) {
                        setNumber(other.getNumber());
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                if (!hasOptions() || getOptions().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                            this.bitField0_ |= EnumValueDescriptorProto.NAME_FIELD_NUMBER;
                            this.name_ = input.readBytes();
                            continue;
                        case Segment.TOKENS_PER_SEGMENT /*16*/:
                            this.bitField0_ |= EnumValueDescriptorProto.NUMBER_FIELD_NUMBER;
                            this.number_ = input.readInt32();
                            continue;
                        case 26:
                            Builder subBuilder = EnumValueOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder, extensionRegistry);
                            setOptions(subBuilder.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasName() {
                return (this.bitField0_ & EnumValueDescriptorProto.NAME_FIELD_NUMBER) == EnumValueDescriptorProto.NAME_FIELD_NUMBER;
            }

            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= EnumValueDescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = EnumValueDescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= EnumValueDescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
            }

            public boolean hasNumber() {
                return (this.bitField0_ & EnumValueDescriptorProto.NUMBER_FIELD_NUMBER) == EnumValueDescriptorProto.NUMBER_FIELD_NUMBER;
            }

            public int getNumber() {
                return this.number_;
            }

            public Builder setNumber(int value) {
                this.bitField0_ |= EnumValueDescriptorProto.NUMBER_FIELD_NUMBER;
                this.number_ = value;
                onChanged();
                return this;
            }

            public Builder clearNumber() {
                this.bitField0_ &= -3;
                this.number_ = 0;
                onChanged();
                return this;
            }

            public boolean hasOptions() {
                return (this.bitField0_ & 4) == 4;
            }

            public EnumValueOptions getOptions() {
                if (this.optionsBuilder_ == null) {
                    return this.options_;
                }
                return (EnumValueOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(EnumValueOptions value) {
                if (this.optionsBuilder_ != null) {
                    this.optionsBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.options_ = value;
                    onChanged();
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeOptions(EnumValueOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 4 || this.options_ == EnumValueOptions.getDefaultInstance()) {
                        this.options_ = value;
                    } else {
                        this.options_ = EnumValueOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = EnumValueOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            public Builder getOptionsBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return (Builder) getOptionsFieldBuilder().getBuilder();
            }

            public EnumValueOptionsOrBuilder getOptionsOrBuilder() {
                if (this.optionsBuilder_ != null) {
                    return (EnumValueOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder();
                }
                return this.options_;
            }

            private SingleFieldBuilder<EnumValueOptions, Builder, EnumValueOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }
        }

        private EnumValueDescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private EnumValueDescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static EnumValueDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public EnumValueDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.f448xf18031a8;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f449xfb173026;
        }

        public boolean hasName() {
            return (this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER;
        }

        public String getName() {
            ByteString ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        public boolean hasNumber() {
            return (this.bitField0_ & NUMBER_FIELD_NUMBER) == NUMBER_FIELD_NUMBER;
        }

        public int getNumber() {
            return this.number_;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 4) == 4;
        }

        public EnumValueOptions getOptions() {
            return this.options_;
        }

        public EnumValueOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        private void initFields() {
            this.name_ = StringUtil.EMPTY_STRING;
            this.number_ = 0;
            this.options_ = EnumValueOptions.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                if (isInitialized == (byte) 1) {
                    return true;
                }
                return false;
            } else if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                output.writeBytes(NAME_FIELD_NUMBER, getNameBytes());
            }
            if ((this.bitField0_ & NUMBER_FIELD_NUMBER) == NUMBER_FIELD_NUMBER) {
                output.writeInt32(NUMBER_FIELD_NUMBER, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(OPTIONS_FIELD_NUMBER, this.options_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeBytesSize(NAME_FIELD_NUMBER, getNameBytes());
            }
            if ((this.bitField0_ & NUMBER_FIELD_NUMBER) == NUMBER_FIELD_NUMBER) {
                size += CodedOutputStream.computeInt32Size(NUMBER_FIELD_NUMBER, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeMessageSize(OPTIONS_FIELD_NUMBER, this.options_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static EnumValueDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumValueDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new EnumValueDescriptorProto(true);
            defaultInstance.initFields();
        }
    }

    public interface EnumValueOptionsOrBuilder extends ExtendableMessageOrBuilder<EnumValueOptions> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    }

    public static final class EnumValueOptions extends ExtendableMessage<EnumValueOptions> implements EnumValueOptionsOrBuilder {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final EnumValueOptions defaultInstance;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f450xdf65a421;
            }

            private Builder() {
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return EnumValueOptions.getDescriptor();
            }

            public EnumValueOptions getDefaultInstanceForType() {
                return EnumValueOptions.getDefaultInstance();
            }

            public EnumValueOptions build() {
                EnumValueOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private EnumValueOptions buildParsed() throws InvalidProtocolBufferException {
                EnumValueOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public EnumValueOptions buildPartial() {
                EnumValueOptions result = new EnumValueOptions();
                int from_bitField0_ = this.bitField0_;
                if (this.uninterpretedOptionBuilder_ == null) {
                    if ((this.bitField0_ & 1) == 1) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -2;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                } else {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof EnumValueOptions) {
                    return mergeFrom((EnumValueOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnumValueOptions other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != EnumValueOptions.getDefaultInstance()) {
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -2;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getUninterpretedOptionFieldBuilder();
                            }
                            this.uninterpretedOptionBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 1;
                }
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return Collections.unmodifiableList(this.uninterpretedOption_);
                }
                return this.uninterpretedOptionBuilder_.getMessageList();
            }

            public int getUninterpretedOptionCount() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return this.uninterpretedOption_.size();
                }
                return this.uninterpretedOptionBuilder_.getCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOption) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public Builder getUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                if (this.uninterpretedOptionBuilder_ != null) {
                    return this.uninterpretedOptionBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public Builder addUninterpretedOptionBuilder() {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public Builder addUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                boolean z = true;
                if (this.uninterpretedOptionBuilder_ == null) {
                    List list = this.uninterpretedOption_;
                    if ((this.bitField0_ & 1) != 1) {
                        z = false;
                    }
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        private EnumValueOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private EnumValueOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static EnumValueOptions getDefaultInstance() {
            return defaultInstance;
        }

        public EnumValueOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f450xdf65a421;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getUninterpretedOptionCount()) {
                    if (getUninterpretedOption(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            ExtensionWriter extensionWriter = newExtensionWriter();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            extensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static EnumValueOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumValueOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumValueOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumValueOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumValueOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumValueOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static EnumValueOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumValueOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumValueOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new EnumValueOptions(true);
            defaultInstance.initFields();
        }
    }

    public interface FieldDescriptorProtoOrBuilder extends MessageOrBuilder {
        String getDefaultValue();

        String getExtendee();

        Label getLabel();

        String getName();

        int getNumber();

        FieldOptions getOptions();

        FieldOptionsOrBuilder getOptionsOrBuilder();

        Type getType();

        String getTypeName();

        boolean hasDefaultValue();

        boolean hasExtendee();

        boolean hasLabel();

        boolean hasName();

        boolean hasNumber();

        boolean hasOptions();

        boolean hasType();

        boolean hasTypeName();
    }

    public static final class FieldDescriptorProto extends GeneratedMessage implements FieldDescriptorProtoOrBuilder {
        public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
        public static final int EXTENDEE_FIELD_NUMBER = 2;
        public static final int LABEL_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 3;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int TYPE_NAME_FIELD_NUMBER = 6;
        private static final FieldDescriptorProto defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object defaultValue_;
        private Object extendee_;
        private Label label_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private int number_;
        private FieldOptions options_;
        private Object typeName_;
        private Type type_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements FieldDescriptorProtoOrBuilder {
            private int bitField0_;
            private Object defaultValue_;
            private Object extendee_;
            private Label label_;
            private Object name_;
            private int number_;
            private SingleFieldBuilder<FieldOptions, Builder, FieldOptionsOrBuilder> optionsBuilder_;
            private FieldOptions options_;
            private Object typeName_;
            private Type type_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f451x4734b330;
            }

            private Builder() {
                this.name_ = StringUtil.EMPTY_STRING;
                this.label_ = Label.LABEL_OPTIONAL;
                this.type_ = Type.TYPE_DOUBLE;
                this.typeName_ = StringUtil.EMPTY_STRING;
                this.extendee_ = StringUtil.EMPTY_STRING;
                this.defaultValue_ = StringUtil.EMPTY_STRING;
                this.options_ = FieldOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.name_ = StringUtil.EMPTY_STRING;
                this.label_ = Label.LABEL_OPTIONAL;
                this.type_ = Type.TYPE_DOUBLE;
                this.typeName_ = StringUtil.EMPTY_STRING;
                this.extendee_ = StringUtil.EMPTY_STRING;
                this.defaultValue_ = StringUtil.EMPTY_STRING;
                this.options_ = FieldOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getOptionsFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.name_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -2;
                this.number_ = 0;
                this.bitField0_ &= -3;
                this.label_ = Label.LABEL_OPTIONAL;
                this.bitField0_ &= -5;
                this.type_ = Type.TYPE_DOUBLE;
                this.bitField0_ &= -9;
                this.typeName_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -17;
                this.extendee_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -33;
                this.defaultValue_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -65;
                if (this.optionsBuilder_ == null) {
                    this.options_ = FieldOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -129;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return FieldDescriptorProto.getDescriptor();
            }

            public FieldDescriptorProto getDefaultInstanceForType() {
                return FieldDescriptorProto.getDefaultInstance();
            }

            public FieldDescriptorProto build() {
                FieldDescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private FieldDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                FieldDescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public FieldDescriptorProto buildPartial() {
                FieldDescriptorProto result = new FieldDescriptorProto();
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & FieldDescriptorProto.NAME_FIELD_NUMBER) == FieldDescriptorProto.NAME_FIELD_NUMBER) {
                    to_bitField0_ = 0 | FieldDescriptorProto.NAME_FIELD_NUMBER;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & FieldDescriptorProto.EXTENDEE_FIELD_NUMBER) == FieldDescriptorProto.EXTENDEE_FIELD_NUMBER) {
                    to_bitField0_ |= FieldDescriptorProto.EXTENDEE_FIELD_NUMBER;
                }
                result.number_ = this.number_;
                if ((from_bitField0_ & FieldDescriptorProto.LABEL_FIELD_NUMBER) == FieldDescriptorProto.LABEL_FIELD_NUMBER) {
                    to_bitField0_ |= FieldDescriptorProto.LABEL_FIELD_NUMBER;
                }
                result.label_ = this.label_;
                if ((from_bitField0_ & FieldDescriptorProto.OPTIONS_FIELD_NUMBER) == FieldDescriptorProto.OPTIONS_FIELD_NUMBER) {
                    to_bitField0_ |= FieldDescriptorProto.OPTIONS_FIELD_NUMBER;
                }
                result.type_ = this.type_;
                if ((from_bitField0_ & 16) == 16) {
                    to_bitField0_ |= 16;
                }
                result.typeName_ = this.typeName_;
                if ((from_bitField0_ & 32) == 32) {
                    to_bitField0_ |= 32;
                }
                result.extendee_ = this.extendee_;
                if ((from_bitField0_ & 64) == 64) {
                    to_bitField0_ |= 64;
                }
                result.defaultValue_ = this.defaultValue_;
                if ((from_bitField0_ & XMLChar.MASK_NCNAME) == XMLChar.MASK_NCNAME) {
                    to_bitField0_ |= XMLChar.MASK_NCNAME;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (FieldOptions) this.optionsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FieldDescriptorProto) {
                    return mergeFrom((FieldDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FieldDescriptorProto other) {
                if (other != FieldDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasNumber()) {
                        setNumber(other.getNumber());
                    }
                    if (other.hasLabel()) {
                        setLabel(other.getLabel());
                    }
                    if (other.hasType()) {
                        setType(other.getType());
                    }
                    if (other.hasTypeName()) {
                        setTypeName(other.getTypeName());
                    }
                    if (other.hasExtendee()) {
                        setExtendee(other.getExtendee());
                    }
                    if (other.hasDefaultValue()) {
                        setDefaultValue(other.getDefaultValue());
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                if (!hasOptions() || getOptions().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    int rawValue;
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                            this.bitField0_ |= FieldDescriptorProto.NAME_FIELD_NUMBER;
                            this.name_ = input.readBytes();
                            continue;
                        case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                            this.bitField0_ |= 32;
                            this.extendee_ = input.readBytes();
                            continue;
                        case 24:
                            this.bitField0_ |= FieldDescriptorProto.EXTENDEE_FIELD_NUMBER;
                            this.number_ = input.readInt32();
                            continue;
                        case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                            rawValue = input.readEnum();
                            Label value = Label.valueOf(rawValue);
                            if (value != null) {
                                this.bitField0_ |= FieldDescriptorProto.LABEL_FIELD_NUMBER;
                                this.label_ = value;
                                break;
                            }
                            unknownFields.mergeVarintField(FieldDescriptorProto.LABEL_FIELD_NUMBER, rawValue);
                            continue;
                        case 40:
                            rawValue = input.readEnum();
                            Type value2 = Type.valueOf(rawValue);
                            if (value2 != null) {
                                this.bitField0_ |= FieldDescriptorProto.OPTIONS_FIELD_NUMBER;
                                this.type_ = value2;
                                break;
                            }
                            unknownFields.mergeVarintField(FieldDescriptorProto.TYPE_FIELD_NUMBER, rawValue);
                            continue;
                        case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                            this.bitField0_ |= 16;
                            this.typeName_ = input.readBytes();
                            continue;
                        case 58:
                            this.bitField0_ |= 64;
                            this.defaultValue_ = input.readBytes();
                            continue;
                        case 66:
                            Builder subBuilder = FieldOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder, extensionRegistry);
                            setOptions(subBuilder.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasName() {
                return (this.bitField0_ & FieldDescriptorProto.NAME_FIELD_NUMBER) == FieldDescriptorProto.NAME_FIELD_NUMBER;
            }

            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= FieldDescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = FieldDescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= FieldDescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
            }

            public boolean hasNumber() {
                return (this.bitField0_ & FieldDescriptorProto.EXTENDEE_FIELD_NUMBER) == FieldDescriptorProto.EXTENDEE_FIELD_NUMBER;
            }

            public int getNumber() {
                return this.number_;
            }

            public Builder setNumber(int value) {
                this.bitField0_ |= FieldDescriptorProto.EXTENDEE_FIELD_NUMBER;
                this.number_ = value;
                onChanged();
                return this;
            }

            public Builder clearNumber() {
                this.bitField0_ &= -3;
                this.number_ = 0;
                onChanged();
                return this;
            }

            public boolean hasLabel() {
                return (this.bitField0_ & FieldDescriptorProto.LABEL_FIELD_NUMBER) == FieldDescriptorProto.LABEL_FIELD_NUMBER;
            }

            public Label getLabel() {
                return this.label_;
            }

            public Builder setLabel(Label value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= FieldDescriptorProto.LABEL_FIELD_NUMBER;
                this.label_ = value;
                onChanged();
                return this;
            }

            public Builder clearLabel() {
                this.bitField0_ &= -5;
                this.label_ = Label.LABEL_OPTIONAL;
                onChanged();
                return this;
            }

            public boolean hasType() {
                return (this.bitField0_ & FieldDescriptorProto.OPTIONS_FIELD_NUMBER) == FieldDescriptorProto.OPTIONS_FIELD_NUMBER;
            }

            public Type getType() {
                return this.type_;
            }

            public Builder setType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= FieldDescriptorProto.OPTIONS_FIELD_NUMBER;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= -9;
                this.type_ = Type.TYPE_DOUBLE;
                onChanged();
                return this;
            }

            public boolean hasTypeName() {
                return (this.bitField0_ & 16) == 16;
            }

            public String getTypeName() {
                Object ref = this.typeName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.typeName_ = s;
                return s;
            }

            public Builder setTypeName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.typeName_ = value;
                onChanged();
                return this;
            }

            public Builder clearTypeName() {
                this.bitField0_ &= -17;
                this.typeName_ = FieldDescriptorProto.getDefaultInstance().getTypeName();
                onChanged();
                return this;
            }

            void setTypeName(ByteString value) {
                this.bitField0_ |= 16;
                this.typeName_ = value;
                onChanged();
            }

            public boolean hasExtendee() {
                return (this.bitField0_ & 32) == 32;
            }

            public String getExtendee() {
                Object ref = this.extendee_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.extendee_ = s;
                return s;
            }

            public Builder setExtendee(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 32;
                this.extendee_ = value;
                onChanged();
                return this;
            }

            public Builder clearExtendee() {
                this.bitField0_ &= -33;
                this.extendee_ = FieldDescriptorProto.getDefaultInstance().getExtendee();
                onChanged();
                return this;
            }

            void setExtendee(ByteString value) {
                this.bitField0_ |= 32;
                this.extendee_ = value;
                onChanged();
            }

            public boolean hasDefaultValue() {
                return (this.bitField0_ & 64) == 64;
            }

            public String getDefaultValue() {
                Object ref = this.defaultValue_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.defaultValue_ = s;
                return s;
            }

            public Builder setDefaultValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.defaultValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearDefaultValue() {
                this.bitField0_ &= -65;
                this.defaultValue_ = FieldDescriptorProto.getDefaultInstance().getDefaultValue();
                onChanged();
                return this;
            }

            void setDefaultValue(ByteString value) {
                this.bitField0_ |= 64;
                this.defaultValue_ = value;
                onChanged();
            }

            public boolean hasOptions() {
                return (this.bitField0_ & XMLChar.MASK_NCNAME) == XMLChar.MASK_NCNAME;
            }

            public FieldOptions getOptions() {
                if (this.optionsBuilder_ == null) {
                    return this.options_;
                }
                return (FieldOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(FieldOptions value) {
                if (this.optionsBuilder_ != null) {
                    this.optionsBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.options_ = value;
                    onChanged();
                }
                this.bitField0_ |= XMLChar.MASK_NCNAME;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= XMLChar.MASK_NCNAME;
                return this;
            }

            public Builder mergeOptions(FieldOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & XMLChar.MASK_NCNAME) != XMLChar.MASK_NCNAME || this.options_ == FieldOptions.getDefaultInstance()) {
                        this.options_ = value;
                    } else {
                        this.options_ = FieldOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= XMLChar.MASK_NCNAME;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = FieldOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -129;
                return this;
            }

            public Builder getOptionsBuilder() {
                this.bitField0_ |= XMLChar.MASK_NCNAME;
                onChanged();
                return (Builder) getOptionsFieldBuilder().getBuilder();
            }

            public FieldOptionsOrBuilder getOptionsOrBuilder() {
                if (this.optionsBuilder_ != null) {
                    return (FieldOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder();
                }
                return this.options_;
            }

            private SingleFieldBuilder<FieldOptions, Builder, FieldOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }
        }

        public enum Label implements ProtocolMessageEnum {
            LABEL_OPTIONAL(0, LABEL_OPTIONAL_VALUE),
            LABEL_REQUIRED(LABEL_OPTIONAL_VALUE, LABEL_REQUIRED_VALUE),
            LABEL_REPEATED(LABEL_REQUIRED_VALUE, LABEL_REPEATED_VALUE);
            
            public static final int LABEL_OPTIONAL_VALUE = 1;
            public static final int LABEL_REPEATED_VALUE = 3;
            public static final int LABEL_REQUIRED_VALUE = 2;
            private static final Label[] VALUES;
            private static EnumLiteMap<Label> internalValueMap;
            private final int index;
            private final int value;

            /* renamed from: com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label.1 */
            static class C08401 implements EnumLiteMap<Label> {
                C08401() {
                }

                public Label findValueByNumber(int number) {
                    return Label.valueOf(number);
                }
            }

            static {
                internalValueMap = new C08401();
                Label[] labelArr = new Label[LABEL_REPEATED_VALUE];
                labelArr[0] = LABEL_OPTIONAL;
                labelArr[LABEL_OPTIONAL_VALUE] = LABEL_REQUIRED;
                labelArr[LABEL_REQUIRED_VALUE] = LABEL_REPEATED;
                VALUES = labelArr;
            }

            public final int getNumber() {
                return this.value;
            }

            public static Label valueOf(int value) {
                switch (value) {
                    case LABEL_OPTIONAL_VALUE:
                        return LABEL_OPTIONAL;
                    case LABEL_REQUIRED_VALUE:
                        return LABEL_REQUIRED;
                    case LABEL_REPEATED_VALUE:
                        return LABEL_REPEATED;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<Label> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().getValues().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) FieldDescriptorProto.getDescriptor().getEnumTypes().get(LABEL_OPTIONAL_VALUE);
            }

            public static Label valueOf(EnumValueDescriptor desc) {
                if (desc.getType() == getDescriptor()) {
                    return VALUES[desc.getIndex()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private Label(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        public enum Type implements ProtocolMessageEnum {
            TYPE_DOUBLE(0, TYPE_DOUBLE_VALUE),
            TYPE_FLOAT(TYPE_DOUBLE_VALUE, TYPE_FLOAT_VALUE),
            TYPE_INT64(TYPE_FLOAT_VALUE, TYPE_INT64_VALUE),
            TYPE_UINT64(TYPE_INT64_VALUE, TYPE_UINT64_VALUE),
            TYPE_INT32(TYPE_UINT64_VALUE, TYPE_INT32_VALUE),
            TYPE_FIXED64(TYPE_INT32_VALUE, TYPE_FIXED64_VALUE),
            TYPE_FIXED32(TYPE_FIXED64_VALUE, TYPE_FIXED32_VALUE),
            TYPE_BOOL(TYPE_FIXED32_VALUE, TYPE_BOOL_VALUE),
            TYPE_STRING(TYPE_BOOL_VALUE, TYPE_STRING_VALUE),
            TYPE_GROUP(TYPE_STRING_VALUE, TYPE_GROUP_VALUE),
            TYPE_MESSAGE(TYPE_GROUP_VALUE, TYPE_MESSAGE_VALUE),
            TYPE_BYTES(TYPE_MESSAGE_VALUE, TYPE_BYTES_VALUE),
            TYPE_UINT32(TYPE_BYTES_VALUE, TYPE_UINT32_VALUE),
            TYPE_ENUM(TYPE_UINT32_VALUE, TYPE_ENUM_VALUE),
            TYPE_SFIXED32(TYPE_ENUM_VALUE, TYPE_SFIXED32_VALUE),
            TYPE_SFIXED64(TYPE_SFIXED32_VALUE, TYPE_SFIXED64_VALUE),
            TYPE_SINT32(TYPE_SFIXED64_VALUE, TYPE_SINT32_VALUE),
            TYPE_SINT64(TYPE_SINT32_VALUE, TYPE_SINT64_VALUE);
            
            public static final int TYPE_BOOL_VALUE = 8;
            public static final int TYPE_BYTES_VALUE = 12;
            public static final int TYPE_DOUBLE_VALUE = 1;
            public static final int TYPE_ENUM_VALUE = 14;
            public static final int TYPE_FIXED32_VALUE = 7;
            public static final int TYPE_FIXED64_VALUE = 6;
            public static final int TYPE_FLOAT_VALUE = 2;
            public static final int TYPE_GROUP_VALUE = 10;
            public static final int TYPE_INT32_VALUE = 5;
            public static final int TYPE_INT64_VALUE = 3;
            public static final int TYPE_MESSAGE_VALUE = 11;
            public static final int TYPE_SFIXED32_VALUE = 15;
            public static final int TYPE_SFIXED64_VALUE = 16;
            public static final int TYPE_SINT32_VALUE = 17;
            public static final int TYPE_SINT64_VALUE = 18;
            public static final int TYPE_STRING_VALUE = 9;
            public static final int TYPE_UINT32_VALUE = 13;
            public static final int TYPE_UINT64_VALUE = 4;
            private static final Type[] VALUES;
            private static EnumLiteMap<Type> internalValueMap;
            private final int index;
            private final int value;

            /* renamed from: com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.1 */
            static class C08411 implements EnumLiteMap<Type> {
                C08411() {
                }

                public Type findValueByNumber(int number) {
                    return Type.valueOf(number);
                }
            }

            static {
                internalValueMap = new C08411();
                Type[] typeArr = new Type[TYPE_SINT64_VALUE];
                typeArr[0] = TYPE_DOUBLE;
                typeArr[TYPE_DOUBLE_VALUE] = TYPE_FLOAT;
                typeArr[TYPE_FLOAT_VALUE] = TYPE_INT64;
                typeArr[TYPE_INT64_VALUE] = TYPE_UINT64;
                typeArr[TYPE_UINT64_VALUE] = TYPE_INT32;
                typeArr[TYPE_INT32_VALUE] = TYPE_FIXED64;
                typeArr[TYPE_FIXED64_VALUE] = TYPE_FIXED32;
                typeArr[TYPE_FIXED32_VALUE] = TYPE_BOOL;
                typeArr[TYPE_BOOL_VALUE] = TYPE_STRING;
                typeArr[TYPE_STRING_VALUE] = TYPE_GROUP;
                typeArr[TYPE_GROUP_VALUE] = TYPE_MESSAGE;
                typeArr[TYPE_MESSAGE_VALUE] = TYPE_BYTES;
                typeArr[TYPE_BYTES_VALUE] = TYPE_UINT32;
                typeArr[TYPE_UINT32_VALUE] = TYPE_ENUM;
                typeArr[TYPE_ENUM_VALUE] = TYPE_SFIXED32;
                typeArr[TYPE_SFIXED32_VALUE] = TYPE_SFIXED64;
                typeArr[TYPE_SFIXED64_VALUE] = TYPE_SINT32;
                typeArr[TYPE_SINT32_VALUE] = TYPE_SINT64;
                VALUES = typeArr;
            }

            public final int getNumber() {
                return this.value;
            }

            public static Type valueOf(int value) {
                switch (value) {
                    case TYPE_DOUBLE_VALUE:
                        return TYPE_DOUBLE;
                    case TYPE_FLOAT_VALUE:
                        return TYPE_FLOAT;
                    case TYPE_INT64_VALUE:
                        return TYPE_INT64;
                    case TYPE_UINT64_VALUE:
                        return TYPE_UINT64;
                    case TYPE_INT32_VALUE:
                        return TYPE_INT32;
                    case TYPE_FIXED64_VALUE:
                        return TYPE_FIXED64;
                    case TYPE_FIXED32_VALUE:
                        return TYPE_FIXED32;
                    case TYPE_BOOL_VALUE:
                        return TYPE_BOOL;
                    case TYPE_STRING_VALUE:
                        return TYPE_STRING;
                    case TYPE_GROUP_VALUE:
                        return TYPE_GROUP;
                    case TYPE_MESSAGE_VALUE:
                        return TYPE_MESSAGE;
                    case TYPE_BYTES_VALUE:
                        return TYPE_BYTES;
                    case TYPE_UINT32_VALUE:
                        return TYPE_UINT32;
                    case TYPE_ENUM_VALUE:
                        return TYPE_ENUM;
                    case TYPE_SFIXED32_VALUE:
                        return TYPE_SFIXED32;
                    case TYPE_SFIXED64_VALUE:
                        return TYPE_SFIXED64;
                    case TYPE_SINT32_VALUE:
                        return TYPE_SINT32;
                    case TYPE_SINT64_VALUE:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<Type> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().getValues().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) FieldDescriptorProto.getDescriptor().getEnumTypes().get(0);
            }

            public static Type valueOf(EnumValueDescriptor desc) {
                if (desc.getType() == getDescriptor()) {
                    return VALUES[desc.getIndex()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private Type(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        private FieldDescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private FieldDescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static FieldDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public FieldDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f451x4734b330;
        }

        public boolean hasName() {
            return (this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER;
        }

        public String getName() {
            ByteString ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        public boolean hasNumber() {
            return (this.bitField0_ & EXTENDEE_FIELD_NUMBER) == EXTENDEE_FIELD_NUMBER;
        }

        public int getNumber() {
            return this.number_;
        }

        public boolean hasLabel() {
            return (this.bitField0_ & LABEL_FIELD_NUMBER) == LABEL_FIELD_NUMBER;
        }

        public Label getLabel() {
            return this.label_;
        }

        public boolean hasType() {
            return (this.bitField0_ & OPTIONS_FIELD_NUMBER) == OPTIONS_FIELD_NUMBER;
        }

        public Type getType() {
            return this.type_;
        }

        public boolean hasTypeName() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getTypeName() {
            ByteString ref = this.typeName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.typeName_ = s;
            }
            return s;
        }

        private ByteString getTypeNameBytes() {
            Object ref = this.typeName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.typeName_ = b;
            return b;
        }

        public boolean hasExtendee() {
            return (this.bitField0_ & 32) == 32;
        }

        public String getExtendee() {
            ByteString ref = this.extendee_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.extendee_ = s;
            }
            return s;
        }

        private ByteString getExtendeeBytes() {
            Object ref = this.extendee_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.extendee_ = b;
            return b;
        }

        public boolean hasDefaultValue() {
            return (this.bitField0_ & 64) == 64;
        }

        public String getDefaultValue() {
            ByteString ref = this.defaultValue_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.defaultValue_ = s;
            }
            return s;
        }

        private ByteString getDefaultValueBytes() {
            Object ref = this.defaultValue_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.defaultValue_ = b;
            return b;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & XMLChar.MASK_NCNAME) == XMLChar.MASK_NCNAME;
        }

        public FieldOptions getOptions() {
            return this.options_;
        }

        public FieldOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        private void initFields() {
            this.name_ = StringUtil.EMPTY_STRING;
            this.number_ = 0;
            this.label_ = Label.LABEL_OPTIONAL;
            this.type_ = Type.TYPE_DOUBLE;
            this.typeName_ = StringUtil.EMPTY_STRING;
            this.extendee_ = StringUtil.EMPTY_STRING;
            this.defaultValue_ = StringUtil.EMPTY_STRING;
            this.options_ = FieldOptions.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                if (isInitialized == (byte) 1) {
                    return true;
                }
                return false;
            } else if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                output.writeBytes(NAME_FIELD_NUMBER, getNameBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeBytes(EXTENDEE_FIELD_NUMBER, getExtendeeBytes());
            }
            if ((this.bitField0_ & EXTENDEE_FIELD_NUMBER) == EXTENDEE_FIELD_NUMBER) {
                output.writeInt32(NUMBER_FIELD_NUMBER, this.number_);
            }
            if ((this.bitField0_ & LABEL_FIELD_NUMBER) == LABEL_FIELD_NUMBER) {
                output.writeEnum(LABEL_FIELD_NUMBER, this.label_.getNumber());
            }
            if ((this.bitField0_ & OPTIONS_FIELD_NUMBER) == OPTIONS_FIELD_NUMBER) {
                output.writeEnum(TYPE_FIELD_NUMBER, this.type_.getNumber());
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeBytes(TYPE_NAME_FIELD_NUMBER, getTypeNameBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                output.writeBytes(DEFAULT_VALUE_FIELD_NUMBER, getDefaultValueBytes());
            }
            if ((this.bitField0_ & XMLChar.MASK_NCNAME) == XMLChar.MASK_NCNAME) {
                output.writeMessage(OPTIONS_FIELD_NUMBER, this.options_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeBytesSize(NAME_FIELD_NUMBER, getNameBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                size += CodedOutputStream.computeBytesSize(EXTENDEE_FIELD_NUMBER, getExtendeeBytes());
            }
            if ((this.bitField0_ & EXTENDEE_FIELD_NUMBER) == EXTENDEE_FIELD_NUMBER) {
                size += CodedOutputStream.computeInt32Size(NUMBER_FIELD_NUMBER, this.number_);
            }
            if ((this.bitField0_ & LABEL_FIELD_NUMBER) == LABEL_FIELD_NUMBER) {
                size += CodedOutputStream.computeEnumSize(LABEL_FIELD_NUMBER, this.label_.getNumber());
            }
            if ((this.bitField0_ & OPTIONS_FIELD_NUMBER) == OPTIONS_FIELD_NUMBER) {
                size += CodedOutputStream.computeEnumSize(TYPE_FIELD_NUMBER, this.type_.getNumber());
            }
            if ((this.bitField0_ & 16) == 16) {
                size += CodedOutputStream.computeBytesSize(TYPE_NAME_FIELD_NUMBER, getTypeNameBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                size += CodedOutputStream.computeBytesSize(DEFAULT_VALUE_FIELD_NUMBER, getDefaultValueBytes());
            }
            if ((this.bitField0_ & XMLChar.MASK_NCNAME) == XMLChar.MASK_NCNAME) {
                size += CodedOutputStream.computeMessageSize(OPTIONS_FIELD_NUMBER, this.options_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FieldDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FieldDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new FieldDescriptorProto(true);
            defaultInstance.initFields();
        }
    }

    public interface FieldOptionsOrBuilder extends ExtendableMessageOrBuilder<FieldOptions> {
        CType getCtype();

        boolean getDeprecated();

        String getExperimentalMapKey();

        boolean getPacked();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();

        boolean hasCtype();

        boolean hasDeprecated();

        boolean hasExperimentalMapKey();

        boolean hasPacked();
    }

    public static final class FieldOptions extends ExtendableMessage<FieldOptions> implements FieldOptionsOrBuilder {
        public static final int CTYPE_FIELD_NUMBER = 1;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int EXPERIMENTAL_MAP_KEY_FIELD_NUMBER = 9;
        public static final int PACKED_FIELD_NUMBER = 2;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final FieldOptions defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private CType ctype_;
        private boolean deprecated_;
        private Object experimentalMapKey_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean packed_;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<FieldOptions, Builder> implements FieldOptionsOrBuilder {
            private int bitField0_;
            private CType ctype_;
            private boolean deprecated_;
            private Object experimentalMapKey_;
            private boolean packed_;
            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
            }

            private Builder() {
                this.ctype_ = CType.STRING;
                this.experimentalMapKey_ = StringUtil.EMPTY_STRING;
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.ctype_ = CType.STRING;
                this.experimentalMapKey_ = StringUtil.EMPTY_STRING;
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.ctype_ = CType.STRING;
                this.bitField0_ &= -2;
                this.packed_ = false;
                this.bitField0_ &= -3;
                this.deprecated_ = false;
                this.bitField0_ &= -5;
                this.experimentalMapKey_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -9;
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return FieldOptions.getDescriptor();
            }

            public FieldOptions getDefaultInstanceForType() {
                return FieldOptions.getDefaultInstance();
            }

            public FieldOptions build() {
                FieldOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private FieldOptions buildParsed() throws InvalidProtocolBufferException {
                FieldOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public FieldOptions buildPartial() {
                FieldOptions result = new FieldOptions();
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & FieldOptions.CTYPE_FIELD_NUMBER) == FieldOptions.CTYPE_FIELD_NUMBER) {
                    to_bitField0_ = 0 | FieldOptions.CTYPE_FIELD_NUMBER;
                }
                result.ctype_ = this.ctype_;
                if ((from_bitField0_ & FieldOptions.PACKED_FIELD_NUMBER) == FieldOptions.PACKED_FIELD_NUMBER) {
                    to_bitField0_ |= FieldOptions.PACKED_FIELD_NUMBER;
                }
                result.packed_ = this.packed_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.deprecated_ = this.deprecated_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.experimentalMapKey_ = this.experimentalMapKey_;
                if (this.uninterpretedOptionBuilder_ == null) {
                    if ((this.bitField0_ & 16) == 16) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -17;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                } else {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FieldOptions) {
                    return mergeFrom((FieldOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FieldOptions other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != FieldOptions.getDefaultInstance()) {
                    if (other.hasCtype()) {
                        setCtype(other.getCtype());
                    }
                    if (other.hasPacked()) {
                        setPacked(other.getPacked());
                    }
                    if (other.hasDeprecated()) {
                        setDeprecated(other.getDeprecated());
                    }
                    if (other.hasExperimentalMapKey()) {
                        setExperimentalMapKey(other.getExperimentalMapKey());
                    }
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -17;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -17;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getUninterpretedOptionFieldBuilder();
                            }
                            this.uninterpretedOptionBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i += FieldOptions.CTYPE_FIELD_NUMBER) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case PayPalActivity.VIEW_TEST /*8*/:
                            int rawValue = input.readEnum();
                            CType value = CType.valueOf(rawValue);
                            if (value != null) {
                                this.bitField0_ |= FieldOptions.CTYPE_FIELD_NUMBER;
                                this.ctype_ = value;
                                break;
                            }
                            unknownFields.mergeVarintField(FieldOptions.CTYPE_FIELD_NUMBER, rawValue);
                            continue;
                        case Segment.TOKENS_PER_SEGMENT /*16*/:
                            this.bitField0_ |= FieldOptions.PACKED_FIELD_NUMBER;
                            this.packed_ = input.readBool();
                            continue;
                        case 24:
                            this.bitField0_ |= 4;
                            this.deprecated_ = input.readBool();
                            continue;
                        case 74:
                            this.bitField0_ |= 8;
                            this.experimentalMapKey_ = input.readBytes();
                            continue;
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasCtype() {
                return (this.bitField0_ & FieldOptions.CTYPE_FIELD_NUMBER) == FieldOptions.CTYPE_FIELD_NUMBER;
            }

            public CType getCtype() {
                return this.ctype_;
            }

            public Builder setCtype(CType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= FieldOptions.CTYPE_FIELD_NUMBER;
                this.ctype_ = value;
                onChanged();
                return this;
            }

            public Builder clearCtype() {
                this.bitField0_ &= -2;
                this.ctype_ = CType.STRING;
                onChanged();
                return this;
            }

            public boolean hasPacked() {
                return (this.bitField0_ & FieldOptions.PACKED_FIELD_NUMBER) == FieldOptions.PACKED_FIELD_NUMBER;
            }

            public boolean getPacked() {
                return this.packed_;
            }

            public Builder setPacked(boolean value) {
                this.bitField0_ |= FieldOptions.PACKED_FIELD_NUMBER;
                this.packed_ = value;
                onChanged();
                return this;
            }

            public Builder clearPacked() {
                this.bitField0_ &= -3;
                this.packed_ = false;
                onChanged();
                return this;
            }

            public boolean hasDeprecated() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean getDeprecated() {
                return this.deprecated_;
            }

            public Builder setDeprecated(boolean value) {
                this.bitField0_ |= 4;
                this.deprecated_ = value;
                onChanged();
                return this;
            }

            public Builder clearDeprecated() {
                this.bitField0_ &= -5;
                this.deprecated_ = false;
                onChanged();
                return this;
            }

            public boolean hasExperimentalMapKey() {
                return (this.bitField0_ & 8) == 8;
            }

            public String getExperimentalMapKey() {
                Object ref = this.experimentalMapKey_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.experimentalMapKey_ = s;
                return s;
            }

            public Builder setExperimentalMapKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.experimentalMapKey_ = value;
                onChanged();
                return this;
            }

            public Builder clearExperimentalMapKey() {
                this.bitField0_ &= -9;
                this.experimentalMapKey_ = FieldOptions.getDefaultInstance().getExperimentalMapKey();
                onChanged();
                return this;
            }

            void setExperimentalMapKey(ByteString value) {
                this.bitField0_ |= 8;
                this.experimentalMapKey_ = value;
                onChanged();
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 16;
                }
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return Collections.unmodifiableList(this.uninterpretedOption_);
                }
                return this.uninterpretedOptionBuilder_.getMessageList();
            }

            public int getUninterpretedOptionCount() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return this.uninterpretedOption_.size();
                }
                return this.uninterpretedOptionBuilder_.getCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOption) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public Builder getUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                if (this.uninterpretedOptionBuilder_ != null) {
                    return this.uninterpretedOptionBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public Builder addUninterpretedOptionBuilder() {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public Builder addUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 16) == 16, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        public enum CType implements ProtocolMessageEnum {
            STRING(0, 0),
            CORD(CORD_VALUE, CORD_VALUE),
            STRING_PIECE(STRING_PIECE_VALUE, STRING_PIECE_VALUE);
            
            public static final int CORD_VALUE = 1;
            public static final int STRING_PIECE_VALUE = 2;
            public static final int STRING_VALUE = 0;
            private static final CType[] VALUES;
            private static EnumLiteMap<CType> internalValueMap;
            private final int index;
            private final int value;

            /* renamed from: com.google.protobuf.DescriptorProtos.FieldOptions.CType.1 */
            static class C08421 implements EnumLiteMap<CType> {
                C08421() {
                }

                public CType findValueByNumber(int number) {
                    return CType.valueOf(number);
                }
            }

            static {
                internalValueMap = new C08421();
                CType[] cTypeArr = new CType[FieldOptions.DEPRECATED_FIELD_NUMBER];
                cTypeArr[0] = STRING;
                cTypeArr[CORD_VALUE] = CORD;
                cTypeArr[STRING_PIECE_VALUE] = STRING_PIECE;
                VALUES = cTypeArr;
            }

            public final int getNumber() {
                return this.value;
            }

            public static CType valueOf(int value) {
                switch (value) {
                    case CharacterEscapes.ESCAPE_NONE /*0*/:
                        return STRING;
                    case CORD_VALUE:
                        return CORD;
                    case STRING_PIECE_VALUE:
                        return STRING_PIECE;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<CType> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().getValues().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) FieldOptions.getDescriptor().getEnumTypes().get(0);
            }

            public static CType valueOf(EnumValueDescriptor desc) {
                if (desc.getType() == getDescriptor()) {
                    return VALUES[desc.getIndex()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private CType(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        private FieldOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private FieldOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static FieldOptions getDefaultInstance() {
            return defaultInstance;
        }

        public FieldOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
        }

        public boolean hasCtype() {
            return (this.bitField0_ & CTYPE_FIELD_NUMBER) == CTYPE_FIELD_NUMBER;
        }

        public CType getCtype() {
            return this.ctype_;
        }

        public boolean hasPacked() {
            return (this.bitField0_ & PACKED_FIELD_NUMBER) == PACKED_FIELD_NUMBER;
        }

        public boolean getPacked() {
            return this.packed_;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        public boolean hasExperimentalMapKey() {
            return (this.bitField0_ & 8) == 8;
        }

        public String getExperimentalMapKey() {
            ByteString ref = this.experimentalMapKey_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.experimentalMapKey_ = s;
            }
            return s;
        }

        private ByteString getExperimentalMapKeyBytes() {
            Object ref = this.experimentalMapKey_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.experimentalMapKey_ = b;
            return b;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.ctype_ = CType.STRING;
            this.packed_ = false;
            this.deprecated_ = false;
            this.experimentalMapKey_ = StringUtil.EMPTY_STRING;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getUninterpretedOptionCount()) {
                    if (getUninterpretedOption(i).isInitialized()) {
                        i += CTYPE_FIELD_NUMBER;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            ExtensionWriter extensionWriter = newExtensionWriter();
            if ((this.bitField0_ & CTYPE_FIELD_NUMBER) == CTYPE_FIELD_NUMBER) {
                output.writeEnum(CTYPE_FIELD_NUMBER, this.ctype_.getNumber());
            }
            if ((this.bitField0_ & PACKED_FIELD_NUMBER) == PACKED_FIELD_NUMBER) {
                output.writeBool(PACKED_FIELD_NUMBER, this.packed_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeBool(DEPRECATED_FIELD_NUMBER, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeBytes(EXPERIMENTAL_MAP_KEY_FIELD_NUMBER, getExperimentalMapKeyBytes());
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i += CTYPE_FIELD_NUMBER) {
                output.writeMessage(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            extensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & CTYPE_FIELD_NUMBER) == CTYPE_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeEnumSize(CTYPE_FIELD_NUMBER, this.ctype_.getNumber());
            }
            if ((this.bitField0_ & PACKED_FIELD_NUMBER) == PACKED_FIELD_NUMBER) {
                size += CodedOutputStream.computeBoolSize(PACKED_FIELD_NUMBER, this.packed_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeBoolSize(DEPRECATED_FIELD_NUMBER, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeBytesSize(EXPERIMENTAL_MAP_KEY_FIELD_NUMBER, getExperimentalMapKeyBytes());
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i += CTYPE_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FieldOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FieldOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FieldOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FieldOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FieldOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FieldOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FieldOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FieldOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FieldOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FieldOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FieldOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new FieldOptions(true);
            defaultInstance.initFields();
        }
    }

    public interface FileDescriptorProtoOrBuilder extends MessageOrBuilder {
        String getDependency(int i);

        int getDependencyCount();

        List<String> getDependencyList();

        EnumDescriptorProto getEnumType(int i);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i);

        List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList();

        FieldDescriptorProto getExtension(int i);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i);

        List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList();

        DescriptorProto getMessageType(int i);

        int getMessageTypeCount();

        List<DescriptorProto> getMessageTypeList();

        DescriptorProtoOrBuilder getMessageTypeOrBuilder(int i);

        List<? extends DescriptorProtoOrBuilder> getMessageTypeOrBuilderList();

        String getName();

        FileOptions getOptions();

        FileOptionsOrBuilder getOptionsOrBuilder();

        String getPackage();

        ServiceDescriptorProto getService(int i);

        int getServiceCount();

        List<ServiceDescriptorProto> getServiceList();

        ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int i);

        List<? extends ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList();

        SourceCodeInfo getSourceCodeInfo();

        SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder();

        boolean hasName();

        boolean hasOptions();

        boolean hasPackage();

        boolean hasSourceCodeInfo();
    }

    public static final class FileDescriptorProto extends GeneratedMessage implements FileDescriptorProtoOrBuilder {
        public static final int DEPENDENCY_FIELD_NUMBER = 3;
        public static final int ENUM_TYPE_FIELD_NUMBER = 5;
        public static final int EXTENSION_FIELD_NUMBER = 7;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int PACKAGE_FIELD_NUMBER = 2;
        public static final int SERVICE_FIELD_NUMBER = 6;
        public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
        private static final FileDescriptorProto defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private LazyStringList dependency_;
        private List<EnumDescriptorProto> enumType_;
        private List<FieldDescriptorProto> extension_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<DescriptorProto> messageType_;
        private Object name_;
        private FileOptions options_;
        private Object package_;
        private List<ServiceDescriptorProto> service_;
        private SourceCodeInfo sourceCodeInfo_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements FileDescriptorProtoOrBuilder {
            private int bitField0_;
            private LazyStringList dependency_;
            private RepeatedFieldBuilder<EnumDescriptorProto, Builder, EnumDescriptorProtoOrBuilder> enumTypeBuilder_;
            private List<EnumDescriptorProto> enumType_;
            private RepeatedFieldBuilder<FieldDescriptorProto, Builder, FieldDescriptorProtoOrBuilder> extensionBuilder_;
            private List<FieldDescriptorProto> extension_;
            private RepeatedFieldBuilder<DescriptorProto, Builder, DescriptorProtoOrBuilder> messageTypeBuilder_;
            private List<DescriptorProto> messageType_;
            private Object name_;
            private SingleFieldBuilder<FileOptions, Builder, FileOptionsOrBuilder> optionsBuilder_;
            private FileOptions options_;
            private Object package_;
            private RepeatedFieldBuilder<ServiceDescriptorProto, Builder, ServiceDescriptorProtoOrBuilder> serviceBuilder_;
            private List<ServiceDescriptorProto> service_;
            private SingleFieldBuilder<SourceCodeInfo, Builder, SourceCodeInfoOrBuilder> sourceCodeInfoBuilder_;
            private SourceCodeInfo sourceCodeInfo_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f452x4b52780c;
            }

            private Builder() {
                this.name_ = StringUtil.EMPTY_STRING;
                this.package_ = StringUtil.EMPTY_STRING;
                this.dependency_ = LazyStringArrayList.EMPTY;
                this.messageType_ = Collections.emptyList();
                this.enumType_ = Collections.emptyList();
                this.service_ = Collections.emptyList();
                this.extension_ = Collections.emptyList();
                this.options_ = FileOptions.getDefaultInstance();
                this.sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.name_ = StringUtil.EMPTY_STRING;
                this.package_ = StringUtil.EMPTY_STRING;
                this.dependency_ = LazyStringArrayList.EMPTY;
                this.messageType_ = Collections.emptyList();
                this.enumType_ = Collections.emptyList();
                this.service_ = Collections.emptyList();
                this.extension_ = Collections.emptyList();
                this.options_ = FileOptions.getDefaultInstance();
                this.sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getMessageTypeFieldBuilder();
                    getEnumTypeFieldBuilder();
                    getServiceFieldBuilder();
                    getExtensionFieldBuilder();
                    getOptionsFieldBuilder();
                    getSourceCodeInfoFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.name_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -2;
                this.package_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -3;
                this.dependency_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -5;
                if (this.messageTypeBuilder_ == null) {
                    this.messageType_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.messageTypeBuilder_.clear();
                }
                if (this.enumTypeBuilder_ == null) {
                    this.enumType_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.enumTypeBuilder_.clear();
                }
                if (this.serviceBuilder_ == null) {
                    this.service_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                } else {
                    this.serviceBuilder_.clear();
                }
                if (this.extensionBuilder_ == null) {
                    this.extension_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                } else {
                    this.extensionBuilder_.clear();
                }
                if (this.optionsBuilder_ == null) {
                    this.options_ = FileOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -129;
                if (this.sourceCodeInfoBuilder_ == null) {
                    this.sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
                } else {
                    this.sourceCodeInfoBuilder_.clear();
                }
                this.bitField0_ &= -257;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return FileDescriptorProto.getDescriptor();
            }

            public FileDescriptorProto getDefaultInstanceForType() {
                return FileDescriptorProto.getDefaultInstance();
            }

            public FileDescriptorProto build() {
                FileDescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private FileDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                FileDescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public FileDescriptorProto buildPartial() {
                FileDescriptorProto result = new FileDescriptorProto();
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & FileDescriptorProto.NAME_FIELD_NUMBER) == FileDescriptorProto.NAME_FIELD_NUMBER) {
                    to_bitField0_ = 0 | FileDescriptorProto.NAME_FIELD_NUMBER;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & FileDescriptorProto.PACKAGE_FIELD_NUMBER) == FileDescriptorProto.PACKAGE_FIELD_NUMBER) {
                    to_bitField0_ |= FileDescriptorProto.PACKAGE_FIELD_NUMBER;
                }
                result.package_ = this.package_;
                if ((this.bitField0_ & FileDescriptorProto.MESSAGE_TYPE_FIELD_NUMBER) == FileDescriptorProto.MESSAGE_TYPE_FIELD_NUMBER) {
                    this.dependency_ = new UnmodifiableLazyStringList(this.dependency_);
                    this.bitField0_ &= -5;
                }
                result.dependency_ = this.dependency_;
                if (this.messageTypeBuilder_ == null) {
                    if ((this.bitField0_ & FileDescriptorProto.OPTIONS_FIELD_NUMBER) == FileDescriptorProto.OPTIONS_FIELD_NUMBER) {
                        this.messageType_ = Collections.unmodifiableList(this.messageType_);
                        this.bitField0_ &= -9;
                    }
                    result.messageType_ = this.messageType_;
                } else {
                    result.messageType_ = this.messageTypeBuilder_.build();
                }
                if (this.enumTypeBuilder_ == null) {
                    if ((this.bitField0_ & 16) == 16) {
                        this.enumType_ = Collections.unmodifiableList(this.enumType_);
                        this.bitField0_ &= -17;
                    }
                    result.enumType_ = this.enumType_;
                } else {
                    result.enumType_ = this.enumTypeBuilder_.build();
                }
                if (this.serviceBuilder_ == null) {
                    if ((this.bitField0_ & 32) == 32) {
                        this.service_ = Collections.unmodifiableList(this.service_);
                        this.bitField0_ &= -33;
                    }
                    result.service_ = this.service_;
                } else {
                    result.service_ = this.serviceBuilder_.build();
                }
                if (this.extensionBuilder_ == null) {
                    if ((this.bitField0_ & 64) == 64) {
                        this.extension_ = Collections.unmodifiableList(this.extension_);
                        this.bitField0_ &= -65;
                    }
                    result.extension_ = this.extension_;
                } else {
                    result.extension_ = this.extensionBuilder_.build();
                }
                if ((from_bitField0_ & XMLChar.MASK_NCNAME) == XMLChar.MASK_NCNAME) {
                    to_bitField0_ |= FileDescriptorProto.MESSAGE_TYPE_FIELD_NUMBER;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (FileOptions) this.optionsBuilder_.build();
                }
                if ((from_bitField0_ & 256) == 256) {
                    to_bitField0_ |= FileDescriptorProto.OPTIONS_FIELD_NUMBER;
                }
                if (this.sourceCodeInfoBuilder_ == null) {
                    result.sourceCodeInfo_ = this.sourceCodeInfo_;
                } else {
                    result.sourceCodeInfo_ = (SourceCodeInfo) this.sourceCodeInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FileDescriptorProto) {
                    return mergeFrom((FileDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FileDescriptorProto other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != FileDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasPackage()) {
                        setPackage(other.getPackage());
                    }
                    if (!other.dependency_.isEmpty()) {
                        if (this.dependency_.isEmpty()) {
                            this.dependency_ = other.dependency_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureDependencyIsMutable();
                            this.dependency_.addAll(other.dependency_);
                        }
                        onChanged();
                    }
                    if (this.messageTypeBuilder_ == null) {
                        if (!other.messageType_.isEmpty()) {
                            if (this.messageType_.isEmpty()) {
                                this.messageType_ = other.messageType_;
                                this.bitField0_ &= -9;
                            } else {
                                ensureMessageTypeIsMutable();
                                this.messageType_.addAll(other.messageType_);
                            }
                            onChanged();
                        }
                    } else if (!other.messageType_.isEmpty()) {
                        if (this.messageTypeBuilder_.isEmpty()) {
                            this.messageTypeBuilder_.dispose();
                            this.messageTypeBuilder_ = null;
                            this.messageType_ = other.messageType_;
                            this.bitField0_ &= -9;
                            this.messageTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getMessageTypeFieldBuilder() : null;
                        } else {
                            this.messageTypeBuilder_.addAllMessages(other.messageType_);
                        }
                    }
                    if (this.enumTypeBuilder_ == null) {
                        if (!other.enumType_.isEmpty()) {
                            if (this.enumType_.isEmpty()) {
                                this.enumType_ = other.enumType_;
                                this.bitField0_ &= -17;
                            } else {
                                ensureEnumTypeIsMutable();
                                this.enumType_.addAll(other.enumType_);
                            }
                            onChanged();
                        }
                    } else if (!other.enumType_.isEmpty()) {
                        if (this.enumTypeBuilder_.isEmpty()) {
                            this.enumTypeBuilder_.dispose();
                            this.enumTypeBuilder_ = null;
                            this.enumType_ = other.enumType_;
                            this.bitField0_ &= -17;
                            this.enumTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getEnumTypeFieldBuilder() : null;
                        } else {
                            this.enumTypeBuilder_.addAllMessages(other.enumType_);
                        }
                    }
                    if (this.serviceBuilder_ == null) {
                        if (!other.service_.isEmpty()) {
                            if (this.service_.isEmpty()) {
                                this.service_ = other.service_;
                                this.bitField0_ &= -33;
                            } else {
                                ensureServiceIsMutable();
                                this.service_.addAll(other.service_);
                            }
                            onChanged();
                        }
                    } else if (!other.service_.isEmpty()) {
                        if (this.serviceBuilder_.isEmpty()) {
                            this.serviceBuilder_.dispose();
                            this.serviceBuilder_ = null;
                            this.service_ = other.service_;
                            this.bitField0_ &= -33;
                            this.serviceBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getServiceFieldBuilder() : null;
                        } else {
                            this.serviceBuilder_.addAllMessages(other.service_);
                        }
                    }
                    if (this.extensionBuilder_ == null) {
                        if (!other.extension_.isEmpty()) {
                            if (this.extension_.isEmpty()) {
                                this.extension_ = other.extension_;
                                this.bitField0_ &= -65;
                            } else {
                                ensureExtensionIsMutable();
                                this.extension_.addAll(other.extension_);
                            }
                            onChanged();
                        }
                    } else if (!other.extension_.isEmpty()) {
                        if (this.extensionBuilder_.isEmpty()) {
                            this.extensionBuilder_.dispose();
                            this.extensionBuilder_ = null;
                            this.extension_ = other.extension_;
                            this.bitField0_ &= -65;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getExtensionFieldBuilder();
                            }
                            this.extensionBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.extensionBuilder_.addAllMessages(other.extension_);
                        }
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    if (other.hasSourceCodeInfo()) {
                        mergeSourceCodeInfo(other.getSourceCodeInfo());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getMessageTypeCount(); i += FileDescriptorProto.NAME_FIELD_NUMBER) {
                    if (!getMessageType(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getEnumTypeCount(); i += FileDescriptorProto.NAME_FIELD_NUMBER) {
                    if (!getEnumType(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getServiceCount(); i += FileDescriptorProto.NAME_FIELD_NUMBER) {
                    if (!getService(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getExtensionCount(); i += FileDescriptorProto.NAME_FIELD_NUMBER) {
                    if (!getExtension(i).isInitialized()) {
                        return false;
                    }
                }
                if (!hasOptions() || getOptions().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                            this.bitField0_ |= FileDescriptorProto.NAME_FIELD_NUMBER;
                            this.name_ = input.readBytes();
                            continue;
                        case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                            this.bitField0_ |= FileDescriptorProto.PACKAGE_FIELD_NUMBER;
                            this.package_ = input.readBytes();
                            continue;
                        case 26:
                            ensureDependencyIsMutable();
                            this.dependency_.add(input.readBytes());
                            continue;
                        case 34:
                            Builder subBuilder = DescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addMessageType(subBuilder.buildPartial());
                            continue;
                        case 42:
                            Builder subBuilder2 = EnumDescriptorProto.newBuilder();
                            input.readMessage(subBuilder2, extensionRegistry);
                            addEnumType(subBuilder2.buildPartial());
                            continue;
                        case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                            Builder subBuilder3 = ServiceDescriptorProto.newBuilder();
                            input.readMessage(subBuilder3, extensionRegistry);
                            addService(subBuilder3.buildPartial());
                            continue;
                        case 58:
                            Builder subBuilder4 = FieldDescriptorProto.newBuilder();
                            input.readMessage(subBuilder4, extensionRegistry);
                            addExtension(subBuilder4.buildPartial());
                            continue;
                        case 66:
                            Builder subBuilder5 = FileOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder5.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder5, extensionRegistry);
                            setOptions(subBuilder5.buildPartial());
                            continue;
                        case 74:
                            Builder subBuilder6 = SourceCodeInfo.newBuilder();
                            if (hasSourceCodeInfo()) {
                                subBuilder6.mergeFrom(getSourceCodeInfo());
                            }
                            input.readMessage(subBuilder6, extensionRegistry);
                            setSourceCodeInfo(subBuilder6.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasName() {
                return (this.bitField0_ & FileDescriptorProto.NAME_FIELD_NUMBER) == FileDescriptorProto.NAME_FIELD_NUMBER;
            }

            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= FileDescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = FileDescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= FileDescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
            }

            public boolean hasPackage() {
                return (this.bitField0_ & FileDescriptorProto.PACKAGE_FIELD_NUMBER) == FileDescriptorProto.PACKAGE_FIELD_NUMBER;
            }

            public String getPackage() {
                Object ref = this.package_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.package_ = s;
                return s;
            }

            public Builder setPackage(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= FileDescriptorProto.PACKAGE_FIELD_NUMBER;
                this.package_ = value;
                onChanged();
                return this;
            }

            public Builder clearPackage() {
                this.bitField0_ &= -3;
                this.package_ = FileDescriptorProto.getDefaultInstance().getPackage();
                onChanged();
                return this;
            }

            void setPackage(ByteString value) {
                this.bitField0_ |= FileDescriptorProto.PACKAGE_FIELD_NUMBER;
                this.package_ = value;
                onChanged();
            }

            private void ensureDependencyIsMutable() {
                if ((this.bitField0_ & FileDescriptorProto.MESSAGE_TYPE_FIELD_NUMBER) != FileDescriptorProto.MESSAGE_TYPE_FIELD_NUMBER) {
                    this.dependency_ = new LazyStringArrayList(this.dependency_);
                    this.bitField0_ |= FileDescriptorProto.MESSAGE_TYPE_FIELD_NUMBER;
                }
            }

            public List<String> getDependencyList() {
                return Collections.unmodifiableList(this.dependency_);
            }

            public int getDependencyCount() {
                return this.dependency_.size();
            }

            public String getDependency(int index) {
                return (String) this.dependency_.get(index);
            }

            public Builder setDependency(int index, String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureDependencyIsMutable();
                this.dependency_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addDependency(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureDependencyIsMutable();
                this.dependency_.add(value);
                onChanged();
                return this;
            }

            public Builder addAllDependency(Iterable<String> values) {
                ensureDependencyIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.dependency_);
                onChanged();
                return this;
            }

            public Builder clearDependency() {
                this.dependency_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            void addDependency(ByteString value) {
                ensureDependencyIsMutable();
                this.dependency_.add(value);
                onChanged();
            }

            private void ensureMessageTypeIsMutable() {
                if ((this.bitField0_ & FileDescriptorProto.OPTIONS_FIELD_NUMBER) != FileDescriptorProto.OPTIONS_FIELD_NUMBER) {
                    this.messageType_ = new ArrayList(this.messageType_);
                    this.bitField0_ |= FileDescriptorProto.OPTIONS_FIELD_NUMBER;
                }
            }

            public List<DescriptorProto> getMessageTypeList() {
                if (this.messageTypeBuilder_ == null) {
                    return Collections.unmodifiableList(this.messageType_);
                }
                return this.messageTypeBuilder_.getMessageList();
            }

            public int getMessageTypeCount() {
                if (this.messageTypeBuilder_ == null) {
                    return this.messageType_.size();
                }
                return this.messageTypeBuilder_.getCount();
            }

            public DescriptorProto getMessageType(int index) {
                if (this.messageTypeBuilder_ == null) {
                    return (DescriptorProto) this.messageType_.get(index);
                }
                return (DescriptorProto) this.messageTypeBuilder_.getMessage(index);
            }

            public Builder setMessageType(int index, DescriptorProto value) {
                if (this.messageTypeBuilder_ != null) {
                    this.messageTypeBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMessageTypeIsMutable();
                    this.messageType_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMessageType(int index, Builder builderForValue) {
                if (this.messageTypeBuilder_ == null) {
                    ensureMessageTypeIsMutable();
                    this.messageType_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.messageTypeBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMessageType(DescriptorProto value) {
                if (this.messageTypeBuilder_ != null) {
                    this.messageTypeBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMessageTypeIsMutable();
                    this.messageType_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMessageType(int index, DescriptorProto value) {
                if (this.messageTypeBuilder_ != null) {
                    this.messageTypeBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMessageTypeIsMutable();
                    this.messageType_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMessageType(Builder builderForValue) {
                if (this.messageTypeBuilder_ == null) {
                    ensureMessageTypeIsMutable();
                    this.messageType_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.messageTypeBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMessageType(int index, Builder builderForValue) {
                if (this.messageTypeBuilder_ == null) {
                    ensureMessageTypeIsMutable();
                    this.messageType_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.messageTypeBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMessageType(Iterable<? extends DescriptorProto> values) {
                if (this.messageTypeBuilder_ == null) {
                    ensureMessageTypeIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.messageType_);
                    onChanged();
                } else {
                    this.messageTypeBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMessageType() {
                if (this.messageTypeBuilder_ == null) {
                    this.messageType_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.messageTypeBuilder_.clear();
                }
                return this;
            }

            public Builder removeMessageType(int index) {
                if (this.messageTypeBuilder_ == null) {
                    ensureMessageTypeIsMutable();
                    this.messageType_.remove(index);
                    onChanged();
                } else {
                    this.messageTypeBuilder_.remove(index);
                }
                return this;
            }

            public Builder getMessageTypeBuilder(int index) {
                return (Builder) getMessageTypeFieldBuilder().getBuilder(index);
            }

            public DescriptorProtoOrBuilder getMessageTypeOrBuilder(int index) {
                if (this.messageTypeBuilder_ == null) {
                    return (DescriptorProtoOrBuilder) this.messageType_.get(index);
                }
                return (DescriptorProtoOrBuilder) this.messageTypeBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends DescriptorProtoOrBuilder> getMessageTypeOrBuilderList() {
                if (this.messageTypeBuilder_ != null) {
                    return this.messageTypeBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.messageType_);
            }

            public Builder addMessageTypeBuilder() {
                return (Builder) getMessageTypeFieldBuilder().addBuilder(DescriptorProto.getDefaultInstance());
            }

            public Builder addMessageTypeBuilder(int index) {
                return (Builder) getMessageTypeFieldBuilder().addBuilder(index, DescriptorProto.getDefaultInstance());
            }

            public List<Builder> getMessageTypeBuilderList() {
                return getMessageTypeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<DescriptorProto, Builder, DescriptorProtoOrBuilder> getMessageTypeFieldBuilder() {
                if (this.messageTypeBuilder_ == null) {
                    this.messageTypeBuilder_ = new RepeatedFieldBuilder(this.messageType_, (this.bitField0_ & FileDescriptorProto.OPTIONS_FIELD_NUMBER) == FileDescriptorProto.OPTIONS_FIELD_NUMBER, getParentForChildren(), isClean());
                    this.messageType_ = null;
                }
                return this.messageTypeBuilder_;
            }

            private void ensureEnumTypeIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.enumType_ = new ArrayList(this.enumType_);
                    this.bitField0_ |= 16;
                }
            }

            public List<EnumDescriptorProto> getEnumTypeList() {
                if (this.enumTypeBuilder_ == null) {
                    return Collections.unmodifiableList(this.enumType_);
                }
                return this.enumTypeBuilder_.getMessageList();
            }

            public int getEnumTypeCount() {
                if (this.enumTypeBuilder_ == null) {
                    return this.enumType_.size();
                }
                return this.enumTypeBuilder_.getCount();
            }

            public EnumDescriptorProto getEnumType(int index) {
                if (this.enumTypeBuilder_ == null) {
                    return (EnumDescriptorProto) this.enumType_.get(index);
                }
                return (EnumDescriptorProto) this.enumTypeBuilder_.getMessage(index);
            }

            public Builder setEnumType(int index, EnumDescriptorProto value) {
                if (this.enumTypeBuilder_ != null) {
                    this.enumTypeBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEnumTypeIsMutable();
                    this.enumType_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setEnumType(int index, Builder builderForValue) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.enumTypeBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto value) {
                if (this.enumTypeBuilder_ != null) {
                    this.enumTypeBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addEnumType(int index, EnumDescriptorProto value) {
                if (this.enumTypeBuilder_ != null) {
                    this.enumTypeBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addEnumType(Builder builderForValue) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addEnumType(int index, Builder builderForValue) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> values) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.enumType_);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEnumType() {
                if (this.enumTypeBuilder_ == null) {
                    this.enumType_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.enumTypeBuilder_.clear();
                }
                return this;
            }

            public Builder removeEnumType(int index) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.remove(index);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.remove(index);
                }
                return this;
            }

            public Builder getEnumTypeBuilder(int index) {
                return (Builder) getEnumTypeFieldBuilder().getBuilder(index);
            }

            public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index) {
                if (this.enumTypeBuilder_ == null) {
                    return (EnumDescriptorProtoOrBuilder) this.enumType_.get(index);
                }
                return (EnumDescriptorProtoOrBuilder) this.enumTypeBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
                if (this.enumTypeBuilder_ != null) {
                    return this.enumTypeBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.enumType_);
            }

            public Builder addEnumTypeBuilder() {
                return (Builder) getEnumTypeFieldBuilder().addBuilder(EnumDescriptorProto.getDefaultInstance());
            }

            public Builder addEnumTypeBuilder(int index) {
                return (Builder) getEnumTypeFieldBuilder().addBuilder(index, EnumDescriptorProto.getDefaultInstance());
            }

            public List<Builder> getEnumTypeBuilderList() {
                return getEnumTypeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<EnumDescriptorProto, Builder, EnumDescriptorProtoOrBuilder> getEnumTypeFieldBuilder() {
                if (this.enumTypeBuilder_ == null) {
                    this.enumTypeBuilder_ = new RepeatedFieldBuilder(this.enumType_, (this.bitField0_ & 16) == 16, getParentForChildren(), isClean());
                    this.enumType_ = null;
                }
                return this.enumTypeBuilder_;
            }

            private void ensureServiceIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.service_ = new ArrayList(this.service_);
                    this.bitField0_ |= 32;
                }
            }

            public List<ServiceDescriptorProto> getServiceList() {
                if (this.serviceBuilder_ == null) {
                    return Collections.unmodifiableList(this.service_);
                }
                return this.serviceBuilder_.getMessageList();
            }

            public int getServiceCount() {
                if (this.serviceBuilder_ == null) {
                    return this.service_.size();
                }
                return this.serviceBuilder_.getCount();
            }

            public ServiceDescriptorProto getService(int index) {
                if (this.serviceBuilder_ == null) {
                    return (ServiceDescriptorProto) this.service_.get(index);
                }
                return (ServiceDescriptorProto) this.serviceBuilder_.getMessage(index);
            }

            public Builder setService(int index, ServiceDescriptorProto value) {
                if (this.serviceBuilder_ != null) {
                    this.serviceBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServiceIsMutable();
                    this.service_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setService(int index, Builder builderForValue) {
                if (this.serviceBuilder_ == null) {
                    ensureServiceIsMutable();
                    this.service_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.serviceBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addService(ServiceDescriptorProto value) {
                if (this.serviceBuilder_ != null) {
                    this.serviceBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServiceIsMutable();
                    this.service_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addService(int index, ServiceDescriptorProto value) {
                if (this.serviceBuilder_ != null) {
                    this.serviceBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServiceIsMutable();
                    this.service_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addService(Builder builderForValue) {
                if (this.serviceBuilder_ == null) {
                    ensureServiceIsMutable();
                    this.service_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.serviceBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addService(int index, Builder builderForValue) {
                if (this.serviceBuilder_ == null) {
                    ensureServiceIsMutable();
                    this.service_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.serviceBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllService(Iterable<? extends ServiceDescriptorProto> values) {
                if (this.serviceBuilder_ == null) {
                    ensureServiceIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.service_);
                    onChanged();
                } else {
                    this.serviceBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearService() {
                if (this.serviceBuilder_ == null) {
                    this.service_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    onChanged();
                } else {
                    this.serviceBuilder_.clear();
                }
                return this;
            }

            public Builder removeService(int index) {
                if (this.serviceBuilder_ == null) {
                    ensureServiceIsMutable();
                    this.service_.remove(index);
                    onChanged();
                } else {
                    this.serviceBuilder_.remove(index);
                }
                return this;
            }

            public Builder getServiceBuilder(int index) {
                return (Builder) getServiceFieldBuilder().getBuilder(index);
            }

            public ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int index) {
                if (this.serviceBuilder_ == null) {
                    return (ServiceDescriptorProtoOrBuilder) this.service_.get(index);
                }
                return (ServiceDescriptorProtoOrBuilder) this.serviceBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList() {
                if (this.serviceBuilder_ != null) {
                    return this.serviceBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.service_);
            }

            public Builder addServiceBuilder() {
                return (Builder) getServiceFieldBuilder().addBuilder(ServiceDescriptorProto.getDefaultInstance());
            }

            public Builder addServiceBuilder(int index) {
                return (Builder) getServiceFieldBuilder().addBuilder(index, ServiceDescriptorProto.getDefaultInstance());
            }

            public List<Builder> getServiceBuilderList() {
                return getServiceFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ServiceDescriptorProto, Builder, ServiceDescriptorProtoOrBuilder> getServiceFieldBuilder() {
                if (this.serviceBuilder_ == null) {
                    this.serviceBuilder_ = new RepeatedFieldBuilder(this.service_, (this.bitField0_ & 32) == 32, getParentForChildren(), isClean());
                    this.service_ = null;
                }
                return this.serviceBuilder_;
            }

            private void ensureExtensionIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.extension_ = new ArrayList(this.extension_);
                    this.bitField0_ |= 64;
                }
            }

            public List<FieldDescriptorProto> getExtensionList() {
                if (this.extensionBuilder_ == null) {
                    return Collections.unmodifiableList(this.extension_);
                }
                return this.extensionBuilder_.getMessageList();
            }

            public int getExtensionCount() {
                if (this.extensionBuilder_ == null) {
                    return this.extension_.size();
                }
                return this.extensionBuilder_.getCount();
            }

            public FieldDescriptorProto getExtension(int index) {
                if (this.extensionBuilder_ == null) {
                    return (FieldDescriptorProto) this.extension_.get(index);
                }
                return (FieldDescriptorProto) this.extensionBuilder_.getMessage(index);
            }

            public Builder setExtension(int index, FieldDescriptorProto value) {
                if (this.extensionBuilder_ != null) {
                    this.extensionBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtensionIsMutable();
                    this.extension_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setExtension(int index, Builder builderForValue) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extensionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExtension(FieldDescriptorProto value) {
                if (this.extensionBuilder_ != null) {
                    this.extensionBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtensionIsMutable();
                    this.extension_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtension(int index, FieldDescriptorProto value) {
                if (this.extensionBuilder_ != null) {
                    this.extensionBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtensionIsMutable();
                    this.extension_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtension(Builder builderForValue) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.extensionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExtension(int index, Builder builderForValue) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extensionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> values) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.extension_);
                    onChanged();
                } else {
                    this.extensionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExtension() {
                if (this.extensionBuilder_ == null) {
                    this.extension_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                    onChanged();
                } else {
                    this.extensionBuilder_.clear();
                }
                return this;
            }

            public Builder removeExtension(int index) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.remove(index);
                    onChanged();
                } else {
                    this.extensionBuilder_.remove(index);
                }
                return this;
            }

            public Builder getExtensionBuilder(int index) {
                return (Builder) getExtensionFieldBuilder().getBuilder(index);
            }

            public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index) {
                if (this.extensionBuilder_ == null) {
                    return (FieldDescriptorProtoOrBuilder) this.extension_.get(index);
                }
                return (FieldDescriptorProtoOrBuilder) this.extensionBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
                if (this.extensionBuilder_ != null) {
                    return this.extensionBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.extension_);
            }

            public Builder addExtensionBuilder() {
                return (Builder) getExtensionFieldBuilder().addBuilder(FieldDescriptorProto.getDefaultInstance());
            }

            public Builder addExtensionBuilder(int index) {
                return (Builder) getExtensionFieldBuilder().addBuilder(index, FieldDescriptorProto.getDefaultInstance());
            }

            public List<Builder> getExtensionBuilderList() {
                return getExtensionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<FieldDescriptorProto, Builder, FieldDescriptorProtoOrBuilder> getExtensionFieldBuilder() {
                if (this.extensionBuilder_ == null) {
                    this.extensionBuilder_ = new RepeatedFieldBuilder(this.extension_, (this.bitField0_ & 64) == 64, getParentForChildren(), isClean());
                    this.extension_ = null;
                }
                return this.extensionBuilder_;
            }

            public boolean hasOptions() {
                return (this.bitField0_ & XMLChar.MASK_NCNAME) == XMLChar.MASK_NCNAME;
            }

            public FileOptions getOptions() {
                if (this.optionsBuilder_ == null) {
                    return this.options_;
                }
                return (FileOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(FileOptions value) {
                if (this.optionsBuilder_ != null) {
                    this.optionsBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.options_ = value;
                    onChanged();
                }
                this.bitField0_ |= XMLChar.MASK_NCNAME;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= XMLChar.MASK_NCNAME;
                return this;
            }

            public Builder mergeOptions(FileOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & XMLChar.MASK_NCNAME) != XMLChar.MASK_NCNAME || this.options_ == FileOptions.getDefaultInstance()) {
                        this.options_ = value;
                    } else {
                        this.options_ = FileOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= XMLChar.MASK_NCNAME;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = FileOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -129;
                return this;
            }

            public Builder getOptionsBuilder() {
                this.bitField0_ |= XMLChar.MASK_NCNAME;
                onChanged();
                return (Builder) getOptionsFieldBuilder().getBuilder();
            }

            public FileOptionsOrBuilder getOptionsOrBuilder() {
                if (this.optionsBuilder_ != null) {
                    return (FileOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder();
                }
                return this.options_;
            }

            private SingleFieldBuilder<FileOptions, Builder, FileOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }

            public boolean hasSourceCodeInfo() {
                return (this.bitField0_ & 256) == 256;
            }

            public SourceCodeInfo getSourceCodeInfo() {
                if (this.sourceCodeInfoBuilder_ == null) {
                    return this.sourceCodeInfo_;
                }
                return (SourceCodeInfo) this.sourceCodeInfoBuilder_.getMessage();
            }

            public Builder setSourceCodeInfo(SourceCodeInfo value) {
                if (this.sourceCodeInfoBuilder_ != null) {
                    this.sourceCodeInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.sourceCodeInfo_ = value;
                    onChanged();
                }
                this.bitField0_ |= 256;
                return this;
            }

            public Builder setSourceCodeInfo(Builder builderForValue) {
                if (this.sourceCodeInfoBuilder_ == null) {
                    this.sourceCodeInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.sourceCodeInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 256;
                return this;
            }

            public Builder mergeSourceCodeInfo(SourceCodeInfo value) {
                if (this.sourceCodeInfoBuilder_ == null) {
                    if ((this.bitField0_ & 256) != 256 || this.sourceCodeInfo_ == SourceCodeInfo.getDefaultInstance()) {
                        this.sourceCodeInfo_ = value;
                    } else {
                        this.sourceCodeInfo_ = SourceCodeInfo.newBuilder(this.sourceCodeInfo_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    this.sourceCodeInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 256;
                return this;
            }

            public Builder clearSourceCodeInfo() {
                if (this.sourceCodeInfoBuilder_ == null) {
                    this.sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.sourceCodeInfoBuilder_.clear();
                }
                this.bitField0_ &= -257;
                return this;
            }

            public Builder getSourceCodeInfoBuilder() {
                this.bitField0_ |= 256;
                onChanged();
                return (Builder) getSourceCodeInfoFieldBuilder().getBuilder();
            }

            public SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder() {
                if (this.sourceCodeInfoBuilder_ != null) {
                    return (SourceCodeInfoOrBuilder) this.sourceCodeInfoBuilder_.getMessageOrBuilder();
                }
                return this.sourceCodeInfo_;
            }

            private SingleFieldBuilder<SourceCodeInfo, Builder, SourceCodeInfoOrBuilder> getSourceCodeInfoFieldBuilder() {
                if (this.sourceCodeInfoBuilder_ == null) {
                    this.sourceCodeInfoBuilder_ = new SingleFieldBuilder(this.sourceCodeInfo_, getParentForChildren(), isClean());
                    this.sourceCodeInfo_ = null;
                }
                return this.sourceCodeInfoBuilder_;
            }
        }

        private FileDescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private FileDescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static FileDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public FileDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f452x4b52780c;
        }

        public boolean hasName() {
            return (this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER;
        }

        public String getName() {
            ByteString ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        public boolean hasPackage() {
            return (this.bitField0_ & PACKAGE_FIELD_NUMBER) == PACKAGE_FIELD_NUMBER;
        }

        public String getPackage() {
            ByteString ref = this.package_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.package_ = s;
            }
            return s;
        }

        private ByteString getPackageBytes() {
            Object ref = this.package_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.package_ = b;
            return b;
        }

        public List<String> getDependencyList() {
            return this.dependency_;
        }

        public int getDependencyCount() {
            return this.dependency_.size();
        }

        public String getDependency(int index) {
            return (String) this.dependency_.get(index);
        }

        public List<DescriptorProto> getMessageTypeList() {
            return this.messageType_;
        }

        public List<? extends DescriptorProtoOrBuilder> getMessageTypeOrBuilderList() {
            return this.messageType_;
        }

        public int getMessageTypeCount() {
            return this.messageType_.size();
        }

        public DescriptorProto getMessageType(int index) {
            return (DescriptorProto) this.messageType_.get(index);
        }

        public DescriptorProtoOrBuilder getMessageTypeOrBuilder(int index) {
            return (DescriptorProtoOrBuilder) this.messageType_.get(index);
        }

        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        public EnumDescriptorProto getEnumType(int index) {
            return (EnumDescriptorProto) this.enumType_.get(index);
        }

        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index) {
            return (EnumDescriptorProtoOrBuilder) this.enumType_.get(index);
        }

        public List<ServiceDescriptorProto> getServiceList() {
            return this.service_;
        }

        public List<? extends ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList() {
            return this.service_;
        }

        public int getServiceCount() {
            return this.service_.size();
        }

        public ServiceDescriptorProto getService(int index) {
            return (ServiceDescriptorProto) this.service_.get(index);
        }

        public ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int index) {
            return (ServiceDescriptorProtoOrBuilder) this.service_.get(index);
        }

        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        public int getExtensionCount() {
            return this.extension_.size();
        }

        public FieldDescriptorProto getExtension(int index) {
            return (FieldDescriptorProto) this.extension_.get(index);
        }

        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index) {
            return (FieldDescriptorProtoOrBuilder) this.extension_.get(index);
        }

        public boolean hasOptions() {
            return (this.bitField0_ & MESSAGE_TYPE_FIELD_NUMBER) == MESSAGE_TYPE_FIELD_NUMBER;
        }

        public FileOptions getOptions() {
            return this.options_;
        }

        public FileOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        public boolean hasSourceCodeInfo() {
            return (this.bitField0_ & OPTIONS_FIELD_NUMBER) == OPTIONS_FIELD_NUMBER;
        }

        public SourceCodeInfo getSourceCodeInfo() {
            return this.sourceCodeInfo_;
        }

        public SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder() {
            return this.sourceCodeInfo_;
        }

        private void initFields() {
            this.name_ = StringUtil.EMPTY_STRING;
            this.package_ = StringUtil.EMPTY_STRING;
            this.dependency_ = LazyStringArrayList.EMPTY;
            this.messageType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.service_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.options_ = FileOptions.getDefaultInstance();
            this.sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
        }

        public final boolean isInitialized() {
            boolean z = true;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                if (isInitialized != (byte) 1) {
                    z = false;
                }
                return z;
            }
            int i = 0;
            while (i < getMessageTypeCount()) {
                if (getMessageType(i).isInitialized()) {
                    i += NAME_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getEnumTypeCount()) {
                if (getEnumType(i).isInitialized()) {
                    i += NAME_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getServiceCount()) {
                if (getService(i).isInitialized()) {
                    i += NAME_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getExtensionCount()) {
                if (getExtension(i).isInitialized()) {
                    i += NAME_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            int i;
            getSerializedSize();
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                output.writeBytes(NAME_FIELD_NUMBER, getNameBytes());
            }
            if ((this.bitField0_ & PACKAGE_FIELD_NUMBER) == PACKAGE_FIELD_NUMBER) {
                output.writeBytes(PACKAGE_FIELD_NUMBER, getPackageBytes());
            }
            for (i = 0; i < this.dependency_.size(); i += NAME_FIELD_NUMBER) {
                output.writeBytes(DEPENDENCY_FIELD_NUMBER, this.dependency_.getByteString(i));
            }
            for (i = 0; i < this.messageType_.size(); i += NAME_FIELD_NUMBER) {
                output.writeMessage(MESSAGE_TYPE_FIELD_NUMBER, (MessageLite) this.messageType_.get(i));
            }
            for (i = 0; i < this.enumType_.size(); i += NAME_FIELD_NUMBER) {
                output.writeMessage(ENUM_TYPE_FIELD_NUMBER, (MessageLite) this.enumType_.get(i));
            }
            for (i = 0; i < this.service_.size(); i += NAME_FIELD_NUMBER) {
                output.writeMessage(SERVICE_FIELD_NUMBER, (MessageLite) this.service_.get(i));
            }
            for (i = 0; i < this.extension_.size(); i += NAME_FIELD_NUMBER) {
                output.writeMessage(EXTENSION_FIELD_NUMBER, (MessageLite) this.extension_.get(i));
            }
            if ((this.bitField0_ & MESSAGE_TYPE_FIELD_NUMBER) == MESSAGE_TYPE_FIELD_NUMBER) {
                output.writeMessage(OPTIONS_FIELD_NUMBER, this.options_);
            }
            if ((this.bitField0_ & OPTIONS_FIELD_NUMBER) == OPTIONS_FIELD_NUMBER) {
                output.writeMessage(SOURCE_CODE_INFO_FIELD_NUMBER, this.sourceCodeInfo_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int i;
            size = 0;
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeBytesSize(NAME_FIELD_NUMBER, getNameBytes());
            }
            if ((this.bitField0_ & PACKAGE_FIELD_NUMBER) == PACKAGE_FIELD_NUMBER) {
                size += CodedOutputStream.computeBytesSize(PACKAGE_FIELD_NUMBER, getPackageBytes());
            }
            int dataSize = 0;
            for (i = 0; i < this.dependency_.size(); i += NAME_FIELD_NUMBER) {
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.dependency_.getByteString(i));
            }
            size = (size + dataSize) + (getDependencyList().size() * NAME_FIELD_NUMBER);
            for (i = 0; i < this.messageType_.size(); i += NAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(MESSAGE_TYPE_FIELD_NUMBER, (MessageLite) this.messageType_.get(i));
            }
            for (i = 0; i < this.enumType_.size(); i += NAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(ENUM_TYPE_FIELD_NUMBER, (MessageLite) this.enumType_.get(i));
            }
            for (i = 0; i < this.service_.size(); i += NAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(SERVICE_FIELD_NUMBER, (MessageLite) this.service_.get(i));
            }
            for (i = 0; i < this.extension_.size(); i += NAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(EXTENSION_FIELD_NUMBER, (MessageLite) this.extension_.get(i));
            }
            if ((this.bitField0_ & MESSAGE_TYPE_FIELD_NUMBER) == MESSAGE_TYPE_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(OPTIONS_FIELD_NUMBER, this.options_);
            }
            if ((this.bitField0_ & OPTIONS_FIELD_NUMBER) == OPTIONS_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(SOURCE_CODE_INFO_FIELD_NUMBER, this.sourceCodeInfo_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FileDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FileDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FileDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new FileDescriptorProto(true);
            defaultInstance.initFields();
        }
    }

    public interface FileDescriptorSetOrBuilder extends MessageOrBuilder {
        FileDescriptorProto getFile(int i);

        int getFileCount();

        List<FileDescriptorProto> getFileList();

        FileDescriptorProtoOrBuilder getFileOrBuilder(int i);

        List<? extends FileDescriptorProtoOrBuilder> getFileOrBuilderList();
    }

    public static final class FileDescriptorSet extends GeneratedMessage implements FileDescriptorSetOrBuilder {
        public static final int FILE_FIELD_NUMBER = 1;
        private static final FileDescriptorSet defaultInstance;
        private static final long serialVersionUID = 0;
        private List<FileDescriptorProto> file_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements FileDescriptorSetOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<FileDescriptorProto, Builder, FileDescriptorProtoOrBuilder> fileBuilder_;
            private List<FileDescriptorProto> file_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f453x15a6a952;
            }

            private Builder() {
                this.file_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.file_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getFileFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.fileBuilder_ == null) {
                    this.file_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.fileBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return FileDescriptorSet.getDescriptor();
            }

            public FileDescriptorSet getDefaultInstanceForType() {
                return FileDescriptorSet.getDefaultInstance();
            }

            public FileDescriptorSet build() {
                FileDescriptorSet result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private FileDescriptorSet buildParsed() throws InvalidProtocolBufferException {
                FileDescriptorSet result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public FileDescriptorSet buildPartial() {
                FileDescriptorSet result = new FileDescriptorSet();
                int from_bitField0_ = this.bitField0_;
                if (this.fileBuilder_ == null) {
                    if ((this.bitField0_ & FileDescriptorSet.FILE_FIELD_NUMBER) == FileDescriptorSet.FILE_FIELD_NUMBER) {
                        this.file_ = Collections.unmodifiableList(this.file_);
                        this.bitField0_ &= -2;
                    }
                    result.file_ = this.file_;
                } else {
                    result.file_ = this.fileBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FileDescriptorSet) {
                    return mergeFrom((FileDescriptorSet) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FileDescriptorSet other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != FileDescriptorSet.getDefaultInstance()) {
                    if (this.fileBuilder_ == null) {
                        if (!other.file_.isEmpty()) {
                            if (this.file_.isEmpty()) {
                                this.file_ = other.file_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureFileIsMutable();
                                this.file_.addAll(other.file_);
                            }
                            onChanged();
                        }
                    } else if (!other.file_.isEmpty()) {
                        if (this.fileBuilder_.isEmpty()) {
                            this.fileBuilder_.dispose();
                            this.fileBuilder_ = null;
                            this.file_ = other.file_;
                            this.bitField0_ &= -2;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getFileFieldBuilder();
                            }
                            this.fileBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.fileBuilder_.addAllMessages(other.file_);
                        }
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getFileCount(); i += FileDescriptorSet.FILE_FIELD_NUMBER) {
                    if (!getFile(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                            Builder subBuilder = FileDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addFile(subBuilder.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            private void ensureFileIsMutable() {
                if ((this.bitField0_ & FileDescriptorSet.FILE_FIELD_NUMBER) != FileDescriptorSet.FILE_FIELD_NUMBER) {
                    this.file_ = new ArrayList(this.file_);
                    this.bitField0_ |= FileDescriptorSet.FILE_FIELD_NUMBER;
                }
            }

            public List<FileDescriptorProto> getFileList() {
                if (this.fileBuilder_ == null) {
                    return Collections.unmodifiableList(this.file_);
                }
                return this.fileBuilder_.getMessageList();
            }

            public int getFileCount() {
                if (this.fileBuilder_ == null) {
                    return this.file_.size();
                }
                return this.fileBuilder_.getCount();
            }

            public FileDescriptorProto getFile(int index) {
                if (this.fileBuilder_ == null) {
                    return (FileDescriptorProto) this.file_.get(index);
                }
                return (FileDescriptorProto) this.fileBuilder_.getMessage(index);
            }

            public Builder setFile(int index, FileDescriptorProto value) {
                if (this.fileBuilder_ != null) {
                    this.fileBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFileIsMutable();
                    this.file_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFile(int index, Builder builderForValue) {
                if (this.fileBuilder_ == null) {
                    ensureFileIsMutable();
                    this.file_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fileBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFile(FileDescriptorProto value) {
                if (this.fileBuilder_ != null) {
                    this.fileBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFileIsMutable();
                    this.file_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFile(int index, FileDescriptorProto value) {
                if (this.fileBuilder_ != null) {
                    this.fileBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFileIsMutable();
                    this.file_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFile(Builder builderForValue) {
                if (this.fileBuilder_ == null) {
                    ensureFileIsMutable();
                    this.file_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.fileBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFile(int index, Builder builderForValue) {
                if (this.fileBuilder_ == null) {
                    ensureFileIsMutable();
                    this.file_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fileBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFile(Iterable<? extends FileDescriptorProto> values) {
                if (this.fileBuilder_ == null) {
                    ensureFileIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.file_);
                    onChanged();
                } else {
                    this.fileBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFile() {
                if (this.fileBuilder_ == null) {
                    this.file_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.fileBuilder_.clear();
                }
                return this;
            }

            public Builder removeFile(int index) {
                if (this.fileBuilder_ == null) {
                    ensureFileIsMutable();
                    this.file_.remove(index);
                    onChanged();
                } else {
                    this.fileBuilder_.remove(index);
                }
                return this;
            }

            public Builder getFileBuilder(int index) {
                return (Builder) getFileFieldBuilder().getBuilder(index);
            }

            public FileDescriptorProtoOrBuilder getFileOrBuilder(int index) {
                if (this.fileBuilder_ == null) {
                    return (FileDescriptorProtoOrBuilder) this.file_.get(index);
                }
                return (FileDescriptorProtoOrBuilder) this.fileBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends FileDescriptorProtoOrBuilder> getFileOrBuilderList() {
                if (this.fileBuilder_ != null) {
                    return this.fileBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.file_);
            }

            public Builder addFileBuilder() {
                return (Builder) getFileFieldBuilder().addBuilder(FileDescriptorProto.getDefaultInstance());
            }

            public Builder addFileBuilder(int index) {
                return (Builder) getFileFieldBuilder().addBuilder(index, FileDescriptorProto.getDefaultInstance());
            }

            public List<Builder> getFileBuilderList() {
                return getFileFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<FileDescriptorProto, Builder, FileDescriptorProtoOrBuilder> getFileFieldBuilder() {
                boolean z = true;
                if (this.fileBuilder_ == null) {
                    List list = this.file_;
                    if ((this.bitField0_ & FileDescriptorSet.FILE_FIELD_NUMBER) != FileDescriptorSet.FILE_FIELD_NUMBER) {
                        z = false;
                    }
                    this.fileBuilder_ = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
                    this.file_ = null;
                }
                return this.fileBuilder_;
            }
        }

        private FileDescriptorSet(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private FileDescriptorSet(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static FileDescriptorSet getDefaultInstance() {
            return defaultInstance;
        }

        public FileDescriptorSet getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f453x15a6a952;
        }

        public List<FileDescriptorProto> getFileList() {
            return this.file_;
        }

        public List<? extends FileDescriptorProtoOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        public int getFileCount() {
            return this.file_.size();
        }

        public FileDescriptorProto getFile(int index) {
            return (FileDescriptorProto) this.file_.get(index);
        }

        public FileDescriptorProtoOrBuilder getFileOrBuilder(int index) {
            return (FileDescriptorProtoOrBuilder) this.file_.get(index);
        }

        private void initFields() {
            this.file_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getFileCount()) {
                    if (getFile(i).isInitialized()) {
                        i += FILE_FIELD_NUMBER;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.file_.size(); i += FILE_FIELD_NUMBER) {
                output.writeMessage(FILE_FIELD_NUMBER, (MessageLite) this.file_.get(i));
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.file_.size(); i += FILE_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(FILE_FIELD_NUMBER, (MessageLite) this.file_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FileDescriptorSet parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FileDescriptorSet parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FileDescriptorSet prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new FileDescriptorSet(true);
            defaultInstance.initFields();
        }
    }

    public interface FileOptionsOrBuilder extends ExtendableMessageOrBuilder<FileOptions> {
        boolean getCcGenericServices();

        boolean getJavaGenerateEqualsAndHash();

        boolean getJavaGenericServices();

        boolean getJavaMultipleFiles();

        String getJavaOuterClassname();

        String getJavaPackage();

        OptimizeMode getOptimizeFor();

        boolean getPyGenericServices();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();

        boolean hasCcGenericServices();

        boolean hasJavaGenerateEqualsAndHash();

        boolean hasJavaGenericServices();

        boolean hasJavaMultipleFiles();

        boolean hasJavaOuterClassname();

        boolean hasJavaPackage();

        boolean hasOptimizeFor();

        boolean hasPyGenericServices();
    }

    public static final class FileOptions extends ExtendableMessage<FileOptions> implements FileOptionsOrBuilder {
        public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
        public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
        public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
        public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
        public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
        public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
        public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
        public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final FileOptions defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean ccGenericServices_;
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private Object javaOuterClassname_;
        private Object javaPackage_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private OptimizeMode optimizeFor_;
        private boolean pyGenericServices_;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<FileOptions, Builder> implements FileOptionsOrBuilder {
            private int bitField0_;
            private boolean ccGenericServices_;
            private boolean javaGenerateEqualsAndHash_;
            private boolean javaGenericServices_;
            private boolean javaMultipleFiles_;
            private Object javaOuterClassname_;
            private Object javaPackage_;
            private OptimizeMode optimizeFor_;
            private boolean pyGenericServices_;
            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable;
            }

            private Builder() {
                this.javaPackage_ = StringUtil.EMPTY_STRING;
                this.javaOuterClassname_ = StringUtil.EMPTY_STRING;
                this.optimizeFor_ = OptimizeMode.SPEED;
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.javaPackage_ = StringUtil.EMPTY_STRING;
                this.javaOuterClassname_ = StringUtil.EMPTY_STRING;
                this.optimizeFor_ = OptimizeMode.SPEED;
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.javaPackage_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -2;
                this.javaOuterClassname_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -3;
                this.javaMultipleFiles_ = false;
                this.bitField0_ &= -5;
                this.javaGenerateEqualsAndHash_ = false;
                this.bitField0_ &= -9;
                this.optimizeFor_ = OptimizeMode.SPEED;
                this.bitField0_ &= -17;
                this.ccGenericServices_ = false;
                this.bitField0_ &= -33;
                this.javaGenericServices_ = false;
                this.bitField0_ &= -65;
                this.pyGenericServices_ = false;
                this.bitField0_ &= -129;
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -257;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return FileOptions.getDescriptor();
            }

            public FileOptions getDefaultInstanceForType() {
                return FileOptions.getDefaultInstance();
            }

            public FileOptions build() {
                FileOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private FileOptions buildParsed() throws InvalidProtocolBufferException {
                FileOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public FileOptions buildPartial() {
                FileOptions result = new FileOptions();
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & FileOptions.JAVA_PACKAGE_FIELD_NUMBER) == FileOptions.JAVA_PACKAGE_FIELD_NUMBER) {
                    to_bitField0_ = 0 | FileOptions.JAVA_PACKAGE_FIELD_NUMBER;
                }
                result.javaPackage_ = this.javaPackage_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.javaOuterClassname_ = this.javaOuterClassname_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.javaMultipleFiles_ = this.javaMultipleFiles_;
                if ((from_bitField0_ & FileOptions.JAVA_OUTER_CLASSNAME_FIELD_NUMBER) == FileOptions.JAVA_OUTER_CLASSNAME_FIELD_NUMBER) {
                    to_bitField0_ |= FileOptions.JAVA_OUTER_CLASSNAME_FIELD_NUMBER;
                }
                result.javaGenerateEqualsAndHash_ = this.javaGenerateEqualsAndHash_;
                if ((from_bitField0_ & FileOptions.CC_GENERIC_SERVICES_FIELD_NUMBER) == FileOptions.CC_GENERIC_SERVICES_FIELD_NUMBER) {
                    to_bitField0_ |= FileOptions.CC_GENERIC_SERVICES_FIELD_NUMBER;
                }
                result.optimizeFor_ = this.optimizeFor_;
                if ((from_bitField0_ & 32) == 32) {
                    to_bitField0_ |= 32;
                }
                result.ccGenericServices_ = this.ccGenericServices_;
                if ((from_bitField0_ & 64) == 64) {
                    to_bitField0_ |= 64;
                }
                result.javaGenericServices_ = this.javaGenericServices_;
                if ((from_bitField0_ & XMLChar.MASK_NCNAME) == XMLChar.MASK_NCNAME) {
                    to_bitField0_ |= XMLChar.MASK_NCNAME;
                }
                result.pyGenericServices_ = this.pyGenericServices_;
                if (this.uninterpretedOptionBuilder_ == null) {
                    if ((this.bitField0_ & 256) == 256) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -257;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                } else {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FileOptions) {
                    return mergeFrom((FileOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FileOptions other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != FileOptions.getDefaultInstance()) {
                    if (other.hasJavaPackage()) {
                        setJavaPackage(other.getJavaPackage());
                    }
                    if (other.hasJavaOuterClassname()) {
                        setJavaOuterClassname(other.getJavaOuterClassname());
                    }
                    if (other.hasJavaMultipleFiles()) {
                        setJavaMultipleFiles(other.getJavaMultipleFiles());
                    }
                    if (other.hasJavaGenerateEqualsAndHash()) {
                        setJavaGenerateEqualsAndHash(other.getJavaGenerateEqualsAndHash());
                    }
                    if (other.hasOptimizeFor()) {
                        setOptimizeFor(other.getOptimizeFor());
                    }
                    if (other.hasCcGenericServices()) {
                        setCcGenericServices(other.getCcGenericServices());
                    }
                    if (other.hasJavaGenericServices()) {
                        setJavaGenericServices(other.getJavaGenericServices());
                    }
                    if (other.hasPyGenericServices()) {
                        setPyGenericServices(other.getPyGenericServices());
                    }
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -257;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -257;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getUninterpretedOptionFieldBuilder();
                            }
                            this.uninterpretedOptionBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i += FileOptions.JAVA_PACKAGE_FIELD_NUMBER) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case FileOptions.JAVA_MULTIPLE_FILES_FIELD_NUMBER /*10*/:
                            this.bitField0_ |= FileOptions.JAVA_PACKAGE_FIELD_NUMBER;
                            this.javaPackage_ = input.readBytes();
                            continue;
                        case 66:
                            this.bitField0_ |= 2;
                            this.javaOuterClassname_ = input.readBytes();
                            continue;
                        case HtmlToText.EMAIL_LINE_WIDTH_MAX /*72*/:
                            int rawValue = input.readEnum();
                            OptimizeMode value = OptimizeMode.valueOf(rawValue);
                            if (value != null) {
                                this.bitField0_ |= FileOptions.CC_GENERIC_SERVICES_FIELD_NUMBER;
                                this.optimizeFor_ = value;
                                break;
                            }
                            unknownFields.mergeVarintField(FileOptions.OPTIMIZE_FOR_FIELD_NUMBER, rawValue);
                            continue;
                        case 80:
                            this.bitField0_ |= 4;
                            this.javaMultipleFiles_ = input.readBool();
                            continue;
                        case XMLChar.MASK_NCNAME /*128*/:
                            this.bitField0_ |= 32;
                            this.ccGenericServices_ = input.readBool();
                            continue;
                        case 136:
                            this.bitField0_ |= 64;
                            this.javaGenericServices_ = input.readBool();
                            continue;
                        case 144:
                            this.bitField0_ |= XMLChar.MASK_NCNAME;
                            this.pyGenericServices_ = input.readBool();
                            continue;
                        case 160:
                            this.bitField0_ |= FileOptions.JAVA_OUTER_CLASSNAME_FIELD_NUMBER;
                            this.javaGenerateEqualsAndHash_ = input.readBool();
                            continue;
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasJavaPackage() {
                return (this.bitField0_ & FileOptions.JAVA_PACKAGE_FIELD_NUMBER) == FileOptions.JAVA_PACKAGE_FIELD_NUMBER;
            }

            public String getJavaPackage() {
                Object ref = this.javaPackage_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.javaPackage_ = s;
                return s;
            }

            public Builder setJavaPackage(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= FileOptions.JAVA_PACKAGE_FIELD_NUMBER;
                this.javaPackage_ = value;
                onChanged();
                return this;
            }

            public Builder clearJavaPackage() {
                this.bitField0_ &= -2;
                this.javaPackage_ = FileOptions.getDefaultInstance().getJavaPackage();
                onChanged();
                return this;
            }

            void setJavaPackage(ByteString value) {
                this.bitField0_ |= FileOptions.JAVA_PACKAGE_FIELD_NUMBER;
                this.javaPackage_ = value;
                onChanged();
            }

            public boolean hasJavaOuterClassname() {
                return (this.bitField0_ & 2) == 2;
            }

            public String getJavaOuterClassname() {
                Object ref = this.javaOuterClassname_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.javaOuterClassname_ = s;
                return s;
            }

            public Builder setJavaOuterClassname(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.javaOuterClassname_ = value;
                onChanged();
                return this;
            }

            public Builder clearJavaOuterClassname() {
                this.bitField0_ &= -3;
                this.javaOuterClassname_ = FileOptions.getDefaultInstance().getJavaOuterClassname();
                onChanged();
                return this;
            }

            void setJavaOuterClassname(ByteString value) {
                this.bitField0_ |= 2;
                this.javaOuterClassname_ = value;
                onChanged();
            }

            public boolean hasJavaMultipleFiles() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean getJavaMultipleFiles() {
                return this.javaMultipleFiles_;
            }

            public Builder setJavaMultipleFiles(boolean value) {
                this.bitField0_ |= 4;
                this.javaMultipleFiles_ = value;
                onChanged();
                return this;
            }

            public Builder clearJavaMultipleFiles() {
                this.bitField0_ &= -5;
                this.javaMultipleFiles_ = false;
                onChanged();
                return this;
            }

            public boolean hasJavaGenerateEqualsAndHash() {
                return (this.bitField0_ & FileOptions.JAVA_OUTER_CLASSNAME_FIELD_NUMBER) == FileOptions.JAVA_OUTER_CLASSNAME_FIELD_NUMBER;
            }

            public boolean getJavaGenerateEqualsAndHash() {
                return this.javaGenerateEqualsAndHash_;
            }

            public Builder setJavaGenerateEqualsAndHash(boolean value) {
                this.bitField0_ |= FileOptions.JAVA_OUTER_CLASSNAME_FIELD_NUMBER;
                this.javaGenerateEqualsAndHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearJavaGenerateEqualsAndHash() {
                this.bitField0_ &= -9;
                this.javaGenerateEqualsAndHash_ = false;
                onChanged();
                return this;
            }

            public boolean hasOptimizeFor() {
                return (this.bitField0_ & FileOptions.CC_GENERIC_SERVICES_FIELD_NUMBER) == FileOptions.CC_GENERIC_SERVICES_FIELD_NUMBER;
            }

            public OptimizeMode getOptimizeFor() {
                return this.optimizeFor_;
            }

            public Builder setOptimizeFor(OptimizeMode value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= FileOptions.CC_GENERIC_SERVICES_FIELD_NUMBER;
                this.optimizeFor_ = value;
                onChanged();
                return this;
            }

            public Builder clearOptimizeFor() {
                this.bitField0_ &= -17;
                this.optimizeFor_ = OptimizeMode.SPEED;
                onChanged();
                return this;
            }

            public boolean hasCcGenericServices() {
                return (this.bitField0_ & 32) == 32;
            }

            public boolean getCcGenericServices() {
                return this.ccGenericServices_;
            }

            public Builder setCcGenericServices(boolean value) {
                this.bitField0_ |= 32;
                this.ccGenericServices_ = value;
                onChanged();
                return this;
            }

            public Builder clearCcGenericServices() {
                this.bitField0_ &= -33;
                this.ccGenericServices_ = false;
                onChanged();
                return this;
            }

            public boolean hasJavaGenericServices() {
                return (this.bitField0_ & 64) == 64;
            }

            public boolean getJavaGenericServices() {
                return this.javaGenericServices_;
            }

            public Builder setJavaGenericServices(boolean value) {
                this.bitField0_ |= 64;
                this.javaGenericServices_ = value;
                onChanged();
                return this;
            }

            public Builder clearJavaGenericServices() {
                this.bitField0_ &= -65;
                this.javaGenericServices_ = false;
                onChanged();
                return this;
            }

            public boolean hasPyGenericServices() {
                return (this.bitField0_ & XMLChar.MASK_NCNAME) == XMLChar.MASK_NCNAME;
            }

            public boolean getPyGenericServices() {
                return this.pyGenericServices_;
            }

            public Builder setPyGenericServices(boolean value) {
                this.bitField0_ |= XMLChar.MASK_NCNAME;
                this.pyGenericServices_ = value;
                onChanged();
                return this;
            }

            public Builder clearPyGenericServices() {
                this.bitField0_ &= -129;
                this.pyGenericServices_ = false;
                onChanged();
                return this;
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 256;
                }
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return Collections.unmodifiableList(this.uninterpretedOption_);
                }
                return this.uninterpretedOptionBuilder_.getMessageList();
            }

            public int getUninterpretedOptionCount() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return this.uninterpretedOption_.size();
                }
                return this.uninterpretedOptionBuilder_.getCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOption) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -257;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public Builder getUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                if (this.uninterpretedOptionBuilder_ != null) {
                    return this.uninterpretedOptionBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public Builder addUninterpretedOptionBuilder() {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public Builder addUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 256) == 256, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        public enum OptimizeMode implements ProtocolMessageEnum {
            SPEED(0, SPEED_VALUE),
            CODE_SIZE(SPEED_VALUE, CODE_SIZE_VALUE),
            LITE_RUNTIME(CODE_SIZE_VALUE, LITE_RUNTIME_VALUE);
            
            public static final int CODE_SIZE_VALUE = 2;
            public static final int LITE_RUNTIME_VALUE = 3;
            public static final int SPEED_VALUE = 1;
            private static final OptimizeMode[] VALUES;
            private static EnumLiteMap<OptimizeMode> internalValueMap;
            private final int index;
            private final int value;

            /* renamed from: com.google.protobuf.DescriptorProtos.FileOptions.OptimizeMode.1 */
            static class C08431 implements EnumLiteMap<OptimizeMode> {
                C08431() {
                }

                public OptimizeMode findValueByNumber(int number) {
                    return OptimizeMode.valueOf(number);
                }
            }

            static {
                internalValueMap = new C08431();
                OptimizeMode[] optimizeModeArr = new OptimizeMode[LITE_RUNTIME_VALUE];
                optimizeModeArr[0] = SPEED;
                optimizeModeArr[SPEED_VALUE] = CODE_SIZE;
                optimizeModeArr[CODE_SIZE_VALUE] = LITE_RUNTIME;
                VALUES = optimizeModeArr;
            }

            public final int getNumber() {
                return this.value;
            }

            public static OptimizeMode valueOf(int value) {
                switch (value) {
                    case SPEED_VALUE:
                        return SPEED;
                    case CODE_SIZE_VALUE:
                        return CODE_SIZE;
                    case LITE_RUNTIME_VALUE:
                        return LITE_RUNTIME;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<OptimizeMode> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().getValues().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) FileOptions.getDescriptor().getEnumTypes().get(0);
            }

            public static OptimizeMode valueOf(EnumValueDescriptor desc) {
                if (desc.getType() == getDescriptor()) {
                    return VALUES[desc.getIndex()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private OptimizeMode(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        private FileOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private FileOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static FileOptions getDefaultInstance() {
            return defaultInstance;
        }

        public FileOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable;
        }

        public boolean hasJavaPackage() {
            return (this.bitField0_ & JAVA_PACKAGE_FIELD_NUMBER) == JAVA_PACKAGE_FIELD_NUMBER;
        }

        public String getJavaPackage() {
            ByteString ref = this.javaPackage_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.javaPackage_ = s;
            }
            return s;
        }

        private ByteString getJavaPackageBytes() {
            Object ref = this.javaPackage_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.javaPackage_ = b;
            return b;
        }

        public boolean hasJavaOuterClassname() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getJavaOuterClassname() {
            ByteString ref = this.javaOuterClassname_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.javaOuterClassname_ = s;
            }
            return s;
        }

        private ByteString getJavaOuterClassnameBytes() {
            Object ref = this.javaOuterClassname_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.javaOuterClassname_ = b;
            return b;
        }

        public boolean hasJavaMultipleFiles() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean getJavaMultipleFiles() {
            return this.javaMultipleFiles_;
        }

        public boolean hasJavaGenerateEqualsAndHash() {
            return (this.bitField0_ & JAVA_OUTER_CLASSNAME_FIELD_NUMBER) == JAVA_OUTER_CLASSNAME_FIELD_NUMBER;
        }

        public boolean getJavaGenerateEqualsAndHash() {
            return this.javaGenerateEqualsAndHash_;
        }

        public boolean hasOptimizeFor() {
            return (this.bitField0_ & CC_GENERIC_SERVICES_FIELD_NUMBER) == CC_GENERIC_SERVICES_FIELD_NUMBER;
        }

        public OptimizeMode getOptimizeFor() {
            return this.optimizeFor_;
        }

        public boolean hasCcGenericServices() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean getCcGenericServices() {
            return this.ccGenericServices_;
        }

        public boolean hasJavaGenericServices() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean getJavaGenericServices() {
            return this.javaGenericServices_;
        }

        public boolean hasPyGenericServices() {
            return (this.bitField0_ & XMLChar.MASK_NCNAME) == XMLChar.MASK_NCNAME;
        }

        public boolean getPyGenericServices() {
            return this.pyGenericServices_;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.javaPackage_ = StringUtil.EMPTY_STRING;
            this.javaOuterClassname_ = StringUtil.EMPTY_STRING;
            this.javaMultipleFiles_ = false;
            this.javaGenerateEqualsAndHash_ = false;
            this.optimizeFor_ = OptimizeMode.SPEED;
            this.ccGenericServices_ = false;
            this.javaGenericServices_ = false;
            this.pyGenericServices_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getUninterpretedOptionCount()) {
                    if (getUninterpretedOption(i).isInitialized()) {
                        i += JAVA_PACKAGE_FIELD_NUMBER;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            ExtensionWriter extensionWriter = newExtensionWriter();
            if ((this.bitField0_ & JAVA_PACKAGE_FIELD_NUMBER) == JAVA_PACKAGE_FIELD_NUMBER) {
                output.writeBytes(JAVA_PACKAGE_FIELD_NUMBER, getJavaPackageBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeBytes(JAVA_OUTER_CLASSNAME_FIELD_NUMBER, getJavaOuterClassnameBytes());
            }
            if ((this.bitField0_ & CC_GENERIC_SERVICES_FIELD_NUMBER) == CC_GENERIC_SERVICES_FIELD_NUMBER) {
                output.writeEnum(OPTIMIZE_FOR_FIELD_NUMBER, this.optimizeFor_.getNumber());
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeBool(JAVA_MULTIPLE_FILES_FIELD_NUMBER, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeBool(CC_GENERIC_SERVICES_FIELD_NUMBER, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 64) == 64) {
                output.writeBool(JAVA_GENERIC_SERVICES_FIELD_NUMBER, this.javaGenericServices_);
            }
            if ((this.bitField0_ & XMLChar.MASK_NCNAME) == XMLChar.MASK_NCNAME) {
                output.writeBool(PY_GENERIC_SERVICES_FIELD_NUMBER, this.pyGenericServices_);
            }
            if ((this.bitField0_ & JAVA_OUTER_CLASSNAME_FIELD_NUMBER) == JAVA_OUTER_CLASSNAME_FIELD_NUMBER) {
                output.writeBool(JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER, this.javaGenerateEqualsAndHash_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i += JAVA_PACKAGE_FIELD_NUMBER) {
                output.writeMessage(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            extensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & JAVA_PACKAGE_FIELD_NUMBER) == JAVA_PACKAGE_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeBytesSize(JAVA_PACKAGE_FIELD_NUMBER, getJavaPackageBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeBytesSize(JAVA_OUTER_CLASSNAME_FIELD_NUMBER, getJavaOuterClassnameBytes());
            }
            if ((this.bitField0_ & CC_GENERIC_SERVICES_FIELD_NUMBER) == CC_GENERIC_SERVICES_FIELD_NUMBER) {
                size += CodedOutputStream.computeEnumSize(OPTIMIZE_FOR_FIELD_NUMBER, this.optimizeFor_.getNumber());
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeBoolSize(JAVA_MULTIPLE_FILES_FIELD_NUMBER, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 32) == 32) {
                size += CodedOutputStream.computeBoolSize(CC_GENERIC_SERVICES_FIELD_NUMBER, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 64) == 64) {
                size += CodedOutputStream.computeBoolSize(JAVA_GENERIC_SERVICES_FIELD_NUMBER, this.javaGenericServices_);
            }
            if ((this.bitField0_ & XMLChar.MASK_NCNAME) == XMLChar.MASK_NCNAME) {
                size += CodedOutputStream.computeBoolSize(PY_GENERIC_SERVICES_FIELD_NUMBER, this.pyGenericServices_);
            }
            if ((this.bitField0_ & JAVA_OUTER_CLASSNAME_FIELD_NUMBER) == JAVA_OUTER_CLASSNAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeBoolSize(JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER, this.javaGenerateEqualsAndHash_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i += JAVA_PACKAGE_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FileOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FileOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FileOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FileOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FileOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FileOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FileOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FileOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FileOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new FileOptions(true);
            defaultInstance.initFields();
        }
    }

    public interface MessageOptionsOrBuilder extends ExtendableMessageOrBuilder<MessageOptions> {
        boolean getMessageSetWireFormat();

        boolean getNoStandardDescriptorAccessor();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();

        boolean hasMessageSetWireFormat();

        boolean hasNoStandardDescriptorAccessor();
    }

    public static final class MessageOptions extends ExtendableMessage<MessageOptions> implements MessageOptionsOrBuilder {
        public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
        public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final MessageOptions defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<MessageOptions, Builder> implements MessageOptionsOrBuilder {
            private int bitField0_;
            private boolean messageSetWireFormat_;
            private boolean noStandardDescriptorAccessor_;
            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f454x9c0b3d38;
            }

            private Builder() {
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.messageSetWireFormat_ = false;
                this.bitField0_ &= -2;
                this.noStandardDescriptorAccessor_ = false;
                this.bitField0_ &= -3;
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return MessageOptions.getDescriptor();
            }

            public MessageOptions getDefaultInstanceForType() {
                return MessageOptions.getDefaultInstance();
            }

            public MessageOptions build() {
                MessageOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private MessageOptions buildParsed() throws InvalidProtocolBufferException {
                MessageOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public MessageOptions buildPartial() {
                MessageOptions result = new MessageOptions();
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & MessageOptions.MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER) == MessageOptions.MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER) {
                    to_bitField0_ = 0 | MessageOptions.MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER;
                }
                result.messageSetWireFormat_ = this.messageSetWireFormat_;
                if ((from_bitField0_ & MessageOptions.NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER) == MessageOptions.NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER) {
                    to_bitField0_ |= MessageOptions.NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER;
                }
                result.noStandardDescriptorAccessor_ = this.noStandardDescriptorAccessor_;
                if (this.uninterpretedOptionBuilder_ == null) {
                    if ((this.bitField0_ & 4) == 4) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -5;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                } else {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MessageOptions) {
                    return mergeFrom((MessageOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MessageOptions other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != MessageOptions.getDefaultInstance()) {
                    if (other.hasMessageSetWireFormat()) {
                        setMessageSetWireFormat(other.getMessageSetWireFormat());
                    }
                    if (other.hasNoStandardDescriptorAccessor()) {
                        setNoStandardDescriptorAccessor(other.getNoStandardDescriptorAccessor());
                    }
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -5;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -5;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getUninterpretedOptionFieldBuilder();
                            }
                            this.uninterpretedOptionBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i += MessageOptions.MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case PayPalActivity.VIEW_TEST /*8*/:
                            this.bitField0_ |= MessageOptions.MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER;
                            this.messageSetWireFormat_ = input.readBool();
                            continue;
                        case Segment.TOKENS_PER_SEGMENT /*16*/:
                            this.bitField0_ |= MessageOptions.NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER;
                            this.noStandardDescriptorAccessor_ = input.readBool();
                            continue;
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasMessageSetWireFormat() {
                return (this.bitField0_ & MessageOptions.MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER) == MessageOptions.MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER;
            }

            public boolean getMessageSetWireFormat() {
                return this.messageSetWireFormat_;
            }

            public Builder setMessageSetWireFormat(boolean value) {
                this.bitField0_ |= MessageOptions.MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER;
                this.messageSetWireFormat_ = value;
                onChanged();
                return this;
            }

            public Builder clearMessageSetWireFormat() {
                this.bitField0_ &= -2;
                this.messageSetWireFormat_ = false;
                onChanged();
                return this;
            }

            public boolean hasNoStandardDescriptorAccessor() {
                return (this.bitField0_ & MessageOptions.NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER) == MessageOptions.NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER;
            }

            public boolean getNoStandardDescriptorAccessor() {
                return this.noStandardDescriptorAccessor_;
            }

            public Builder setNoStandardDescriptorAccessor(boolean value) {
                this.bitField0_ |= MessageOptions.NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER;
                this.noStandardDescriptorAccessor_ = value;
                onChanged();
                return this;
            }

            public Builder clearNoStandardDescriptorAccessor() {
                this.bitField0_ &= -3;
                this.noStandardDescriptorAccessor_ = false;
                onChanged();
                return this;
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 4;
                }
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return Collections.unmodifiableList(this.uninterpretedOption_);
                }
                return this.uninterpretedOptionBuilder_.getMessageList();
            }

            public int getUninterpretedOptionCount() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return this.uninterpretedOption_.size();
                }
                return this.uninterpretedOptionBuilder_.getCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOption) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public Builder getUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                if (this.uninterpretedOptionBuilder_ != null) {
                    return this.uninterpretedOptionBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public Builder addUninterpretedOptionBuilder() {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public Builder addUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        private MessageOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MessageOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MessageOptions getDefaultInstance() {
            return defaultInstance;
        }

        public MessageOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f454x9c0b3d38;
        }

        public boolean hasMessageSetWireFormat() {
            return (this.bitField0_ & MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER) == MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER;
        }

        public boolean getMessageSetWireFormat() {
            return this.messageSetWireFormat_;
        }

        public boolean hasNoStandardDescriptorAccessor() {
            return (this.bitField0_ & NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER) == NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER;
        }

        public boolean getNoStandardDescriptorAccessor() {
            return this.noStandardDescriptorAccessor_;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.messageSetWireFormat_ = false;
            this.noStandardDescriptorAccessor_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getUninterpretedOptionCount()) {
                    if (getUninterpretedOption(i).isInitialized()) {
                        i += MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            ExtensionWriter extensionWriter = newExtensionWriter();
            if ((this.bitField0_ & MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER) == MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER) {
                output.writeBool(MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER, this.messageSetWireFormat_);
            }
            if ((this.bitField0_ & NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER) == NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER) {
                output.writeBool(NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER, this.noStandardDescriptorAccessor_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i += MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER) {
                output.writeMessage(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            extensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER) == MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeBoolSize(MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER, this.messageSetWireFormat_);
            }
            if ((this.bitField0_ & NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER) == NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER) {
                size += CodedOutputStream.computeBoolSize(NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER, this.noStandardDescriptorAccessor_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i += MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MessageOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static MessageOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static MessageOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static MessageOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static MessageOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MessageOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static MessageOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static MessageOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static MessageOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MessageOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MessageOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new MessageOptions(true);
            defaultInstance.initFields();
        }
    }

    public interface MethodDescriptorProtoOrBuilder extends MessageOrBuilder {
        String getInputType();

        String getName();

        MethodOptions getOptions();

        MethodOptionsOrBuilder getOptionsOrBuilder();

        String getOutputType();

        boolean hasInputType();

        boolean hasName();

        boolean hasOptions();

        boolean hasOutputType();
    }

    public static final class MethodDescriptorProto extends GeneratedMessage implements MethodDescriptorProtoOrBuilder {
        public static final int INPUT_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
        private static final MethodDescriptorProto defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object inputType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private MethodOptions options_;
        private Object outputType_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements MethodDescriptorProtoOrBuilder {
            private int bitField0_;
            private Object inputType_;
            private Object name_;
            private SingleFieldBuilder<MethodOptions, Builder, MethodOptionsOrBuilder> optionsBuilder_;
            private MethodOptions options_;
            private Object outputType_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f455xc5331ef1;
            }

            private Builder() {
                this.name_ = StringUtil.EMPTY_STRING;
                this.inputType_ = StringUtil.EMPTY_STRING;
                this.outputType_ = StringUtil.EMPTY_STRING;
                this.options_ = MethodOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.name_ = StringUtil.EMPTY_STRING;
                this.inputType_ = StringUtil.EMPTY_STRING;
                this.outputType_ = StringUtil.EMPTY_STRING;
                this.options_ = MethodOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getOptionsFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.name_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -2;
                this.inputType_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -3;
                this.outputType_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -5;
                if (this.optionsBuilder_ == null) {
                    this.options_ = MethodOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -9;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return MethodDescriptorProto.getDescriptor();
            }

            public MethodDescriptorProto getDefaultInstanceForType() {
                return MethodDescriptorProto.getDefaultInstance();
            }

            public MethodDescriptorProto build() {
                MethodDescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private MethodDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                MethodDescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public MethodDescriptorProto buildPartial() {
                MethodDescriptorProto result = new MethodDescriptorProto();
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & MethodDescriptorProto.NAME_FIELD_NUMBER) == MethodDescriptorProto.NAME_FIELD_NUMBER) {
                    to_bitField0_ = 0 | MethodDescriptorProto.NAME_FIELD_NUMBER;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & MethodDescriptorProto.INPUT_TYPE_FIELD_NUMBER) == MethodDescriptorProto.INPUT_TYPE_FIELD_NUMBER) {
                    to_bitField0_ |= MethodDescriptorProto.INPUT_TYPE_FIELD_NUMBER;
                }
                result.inputType_ = this.inputType_;
                if ((from_bitField0_ & MethodDescriptorProto.OPTIONS_FIELD_NUMBER) == MethodDescriptorProto.OPTIONS_FIELD_NUMBER) {
                    to_bitField0_ |= MethodDescriptorProto.OPTIONS_FIELD_NUMBER;
                }
                result.outputType_ = this.outputType_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (MethodOptions) this.optionsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MethodDescriptorProto) {
                    return mergeFrom((MethodDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MethodDescriptorProto other) {
                if (other != MethodDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasInputType()) {
                        setInputType(other.getInputType());
                    }
                    if (other.hasOutputType()) {
                        setOutputType(other.getOutputType());
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                if (!hasOptions() || getOptions().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                            this.bitField0_ |= MethodDescriptorProto.NAME_FIELD_NUMBER;
                            this.name_ = input.readBytes();
                            continue;
                        case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                            this.bitField0_ |= MethodDescriptorProto.INPUT_TYPE_FIELD_NUMBER;
                            this.inputType_ = input.readBytes();
                            continue;
                        case 26:
                            this.bitField0_ |= MethodDescriptorProto.OPTIONS_FIELD_NUMBER;
                            this.outputType_ = input.readBytes();
                            continue;
                        case 34:
                            Builder subBuilder = MethodOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder, extensionRegistry);
                            setOptions(subBuilder.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasName() {
                return (this.bitField0_ & MethodDescriptorProto.NAME_FIELD_NUMBER) == MethodDescriptorProto.NAME_FIELD_NUMBER;
            }

            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= MethodDescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = MethodDescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= MethodDescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
            }

            public boolean hasInputType() {
                return (this.bitField0_ & MethodDescriptorProto.INPUT_TYPE_FIELD_NUMBER) == MethodDescriptorProto.INPUT_TYPE_FIELD_NUMBER;
            }

            public String getInputType() {
                Object ref = this.inputType_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.inputType_ = s;
                return s;
            }

            public Builder setInputType(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= MethodDescriptorProto.INPUT_TYPE_FIELD_NUMBER;
                this.inputType_ = value;
                onChanged();
                return this;
            }

            public Builder clearInputType() {
                this.bitField0_ &= -3;
                this.inputType_ = MethodDescriptorProto.getDefaultInstance().getInputType();
                onChanged();
                return this;
            }

            void setInputType(ByteString value) {
                this.bitField0_ |= MethodDescriptorProto.INPUT_TYPE_FIELD_NUMBER;
                this.inputType_ = value;
                onChanged();
            }

            public boolean hasOutputType() {
                return (this.bitField0_ & MethodDescriptorProto.OPTIONS_FIELD_NUMBER) == MethodDescriptorProto.OPTIONS_FIELD_NUMBER;
            }

            public String getOutputType() {
                Object ref = this.outputType_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.outputType_ = s;
                return s;
            }

            public Builder setOutputType(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= MethodDescriptorProto.OPTIONS_FIELD_NUMBER;
                this.outputType_ = value;
                onChanged();
                return this;
            }

            public Builder clearOutputType() {
                this.bitField0_ &= -5;
                this.outputType_ = MethodDescriptorProto.getDefaultInstance().getOutputType();
                onChanged();
                return this;
            }

            void setOutputType(ByteString value) {
                this.bitField0_ |= MethodDescriptorProto.OPTIONS_FIELD_NUMBER;
                this.outputType_ = value;
                onChanged();
            }

            public boolean hasOptions() {
                return (this.bitField0_ & 8) == 8;
            }

            public MethodOptions getOptions() {
                if (this.optionsBuilder_ == null) {
                    return this.options_;
                }
                return (MethodOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(MethodOptions value) {
                if (this.optionsBuilder_ != null) {
                    this.optionsBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.options_ = value;
                    onChanged();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeOptions(MethodOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 8 || this.options_ == MethodOptions.getDefaultInstance()) {
                        this.options_ = value;
                    } else {
                        this.options_ = MethodOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = MethodOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -9;
                return this;
            }

            public Builder getOptionsBuilder() {
                this.bitField0_ |= 8;
                onChanged();
                return (Builder) getOptionsFieldBuilder().getBuilder();
            }

            public MethodOptionsOrBuilder getOptionsOrBuilder() {
                if (this.optionsBuilder_ != null) {
                    return (MethodOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder();
                }
                return this.options_;
            }

            private SingleFieldBuilder<MethodOptions, Builder, MethodOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }
        }

        private MethodDescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MethodDescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MethodDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public MethodDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f455xc5331ef1;
        }

        public boolean hasName() {
            return (this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER;
        }

        public String getName() {
            ByteString ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        public boolean hasInputType() {
            return (this.bitField0_ & INPUT_TYPE_FIELD_NUMBER) == INPUT_TYPE_FIELD_NUMBER;
        }

        public String getInputType() {
            ByteString ref = this.inputType_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.inputType_ = s;
            }
            return s;
        }

        private ByteString getInputTypeBytes() {
            Object ref = this.inputType_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.inputType_ = b;
            return b;
        }

        public boolean hasOutputType() {
            return (this.bitField0_ & OPTIONS_FIELD_NUMBER) == OPTIONS_FIELD_NUMBER;
        }

        public String getOutputType() {
            ByteString ref = this.outputType_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.outputType_ = s;
            }
            return s;
        }

        private ByteString getOutputTypeBytes() {
            Object ref = this.outputType_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.outputType_ = b;
            return b;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 8) == 8;
        }

        public MethodOptions getOptions() {
            return this.options_;
        }

        public MethodOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        private void initFields() {
            this.name_ = StringUtil.EMPTY_STRING;
            this.inputType_ = StringUtil.EMPTY_STRING;
            this.outputType_ = StringUtil.EMPTY_STRING;
            this.options_ = MethodOptions.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                if (isInitialized == (byte) 1) {
                    return true;
                }
                return false;
            } else if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                output.writeBytes(NAME_FIELD_NUMBER, getNameBytes());
            }
            if ((this.bitField0_ & INPUT_TYPE_FIELD_NUMBER) == INPUT_TYPE_FIELD_NUMBER) {
                output.writeBytes(INPUT_TYPE_FIELD_NUMBER, getInputTypeBytes());
            }
            if ((this.bitField0_ & OPTIONS_FIELD_NUMBER) == OPTIONS_FIELD_NUMBER) {
                output.writeBytes(OUTPUT_TYPE_FIELD_NUMBER, getOutputTypeBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeMessage(OPTIONS_FIELD_NUMBER, this.options_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeBytesSize(NAME_FIELD_NUMBER, getNameBytes());
            }
            if ((this.bitField0_ & INPUT_TYPE_FIELD_NUMBER) == INPUT_TYPE_FIELD_NUMBER) {
                size += CodedOutputStream.computeBytesSize(INPUT_TYPE_FIELD_NUMBER, getInputTypeBytes());
            }
            if ((this.bitField0_ & OPTIONS_FIELD_NUMBER) == OPTIONS_FIELD_NUMBER) {
                size += CodedOutputStream.computeBytesSize(OUTPUT_TYPE_FIELD_NUMBER, getOutputTypeBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeMessageSize(OPTIONS_FIELD_NUMBER, this.options_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MethodDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MethodDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new MethodDescriptorProto(true);
            defaultInstance.initFields();
        }
    }

    public interface MethodOptionsOrBuilder extends ExtendableMessageOrBuilder<MethodOptions> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    }

    public static final class MethodOptions extends ExtendableMessage<MethodOptions> implements MethodOptionsOrBuilder {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final MethodOptions defaultInstance;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<MethodOptions, Builder> implements MethodOptionsOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
            }

            private Builder() {
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return MethodOptions.getDescriptor();
            }

            public MethodOptions getDefaultInstanceForType() {
                return MethodOptions.getDefaultInstance();
            }

            public MethodOptions build() {
                MethodOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private MethodOptions buildParsed() throws InvalidProtocolBufferException {
                MethodOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public MethodOptions buildPartial() {
                MethodOptions result = new MethodOptions();
                int from_bitField0_ = this.bitField0_;
                if (this.uninterpretedOptionBuilder_ == null) {
                    if ((this.bitField0_ & 1) == 1) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -2;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                } else {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MethodOptions) {
                    return mergeFrom((MethodOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MethodOptions other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != MethodOptions.getDefaultInstance()) {
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -2;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getUninterpretedOptionFieldBuilder();
                            }
                            this.uninterpretedOptionBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 1;
                }
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return Collections.unmodifiableList(this.uninterpretedOption_);
                }
                return this.uninterpretedOptionBuilder_.getMessageList();
            }

            public int getUninterpretedOptionCount() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return this.uninterpretedOption_.size();
                }
                return this.uninterpretedOptionBuilder_.getCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOption) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public Builder getUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                if (this.uninterpretedOptionBuilder_ != null) {
                    return this.uninterpretedOptionBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public Builder addUninterpretedOptionBuilder() {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public Builder addUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                boolean z = true;
                if (this.uninterpretedOptionBuilder_ == null) {
                    List list = this.uninterpretedOption_;
                    if ((this.bitField0_ & 1) != 1) {
                        z = false;
                    }
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        private MethodOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MethodOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MethodOptions getDefaultInstance() {
            return defaultInstance;
        }

        public MethodOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getUninterpretedOptionCount()) {
                    if (getUninterpretedOption(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            ExtensionWriter extensionWriter = newExtensionWriter();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            extensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MethodOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static MethodOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static MethodOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static MethodOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static MethodOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MethodOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static MethodOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static MethodOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static MethodOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MethodOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MethodOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new MethodOptions(true);
            defaultInstance.initFields();
        }
    }

    public interface ServiceDescriptorProtoOrBuilder extends MessageOrBuilder {
        MethodDescriptorProto getMethod(int i);

        int getMethodCount();

        List<MethodDescriptorProto> getMethodList();

        MethodDescriptorProtoOrBuilder getMethodOrBuilder(int i);

        List<? extends MethodDescriptorProtoOrBuilder> getMethodOrBuilderList();

        String getName();

        ServiceOptions getOptions();

        ServiceOptionsOrBuilder getOptionsOrBuilder();

        boolean hasName();

        boolean hasOptions();
    }

    public static final class ServiceDescriptorProto extends GeneratedMessage implements ServiceDescriptorProtoOrBuilder {
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static final ServiceDescriptorProto defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<MethodDescriptorProto> method_;
        private Object name_;
        private ServiceOptions options_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements ServiceDescriptorProtoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<MethodDescriptorProto, Builder, MethodDescriptorProtoOrBuilder> methodBuilder_;
            private List<MethodDescriptorProto> method_;
            private Object name_;
            private SingleFieldBuilder<ServiceOptions, Builder, ServiceOptionsOrBuilder> optionsBuilder_;
            private ServiceOptions options_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.f456x158c73ed;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f457xee335d6b;
            }

            private Builder() {
                this.name_ = StringUtil.EMPTY_STRING;
                this.method_ = Collections.emptyList();
                this.options_ = ServiceOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.name_ = StringUtil.EMPTY_STRING;
                this.method_ = Collections.emptyList();
                this.options_ = ServiceOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getMethodFieldBuilder();
                    getOptionsFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.name_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -2;
                if (this.methodBuilder_ == null) {
                    this.method_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.methodBuilder_.clear();
                }
                if (this.optionsBuilder_ == null) {
                    this.options_ = ServiceOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return ServiceDescriptorProto.getDescriptor();
            }

            public ServiceDescriptorProto getDefaultInstanceForType() {
                return ServiceDescriptorProto.getDefaultInstance();
            }

            public ServiceDescriptorProto build() {
                ServiceDescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private ServiceDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                ServiceDescriptorProto result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public ServiceDescriptorProto buildPartial() {
                ServiceDescriptorProto result = new ServiceDescriptorProto();
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & ServiceDescriptorProto.NAME_FIELD_NUMBER) == ServiceDescriptorProto.NAME_FIELD_NUMBER) {
                    to_bitField0_ = 0 | ServiceDescriptorProto.NAME_FIELD_NUMBER;
                }
                result.name_ = this.name_;
                if (this.methodBuilder_ == null) {
                    if ((this.bitField0_ & ServiceDescriptorProto.METHOD_FIELD_NUMBER) == ServiceDescriptorProto.METHOD_FIELD_NUMBER) {
                        this.method_ = Collections.unmodifiableList(this.method_);
                        this.bitField0_ &= -3;
                    }
                    result.method_ = this.method_;
                } else {
                    result.method_ = this.methodBuilder_.build();
                }
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= ServiceDescriptorProto.METHOD_FIELD_NUMBER;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (ServiceOptions) this.optionsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ServiceDescriptorProto) {
                    return mergeFrom((ServiceDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ServiceDescriptorProto other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != ServiceDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (this.methodBuilder_ == null) {
                        if (!other.method_.isEmpty()) {
                            if (this.method_.isEmpty()) {
                                this.method_ = other.method_;
                                this.bitField0_ &= -3;
                            } else {
                                ensureMethodIsMutable();
                                this.method_.addAll(other.method_);
                            }
                            onChanged();
                        }
                    } else if (!other.method_.isEmpty()) {
                        if (this.methodBuilder_.isEmpty()) {
                            this.methodBuilder_.dispose();
                            this.methodBuilder_ = null;
                            this.method_ = other.method_;
                            this.bitField0_ &= -3;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getMethodFieldBuilder();
                            }
                            this.methodBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.methodBuilder_.addAllMessages(other.method_);
                        }
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getMethodCount(); i += ServiceDescriptorProto.NAME_FIELD_NUMBER) {
                    if (!getMethod(i).isInitialized()) {
                        return false;
                    }
                }
                if (!hasOptions() || getOptions().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                            this.bitField0_ |= ServiceDescriptorProto.NAME_FIELD_NUMBER;
                            this.name_ = input.readBytes();
                            continue;
                        case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                            Builder subBuilder = MethodDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addMethod(subBuilder.buildPartial());
                            continue;
                        case 26:
                            Builder subBuilder2 = ServiceOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder2.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder2, extensionRegistry);
                            setOptions(subBuilder2.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasName() {
                return (this.bitField0_ & ServiceDescriptorProto.NAME_FIELD_NUMBER) == ServiceDescriptorProto.NAME_FIELD_NUMBER;
            }

            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= ServiceDescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = ServiceDescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= ServiceDescriptorProto.NAME_FIELD_NUMBER;
                this.name_ = value;
                onChanged();
            }

            private void ensureMethodIsMutable() {
                if ((this.bitField0_ & ServiceDescriptorProto.METHOD_FIELD_NUMBER) != ServiceDescriptorProto.METHOD_FIELD_NUMBER) {
                    this.method_ = new ArrayList(this.method_);
                    this.bitField0_ |= ServiceDescriptorProto.METHOD_FIELD_NUMBER;
                }
            }

            public List<MethodDescriptorProto> getMethodList() {
                if (this.methodBuilder_ == null) {
                    return Collections.unmodifiableList(this.method_);
                }
                return this.methodBuilder_.getMessageList();
            }

            public int getMethodCount() {
                if (this.methodBuilder_ == null) {
                    return this.method_.size();
                }
                return this.methodBuilder_.getCount();
            }

            public MethodDescriptorProto getMethod(int index) {
                if (this.methodBuilder_ == null) {
                    return (MethodDescriptorProto) this.method_.get(index);
                }
                return (MethodDescriptorProto) this.methodBuilder_.getMessage(index);
            }

            public Builder setMethod(int index, MethodDescriptorProto value) {
                if (this.methodBuilder_ != null) {
                    this.methodBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMethodIsMutable();
                    this.method_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMethod(int index, Builder builderForValue) {
                if (this.methodBuilder_ == null) {
                    ensureMethodIsMutable();
                    this.method_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.methodBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMethod(MethodDescriptorProto value) {
                if (this.methodBuilder_ != null) {
                    this.methodBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMethodIsMutable();
                    this.method_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMethod(int index, MethodDescriptorProto value) {
                if (this.methodBuilder_ != null) {
                    this.methodBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMethodIsMutable();
                    this.method_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMethod(Builder builderForValue) {
                if (this.methodBuilder_ == null) {
                    ensureMethodIsMutable();
                    this.method_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.methodBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMethod(int index, Builder builderForValue) {
                if (this.methodBuilder_ == null) {
                    ensureMethodIsMutable();
                    this.method_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.methodBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMethod(Iterable<? extends MethodDescriptorProto> values) {
                if (this.methodBuilder_ == null) {
                    ensureMethodIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.method_);
                    onChanged();
                } else {
                    this.methodBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMethod() {
                if (this.methodBuilder_ == null) {
                    this.method_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.methodBuilder_.clear();
                }
                return this;
            }

            public Builder removeMethod(int index) {
                if (this.methodBuilder_ == null) {
                    ensureMethodIsMutable();
                    this.method_.remove(index);
                    onChanged();
                } else {
                    this.methodBuilder_.remove(index);
                }
                return this;
            }

            public Builder getMethodBuilder(int index) {
                return (Builder) getMethodFieldBuilder().getBuilder(index);
            }

            public MethodDescriptorProtoOrBuilder getMethodOrBuilder(int index) {
                if (this.methodBuilder_ == null) {
                    return (MethodDescriptorProtoOrBuilder) this.method_.get(index);
                }
                return (MethodDescriptorProtoOrBuilder) this.methodBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends MethodDescriptorProtoOrBuilder> getMethodOrBuilderList() {
                if (this.methodBuilder_ != null) {
                    return this.methodBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.method_);
            }

            public Builder addMethodBuilder() {
                return (Builder) getMethodFieldBuilder().addBuilder(MethodDescriptorProto.getDefaultInstance());
            }

            public Builder addMethodBuilder(int index) {
                return (Builder) getMethodFieldBuilder().addBuilder(index, MethodDescriptorProto.getDefaultInstance());
            }

            public List<Builder> getMethodBuilderList() {
                return getMethodFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<MethodDescriptorProto, Builder, MethodDescriptorProtoOrBuilder> getMethodFieldBuilder() {
                if (this.methodBuilder_ == null) {
                    this.methodBuilder_ = new RepeatedFieldBuilder(this.method_, (this.bitField0_ & ServiceDescriptorProto.METHOD_FIELD_NUMBER) == ServiceDescriptorProto.METHOD_FIELD_NUMBER, getParentForChildren(), isClean());
                    this.method_ = null;
                }
                return this.methodBuilder_;
            }

            public boolean hasOptions() {
                return (this.bitField0_ & 4) == 4;
            }

            public ServiceOptions getOptions() {
                if (this.optionsBuilder_ == null) {
                    return this.options_;
                }
                return (ServiceOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(ServiceOptions value) {
                if (this.optionsBuilder_ != null) {
                    this.optionsBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.options_ = value;
                    onChanged();
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeOptions(ServiceOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 4 || this.options_ == ServiceOptions.getDefaultInstance()) {
                        this.options_ = value;
                    } else {
                        this.options_ = ServiceOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = ServiceOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            public Builder getOptionsBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return (Builder) getOptionsFieldBuilder().getBuilder();
            }

            public ServiceOptionsOrBuilder getOptionsOrBuilder() {
                if (this.optionsBuilder_ != null) {
                    return (ServiceOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder();
                }
                return this.options_;
            }

            private SingleFieldBuilder<ServiceOptions, Builder, ServiceOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }
        }

        private ServiceDescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private ServiceDescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static ServiceDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public ServiceDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.f456x158c73ed;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f457xee335d6b;
        }

        public boolean hasName() {
            return (this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER;
        }

        public String getName() {
            ByteString ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        public List<MethodDescriptorProto> getMethodList() {
            return this.method_;
        }

        public List<? extends MethodDescriptorProtoOrBuilder> getMethodOrBuilderList() {
            return this.method_;
        }

        public int getMethodCount() {
            return this.method_.size();
        }

        public MethodDescriptorProto getMethod(int index) {
            return (MethodDescriptorProto) this.method_.get(index);
        }

        public MethodDescriptorProtoOrBuilder getMethodOrBuilder(int index) {
            return (MethodDescriptorProtoOrBuilder) this.method_.get(index);
        }

        public boolean hasOptions() {
            return (this.bitField0_ & METHOD_FIELD_NUMBER) == METHOD_FIELD_NUMBER;
        }

        public ServiceOptions getOptions() {
            return this.options_;
        }

        public ServiceOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        private void initFields() {
            this.name_ = StringUtil.EMPTY_STRING;
            this.method_ = Collections.emptyList();
            this.options_ = ServiceOptions.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getMethodCount()) {
                    if (getMethod(i).isInitialized()) {
                        i += NAME_FIELD_NUMBER;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!hasOptions() || getOptions().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                output.writeBytes(NAME_FIELD_NUMBER, getNameBytes());
            }
            for (int i = 0; i < this.method_.size(); i += NAME_FIELD_NUMBER) {
                output.writeMessage(METHOD_FIELD_NUMBER, (MessageLite) this.method_.get(i));
            }
            if ((this.bitField0_ & METHOD_FIELD_NUMBER) == METHOD_FIELD_NUMBER) {
                output.writeMessage(OPTIONS_FIELD_NUMBER, this.options_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeBytesSize(NAME_FIELD_NUMBER, getNameBytes());
            }
            for (int i = 0; i < this.method_.size(); i += NAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(METHOD_FIELD_NUMBER, (MessageLite) this.method_.get(i));
            }
            if ((this.bitField0_ & METHOD_FIELD_NUMBER) == METHOD_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(OPTIONS_FIELD_NUMBER, this.options_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ServiceDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ServiceDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new ServiceDescriptorProto(true);
            defaultInstance.initFields();
        }
    }

    public interface ServiceOptionsOrBuilder extends ExtendableMessageOrBuilder<ServiceOptions> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    }

    public static final class ServiceOptions extends ExtendableMessage<ServiceOptions> implements ServiceOptionsOrBuilder {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final ServiceOptions defaultInstance;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f458x371e666;
            }

            private Builder() {
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return ServiceOptions.getDescriptor();
            }

            public ServiceOptions getDefaultInstanceForType() {
                return ServiceOptions.getDefaultInstance();
            }

            public ServiceOptions build() {
                ServiceOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private ServiceOptions buildParsed() throws InvalidProtocolBufferException {
                ServiceOptions result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public ServiceOptions buildPartial() {
                ServiceOptions result = new ServiceOptions();
                int from_bitField0_ = this.bitField0_;
                if (this.uninterpretedOptionBuilder_ == null) {
                    if ((this.bitField0_ & 1) == 1) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -2;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                } else {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ServiceOptions) {
                    return mergeFrom((ServiceOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ServiceOptions other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != ServiceOptions.getDefaultInstance()) {
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -2;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getUninterpretedOptionFieldBuilder();
                            }
                            this.uninterpretedOptionBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 1;
                }
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return Collections.unmodifiableList(this.uninterpretedOption_);
                }
                return this.uninterpretedOptionBuilder_.getMessageList();
            }

            public int getUninterpretedOptionCount() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return this.uninterpretedOption_.size();
                }
                return this.uninterpretedOptionBuilder_.getCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOption) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ != null) {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public Builder getUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
                }
                return (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                if (this.uninterpretedOptionBuilder_ != null) {
                    return this.uninterpretedOptionBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public Builder addUninterpretedOptionBuilder() {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public Builder addUninterpretedOptionBuilder(int index) {
                return (Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                boolean z = true;
                if (this.uninterpretedOptionBuilder_ == null) {
                    List list = this.uninterpretedOption_;
                    if ((this.bitField0_ & 1) != 1) {
                        z = false;
                    }
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        private ServiceOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private ServiceOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static ServiceOptions getDefaultInstance() {
            return defaultInstance;
        }

        public ServiceOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f458x371e666;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getUninterpretedOptionCount()) {
                    if (getUninterpretedOption(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            ExtensionWriter extensionWriter = newExtensionWriter();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            extensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(UNINTERPRETED_OPTION_FIELD_NUMBER, (MessageLite) this.uninterpretedOption_.get(i));
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ServiceOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static ServiceOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static ServiceOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static ServiceOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static ServiceOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static ServiceOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static ServiceOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static ServiceOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static ServiceOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static ServiceOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ServiceOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new ServiceOptions(true);
            defaultInstance.initFields();
        }
    }

    public interface SourceCodeInfoOrBuilder extends MessageOrBuilder {
        Location getLocation(int i);

        int getLocationCount();

        List<Location> getLocationList();

        LocationOrBuilder getLocationOrBuilder(int i);

        List<? extends LocationOrBuilder> getLocationOrBuilderList();
    }

    public static final class SourceCodeInfo extends GeneratedMessage implements SourceCodeInfoOrBuilder {
        public static final int LOCATION_FIELD_NUMBER = 1;
        private static final SourceCodeInfo defaultInstance;
        private static final long serialVersionUID = 0;
        private List<Location> location_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements SourceCodeInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<Location, Builder, LocationOrBuilder> locationBuilder_;
            private List<Location> location_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f461x532209f9;
            }

            private Builder() {
                this.location_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.location_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getLocationFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.locationBuilder_ == null) {
                    this.location_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.locationBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return SourceCodeInfo.getDescriptor();
            }

            public SourceCodeInfo getDefaultInstanceForType() {
                return SourceCodeInfo.getDefaultInstance();
            }

            public SourceCodeInfo build() {
                SourceCodeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private SourceCodeInfo buildParsed() throws InvalidProtocolBufferException {
                SourceCodeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public SourceCodeInfo buildPartial() {
                SourceCodeInfo result = new SourceCodeInfo();
                int from_bitField0_ = this.bitField0_;
                if (this.locationBuilder_ == null) {
                    if ((this.bitField0_ & SourceCodeInfo.LOCATION_FIELD_NUMBER) == SourceCodeInfo.LOCATION_FIELD_NUMBER) {
                        this.location_ = Collections.unmodifiableList(this.location_);
                        this.bitField0_ &= -2;
                    }
                    result.location_ = this.location_;
                } else {
                    result.location_ = this.locationBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SourceCodeInfo) {
                    return mergeFrom((SourceCodeInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SourceCodeInfo other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != SourceCodeInfo.getDefaultInstance()) {
                    if (this.locationBuilder_ == null) {
                        if (!other.location_.isEmpty()) {
                            if (this.location_.isEmpty()) {
                                this.location_ = other.location_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureLocationIsMutable();
                                this.location_.addAll(other.location_);
                            }
                            onChanged();
                        }
                    } else if (!other.location_.isEmpty()) {
                        if (this.locationBuilder_.isEmpty()) {
                            this.locationBuilder_.dispose();
                            this.locationBuilder_ = null;
                            this.location_ = other.location_;
                            this.bitField0_ &= -2;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getLocationFieldBuilder();
                            }
                            this.locationBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.locationBuilder_.addAllMessages(other.location_);
                        }
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                            Builder subBuilder = Location.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addLocation(subBuilder.buildPartial());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            private void ensureLocationIsMutable() {
                if ((this.bitField0_ & SourceCodeInfo.LOCATION_FIELD_NUMBER) != SourceCodeInfo.LOCATION_FIELD_NUMBER) {
                    this.location_ = new ArrayList(this.location_);
                    this.bitField0_ |= SourceCodeInfo.LOCATION_FIELD_NUMBER;
                }
            }

            public List<Location> getLocationList() {
                if (this.locationBuilder_ == null) {
                    return Collections.unmodifiableList(this.location_);
                }
                return this.locationBuilder_.getMessageList();
            }

            public int getLocationCount() {
                if (this.locationBuilder_ == null) {
                    return this.location_.size();
                }
                return this.locationBuilder_.getCount();
            }

            public Location getLocation(int index) {
                if (this.locationBuilder_ == null) {
                    return (Location) this.location_.get(index);
                }
                return (Location) this.locationBuilder_.getMessage(index);
            }

            public Builder setLocation(int index, Location value) {
                if (this.locationBuilder_ != null) {
                    this.locationBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLocationIsMutable();
                    this.location_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setLocation(int index, Builder builderForValue) {
                if (this.locationBuilder_ == null) {
                    ensureLocationIsMutable();
                    this.location_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.locationBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLocation(Location value) {
                if (this.locationBuilder_ != null) {
                    this.locationBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLocationIsMutable();
                    this.location_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addLocation(int index, Location value) {
                if (this.locationBuilder_ != null) {
                    this.locationBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLocationIsMutable();
                    this.location_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addLocation(Builder builderForValue) {
                if (this.locationBuilder_ == null) {
                    ensureLocationIsMutable();
                    this.location_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.locationBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLocation(int index, Builder builderForValue) {
                if (this.locationBuilder_ == null) {
                    ensureLocationIsMutable();
                    this.location_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.locationBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLocation(Iterable<? extends Location> values) {
                if (this.locationBuilder_ == null) {
                    ensureLocationIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.location_);
                    onChanged();
                } else {
                    this.locationBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLocation() {
                if (this.locationBuilder_ == null) {
                    this.location_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.locationBuilder_.clear();
                }
                return this;
            }

            public Builder removeLocation(int index) {
                if (this.locationBuilder_ == null) {
                    ensureLocationIsMutable();
                    this.location_.remove(index);
                    onChanged();
                } else {
                    this.locationBuilder_.remove(index);
                }
                return this;
            }

            public Builder getLocationBuilder(int index) {
                return (Builder) getLocationFieldBuilder().getBuilder(index);
            }

            public LocationOrBuilder getLocationOrBuilder(int index) {
                if (this.locationBuilder_ == null) {
                    return (LocationOrBuilder) this.location_.get(index);
                }
                return (LocationOrBuilder) this.locationBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends LocationOrBuilder> getLocationOrBuilderList() {
                if (this.locationBuilder_ != null) {
                    return this.locationBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.location_);
            }

            public Builder addLocationBuilder() {
                return (Builder) getLocationFieldBuilder().addBuilder(Location.getDefaultInstance());
            }

            public Builder addLocationBuilder(int index) {
                return (Builder) getLocationFieldBuilder().addBuilder(index, Location.getDefaultInstance());
            }

            public List<Builder> getLocationBuilderList() {
                return getLocationFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Location, Builder, LocationOrBuilder> getLocationFieldBuilder() {
                boolean z = true;
                if (this.locationBuilder_ == null) {
                    List list = this.location_;
                    if ((this.bitField0_ & SourceCodeInfo.LOCATION_FIELD_NUMBER) != SourceCodeInfo.LOCATION_FIELD_NUMBER) {
                        z = false;
                    }
                    this.locationBuilder_ = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
                    this.location_ = null;
                }
                return this.locationBuilder_;
            }
        }

        public interface LocationOrBuilder extends MessageOrBuilder {
            int getPath(int i);

            int getPathCount();

            List<Integer> getPathList();

            int getSpan(int i);

            int getSpanCount();

            List<Integer> getSpanList();
        }

        public static final class Location extends GeneratedMessage implements LocationOrBuilder {
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SPAN_FIELD_NUMBER = 2;
            private static final Location defaultInstance;
            private static final long serialVersionUID = 0;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int pathMemoizedSerializedSize;
            private List<Integer> path_;
            private int spanMemoizedSerializedSize;
            private List<Integer> span_;

            public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements LocationOrBuilder {
                private int bitField0_;
                private List<Integer> path_;
                private List<Integer> span_;

                public static final Descriptor getDescriptor() {
                    return DescriptorProtos.f459xb210d08d;
                }

                protected FieldAccessorTable internalGetFieldAccessorTable() {
                    return DescriptorProtos.f460x9611a0b;
                }

                private Builder() {
                    this.path_ = Collections.emptyList();
                    this.span_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private Builder(BuilderParent parent) {
                    super(parent);
                    this.path_ = Collections.emptyList();
                    this.span_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (!GeneratedMessage.alwaysUseFieldBuilders) {
                    }
                }

                private static Builder create() {
                    return new Builder();
                }

                public Builder clear() {
                    super.clear();
                    this.path_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    this.span_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    return this;
                }

                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Descriptor getDescriptorForType() {
                    return Location.getDescriptor();
                }

                public Location getDefaultInstanceForType() {
                    return Location.getDefaultInstance();
                }

                public Location build() {
                    Location result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
                }

                private Location buildParsed() throws InvalidProtocolBufferException {
                    Location result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
                }

                public Location buildPartial() {
                    Location result = new Location();
                    int from_bitField0_ = this.bitField0_;
                    if ((this.bitField0_ & Location.PATH_FIELD_NUMBER) == Location.PATH_FIELD_NUMBER) {
                        this.path_ = Collections.unmodifiableList(this.path_);
                        this.bitField0_ &= -2;
                    }
                    result.path_ = this.path_;
                    if ((this.bitField0_ & Location.SPAN_FIELD_NUMBER) == Location.SPAN_FIELD_NUMBER) {
                        this.span_ = Collections.unmodifiableList(this.span_);
                        this.bitField0_ &= -3;
                    }
                    result.span_ = this.span_;
                    onBuilt();
                    return result;
                }

                public Builder mergeFrom(Message other) {
                    if (other instanceof Location) {
                        return mergeFrom((Location) other);
                    }
                    super.mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(Location other) {
                    if (other != Location.getDefaultInstance()) {
                        if (!other.path_.isEmpty()) {
                            if (this.path_.isEmpty()) {
                                this.path_ = other.path_;
                                this.bitField0_ &= -2;
                            } else {
                                ensurePathIsMutable();
                                this.path_.addAll(other.path_);
                            }
                            onChanged();
                        }
                        if (!other.span_.isEmpty()) {
                            if (this.span_.isEmpty()) {
                                this.span_ = other.span_;
                                this.bitField0_ &= -3;
                            } else {
                                ensureSpanIsMutable();
                                this.span_.addAll(other.span_);
                            }
                            onChanged();
                        }
                        mergeUnknownFields(other.getUnknownFields());
                    }
                    return this;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                    while (true) {
                        int tag = input.readTag();
                        int limit;
                        switch (tag) {
                            case CharacterEscapes.ESCAPE_NONE /*0*/:
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            case PayPalActivity.VIEW_TEST /*8*/:
                                ensurePathIsMutable();
                                this.path_.add(Integer.valueOf(input.readInt32()));
                                continue;
                            case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                                limit = input.pushLimit(input.readRawVarint32());
                                while (input.getBytesUntilLimit() > 0) {
                                    addPath(input.readInt32());
                                }
                                input.popLimit(limit);
                                continue;
                            case Segment.TOKENS_PER_SEGMENT /*16*/:
                                ensureSpanIsMutable();
                                this.span_.add(Integer.valueOf(input.readInt32()));
                                continue;
                            case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                                limit = input.pushLimit(input.readRawVarint32());
                                while (input.getBytesUntilLimit() > 0) {
                                    addSpan(input.readInt32());
                                }
                                input.popLimit(limit);
                                continue;
                            default:
                                if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    setUnknownFields(unknownFields.build());
                                    onChanged();
                                    break;
                                }
                                continue;
                        }
                        return this;
                    }
                }

                private void ensurePathIsMutable() {
                    if ((this.bitField0_ & Location.PATH_FIELD_NUMBER) != Location.PATH_FIELD_NUMBER) {
                        this.path_ = new ArrayList(this.path_);
                        this.bitField0_ |= Location.PATH_FIELD_NUMBER;
                    }
                }

                public List<Integer> getPathList() {
                    return Collections.unmodifiableList(this.path_);
                }

                public int getPathCount() {
                    return this.path_.size();
                }

                public int getPath(int index) {
                    return ((Integer) this.path_.get(index)).intValue();
                }

                public Builder setPath(int index, int value) {
                    ensurePathIsMutable();
                    this.path_.set(index, Integer.valueOf(value));
                    onChanged();
                    return this;
                }

                public Builder addPath(int value) {
                    ensurePathIsMutable();
                    this.path_.add(Integer.valueOf(value));
                    onChanged();
                    return this;
                }

                public Builder addAllPath(Iterable<? extends Integer> values) {
                    ensurePathIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.path_);
                    onChanged();
                    return this;
                }

                public Builder clearPath() {
                    this.path_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                    return this;
                }

                private void ensureSpanIsMutable() {
                    if ((this.bitField0_ & Location.SPAN_FIELD_NUMBER) != Location.SPAN_FIELD_NUMBER) {
                        this.span_ = new ArrayList(this.span_);
                        this.bitField0_ |= Location.SPAN_FIELD_NUMBER;
                    }
                }

                public List<Integer> getSpanList() {
                    return Collections.unmodifiableList(this.span_);
                }

                public int getSpanCount() {
                    return this.span_.size();
                }

                public int getSpan(int index) {
                    return ((Integer) this.span_.get(index)).intValue();
                }

                public Builder setSpan(int index, int value) {
                    ensureSpanIsMutable();
                    this.span_.set(index, Integer.valueOf(value));
                    onChanged();
                    return this;
                }

                public Builder addSpan(int value) {
                    ensureSpanIsMutable();
                    this.span_.add(Integer.valueOf(value));
                    onChanged();
                    return this;
                }

                public Builder addAllSpan(Iterable<? extends Integer> values) {
                    ensureSpanIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.span_);
                    onChanged();
                    return this;
                }

                public Builder clearSpan() {
                    this.span_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                    return this;
                }
            }

            private Location(Builder builder) {
                super(builder);
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            private Location(boolean noInit) {
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            public static Location getDefaultInstance() {
                return defaultInstance;
            }

            public Location getDefaultInstanceForType() {
                return defaultInstance;
            }

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.f459xb210d08d;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f460x9611a0b;
            }

            public List<Integer> getPathList() {
                return this.path_;
            }

            public int getPathCount() {
                return this.path_.size();
            }

            public int getPath(int index) {
                return ((Integer) this.path_.get(index)).intValue();
            }

            public List<Integer> getSpanList() {
                return this.span_;
            }

            public int getSpanCount() {
                return this.span_.size();
            }

            public int getSpan(int index) {
                return ((Integer) this.span_.get(index)).intValue();
            }

            private void initFields() {
                this.path_ = Collections.emptyList();
                this.span_ = Collections.emptyList();
            }

            public final boolean isInitialized() {
                byte isInitialized = this.memoizedIsInitialized;
                if (isInitialized == -1) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                } else if (isInitialized == (byte) 1) {
                    return true;
                } else {
                    return false;
                }
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                int i;
                getSerializedSize();
                if (getPathList().size() > 0) {
                    output.writeRawVarint32(10);
                    output.writeRawVarint32(this.pathMemoizedSerializedSize);
                }
                for (i = 0; i < this.path_.size(); i += PATH_FIELD_NUMBER) {
                    output.writeInt32NoTag(((Integer) this.path_.get(i)).intValue());
                }
                if (getSpanList().size() > 0) {
                    output.writeRawVarint32(18);
                    output.writeRawVarint32(this.spanMemoizedSerializedSize);
                }
                for (i = 0; i < this.span_.size(); i += PATH_FIELD_NUMBER) {
                    output.writeInt32NoTag(((Integer) this.span_.get(i)).intValue());
                }
                getUnknownFields().writeTo(output);
            }

            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                int i;
                int dataSize = 0;
                for (i = 0; i < this.path_.size(); i += PATH_FIELD_NUMBER) {
                    dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.path_.get(i)).intValue());
                }
                size = 0 + dataSize;
                if (!getPathList().isEmpty()) {
                    size = (size + PATH_FIELD_NUMBER) + CodedOutputStream.computeInt32SizeNoTag(dataSize);
                }
                this.pathMemoizedSerializedSize = dataSize;
                dataSize = 0;
                for (i = 0; i < this.span_.size(); i += PATH_FIELD_NUMBER) {
                    dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.span_.get(i)).intValue());
                }
                size += dataSize;
                if (!getSpanList().isEmpty()) {
                    size = (size + PATH_FIELD_NUMBER) + CodedOutputStream.computeInt32SizeNoTag(dataSize);
                }
                this.spanMemoizedSerializedSize = dataSize;
                size += getUnknownFields().getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }

            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static Location parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            public static Location parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            public static Location parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            public static Location parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            public static Location parseFrom(InputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static Location parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
            }

            public static Location parseDelimitedFrom(InputStream input) throws IOException {
                Builder builder = newBuilder();
                if (builder.mergeDelimitedFrom(input)) {
                    return builder.buildParsed();
                }
                return null;
            }

            public static Location parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Builder builder = newBuilder();
                if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                    return builder.buildParsed();
                }
                return null;
            }

            public static Location parseFrom(CodedInputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static Location parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(Location prototype) {
                return newBuilder().mergeFrom(prototype);
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }

            protected Builder newBuilderForType(BuilderParent parent) {
                return new Builder(null);
            }

            static {
                defaultInstance = new Location(true);
                defaultInstance.initFields();
            }
        }

        private SourceCodeInfo(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private SourceCodeInfo(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static SourceCodeInfo getDefaultInstance() {
            return defaultInstance;
        }

        public SourceCodeInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f461x532209f9;
        }

        public List<Location> getLocationList() {
            return this.location_;
        }

        public List<? extends LocationOrBuilder> getLocationOrBuilderList() {
            return this.location_;
        }

        public int getLocationCount() {
            return this.location_.size();
        }

        public Location getLocation(int index) {
            return (Location) this.location_.get(index);
        }

        public LocationOrBuilder getLocationOrBuilder(int index) {
            return (LocationOrBuilder) this.location_.get(index);
        }

        private void initFields() {
            this.location_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.location_.size(); i += LOCATION_FIELD_NUMBER) {
                output.writeMessage(LOCATION_FIELD_NUMBER, (MessageLite) this.location_.get(i));
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.location_.size(); i += LOCATION_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(LOCATION_FIELD_NUMBER, (MessageLite) this.location_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SourceCodeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static SourceCodeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static SourceCodeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static SourceCodeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static SourceCodeInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static SourceCodeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static SourceCodeInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static SourceCodeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SourceCodeInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new SourceCodeInfo(true);
            defaultInstance.initFields();
        }
    }

    public interface UninterpretedOptionOrBuilder extends MessageOrBuilder {
        String getAggregateValue();

        double getDoubleValue();

        String getIdentifierValue();

        NamePart getName(int i);

        int getNameCount();

        List<NamePart> getNameList();

        NamePartOrBuilder getNameOrBuilder(int i);

        List<? extends NamePartOrBuilder> getNameOrBuilderList();

        long getNegativeIntValue();

        long getPositiveIntValue();

        ByteString getStringValue();

        boolean hasAggregateValue();

        boolean hasDoubleValue();

        boolean hasIdentifierValue();

        boolean hasNegativeIntValue();

        boolean hasPositiveIntValue();

        boolean hasStringValue();
    }

    public static final class UninterpretedOption extends GeneratedMessage implements UninterpretedOptionOrBuilder {
        public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
        public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
        public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
        public static final int STRING_VALUE_FIELD_NUMBER = 7;
        private static final UninterpretedOption defaultInstance;
        private static final long serialVersionUID = 0;
        private Object aggregateValue_;
        private int bitField0_;
        private double doubleValue_;
        private Object identifierValue_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<NamePart> name_;
        private long negativeIntValue_;
        private long positiveIntValue_;
        private ByteString stringValue_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements UninterpretedOptionOrBuilder {
            private Object aggregateValue_;
            private int bitField0_;
            private double doubleValue_;
            private Object identifierValue_;
            private RepeatedFieldBuilder<NamePart, Builder, NamePartOrBuilder> nameBuilder_;
            private List<NamePart> name_;
            private long negativeIntValue_;
            private long positiveIntValue_;
            private ByteString stringValue_;

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f464x2101041;
            }

            private Builder() {
                this.name_ = Collections.emptyList();
                this.identifierValue_ = StringUtil.EMPTY_STRING;
                this.stringValue_ = ByteString.EMPTY;
                this.aggregateValue_ = StringUtil.EMPTY_STRING;
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                this.name_ = Collections.emptyList();
                this.identifierValue_ = StringUtil.EMPTY_STRING;
                this.stringValue_ = ByteString.EMPTY;
                this.aggregateValue_ = StringUtil.EMPTY_STRING;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getNameFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.nameBuilder_ == null) {
                    this.name_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.nameBuilder_.clear();
                }
                this.identifierValue_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -3;
                this.positiveIntValue_ = 0;
                this.bitField0_ &= -5;
                this.negativeIntValue_ = 0;
                this.bitField0_ &= -9;
                this.doubleValue_ = 0.0d;
                this.bitField0_ &= -17;
                this.stringValue_ = ByteString.EMPTY;
                this.bitField0_ &= -33;
                this.aggregateValue_ = StringUtil.EMPTY_STRING;
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptor getDescriptorForType() {
                return UninterpretedOption.getDescriptor();
            }

            public UninterpretedOption getDefaultInstanceForType() {
                return UninterpretedOption.getDefaultInstance();
            }

            public UninterpretedOption build() {
                UninterpretedOption result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
            }

            private UninterpretedOption buildParsed() throws InvalidProtocolBufferException {
                UninterpretedOption result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
            }

            public UninterpretedOption buildPartial() {
                UninterpretedOption result = new UninterpretedOption();
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if (this.nameBuilder_ == null) {
                    if ((this.bitField0_ & 1) == 1) {
                        this.name_ = Collections.unmodifiableList(this.name_);
                        this.bitField0_ &= -2;
                    }
                    result.name_ = this.name_;
                } else {
                    result.name_ = this.nameBuilder_.build();
                }
                if ((from_bitField0_ & UninterpretedOption.NAME_FIELD_NUMBER) == UninterpretedOption.NAME_FIELD_NUMBER) {
                    to_bitField0_ = 0 | 1;
                }
                result.identifierValue_ = this.identifierValue_;
                if ((from_bitField0_ & UninterpretedOption.POSITIVE_INT_VALUE_FIELD_NUMBER) == UninterpretedOption.POSITIVE_INT_VALUE_FIELD_NUMBER) {
                    to_bitField0_ |= UninterpretedOption.NAME_FIELD_NUMBER;
                }
                result.positiveIntValue_ = this.positiveIntValue_;
                if ((from_bitField0_ & UninterpretedOption.AGGREGATE_VALUE_FIELD_NUMBER) == UninterpretedOption.AGGREGATE_VALUE_FIELD_NUMBER) {
                    to_bitField0_ |= UninterpretedOption.POSITIVE_INT_VALUE_FIELD_NUMBER;
                }
                result.negativeIntValue_ = this.negativeIntValue_;
                if ((from_bitField0_ & 16) == 16) {
                    to_bitField0_ |= UninterpretedOption.AGGREGATE_VALUE_FIELD_NUMBER;
                }
                result.doubleValue_ = this.doubleValue_;
                if ((from_bitField0_ & 32) == 32) {
                    to_bitField0_ |= 16;
                }
                result.stringValue_ = this.stringValue_;
                if ((from_bitField0_ & 64) == 64) {
                    to_bitField0_ |= 32;
                }
                result.aggregateValue_ = this.aggregateValue_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof UninterpretedOption) {
                    return mergeFrom((UninterpretedOption) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UninterpretedOption other) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (other != UninterpretedOption.getDefaultInstance()) {
                    if (this.nameBuilder_ == null) {
                        if (!other.name_.isEmpty()) {
                            if (this.name_.isEmpty()) {
                                this.name_ = other.name_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureNameIsMutable();
                                this.name_.addAll(other.name_);
                            }
                            onChanged();
                        }
                    } else if (!other.name_.isEmpty()) {
                        if (this.nameBuilder_.isEmpty()) {
                            this.nameBuilder_.dispose();
                            this.nameBuilder_ = null;
                            this.name_ = other.name_;
                            this.bitField0_ &= -2;
                            if (GeneratedMessage.alwaysUseFieldBuilders) {
                                repeatedFieldBuilder = getNameFieldBuilder();
                            }
                            this.nameBuilder_ = repeatedFieldBuilder;
                        } else {
                            this.nameBuilder_.addAllMessages(other.name_);
                        }
                    }
                    if (other.hasIdentifierValue()) {
                        setIdentifierValue(other.getIdentifierValue());
                    }
                    if (other.hasPositiveIntValue()) {
                        setPositiveIntValue(other.getPositiveIntValue());
                    }
                    if (other.hasNegativeIntValue()) {
                        setNegativeIntValue(other.getNegativeIntValue());
                    }
                    if (other.hasDoubleValue()) {
                        setDoubleValue(other.getDoubleValue());
                    }
                    if (other.hasStringValue()) {
                        setStringValue(other.getStringValue());
                    }
                    if (other.hasAggregateValue()) {
                        setAggregateValue(other.getAggregateValue());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getNameCount(); i++) {
                    if (!getName(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                            Builder subBuilder = NamePart.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addName(subBuilder.buildPartial());
                            continue;
                        case 26:
                            this.bitField0_ |= UninterpretedOption.NAME_FIELD_NUMBER;
                            this.identifierValue_ = input.readBytes();
                            continue;
                        case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                            this.bitField0_ |= UninterpretedOption.POSITIVE_INT_VALUE_FIELD_NUMBER;
                            this.positiveIntValue_ = input.readUInt64();
                            continue;
                        case 40:
                            this.bitField0_ |= UninterpretedOption.AGGREGATE_VALUE_FIELD_NUMBER;
                            this.negativeIntValue_ = input.readInt64();
                            continue;
                        case 49:
                            this.bitField0_ |= 16;
                            this.doubleValue_ = input.readDouble();
                            continue;
                        case 58:
                            this.bitField0_ |= 32;
                            this.stringValue_ = input.readBytes();
                            continue;
                        case 66:
                            this.bitField0_ |= 64;
                            this.aggregateValue_ = input.readBytes();
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            private void ensureNameIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.name_ = new ArrayList(this.name_);
                    this.bitField0_ |= 1;
                }
            }

            public List<NamePart> getNameList() {
                if (this.nameBuilder_ == null) {
                    return Collections.unmodifiableList(this.name_);
                }
                return this.nameBuilder_.getMessageList();
            }

            public int getNameCount() {
                if (this.nameBuilder_ == null) {
                    return this.name_.size();
                }
                return this.nameBuilder_.getCount();
            }

            public NamePart getName(int index) {
                if (this.nameBuilder_ == null) {
                    return (NamePart) this.name_.get(index);
                }
                return (NamePart) this.nameBuilder_.getMessage(index);
            }

            public Builder setName(int index, NamePart value) {
                if (this.nameBuilder_ != null) {
                    this.nameBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNameIsMutable();
                    this.name_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setName(int index, Builder builderForValue) {
                if (this.nameBuilder_ == null) {
                    ensureNameIsMutable();
                    this.name_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nameBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addName(NamePart value) {
                if (this.nameBuilder_ != null) {
                    this.nameBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNameIsMutable();
                    this.name_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addName(int index, NamePart value) {
                if (this.nameBuilder_ != null) {
                    this.nameBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNameIsMutable();
                    this.name_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addName(Builder builderForValue) {
                if (this.nameBuilder_ == null) {
                    ensureNameIsMutable();
                    this.name_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.nameBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addName(int index, Builder builderForValue) {
                if (this.nameBuilder_ == null) {
                    ensureNameIsMutable();
                    this.name_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nameBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllName(Iterable<? extends NamePart> values) {
                if (this.nameBuilder_ == null) {
                    ensureNameIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.name_);
                    onChanged();
                } else {
                    this.nameBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearName() {
                if (this.nameBuilder_ == null) {
                    this.name_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.nameBuilder_.clear();
                }
                return this;
            }

            public Builder removeName(int index) {
                if (this.nameBuilder_ == null) {
                    ensureNameIsMutable();
                    this.name_.remove(index);
                    onChanged();
                } else {
                    this.nameBuilder_.remove(index);
                }
                return this;
            }

            public Builder getNameBuilder(int index) {
                return (Builder) getNameFieldBuilder().getBuilder(index);
            }

            public NamePartOrBuilder getNameOrBuilder(int index) {
                if (this.nameBuilder_ == null) {
                    return (NamePartOrBuilder) this.name_.get(index);
                }
                return (NamePartOrBuilder) this.nameBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends NamePartOrBuilder> getNameOrBuilderList() {
                if (this.nameBuilder_ != null) {
                    return this.nameBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.name_);
            }

            public Builder addNameBuilder() {
                return (Builder) getNameFieldBuilder().addBuilder(NamePart.getDefaultInstance());
            }

            public Builder addNameBuilder(int index) {
                return (Builder) getNameFieldBuilder().addBuilder(index, NamePart.getDefaultInstance());
            }

            public List<Builder> getNameBuilderList() {
                return getNameFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<NamePart, Builder, NamePartOrBuilder> getNameFieldBuilder() {
                boolean z = true;
                if (this.nameBuilder_ == null) {
                    List list = this.name_;
                    if ((this.bitField0_ & 1) != 1) {
                        z = false;
                    }
                    this.nameBuilder_ = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
                    this.name_ = null;
                }
                return this.nameBuilder_;
            }

            public boolean hasIdentifierValue() {
                return (this.bitField0_ & UninterpretedOption.NAME_FIELD_NUMBER) == UninterpretedOption.NAME_FIELD_NUMBER;
            }

            public String getIdentifierValue() {
                Object ref = this.identifierValue_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.identifierValue_ = s;
                return s;
            }

            public Builder setIdentifierValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= UninterpretedOption.NAME_FIELD_NUMBER;
                this.identifierValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdentifierValue() {
                this.bitField0_ &= -3;
                this.identifierValue_ = UninterpretedOption.getDefaultInstance().getIdentifierValue();
                onChanged();
                return this;
            }

            void setIdentifierValue(ByteString value) {
                this.bitField0_ |= UninterpretedOption.NAME_FIELD_NUMBER;
                this.identifierValue_ = value;
                onChanged();
            }

            public boolean hasPositiveIntValue() {
                return (this.bitField0_ & UninterpretedOption.POSITIVE_INT_VALUE_FIELD_NUMBER) == UninterpretedOption.POSITIVE_INT_VALUE_FIELD_NUMBER;
            }

            public long getPositiveIntValue() {
                return this.positiveIntValue_;
            }

            public Builder setPositiveIntValue(long value) {
                this.bitField0_ |= UninterpretedOption.POSITIVE_INT_VALUE_FIELD_NUMBER;
                this.positiveIntValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearPositiveIntValue() {
                this.bitField0_ &= -5;
                this.positiveIntValue_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNegativeIntValue() {
                return (this.bitField0_ & UninterpretedOption.AGGREGATE_VALUE_FIELD_NUMBER) == UninterpretedOption.AGGREGATE_VALUE_FIELD_NUMBER;
            }

            public long getNegativeIntValue() {
                return this.negativeIntValue_;
            }

            public Builder setNegativeIntValue(long value) {
                this.bitField0_ |= UninterpretedOption.AGGREGATE_VALUE_FIELD_NUMBER;
                this.negativeIntValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearNegativeIntValue() {
                this.bitField0_ &= -9;
                this.negativeIntValue_ = 0;
                onChanged();
                return this;
            }

            public boolean hasDoubleValue() {
                return (this.bitField0_ & 16) == 16;
            }

            public double getDoubleValue() {
                return this.doubleValue_;
            }

            public Builder setDoubleValue(double value) {
                this.bitField0_ |= 16;
                this.doubleValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearDoubleValue() {
                this.bitField0_ &= -17;
                this.doubleValue_ = 0.0d;
                onChanged();
                return this;
            }

            public boolean hasStringValue() {
                return (this.bitField0_ & 32) == 32;
            }

            public ByteString getStringValue() {
                return this.stringValue_;
            }

            public Builder setStringValue(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 32;
                this.stringValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearStringValue() {
                this.bitField0_ &= -33;
                this.stringValue_ = UninterpretedOption.getDefaultInstance().getStringValue();
                onChanged();
                return this;
            }

            public boolean hasAggregateValue() {
                return (this.bitField0_ & 64) == 64;
            }

            public String getAggregateValue() {
                Object ref = this.aggregateValue_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.aggregateValue_ = s;
                return s;
            }

            public Builder setAggregateValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.aggregateValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearAggregateValue() {
                this.bitField0_ &= -65;
                this.aggregateValue_ = UninterpretedOption.getDefaultInstance().getAggregateValue();
                onChanged();
                return this;
            }

            void setAggregateValue(ByteString value) {
                this.bitField0_ |= 64;
                this.aggregateValue_ = value;
                onChanged();
            }
        }

        public interface NamePartOrBuilder extends MessageOrBuilder {
            boolean getIsExtension();

            String getNamePart();

            boolean hasIsExtension();

            boolean hasNamePart();
        }

        public static final class NamePart extends GeneratedMessage implements NamePartOrBuilder {
            public static final int IS_EXTENSION_FIELD_NUMBER = 2;
            public static final int NAME_PART_FIELD_NUMBER = 1;
            private static final NamePart defaultInstance;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private boolean isExtension_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Object namePart_;

            public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements NamePartOrBuilder {
                private int bitField0_;
                private boolean isExtension_;
                private Object namePart_;

                public static final Descriptor getDescriptor() {
                    return DescriptorProtos.f462xb111d23c;
                }

                protected FieldAccessorTable internalGetFieldAccessorTable() {
                    return DescriptorProtos.f463x1698fcba;
                }

                private Builder() {
                    this.namePart_ = StringUtil.EMPTY_STRING;
                    maybeForceBuilderInitialization();
                }

                private Builder(BuilderParent parent) {
                    super(parent);
                    this.namePart_ = StringUtil.EMPTY_STRING;
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (!GeneratedMessage.alwaysUseFieldBuilders) {
                    }
                }

                private static Builder create() {
                    return new Builder();
                }

                public Builder clear() {
                    super.clear();
                    this.namePart_ = StringUtil.EMPTY_STRING;
                    this.bitField0_ &= -2;
                    this.isExtension_ = false;
                    this.bitField0_ &= -3;
                    return this;
                }

                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Descriptor getDescriptorForType() {
                    return NamePart.getDescriptor();
                }

                public NamePart getDefaultInstanceForType() {
                    return NamePart.getDefaultInstance();
                }

                public NamePart build() {
                    NamePart result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result);
                }

                private NamePart buildParsed() throws InvalidProtocolBufferException {
                    NamePart result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(result).asInvalidProtocolBufferException();
                }

                public NamePart buildPartial() {
                    NamePart result = new NamePart();
                    int from_bitField0_ = this.bitField0_;
                    int to_bitField0_ = 0;
                    if ((from_bitField0_ & NamePart.NAME_PART_FIELD_NUMBER) == NamePart.NAME_PART_FIELD_NUMBER) {
                        to_bitField0_ = 0 | NamePart.NAME_PART_FIELD_NUMBER;
                    }
                    result.namePart_ = this.namePart_;
                    if ((from_bitField0_ & NamePart.IS_EXTENSION_FIELD_NUMBER) == NamePart.IS_EXTENSION_FIELD_NUMBER) {
                        to_bitField0_ |= NamePart.IS_EXTENSION_FIELD_NUMBER;
                    }
                    result.isExtension_ = this.isExtension_;
                    result.bitField0_ = to_bitField0_;
                    onBuilt();
                    return result;
                }

                public Builder mergeFrom(Message other) {
                    if (other instanceof NamePart) {
                        return mergeFrom((NamePart) other);
                    }
                    super.mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(NamePart other) {
                    if (other != NamePart.getDefaultInstance()) {
                        if (other.hasNamePart()) {
                            setNamePart(other.getNamePart());
                        }
                        if (other.hasIsExtension()) {
                            setIsExtension(other.getIsExtension());
                        }
                        mergeUnknownFields(other.getUnknownFields());
                    }
                    return this;
                }

                public final boolean isInitialized() {
                    if (hasNamePart() && hasIsExtension()) {
                        return true;
                    }
                    return false;
                }

                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                    while (true) {
                        int tag = input.readTag();
                        switch (tag) {
                            case CharacterEscapes.ESCAPE_NONE /*0*/:
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                                this.bitField0_ |= NamePart.NAME_PART_FIELD_NUMBER;
                                this.namePart_ = input.readBytes();
                                continue;
                            case Segment.TOKENS_PER_SEGMENT /*16*/:
                                this.bitField0_ |= NamePart.IS_EXTENSION_FIELD_NUMBER;
                                this.isExtension_ = input.readBool();
                                continue;
                            default:
                                if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    setUnknownFields(unknownFields.build());
                                    onChanged();
                                    break;
                                }
                                continue;
                        }
                        return this;
                    }
                }

                public boolean hasNamePart() {
                    return (this.bitField0_ & NamePart.NAME_PART_FIELD_NUMBER) == NamePart.NAME_PART_FIELD_NUMBER;
                }

                public String getNamePart() {
                    Object ref = this.namePart_;
                    if (ref instanceof String) {
                        return (String) ref;
                    }
                    String s = ((ByteString) ref).toStringUtf8();
                    this.namePart_ = s;
                    return s;
                }

                public Builder setNamePart(String value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= NamePart.NAME_PART_FIELD_NUMBER;
                    this.namePart_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearNamePart() {
                    this.bitField0_ &= -2;
                    this.namePart_ = NamePart.getDefaultInstance().getNamePart();
                    onChanged();
                    return this;
                }

                void setNamePart(ByteString value) {
                    this.bitField0_ |= NamePart.NAME_PART_FIELD_NUMBER;
                    this.namePart_ = value;
                    onChanged();
                }

                public boolean hasIsExtension() {
                    return (this.bitField0_ & NamePart.IS_EXTENSION_FIELD_NUMBER) == NamePart.IS_EXTENSION_FIELD_NUMBER;
                }

                public boolean getIsExtension() {
                    return this.isExtension_;
                }

                public Builder setIsExtension(boolean value) {
                    this.bitField0_ |= NamePart.IS_EXTENSION_FIELD_NUMBER;
                    this.isExtension_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearIsExtension() {
                    this.bitField0_ &= -3;
                    this.isExtension_ = false;
                    onChanged();
                    return this;
                }
            }

            private NamePart(Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            private NamePart(boolean noInit) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            public static NamePart getDefaultInstance() {
                return defaultInstance;
            }

            public NamePart getDefaultInstanceForType() {
                return defaultInstance;
            }

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.f462xb111d23c;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f463x1698fcba;
            }

            public boolean hasNamePart() {
                return (this.bitField0_ & NAME_PART_FIELD_NUMBER) == NAME_PART_FIELD_NUMBER;
            }

            public String getNamePart() {
                ByteString ref = this.namePart_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                ByteString bs = ref;
                String s = bs.toStringUtf8();
                if (Internal.isValidUtf8(bs)) {
                    this.namePart_ = s;
                }
                return s;
            }

            private ByteString getNamePartBytes() {
                Object ref = this.namePart_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.namePart_ = b;
                return b;
            }

            public boolean hasIsExtension() {
                return (this.bitField0_ & IS_EXTENSION_FIELD_NUMBER) == IS_EXTENSION_FIELD_NUMBER;
            }

            public boolean getIsExtension() {
                return this.isExtension_;
            }

            private void initFields() {
                this.namePart_ = StringUtil.EMPTY_STRING;
                this.isExtension_ = false;
            }

            public final boolean isInitialized() {
                byte isInitialized = this.memoizedIsInitialized;
                if (isInitialized != -1) {
                    if (isInitialized == (byte) 1) {
                        return true;
                    }
                    return false;
                } else if (!hasNamePart()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (hasIsExtension()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & NAME_PART_FIELD_NUMBER) == NAME_PART_FIELD_NUMBER) {
                    output.writeBytes(NAME_PART_FIELD_NUMBER, getNamePartBytes());
                }
                if ((this.bitField0_ & IS_EXTENSION_FIELD_NUMBER) == IS_EXTENSION_FIELD_NUMBER) {
                    output.writeBool(IS_EXTENSION_FIELD_NUMBER, this.isExtension_);
                }
                getUnknownFields().writeTo(output);
            }

            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                size = 0;
                if ((this.bitField0_ & NAME_PART_FIELD_NUMBER) == NAME_PART_FIELD_NUMBER) {
                    size = 0 + CodedOutputStream.computeBytesSize(NAME_PART_FIELD_NUMBER, getNamePartBytes());
                }
                if ((this.bitField0_ & IS_EXTENSION_FIELD_NUMBER) == IS_EXTENSION_FIELD_NUMBER) {
                    size += CodedOutputStream.computeBoolSize(IS_EXTENSION_FIELD_NUMBER, this.isExtension_);
                }
                size += getUnknownFields().getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }

            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static NamePart parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            public static NamePart parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            public static NamePart parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            public static NamePart parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            public static NamePart parseFrom(InputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static NamePart parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
            }

            public static NamePart parseDelimitedFrom(InputStream input) throws IOException {
                Builder builder = newBuilder();
                if (builder.mergeDelimitedFrom(input)) {
                    return builder.buildParsed();
                }
                return null;
            }

            public static NamePart parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Builder builder = newBuilder();
                if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                    return builder.buildParsed();
                }
                return null;
            }

            public static NamePart parseFrom(CodedInputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static NamePart parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(NamePart prototype) {
                return newBuilder().mergeFrom(prototype);
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }

            protected Builder newBuilderForType(BuilderParent parent) {
                return new Builder(null);
            }

            static {
                defaultInstance = new NamePart(true);
                defaultInstance.initFields();
            }
        }

        private UninterpretedOption(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UninterpretedOption(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UninterpretedOption getDefaultInstance() {
            return defaultInstance;
        }

        public UninterpretedOption getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f464x2101041;
        }

        public List<NamePart> getNameList() {
            return this.name_;
        }

        public List<? extends NamePartOrBuilder> getNameOrBuilderList() {
            return this.name_;
        }

        public int getNameCount() {
            return this.name_.size();
        }

        public NamePart getName(int index) {
            return (NamePart) this.name_.get(index);
        }

        public NamePartOrBuilder getNameOrBuilder(int index) {
            return (NamePartOrBuilder) this.name_.get(index);
        }

        public boolean hasIdentifierValue() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getIdentifierValue() {
            ByteString ref = this.identifierValue_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.identifierValue_ = s;
            }
            return s;
        }

        private ByteString getIdentifierValueBytes() {
            Object ref = this.identifierValue_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.identifierValue_ = b;
            return b;
        }

        public boolean hasPositiveIntValue() {
            return (this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER;
        }

        public long getPositiveIntValue() {
            return this.positiveIntValue_;
        }

        public boolean hasNegativeIntValue() {
            return (this.bitField0_ & POSITIVE_INT_VALUE_FIELD_NUMBER) == POSITIVE_INT_VALUE_FIELD_NUMBER;
        }

        public long getNegativeIntValue() {
            return this.negativeIntValue_;
        }

        public boolean hasDoubleValue() {
            return (this.bitField0_ & AGGREGATE_VALUE_FIELD_NUMBER) == AGGREGATE_VALUE_FIELD_NUMBER;
        }

        public double getDoubleValue() {
            return this.doubleValue_;
        }

        public boolean hasStringValue() {
            return (this.bitField0_ & 16) == 16;
        }

        public ByteString getStringValue() {
            return this.stringValue_;
        }

        public boolean hasAggregateValue() {
            return (this.bitField0_ & 32) == 32;
        }

        public String getAggregateValue() {
            ByteString ref = this.aggregateValue_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.aggregateValue_ = s;
            }
            return s;
        }

        private ByteString getAggregateValueBytes() {
            Object ref = this.aggregateValue_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.aggregateValue_ = b;
            return b;
        }

        private void initFields() {
            this.name_ = Collections.emptyList();
            this.identifierValue_ = StringUtil.EMPTY_STRING;
            this.positiveIntValue_ = 0;
            this.negativeIntValue_ = 0;
            this.doubleValue_ = 0.0d;
            this.stringValue_ = ByteString.EMPTY;
            this.aggregateValue_ = StringUtil.EMPTY_STRING;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getNameCount()) {
                    if (getName(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.name_.size(); i++) {
                output.writeMessage(NAME_FIELD_NUMBER, (MessageLite) this.name_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeBytes(IDENTIFIER_VALUE_FIELD_NUMBER, getIdentifierValueBytes());
            }
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                output.writeUInt64(POSITIVE_INT_VALUE_FIELD_NUMBER, this.positiveIntValue_);
            }
            if ((this.bitField0_ & POSITIVE_INT_VALUE_FIELD_NUMBER) == POSITIVE_INT_VALUE_FIELD_NUMBER) {
                output.writeInt64(NEGATIVE_INT_VALUE_FIELD_NUMBER, this.negativeIntValue_);
            }
            if ((this.bitField0_ & AGGREGATE_VALUE_FIELD_NUMBER) == AGGREGATE_VALUE_FIELD_NUMBER) {
                output.writeDouble(DOUBLE_VALUE_FIELD_NUMBER, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeBytes(STRING_VALUE_FIELD_NUMBER, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeBytes(AGGREGATE_VALUE_FIELD_NUMBER, getAggregateValueBytes());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.name_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(NAME_FIELD_NUMBER, (MessageLite) this.name_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeBytesSize(IDENTIFIER_VALUE_FIELD_NUMBER, getIdentifierValueBytes());
            }
            if ((this.bitField0_ & NAME_FIELD_NUMBER) == NAME_FIELD_NUMBER) {
                size += CodedOutputStream.computeUInt64Size(POSITIVE_INT_VALUE_FIELD_NUMBER, this.positiveIntValue_);
            }
            if ((this.bitField0_ & POSITIVE_INT_VALUE_FIELD_NUMBER) == POSITIVE_INT_VALUE_FIELD_NUMBER) {
                size += CodedOutputStream.computeInt64Size(NEGATIVE_INT_VALUE_FIELD_NUMBER, this.negativeIntValue_);
            }
            if ((this.bitField0_ & AGGREGATE_VALUE_FIELD_NUMBER) == AGGREGATE_VALUE_FIELD_NUMBER) {
                size += CodedOutputStream.computeDoubleSize(DOUBLE_VALUE_FIELD_NUMBER, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                size += CodedOutputStream.computeBytesSize(STRING_VALUE_FIELD_NUMBER, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                size += CodedOutputStream.computeBytesSize(AGGREGATE_VALUE_FIELD_NUMBER, getAggregateValueBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static UninterpretedOption parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static UninterpretedOption parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static UninterpretedOption parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static UninterpretedOption parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static UninterpretedOption parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static UninterpretedOption parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static UninterpretedOption parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static UninterpretedOption parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(UninterpretedOption prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(BuilderParent parent) {
            return new Builder(null);
        }

        static {
            defaultInstance = new UninterpretedOption(true);
            defaultInstance.initFields();
        }
    }

    private DescriptorProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n google/protobuf/descriptor.proto\u0012\u000fgoogle.protobuf\"G\n\u0011FileDescriptorSet\u00122\n\u0004file\u0018\u0001 \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"\u0097\u0003\n\u0013FileDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007package\u0018\u0002 \u0001(\t\u0012\u0012\n\ndependency\u0018\u0003 \u0003(\t\u00126\n\fmessage_type\u0018\u0004 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0005 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u00128\n\u0007service\u0018\u0006 \u0003(\u000b2'.google.protobuf.ServiceDescriptorProto\u00128\n\textension\u0018\u0007 \u0003(\u000b2%.google.p", "rotobuf.FieldDescriptorProto\u0012-\n\u0007options\u0018\b \u0001(\u000b2\u001c.google.protobuf.FileOptions\u00129\n\u0010source_code_info\u0018\t \u0001(\u000b2\u001f.google.protobuf.SourceCodeInfo\"\u00a9\u0003\n\u000fDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00124\n\u0005field\u0018\u0002 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00128\n\textension\u0018\u0006 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00125\n\u000bnested_type\u0018\u0003 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0004 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u0012H\n\u000fexte", "nsion_range\u0018\u0005 \u0003(\u000b2/.google.protobuf.DescriptorProto.ExtensionRange\u00120\n\u0007options\u0018\u0007 \u0001(\u000b2\u001f.google.protobuf.MessageOptions\u001a,\n\u000eExtensionRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"\u0094\u0005\n\u0014FieldDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012:\n\u0005label\u0018\u0004 \u0001(\u000e2+.google.protobuf.FieldDescriptorProto.Label\u00128\n\u0004type\u0018\u0005 \u0001(\u000e2*.google.protobuf.FieldDescriptorProto.Type\u0012\u0011\n\ttype_name\u0018\u0006 \u0001(\t\u0012\u0010\n\bextendee\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u0007 \u0001(\t\u0012.\n\u0007o", "ptions\u0018\b \u0001(\u000b2\u001d.google.protobuf.FieldOptions\"\u00b6\u0002\n\u0004Type\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"C\n\u0005Label\u0012\u0012\n\u000eLABEL_OPTIONAL\u0010\u0001\u0012\u0012\n\u000eLABEL_REQUI", "RED\u0010\u0002\u0012\u0012\n\u000eLABEL_REPEATED\u0010\u0003\"\u008c\u0001\n\u0013EnumDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00128\n\u0005value\u0018\u0002 \u0003(\u000b2).google.protobuf.EnumValueDescriptorProto\u0012-\n\u0007options\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.EnumOptions\"l\n\u0018EnumValueDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u00122\n\u0007options\u0018\u0003 \u0001(\u000b2!.google.protobuf.EnumValueOptions\"\u0090\u0001\n\u0016ServiceDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00126\n\u0006method\u0018\u0002 \u0003(\u000b2&.google.protobuf.MethodDescriptorProto\u00120\n\u0007options\u0018\u0003 \u0001(\u000b2\u001f.googl", "e.protobuf.ServiceOptions\"\u007f\n\u0015MethodDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_type\u0018\u0002 \u0001(\t\u0012\u0013\n\u000boutput_type\u0018\u0003 \u0001(\t\u0012/\n\u0007options\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.MethodOptions\"\u00d5\u0003\n\u000bFileOptions\u0012\u0014\n\fjava_package\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014java_outer_classname\u0018\b \u0001(\t\u0012\"\n\u0013java_multiple_files\u0018\n \u0001(\b:\u0005false\u0012,\n\u001djava_generate_equals_and_hash\u0018\u0014 \u0001(\b:\u0005false\u0012F\n\foptimize_for\u0018\t \u0001(\u000e2).google.protobuf.FileOptions.OptimizeMode:\u0005SPEED\u0012\"\n\u0013cc_generic_services\u0018", "\u0010 \u0001(\b:\u0005false\u0012$\n\u0015java_generic_services\u0018\u0011 \u0001(\b:\u0005false\u0012\"\n\u0013py_generic_services\u0018\u0012 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\u0012\t\n\u0005SPEED\u0010\u0001\u0012\r\n\tCODE_SIZE\u0010\u0002\u0012\u0010\n\fLITE_RUNTIME\u0010\u0003*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u00b8\u0001\n\u000eMessageOptions\u0012&\n\u0017message_set_wire_format\u0018\u0001 \u0001(\b:\u0005false\u0012.\n\u001fno_standard_descriptor_accessor\u0018\u0002 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOpti", "on*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u0094\u0002\n\fFieldOptions\u0012:\n\u0005ctype\u0018\u0001 \u0001(\u000e2#.google.protobuf.FieldOptions.CType:\u0006STRING\u0012\u000e\n\u0006packed\u0018\u0002 \u0001(\b\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u001c\n\u0014experimental_map_key\u0018\t \u0001(\t\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"/\n\u0005CType\u0012\n\n\u0006STRING\u0010\u0000\u0012\b\n\u0004CORD\u0010\u0001\u0012\u0010\n\fSTRING_PIECE\u0010\u0002*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"]\n\u000bEnumOptions\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"b\n\u0010EnumValue", "Options\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"`\n\u000eServiceOptions\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"_\n\rMethodOptions\u0012C\n\u0014uninterpreted_option\u0018\u00e7\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\b\u00e8\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u009e\u0002\n\u0013UninterpretedOption\u0012;\n\u0004name\u0018\u0002 \u0003(\u000b2-.google.protobuf.UninterpretedOption.NamePart\u0012\u0018\n\u0010identifier_value\u0018\u0003 \u0001(\t\u0012\u001a\n\u0012pos", "itive_int_value\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012negative_int_value\u0018\u0005 \u0001(\u0003\u0012\u0014\n\fdouble_value\u0018\u0006 \u0001(\u0001\u0012\u0014\n\fstring_value\u0018\u0007 \u0001(\f\u0012\u0017\n\u000faggregate_value\u0018\b \u0001(\t\u001a3\n\bNamePart\u0012\u0011\n\tname_part\u0018\u0001 \u0002(\t\u0012\u0014\n\fis_extension\u0018\u0002 \u0002(\b\"|\n\u000eSourceCodeInfo\u0012:\n\blocation\u0018\u0001 \u0003(\u000b2(.google.protobuf.SourceCodeInfo.Location\u001a.\n\bLocation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0010\n\u0004span\u0018\u0002 \u0003(\u0005B\u0002\u0010\u0001B)\n\u0013com.google.protobufB\u0010DescriptorProtosH\u0001"}, new FileDescriptor[0], new C08391());
    }
}
