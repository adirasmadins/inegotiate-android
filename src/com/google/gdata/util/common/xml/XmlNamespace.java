package com.google.gdata.util.common.xml;

import com.google.gdata.util.common.base.Preconditions;

public class XmlNamespace {
    final String alias;
    final String uri;

    public XmlNamespace(String uri) {
        this(null, uri);
    }

    public XmlNamespace(String alias, String uri) {
        Preconditions.checkNotNull(uri, "Null namespace URI");
        this.alias = alias;
        this.uri = uri;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getUri() {
        return this.uri;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XmlNamespace)) {
            return false;
        }
        XmlNamespace other = (XmlNamespace) obj;
        if (this.alias == null) {
            if (other.alias == null && this.uri.equals(other.uri)) {
                return true;
            }
            return false;
        } else if (this.alias.equals(other.alias) && this.uri.equals(other.uri)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        if (this.alias == null) {
            return this.uri.hashCode();
        }
        return this.alias.hashCode() & this.uri.hashCode();
    }
}
