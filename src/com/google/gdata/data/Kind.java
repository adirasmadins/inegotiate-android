package com.google.gdata.data;

import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ServiceException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kind {
    public static final String META_DIRECTORY = "META-INF/gdata/kinds/";
    private static Map<String, List<Class<Adaptor>>> kindAdaptors;

    public interface Adaptable {
        void addAdaptor(Adaptor adaptor);

        <E extends Adaptor> E getAdaptor(Class<E> cls);

        Collection<Adaptor> getAdaptors();
    }

    public interface Adaptor {
        void declareExtensions(ExtensionProfile extensionProfile);
    }

    public static class AdaptableHelper implements Adaptable {
        private List<Adaptor> adaptors;

        public AdaptableHelper() {
            this.adaptors = new ArrayList();
        }

        public void addAdaptor(Adaptor adaptor) {
            this.adaptors.add(adaptor);
        }

        public Collection<Adaptor> getAdaptors() {
            return this.adaptors;
        }

        public <E extends Adaptor> E getAdaptor(Class<E> adaptorClass) {
            for (Adaptor adaptor : this.adaptors) {
                if (adaptor.getClass().equals(adaptorClass)) {
                    return (Adaptor) adaptorClass.cast(adaptor);
                }
            }
            return null;
        }
    }

    public static class AdaptorException extends ServiceException {
        public AdaptorException(String message) {
            super(message);
            setHttpErrorCodeOverride(500);
        }

        public AdaptorException(String message, Throwable cause) {
            super(message, cause);
            setHttpErrorCodeOverride(500);
        }

        public AdaptorException(Throwable cause) {
            super(cause);
            setHttpErrorCodeOverride(500);
        }
    }

    @Target({ElementType.TYPE})
    public @interface Term {
        String value();
    }

    static {
        kindAdaptors = new HashMap();
    }

    public static boolean isKindCategory(Category category) {
        return Namespaces.gKind.equals(category.getScheme());
    }

    public static String getKindServiceName(String kindTerm) {
        StringBuilder serviceName = new StringBuilder(kindTerm.length());
        try {
            int i;
            URL termUrl = new URL(kindTerm);
            String[] hostComponents = termUrl.getHost().split("\\W");
            int lastIndex = hostComponents.length - 1;
            for (i = lastIndex; i >= 0; i--) {
                if (i != lastIndex) {
                    serviceName.append(".");
                }
                serviceName.append(hostComponents[i]);
            }
            String[] pathComponents = termUrl.getPath().split("\\W");
            for (i = 0; i < pathComponents.length; i++) {
                if (pathComponents[i].length() > 0) {
                    serviceName.append(".");
                    serviceName.append(pathComponents[i]);
                }
            }
            if (termUrl.getRef() != null) {
                String[] refComponents = termUrl.getRef().split("\\W");
                for (i = 0; i < refComponents.length; i++) {
                    if (refComponents[i].length() > 0) {
                        serviceName.append(".");
                        serviceName.append(refComponents[i]);
                    }
                }
            }
            return serviceName.toString();
        } catch (MalformedURLException mue) {
            throw new IllegalArgumentException("Kind term must be a valid URL", mue);
        }
    }

    public static Class<Adaptor> getAdaptorClass(String kindTerm, Adaptable adaptable) throws AdaptorException {
        ClassLoader cl = adaptable.getClass().getClassLoader();
        List<Class<Adaptor>> adaptorList = (List) kindAdaptors.get(kindTerm);
        if (adaptorList == null) {
            adaptorList = new ArrayList();
            try {
                InputStream serviceStream = cl.getResourceAsStream(META_DIRECTORY + getKindServiceName(kindTerm));
                if (serviceStream == null) {
                    return null;
                }
                BufferedReader rdr = new BufferedReader(new InputStreamReader(serviceStream));
                while (true) {
                    String line = rdr.readLine();
                    if (line == null) {
                        break;
                    } else if (line.charAt(0) != '#') {
                        adaptorList.add(cl.loadClass(line));
                    }
                }
                kindAdaptors.put(kindTerm, adaptorList);
            } catch (IOException ioe) {
                throw new AdaptorException("Unable to load Adaptor service info", ioe);
            } catch (ClassNotFoundException cnfe) {
                throw new AdaptorException("Unable to load Adaptor class", cnfe);
            }
        }
        if (adaptorList.size() == 1) {
            return (Class) adaptorList.get(0);
        }
        for (Class<Adaptor> adaptorClass : adaptorList) {
            for (Class<? extends Adaptable> checkClass = adaptable.getClass(); Adaptable.class.isAssignableFrom(checkClass); checkClass = checkClass.getSuperclass()) {
                if (checkClass.isAssignableFrom(adaptorClass)) {
                    return adaptorClass;
                }
            }
        }
        return null;
    }

    public static Adaptor getAdaptor(String kindTerm, Adaptable adaptable) throws AdaptorException {
        Class<Adaptor> adaptorClass = getAdaptorClass(kindTerm, adaptable);
        if (adaptorClass == null) {
            return null;
        }
        Adaptor adaptor = adaptable.getAdaptor(adaptorClass);
        if (adaptor != null) {
            return adaptor;
        }
        Constructor<?> adaptorConstructor = null;
        Class<?> constructorArgClass = adaptable.getClass();
        while (constructorArgClass != null) {
            try {
                adaptorConstructor = adaptorClass.getConstructor(new Class[]{constructorArgClass});
                break;
            } catch (NoSuchMethodException e) {
                constructorArgClass = constructorArgClass.getSuperclass();
            }
        }
        if (adaptorConstructor == null) {
            try {
                adaptorConstructor = adaptorClass.getConstructor(new Class[0]);
            } catch (NoSuchMethodException e2) {
                throw new AdaptorException("Unable to construct Adaptor " + adaptorClass + " instance for " + adaptable.getClass());
            }
        }
        if (constructorArgClass == null) {
            try {
                adaptor = (Adaptor) adaptorConstructor.newInstance(new Object[0]);
            } catch (RuntimeException re) {
                throw re;
            } catch (Exception e3) {
                throw new AdaptorException("Unable to create kind Adaptor", e3);
            }
        }
        adaptor = (Adaptor) adaptorConstructor.newInstance(new Object[]{adaptable});
        adaptable.addAdaptor(adaptor);
        return adaptor;
    }
}
