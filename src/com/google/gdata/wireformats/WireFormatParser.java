package com.google.gdata.wireformats;

import com.google.gdata.model.Element;
import com.google.gdata.util.ParseException;
import java.io.IOException;

public interface WireFormatParser {
    Element parse(Element element) throws IOException, ParseException, ContentCreationException, ContentValidationException;
}
