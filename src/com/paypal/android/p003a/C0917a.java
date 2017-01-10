package com.paypal.android.p003a;

import com.google.common.base.Ascii;
import com.google.gdata.util.common.base.StringUtil;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import org.codehaus.jackson.impl.JsonWriteContext;

/* renamed from: com.paypal.android.a.a */
public final class C0917a {
    private static final byte[] f785a;
    private static final byte[] f786b;
    private static final byte[] f787c;
    private static final byte[] f788d;
    private static final byte[] f789e;
    private static final byte[] f790f;

    /* renamed from: com.paypal.android.a.a.a */
    public static class C0905a extends FilterOutputStream {
        private boolean f731a;
        private int f732b;
        private byte[] f733c;
        private int f734d;
        private int f735e;
        private boolean f736f;
        private byte[] f737g;
        private boolean f738h;
        private int f739i;
        private byte[] f740j;

        public C0905a(OutputStream outputStream, int i) {
            boolean z = true;
            super(outputStream);
            this.f736f = (i & 8) != 8;
            if ((i & 1) != 1) {
                z = false;
            }
            this.f731a = z;
            this.f734d = this.f731a ? 3 : 4;
            this.f733c = new byte[this.f734d];
            this.f732b = 0;
            this.f735e = 0;
            this.f738h = false;
            this.f737g = new byte[4];
            this.f739i = i;
            this.f740j = C0917a.m595b(i);
        }

        public final void close() throws IOException {
            if (this.f732b > 0) {
                if (this.f731a) {
                    this.out.write(C0917a.m592a(this.f733c, 0, this.f732b, this.f737g, 0, this.f739i));
                    this.f732b = 0;
                } else {
                    throw new IOException("Base64 input not properly padded.");
                }
            }
            super.close();
            this.f733c = null;
            this.out = null;
        }

        public final void write(int i) throws IOException {
            byte[] bArr;
            int i2;
            if (this.f731a) {
                bArr = this.f733c;
                i2 = this.f732b;
                this.f732b = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.f732b >= this.f734d) {
                    this.out.write(C0917a.m592a(this.f733c, 0, this.f734d, this.f737g, 0, this.f739i));
                    this.f735e += 4;
                    if (this.f736f && this.f735e >= 76) {
                        this.out.write(10);
                        this.f735e = 0;
                    }
                    this.f732b = 0;
                }
            } else if (this.f740j[i & Ascii.MAX] > (byte) -5) {
                bArr = this.f733c;
                i2 = this.f732b;
                this.f732b = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.f732b >= this.f734d) {
                    this.out.write(this.f737g, 0, C0917a.m594b(this.f733c, 0, this.f737g, 0, this.f739i));
                    this.f732b = 0;
                }
            } else if (this.f740j[i & Ascii.MAX] != (byte) -5) {
                throw new IOException("Invalid character in Base64 data.");
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }
    }

    static {
        f785a = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        f786b = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 62, (byte) -9, (byte) -9, (byte) -9, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, Ascii.XON, Ascii.DC2, Ascii.XOFF, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, Ascii.SPACE, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) -9, (byte) -9, (byte) -9, (byte) -9};
        f787c = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        f788d = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 62, (byte) -9, (byte) -9, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, Ascii.XON, Ascii.DC2, Ascii.XOFF, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 63, (byte) -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, Ascii.SPACE, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) -9, (byte) -9, (byte) -9, (byte) -9};
        f789e = new byte[]{(byte) 45, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 95, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122};
        f790f = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) -9, (byte) -9, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, Ascii.XON, Ascii.DC2, Ascii.XOFF, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, Ascii.SPACE, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 37, (byte) -9, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) 62, (byte) 63, (byte) -9, (byte) -9, (byte) -9, (byte) -9};
    }

    private C0917a() {
    }

    public static String m589a(byte[] bArr, int i) {
        return C0917a.m590a(bArr, 0, bArr.length, 8);
    }

    private static String m590a(byte[] bArr, int i, int i2, int i3) {
        ByteArrayOutputStream byteArrayOutputStream;
        C0905a c0905a;
        IOException e;
        Throwable th;
        int i4 = i3 & 8;
        if ((i3 & 2) == 2) {
            GZIPOutputStream gZIPOutputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    c0905a = new C0905a(byteArrayOutputStream, i3 | 1);
                    try {
                        gZIPOutputStream = new GZIPOutputStream(c0905a);
                        try {
                            gZIPOutputStream.write(bArr, 0, i2);
                            gZIPOutputStream.close();
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e2) {
                            }
                            try {
                                c0905a.close();
                            } catch (Exception e3) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e4) {
                            }
                            try {
                                return new String(byteArrayOutputStream.toByteArray(), StringEncodings.UTF8);
                            } catch (UnsupportedEncodingException e5) {
                                return new String(byteArrayOutputStream.toByteArray());
                            }
                        } catch (IOException e6) {
                            e = e6;
                            try {
                                e.printStackTrace();
                                try {
                                    gZIPOutputStream.close();
                                } catch (Exception e7) {
                                }
                                try {
                                    c0905a.close();
                                } catch (Exception e8) {
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    return null;
                                } catch (Exception e9) {
                                    return null;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    gZIPOutputStream.close();
                                } catch (Exception e10) {
                                }
                                try {
                                    c0905a.close();
                                } catch (Exception e11) {
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e12) {
                                }
                                throw th;
                            }
                        }
                    } catch (IOException e13) {
                        e = e13;
                        gZIPOutputStream = null;
                        e.printStackTrace();
                        gZIPOutputStream.close();
                        c0905a.close();
                        byteArrayOutputStream.close();
                        return null;
                    } catch (Throwable th3) {
                        gZIPOutputStream = null;
                        th = th3;
                        gZIPOutputStream.close();
                        c0905a.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e14) {
                    e = e14;
                    c0905a = null;
                    gZIPOutputStream = null;
                    e.printStackTrace();
                    gZIPOutputStream.close();
                    c0905a.close();
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th32) {
                    c0905a = null;
                    gZIPOutputStream = null;
                    th = th32;
                    gZIPOutputStream.close();
                    c0905a.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e15) {
                e = e15;
                c0905a = null;
                gZIPOutputStream = null;
                byteArrayOutputStream = null;
                e.printStackTrace();
                gZIPOutputStream.close();
                c0905a.close();
                byteArrayOutputStream.close();
                return null;
            } catch (Throwable th322) {
                c0905a = null;
                gZIPOutputStream = null;
                byteArrayOutputStream = null;
                th = th322;
                gZIPOutputStream.close();
                c0905a.close();
                byteArrayOutputStream.close();
                throw th;
            }
        }
        int i5 = i4 == 0 ? 1 : 0;
        i4 = (i2 << 2) / 3;
        byte[] bArr2 = new byte[((i5 != 0 ? i4 / 76 : 0) + (i4 + (i2 % 3 > 0 ? 4 : 0)))];
        int i6 = i2 - 2;
        int i7 = 0;
        i4 = 0;
        int i8 = 0;
        while (i4 < i6) {
            C0917a.m592a(bArr, i4, 3, bArr2, i8, i3);
            int i9 = i7 + 4;
            if (i5 != 0 && i9 == 76) {
                bArr2[i8 + 4] = (byte) 10;
                i8++;
                i9 = 0;
            }
            i4 += 3;
            i8 += 4;
            i7 = i9;
        }
        if (i4 < i2) {
            C0917a.m592a(bArr, i4, i2 - i4, bArr2, i8, i3);
            i8 += 4;
        }
        try {
            return new String(bArr2, 0, i8, StringEncodings.UTF8);
        } catch (UnsupportedEncodingException e16) {
            return new String(bArr2, 0, i8);
        }
    }

    private static byte[] m592a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = 0;
        byte[] bArr3 = (i4 & 16) == 16 ? f787c : (i4 & 32) == 32 ? f789e : f785a;
        int i6 = (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        i5 |= i6;
        switch (i2) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                bArr2[i3] = bArr3[i5 >>> 18];
                bArr2[i3 + 1] = bArr3[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = (byte) 61;
                bArr2[i3 + 3] = (byte) 61;
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                bArr2[i3] = bArr3[i5 >>> 18];
                bArr2[i3 + 1] = bArr3[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = bArr3[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = (byte) 61;
                break;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                bArr2[i3] = bArr3[i5 >>> 18];
                bArr2[i3 + 1] = bArr3[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = bArr3[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = bArr3[i5 & 63];
                break;
        }
        return bArr2;
    }

    private static int m594b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte[] b = C0917a.m595b(i3);
        if (bArr[i + 2] == (byte) 61) {
            bArr2[i2] = (byte) ((((b[bArr[i + 1]] & 255) << 12) | ((b[bArr[i]] & 255) << 18)) >>> 16);
            return 1;
        } else if (bArr[i + 3] == (byte) 61) {
            int i4 = ((b[bArr[i + 2]] & 255) << 6) | (((b[bArr[i]] & 255) << 18) | ((b[bArr[i + 1]] & 255) << 12));
            bArr2[i2] = (byte) (i4 >>> 16);
            bArr2[i2 + 1] = (byte) (i4 >>> 8);
            return 2;
        } else {
            try {
                int i5 = ((((b[bArr[i]] & 255) << 18) | ((b[bArr[i + 1]] & 255) << 12)) | ((b[bArr[i + 2]] & 255) << 6)) | (b[bArr[i + 3]] & 255);
                bArr2[i2] = (byte) (i5 >> 16);
                bArr2[i2 + 1] = (byte) (i5 >> 8);
                bArr2[i2 + 2] = (byte) i5;
                return 3;
            } catch (Exception e) {
                System.out.println(StringUtil.EMPTY_STRING + bArr[i] + ": " + b[bArr[i]]);
                System.out.println(StringUtil.EMPTY_STRING + bArr[i + 1] + ": " + b[bArr[i + 1]]);
                System.out.println(StringUtil.EMPTY_STRING + bArr[i + 2] + ": " + b[bArr[i + 2]]);
                System.out.println(StringUtil.EMPTY_STRING + bArr[i + 3] + ": " + b[bArr[i + 3]]);
                return -1;
            }
        }
    }

    private static final byte[] m595b(int i) {
        return (i & 16) == 16 ? f788d : (i & 32) == 32 ? f790f : f786b;
    }
}
