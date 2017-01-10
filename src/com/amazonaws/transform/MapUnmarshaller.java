package com.amazonaws.transform;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.JsonToken;

public class MapUnmarshaller<K, V> implements Unmarshaller<Map<K, V>, JsonUnmarshallerContext> {
    private final Unmarshaller<K, JsonUnmarshallerContext> keyUnmarshaller;
    private final Unmarshaller<V, JsonUnmarshallerContext> valueUnmarshaller;

    public MapUnmarshaller(Unmarshaller<K, JsonUnmarshallerContext> unmarshaller, Unmarshaller<V, JsonUnmarshallerContext> unmarshaller2) {
        this.keyUnmarshaller = unmarshaller;
        this.valueUnmarshaller = unmarshaller2;
    }

    public Map<K, V> unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        Map hashMap = new HashMap();
        int currentDepth = jsonUnmarshallerContext.getCurrentDepth();
        while (true) {
            JsonToken nextToken = jsonUnmarshallerContext.nextToken();
            if (nextToken != null) {
                if (nextToken != JsonToken.FIELD_NAME) {
                    if ((nextToken == JsonToken.END_ARRAY || nextToken == JsonToken.END_OBJECT) && jsonUnmarshallerContext.getCurrentDepth() <= currentDepth) {
                        break;
                    }
                }
                hashMap.put(this.keyUnmarshaller.unmarshall(jsonUnmarshallerContext), this.valueUnmarshaller.unmarshall(jsonUnmarshallerContext));
            } else {
                break;
            }
        }
        return hashMap;
    }
}
