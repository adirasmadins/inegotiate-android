package com.google.gdata.wireformats.input;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Entry;
import com.google.gdata.data.Feed;
import com.google.gdata.data.IAtom;
import com.google.gdata.data.XmlEventSource;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.ContentCreationException;
import java.io.IOException;
import java.io.Reader;

public class AtomDataParser extends XmlInputParser<IAtom> {
    public AtomDataParser() {
        super(AltFormat.ATOM, IAtom.class);
    }

    public <R extends IAtom> R parse(Reader inputReader, InputProperties inProps, Class<R> resultClass) throws IOException, ServiceException {
        Preconditions.checkNotNull(inProps.getExtensionProfile(), "No extension profile");
        IAtom result = (IAtom) createResult(resultClass);
        if (result instanceof BaseEntry) {
            BaseEntry<?> entryResult = (BaseEntry) result;
            entryResult.parseAtom(inProps.getExtensionProfile(), inputReader);
            if (resultClass != Entry.class) {
                return result;
            }
            BaseEntry<?> adaptedEntry = entryResult.getAdaptedEntry();
            if (resultClass.isInstance(adaptedEntry)) {
                return (IAtom) resultClass.cast(adaptedEntry);
            }
            return result;
        } else if (result instanceof BaseFeed) {
            BaseFeed<?, ?> feedResult = (BaseFeed) result;
            feedResult.parseAtom(inProps.getExtensionProfile(), inputReader);
            if (resultClass != Feed.class) {
                return result;
            }
            BaseFeed<?, ?> adaptedFeed = feedResult.getAdaptedFeed();
            if (resultClass.isInstance(adaptedFeed)) {
                return (IAtom) resultClass.cast(adaptedFeed);
            }
            return result;
        } else {
            throw new ContentCreationException("Invalid result class: " + resultClass);
        }
    }

    protected <R extends IAtom> R parse(XmlEventSource eventSource, InputProperties inProps, Class<R> resultClass) throws IOException, ServiceException {
        Preconditions.checkNotNull(inProps.getExtensionProfile(), "No extension profile");
        IAtom result = (IAtom) createResult(resultClass);
        if (result instanceof BaseEntry) {
            ((BaseEntry) result).parseAtom(inProps.getExtensionProfile(), eventSource);
        } else if (result instanceof BaseFeed) {
            ((BaseFeed) result).parseAtom(inProps.getExtensionProfile(), eventSource);
        } else {
            throw new ContentCreationException("Invalid result class: " + resultClass);
        }
        return result;
    }
}
