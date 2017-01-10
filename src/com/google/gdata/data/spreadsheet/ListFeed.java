package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind.Term;

@Term("http://schemas.google.com/spreadsheets/2006#list")
public class ListFeed extends BaseFeed<ListFeed, ListEntry> {
    public ListFeed() {
        super(ListEntry.class);
        getCategories().add(ListEntry.CATEGORY);
    }

    public ListFeed(BaseFeed sourceFeed) {
        super(ListEntry.class, sourceFeed);
        getCategories().add(ListEntry.CATEGORY);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        super.declareExtensions(extProfile);
    }
}
