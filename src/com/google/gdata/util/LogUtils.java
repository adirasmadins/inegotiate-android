package com.google.gdata.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class LogUtils {
    public static void logException(Logger logger, Level level, String prefix, Throwable e) {
        String message = e.toString();
        if (prefix != null) {
            message = prefix + ": " + message;
        }
        logger.log(level, message, e);
    }
}
