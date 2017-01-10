package com.amazonaws.util;

import com.amazonaws.javax.xml.XMLConstants;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

class NamespaceRemovingInputStream extends FilterInputStream {
    private boolean hasRemovedNamespace;
    private byte[] lookAheadData;

    private static final class StringPrefixSlicer {
        private String f6s;

        public StringPrefixSlicer(String str) {
            this.f6s = str;
        }

        public String getString() {
            return this.f6s;
        }

        public boolean removePrefix(String str) {
            if (!this.f6s.startsWith(str)) {
                return false;
            }
            this.f6s = this.f6s.substring(str.length());
            return true;
        }

        public boolean removePrefixEndingWith(String str) {
            int indexOf = this.f6s.indexOf(str);
            if (indexOf < 0) {
                return false;
            }
            this.f6s = this.f6s.substring(indexOf + str.length());
            return true;
        }

        public boolean removeRepeatingPrefix(String str) {
            if (!this.f6s.startsWith(str)) {
                return false;
            }
            while (this.f6s.startsWith(str)) {
                this.f6s = this.f6s.substring(str.length());
            }
            return true;
        }
    }

    public NamespaceRemovingInputStream(InputStream inputStream) {
        super(new BufferedInputStream(inputStream));
        this.lookAheadData = new byte[200];
        this.hasRemovedNamespace = false;
    }

    private int matchXmlNamespaceAttribute(String str) {
        StringPrefixSlicer stringPrefixSlicer = new StringPrefixSlicer(str);
        if (!stringPrefixSlicer.removePrefix(XMLConstants.XMLNS_ATTRIBUTE)) {
            return -1;
        }
        stringPrefixSlicer.removeRepeatingPrefix(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        if (!stringPrefixSlicer.removePrefix("=")) {
            return -1;
        }
        stringPrefixSlicer.removeRepeatingPrefix(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        return (stringPrefixSlicer.removePrefix("\"") && stringPrefixSlicer.removePrefixEndingWith("\"")) ? str.length() - stringPrefixSlicer.getString().length() : -1;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read != 120 || this.hasRemovedNamespace) {
            return read;
        }
        this.lookAheadData[0] = (byte) read;
        this.in.mark(this.lookAheadData.length);
        int read2 = this.in.read(this.lookAheadData, 1, this.lookAheadData.length - 1);
        this.in.reset();
        read2 = matchXmlNamespaceAttribute(new String(this.lookAheadData, 0, read2 + 1));
        if (read2 <= 0) {
            return read;
        }
        for (read = 0; read < read2 - 1; read++) {
            this.in.read();
        }
        read = this.in.read();
        this.hasRemovedNamespace = true;
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int read = read();
            if (read == -1) {
                return i3 == 0 ? -1 : i3;
            } else {
                bArr[i3 + i] = (byte) read;
                i3++;
            }
        }
        return i2;
    }
}
