package com.google.gdata.data.docs;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind.Term;

@Term("http://schemas.google.com/docs/2007#change")
public class ChangelogFeed extends BaseFeed<ChangelogFeed, ChangelogEntry> {
    public ChangelogFeed() {
        super(ChangelogEntry.class);
        getCategories().add(ChangelogEntry.CATEGORY);
    }

    public ChangelogFeed(BaseFeed<?, ?> sourceFeed) {
        super(ChangelogEntry.class, sourceFeed);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        if (!extProfile.isDeclared(ChangelogFeed.class)) {
            super.declareExtensions(extProfile);
            extProfile.declare(ChangelogFeed.class, LargestChangestamp.getDefaultDescription(true, false));
        }
    }

    public LargestChangestamp getLargestChangestamp() {
        return (LargestChangestamp) getExtension(LargestChangestamp.class);
    }

    public void setLargestChangestamp(LargestChangestamp largestChangestamp) {
        if (largestChangestamp == null) {
            removeExtension(LargestChangestamp.class);
        } else {
            setExtension(largestChangestamp);
        }
    }

    public boolean hasLargestChangestamp() {
        return hasExtension(LargestChangestamp.class);
    }

    protected void validate() {
    }

    public String toString() {
        return "{ChangelogFeed " + super.toString() + "}";
    }
}
