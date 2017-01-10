package com.paypal.android.MEP;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import com.paypal.android.MEP.p000a.C0875a;
import com.paypal.android.MEP.p000a.C0875a.C0871a;
import com.paypal.android.MEP.p000a.C0876b;
import com.paypal.android.MEP.p000a.C0878c;
import com.paypal.android.MEP.p000a.C0882d;
import com.paypal.android.MEP.p000a.C0882d.C08791;
import com.paypal.android.MEP.p000a.C0882d.C0880a;
import com.paypal.android.MEP.p000a.C0885e;
import com.paypal.android.MEP.p000a.C0886f;
import com.paypal.android.MEP.p000a.C0888g;
import com.paypal.android.MEP.p000a.C0888g.C0887a;
import com.paypal.android.MEP.p000a.C0889h;
import com.paypal.android.MEP.p002b.C0902f;
import com.paypal.android.p001b.C0872j;
import com.paypal.android.p001b.C0945l;
import com.paypal.android.p003a.C0919b;
import com.paypal.android.p003a.C0925h;
import java.util.Hashtable;
import java.util.Vector;

public final class PayPalActivity extends Activity implements AnimationListener {
    public static String AUTH_SUCCESS = null;
    public static String CREATE_PAYMENT_FAIL = null;
    public static String CREATE_PAYMENT_SUCCESS = null;
    public static final String EXTRA_CORRELATION_ID = "com.paypal.android.CORRELATION_ID";
    public static final String EXTRA_ERROR_ID = "com.paypal.android.ERROR_ID";
    public static final String EXTRA_ERROR_MESSAGE = "com.paypal.android.ERROR_MESSAGE";
    public static final String EXTRA_PAYMENT_ADJUSTER = "com.paypal.android.PAYMENT_ADJUSTER";
    public static final String EXTRA_PAYMENT_INFO = "com.paypal.android.PAYPAL_PAYMENT";
    public static final String EXTRA_PAYMENT_STATUS = "com.paypal.android.PAYMENT_STATUS";
    public static final String EXTRA_PAY_KEY = "com.paypal.android.PAY_KEY";
    public static final String EXTRA_PREAPPROVAL_INFO = "com.paypal.android.PAYPAL_PREAPPROVAL";
    public static final String EXTRA_RESULT_DELEGATE = "com.paypal.android.RESULT_DELEGATE";
    public static String FATAL_ERROR = null;
    public static String LOGIN_FAIL = null;
    public static String LOGIN_SUCCESS = null;
    public static final int RESULT_FAILURE = 2;
    public static final int VIEW_ABOUT = 2;
    public static final int VIEW_CREATE_PIN = 7;
    public static final int VIEW_FATAL_ERROR = 5;
    public static final int VIEW_INFO = 1;
    public static final int VIEW_LOGIN = 0;
    public static final int VIEW_NUM_VIEWS = 9;
    public static final int VIEW_PREAPPROVAL = 6;
    public static final int VIEW_REVIEW = 3;
    public static final int VIEW_SUCCESS = 4;
    public static final int VIEW_TEST = 8;
    public static C0919b _networkHandler;
    public static PayPal _paypal;
    public static String _popIntent;
    public static String _pushIntent;
    public static String _replaceIntent;
    public static String _updateIntent;
    private static PayPalActivity f523c;
    private static String f524h;
    private PaymentAdjuster f525a;
    private PayPalResultDelegate f526b;
    private Vector<C0872j> f527d;
    private Animation f528e;
    private Intent f529f;
    private boolean f530g;
    private BroadcastReceiver f531i;
    private BroadcastReceiver f532j;
    public boolean transactionSuccessful;

    static {
        f523c = null;
        _networkHandler = null;
        f524h = null;
    }

    public PayPalActivity() {
        this.f529f = null;
        this.f530g = false;
        this.transactionSuccessful = false;
        this.f531i = new C0904c(this);
        this.f532j = new C0903b(this);
    }

    private boolean m428a(int i) {
        View c0882d;
        if (i == 0) {
            C0919b.m619e().m655a("mpl-login");
            c0882d = new C0882d(this);
        } else if (i == VIEW_INFO) {
            C0919b.m619e().m655a("mpl-help-binding");
            c0882d = new C0876b(this);
        } else if (i == VIEW_ABOUT) {
            C0919b.m619e().m655a("mpl-help");
            c0882d = new C0886f(this);
        } else if (i == VIEW_REVIEW) {
            c0882d = new C0875a(this);
        } else if (i == VIEW_SUCCESS) {
            c0882d = new C0889h(this);
        } else if (i == VIEW_FATAL_ERROR) {
            c0882d = new C0878c(this, this.f529f);
        } else if (i == VIEW_PREAPPROVAL) {
            c0882d = new C0888g(this);
        } else if (i != VIEW_CREATE_PIN) {
            return false;
        } else {
            C0919b.m619e().m655a("mpl-create-PIN");
            c0882d = new C0885e(this);
        }
        C0872j c0872j = this.f527d.size() > 0 ? (C0872j) this.f527d.lastElement() : null;
        setContentView(c0882d);
        this.f527d.add(c0882d);
        if (c0872j != null) {
            c0872j.m439a();
        }
        if (i == 0) {
            Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, VIEW_ABOUT, 0.5f, VIEW_ABOUT, 0.5f);
            scaleAnimation.setDuration(500);
            scaleAnimation.setRepeatCount(VIEW_LOGIN);
            scaleAnimation.setAnimationListener(this);
            c0882d.setAnimation(scaleAnimation);
            if (f524h != null) {
                ((C0882d) c0882d).m473a(C0880a.STATE_LOGGING_OUT);
                ((C0882d) c0882d).m478d(f524h);
                f524h = null;
            }
        }
        return true;
    }

    static /* synthetic */ boolean m429a(PayPalActivity payPalActivity) {
        C0872j c0872j = (C0872j) f523c.f527d.lastElement();
        if (payPalActivity.f527d.size() != VIEW_INFO) {
            payPalActivity.f527d.remove(c0872j);
            C0872j c0872j2 = (C0872j) payPalActivity.f527d.lastElement();
            if (c0872j2 != null) {
                payPalActivity.setContentView(c0872j2);
            }
        }
        c0872j.m439a();
        return true;
    }

    private void m431b() {
        String appID = PayPal.getInstance().getAppID();
        _pushIntent = appID + "PUSH_DIALOG_";
        _popIntent = appID + "POP_DIALOG";
        _replaceIntent = appID + "REPLACE_DIALOG_";
        _updateIntent = appID + "UPDATE_VIEW";
        LOGIN_SUCCESS = appID + "LOGIN_SUCCESS";
        LOGIN_FAIL = appID + "LOGIN_FAIL";
        AUTH_SUCCESS = appID + "AUTH_SUCCESS";
        CREATE_PAYMENT_SUCCESS = appID + "CREATE_PAYMENT_SUCCESS";
        CREATE_PAYMENT_FAIL = appID + "CREATE_PAYMENT_FAIL";
        FATAL_ERROR = appID + "FATAL_ERROR";
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(_popIntent);
        for (int i = VIEW_LOGIN; i < VIEW_NUM_VIEWS; i += VIEW_INFO) {
            intentFilter.addAction(_pushIntent + i);
            intentFilter.addAction(_replaceIntent + i);
        }
        intentFilter.addAction(_updateIntent);
        registerReceiver(this.f532j, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(LOGIN_SUCCESS);
        intentFilter2.addAction(LOGIN_FAIL);
        intentFilter2.addAction(CREATE_PAYMENT_SUCCESS);
        intentFilter2.addAction(CREATE_PAYMENT_FAIL);
        intentFilter2.addAction(FATAL_ERROR);
        registerReceiver(this.f531i, intentFilter2);
        C0919b.m616c();
    }

    static /* synthetic */ boolean m433b(PayPalActivity payPalActivity, int i) {
        C0872j c0872j = (C0872j) payPalActivity.f527d.lastElement();
        if (!payPalActivity.m428a(i)) {
            return false;
        }
        payPalActivity.f527d.remove(c0872j);
        return true;
    }

    private void m434c() {
        if (this.f527d == null || this.f527d.size() <= 0) {
            finish();
            f523c = null;
            return;
        }
        C0872j c0872j = (C0872j) this.f527d.lastElement();
        this.f528e = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, VIEW_ABOUT, 0.5f, VIEW_ABOUT, 0.5f);
        this.f528e.setDuration(500);
        this.f528e.setRepeatCount(VIEW_LOGIN);
        this.f528e.setAnimationListener(this);
        c0872j.setAnimation(this.f528e);
        runOnUiThread(new C0945l(c0872j, this.f528e));
    }

    public static PayPalActivity getInstance() {
        return f523c;
    }

    public final MEPAmounts AdjustAmounts(MEPAddress mEPAddress, String str, String str2, String str3, String str4) {
        return this.f525a != null ? this.f525a.adjustAmount(mEPAddress, str, str2, str3, str4) : null;
    }

    public final Vector<MEPReceiverAmounts> adjustAmountsAdvanced(MEPAddress mEPAddress, String str, Vector<MEPReceiverAmounts> vector) {
        return this.f525a != null ? this.f525a.adjustAmountsAdvanced(mEPAddress, str, vector) : null;
    }

    public final C0872j getDialog() {
        return (C0872j) this.f527d.lastElement();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i == VIEW_REVIEW) {
            setResult(i2, intent);
            m434c();
        }
    }

    public final void onAnimationEnd(Animation animation) {
        if (animation == this.f528e) {
            f523c.finish();
            f523c = null;
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f530g = false;
        Hashtable hashtable = (Hashtable) getLastNonConfigurationInstance();
        if (hashtable != null) {
            _paypal = (PayPal) hashtable.get("PayPal");
            Vector vector = (Vector) hashtable.get("ViewStack");
            this.f527d = new Vector(VIEW_LOGIN);
            _networkHandler = (C0919b) hashtable.get("NetworkHandler");
            if (hashtable.get("ReviewViewInfo") != null) {
                C0875a.f590a = (Hashtable) hashtable.get("ReviewViewInfo");
            }
            m431b();
            int i = VIEW_LOGIN;
            Object obj = null;
            while (i < vector.size()) {
                int intValue = ((Integer) vector.elementAt(i)).intValue();
                Object c0882d = intValue == 0 ? new C0882d(this) : intValue == VIEW_INFO ? new C0876b(this) : intValue == VIEW_ABOUT ? new C0886f(this) : intValue == VIEW_REVIEW ? new C0875a(this) : intValue == VIEW_SUCCESS ? new C0889h(this) : intValue == VIEW_FATAL_ERROR ? new C0878c(this) : intValue == VIEW_PREAPPROVAL ? new C0888g(this) : intValue == VIEW_CREATE_PIN ? new C0885e(this) : obj;
                this.f527d.add(c0882d);
                i += VIEW_INFO;
                obj = c0882d;
            }
            Editable editable = (Editable) hashtable.get("UserString");
            EditText editText = (EditText) findViewById(5004);
            if (!(editText == null || editable == null || editable.length() <= 0)) {
                editText.setText(editable);
            }
            Editable editable2 = (Editable) hashtable.get("PasswordString");
            EditText editText2 = (EditText) findViewById(5005);
            if (!(editText2 == null || editable2 == null || editable2.length() <= 0)) {
                editText2.setText(editable2);
            }
            setContentView((View) this.f527d.lastElement());
            this.f527d.lastElement();
            f523c = this;
            return;
        }
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_PAYMENT_INFO) || intent.hasExtra(EXTRA_PREAPPROVAL_INFO)) {
            if (intent.hasExtra(EXTRA_PAYMENT_ADJUSTER)) {
                this.f525a = (PaymentAdjuster) intent.getSerializableExtra(EXTRA_PAYMENT_ADJUSTER);
            }
            if (intent.hasExtra(EXTRA_RESULT_DELEGATE)) {
                this.f526b = (PayPalResultDelegate) intent.getSerializableExtra(EXTRA_RESULT_DELEGATE);
            }
            m431b();
            PayPal instance = PayPal.getInstance();
            if (instance.getPayType() == VIEW_REVIEW) {
                PayPalPreapproval payPalPreapproval = (PayPalPreapproval) intent.getSerializableExtra(EXTRA_PREAPPROVAL_INFO);
                if (payPalPreapproval == null) {
                    paymentFailed((String) C0919b.m619e().m657c("CorrelationId"), (String) C0919b.m619e().m657c("PayKey"), "-1", C0925h.m680a("ANDROID_no_payment"), true, true);
                    return;
                } else if (!payPalPreapproval.isValid() || instance.getPreapprovalKey() == null || instance.getPreapprovalKey().length() <= 0) {
                    paymentFailed((String) C0919b.m619e().m657c("CorrelationId"), (String) C0919b.m619e().m657c("PayKey"), "-1", C0925h.m680a("ANDROID_invalid_payment"), true, true);
                    return;
                } else if (!C0919b.m605a()) {
                    paymentFailed((String) C0919b.m619e().m657c("CorrelationId"), (String) C0919b.m619e().m657c("PayKey"), "-1", C0925h.m680a("ANDROID_application_not_authorized"), true, true);
                    return;
                }
            }
            PayPalAdvancedPayment payPalAdvancedPayment = (PayPalAdvancedPayment) intent.getSerializableExtra(EXTRA_PAYMENT_INFO);
            if (payPalAdvancedPayment == null) {
                paymentFailed((String) C0919b.m619e().m657c("CorrelationId"), (String) C0919b.m619e().m657c("PayKey"), "-1", C0925h.m680a("ANDROID_no_payment"), true, true);
                return;
            } else if (!payPalAdvancedPayment.isValid()) {
                paymentFailed((String) C0919b.m619e().m657c("CorrelationId"), (String) C0919b.m619e().m657c("PayKey"), "-1", C0925h.m680a("ANDROID_invalid_payment"), true, true);
                return;
            } else if (!C0919b.m605a()) {
                paymentFailed((String) C0919b.m619e().m657c("CorrelationId"), (String) C0919b.m619e().m657c("PayKey"), "-1", C0925h.m680a("ANDROID_application_not_authorized"), true, true);
                return;
            }
            f523c = this;
            if (this.f527d != null) {
                this.f527d.setSize(VIEW_LOGIN);
            } else {
                this.f527d = new Vector(VIEW_LOGIN);
            }
            C08791.m464a(VIEW_LOGIN);
            return;
        }
        throw new NullPointerException("PayPalPayment/Preapproval object does not exist in intent");
    }

    protected final void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(this.f532j);
            unregisterReceiver(this.f531i);
        } catch (Exception e) {
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != VIEW_SUCCESS) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.f527d.lastElement() instanceof C0882d) {
            if (((C0882d) this.f527d.lastElement()).m477c() != C0880a.STATE_LOGGING_IN) {
                new C0902f(this).show();
            }
            return true;
        } else if (this.f527d.lastElement() instanceof C0875a) {
            if (!(((C0875a) this.f527d.lastElement()).m453c() == C0871a.STATE_SENDING_PAYMENT || ((C0875a) this.f527d.lastElement()).m453c() == C0871a.STATE_UPDATING)) {
                new C0902f(this).show();
            }
            return true;
        } else if (this.f527d.lastElement() instanceof C0888g) {
            if (((C0888g) this.f527d.lastElement()).m504c() != C0887a.STATE_CONFIRM_PREAPPROVAL) {
                new C0902f(this).show();
            }
            return true;
        } else if ((this.f527d.lastElement() instanceof C0886f) || (this.f527d.lastElement() instanceof C0876b)) {
            C08791.m463a();
            return true;
        } else if (!(this.f527d.lastElement() instanceof C0889h) && !(this.f527d.lastElement() instanceof C0885e)) {
            return super.onKeyDown(i, keyEvent);
        } else {
            if (!this.f530g) {
                this.f530g = true;
                paymentSucceeded((String) _networkHandler.m657c("PayKey"), (String) _networkHandler.m657c("PaymentExecStatus"), true);
            }
            return true;
        }
    }

    public final Object onRetainNonConfigurationInstance() {
        Editable text;
        Hashtable hashtable = new Hashtable();
        hashtable.put("PayPal", _paypal);
        Vector vector = new Vector();
        for (int i = VIEW_LOGIN; i < this.f527d.size(); i += VIEW_INFO) {
            C0872j c0872j = (C0872j) this.f527d.elementAt(i);
            int i2 = c0872j instanceof C0882d ? VIEW_LOGIN : c0872j instanceof C0876b ? VIEW_INFO : c0872j instanceof C0886f ? VIEW_ABOUT : c0872j instanceof C0875a ? VIEW_REVIEW : c0872j instanceof C0889h ? VIEW_SUCCESS : c0872j instanceof C0878c ? VIEW_FATAL_ERROR : c0872j instanceof C0888g ? VIEW_PREAPPROVAL : c0872j instanceof C0885e ? VIEW_CREATE_PIN : VIEW_LOGIN;
            vector.add(new Integer(i2));
        }
        hashtable.put("ViewStack", vector);
        hashtable.put("NetworkHandler", _networkHandler);
        if (C0875a.f590a != null) {
            hashtable.put("ReviewViewInfo", C0875a.f590a);
        }
        EditText editText = (EditText) findViewById(5004);
        if (editText != null) {
            text = editText.getText();
            if (text != null && text.length() > 0) {
                hashtable.put("UserString", text);
            }
        }
        editText = (EditText) findViewById(5005);
        if (editText != null) {
            text = editText.getText();
            if (text != null && text.length() > 0) {
                hashtable.put("PasswordString", text);
            }
        }
        return hashtable;
    }

    public final void paymentCanceled() {
        if (this.transactionSuccessful) {
            paymentSucceeded((String) C0919b.m619e().m657c("PayKey"), (String) C0919b.m619e().m657c("PaymentExecStatus"));
            return;
        }
        if (this.f526b != null) {
            this.f526b.onPaymentCanceled("OTHER");
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_PAYMENT_STATUS, "OTHER");
        setResult(VIEW_LOGIN, intent);
        m434c();
    }

    public final void paymentFailed(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        if (this.transactionSuccessful) {
            paymentSucceeded((String) C0919b.m619e().m657c("PayKey"), (String) C0919b.m619e().m657c("PaymentExecStatus"));
            return;
        }
        if (this.f526b != null && z2) {
            this.f526b.onPaymentFailed("OTHER", str, str2, str3, str4);
        }
        if (z) {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_CORRELATION_ID, str);
            intent.putExtra(EXTRA_PAY_KEY, str2);
            intent.putExtra(EXTRA_ERROR_ID, str3);
            intent.putExtra(EXTRA_ERROR_MESSAGE, str4);
            intent.putExtra(EXTRA_PAYMENT_STATUS, "OTHER");
            setResult(VIEW_ABOUT, intent);
            m434c();
        }
    }

    public final void paymentSucceeded(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_PAY_KEY, str);
        intent.putExtra(EXTRA_PAYMENT_STATUS, str2);
        setResult(-1, intent);
        m434c();
    }

    public final void paymentSucceeded(String str, String str2, boolean z) {
        if (this.f526b != null) {
            this.f526b.onPaymentSucceeded(str, str2);
        }
        if (z) {
            paymentSucceeded(str, str2);
        }
    }

    public final void setTransactionSuccessful(boolean z) {
        this.transactionSuccessful = z;
    }
}
