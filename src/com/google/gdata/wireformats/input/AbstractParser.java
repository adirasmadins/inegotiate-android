package com.google.gdata.wireformats.input;

import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.ContentCreationException;

public abstract class AbstractParser<T> implements InputParser<T> {
    protected final AltFormat altFormat;
    protected final Class<? extends T> resultType;

    protected AbstractParser(AltFormat altFormat, Class<? extends T> resultType) {
        Preconditions.checkNotNull(altFormat, "altFormat");
        Preconditions.checkNotNull(resultType, "resultType");
        this.altFormat = altFormat;
        this.resultType = resultType;
    }

    public AltFormat getAltFormat() {
        return this.altFormat;
    }

    public Class<? extends T> getResultType() {
        return this.resultType;
    }

    protected T createResult() throws ContentCreationException {
        return createResult(this.resultType);
    }

    protected <R extends T> R createResult(Class<R> resultImplClass) throws ContentCreationException {
        try {
            return resultImplClass.newInstance();
        } catch (IllegalAccessException iae) {
            throw new IllegalStateException("Can't create parse target", iae);
        } catch (InstantiationException ie) {
            throw new IllegalStateException("Can't create parse target", ie);
        }
    }
}
