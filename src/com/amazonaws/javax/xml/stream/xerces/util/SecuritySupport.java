package com.amazonaws.javax.xml.stream.xerces.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

class SecuritySupport {
    private static final Object securitySupport;

    SecuritySupport() {
    }

    static {
        SecuritySupport ss = null;
        try {
            Class c = Class.forName("java.security.AccessController");
            SecuritySupport ss2 = new SecuritySupport12();
            if (ss2 == null) {
                ss = new SecuritySupport();
            } else {
                ss = ss2;
            }
            securitySupport = ss;
        } catch (Exception e) {
            if (null == null) {
                ss = new SecuritySupport();
            }
            securitySupport = ss;
        } catch (Throwable th) {
            if (null == null) {
                ss = new SecuritySupport();
            }
            securitySupport = ss;
        }
    }

    public static SecuritySupport getInstance() {
        return (SecuritySupport) securitySupport;
    }

    public ClassLoader getContextClassLoader() {
        return null;
    }

    public String getSystemProperty(String propName) {
        return System.getProperty(propName);
    }

    public FileInputStream getFileInputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    public InputStream getResourceAsStream(ClassLoader cl, String name) {
        if (cl == null) {
            return ClassLoader.getSystemResourceAsStream(name);
        }
        return cl.getResourceAsStream(name);
    }
}
