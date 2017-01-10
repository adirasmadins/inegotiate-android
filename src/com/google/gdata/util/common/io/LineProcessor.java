package com.google.gdata.util.common.io;

import java.io.IOException;

public interface LineProcessor<T> {
    T getResult();

    boolean processLine(String str) throws IOException;
}
