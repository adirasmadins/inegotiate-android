package com.google.gdata.wireformats.input;

import com.google.gdata.wireformats.ForwardingStreamProperties;

public class ForwardingInputProperties extends ForwardingStreamProperties implements InputProperties {
    private final InputProperties delegate;

    public ForwardingInputProperties(InputProperties delegate) {
        super(delegate);
        this.delegate = delegate;
    }

    public Class<?> getRootType() {
        return this.delegate.getRootType();
    }
}
