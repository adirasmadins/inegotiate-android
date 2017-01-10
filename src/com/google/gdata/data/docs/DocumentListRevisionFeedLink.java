package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.extensions.FeedLink;

@Default(isRepeatable = true, localName = "feedLink", nsAlias = "gd", nsUri = "http://schemas.google.com/g/2005")
public class DocumentListRevisionFeedLink extends FeedLink<RevisionFeed> {
    public DocumentListRevisionFeedLink() {
        super(RevisionFeed.class);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        super.declareExtensions(extProfile);
        ExtensionProfile ep = new ExtensionProfile();
        new RevisionFeed().declareExtensions(ep);
        extProfile.declareFeedLinkProfile(ep);
    }
}
