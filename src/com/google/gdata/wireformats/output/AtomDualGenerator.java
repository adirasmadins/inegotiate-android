package com.google.gdata.wireformats.output;

import com.google.gdata.data.IAtom;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.WireFormat;

public class AtomDualGenerator extends DualModeGenerator<IAtom> {
    private AltFormat altFormat;

    public AtomDualGenerator() {
        super(new AtomGenerator());
        this.altFormat = AltFormat.ATOM;
    }

    public AtomDualGenerator(AltFormat altFormat) {
        super(new AtomGenerator());
        this.altFormat = AltFormat.ATOM;
        this.altFormat = altFormat;
    }

    public Class<IAtom> getSourceType() {
        return IAtom.class;
    }

    public AltFormat getAltFormat() {
        return this.altFormat;
    }

    public WireFormat getWireFormat() {
        return WireFormat.XML;
    }
}
