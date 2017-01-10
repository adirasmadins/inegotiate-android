package com.google.gdata.wireformats.output;

import com.google.gdata.wireformats.ForwardingStreamProperties;

public class ForwardingOutputProperties extends ForwardingStreamProperties implements OutputProperties {
    public ForwardingOutputProperties(OutputProperties delegate) {
        super(delegate);
    }
}
