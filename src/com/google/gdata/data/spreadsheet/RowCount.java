package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import org.xml.sax.Attributes;

public class RowCount implements Extension {
    public static final String TAG_NAME = "rowCount";
    private int count;

    /* renamed from: com.google.gdata.data.spreadsheet.RowCount.1 */
    class C07311 extends ElementHandler {
        C07311() throws ParseException {
        }

        public void processEndElement() throws ParseException {
            if (this.value != null) {
                try {
                    RowCount.this.count = Integer.parseInt(this.value);
                } catch (NumberFormatException e) {
                }
            }
            if (RowCount.this.count <= 0) {
                throw new ParseException("The count must be specified.");
            }
        }
    }

    public RowCount() {
        this.count = -1;
    }

    public RowCount(int count) {
        this.count = -1;
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public static ExtensionDescription getDefaultDescription() {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(RowCount.class);
        desc.setNamespace(Namespaces.gSpreadNs);
        desc.setLocalName(TAG_NAME);
        return desc;
    }

    public void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        w.simpleElement(Namespaces.gSpreadNs, TAG_NAME, null, String.valueOf(this.count));
    }

    public ElementHandler getHandler(ExtensionProfile extProfile, String namespace, String localName, Attributes attrs) throws ParseException, IOException {
        return new C07311();
    }
}
