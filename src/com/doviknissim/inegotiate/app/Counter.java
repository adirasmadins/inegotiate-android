package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Html;
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
import com.amazonaws.services.s3.internal.Mimetypes;
import com.google.gdata.model.gd.Reminder.Method;
import com.google.gdata.util.common.base.StringUtil;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

public class Counter extends Activity {
    private static boolean _contactMe;
    private static String _counteredOfferId;
    private static long _newCounterpartId;
    private static long _newOfferId;
    private static String _newOfferIdAsString;
    private static long _selectedAmount;
    private static String _selectedCurrency;
    private static String _selectedValidThroughDate;
    private int EMAIL_REQUEST;
    private final CharSequence[] _communicationsMethods;
    private String _recipientEmail;
    private String _recipientName;
    private int _selected;
    private int day;
    String[] iso4217WithoutViaLocales;
    private int month;
    String[] viaLocales;
    private int year;

    /* renamed from: com.doviknissim.inegotiate.app.Counter.1 */
    class C01221 implements OnClickListener {
        C01221() {
        }

        public void onClick(View v) {
            Counter.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Counter.2 */
    class C01232 implements OnClickListener {
        C01232() {
        }

        public void onClick(View v) {
            Counter.this.counter();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Counter.3 */
    class C01243 implements OnClickListener {
        private final /* synthetic */ TextView val$validThroughTV;

        C01243(TextView textView) {
            this.val$validThroughTV = textView;
        }

        public void onClick(View arg0) {
            Counter.this.showDatePickerDialog(this.val$validThroughTV);
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Counter.4 */
    class C01254 implements DialogInterface.OnClickListener {
        C01254() {
        }

        public void onClick(DialogInterface dialog, int which) {
            if (which == 0) {
                Intent nfcIntent = new Intent("android.intent.action.INEGOTIATENFC");
                nfcIntent.putExtra("offerId", Counter._newOfferIdAsString);
                Counter.this.startActivity(nfcIntent);
            } else if (which == 1) {
                Counter.this.sendCounterEmail(Counter.this._recipientName, Counter.this._recipientEmail);
            } else {
                Log.i("iNegotiate", "[INFO] User selected not to communicate the offer");
            }
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Counter.5 */
    class C01265 implements DialogInterface.OnClickListener {
        C01265() {
        }

        public void onClick(DialogInterface arg0, int arg1) {
            Counter.this.startActivity(new Intent("android.intent.action.WINDOWS"));
        }
    }

    public Counter() {
        this.viaLocales = new String[]{"USD", "JPY", "CNY", "SDG", "RON", "MKD", "MXN", "CAD", "ZAR", "AUD", "NOK", "ILS", "ISK", "SYP", "LYD", "UYU", "YER", "CSD", "EEK", "THB", "IDR", "LBP", "AED", "BOB", "QAR", "BHD", "HNL", "HRK", "COP", "ALL", "DKK", "MYR", "SEK", "RSD", "BGN", "DOP", "KRW", "LVL", "VEF", "CZK", "TND", "KWD", "VND", "JOD", "NZD", "PAB", "CLP", "PEN", "GBP", "DZD", "CHF", "RUB", "UAH", "ARS", "SAR", "EGP", "INR", "PYG", "TWD", "TRY", "BAM", "OMR", "SGD", "MAD", "BYR", "NIO", "HKD", "LTL", "SKK", "GTQ", "BRL", "EUR", "HUF", "IQD", "CRC", "PHP", "SVC", "PLN"};
        this.iso4217WithoutViaLocales = new String[]{"XBB", "XBC", "XBD", "UGX", "MOP", "SHP", "TTD", "UYI", "KGS", "DJF", "BTN", "XBA", "HTG", "BBD", "XAU", "FKP", "MWK", "PGK", "XCD", "COU", "RWF", "NGN", "BSD", "XTS", "TMT", "GEL", "VUV", "FJD", "MVR", "AZN", "MNT", "MGA", "WST", "KMF", "GNF", "SBD", "BDT", "MMK", "TJS", "CVE", "MDL", "KES", "SRD", "LRD", "MUR", "CDF", "BMD", "USN", "CUP", "USS", "GMD", "UZS", "CUC", "ZMK", "NPR", "NAD", "LAK", "SZL", "XDR", "BND", "TZS", "MXV", "LSL", "KYD", "LKR", "ANG", "PKR", "SLL", "SCR", "GHS", "ERN", "BOV", "GIP", "IRR", "XPT", "BWP", "XFU", "CLF", "ETB", "STD", "XXX", "XPD", "AMD", "XPF", "JMD", "MRO", "BIF", "CHW", "ZWL", "AWG", "MZN", "CHE", "XOF", "KZT", "BZD", "XAG", "KHR", "XAF", "GYD", "AFN", "SOS", "TOP", "AOA", "KPW"};
        this._communicationsMethods = new CharSequence[]{"NFC", "Send e-mail", "Do not communicate"};
        this._selected = 0;
        this.EMAIL_REQUEST = 473;
        this._recipientName = StringUtil.EMPTY_STRING;
        this._recipientEmail = StringUtil.EMPTY_STRING;
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    static {
        _selectedAmount = 0;
        _selectedCurrency = StringUtil.EMPTY_STRING;
        _contactMe = false;
        _selectedValidThroughDate = StringUtil.EMPTY_STRING;
        _counteredOfferId = StringUtil.EMPTY_STRING;
        _newOfferIdAsString = StringUtil.EMPTY_STRING;
        _newOfferId = 0;
        _newCounterpartId = -1;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.counter);
        ((Button) findViewById(C0185R.id.button31)).setOnClickListener(new C01221());
        ((Button) findViewById(C0185R.id.button32)).setOnClickListener(new C01232());
        Spinner spinner = (Spinner) findViewById(C0185R.id.spinner1);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter(this, 17367048, this.viaLocales);
        dataAdapter.setDropDownViewResource(17367049);
        spinner.setAdapter(dataAdapter);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
        c.add(2, 1);
        String formattedDate = df.format(c.getTime());
        setCurrentDateOnView();
        setDateOnDateClickListener();
        _counteredOfferId = getIntent().getExtras().getString("offerId");
        setAmountAsHint(_counteredOfferId);
    }

    private void setCurrentDateOnView() {
        TextView validThroughTV = (TextView) findViewById(C0185R.id.editText11);
        Calendar c = Calendar.getInstance();
        c.add(2, 1);
        this.year = c.get(1);
        this.month = c.get(2);
        this.day = c.get(5);
        String formattedDate = new SimpleDateFormat("MMM-dd-yyyy").format(c.getTime());
        validThroughTV.setHint(formattedDate);
        _selectedValidThroughDate = formattedDate;
    }

    private void setDateOnDateClickListener() {
        TextView validThroughTV = (TextView) findViewById(C0185R.id.editText11);
        validThroughTV.setOnClickListener(new C01243(validThroughTV));
    }

    public void showDatePickerDialog(TextView v) {
        new DatePickerFragment(v).show(getFragmentManager(), "datePicker");
    }

    private void counter() {
        if (validate()) {
            performCounter();
            moveOn();
        }
    }

    private boolean validate() {
        EditText amountEditText = (EditText) findViewById(C0185R.id.editText31);
        if (amountEditText.getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(0);
            return false;
        }
        _selectedAmount = new Long(amountEditText.getText().toString()).longValue();
        _selectedCurrency = ((Spinner) findViewById(C0185R.id.spinner1)).getSelectedItem().toString();
        if (((CheckBox) findViewById(C0185R.id.checkBox1)).isChecked()) {
            _contactMe = true;
        } else {
            _contactMe = false;
        }
        return true;
    }

    private void performCounter() {
        Bundle extras = getIntent().getExtras();
        _counteredOfferId = extras.getString("offerId");
        if (_counteredOfferId == null) {
            Log.e("iNegotiate", "[ERROR] Could not find the countered offer in the database!");
            showDialog(3);
            return;
        }
        Calendar cldr = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");
        String formattedDate = simpleDateFormat.format(cldr.getTime());
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            Cursor cOffer = db.getOfferByID(_counteredOfferId);
            if (cOffer == null || cOffer.getCount() != 1) {
                showDialog(3);
                Log.e("iNegotiate", "[ERROR] Could not find the original offer in the database!");
                db.close();
                return;
            }
            cOffer.moveToFirst();
            long contactId = cOffer.getLong(2);
            Cursor cContact = db.getContact(contactId);
            if (cContact == null || cContact.getCount() == 0) {
                showDialog(3);
                Log.e("iNegotiate", "[ERROR] Could not find information about the sender of the original offer");
                db.close();
                return;
            }
            long amITheBuyerOrSellerInCurrentOffer;
            cContact.moveToFirst();
            this._recipientName = cContact.getString(1);
            this._recipientEmail = cContact.getString(5);
            long previousCounterId = cOffer.getLong(9);
            if (previousCounterId == -1) {
                _newCounterpartId = new Long(_counteredOfferId).longValue();
            } else {
                _newCounterpartId = previousCounterId;
            }
            String historyOnPreviousOffer = cOffer.getString(9);
            String historyForNewOffer = constructHistoricDataForNewOffer(_counteredOfferId, historyOnPreviousOffer);
            if (cOffer.getLong(8) == 0) {
                amITheBuyerOrSellerInCurrentOffer = 1;
            } else {
                amITheBuyerOrSellerInCurrentOffer = 0;
            }
            _newOfferId = db.insertOffer(cOffer.getLong(1), contactId, formattedDate, _selectedValidThroughDate, _selectedAmount, OfferStatus.SENT_NEW_OFFER.getStatusDbCode(), _selectedCurrency, amITheBuyerOrSellerInCurrentOffer, historyForNewOffer, new Boolean(_contactMe).toString());
            db.close();
            updateHistoricDataOnPreviousOffer(_counteredOfferId, new Long(_newOfferId).toString(), historyOnPreviousOffer);
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] An Exception was thrown while inserting a counter offer to the database!" + e.getStackTrace().toString());
        }
    }

    private String constructHistoricDataForNewOffer(String previousOfferId, String historyOnPreviousOffer) {
        if (historyOnPreviousOffer == null || historyOnPreviousOffer.length() == 0) {
            return new StringBuilder(String.valueOf(previousOfferId)).append("|-1|-1").toString();
        }
        return new StringBuilder(String.valueOf(previousOfferId)).append("|").append("-1").append("|").append(historyOnPreviousOffer.split("|")[2]).toString();
    }

    private void updateHistoricDataOnPreviousOffer(String previousOfferId, String nextOfferId, String historyOnPreviousOffer) {
        if (nextOfferId != null && nextOfferId.length() != 0) {
            String[] historyArr = historyOnPreviousOffer.split("|");
            String updatedHistory = historyArr[0] + "|" + nextOfferId + "|" + historyArr[2];
            DBAdapter db = new DBAdapter(this);
            try {
                db.open();
                db.updateOfferHistory(new Long(previousOfferId).longValue(), updatedHistory);
                db.close();
            } catch (SQLException e) {
                Log.e("iNegotiate", "[ERROR] Failed to update history for previous offer, exception: " + e.getStackTrace().toString());
            }
        }
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Invalid input!").setMessage("Please enter a meaningful amount").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Invalid input!").setMessage("Please enter a meaningful expiration date for your offer").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new Builder(this).setTitle("Offer submitted successfully!").setSingleChoiceItems(this._communicationsMethods, this._selected, new C01254()).create();
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return new Builder(this).setTitle("Aww Snap!").setMessage("An Internal error has occured, please try again later").setPositiveButton("OK", new C01265()).create();
            default:
                return null;
        }
    }

    private void moveOn() {
        showDialog(2);
    }

    private void setAmountAsHint(String id) {
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            Cursor c = db.getOfferByID(id);
            c.moveToFirst();
            ((EditText) findViewById(C0185R.id.editText31)).setHint(c.getString(5));
        } catch (SQLException e) {
            Log.e("Inegotiate", "[ERROR] An exception was thrown: " + e.getStackTrace());
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
            if (event.getAction() == 1 && (x < ((float) w.getLeft()) || x >= ((float) w.getRight()) || y < ((float) w.getTop()) || y > ((float) w.getBottom()))) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
    }

    private void sendCounterEmail(String recipientName, String recipientEmail) {
        String senderName = getSharedPreferences("bargain-preferences", 0).getString("INEGOTIATE_FIRSTNAME", StringUtil.EMPTY_STRING);
        Intent emailIntent = new Intent("android.intent.action.SEND");
        emailIntent.putExtra("android.intent.extra.EMAIL", new String[]{recipientEmail});
        emailIntent.putExtra("android.intent.extra.SUBJECT", "You've received a counter offer via iNegotiate!");
        emailIntent.setType(Mimetypes.MIMETYPE_HTML);
        emailIntent.putExtra("android.intent.extra.TEXT", Html.fromHtml("<!DOCTYPE html><html><body><br>Dear " + recipientName + ",<br>" + "You've received a counter offer via iNegotiate! <br>" + "To view the details of the counter offer, please " + "<a href=\"http://inegotiate.blogspot.com/get/" + getOfferPayloadForEmail() + "\">click here</a>" + "<br><br>Warm regards,<br>The iNegotiate Team" + "</body></html>"));
        startActivityForResult(emailIntent, this.EMAIL_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        startActivity(new Intent("android.intent.action.WINDOWS"));
        finish();
    }

    private String getOfferPayloadForEmail() {
        StringBuffer payload = new StringBuffer(StringUtil.EMPTY_STRING);
        DBAdapter db = new DBAdapter(this);
        try {
            SharedPreferences prefs = getSharedPreferences("bargain-preferences", 0);
            String cName = prefs.getString("INEGOTIATE_FIRSTNAME", StringUtil.EMPTY_STRING);
            if (cName == null || cName.length() == 0) {
                showDialog(3);
                return null;
            }
            String cEmail = prefs.getString("INEGOTIATE_EMAIL", StringUtil.EMPTY_STRING);
            if (cEmail == null || cEmail.length() == 0) {
                showDialog(4);
                return null;
            }
            db.open();
            Cursor cOffer = db.getOffer(_newOfferId);
            if (cOffer == null || cOffer.getCount() == 0) {
                Log.e("iNegotitate", "[ERROR] Failed to get Offer for Id=" + _newOfferIdAsString);
                db.close();
                return null;
            }
            cOffer.moveToFirst();
            long productId = cOffer.getLong(1);
            Cursor cProduct = db.getProduct(productId);
            if (cProduct == null || cProduct.getCount() == 0) {
                Log.e("iNegotitate", "[ERROR] Failed to get Product for Id=" + productId);
                db.close();
                return null;
            }
            cProduct.moveToFirst();
            payload.append("method=").append(Method.EMAIL).append("/").append("contactName=").append(cName).append("/").append("contactEmail=").append(cEmail).append("/").append("contactCell=").append(prefs.getString("INEGOTIATE_CELL", StringUtil.EMPTY_STRING)).append("/").append("myid=").append(_newOfferIdAsString).append("/").append("date=").append(cOffer.getString(3)).append("/").append("duedate=").append(cOffer.getString(4)).append("/").append("amount=").append(cOffer.getInt(5)).append("/").append("currency=").append(cOffer.getString(7)).append("/").append("buyerseller=").append(cOffer.getInt(4)).append("/").append("contactme=").append(cOffer.getString(10)).append("/").append("history=").append(cOffer.getString(9)).append("/").append("item=").append(cProduct.getString(1)).append("/");
            String itemDescription = cProduct.getString(2);
            if (itemDescription == null) {
                itemDescription = StringUtil.EMPTY_STRING;
            }
            if (itemDescription.length() > 0) {
                itemDescription = itemDescription.replaceAll(",", StringUtil.EMPTY_STRING).replaceAll("/", StringUtil.EMPTY_STRING);
            }
            payload.append("itemDescription=").append(itemDescription).append("/");
            String awsBucket = cProduct.getString(6);
            if (awsBucket == null) {
                awsBucket = StringUtil.EMPTY_STRING;
            }
            payload.append("awsBucket=").append(awsBucket).append("/");
            String awsPicture = cProduct.getString(7);
            if (awsPicture == null) {
                awsPicture = StringUtil.EMPTY_STRING;
            }
            payload.append("awsPicture=").append(awsPicture).append("/");
            db.close();
            return payload.toString();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] A databased error occured while building the NFC message " + e.getStackTrace().toString());
            db.close();
            return null;
        }
    }
}
