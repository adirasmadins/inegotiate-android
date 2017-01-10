package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind.Term;

@Term("http://schemas.google.com/spreadsheets/2006#worksheet")
public class WorksheetFeed extends BaseFeed<WorksheetFeed, WorksheetEntry> {
    public WorksheetFeed() {
        super(WorksheetEntry.class);
        getCategories().add(WorksheetEntry.CATEGORY);
    }

    public WorksheetFeed(BaseFeed sourceFeed) {
        super(WorksheetEntry.class, sourceFeed);
        getCategories().add(WorksheetEntry.CATEGORY);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        super.declareExtensions(extProfile);
    }
}
