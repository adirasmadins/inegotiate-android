package com.google.ads.mediation;

import com.google.ads.util.C0299b;
import com.google.gdata.util.common.base.StringUtil;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class MediationServerParameters {

    public static class MappingException extends Exception {
        public MappingException(String message) {
            super(message);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Parameter {
        String name();

        boolean required() default true;
    }

    public void load(Map<String, String> parameters) throws MappingException {
        Map hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            Parameter parameter = (Parameter) field.getAnnotation(Parameter.class);
            if (parameter != null) {
                hashMap.put(parameter.name(), field);
            }
        }
        if (hashMap.isEmpty()) {
            C0299b.m390e("No server options fields detected.  To suppress this message either add a field with the @Parameter annotation, or override the load() method");
        }
        for (Entry entry : parameters.entrySet()) {
            Field field2 = (Field) hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException e) {
                    C0299b.m384b("Server Option '" + ((String) entry.getKey()) + "' could not be set: Illegal Access");
                } catch (IllegalArgumentException e2) {
                    C0299b.m384b("Server Option '" + ((String) entry.getKey()) + "' could not be set: Bad Type");
                }
            } else {
                C0299b.m390e("Unexpected Server Option: " + ((String) entry.getKey()) + " = '" + ((String) entry.getValue()) + "'");
            }
        }
        String str = null;
        for (Field field22 : hashMap.values()) {
            String str2;
            if (((Parameter) field22.getAnnotation(Parameter.class)).required()) {
                C0299b.m384b("Required Server Option missing: " + ((Parameter) field22.getAnnotation(Parameter.class)).name());
                str2 = (str == null ? StringUtil.EMPTY_STRING : str + ", ") + ((Parameter) field22.getAnnotation(Parameter.class)).name();
            } else {
                str2 = str;
            }
            str = str2;
        }
        if (str != null) {
            throw new MappingException("Required Server Option(s) missing: " + str);
        }
        m312a();
    }

    protected void m312a() {
    }
}
