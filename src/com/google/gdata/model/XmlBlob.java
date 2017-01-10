package com.google.gdata.model;

import com.google.gdata.util.ParseException;
import com.google.gdata.util.common.base.Charsets;
import com.google.gdata.wireformats.ContentCreationException;
import com.google.gdata.wireformats.ContentValidationException;
import com.google.gdata.wireformats.WireFormat;
import com.google.gdata.wireformats.input.InputPropertiesBuilder;
import com.google.gdata.wireformats.output.OutputPropertiesBuilder;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;

public class XmlBlob extends Element {
    public static final ElementKey<Void, XmlBlob> KEY;

    static {
        KEY = ElementKey.of(null, XmlBlob.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public XmlBlob(ElementKey<?, ? extends XmlBlob> key) {
        super((ElementKey) key);
    }

    public String getLang() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public void setLang(String v) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public String getBase() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public void setBase(String v) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public String getBlob() {
        StringWriter sw = new StringWriter();
        try {
            WireFormat.XML.createGenerator(new OutputPropertiesBuilder().build(), sw, Charsets.UTF_8, false).generate(this);
            return sw.toString();
        } catch (ContentValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void setBlob(String v) {
        clear();
        try {
            WireFormat.XML.createParser(new InputPropertiesBuilder().build(), new StringReader(v), Charset.forName("utf-8")).parse(this);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (ContentCreationException e2) {
            throw new RuntimeException(e2);
        } catch (ContentValidationException e3) {
            throw new RuntimeException(e3);
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }

    public String getFullText() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public void setFullText(String v) {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
