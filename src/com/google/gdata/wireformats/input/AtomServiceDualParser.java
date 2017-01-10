package com.google.gdata.wireformats.input;

import com.google.gdata.data.ParseSource;
import com.google.gdata.data.introspection.IServiceDocument;
import com.google.gdata.data.introspection.ServiceDocument;
import com.google.gdata.model.Element;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.wireformats.AltFormat;
import java.io.IOException;

public class AtomServiceDualParser implements InputParser<IServiceDocument> {
    private final InputParser<ServiceDocument> dataParser;
    private final InputParser<IServiceDocument> elementParser;

    public AtomServiceDualParser() {
        this.dataParser = new AtomServiceDataParser();
        this.elementParser = ElementParser.of(AltFormat.ATOM_SERVICE, IServiceDocument.class);
    }

    public AltFormat getAltFormat() {
        return AltFormat.ATOM_SERVICE;
    }

    public Class<IServiceDocument> getResultType() {
        return IServiceDocument.class;
    }

    public <R extends IServiceDocument> R parse(ParseSource parseSource, InputProperties inProps, Class<R> resultClass) throws IOException, ServiceException {
        Preconditions.checkNotNull(parseSource, "parseSource");
        Preconditions.checkNotNull(inProps, "inProps");
        Preconditions.checkNotNull("resultClass", resultClass);
        if (Element.class.isAssignableFrom(resultClass)) {
            IServiceDocument iServiceDocument = (IServiceDocument) this.elementParser.parse(parseSource, inProps, resultClass);
        }
        if (ServiceDocument.class.isAssignableFrom(resultClass)) {
            return (IServiceDocument) this.dataParser.parse(parseSource, inProps, resultClass);
        }
        throw new IllegalArgumentException("Invalid result type:" + resultClass);
    }
}
