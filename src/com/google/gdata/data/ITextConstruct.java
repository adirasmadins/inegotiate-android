package com.google.gdata.data;

public interface ITextConstruct {

    public static class Type {
        public static final int HTML = 2;
        public static final int TEXT = 1;
        public static final int XHTML = 3;
    }

    String getPlainText();

    int getType();
}
