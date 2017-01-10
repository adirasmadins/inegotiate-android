package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.gdata.util.common.base.StringUtil;
import org.codehaus.jackson.impl.JsonWriteContext;

@GwtCompatible
public enum CaseFormat {
    LOWER_HYPHEN(CharMatcher.is('-'), "-"),
    LOWER_UNDERSCORE(CharMatcher.is('_'), "_"),
    LOWER_CAMEL(CharMatcher.inRange('A', 'Z'), StringUtil.EMPTY_STRING),
    UPPER_CAMEL(CharMatcher.inRange('A', 'Z'), StringUtil.EMPTY_STRING),
    UPPER_UNDERSCORE(CharMatcher.is('_'), "_");
    
    private final CharMatcher wordBoundary;
    private final String wordSeparator;

    /* renamed from: com.google.common.base.CaseFormat.1 */
    static /* synthetic */ class C03331 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$base$CaseFormat;

        static {
            $SwitchMap$com$google$common$base$CaseFormat = new int[CaseFormat.values().length];
            try {
                $SwitchMap$com$google$common$base$CaseFormat[CaseFormat.LOWER_UNDERSCORE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$common$base$CaseFormat[CaseFormat.UPPER_UNDERSCORE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$common$base$CaseFormat[CaseFormat.LOWER_HYPHEN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$common$base$CaseFormat[CaseFormat.LOWER_CAMEL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$common$base$CaseFormat[CaseFormat.UPPER_CAMEL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private CaseFormat(CharMatcher wordBoundary, String wordSeparator) {
        this.wordBoundary = wordBoundary;
        this.wordSeparator = wordSeparator;
    }

    public String to(CaseFormat format, String s) {
        if (format == null) {
            throw new NullPointerException();
        } else if (s == null) {
            throw new NullPointerException();
        } else if (format == this) {
            return s;
        } else {
            switch (C03331.$SwitchMap$com$google$common$base$CaseFormat[ordinal()]) {
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    switch (C03331.$SwitchMap$com$google$common$base$CaseFormat[format.ordinal()]) {
                        case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                            return Ascii.toUpperCase(s);
                        case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                            return s.replace('_', '-');
                        default:
                            break;
                    }
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                    switch (C03331.$SwitchMap$com$google$common$base$CaseFormat[format.ordinal()]) {
                        case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                            return Ascii.toLowerCase(s);
                        case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                            return Ascii.toLowerCase(s.replace('_', '-'));
                        default:
                            break;
                    }
                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                    switch (C03331.$SwitchMap$com$google$common$base$CaseFormat[format.ordinal()]) {
                        case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                            return s.replace('-', '_');
                        case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                            return Ascii.toUpperCase(s.replace('-', '_'));
                        default:
                            break;
                    }
            }
            StringBuilder out = null;
            int i = 0;
            int j = -1;
            while (true) {
                j = this.wordBoundary.indexIn(s, j + 1);
                if (j != -1) {
                    if (i == 0) {
                        out = new StringBuilder(s.length() + (this.wordSeparator.length() * 4));
                        out.append(format.normalizeFirstWord(s.substring(i, j)));
                    } else {
                        out.append(format.normalizeWord(s.substring(i, j)));
                    }
                    out.append(format.wordSeparator);
                    i = j + this.wordSeparator.length();
                } else if (i == 0) {
                    return format.normalizeFirstWord(s);
                } else {
                    out.append(format.normalizeWord(s.substring(i)));
                    return out.toString();
                }
            }
        }
    }

    private String normalizeFirstWord(String word) {
        switch (C03331.$SwitchMap$com$google$common$base$CaseFormat[ordinal()]) {
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                return Ascii.toLowerCase(word);
            default:
                return normalizeWord(word);
        }
    }

    private String normalizeWord(String word) {
        switch (C03331.$SwitchMap$com$google$common$base$CaseFormat[ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return Ascii.toLowerCase(word);
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return Ascii.toUpperCase(word);
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return Ascii.toLowerCase(word);
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                return firstCharOnlyToUpper(word);
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                return firstCharOnlyToUpper(word);
            default:
                throw new RuntimeException("unknown case: " + this);
        }
    }

    private static String firstCharOnlyToUpper(String word) {
        int length = word.length();
        return length == 0 ? word : Ascii.toUpperCase(word.charAt(0)) + Ascii.toLowerCase(word.substring(1));
    }
}
