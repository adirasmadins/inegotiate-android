package com.google.protobuf;

import com.google.common.base.Ascii;
import com.google.gdata.util.common.base.StringUtil;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;
import com.google.protobuf.ExtensionRegistry.ExtensionInfo;
import com.google.protobuf.Message.Builder;
import com.google.protobuf.UnknownFieldSet.Field;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public final class TextFormat {
    private static final int BUFFER_SIZE = 4096;
    private static final Printer DEFAULT_PRINTER;
    private static final Printer SINGLE_LINE_PRINTER;

    /* renamed from: com.google.protobuf.TextFormat.1 */
    static /* synthetic */ class C08571 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        static {
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = new int[Type.values().length];
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.SINT32.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.SFIXED32.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.INT64.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.SINT64.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.SFIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.DOUBLE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.FIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.FIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Type.GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
        }
    }

    static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        InvalidEscapeSequenceException(String description) {
            super(description);
        }
    }

    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;

        public ParseException(String message) {
            super(message);
        }
    }

    private static final class Printer {
        final boolean singleLineMode;

        private Printer(boolean singleLineMode) {
            this.singleLineMode = singleLineMode;
        }

        private void print(Message message, TextGenerator generator) throws IOException {
            for (Entry<FieldDescriptor, Object> field : message.getAllFields().entrySet()) {
                printField((FieldDescriptor) field.getKey(), field.getValue(), generator);
            }
            printUnknownFields(message.getUnknownFields(), generator);
        }

        private void printField(FieldDescriptor field, Object value, TextGenerator generator) throws IOException {
            if (field.isRepeated()) {
                for (Object element : (List) value) {
                    printSingleField(field, element, generator);
                }
                return;
            }
            printSingleField(field, value, generator);
        }

        private void printSingleField(FieldDescriptor field, Object value, TextGenerator generator) throws IOException {
            if (field.isExtension()) {
                generator.print("[");
                if (field.getContainingType().getOptions().getMessageSetWireFormat() && field.getType() == Type.MESSAGE && field.isOptional() && field.getExtensionScope() == field.getMessageType()) {
                    generator.print(field.getMessageType().getFullName());
                } else {
                    generator.print(field.getFullName());
                }
                generator.print("]");
            } else if (field.getType() == Type.GROUP) {
                generator.print(field.getMessageType().getName());
            } else {
                generator.print(field.getName());
            }
            if (field.getJavaType() != JavaType.MESSAGE) {
                generator.print(": ");
            } else if (this.singleLineMode) {
                generator.print(" { ");
            } else {
                generator.print(" {\n");
                generator.indent();
            }
            printFieldValue(field, value, generator);
            if (field.getJavaType() == JavaType.MESSAGE) {
                if (this.singleLineMode) {
                    generator.print("} ");
                    return;
                }
                generator.outdent();
                generator.print("}\n");
            } else if (this.singleLineMode) {
                generator.print(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            } else {
                generator.print("\n");
            }
        }

        private void printFieldValue(FieldDescriptor field, Object value, TextGenerator generator) throws IOException {
            switch (C08571.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[field.getType().ordinal()]) {
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                    generator.print(((Integer) value).toString());
                case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                    generator.print(((Long) value).toString());
                case SimpleLog.LOG_LEVEL_OFF /*7*/:
                    generator.print(((Boolean) value).toString());
                case PayPalActivity.VIEW_TEST /*8*/:
                    generator.print(((Float) value).toString());
                case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                    generator.print(((Double) value).toString());
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                case PayPal.PAYMENT_SUBTYPE_REMITTANCES /*11*/:
                    generator.print(TextFormat.unsignedToString(((Integer) value).intValue()));
                case PayPal.PAYMENT_SUBTYPE_RENT /*12*/:
                case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                    generator.print(TextFormat.unsignedToString(((Long) value).longValue()));
                case PayPal.PAYMENT_SUBTYPE_MEDICAL /*14*/:
                    generator.print("\"");
                    generator.print(TextFormat.escapeText((String) value));
                    generator.print("\"");
                case PayPal.PAYMENT_SUBTYPE_CHILDCARE /*15*/:
                    generator.print("\"");
                    generator.print(TextFormat.escapeBytes((ByteString) value));
                    generator.print("\"");
                case Segment.TOKENS_PER_SEGMENT /*16*/:
                    generator.print(((EnumValueDescriptor) value).getName());
                case PayPal.PAYMENT_SUBTYPE_CONTRACTORS /*17*/:
                case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                    print((Message) value, generator);
                default:
            }
        }

        private void printUnknownFields(UnknownFieldSet unknownFields, TextGenerator generator) throws IOException {
            for (Entry<Integer, Field> entry : unknownFields.asMap().entrySet()) {
                int number = ((Integer) entry.getKey()).intValue();
                Field field = (Field) entry.getValue();
                printUnknownField(number, 0, field.getVarintList(), generator);
                printUnknownField(number, 5, field.getFixed32List(), generator);
                printUnknownField(number, 1, field.getFixed64List(), generator);
                printUnknownField(number, 2, field.getLengthDelimitedList(), generator);
                for (UnknownFieldSet value : field.getGroupList()) {
                    generator.print(((Integer) entry.getKey()).toString());
                    if (this.singleLineMode) {
                        generator.print(" { ");
                    } else {
                        generator.print(" {\n");
                        generator.indent();
                    }
                    printUnknownFields(value, generator);
                    if (this.singleLineMode) {
                        generator.print("} ");
                    } else {
                        generator.outdent();
                        generator.print("}\n");
                    }
                }
            }
        }

        private void printUnknownField(int number, int wireType, List<?> values, TextGenerator generator) throws IOException {
            for (Object value : values) {
                generator.print(String.valueOf(number));
                generator.print(": ");
                TextFormat.printUnknownFieldValue(wireType, value, generator);
                generator.print(this.singleLineMode ? MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR : "\n");
            }
        }
    }

    private static final class TextGenerator {
        private boolean atStartOfLine;
        private final StringBuilder indent;
        private final Appendable output;

        private TextGenerator(Appendable output) {
            this.indent = new StringBuilder();
            this.atStartOfLine = true;
            this.output = output;
        }

        public void indent() {
            this.indent.append("  ");
        }

        public void outdent() {
            int length = this.indent.length();
            if (length == 0) {
                throw new IllegalArgumentException(" Outdent() without matching Indent().");
            }
            this.indent.delete(length - 2, length);
        }

        public void print(CharSequence text) throws IOException {
            int size = text.length();
            int pos = 0;
            for (int i = 0; i < size; i++) {
                if (text.charAt(i) == '\n') {
                    write(text.subSequence(pos, size), (i - pos) + 1);
                    pos = i + 1;
                    this.atStartOfLine = true;
                }
            }
            write(text.subSequence(pos, size), size - pos);
        }

        private void write(CharSequence data, int size) throws IOException {
            if (size != 0) {
                if (this.atStartOfLine) {
                    this.atStartOfLine = false;
                    this.output.append(this.indent);
                }
                this.output.append(data);
            }
        }
    }

    private static final class Tokenizer {
        private static final Pattern DOUBLE_INFINITY;
        private static final Pattern FLOAT_INFINITY;
        private static final Pattern FLOAT_NAN;
        private static final Pattern TOKEN;
        private static final Pattern WHITESPACE;
        private int column;
        private String currentToken;
        private int line;
        private final Matcher matcher;
        private int pos;
        private int previousColumn;
        private int previousLine;
        private final CharSequence text;

        static {
            WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
            TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
            DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
            FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
            FLOAT_NAN = Pattern.compile("nanf?", 2);
        }

        private Tokenizer(CharSequence text) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.text = text;
            this.matcher = WHITESPACE.matcher(text);
            skipWhitespace();
            nextToken();
        }

        public boolean atEnd() {
            return this.currentToken.length() == 0;
        }

        public void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
            while (this.pos < this.matcher.regionStart()) {
                if (this.text.charAt(this.pos) == '\n') {
                    this.line++;
                    this.column = 0;
                } else {
                    this.column++;
                }
                this.pos++;
            }
            if (this.matcher.regionStart() == this.matcher.regionEnd()) {
                this.currentToken = StringUtil.EMPTY_STRING;
                return;
            }
            this.matcher.usePattern(TOKEN);
            if (this.matcher.lookingAt()) {
                this.currentToken = this.matcher.group();
                this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
            } else {
                this.currentToken = String.valueOf(this.text.charAt(this.pos));
                this.matcher.region(this.pos + 1, this.matcher.regionEnd());
            }
            skipWhitespace();
        }

        private void skipWhitespace() {
            this.matcher.usePattern(WHITESPACE);
            if (this.matcher.lookingAt()) {
                this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
            }
        }

        public boolean tryConsume(String token) {
            if (!this.currentToken.equals(token)) {
                return false;
            }
            nextToken();
            return true;
        }

        public void consume(String token) throws ParseException {
            if (!tryConsume(token)) {
                throw parseException("Expected \"" + token + "\".");
            }
        }

        public boolean lookingAtInteger() {
            if (this.currentToken.length() == 0) {
                return false;
            }
            char c = this.currentToken.charAt(0);
            if (('0' <= c && c <= '9') || c == '-' || c == '+') {
                return true;
            }
            return false;
        }

        public String consumeIdentifier() throws ParseException {
            for (int i = 0; i < this.currentToken.length(); i++) {
                char c = this.currentToken.charAt(i);
                if (('a' > c || c > 'z') && (('A' > c || c > 'Z') && !(('0' <= c && c <= '9') || c == '_' || c == '.'))) {
                    throw parseException("Expected identifier.");
                }
            }
            String result = this.currentToken;
            nextToken();
            return result;
        }

        public int consumeInt32() throws ParseException {
            try {
                int result = TextFormat.parseInt32(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public int consumeUInt32() throws ParseException {
            try {
                int result = TextFormat.parseUInt32(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public long consumeInt64() throws ParseException {
            try {
                long result = TextFormat.parseInt64(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public long consumeUInt64() throws ParseException {
            try {
                long result = TextFormat.parseUInt64(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public double consumeDouble() throws ParseException {
            if (DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
                boolean negative = this.currentToken.startsWith("-");
                nextToken();
                return negative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            } else if (this.currentToken.equalsIgnoreCase("nan")) {
                nextToken();
                return Double.NaN;
            } else {
                try {
                    double result = Double.parseDouble(this.currentToken);
                    nextToken();
                    return result;
                } catch (NumberFormatException e) {
                    throw floatParseException(e);
                }
            }
        }

        public float consumeFloat() throws ParseException {
            if (FLOAT_INFINITY.matcher(this.currentToken).matches()) {
                boolean negative = this.currentToken.startsWith("-");
                nextToken();
                return negative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
            } else if (FLOAT_NAN.matcher(this.currentToken).matches()) {
                nextToken();
                return Float.NaN;
            } else {
                try {
                    float result = Float.parseFloat(this.currentToken);
                    nextToken();
                    return result;
                } catch (NumberFormatException e) {
                    throw floatParseException(e);
                }
            }
        }

        public boolean consumeBoolean() throws ParseException {
            if (this.currentToken.equals("true") || this.currentToken.equals("t") || this.currentToken.equals("1")) {
                nextToken();
                return true;
            } else if (this.currentToken.equals("false") || this.currentToken.equals("f") || this.currentToken.equals("0")) {
                nextToken();
                return false;
            } else {
                throw parseException("Expected \"true\" or \"false\".");
            }
        }

        public String consumeString() throws ParseException {
            return consumeByteString().toStringUtf8();
        }

        public ByteString consumeByteString() throws ParseException {
            List list = new ArrayList();
            consumeByteString(list);
            while (true) {
                if (!this.currentToken.startsWith("'") && !this.currentToken.startsWith("\"")) {
                    return ByteString.copyFrom(list);
                }
                consumeByteString(list);
            }
        }

        private void consumeByteString(List<ByteString> list) throws ParseException {
            char quote = '\u0000';
            if (this.currentToken.length() > 0) {
                quote = this.currentToken.charAt(0);
            }
            if (quote != '\"' && quote != '\'') {
                throw parseException("Expected string.");
            } else if (this.currentToken.length() < 2 || this.currentToken.charAt(this.currentToken.length() - 1) != quote) {
                throw parseException("String missing ending quote.");
            } else {
                try {
                    ByteString result = TextFormat.unescapeBytes(this.currentToken.substring(1, this.currentToken.length() - 1));
                    nextToken();
                    list.add(result);
                } catch (InvalidEscapeSequenceException e) {
                    throw parseException(e.getMessage());
                }
            }
        }

        public ParseException parseException(String description) {
            return new ParseException((this.line + 1) + ":" + (this.column + 1) + ": " + description);
        }

        public ParseException parseExceptionPreviousToken(String description) {
            return new ParseException((this.previousLine + 1) + ":" + (this.previousColumn + 1) + ": " + description);
        }

        private ParseException integerParseException(NumberFormatException e) {
            return parseException("Couldn't parse integer: " + e.getMessage());
        }

        private ParseException floatParseException(NumberFormatException e) {
            return parseException("Couldn't parse number: " + e.getMessage());
        }
    }

    private TextFormat() {
    }

    static {
        DEFAULT_PRINTER = new Printer(null);
        SINGLE_LINE_PRINTER = new Printer(null);
    }

    public static void print(Message message, Appendable output) throws IOException {
        DEFAULT_PRINTER.print(message, new TextGenerator(null));
    }

    public static void print(UnknownFieldSet fields, Appendable output) throws IOException {
        DEFAULT_PRINTER.printUnknownFields(fields, new TextGenerator(null));
    }

    public static String shortDebugString(Message message) {
        try {
            StringBuilder sb = new StringBuilder();
            SINGLE_LINE_PRINTER.print(message, new TextGenerator(null));
            return sb.toString().trim();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String shortDebugString(UnknownFieldSet fields) {
        try {
            StringBuilder sb = new StringBuilder();
            SINGLE_LINE_PRINTER.printUnknownFields(fields, new TextGenerator(null));
            return sb.toString().trim();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String printToString(Message message) {
        try {
            Appendable text = new StringBuilder();
            print(message, text);
            return text.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String printToString(UnknownFieldSet fields) {
        try {
            Appendable text = new StringBuilder();
            print(fields, text);
            return text.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void printField(FieldDescriptor field, Object value, Appendable output) throws IOException {
        DEFAULT_PRINTER.printField(field, value, new TextGenerator(null));
    }

    public static String printFieldToString(FieldDescriptor field, Object value) {
        try {
            StringBuilder text = new StringBuilder();
            printField(field, value, text);
            return text.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void printFieldValue(FieldDescriptor field, Object value, Appendable output) throws IOException {
        DEFAULT_PRINTER.printFieldValue(field, value, new TextGenerator(null));
    }

    public static void printUnknownFieldValue(int tag, Object value, Appendable output) throws IOException {
        printUnknownFieldValue(tag, value, new TextGenerator(null));
    }

    private static void printUnknownFieldValue(int tag, Object value, TextGenerator generator) throws IOException {
        switch (WireFormat.getTagWireType(tag)) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                generator.print(unsignedToString(((Long) value).longValue()));
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                generator.print(String.format((Locale) null, "0x%016x", new Object[]{(Long) value}));
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                generator.print("\"");
                generator.print(escapeBytes((ByteString) value));
                generator.print("\"");
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                DEFAULT_PRINTER.printUnknownFields((UnknownFieldSet) value, generator);
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                generator.print(String.format((Locale) null, "0x%08x", new Object[]{(Integer) value}));
            default:
                throw new IllegalArgumentException("Bad tag: " + tag);
        }
    }

    private static String unsignedToString(int value) {
        if (value >= 0) {
            return Integer.toString(value);
        }
        return Long.toString(((long) value) & 4294967295L);
    }

    private static String unsignedToString(long value) {
        if (value >= 0) {
            return Long.toString(value);
        }
        return BigInteger.valueOf(Long.MAX_VALUE & value).setBit(63).toString();
    }

    public static void merge(Readable input, Builder builder) throws IOException {
        merge(input, ExtensionRegistry.getEmptyRegistry(), builder);
    }

    public static void merge(CharSequence input, Builder builder) throws ParseException {
        merge(input, ExtensionRegistry.getEmptyRegistry(), builder);
    }

    public static void merge(Readable input, ExtensionRegistry extensionRegistry, Builder builder) throws IOException {
        merge(toStringBuilder(input), extensionRegistry, builder);
    }

    private static StringBuilder toStringBuilder(Readable input) throws IOException {
        StringBuilder text = new StringBuilder();
        CharBuffer buffer = CharBuffer.allocate(BUFFER_SIZE);
        while (true) {
            int n = input.read(buffer);
            if (n == -1) {
                return text;
            }
            buffer.flip();
            text.append(buffer, 0, n);
        }
    }

    public static void merge(CharSequence input, ExtensionRegistry extensionRegistry, Builder builder) throws ParseException {
        Tokenizer tokenizer = new Tokenizer(null);
        while (!tokenizer.atEnd()) {
            mergeField(tokenizer, extensionRegistry, builder);
        }
    }

    private static void mergeField(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, Builder builder) throws ParseException {
        FieldDescriptor field;
        Descriptor type = builder.getDescriptorForType();
        ExtensionInfo extension = null;
        if (tokenizer.tryConsume("[")) {
            StringBuilder name = new StringBuilder(tokenizer.consumeIdentifier());
            while (tokenizer.tryConsume(".")) {
                name.append('.');
                name.append(tokenizer.consumeIdentifier());
            }
            extension = extensionRegistry.findExtensionByName(name.toString());
            if (extension == null) {
                throw tokenizer.parseExceptionPreviousToken("Extension \"" + name + "\" not found in the ExtensionRegistry.");
            } else if (extension.descriptor.getContainingType() != type) {
                throw tokenizer.parseExceptionPreviousToken("Extension \"" + name + "\" does not extend message type \"" + type.getFullName() + "\".");
            } else {
                tokenizer.consume("]");
                field = extension.descriptor;
            }
        } else {
            String name2 = tokenizer.consumeIdentifier();
            field = type.findFieldByName(name2);
            if (field == null) {
                field = type.findFieldByName(name2.toLowerCase(Locale.US));
                if (!(field == null || field.getType() == Type.GROUP)) {
                    field = null;
                }
            }
            if (!(field == null || field.getType() != Type.GROUP || field.getMessageType().getName().equals(name2))) {
                field = null;
            }
            if (field == null) {
                throw tokenizer.parseExceptionPreviousToken("Message type \"" + type.getFullName() + "\" has no field named \"" + name2 + "\".");
            }
        }
        Object value = null;
        if (field.getJavaType() != JavaType.MESSAGE) {
            tokenizer.consume(":");
            switch (C08571.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[field.getType().ordinal()]) {
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                    value = Integer.valueOf(tokenizer.consumeInt32());
                    break;
                case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                    value = Long.valueOf(tokenizer.consumeInt64());
                    break;
                case SimpleLog.LOG_LEVEL_OFF /*7*/:
                    value = Boolean.valueOf(tokenizer.consumeBoolean());
                    break;
                case PayPalActivity.VIEW_TEST /*8*/:
                    value = Float.valueOf(tokenizer.consumeFloat());
                    break;
                case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                    value = Double.valueOf(tokenizer.consumeDouble());
                    break;
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                case PayPal.PAYMENT_SUBTYPE_REMITTANCES /*11*/:
                    value = Integer.valueOf(tokenizer.consumeUInt32());
                    break;
                case PayPal.PAYMENT_SUBTYPE_RENT /*12*/:
                case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                    value = Long.valueOf(tokenizer.consumeUInt64());
                    break;
                case PayPal.PAYMENT_SUBTYPE_MEDICAL /*14*/:
                    value = tokenizer.consumeString();
                    break;
                case PayPal.PAYMENT_SUBTYPE_CHILDCARE /*15*/:
                    value = tokenizer.consumeByteString();
                    break;
                case Segment.TOKENS_PER_SEGMENT /*16*/:
                    EnumDescriptor enumType = field.getEnumType();
                    if (tokenizer.lookingAtInteger()) {
                        int number = tokenizer.consumeInt32();
                        value = enumType.findValueByNumber(number);
                        if (value == null) {
                            throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value with number " + number + '.');
                        }
                    }
                    String id = tokenizer.consumeIdentifier();
                    value = enumType.findValueByName(id);
                    if (value == null) {
                        throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value named \"" + id + "\".");
                    }
                    break;
                case PayPal.PAYMENT_SUBTYPE_CONTRACTORS /*17*/:
                case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                    throw new RuntimeException("Can't get here.");
                default:
                    break;
            }
        }
        String endToken;
        Builder subBuilder;
        tokenizer.tryConsume(":");
        if (tokenizer.tryConsume("<")) {
            endToken = ">";
        } else {
            tokenizer.consume("{");
            endToken = "}";
        }
        if (extension == null) {
            subBuilder = builder.newBuilderForField(field);
        } else {
            subBuilder = extension.defaultInstance.newBuilderForType();
        }
        while (!tokenizer.tryConsume(endToken)) {
            if (tokenizer.atEnd()) {
                throw tokenizer.parseException("Expected \"" + endToken + "\".");
            }
            mergeField(tokenizer, extensionRegistry, subBuilder);
        }
        value = subBuilder.build();
        if (field.isRepeated()) {
            builder.addRepeatedField(field, value);
        } else {
            builder.setField(field, value);
        }
    }

    static String escapeBytes(ByteString input) {
        StringBuilder builder = new StringBuilder(input.size());
        for (int i = 0; i < input.size(); i++) {
            byte b = input.byteAt(i);
            switch (b) {
                case SimpleLog.LOG_LEVEL_OFF /*7*/:
                    builder.append("\\a");
                    break;
                case PayPalActivity.VIEW_TEST /*8*/:
                    builder.append("\\b");
                    break;
                case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                    builder.append("\\t");
                    break;
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                    builder.append("\\n");
                    break;
                case PayPal.PAYMENT_SUBTYPE_REMITTANCES /*11*/:
                    builder.append("\\v");
                    break;
                case PayPal.PAYMENT_SUBTYPE_RENT /*12*/:
                    builder.append("\\f");
                    break;
                case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                    builder.append("\\r");
                    break;
                case (byte) 34:
                    builder.append("\\\"");
                    break;
                case (byte) 39:
                    builder.append("\\'");
                    break;
                case (byte) 92:
                    builder.append("\\\\");
                    break;
                default:
                    if (b < 32) {
                        builder.append('\\');
                        builder.append((char) (((b >>> 6) & 3) + 48));
                        builder.append((char) (((b >>> 3) & 7) + 48));
                        builder.append((char) ((b & 7) + 48));
                        break;
                    }
                    builder.append((char) b);
                    break;
            }
        }
        return builder.toString();
    }

    static ByteString unescapeBytes(CharSequence charString) throws InvalidEscapeSequenceException {
        ByteString input = ByteString.copyFromUtf8(charString.toString());
        byte[] result = new byte[input.size()];
        int pos = 0;
        int i = 0;
        while (i < input.size()) {
            byte c = input.byteAt(i);
            int pos2;
            if (c != (byte) 92) {
                pos2 = pos + 1;
                result[pos] = c;
                pos = pos2;
            } else if (i + 1 < input.size()) {
                i++;
                c = input.byteAt(i);
                int code;
                if (isOctal(c)) {
                    code = digitValue(c);
                    if (i + 1 < input.size() && isOctal(input.byteAt(i + 1))) {
                        i++;
                        code = (code * 8) + digitValue(input.byteAt(i));
                    }
                    if (i + 1 < input.size() && isOctal(input.byteAt(i + 1))) {
                        i++;
                        code = (code * 8) + digitValue(input.byteAt(i));
                    }
                    pos2 = pos + 1;
                    result[pos] = (byte) code;
                    pos = pos2;
                } else {
                    switch (c) {
                        case (byte) 34:
                            pos2 = pos + 1;
                            result[pos] = (byte) 34;
                            pos = pos2;
                            break;
                        case (byte) 39:
                            pos2 = pos + 1;
                            result[pos] = (byte) 39;
                            pos = pos2;
                            break;
                        case (byte) 92:
                            pos2 = pos + 1;
                            result[pos] = (byte) 92;
                            pos = pos2;
                            break;
                        case (byte) 97:
                            pos2 = pos + 1;
                            result[pos] = (byte) 7;
                            pos = pos2;
                            break;
                        case (byte) 98:
                            pos2 = pos + 1;
                            result[pos] = (byte) 8;
                            pos = pos2;
                            break;
                        case (byte) 102:
                            pos2 = pos + 1;
                            result[pos] = Ascii.FF;
                            pos = pos2;
                            break;
                        case (byte) 110:
                            pos2 = pos + 1;
                            result[pos] = (byte) 10;
                            pos = pos2;
                            break;
                        case (byte) 114:
                            pos2 = pos + 1;
                            result[pos] = Ascii.CR;
                            pos = pos2;
                            break;
                        case (byte) 116:
                            pos2 = pos + 1;
                            result[pos] = (byte) 9;
                            pos = pos2;
                            break;
                        case (byte) 118:
                            pos2 = pos + 1;
                            result[pos] = Ascii.VT;
                            pos = pos2;
                            break;
                        case (byte) 120:
                            if (i + 1 < input.size() && isHex(input.byteAt(i + 1))) {
                                i++;
                                code = digitValue(input.byteAt(i));
                                if (i + 1 < input.size() && isHex(input.byteAt(i + 1))) {
                                    i++;
                                    code = (code * 16) + digitValue(input.byteAt(i));
                                }
                                pos2 = pos + 1;
                                result[pos] = (byte) code;
                                pos = pos2;
                                break;
                            }
                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                        default:
                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) c) + '\'');
                    }
                }
            } else {
                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
            }
            i++;
        }
        return ByteString.copyFrom(result, 0, pos);
    }

    static String escapeText(String input) {
        return escapeBytes(ByteString.copyFromUtf8(input));
    }

    static String unescapeText(String input) throws InvalidEscapeSequenceException {
        return unescapeBytes(input).toStringUtf8();
    }

    private static boolean isOctal(byte c) {
        return 48 <= c && c <= 55;
    }

    private static boolean isHex(byte c) {
        return (48 <= c && c <= 57) || ((97 <= c && c <= 102) || (65 <= c && c <= 70));
    }

    private static int digitValue(byte c) {
        if (48 <= c && c <= 57) {
            return c - 48;
        }
        if (97 > c || c > 122) {
            return (c - 65) + 10;
        }
        return (c - 97) + 10;
    }

    static int parseInt32(String text) throws NumberFormatException {
        return (int) parseInteger(text, true, false);
    }

    static int parseUInt32(String text) throws NumberFormatException {
        return (int) parseInteger(text, false, false);
    }

    static long parseInt64(String text) throws NumberFormatException {
        return parseInteger(text, true, true);
    }

    static long parseUInt64(String text) throws NumberFormatException {
        return parseInteger(text, false, true);
    }

    private static long parseInteger(String text, boolean isSigned, boolean isLong) throws NumberFormatException {
        int pos = 0;
        boolean negative = false;
        if (text.startsWith("-", 0)) {
            if (isSigned) {
                pos = 0 + 1;
                negative = true;
            } else {
                throw new NumberFormatException("Number must be positive: " + text);
            }
        }
        int radix = 10;
        if (text.startsWith("0x", pos)) {
            pos += 2;
            radix = 16;
        } else if (text.startsWith("0", pos)) {
            radix = 8;
        }
        String numberText = text.substring(pos);
        if (numberText.length() < 16) {
            long result = Long.parseLong(numberText, radix);
            if (negative) {
                result = -result;
            }
            if (isLong) {
                return result;
            }
            if (isSigned) {
                if (result <= 2147483647L && result >= -2147483648L) {
                    return result;
                }
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + text);
            } else if (result < 4294967296L && result >= 0) {
                return result;
            } else {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + text);
            }
        }
        BigInteger bigValue = new BigInteger(numberText, radix);
        if (negative) {
            bigValue = bigValue.negate();
        }
        if (isLong) {
            if (isSigned) {
                if (bigValue.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: " + text);
                }
            } else if (bigValue.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + text);
            }
        } else if (isSigned) {
            if (bigValue.bitLength() > 31) {
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + text);
            }
        } else if (bigValue.bitLength() > 32) {
            throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + text);
        }
        return bigValue.longValue();
    }
}
