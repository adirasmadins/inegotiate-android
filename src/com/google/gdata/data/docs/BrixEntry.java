package com.google.gdata.data.docs;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.util.Namespaces;

@Term("http://schemas.google.com/docs/2007#brix")
public class BrixEntry extends BaseDocumentListEntry<BrixEntry> {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/docs/2007#brix";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND, "brix");
    }

    public BrixEntry() {
        getCategories().add(CATEGORY);
    }

    public BrixEntry(BaseEntry<?> sourceEntry) {
        super(sourceEntry);
    }

    public String toString() {
        return "{BrixEntry " + super.toString() + "}";
    }
}
