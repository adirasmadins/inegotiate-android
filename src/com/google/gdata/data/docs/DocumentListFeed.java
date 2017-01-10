package com.google.gdata.data.docs;

import com.google.gdata.data.Kind.Term;
import com.google.gdata.data.media.MediaFeed;

@Term("http://schemas.google.com/docs/2007#item")
public class DocumentListFeed extends MediaFeed<DocumentListFeed, DocumentListEntry> {
    public static final String DOCUMENT_NAMESPACE = "http://schemas.google.com/docs/2007";

    public DocumentListFeed() {
        super(DocumentListEntry.class);
        getCategories().add(DocumentListEntry.CATEGORY);
    }
}
