package com.google.gdata.wireformats.output;

import com.google.gdata.client.GDataProtocol.Parameter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public abstract class CharacterGenerator<S> implements OutputGenerator<S> {
    public abstract void generate(Writer writer, OutputProperties outputProperties, S s) throws IOException;

    protected static String getCharsetEncoding(OutputProperties outProps) {
        String charset = null;
        if (outProps.getContentType() != null) {
            charset = outProps.getContentType().getCharset();
        }
        if (charset == null) {
            return "utf-8";
        }
        return charset;
    }

    protected Writer getContentWriter(OutputProperties outProps, OutputStream contentStream) throws IOException {
        return new OutputStreamWriter(contentStream, getCharsetEncoding(outProps));
    }

    public void generate(OutputStream contentStream, OutputProperties outProps, S s) throws IOException {
        generate(getContentWriter(outProps, contentStream), outProps, (Object) s);
    }

    protected boolean usePrettyPrint(OutputProperties outProps) {
        return Boolean.parseBoolean(outProps.getQueryParameter(Parameter.PRETTYPRINT));
    }
}
