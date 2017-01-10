package com.google.gdata.data.docs;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind.Term;

@Term("http://schemas.google.com/docs/2007#revision")
public class RevisionFeed extends BaseFeed<RevisionFeed, RevisionEntry> {
    public RevisionFeed() {
        super(RevisionEntry.class);
        getCategories().add(RevisionEntry.CATEGORY);
    }
}
