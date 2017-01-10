package com.google.gdata.client.spreadsheet;

import com.google.gdata.client.Query;
import com.google.gdata.util.common.base.StringUtil;
import java.net.URL;

public class CellQuery extends Query {
    public static final String MAXIMUM_COL = "max-col";
    public static final String MAXIMUM_ROW = "max-row";
    public static final String MINIMUM_COL = "min-col";
    public static final String MINIMUM_ROW = "min-row";
    public static final String RANGE = "range";
    public static final String RETURN_EMPTY = "return-empty";

    public CellQuery(URL feedUrl) {
        super(feedUrl);
    }

    public void setMinimumRow(Integer value) {
        if (value == null || value.intValue() <= 0) {
            setIntegerCustomParameter(MINIMUM_ROW, null);
        } else {
            setIntegerCustomParameter(MINIMUM_ROW, value);
        }
    }

    public void setMaximumRow(Integer value) {
        if (value == null || value.intValue() <= 0) {
            setIntegerCustomParameter(MAXIMUM_ROW, null);
        } else {
            setIntegerCustomParameter(MAXIMUM_ROW, value);
        }
    }

    public void setMinimumCol(Integer value) {
        if (value == null || value.intValue() <= 0) {
            setIntegerCustomParameter(MINIMUM_COL, null);
        } else {
            setIntegerCustomParameter(MINIMUM_COL, value);
        }
    }

    public void setMaximumCol(Integer value) {
        if (value == null || value.intValue() <= 0) {
            setIntegerCustomParameter(MAXIMUM_COL, null);
        } else {
            setIntegerCustomParameter(MAXIMUM_COL, value);
        }
    }

    public void setRange(String value) {
        setStringCustomParameter(RANGE, value);
    }

    public void setReturnEmpty(boolean value) {
        setStringCustomParameter(RETURN_EMPTY, StringUtil.EMPTY_STRING + value);
    }

    public Integer getMinimumRow() {
        return getIntegerCustomParameter(MINIMUM_ROW);
    }

    public Integer getMaximumRow() {
        return getIntegerCustomParameter(MAXIMUM_ROW);
    }

    public Integer getMinimumCol() {
        return getIntegerCustomParameter(MINIMUM_COL);
    }

    public Integer getMaximumCol() {
        return getIntegerCustomParameter(MAXIMUM_COL);
    }

    public String getRange() {
        return getStringCustomParameter(RANGE);
    }

    public boolean getReturnEmpty() {
        return Boolean.parseBoolean(getStringCustomParameter(RETURN_EMPTY));
    }
}
