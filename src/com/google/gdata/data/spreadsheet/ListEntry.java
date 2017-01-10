package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.Content;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.data.TextConstruct;

@Term("http://schemas.google.com/spreadsheets/2006#list")
public class ListEntry extends BaseEntry<ListEntry> {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/spreadsheets/2006#list";
    private CustomElementCollection customElements;

    static {
        CATEGORY = new Category(Namespaces.gSpread, KIND);
    }

    public ListEntry() {
        getCategories().add(CATEGORY);
        init();
    }

    public ListEntry(String id, String versionId) {
        this();
        setId(id);
        setVersionId(versionId);
    }

    public ListEntry(BaseEntry sourceEntry) {
        super(sourceEntry);
        getCategories().add(CATEGORY);
        if (getExtension(CustomElementCollection.class) == null) {
            init();
        }
    }

    private void init() {
        this.customElements = new CustomElementCollection();
        setExtension(this.customElements);
    }

    public CustomElementCollection getCustomElements() {
        return this.customElements;
    }

    public void setTitle(TextConstruct v) {
        throw new UnsupportedOperationException("Title is server-generated for Google Spreadsheets list access.");
    }

    public void setContent(Content c) {
        throw new UnsupportedOperationException("Content is server-generated for Google Spreadsheets list access.");
    }

    public void setContent(TextConstruct c) {
        throw new UnsupportedOperationException("Content is server-generated for Google Spreadsheets list access.");
    }

    public void setSummary(TextConstruct v) {
        throw new UnsupportedOperationException("Summary is server-generated for Google Spreadsheets list access.");
    }

    public void setAutomaticallyGeneratedTitle(TextConstruct v) {
        this.state.title = v;
    }

    public void setAutomaticallyGeneratedContent(Content c) {
        this.state.content = c;
    }

    public void setAutomaticallyGeneratedSummary(TextConstruct v) {
        this.state.summary = v;
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declare(ListEntry.class, CustomElementCollection.getDefaultDescription());
    }
}
