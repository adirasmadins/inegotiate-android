package com.google.gdata.data.batch;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import org.xml.sax.Attributes;

public class BatchId implements Extension {
    private String id;

    /* renamed from: com.google.gdata.data.batch.BatchId.1 */
    class C07271 extends ElementHandler {
        C07271() {
        }

        public void processEndElement() {
            BatchId.this.id = this.value;
        }
    }

    public BatchId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static ExtensionDescription getDefaultDescription() {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(BatchId.class);
        desc.setNamespace(Namespaces.batchNs);
        desc.setLocalName("id");
        desc.setRepeatable(false);
        return desc;
    }

    public static String getIdFrom(BaseEntry<?> entry) {
        BatchId tag = (BatchId) entry.getExtension(BatchId.class);
        return tag == null ? null : tag.getId();
    }

    public void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        w.simpleElement(Namespaces.batchNs, "id", null, this.id);
    }

    public ElementHandler getHandler(ExtensionProfile extProfile, String namespace, String localName, Attributes attrs) {
        return new C07271();
    }
}
