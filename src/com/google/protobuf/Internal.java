package com.google.protobuf;

import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import java.io.UnsupportedEncodingException;

public class Internal {

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i);
    }

    public interface EnumLite {
        int getNumber();
    }

    public static String stringDefaultValue(String bytes) {
        try {
            return new String(bytes.getBytes("ISO-8859-1"), StringEncodings.UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Java VM does not support a standard character set.", e);
        }
    }

    public static ByteString bytesDefaultValue(String bytes) {
        try {
            return ByteString.copyFrom(bytes.getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Java VM does not support a standard character set.", e);
        }
    }

    public static boolean isValidUtf8(ByteString byteString) {
        int index;
        int size = byteString.size();
        int index2 = 0;
        while (index2 < size) {
            index = index2 + 1;
            int byte1 = byteString.byteAt(index2) & 255;
            if (byte1 < XMLChar.MASK_NCNAME) {
                index2 = index;
            } else if (byte1 < 194 || byte1 > 244 || index >= size) {
                return false;
            } else {
                index2 = index + 1;
                int byte2 = byteString.byteAt(index) & 255;
                if (byte2 < XMLChar.MASK_NCNAME || byte2 > 191) {
                    index = index2;
                    return false;
                } else if (byte1 <= 223) {
                    continue;
                } else if (index2 >= size) {
                    index = index2;
                    return false;
                } else {
                    index = index2 + 1;
                    int byte3 = byteString.byteAt(index2) & 255;
                    if (byte3 < XMLChar.MASK_NCNAME || byte3 > 191) {
                        return false;
                    }
                    if (byte1 <= 239) {
                        if (byte1 == 224 && byte2 < 160) {
                            return false;
                        }
                        if (byte1 == 237 && byte2 > 159) {
                            return false;
                        }
                    } else if (index >= size) {
                        return false;
                    } else {
                        index2 = index + 1;
                        int byte4 = byteString.byteAt(index) & 255;
                        if (byte4 < XMLChar.MASK_NCNAME || byte4 > 191) {
                            index = index2;
                            return false;
                        } else if ((byte1 != 240 || byte2 >= 144) && (byte1 != 244 || byte2 <= 143)) {
                            index = index2;
                        } else {
                            index = index2;
                            return false;
                        }
                    }
                    index2 = index;
                }
            }
        }
        index = index2;
        return true;
    }
}
