package com.amazonaws.javax.xml.transform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

class SecuritySupport {

    /* renamed from: com.amazonaws.javax.xml.transform.SecuritySupport.1 */
    class C00121 implements PrivilegedAction {
        C00121() {
        }

        public Object run() {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null) {
                return ClassLoader.getSystemClassLoader();
            }
            return cl;
        }
    }

    /* renamed from: com.amazonaws.javax.xml.transform.SecuritySupport.2 */
    class C00132 implements PrivilegedAction {
        final /* synthetic */ String val$propName;

        C00132(String str) {
            this.val$propName = str;
        }

        public Object run() {
            return System.getProperty(this.val$propName);
        }
    }

    /* renamed from: com.amazonaws.javax.xml.transform.SecuritySupport.3 */
    class C00143 implements PrivilegedExceptionAction {
        final /* synthetic */ File val$file;

        C00143(File file) throws FileNotFoundException {
            this.val$file = file;
        }

        public Object run() throws FileNotFoundException {
            return new FileInputStream(this.val$file);
        }
    }

    /* renamed from: com.amazonaws.javax.xml.transform.SecuritySupport.4 */
    class C00154 implements PrivilegedAction {
        final /* synthetic */ ClassLoader val$cl;
        final /* synthetic */ String val$name;

        C00154(ClassLoader classLoader, String str) {
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

    /* renamed from: com.amazonaws.javax.xml.transform.SecuritySupport.5 */
    class C00165 implements PrivilegedAction {
        final /* synthetic */ File val$f;

        C00165(File file) {
            this.val$f = file;
        }

        public Object run() {
            return new Boolean(this.val$f.exists());
        }
    }

    SecuritySupport() {
    }

    ClassLoader getContextClassLoader() throws SecurityException {
        return (ClassLoader) AccessController.doPrivileged(new C00121());
    }

    String getSystemProperty(String propName) {
        return (String) AccessController.doPrivileged(new C00132(propName));
    }

    FileInputStream getFileInputStream(File file) throws FileNotFoundException {
        try {
            return (FileInputStream) AccessController.doPrivileged(new C00143(file));
        } catch (PrivilegedActionException e) {
            throw ((FileNotFoundException) e.getException());
        }
    }

    InputStream getResourceAsStream(ClassLoader cl, String name) {
        return (InputStream) AccessController.doPrivileged(new C00154(cl, name));
    }

    boolean doesFileExist(File f) {
        return ((Boolean) AccessController.doPrivileged(new C00165(f))).booleanValue();
    }
}
