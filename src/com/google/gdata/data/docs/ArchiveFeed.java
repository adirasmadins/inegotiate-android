package com.google.gdata.data.docs;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind.Term;

@Term("http://schemas.google.com/docs/2007#archive")
public class ArchiveFeed extends BaseFeed<ArchiveFeed, ArchiveEntry> {
    public ArchiveFeed() {
        super(ArchiveEntry.class);
        getCategories().add(ArchiveEntry.CATEGORY);
    }

    public ArchiveFeed(BaseFeed<?, ?> sourceFeed) {
        super(ArchiveEntry.class, sourceFeed);
    }

    public String toString() {
        return "{ArchiveFeed " + super.toString() + "}";
    }
}
