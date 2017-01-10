package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonHttpParser;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public final class JsonCParser extends JsonHttpParser {
    public <T> T parse(HttpResponse response, Class<T> dataClass) throws IOException {
        return Json.parseAndClose(parserForResponse(response), (Class) dataClass, null);
    }

    public static JsonParser parserForResponse(HttpResponse response) throws IOException {
        String contentType = response.contentType;
        if (contentType == null || !contentType.startsWith(Json.CONTENT_TYPE)) {
            throw new IllegalArgumentException("Wrong content type: expected <application/json> but got <" + contentType + ">");
        }
        boolean failed = true;
        JsonParser parser = JsonHttpParser.parserForResponse(response);
        try {
            Json.skipToKey(parser, response.isSuccessStatusCode ? "data" : "error");
            if (parser.getCurrentToken() == JsonToken.END_OBJECT) {
                throw new IllegalArgumentException("data key not found");
            }
            failed = false;
            return parser;
        } finally {
            if (failed) {
                parser.close();
            }
        }
    }
}
