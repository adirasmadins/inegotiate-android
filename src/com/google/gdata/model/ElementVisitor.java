package com.google.gdata.model;

public interface ElementVisitor {

    public static class StoppedException extends RuntimeException {
        public StoppedException(String message, Throwable cause) {
            super(message, cause);
        }

        public StoppedException(String message) {
            super(message);
        }

        public StoppedException(Throwable cause) {
            super(cause);
        }
    }

    boolean visit(Element element, Element element2, ElementMetadata<?, ?> elementMetadata) throws StoppedException;

    void visitComplete(Element element, Element element2, ElementMetadata<?, ?> elementMetadata) throws StoppedException;
}
