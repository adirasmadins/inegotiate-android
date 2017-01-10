package com.google.gdata.data.docs;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.data.spreadsheet.SpreadsheetLink.Rel;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Term("http://schemas.google.com/docs/2007#spreadsheet")
public class SpreadsheetEntry extends DocumentListEntry {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/docs/2007#spreadsheet";
    public static final String LABEL = "spreadsheet";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND, LABEL);
    }

    public SpreadsheetEntry() {
        getCategories().remove(DocumentListEntry.CATEGORY);
        getCategories().add(CATEGORY);
    }

    public SpreadsheetEntry(BaseEntry sourceEntry) {
        super(sourceEntry);
    }

    public URL getWorksheetFeedUrl() {
        try {
            return new URL(getLink(Rel.WORKSHEETS_FEED, Type.ATOM).getHref());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error in GData server", e);
        }
    }

    public List<WorksheetEntry> getWorksheets() throws IOException, ServiceException {
        return ((WorksheetFeed) this.state.service.getFeed(getWorksheetFeedUrl(), WorksheetFeed.class)).getEntries();
    }

    public WorksheetEntry getDefaultWorksheet() throws IOException, ServiceException {
        return (WorksheetEntry) this.state.service.getEntry(new URL(getLink(Rel.WORKSHEETS_FEED, Type.ATOM).getHref() + "/default"), WorksheetEntry.class);
    }
}
