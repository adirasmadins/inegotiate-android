package com.google.gdata.util.common.base;

import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.google.protobuf.CodedOutputStream;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class StringUtil {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Set<UnicodeBlock> CJK_BLOCKS;
    private static final CharMatcher CONTROL_MATCHER;
    public static final String EMPTY_STRING = "";
    public static final String LINE_BREAKS = "\r\n";
    private static final String[] UNSAFE_TAGS;
    public static final String WHITE_SPACES = " \r\n\t\u3000\u00a0\u2007\u202f";
    private static final Pattern characterReferencePattern;
    private static final Pattern dbSpecPattern;
    static Map<String, Character> escapeStrings;
    private static char[] hexChars;
    private static final Pattern htmlTagPattern;

    static {
        boolean z;
        if (StringUtil.class.desiredAssertionStatus()) {
            z = $assertionsDisabled;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
        htmlTagPattern = Pattern.compile("</?[a-zA-Z][^>]*>");
        characterReferencePattern = Pattern.compile("&#?[a-zA-Z0-9]{1,8};");
        dbSpecPattern = Pattern.compile("(.*)\\{(\\d+),(\\d+)\\}(.*)");
        escapeStrings = new HashMap(252);
        escapeStrings.put("&nbsp;", new Character('\u00a0'));
        escapeStrings.put("&iexcl;", new Character('\u00a1'));
        escapeStrings.put("&cent;", new Character('\u00a2'));
        escapeStrings.put("&pound;", new Character('\u00a3'));
        escapeStrings.put("&curren;", new Character('\u00a4'));
        escapeStrings.put("&yen;", new Character('\u00a5'));
        escapeStrings.put("&brvbar;", new Character('\u00a6'));
        escapeStrings.put("&sect;", new Character('\u00a7'));
        escapeStrings.put("&uml;", new Character('\u00a8'));
        escapeStrings.put("&copy;", new Character('\u00a9'));
        escapeStrings.put("&ordf;", new Character('\u00aa'));
        escapeStrings.put("&laquo;", new Character('\u00ab'));
        escapeStrings.put("&not;", new Character('\u00ac'));
        escapeStrings.put("&shy;", new Character('\u00ad'));
        escapeStrings.put("&reg;", new Character('\u00ae'));
        escapeStrings.put("&macr;", new Character('\u00af'));
        escapeStrings.put("&deg;", new Character('\u00b0'));
        escapeStrings.put("&plusmn;", new Character('\u00b1'));
        escapeStrings.put("&sup2;", new Character('\u00b2'));
        escapeStrings.put("&sup3;", new Character('\u00b3'));
        escapeStrings.put("&acute;", new Character('\u00b4'));
        escapeStrings.put("&micro;", new Character('\u00b5'));
        escapeStrings.put("&para;", new Character('\u00b6'));
        escapeStrings.put("&middot;", new Character('\u00b7'));
        escapeStrings.put("&cedil;", new Character('\u00b8'));
        escapeStrings.put("&sup1;", new Character('\u00b9'));
        escapeStrings.put("&ordm;", new Character('\u00ba'));
        escapeStrings.put("&raquo;", new Character('\u00bb'));
        escapeStrings.put("&frac14;", new Character('\u00bc'));
        escapeStrings.put("&frac12;", new Character('\u00bd'));
        escapeStrings.put("&frac34;", new Character('\u00be'));
        escapeStrings.put("&iquest;", new Character('\u00bf'));
        escapeStrings.put("&Agrave;", new Character('\u00c0'));
        escapeStrings.put("&Aacute;", new Character('\u00c1'));
        escapeStrings.put("&Acirc;", new Character('\u00c2'));
        escapeStrings.put("&Atilde;", new Character('\u00c3'));
        escapeStrings.put("&Auml;", new Character('\u00c4'));
        escapeStrings.put("&Aring;", new Character('\u00c5'));
        escapeStrings.put("&AElig;", new Character('\u00c6'));
        escapeStrings.put("&Ccedil;", new Character('\u00c7'));
        escapeStrings.put("&Egrave;", new Character('\u00c8'));
        escapeStrings.put("&Eacute;", new Character('\u00c9'));
        escapeStrings.put("&Ecirc;", new Character('\u00ca'));
        escapeStrings.put("&Euml;", new Character('\u00cb'));
        escapeStrings.put("&Igrave;", new Character('\u00cc'));
        escapeStrings.put("&Iacute;", new Character('\u00cd'));
        escapeStrings.put("&Icirc;", new Character('\u00ce'));
        escapeStrings.put("&Iuml;", new Character('\u00cf'));
        escapeStrings.put("&ETH;", new Character('\u00d0'));
        escapeStrings.put("&Ntilde;", new Character('\u00d1'));
        escapeStrings.put("&Ograve;", new Character('\u00d2'));
        escapeStrings.put("&Oacute;", new Character('\u00d3'));
        escapeStrings.put("&Ocirc;", new Character('\u00d4'));
        escapeStrings.put("&Otilde;", new Character('\u00d5'));
        escapeStrings.put("&Ouml;", new Character('\u00d6'));
        escapeStrings.put("&times;", new Character('\u00d7'));
        escapeStrings.put("&Oslash;", new Character('\u00d8'));
        escapeStrings.put("&Ugrave;", new Character('\u00d9'));
        escapeStrings.put("&Uacute;", new Character('\u00da'));
        escapeStrings.put("&Ucirc;", new Character('\u00db'));
        escapeStrings.put("&Uuml;", new Character('\u00dc'));
        escapeStrings.put("&Yacute;", new Character('\u00dd'));
        escapeStrings.put("&THORN;", new Character('\u00de'));
        escapeStrings.put("&szlig;", new Character('\u00df'));
        escapeStrings.put("&agrave;", new Character('\u00e0'));
        escapeStrings.put("&aacute;", new Character('\u00e1'));
        escapeStrings.put("&acirc;", new Character('\u00e2'));
        escapeStrings.put("&atilde;", new Character('\u00e3'));
        escapeStrings.put("&auml;", new Character('\u00e4'));
        escapeStrings.put("&aring;", new Character('\u00e5'));
        escapeStrings.put("&aelig;", new Character('\u00e6'));
        escapeStrings.put("&ccedil;", new Character('\u00e7'));
        escapeStrings.put("&egrave;", new Character('\u00e8'));
        escapeStrings.put("&eacute;", new Character('\u00e9'));
        escapeStrings.put("&ecirc;", new Character('\u00ea'));
        escapeStrings.put("&euml;", new Character('\u00eb'));
        escapeStrings.put("&igrave;", new Character('\u00ec'));
        escapeStrings.put("&iacute;", new Character('\u00ed'));
        escapeStrings.put("&icirc;", new Character('\u00ee'));
        escapeStrings.put("&iuml;", new Character('\u00ef'));
        escapeStrings.put("&eth;", new Character('\u00f0'));
        escapeStrings.put("&ntilde;", new Character('\u00f1'));
        escapeStrings.put("&ograve;", new Character('\u00f2'));
        escapeStrings.put("&oacute;", new Character('\u00f3'));
        escapeStrings.put("&ocirc;", new Character('\u00f4'));
        escapeStrings.put("&otilde;", new Character('\u00f5'));
        escapeStrings.put("&ouml;", new Character('\u00f6'));
        escapeStrings.put("&divide;", new Character('\u00f7'));
        escapeStrings.put("&oslash;", new Character('\u00f8'));
        escapeStrings.put("&ugrave;", new Character('\u00f9'));
        escapeStrings.put("&uacute;", new Character('\u00fa'));
        escapeStrings.put("&ucirc;", new Character('\u00fb'));
        escapeStrings.put("&uuml;", new Character('\u00fc'));
        escapeStrings.put("&yacute;", new Character('\u00fd'));
        escapeStrings.put("&thorn;", new Character('\u00fe'));
        escapeStrings.put("&yuml;", new Character('\u00ff'));
        escapeStrings.put("&fnof;", new Character('\u0192'));
        escapeStrings.put("&Alpha;", new Character('\u0391'));
        escapeStrings.put("&Beta;", new Character('\u0392'));
        escapeStrings.put("&Gamma;", new Character('\u0393'));
        escapeStrings.put("&Delta;", new Character('\u0394'));
        escapeStrings.put("&Epsilon;", new Character('\u0395'));
        escapeStrings.put("&Zeta;", new Character('\u0396'));
        escapeStrings.put("&Eta;", new Character('\u0397'));
        escapeStrings.put("&Theta;", new Character('\u0398'));
        escapeStrings.put("&Iota;", new Character('\u0399'));
        escapeStrings.put("&Kappa;", new Character('\u039a'));
        escapeStrings.put("&Lambda;", new Character('\u039b'));
        escapeStrings.put("&Mu;", new Character('\u039c'));
        escapeStrings.put("&Nu;", new Character('\u039d'));
        escapeStrings.put("&Xi;", new Character('\u039e'));
        escapeStrings.put("&Omicron;", new Character('\u039f'));
        escapeStrings.put("&Pi;", new Character('\u03a0'));
        escapeStrings.put("&Rho;", new Character('\u03a1'));
        escapeStrings.put("&Sigma;", new Character('\u03a3'));
        escapeStrings.put("&Tau;", new Character('\u03a4'));
        escapeStrings.put("&Upsilon;", new Character('\u03a5'));
        escapeStrings.put("&Phi;", new Character('\u03a6'));
        escapeStrings.put("&Chi;", new Character('\u03a7'));
        escapeStrings.put("&Psi;", new Character('\u03a8'));
        escapeStrings.put("&Omega;", new Character('\u03a9'));
        escapeStrings.put("&alpha;", new Character('\u03b1'));
        escapeStrings.put("&beta;", new Character('\u03b2'));
        escapeStrings.put("&gamma;", new Character('\u03b3'));
        escapeStrings.put("&delta;", new Character('\u03b4'));
        escapeStrings.put("&epsilon;", new Character('\u03b5'));
        escapeStrings.put("&zeta;", new Character('\u03b6'));
        escapeStrings.put("&eta;", new Character('\u03b7'));
        escapeStrings.put("&theta;", new Character('\u03b8'));
        escapeStrings.put("&iota;", new Character('\u03b9'));
        escapeStrings.put("&kappa;", new Character('\u03ba'));
        escapeStrings.put("&lambda;", new Character('\u03bb'));
        escapeStrings.put("&mu;", new Character('\u03bc'));
        escapeStrings.put("&nu;", new Character('\u03bd'));
        escapeStrings.put("&xi;", new Character('\u03be'));
        escapeStrings.put("&omicron;", new Character('\u03bf'));
        escapeStrings.put("&pi;", new Character('\u03c0'));
        escapeStrings.put("&rho;", new Character('\u03c1'));
        escapeStrings.put("&sigmaf;", new Character('\u03c2'));
        escapeStrings.put("&sigma;", new Character('\u03c3'));
        escapeStrings.put("&tau;", new Character('\u03c4'));
        escapeStrings.put("&upsilon;", new Character('\u03c5'));
        escapeStrings.put("&phi;", new Character('\u03c6'));
        escapeStrings.put("&chi;", new Character('\u03c7'));
        escapeStrings.put("&psi;", new Character('\u03c8'));
        escapeStrings.put("&omega;", new Character('\u03c9'));
        escapeStrings.put("&thetasym;", new Character('\u03d1'));
        escapeStrings.put("&upsih;", new Character('\u03d2'));
        escapeStrings.put("&piv;", new Character('\u03d6'));
        escapeStrings.put("&bull;", new Character('\u2022'));
        escapeStrings.put("&hellip;", new Character('\u2026'));
        escapeStrings.put("&prime;", new Character('\u2032'));
        escapeStrings.put("&Prime;", new Character('\u2033'));
        escapeStrings.put("&oline;", new Character('\u203e'));
        escapeStrings.put("&frasl;", new Character('\u2044'));
        escapeStrings.put("&weierp;", new Character('\u2118'));
        escapeStrings.put("&image;", new Character('\u2111'));
        escapeStrings.put("&real;", new Character('\u211c'));
        escapeStrings.put("&trade;", new Character('\u2122'));
        escapeStrings.put("&alefsym;", new Character('\u2135'));
        escapeStrings.put("&larr;", new Character('\u2190'));
        escapeStrings.put("&uarr;", new Character('\u2191'));
        escapeStrings.put("&rarr;", new Character('\u2192'));
        escapeStrings.put("&darr;", new Character('\u2193'));
        escapeStrings.put("&harr;", new Character('\u2194'));
        escapeStrings.put("&crarr;", new Character('\u21b5'));
        escapeStrings.put("&lArr;", new Character('\u21d0'));
        escapeStrings.put("&uArr;", new Character('\u21d1'));
        escapeStrings.put("&rArr;", new Character('\u21d2'));
        escapeStrings.put("&dArr;", new Character('\u21d3'));
        escapeStrings.put("&hArr;", new Character('\u21d4'));
        escapeStrings.put("&forall;", new Character('\u2200'));
        escapeStrings.put("&part;", new Character('\u2202'));
        escapeStrings.put("&exist;", new Character('\u2203'));
        escapeStrings.put("&empty;", new Character('\u2205'));
        escapeStrings.put("&nabla;", new Character('\u2207'));
        escapeStrings.put("&isin;", new Character('\u2208'));
        escapeStrings.put("&notin;", new Character('\u2209'));
        escapeStrings.put("&ni;", new Character('\u220b'));
        escapeStrings.put("&prod;", new Character('\u220f'));
        escapeStrings.put("&sum;", new Character('\u2211'));
        escapeStrings.put("&minus;", new Character('\u2212'));
        escapeStrings.put("&lowast;", new Character('\u2217'));
        escapeStrings.put("&radic;", new Character('\u221a'));
        escapeStrings.put("&prop;", new Character('\u221d'));
        escapeStrings.put("&infin;", new Character('\u221e'));
        escapeStrings.put("&ang;", new Character('\u2220'));
        escapeStrings.put("&and;", new Character('\u2227'));
        escapeStrings.put("&or;", new Character('\u2228'));
        escapeStrings.put("&cap;", new Character('\u2229'));
        escapeStrings.put("&cup;", new Character('\u222a'));
        escapeStrings.put("&int;", new Character('\u222b'));
        escapeStrings.put("&there4;", new Character('\u2234'));
        escapeStrings.put("&sim;", new Character('\u223c'));
        escapeStrings.put("&cong;", new Character('\u2245'));
        escapeStrings.put("&asymp;", new Character('\u2248'));
        escapeStrings.put("&ne;", new Character('\u2260'));
        escapeStrings.put("&equiv;", new Character('\u2261'));
        escapeStrings.put("&le;", new Character('\u2264'));
        escapeStrings.put("&ge;", new Character('\u2265'));
        escapeStrings.put("&sub;", new Character('\u2282'));
        escapeStrings.put("&sup;", new Character('\u2283'));
        escapeStrings.put("&nsub;", new Character('\u2284'));
        escapeStrings.put("&sube;", new Character('\u2286'));
        escapeStrings.put("&supe;", new Character('\u2287'));
        escapeStrings.put("&oplus;", new Character('\u2295'));
        escapeStrings.put("&otimes;", new Character('\u2297'));
        escapeStrings.put("&perp;", new Character('\u22a5'));
        escapeStrings.put("&sdot;", new Character('\u22c5'));
        escapeStrings.put("&lceil;", new Character('\u2308'));
        escapeStrings.put("&rceil;", new Character('\u2309'));
        escapeStrings.put("&lfloor;", new Character('\u230a'));
        escapeStrings.put("&rfloor;", new Character('\u230b'));
        escapeStrings.put("&lang;", new Character('\u2329'));
        escapeStrings.put("&rang;", new Character('\u232a'));
        escapeStrings.put("&loz;", new Character('\u25ca'));
        escapeStrings.put("&spades;", new Character('\u2660'));
        escapeStrings.put("&clubs;", new Character('\u2663'));
        escapeStrings.put("&hearts;", new Character('\u2665'));
        escapeStrings.put("&diams;", new Character('\u2666'));
        escapeStrings.put("&quot;", new Character('\"'));
        escapeStrings.put("&amp;", new Character('&'));
        escapeStrings.put("&lt;", new Character(XMLStreamWriterImpl.OPEN_START_TAG));
        escapeStrings.put("&gt;", new Character(XMLStreamWriterImpl.CLOSE_START_TAG));
        escapeStrings.put("&OElig;", new Character('\u0152'));
        escapeStrings.put("&oelig;", new Character('\u0153'));
        escapeStrings.put("&Scaron;", new Character('\u0160'));
        escapeStrings.put("&scaron;", new Character('\u0161'));
        escapeStrings.put("&Yuml;", new Character('\u0178'));
        escapeStrings.put("&circ;", new Character('\u02c6'));
        escapeStrings.put("&tilde;", new Character('\u02dc'));
        escapeStrings.put("&ensp;", new Character('\u2002'));
        escapeStrings.put("&emsp;", new Character('\u2003'));
        escapeStrings.put("&thinsp;", new Character('\u2009'));
        escapeStrings.put("&zwnj;", new Character('\u200c'));
        escapeStrings.put("&zwj;", new Character('\u200d'));
        escapeStrings.put("&lrm;", new Character('\u200e'));
        escapeStrings.put("&rlm;", new Character('\u200f'));
        escapeStrings.put("&ndash;", new Character('\u2013'));
        escapeStrings.put("&mdash;", new Character('\u2014'));
        escapeStrings.put("&lsquo;", new Character('\u2018'));
        escapeStrings.put("&rsquo;", new Character('\u2019'));
        escapeStrings.put("&sbquo;", new Character('\u201a'));
        escapeStrings.put("&ldquo;", new Character('\u201c'));
        escapeStrings.put("&rdquo;", new Character('\u201d'));
        escapeStrings.put("&bdquo;", new Character('\u201e'));
        escapeStrings.put("&dagger;", new Character('\u2020'));
        escapeStrings.put("&Dagger;", new Character('\u2021'));
        escapeStrings.put("&permil;", new Character('\u2030'));
        escapeStrings.put("&lsaquo;", new Character('\u2039'));
        escapeStrings.put("&rsaquo;", new Character('\u203a'));
        escapeStrings.put("&euro;", new Character('\u20ac'));
        UNSAFE_TAGS = new String[]{"script", "style", "object", "applet", "!--"};
        CONTROL_MATCHER = CharMatcher.anyOf("\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\u000b\f\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f\ufffe\uffff");
        Set<UnicodeBlock> set = new HashSet();
        set.add(UnicodeBlock.HANGUL_JAMO);
        set.add(UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
        set.add(UnicodeBlock.KANGXI_RADICALS);
        set.add(UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
        set.add(UnicodeBlock.HIRAGANA);
        set.add(UnicodeBlock.KATAKANA);
        set.add(UnicodeBlock.BOPOMOFO);
        set.add(UnicodeBlock.HANGUL_COMPATIBILITY_JAMO);
        set.add(UnicodeBlock.KANBUN);
        set.add(UnicodeBlock.BOPOMOFO_EXTENDED);
        set.add(UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
        set.add(UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS);
        set.add(UnicodeBlock.CJK_COMPATIBILITY);
        set.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
        set.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
        set.add(UnicodeBlock.HANGUL_SYLLABLES);
        set.add(UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
        set.add(UnicodeBlock.CJK_COMPATIBILITY_FORMS);
        set.add(UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
        set.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
        set.add(UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
        CJK_BLOCKS = Collections.unmodifiableSet(set);
        hexChars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    private StringUtil() {
    }

    public static String[] split(String str, String delims) {
        return split(str, delims, $assertionsDisabled);
    }

    public static String[] split(String str, String delims, boolean trimTokens) {
        StringTokenizer tokenizer = new StringTokenizer(str, delims);
        int n = tokenizer.countTokens();
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            if (trimTokens) {
                list[i] = tokenizer.nextToken().trim();
            } else {
                list[i] = tokenizer.nextToken();
            }
        }
        return list;
    }

    public static String[] splitAndTrim(String str, String delims) {
        return split(str, delims, true);
    }

    public static int[] splitInts(String str) throws IllegalArgumentException {
        StringTokenizer tokenizer = new StringTokenizer(str, ",");
        int n = tokenizer.countTokens();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(tokenizer.nextToken());
        }
        return list;
    }

    public static long[] splitLongs(String str) throws IllegalArgumentException {
        StringTokenizer tokenizer = new StringTokenizer(str, ",");
        int n = tokenizer.countTokens();
        long[] list = new long[n];
        for (int i = 0; i < n; i++) {
            list[i] = Long.parseLong(tokenizer.nextToken());
        }
        return list;
    }

    public static String joinInts(int[] tokens, String delimiter) {
        if (tokens == null) {
            return EMPTY_STRING;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            if (i > 0 && delimiter != null) {
                result.append(delimiter);
            }
            result.append(String.valueOf(tokens[i]));
        }
        return result.toString();
    }

    public static String joinLongs(long[] tokens, String delimiter) {
        if (tokens == null) {
            return EMPTY_STRING;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            if (i > 0 && delimiter != null) {
                result.append(delimiter);
            }
            result.append(String.valueOf(tokens[i]));
        }
        return result.toString();
    }

    @Deprecated
    public static String join(Object[] tokens, String delimiter) {
        if (tokens == null || tokens.length == 0) {
            return EMPTY_STRING;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            if (i > 0 && delimiter != null) {
                result.append(delimiter);
            }
            if (tokens[i] != null) {
                result.append(tokens[i].toString());
            }
        }
        return result.toString();
    }

    @Deprecated
    public static String join(Collection tokens, String delimiter) {
        return join(tokens.toArray(), delimiter);
    }

    @Deprecated
    public static String replace(String str, String what, String with) {
        if ($assertionsDisabled || what.length() > 0) {
            return str.replace(what, with);
        }
        throw new AssertionError();
    }

    public static String fixedWidth(String str, int width) {
        return fixedWidth(split(str, "\n"), width);
    }

    public static String fixedWidth(String[] lines, int width) {
        StringBuilder formatStr = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            int curWidth = 0;
            if (i != 0) {
                formatStr.append("\n");
            }
            if (lines[i].length() <= width) {
                formatStr.append(lines[i]);
            } else {
                String[] words = splitAndTrim(lines[i], WHITE_SPACES);
                int j = 0;
                while (j < words.length) {
                    if (curWidth == 0 || words[j].length() + curWidth < width) {
                        if (curWidth != 0) {
                            formatStr.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                            curWidth++;
                        }
                        curWidth += words[j].length();
                        formatStr.append(words[j]);
                    } else {
                        formatStr.append("\n");
                        curWidth = words[j].length();
                        formatStr.append(words[j]);
                    }
                    j++;
                }
            }
        }
        return formatStr.toString();
    }

    public static String insertBreakingWhitespace(int lineLen, String original) {
        if (original == null || lineLen <= 0) {
            throw new IllegalArgumentException();
        }
        int length = original.length();
        if (length <= lineLen) {
            return original;
        }
        int currPos = 0;
        StringBuilder retval = new StringBuilder();
        while (length - currPos > lineLen) {
            retval.append(original.substring(currPos, currPos + lineLen));
            currPos += lineLen;
            retval.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        }
        retval.append(original.substring(currPos, length));
        return retval.toString();
    }

    public static String indent(String iString, int iIndentDepth) {
        StringBuilder spacer = new StringBuilder();
        spacer.append("\n");
        for (int i = 0; i < iIndentDepth; i++) {
            spacer.append("  ");
        }
        return replace(iString, "\n", spacer.toString());
    }

    @Deprecated
    public static String megastrip(String str, boolean left, boolean right, String what) {
        if (str == null) {
            return null;
        }
        int limitLeft = 0;
        int limitRight = str.length() - 1;
        while (left && limitLeft <= limitRight && what.indexOf(str.charAt(limitLeft)) >= 0) {
            limitLeft++;
        }
        while (right && limitRight >= limitLeft && what.indexOf(str.charAt(limitRight)) >= 0) {
            limitRight--;
        }
        return str.substring(limitLeft, limitRight + 1);
    }

    @Deprecated
    public static String lstrip(String str) {
        return str == null ? null : CharMatcher.LEGACY_WHITESPACE.trimLeadingFrom(str);
    }

    @Deprecated
    public static String rstrip(String str) {
        return str == null ? null : CharMatcher.LEGACY_WHITESPACE.trimTrailingFrom(str);
    }

    public static String strip(String str) {
        return megastrip(str, true, true, WHITE_SPACES);
    }

    public static String stripAndCollapse(String str) {
        return collapseWhitespace(strip(str));
    }

    public static String stripPrefix(String str, String prefix) {
        return str.startsWith(prefix) ? str.substring(prefix.length()) : null;
    }

    public static String stripPrefixIgnoreCase(String str, String prefix) {
        if (str.length() < prefix.length() || !str.substring(0, prefix.length()).equalsIgnoreCase(prefix)) {
            return null;
        }
        return str.substring(prefix.length());
    }

    public static String stripNonDigits(String str) {
        StringBuffer result = new StringBuffer(str.length());
        for (char candidate : str.toCharArray()) {
            if (Character.isDigit(candidate)) {
                result.append(candidate);
            }
        }
        return result.toString();
    }

    public static int numSharedChars(String str, String chars) {
        if (str == null || chars == null) {
            return 0;
        }
        int total = 0;
        int pos = -1;
        while (true) {
            pos = indexOfChars(str, chars, pos + 1);
            if (pos == -1) {
                return total;
            }
            total++;
        }
    }

    public static int indexOfChars(String str, String chars, int fromIndex) {
        int len = str.length();
        for (int pos = fromIndex; pos < len; pos++) {
            if (chars.indexOf(str.charAt(pos)) >= 0) {
                return pos;
            }
        }
        return -1;
    }

    public static int indexOfChars(String str, String chars) {
        return indexOfChars(str, chars, 0);
    }

    public static int lastIndexNotOf(String str, String chars, int fromIndex) {
        for (int pos = Math.min(fromIndex, str.length() - 1); pos >= 0; pos--) {
            if (chars.indexOf(str.charAt(pos)) < 0) {
                return pos;
            }
        }
        return -1;
    }

    public static String replaceChars(String str, String oldchars, char newchar) {
        int pos = indexOfChars(str, oldchars);
        if (pos == -1) {
            return str;
        }
        StringBuilder buf = new StringBuilder(str);
        do {
            buf.setCharAt(pos, newchar);
            pos = indexOfChars(str, oldchars, pos + 1);
        } while (pos != -1);
        return buf.toString();
    }

    public static String removeChars(String str, String oldchars) {
        int pos = indexOfChars(str, oldchars);
        if (pos == -1) {
            return str;
        }
        StringBuilder buf = new StringBuilder();
        int start = 0;
        do {
            buf.append(str.substring(start, pos));
            start = pos + 1;
            pos = indexOfChars(str, oldchars, start);
        } while (pos != -1);
        if (start < str.length()) {
            buf.append(str.substring(start));
        }
        return buf.toString();
    }

    public static String retainAllChars(String str, String retainChars) {
        int pos = indexOfChars(str, retainChars);
        if (pos == -1) {
            return EMPTY_STRING;
        }
        StringBuilder buf = new StringBuilder();
        do {
            buf.append(str.charAt(pos));
            pos = indexOfChars(str, retainChars, pos + 1);
        } while (pos != -1);
        return buf.toString();
    }

    public static String replaceSmartQuotes(String str) {
        return replaceChars(replaceChars(str, "\u0091\u0092\u2018\u2019", '\''), "\u0093\u0094\u201c\u201d", '\"');
    }

    public static byte[] hexToBytes(String str) {
        byte[] bytes = new byte[((str.length() + 1) / 2)];
        if (str.length() != 0) {
            bytes[0] = (byte) 0;
            int nibbleIdx = str.length() % 2;
            int i = 0;
            while (i < str.length()) {
                char c = str.charAt(i);
                if (isHex(c)) {
                    if (nibbleIdx % 2 == 0) {
                        bytes[nibbleIdx >> 1] = (byte) (hexValue(c) << 4);
                    } else {
                        int i2 = nibbleIdx >> 1;
                        bytes[i2] = (byte) (bytes[i2] + ((byte) hexValue(c)));
                    }
                    nibbleIdx++;
                    i++;
                } else {
                    throw new IllegalArgumentException("string contains non-hex chars");
                }
            }
        }
        return bytes;
    }

    public static String convertEOLToLF(String input) {
        StringBuilder res = new StringBuilder(input.length());
        char[] s = input.toCharArray();
        int from = 0;
        int end = s.length;
        int i = 0;
        while (i < end) {
            if (s[i] == '\r') {
                res.append(s, from, i - from);
                res.append('\n');
                if (i + 1 < end && s[i + 1] == '\n') {
                    i++;
                }
                from = i + 1;
            }
            i++;
        }
        if (from == 0) {
            return input;
        }
        res.append(s, from, end - from);
        return res.toString();
    }

    @Deprecated
    public static String convertEOLToCRLF(String input) {
        return input.replaceAll("(\r\n|\r|\n)", LINE_BREAKS);
    }

    public static String padLeft(String s, int len, char pad_ch) {
        if (s.length() >= len) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = len - s.length();
        for (int i = 0; i < n; i++) {
            sb.append(pad_ch);
        }
        sb.append(s);
        return sb.toString();
    }

    public static String padRight(String s, int len, char pad_ch) {
        if (s.length() >= len) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = len - s.length();
        sb.append(s);
        for (int i = 0; i < n; i++) {
            sb.append(pad_ch);
        }
        return sb.toString();
    }

    public static String maskLeft(String s, int len, char mask_ch) {
        if (len <= 0) {
            return s;
        }
        len = Math.min(len, s.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(mask_ch);
        }
        sb.append(s.substring(len));
        return sb.toString();
    }

    public static String maskRight(String s, int len, char mask_ch) {
        if (len <= 0) {
            return s;
        }
        len = Math.min(len, s.length());
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, s.length() - len));
        for (int i = 0; i < len; i++) {
            sb.append(mask_ch);
        }
        return sb.toString();
    }

    private static boolean isOctal(char c) {
        return (c < '0' || c > '7') ? $assertionsDisabled : true;
    }

    private static boolean isHex(char c) {
        return ((c < '0' || c > '9') && ((c < 'a' || c > 'f') && (c < 'A' || c > 'F'))) ? $assertionsDisabled : true;
    }

    private static int hexValue(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c < 'a' || c > 'f') {
            return (c - 65) + 10;
        }
        return (c - 97) + 10;
    }

    public static String unescapeCString(String s) {
        if (s.indexOf(92) < 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int i = 0;
        while (i < len) {
            int i2 = i + 1;
            char c = s.charAt(i);
            if (c == '\\' && i2 < len) {
                i = i2 + 1;
                c = s.charAt(i2);
                switch (c) {
                    case '\"':
                        c = '\"';
                        i2 = i;
                        break;
                    case '\'':
                        c = '\'';
                        i2 = i;
                        break;
                    case '?':
                        c = '?';
                        i2 = i;
                        break;
                    case '\\':
                        c = '\\';
                        i2 = i;
                        break;
                    case 'a':
                        c = '\u0007';
                        i2 = i;
                        break;
                    case 'b':
                        c = '\b';
                        i2 = i;
                        break;
                    case 'f':
                        c = '\f';
                        i2 = i;
                        break;
                    case 'n':
                        c = '\n';
                        i2 = i;
                        break;
                    case 'r':
                        c = '\r';
                        i2 = i;
                        break;
                    case 't':
                        c = '\t';
                        i2 = i;
                        break;
                    case 'v':
                        c = '\u000b';
                        i2 = i;
                        break;
                    default:
                        int v;
                        if (c != 'x' || i >= len || !isHex(s.charAt(i))) {
                            if (!isOctal(c)) {
                                sb.append('\\');
                                i2 = i;
                                break;
                            }
                            v = c - 48;
                            if (i < len && isOctal(s.charAt(i))) {
                                v = (v * 8) + (s.charAt(i) - 48);
                                i++;
                            }
                            if (i >= len || !isOctal(s.charAt(i))) {
                                i2 = i;
                            } else {
                                i2 = i + 1;
                                v = (v * 8) + (s.charAt(i) - 48);
                            }
                            c = (char) v;
                            break;
                        }
                        i2 = i + 1;
                        v = hexValue(s.charAt(i));
                        if (i2 < len && isHex(s.charAt(i2))) {
                            v = (v * 16) + hexValue(s.charAt(i2));
                            i2++;
                        }
                        c = (char) v;
                        break;
                        break;
                }
            }
            sb.append(c);
            i = i2;
        }
        return sb.toString();
    }

    public static String unescapeMySQLString(String s) throws IllegalArgumentException {
        char[] chars = s.toCharArray();
        if (chars.length >= 2 && chars[0] == chars[chars.length - 1] && (chars[0] == '\'' || chars[0] == '\"')) {
            int j = 1;
            int f = 0;
            for (int i = 1; i < chars.length - 1; i++) {
                int j2;
                if (f == 0) {
                    if (chars[i] == '\\') {
                        f = 1;
                    } else if (chars[i] == chars[0]) {
                        f = 2;
                    } else {
                        j2 = j + 1;
                        chars[j] = chars[i];
                        j = j2;
                    }
                } else if (f == 1) {
                    switch (chars[i]) {
                        case '\"':
                            j2 = j + 1;
                            chars[j] = '\"';
                            j = j2;
                            break;
                        case '\'':
                            j2 = j + 1;
                            chars[j] = '\'';
                            j = j2;
                            break;
                        case '0':
                            j2 = j + 1;
                            chars[j] = '\u0000';
                            j = j2;
                            break;
                        case '\\':
                            j2 = j + 1;
                            chars[j] = '\\';
                            j = j2;
                            break;
                        case 'b':
                            j2 = j + 1;
                            chars[j] = '\b';
                            j = j2;
                            break;
                        case 'n':
                            j2 = j + 1;
                            chars[j] = '\n';
                            j = j2;
                            break;
                        case 'r':
                            j2 = j + 1;
                            chars[j] = '\r';
                            j = j2;
                            break;
                        case 't':
                            j2 = j + 1;
                            chars[j] = '\t';
                            j = j2;
                            break;
                        case 'z':
                            j2 = j + 1;
                            chars[j] = '\u001a';
                            j = j2;
                            break;
                        default:
                            j2 = j + 1;
                            chars[j] = chars[i];
                            j = j2;
                            break;
                    }
                    f = 0;
                } else if (chars[i] != chars[0]) {
                    throw new IllegalArgumentException("not a valid MySQL string: " + s);
                } else {
                    j2 = j + 1;
                    chars[j] = chars[0];
                    f = 0;
                    j = j2;
                }
            }
            if (f == 0) {
                return new String(chars, 1, j - 1);
            }
            throw new IllegalArgumentException("not a valid MySQL string: " + s);
        }
        throw new IllegalArgumentException("not a valid MySQL string: " + s);
    }

    public static final String unescapeHTML(String s) {
        char[] chars = s.toCharArray();
        char[] escaped = new char[chars.length];
        int pos = 0;
        int i = 0;
        while (i < chars.length) {
            int pos2;
            if (chars[i] != '&') {
                pos2 = pos + 1;
                int i2 = i + 1;
                escaped[pos] = chars[i];
                i = i2;
                pos = pos2;
            } else {
                int j = i + 1;
                if (j < chars.length && chars[j] == '#') {
                    j++;
                }
                while (j < chars.length && Character.isLetterOrDigit(chars[j])) {
                    j++;
                }
                boolean replaced = $assertionsDisabled;
                if (j < chars.length && chars[j] == ';') {
                    if (s.charAt(i + 1) == '#') {
                        long charcode = 0;
                        try {
                            char ch = s.charAt(i + 2);
                            if (ch == 'x' || ch == 'X') {
                                charcode = Long.parseLong(new String(chars, i + 3, (j - i) - 3), 16);
                            } else if (Character.isDigit(ch)) {
                                charcode = Long.parseLong(new String(chars, i + 2, (j - i) - 2));
                            }
                            if (charcode > 0 && charcode < 65536) {
                                pos2 = pos + 1;
                                try {
                                    escaped[pos] = (char) ((int) charcode);
                                    replaced = true;
                                    pos = pos2;
                                } catch (NumberFormatException e) {
                                    pos = pos2;
                                }
                            }
                        } catch (NumberFormatException e2) {
                        }
                    } else {
                        Character repl = (Character) escapeStrings.get(new String(chars, i, (j - i) + 1));
                        if (repl != null) {
                            pos2 = pos + 1;
                            escaped[pos] = repl.charValue();
                            replaced = true;
                            pos = pos2;
                        }
                    }
                    j++;
                }
                if (!replaced) {
                    System.arraycopy(chars, i, escaped, pos, j - i);
                    pos += j - i;
                }
                i = j;
            }
        }
        return new String(escaped, 0, pos);
    }

    public static String stripHtmlTags(String string) {
        return (string == null || EMPTY_STRING.equals(string)) ? string : htmlTagPattern.matcher(string).replaceAll(EMPTY_STRING);
    }

    public static String pythonEscape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                    sb.append("\\t");
                    break;
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                    sb.append("\\n");
                    break;
                case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                    sb.append("\\r");
                    break;
                case '\"':
                    sb.append("\\\"");
                    break;
                case '\'':
                    sb.append("\\'");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    public static String javaScriptEscape(String s) {
        return javaScriptEscapeHelper(s, $assertionsDisabled);
    }

    public static String javaScriptEscapeToAscii(String s) {
        return javaScriptEscapeHelper(s, true);
    }

    private static String javaScriptEscapeHelper(String s, boolean escapeToAscii) {
        StringBuilder sb = new StringBuilder((s.length() * 9) / 8);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                    sb.append("\\t");
                    break;
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                    sb.append("\\n");
                    break;
                case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                    sb.append("\\r");
                    break;
                case '\"':
                    sb.append("\\\"");
                    break;
                case '\'':
                    sb.append("\\'");
                    break;
                case '/':
                case '<':
                    boolean isUnsafe = $assertionsDisabled;
                    for (String tag : UNSAFE_TAGS) {
                        if (s.regionMatches(true, i + 1, tag, 0, tag.length())) {
                            isUnsafe = true;
                            if (isUnsafe) {
                                appendHexJavaScriptRepresentation(sb, c);
                                break;
                            }
                            sb.append(c);
                            break;
                        }
                    }
                    if (isUnsafe) {
                        appendHexJavaScriptRepresentation(sb, c);
                    } else {
                        sb.append(c);
                    }
                case '=':
                    appendHexJavaScriptRepresentation(sb, c);
                    break;
                case '>':
                    if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
                        sb.append('\\');
                    }
                    sb.append(c);
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\u2028':
                    sb.append("\\u2028");
                    break;
                case '\u2029':
                    sb.append("\\u2029");
                    break;
                default:
                    if (c >= '\u0080' && escapeToAscii) {
                        appendHexJavaScriptRepresentation(sb, c);
                        break;
                    }
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    public static void appendHexJavaScriptRepresentation(StringBuilder sb, char c) {
        sb.append("\\u");
        String val = Integer.toHexString(c);
        for (int j = val.length(); j < 4; j++) {
            sb.append('0');
        }
        sb.append(val);
    }

    public static String javaScriptUnescape(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '\\') {
                i = javaScriptUnescapeHelper(s, i + 1, sb);
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

    private static int javaScriptUnescapeHelper(String s, int i, StringBuilder sb) {
        if (i >= s.length()) {
            throw new IllegalArgumentException("End-of-string after escape character in [" + s + "]");
        }
        int i2 = i + 1;
        char c = s.charAt(i);
        switch (c) {
            case '\"':
            case '\'':
            case '>':
            case '\\':
                sb.append(c);
                return i2;
            case 'n':
                sb.append('\n');
                return i2;
            case 'r':
                sb.append('\r');
                return i2;
            case 't':
                sb.append('\t');
                return i2;
            case 'u':
                try {
                    String hexCode = s.substring(i2, i2 + 4);
                    try {
                        sb.append((char) Integer.parseInt(hexCode, 16));
                        return i2 + 4;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid unicode sequence [" + hexCode + "] at index " + i2 + " in [" + s + "]");
                    }
                } catch (IndexOutOfBoundsException e2) {
                    throw new IllegalArgumentException("Invalid unicode sequence [" + s.substring(i2) + "] at index " + i2 + " in [" + s + "]");
                }
            default:
                throw new IllegalArgumentException("Unknown escape code [" + c + "] at index " + i2 + " in [" + s + "]");
        }
    }

    public static String xmlContentEscape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                case SimpleLog.LOG_LEVEL_OFF /*7*/:
                case PayPalActivity.VIEW_TEST /*8*/:
                case PayPal.PAYMENT_SUBTYPE_REMITTANCES /*11*/:
                case PayPal.PAYMENT_SUBTYPE_RENT /*12*/:
                case PayPal.PAYMENT_SUBTYPE_MEDICAL /*14*/:
                case PayPal.PAYMENT_SUBTYPE_CHILDCARE /*15*/:
                case Segment.TOKENS_PER_SEGMENT /*16*/:
                case PayPal.PAYMENT_SUBTYPE_CONTRACTORS /*17*/:
                case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                case PayPal.PAYMENT_SUBTYPE_TOURISM /*19*/:
                case PayPal.PAYMENT_SUBTYPE_INVOICE /*20*/:
                case PayPal.PAYMENT_SUBTYPE_TRANSFER /*21*/:
                case PayPal.PAYMENT_SUBTYPE_NONE /*22*/:
                case '\u0017':
                case '\u0018':
                case '\u0019':
                case '\u001a':
                case '\u001b':
                case '\u001c':
                case '\u001d':
                case '\u001e':
                case '\u001f':
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    public static String xmlSingleQuotedEscape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                case SimpleLog.LOG_LEVEL_OFF /*7*/:
                case PayPalActivity.VIEW_TEST /*8*/:
                case PayPal.PAYMENT_SUBTYPE_REMITTANCES /*11*/:
                case PayPal.PAYMENT_SUBTYPE_RENT /*12*/:
                case PayPal.PAYMENT_SUBTYPE_MEDICAL /*14*/:
                case PayPal.PAYMENT_SUBTYPE_CHILDCARE /*15*/:
                case Segment.TOKENS_PER_SEGMENT /*16*/:
                case PayPal.PAYMENT_SUBTYPE_CONTRACTORS /*17*/:
                case PayPal.PAYMENT_SUBTYPE_ENTERTAINMENT /*18*/:
                case PayPal.PAYMENT_SUBTYPE_TOURISM /*19*/:
                case PayPal.PAYMENT_SUBTYPE_INVOICE /*20*/:
                case PayPal.PAYMENT_SUBTYPE_TRANSFER /*21*/:
                case PayPal.PAYMENT_SUBTYPE_NONE /*22*/:
                case '\u0017':
                case '\u0018':
                case '\u0019':
                case '\u001a':
                case '\u001b':
                case '\u001c':
                case '\u001d':
                case '\u001e':
                case '\u001f':
                    break;
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                    sb.append("&#xA;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&quot;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    public static String xmlCDataEscape(String s) {
        s = CONTROL_MATCHER.removeFrom(s);
        int found = s.indexOf(XMLStreamWriterImpl.END_CDATA);
        if (found == -1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        do {
            sb.append(s.substring(prev, found + 3));
            sb.append("]]&gt;<![CDATA[");
            prev = found + 3;
            found = s.indexOf(XMLStreamWriterImpl.END_CDATA, prev);
        } while (found != -1);
        sb.append(s.substring(prev));
        return sb.toString();
    }

    public static String javaEscape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                    sb.append("\\t");
                    break;
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                    sb.append("\\n");
                    break;
                case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                    sb.append("\\r");
                    break;
                case '\"':
                    sb.append("\\\"");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("\\'");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    public static String javaEscapeWithinAttribute(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                    sb.append("\\t");
                    break;
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                    sb.append("\\n");
                    break;
                case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                    sb.append("\\r");
                    break;
                case '\"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("\\'");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    public static String xmlEscape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                    break;
                case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                    sb.append("&#x9;");
                    break;
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                    sb.append("&#xA;");
                    break;
                case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                    sb.append("&#xD;");
                    break;
                case '\"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                default:
                    sb.append(ch);
                    break;
            }
        }
        return sb.toString();
    }

    public static String htmlEscape(String s) {
        StringBuilder sb = null;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            String replacement;
            switch (s.charAt(i)) {
                case '\"':
                    replacement = "&quot;";
                    break;
                case '&':
                    replacement = "&amp;";
                    break;
                case '<':
                    replacement = "&lt;";
                    break;
                case '>':
                    replacement = "&gt;";
                    break;
                default:
                    replacement = null;
                    break;
            }
            if (replacement != null) {
                if (sb == null) {
                    sb = new StringBuilder((s.length() + replacement.length()) - 1);
                }
                if (i > start) {
                    sb.append(s.substring(start, i));
                }
                sb.append(replacement);
                start = i + 1;
            }
        }
        if (start > 0) {
            sb.append(s.substring(start));
        }
        if (sb != null) {
            return sb.toString();
        }
        return s;
    }

    public static String regexEscape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("()|*+?.{}[]$^\\".indexOf(c) != -1) {
                sb.append('\\');
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String javaUtilRegexEscape(String s) {
        if (s.indexOf("\\E") == -1) {
            return "\\Q" + s + "\\E";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append('\\');
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String regexReplacementEscape(String s) {
        StringBuilder sb = null;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '$':
                case '\\':
                    if (sb == null) {
                        sb = new StringBuilder(s.substring(0, i));
                    }
                    sb.append('\\');
                    break;
            }
            if (sb != null) {
                sb.append(c);
            }
        }
        return sb == null ? s : sb.toString();
    }

    public static String cropBetween(String in, char limit) {
        return cropBetween(in, String.valueOf(new char[]{limit}));
    }

    public static String cropBetween(String in, String limit) {
        StringBuilder out = new StringBuilder();
        int lastPos = 0;
        int lenLimit = limit.length();
        boolean modeAdd = true;
        while (true) {
            int pos = in.indexOf(limit, lastPos);
            if (pos < 0) {
                break;
            }
            if (modeAdd) {
                out.append(in.substring(lastPos, pos));
            }
            modeAdd = !modeAdd ? true : $assertionsDisabled;
            lastPos = pos + lenLimit;
        }
        if (modeAdd) {
            out.append(in.substring(lastPos));
        }
        return out.toString();
    }

    public static LinkedList<String> string2List(String in, String delimiter, boolean doStrip) {
        if (in == null) {
            return null;
        }
        LinkedList<String> out = new LinkedList();
        string2Collection(in, delimiter, doStrip, out);
        return out;
    }

    public static Set string2Set(String in, String delimiter, boolean doStrip) {
        if (in == null) {
            return null;
        }
        Set out = new HashSet();
        string2Collection(in, delimiter, doStrip, out);
        return out;
    }

    public static Collection<String> string2Collection(String in, String delimiter, boolean doStrip, Collection<String> collection) {
        if (in == null) {
            return null;
        }
        if (collection == null) {
            collection = new ArrayList();
        }
        if (delimiter == null || delimiter.length() == 0) {
            collection.add(in);
            return collection;
        }
        String interim;
        int fromIndex = 0;
        while (true) {
            int pos = in.indexOf(delimiter, fromIndex);
            if (pos < 0) {
                break;
            }
            interim = in.substring(fromIndex, pos);
            if (doStrip) {
                interim = strip(interim);
            }
            if (!doStrip || interim.length() > 0) {
                collection.add(interim);
            }
            fromIndex = pos + delimiter.length();
        }
        interim = in.substring(fromIndex);
        if (doStrip) {
            interim = strip(interim);
        }
        if (!doStrip || interim.length() > 0) {
            collection.add(interim);
        }
        return collection;
    }

    @Deprecated
    public static String list2String(Collection<?> in, String separator) {
        return Collection2String(in, separator);
    }

    @Deprecated
    public static String Collection2String(Collection<?> in, String separator) {
        if (in == null) {
            return null;
        }
        return Iterator2String(in.iterator(), separator);
    }

    @Deprecated
    public static String Iterator2String(Iterator<?> it, String separator) {
        if (it == null) {
            return null;
        }
        StringBuilder out = new StringBuilder();
        while (it.hasNext()) {
            if (out.length() > 0) {
                out.append(separator);
            }
            out.append(it.next().toString());
        }
        return out.toString();
    }

    public static HashMap<String, String> string2Map(String in, String delimEntry, String delimKey, boolean doStripEntry) {
        if (in == null) {
            return null;
        }
        HashMap<String, String> out = new HashMap();
        if (isEmpty(delimEntry) || isEmpty(delimKey)) {
            out.put(strip(in), EMPTY_STRING);
            return out;
        }
        Iterator<String> it = string2List(in, delimEntry, $assertionsDisabled).iterator();
        int len = delimKey.length();
        while (it.hasNext()) {
            String entry = (String) it.next();
            int pos = entry.indexOf(delimKey);
            if (pos > 0) {
                String value = entry.substring(pos + len);
                if (doStripEntry) {
                    value = strip(value);
                }
                out.put(strip(entry.substring(0, pos)), value);
            } else {
                out.put(strip(entry), EMPTY_STRING);
            }
        }
        return out;
    }

    public static <K, V> String map2String(Map<K, V> in, String sepKey, String sepEntry) {
        if (in == null) {
            return null;
        }
        StringBuilder out = new StringBuilder();
        for (Entry<K, V> entry : in.entrySet()) {
            if (out.length() > 0) {
                out.append(sepEntry);
            }
            out.append(entry.getKey() + sepKey + entry.getValue());
        }
        return out.toString();
    }

    public static <V> Map lowercaseKeys(Map<String, V> map) {
        Map<String, V> result = new HashMap(map.size());
        for (String key : map.keySet()) {
            if (result.containsKey(key.toLowerCase())) {
                throw new IllegalArgumentException("Duplicate string key in map when lower casing");
            }
            result.put(key.toLowerCase(), map.get(key));
        }
        return result;
    }

    public static String collapseWhitespace(String str) {
        return collapse(str, WHITE_SPACES, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
    }

    public static String collapse(String str, String chars, String replacement) {
        if (str == null) {
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        boolean prevCharMatched = $assertionsDisabled;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (chars.indexOf(c) == -1) {
                prevCharMatched = $assertionsDisabled;
                newStr.append(c);
            } else if (!prevCharMatched) {
                prevCharMatched = true;
                newStr.append(replacement);
            }
        }
        return newStr.toString();
    }

    public static String stream2String(InputStream is, int maxLength) throws IOException {
        byte[] buffer = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        StringWriter sw = new StringWriter();
        int totalRead = 0;
        int read = 0;
        do {
            sw.write(new String(buffer, 0, read));
            totalRead += read;
            read = is.read(buffer, 0, buffer.length);
            if (-1 != maxLength && totalRead >= maxLength) {
                break;
            }
        } while (read != -1);
        return sw.toString();
    }

    public static String[] parseDelimitedList(String list, char delimiter) {
        String delim = EMPTY_STRING + delimiter;
        StringTokenizer st = new StringTokenizer(list + delim + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, delim, true);
        ArrayList<String> v = new ArrayList();
        String lastToken = EMPTY_STRING;
        String word = EMPTY_STRING;
        while (st.hasMoreTokens()) {
            String tok = st.nextToken();
            if (lastToken != null) {
                if (tok.equals(delim)) {
                    word = word + lastToken;
                    if (lastToken.equals(delim)) {
                        tok = null;
                    }
                } else {
                    if (!word.equals(EMPTY_STRING)) {
                        v.add(word);
                    }
                    word = EMPTY_STRING;
                }
            }
            lastToken = tok;
        }
        return (String[]) v.toArray(new String[0]);
    }

    public static boolean isEmpty(String s) {
        return makeSafe(s).length() == 0 ? true : $assertionsDisabled;
    }

    public static boolean isEmptyOrWhitespace(String s) {
        s = makeSafe(s);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return $assertionsDisabled;
            }
        }
        return true;
    }

    public static String makeSafe(String s) {
        return s == null ? EMPTY_STRING : s;
    }

    public static String toNullIfEmpty(String s) {
        return isEmpty(s) ? null : s;
    }

    public static String toNullIfEmptyOrWhitespace(String s) {
        return isEmptyOrWhitespace(s) ? null : s;
    }

    public static String arrayMap2String(Map<String, String[]> map, String keyValueDelim, String entryDelim) {
        Iterator<Entry<String, String[]>> itor = map.entrySet().iterator();
        StringWriter sw = new StringWriter();
        while (itor.hasNext()) {
            Entry<String, String[]> entry = (Entry) itor.next();
            String key = (String) entry.getKey();
            String[] values = (String[]) entry.getValue();
            for (int i = 0; i < values.length; i++) {
                sw.write(((String) entry.getKey()) + keyValueDelim + values[i]);
                if (i < values.length - 1) {
                    sw.write(entryDelim);
                }
            }
            if (itor.hasNext()) {
                sw.write(entryDelim);
            }
        }
        return sw.toString();
    }

    public static boolean equals(String s1, String s2) {
        if (s1 == s2) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return $assertionsDisabled;
        }
        return s1.equals(s2);
    }

    public static String lastToken(String s, String delimiter) {
        String[] parts = split(s, delimiter);
        return parts.length == 0 ? EMPTY_STRING : parts[parts.length - 1];
    }

    public static boolean allAscii(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if ((s.charAt(i) & 65408) != 0) {
                return $assertionsDisabled;
            }
        }
        return true;
    }

    public static boolean containsCharRef(String s) {
        return characterReferencePattern.matcher(s).find();
    }

    public static boolean isHebrew(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (isHebrew(s.codePointAt(i))) {
                return true;
            }
        }
        return $assertionsDisabled;
    }

    public static boolean isHebrew(int codePoint) {
        return UnicodeBlock.HEBREW.equals(UnicodeBlock.of(codePoint));
    }

    public static boolean isCjk(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (isCjk(s.codePointAt(i))) {
                return true;
            }
        }
        return $assertionsDisabled;
    }

    public static boolean isCjk(char ch) {
        return isCjk((int) ch);
    }

    public static boolean isCjk(int codePoint) {
        if ((codePoint & -256) == 0) {
            return $assertionsDisabled;
        }
        return CJK_BLOCKS.contains(UnicodeBlock.of(codePoint));
    }

    public static String unicodeEscape(String s) {
        if (allAscii(s)) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch <= '\u007f') {
                sb.append(ch);
            } else {
                sb.append("\\u");
                String hexString = Integer.toHexString(ch);
                int numZerosToPad = 4 - hexString.length();
                for (int j = 0; j < numZerosToPad; j++) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
        }
        return sb.toString();
    }

    public static int displayWidth(String s) {
        int width = 0;
        for (int i = 0; i < s.length(); i++) {
            width += displayWidth(s.charAt(i));
        }
        return width;
    }

    public static int displayWidth(char ch) {
        if (ch <= '\u04f9' || ch == '\u05be' || ((ch >= '\u05d0' && ch <= '\u05ea') || ch == '\u05f3' || ch == '\u05f4' || ((ch >= '\u0e00' && ch <= '\u0e7f') || ((ch >= '\u1e00' && ch <= '\u20af') || ((ch >= '\u2100' && ch <= '\u213a') || (ch >= '\uff61' && ch <= '\uffdc')))))) {
            return 1;
        }
        return 2;
    }

    public static String toString(float[] iArray) {
        if (iArray == null) {
            return "NULL";
        }
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        for (int i = 0; i < iArray.length; i++) {
            buffer.append(iArray[i]);
            if (i != iArray.length - 1) {
                buffer.append(", ");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static String toString(long[] iArray) {
        if (iArray == null) {
            return "NULL";
        }
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        for (int i = 0; i < iArray.length; i++) {
            buffer.append(iArray[i]);
            if (i != iArray.length - 1) {
                buffer.append(", ");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static String toString(int[] iArray) {
        if (iArray == null) {
            return "NULL";
        }
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        for (int i = 0; i < iArray.length; i++) {
            buffer.append(iArray[i]);
            if (i != iArray.length - 1) {
                buffer.append(", ");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static String toString(String[] iArray) {
        if (iArray == null) {
            return "NULL";
        }
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        for (int i = 0; i < iArray.length; i++) {
            buffer.append("'").append(iArray[i]).append("'");
            if (i != iArray.length - 1) {
                buffer.append(", ");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static String toString(String s) {
        if (s == null) {
            return "NULL";
        }
        return new StringBuilder(s.length() + 2).append("'").append(s).append("'").toString();
    }

    public static String toString(int[][] iArray) {
        if (iArray == null) {
            return "NULL";
        }
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        for (int i = 0; i < iArray.length; i++) {
            buffer.append("[");
            for (int j = 0; j < iArray[i].length; j++) {
                buffer.append(iArray[i][j]);
                if (j != iArray[i].length - 1) {
                    buffer.append(", ");
                }
            }
            buffer.append("]");
            if (i != iArray.length - 1) {
                buffer.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static String toString(long[][] iArray) {
        if (iArray == null) {
            return "NULL";
        }
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        for (int i = 0; i < iArray.length; i++) {
            buffer.append("[");
            for (int j = 0; j < iArray[i].length; j++) {
                buffer.append(iArray[i][j]);
                if (j != iArray[i].length - 1) {
                    buffer.append(", ");
                }
            }
            buffer.append("]");
            if (i != iArray.length - 1) {
                buffer.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static String toString(Object[] obj) {
        if (obj == null) {
            return "NULL";
        }
        StringBuilder tmp = new StringBuilder();
        tmp.append("[");
        for (int i = 0; i < obj.length; i++) {
            tmp.append(obj[i].toString());
            if (i != obj.length - 1) {
                tmp.append(",");
            }
        }
        tmp.append("]");
        return tmp.toString();
    }

    public static InputStream toUTF8InputStream(String str) {
        try {
            return new ByteArrayInputStream(str.getBytes(StringEncodings.UTF8));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }

    public static void copyStreams(InputStream in, OutputStream out) throws IOException {
        if (in == null || out == null) {
            throw new IllegalArgumentException();
        }
        byte[] buffer = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        while (true) {
            int len = in.read(buffer, 0, buffer.length);
            if (-1 != len) {
                out.write(buffer, 0, len);
            } else {
                return;
            }
        }
    }

    public static String bytesToLatin1(byte[] ba) {
        return bytesToEncoding(ba, "ISO-8859-1");
    }

    public static String bytesToHexString(byte[] bytes) {
        return bytesToHexString(bytes, null);
    }

    public static String bytesToHexString(byte[] bytes, Character delimiter) {
        StringBuffer hex = new StringBuffer((delimiter == null ? 2 : 3) * bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            int nibble1 = (bytes[i] >>> 4) & 15;
            int nibble2 = bytes[i] & 15;
            if (i > 0 && delimiter != null) {
                hex.append(delimiter.charValue());
            }
            hex.append(hexChars[nibble1]);
            hex.append(hexChars[nibble2]);
        }
        return hex.toString();
    }

    public static byte[] latin1ToBytes(String str) {
        return encodingToBytes(str, "ISO-8859-1");
    }

    public static String bytesToUtf8(byte[] ba) {
        return bytesToEncoding(ba, "UTF8");
    }

    public static byte[] utf8ToBytes(String str) {
        return encodingToBytes(str, "UTF8");
    }

    private static String bytesToEncoding(byte[] ba, String encoding) {
        if (ba == null) {
            return null;
        }
        try {
            return new String(ba, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new Error(encoding + " not supported! Original exception: " + e);
        }
    }

    public static byte[] encodingToBytes(String str, String encoding) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            throw new Error(encoding + " not supported! Original exception: " + e);
        }
    }

    public static List<String> bytesToStringList(byte[] bytes) {
        List<String> lines = new ArrayList();
        if (bytes != null) {
            try {
                BufferedReader r = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes), StringEncodings.UTF8));
                try {
                    for (String line = r.readLine(); line != null; line = r.readLine()) {
                        lines.add(line);
                    }
                    r.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    r.close();
                }
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException(e2);
            }
        }
        return lines;
    }

    public static String toUpperCase(String src) {
        if (src == null) {
            return null;
        }
        return src.toUpperCase();
    }

    public static String expandShardNames(String dbSpecComponent) throws IllegalArgumentException, IllegalStateException {
        Matcher matcher = dbSpecPattern.matcher(dbSpecComponent);
        if (matcher.find()) {
            try {
                String prefix = dbSpecComponent.substring(matcher.start(1), matcher.end(1));
                int minShard = Integer.parseInt(dbSpecComponent.substring(matcher.start(2), matcher.end(2)));
                int maxShard = Integer.parseInt(dbSpecComponent.substring(matcher.start(3), matcher.end(3)));
                String suffix = dbSpecComponent.substring(matcher.start(4), matcher.end(4));
                if (minShard > maxShard) {
                    throw new IllegalArgumentException("Maximum shard must be greater than or equal to the minimum shard");
                }
                StringBuilder tmp = new StringBuilder();
                for (int shard = minShard; shard <= maxShard; shard++) {
                    tmp.append(prefix).append(shard).append(suffix);
                    if (shard != maxShard) {
                        tmp.append(",");
                    }
                }
                dbSpecComponent = tmp.toString();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Malformed DB specification component: " + dbSpecComponent);
            }
        }
        return dbSpecComponent;
    }

    public static String repeat(String sourceString, int factor) {
        if (factor < 1) {
            return EMPTY_STRING;
        }
        if (factor == 1) {
            return sourceString;
        }
        StringBuilder sb = new StringBuilder(sourceString.length() * factor);
        while (factor > 0) {
            sb.append(sourceString);
            factor--;
        }
        return sb.toString();
    }

    public static String capitalize(String s) {
        if (s.length() == 0) {
            return s;
        }
        char first = s.charAt(0);
        char capitalized = Character.toUpperCase(first);
        return first != capitalized ? capitalized + s.substring(1) : s;
    }
}
