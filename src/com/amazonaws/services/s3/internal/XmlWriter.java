package com.amazonaws.services.s3.internal;

import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class XmlWriter {
    static final /* synthetic */ boolean $assertionsDisabled;
    StringBuilder sb;
    List<String> tags;

    static {
        $assertionsDisabled = !XmlWriter.class.desiredAssertionStatus();
    }

    public XmlWriter() {
        this.tags = new ArrayList();
        this.sb = new StringBuilder();
    }

    private void appendEscapedString(String str, StringBuilder stringBuilder) {
        int i = 0;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            String str2;
            switch (str.charAt(i2)) {
                case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                    str2 = "&#9;";
                    break;
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                    str2 = "&#10;";
                    break;
                case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                    str2 = "&#13;";
                    break;
                case '\"':
                    str2 = "&quote;";
                    break;
                case '&':
                    str2 = "&amp;";
                    break;
                case '<':
                    str2 = "&lt;";
                    break;
                case '>':
                    str2 = "&gt;";
                    break;
                default:
                    str2 = null;
                    break;
            }
            if (str2 != null) {
                if (i < i2) {
                    stringBuilder.append(str, i, i2);
                }
                this.sb.append(str2);
                i = i2 + 1;
            }
            i2++;
        }
        if (i < i2) {
            this.sb.append(str, i, i2);
        }
    }

    private void writeAttr(String str, String str2) {
        this.sb.append(' ').append(str).append("=\"");
        appendEscapedString(str2, this.sb);
        this.sb.append("\"");
    }

    public XmlWriter end() {
        if ($assertionsDisabled || this.tags.size() > 0) {
            this.sb.append(XMLStreamWriterImpl.OPEN_END_TAG).append((String) this.tags.remove(this.tags.size() - 1)).append(">");
            return this;
        }
        throw new AssertionError();
    }

    public byte[] getBytes() {
        if ($assertionsDisabled || this.tags.size() == 0) {
            try {
                return toString().getBytes(Constants.DEFAULT_ENCODING);
            } catch (UnsupportedEncodingException e) {
                return toString().toString().getBytes();
            }
        }
        throw new AssertionError();
    }

    public XmlWriter start(String str) {
        this.sb.append("<").append(str).append(">");
        this.tags.add(str);
        return this;
    }

    public XmlWriter start(String str, String str2, String str3) {
        this.sb.append("<").append(str);
        writeAttr(str2, str3);
        this.sb.append(">");
        this.tags.add(str);
        return this;
    }

    public XmlWriter start(String str, String[] strArr, String[] strArr2) {
        this.sb.append("<").append(str);
        for (int i = 0; i < Math.min(strArr.length, strArr2.length); i++) {
            writeAttr(strArr[i], strArr2[i]);
        }
        this.sb.append(">");
        this.tags.add(str);
        return this;
    }

    public String toString() {
        return this.sb.toString();
    }

    public XmlWriter value(String str) {
        appendEscapedString(str, this.sb);
        return this;
    }
}
