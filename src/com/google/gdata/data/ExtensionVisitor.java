package com.google.gdata.data;

public interface ExtensionVisitor {

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

    boolean visit(ExtensionPoint extensionPoint, Extension extension) throws StoppedException;

    void visitComplete(ExtensionPoint extensionPoint) throws StoppedException;
}
