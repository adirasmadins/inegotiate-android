package com.google.gdata.model;

import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlNamespace;

public final class QName implements Comparable<QName> {
    public static final String ANY_LOCALNAME = "*";
    public static final XmlNamespace ANY_NAMESPACE;
    private final String localName;
    private final XmlNamespace namespace;

    static {
        ANY_NAMESPACE = new XmlNamespace(ANY_LOCALNAME, ANY_LOCALNAME);
    }

    public QName(String localName) {
        this(null, localName);
    }

    public QName(XmlNamespace namespace, String localName) {
        Preconditions.checkNotNull(localName, "localName");
        this.namespace = namespace;
        this.localName = localName;
    }

    public XmlNamespace getNs() {
        return this.namespace;
    }

    public String getLocalName() {
        return this.localName;
    }

    public boolean matchesAnyNamespace() {
        return ANY_NAMESPACE.equals(this.namespace);
    }

    public boolean matchesAnyLocalName() {
        return ANY_LOCALNAME.equals(this.localName);
    }

    public boolean matches(QName o) {
        String otherUri = null;
        if (o == null) {
            return false;
        }
        if (!matchesAnyNamespace()) {
            XmlNamespace otherNs = o.getNs();
            String idUri = this.namespace == null ? null : this.namespace.getUri();
            if (otherNs != null) {
                otherUri = otherNs.getUri();
            }
            if (idUri == null) {
                if (otherUri != null) {
                    return false;
                }
            } else if (!idUri.equals(otherUri)) {
                return false;
            }
        }
        if (matchesAnyLocalName()) {
            return true;
        }
        return this.localName.equals(o.getLocalName());
    }

    public boolean equals(Object other) {
        if (!(other instanceof QName)) {
            return false;
        }
        QName otherQName = (QName) other;
        if (getNs() == null && otherQName.getNs() == null) {
            return getLocalName().equals(otherQName.getLocalName());
        }
        if (getNs() == null || otherQName.getNs() == null || !getNs().getUri().equals(otherQName.getNs().getUri()) || !getLocalName().equals(otherQName.getLocalName())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (getNs() == null) {
            return getLocalName().hashCode();
        }
        return (getNs().getUri().hashCode() * 13) + getLocalName().hashCode();
    }

    public String toString() {
        if (getNs() == null || StringUtil.EMPTY_STRING.equals(getNs().getAlias())) {
            return getLocalName();
        }
        return getNs().getAlias() + ":" + getLocalName();
    }

    public int compareTo(QName o) {
        if (getNs() == null) {
            if (o.getNs() != null) {
                return -1;
            }
        } else if (o.getNs() == null) {
            return 1;
        } else {
            int result = getNs().getUri().compareTo(o.getNs().getUri());
            if (result != 0) {
                if (ANY_NAMESPACE.equals(o.getNs())) {
                    return -1;
                }
                return result;
            }
        }
        String localName = getLocalName();
        int compare = localName.compareTo(o.getLocalName());
        if (compare == 0 || !ANY_LOCALNAME.equals(localName)) {
            return compare;
        }
        return -1;
    }
}
