package com.google.gdata.data.docs;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.util.Namespaces;

@Term("http://schemas.google.com/docs/2007#file")
public class FileEntry extends DocumentListEntry {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/docs/2007#file";
    public static final String LABEL = "file";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND, LABEL);
    }

    public FileEntry() {
        getCategories().remove(DocumentListEntry.CATEGORY);
        getCategories().add(CATEGORY);
    }

    public FileEntry(BaseEntry sourceEntry) {
        super(sourceEntry);
    }
}
