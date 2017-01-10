package com.google.gdata.util;

import com.amazonaws.javax.xml.XMLConstants;
import com.google.api.client.xml.XmlHttpParser;
import com.google.gdata.client.GDataProtocol.Query;
import com.google.gdata.client.Service;
import com.google.gdata.client.Service.Versions;
import com.google.gdata.util.common.base.StringUtil;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentType implements Serializable {
    public static final ContentType ANY;
    public static final ContentType APPLICATION_XML;
    public static final ContentType ATOM;
    public static final ContentType ATOM_ENTRY;
    public static final ContentType ATOM_FEED;
    public static final ContentType ATOM_SERVICE;
    public static final String ATTR_CHARSET = "charset";
    private static Pattern ATTR_PATTERN = null;
    private static final String DEFAULT_CHARSET = "charset=UTF-8";
    public static final ContentType GDATA_ERROR;
    public static final ContentType JAVASCRIPT;
    public static final ContentType JSON;
    public static final ContentType MESSAGE_RFC822;
    public static final ContentType MULTIPART_RELATED;
    public static final ContentType OPENSEARCH;
    public static final ContentType RSS;
    private static final String STAR = "*";
    public static final ContentType TEXT_HTML;
    public static final ContentType TEXT_PLAIN;
    public static final ContentType TEXT_XML;
    private static String TOKEN;
    private static Pattern TOKEN_PATTERN;
    private static Pattern TYPE_PATTERN;
    private HashMap<String, String> attributes;
    private boolean inferredCharset;
    private boolean locked;
    private String subType;
    private String type;

    static {
        TOKEN = "[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+";
        TOKEN_PATTERN = Pattern.compile("^" + TOKEN + "$");
        TYPE_PATTERN = Pattern.compile("(" + TOKEN + ")" + "/" + "(" + TOKEN + ")" + "\\s*(.*)\\s*", 32);
        ATTR_PATTERN = Pattern.compile("\\s*;\\s*(" + TOKEN + ")" + "\\s*=\\s*" + "(?:" + "\"([^\"]*)\"" + "|" + "(" + TOKEN + ")?" + ")");
        ATOM = new ContentType("application/atom+xml;charset=UTF-8").lock();
        ATOM_ENTRY = new ContentType("application/atom+xml;type=entry;charset=UTF-8").lock();
        ATOM_FEED = new ContentType("application/atom+xml;type=feed;charset=UTF-8").lock();
        ATOM_SERVICE = new ContentType("application/atomsvc+xml;charset=UTF-8").lock();
        RSS = new ContentType("application/rss+xml;charset=UTF-8").lock();
        JSON = new ContentType("application/json;charset=UTF-8").lock();
        JAVASCRIPT = new ContentType("text/javascript;charset=UTF-8").lock();
        TEXT_XML = new ContentType("text/xml;charset=UTF-8").lock();
        TEXT_HTML = new ContentType("text/html;charset=UTF-8").lock();
        TEXT_PLAIN = new ContentType("text/plain;charset=UTF-8").lock();
        GDATA_ERROR = new ContentType("application/vnd.google.gdata.error+xml").lock();
        OPENSEARCH = new ContentType("application/opensearchdescription+xml").lock();
        MULTIPART_RELATED = new ContentType("multipart/related").lock();
        APPLICATION_XML = new ContentType(XmlHttpParser.CONTENT_TYPE).lock();
        MESSAGE_RFC822 = new ContentType("message/rfc822").lock();
        ANY = new ContentType("*/*").lock();
    }

    public static ContentType getAtomEntry() {
        return Service.getVersion().isCompatible(Versions.V1) ? ATOM : ATOM_ENTRY;
    }

    public static ContentType getAtomFeed() {
        return Service.getVersion().isCompatible(Versions.V1) ? ATOM : ATOM_FEED;
    }

    public static ContentType getBestContentType(String acceptHeader, List<ContentType> actualContentTypes) {
        if (acceptHeader == null) {
            return (ContentType) actualContentTypes.get(0);
        }
        float bestQ = 0.0f;
        ContentType bestContentType = null;
        for (String acceptedTypeString : acceptHeader.split(",")) {
            try {
                ContentType acceptedContentType = new ContentType(acceptedTypeString.trim());
                float curQ = 1.0f;
                try {
                    String qAttr = acceptedContentType.getAttribute(Query.FULL_TEXT);
                    if (qAttr != null) {
                        float qValue = Float.valueOf(qAttr).floatValue();
                        if (qValue > 0.0f && qValue <= 1.0f) {
                            curQ = qValue;
                        }
                    }
                    if (curQ >= bestQ) {
                        for (ContentType actualContentType : actualContentTypes) {
                            if (curQ != bestQ || bestContentType != actualContentType) {
                                if (actualContentType.match(acceptedContentType)) {
                                    bestContentType = actualContentType;
                                    bestQ = curQ;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                }
            } catch (IllegalArgumentException e2) {
            }
        }
        if (bestQ != 0.0f) {
            return bestContentType;
        }
        return null;
    }

    public ContentType() {
        this(null);
    }

    public ContentType(String typeHeader) {
        this.inferredCharset = false;
        this.attributes = new HashMap();
        if (typeHeader == null) {
            this.type = "application";
            this.subType = "octet-stream";
            this.attributes.put(ATTR_CHARSET, "iso-8859-1");
            return;
        }
        Matcher typeMatch = TYPE_PATTERN.matcher(typeHeader);
        if (typeMatch.matches()) {
            this.type = typeMatch.group(1).toLowerCase();
            this.subType = typeMatch.group(2).toLowerCase();
            if (typeMatch.groupCount() >= 3) {
                Matcher attrMatch = ATTR_PATTERN.matcher(typeMatch.group(3));
                while (attrMatch.find()) {
                    String value = attrMatch.group(2);
                    if (value == null) {
                        value = attrMatch.group(3);
                        if (value == null) {
                            value = StringUtil.EMPTY_STRING;
                        }
                    }
                    this.attributes.put(attrMatch.group(1).toLowerCase(), value);
                }
                if (!this.attributes.containsKey(ATTR_CHARSET)) {
                    this.inferredCharset = true;
                    if (this.subType.endsWith(XMLConstants.XML_NS_PREFIX)) {
                        if (this.type.equals("application")) {
                            this.attributes.put(ATTR_CHARSET, "utf-8");
                            return;
                        } else {
                            this.attributes.put(ATTR_CHARSET, "us-ascii");
                            return;
                        }
                    } else if (this.subType.equals("json")) {
                        this.attributes.put(ATTR_CHARSET, "utf-8");
                        return;
                    } else {
                        this.attributes.put(ATTR_CHARSET, "iso-8859-1");
                        return;
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid media type:" + typeHeader);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        assertNotLocked();
        this.type = type;
    }

    public String getSubType() {
        return this.subType;
    }

    public void setSubType(String subType) {
        assertNotLocked();
        this.subType = subType;
    }

    public String getMediaType() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.type);
        sb.append("/");
        sb.append(this.subType);
        if (this.attributes.containsKey("type")) {
            sb.append(";type=").append((String) this.attributes.get("type"));
        }
        return sb.toString();
    }

    public ContentType lock() {
        this.locked = true;
        return this;
    }

    private void assertNotLocked() {
        if (this.locked) {
            throw new IllegalStateException("Unmodifiable instance");
        }
    }

    public Map<String, String> getAttributes() {
        if (this.locked) {
            return Collections.unmodifiableMap(this.attributes);
        }
        return this.attributes;
    }

    public String getAttribute(String name) {
        return (String) this.attributes.get(name);
    }

    public String getCharset() {
        return (String) this.attributes.get(ATTR_CHARSET);
    }

    public boolean match(ContentType acceptedContentType) {
        String acceptedType = acceptedContentType.getType();
        String acceptedSubType = acceptedContentType.getSubType();
        return STAR.equals(acceptedType) || (this.type.equals(acceptedType) && ((STAR.equals(acceptedSubType) || this.subType.equals(acceptedSubType)) && (!isAtom() || matchAtom(acceptedContentType))));
    }

    private boolean isAtom() {
        return "application".equals(this.type) && "atom+xml".equals(this.subType);
    }

    private boolean matchAtom(ContentType acceptedContentType) {
        String atomType = getAttribute("type");
        String acceptedAtomType = acceptedContentType.getAttribute("type");
        return atomType == null || acceptedAtomType == null || atomType.equals(acceptedAtomType);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.type);
        sb.append("/");
        sb.append(this.subType);
        for (String name : this.attributes.keySet()) {
            if (!this.inferredCharset || !ATTR_CHARSET.equals(name)) {
                sb.append(";");
                sb.append(name);
                sb.append("=");
                String value = (String) this.attributes.get(name);
                if (TOKEN_PATTERN.matcher(value).matches()) {
                    sb.append(value);
                } else {
                    sb.append("\"" + value + "\"");
                }
            }
        }
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContentType that = (ContentType) o;
        if (this.type.equals(that.type) && this.subType.equals(that.subType) && this.attributes.equals(that.attributes)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.subType.hashCode()) * 31) + this.attributes.hashCode();
    }
}
