package com.google.gdata.wireformats;

import com.google.gdata.wireformats.XmlGenerator.ElementGenerator;

public class XmlWireFormatProperties {
    private ElementGenerator elementGenerator;

    public XmlWireFormatProperties setElementGenerator(ElementGenerator elementGenerator) {
        this.elementGenerator = elementGenerator;
        return this;
    }

    public ElementGenerator getElementGenerator() {
        return this.elementGenerator;
    }
}
