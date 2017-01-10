package com.paypal.android.p003a;

import android.util.Log;
import com.paypal.android.MEP.PayPal;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Hashtable;
import java.util.Locale;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.paypal.android.a.h */
public final class C0925h {
    private static String[] f812a;
    private static Hashtable<String, String> f813b;
    private static NumberFormat f814c;
    private static Object f815d;

    static {
        f812a = new String[]{"de_at", "de_ch", "de_de", "en_ar", "en_at", "en_au", "en_be", "en_br", "en_ca", "en_ch", "en_de", "en_es", "en_fr", "en_gb", "en_hk", "en_in", "en_it", "en_jp", "en_mx", "en_nl", "en_pl", "en_sg", "en_tw", "en_us", "es_ar", "es_es", "es_mx", "fr_be", "fr_ca", "fr_ch", "fr_fr", "it_it", "ja_jp", "nl_be", "nl_nl", "pl_pl", "pt_br", "zh_hk", "zh_tw"};
        f815d = new Object();
    }

    public static String m680a(String str) {
        while (f813b == null) {
            try {
                Log.d("StringUtil", "wait for _strings to be allocated");
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        synchronized (f815d) {
            String str2 = (String) f813b.get(str);
            if (str2 != null) {
                str = str2;
            }
        }
        return str;
    }

    public static String m681a(String str, int i) {
        String[] split = str.substring(0, str.indexOf("T")).split("-");
        if (split.length < 3) {
            return "Error with timestamp.";
        }
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        int parseInt3 = Integer.parseInt(split[2]);
        String language = PayPal.getInstance().getLanguage();
        if (language.contains("AU") || language.contains("DE") || language.contains("BR") || language.contains("FR") || language.contains("IN") || language.contains("NL") || language.contains("PL") || language.contains("ES") || language.contains("GB") || language.contains("AT") || language.contains("CH") || language.contains("MX") || language.contains("SG") || language.contains("IT") || language.contains("AR")) {
            i = 0;
        } else if (language.contains("US")) {
            i = 2;
        } else if (language.contains("BE") || language.contains("CA") || language.contains("JP") || language.contains("HK") || language.contains("TW")) {
            i = 5;
        }
        switch (i) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return parseInt3 + "/" + parseInt2 + "/" + parseInt;
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                return parseInt + "/" + parseInt2 + "/" + parseInt3;
            default:
                return parseInt2 + "/" + parseInt3 + "/" + parseInt;
        }
    }

    public static String m682a(BigDecimal bigDecimal, String str) {
        f814c.setCurrency(Currency.getInstance(str));
        return f814c.format(bigDecimal) + " (" + str + ")";
    }

    public static void m683a() {
        f813b = null;
        f814c = null;
    }

    public static boolean m684b(String str) {
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.indexOf(95) == -1 || toLowerCase.length() != 5 || !C0925h.m689g(toLowerCase.substring(0, 1)) || !C0925h.m689g(toLowerCase.substring(3, 5))) {
            return false;
        }
        for (String equals : f812a) {
            if (equals.equals(toLowerCase)) {
                return true;
            }
        }
        return false;
    }

    public static void m685c(String str) {
        int i = 17877;
        synchronized (f815d) {
            int i2;
            if (str == null) {
                str = "en_US";
            }
            String toLowerCase = str.toLowerCase();
            String str2 = !C0925h.m684b(toLowerCase) ? "en_US" : toLowerCase;
            if (f813b != null) {
                f813b = null;
            }
            f814c = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.getDefault());
            if (str2.equals("de_at")) {
                i = 407851;
                i2 = 19844;
            } else if (str2.equals("de_ch")) {
                i2 = 19922;
            } else if (str2.equals("de_de")) {
                i = 367816;
                i2 = 19844;
            } else if (str2.equals("en_ar")) {
                i = 57219;
                i2 = 19391;
            } else if (str2.equals("en_at")) {
                i = 175128;
                i2 = 20185;
            } else if (str2.equals("en_au")) {
                i = 563442;
                i2 = 18501;
            } else if (str2.equals("en_be")) {
                i = 742893;
                i2 = 19328;
            } else if (str2.equals("en_br")) {
                i = 135958;
                i2 = 19762;
            } else if (str2.equals("en_ca")) {
                i = 683782;
                i2 = 21569;
            } else if (str2.equals("en_ch")) {
                i = 523349;
                i2 = 20439;
            } else if (str2.equals("en_de")) {
                i = 95688;
                i2 = 20185;
            } else if (str2.equals("en_es")) {
                i = 705351;
                i2 = 19362;
            } else if (str2.equals("en_fr")) {
                i = 309212;
                i2 = 20370;
            } else if (str2.equals("en_gb")) {
                i = 487773;
                i2 = 18217;
            } else if (str2.equals("en_hk")) {
                i = 505990;
                i2 = 17359;
            } else if (str2.equals("en_in")) {
                i = 329582;
                i2 = 18162;
            } else if (str2.equals("en_it")) {
                i = 543788;
                i2 = 19654;
            } else if (str2.equals("en_jp")) {
                i = 427695;
                i2 = 23230;
            } else if (str2.equals("en_mx")) {
                i = 155720;
                i2 = 19408;
            } else if (str2.equals("en_nl")) {
                i = 468459;
                i2 = 19314;
            } else if (str2.equals("en_pl")) {
                i = 581943;
                i2 = 20507;
            } else if (str2.equals("en_sg")) {
                i = 195313;
                i2 = 18176;
            } else if (str2.equals("en_tw")) {
                i2 = 17877;
                i = 0;
            } else if (str2.equals("en_us")) {
                i = 724713;
                i2 = 18180;
            } else if (str2.equals("es_ar")) {
                i = 251927;
                i2 = 19188;
            } else if (str2.equals("es_es")) {
                i = 76610;
                i2 = 19078;
            } else if (str2.equals("es_mx")) {
                i = 271115;
                i2 = 19157;
            } else if (str2.equals("fr_be")) {
                i = 347744;
                i2 = 20072;
            } else if (str2.equals("fr_ca")) {
                i = 230568;
                i2 = 21359;
            } else if (str2.equals("fr_ch")) {
                i = 115873;
                i2 = 20085;
            } else if (str2.equals("fr_fr")) {
                i = 663766;
                i2 = 20016;
            } else if (str2.equals("it_it")) {
                i = 37799;
                i2 = 19420;
            } else if (str2.equals("ja_jp")) {
                i = 640855;
                i2 = 22911;
            } else if (str2.equals("nl_be")) {
                i = 602450;
                i2 = 18954;
            } else if (str2.equals("nl_nl")) {
                i = 290272;
                i2 = 18940;
            } else if (str2.equals("pl_pl")) {
                i = 387660;
                i2 = 20191;
            } else if (str2.equals("pt_br")) {
                i = 621404;
                i2 = 19451;
            } else if (str2.equals("zh_hk")) {
                i = 213489;
                i2 = 17079;
            } else if (str2.equals("zh_tw")) {
                i = 450925;
                i2 = 17534;
            } else {
                i2 = 0;
                i = 0;
            }
            String[] split = new String(C0924g.m676a(i, i2, C0924g.m677a("com/paypal/android/utils/data/locale.bin"))).split("\n");
            f813b = new Hashtable();
            for (String str3 : split) {
                if (str3.contains("\" = \"")) {
                    String[] split2 = str3.split("\" = \"");
                    f813b.put(split2[0].replace('\"', ' ').trim(), split2[1].replace("\";", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).trim());
                }
            }
        }
    }

    public static boolean m686d(String str) {
        int indexOf = str.indexOf(64);
        int lastIndexOf = str.lastIndexOf(46);
        return (indexOf == -1 || lastIndexOf == -1 || lastIndexOf - 1 <= indexOf || lastIndexOf == str.length() - 1) ? false : true;
    }

    public static boolean m687e(String str) {
        if (str.length() <= 0) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt >= '0' && charAt <= '9') || charAt == '+') {
                stringBuffer.append(charAt);
            }
        }
        return str.equals(stringBuffer.toString());
    }

    public static boolean m688f(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    private static boolean m689g(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9'))) {
                return false;
            }
        }
        return true;
    }
}
