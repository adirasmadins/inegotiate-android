package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind.Term;

@Term("http://schemas.google.com/spreadsheets/2006#spreadsheet")
public class SpreadsheetFeed extends BaseFeed<SpreadsheetFeed, SpreadsheetEntry> {
    public SpreadsheetFeed() {
        super(SpreadsheetEntry.class);
        getCategories().add(SpreadsheetEntry.CATEGORY);
    }

    public SpreadsheetFeed(BaseFeed sourceFeed) {
        super(SpreadsheetEntry.class, sourceFeed);
        getCategories().add(SpreadsheetEntry.CATEGORY);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        super.declareExtensions(extProfile);
    }
}
