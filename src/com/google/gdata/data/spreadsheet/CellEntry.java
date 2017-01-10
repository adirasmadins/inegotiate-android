package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.Content;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.data.TextConstruct;

@Term("http://schemas.google.com/spreadsheets/2006#cell")
public class CellEntry extends BaseEntry<CellEntry> {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/spreadsheets/2006#cell";

    static {
        CATEGORY = new Category(Namespaces.gSpread, KIND);
    }

    public CellEntry() {
        getCategories().add(CATEGORY);
    }

    public CellEntry(int row, int col, String newInputValue) {
        this(new Cell(row, col, newInputValue));
    }

    public CellEntry(Cell cell) {
        this();
        if (cell != null) {
            setExtension(cell);
        }
    }

    public CellEntry(BaseEntry sourceEntry) {
        super(sourceEntry);
        getCategories().add(CATEGORY);
    }

    public Cell getCell() {
        return (Cell) getExtension(Cell.class);
    }

    public void setTitle(TextConstruct v) {
        throw new UnsupportedOperationException("Field is server-generated.");
    }

    public void setContent(TextConstruct v) {
        throw new UnsupportedOperationException("Field is server-generated.");
    }

    public void setContent(Content v) {
        throw new UnsupportedOperationException("Field is server-generated.");
    }

    public void setSummary(TextConstruct v) {
        throw new UnsupportedOperationException("Field is server-generated.");
    }

    public void changeInputValueLocal(String newInputValue) {
        setExtension(getCell().withNewInputValue(newInputValue));
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declare(CellEntry.class, Cell.getDefaultDescription(false));
    }

    public void setAutomaticallyGeneratedTitle(TextConstruct v) {
        this.state.title = v;
    }

    public void setAutomaticallyGeneratedContent(Content v) {
        this.state.content = v;
    }
}
