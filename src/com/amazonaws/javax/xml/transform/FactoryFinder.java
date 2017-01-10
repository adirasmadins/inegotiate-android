package com.amazonaws.javax.xml.transform;

import com.google.gdata.util.common.base.StringUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

class FactoryFinder {
    static Properties cacheProps;
    private static boolean debug;
    static boolean firstTime;
    static SecuritySupport ss;

    static class ConfigurationError extends Error {
        private Exception exception;

        ConfigurationError(String msg, Exception x) {
            super(msg);
            this.exception = x;
        }

        Exception getException() {
            return this.exception;
        }

        public Throwable getCause() {
            return this.exception;
        }
    }

    FactoryFinder() {
    }

    static {
        boolean z = true;
        debug = false;
        cacheProps = new Properties();
        firstTime = true;
        ss = new SecuritySupport();
        try {
            String val = ss.getSystemProperty("jaxp.debug");
            if (val == null || "false".equals(val)) {
                z = false;
            }
            debug = z;
        } catch (SecurityException e) {
            debug = false;
        }
    }

    private static void dPrint(String msg) {
        if (debug) {
            System.err.println("JAXP: " + msg);
        }
    }

    private static Class getProviderClass(String className, ClassLoader cl, boolean doFallback) throws ClassNotFoundException {
        if (cl != null) {
            return cl.loadClass(className);
        }
        try {
            cl = ss.getContextClassLoader();
            if (cl != null) {
                return cl.loadClass(className);
            }
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException e1) {
            if (doFallback) {
                return Class.forName(className, true, FactoryFinder.class.getClassLoader());
            }
            throw e1;
        }
    }

    static Object newInstance(String className, ClassLoader cl, boolean doFallback) throws ConfigurationError {
        try {
            Class providerClass = getProviderClass(className, cl, doFallback);
            Object instance = providerClass.newInstance();
            if (debug) {
                dPrint("created new instance of " + providerClass + " using ClassLoader: " + cl);
            }
            return instance;
        } catch (ClassNotFoundException x) {
            throw new ConfigurationError("Provider " + className + " not found", x);
        } catch (Exception x2) {
            throw new ConfigurationError("Provider " + className + " could not be instantiated: " + x2, x2);
        }
    }

    static Object find(String factoryId, String fallbackClassName) throws ConfigurationError {
        dPrint("find factoryId =" + factoryId);
        try {
            String systemProp = ss.getSystemProperty(factoryId);
            if (systemProp != null) {
                dPrint("found system property, value=" + systemProp);
                return newInstance(systemProp, null, true);
            }
        } catch (SecurityException se) {
            if (debug) {
                se.printStackTrace();
            }
        }
        try {
            if (firstTime) {
                synchronized (cacheProps) {
                    if (firstTime) {
                        File f = new File(ss.getSystemProperty("java.home") + File.separator + "lib" + File.separator + "jaxp.properties");
                        firstTime = false;
                        if (ss.doesFileExist(f)) {
                            dPrint("Read properties file " + f);
                            cacheProps.load(ss.getFileInputStream(f));
                        }
                    }
                }
            }
            String factoryClassName = cacheProps.getProperty(factoryId);
            if (factoryClassName != null) {
                dPrint("found in $java.home/jaxp.properties, value=" + factoryClassName);
                return newInstance(factoryClassName, null, true);
            }
        } catch (Exception ex) {
            if (debug) {
                ex.printStackTrace();
            }
        }
        Object provider = findJarServiceProvider(factoryId);
        if (provider != null) {
            return provider;
        }
        if (fallbackClassName == null) {
            throw new ConfigurationError("Provider for " + factoryId + " cannot be found", null);
        }
        dPrint("loaded from fallback value: " + fallbackClassName);
        return newInstance(fallbackClassName, null, true);
    }

    private static Object findJarServiceProvider(String factoryId) throws ConfigurationError {
        InputStream is;
        String serviceId = "META-INF/services/" + factoryId;
        ClassLoader cl = ss.getContextClassLoader();
        if (cl != null) {
            is = ss.getResourceAsStream(cl, serviceId);
            if (is == null) {
                cl = FactoryFinder.class.getClassLoader();
                is = ss.getResourceAsStream(cl, serviceId);
            }
        } else {
            cl = FactoryFinder.class.getClassLoader();
            is = ss.getResourceAsStream(cl, serviceId);
        }
        if (is == null) {
            return null;
        }
        BufferedReader rd;
        if (debug) {
            dPrint("found jar resource=" + serviceId + " using ClassLoader: " + cl);
        }
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
            dPrint("found in resource, value=" + factoryClassName);
            return newInstance(factoryClassName, cl, false);
        } catch (IOException e2) {
            return null;
        }
    }
}
