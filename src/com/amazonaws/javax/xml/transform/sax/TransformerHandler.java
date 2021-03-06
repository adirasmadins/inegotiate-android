package com.amazonaws.javax.xml.transform.sax;

import com.amazonaws.javax.xml.transform.Result;
import com.amazonaws.javax.xml.transform.Transformer;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.ext.LexicalHandler;

public interface TransformerHandler extends ContentHandler, LexicalHandler, DTDHandler {
    String getSystemId();

    Transformer getTransformer();

    void setResult(Result result) throws IllegalArgumentException;

    void setSystemId(String str);
}
