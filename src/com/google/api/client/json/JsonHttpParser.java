package com.google.api.client.json;

import com.google.api.client.http.HttpParser;
import com.google.api.client.http.HttpResponse;
import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.JsonParser;

public class JsonHttpParser implements HttpParser {
    public String contentType;

    public JsonHttpParser() {
        this.contentType = Json.CONTENT_TYPE;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public <T> T parse(HttpResponse response, Class<T> dataClass) throws IOException {
        return Json.parseAndClose(parserForResponse(response), (Class) dataClass, null);
    }

    public static JsonParser parserForResponse(HttpResponse response) throws IOException {
        InputStream content = response.getContent();
        try {
            JsonParser parser = Json.JSON_FACTORY.createJsonParser(content);
            parser.nextToken();
            content = null;
            return parser;
        } finally {
            if (content != null) {
                content.close();
            }
        }
    }
}
