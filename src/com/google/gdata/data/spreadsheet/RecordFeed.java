package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind.Term;

@Term("http://schemas.google.com/spreadsheets/2006#record")
public class RecordFeed extends BaseFeed<RecordFeed, RecordEntry> {
    public RecordFeed() {
        super(RecordEntry.class);
        getCategories().add(RecordEntry.CATEGORY);
    }

    public RecordFeed(BaseFeed<?, ?> sourceFeed) {
        super(RecordEntry.class, sourceFeed);
    }

    public String toString() {
        return "{RecordFeed " + super.toString() + "}";
    }
}
