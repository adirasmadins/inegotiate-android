package com.google.gdata.data.docs;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.util.Namespaces;

@Term("http://schemas.google.com/docs/2007#pdf")
public class PdfEntry extends DocumentListEntry {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/docs/2007#pdf";
    public static final String LABEL = "pdf";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND, LABEL);
    }

    public PdfEntry() {
        getCategories().remove(DocumentListEntry.CATEGORY);
        getCategories().add(CATEGORY);
    }

    public PdfEntry(BaseEntry sourceEntry) {
        super(sourceEntry);
    }
}
