package com.google.gdata.data.docs;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.util.Namespaces;

@Term("http://schemas.google.com/docs/2007#change")
public class ChangelogEntry extends BaseDocumentListEntry<ChangelogEntry> {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/docs/2007#change";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND, "change");
    }

    public ChangelogEntry() {
        getCategories().add(CATEGORY);
    }

    public ChangelogEntry(BaseEntry<?> sourceEntry) {
        super(sourceEntry);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        if (!extProfile.isDeclared(ChangelogEntry.class)) {
            super.declareExtensions(extProfile);
            extProfile.declare(ChangelogEntry.class, Changestamp.getDefaultDescription(true, false));
            extProfile.declare(ChangelogEntry.class, Removed.class);
        }
    }

    public Changestamp getChangestamp() {
        return (Changestamp) getExtension(Changestamp.class);
    }

    public void setChangestamp(Changestamp changestamp) {
        if (changestamp == null) {
            removeExtension(Changestamp.class);
        } else {
            setExtension(changestamp);
        }
    }

    public boolean hasChangestamp() {
        return hasExtension(Changestamp.class);
    }

    public Removed getRemoved() {
        return (Removed) getExtension(Removed.class);
    }

    public void setRemoved(Removed removed) {
        if (removed == null) {
            removeExtension(Removed.class);
        } else {
            setExtension(removed);
        }
    }

    public boolean hasRemoved() {
        return hasExtension(Removed.class);
    }

    protected void validate() {
    }

    public String toString() {
        return "{ChangelogEntry " + super.toString() + "}";
    }
}
