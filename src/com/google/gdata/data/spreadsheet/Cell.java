package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.Attributes;

public class Cell implements Extension {
    private int col;
    private String inputValue;
    private Number numericValue;
    private int row;
    private String value;

    private class Handler extends ElementHandler {
        public void processAttribute(String namespace, String localName, String attributeData) throws ParseException {
            if (!namespace.equals(StringUtil.EMPTY_STRING)) {
                return;
            }
            if (localName.equals("row")) {
                Cell.this.row = Integer.parseInt(attributeData);
            } else if (localName.equals("col")) {
                Cell.this.col = Integer.parseInt(attributeData);
            } else if (localName.equals("inputValue")) {
                Cell.this.inputValue = attributeData;
            } else if (localName.equals("numericValue")) {
                try {
                    Cell.this.numericValue = Double.valueOf(attributeData);
                } catch (NumberFormatException e) {
                    throw new ParseException("Invalid numericValue.");
                }
            }
        }

        public void processEndElement() throws ParseException {
            Cell.this.value = this.value;
            if (Cell.this.value != null && Cell.this.value.equals(StringUtil.EMPTY_STRING)) {
                Cell.this.value = null;
            }
        }
    }

    public Cell() {
        this.row = -1;
        this.col = -1;
        this.inputValue = null;
        this.numericValue = null;
        this.value = null;
    }

    private Cell(int inRow, int inCol, String inInputValue, Number inNumericValue, String inValue) {
        this.row = -1;
        this.col = -1;
        this.inputValue = null;
        this.numericValue = null;
        this.value = null;
        this.row = inRow;
        this.col = inCol;
        this.inputValue = inInputValue;
        this.value = inValue;
        this.numericValue = inNumericValue;
    }

    public Cell(int inRow, int inCol, String inInputValue) {
        this(inRow, inCol, inInputValue, null, null);
    }

    public static Cell createFullCell(int inRow, int inCol, String inInputValue, Number inCalculatedValue, String inValue) {
        return new Cell(inRow, inCol, inInputValue, inCalculatedValue, inValue);
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public String getInputValue() {
        return this.inputValue;
    }

    public Number getNumericValue() {
        return this.numericValue;
    }

    public double getDoubleValue() {
        if (this.numericValue == null) {
            return Double.NaN;
        }
        return this.numericValue.doubleValue();
    }

    public String getValue() {
        return this.value;
    }

    public Cell withNewInputValue(String newInputValue) {
        return new Cell(this.row, this.col, newInputValue, null, null);
    }

    public static ExtensionDescription getDefaultDescription(boolean repeats) {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(Cell.class);
        desc.setNamespace(Namespaces.gSpreadNs);
        desc.setLocalName("cell");
        desc.setRepeatable(repeats);
        return desc;
    }

    public void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList();
        if (this.row > 0) {
            attrs.add(new Attribute("row", String.valueOf(this.row)));
        }
        if (this.col > 0) {
            attrs.add(new Attribute("col", String.valueOf(this.col)));
        }
        if (this.inputValue != null) {
            attrs.add(new Attribute("inputValue", this.inputValue));
        }
        if (this.numericValue != null) {
            attrs.add(new Attribute("numericValue", this.numericValue.toString()));
        }
        w.simpleElement(Namespaces.gSpreadNs, "cell", attrs, this.value);
    }

    public ElementHandler getHandler(ExtensionProfile extProfile, String namespace, String localName, Attributes attrs) throws ParseException, IOException {
        return new Handler();
    }
}
