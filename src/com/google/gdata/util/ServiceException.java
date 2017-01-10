package com.google.gdata.util;

import com.google.gdata.client.authn.oauthproxy.OAuthProxyProtocol.Header;
import com.google.gdata.client.authn.oauthproxy.OAuthProxyResponse;
import com.google.gdata.util.ErrorContent.LocationType;
import com.google.gdata.util.common.base.CharEscapers;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceException extends Exception {
    ErrorElement errorElement;
    int httpErrorCodeOverride;
    Map<String, List<String>> httpHeaders;
    String responseBody;
    ContentType responseContentType;
    List<ServiceException> siblings;

    public ServiceException(String message) {
        super(nullsafe(message));
        this.httpErrorCodeOverride = -1;
        this.errorElement = new ErrorElement();
        this.siblings = new ArrayList(1);
        this.siblings.add(this);
        this.httpHeaders = new HashMap();
    }

    public ServiceException(String message, Throwable cause) {
        this(message);
        initCause(cause);
    }

    public ServiceException(Throwable cause) {
        this(cause.getMessage());
        initCause(cause);
    }

    public ServiceException(HttpURLConnection httpConn) throws IOException {
        super(nullsafe(httpConn.getResponseMessage()));
        this.httpErrorCodeOverride = -1;
        this.errorElement = new ErrorElement();
        this.siblings = new ArrayList(1);
        this.siblings.add(this);
        try {
            new ServiceExceptionInitializer(this).parse(httpConn);
        } catch (ParseException e) {
            this.errorElement = new ErrorElement();
            this.siblings.clear();
            this.siblings.add(this);
            this.responseContentType = ContentType.TEXT_PLAIN;
        }
    }

    public ServiceException(ErrorContent errorCode) {
        this(errorCode.getInternalReason());
        this.errorElement = new ErrorElement(errorCode);
    }

    public ServiceException(ErrorContent errorCode, Throwable cause) {
        this(errorCode);
        initCause(cause);
    }

    public Throwable initCause(Throwable cause) {
        super.initCause(cause);
        if (cause instanceof ServiceException) {
            addSibling((ServiceException) cause);
        }
        return this;
    }

    private static String nullsafe(String src) {
        return src != null ? src : "Exception message unavailable";
    }

    public int getHttpErrorCodeOverride() {
        return this.httpErrorCodeOverride;
    }

    public void setHttpErrorCodeOverride(int v) {
        this.httpErrorCodeOverride = v;
    }

    public ContentType getResponseContentType() {
        return this.responseContentType;
    }

    public void setResponseContentType(ContentType v) {
        if (v == null) {
            throw new NullPointerException("Null content type");
        }
        this.responseContentType = v;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public void setResponseBody(String body) {
        if (body == null) {
            throw new NullPointerException("Null response body");
        }
        this.responseBody = body;
        try {
            new ServiceExceptionInitializer(this).parse(this.responseContentType, this.responseBody);
        } catch (ParseException pe) {
            throw new RuntimeException(pe.getMessage(), pe);
        }
    }

    public void setResponse(ContentType contentType, String body) {
        if (contentType == null) {
            throw new NullPointerException("Null content type");
        } else if (body == null) {
            throw new NullPointerException("Null response body");
        } else {
            this.responseContentType = contentType;
            setResponseBody(body);
        }
    }

    public String toXmlErrorMessage() {
        return toXmlErrorMessage(false);
    }

    public String toXmlErrorMessage(boolean includeDebugInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("<errors xmlns='http://schemas.google.com/g/2005'>\n");
        for (ServiceException sibling : this.siblings) {
            addXmlError(sibling, sb, includeDebugInfo);
        }
        sb.append("</errors>\n");
        return sb.toString();
    }

    private String escape(String src) {
        return CharEscapers.xmlEscaper().escape(src);
    }

    private void addXmlError(ServiceException se, StringBuilder sb, boolean includeDebugInfo) {
        sb.append("<error>\n");
        String domainName = se.getDomainName();
        sb.append("<domain>");
        sb.append(escape(domainName));
        sb.append("</domain>\n");
        String codeName = se.getCodeName();
        sb.append("<code>");
        sb.append(escape(codeName));
        sb.append("</code>\n");
        String location = se.getLocation();
        LocationType locationType = se.getLocationTypeWithDefault();
        if (location != null) {
            sb.append("<location type='");
            sb.append(escape(locationType.toString()));
            sb.append("'>");
            sb.append(escape(location));
            sb.append("</location>\n");
        }
        String internalReason = se.getInternalReason();
        if (internalReason != null) {
            sb.append("<internalReason>");
            sb.append(escape(internalReason));
            sb.append("</internalReason>\n");
        }
        String extendedHelp = se.getExtendedHelp();
        if (extendedHelp != null) {
            sb.append("<extendedHelp>");
            sb.append(escape(extendedHelp));
            sb.append("</extendedHelp>\n");
        }
        String sendReport = se.getSendReport();
        if (sendReport != null) {
            sb.append("<sendReport>");
            sb.append(escape(sendReport));
            sb.append("</sendReport>\n");
        }
        if (includeDebugInfo) {
            String debugInfo = se.getDebugInfo();
            if (debugInfo != null) {
                sb.append("<debugInfo>");
                sb.append(escape(debugInfo));
                sb.append("</debugInfo>\n");
            }
        }
        sb.append("</error>\n");
    }

    public Map<String, List<String>> getHttpHeaders() {
        return this.httpHeaders;
    }

    public List<String> getHttpHeader(String header) {
        if (header == null) {
            return (List) this.httpHeaders.get(header);
        }
        for (String key : this.httpHeaders.keySet()) {
            if (key != null && key.toLowerCase().equals(header.toLowerCase())) {
                return (List) this.httpHeaders.get(key);
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (this.responseBody != null) {
            sb.append('\n');
            sb.append(this.responseBody);
        }
        return sb.toString();
    }

    public String getDomainName() {
        String domainName = this.errorElement.getDomainName();
        return domainName != null ? domainName : "GData";
    }

    public void setDomain(String domain) {
        this.errorElement.setDomain(domain);
    }

    public String getCodeName() {
        String codeName = this.errorElement.getCodeName();
        return codeName != null ? codeName : getClass().getSimpleName();
    }

    public void setCode(String code) {
        this.errorElement.setCode(code);
    }

    public String getLocation() {
        return this.errorElement.getLocation();
    }

    public LocationType getLocationType() {
        return this.errorElement.getLocationType();
    }

    private LocationType getLocationTypeWithDefault() {
        LocationType type = getLocationType();
        return type != null ? type : LocationType.OTHER;
    }

    public void setXpathLocation(String location) {
        this.errorElement.setXpathLocation(location);
    }

    public void setHeaderLocation(String location) {
        this.errorElement.setHeaderLocation(location);
    }

    public void setLocation(String location) {
        this.errorElement.setLocation(location);
    }

    public String getInternalReason() {
        String internalReason = this.errorElement.getInternalReason();
        return internalReason != null ? internalReason : super.getMessage();
    }

    public String getMessage() {
        return getInternalReason();
    }

    public void setInternalReason(String internalReason) {
        this.errorElement.setInternalReason(internalReason);
    }

    public String getExtendedHelp() {
        return this.errorElement.getExtendedHelp();
    }

    public void setExtendedHelp(String extendedHelp) {
        this.errorElement.setExtendedHelp(extendedHelp);
    }

    public String getSendReport() {
        return this.errorElement.getSendReport();
    }

    public void setSendReport(String sendReport) {
        this.errorElement.setSendReport(sendReport);
    }

    public String getDebugInfo() {
        return this.errorElement.getDebugInfo();
    }

    public void setDebugInfo(String debugInfo) {
        this.errorElement.setDebugInfo(debugInfo);
    }

    public List<ServiceException> getSiblings() {
        return Collections.unmodifiableList(new ArrayList(this.siblings));
    }

    public ServiceException addSibling(ServiceException newbie) {
        if (newbie == null) {
            throw new NullPointerException("Null exception being added");
        }
        for (ServiceException newbieSibling : newbie.siblings) {
            if (!this.siblings.contains(newbieSibling)) {
                this.siblings.add(newbieSibling);
            }
            newbieSibling.siblings = this.siblings;
        }
        return this;
    }

    public boolean matches(ErrorContent code) {
        return getDomainName().equals(code.getDomainName()) && getCodeName().equals(code.getCodeName());
    }

    public boolean matchesAny(ErrorContent errorCode) {
        for (ServiceException se : this.siblings) {
            if (se.matches(errorCode)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasOAuthProxyResponse() {
        return this.httpHeaders.containsKey(Header.X_OAUTH_APPROVAL_URL) || this.httpHeaders.containsKey(Header.X_OAUTH_STATE) || this.httpHeaders.containsKey(Header.X_OAUTH_ERROR) || this.httpHeaders.containsKey(Header.X_OAUTH_ERROR);
    }

    public OAuthProxyResponse getOAuthProxyResponse() {
        return new OAuthProxyResponse(this.httpHeaders);
    }
}
