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
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class Offer extends Activity {
    private static String OFFER_STATUS_NEW;
    private static boolean _contactMe;
    private static long _iAmTheBuyer;
    private static long _newOfferId;
    private static String _offerHistory;
    private static long _selectedAmount;
    private static String _selectedCurrency;
    private static String _selectedValidThroughDate;
    private int EMAIL_REQUEST;
    private final CharSequence[] _communicationsMethods;
    private String _recepientEmail;
    private String _recepientName;
    private int _selected;
    private int day;
    String[] iso4217WithoutViaLocales;
    private int month;
    private SharedPreferences prefs;
    String[] viaLocales;
    private int year;

    /* renamed from: com.doviknissim.inegotiate.app.Offer.1 */
    class C01561 implements OnClickListener {
        C01561() {
        }

        public void onClick(View v) {
            Offer.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Offer.2 */
    class C01572 implements OnClickListener {
        C01572() {
        }

        public void onClick(View v) {
            Offer.this.next();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Offer.3 */
    class C01583 implements OnClickListener {
        private final /* synthetic */ TextView val$validThroughTV;

        C01583(TextView textView) {
            this.val$validThroughTV = textView;
        }

        public void onClick(View arg0) {
            Offer.this.showDatePickerDialog(this.val$validThroughTV);
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Offer.4 */
    class C01594 implements DialogInterface.OnClickListener {
        C01594() {
        }

        public void onClick(DialogInterface dialog, int which) {
            if (which == 0) {
                Offer.this.sendEmail(Offer.this._recepientName, Offer.this._recepientEmail);
            } else {
                Log.i("iNegotiate", "[INFO] User selected not to communicate the offer");
            }
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Offer.5 */
    class C01605 implements DialogInterface.OnClickListener {
        C01605() {
        }

        public void onClick(DialogInterface dialog, int which) {
            Offer.this.startActivity(new Intent("android.intent.action.SETTINGS"));
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Offer.6 */
    class C01616 implements DialogInterface.OnClickListener {
        C01616() {
        }

        public void onClick(DialogInterface dialog, int which) {
            Offer.this.startActivity(new Intent("android.intent.action.SETTINGS"));
        }
    }

    public Offer() {
        this.viaLocales = new String[]{"USD", "JPY", "CNY", "SDG", "RON", "MKD", "MXN", "CAD", "ZAR", "AUD", "NOK", "ILS", "ISK", "SYP", "LYD", "UYU", "YER", "CSD", "EEK", "THB", "IDR", "LBP", "AED", "BOB", "QAR", "BHD", "HNL", "HRK", "COP", "ALL", "DKK", "MYR", "SEK", "RSD", "BGN", "DOP", "KRW", "LVL", "VEF", "CZK", "TND", "KWD", "VND", "JOD", "NZD", "PAB", "CLP", "PEN", "GBP", "DZD", "CHF", "RUB", "UAH", "ARS", "SAR", "EGP", "INR", "PYG", "TWD", "TRY", "BAM", "OMR", "SGD", "MAD", "BYR", "NIO", "HKD", "LTL", "SKK", "GTQ", "BRL", "EUR", "HUF", "IQD", "CRC", "PHP", "SVC", "PLN"};
        this.iso4217WithoutViaLocales = new String[]{"XBB", "XBC", "XBD", "UGX", "MOP", "SHP", "TTD", "UYI", "KGS", "DJF", "BTN", "XBA", "HTG", "BBD", "XAU", "FKP", "MWK", "PGK", "XCD", "COU", "RWF", "NGN", "BSD", "XTS", "TMT", "GEL", "VUV", "FJD", "MVR", "AZN", "MNT", "MGA", "WST", "KMF", "GNF", "SBD", "BDT", "MMK", "TJS", "CVE", "MDL", "KES", "SRD", "LRD", "MUR", "CDF", "BMD", "USN", "CUP", "USS", "GMD", "UZS", "CUC", "ZMK", "NPR", "NAD", "LAK", "SZL", "XDR", "BND", "TZS", "MXV", "LSL", "KYD", "LKR", "ANG", "PKR", "SLL", "SCR", "GHS", "ERN", "BOV", "GIP", "IRR", "XPT", "BWP", "XFU", "CLF", "ETB", "STD", "XXX", "XPD", "AMD", "XPF", "JMD", "MRO", "BIF", "CHW", "ZWL", "AWG", "MZN", "CHE", "XOF", "KZT", "BZD", "XAG", "KHR", "XAF", "GYD", "AFN", "SOS", "TOP", "AOA", "KPW"};
        this._communicationsMethods = new CharSequence[]{"Send e-mail", "Do not communicate"};
        this._selected = 0;
        this.EMAIL_REQUEST = 573;
        this._recepientName = StringUtil.EMPTY_STRING;
        this._recepientEmail = StringUtil.EMPTY_STRING;
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    static {
        _selectedAmount = 0;
        _selectedCurrency = null;
        _contactMe = false;
        _newOfferId = 0;
        _iAmTheBuyer = 1;
        _offerHistory = "-1|-1|-1";
        _selectedValidThroughDate = StringUtil.EMPTY_STRING;
        OFFER_STATUS_NEW = "sent.new";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.offer);
        ((Button) findViewById(C0185R.id.button31)).setOnClickListener(new C01561());
        ((Button) findViewById(C0185R.id.button32)).setOnClickListener(new C01572());
        Spinner spinner = (Spinner) findViewById(C0185R.id.spinner1);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter(this, 17367048, this.viaLocales);
        dataAdapter.setDropDownViewResource(17367049);
        spinner.setAdapter(dataAdapter);
        setCurrentDateOnView();
        setDateOnDateClickListener();
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
        validThroughTV.setOnClickListener(new C01583(validThroughTV));
    }

    public void showDatePickerDialog(TextView v) {
        new DatePickerFragment(v).show(getFragmentManager(), "datePicker");
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void next() {
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
        return true;
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Invalid input!").setMessage("Please enter a meaningful amount").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Invalid input!").setMessage("Please enter a meaningful Email Address for the contact").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new Builder(this).setTitle("Offer submitted successfully!").setSingleChoiceItems(this._communicationsMethods, this._selected, new C01594()).create();
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return new Builder(this).setTitle("Aww! snap ").setMessage("Your contact name is missing,  please provide your contact name via the Settings page.").setPositiveButton("OK", new C01605()).create();
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                return new Builder(this).setTitle("Aww! snap ").setMessage("Your email is missing,  please provide your email via the Settings page.").setPositiveButton("OK", new C01616()).create();
            default:
                return null;
        }
    }

    private void saveData() {
        Bundle extras = getIntent().getExtras();
        long productId = new Long(extras.getString("productId")).longValue();
        long contactId = new Long(extras.getString("contactId")).longValue();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");
        String formattedDate = simpleDateFormat.format(c.getTime());
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            _newOfferId = db.insertOffer(productId, contactId, formattedDate, _selectedValidThroughDate, _selectedAmount, OFFER_STATUS_NEW, _selectedCurrency, _iAmTheBuyer, _offerHistory, new Boolean(_contactMe).toString());
            setActiveOfferId(new Long(_newOfferId).toString());
            Cursor cContact = db.getContact(contactId);
            cContact.moveToFirst();
            this._recepientName = cContact.getString(1);
            this._recepientEmail = cContact.getString(5);
            db.close();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] Exception Thrown while inserting offer: " + e.toString());
        }
    }

    private void moveOn() {
        showDialog(2);
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

    private void sendEmail(String recepientName, String recipientEmail) {
        Intent emailIntent = new Intent("android.intent.action.SEND");
        emailIntent.putExtra("android.intent.extra.EMAIL", new String[]{recipientEmail});
        emailIntent.putExtra("android.intent.extra.SUBJECT", "You've received a new offer via iNegotiate!");
        emailIntent.setType(Mimetypes.MIMETYPE_HTML);
        emailIntent.putExtra("android.intent.extra.TEXT", Html.fromHtml("<!DOCTYPE html><html><body><br>Dear " + recepientName + ",<br><br>" + "Congratulations! <br><br>" + "You have received a new offer via iNegotiate - an Android Application that provides an advanced platform for a buyer and a seller to negotiate the price of a product, service, or experience  in a convenient and a discrete manner. <br>" + "Please " + "<a href=\"https://play.google.com/store/apps/details?id=com.doviknissim.inegotiate.app/" + "\">" + "click here</a> to download iNegotiate <br>" + "Please " + "<a href=\"http://inegotiate.blogspot.com/get/" + getOfferPayloadForEmail() + "\">" + "click here</a> to view your new offer," + "<br><br>Warm regards,<br>" + "<a href=\"http://inegotiate.blogspot.com" + "\">" + "The iNegotiate team</a>" + "</body></html>"));
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
                Log.e("iNegotitate", "[ERROR] Failed to get Offer for Id=" + _newOfferId);
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
            payload.append("method=").append(Method.EMAIL).append("/").append("contactName=").append(cName).append("/").append("contactEmail=").append(cEmail).append("/").append("contactCell=").append(prefs.getString("INEGOTIATE_CELL", StringUtil.EMPTY_STRING)).append("/").append("myid=").append(_newOfferId).append("/").append("date=").append(cOffer.getString(3)).append("/").append("duedate=").append(cOffer.getString(4)).append("/").append("amount=").append(cOffer.getInt(5)).append("/").append("currency=").append(cOffer.getString(7)).append("/").append("buyerseller=").append(cOffer.getInt(4)).append("/").append("contactme=").append(cOffer.getString(10)).append("/").append("history=").append(cOffer.getString(9)).append("/").append("item=").append(cProduct.getString(1)).append("/");
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
            Log.e("iNegotiate", "[ERROR] A databased error occured while building the Email message " + e.getMessage());
            db.close();
            return null;
        }
    }
}
