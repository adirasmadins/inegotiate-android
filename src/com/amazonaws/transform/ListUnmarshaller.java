package com.amazonaws.transform;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonToken;

public class ListUnmarshaller<T> implements Unmarshaller<List<T>, JsonUnmarshallerContext> {
    private final Unmarshaller<T, JsonUnmarshallerContext> itemUnmarshaller;

    public ListUnmarshaller(Unmarshaller<T, JsonUnmarshallerContext> unmarshaller) {
        this.itemUnmarshaller = unmarshaller;
    }

    public List<T> unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        List arrayList = new ArrayList();
        int currentDepth = jsonUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        while (true) {
            JsonToken nextToken = jsonUnmarshallerContext.nextToken();
            if (nextToken == null) {
                break;
            } else if (nextToken != JsonToken.START_ARRAY) {
                if (nextToken != JsonToken.END_ARRAY && nextToken != JsonToken.END_OBJECT) {
                    arrayList.add(this.itemUnmarshaller.unmarshall(jsonUnmarshallerContext));
                } else if (jsonUnmarshallerContext.getCurrentDepth() < currentDepth) {
                    break;
                }
            }
        }
        return arrayList;
    }
}
