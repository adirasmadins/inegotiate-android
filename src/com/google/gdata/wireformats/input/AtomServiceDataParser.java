package com.google.gdata.wireformats.input;

import com.google.gdata.data.XmlEventSource;
import com.google.gdata.data.introspection.ServiceDocument;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.wireformats.AltFormat;
import java.io.IOException;
import java.io.Reader;

public class AtomServiceDataParser extends XmlInputParser<ServiceDocument> {
    public AtomServiceDataParser() {
        super(AltFormat.ATOM_SERVICE, ServiceDocument.class);
    }

    protected <R extends ServiceDocument> R parse(XmlEventSource eventSource, InputProperties inProps, Class<R> cls) {
        throw new IllegalStateException("Parsing from XmlEventSource not supported");
    }

    public <R extends ServiceDocument> R parse(Reader inputReader, InputProperties inProps, Class<R> resultClass) throws IOException, ServiceException {
        Preconditions.checkNotNull(inProps.getExtensionProfile(), "No extension profile");
        ServiceDocument serviceDoc = (ServiceDocument) createResult(resultClass);
        serviceDoc.parse(inProps.getExtensionProfile(), inputReader);
        return serviceDoc;
    }
}
