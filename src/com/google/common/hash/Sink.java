package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.nio.charset.Charset;

@Beta
public interface Sink {
    Sink putBoolean(boolean z);

    Sink putByte(byte b);

    Sink putBytes(byte[] bArr);

    Sink putBytes(byte[] bArr, int i, int i2);

    Sink putChar(char c);

    Sink putDouble(double d);

    Sink putFloat(float f);

    Sink putInt(int i);

    Sink putLong(long j);

    Sink putShort(short s);

    Sink putString(CharSequence charSequence);

    Sink putString(CharSequence charSequence, Charset charset);
}
