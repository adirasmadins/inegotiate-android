package com.google.gdata.data.batch;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.xml.sax.Attributes;

public class BatchOperation extends ExtensionPoint implements Extension {
    private BatchOperationType type;

    private class BatchOperationHandler extends ExtensionHandler {
        public BatchOperationHandler(ExtensionProfile profile, Attributes attrs) throws ParseException {
            super(BatchOperation.this, profile, BatchOperation.class);
            String operationType = attrs.getValue("type");
            BatchOperationType op = BatchOperationType.forName(operationType);
            if (op == null) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidBatchOperationType);
                pe.setInternalReason("Invalid type for batch:operation: '" + operationType + "'");
                throw pe;
            }
            BatchOperation.this.type = op;
        }
    }

    public BatchOperation(BatchOperationType type) {
        this.type = type;
    }

    public static ExtensionDescription getDefaultDescription() {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(BatchOperation.class);
        desc.setNamespace(Namespaces.batchNs);
        desc.setLocalName("operation");
        desc.setRepeatable(false);
        return desc;
    }

    public BatchOperationType getType() {
        return this.type;
    }

    public void setType(BatchOperationType type) {
        this.type = type;
    }

    public void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        List<Attribute> attrs = null;
        if (this.type != null) {
            attrs = Collections.singletonList(new Attribute("type", this.type.getName()));
        }
        generateStartElement(w, Namespaces.batchNs, "operation", attrs, null);
        generateExtensions(w, extProfile);
        w.endElement(Namespaces.batchNs, "operation");
    }

    public ElementHandler getHandler(ExtensionProfile extProfile, String namespace, String localName, Attributes attrs) throws ParseException {
        return new BatchOperationHandler(extProfile, attrs);
    }
}
