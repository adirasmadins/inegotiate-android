package com.amazonaws.javax.xml.stream.xerces.util;

public class SymbolTable {
    protected static final int TABLE_SIZE = 173;
    protected Entry[] fBuckets;
    protected int fTableSize;
    protected char[] symbolAsArray;

    protected static final class Entry {
        public char[] characters;
        int hashCode;
        public Entry next;
        public String symbol;

        public Entry(String symbol, Entry next) {
            this.hashCode = 0;
            this.symbol = symbol.intern();
            this.characters = new char[symbol.length()];
            symbol.getChars(0, this.characters.length, this.characters, 0);
            this.next = next;
        }

        public Entry(char[] ch, int offset, int length, Entry next) {
            this.hashCode = 0;
            this.characters = new char[length];
            System.arraycopy(ch, offset, this.characters, 0, length);
            this.symbol = new String(this.characters).intern();
            this.next = next;
        }
    }

    public SymbolTable() {
        this(TABLE_SIZE);
    }

    public SymbolTable(int tableSize) {
        this.symbolAsArray = null;
        this.fBuckets = null;
        this.fTableSize = tableSize;
        this.fBuckets = new Entry[this.fTableSize];
    }

    public String addSymbol(String symbol) {
        int hash = hash(symbol);
        int bucket = hash % this.fTableSize;
        int length = symbol.length();
        Entry entry = this.fBuckets[bucket];
        while (entry != null) {
            if (length == entry.characters.length && hash == entry.hashCode && symbol.regionMatches(0, entry.symbol, 0, length)) {
                this.symbolAsArray = entry.characters;
                return entry.symbol;
            }
            entry = entry.next;
        }
        entry = new Entry(symbol, this.fBuckets[bucket]);
        entry.hashCode = hash;
        this.symbolAsArray = entry.characters;
        this.fBuckets[bucket] = entry;
        return entry.symbol;
    }

    public String addSymbol(char[] buffer, int offset, int length) {
        int hash = hash(buffer, offset, length);
        int bucket = hash % this.fTableSize;
        Entry entry = this.fBuckets[bucket];
        while (entry != null) {
            if (length == entry.characters.length && hash == entry.hashCode) {
                int i = 0;
                while (i < length) {
                    if (buffer[offset + i] == entry.characters[i]) {
                        i++;
                    }
                }
                this.symbolAsArray = entry.characters;
                return entry.symbol;
            }
            entry = entry.next;
        }
        entry = new Entry(buffer, offset, length, this.fBuckets[bucket]);
        this.fBuckets[bucket] = entry;
        entry.hashCode = hash;
        this.symbolAsArray = entry.characters;
        return entry.symbol;
    }

    public int hash(String symbol) {
        int code = 0;
        for (int i = 0; i < symbol.length(); i++) {
            code = (code * 37) + symbol.charAt(i);
        }
        return 134217727 & code;
    }

    public int hash(char[] buffer, int offset, int length) {
        int code = 0;
        for (int i = 0; i < length; i++) {
            code = (code * 37) + buffer[offset + i];
        }
        return 134217727 & code;
    }

    public boolean containsSymbol(String symbol) {
        int hash = hash(symbol);
        int bucket = hash % this.fTableSize;
        int length = symbol.length();
        Entry entry = this.fBuckets[bucket];
        while (entry != null) {
            if (length == entry.characters.length && hash == entry.hashCode && symbol.regionMatches(0, entry.symbol, 0, length)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public boolean containsSymbol(char[] buffer, int offset, int length) {
        int hash = hash(buffer, offset, length);
        Entry entry = this.fBuckets[hash % this.fTableSize];
        while (entry != null) {
            if (length == entry.characters.length && hash == entry.hashCode) {
                int i = 0;
                while (i < length) {
                    if (buffer[offset + i] == entry.characters[i]) {
                        i++;
                    }
                }
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public char[] getCharArray() {
        return this.symbolAsArray;
    }
}
