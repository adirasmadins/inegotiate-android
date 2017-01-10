package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.AttributeHelper.EnumToAttributeValue;
import com.google.gdata.data.AttributeHelper.LowerCaseEnumToAttributeValue;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.ParseException;
import java.util.List;

@Default(localName = "data", nsAlias = "gs", nsUri = "http://schemas.google.com/spreadsheets/2006")
public class Data extends ExtensionPoint {
    private static final String INSERTIONMODE = "insertionMode";
    private static final EnumToAttributeValue<InsertionMode> INSERTIONMODE_ENUM_TO_ATTRIBUTE_VALUE;
    private static final String NUMROWS = "numRows";
    private static final String STARTROW = "startRow";
    static final String XML_NAME = "data";
    private InsertionMode insertionMode;
    private Integer numberOfRows;
    private Integer startIndex;

    public enum InsertionMode {
        INSERT,
        OVERWRITE
    }

    static {
        INSERTIONMODE_ENUM_TO_ATTRIBUTE_VALUE = new LowerCaseEnumToAttributeValue();
    }

    public Data() {
        this.insertionMode = null;
        this.numberOfRows = null;
        this.startIndex = null;
    }

    public Data(InsertionMode insertionMode, Integer numberOfRows, Integer startIndex) {
        this.insertionMode = null;
        this.numberOfRows = null;
        this.startIndex = null;
        setInsertionMode(insertionMode);
        setNumberOfRows(numberOfRows);
        setStartIndex(startIndex);
        setImmutable(true);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        if (!extProfile.isDeclared(Data.class)) {
            extProfile.declare(Data.class, Column.getDefaultDescription(false, true));
        }
    }

    public List<Column> getColumns() {
        return getRepeatingExtension(Column.class);
    }

    public void addColumn(Column column) {
        getColumns().add(column);
    }

    public boolean hasColumns() {
        return hasRepeatingExtension(Column.class);
    }

    public InsertionMode getInsertionMode() {
        return this.insertionMode;
    }

    public void setInsertionMode(InsertionMode insertionMode) {
        throwExceptionIfImmutable();
        this.insertionMode = insertionMode;
    }

    public boolean hasInsertionMode() {
        return getInsertionMode() != null;
    }

    public Integer getNumberOfRows() {
        return this.numberOfRows;
    }

    public void setNumberOfRows(Integer numberOfRows) {
        throwExceptionIfImmutable();
        this.numberOfRows = numberOfRows;
    }

    public boolean hasNumberOfRows() {
        return getNumberOfRows() != null;
    }

    public Integer getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        throwExceptionIfImmutable();
        this.startIndex = startIndex;
    }

    public boolean hasStartIndex() {
        return getStartIndex() != null;
    }

    protected void validate() {
        if (this.startIndex == null) {
            AbstractExtension.throwExceptionForMissingAttribute(STARTROW);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Data.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(INSERTIONMODE, this.insertionMode, INSERTIONMODE_ENUM_TO_ATTRIBUTE_VALUE);
        generator.put(NUMROWS, this.numberOfRows);
        generator.put(STARTROW, this.startIndex);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.insertionMode = (InsertionMode) helper.consumeEnum(INSERTIONMODE, false, InsertionMode.class, null, INSERTIONMODE_ENUM_TO_ATTRIBUTE_VALUE);
        this.numberOfRows = Integer.valueOf(helper.consumeInteger(NUMROWS, false));
        this.startIndex = Integer.valueOf(helper.consumeInteger(STARTROW, true));
    }

    public String toString() {
        return "{Data insertionMode=" + this.insertionMode + " numberOfRows=" + this.numberOfRows + " startIndex=" + this.startIndex + "}";
    }
}
