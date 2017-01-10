package com.google.gdata.wireformats.output;

import com.google.gdata.wireformats.StreamPropertiesBuilder;

public class OutputPropertiesBuilder extends StreamPropertiesBuilder<OutputPropertiesBuilder> {

    private static class OutputPropertiesImpl extends StreamPropertiesImpl implements OutputProperties {
        private OutputPropertiesImpl(OutputPropertiesBuilder builder) {
            super(builder);
        }
    }

    public OutputPropertiesBuilder(OutputProperties source) {
        super(source);
    }

    public OutputProperties build() {
        return new OutputPropertiesImpl();
    }
}
