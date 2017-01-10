package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.util.ThreadLocalBufferAllocator;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public abstract class Entity {
    public boolean inExternalSubset;
    public String name;

    public static class ExternalEntity extends Entity {
        public XMLResourceIdentifier entityLocation;
        public String notation;

        public ExternalEntity() {
            clear();
        }

        public ExternalEntity(String name, XMLResourceIdentifier entityLocation, String notation, boolean inExternalSubset) {
            super(name, inExternalSubset);
            this.entityLocation = entityLocation;
            this.notation = notation;
        }

        public final boolean isExternal() {
            return true;
        }

        public final boolean isUnparsed() {
            return this.notation != null;
        }

        public void clear() {
            super.clear();
            this.entityLocation = null;
            this.notation = null;
        }

        public void setValues(Entity entity) {
            super.setValues(entity);
            this.entityLocation = null;
            this.notation = null;
        }

        public void setValues(ExternalEntity entity) {
            super.setValues(entity);
            this.entityLocation = entity.entityLocation;
            this.notation = entity.notation;
        }
    }

    public static class InternalEntity extends Entity {
        public String text;

        public InternalEntity() {
            clear();
        }

        public InternalEntity(String name, String text, boolean inExternalSubset) {
            super(name, inExternalSubset);
            this.text = text;
        }

        public final boolean isExternal() {
            return false;
        }

        public final boolean isUnparsed() {
            return false;
        }

        public void clear() {
            super.clear();
            this.text = null;
        }

        public void setValues(Entity entity) {
            super.setValues(entity);
            this.text = null;
        }

        public void setValues(InternalEntity entity) {
            super.setValues(entity);
            this.text = entity.text;
        }
    }

    public static class ScannedEntity extends Entity {
        public static final int DEFAULT_BUFFER_SIZE = 8192;
        public static final int DEFAULT_INTERNAL_BUFFER_SIZE = 1024;
        public static final int DEFAULT_XMLDECL_BUFFER_SIZE = 64;
        public char[] ch;
        public int columnNumber;
        public int count;
        public String encoding;
        public XMLResourceIdentifier entityLocation;
        public int fBufferSize;
        public int fLastCount;
        public int fTotalCountTillLastLoad;
        public boolean isExternal;
        public int lineNumber;
        public boolean literal;
        public boolean mayReadChunks;
        public int position;
        public Reader reader;
        public InputStream stream;
        public String version;

        public String getEncodingName() {
            return this.encoding;
        }

        public String getEntityVersion() {
            return this.version;
        }

        public void setEntityVersion(String version) {
            this.version = version;
        }

        public Reader getEntityReader() {
            return this.reader;
        }

        public InputStream getEntityInputStream() {
            return this.stream;
        }

        public ScannedEntity(String name, XMLResourceIdentifier entityLocation, InputStream stream, Reader reader, String encoding, boolean literal, boolean mayReadChunks, boolean isExternal) {
            this.fBufferSize = DEFAULT_BUFFER_SIZE;
            this.ch = null;
            this.lineNumber = 1;
            this.columnNumber = 1;
            this.name = name;
            this.entityLocation = entityLocation;
            this.stream = stream;
            this.reader = reader;
            this.encoding = encoding;
            this.literal = literal;
            this.mayReadChunks = mayReadChunks;
            this.isExternal = isExternal;
            int size = isExternal ? this.fBufferSize : DEFAULT_INTERNAL_BUFFER_SIZE;
            this.ch = ThreadLocalBufferAllocator.getBufferAllocator().getCharBuffer(size);
            if (this.ch == null) {
                this.ch = new char[size];
            }
        }

        public void close() throws IOException {
            ThreadLocalBufferAllocator.getBufferAllocator().returnCharBuffer(this.ch);
            this.ch = null;
            this.reader.close();
        }

        public final boolean isExternal() {
            return this.isExternal;
        }

        public final boolean isUnparsed() {
            return false;
        }

        public String toString() {
            StringBuffer str = new StringBuffer();
            str.append(new StringBuffer().append("name=\"").append(this.name).append('\"').toString());
            str.append(new StringBuffer().append(",ch=").append(new String(this.ch)).toString());
            str.append(new StringBuffer().append(",position=").append(this.position).toString());
            str.append(new StringBuffer().append(",count=").append(this.count).toString());
            return str.toString();
        }
    }

    public abstract boolean isExternal();

    public abstract boolean isUnparsed();

    public Entity() {
        clear();
    }

    public Entity(String name, boolean inExternalSubset) {
        this.name = name;
        this.inExternalSubset = inExternalSubset;
    }

    public boolean isEntityDeclInExternalSubset() {
        return this.inExternalSubset;
    }

    public void clear() {
        this.name = null;
        this.inExternalSubset = false;
    }

    public void setValues(Entity entity) {
        this.name = entity.name;
        this.inExternalSubset = entity.inExternalSubset;
    }
}
