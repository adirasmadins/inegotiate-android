package com.google.gdata.data.docs;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Link;
import com.google.gdata.data.docs.DocumentListLink.Rel;
import com.google.gdata.data.docs.DocumentListLink.Type;
import java.util.List;

public class DocumentExportEntry extends BaseEntry<DocumentExportEntry> {
    public DocumentExportEntry(BaseEntry<?> sourceEntry) {
        super(sourceEntry);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        if (!extProfile.isDeclared(DocumentExportEntry.class)) {
            super.declareExtensions(extProfile);
            extProfile.declare(DocumentExportEntry.class, ExportDocId.getDefaultDescription(false, true));
            extProfile.declare(DocumentExportEntry.class, DocumentExportRequestor.class);
            extProfile.declare(DocumentExportEntry.class, ObjectNumber.class);
            extProfile.declare(DocumentExportEntry.class, QueryParameter.getDefaultDescription(false, true));
            extProfile.declare(DocumentExportEntry.class, ExportStatus.class);
        }
    }

    public List<ExportDocId> getExportDocIds() {
        return getRepeatingExtension(ExportDocId.class);
    }

    public void addExportDocId(ExportDocId exportDocId) {
        getExportDocIds().add(exportDocId);
    }

    public boolean hasExportDocIds() {
        return hasRepeatingExtension(ExportDocId.class);
    }

    public DocumentExportRequestor getExportRequestor() {
        return (DocumentExportRequestor) getExtension(DocumentExportRequestor.class);
    }

    public void setExportRequestor(DocumentExportRequestor exportRequestor) {
        if (exportRequestor == null) {
            removeExtension(DocumentExportRequestor.class);
        } else {
            setExtension(exportRequestor);
        }
    }

    public boolean hasExportRequestor() {
        return hasExtension(DocumentExportRequestor.class);
    }

    public ObjectNumber getObjectNumber() {
        return (ObjectNumber) getExtension(ObjectNumber.class);
    }

    public void setObjectNumber(ObjectNumber objectNumber) {
        if (objectNumber == null) {
            removeExtension(ObjectNumber.class);
        } else {
            setExtension(objectNumber);
        }
    }

    public boolean hasObjectNumber() {
        return hasExtension(ObjectNumber.class);
    }

    public List<QueryParameter> getQueries() {
        return getRepeatingExtension(QueryParameter.class);
    }

    public void addQuery(QueryParameter query) {
        getQueries().add(query);
    }

    public boolean hasQueries() {
        return hasRepeatingExtension(QueryParameter.class);
    }

    public ExportStatus getStatus() {
        return (ExportStatus) getExtension(ExportStatus.class);
    }

    public void setStatus(ExportStatus status) {
        if (status == null) {
            removeExtension(ExportStatus.class);
        } else {
            setExtension(status);
        }
    }

    public boolean hasStatus() {
        return hasExtension(ExportStatus.class);
    }

    public Link getDocumentExportLink() {
        return getLink(Rel.EXPORT, Type.APPLICATION_ZIP);
    }

    protected void validate() {
    }

    public String toString() {
        return "{DocumentExportEntry " + super.toString() + "}";
    }
}
