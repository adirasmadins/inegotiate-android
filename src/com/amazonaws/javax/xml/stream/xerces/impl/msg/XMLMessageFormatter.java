package com.amazonaws.javax.xml.stream.xerces.impl.msg;

import com.amazonaws.javax.xml.stream.xerces.util.MessageFormatter;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class XMLMessageFormatter implements MessageFormatter {
    public static final String XMLNS_DOMAIN = "http://www.w3.org/TR/1999/REC-xml-names-19990114";
    public static final String XML_DOMAIN = "http://www.w3.org/TR/1998/REC-xml-19980210";
    private Locale fLocale;
    private ResourceBundle fResourceBundle;

    public XMLMessageFormatter() {
        this.fLocale = null;
        this.fResourceBundle = null;
    }

    public String formatMessage(Locale locale, String key, Object[] arguments) throws MissingResourceException {
        if (this.fResourceBundle == null || locale != this.fLocale) {
            if (locale != null) {
                this.fResourceBundle = PropertyResourceBundle.getBundle("com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessages", locale);
                this.fLocale = locale;
            }
            if (this.fResourceBundle == null) {
                this.fResourceBundle = PropertyResourceBundle.getBundle("com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessages");
            }
        }
        try {
            String msg = this.fResourceBundle.getString(key);
            if (arguments != null) {
                try {
                    msg = MessageFormat.format(msg, arguments);
                } catch (Exception e) {
                    msg = new StringBuffer().append(this.fResourceBundle.getString("FormatFailed")).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(this.fResourceBundle.getString(key)).toString();
                }
            }
            if (msg == null) {
                msg = key;
                if (arguments.length > 0) {
                    StringBuffer str = new StringBuffer(msg);
                    str.append('?');
                    for (int i = 0; i < arguments.length; i++) {
                        if (i > 0) {
                            str.append('&');
                        }
                        str.append(String.valueOf(arguments[i]));
                    }
                }
            }
            return msg;
        } catch (MissingResourceException e2) {
            throw new MissingResourceException(key, this.fResourceBundle.getString("BadMessageKey"), key);
        }
    }
}
