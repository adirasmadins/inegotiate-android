package com.google.gdata.util.common.io;

import java.io.IOException;

public interface InputSupplier<T> {
    T getInput() throws IOException;
}
