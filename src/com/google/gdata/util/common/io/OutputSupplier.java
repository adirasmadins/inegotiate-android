package com.google.gdata.util.common.io;

import java.io.IOException;

public interface OutputSupplier<T> {
    T getOutput() throws IOException;
}
