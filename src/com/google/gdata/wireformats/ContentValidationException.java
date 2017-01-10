package com.google.gdata.wireformats;

import com.google.gdata.model.Element;
import com.google.gdata.model.ValidationContext;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.ErrorContent;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.ServiceException;
import java.util.List;
import java.util.Map.Entry;

public class ContentValidationException extends ServiceException {
    protected ValidationContext vc;

    public ContentValidationException(String message, ValidationContext vc) {
        super(message);
        this.vc = vc;
        setResponse(ContentType.TEXT_PLAIN, vc.toString());
    }

    public ValidationContext getContext() {
        return this.vc;
    }

    public ParseException toParseException() {
        ParseException result = null;
        for (Entry<Element, List<ErrorContent>> entry : this.vc.getErrors().entrySet()) {
            String location = ((Element) entry.getKey()).getElementKey().getId().toString();
            for (ErrorContent errorCode : (List) entry.getValue()) {
                ParseException pe = new ParseException(errorCode);
                pe.setLocation(location);
                if (result == null) {
                    result = pe;
                } else {
                    result.addSibling(pe);
                }
            }
        }
        return result;
    }
}
