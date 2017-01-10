package com.google.gdata.wireformats;

import com.google.common.collect.Maps;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.wireformats.input.InputParser;
import com.google.gdata.wireformats.output.OutputGenerator;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class AltRegistry {
    private final Map<AltFormat, AltHandlers> altHandlers;
    private AltRegistry delegate;
    private boolean locked;
    private final Map<String, AltFormat> nameMap;
    private final Map<String, AltFormat> typeMap;

    private static class AltHandlers {
        private final OutputGenerator<?> generator;
        private final InputParser<?> parser;

        AltHandlers(InputParser<?> parser, OutputGenerator<?> generator) {
            this.parser = parser;
            this.generator = generator;
        }
    }

    public AltRegistry() {
        this(null);
    }

    public AltRegistry(AltRegistry origRegistry) {
        if (origRegistry != null) {
            this.nameMap = Maps.newHashMap(origRegistry.nameMap);
            this.typeMap = Maps.newHashMap(origRegistry.typeMap);
            this.altHandlers = Maps.newHashMap(origRegistry.altHandlers);
            this.delegate = origRegistry.delegate;
            return;
        }
        this.nameMap = Maps.newHashMap();
        this.typeMap = Maps.newHashMap();
        this.altHandlers = Maps.newHashMap();
    }

    private void registerFormat(AltFormat format) {
        this.nameMap.put(format.getName(), format);
        if (format.isSelectableByType()) {
            this.typeMap.put(format.getContentType().getMediaType(), format);
        }
    }

    public void register(AltFormat format, InputParser<?> parser, OutputGenerator<?> generator) {
        Preconditions.checkNotNull(format);
        Preconditions.checkNotNull(generator);
        Preconditions.checkState(!this.locked, "Registry is locked against changes");
        registerFormat(format);
        this.altHandlers.put(format, new AltHandlers(parser, generator));
    }

    public void lock() {
        this.locked = true;
    }

    public AltFormat lookupName(String name) {
        AltFormat format = (AltFormat) this.nameMap.get(name);
        if (format != null || this.delegate == null) {
            return format;
        }
        return this.delegate.lookupName(name);
    }

    public AltFormat lookupType(ContentType contentType) {
        AltFormat format = (AltFormat) this.typeMap.get(contentType.getMediaType());
        if (format == null) {
            for (AltFormat testFormat : this.typeMap.values()) {
                if (contentType.match(testFormat.getContentType())) {
                    format = testFormat;
                    break;
                }
            }
        }
        if (format != null || this.delegate == null) {
            return format;
        }
        return this.delegate.lookupType(contentType);
    }

    public Collection<AltFormat> registeredFormats() {
        return Collections.unmodifiableCollection(this.altHandlers.keySet());
    }

    public InputParser<?> getParser(AltFormat altFormat) {
        AltHandlers handlers = (AltHandlers) this.altHandlers.get(altFormat);
        if (handlers != null) {
            return handlers.parser;
        }
        if (this.delegate != null) {
            return this.delegate.getParser(altFormat);
        }
        return null;
    }

    public OutputGenerator<?> getGenerator(AltFormat altFormat) {
        AltHandlers handlers = (AltHandlers) this.altHandlers.get(altFormat);
        if (handlers != null) {
            return handlers.generator;
        }
        if (this.delegate != null) {
            return this.delegate.getGenerator(altFormat);
        }
        return null;
    }

    public void setDelegate(AltRegistry delegate) {
        Preconditions.checkState(!this.locked, "Registry is locked against changes");
        this.delegate = delegate;
    }

    public boolean hasSameHandlers(AltRegistry targetRegistry, AltFormat altFormat) {
        boolean z = false;
        AltHandlers thisHandlers = (AltHandlers) this.altHandlers.get(altFormat);
        AltHandlers targetHandlers = (AltHandlers) targetRegistry.altHandlers.get(altFormat);
        if (thisHandlers != null) {
            if (targetHandlers != null && thisHandlers.generator == targetHandlers.generator && thisHandlers.parser == targetHandlers.parser) {
                z = true;
            }
            return z;
        } else if (targetHandlers == null) {
            return true;
        } else {
            return false;
        }
    }
}
