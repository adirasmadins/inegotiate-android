package com.google.api.client.json;

import com.google.api.client.http.HttpContent;
import java.io.IOException;
import java.io.OutputStream;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;

public class JsonHttpContent implements HttpContent {
    public String contentType;
    public Object data;

    public JsonHttpContent() {
        this.contentType = Json.CONTENT_TYPE;
    }

    public long getLength() {
        return -1;
    }

    public final String getEncoding() {
        return null;
    }

    public String getType() {
        return Json.CONTENT_TYPE;
    }

    public void writeTo(OutputStream out) throws IOException {
        JsonGenerator generator = Json.JSON_FACTORY.createJsonGenerator(out, JsonEncoding.UTF8);
        Json.serialize(generator, this.data);
        generator.close();
    }
}
