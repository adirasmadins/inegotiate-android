package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.util.MessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLLocator;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

public class StaxErrorReporter extends XMLErrorReporter {
    protected XMLReporter fXMLReporter;

    /* renamed from: com.amazonaws.javax.xml.stream.StaxErrorReporter.1 */
    class C00061 implements Location {
        private final /* synthetic */ XMLLocator val$location;

        public int getColumnNumber() {
            return this.val$location.getColumnNumber();
        }

        public int getLineNumber() {
            return this.val$location.getLineNumber();
        }

        public String getPublicId() {
            return this.val$location.getPublicId();
        }

        public String getSystemId() {
            return this.val$location.getLiteralSystemId();
        }

        C00061(XMLLocator xMLLocator) {
            this.val$location = xMLLocator;
        }

        public int getCharacterOffset() {
            return this.val$location.getCharacterOffset();
        }
    }

    public StaxErrorReporter(PropertyManager propertyManager) {
        this.fXMLReporter = null;
        putMessageFormatter(XMLMessageFormatter.XML_DOMAIN, new XMLMessageFormatter());
        reset(propertyManager);
    }

    public StaxErrorReporter() {
        this.fXMLReporter = null;
        putMessageFormatter(XMLMessageFormatter.XML_DOMAIN, new XMLMessageFormatter());
    }

    public void reset(PropertyManager propertyManager) {
        this.fXMLReporter = (XMLReporter) propertyManager.getProperty(XMLInputFactory.REPORTER);
    }

    public void reportError(XMLLocator location, String domain, String key, Object[] arguments, short severity) throws XNIException {
        String message;
        MessageFormatter messageFormatter = getMessageFormatter(domain);
        if (messageFormatter != null) {
            message = messageFormatter.formatMessage(this.fLocale, key, arguments);
        } else {
            StringBuffer str = new StringBuffer();
            str.append(domain);
            str.append('#');
            str.append(key);
            int argCount = arguments != null ? arguments.length : 0;
            if (argCount > 0) {
                str.append('?');
                for (int i = 0; i < argCount; i++) {
                    str.append(arguments[i]);
                    if (i < argCount - 1) {
                        str.append('&');
                    }
                }
            }
            message = str.toString();
        }
        switch (severity) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                try {
                    if (this.fXMLReporter != null) {
                        this.fXMLReporter.report(message, "WARNING", null, convertToStaxLocation(location));
                    }
                } catch (Exception ex) {
                    throw new XNIException(ex);
                }
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                try {
                    if (this.fXMLReporter != null) {
                        this.fXMLReporter.report(message, "ERROR", null, convertToStaxLocation(location));
                    }
                } catch (Exception ex2) {
                    throw new XNIException(ex2);
                }
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                if (!this.fContinueAfterFatalError) {
                    throw new XNIException(message);
                }
            default:
        }
    }

    Location convertToStaxLocation(XMLLocator location) {
        return new C00061(location);
    }
}
