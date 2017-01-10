package com.google.gdata.data.spreadsheet;

import com.google.gdata.client.spreadsheet.SpreadsheetService.Versions;
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.data.OutOfLineContent;
import com.google.gdata.data.spreadsheet.SpreadsheetLink.Rel;
import java.net.MalformedURLException;
import java.net.URL;

@Term("http://schemas.google.com/spreadsheets/2006#worksheet")
public class WorksheetEntry extends BaseEntry<WorksheetEntry> {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/spreadsheets/2006#worksheet";

    static {
        CATEGORY = new Category(Namespaces.gSpread, KIND);
    }

    public WorksheetEntry() {
        getCategories().add(CATEGORY);
    }

    public WorksheetEntry(int rowCount, int colCount) {
        getCategories().add(CATEGORY);
        addExtension(new RowCount(rowCount));
        addExtension(new ColCount(colCount));
    }

    public WorksheetEntry(BaseEntry sourceEntry) {
        super(sourceEntry);
        getCategories().add(CATEGORY);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declare(WorksheetEntry.class, RowCount.getDefaultDescription());
        extProfile.declare(WorksheetEntry.class, ColCount.getDefaultDescription());
    }

    public URL getListFeedUrl() {
        try {
            return new URL(getFeedUrlString(Rel.LIST_FEED));
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error in GData server", e);
        }
    }

    public URL getCellFeedUrl() {
        try {
            return new URL(getFeedUrlString(Rel.CELLS_FEED));
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error in GData server", e);
        }
    }

    private String getFeedUrlString(String linkRelKind) {
        if (this.state.service.getProtocolVersion().isCompatible(Versions.V1)) {
            return getLink(linkRelKind, Type.ATOM).getHref();
        }
        if (linkRelKind.equals(Rel.LIST_FEED)) {
            return ((OutOfLineContent) getContent()).getUri();
        }
        return getLink(linkRelKind, Type.ATOM).getHref();
    }

    public int getRowCount() {
        RowCount count = (RowCount) getExtension(RowCount.class);
        if (count != null) {
            return count.getCount();
        }
        return 0;
    }

    public void setRowCount(int count) {
        setExtension(new RowCount(count));
    }

    public int getColCount() {
        ColCount count = (ColCount) getExtension(ColCount.class);
        if (count != null) {
            return count.getCount();
        }
        return 0;
    }

    public void setColCount(int count) {
        setExtension(new ColCount(count));
    }
}
