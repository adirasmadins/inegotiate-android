package com.google.gdata.wireformats.output;

import com.google.gdata.data.introspection.IServiceDocument;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.WireFormat;

public class AtomServiceDualGenerator extends DualModeGenerator<IServiceDocument> {
    public AtomServiceDualGenerator() {
        super(new AtomServiceGenerator());
    }

    public AltFormat getAltFormat() {
        return AltFormat.ATOM_SERVICE;
    }

    public Class<IServiceDocument> getSourceType() {
        return IServiceDocument.class;
    }

    public WireFormat getWireFormat() {
        return WireFormat.XML;
    }
}
