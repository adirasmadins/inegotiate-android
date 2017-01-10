package com.google.gdata.client;

import java.net.URL;

public class DocumentQuery extends Query {
    public static final String DEFAULT_SORT_MODE = "last-modified";
    public static final String LAST_MODIFIED_SORT = "last-modified";
    public static final String LAST_VIEWED_SORT = "last-viewed";
    public static final String ORDERBY = "orderby";
    public static final String STARRED_SORT = "starred";
    public static final String TITLE = "title";
    public static final String TITLE_EXACT = "title-exact";
    public static final String TITLE_SORT = "title";

    public DocumentQuery(URL feedUrl) {
        super(feedUrl);
    }

    public void setTitleQuery(String titleQuery) {
        setStringCustomParameter(TITLE_SORT, titleQuery);
    }

    public String getTitleQuery() {
        return getStringCustomParameter(TITLE_SORT);
    }

    public void setTitleExact(boolean exact) {
        setStringCustomParameter(TITLE_EXACT, exact ? "true" : null);
    }

    public boolean isTitleExact() {
        return getStringCustomParameter(TITLE_EXACT) != null;
    }

    public void setSortMode(String orderby) {
        setStringCustomParameter(ORDERBY, orderby);
    }

    public String getSortMode() {
        return getStringCustomParameter(ORDERBY);
    }
}
