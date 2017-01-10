package com.amazonaws.javax.xml.stream.util;

import com.amazonaws.javax.xml.stream.xerces.impl.io.UCSReader;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.services.s3.model.ProgressEvent;

public class BufferAllocator {
    public static int LARGE_SIZE_LIMIT;
    public static int MEDIUM_SIZE_LIMIT;
    public static int SMALL_SIZE_LIMIT;
    byte[] largeByteBuffer;
    char[] largeCharBuffer;
    byte[] mediumByteBuffer;
    char[] mediumCharBuffer;
    byte[] smallByteBuffer;
    char[] smallCharBuffer;

    static {
        SMALL_SIZE_LIMIT = XMLChar.MASK_NCNAME;
        MEDIUM_SIZE_LIMIT = ProgressEvent.PART_COMPLETED_EVENT_CODE;
        LARGE_SIZE_LIMIT = UCSReader.DEFAULT_BUFFER_SIZE;
    }

    public char[] getCharBuffer(int size) {
        char[] buffer;
        if (size <= SMALL_SIZE_LIMIT) {
            buffer = this.smallCharBuffer;
            this.smallCharBuffer = null;
            return buffer;
        } else if (size <= MEDIUM_SIZE_LIMIT) {
            buffer = this.mediumCharBuffer;
            this.mediumCharBuffer = null;
            return buffer;
        } else if (size > LARGE_SIZE_LIMIT) {
            return null;
        } else {
            buffer = this.largeCharBuffer;
            this.largeCharBuffer = null;
            return buffer;
        }
    }

    public void returnCharBuffer(char[] c) {
        if (c != null) {
            if (c.length <= SMALL_SIZE_LIMIT) {
                this.smallCharBuffer = c;
            } else if (c.length <= MEDIUM_SIZE_LIMIT) {
                this.mediumCharBuffer = c;
            } else if (c.length <= LARGE_SIZE_LIMIT) {
                this.largeCharBuffer = c;
            }
        }
    }

    public byte[] getByteBuffer(int size) {
        byte[] buffer;
        if (size <= SMALL_SIZE_LIMIT) {
            buffer = this.smallByteBuffer;
            this.smallByteBuffer = null;
            return buffer;
        } else if (size <= MEDIUM_SIZE_LIMIT) {
            buffer = this.mediumByteBuffer;
            this.mediumByteBuffer = null;
            return buffer;
        } else if (size > LARGE_SIZE_LIMIT) {
            return null;
        } else {
            buffer = this.largeByteBuffer;
            this.largeByteBuffer = null;
            return buffer;
        }
    }

    public void returnByteBuffer(byte[] b) {
        if (b != null) {
            if (b.length <= SMALL_SIZE_LIMIT) {
                this.smallByteBuffer = b;
            } else if (b.length <= MEDIUM_SIZE_LIMIT) {
                this.mediumByteBuffer = b;
            } else if (b.length <= LARGE_SIZE_LIMIT) {
                this.largeByteBuffer = b;
            }
        }
    }
}
