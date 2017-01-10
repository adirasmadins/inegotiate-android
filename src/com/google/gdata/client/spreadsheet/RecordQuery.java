package com.google.gdata.client.spreadsheet;

import com.google.gdata.client.Query;
import java.net.URL;

public class RecordQuery extends Query {
    private String orderBy;
    private Boolean reverse;
    private String spreadsheetQuery;

    public RecordQuery(URL feedUrl) {
        super(feedUrl);
        this.reverse = Boolean.valueOf(false);
    }

    public String getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        if (this.orderBy == null) {
            if (orderBy == null) {
                return;
            }
        } else if (this.orderBy.equals(orderBy)) {
            return;
        }
        this.orderBy = orderBy;
        setStringCustomParameter(ListQuery.ORDERBY, orderBy);
    }

    public Boolean getReverse() {
        return this.reverse;
    }

    public void setReverse(Boolean reverse) {
        if (reverse == null) {
            reverse = Boolean.valueOf(false);
        }
        if (!this.reverse.equals(reverse)) {
            this.reverse = reverse;
            setStringCustomParameter(ListQuery.REVERSE, !reverse.booleanValue() ? null : reverse.toString());
        }
    }

    public String getSpreadsheetQuery() {
        return this.spreadsheetQuery;
    }

    public void setSpreadsheetQuery(String spreadsheetQuery) {
        if (this.spreadsheetQuery == null) {
            if (spreadsheetQuery == null) {
                return;
            }
        } else if (this.spreadsheetQuery.equals(spreadsheetQuery)) {
            return;
        }
        this.spreadsheetQuery = spreadsheetQuery;
        setStringCustomParameter(ListQuery.SPREADSHEET_QUERY, spreadsheetQuery);
    }
}
