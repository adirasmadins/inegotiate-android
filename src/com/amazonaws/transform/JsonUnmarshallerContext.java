package com.amazonaws.transform;

import com.amazonaws.http.HttpResponse;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.impl.JsonWriteContext;

public class JsonUnmarshallerContext {
    private String currentField;
    public JsonToken currentToken;
    private final HttpResponse httpResponse;
    private final JsonParser jsonParser;
    private Map<String, String> metadata;
    private List<MetadataExpression> metadataExpressions;
    private JsonToken nextToken;
    private final Stack<String> stack;
    private String stackString;

    /* renamed from: com.amazonaws.transform.JsonUnmarshallerContext.1 */
    static /* synthetic */ class C01111 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$JsonToken;

        static {
            $SwitchMap$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.FIELD_NAME.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private class MetadataExpression {
        public String expression;
        public String key;
        public int targetDepth;

        public MetadataExpression(String str, int i, String str2) {
            this.expression = str;
            this.targetDepth = i;
            this.key = str2;
        }
    }

    public JsonUnmarshallerContext(JsonParser jsonParser) {
        this(jsonParser, null);
    }

    public JsonUnmarshallerContext(JsonParser jsonParser, HttpResponse httpResponse) {
        this.stack = new Stack();
        this.stackString = StringUtil.EMPTY_STRING;
        this.metadata = new HashMap();
        this.metadataExpressions = new ArrayList();
        this.jsonParser = jsonParser;
        this.httpResponse = httpResponse;
    }

    private void rebuildStackString() {
        this.stackString = StringUtil.EMPTY_STRING;
        Iterator it = this.stack.iterator();
        while (it.hasNext()) {
            this.stackString += "/" + ((String) it.next());
        }
        if (this.currentField != null) {
            this.stackString += "/" + this.currentField;
        }
        if (this.stackString == StringUtil.EMPTY_STRING) {
            this.stackString = "/";
        }
    }

    private void updateContext() throws IOException {
        if (this.currentToken != null) {
            if (this.currentToken == JsonToken.START_OBJECT || this.currentToken == JsonToken.START_ARRAY) {
                if (this.currentField != null) {
                    this.stack.push(this.currentField);
                    this.currentField = null;
                }
            } else if (this.currentToken == JsonToken.END_OBJECT || this.currentToken == JsonToken.END_ARRAY) {
                if (!this.stack.isEmpty()) {
                    this.stack.pop();
                }
                this.currentField = null;
            } else if (this.currentToken == JsonToken.FIELD_NAME) {
                this.currentField = this.jsonParser.getText();
            }
            rebuildStackString();
        }
    }

    public int getCurrentDepth() {
        int size = this.stack.size();
        return this.currentField != null ? size + 1 : size;
    }

    public String getHeader(String str) {
        return this.httpResponse == null ? null : (String) this.httpResponse.getHeaders().get(str);
    }

    public HttpResponse getHttpResponse() {
        return this.httpResponse;
    }

    public JsonParser getJsonParser() {
        return this.jsonParser;
    }

    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    public boolean isStartOfDocument() {
        return this.jsonParser == null || this.jsonParser.getCurrentToken() == null;
    }

    public JsonToken nextToken() throws IOException {
        JsonToken nextToken = this.nextToken != null ? this.nextToken : this.jsonParser.nextToken();
        this.currentToken = nextToken;
        this.nextToken = null;
        updateContext();
        return nextToken;
    }

    public JsonToken peek() throws IOException {
        if (this.nextToken != null) {
            return this.nextToken;
        }
        this.nextToken = this.jsonParser.nextToken();
        return this.nextToken;
    }

    public String readText() throws IOException {
        switch (C01111.$SwitchMap$org$codehaus$jackson$JsonToken[this.currentToken.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return this.jsonParser.getText();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return "false";
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return "true";
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                return null;
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                return this.jsonParser.getNumberValue().toString();
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
                return this.jsonParser.getText();
            default:
                throw new RuntimeException("We expected a VALUE token but got: " + this.currentToken);
        }
    }

    public void registerMetadataExpression(String str, int i, String str2) {
        this.metadataExpressions.add(new MetadataExpression(str, i, str2));
    }

    public boolean testExpression(String str) {
        return str.equals(".") ? true : this.stackString.endsWith(str);
    }

    public boolean testExpression(String str, int i) {
        if (str.equals(".")) {
            return true;
        }
        int i2 = -1;
        while (true) {
            i2 = str.indexOf("/", i2 + 1);
            if (i2 <= -1) {
                break;
            } else if (str.charAt(i2 + 1) != '@') {
                i++;
            }
        }
        boolean z = this.stackString.endsWith(new StringBuilder().append("/").append(str).toString()) && i == getCurrentDepth();
        return z;
    }

    public String toString() {
        return this.stackString;
    }
}
