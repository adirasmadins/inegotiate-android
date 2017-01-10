package com.paypal.android.p003a;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.gdata.model.gd.Reminder.Method;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.C0890a.C0869b;
import com.paypal.android.MEP.MEPAddress;
import com.paypal.android.MEP.MEPAmounts;
import com.paypal.android.MEP.MEPReceiverAmounts;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.PayPalAdvancedPayment;
import com.paypal.android.MEP.PayPalReceiverDetails;
import com.paypal.android.MEP.p000a.C0875a;
import com.paypal.android.MEP.p000a.C0882d.C08791;
import com.paypal.android.MEP.p000a.C0885e;
import com.paypal.android.MEP.p000a.C0889h;
import com.paypal.android.p003a.p004a.C0913h;
import com.paypal.android.p005c.C0926a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.logging.impl.SimpleLog;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* renamed from: com.paypal.android.a.b */
public final class C0919b implements C0869b {
    protected static C0926a f792a;
    protected static C0926a f793b;
    private static List<String> f794k;
    private static C0918a f795l;
    private static byte[] f796m;
    private static byte[] f797n;
    private static byte[] f798o;
    private static String[] f799p;
    private static String f800q;
    private HttpPost f801c;
    private DefaultHttpClient f802d;
    private int f803e;
    private int f804f;
    private int f805g;
    private Hashtable<String, Object> f806h;
    private boolean f807i;
    private final Thread f808j;

    /* renamed from: com.paypal.android.a.b.a */
    private static class C0918a extends Thread {
        private boolean f791a;

        public C0918a() {
            this.f791a = false;
            start();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r4 = this;
        L_0x0000:
            r0 = 0;
            r1 = com.paypal.android.p003a.C0919b.f794k;
            monitor-enter(r1);
            r2 = com.paypal.android.p003a.C0919b.f794k;	 Catch:{ all -> 0x0069 }
            r2 = r2.size();	 Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x005d;
        L_0x0010:
            r2 = com.paypal.android.p003a.C0919b.f794k;	 Catch:{ InterruptedException -> 0x008b }
            r2.wait();	 Catch:{ InterruptedException -> 0x008b }
        L_0x0017:
            monitor-exit(r1);	 Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0000;
        L_0x001a:
            r1 = new org.apache.http.client.methods.HttpGet;
            r1.<init>(r0);
            r2 = com.paypal.android.p003a.C0919b.m627h();
            r2.execute(r1);	 Catch:{ ClientProtocolException -> 0x003f, IOException -> 0x006c }
            r1 = "NetworkHandler";
            r2 = new java.lang.StringBuilder;	 Catch:{ ClientProtocolException -> 0x003f, IOException -> 0x006c }
            r2.<init>();	 Catch:{ ClientProtocolException -> 0x003f, IOException -> 0x006c }
            r3 = "TrackingPostThread (), posted tracking ";
            r2 = r2.append(r3);	 Catch:{ ClientProtocolException -> 0x003f, IOException -> 0x006c }
            r0 = r2.append(r0);	 Catch:{ ClientProtocolException -> 0x003f, IOException -> 0x006c }
            r0 = r0.toString();	 Catch:{ ClientProtocolException -> 0x003f, IOException -> 0x006c }
            com.paypal.android.MEP.PayPal.logd(r1, r0);	 Catch:{ ClientProtocolException -> 0x003f, IOException -> 0x006c }
            goto L_0x0000;
        L_0x003f:
            r0 = move-exception;
            r1 = "NetworkHandler";
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "TrackingPostThread (), exception ";
            r2 = r2.append(r3);
            r0 = r0.getMessage();
            r0 = r2.append(r0);
            r0 = r0.toString();
            com.paypal.android.MEP.PayPal.loge(r1, r0);
            goto L_0x0000;
        L_0x005d:
            r0 = com.paypal.android.p003a.C0919b.f794k;	 Catch:{ all -> 0x0069 }
            r2 = 0;
            r0 = r0.remove(r2);	 Catch:{ all -> 0x0069 }
            r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0069 }
            goto L_0x0017;
        L_0x0069:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0069 }
            throw r0;
        L_0x006c:
            r0 = move-exception;
            r1 = "NetworkHandler";
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "TrackingPostThread (), exception ";
            r2 = r2.append(r3);
            r0 = r0.getMessage();
            r0 = r2.append(r0);
            r0 = r0.toString();
            com.paypal.android.MEP.PayPal.loge(r1, r0);
            goto L_0x0000;
        L_0x008b:
            r2 = move-exception;
            goto L_0x0017;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.a.b.a.run():void");
        }
    }

    static {
        f792a = new C0927i();
        f793b = new C0928j();
        f794k = new ArrayList();
        f795l = null;
        f796m = new byte[]{(byte) 48, (byte) -126, (byte) 3, (byte) 115, (byte) 48, (byte) -126, (byte) 2, (byte) 91, (byte) 2, (byte) 4, (byte) 77, (byte) 122, (byte) -66, (byte) 90, (byte) 48, Ascii.CR, (byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, Ascii.CR, (byte) 1, (byte) 1, (byte) 5, (byte) 5, (byte) 0, (byte) 48, (byte) 126, (byte) 49, Ascii.VT, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 6, Ascii.XOFF, (byte) 2, (byte) 85, (byte) 83, (byte) 49, Ascii.VT, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 8, Ascii.XOFF, (byte) 2, (byte) 67, (byte) 65, (byte) 49, Ascii.XON, (byte) 48, Ascii.SI, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 7, Ascii.XOFF, (byte) 8, (byte) 83, (byte) 97, (byte) 110, Ascii.SPACE, (byte) 74, (byte) 111, (byte) 115, (byte) 101, (byte) 49, Ascii.NAK, (byte) 48, Ascii.XOFF, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 10, Ascii.XOFF, Ascii.FF, (byte) 80, (byte) 97, (byte) 121, (byte) 80, (byte) 97, (byte) 108, (byte) 44, Ascii.SPACE, (byte) 73, (byte) 110, (byte) 99, (byte) 46, (byte) 49, Ascii.DC4, (byte) 48, Ascii.DC2, (byte) 6, (byte) 3, (byte) 85, (byte) 4, Ascii.VT, Ascii.FF, Ascii.VT, (byte) 115, (byte) 116, (byte) 97, (byte) 103, (byte) 101, (byte) 95, (byte) 99, (byte) 101, (byte) 114, (byte) 116, (byte) 115, (byte) 49, (byte) 34, (byte) 48, Ascii.SPACE, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 3, Ascii.FF, Ascii.EM, (byte) 115, (byte) 116, (byte) 97, (byte) 103, (byte) 101, (byte) 95, (byte) 109, (byte) 112, (byte) 108, (byte) 95, (byte) 101, (byte) 110, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 95, (byte) 99, (byte) 101, (byte) 114, (byte) 116, (byte) 48, Ascii.RS, Ascii.ETB, Ascii.CR, (byte) 49, (byte) 49, (byte) 48, (byte) 51, (byte) 49, (byte) 50, (byte) 48, (byte) 48, (byte) 50, (byte) 57, (byte) 49, (byte) 52, (byte) 90, Ascii.ETB, Ascii.CR, (byte) 51, (byte) 54, (byte) 48, (byte) 51, (byte) 48, (byte) 53, (byte) 48, (byte) 48, (byte) 50, (byte) 57, (byte) 49, (byte) 52, (byte) 90, (byte) 48, (byte) 126, (byte) 49, Ascii.VT, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 6, Ascii.XOFF, (byte) 2, (byte) 85, (byte) 83, (byte) 49, Ascii.VT, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 8, Ascii.XOFF, (byte) 2, (byte) 67, (byte) 65, (byte) 49, Ascii.XON, (byte) 48, Ascii.SI, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 7, Ascii.XOFF, (byte) 8, (byte) 83, (byte) 97, (byte) 110, Ascii.SPACE, (byte) 74, (byte) 111, (byte) 115, (byte) 101, (byte) 49, Ascii.NAK, (byte) 48, Ascii.XOFF, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 10, Ascii.XOFF, Ascii.FF, (byte) 80, (byte) 97, (byte) 121, (byte) 80, (byte) 97, (byte) 108, (byte) 44, Ascii.SPACE, (byte) 73, (byte) 110, (byte) 99, (byte) 46, (byte) 49, Ascii.DC4, (byte) 48, Ascii.DC2, (byte) 6, (byte) 3, (byte) 85, (byte) 4, Ascii.VT, Ascii.FF, Ascii.VT, (byte) 115, (byte) 116, (byte) 97, (byte) 103, (byte) 101, (byte) 95, (byte) 99, (byte) 101, (byte) 114, (byte) 116, (byte) 115, (byte) 49, (byte) 34, (byte) 48, Ascii.SPACE, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 3, Ascii.FF, Ascii.EM, (byte) 115, (byte) 116, (byte) 97, (byte) 103, (byte) 101, (byte) 95, (byte) 109, (byte) 112, (byte) 108, (byte) 95, (byte) 101, (byte) 110, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 95, (byte) 99, (byte) 101, (byte) 114, (byte) 116, (byte) 48, (byte) -126, (byte) 1, (byte) 34, (byte) 48, Ascii.CR, (byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, Ascii.CR, (byte) 1, (byte) 1, (byte) 1, (byte) 5, (byte) 0, (byte) 3, (byte) -126, (byte) 1, Ascii.SI, (byte) 0, (byte) 48, (byte) -126, (byte) 1, (byte) 10, (byte) 2, (byte) -126, (byte) 1, (byte) 1, (byte) 0, (byte) -103, (byte) -59, (byte) -112, (byte) -109, (byte) 34, (byte) 95, (byte) -44, (byte) 88, (byte) -8, (byte) 47, (byte) -24, (byte) 97, (byte) -96, Ascii.CAN, (byte) -27, (byte) -16, (byte) 96, (byte) 78, (byte) -96, (byte) 101, (byte) 96, (byte) -55, (byte) 117, (byte) -103, Ascii.GS, (byte) 116, (byte) 85, Ascii.EM, (byte) -52, (byte) 5, (byte) 71, (byte) -21, (byte) 1, (byte) -114, (byte) -57, (byte) -50, (byte) 36, (byte) -31, (byte) 103, (byte) 39, (byte) -58, Ascii.SPACE, Ascii.NAK, (byte) -82, (byte) -3, (byte) 118, (byte) 42, (byte) 1, (byte) -93, (byte) -111, (byte) 114, (byte) -11, (byte) 73, (byte) 63, (byte) 99, (byte) 97, (byte) -26, (byte) 103, (byte) 97, (byte) 49, (byte) 39, (byte) 33, (byte) -12, Ascii.US, (byte) -40, Ascii.SO, (byte) -100, (byte) -99, (byte) -80, (byte) -53, (byte) -105, (byte) -48, Ascii.FS, (byte) 72, (byte) 53, (byte) 0, (byte) 89, (byte) -44, (byte) -97, (byte) -45, (byte) 39, (byte) -96, (byte) -9, (byte) 1, (byte) 73, (byte) -23, (byte) 58, (byte) 3, (byte) 126, (byte) -61, (byte) -86, (byte) 5, (byte) -64, (byte) -10, (byte) -107, (byte) -64, (byte) 50, (byte) 79, SignedBytes.MAX_POWER_OF_TWO, (byte) 42, (byte) 114, (byte) 33, (byte) 121, (byte) 59, (byte) 121, (byte) -122, (byte) -105, (byte) 6, (byte) -70, Ascii.XOFF, (byte) 83, (byte) -91, (byte) 48, (byte) -9, (byte) 78, (byte) 112, (byte) 91, (byte) 71, (byte) -30, (byte) -61, (byte) 3, (byte) 113, (byte) 84, (byte) -47, (byte) -9, (byte) 103, (byte) -4, (byte) 40, Ascii.DC4, (byte) -29, (byte) -95, (byte) -124, (byte) -125, UnsignedBytes.MAX_POWER_OF_TWO, (byte) 42, (byte) -24, (byte) -37, (byte) 40, (byte) 74, (byte) -121, (byte) -45, (byte) -87, (byte) -10, (byte) -42, (byte) -63, (byte) 45, (byte) 111, (byte) -30, (byte) -3, (byte) 68, (byte) 8, (byte) -60, (byte) -22, (byte) -8, (byte) -25, (byte) -99, Ascii.FF, (byte) -89, (byte) -117, (byte) 1, (byte) -95, (byte) -110, (byte) -1, (byte) -58, Ascii.FF, (byte) -7, (byte) 59, (byte) -22, (byte) -61, (byte) 9, (byte) 122, (byte) -27, (byte) -52, (byte) -114, (byte) -92, Ascii.XON, (byte) 59, (byte) -16, (byte) 95, (byte) -111, (byte) -124, (byte) -110, (byte) -31, (byte) -5, (byte) 116, (byte) -112, (byte) -121, (byte) -123, (byte) -11, (byte) -69, (byte) -24, (byte) 46, (byte) 117, (byte) -8, (byte) 120, (byte) -40, (byte) 101, (byte) -124, (byte) 70, (byte) 113, (byte) -79, (byte) -25, (byte) 120, (byte) -14, (byte) -49, (byte) -32, (byte) -53, (byte) -17, (byte) -4, (byte) -85, (byte) -102, (byte) 85, (byte) -85, (byte) 44, (byte) 95, (byte) 69, (byte) 92, (byte) -49, (byte) 3, (byte) -13, Ascii.SO, (byte) 86, (byte) -74, (byte) 72, (byte) 93, (byte) -45, (byte) -114, Ascii.SPACE, (byte) 43, (byte) -4, (byte) -95, (byte) -26, (byte) 118, (byte) -78, (byte) 122, (byte) -73, Ascii.EM, (byte) 118, (byte) -82, (byte) -108, (byte) -66, (byte) 107, (byte) 98, (byte) -102, (byte) 91, (byte) 46, (byte) 123, (byte) 81, (byte) -113, Ascii.RS, (byte) -54, (byte) 120, (byte) -44, (byte) -26, (byte) -84, (byte) -97, (byte) 2, (byte) 3, (byte) 1, (byte) 0, (byte) 1, (byte) 48, Ascii.CR, (byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, Ascii.CR, (byte) 1, (byte) 1, (byte) 5, (byte) 5, (byte) 0, (byte) 3, (byte) -126, (byte) 1, (byte) 1, (byte) 0, (byte) 123, (byte) -27, (byte) -3, (byte) -116, (byte) -46, (byte) -77, (byte) 0, (byte) -88, (byte) -121, (byte) -22, (byte) -28, (byte) -105, (byte) -75, (byte) 59, (byte) -109, UnsignedBytes.MAX_POWER_OF_TWO, (byte) 87, (byte) 99, (byte) 8, (byte) 92, (byte) -122, (byte) 44, (byte) -88, (byte) -116, (byte) 0, (byte) -92, (byte) 69, (byte) 89, Ascii.SPACE, (byte) 2, (byte) -41, (byte) 9, (byte) -90, (byte) -20, (byte) 73, (byte) 5, (byte) -40, (byte) 123, (byte) 73, (byte) 33, (byte) 40, (byte) -45, (byte) -124, (byte) -45, (byte) -88, (byte) 50, (byte) 66, (byte) -102, (byte) -103, (byte) -38, Ascii.DC2, (byte) 5, (byte) -17, Ascii.FS, (byte) 47, (byte) 82, (byte) -28, (byte) 87, (byte) 7, (byte) -50, (byte) 108, (byte) 88, (byte) 120, (byte) 119, (byte) 105, Ascii.SPACE, UnsignedBytes.MAX_POWER_OF_TWO, (byte) -48, (byte) -30, (byte) -50, (byte) -2, (byte) -58, (byte) -69, (byte) -126, (byte) -80, (byte) 104, (byte) -101, (byte) -11, Ascii.ESC, Ascii.CR, (byte) -36, (byte) 112, (byte) -36, (byte) 77, Ascii.DLE, (byte) 78, (byte) -76, (byte) -91, (byte) -119, (byte) -56, (byte) -32, (byte) 98, (byte) 68, (byte) -44, (byte) 86, (byte) 91, (byte) 57, (byte) 85, Ascii.GS, (byte) 60, (byte) 34, (byte) 7, (byte) -96, (byte) 42, (byte) 60, (byte) -101, (byte) -40, (byte) -62, (byte) -41, (byte) -109, Ascii.XON, (byte) -50, (byte) -86, (byte) 58, (byte) 82, SignedBytes.MAX_POWER_OF_TWO, (byte) -72, (byte) 73, (byte) -95, (byte) -91, (byte) -13, (byte) -57, (byte) -33, (byte) -76, (byte) 9, (byte) -15, (byte) 85, (byte) 125, (byte) -17, (byte) 83, (byte) -61, (byte) -52, (byte) 92, (byte) -30, (byte) -76, (byte) -118, (byte) 0, (byte) -101, Ascii.FF, (byte) -109, Ascii.DC4, (byte) 74, (byte) -114, (byte) -21, (byte) -32, (byte) -15, (byte) 68, (byte) -58, (byte) -126, (byte) -102, (byte) 86, (byte) -87, (byte) 68, (byte) -34, (byte) -101, (byte) -108, (byte) 43, (byte) 70, (byte) -75, (byte) -88, (byte) 84, (byte) 101, (byte) -30, (byte) -57, (byte) -59, (byte) 90, (byte) -102, (byte) 49, (byte) 121, (byte) 34, (byte) -24, Ascii.RS, (byte) -65, (byte) -59, (byte) -12, Ascii.NAK, (byte) 8, (byte) -115, (byte) 102, (byte) -104, (byte) -81, (byte) 7, (byte) 126, (byte) -8, (byte) -8, (byte) -124, Ascii.FF, (byte) 123, (byte) 42, (byte) 54, (byte) 9, (byte) 63, Ascii.SYN, Ascii.VT, (byte) -15, (byte) 124, (byte) 51, (byte) -76, (byte) 68, (byte) -87, (byte) -113, (byte) -127, (byte) -93, (byte) -32, (byte) 58, Ascii.RS, (byte) 2, (byte) -90, (byte) -15, (byte) -83, (byte) -81, (byte) 117, (byte) -61, Ascii.CAN, (byte) -25, (byte) -120, (byte) 1, (byte) -109, (byte) 69, (byte) 92, (byte) 92, (byte) -8, (byte) 103, (byte) 7, (byte) -63, (byte) -107, (byte) 54, (byte) 55, (byte) 89, (byte) 50, (byte) -13, (byte) 44, (byte) 34, (byte) 87, (byte) -88, (byte) -98, (byte) 60, (byte) 103, (byte) 4, (byte) 93, (byte) -89, (byte) 0, (byte) 37, (byte) 118, (byte) -113, (byte) 59, (byte) -114, (byte) -9, (byte) 106, (byte) -92, (byte) -110, (byte) 81, (byte) 105, (byte) 109, (byte) -87, (byte) 6};
        f797n = new byte[]{(byte) 48, (byte) -126, (byte) 2, (byte) 106, (byte) 48, (byte) -126, (byte) 1, (byte) -45, (byte) 2, (byte) 4, (byte) 77, (byte) -90, (byte) -88, (byte) -61, (byte) 48, Ascii.CR, (byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, Ascii.CR, (byte) 1, (byte) 1, (byte) 5, (byte) 5, (byte) 0, (byte) 48, (byte) 124, (byte) 49, Ascii.VT, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 6, Ascii.XOFF, (byte) 2, (byte) 85, (byte) 83, (byte) 49, Ascii.VT, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 8, Ascii.XOFF, (byte) 2, (byte) 67, (byte) 65, (byte) 49, Ascii.XON, (byte) 48, Ascii.SI, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 7, Ascii.XOFF, (byte) 8, (byte) 83, (byte) 97, (byte) 110, Ascii.SPACE, (byte) 74, (byte) 111, (byte) 115, (byte) 101, (byte) 49, Ascii.NAK, (byte) 48, Ascii.XOFF, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 10, Ascii.XOFF, Ascii.FF, (byte) 80, (byte) 97, (byte) 121, (byte) 80, (byte) 97, (byte) 108, (byte) 44, Ascii.SPACE, (byte) 73, (byte) 110, (byte) 99, (byte) 46, (byte) 49, Ascii.XOFF, (byte) 48, Ascii.XON, (byte) 6, (byte) 3, (byte) 85, (byte) 4, Ascii.VT, Ascii.FF, (byte) 10, (byte) 108, (byte) 105, (byte) 118, (byte) 101, (byte) 95, (byte) 99, (byte) 101, (byte) 114, (byte) 116, (byte) 115, (byte) 49, (byte) 33, (byte) 48, Ascii.US, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 3, Ascii.FF, Ascii.CAN, (byte) 108, (byte) 105, (byte) 118, (byte) 101, (byte) 95, (byte) 109, (byte) 112, (byte) 108, (byte) 95, (byte) 101, (byte) 110, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 95, (byte) 99, (byte) 101, (byte) 114, (byte) 116, (byte) 48, Ascii.RS, Ascii.ETB, Ascii.CR, (byte) 49, (byte) 49, (byte) 48, (byte) 52, (byte) 49, (byte) 52, (byte) 48, (byte) 55, (byte) 53, (byte) 54, (byte) 53, (byte) 49, (byte) 90, Ascii.ETB, Ascii.CR, (byte) 49, (byte) 51, (byte) 48, (byte) 54, (byte) 50, (byte) 50, (byte) 48, (byte) 55, (byte) 53, (byte) 54, (byte) 53, (byte) 49, (byte) 90, (byte) 48, (byte) 124, (byte) 49, Ascii.VT, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 6, Ascii.XOFF, (byte) 2, (byte) 85, (byte) 83, (byte) 49, Ascii.VT, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 8, Ascii.XOFF, (byte) 2, (byte) 67, (byte) 65, (byte) 49, Ascii.XON, (byte) 48, Ascii.SI, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 7, Ascii.XOFF, (byte) 8, (byte) 83, (byte) 97, (byte) 110, Ascii.SPACE, (byte) 74, (byte) 111, (byte) 115, (byte) 101, (byte) 49, Ascii.NAK, (byte) 48, Ascii.XOFF, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 10, Ascii.XOFF, Ascii.FF, (byte) 80, (byte) 97, (byte) 121, (byte) 80, (byte) 97, (byte) 108, (byte) 44, Ascii.SPACE, (byte) 73, (byte) 110, (byte) 99, (byte) 46, (byte) 49, Ascii.XOFF, (byte) 48, Ascii.XON, (byte) 6, (byte) 3, (byte) 85, (byte) 4, Ascii.VT, Ascii.FF, (byte) 10, (byte) 108, (byte) 105, (byte) 118, (byte) 101, (byte) 95, (byte) 99, (byte) 101, (byte) 114, (byte) 116, (byte) 115, (byte) 49, (byte) 33, (byte) 48, Ascii.US, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 3, Ascii.FF, Ascii.CAN, (byte) 108, (byte) 105, (byte) 118, (byte) 101, (byte) 95, (byte) 109, (byte) 112, (byte) 108, (byte) 95, (byte) 101, (byte) 110, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 95, (byte) 99, (byte) 101, (byte) 114, (byte) 116, (byte) 48, (byte) -127, (byte) -97, (byte) 48, Ascii.CR, (byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, Ascii.CR, (byte) 1, (byte) 1, (byte) 1, (byte) 5, (byte) 0, (byte) 3, (byte) -127, (byte) -115, (byte) 0, (byte) 48, (byte) -127, (byte) -119, (byte) 2, (byte) -127, (byte) -127, (byte) 0, (byte) -82, UnsignedBytes.MAX_POWER_OF_TWO, (byte) -69, (byte) 76, (byte) -124, (byte) -63, (byte) 108, (byte) -113, (byte) -33, Ascii.XON, (byte) 7, (byte) -86, (byte) -95, (byte) -7, (byte) 114, (byte) -125, (byte) -63, (byte) -125, Ascii.SO, (byte) -67, Ascii.DC2, (byte) 68, (byte) -95, (byte) -61, Ascii.XON, (byte) -55, (byte) -17, (byte) -28, (byte) -18, (byte) -28, (byte) -117, (byte) -37, (byte) -9, (byte) 59, (byte) -39, (byte) 46, (byte) 54, (byte) 1, (byte) -64, Ascii.SO, (byte) -78, (byte) 6, (byte) -29, (byte) -41, (byte) 90, (byte) -20, (byte) 108, (byte) 58, (byte) -60, Ascii.SYN, (byte) -68, (byte) -125, (byte) 74, (byte) -14, Ascii.DC2, (byte) -123, (byte) -36, (byte) -41, (byte) 77, (byte) -106, (byte) -25, (byte) -74, (byte) -5, (byte) 112, (byte) 126, (byte) 108, (byte) 86, (byte) 44, (byte) 0, (byte) -61, (byte) 121, (byte) -21, (byte) -43, (byte) -3, (byte) 74, (byte) -125, (byte) -122, (byte) 114, (byte) 42, (byte) 109, (byte) -48, (byte) 61, (byte) 77, (byte) -52, (byte) 121, (byte) -59, (byte) 51, (byte) -108, (byte) -52, (byte) -44, SignedBytes.MAX_POWER_OF_TWO, (byte) 41, (byte) 84, (byte) -92, (byte) -43, (byte) 97, (byte) -77, (byte) 81, (byte) -88, (byte) -111, (byte) 124, Ascii.DLE, (byte) -110, (byte) -85, (byte) -11, (byte) 2, (byte) -76, (byte) 103, (byte) 50, (byte) -56, (byte) -93, (byte) 1, (byte) -115, (byte) 82, (byte) 43, (byte) 74, (byte) 79, (byte) 110, (byte) -16, (byte) -68, Ascii.FF, Ascii.ETB, (byte) -56, Ascii.US, (byte) -108, (byte) -113, (byte) 82, (byte) 47, (byte) 2, (byte) 3, (byte) 1, (byte) 0, (byte) 1, (byte) 48, Ascii.CR, (byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, Ascii.CR, (byte) 1, (byte) 1, (byte) 5, (byte) 5, (byte) 0, (byte) 3, (byte) -127, (byte) -127, (byte) 0, (byte) 118, (byte) -105, (byte) -7, (byte) 69, (byte) -119, (byte) -75, Ascii.US, (byte) 110, (byte) 91, (byte) 10, (byte) 124, (byte) -36, (byte) -41, (byte) -111, (byte) 100, (byte) -55, (byte) -103, (byte) -71, (byte) 118, (byte) -18, (byte) -31, (byte) 55, (byte) -84, (byte) -22, (byte) 10, (byte) -15, (byte) 114, (byte) 39, (byte) -118, (byte) -4, (byte) 33, (byte) -72, (byte) -112, (byte) 5, (byte) 106, (byte) 100, (byte) -127, (byte) 58, (byte) 71, Ascii.SUB, (byte) -2, (byte) 86, (byte) -111, Ascii.US, (byte) -15, (byte) 89, Ascii.ETB, (byte) 91, (byte) 66, (byte) 65, (byte) 52, (byte) 89, (byte) 115, (byte) -103, (byte) -4, (byte) -94, Ascii.GS, (byte) 90, (byte) -15, (byte) 8, (byte) 41, (byte) 61, Ascii.GS, (byte) 42, (byte) -111, Ascii.EM, (byte) -94, Ascii.GS, Ascii.ETB, (byte) 70, (byte) -48, (byte) 59, (byte) -37, (byte) -32, (byte) 102, (byte) 111, (byte) 33, (byte) 33, (byte) -34, (byte) -106, (byte) -60, (byte) 121, (byte) -127, (byte) -115, (byte) -79, (byte) -29, (byte) -9, (byte) 82, (byte) -97, (byte) -11, (byte) -51, Ascii.SI, (byte) -125, (byte) -20, Ascii.RS, (byte) -11, (byte) 75, (byte) -20, (byte) -19, (byte) 97, (byte) 105, (byte) 56, (byte) -9, (byte) -118, (byte) 34, (byte) 4, (byte) 67, (byte) -49, (byte) -42, (byte) 83, (byte) 96, (byte) -14, (byte) -59, (byte) 39, (byte) -9, (byte) -100, (byte) -68, (byte) -13, (byte) -76, (byte) 41, Ascii.VT, (byte) -59, (byte) -34, (byte) -79, (byte) 8, (byte) -40, (byte) -94, (byte) -75};
        f798o = new byte[]{(byte) 48, (byte) -126, (byte) 2, (byte) 120, (byte) 48, (byte) -126, (byte) 1, (byte) -31, (byte) 2, (byte) 4, (byte) 77, (byte) -90, (byte) -94, (byte) 69, (byte) 48, Ascii.CR, (byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, Ascii.CR, (byte) 1, (byte) 1, (byte) 5, (byte) 5, (byte) 0, (byte) 48, (byte) -127, (byte) -126, (byte) 49, Ascii.VT, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 6, Ascii.XOFF, (byte) 2, (byte) 85, (byte) 83, (byte) 49, Ascii.VT, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 8, Ascii.XOFF, (byte) 2, (byte) 67, (byte) 65, (byte) 49, Ascii.XON, (byte) 48, Ascii.SI, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 7, Ascii.XOFF, (byte) 8, (byte) 83, (byte) 97, (byte) 110, Ascii.SPACE, (byte) 74, (byte) 111, (byte) 115, (byte) 101, (byte) 49, Ascii.NAK, (byte) 48, Ascii.XOFF, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 10, Ascii.XOFF, Ascii.FF, (byte) 80, (byte) 97, (byte) 121, (byte) 80, (byte) 97, (byte) 108, (byte) 44, Ascii.SPACE, (byte) 73, (byte) 110, (byte) 99, (byte) 46, (byte) 49, Ascii.SYN, (byte) 48, Ascii.DC4, (byte) 6, (byte) 3, (byte) 85, (byte) 4, Ascii.VT, Ascii.FF, Ascii.CR, (byte) 115, (byte) 97, (byte) 110, (byte) 100, (byte) 98, (byte) 111, (byte) 120, (byte) 95, (byte) 99, (byte) 101, (byte) 114, (byte) 116, (byte) 115, (byte) 49, (byte) 36, (byte) 48, (byte) 34, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 3, Ascii.FF, Ascii.ESC, (byte) 115, (byte) 97, (byte) 110, (byte) 100, (byte) 98, (byte) 111, (byte) 120, (byte) 95, (byte) 109, (byte) 112, (byte) 108, (byte) 95, (byte) 101, (byte) 110, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 95, (byte) 99, (byte) 101, (byte) 114, (byte) 116, (byte) 48, Ascii.RS, Ascii.ETB, Ascii.CR, (byte) 49, (byte) 49, (byte) 48, (byte) 52, (byte) 49, (byte) 52, (byte) 48, (byte) 55, (byte) 50, (byte) 57, (byte) 48, (byte) 57, (byte) 90, Ascii.ETB, Ascii.CR, (byte) 51, (byte) 54, (byte) 48, (byte) 52, (byte) 48, (byte) 55, (byte) 48, (byte) 55, (byte) 50, (byte) 57, (byte) 48, (byte) 57, (byte) 90, (byte) 48, (byte) -127, (byte) -126, (byte) 49, Ascii.VT, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 6, Ascii.XOFF, (byte) 2, (byte) 85, (byte) 83, (byte) 49, Ascii.VT, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 8, Ascii.XOFF, (byte) 2, (byte) 67, (byte) 65, (byte) 49, Ascii.XON, (byte) 48, Ascii.SI, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 7, Ascii.XOFF, (byte) 8, (byte) 83, (byte) 97, (byte) 110, Ascii.SPACE, (byte) 74, (byte) 111, (byte) 115, (byte) 101, (byte) 49, Ascii.NAK, (byte) 48, Ascii.XOFF, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 10, Ascii.XOFF, Ascii.FF, (byte) 80, (byte) 97, (byte) 121, (byte) 80, (byte) 97, (byte) 108, (byte) 44, Ascii.SPACE, (byte) 73, (byte) 110, (byte) 99, (byte) 46, (byte) 49, Ascii.SYN, (byte) 48, Ascii.DC4, (byte) 6, (byte) 3, (byte) 85, (byte) 4, Ascii.VT, Ascii.FF, Ascii.CR, (byte) 115, (byte) 97, (byte) 110, (byte) 100, (byte) 98, (byte) 111, (byte) 120, (byte) 95, (byte) 99, (byte) 101, (byte) 114, (byte) 116, (byte) 115, (byte) 49, (byte) 36, (byte) 48, (byte) 34, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 3, Ascii.FF, Ascii.ESC, (byte) 115, (byte) 97, (byte) 110, (byte) 100, (byte) 98, (byte) 111, (byte) 120, (byte) 95, (byte) 109, (byte) 112, (byte) 108, (byte) 95, (byte) 101, (byte) 110, (byte) 99, (byte) 114, (byte) 121, (byte) 112, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 95, (byte) 99, (byte) 101, (byte) 114, (byte) 116, (byte) 48, (byte) -127, (byte) -97, (byte) 48, Ascii.CR, (byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, Ascii.CR, (byte) 1, (byte) 1, (byte) 1, (byte) 5, (byte) 0, (byte) 3, (byte) -127, (byte) -115, (byte) 0, (byte) 48, (byte) -127, (byte) -119, (byte) 2, (byte) -127, (byte) -127, (byte) 0, (byte) -122, (byte) 60, (byte) -17, (byte) -98, (byte) 126, (byte) 97, (byte) -124, (byte) -43, (byte) 10, (byte) -104, (byte) 124, (byte) 117, (byte) -41, (byte) -15, (byte) -106, (byte) 43, (byte) -52, (byte) -80, (byte) -89, (byte) -13, (byte) -9, (byte) 71, (byte) -122, Ascii.FS, (byte) 97, Ascii.RS, UnsignedBytes.MAX_POWER_OF_TWO, Ascii.EM, (byte) 33, (byte) 59, (byte) -66, Ascii.VT, (byte) 75, (byte) -79, (byte) 91, (byte) -67, (byte) 124, (byte) -16, (byte) -54, Ascii.SYN, (byte) 71, (byte) 83, (byte) -89, (byte) 5, (byte) -104, (byte) 96, (byte) -82, (byte) 124, (byte) -55, (byte) -64, (byte) 118, (byte) 120, (byte) -122, (byte) 116, (byte) -99, (byte) 106, (byte) -29, (byte) -85, (byte) -54, Ascii.DLE, (byte) 34, (byte) -22, (byte) -82, (byte) -30, (byte) -11, (byte) 62, (byte) 39, (byte) 123, Ascii.DC2, (byte) -40, (byte) 6, (byte) -106, Ascii.GS, (byte) -25, (byte) 47, (byte) 55, Ascii.FS, Ascii.FS, (byte) 52, Ascii.CR, (byte) 63, (byte) -2, (byte) 76, (byte) 94, (byte) 74, (byte) 55, (byte) -97, (byte) -19, Ascii.ESC, (byte) -83, (byte) 93, (byte) 57, SignedBytes.MAX_POWER_OF_TWO, (byte) -63, (byte) -57, (byte) -56, (byte) -57, (byte) -88, Ascii.XOFF, (byte) 52, (byte) -124, (byte) -52, (byte) 37, (byte) -28, (byte) -82, (byte) -58, (byte) 100, (byte) 121, (byte) 79, Ascii.SYN, Ascii.SI, (byte) 78, (byte) -33, (byte) -1, (byte) -30, (byte) 50, (byte) -5, (byte) -32, (byte) 122, (byte) -6, (byte) -116, (byte) -116, (byte) 84, (byte) -105, (byte) 42, (byte) 86, (byte) -30, (byte) 99, (byte) 2, (byte) 3, (byte) 1, (byte) 0, (byte) 1, (byte) 48, Ascii.CR, (byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, Ascii.CR, (byte) 1, (byte) 1, (byte) 5, (byte) 5, (byte) 0, (byte) 3, (byte) -127, (byte) -127, (byte) 0, (byte) 46, Ascii.GS, Ascii.VT, (byte) -21, (byte) -95, (byte) -37, (byte) -60, Ascii.DLE, (byte) 5, (byte) 46, (byte) 112, (byte) -28, (byte) -72, (byte) 2, (byte) 44, (byte) -41, (byte) 38, (byte) 93, (byte) -73, Ascii.SI, (byte) 112, (byte) -42, (byte) -15, (byte) -15, (byte) -80, (byte) -120, (byte) 55, (byte) -35, (byte) -36, (byte) 7, (byte) 111, (byte) -74, (byte) -52, (byte) -81, (byte) 60, (byte) -125, (byte) 69, (byte) 117, (byte) -103, (byte) 79, (byte) 113, Ascii.EM, (byte) 36, (byte) 44, Ascii.GS, (byte) 97, (byte) 97, (byte) -66, (byte) -8, (byte) 94, (byte) -85, Ascii.FS, (byte) 96, (byte) -106, Ascii.CAN, SignedBytes.MAX_POWER_OF_TWO, (byte) -1, (byte) -55, (byte) -112, (byte) -52, (byte) -57, (byte) 35, (byte) -36, (byte) 122, (byte) -21, (byte) 122, (byte) 37, (byte) 54, (byte) -68, (byte) -48, (byte) 36, Ascii.VT, Ascii.VT, (byte) 91, (byte) 58, (byte) -100, (byte) 126, Ascii.FS, (byte) -109, Ascii.XOFF, (byte) 95, (byte) 49, (byte) -46, Ascii.EM, (byte) 77, (byte) -110, (byte) 80, (byte) 122, (byte) -22, (byte) -41, (byte) -98, (byte) 60, (byte) -118, Ascii.RS, (byte) -111, (byte) 62, (byte) -89, (byte) 9, (byte) -20, (byte) -104, (byte) -100, (byte) -120, (byte) 69, (byte) -110, (byte) -4, Ascii.DC2, (byte) 110, (byte) -50, (byte) 83, (byte) -17, (byte) 115, (byte) -76, (byte) 111, (byte) 95, (byte) -106, (byte) -5, (byte) 8, (byte) -93, (byte) -31, Ascii.CR, (byte) 54, (byte) -122, (byte) -97, (byte) -41, (byte) 9, (byte) -63, (byte) 96, Ascii.SPACE};
        f799p = new String[]{"1", "27", "30", "31", "32", "33", "34", "36", "39", "41", "43", "44", "45", "46", "47", "48", "49", "52", "54", "55", "56", "58", "60", "61", "64", "65", "66", "81", "82", "86", "90", "91", "351", "352", "353", "354", "356", "357", "358", "370", "371", "372", "377", "386", "420", "421", "506", "593", "598", "852", "886", "972"};
        f800q = StringUtil.EMPTY_STRING;
    }

    public C0919b() {
        this.f802d = null;
        this.f803e = -1;
        this.f804f = -1;
        this.f805g = -1;
        this.f807i = false;
        this.f808j = new C0929k(this);
    }

    private static String m596A() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            PayPal.loge("Exception", e.toString());
        }
        return null;
    }

    private boolean m597B() {
        String a = C0931m.m698a();
        String str = C0919b.m612b() + C0919b.m643q() + "/DeviceInterrogation";
        PayPal.logd("MPL", "start makeDeviceInterrogationRequest Post");
        String a2 = m601a(a, str, true);
        PayPal.logd("MPL", "end makeDeviceInterrogationRequest Post");
        PayPal instance = PayPal.getInstance();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(a2.getBytes(StringEncodings.UTF8)));
            if (m609a(parse, a2)) {
                C0919b.m604a("makeDeviceInterrogationRequest", str, a, a2);
                try {
                    C0931m.m709a(parse, this.f806h);
                } catch (Throwable th) {
                    PayPal.loge("NetworkHandler", "makeDeviceInterrogationRequest caught exception " + th.getMessage());
                }
                instance.resetAccount();
                return false;
            } else if (C0931m.m709a(parse, this.f806h)) {
                return true;
            } else {
                instance.resetAccount();
                this.f804f = -1;
                PayPal.loge("NetworkHandler", "makeDeviceInterrogationRequest something failed");
                return false;
            }
        } catch (ParserConfigurationException e) {
            C0919b.m604a("makeDeviceInterrogationRequest", str, a, "exception " + e.getMessage());
            instance.resetAccount();
            return false;
        } catch (UnsupportedEncodingException e2) {
            C0919b.m604a("makeDeviceInterrogationRequest", str, a, "exception " + e2.getMessage());
            instance.resetAccount();
            return false;
        } catch (SAXException e3) {
            C0919b.m604a("makeDeviceInterrogationRequest", str, a, "exception " + e3.getMessage());
            instance.resetAccount();
            return false;
        } catch (NullPointerException e4) {
            C0919b.m604a("makeDeviceInterrogationRequest", str, a, "exception " + e4.getMessage());
            instance.resetAccount();
            return false;
        } catch (IOException e5) {
            C0919b.m604a("makeDeviceInterrogationRequest", str, a, "exception " + e5.getMessage());
            instance.resetAccount();
            return false;
        }
    }

    private boolean m598C() {
        try {
            String a = C0931m.m700a(this.f806h, C0919b.m631j((String) this.f806h.get("NewPin")));
            String str = C0919b.m612b() + C0919b.m643q() + "/DeviceCreatePin";
            String a2 = m601a(a, str, true);
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(a2.getBytes(StringEncodings.UTF8)));
            if (m609a(parse, a2)) {
                C0919b.m604a("createPIN", str, a, a2);
                this.f804f = -1;
                return false;
            }
            C0931m.m716b(parse);
            return true;
        } catch (C0923f e) {
            PayPal.loge("NetworkHandler", "createPIN caught BadXMLException " + e.getMessage());
        } catch (C0932n e2) {
            PayPal.loge("NetworkHandler", "createPIN caught BadPhoneNumberException " + e2.getMessage());
        } catch (ParserConfigurationException e3) {
            PayPal.loge("NetworkHandler", "Exception " + e3.getMessage());
        } catch (UnsupportedEncodingException e4) {
            PayPal.loge("NetworkHandler", "Exception " + e4.getMessage());
        } catch (SAXException e5) {
            PayPal.loge("NetworkHandler", "Exception " + e5.getMessage());
        } catch (IOException e6) {
            PayPal.loge("NetworkHandler", "Exception " + e6.getMessage());
        } catch (CertificateExpiredException e7) {
            PayPal.loge("NetworkHandler", "Exception " + e7.getMessage());
        } catch (CertificateNotYetValidException e8) {
            PayPal.loge("NetworkHandler", "Exception " + e8.getMessage());
        }
    }

    private boolean m599D() {
        String a = m601a(C0931m.m718c(), C0919b.m612b() + C0919b.m643q() + "/RemoveDeviceAuthorization", true);
        if (m634k(a)) {
            try {
                C0931m.m732f(a, this.f806h);
                return false;
            } catch (Throwable th) {
                PayPal.loge("NetworkHandler", "readRemoveDeviceAuthorization caught exception " + th.getMessage());
                return false;
            }
        } else if (C0931m.m732f(a, this.f806h)) {
            return true;
        } else {
            this.f804f = -1;
            return false;
        }
    }

    private String m601a(String str, String str2, boolean z) {
        InputStream content;
        Throwable th;
        DataInputStream dataInputStream;
        try {
            String str3;
            int i;
            if (this.f802d == null) {
                this.f802d = C0919b.m627h();
            }
            this.f801c = new HttpPost(str2);
            HttpEntity stringEntity = new StringEntity(str, Charset.forName(StringEncodings.UTF8).name());
            if (z) {
                this.f801c.setHeader("CLIENT-AUTH", "No cert");
                this.f801c.setHeader("X-PAYPAL-MESSAGE-PROTOCOL", "SOAP11");
                this.f801c.setHeader("X-PAYPAL-APPLICATION-ID", PayPalActivity._paypal.getAppID());
                this.f801c.setHeader("X-PAYPAL-REQUEST-SOURCE", PayPal.getVersionWithoutBuild());
                this.f801c.setHeader("X-PAYPAL-REQUEST-DATA-FORMAT", "XML");
                this.f801c.setHeader("X-PAYPAL-RESPONSE-DATA-FORMAT", "XML");
                this.f801c.setHeader("X-PAYPAL-RESPONSE-DATA-FORMAT", "XML");
                this.f801c.setHeader("X-PAYPAL-RESPONSE-DATA-FORMAT", "XML");
                this.f801c.setHeader("X-PAYPAL-RESPONSE-DATA-FORMAT", "XML");
                this.f801c.setHeader("x-paypal-service-version", "1.0.0");
                this.f801c.setHeader("x-paypal-element-ordering-preserve", "false");
                this.f801c.setEntity(stringEntity);
            } else if (str2.contains(C0919b.m642p())) {
                if (PayPal.getInstance().getServer() == 3) {
                    this.f801c.setHeader("CLIENT-AUTH", "No cert");
                } else {
                    this.f801c.setHeader("X-PAYPAL-SECURITY-PASSWORD", "MPL");
                    this.f801c.setHeader("X-PAYPAL-SECURITY-USERID", "MPL");
                    this.f801c.setHeader("X-PAYPAL-SECURITY-SIGNATURE", "MPL");
                }
                this.f801c.setHeader("X-PAYPAL-MESSAGE-PROTOCOL", "SOAP11");
                this.f801c.setHeader("X-PAYPAL-DEVICE-IPADDRESS", C0919b.m596A());
                this.f801c.setHeader("X-PAYPAL-APPLICATION-ID", PayPalActivity._paypal.getAppID());
                this.f801c.setHeader("X-PAYPAL-DEVICE-AUTH-TOKEN", f800q);
                this.f801c.setHeader("X-PAYPAL-REQUEST-SOURCE", PayPal.getVersionWithoutBuild());
                this.f801c.setHeader("X-PAYPAL-REQUEST-DATA-FORMAT", "XML");
                this.f801c.setHeader("X-PAYPAL-RESPONSE-DATA-FORMAT", "XML");
                this.f801c.setHeader("x-paypal-service-version", "1.0.0");
                this.f801c.setHeader("x-paypal-element-ordering-preserve", "false");
                this.f801c.setEntity(stringEntity);
            } else {
                str3 = "ErrorId=-1";
                this.f801c = null;
                this.f802d = null;
                return str3;
            }
            PayPal.logd("NetworkHandler", "postXML do execute");
            HttpResponse execute = this.f802d.execute(this.f801c);
            HttpEntity entity = execute.getEntity();
            Header[] allHeaders = execute.getAllHeaders();
            if (allHeaders != null) {
                i = 0;
                for (Header header : allHeaders) {
                    if (header.getName().compareTo(HttpHeaders.CONTENT_LENGTH) == 0) {
                        i = Integer.parseInt(header.getValue());
                    }
                }
            } else {
                i = 0;
            }
            PayPal.logd("NetworkHandler", "postXML setup to read reponse");
            content = entity.getContent();
            try {
                InputStream dataInputStream2 = new DataInputStream(content);
                try {
                    if (content.available() > i) {
                        i = content.available();
                    }
                    if (dataInputStream2.available() > i) {
                        i = dataInputStream2.available();
                    }
                    PayPal.logd("NetworkHandler", "postXML do read response");
                    if (i != 0) {
                        byte[] bArr = new byte[i];
                        dataInputStream2.readFully(bArr);
                        str3 = new String(bArr, StringEncodings.UTF8);
                    } else {
                        str3 = new String(C0919b.m610a(dataInputStream2), StringEncodings.UTF8);
                    }
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    dataInputStream2.close();
                    content.close();
                    this.f801c = null;
                    this.f802d = null;
                    try {
                        dataInputStream2.close();
                    } catch (Exception e) {
                    }
                    if (content != null) {
                        try {
                            content.close();
                        } catch (Exception e2) {
                            PayPal.loge("NetworkHandler", "postXML caught exception closing streams" + e2.getMessage());
                        }
                    }
                    this.f801c = null;
                    this.f802d = null;
                    return str3;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        PayPal.loge("NetworkHandler", "postXML caught exception doing I/O, " + th.getMessage());
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (content != null) {
                            try {
                                content.close();
                            } catch (Exception e4) {
                                PayPal.loge("NetworkHandler", "postXML caught exception closing streams" + e4.getMessage());
                            }
                        }
                        this.f801c = null;
                        this.f802d = null;
                        this.f804f = 0;
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        if (content != null) {
                            try {
                                content.close();
                            } catch (Exception e22) {
                                PayPal.loge("NetworkHandler", "postXML caught exception closing streams" + e22.getMessage());
                            }
                        }
                        this.f801c = null;
                        this.f802d = null;
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (content != null) {
                    content.close();
                }
                this.f801c = null;
                this.f802d = null;
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            dataInputStream = null;
            content = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (content != null) {
                content.close();
            }
            this.f801c = null;
            this.f802d = null;
            throw th;
        }
    }

    static /* synthetic */ void m602a(C0919b c0919b, int i, C0926a c0926a) {
        String f = c0919b.m659f();
        c0926a.m691b(i, f);
        PayPal.logd("MPL", "end " + i + " fail, " + f);
    }

    static /* synthetic */ void m603a(C0919b c0919b, String str, C0869b c0869b) {
        String f = c0919b.m659f();
        c0869b.m437d(f);
        PayPal.logd("MPL", "end " + str + " fail, " + f);
    }

    private static void m604a(String str, String str2, String str3, String str4) {
        PayPal.logd("NetworkHandler", str + " error endpoint - " + str2);
        PayPal.logd("NetworkHandler", str + " error request - " + str3);
        if (str4 != null) {
            PayPal.logd("NetworkHandler", str + " error reply - " + str4);
        }
    }

    public static final boolean m605a() {
        try {
            if (((String) PayPalActivity._networkHandler.f806h.get("payButtonEnable")).compareToIgnoreCase("true") == 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    static /* synthetic */ boolean m607a(C0919b c0919b, String str, String str2) throws C0932n, C0923f, CertificateExpiredException, CertificateNotYetValidException {
        boolean z = false;
        if (!C0919b.m650x()) {
            return false;
        }
        f800q = StringUtil.EMPTY_STRING;
        PayPal instance = PayPal.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        if (str.indexOf("@") > 0) {
            z = true;
        }
        if (z) {
            C0931m.m702a(stringBuilder, "authorizationType", "Email");
            C0931m.m702a(stringBuilder, Method.EMAIL, C0919b.m613b(str));
            C0931m.m702a(stringBuilder, "password", C0919b.m631j(str2));
        } else {
            C0931m.m702a(stringBuilder, "authorizationType", "Phone");
            stringBuilder.append("<phone>");
            C0931m.m702a(stringBuilder, "countryCode", instance.getAccountCountryDialingCode());
            C0931m.m702a(stringBuilder, "phoneNumber", C0919b.m620e(str));
            stringBuilder.append("</phone>");
            C0931m.m702a(stringBuilder, "password", C0919b.m631j(str2));
        }
        C0931m.m703a(stringBuilder, "authorizeDevice", instance.getIsRememberMe());
        String str3 = C0919b.m612b() + C0919b.m644r() + "/DeviceAuthenticateUser";
        String c = C0931m.m719c(stringBuilder.toString());
        return c0919b.m608a(str3, c, c0919b.m601a(c, str3, true));
    }

    private boolean m608a(String str, String str2, String str3) throws C0923f {
        PayPal.getInstance();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str3.getBytes(StringEncodings.UTF8)));
            if (m609a(parse, str3)) {
                C0919b.m604a("createQuickPayment", str, str2, str3);
                return false;
            }
            NodeList elementsByTagName = parse.getElementsByTagName("pinEstablished");
            if (elementsByTagName.getLength() != 1) {
                throw new C0923f("Not exactly one pinEstablished tag");
            }
            PayPal.getInstance().setPINCreated(Boolean.parseBoolean(elementsByTagName.item(0).getChildNodes().item(0).getNodeValue()));
            elementsByTagName = parse.getElementsByTagName("sessionToken");
            if (elementsByTagName.getLength() != 1) {
                throw new C0923f("Not exactly one sessionToken tag");
            }
            f800q = elementsByTagName.item(0).getChildNodes().item(0).getNodeValue();
            elementsByTagName = parse.getElementsByTagName("deviceAuthorized");
            if (elementsByTagName.getLength() != 1) {
                throw new C0923f("Not exactly one deviceAuthorized tag");
            }
            this.f806h.put("AuthorizedDevice", elementsByTagName.item(0).getChildNodes().item(0).getNodeValue());
            C0931m.m706a(parse);
            return f800q.length() > 0;
        } catch (ParserConfigurationException e) {
            C0919b.m604a("parseDeviceAuthenticateUser", str, str2, "Exception " + e.getMessage());
            return false;
        } catch (UnsupportedEncodingException e2) {
            C0919b.m604a("parseDeviceAuthenticateUser", str, str2, "Exception " + e2.getMessage());
            return false;
        } catch (SAXException e3) {
            C0919b.m604a("parseDeviceAuthenticateUser", str, str2, "Exception " + e3.getMessage());
            return false;
        } catch (NullPointerException e4) {
            if (str3 == null) {
                C0919b.m604a("parseDeviceAuthenticateUser", str, str2, "null response from server");
                return false;
            }
            C0919b.m604a("parseDeviceAuthenticateUser", str, str2, "Exception " + e4.getMessage());
            return false;
        } catch (IOException e5) {
            C0919b.m604a("parseDeviceAuthenticateUser", str, str2, "Exception " + e5.getMessage());
            return false;
        }
    }

    private boolean m609a(Document document, String str) {
        this.f804f = -1;
        if (str == null || str.length() <= 0) {
            this.f804f = 408;
            return true;
        }
        int c = C0931m.m717c(document);
        if (str == null) {
            this.f804f = 408;
            return true;
        }
        if (str.contains("ErrorId=")) {
            this.f804f = Integer.parseInt(str.substring(str.indexOf("ErrorId=") + "ErrorId=".length()));
        } else if (c != 200) {
            this.f804f = c;
        } else if (str.contains("<SOAP-ENV:Body") && !str.contains("</SOAP-ENV:Body")) {
            this.f804f = 0;
            return true;
        }
        if (this.f804f == -1) {
            return false;
        }
        Intent putExtra;
        String str2 = StringUtil.EMPTY_STRING + this.f804f;
        String a = C0925h.m680a("ANDROID_" + this.f804f);
        if (C0919b.m625g(StringUtil.EMPTY_STRING + this.f804f)) {
            String[] a2 = C0931m.m710a(str);
            if (a2 != null) {
                String str3 = a;
                for (c = 0; c < a2.length; c++) {
                    str3 = str3 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + a2[c] + (c + 1 == a2.length ? "." : ",");
                }
                a = str3;
            }
        }
        if (C0919b.m630i(str2)) {
            String a3;
            Intent putExtra2 = new Intent(PayPalActivity.FATAL_ERROR).putExtra("FATAL_ERROR_ID", str2);
            if (str2.equals("569060")) {
                a3 = C0925h.m680a("ANDROID_no_personal_payments");
            } else if (str2.equals("500000")) {
                a3 = C0925h.m680a("ANDROID_10001");
            } else if (str2.equals("580001")) {
                try {
                    if (document.getElementsByTagName("parameter").item(0).getChildNodes().item(0).getNodeValue().length() == 3) {
                        a = C0925h.m680a("ANDROID_580001_4");
                    }
                    a3 = a;
                } catch (Throwable th) {
                    a3 = a;
                }
            } else {
                if (str2.equals("520009")) {
                    try {
                        if (document.getElementsByTagName("parameter").item(0).getChildNodes().item(0).getNodeValue().length() > 0) {
                            a = C0925h.m680a("ANDROID_520009_2");
                        }
                        a3 = a;
                    } catch (Throwable th2) {
                    }
                }
                a3 = a;
            }
            if (!(this.f803e == 11 || PayPalActivity.getInstance() == null)) {
                PayPalActivity.getInstance().paymentFailed((String) PayPalActivity._networkHandler.m657c("CorrelationId"), (String) PayPalActivity._networkHandler.m657c("PayKey"), str2, a3, false, true);
            }
            putExtra = putExtra2.putExtra("FATAL_ERROR_MESSAGE", a3);
        } else {
            putExtra = (!C0919b.m628h(str2) || this.f803e == 11) ? (C0919b.m628h(str2) && this.f803e == 11) ? new Intent(PayPalActivity.FATAL_ERROR).putExtra("FATAL_ERROR_ID", str2).putExtra("FATAL_ERROR_MESSAGE", C0925h.m680a("ANDROID_pin_creation_timeout")).putExtra("ERROR_TIMEOUT", a) : new Intent(PayPalActivity.CREATE_PAYMENT_FAIL) : new Intent(PayPalActivity.LOGIN_FAIL).putExtra("FATAL_ERROR_ID", str2).putExtra("ERROR_TIMEOUT", a);
        }
        try {
            PayPalActivity.getInstance().sendBroadcast(putExtra);
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    private static byte[] m610a(InputStream inputStream) {
        int i = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        byte[] bArr = null;
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            }
            if (bArr == null) {
                bArr = new byte[ProgressEvent.PART_STARTED_EVENT_CODE];
            }
            if (i2 == ProgressEvent.PART_STARTED_EVENT_CODE) {
                byteArrayOutputStream.write(bArr);
                try {
                    bArr = new byte[ProgressEvent.PART_STARTED_EVENT_CODE];
                    i2 = 0;
                } catch (IOException e) {
                    return null;
                }
            }
            try {
                bArr[i2] = (byte) read;
                i2++;
            } catch (IOException e2) {
                return bArr;
            }
        }
        if (i2 != 0) {
            while (i < i2) {
                byteArrayOutputStream.write(bArr[i]);
                i++;
            }
        }
        bArr = new byte[byteArrayOutputStream.size()];
        bArr = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return bArr;
    }

    public static String m612b() {
        switch (PayPal.getInstance().getServer()) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return "https://mobileclient.sandbox.paypal.com/";
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return StringUtil.EMPTY_STRING;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return "https://www.stage2mb101.paypal.com:10521/";
            default:
                return "https://mobileclient.paypal.com/";
        }
    }

    public static String m613b(String str) {
        return str != null ? str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&apos;") : str;
    }

    public static void m616c() {
        if (f795l == null) {
            f795l = new C0918a();
        }
        if (PayPalActivity._networkHandler == null) {
            PayPalActivity._networkHandler = new C0919b();
        }
        if (PayPalActivity._networkHandler.f806h == null) {
            PayPalActivity._networkHandler.f806h = new Hashtable();
        }
        if (PayPal.getInstance().getServer() == 2) {
            PayPalActivity._networkHandler.f806h.put("payButtonEnable", "true");
            PayPal.getInstance().setLibraryInitialized(true);
            return;
        }
        if (!PayPalActivity._networkHandler.f808j.isAlive()) {
            PayPalActivity._networkHandler.f808j.start();
        }
        PayPalActivity._networkHandler.m653a(8);
    }

    public static void m617d() {
        if (PayPalActivity._networkHandler != null) {
            C0919b c0919b = PayPalActivity._networkHandler;
            c0919b.f807i = true;
            while (c0919b.f808j.isAlive()) {
                PayPal.logd("NetworkHandler", "waiting for thread to stop");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    PayPal.logd("NetworkHandler", "waiting for thread to stop");
                }
            }
            PayPal.logd("NetworkHandler", "thread has stopped");
            PayPalActivity._networkHandler = null;
        }
    }

    public static C0919b m619e() {
        return PayPalActivity._networkHandler;
    }

    public static String m620e(String str) {
        if (str == null || str.length() == 0) {
            return StringUtil.EMPTY_STRING;
        }
        if (!str.startsWith("+")) {
            return str;
        }
        str = str.substring(1);
        for (String str2 : f799p) {
            if (str.startsWith(str2)) {
                return str.substring(str2.length());
            }
        }
        return str;
    }

    static /* synthetic */ boolean m621e(C0919b c0919b) throws C0923f {
        if (!C0919b.m650x()) {
            return false;
        }
        f800q = StringUtil.EMPTY_STRING;
        StringBuilder stringBuilder = new StringBuilder();
        C0931m.m702a(stringBuilder, "authorizationType", "Device");
        C0931m.m702a(stringBuilder, "authorizeDevice", "true");
        String str = C0919b.m612b() + C0919b.m644r() + "/DeviceAuthenticateUser";
        String c = C0931m.m719c(stringBuilder.toString());
        return c0919b.m608a(str, c, c0919b.m601a(c, str, true));
    }

    public static String m622f(String str) {
        if (str != null && str.length() > 0 && str.charAt(0) == '+') {
            String substring = str.substring(1);
            for (String str2 : f799p) {
                if (substring.startsWith(str2)) {
                    return str2;
                }
            }
        }
        return C0919b.m636m();
    }

    private static boolean m625g(String str) {
        String[] strArr = new String[]{"560027", "580022", "580023"};
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ String m626h(C0919b c0919b) {
        String a = C0931m.m699a(c0919b.f806h);
        String str = C0919b.m642p() + "ExecutePayment/";
        String a2 = c0919b.m601a(a, str, false);
        if (c0919b.m634k(a2)) {
            C0919b.m604a("sendPayment", str, a, a2);
            return null;
        }
        a = C0931m.m712b(a2);
        return a == null ? "-1" : a;
    }

    public static final DefaultHttpClient m627h() {
        if (PayPal.getInstance().getServer() != 3) {
            return new DefaultHttpClient();
        }
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try {
            schemeRegistry.register(new Scheme("https", new C0920c(), 443));
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (KeyStoreException e3) {
            e3.printStackTrace();
        } catch (UnrecoverableKeyException e4) {
            e4.printStackTrace();
        }
        HttpParams basicHttpParams = new BasicHttpParams();
        basicHttpParams.setParameter("http.conn-manager.max-total", Integer.valueOf(30));
        basicHttpParams.setParameter("http.conn-manager.max-per-route", new ConnPerRouteBean(30));
        basicHttpParams.setParameter("http.protocol.expect-continue", Boolean.valueOf(false));
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    private static boolean m628h(String str) {
        String[] strArr = new String[]{"10818", "10897", "10898", "10899", "520003"};
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean m630i(String str) {
        String[] strArr = new String[]{"10001", "10004", "10800", "10801", "10802", "10804", "10805", "10806", "10808", "10809", "10810", "10811", "10812", "10813", "10815", "10819", "10820", "10821", "10822", "10823", "10824", "10825", "10849", "10850", "10858", "10859", "10860", "10861", "10862", "10863", "10864", "10867", "99999", "520002", "520009", "539041", "540031", "550001", "550006", "559044", "560027", "569000", "569042", "569056", "569060", "579007", "579017", "579033", "579040", "579045", "579047", "579048", "580001", "580022", "580023", "580028", "580030", "580031", "580032", "580033", "580034", "589009", "589019", "500000"};
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static String m631j(String str) throws CertificateExpiredException, CertificateNotYetValidException {
        try {
            InputStream byteArrayInputStream;
            switch (PayPal.getInstance().getServer()) {
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                    byteArrayInputStream = new ByteArrayInputStream(f798o);
                    break;
                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                    byteArrayInputStream = new ByteArrayInputStream(f796m);
                    break;
                default:
                    byteArrayInputStream = new ByteArrayInputStream(f797n);
                    break;
            }
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            x509Certificate.checkValidity(new Date());
            RSAPublicKey rSAPublicKey = (RSAPublicKey) x509Certificate.getPublicKey();
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, rSAPublicKey);
            return C0919b.m613b(C0917a.m589a(instance.doFinal(str.getBytes()), 8));
        } catch (FileNotFoundException e) {
            PayPal.loge("NetworkHandler", "encryptPassword faulted " + e.getMessage());
            return StringUtil.EMPTY_STRING;
        } catch (CertificateException e2) {
            PayPal.loge("NetworkHandler", "encryptPassword faulted " + e2.getMessage());
            return StringUtil.EMPTY_STRING;
        } catch (IOException e3) {
            PayPal.loge("NetworkHandler", "encryptPassword faulted " + e3.getMessage());
            return StringUtil.EMPTY_STRING;
        } catch (NoSuchAlgorithmException e4) {
            PayPal.loge("NetworkHandler", "encryptPassword faulted " + e4.getMessage());
            return StringUtil.EMPTY_STRING;
        } catch (NoSuchPaddingException e5) {
            PayPal.loge("NetworkHandler", "encryptPassword faulted " + e5.getMessage());
            return StringUtil.EMPTY_STRING;
        } catch (InvalidKeyException e6) {
            PayPal.loge("NetworkHandler", "encryptPassword faulted " + e6.getMessage());
            return StringUtil.EMPTY_STRING;
        } catch (IllegalBlockSizeException e7) {
            PayPal.loge("NetworkHandler", "encryptPassword faulted " + e7.getMessage());
            return StringUtil.EMPTY_STRING;
        } catch (BadPaddingException e8) {
            PayPal.loge("NetworkHandler", "encryptPassword faulted " + e8.getMessage());
            return StringUtil.EMPTY_STRING;
        }
    }

    private boolean m634k(String str) {
        ParserConfigurationException parserConfigurationException = null;
        try {
            if (!m609a(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes(StringEncodings.UTF8))), str)) {
                return false;
            }
        } catch (SAXException e) {
            parserConfigurationException = e;
        } catch (IOException e2) {
            parserConfigurationException = e2;
        } catch (ParserConfigurationException e3) {
            parserConfigurationException = e3;
        }
        if (parserConfigurationException == null) {
            PayPal.loge("NetworkHandler", "Response contains an error, " + str);
        } else {
            PayPal.loge("NetworkHandler", "Exception checking for error in response, " + str);
        }
        return true;
    }

    public static String m636m() {
        String toUpperCase = Locale.getDefault().getCountry().toUpperCase();
        return toUpperCase.compareTo("US") == 0 ? "1" : toUpperCase.compareTo("CA") == 0 ? "1" : toUpperCase.compareTo("GB") == 0 ? "44" : toUpperCase.compareTo("AU") == 0 ? "61" : toUpperCase.compareTo("FR") == 0 ? "33" : toUpperCase.compareTo("ES") == 0 ? "34" : toUpperCase.compareTo("IT") == 0 ? "39" : "1";
    }

    public static String m638n() {
        return f800q;
    }

    private static String m642p() {
        switch (PayPal.getInstance().getServer()) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return "https://svcs.sandbox.paypal.com/AdaptivePayments/";
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return StringUtil.EMPTY_STRING;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return "https://www.stage2mb101.paypal.com:10279/AdaptivePayments/";
            default:
                return "https://svcs.paypal.com/AdaptivePayments/";
        }
    }

    private static String m643q() {
        switch (PayPal.getInstance().getServer()) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return "GMAdapter";
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return StringUtil.EMPTY_STRING;
            default:
                return "GMAdapter";
        }
    }

    private static String m644r() {
        switch (PayPal.getInstance().getServer()) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return "GMAdapter";
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return StringUtil.EMPTY_STRING;
            default:
                return "GMAdapter";
        }
    }

    private boolean m645s() {
        try {
            String g = C0931m.m733g(this.f806h);
            String str = C0919b.m642p() + "SetPaymentOptions/";
            String a = m601a(g, str, false);
            if (m634k(a)) {
                C0919b.m604a("setPaymentOptions", str, g, a);
                try {
                    C0931m.m708a(a, this.f806h);
                    return false;
                } catch (Throwable th) {
                    return false;
                }
            }
            C0931m.m708a(a, this.f806h);
            return true;
        } catch (C0932n e) {
            PayPal.loge("NetworkHandler", "Exception " + e.getMessage());
            return false;
        }
    }

    private boolean m646t() {
        String h = C0931m.m735h(this.f806h);
        String str = C0919b.m642p() + "GetAvailableShippingAddresses/";
        String a = m601a(h, str, false);
        if (m634k(a)) {
            C0919b.m604a("getAddresses", str, h, a);
            try {
                C0931m.m734g(a, this.f806h);
                return false;
            } catch (Throwable th) {
                return false;
            }
        }
        C0931m.m734g(a, this.f806h);
        return true;
    }

    private boolean m647u() {
        String b = C0931m.m713b(this.f806h);
        String str = C0919b.m642p() + "Preapproval/";
        String a = m601a(b, str, false);
        if (m634k(a)) {
            C0919b.m604a("createPreapprovalRequest", str, b, a);
            try {
                C0931m.m715b(a, this.f806h);
                return false;
            } catch (Throwable th) {
                return false;
            }
        }
        C0931m.m715b(a, this.f806h);
        return true;
    }

    private boolean m648v() {
        String a = m601a(C0931m.m724d(this.f806h), C0919b.m642p() + "PreapprovalDetails/", false);
        if (m634k(a)) {
            try {
                C0931m.m721c(a, this.f806h);
                return false;
            } catch (Throwable th) {
                return false;
            }
        }
        C0931m.m721c(a, this.f806h);
        if (!this.f806h.get("Approved").equals("true")) {
            return true;
        }
        Intent putExtra = new Intent(PayPalActivity.FATAL_ERROR).putExtra("FATAL_ERROR_ID", "-1").putExtra("FATAL_ERROR_MESSAGE", C0925h.m680a("ANDROID_preapproval_already_approved"));
        PayPalActivity.getInstance().paymentFailed((String) PayPalActivity._networkHandler.m657c("CorrelationId"), (String) PayPalActivity._networkHandler.m657c("PayKey"), "-1", C0925h.m680a("ANDROID_preapproval_already_approved"), false, true);
        PayPalActivity.getInstance().sendBroadcast(putExtra);
        return false;
    }

    private boolean m649w() {
        String c = C0931m.m720c(this.f806h);
        String str = C0919b.m642p() + "ConfirmPreapproval/";
        String a = m601a(c, str, false);
        if (m634k(a)) {
            C0919b.m604a("confirmPreapprovalRequest", str, c, a);
            try {
                C0931m.m725d(a, this.f806h);
                return false;
            } catch (Throwable th) {
                return false;
            }
        }
        C0931m.m725d(a, this.f806h);
        return true;
    }

    private static boolean m650x() {
        String deviceId = ((TelephonyManager) PayPal.getInstance().getParentContext().getSystemService("phone")).getDeviceId();
        if (deviceId == null) {
            deviceId = ((WifiManager) PayPal.getInstance().getParentContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        if (PayPal.getInstance().getServer() != 1 || !r0.equals("000000000000000")) {
            return true;
        }
        Intent putExtra = new Intent(PayPalActivity.FATAL_ERROR).putExtra("FATAL_ERROR_ID", "-1").putExtra("FATAL_ERROR_MESSAGE", C0925h.m680a("ANDROID_simulator_payment_block"));
        PayPalActivity.getInstance().paymentFailed((String) PayPalActivity._networkHandler.m657c("CorrelationId"), (String) PayPalActivity._networkHandler.m657c("PayKey"), "-1", C0925h.m680a("ANDROID_simulator_payment_block"), false, true);
        PayPalActivity.getInstance().sendBroadcast(putExtra);
        return false;
    }

    private Hashtable<String, Object> m651y() {
        try {
            String f = C0931m.m731f(this.f806h);
            if (f == null) {
                return null;
            }
            String str = C0919b.m642p() + "Pay/";
            String a = m601a(f, str, false);
            Intent putExtra;
            if (m634k(a)) {
                C0919b.m604a("createPayment", str, f, a);
                if (!a.contains("<errorId>580022</errorId>")) {
                    return null;
                }
                String a2 = C0925h.m680a("ANDROID_580022");
                putExtra = new Intent(PayPalActivity.FATAL_ERROR).putExtra("FATAL_ERROR_ID", "580022").putExtra("FATAL_ERROR_MESSAGE", a2);
                PayPalActivity.getInstance().paymentFailed((String) PayPalActivity._networkHandler.m657c("CorrelationId"), (String) PayPalActivity._networkHandler.m657c("PayKey"), "580022", a2, false, true);
                try {
                    PayPalActivity.getInstance().sendBroadcast(putExtra);
                } catch (Exception e) {
                }
                return null;
            } else if (!C0931m.m708a(a, this.f806h)) {
                this.f804f = -1;
                return null;
            } else if (a.contains("defaultFundingPlan") || !((String) this.f806h.get("ActionType")).equals("CREATE")) {
                return this.f806h;
            } else {
                putExtra = new Intent(PayPalActivity.FATAL_ERROR).putExtra("FATAL_ERROR_ID", "589009").putExtra("FATAL_ERROR_MESSAGE", C0925h.m680a("ANDROID_589009"));
                PayPalActivity.getInstance().paymentFailed((String) PayPalActivity._networkHandler.m657c("CorrelationId"), (String) PayPalActivity._networkHandler.m657c("PayKey"), "589009", C0925h.m680a("ANDROID_589009"), false, true);
                try {
                    PayPalActivity.getInstance().sendBroadcast(putExtra);
                } catch (Exception e2) {
                }
                return null;
            }
        } catch (C0932n e3) {
            PayPal.loge("NetworkHandler", "Exception " + e3.getMessage());
            return null;
        }
    }

    private Hashtable<String, Object> m652z() {
        String e = C0931m.m728e(this.f806h);
        String str = C0919b.m642p() + "GetFundingPlans/";
        String a = m601a(e, str, false);
        if (m634k(a)) {
            C0919b.m604a("createFundingRequest", str, e, a);
            try {
                C0931m.m729e(a, this.f806h);
            } catch (Throwable th) {
            }
            return null;
        } else if (!C0931m.m729e(a, this.f806h)) {
            this.f804f = -1;
            return null;
        } else if (((Vector) this.f806h.get("FundingPlans")).size() != 0) {
            return this.f806h;
        } else {
            try {
                PayPalActivity.getInstance().sendBroadcast(new Intent(PayPalActivity.FATAL_ERROR).putExtra("FATAL_ERROR_ID", "589009").putExtra("FATAL_ERROR_MESSAGE", C0925h.m680a("ANDROID_589009")));
            } catch (Exception e2) {
            }
            return null;
        }
    }

    public final void m653a(int i) {
        this.f805g = i;
        this.f803e = i;
    }

    public final void m654a(int i, Object obj) {
        PayPal instance = PayPal.getInstance();
        PayPalActivity instance2 = PayPalActivity.getInstance();
        C0919b c0919b = PayPalActivity._networkHandler;
        switch (i) {
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                if (((String) this.f806h.get("quickPay")).equals("true")) {
                    m653a(4);
                } else if (instance.getShippingEnabled()) {
                    m653a(7);
                } else {
                    instance2.sendBroadcast(new Intent(PayPalActivity.CREATE_PAYMENT_SUCCESS));
                }
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                String str = (String) c0919b.m657c("PayKey");
                String str2 = (String) c0919b.m657c("PaymentExecStatus");
                if (!instance.isHeavyCountry() || instance.hasCreatedPIN()) {
                    instance2.paymentSucceeded(str, str2, true);
                    return;
                }
                instance2.setTransactionSuccessful(true);
                instance2.paymentSucceeded(str, str2, false);
                C0885e.f640a = (String) obj;
                C08791.m466b(7);
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                m656a("FundingPlanId", (Object) "0");
                if (instance.getShippingEnabled()) {
                    m653a(7);
                } else {
                    instance2.sendBroadcast(new Intent(PayPalActivity.CREATE_PAYMENT_SUCCESS));
                }
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
                Hashtable hashtable;
                int k;
                Intent putExtra;
                if (instance.getServer() == 2) {
                    hashtable = C0875a.f590a;
                } else {
                    C0875a.f590a = (Hashtable) obj;
                    hashtable = c0919b.f806h;
                }
                Vector vector = (Vector) hashtable.get("AvailableAddresses");
                if (vector != null && vector.size() > 0) {
                    C0913h c0913h = (C0913h) vector.get(0);
                    if (((String) m657c("ShippingAddressId")) == null) {
                        m656a("ShippingAddressId", c0913h.m586h());
                        k = m663k();
                        if (k == 0) {
                            instance2.sendBroadcast(new Intent(PayPalActivity.CREATE_PAYMENT_SUCCESS));
                        }
                        if (k == -1) {
                            putExtra = new Intent(PayPalActivity.FATAL_ERROR).putExtra("FATAL_ERROR_ID", "-1").putExtra("FATAL_ERROR_MESSAGE", instance.getAdjustPaymentError());
                            instance2.paymentFailed((String) c0919b.m657c("CorrelationId"), (String) c0919b.m657c("PayKey"), "-1", instance.getAdjustPaymentError(), false, true);
                            instance2.sendBroadcast(putExtra);
                        }
                    }
                }
                k = 0;
                if (k == 0) {
                    instance2.sendBroadcast(new Intent(PayPalActivity.CREATE_PAYMENT_SUCCESS));
                }
                if (k == -1) {
                    putExtra = new Intent(PayPalActivity.FATAL_ERROR).putExtra("FATAL_ERROR_ID", "-1").putExtra("FATAL_ERROR_MESSAGE", instance.getAdjustPaymentError());
                    instance2.paymentFailed((String) c0919b.m657c("CorrelationId"), (String) c0919b.m657c("PayKey"), "-1", instance.getAdjustPaymentError(), false, true);
                    instance2.sendBroadcast(putExtra);
                }
            case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                C0889h.f677a = (String) obj;
                C08791.m464a(4);
            case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                instance2.sendBroadcast(new Intent(PayPalActivity.CREATE_PAYMENT_SUCCESS));
            default:
        }
    }

    public final void m655a(String str) {
        PayPal instance = PayPal.getInstance();
        if (instance.getServer() == 1) {
            PayPal.logd("MPL Tracking", "Post: " + str);
            String str2 = "Device";
            if (instance.getAuthMethod() == 0 || instance.getAuthMethod() == 3) {
                str2 = "Password";
            } else if (instance.getAuthMethod() == 1) {
                str2 = "PIN";
            }
            String str3 = "Simple";
            if (instance.getPayType() == 3) {
                str3 = "Preapproval";
            } else if (instance.getPayType() == 2) {
                str3 = "Chained";
            } else if (instance.getPayType() == 1) {
                str3 = "Parallel";
            }
            StringBuilder stringBuilder = new StringBuilder("https://sstats.paypal-metrics.com/b/ss/paypalwireless/5/H.5--WAP/12345?pageName=android/");
            stringBuilder.append("mpl-").append(str);
            stringBuilder.append("&c1=").append(Locale.getDefault().getCountry().toUpperCase());
            stringBuilder.append("&c4=ver").append(PayPal.getVersion());
            stringBuilder.append("&c5=").append("Android");
            stringBuilder.append("&c6=").append(instance.getParentContext().getPackageName());
            stringBuilder.append("&c7=").append(str2);
            stringBuilder.append("&c9=").append(str3);
            stringBuilder.append("&c10=").append(instance.getShippingEnabled() ? BucketVersioningConfiguration.ENABLED : BucketLifecycleConfiguration.DISABLED);
            str2 = stringBuilder.toString();
            PayPal.logd("NetworkHandler", "queueTrackingPost (), queue tracking " + str2);
            synchronized (f794k) {
                f794k.add(str2);
                f794k.notifyAll();
            }
        }
    }

    public final void m656a(String str, Object obj) {
        if (obj != null) {
            this.f806h.put(str, obj);
        } else {
            this.f806h.remove(str);
        }
    }

    public final Object m657c(String str) {
        return this.f806h.get(str);
    }

    public final void m658d(String str) {
        Intent putExtra = new Intent(PayPalActivity.FATAL_ERROR).putExtra("FATAL_ERROR_ID", "-1").putExtra("FATAL_ERROR_MESSAGE", str);
        PayPalActivity.getInstance().paymentFailed((String) PayPalActivity._networkHandler.m657c("CorrelationId"), (String) PayPalActivity._networkHandler.m657c("PayKey"), "-1", str, false, true);
        PayPalActivity.getInstance().sendBroadcast(putExtra);
    }

    public final String m659f() {
        if (this.f804f == 0) {
            this.f804f = 408;
        }
        return C0925h.m680a("ANDROID_" + this.f804f);
    }

    public final Hashtable<String, Object> m660g() {
        return this.f806h;
    }

    public final void m661i() {
        Object obj;
        PayPal instance = PayPal.getInstance();
        PayPalAdvancedPayment payment = instance.getPayment();
        this.f806h.remove("ShippingAddressId");
        m656a("PaymentCurrencyID", payment.getCurrencyType());
        m656a("CancelUrl", instance.getCancelUrl());
        m656a("ReturnUrl", instance.getReturnUrl());
        switch (instance.getFeesPayer()) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                obj = "SENDER";
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                obj = "PRIMARYRECEIVER";
                break;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                obj = "SECONDARYONLY";
                break;
            default:
                obj = "EACHRECEIVER";
                break;
        }
        m656a("FeesPayer", obj);
        m656a("ActionType", (Object) "CREATE");
        m656a("Receivers", payment.getReceivers());
        if (!(payment.getIpnUrl() == null || payment.getIpnUrl().equals(StringUtil.EMPTY_STRING))) {
            m656a("IpnNotificationUrl", payment.getIpnUrl());
        }
        if (!(payment.getMemo() == null || payment.getMemo().equals(StringUtil.EMPTY_STRING))) {
            m656a("Memo", payment.getMemo());
        }
        m656a("delegate", (Object) this);
        PayPalActivity._networkHandler.m653a(3);
    }

    public final void m662j() {
        m656a("PreapprovalKey", PayPal.getInstance().getPreapprovalKey());
        m656a("delegate", (Object) this);
        PayPalActivity._networkHandler.m653a(13);
    }

    public final int m663k() {
        int i = 0;
        PayPal instance = PayPal.getInstance();
        if (instance.getDynamicAmountCalculationEnabled() && instance.getShippingEnabled()) {
            C0913h c0913h;
            PayPalReceiverDetails payPalReceiverDetails;
            String str = (String) this.f806h.get("ShippingAddressId");
            Vector vector = (Vector) (PayPal.getInstance().getServer() == 2 ? C0875a.f590a : this.f806h).get("AvailableAddresses");
            for (int i2 = 0; i2 < vector.size(); i2++) {
                c0913h = (C0913h) vector.elementAt(i2);
                if (c0913h.m586h().equals(str)) {
                    break;
                }
            }
            c0913h = null;
            MEPAddress mEPAddress = new MEPAddress();
            str = c0913h.m578d();
            String e = c0913h.m580e();
            String b = c0913h.m574b();
            String g = c0913h.m584g();
            String f = c0913h.m582f();
            String c = c0913h.m576c();
            mEPAddress.setStreet1(str);
            mEPAddress.setStreet2(e);
            mEPAddress.setCity(b);
            mEPAddress.setState(g);
            mEPAddress.setPostalcode(f);
            mEPAddress.setCountrycode(c);
            PayPalAdvancedPayment payment = PayPal.getInstance().getPayment();
            ArrayList receivers = payment.getReceivers();
            Vector vector2 = new Vector();
            for (int i3 = 0; i3 < payment.getReceivers().size(); i3++) {
                payPalReceiverDetails = (PayPalReceiverDetails) payment.getReceivers().get(i3);
                MEPReceiverAmounts mEPReceiverAmounts = new MEPReceiverAmounts();
                mEPReceiverAmounts.amounts = new MEPAmounts();
                mEPReceiverAmounts.receiver = payPalReceiverDetails.getRecipient();
                if (payPalReceiverDetails.getInvoiceData().getTax() != null) {
                    mEPReceiverAmounts.amounts.setTax(payPalReceiverDetails.getInvoiceData().getTax());
                }
                if (payPalReceiverDetails.getInvoiceData().getShipping() != null) {
                    mEPReceiverAmounts.amounts.setShipping(payPalReceiverDetails.getInvoiceData().getShipping());
                }
                if (payment.getCurrencyType() != null) {
                    mEPReceiverAmounts.amounts.setCurrency(payment.getCurrencyType());
                }
                if (payPalReceiverDetails.getSubtotal() != null) {
                    mEPReceiverAmounts.amounts.setPaymentAmount(payPalReceiverDetails.getSubtotal());
                }
                vector2.add(mEPReceiverAmounts);
            }
            Vector adjustAmountsAdvanced = PayPalActivity.getInstance().adjustAmountsAdvanced(mEPAddress, payment.getCurrencyType(), vector2);
            if (adjustAmountsAdvanced == null) {
                return -1;
            }
            if (adjustAmountsAdvanced.size() == receivers.size()) {
                MEPReceiverAmounts mEPReceiverAmounts2;
                int i4 = 0;
                int i5 = 0;
                while (i4 < adjustAmountsAdvanced.size()) {
                    payPalReceiverDetails = (PayPalReceiverDetails) receivers.get(i4);
                    mEPReceiverAmounts2 = (MEPReceiverAmounts) adjustAmountsAdvanced.elementAt(i4);
                    BigDecimal tax = payPalReceiverDetails.getInvoiceData().getTax() != null ? payPalReceiverDetails.getInvoiceData().getTax() : new BigDecimal("0.0");
                    BigDecimal shipping = payPalReceiverDetails.getInvoiceData().getShipping() != null ? payPalReceiverDetails.getInvoiceData().getShipping() : new BigDecimal("0.0");
                    BigDecimal subtotal = payPalReceiverDetails.getSubtotal() != null ? payPalReceiverDetails.getSubtotal() : new BigDecimal("0.0");
                    str = payPalReceiverDetails.getRecipient();
                    BigDecimal tax2 = mEPReceiverAmounts2.amounts.getTax();
                    BigDecimal shipping2 = mEPReceiverAmounts2.amounts.getShipping();
                    BigDecimal paymentAmount = mEPReceiverAmounts2.amounts.getPaymentAmount();
                    e = mEPReceiverAmounts2.receiver;
                    if (paymentAmount == subtotal && str.equals(e)) {
                        int i6 = (tax2 == tax && shipping2 == shipping) ? i5 : 1;
                        i4++;
                        i5 = i6;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                if (i5 != 0) {
                    while (i < adjustAmountsAdvanced.size()) {
                        payPalReceiverDetails = (PayPalReceiverDetails) receivers.get(i);
                        mEPReceiverAmounts2 = (MEPReceiverAmounts) adjustAmountsAdvanced.elementAt(i);
                        payPalReceiverDetails.getInvoiceData().setShipping(mEPReceiverAmounts2.amounts.getShipping());
                        payPalReceiverDetails.getInvoiceData().setTax(mEPReceiverAmounts2.amounts.getTax());
                        i++;
                    }
                    m656a("PaymentCurrencyID", payment.getCurrencyType());
                    m656a("Receivers", payment.getReceivers());
                    if (!(payment.getIpnUrl() == null || payment.getIpnUrl().equals(StringUtil.EMPTY_STRING))) {
                        m656a("IpnNotificationUrl", payment.getIpnUrl());
                    }
                    if (!(payment.getMemo() == null || payment.getMemo().equals(StringUtil.EMPTY_STRING))) {
                        m656a("Memo", payment.getMemo());
                    }
                    m656a("ActionType", (Object) "CREATE");
                    m656a("delegate", (Object) this);
                    m653a(3);
                    return 1;
                }
            }
            throw new IllegalArgumentException();
        }
        return 0;
    }

    public final void m664l() {
    }
}
