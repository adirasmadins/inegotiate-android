package com.google.gdata.data.spreadsheet;

import com.google.gdata.util.common.xml.XmlNamespace;

public class Namespaces {
    public static final String CELLS_LINK_REL = "http://schemas.google.com/spreadsheets/2006#cellsfeed";
    public static final String GVIZ = "http://schemas.google.com/visualization/2008";
    public static final String GVIZ_LINK_REL = "http://schemas.google.com/visualization/2008#visualizationApi";
    public static final String GVIZ_PREFIX = "http://schemas.google.com/visualization/2008#";
    public static final String LIST_LINK_REL = "http://schemas.google.com/spreadsheets/2006#listfeed";
    public static final String SOURCE_LINK_REL = "http://schemas.google.com/spreadsheets/2006#source";
    public static final String TABLES_LINK_REL = "http://schemas.google.com/spreadsheets/2006#tablesfeed";
    public static final String WORKSHEETS_LINK_REL = "http://schemas.google.com/spreadsheets/2006#worksheetsfeed";
    public static final String gSpread = "http://schemas.google.com/spreadsheets/2006";
    public static final String gSpreadAlias = "gs";
    public static final String gSpreadCustom = "http://schemas.google.com/spreadsheets/2006/extended";
    public static final String gSpreadCustomAlias = "gsx";
    public static final XmlNamespace gSpreadCustomNs;
    public static final String gSpreadCustomPrefix = "http://schemas.google.com/spreadsheets/2006/extended#";
    public static final XmlNamespace gSpreadNs;
    public static final String gSpreadPrefix = "http://schemas.google.com/spreadsheets/2006#";

    private Namespaces() {
    }

    static {
        gSpreadNs = new XmlNamespace(gSpreadAlias, gSpread);
        gSpreadCustomNs = new XmlNamespace(gSpreadCustomAlias, gSpreadCustom);
    }
}
