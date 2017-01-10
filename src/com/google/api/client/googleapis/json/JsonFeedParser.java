package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.Json;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

public final class JsonFeedParser<T, I> extends AbstractJsonFeedParser<T> {
    private final Class<I> itemClass;

    public JsonFeedParser(JsonParser parser, Class<T> feedClass, Class<I> itemClass) {
        super(parser, feedClass);
        this.itemClass = itemClass;
    }

    public I parseNextItem() throws IOException {
        return super.parseNextItem();
    }

    Object parseItemInternal() throws IOException {
        return Json.parse(this.parser, this.itemClass, null);
    }

    public static <T, I> JsonFeedParser<T, I> use(HttpResponse response, Class<T> feedClass, Class<I> itemClass) throws IOException {
        return new JsonFeedParser(JsonCParser.parserForResponse(response), feedClass, itemClass);
    }
}
