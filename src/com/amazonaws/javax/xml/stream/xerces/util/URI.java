package com.amazonaws.javax.xml.stream.xerces.util;

import java.io.IOException;
import java.io.Serializable;

public class URI implements Serializable {
    private static boolean DEBUG = false;
    private static final String MARK_CHARACTERS = "-_.!~*'()";
    private static final String RESERVED_CHARACTERS = ";/?:@&=+$,[]";
    private static final String SCHEME_CHARACTERS = "+-.";
    private static final String USERINFO_CHARACTERS = ";:&=+$,";
    private String m_fragment;
    private String m_host;
    private String m_path;
    private int m_port;
    private String m_queryString;
    private String m_scheme;
    private String m_userinfo;

    public static class MalformedURIException extends IOException {
        public MalformedURIException(String p_msg) {
            super(p_msg);
        }
    }

    static {
        DEBUG = false;
    }

    public URI() {
        this.m_scheme = null;
        this.m_userinfo = null;
        this.m_host = null;
        this.m_port = -1;
        this.m_path = null;
        this.m_queryString = null;
        this.m_fragment = null;
    }

    public URI(URI p_other) {
        this.m_scheme = null;
        this.m_userinfo = null;
        this.m_host = null;
        this.m_port = -1;
        this.m_path = null;
        this.m_queryString = null;
        this.m_fragment = null;
        initialize(p_other);
    }

    public URI(String p_uriSpec) throws MalformedURIException {
        this((URI) null, p_uriSpec);
    }

    public URI(URI p_base, String p_uriSpec) throws MalformedURIException {
        this.m_scheme = null;
        this.m_userinfo = null;
        this.m_host = null;
        this.m_port = -1;
        this.m_path = null;
        this.m_queryString = null;
        this.m_fragment = null;
        initialize(p_base, p_uriSpec);
    }

    public URI(String p_scheme, String p_schemeSpecificPart) throws MalformedURIException {
        this.m_scheme = null;
        this.m_userinfo = null;
        this.m_host = null;
        this.m_port = -1;
        this.m_path = null;
        this.m_queryString = null;
        this.m_fragment = null;
        if (p_scheme == null || p_scheme.trim().length() == 0) {
            throw new MalformedURIException("Cannot construct URI with null/empty scheme!");
        } else if (p_schemeSpecificPart == null || p_schemeSpecificPart.trim().length() == 0) {
            throw new MalformedURIException("Cannot construct URI with null/empty scheme-specific part!");
        } else {
            setScheme(p_scheme);
            setPath(p_schemeSpecificPart);
        }
    }

    public URI(String p_scheme, String p_host, String p_path, String p_queryString, String p_fragment) throws MalformedURIException {
        this(p_scheme, null, p_host, -1, p_path, p_queryString, p_fragment);
    }

    public URI(String p_scheme, String p_userinfo, String p_host, int p_port, String p_path, String p_queryString, String p_fragment) throws MalformedURIException {
        this.m_scheme = null;
        this.m_userinfo = null;
        this.m_host = null;
        this.m_port = -1;
        this.m_path = null;
        this.m_queryString = null;
        this.m_fragment = null;
        if (p_scheme == null || p_scheme.trim().length() == 0) {
            throw new MalformedURIException("Scheme is required!");
        }
        if (p_host == null) {
            if (p_userinfo != null) {
                throw new MalformedURIException("Userinfo may not be specified if host is not specified!");
            } else if (p_port != -1) {
                throw new MalformedURIException("Port may not be specified if host is not specified!");
            }
        }
        if (p_path != null) {
            if (p_path.indexOf(63) != -1 && p_queryString != null) {
                throw new MalformedURIException("Query string cannot be specified in path and query string!");
            } else if (!(p_path.indexOf(35) == -1 || p_fragment == null)) {
                throw new MalformedURIException("Fragment cannot be specified in both the path and fragment!");
            }
        }
        setScheme(p_scheme);
        setHost(p_host);
        setPort(p_port);
        setUserinfo(p_userinfo);
        setPath(p_path);
        setQueryString(p_queryString);
        setFragment(p_fragment);
    }

    private void initialize(URI p_other) {
        this.m_scheme = p_other.getScheme();
        this.m_userinfo = p_other.getUserinfo();
        this.m_host = p_other.getHost();
        this.m_port = p_other.getPort();
        this.m_path = p_other.getPath();
        this.m_queryString = p_other.getQueryString();
        this.m_fragment = p_other.getFragment();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initialize(com.amazonaws.javax.xml.stream.xerces.util.URI r18, java.lang.String r19) throws com.amazonaws.javax.xml.stream.xerces.util.URI.MalformedURIException {
        /*
        r17 = this;
        if (r18 != 0) goto L_0x0016;
    L_0x0002:
        if (r19 == 0) goto L_0x000e;
    L_0x0004:
        r15 = r19.trim();
        r15 = r15.length();
        if (r15 != 0) goto L_0x0016;
    L_0x000e:
        r15 = new com.amazonaws.javax.xml.stream.xerces.util.URI$MalformedURIException;
        r16 = "Cannot initialize URI with empty parameters.";
        r15.<init>(r16);
        throw r15;
    L_0x0016:
        if (r19 == 0) goto L_0x0022;
    L_0x0018:
        r15 = r19.trim();
        r15 = r15.length();
        if (r15 != 0) goto L_0x0026;
    L_0x0022:
        r17.initialize(r18);
    L_0x0025:
        return;
    L_0x0026:
        r13 = r19.trim();
        r14 = r13.length();
        r4 = 0;
        r15 = 58;
        r2 = r13.indexOf(r15);
        r15 = 47;
        r9 = r13.indexOf(r15);
        r15 = 63;
        r7 = r13.indexOf(r15);
        r15 = 35;
        r3 = r13.indexOf(r15);
        r15 = 2;
        if (r2 < r15) goto L_0x0059;
    L_0x004a:
        if (r2 <= r9) goto L_0x004f;
    L_0x004c:
        r15 = -1;
        if (r9 != r15) goto L_0x0059;
    L_0x004f:
        if (r2 <= r7) goto L_0x0054;
    L_0x0051:
        r15 = -1;
        if (r7 != r15) goto L_0x0059;
    L_0x0054:
        if (r2 <= r3) goto L_0x0065;
    L_0x0056:
        r15 = -1;
        if (r3 == r15) goto L_0x0065;
    L_0x0059:
        if (r18 != 0) goto L_0x0074;
    L_0x005b:
        if (r3 == 0) goto L_0x0074;
    L_0x005d:
        r15 = new com.amazonaws.javax.xml.stream.xerces.util.URI$MalformedURIException;
        r16 = "No scheme found in URI.";
        r15.<init>(r16);
        throw r15;
    L_0x0065:
        r0 = r17;
        r0.initializeScheme(r13);
        r0 = r17;
        r15 = r0.m_scheme;
        r15 = r15.length();
        r4 = r15 + 1;
    L_0x0074:
        r15 = r4 + 1;
        if (r15 >= r14) goto L_0x00a5;
    L_0x0078:
        r15 = r13.substring(r4);
        r16 = "//";
        r15 = r15.startsWith(r16);
        if (r15 == 0) goto L_0x00a5;
    L_0x0084:
        r4 = r4 + 2;
        r10 = r4;
        r12 = 0;
    L_0x0088:
        if (r4 >= r14) goto L_0x009a;
    L_0x008a:
        r12 = r13.charAt(r4);
        r15 = 47;
        if (r12 == r15) goto L_0x009a;
    L_0x0092:
        r15 = 63;
        if (r12 == r15) goto L_0x009a;
    L_0x0096:
        r15 = 35;
        if (r12 != r15) goto L_0x00fe;
    L_0x009a:
        if (r4 <= r10) goto L_0x0101;
    L_0x009c:
        r15 = r13.substring(r10, r4);
        r0 = r17;
        r0.initializeAuthority(r15);
    L_0x00a5:
        r15 = r13.substring(r4);
        r0 = r17;
        r0.initializePath(r15);
        if (r18 == 0) goto L_0x0025;
    L_0x00b0:
        r0 = r17;
        r15 = r0.m_path;
        r15 = r15.length();
        if (r15 != 0) goto L_0x0108;
    L_0x00ba:
        r0 = r17;
        r15 = r0.m_scheme;
        if (r15 != 0) goto L_0x0108;
    L_0x00c0:
        r0 = r17;
        r15 = r0.m_host;
        if (r15 != 0) goto L_0x0108;
    L_0x00c6:
        r15 = r18.getScheme();
        r0 = r17;
        r0.m_scheme = r15;
        r15 = r18.getUserinfo();
        r0 = r17;
        r0.m_userinfo = r15;
        r15 = r18.getHost();
        r0 = r17;
        r0.m_host = r15;
        r15 = r18.getPort();
        r0 = r17;
        r0.m_port = r15;
        r15 = r18.getPath();
        r0 = r17;
        r0.m_path = r15;
        r0 = r17;
        r15 = r0.m_queryString;
        if (r15 != 0) goto L_0x0025;
    L_0x00f4:
        r15 = r18.getQueryString();
        r0 = r17;
        r0.m_queryString = r15;
        goto L_0x0025;
    L_0x00fe:
        r4 = r4 + 1;
        goto L_0x0088;
    L_0x0101:
        r15 = "";
        r0 = r17;
        r0.m_host = r15;
        goto L_0x00a5;
    L_0x0108:
        r0 = r17;
        r15 = r0.m_scheme;
        if (r15 != 0) goto L_0x0025;
    L_0x010e:
        r15 = r18.getScheme();
        r0 = r17;
        r0.m_scheme = r15;
        r0 = r17;
        r15 = r0.m_host;
        if (r15 != 0) goto L_0x0025;
    L_0x011c:
        r15 = r18.getUserinfo();
        r0 = r17;
        r0.m_userinfo = r15;
        r15 = r18.getHost();
        r0 = r17;
        r0.m_host = r15;
        r15 = r18.getPort();
        r0 = r17;
        r0.m_port = r15;
        r0 = r17;
        r15 = r0.m_path;
        r15 = r15.length();
        if (r15 <= 0) goto L_0x014a;
    L_0x013e:
        r0 = r17;
        r15 = r0.m_path;
        r16 = "/";
        r15 = r15.startsWith(r16);
        if (r15 != 0) goto L_0x0025;
    L_0x014a:
        r6 = new java.lang.String;
        r6.<init>();
        r1 = r18.getPath();
        if (r1 == 0) goto L_0x0167;
    L_0x0155:
        r15 = 47;
        r5 = r1.lastIndexOf(r15);
        r15 = -1;
        if (r5 == r15) goto L_0x0167;
    L_0x015e:
        r15 = 0;
        r16 = r5 + 1;
        r0 = r16;
        r6 = r1.substring(r15, r0);
    L_0x0167:
        r0 = r17;
        r15 = r0.m_path;
        r6 = r6.concat(r15);
        r4 = -1;
    L_0x0170:
        r15 = "/./";
        r4 = r6.indexOf(r15);
        r15 = -1;
        if (r4 == r15) goto L_0x018f;
    L_0x0179:
        r15 = 0;
        r16 = r4 + 1;
        r0 = r16;
        r15 = r6.substring(r15, r0);
        r16 = r4 + 3;
        r0 = r16;
        r16 = r6.substring(r0);
        r6 = r15.concat(r16);
        goto L_0x0170;
    L_0x018f:
        r15 = "/.";
        r15 = r6.endsWith(r15);
        if (r15 == 0) goto L_0x01a4;
    L_0x0197:
        r15 = 0;
        r16 = r6.length();
        r16 = r16 + -1;
        r0 = r16;
        r6 = r6.substring(r15, r0);
    L_0x01a4:
        r4 = 1;
        r8 = -1;
        r11 = 0;
    L_0x01a7:
        r15 = "/../";
        r4 = r6.indexOf(r15, r4);
        if (r4 <= 0) goto L_0x01f0;
    L_0x01af:
        r15 = 0;
        r16 = "/../";
        r0 = r16;
        r16 = r6.indexOf(r0);
        r0 = r16;
        r11 = r6.substring(r15, r0);
        r15 = 47;
        r8 = r11.lastIndexOf(r15);
        r15 = -1;
        if (r8 == r15) goto L_0x01ed;
    L_0x01c7:
        r15 = r11.substring(r8);
        r16 = "..";
        r15 = r15.equals(r16);
        if (r15 != 0) goto L_0x01ea;
    L_0x01d3:
        r15 = 0;
        r16 = r8 + 1;
        r0 = r16;
        r15 = r6.substring(r15, r0);
        r16 = r4 + 4;
        r0 = r16;
        r16 = r6.substring(r0);
        r6 = r15.concat(r16);
        r4 = r8;
        goto L_0x01a7;
    L_0x01ea:
        r4 = r4 + 4;
        goto L_0x01a7;
    L_0x01ed:
        r4 = r4 + 4;
        goto L_0x01a7;
    L_0x01f0:
        r15 = "/..";
        r15 = r6.endsWith(r15);
        if (r15 == 0) goto L_0x0217;
    L_0x01f8:
        r15 = 0;
        r16 = r6.length();
        r16 = r16 + -3;
        r0 = r16;
        r11 = r6.substring(r15, r0);
        r15 = 47;
        r8 = r11.lastIndexOf(r15);
        r15 = -1;
        if (r8 == r15) goto L_0x0217;
    L_0x020e:
        r15 = 0;
        r16 = r8 + 1;
        r0 = r16;
        r6 = r6.substring(r15, r0);
    L_0x0217:
        r0 = r17;
        r0.m_path = r6;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.javax.xml.stream.xerces.util.URI.initialize(com.amazonaws.javax.xml.stream.xerces.util.URI, java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initializeScheme(java.lang.String r7) throws com.amazonaws.javax.xml.stream.xerces.util.URI.MalformedURIException {
        /*
        r6 = this;
        r3 = r7.length();
        r0 = 0;
        r1 = 0;
        r2 = 0;
    L_0x0007:
        if (r0 >= r3) goto L_0x001d;
    L_0x0009:
        r2 = r7.charAt(r0);
        r4 = 58;
        if (r2 == r4) goto L_0x001d;
    L_0x0011:
        r4 = 47;
        if (r2 == r4) goto L_0x001d;
    L_0x0015:
        r4 = 63;
        if (r2 == r4) goto L_0x001d;
    L_0x0019:
        r4 = 35;
        if (r2 != r4) goto L_0x0030;
    L_0x001d:
        r4 = 0;
        r1 = r7.substring(r4, r0);
        r4 = r1.length();
        if (r4 != 0) goto L_0x0033;
    L_0x0028:
        r4 = new com.amazonaws.javax.xml.stream.xerces.util.URI$MalformedURIException;
        r5 = "No scheme found in URI.";
        r4.<init>(r5);
        throw r4;
    L_0x0030:
        r0 = r0 + 1;
        goto L_0x0007;
    L_0x0033:
        r6.setScheme(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.javax.xml.stream.xerces.util.URI.initializeScheme(java.lang.String):void");
    }

    private void initializeAuthority(String p_uriSpec) throws MalformedURIException {
        int index = 0;
        int end = p_uriSpec.length();
        char testChar = '\u0000';
        String userinfo = null;
        if (p_uriSpec.indexOf(64, 0) != -1) {
            while (index < end) {
                testChar = p_uriSpec.charAt(index);
                if (testChar == '@') {
                    break;
                }
                index++;
            }
            userinfo = p_uriSpec.substring(0, index);
            index++;
        }
        int start = index;
        while (index < end) {
            testChar = p_uriSpec.charAt(index);
            if (testChar == ':') {
                break;
            }
            index++;
        }
        String host = p_uriSpec.substring(start, index);
        int port = -1;
        if (host.length() > 0 && testChar == ':') {
            index++;
            start = index;
            while (index < end) {
                index++;
            }
            String portStr = p_uriSpec.substring(start, index);
            if (portStr.length() > 0) {
                int i = 0;
                while (i < portStr.length()) {
                    if (isDigit(portStr.charAt(i))) {
                        i++;
                    } else {
                        throw new MalformedURIException(new StringBuffer().append(portStr).append(" is invalid. Port should only contain digits!").toString());
                    }
                }
                try {
                    port = Integer.parseInt(portStr);
                } catch (NumberFormatException e) {
                }
            }
        }
        setHost(host);
        setPort(port);
        setUserinfo(userinfo);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initializePath(java.lang.String r9) throws com.amazonaws.javax.xml.stream.xerces.util.URI.MalformedURIException {
        /*
        r8 = this;
        r7 = 63;
        r6 = 37;
        r5 = 35;
        if (r9 != 0) goto L_0x0010;
    L_0x0008:
        r4 = new com.amazonaws.javax.xml.stream.xerces.util.URI$MalformedURIException;
        r5 = "Cannot initialize path from null string!";
        r4.<init>(r5);
        throw r4;
    L_0x0010:
        r1 = 0;
        r2 = 0;
        r0 = r9.length();
        r3 = 0;
    L_0x0017:
        if (r1 >= r0) goto L_0x0021;
    L_0x0019:
        r3 = r9.charAt(r1);
        if (r3 == r7) goto L_0x0021;
    L_0x001f:
        if (r3 != r5) goto L_0x006b;
    L_0x0021:
        r4 = r9.substring(r2, r1);
        r8.m_path = r4;
        if (r3 != r7) goto L_0x003a;
    L_0x0029:
        r1 = r1 + 1;
        r2 = r1;
    L_0x002c:
        if (r1 >= r0) goto L_0x0034;
    L_0x002e:
        r3 = r9.charAt(r1);
        if (r3 != r5) goto L_0x00ba;
    L_0x0034:
        r4 = r9.substring(r2, r1);
        r8.m_queryString = r4;
    L_0x003a:
        if (r3 != r5) goto L_0x0138;
    L_0x003c:
        r1 = r1 + 1;
        r2 = r1;
    L_0x003f:
        if (r1 >= r0) goto L_0x0132;
    L_0x0041:
        r3 = r9.charAt(r1);
        if (r3 != r6) goto L_0x0109;
    L_0x0047:
        r4 = r1 + 2;
        if (r4 >= r0) goto L_0x0063;
    L_0x004b:
        r4 = r1 + 1;
        r4 = r9.charAt(r4);
        r4 = isHex(r4);
        if (r4 == 0) goto L_0x0063;
    L_0x0057:
        r4 = r1 + 2;
        r4 = r9.charAt(r4);
        r4 = isHex(r4);
        if (r4 != 0) goto L_0x012e;
    L_0x0063:
        r4 = new com.amazonaws.javax.xml.stream.xerces.util.URI$MalformedURIException;
        r5 = "Fragment contains invalid escape sequence!";
        r4.<init>(r5);
        throw r4;
    L_0x006b:
        if (r3 != r6) goto L_0x0091;
    L_0x006d:
        r4 = r1 + 2;
        if (r4 >= r0) goto L_0x0089;
    L_0x0071:
        r4 = r1 + 1;
        r4 = r9.charAt(r4);
        r4 = isHex(r4);
        if (r4 == 0) goto L_0x0089;
    L_0x007d:
        r4 = r1 + 2;
        r4 = r9.charAt(r4);
        r4 = isHex(r4);
        if (r4 != 0) goto L_0x00b6;
    L_0x0089:
        r4 = new com.amazonaws.javax.xml.stream.xerces.util.URI$MalformedURIException;
        r5 = "Path contains invalid escape sequence!";
        r4.<init>(r5);
        throw r4;
    L_0x0091:
        r4 = isReservedCharacter(r3);
        if (r4 != 0) goto L_0x00b6;
    L_0x0097:
        r4 = isUnreservedCharacter(r3);
        if (r4 != 0) goto L_0x00b6;
    L_0x009d:
        r4 = new com.amazonaws.javax.xml.stream.xerces.util.URI$MalformedURIException;
        r5 = new java.lang.StringBuffer;
        r5.<init>();
        r6 = "Path contains invalid character: ";
        r5 = r5.append(r6);
        r5 = r5.append(r3);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x00b6:
        r1 = r1 + 1;
        goto L_0x0017;
    L_0x00ba:
        if (r3 != r6) goto L_0x00e0;
    L_0x00bc:
        r4 = r1 + 2;
        if (r4 >= r0) goto L_0x00d8;
    L_0x00c0:
        r4 = r1 + 1;
        r4 = r9.charAt(r4);
        r4 = isHex(r4);
        if (r4 == 0) goto L_0x00d8;
    L_0x00cc:
        r4 = r1 + 2;
        r4 = r9.charAt(r4);
        r4 = isHex(r4);
        if (r4 != 0) goto L_0x0105;
    L_0x00d8:
        r4 = new com.amazonaws.javax.xml.stream.xerces.util.URI$MalformedURIException;
        r5 = "Query string contains invalid escape sequence!";
        r4.<init>(r5);
        throw r4;
    L_0x00e0:
        r4 = isReservedCharacter(r3);
        if (r4 != 0) goto L_0x0105;
    L_0x00e6:
        r4 = isUnreservedCharacter(r3);
        if (r4 != 0) goto L_0x0105;
    L_0x00ec:
        r4 = new com.amazonaws.javax.xml.stream.xerces.util.URI$MalformedURIException;
        r5 = new java.lang.StringBuffer;
        r5.<init>();
        r6 = "Query string contains invalid character:";
        r5 = r5.append(r6);
        r5 = r5.append(r3);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0105:
        r1 = r1 + 1;
        goto L_0x002c;
    L_0x0109:
        r4 = isReservedCharacter(r3);
        if (r4 != 0) goto L_0x012e;
    L_0x010f:
        r4 = isUnreservedCharacter(r3);
        if (r4 != 0) goto L_0x012e;
    L_0x0115:
        r4 = new com.amazonaws.javax.xml.stream.xerces.util.URI$MalformedURIException;
        r5 = new java.lang.StringBuffer;
        r5.<init>();
        r6 = "Fragment contains invalid character:";
        r5 = r5.append(r6);
        r5 = r5.append(r3);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x012e:
        r1 = r1 + 1;
        goto L_0x003f;
    L_0x0132:
        r4 = r9.substring(r2, r1);
        r8.m_fragment = r4;
    L_0x0138:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.javax.xml.stream.xerces.util.URI.initializePath(java.lang.String):void");
    }

    public String getScheme() {
        return this.m_scheme;
    }

    public String getSchemeSpecificPart() {
        StringBuffer schemespec = new StringBuffer();
        if (!(this.m_userinfo == null && this.m_host == null && this.m_port == -1)) {
            schemespec.append("//");
        }
        if (this.m_userinfo != null) {
            schemespec.append(this.m_userinfo);
            schemespec.append('@');
        }
        if (this.m_host != null) {
            schemespec.append(this.m_host);
        }
        if (this.m_port != -1) {
            schemespec.append(':');
            schemespec.append(this.m_port);
        }
        if (this.m_path != null) {
            schemespec.append(this.m_path);
        }
        if (this.m_queryString != null) {
            schemespec.append('?');
            schemespec.append(this.m_queryString);
        }
        if (this.m_fragment != null) {
            schemespec.append('#');
            schemespec.append(this.m_fragment);
        }
        return schemespec.toString();
    }

    public String getUserinfo() {
        return this.m_userinfo;
    }

    public String getHost() {
        return this.m_host;
    }

    public int getPort() {
        return this.m_port;
    }

    public String getPath(boolean p_includeQueryString, boolean p_includeFragment) {
        StringBuffer pathString = new StringBuffer(this.m_path);
        if (p_includeQueryString && this.m_queryString != null) {
            pathString.append('?');
            pathString.append(this.m_queryString);
        }
        if (p_includeFragment && this.m_fragment != null) {
            pathString.append('#');
            pathString.append(this.m_fragment);
        }
        return pathString.toString();
    }

    public String getPath() {
        return this.m_path;
    }

    public String getQueryString() {
        return this.m_queryString;
    }

    public String getFragment() {
        return this.m_fragment;
    }

    public void setScheme(String p_scheme) throws MalformedURIException {
        if (p_scheme == null) {
            throw new MalformedURIException("Cannot set scheme from null string!");
        } else if (isConformantSchemeName(p_scheme)) {
            this.m_scheme = p_scheme.toLowerCase();
        } else {
            throw new MalformedURIException("The scheme is not conformant.");
        }
    }

    public void setUserinfo(String p_userinfo) throws MalformedURIException {
        if (p_userinfo == null) {
            this.m_userinfo = null;
        } else if (this.m_host == null) {
            throw new MalformedURIException("Userinfo cannot be set when host is null!");
        } else {
            int index = 0;
            int end = p_userinfo.length();
            while (index < end) {
                char testChar = p_userinfo.charAt(index);
                if (testChar == '%') {
                    if (index + 2 >= end || !isHex(p_userinfo.charAt(index + 1)) || !isHex(p_userinfo.charAt(index + 2))) {
                        throw new MalformedURIException("Userinfo contains invalid escape sequence!");
                    }
                } else if (!isUnreservedCharacter(testChar) && USERINFO_CHARACTERS.indexOf(testChar) == -1) {
                    throw new MalformedURIException(new StringBuffer().append("Userinfo contains invalid character:").append(testChar).toString());
                }
                index++;
            }
        }
        this.m_userinfo = p_userinfo;
    }

    public void setHost(String p_host) throws MalformedURIException {
        if (p_host == null || p_host.trim().length() == 0) {
            this.m_host = p_host;
            this.m_userinfo = null;
            this.m_port = -1;
        } else if (!isWellFormedAddress(p_host)) {
            throw new MalformedURIException("Host is not a well formed address!");
        }
        this.m_host = p_host;
    }

    public void setPort(int p_port) throws MalformedURIException {
        if (p_port < 0 || p_port > 65535) {
            if (p_port != -1) {
                throw new MalformedURIException("Invalid port number!");
            }
        } else if (this.m_host == null) {
            throw new MalformedURIException("Port cannot be set when host is null!");
        }
        this.m_port = p_port;
    }

    public void setPath(String p_path) throws MalformedURIException {
        if (p_path == null) {
            this.m_path = null;
            this.m_queryString = null;
            this.m_fragment = null;
            return;
        }
        initializePath(p_path);
    }

    public void appendPath(String p_addToPath) throws MalformedURIException {
        if (p_addToPath != null && p_addToPath.trim().length() != 0) {
            if (!isURIString(p_addToPath)) {
                throw new MalformedURIException("Path contains invalid character!");
            } else if (this.m_path == null || this.m_path.trim().length() == 0) {
                if (p_addToPath.startsWith("/")) {
                    this.m_path = p_addToPath;
                } else {
                    this.m_path = new StringBuffer().append("/").append(p_addToPath).toString();
                }
            } else if (this.m_path.endsWith("/")) {
                if (p_addToPath.startsWith("/")) {
                    this.m_path = this.m_path.concat(p_addToPath.substring(1));
                } else {
                    this.m_path = this.m_path.concat(p_addToPath);
                }
            } else if (p_addToPath.startsWith("/")) {
                this.m_path = this.m_path.concat(p_addToPath);
            } else {
                this.m_path = this.m_path.concat(new StringBuffer().append("/").append(p_addToPath).toString());
            }
        }
    }

    public void setQueryString(String p_queryString) throws MalformedURIException {
        if (p_queryString == null) {
            this.m_queryString = null;
        } else if (!isGenericURI()) {
            throw new MalformedURIException("Query string can only be set for a generic URI!");
        } else if (getPath() == null) {
            throw new MalformedURIException("Query string cannot be set when path is null!");
        } else if (isURIString(p_queryString)) {
            this.m_queryString = p_queryString;
        } else {
            throw new MalformedURIException("Query string contains invalid character!");
        }
    }

    public void setFragment(String p_fragment) throws MalformedURIException {
        if (p_fragment == null) {
            this.m_fragment = null;
        } else if (!isGenericURI()) {
            throw new MalformedURIException("Fragment can only be set for a generic URI!");
        } else if (getPath() == null) {
            throw new MalformedURIException("Fragment cannot be set when path is null!");
        } else if (isURIString(p_fragment)) {
            this.m_fragment = p_fragment;
        } else {
            throw new MalformedURIException("Fragment contains invalid character!");
        }
    }

    public boolean equals(Object p_test) {
        if (p_test instanceof URI) {
            URI testURI = (URI) p_test;
            if (((this.m_scheme == null && testURI.m_scheme == null) || !(this.m_scheme == null || testURI.m_scheme == null || !this.m_scheme.equals(testURI.m_scheme))) && (((this.m_userinfo == null && testURI.m_userinfo == null) || !(this.m_userinfo == null || testURI.m_userinfo == null || !this.m_userinfo.equals(testURI.m_userinfo))) && (((this.m_host == null && testURI.m_host == null) || !(this.m_host == null || testURI.m_host == null || !this.m_host.equals(testURI.m_host))) && this.m_port == testURI.m_port && (((this.m_path == null && testURI.m_path == null) || !(this.m_path == null || testURI.m_path == null || !this.m_path.equals(testURI.m_path))) && (((this.m_queryString == null && testURI.m_queryString == null) || !(this.m_queryString == null || testURI.m_queryString == null || !this.m_queryString.equals(testURI.m_queryString))) && ((this.m_fragment == null && testURI.m_fragment == null) || !(this.m_fragment == null || testURI.m_fragment == null || !this.m_fragment.equals(testURI.m_fragment)))))))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuffer uriSpecString = new StringBuffer();
        if (this.m_scheme != null) {
            uriSpecString.append(this.m_scheme);
            uriSpecString.append(':');
        }
        uriSpecString.append(getSchemeSpecificPart());
        return uriSpecString.toString();
    }

    public boolean isGenericURI() {
        return this.m_host != null;
    }

    public static boolean isConformantSchemeName(String p_scheme) {
        if (p_scheme == null || p_scheme.trim().length() == 0 || !isAlpha(p_scheme.charAt(0))) {
            return false;
        }
        for (int i = 1; i < p_scheme.length(); i++) {
            char testChar = p_scheme.charAt(i);
            if (!isAlphanum(testChar) && SCHEME_CHARACTERS.indexOf(testChar) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWellFormedAddress(String p_address) {
        if (p_address == null) {
            return false;
        }
        String address = p_address.trim();
        int addrLength = address.length();
        if (addrLength == 0 || addrLength > 255 || address.startsWith(".") || address.startsWith("-")) {
            return false;
        }
        int index = address.lastIndexOf(46);
        if (address.endsWith(".")) {
            index = address.substring(0, index).lastIndexOf(46);
        }
        int i;
        char testChar;
        if (index + 1 >= addrLength || !isDigit(p_address.charAt(index + 1))) {
            i = 0;
            while (i < addrLength) {
                testChar = address.charAt(i);
                if (testChar == '.') {
                    if (!isAlphanum(address.charAt(i - 1))) {
                        return false;
                    }
                    if (i + 1 < addrLength && !isAlphanum(address.charAt(i + 1))) {
                        return false;
                    }
                } else if (!(isAlphanum(testChar) || testChar == '-')) {
                    return false;
                }
                i++;
            }
        } else {
            int numDots = 0;
            i = 0;
            while (i < addrLength) {
                testChar = address.charAt(i);
                if (testChar == '.') {
                    if (!isDigit(address.charAt(i - 1))) {
                        return false;
                    }
                    if (i + 1 < addrLength && !isDigit(address.charAt(i + 1))) {
                        return false;
                    }
                    numDots++;
                } else if (!isDigit(testChar)) {
                    return false;
                }
                i++;
            }
            if (numDots != 3) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDigit(char p_char) {
        return p_char >= '0' && p_char <= '9';
    }

    private static boolean isHex(char p_char) {
        return isDigit(p_char) || ((p_char >= 'a' && p_char <= 'f') || (p_char >= 'A' && p_char <= 'F'));
    }

    private static boolean isAlpha(char p_char) {
        return (p_char >= 'a' && p_char <= 'z') || (p_char >= 'A' && p_char <= 'Z');
    }

    private static boolean isAlphanum(char p_char) {
        return isAlpha(p_char) || isDigit(p_char);
    }

    private static boolean isReservedCharacter(char p_char) {
        return RESERVED_CHARACTERS.indexOf(p_char) != -1;
    }

    private static boolean isUnreservedCharacter(char p_char) {
        return isAlphanum(p_char) || MARK_CHARACTERS.indexOf(p_char) != -1;
    }

    private static boolean isURIString(String p_uric) {
        if (p_uric == null) {
            return false;
        }
        int end = p_uric.length();
        int i = 0;
        while (i < end) {
            char testChar = p_uric.charAt(i);
            if (testChar == '%') {
                if (i + 2 >= end || !isHex(p_uric.charAt(i + 1)) || !isHex(p_uric.charAt(i + 2))) {
                    return false;
                }
                i += 2;
            } else if (isReservedCharacter(testChar)) {
                continue;
            } else if (!isUnreservedCharacter(testChar)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
