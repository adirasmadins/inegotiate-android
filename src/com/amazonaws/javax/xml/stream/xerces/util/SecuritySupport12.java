package com.amazonaws.javax.xml.stream.xerces.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

class SecuritySupport12 extends SecuritySupport {

    /* renamed from: com.amazonaws.javax.xml.stream.xerces.util.SecuritySupport12.1 */
    class C00081 implements PrivilegedAction {
        C00081() {
        }

        public Object run() {
            ClassLoader cl = null;
            try {
                cl = Thread.currentThread().getContextClassLoader();
            } catch (SecurityException e) {
            }
            return cl;
        }
    }

    /* renamed from: com.amazonaws.javax.xml.stream.xerces.util.SecuritySupport12.2 */
    class C00092 implements PrivilegedAction {
        private final /* synthetic */ String val$propName;

        C00092(String str) {
            this.val$propName = str;
        }

        public Object run() {
            return System.getProperty(this.val$propName);
        }
    }

    /* renamed from: com.amazonaws.javax.xml.stream.xerces.util.SecuritySupport12.3 */
    class C00103 implements PrivilegedExceptionAction {
        private final /* synthetic */ File val$file;

        C00103(File file) throws FileNotFoundException {
            this.val$file = file;
        }

        public Object run() throws FileNotFoundException {
            return new FileInputStream(this.val$file);
        }
    }

    /* renamed from: com.amazonaws.javax.xml.stream.xerces.util.SecuritySupport12.4 */
    class C00114 implements PrivilegedAction {
        private final /* synthetic */ ClassLoader val$cl;
        private final /* synthetic */ String val$name;

        C00114(ClassLoader classLoader, String str) {
            this.val$cl = classLoader;
            this.val$name = str;
        }

        public Object run() {
            if (this.val$cl == null) {
                return ClassLoader.getSystemResourceAsStream(this.val$name);
            }
            return this.val$cl.getResourceAsStream(this.val$name);
        }
    }

    SecuritySupport12() {
    }

    public ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new C00081());
    }

    public String getSystemProperty(String propName) {
        return (String) AccessController.doPrivileged(new C00092(propName));
    }

    public FileInputStream getFileInputStream(File file) throws FileNotFoundException {
        try {
            return (FileInputStream) AccessController.doPrivileged(new C00103(file));
        } catch (PrivilegedActionException e) {
            throw ((FileNotFoundException) e.getException());
        }
    }

    public InputStream getResourceAsStream(ClassLoader cl, String name) {
        return (InputStream) AccessController.doPrivileged(new C00114(cl, name));
    }
}
