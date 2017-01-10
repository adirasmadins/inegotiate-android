package com.amazonaws.services.simpleemail.model;

public class Message {
    private Body body;
    private Content subject;

    public Message(Content content, Body body) {
        this.subject = content;
        this.body = body;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        if (((message.getSubject() == null ? 1 : 0) ^ (getSubject() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (message.getSubject() != null && !message.getSubject().equals(getSubject())) {
            return false;
        }
        return ((message.getBody() == null ? 1 : 0) ^ (getBody() == null ? 1 : 0)) == 0 ? message.getBody() == null || message.getBody().equals(getBody()) : false;
    }

    public Body getBody() {
        return this.body;
    }

    public Content getSubject() {
        return this.subject;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSubject() == null ? 0 : getSubject().hashCode()) + 31) * 31;
        if (getBody() != null) {
            i = getBody().hashCode();
        }
        return hashCode + i;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void setSubject(Content content) {
        this.subject = content;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.subject != null) {
            stringBuilder.append("Subject: " + this.subject + ", ");
        }
        if (this.body != null) {
            stringBuilder.append("Body: " + this.body + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Message withBody(Body body) {
        this.body = body;
        return this;
    }

    public Message withSubject(Content content) {
        this.subject = content;
        return this;
    }
}
