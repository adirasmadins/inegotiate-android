package com.google.gdata.wireformats.input;

import com.google.gdata.data.IAtom;
import com.google.gdata.data.ParseSource;
import com.google.gdata.model.Element;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.wireformats.AltFormat;
import java.io.IOException;

public class AtomDualParser implements InputParser<IAtom> {
    private final InputParser<IAtom> dataParser;
    private final InputParser<IAtom> elementParser;

    public AtomDualParser() {
        this.dataParser = new AtomDataParser();
        this.elementParser = ElementParser.of(AltFormat.ATOM, IAtom.class);
    }

    public AltFormat getAltFormat() {
        return AltFormat.ATOM;
    }

    public Class<IAtom> getResultType() {
        return IAtom.class;
    }

    public <R extends IAtom> R parse(ParseSource parseSource, InputProperties inProps, Class<R> resultClass) throws IOException, ServiceException {
        Preconditions.checkNotNull(parseSource, "parseSource");
        Preconditions.checkNotNull(inProps, "inProps");
        Preconditions.checkNotNull("resultClass", resultClass);
        if (Element.class.isAssignableFrom(resultClass)) {
            return (IAtom) this.elementParser.parse(parseSource, inProps, resultClass);
        }
        return (IAtom) this.dataParser.parse(parseSource, inProps, resultClass);
    }
}
