package com.google.gdata.wireformats;

import com.google.gdata.model.Element;
import java.io.IOException;

public interface WireFormatGenerator {
    void generate(Element element) throws IOException, ContentValidationException;
}
