package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.google.common.base.Ascii;
import com.google.gdata.util.common.base.Charsets;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.util.common.base.StringUtil;
import java.nio.charset.Charset;
import java.util.Locale;

public class Test extends Activity {
    public static final byte[] ENGLISH_PLAIN_TEXT;
    static final String TAG = "FakeTagsActivity";
    static final byte[] UID;
    ArrayAdapter<TagDescription> _adapter;
    NfcAdapter nfcAdapter;

    /* renamed from: com.doviknissim.inegotiate.app.Test.1 */
    class C02061 implements OnClickListener {
        C02061() {
        }

        public void onClick(View v) {
            Test.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Test.2 */
    class C02072 implements OnClickListener {
        C02072() {
        }

        public void onClick(View v) {
            Test.this.testNFC();
        }
    }

    static final class TagDescription {
        public NdefMessage[] msgs;
        public String title;

        public TagDescription(String title, byte[] bytes) {
            this.title = title;
            try {
                this.msgs = new NdefMessage[]{new NdefMessage(bytes)};
            } catch (Exception e) {
                throw new RuntimeException("Failed to create tag description", e);
            }
        }

        public String toString() {
            return this.title;
        }
    }

    static {
        ENGLISH_PLAIN_TEXT = new byte[]{(byte) -47, (byte) 1, Ascii.FS, (byte) 84, (byte) 2, (byte) 101, (byte) 110, (byte) 83, (byte) 111, (byte) 109, (byte) 101, Ascii.SPACE, (byte) 114, (byte) 97, (byte) 110, (byte) 100, (byte) 111, (byte) 109, Ascii.SPACE, (byte) 101, (byte) 110, (byte) 103, (byte) 108, (byte) 105, (byte) 115, (byte) 104, Ascii.SPACE, (byte) 116, (byte) 101, (byte) 120, (byte) 116, (byte) 46};
        byte[] bArr = new byte[4];
        bArr[0] = (byte) 5;
        bArr[2] = (byte) 3;
        bArr[3] = (byte) 8;
        UID = bArr;
    }

    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        setContentView(C0185R.layout.test);
        ((Button) findViewById(C0185R.id.button1)).setOnClickListener(new C02061());
        ((Button) findViewById(C0185R.id.button2)).setOnClickListener(new C02072());
    }

    private void testNFC() {
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(getApplicationContext());
        if (this.nfcAdapter != null) {
            NdefRecord record = new NdefRecord((short) 1, NdefRecord.RTD_TEXT, new byte[0], getNdefMessageMockContent());
            NdefMessage msg = new NdefMessage(new NdefRecord[]{record});
            Intent intent = new Intent("android.nfc.action.NDEF_DISCOVERED");
            intent.putExtra("android.nfc.extra.NDEF_MESSAGES", new NdefMessage[]{msg});
            startActivity(intent);
            return;
        }
        Log.e("iNegotiate", "[ERROR] NFC Adapter is null");
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public static NdefRecord newTextRecord(String text, Locale locale, boolean encodeInUtf8) {
        Preconditions.checkNotNull(text);
        Preconditions.checkNotNull(locale);
        byte[] langBytes = locale.getLanguage().getBytes(Charsets.US_ASCII);
        byte[] textBytes = text.getBytes(encodeInUtf8 ? Charsets.UTF_8 : Charset.forName("UTF-16"));
        int utfBit = encodeInUtf8 ? 0 : XMLChar.MASK_NCNAME;
        byte[] statusAsByte = new byte[]{(byte) ((char) (langBytes.length + utfBit))};
        byte[] data = new byte[((statusAsByte.length + langBytes.length) + textBytes.length)];
        System.arraycopy(statusAsByte, 0, data, 0, statusAsByte.length);
        System.arraycopy(langBytes, 0, data, statusAsByte.length, langBytes.length);
        System.arraycopy(textBytes, 0, data, statusAsByte.length + langBytes.length, textBytes.length);
        return new NdefRecord((short) 1, NdefRecord.RTD_TEXT, new byte[0], data);
    }

    public static NdefRecord newMimeRecord(String type, byte[] data) {
        Preconditions.checkNotNull(type);
        Preconditions.checkNotNull(data);
        return new NdefRecord((short) 2, type.getBytes(Charsets.US_ASCII), new byte[0], data);
    }

    private byte[] getNdefMessageMockContent() {
        return (StringUtil.EMPTY_STRING + "contactName=" + "Johny Depp," + "contactEmail=" + "j@j.co.il," + "contactCell=" + "555-555-5555," + "item=" + "Beatles Disk," + "date=" + "08-20-2012," + "amount=" + "100," + "buyerOrSeller=" + "1," + "contactme=" + "true," + "currency=" + "USD," + "status=" + "received.new," + "duedate=" + "08-20-2013").getBytes();
    }
}
