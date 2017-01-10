package com.google.gdata.data.introspection;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.ExtensionVisitor;
import com.google.gdata.data.ExtensionVisitor.StoppedException;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class ServiceDocument extends ExtensionPoint implements IServiceDocument {
    private XmlNamespace atomPubNs;
    List<Workspace> workspaces;

    public class Handler extends ExtensionHandler {
        public Handler(ExtensionProfile extProfile) {
            super(ServiceDocument.this, extProfile, ServiceDocument.class);
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (!namespace.equals(ServiceDocument.this.atomPubNs.getUri()) || !localName.equals("workspace")) {
                return super.getChildHandler(namespace, localName, attrs);
            }
            Workspace workspace = new Workspace();
            ServiceDocument.this.workspaces.add(workspace);
            workspace.getClass();
            return new com.google.gdata.data.introspection.Workspace.Handler(this.extProfile, attrs);
        }
    }

    public ServiceDocument() {
        this.atomPubNs = Namespaces.getAtomPubNs();
        this.workspaces = new ArrayList();
    }

    public List<Workspace> getWorkspaces() {
        return this.workspaces;
    }

    public void addWorkspace(Workspace workspace) {
        this.workspaces.add(workspace);
    }

    public Workspace addWorkspace(String title) {
        Workspace workspace = new Workspace(new PlainTextConstruct(title));
        this.workspaces.add(workspace);
        return workspace;
    }

    protected void visitChildren(ExtensionVisitor ev) throws StoppedException {
        for (Workspace workspace : this.workspaces) {
            visitChild(ev, workspace);
        }
        super.visitChildren(ev);
    }

    public void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        w.startElement(this.atomPubNs, "service", null, null);
        w.startRepeatingElement();
        for (Workspace workspace : this.workspaces) {
            workspace.generate(w, extProfile);
        }
        w.endRepeatingElement();
        generateExtensions(w, extProfile);
        w.endElement(this.atomPubNs, "service");
    }

    public void parse(ExtensionProfile extProfile, Reader reader) throws IOException, ParseException {
        new XmlParser().parse(reader, new Handler(extProfile), this.atomPubNs.getUri(), "service");
    }

    public void parse(ExtensionProfile extProfile, InputStream inputStream) throws IOException, ParseException {
        new XmlParser().parse(inputStream, new Handler(extProfile), this.atomPubNs.getUri(), "service");
    }

    public ElementHandler getHandler(ExtensionProfile p, String namespace, String localName, Attributes attrs) {
        return new Handler(p);
    }

    public void processEndElement() throws ParseException {
        if (this.workspaces.size() == 0) {
            throw new ParseException(CoreErrorDomain.ERR.workspaceRequired);
        }
    }
}
