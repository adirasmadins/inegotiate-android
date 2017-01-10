package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.util.Namespaces;
import java.util.List;

@Term("http://schemas.google.com/spreadsheets/2006#record")
public class RecordEntry extends BaseEntry<RecordEntry> {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/spreadsheets/2006#record";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND);
    }

    public RecordEntry() {
        getCategories().add(CATEGORY);
    }

    public RecordEntry(BaseEntry<?> sourceEntry) {
        super(sourceEntry);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        if (!extProfile.isDeclared(RecordEntry.class)) {
            super.declareExtensions(extProfile);
            extProfile.declare(RecordEntry.class, Field.getDefaultDescription(false, true));
        }
    }

    public List<Field> getFields() {
        return getRepeatingExtension(Field.class);
    }

    public void addField(Field field) {
        getFields().add(field);
    }

    public boolean hasFields() {
        return hasRepeatingExtension(Field.class);
    }

    protected void validate() {
    }

    public String toString() {
        return "{RecordEntry " + super.toString() + "}";
    }
}
