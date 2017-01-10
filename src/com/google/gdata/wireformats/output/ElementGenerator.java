package com.google.gdata.wireformats.output;

import com.google.gdata.model.Element;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.WireFormat;

public class ElementGenerator<E extends Element> extends WireFormatOutputGenerator<E> {
    private final AltFormat altFormat;
    private final Class<E> inputType;

    public static <E extends Element> ElementGenerator<E> of(AltFormat altFormat, Class<E> inputType) {
        return new ElementGenerator(altFormat, inputType);
    }

    private ElementGenerator(AltFormat altFormat, Class<E> inputType) {
        this.altFormat = altFormat;
        this.inputType = inputType;
    }

    public WireFormat getWireFormat() {
        return this.altFormat.getWireFormat();
    }

    public AltFormat getAltFormat() {
        return this.altFormat;
    }

    public Class<E> getSourceType() {
        return this.inputType;
    }
}
