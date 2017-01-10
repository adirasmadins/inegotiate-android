package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.gdata.util.common.base.StringUtil;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class EditOffer extends Activity {
    private static String OFFER_STATUS_NEW;
    private static String _contactIdAsString;
    private static boolean _contactMe;
    private static long _counterpartId;
    private static long _iAmTheBuyer;
    private static long _offerId;
    private static String _productIdAsString;
    private static long _selectedAmount;
    private static String _selectedCurrency;
    private static String _selectedValidThroughDate;
    private final CharSequence[] _communicationsMethods;
    private int _selected;
    String[] iso4217WithoutViaLocales;
    private SharedPreferences prefs;
    String[] viaLocales;

    /* renamed from: com.doviknissim.inegotiate.app.EditOffer.1 */
    class C01321 implements OnClickListener {
        C01321() {
        }

        public void onClick(View v) {
            EditOffer.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.EditOffer.2 */
    class C01332 implements OnClickListener {
        C01332() {
        }

        public void onClick(View v) {
            EditOffer.this.edit();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.EditOffer.3 */
    class C01343 implements DialogInterface.OnClickListener {
        C01343() {
        }

        public void onClick(DialogInterface dialog, int which) {
            if (which == 0) {
                Intent nfcIntent = new Intent("android.intent.action.INEGOTIATENFC");
                nfcIntent.putExtra("offerId", EditOffer._offerId);
                EditOffer.this.startActivity(nfcIntent);
                return;
            }
            Log.i("DOVIK", "[INFO] selected Do Not Communicate");
        }
    }

    public EditOffer() {
        this.viaLocales = new String[]{"USD", "JPY", "CNY", "SDG", "RON", "MKD", "MXN", "CAD", "ZAR", "AUD", "NOK", "ILS", "ISK", "SYP", "LYD", "UYU", "YER", "CSD", "EEK", "THB", "IDR", "LBP", "AED", "BOB", "QAR", "BHD", "HNL", "HRK", "COP", "ALL", "DKK", "MYR", "SEK", "RSD", "BGN", "DOP", "KRW", "LVL", "VEF", "CZK", "TND", "KWD", "VND", "JOD", "NZD", "PAB", "CLP", "PEN", "GBP", "DZD", "CHF", "RUB", "UAH", "ARS", "SAR", "EGP", "INR", "PYG", "TWD", "TRY", "BAM", "OMR", "SGD", "MAD", "BYR", "NIO", "HKD", "LTL", "SKK", "GTQ", "BRL", "EUR", "HUF", "IQD", "CRC", "PHP", "SVC", "PLN"};
        this.iso4217WithoutViaLocales = new String[]{"XBB", "XBC", "XBD", "UGX", "MOP", "SHP", "TTD", "UYI", "KGS", "DJF", "BTN", "XBA", "HTG", "BBD", "XAU", "FKP", "MWK", "PGK", "XCD", "COU", "RWF", "NGN", "BSD", "XTS", "TMT", "GEL", "VUV", "FJD", "MVR", "AZN", "MNT", "MGA", "WST", "KMF", "GNF", "SBD", "BDT", "MMK", "TJS", "CVE", "MDL", "KES", "SRD", "LRD", "MUR", "CDF", "BMD", "USN", "CUP", "USS", "GMD", "UZS", "CUC", "ZMK", "NPR", "NAD", "LAK", "SZL", "XDR", "BND", "TZS", "MXV", "LSL", "KYD", "LKR", "ANG", "PKR", "SLL", "SCR", "GHS", "ERN", "BOV", "GIP", "IRR", "XPT", "BWP", "XFU", "CLF", "ETB", "STD", "XXX", "XPD", "AMD", "XPF", "JMD", "MRO", "BIF", "CHW", "ZWL", "AWG", "MZN", "CHE", "XOF", "KZT", "BZD", "XAG", "KHR", "XAF", "GYD", "AFN", "SOS", "TOP", "AOA", "KPW"};
        this._communicationsMethods = new CharSequence[]{"NFC", "Do not communicate"};
        this._selected = 0;
    }

    static {
        _selectedAmount = 0;
        _selectedCurrency = null;
        _contactMe = false;
        _offerId = 0;
        _iAmTheBuyer = 1;
        _counterpartId = 0;
        _selectedValidThroughDate = StringUtil.EMPTY_STRING;
        OFFER_STATUS_NEW = "sent.new";
        _contactIdAsString = StringUtil.EMPTY_STRING;
        _productIdAsString = StringUtil.EMPTY_STRING;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.editoffer);
        ((Button) findViewById(C0185R.id.button31)).setOnClickListener(new C01321());
        ((Button) findViewById(C0185R.id.button32)).setOnClickListener(new C01332());
        Spinner spinner = (Spinner) findViewById(C0185R.id.spinner1);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter(this, 17367048, this.viaLocales);
        dataAdapter.setDropDownViewResource(17367049);
        spinner.setAdapter(dataAdapter);
        ((EditText) findViewById(C0185R.id.editText11)).setHint(new SimpleDateFormat("MMM-dd-yyyy").format(Calendar.getInstance().getTime()));
        String offerIdAsString = getIntent().getExtras().getString("offerId");
        if (offerIdAsString == null || offerIdAsString.length() == 0) {
            showDialog(2);
            return;
        }
        _offerId = Long.valueOf(offerIdAsString).longValue();
        populate(offerIdAsString);
    }

    private void populate(String offerIdAsString) {
        if (offerIdAsString == null || offerIdAsString.length() == 0) {
            Log.i("iNegotiate", "[INFO] Failed to find a valid offer Id");
            showDialog(0);
            return;
        }
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            Cursor cOffer = db.getOffer(Long.valueOf(_offerId).longValue());
            if (cOffer == null || cOffer.getCount() == 0) {
                Log.e("iNegotiate", "[ERROR] Failed to find the offer object in the database");
                showDialog(0);
                db.close();
                return;
            }
            cOffer.moveToFirst();
            String amount = cOffer.getString(5);
            if (amount == null || amount.length() == 0) {
                amount = StringUtil.EMPTY_STRING;
            }
            ((TextView) findViewById(C0185R.id.editText31)).setText(amount);
            String currency = cOffer.getString(7);
            if (currency == null || currency.length() == 0) {
                currency = StringUtil.EMPTY_STRING;
            }
            Spinner currencySpinner = (Spinner) findViewById(C0185R.id.spinner1);
            String duedate = cOffer.getString(4);
            if (duedate == null || duedate.length() == 0) {
                duedate = StringUtil.EMPTY_STRING;
            }
            ((TextView) findViewById(C0185R.id.editText11)).setText(duedate);
            ((CheckBox) findViewById(C0185R.id.checkBox1)).setChecked(true);
            _productIdAsString = cOffer.getString(1);
            _contactIdAsString = cOffer.getString(2);
            db.close();
        } catch (SQLException e) {
            db.close();
            Log.e("iNegotiate", "[ERROR] exception thrown: " + e.getStackTrace().toString());
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void edit() {
        if (validateInput()) {
            saveData();
            moveOn();
        }
    }

    private boolean validateInput() {
        EditText amountEditText = (EditText) findViewById(C0185R.id.editText31);
        if (amountEditText.getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(0);
            return false;
        }
        _selectedAmount = new Long(amountEditText.getText().toString()).longValue();
        _selectedCurrency = ((Spinner) findViewById(C0185R.id.spinner1)).getSelectedItem().toString();
        if (((CheckBox) findViewById(C0185R.id.checkBox1)).isChecked()) {
            _contactMe = true;
        }
        _selectedValidThroughDate = ((EditText) findViewById(C0185R.id.editText11)).getText().toString();
        return true;
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Invalid input!").setMessage("Please enter a meaningful amount").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Invalid input!").setMessage("Please enter a meaningful Email Address for the contact").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new Builder(this).setTitle("Offer submitted successfully!").setSingleChoiceItems(this._communicationsMethods, this._selected, new C01343()).create();
            default:
                return null;
        }
    }

    private void saveData() {
        Bundle extras = getIntent().getExtras();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");
        String formattedDate = simpleDateFormat.format(c.getTime());
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            db.updateOffer(_offerId, _productIdAsString, _contactIdAsString, formattedDate, _selectedValidThroughDate, new Long(_selectedAmount).toString(), OfferStatus.SENT_AND_UPDATED_OFFER.getStatusDbCode(), _selectedCurrency, _iAmTheBuyer, _counterpartId, new Boolean(_contactMe).toString());
            setActiveOfferId(new Long(_offerId).toString());
            db.close();
        } catch (SQLException e) {
            Log.e("DOVIK", "[ERROR] Exception Thrown while inserting offer: " + e.toString());
        }
    }

    private void moveOn() {
        setResult(-1);
        finish();
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

    private String getActiveOfferId() {
        this.prefs = getSharedPreferences("bargain-preferences", 0);
        return this.prefs.getString("ActiveOfferId", null);
    }

    private void setActiveOfferId(String id) {
        this.prefs = getSharedPreferences("bargain-preferences", 0);
        Editor editor = this.prefs.edit();
        editor.putString("ActiveOfferId", id);
        editor.commit();
    }
}
