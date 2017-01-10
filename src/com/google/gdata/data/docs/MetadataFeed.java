package com.google.gdata.data.docs;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind.Term;

@Term("http://schemas.google.com/docs/2007#metadata")
public class MetadataFeed extends BaseFeed<MetadataFeed, MetadataEntry> {
    public MetadataFeed() {
        super(MetadataEntry.class);
        getCategories().add(MetadataEntry.CATEGORY);
    }

    public MetadataFeed(BaseFeed<?, ?> sourceFeed) {
        super(MetadataEntry.class, sourceFeed);
    }

    public String toString() {
        return "{MetadataFeed " + super.toString() + "}";
    }
}
