package com.paypal.android.p003a;

import com.amazonaws.services.s3.model.ProgressEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.paypal.android.a.g */
public final class C0924g {
    private static byte[] f810a;
    private static C0924g f811b;

    static {
        f811b = null;
    }

    public static void m674a() {
        if (f811b == null) {
            f811b = new C0924g();
        }
        f810a = f811b.m679b("com/paypal/android/utils/data/data.bin");
    }

    public static byte[] m675a(int i, int i2) {
        return C0924g.m676a(i, i2, f810a);
    }

    public static byte[] m676a(int i, int i2, byte[] bArr) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return obj;
    }

    public static byte[] m677a(String str) {
        return f811b.m679b(str);
    }

    public static void m678b() {
        f810a = null;
        f811b = null;
    }

    private byte[] m679b(String str) {
        InputStream resourceAsStream;
        byte[] toByteArray;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        Throwable th2;
        Object obj;
        InputStream inputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            if (classLoader != null) {
                resourceAsStream = classLoader.getResourceAsStream(str);
                if (resourceAsStream != null) {
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[ProgressEvent.PART_STARTED_EVENT_CODE];
                            while (true) {
                                int read = resourceAsStream.read(bArr, 0, bArr.length);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr, 0, read);
                                Thread.yield();
                            }
                            toByteArray = byteArrayOutputStream2.toByteArray();
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Throwable th3) {
                            }
                            if (resourceAsStream != null) {
                                try {
                                    resourceAsStream.close();
                                } catch (Throwable th4) {
                                }
                            }
                        } catch (IOException e) {
                            ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream2;
                            inputStream = resourceAsStream;
                            byteArrayOutputStream = byteArrayOutputStream3;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable th5) {
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th6) {
                                }
                            }
                            return toByteArray;
                        } catch (Throwable th7) {
                            th = th7;
                            inputStream2 = resourceAsStream;
                            th2 = th;
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Throwable th8) {
                                }
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable th9) {
                                }
                            }
                            throw th2;
                        }
                    } catch (IOException e2) {
                        inputStream = resourceAsStream;
                        obj = inputStream2;
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return toByteArray;
                    } catch (Throwable th10) {
                        th = th10;
                        Object obj2 = inputStream2;
                        inputStream2 = resourceAsStream;
                        th2 = th;
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        throw th2;
                    }
                    return toByteArray;
                }
            }
            resourceAsStream = inputStream2;
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (Throwable th11) {
                }
            }
        } catch (IOException e3) {
            obj = inputStream2;
            inputStream = inputStream2;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return toByteArray;
        } catch (Throwable th12) {
            th2 = th12;
            byteArrayOutputStream2 = inputStream2;
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th2;
        }
        return toByteArray;
    }
}
