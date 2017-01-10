package com.google.gdata.wireformats.output;

import com.google.gdata.data.IAtom;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.WireFormat;

public class RssDualGenerator extends DualModeGenerator<IAtom> {
    public RssDualGenerator() {
        super(new RssGenerator());
    }

    public Class<IAtom> getSourceType() {
        return IAtom.class;
    }

    public AltFormat getAltFormat() {
        return AltFormat.RSS;
    }

    public WireFormat getWireFormat() {
        return WireFormat.XML;
    }
}
