package com.google.gdata.wireformats;

import com.google.common.collect.MapMaker;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.DateTime;
import com.google.gdata.util.ParseException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public abstract class ObjectConverter<T> {
    private static final ConcurrentMap<Class<?>, ObjectConverter<?>> CONVERTERS;

    private static class BooleanConverter extends ObjectConverter<Boolean> {
        private BooleanConverter() {
        }

        public Boolean convertValue(String value, Class<? extends Boolean> cls) throws ParseException {
            if (value == null) {
                return null;
            }
            if ("true".equals(value) || "1".equals(value) || "ture".equals(value)) {
                return Boolean.TRUE;
            }
            if ("false".equals(value) || "0".equals(value)) {
                return Boolean.FALSE;
            }
            throw new ParseException(CoreErrorDomain.ERR.invalidBooleanAttribute.withInternalReason("Invalid boolean value: '" + value + "'"));
        }
    }

    private static class DateTimeConverter extends ObjectConverter<DateTime> {
        private DateTimeConverter() {
        }

        public DateTime convertValue(String value, Class<? extends DateTime> cls) throws ParseException {
            try {
                return DateTime.parseDateTimeChoice(value);
            } catch (Throwable e) {
                throw new ParseException(CoreErrorDomain.ERR.invalidDatetime, e);
            }
        }
    }

    private static class EnumConverter extends ObjectConverter<Enum> {
        private EnumConverter() {
        }

        public Enum<?> convertValue(String value, Class<? extends Enum> datatype) throws ParseException {
            if (value == null) {
                return null;
            }
            Enum<?> result = Enum.valueOf(datatype, value.toUpperCase());
            if (result != null) {
                return result;
            }
            throw new ParseException(CoreErrorDomain.ERR.invalidEnumValue.withInternalReason("No such enum of type " + datatype + " named " + value.toUpperCase()));
        }
    }

    public static class MappedEnumConverter<T> extends ObjectConverter<T> {
        private final Map<String, T> map;

        public MappedEnumConverter(Map<String, T> map) {
            this.map = map;
        }

        public T convertValue(String value, Class<? extends T> datatype) throws ParseException {
            T converted = this.map.get(value);
            if (converted != null) {
                return converted;
            }
            throw new ParseException(CoreErrorDomain.ERR.invalidEnumValue.withInternalReason("No such pseudo enum value of type " + datatype + " named " + value));
        }
    }

    public abstract T convertValue(String str, Class<? extends T> cls) throws ParseException;

    static {
        CONVERTERS = new MapMaker().makeMap();
        addConverter(DateTime.class, new DateTimeConverter());
        addConverter(Enum.class, new EnumConverter());
        addConverter(Boolean.class, new BooleanConverter());
    }

    public static <V> void addConverter(Class<V> type, ObjectConverter<V> converter) {
        CONVERTERS.put(type, converter);
    }

    public static <V> V getValue(Object value, Class<V> datatype) throws ParseException {
        if (value instanceof String) {
            return getValue((String) value, (Class) datatype);
        }
        if (value == null || datatype.isInstance(value)) {
            return datatype.cast(value);
        }
        throw new ParseException("Cannot convert value " + value + " of type " + value.getClass() + " to " + datatype);
    }

    public static <V> V getValue(String value, Class<V> datatype) throws ParseException {
        if (value == null || datatype.isInstance(value)) {
            return datatype.cast(value);
        }
        try {
            ObjectConverter<V> handler = getHandler(datatype);
            if (handler != null) {
                return handler.convertValue(value, datatype);
            }
            return datatype.getConstructor(new Class[]{String.class}).newInstance(new Object[]{value});
        } catch (NoSuchMethodException e) {
            ParseException pe = new ParseException(CoreErrorDomain.ERR.missingConverter);
            pe.setInternalReason("No converter for type " + datatype);
            throw pe;
        } catch (Throwable e2) {
            throw new ParseException(e2);
        } catch (Throwable e22) {
            throw new ParseException(e22);
        } catch (Throwable e222) {
            throw new ParseException(e222);
        } catch (InvocationTargetException e3) {
            throw new ParseException(e3.getTargetException());
        }
    }

    private static <V> ObjectConverter<V> getHandler(Class<? extends V> type) {
        ObjectConverter<V> handler = (ObjectConverter) CONVERTERS.get(type);
        if (handler == null && type.isEnum()) {
            return (ObjectConverter) CONVERTERS.get(Enum.class);
        }
        return handler;
    }
}
