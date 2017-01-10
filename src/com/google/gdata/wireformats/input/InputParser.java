package com.google.gdata.wireformats.input;

import com.google.gdata.data.ParseSource;
import com.google.gdata.util.ServiceException;
import com.google.gdata.wireformats.AltFormat;
import java.io.IOException;

public interface InputParser<T> {
    AltFormat getAltFormat();

    Class<? extends T> getResultType();

    <R extends T> R parse(ParseSource parseSource, InputProperties inputProperties, Class<R> cls) throws IOException, ServiceException;
}
