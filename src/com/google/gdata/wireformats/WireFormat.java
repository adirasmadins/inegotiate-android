package com.google.gdata.wireformats;

import com.google.gdata.data.XmlEventSource;
import com.google.gdata.wireformats.input.InputProperties;
import com.google.gdata.wireformats.output.OutputProperties;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public abstract class WireFormat {
    public static final List<WireFormat> ALL;
    public static final XmlWireFormat XML;
    protected final String name;

    public abstract WireFormatGenerator createGenerator(OutputProperties outputProperties, Writer writer, Charset charset, boolean z);

    public abstract WireFormatParser createParser(InputProperties inputProperties, Reader reader, Charset charset);

    static {
        XML = new XmlWireFormat();
        ALL = Arrays.asList(new WireFormat[]{XML});
    }

    protected WireFormat(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public WireFormatParser createParser(InputProperties inProps, XmlEventSource source) {
        throw new UnsupportedOperationException("Wire format does not support xml event sources.");
    }
}
