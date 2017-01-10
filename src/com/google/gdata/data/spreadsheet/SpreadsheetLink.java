package com.google.gdata.data.spreadsheet;

public class SpreadsheetLink {

    public static final class Rel {
        public static final String CELLS_FEED = "http://schemas.google.com/spreadsheets/2006#cellsfeed";
        public static final String GVIZ = "http://schemas.google.com/visualization/2008#visualizationApi";
        public static final String LIST_FEED = "http://schemas.google.com/spreadsheets/2006#listfeed";
        public static final String RECORDS_FEED = "http://schemas.google.com/spreadsheets/2006#recordsfeed";
        public static final String WORKSHEETS_FEED = "http://schemas.google.com/spreadsheets/2006#worksheetsfeed";
    }

    private SpreadsheetLink() {
    }
}
