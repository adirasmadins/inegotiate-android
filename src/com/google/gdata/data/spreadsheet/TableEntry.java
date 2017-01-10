package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.data.Link;
import com.google.gdata.data.spreadsheet.SpreadsheetLink.Rel;
import com.google.gdata.util.Namespaces;

@Term("http://schemas.google.com/spreadsheets/2006#table")
public class TableEntry extends BaseEntry<TableEntry> {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/spreadsheets/2006#table";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND);
    }

    public TableEntry() {
        getCategories().add(CATEGORY);
    }

    public TableEntry(BaseEntry<?> sourceEntry) {
        super(sourceEntry);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        if (!extProfile.isDeclared(TableEntry.class)) {
            super.declareExtensions(extProfile);
            extProfile.declare(TableEntry.class, Data.getDefaultDescription(true, false));
            new Data().declareExtensions(extProfile);
            extProfile.declare(TableEntry.class, Header.getDefaultDescription(true, false));
            extProfile.declare(TableEntry.class, Worksheet.getDefaultDescription(true, false));
        }
    }

    public Data getData() {
        return (Data) getExtension(Data.class);
    }

    public void setData(Data data) {
        if (data == null) {
            removeExtension(Data.class);
        } else {
            setExtension(data);
        }
    }

    public boolean hasData() {
        return hasExtension(Data.class);
    }

    public Header getHeader() {
        return (Header) getExtension(Header.class);
    }

    public void setHeader(Header header) {
        if (header == null) {
            removeExtension(Header.class);
        } else {
            setExtension(header);
        }
    }

    public boolean hasHeader() {
        return hasExtension(Header.class);
    }

    public Worksheet getWorksheet() {
        return (Worksheet) getExtension(Worksheet.class);
    }

    public void setWorksheet(Worksheet worksheet) {
        if (worksheet == null) {
            removeExtension(Worksheet.class);
        } else {
            setExtension(worksheet);
        }
    }

    public boolean hasWorksheet() {
        return hasExtension(Worksheet.class);
    }

    public Link getRecordsFeedLink() {
        return getLink(Rel.RECORDS_FEED, Type.ATOM);
    }

    protected void validate() {
    }

    public String toString() {
        return "{TableEntry " + super.toString() + "}";
    }
}
