package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;

public class Rfc3339Handler extends ElementHandler {
    private DateTime dateTime;

    public DateTime getDateTime() {
        return this.dateTime;
    }

    public void processEndElement() throws ParseException {
        try {
            this.dateTime = DateTime.parseDateTime(this.value);
        } catch (NumberFormatException e) {
            throw new ParseException(CoreErrorDomain.ERR.invalidDatetime.withInternalReason("Invalid date/time format: '" + this.value + "'."));
        }
    }
}
