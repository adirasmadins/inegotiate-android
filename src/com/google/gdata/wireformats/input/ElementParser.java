package com.google.gdata.wireformats.input;

import com.google.gdata.model.Element;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.ContentCreationException;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

public class ElementParser<T> extends CharacterParser<T> {
    public static <T> ElementParser<T> of(AltFormat altFormat, Class<T> resultType) {
        Preconditions.checkArgument(altFormat.getWireFormat() != null, "No wire format defined for " + altFormat);
        return new ElementParser(altFormat, resultType);
    }

    protected ElementParser(AltFormat altFormat, Class<T> resultType) {
        super(altFormat, resultType);
    }

    public <R extends T> R parse(Reader inputReader, InputProperties inProps, Class<R> resultClass) throws IOException, ServiceException {
        Preconditions.checkNotNull(inProps.getRootMetadata(), "No element metadata");
        R result = createResult(resultClass);
        if (result instanceof Element) {
            try {
                return resultClass.cast(this.altFormat.getWireFormat().createParser(inProps, inputReader, Charset.forName(getCharset(inProps))).parse((Element) result));
            } catch (Throwable ice) {
                throw new ParseException("Invalid charset:" + getCharset(inProps), ice);
            } catch (Throwable uce) {
                throw new ParseException("Invalid charset:" + getCharset(inProps), uce);
            } catch (Throwable e) {
                throw new ParseException("Unable to create element to parse into.", e);
            } catch (Throwable e2) {
                throw new ParseException("Error trying to parse element.", e2);
            }
        }
        throw new ContentCreationException("Result class is not an Element type: " + resultClass);
    }
}
