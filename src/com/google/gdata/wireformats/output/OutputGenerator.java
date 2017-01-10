package com.google.gdata.wireformats.output;

import com.google.gdata.wireformats.AltFormat;
import java.io.IOException;
import java.io.OutputStream;

public interface OutputGenerator<S> {
    void generate(OutputStream outputStream, OutputProperties outputProperties, S s) throws IOException;

    AltFormat getAltFormat();

    Class<S> getSourceType();
}
