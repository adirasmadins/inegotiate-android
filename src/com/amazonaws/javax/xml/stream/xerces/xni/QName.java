package com.amazonaws.javax.xml.stream.xerces.xni;

public class QName implements Cloneable {
    public char[] characters;
    public String localpart;
    public String prefix;
    public String rawname;
    public String uri;

    public QName() {
        this.characters = null;
        clear();
    }

    public QName(String prefix, String localpart, String rawname, String uri) {
        this.characters = null;
        setValues(prefix, localpart, rawname, uri);
    }

    public QName(QName qname) {
        this.characters = null;
        setValues(qname);
    }

    public void setValues(QName qname) {
        this.prefix = qname.prefix;
        this.localpart = qname.localpart;
        this.rawname = qname.rawname;
        this.uri = qname.uri;
        this.characters = qname.characters;
    }

    public void setValues(String prefix, String localpart, String rawname, String uri) {
        this.prefix = prefix;
        this.localpart = localpart;
        this.rawname = rawname;
        this.uri = uri;
    }

    public void clear() {
        this.prefix = null;
        this.localpart = null;
        this.rawname = null;
        this.uri = null;
    }

    public Object clone() {
        return new QName(this);
    }

    public int hashCode() {
        if (this.uri != null) {
            return this.uri.hashCode() + this.localpart.hashCode();
        }
        return this.rawname.hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof QName) {
            QName qname = (QName) object;
            if (qname.uri != null) {
                if (this.uri == qname.uri && this.localpart == qname.localpart) {
                    return true;
                }
                return false;
            } else if (this.uri == null) {
                if (this.rawname != qname.rawname) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        boolean comma = false;
        if (this.prefix != null) {
            str.append(new StringBuffer().append("prefix=\"").append(this.prefix).append('\"').toString());
            comma = true;
        }
        if (this.localpart != null) {
            if (comma) {
                str.append(',');
            }
            str.append(new StringBuffer().append("localpart=\"").append(this.localpart).append('\"').toString());
            comma = true;
        }
        if (this.rawname != null) {
            if (comma) {
                str.append(',');
            }
            str.append(new StringBuffer().append("rawname=\"").append(this.rawname).append('\"').toString());
            comma = true;
        }
        if (this.uri != null) {
            if (comma) {
                str.append(',');
            }
            str.append(new StringBuffer().append("uri=\"").append(this.uri).append('\"').toString());
        }
        return str.toString();
    }
}
