package com.amazonaws.javax.xml.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

class SecuritySupport {

    /* renamed from: com.amazonaws.javax.xml.stream.SecuritySupport.1 */
    class C00011 implements PrivilegedAction {
        C00011() {
        }

        public Object run() {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null) {
                return ClassLoader.getSystemClassLoader();
            }
            return cl;
        }
    }

    /* renamed from: com.amazonaws.javax.xml.stream.SecuritySupport.2 */
    class C00022 implements PrivilegedAction {
        final /* synthetic */ String val$propName;

        C00022(String str) {
            this.val$propName = str;
        }

        public Object run() {
            return System.getProperty(this.val$propName);
        }
    }

    /* renamed from: com.amazonaws.javax.xml.stream.SecuritySupport.3 */
    class C00033 implements PrivilegedExceptionAction {
        final /* synthetic */ File val$file;

        C00033(File file) throws FileNotFoundException {
            this.val$file = file;
        }

        public Object run() throws FileNotFoundException {
            return new FileInputStream(this.val$file);
        }
    }

    /* renamed from: com.amazonaws.javax.xml.stream.SecuritySupport.4 */
    class C00044 implements PrivilegedAction {
        final /* synthetic */ ClassLoader val$cl;
        final /* synthetic */ String val$name;

        C00044(ClassLoader classLoader, String str) {
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

    /* renamed from: com.amazonaws.javax.xml.stream.SecuritySupport.5 */
    class C00055 implements PrivilegedAction {
        final /* synthetic */ File val$f;

        C00055(File file) {
            this.val$f = file;
        }

        public Object run() {
            return new Boolean(this.val$f.exists());
        }
    }

    SecuritySupport() {
    }

    ClassLoader getContextClassLoader() throws SecurityException {
        return (ClassLoader) AccessController.doPrivileged(new C00011());
    }

    String getSystemProperty(String propName) {
        return (String) AccessController.doPrivileged(new C00022(propName));
    }

    FileInputStream getFileInputStream(File file) throws FileNotFoundException {
        try {
            return (FileInputStream) AccessController.doPrivileged(new C00033(file));
        } catch (PrivilegedActionException e) {
            throw ((FileNotFoundException) e.getException());
        }
    }

    InputStream getResourceAsStream(ClassLoader cl, String name) {
        return (InputStream) AccessController.doPrivileged(new C00044(cl, name));
    }

    boolean doesFileExist(File f) {
        return ((Boolean) AccessController.doPrivileged(new C00055(f))).booleanValue();
    }
}
