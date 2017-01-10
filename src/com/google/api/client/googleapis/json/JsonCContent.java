package com.google.api.client.googleapis.json;

import com.google.api.client.json.Json;
import com.google.api.client.json.JsonHttpContent;
import java.io.IOException;
import java.io.OutputStream;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;

public final class JsonCContent extends JsonHttpContent {
    public void writeTo(OutputStream out) throws IOException {
        JsonGenerator generator = Json.JSON_FACTORY.createJsonGenerator(out, JsonEncoding.UTF8);
        generator.writeStartObject();
        generator.writeFieldName("data");
        Json.serialize(generator, this.data);
        generator.writeEndObject();
        generator.close();
    }
}
