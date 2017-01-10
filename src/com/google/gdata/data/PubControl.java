package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import org.xml.sax.Attributes;

public class PubControl extends ExtensionPoint {
    private XmlNamespace atomPubNs;
    private Boolean draft;

    public class AtomHandler extends ExtensionHandler {
        public AtomHandler(ExtensionProfile profile) {
            super(PubControl.this, profile, PubControl.class);
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (!namespace.equals(PubControl.this.atomPubNs.getUri())) {
                return super.getChildHandler(namespace, localName, attrs);
            }
            if (localName.equals("draft")) {
                return new DraftHandler(null);
            }
            return null;
        }
    }

    private class DraftHandler extends ElementHandler {
        private DraftHandler() {
        }

        public void processEndElement() throws ParseException {
            if (PubControl.this.draft != null) {
                throw new ParseException(CoreErrorDomain.ERR.duplicateDraft);
            } else if (this.value.equals("yes")) {
                PubControl.this.draft = Boolean.valueOf(true);
            } else if (this.value.equals("no")) {
                PubControl.this.draft = Boolean.valueOf(false);
            } else {
                throw new ParseException(CoreErrorDomain.ERR.invalidDraft);
            }
        }
    }

    public PubControl() {
        this.atomPubNs = Namespaces.getAtomPubNs();
    }

    public boolean isDraft() {
        return this.draft != null && this.draft.booleanValue();
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    public void generateAtom(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        w.startElement(Namespaces.getAtomPubNs(), "control", null, null);
        if (isDraft()) {
            w.simpleElement(Namespaces.getAtomPubNs(), "draft", null, "yes");
        }
        generateExtensions(w, extProfile);
        w.endElement();
    }
}
