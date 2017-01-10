package com.amazonaws.services.simpleemail.model;

public class Content {
    private String charset;
    private String data;

    public Content(String str) {
        this.data = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Content)) {
            return false;
        }
        Content content = (Content) obj;
        if (((content.getData() == null ? 1 : 0) ^ (getData() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (content.getData() != null && !content.getData().equals(getData())) {
            return false;
        }
        return ((content.getCharset() == null ? 1 : 0) ^ (getCharset() == null ? 1 : 0)) == 0 ? content.getCharset() == null || content.getCharset().equals(getCharset()) : false;
    }

    public String getCharset() {
        return this.charset;
    }

    public String getData() {
        return this.data;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getData() == null ? 0 : getData().hashCode()) + 31) * 31;
        if (getCharset() != null) {
            i = getCharset().hashCode();
        }
        return hashCode + i;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.data != null) {
            stringBuilder.append("Data: " + this.data + ", ");
        }
        if (this.charset != null) {
            stringBuilder.append("Charset: " + this.charset + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Content withCharset(String str) {
        this.charset = str;
        return this;
    }

    public Content withData(String str) {
        this.data = str;
        return this;
    }
}
