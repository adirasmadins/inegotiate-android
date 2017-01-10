package com.google.gdata.wireformats.output;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.wireformats.ContentValidationException;
import com.google.gdata.wireformats.WireFormat;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

public abstract class WireFormatOutputGenerator<T> extends CharacterGenerator<T> {
    public abstract WireFormat getWireFormat();

    public void generate(Writer w, OutputProperties outProps, T source) throws IOException {
        if (source instanceof Element) {
            Element elem = (Element) source;
            try {
                ElementMetadata<?, ?> outputMetadata = outProps.getRootMetadata();
                if (outputMetadata == null) {
                    throw new IllegalStateException("No metadata for " + elem.getElementKey());
                }
                elem = elem.resolve(outputMetadata);
                if (!elem.getElementKey().equals(outputMetadata.getKey())) {
                    outputMetadata = outputMetadata.getSchema().bind(elem.getElementKey(), outputMetadata.getContext());
                    if (outputMetadata == null) {
                        throw new IllegalStateException("Unable to rebind from " + outProps.getRootMetadata().getKey() + " to " + elem.getElementKey());
                    }
                    outProps = ((OutputPropertiesBuilder) new OutputPropertiesBuilder(outProps).setElementMetadata(outputMetadata)).build();
                }
                getWireFormat().createGenerator(outProps, w, Charset.forName(CharacterGenerator.getCharsetEncoding(outProps)), usePrettyPrint(outProps)).generate(elem);
                w.flush();
                return;
            } catch (ContentValidationException e) {
                throw new IOException("Invalid content: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("Output object was not an Element: " + source);
    }
}
