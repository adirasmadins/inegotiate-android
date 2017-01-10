package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.Json;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.FieldInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.codehaus.jackson.JsonParser;

public final class JsonMultiKindFeedParser<T> extends AbstractJsonFeedParser<T> {
    private final HashMap<String, Class<?>> kindToItemClassMap;

    public JsonMultiKindFeedParser(JsonParser parser, Class<T> feedClass, Class<?>... itemClasses) {
        super(parser, feedClass);
        this.kindToItemClassMap = new HashMap();
        HashMap<String, Class<?>> kindToItemClassMap = this.kindToItemClassMap;
        for (Class<?> itemClass : itemClasses) {
            Field field = ClassInfo.of(itemClass).getField("kind");
            if (field == null) {
                throw new IllegalArgumentException("missing kind field for " + itemClass.getName());
            }
            String kind = (String) FieldInfo.getFieldValue(field, ClassInfo.newInstance(itemClass));
            if (kind == null) {
                throw new IllegalArgumentException("missing value for kind field in " + itemClass.getName());
            }
            kindToItemClassMap.put(kind, itemClass);
        }
    }

    Object parseItemInternal() throws IOException {
        this.parser.nextToken();
        String key = this.parser.getCurrentName();
        if (key != "kind") {
            throw new IllegalArgumentException("expected kind field: " + key);
        }
        this.parser.nextToken();
        String kind = this.parser.getText();
        Class itemClass = (Class) this.kindToItemClassMap.get(kind);
        if (itemClass != null) {
            return Json.parse(this.parser, itemClass, null);
        }
        throw new IllegalArgumentException("unrecognized kind: " + kind);
    }

    public static <T, I> JsonMultiKindFeedParser<T> use(HttpResponse response, Class<T> feedClass, Class<?>... itemClasses) throws IOException {
        return new JsonMultiKindFeedParser(JsonCParser.parserForResponse(response), feedClass, itemClasses);
    }
}
