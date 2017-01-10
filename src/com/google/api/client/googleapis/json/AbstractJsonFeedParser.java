package com.google.api.client.googleapis.json;

import com.google.api.client.json.CustomizeJsonParser;
import com.google.api.client.json.Json;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public abstract class AbstractJsonFeedParser<T> {
    final Class<T> feedClass;
    private boolean feedParsed;
    final JsonParser parser;

    final class StopAtItems extends CustomizeJsonParser {
        StopAtItems() {
        }

        public boolean stopAt(Object context, String key) {
            return "items".equals(key) && context.getClass().equals(AbstractJsonFeedParser.this.feedClass);
        }
    }

    abstract Object parseItemInternal() throws IOException;

    AbstractJsonFeedParser(JsonParser parser, Class<T> feedClass) {
        this.parser = parser;
        this.feedClass = feedClass;
    }

    public T parseFeed() throws IOException {
        boolean close = true;
        try {
            this.feedParsed = true;
            T result = Json.parse(this.parser, this.feedClass, new StopAtItems());
            close = false;
            return result;
        } finally {
            if (close) {
                close();
            }
        }
    }

    public Object parseNextItem() throws IOException {
        JsonParser parser = this.parser;
        if (!this.feedParsed) {
            this.feedParsed = true;
            Json.skipToKey(parser, "items");
        }
        try {
            if (parser.nextToken() != JsonToken.START_OBJECT) {
                return null;
            }
            Object result = parseItemInternal();
            if (!false) {
                return result;
            }
            close();
            return result;
        } finally {
            if (true) {
                close();
            }
        }
    }

    public void close() throws IOException {
        this.parser.close();
    }
}
