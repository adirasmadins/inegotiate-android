package com.amazonaws.util.json;

public class JSONException extends Exception {
    private static final long serialVersionUID = 0;
    private Throwable cause;

    public JSONException(String str) {
        super(str);
    }

    public JSONException(Throwable th) {
        super(th.getMessage());
        this.cause = th;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
