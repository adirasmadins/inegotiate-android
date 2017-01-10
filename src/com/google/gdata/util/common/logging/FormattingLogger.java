package com.google.gdata.util.common.logging;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public final class FormattingLogger {
    private static final String LOGGER_CLASS_NAME;
    private final Logger logger;

    public static class Record extends LogRecord {
        private static final long serialVersionUID = 1;
        private final Object[] formatterArgs;
        private final String formatterFormat;
        private boolean needToInferCaller;
        private String sourceClassName;
        private String sourceMethodName;

        public String getSourceMethodName() {
            if (this.needToInferCaller) {
                inferCaller(FormattingLogger.LOGGER_CLASS_NAME);
            }
            return this.sourceMethodName;
        }

        public String getSourceClassName() {
            if (this.needToInferCaller) {
                inferCaller(FormattingLogger.LOGGER_CLASS_NAME);
            }
            return this.sourceClassName;
        }

        public Object[] getFormatterArgs() {
            return this.formatterArgs;
        }

        public String getFormatterFormat() {
            return this.formatterFormat;
        }

        public void setSourceClassName(String sourceClassName) {
            this.sourceClassName = sourceClassName;
            super.setSourceClassName(sourceClassName);
        }

        public void setSourceMethodName(String sourceMethodName) {
            this.sourceMethodName = sourceMethodName;
            super.setSourceMethodName(sourceMethodName);
        }

        Record(Level level, String msg) {
            super(level, msg);
            this.needToInferCaller = true;
            this.formatterFormat = null;
            this.formatterArgs = null;
        }

        Record(Level level, String fmt, Object[] args) {
            super(level, String.format(fmt, args));
            this.needToInferCaller = true;
            this.formatterFormat = fmt;
            this.formatterArgs = args;
        }

        Record(Level level, String msg, String sourceClassName, String sourceMethodName) {
            super(level, msg);
            setSourceClassName(sourceClassName);
            setSourceMethodName(sourceMethodName);
            this.formatterFormat = null;
            this.formatterArgs = null;
        }

        Record(Level level, String fmt, Object[] args, String sourceClassName, String sourceMethodName) {
            super(level, String.format(fmt, args));
            setSourceClassName(sourceClassName);
            setSourceMethodName(sourceMethodName);
            this.formatterFormat = fmt;
            this.formatterArgs = args;
        }

        protected void inferCaller(String loggerClassName) {
            this.needToInferCaller = false;
            boolean isSearchingForLogger = true;
            for (StackTraceElement elem : new Throwable().getStackTrace()) {
                String className = elem.getClassName();
                boolean matches = className.equals(loggerClassName);
                if (matches && isSearchingForLogger) {
                    isSearchingForLogger = false;
                } else if (!(matches || isSearchingForLogger)) {
                    setSourceClassName(className);
                    setSourceMethodName(elem.getMethodName());
                    return;
                }
            }
        }
    }

    static {
        LOGGER_CLASS_NAME = FormattingLogger.class.getName();
    }

    public static FormattingLogger getLogger(String name) {
        return new FormattingLogger(Logger.getLogger(name));
    }

    public static FormattingLogger getLogger(Class<?> cls) {
        return getLogger(cls.getCanonicalName());
    }

    public FormattingLogger(Class<?> cls) {
        this(Logger.getLogger(cls.getCanonicalName()));
    }

    public FormattingLogger() {
        this(Logger.getAnonymousLogger());
    }

    public FormattingLogger(Logger logger) {
        if (logger == null) {
            throw new NullPointerException("logger is null");
        }
        this.logger = logger;
    }

    public Logger getFormattingLogger() {
        return this.logger;
    }

    public void log(Level level, String msg, Object... params) {
        if (isLoggable(level)) {
            Record record = new Record(level, msg);
            record.setParameters(params);
            nameAndLog(record);
        }
    }

    public void log(Level level, String msg, Throwable thrown) {
        if (isLoggable(level)) {
            Record record = new Record(level, msg);
            record.setThrown(thrown);
            nameAndLog(record);
        }
    }

    public void log(Level level, Throwable thrown, String msg, Object... params) {
        if (isLoggable(level)) {
            Record record = new Record(level, msg);
            if (thrown != null) {
                record.setThrown(thrown);
            }
            if (!(params == null || params.length == 0)) {
                record.setParameters(params);
            }
            nameAndLog(record);
        }
    }

    private void nameAndLog(Record record) {
        record.setLoggerName(this.logger.getName());
        log(record);
    }

    public void log(LogRecord lr) {
        if (!(lr instanceof Record)) {
            Record rec = new Record(Level.INFO, null);
            lr.setSourceClassName(rec.getSourceClassName());
            lr.setSourceMethodName(rec.getSourceMethodName());
        }
        this.logger.log(lr);
    }

    public void logp(Level level, String sourceClassName, String sourceMethodName, String msg, Object... params) {
        if (isLoggable(level)) {
            Record record = new Record(level, msg, sourceClassName, sourceMethodName);
            if (!(params == null || params.length == 0)) {
                record.setParameters(params);
            }
            nameAndLog(record);
        }
    }

    public void logp(Level level, String sourceClassName, String sourceMethodName, String msg, Throwable thrown) {
        if (isLoggable(level)) {
            Record record = new Record(level, msg, sourceClassName, sourceMethodName);
            record.setThrown(thrown);
            nameAndLog(record);
        }
    }

    public void logp(Level level, String sourceClassName, String sourceMethodName, Throwable thrown, String msg, Object... params) {
        if (isLoggable(level)) {
            Record record = new Record(level, msg, sourceClassName, sourceMethodName);
            if (thrown != null) {
                record.setThrown(thrown);
            }
            if (!(params == null || params.length == 0)) {
                record.setParameters(params);
            }
            nameAndLog(record);
        }
    }

    public boolean isLoggable(Level level) {
        return this.logger.isLoggable(level);
    }

    public Level getLevel() {
        return this.logger.getLevel();
    }

    public void setLevel(Level level) {
        this.logger.setLevel(level);
    }

    public void logfmt(Level level, String fmt, Object... args) {
        if (this.logger.isLoggable(level)) {
            nameAndLog(new Record(level, fmt, args));
        }
    }

    public void logfmt(Level level, String fmt, Throwable thrown) {
        if (this.logger.isLoggable(level)) {
            Record record = new Record(level, fmt, new Object[]{thrown});
            record.setThrown(thrown);
            nameAndLog(record);
        }
    }

    public void logfmt(Level level, Throwable thrown, String fmt, Object... args) {
        if (this.logger.isLoggable(level)) {
            Record record = new Record(level, fmt, args);
            record.setThrown(thrown);
            nameAndLog(record);
        }
    }

    public void logpfmt(Level level, String sourceClassName, String sourceMethodName, String fmt, Object... args) {
        if (isLoggable(level)) {
            nameAndLog(new Record(level, fmt, args, sourceClassName, sourceMethodName));
        }
    }

    public void logpfmt(Level level, String sourceClassName, String sourceMethodName, String fmt, Throwable thrown) {
        if (isLoggable(level)) {
            Record record = new Record(level, fmt, new Object[]{thrown}, sourceClassName, sourceMethodName);
            record.setThrown(thrown);
            nameAndLog(record);
        }
    }

    public void logpfmt(Level level, String sourceClassName, String sourceMethodName, Throwable thrown, String fmt, Object... args) {
        if (this.logger.isLoggable(level)) {
            logp(level, sourceClassName, sourceMethodName, thrown, String.format(fmt, args), (Object[]) null);
        }
    }

    public void severe(String msg, Throwable thrown) {
        log(Level.SEVERE, thrown, msg, thrown);
    }

    public void warning(String msg, Throwable thrown) {
        log(Level.WARNING, thrown, msg, thrown);
    }

    public void info(String msg, Throwable thrown) {
        log(Level.INFO, thrown, msg, thrown);
    }

    public void config(String msg, Throwable thrown) {
        log(Level.CONFIG, thrown, msg, thrown);
    }

    public void fine(String msg, Throwable thrown) {
        log(Level.FINE, thrown, msg, thrown);
    }

    public void finer(String msg, Throwable thrown) {
        log(Level.FINER, thrown, msg, thrown);
    }

    public void finest(String msg, Throwable thrown) {
        log(Level.FINEST, thrown, msg, thrown);
    }

    public void severefmt(String fmt, Throwable thrown) {
        logfmt(Level.SEVERE, thrown, fmt, thrown);
    }

    public void warningfmt(String fmt, Throwable thrown) {
        logfmt(Level.WARNING, thrown, fmt, thrown);
    }

    public void infofmt(String fmt, Throwable thrown) {
        logfmt(Level.INFO, thrown, fmt, thrown);
    }

    public void configfmt(String fmt, Throwable thrown) {
        logfmt(Level.CONFIG, thrown, fmt, thrown);
    }

    public void finefmt(String fmt, Throwable thrown) {
        logfmt(Level.FINE, thrown, fmt, thrown);
    }

    public void finerfmt(String fmt, Throwable thrown) {
        logfmt(Level.FINER, thrown, fmt, thrown);
    }

    public void finestfmt(String fmt, Throwable thrown) {
        logfmt(Level.FINEST, thrown, fmt, thrown);
    }

    public void severe(String msg, Object... params) {
        log(Level.SEVERE, msg, params);
    }

    public void warning(String msg, Object... params) {
        log(Level.WARNING, msg, params);
    }

    public void info(String msg, Object... params) {
        log(Level.INFO, msg, params);
    }

    public void config(String msg, Object... params) {
        log(Level.CONFIG, msg, params);
    }

    public void fine(String msg, Object... params) {
        log(Level.FINE, msg, params);
    }

    public void finer(String msg, Object... params) {
        log(Level.FINER, msg, params);
    }

    public void finest(String msg, Object... params) {
        log(Level.FINEST, msg, params);
    }

    public void severefmt(String fmt, Object... args) {
        logfmt(Level.SEVERE, fmt, args);
    }

    public void warningfmt(String fmt, Object... args) {
        logfmt(Level.WARNING, fmt, args);
    }

    public void infofmt(String fmt, Object... args) {
        logfmt(Level.INFO, fmt, args);
    }

    public void configfmt(String fmt, Object... args) {
        logfmt(Level.CONFIG, fmt, args);
    }

    public void finefmt(String fmt, Object... args) {
        logfmt(Level.FINE, fmt, args);
    }

    public void finerfmt(String fmt, Object... args) {
        logfmt(Level.FINER, fmt, args);
    }

    public void finestfmt(String fmt, Object... args) {
        logfmt(Level.FINEST, fmt, args);
    }

    public void severefmt(Throwable thrown, String fmt, Object... args) {
        logfmt(Level.SEVERE, thrown, fmt, args);
    }

    public void warningfmt(Throwable thrown, String fmt, Object... args) {
        logfmt(Level.WARNING, thrown, fmt, args);
    }

    public void infofmt(Throwable thrown, String fmt, Object... args) {
        logfmt(Level.INFO, thrown, fmt, args);
    }

    public void configfmt(Throwable thrown, String fmt, Object... args) {
        logfmt(Level.CONFIG, thrown, fmt, args);
    }

    public void finefmt(Throwable thrown, String fmt, Object... args) {
        logfmt(Level.FINE, thrown, fmt, args);
    }

    public void finerfmt(Throwable thrown, String fmt, Object... args) {
        logfmt(Level.FINER, thrown, fmt, args);
    }

    public void finestfmt(Throwable thrown, String fmt, Object... args) {
        logfmt(Level.FINEST, thrown, fmt, args);
    }
}
