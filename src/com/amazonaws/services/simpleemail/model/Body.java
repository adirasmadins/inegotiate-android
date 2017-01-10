package com.amazonaws.services.simpleemail.model;

public class Body {
    private Content html;
    private Content text;

    public Body(Content content) {
        this.text = content;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Body)) {
            return false;
        }
        Body body = (Body) obj;
        if (((body.getText() == null ? 1 : 0) ^ (getText() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (body.getText() != null && !body.getText().equals(getText())) {
            return false;
        }
        return ((body.getHtml() == null ? 1 : 0) ^ (getHtml() == null ? 1 : 0)) == 0 ? body.getHtml() == null || body.getHtml().equals(getHtml()) : false;
    }

    public Content getHtml() {
        return this.html;
    }

    public Content getText() {
        return this.text;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getText() == null ? 0 : getText().hashCode()) + 31) * 31;
        if (getHtml() != null) {
            i = getHtml().hashCode();
        }
        return hashCode + i;
    }

    public void setHtml(Content content) {
        this.html = content;
    }

    public void setText(Content content) {
        this.text = content;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.text != null) {
            stringBuilder.append("Text: " + this.text + ", ");
        }
        if (this.html != null) {
            stringBuilder.append("Html: " + this.html + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Body withHtml(Content content) {
        this.html = content;
        return this;
    }

    public Body withText(Content content) {
        this.text = content;
        return this;
    }
}
