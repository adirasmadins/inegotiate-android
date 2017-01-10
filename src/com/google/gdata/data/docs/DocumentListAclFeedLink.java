package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.acl.AclFeed;
import com.google.gdata.data.extensions.FeedLink;

@Default(isRepeatable = true, localName = "feedLink", nsAlias = "gd", nsUri = "http://schemas.google.com/g/2005")
public class DocumentListAclFeedLink extends FeedLink<AclFeed> {
    public DocumentListAclFeedLink() {
        super(AclFeed.class);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        super.declareExtensions(extProfile);
        ExtensionProfile ep = new ExtensionProfile();
        new AclFeed().declareExtensions(ep);
        extProfile.declareFeedLinkProfile(ep);
    }
}
