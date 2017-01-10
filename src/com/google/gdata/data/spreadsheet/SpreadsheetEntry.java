package com.google.gdata.data.spreadsheet;

import com.google.gdata.client.spreadsheet.SpreadsheetService.Versions;
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.data.Link;
import com.google.gdata.data.OutOfLineContent;
import com.google.gdata.data.spreadsheet.SpreadsheetLink.Rel;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Term("http://schemas.google.com/spreadsheets/2006#spreadsheet")
public class SpreadsheetEntry extends BaseEntry<SpreadsheetEntry> {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/spreadsheets/2006#spreadsheet";

    static {
        CATEGORY = new Category(Namespaces.gSpread, KIND);
    }

    public SpreadsheetEntry() {
        getCategories().add(CATEGORY);
    }

    public SpreadsheetEntry(BaseEntry sourceEntry) {
        super(sourceEntry);
        getCategories().add(CATEGORY);
    }

    public Link getSpreadsheetLink() {
        return super.getHtmlLink();
    }

    public URL getWorksheetFeedUrl() {
        try {
            return new URL(getWorksheetFeedUrlString());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error in GData server", e);
        }
    }

    private String getWorksheetFeedUrlString() {
        if (this.state.service.getProtocolVersion().isCompatible(Versions.V1)) {
            return getLink(Rel.WORKSHEETS_FEED, Type.ATOM).getHref();
        }
        return ((OutOfLineContent) getContent()).getUri();
    }

    public List<WorksheetEntry> getWorksheets() throws IOException, ServiceException {
        return ((WorksheetFeed) this.state.service.getFeed(getWorksheetFeedUrl(), WorksheetFeed.class)).getEntries();
    }

    public WorksheetEntry getDefaultWorksheet() throws IOException, ServiceException {
        return (WorksheetEntry) this.state.service.getEntry(new URL(getWorksheetFeedUrlString() + "/default"), WorksheetEntry.class);
    }

    public String getKey() {
        String result = this.state.id;
        int position = result.lastIndexOf("/");
        if (position > 0) {
            return result.substring(position + 1);
        }
        return result;
    }

    public void declareExtensions(ExtensionProfile extProfile) {
    }
}
