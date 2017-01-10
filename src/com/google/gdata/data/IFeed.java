package com.google.gdata.data;

import java.util.List;

public interface IFeed extends IAtom {
    IEntry createEntry();

    boolean getCanPost();

    List<? extends IEntry> getEntries();

    ILink getEntryPostLink();

    ILink getFeedBatchLink();

    IGenerator getGenerator();

    int getItemsPerPage();

    String getLogo();

    ILink getNextLink();

    ILink getPreviousLink();

    int getStartIndex();

    ITextConstruct getSubtitle();

    int getTotalResults();

    void setCanPost(boolean z);

    IGenerator setGenerator(String str, String str2, String str3);

    void setItemsPerPage(int i);

    void setLogo(String str);

    void setStartIndex(int i);

    void setTotalResults(int i);
}
