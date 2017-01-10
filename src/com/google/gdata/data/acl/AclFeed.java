package com.google.gdata.data.acl;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind.Term;

@Term("http://schemas.google.com/acl/2007#accessRule")
public class AclFeed extends BaseFeed<AclFeed, AclEntry> {
    public AclFeed() {
        super(AclEntry.class);
        getCategories().add(AclEntry.ACCESS_RULE_CATEGORY);
    }
}
