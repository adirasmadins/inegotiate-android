package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.CheckoutButton;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.PayPalPayment;
import java.math.BigDecimal;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class INegotiatePaypal extends Activity {
    private static final int REQUEST_PAYPAL_CHECKOUT = 272;

    /* renamed from: com.doviknissim.inegotiate.app.INegotiatePaypal.1 */
    class C01421 implements OnClickListener {
        C01421() {
        }

        public void onClick(View v) {
            INegotiatePaypal.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.INegotiatePaypal.2 */
    class C01432 implements OnClickListener {
        C01432() {
        }

        public void onClick(View v) {
            INegotiatePaypal.this.validateInput();
            INegotiatePaypal.this.processPayment();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.paypal);
        PayPal pp = PayPal.initWithAppID(this, "APP-8XR03744J7208135H", 1);
        ((ImageView) findViewById(C0185R.id.backImageButton)).setOnClickListener(new C01421());
        Bundle extras = getIntent().getExtras();
        ((EditText) findViewById(C0185R.id.editText4)).setText(extras.getString("amount"));
        ((EditText) findViewById(C0185R.id.editText5)).setText(extras.getString("currency"));
        LinearLayout layoutSimplePayment = (LinearLayout) findViewById(C0185R.id.buttonLayout);
        LayoutParams params = new LayoutParams(-2, -2);
        params.bottomMargin = 10;
        params.leftMargin = 150;
        layoutSimplePayment.setLayoutParams(params);
        layoutSimplePayment.setOrientation(1);
        CheckoutButton launchSimplePayment = pp.getCheckoutButton(this, 1, 0);
        launchSimplePayment.setOnClickListener(new C01432());
        launchSimplePayment.offsetLeftAndRight(80);
        layoutSimplePayment.addView(launchSimplePayment);
    }

    private void processPayment() {
        PayPalPayment payment = new PayPalPayment();
        payment.setSubtotal(new BigDecimal(((EditText) findViewById(C0185R.id.editText4)).getText().toString()));
        payment.setCurrencyType(((EditText) findViewById(C0185R.id.editText5)).getText().toString());
        payment.setRecipient(((EditText) findViewById(C0185R.id.editText3)).getText().toString());
        payment.setPaymentType(2);
        startActivityForResult(PayPal.getInstance().checkout(payment, (Context) this), REQUEST_PAYPAL_CHECKOUT);
    }

    private void validateInput() {
        if (((EditText) findViewById(C0185R.id.editText3)).getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(1);
        } else if (((EditText) findViewById(C0185R.id.editText4)).getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(2);
        } else if (((EditText) findViewById(C0185R.id.editText5)).getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(3);
        }
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Missing required information").setMessage("Please enter a valid email address, representing the buyer's paypal account").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Missing required information").setMessage("Please enter a valid email address, representing the sellers paypal account").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new Builder(this).setTitle("Missing required information").setMessage("Please enter a valid amount for the deal").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return new Builder(this).setTitle("Missing required information").setMessage("Please enter a valid currency for the deal").setPositiveButton("OK", null).create();
            default:
                return null;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("iNegotiate", "[DEBUG] onActivityResults is called");
        Context context = getApplicationContext();
        CharSequence text = StringUtil.EMPTY_STRING;
        switch (resultCode) {
            case CharacterEscapes.ESCAPE_STANDARD /*-1*/:
                Log.d("iNegotiate", "[DEBUG] result = RESULT_OK");
                Log.d("iNegotiate", "[DEBUG] payKey ID is: " + data.getStringExtra(PayPalActivity.EXTRA_PAY_KEY));
                Toast.makeText(context, "The payment was processed successfully!", 0).show();
                startActivity(new Intent("android.intent.action.WINDOWS"));
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                Log.d("iNegotiate", "[DEBUG] result = RESULT_CANCELED");
                Toast.makeText(context, "The payment was canceled!", 0).show();
                startActivity(new Intent("android.intent.action.WINDOWS"));
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                Log.d("iNegotiate", "[DEBUG] result = RESULT_FAILURE");
                String errorID = data.getStringExtra(PayPalActivity.EXTRA_ERROR_ID);
                String errorMessage = data.getStringExtra(PayPalActivity.EXTRA_ERROR_MESSAGE);
                Toast.makeText(context, "The payment failed to go through", 0).show();
                startActivity(new Intent("android.intent.action.WINDOWS"));
            default:
        }
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        View v = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);
        if (v instanceof EditText) {
            View w = getCurrentFocus();
            int[] scrcoords = new int[2];
            w.getLocationOnScreen(scrcoords);
            float x = (event.getRawX() + ((float) w.getLeft())) - ((float) scrcoords[0]);
            float y = (event.getRawY() + ((float) w.getTop())) - ((float) scrcoords[1]);
            Log.d("Activity", "Touch event " + event.getRawX() + "," + event.getRawY() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + x + "," + y + " rect " + w.getLeft() + "," + w.getTop() + "," + w.getRight() + "," + w.getBottom() + " coords " + scrcoords[0] + "," + scrcoords[1]);
            if (event.getAction() == 1 && (x < ((float) w.getLeft()) || x >= ((float) w.getRight()) || y < ((float) w.getTop()) || y > ((float) w.getBottom()))) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
    }
}
