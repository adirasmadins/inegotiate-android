package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.data.batch.BatchUtils;

@Term("http://schemas.google.com/spreadsheets/2006#cell")
public class CellFeed extends BaseFeed<CellFeed, CellEntry> {
    public CellFeed() {
        super(CellEntry.class);
        getCategories().add(CellEntry.CATEGORY);
    }

    public CellFeed(BaseFeed sourceFeed) {
        super(CellEntry.class, sourceFeed);
        getCategories().add(CellEntry.CATEGORY);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declare(CellFeed.class, RowCount.getDefaultDescription());
        extProfile.declare(CellFeed.class, ColCount.getDefaultDescription());
        super.declareExtensions(extProfile);
        BatchUtils.declareExtensions(extProfile);
    }

    public int getRowCount() {
        return ((RowCount) getExtension(RowCount.class)).getCount();
    }

    public int getColCount() {
        return ((ColCount) getExtension(ColCount.class)).getCount();
    }
}
