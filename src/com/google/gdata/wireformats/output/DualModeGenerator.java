package com.google.gdata.wireformats.output;

import com.google.gdata.model.Element;
import java.io.IOException;
import java.io.Writer;

public abstract class DualModeGenerator<T> extends WireFormatOutputGenerator<T> {
    private final CharacterGenerator<T> oldGen;

    protected DualModeGenerator(CharacterGenerator<T> oldGen) {
        this.oldGen = oldGen;
    }

    public void generate(Writer contentWriter, OutputProperties outProps, T source) throws IOException {
        if (isNewModel(source)) {
            super.generate(contentWriter, outProps, source);
        } else {
            this.oldGen.generate(contentWriter, outProps, (Object) source);
        }
    }

    private boolean isNewModel(T source) {
        return source instanceof Element;
    }
}
