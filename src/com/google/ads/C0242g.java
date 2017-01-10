package com.google.ads;

/* renamed from: com.google.ads.g */
public final class C0242g {

    /* renamed from: com.google.ads.g.a */
    public enum C0241a {
        AD,
        NO_FILL,
        ERROR,
        TIMEOUT,
        NOT_FOUND,
        EXCEPTION
    }

    public static String m101a(String str, String str2, Boolean bool, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        String replaceAll = str.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_qdata@", str6).replaceAll("@gw_sdkver@", "afma-sdk-a-v6.2.1").replaceAll("@gw_sessid@", str7).replaceAll("@gw_seqnum@", str8).replaceAll("@gw_devid@", str3);
        if (str5 != null) {
            replaceAll = replaceAll.replaceAll("@gw_adnetid@", str5);
        }
        if (str4 != null) {
            replaceAll = replaceAll.replaceAll("@gw_allocid@", str4);
        }
        if (str9 != null) {
            replaceAll = replaceAll.replaceAll("@gw_adt@", str9);
        }
        if (str10 != null) {
            replaceAll = replaceAll.replaceAll("@gw_aec@", str10);
        }
        if (bool == null) {
            return replaceAll;
        }
        return replaceAll.replaceAll("@gw_adnetrefresh@", bool.booleanValue() ? "1" : "0");
    }

    public static <T> T m100a(String str, Class<T> cls) throws ClassNotFoundException, ClassCastException, IllegalAccessException, InstantiationException, LinkageError, ExceptionInInitializerError {
        return cls.cast(Class.forName(str).newInstance());
    }
}
