package com.amazonaws.services.simpleemail.model;

import java.nio.ByteBuffer;

public class RawMessage {
    private ByteBuffer data;

    public RawMessage(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RawMessage)) {
            return false;
        }
        RawMessage rawMessage = (RawMessage) obj;
        return ((rawMessage.getData() == null ? 1 : 0) ^ (getData() == null ? 1 : 0)) == 0 ? rawMessage.getData() == null || rawMessage.getData().equals(getData()) : false;
    }

    public ByteBuffer getData() {
        return this.data;
    }

    public int hashCode() {
        return (getData() == null ? 0 : getData().hashCode()) + 31;
    }

    public void setData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.data != null) {
            stringBuilder.append("Data: " + this.data + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public RawMessage withData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
        return this;
    }
}
