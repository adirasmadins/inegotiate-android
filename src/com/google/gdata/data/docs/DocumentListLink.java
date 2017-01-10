package com.google.gdata.data.docs;

public class DocumentListLink {

    public static final class Rel {
        public static final String EXPORT = "http://schemas.google.com/docs/2007#export";
        public static final String PARENT = "http://schemas.google.com/docs/2007#parent";
        public static final String TABLES_FEED = "http://schemas.google.com/spreadsheets/2006#tablesfeed";
        public static final String WORKSHEETS_FEED = "http://schemas.google.com/spreadsheets/2006#worksheetsfeed";
    }

    public static final class Type {
        public static final String APPLICATION_ZIP = "application/zip";
    }

    private DocumentListLink() {
    }
}
