package com.google.gdata.data.introspection;

import java.util.List;

public interface IWorkspace {
    ICollection addCollection(String str, String str2, String... strArr);

    List<? extends ICollection> getCollections();
}
