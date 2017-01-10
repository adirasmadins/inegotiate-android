package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.stream.Location;
import java.io.IOException;
import java.io.Writer;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class ProcessingInstructionEvent extends DummyEvent implements ProcessingInstruction {
    private String fContent;
    private String fName;

    public ProcessingInstructionEvent() {
        init();
    }

    public ProcessingInstructionEvent(String targetName, String data) {
        this(targetName, data, null);
    }

    public ProcessingInstructionEvent(String targetName, String data, Location loc) {
        init();
        this.fName = targetName;
        this.fContent = data;
        setLocation(loc);
    }

    protected void init() {
        setEventType(3);
    }

    public String getTarget() {
        return this.fName;
    }

    public void setTarget(String targetName) {
        this.fName = targetName;
    }

    public void setData(String data) {
        this.fContent = data;
    }

    public String getData() {
        return this.fContent;
    }

    public String toString() {
        if (this.fContent != null && this.fName != null) {
            return new StringBuffer().append("<?").append(this.fName).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(this.fContent).append("?>").toString();
        }
        if (this.fName != null) {
            return new StringBuffer().append("<?").append(this.fName).append("?>").toString();
        }
        if (this.fContent != null) {
            return new StringBuffer().append("<?").append(this.fContent).append("?>").toString();
        }
        return "<??>";
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
        writer.write(toString());
    }
}
