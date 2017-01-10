package com.amazonaws.javax.xml.stream.xerces.util;

import com.google.gdata.util.common.base.StringUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ObjectFactory {
    private static final boolean DEBUG = false;
    private static final String DEFAULT_PROPERTIES_FILENAME = "xerces.properties";
    static /* synthetic */ Class class$com$sun$xml$stream$xerces$util$ObjectFactory;

    public static class ConfigurationError extends Error {
        private Exception exception;

        public ConfigurationError(String msg, Exception x) {
            super(msg);
            this.exception = x;
        }

        public Exception getException() {
            return this.exception;
        }
    }

    public static Object createObject(String factoryId, String fallbackClassName) throws ConfigurationError {
        return createObject(factoryId, null, fallbackClassName);
    }

    public static Object createObject(String factoryId, String propertiesFilename, String fallbackClassName) throws ConfigurationError {
        debugPrintln("debug is on");
        SecuritySupport ss = SecuritySupport.getInstance();
        ClassLoader cl = findClassLoader();
        try {
            String systemProp = ss.getSystemProperty(factoryId);
            if (systemProp != null) {
                debugPrintln(new StringBuffer().append("found system property, value=").append(systemProp).toString());
                return newInstance(systemProp, cl, true);
            }
        } catch (SecurityException e) {
        }
        if (propertiesFilename == null) {
            try {
                propertiesFilename = new StringBuffer().append(ss.getSystemProperty("java.home")).append(File.separator).append("lib").append(File.separator).append(DEFAULT_PROPERTIES_FILENAME).toString();
            } catch (Exception e2) {
            }
        }
        FileInputStream fis = ss.getFileInputStream(new File(propertiesFilename));
        Properties props = new Properties();
        props.load(fis);
        String factoryClassName = props.getProperty(factoryId);
        if (factoryClassName != null) {
            debugPrintln(new StringBuffer().append("found in ").append(propertiesFilename).append(", value=").append(factoryClassName).toString());
            return newInstance(factoryClassName, cl, true);
        }
        Object provider = findJarServiceProvider(factoryId);
        if (provider != null) {
            return provider;
        }
        if (fallbackClassName == null) {
            throw new ConfigurationError(new StringBuffer().append("Provider for ").append(factoryId).append(" cannot be found").toString(), null);
        }
        debugPrintln(new StringBuffer().append("using fallback, value=").append(fallbackClassName).toString());
        return newInstance(fallbackClassName, cl, true);
    }

    private static void debugPrintln(String msg) {
    }

    public static ClassLoader findClassLoader() throws ConfigurationError {
        ClassLoader cl = SecuritySupport.getInstance().getContextClassLoader();
        if (cl != null) {
            return cl;
        }
        Class class$;
        if (class$com$sun$xml$stream$xerces$util$ObjectFactory == null) {
            class$ = class$("com.amazonaws.javax.xml.stream.xerces.util.ObjectFactory");
            class$com$sun$xml$stream$xerces$util$ObjectFactory = class$;
        } else {
            class$ = class$com$sun$xml$stream$xerces$util$ObjectFactory;
        }
        return class$.getClassLoader();
    }

    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError().initCause(x1);
        }
    }

    public static Object newInstance(String className, ClassLoader cl, boolean doFallback) throws ConfigurationError {
        try {
            Class providerClass = findProviderClass(className, cl, doFallback);
            Object instance = providerClass.newInstance();
            debugPrintln(new StringBuffer().append("created new instance of ").append(providerClass).append(" using ClassLoader: ").append(cl).toString());
            return instance;
        } catch (ClassNotFoundException x) {
            throw new ConfigurationError(new StringBuffer().append("Provider ").append(className).append(" not found").toString(), x);
        } catch (Exception x2) {
            throw new ConfigurationError(new StringBuffer().append("Provider ").append(className).append(" could not be instantiated: ").append(x2).toString(), x2);
        }
    }

    public static Class findProviderClass(String className, ClassLoader cl, boolean doFallback) throws ClassNotFoundException, ConfigurationError {
        if (cl == null) {
            return Class.forName(className);
        }
        try {
            return cl.loadClass(className);
        } catch (ClassNotFoundException x) {
            if (doFallback) {
                Class class$;
                if (class$com$sun$xml$stream$xerces$util$ObjectFactory == null) {
                    class$ = class$("com.amazonaws.javax.xml.stream.xerces.util.ObjectFactory");
                    class$com$sun$xml$stream$xerces$util$ObjectFactory = class$;
                } else {
                    class$ = class$com$sun$xml$stream$xerces$util$ObjectFactory;
                }
                return class$.getClassLoader().loadClass(className);
            }
            throw x;
        }
    }

    private static Object findJarServiceProvider(String factoryId) throws ConfigurationError {
        InputStream is;
        SecuritySupport ss = SecuritySupport.getInstance();
        String serviceId = new StringBuffer().append("META-INF/services/").append(factoryId).toString();
        ClassLoader cl = ss.getContextClassLoader();
        Class class$;
        if (cl != null) {
            is = ss.getResourceAsStream(cl, serviceId);
            if (is == null) {
                if (class$com$sun$xml$stream$xerces$util$ObjectFactory == null) {
                    class$ = class$("com.amazonaws.javax.xml.stream.xerces.util.ObjectFactory");
                    class$com$sun$xml$stream$xerces$util$ObjectFactory = class$;
                } else {
                    class$ = class$com$sun$xml$stream$xerces$util$ObjectFactory;
                }
                cl = class$.getClassLoader();
                is = ss.getResourceAsStream(cl, serviceId);
            }
        } else {
            if (class$com$sun$xml$stream$xerces$util$ObjectFactory == null) {
                class$ = class$("com.amazonaws.javax.xml.stream.xerces.util.ObjectFactory");
                class$com$sun$xml$stream$xerces$util$ObjectFactory = class$;
            } else {
                class$ = class$com$sun$xml$stream$xerces$util$ObjectFactory;
            }
            cl = class$.getClassLoader();
            is = ss.getResourceAsStream(cl, serviceId);
        }
        if (is == null) {
            return null;
        }
        BufferedReader rd;
        debugPrintln(new StringBuffer().append("found jar resource=").append(serviceId).append(" using ClassLoader: ").append(cl).toString());
        try {
            rd = new BufferedReader(new InputStreamReader(is, StringEncodings.UTF8));
        } catch (UnsupportedEncodingException e) {
            rd = new BufferedReader(new InputStreamReader(is));
        }
        try {
            String factoryClassName = rd.readLine();
            rd.close();
            if (factoryClassName == null || StringUtil.EMPTY_STRING.equals(factoryClassName)) {
                return null;
            }
            debugPrintln(new StringBuffer().append("found in resource, value=").append(factoryClassName).toString());
            return newInstance(factoryClassName, cl, DEBUG);
        } catch (IOException e2) {
            return null;
        }
    }
}
