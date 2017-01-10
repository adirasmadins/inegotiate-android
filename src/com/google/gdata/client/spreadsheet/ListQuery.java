package com.google.gdata.client.spreadsheet;

import com.google.gdata.client.Query;
import java.net.URL;

public class ListQuery extends Query {
    public static final String ORDERBY = "orderby";
    public static final String ORDERBY_COLUMN = "column";
    public static final String ORDERBY_POSITION = "position";
    public static final String REVERSE = "reverse";
    public static final String SPREADSHEET_QUERY = "sq";

    public ListQuery(URL feedUrl) {
        super(feedUrl);
    }

    public void setSpreadsheetQuery(String query) {
        setStringCustomParameter(SPREADSHEET_QUERY, query);
    }

    public String getSpreadsheetQuery() {
        return getStringCustomParameter(SPREADSHEET_QUERY);
    }

    public void setFullTextQuery(String query) {
        super.setFullTextQuery(query);
    }

    public void setSortColumn(String column) {
        if (column == null || column.split("\\s").length > 1) {
            setOrderBy(null);
        } else {
            setOrderBy("column:" + column);
        }
    }

    public void setOrderBy(String orderby) {
        if (orderby == null || orderby.equals(ORDERBY_POSITION) || (orderby.startsWith(ORDERBY_COLUMN) && orderby.split("\\s").length == 1)) {
            setStringCustomParameter(ORDERBY, orderby);
        }
    }

    public String getOrderBy() {
        return getStringCustomParameter(ORDERBY);
    }

    public void setReverse(boolean reverse) {
        setStringCustomParameter(REVERSE, reverse ? "true" : null);
    }

    public boolean isReverse() {
        return getStringCustomParameter(REVERSE) != null;
    }
}
