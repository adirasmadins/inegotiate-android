package com.google.gdata.data;

import com.google.gdata.client.Service;
import java.util.List;
import java.util.Set;

public interface IAtom {
    ILink addLink(String str, String str2, String str3);

    List<? extends IPerson> getAuthors();

    Set<? extends ICategory> getCategories();

    String getEtag();

    String getId();

    String getKind();

    ILink getLink(String str, String str2);

    List<? extends ILink> getLinks();

    ILink getSelfLink();

    ITextConstruct getTitle();

    DateTime getUpdated();

    String getVersionId();

    void removeLinks();

    void removeLinks(String str, String str2);

    void setEtag(String str);

    void setId(String str);

    void setKind(String str);

    void setService(Service service);

    void setUpdated(DateTime dateTime);

    void setVersionId(String str);
}
