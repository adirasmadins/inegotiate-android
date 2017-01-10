package com.google.gdata.wireformats.input;

import com.google.gdata.wireformats.StreamPropertiesBuilder;

public class InputPropertiesBuilder extends StreamPropertiesBuilder<InputPropertiesBuilder> {
    private Class<?> expectType;

    private static class InputPropertiesImpl extends StreamPropertiesImpl implements InputProperties {
        private final Class<?> expectType;

        private InputPropertiesImpl(InputPropertiesBuilder builder) {
            super(builder);
            this.expectType = builder.expectType;
        }

        public Class<?> getRootType() {
            return this.expectType;
        }
    }

    public InputPropertiesBuilder(InputProperties source) {
        super(source);
        this.expectType = source.getRootType();
    }

    public InputPropertiesBuilder setExpectType(Class<?> expectType) {
        this.expectType = expectType;
        return this;
    }

    public InputProperties build() {
        return new InputPropertiesImpl();
    }
}
