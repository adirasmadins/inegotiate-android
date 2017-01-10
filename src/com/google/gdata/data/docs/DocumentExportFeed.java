package com.google.gdata.data.docs;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Link;
import com.google.gdata.data.docs.DocumentListLink.Rel;
import com.google.gdata.data.docs.DocumentListLink.Type;

public class DocumentExportFeed extends BaseFeed<DocumentExportFeed, DocumentExportEntry> {
    public DocumentExportFeed() {
        super(DocumentExportEntry.class);
    }

    public DocumentExportFeed(BaseFeed<?, ?> sourceFeed) {
        super(DocumentExportEntry.class, sourceFeed);
    }

    public Link getDocumentExportLink() {
        return getLink(Rel.EXPORT, Type.APPLICATION_ZIP);
    }

    public String toString() {
        return "{DocumentExportFeed " + super.toString() + "}";
    }
}
