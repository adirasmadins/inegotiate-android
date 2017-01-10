package com.google.gdata.model.atompub;

import com.google.gdata.data.introspection.IServiceDocument;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.atom.TextContent;
import com.google.gdata.util.Namespaces;
import java.util.List;

public class ServiceDocument extends Element implements IServiceDocument {
    public static final ElementKey<Void, ServiceDocument> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomPubStandardNs, "service"), Void.class, ServiceDocument.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(KEY).addElement(Workspace.KEY).setCardinality(Cardinality.MULTIPLE).setRequired(true);
        }
    }

    public ServiceDocument() {
        super(KEY);
    }

    protected ServiceDocument(ElementKey<?, ? extends ServiceDocument> key) {
        super((ElementKey) key);
    }

    protected ServiceDocument(ElementKey<?, ? extends ServiceDocument> key, Element source) {
        super(key, source);
    }

    public ServiceDocument lock() {
        return (ServiceDocument) super.lock();
    }

    public List<Workspace> getWorkspaces() {
        return super.getElements(Workspace.KEY);
    }

    public ServiceDocument addWorkspace(Workspace workspace) {
        super.addElement(workspace);
        return this;
    }

    public boolean removeWorkspace(Workspace workspace) {
        return super.removeElement((Element) workspace);
    }

    public void clearWorkspaces() {
        super.removeElement(Workspace.KEY);
    }

    public boolean hasWorkspaces() {
        return super.hasElement(Workspace.KEY);
    }

    public Workspace addWorkspace(String title) {
        Workspace workspace = new Workspace(TextContent.plainText(title));
        addWorkspace(workspace);
        return workspace;
    }
}
