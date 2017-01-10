package com.google.gdata.util;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Entry;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Feed;
import com.google.gdata.data.IEntry;
import com.google.gdata.data.IFeed;
import com.google.gdata.data.ParseSource;
import com.google.gdata.model.Element;
import com.google.gdata.model.Schema;
import com.google.gdata.util.common.base.Charsets;
import com.google.gdata.wireformats.ContentValidationException;
import com.google.gdata.wireformats.WireFormat;
import com.google.gdata.wireformats.WireFormatParser;
import com.google.gdata.wireformats.input.InputProperties;
import com.google.gdata.wireformats.input.InputPropertiesBuilder;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseUtil {
    public static IEntry readEntry(ParseSource source) throws IOException, ParseException, ServiceException {
        return readEntry(source, null, null, null);
    }

    public static <T extends IEntry> T readEntry(ParseSource source, Class<T> requestedClass, ExtensionProfile extProfile, Schema schema) throws IOException, ParseException, ServiceException {
        if (source == null) {
            throw new NullPointerException("Null source");
        }
        Class<? extends IEntry> entryClass = requestedClass;
        Class<? extends IEntry> responseClass = requestedClass;
        if (entryClass == null) {
            entryClass = Entry.class;
            responseClass = BaseEntry.class;
        }
        boolean isAdapting = isAdapting(entryClass);
        try {
            IEntry entry = (IEntry) entryClass.newInstance();
            if (entry instanceof Element) {
                entry = (IEntry) entryClass.cast(parseElement(source, (Element) entry, schema));
            } else {
                BaseEntry baseEntry = (BaseEntry) entry;
                if (extProfile == null) {
                    extProfile = getExtProfile(baseEntry, isAdapting);
                }
                parseEntry(source, baseEntry, extProfile);
                if (isAdapting) {
                    BaseEntry<?> adaptedEntry = baseEntry.getAdaptedEntry();
                    if (responseClass.isInstance(adaptedEntry)) {
                        Object entry2 = adaptedEntry;
                    }
                }
            }
            return (IEntry) responseClass.cast(entry);
        } catch (Throwable iae) {
            throw new ServiceException(CoreErrorDomain.ERR.cantCreateEntry, iae);
        } catch (Throwable ie) {
            throw new ServiceException(CoreErrorDomain.ERR.cantCreateEntry, ie);
        }
    }

    public static IFeed readFeed(ParseSource source) throws IOException, ParseException, ServiceException {
        return readFeed(source, null, null, null);
    }

    public static <F extends IFeed> F readFeed(ParseSource source, Class<F> requestedClass, ExtensionProfile extProfile, Schema schema) throws IOException, ParseException, ServiceException {
        if (source == null) {
            throw new NullPointerException("Null source");
        }
        Class<? extends IFeed> feedClass = requestedClass;
        Class<? extends IFeed> responseClass = requestedClass;
        if (feedClass == null) {
            feedClass = Feed.class;
            responseClass = BaseFeed.class;
        }
        boolean isAdapting = isAdapting(feedClass);
        try {
            IFeed feed = (IFeed) feedClass.newInstance();
            if (feed instanceof Element) {
                feed = (IFeed) feedClass.cast(parseElement(source, (Element) feed, schema));
            } else {
                BaseFeed baseFeed = (BaseFeed) feed;
                if (extProfile == null) {
                    extProfile = getExtProfile(baseFeed, isAdapting);
                }
                parseFeed(source, baseFeed, extProfile);
                if (isAdapting) {
                    BaseFeed<?, ?> adaptedFeed = baseFeed.getAdaptedFeed();
                    if (responseClass.isInstance(adaptedFeed)) {
                        Object feed2 = adaptedFeed;
                    }
                }
            }
            return (IFeed) responseClass.cast(feed);
        } catch (Throwable iae) {
            throw new ServiceException(CoreErrorDomain.ERR.cantCreateFeed, iae);
        } catch (Throwable ie) {
            throw new ServiceException(CoreErrorDomain.ERR.cantCreateFeed, ie);
        }
    }

    private static Element parseElement(ParseSource source, Element element, Schema schema) throws ParseException, IOException {
        WireFormatParser parser;
        WireFormat format = WireFormat.XML;
        InputProperties inProps = ((InputPropertiesBuilder) new InputPropertiesBuilder().setElementMetadata(schema.bind(element.getElementKey()))).build();
        if (source.getReader() != null) {
            parser = format.createParser(inProps, source.getReader(), Charsets.UTF_8);
        } else if (source.getInputStream() != null) {
            parser = format.createParser(inProps, new InputStreamReader(source.getInputStream()), Charsets.UTF_8);
        } else if (source.getEventSource() != null) {
            parser = format.createParser(inProps, source.getEventSource());
        } else {
            throw new IllegalStateException("Unexpected source: " + source);
        }
        try {
            return parser.parse(element);
        } catch (Throwable e) {
            throw new ParseException(CoreErrorDomain.ERR.cantCreateExtension, e);
        } catch (ContentValidationException e2) {
            throw e2.toParseException();
        }
    }

    private static void parseEntry(ParseSource source, BaseEntry<?> entry, ExtensionProfile extProfile) throws ParseException, IOException {
        if (source.getReader() != null) {
            entry.parseAtom(extProfile, source.getReader());
        } else if (source.getInputStream() != null) {
            entry.parseAtom(extProfile, source.getInputStream());
        } else if (source.getEventSource() != null) {
            entry.parseAtom(extProfile, source.getEventSource());
        } else {
            throw new IllegalStateException("Unexpected source: " + source);
        }
    }

    private static void parseFeed(ParseSource source, BaseFeed<?, ?> feed, ExtensionProfile extProfile) throws ParseException, IOException {
        if (source.getReader() != null) {
            feed.parseAtom(extProfile, source.getReader());
        } else if (source.getInputStream() != null) {
            feed.parseAtom(extProfile, source.getInputStream());
        } else if (source.getEventSource() != null) {
            feed.parseAtom(extProfile, source.getEventSource());
        } else {
            throw new IllegalStateException("Unexpected source: " + source);
        }
    }

    private static boolean isAdapting(Class<?> clazz) {
        return clazz == Entry.class || clazz == com.google.gdata.model.atom.Entry.class || clazz == Feed.class || clazz == com.google.gdata.model.atom.Feed.class;
    }

    private static ExtensionProfile getExtProfile(BaseEntry<?> entry, boolean isAdapting) {
        ExtensionProfile extProfile = new ExtensionProfile();
        entry.declareExtensions(extProfile);
        if (isAdapting) {
            extProfile.setAutoExtending(true);
        }
        return extProfile;
    }

    private static ExtensionProfile getExtProfile(BaseFeed<?, ?> feed, boolean isAdapting) {
        ExtensionProfile extProfile = new ExtensionProfile();
        feed.declareExtensions(extProfile);
        if (isAdapting) {
            extProfile.setAutoExtending(true);
        }
        return extProfile;
    }
}
