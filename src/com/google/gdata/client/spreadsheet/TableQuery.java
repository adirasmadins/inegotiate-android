package com.google.gdata.client.spreadsheet;

import com.google.gdata.client.DocumentQuery;
import com.google.gdata.client.Query;
import java.net.URL;

public class TableQuery extends Query {
    private Boolean titleExact;
    private String titleQuery;

    public TableQuery(URL feedUrl) {
        super(feedUrl);
    }

    public String getTitleQuery() {
        return this.titleQuery;
    }

    public void setTitleQuery(String titleQuery) {
        if (this.titleQuery == null) {
            if (titleQuery == null) {
                return;
            }
        } else if (this.titleQuery.equals(titleQuery)) {
            return;
        }
        this.titleQuery = titleQuery;
        setStringCustomParameter(DocumentQuery.TITLE_SORT, titleQuery);
    }

    public Boolean getTitleExact() {
        return this.titleExact;
    }

    public void setTitleExact(Boolean titleExact) {
        if (this.titleExact == null) {
            if (titleExact == null) {
                return;
            }
        } else if (this.titleExact.equals(titleExact)) {
            return;
        }
        this.titleExact = titleExact;
        setStringCustomParameter(DocumentQuery.TITLE_EXACT, titleExact == null ? null : titleExact.toString());
    }
}
