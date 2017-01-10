package com.google.gdata.util.httputil;

import com.google.common.collect.Lists;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.parser.Chset;
import com.google.gdata.util.parser.Parser;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

public class FormUrlDecoder {
    private static Parser<Result> parser;

    @Deprecated
    public interface Callback {
        void handleParameter(String str, String str2);
    }

    /* renamed from: com.google.gdata.util.httputil.FormUrlDecoder.1 */
    static class C07791 implements Callback {
        final /* synthetic */ AtomicReference val$outMap;

        C07791(AtomicReference atomicReference) {
            this.val$outMap = atomicReference;
        }

        public void handleParameter(String name, String value) {
            ParamMap map = (ParamMap) this.val$outMap.get();
            if (map == null) {
                map = new ParamMap();
                this.val$outMap.set(map);
            }
            map.append(name, value);
        }
    }

    private static class NameAction implements com.google.gdata.util.parser.Callback<Result> {
        private NameAction() {
        }

        public void handle(char[] buf, int start, int end, Result result) {
            Parameter param = new Parameter();
            param.name = FormUrlDecoder.decodeString(buf, start, end, result.encoding);
            result.params.addLast(param);
        }
    }

    private static class Parameter {
        String name;
        String value;

        private Parameter() {
            this.name = null;
            this.value = StringUtil.EMPTY_STRING;
        }
    }

    private static class Result {
        String encoding;
        LinkedList<Parameter> params;

        public Result(String encoding) {
            this.params = Lists.newLinkedList();
            if (encoding == null) {
                encoding = "ISO-8859-1";
            }
            this.encoding = encoding;
        }
    }

    private static class ValueAction implements com.google.gdata.util.parser.Callback<Result> {
        private ValueAction() {
        }

        public void handle(char[] buf, int start, int end, Result result) {
            ((Parameter) result.params.getLast()).value = FormUrlDecoder.decodeString(buf, start, end, result.encoding);
        }
    }

    private FormUrlDecoder() {
    }

    @Deprecated
    public static void parseWithCallback(String str, String encoding, Callback callback) {
        if (!StringUtil.isEmpty(str)) {
            Object result = new Result(encoding);
            parser.parse(str, result);
            Iterator i$ = result.params.iterator();
            while (i$.hasNext()) {
                Parameter param = (Parameter) i$.next();
                callback.handleParameter(param.name, param.value);
            }
        }
    }

    @Deprecated
    public static ParamMap parse(String str, ParamMap map, String encoding) {
        if (!StringUtil.EMPTY_STRING.equals(str)) {
            AtomicReference<ParamMap> outMap = new AtomicReference(map);
            parseWithCallback(str, encoding, new C07791(outMap));
            return (ParamMap) outMap.get();
        } else if (map == null) {
            return new ParamMap();
        } else {
            return map;
        }
    }

    private static String getCanonicalEncodingName(String charset) {
        String canonicalName = charset;
        if (charset != null && charset.length() > 0) {
            try {
                canonicalName = Charset.forName(charset).name();
            } catch (UnsupportedCharsetException e) {
            } catch (IllegalCharsetNameException e2) {
            }
        }
        return canonicalName;
    }

    private static String decodeString(char[] buf, int start, int end, String encoding) {
        String str = new String(buf, start, end - start);
        try {
            if (requiresByteLevelDecoding(encoding)) {
                return new String(URLDecoder.decode(str, "ISO-8859-1").getBytes("ISO-8859-1"), encoding);
            }
            return URLDecoder.decode(str, encoding);
        } catch (IllegalArgumentException e) {
            return str;
        } catch (UnsupportedEncodingException e2) {
            return str;
        }
    }

    private static boolean requiresByteLevelDecoding(String encoding) {
        encoding = getCanonicalEncodingName(encoding).toUpperCase();
        return encoding.endsWith("SHIFT_JIS") || encoding.endsWith("WINDOWS-31J");
    }

    static {
        Chset nameToken = Chset.difference(Chset.ANYCHAR, new Chset("&="));
        Chset valueToken = Chset.difference(Chset.ANYCHAR, new Chset("&"));
        parser = Parser.sequence(nameToken.star().action(new NameAction()), Parser.sequence(new Chset('='), valueToken.plus().action(new ValueAction()).optional()).optional()).list(new Chset('&')).optional();
    }
}
