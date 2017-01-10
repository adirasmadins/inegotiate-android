package com.google.gdata.util;

import com.google.gdata.util.ErrorContent.LocationType;
import com.google.gdata.util.XmlParser.ElementHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.zip.GZIPInputStream;
import org.xml.sax.Attributes;

public class ServiceExceptionInitializer {
    private ServiceException currentException;
    private final ServiceException initialException;

    private class CodeHandler extends ElementHandler {
        private CodeHandler() {
        }

        public void processEndElement() {
            ServiceExceptionInitializer.this.currentException.errorElement.setCode(this.value);
        }
    }

    private class DebugInfoHandler extends ElementHandler {
        private DebugInfoHandler() {
        }

        public void processEndElement() {
            ServiceExceptionInitializer.this.currentException.errorElement.setDebugInfo(this.value);
        }
    }

    private class DomainHandler extends ElementHandler {
        private DomainHandler() {
        }

        public void processEndElement() {
            ServiceExceptionInitializer.this.currentException.errorElement.setDomain(this.value);
        }
    }

    private class ErrorHandler extends ElementHandler {
        private ErrorHandler() {
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (Namespaces.f443g.equals(namespace)) {
                if ("domain".equals(localName)) {
                    return new DomainHandler(null);
                }
                if ("code".equals(localName)) {
                    return new CodeHandler(null);
                }
                if ("location".equals(localName)) {
                    return new LocationHandler(null);
                }
                if ("internalReason".equals(localName)) {
                    return new InternalReasonHandler(null);
                }
                if ("extendedHelp".equals(localName)) {
                    return new ExtendedHelpHandler(null);
                }
                if ("sendReport".equals(localName)) {
                    return new SendReportHandler(null);
                }
                if ("debugInfo".equals(localName)) {
                    return new DebugInfoHandler(null);
                }
            }
            return super.getChildHandler(namespace, localName, attrs);
        }
    }

    private class ErrorsHandler extends ElementHandler {
        private ErrorsHandler() {
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (!Namespaces.f443g.equals(namespace) || !"error".equals(localName)) {
                return super.getChildHandler(namespace, localName, attrs);
            }
            ServiceExceptionInitializer.this.nextException();
            return new ErrorHandler(null);
        }
    }

    private class ExtendedHelpHandler extends ElementHandler {
        private ExtendedHelpHandler() {
        }

        public void processEndElement() {
            ServiceExceptionInitializer.this.currentException.errorElement.setExtendedHelp(this.value);
        }
    }

    private class InternalReasonHandler extends ElementHandler {
        private InternalReasonHandler() {
        }

        public void processEndElement() {
            ServiceExceptionInitializer.this.currentException.errorElement.setInternalReason(this.value);
        }
    }

    private class LocationHandler extends ElementHandler {
        private LocationType locationType;

        private LocationHandler() {
            this.locationType = LocationType.OTHER;
        }

        public void processAttribute(String namespace, String localName, String value) {
            if ("type".equals(localName)) {
                this.locationType = LocationType.fromString(value);
            }
        }

        public void processEndElement() {
            ServiceExceptionInitializer.this.currentException.errorElement.setLocation(this.value, this.locationType);
        }
    }

    private class SendReportHandler extends ElementHandler {
        private SendReportHandler() {
        }

        public void processEndElement() {
            ServiceExceptionInitializer.this.currentException.errorElement.setSendReport(this.value);
        }
    }

    public ServiceExceptionInitializer(ServiceException se) {
        this.currentException = null;
        this.initialException = se;
    }

    public void parse(HttpURLConnection httpConn) throws ParseException, IOException {
        StringBuilder sb;
        this.initialException.httpErrorCodeOverride = httpConn.getResponseCode();
        this.initialException.httpHeaders = Collections.unmodifiableMap(httpConn.getHeaderFields());
        ContentType responseContentType = new ContentType(httpConn.getContentType());
        this.initialException.responseContentType = responseContentType;
        int responseLength = httpConn.getContentLength();
        if (responseLength < 0) {
            sb = new StringBuilder();
        } else if (responseLength > 0) {
            sb = new StringBuilder(responseLength);
        } else {
            return;
        }
        InputStream errorStream = this.initialException.httpErrorCodeOverride >= 400 ? httpConn.getErrorStream() : httpConn.getInputStream();
        if (errorStream != null) {
            if ("gzip".equalsIgnoreCase(httpConn.getContentEncoding())) {
                errorStream = new GZIPInputStream(errorStream);
            }
            try {
                String charset = (String) responseContentType.getAttributes().get(ContentType.ATTR_CHARSET);
                if (charset == null) {
                    charset = "iso8859-1";
                }
                BufferedReader reader = new BufferedReader(new InputStreamReader(errorStream, charset));
                while (true) {
                    String responseLine = reader.readLine();
                    if (responseLine == null) {
                        break;
                    }
                    sb.append(responseLine);
                    sb.append('\n');
                }
                String body = sb.toString();
                this.initialException.responseBody = body;
                parse(responseContentType, body);
            } finally {
                errorStream.close();
            }
        }
    }

    public void parse(ContentType contentType, String body) throws ParseException {
        if (ContentType.GDATA_ERROR.equals(contentType)) {
            try {
                new XmlParser().parse(new StringReader(body), new ErrorsHandler(), Namespaces.f443g, "errors");
            } catch (IOException ioe) {
                throw new RuntimeException("Impossible parser I/O", ioe);
            }
        }
    }

    private ServiceException nextException() {
        if (this.currentException == null) {
            this.currentException = this.initialException;
            return this.currentException;
        }
        try {
            this.currentException = (ServiceException) this.initialException.getClass().getConstructor(new Class[]{String.class}).newInstance(new Object[]{this.initialException.getMessage()});
            this.initialException.addSibling(this.currentException);
            return this.currentException;
        } catch (InstantiationException ie) {
            throw new IllegalStateException(ie);
        } catch (NoSuchMethodException nsme) {
            throw new IllegalStateException(nsme);
        } catch (IllegalAccessException iae) {
            throw new IllegalStateException(iae);
        } catch (InvocationTargetException ite) {
            throw new IllegalStateException(ite);
        }
    }
}
