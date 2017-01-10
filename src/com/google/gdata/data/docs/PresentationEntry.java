package com.google.gdata.data.docs;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.util.Namespaces;

@Term("http://schemas.google.com/docs/2007#presentation")
public class PresentationEntry extends DocumentListEntry {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/docs/2007#presentation";
    public static final String LABEL = "presentation";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND, LABEL);
    }

    public PresentationEntry() {
        getCategories().remove(DocumentListEntry.CATEGORY);
        getCategories().add(CATEGORY);
    }

    public PresentationEntry(BaseEntry sourceEntry) {
        super(sourceEntry);
    }
}
