package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind.Term;

@Term("http://schemas.google.com/spreadsheets/2006#table")
public class TableFeed extends BaseFeed<TableFeed, TableEntry> {
    public TableFeed() {
        super(TableEntry.class);
        getCategories().add(TableEntry.CATEGORY);
    }

    public TableFeed(BaseFeed<?, ?> sourceFeed) {
        super(TableEntry.class, sourceFeed);
    }

    public String toString() {
        return "{TableFeed " + super.toString() + "}";
    }
}
