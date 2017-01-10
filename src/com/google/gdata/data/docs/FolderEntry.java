package com.google.gdata.data.docs;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.util.Namespaces;

@Term("http://schemas.google.com/docs/2007#folder")
public class FolderEntry extends DocumentListEntry {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/docs/2007#folder";
    public static final String LABEL = "folder";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND, LABEL);
    }

    public FolderEntry() {
        getCategories().remove(DocumentListEntry.CATEGORY);
        getCategories().add(CATEGORY);
    }

    public FolderEntry(BaseEntry<FolderEntry> sourceEntry) {
        super(sourceEntry);
    }
}
