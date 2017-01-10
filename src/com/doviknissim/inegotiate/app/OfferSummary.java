package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gdata.util.common.base.StringUtil;
import java.io.File;
import java.sql.SQLException;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class OfferSummary extends Activity {
    private int EDIT_CONTACT_REQUEST_SUCCESS;
    private int EDIT_OFFER_REQUEST_SUCCESS;
    private int EDIT_PRODUCT_REQUEST_SUCCESS;
    private int _buyerOrSeller;
    private final CharSequence[] _communicationsMethods;
    private String _contactIdAsString;
    private String _offerIdAsString;
    private String _productIdAsString;
    private int _selected;

    /* renamed from: com.doviknissim.inegotiate.app.OfferSummary.1 */
    class C01681 implements OnClickListener {
        C01681() {
        }

        public void onClick(View v) {
            OfferSummary.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.OfferSummary.2 */
    class C01692 implements OnClickListener {
        C01692() {
        }

        public void onClick(View v) {
            OfferSummary.this.resubmit();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.OfferSummary.3 */
    class C01703 implements OnClickListener {
        C01703() {
        }

        public void onClick(View v) {
            OfferSummary.this.editProduct();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.OfferSummary.4 */
    class C01714 implements OnClickListener {
        C01714() {
        }

        public void onClick(View v) {
            OfferSummary.this.editContact();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.OfferSummary.5 */
    class C01725 implements OnClickListener {
        C01725() {
        }

        public void onClick(View v) {
            OfferSummary.this.editOffer();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.OfferSummary.6 */
    class C01736 implements OnClickListener {
        C01736() {
        }

        public void onClick(View v) {
            OfferSummary.this.seeHistory();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.OfferSummary.7 */
    class C01747 implements OnClickListener {
        C01747() {
        }

        public void onClick(View v) {
            OfferSummary.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.OfferSummary.8 */
    class C01758 implements DialogInterface.OnClickListener {
        C01758() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
            OfferSummary.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.OfferSummary.9 */
    class C01769 implements DialogInterface.OnClickListener {
        C01769() {
        }

        public void onClick(DialogInterface dialog, int which) {
            if (which == 0) {
                Intent nfcIntent = new Intent("android.intent.action.INEGOTIATENFC");
                nfcIntent.putExtra("offerId", OfferSummary.this._offerIdAsString);
                OfferSummary.this.startActivity(nfcIntent);
                return;
            }
            Log.i("DOVIK", "[INFO] selected Do Not Communicate");
        }
    }

    public OfferSummary() {
        this._productIdAsString = StringUtil.EMPTY_STRING;
        this._contactIdAsString = StringUtil.EMPTY_STRING;
        this._offerIdAsString = StringUtil.EMPTY_STRING;
        this.EDIT_PRODUCT_REQUEST_SUCCESS = 173;
        this.EDIT_CONTACT_REQUEST_SUCCESS = 373;
        this.EDIT_OFFER_REQUEST_SUCCESS = 737;
        this._communicationsMethods = new CharSequence[]{"NFC", "Do not communicate"};
        this._selected = 0;
        this._buyerOrSeller = 0;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.summary);
        ((Button) findViewById(C0185R.id.button1)).setOnClickListener(new C01681());
        ((Button) findViewById(C0185R.id.button2)).setOnClickListener(new C01692());
        ((ImageView) findViewById(C0185R.id.editProduct)).setOnClickListener(new C01703());
        ((ImageView) findViewById(C0185R.id.editContact)).setOnClickListener(new C01714());
        ((ImageView) findViewById(C0185R.id.editOffer)).setOnClickListener(new C01725());
        ((TextView) findViewById(C0185R.id.seehistory)).setOnClickListener(new C01736());
        ((ImageView) findViewById(C0185R.id.backImageButton)).setOnClickListener(new C01747());
        populate();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void populate() {
        populateOffer();
        populateProduct();
        populateContact();
    }

    private void populateOffer() {
        this._offerIdAsString = getIntent().getExtras().getString("offerId");
        if (this._offerIdAsString != null) {
            if (this._offerIdAsString.length() != 0) {
                DBAdapter db = new DBAdapter(this);
                try {
                    db.open();
                    Cursor c = db.getOffer(Long.valueOf(this._offerIdAsString).longValue());
                    if (c == null || c.getCount() == 0) {
                        Log.i("iNegotiate", "[INFO] Failed to find the offer in the database");
                        showDialog(0);
                        return;
                    }
                    c.moveToFirst();
                    this._productIdAsString = c.getString(1);
                    if (this._productIdAsString != null) {
                        if (this._productIdAsString.length() != 0) {
                            this._contactIdAsString = c.getString(2);
                            if (this._contactIdAsString != null) {
                                if (this._contactIdAsString.length() != 0) {
                                    this._buyerOrSeller = c.getInt(8);
                                    String amount = c.getString(5);
                                    if (amount == null || amount.length() == 0) {
                                        amount = StringUtil.EMPTY_STRING;
                                    }
                                    String currency = c.getString(7);
                                    if (currency == null || currency.length() == 0) {
                                        currency = StringUtil.EMPTY_STRING;
                                    }
                                    amount = new StringBuilder(String.valueOf(amount)).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(currency).toString();
                                    TextView amountTV = (TextView) findViewById(C0185R.id.offerTitle);
                                    if (this._buyerOrSeller == 0) {
                                        amountTV.setText("Received offer: " + amount);
                                        amountTV.setTextColor(Color.parseColor("#ff9900"));
                                    } else {
                                        amountTV.setText("Sent offer: " + amount);
                                    }
                                    String statusCode = c.getString(6);
                                    String status = OfferStatus.displayStatus(statusCode);
                                    Log.d("iNegotiate", "[DEBUG] Status Code is " + statusCode + " status is: " + status);
                                    if (status == null || status.length() == 0) {
                                        status = StringUtil.EMPTY_STRING;
                                    }
                                    TextView statusTV = (TextView) findViewById(C0185R.id.offerStatus);
                                    if (this._buyerOrSeller == 0) {
                                        statusTV.setTextColor(Color.parseColor("#ff9900"));
                                    }
                                    statusTV.setText("Status: " + status);
                                    String date = c.getString(3);
                                    if (date == null || date.length() == 0) {
                                        date = StringUtil.EMPTY_STRING;
                                    }
                                    TextView dateTV = (TextView) findViewById(C0185R.id.offerDate);
                                    if (this._buyerOrSeller == 0) {
                                        dateTV.setText("Received on: " + date);
                                        dateTV.setTextColor(Color.parseColor("#ff9900"));
                                    } else {
                                        dateTV.setText("Sent on: " + date);
                                    }
                                    ImageView offerIV = (ImageView) findViewById(C0185R.id.offerIcon);
                                    offerIV.setImageBitmap(ImageUtilities.getRoundedCornerBitmap(((BitmapDrawable) offerIV.getDrawable()).getBitmap(), 20));
                                    if (this._buyerOrSeller == 0) {
                                        ((ImageView) findViewById(C0185R.id.editProduct)).setVisibility(4);
                                        ((ImageView) findViewById(C0185R.id.editContact)).setVisibility(4);
                                        ((ImageView) findViewById(C0185R.id.editOffer)).setVisibility(4);
                                    }
                                    if (this._buyerOrSeller == 0) {
                                        ((TextView) findViewById(C0185R.id.seehistory)).setTextColor(Color.parseColor("#ff9900"));
                                    }
                                    db.close();
                                    return;
                                }
                            }
                            Log.i("iNegotiate", "[INFO] Failed to find the contact Id in the database");
                            showDialog(0);
                            return;
                        }
                    }
                    Log.i("iNegotiate", "[INFO] Failed to find the product Id in the database");
                    showDialog(0);
                    return;
                } catch (SQLException e) {
                    db.close();
                    Log.e("iNegotiate", "[ERROR] exception thrown: " + e.getStackTrace().toString());
                    return;
                }
            }
        }
        Log.i("iNegotiate", "[INFO] Failed to find the offer Id in the activity's extras");
        showDialog(0);
    }

    private void populateProduct() {
        if (this._productIdAsString == null || this._productIdAsString.length() == 0) {
            Log.i("iNegotiate", "[INFO] Failed to find a valid product Id");
            showDialog(0);
            return;
        }
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            Cursor c = db.getProduct(Long.valueOf(this._productIdAsString).longValue());
            if (c == null || c.getCount() == 0) {
                Log.i("iNegotiate", "[INFO] Failed to find the product in the database");
                showDialog(0);
                return;
            }
            c.moveToFirst();
            String productName = c.getString(1);
            if (productName == null || productName.length() == 0) {
                productName = StringUtil.EMPTY_STRING;
            }
            TextView productNameTV = (TextView) findViewById(C0185R.id.productTitle);
            productNameTV.setText("Item: " + productName);
            if (this._buyerOrSeller == 0) {
                productNameTV.setTextColor(Color.parseColor("#ff9900"));
            }
            String description = c.getString(2);
            if (description == null || description.length() == 0) {
                description = StringUtil.EMPTY_STRING;
            }
            TextView descriptionTV = (TextView) findViewById(C0185R.id.productDescription);
            descriptionTV.setText("Description: " + description);
            if (this._buyerOrSeller == 0) {
                descriptionTV.setTextColor(Color.parseColor("#ff9900"));
            }
            String url = c.getString(3);
            if (!(url == null || url.equals(StringUtil.EMPTY_STRING))) {
                File imgFile = new File(url);
                if (imgFile.exists()) {
                    ((ImageView) findViewById(C0185R.id.productIcon)).setImageBitmap(ImageUtilities.getRoundedCornerBitmap(BitmapFactory.decodeFile(imgFile.getAbsolutePath()), 20));
                }
            }
            db.close();
        } catch (SQLException e) {
            db.close();
            Log.e("iNegotiate", "[ERROR] exception thrown: " + e.getMessage());
        }
    }

    private void populateContact() {
        if (this._contactIdAsString != null) {
            if (this._contactIdAsString.length() != 0) {
                DBAdapter db = new DBAdapter(this);
                try {
                    db.open();
                    Cursor c = db.getContact(Long.valueOf(this._contactIdAsString).longValue());
                    if (c == null || c.getCount() == 0) {
                        Log.i("iNegotiate", "[INFO] Failed to find the contact in the database");
                        showDialog(0);
                        return;
                    }
                    c.moveToFirst();
                    String contactName = c.getString(1);
                    if (contactName == null || contactName.length() == 0) {
                        contactName = StringUtil.EMPTY_STRING;
                    }
                    TextView contactNameTV = (TextView) findViewById(C0185R.id.contactTitle);
                    if (this._buyerOrSeller == 0) {
                        contactNameTV.setText("Sent by:  " + contactName);
                        contactNameTV.setTextColor(Color.parseColor("#ff9900"));
                    } else {
                        contactNameTV.setText("Sent to:  " + contactName);
                    }
                    String email = c.getString(5);
                    if (email == null || email.length() == 0) {
                        email = "E-mail: ";
                    }
                    TextView emailTV = (TextView) findViewById(C0185R.id.contactEmail);
                    if (this._buyerOrSeller == 0) {
                        emailTV.setTextColor(Color.parseColor("#ff9900"));
                    }
                    emailTV.setText("E-mail: " + email);
                    String cell = c.getString(4);
                    if (cell == null || cell.length() == 0) {
                        cell = "Cell: ";
                    }
                    TextView cellTV = (TextView) findViewById(C0185R.id.contactCell);
                    if (this._buyerOrSeller == 0) {
                        cellTV.setTextColor(Color.parseColor("#ff9900"));
                    }
                    cellTV.setText("Cell: " + cell);
                    String url = c.getString(3);
                    if (!(url == null || url.equals(StringUtil.EMPTY_STRING))) {
                        File imgFile = new File(url);
                        if (imgFile.exists()) {
                            ((ImageView) findViewById(C0185R.id.contactIcon)).setImageBitmap(ImageUtilities.getRoundedCornerBitmap(BitmapFactory.decodeFile(imgFile.getAbsolutePath()), 20));
                        }
                    }
                    db.close();
                    return;
                } catch (SQLException e) {
                    db.close();
                    Log.e("iNegotiate", "[ERROR] exception thrown: " + e.getMessage());
                    return;
                }
            }
        }
        Log.i("iNegotiate", "[INFO] Failed to find a valid contact Id");
        showDialog(0);
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Aw Snap!").setMessage("An internla error occured, please try again!").setPositiveButton("Ok", new C01758()).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Offer submitted successfully!").setSingleChoiceItems(this._communicationsMethods, this._selected, new C01769()).create();
            default:
                return null;
        }
    }

    protected void onResume() {
        super.onResume();
    }

    private void editProduct() {
        Intent editProductIntent = new Intent("android.intent.action.EDITPRODUCT");
        editProductIntent.putExtra("offerId", this._offerIdAsString);
        startActivityForResult(editProductIntent, this.EDIT_PRODUCT_REQUEST_SUCCESS);
    }

    private void editContact() {
        Intent editContactIntent = new Intent("android.intent.action.EDITCONTACT");
        editContactIntent.putExtra("offerId", this._offerIdAsString);
        startActivityForResult(editContactIntent, this.EDIT_CONTACT_REQUEST_SUCCESS);
    }

    private void editOffer() {
        Intent editOfferIntent = new Intent("android.intent.action.EDITOFFER");
        editOfferIntent.putExtra("offerId", this._offerIdAsString);
        startActivityForResult(editOfferIntent, this.EDIT_OFFER_REQUEST_SUCCESS);
    }

    private void seeHistory() {
        Intent seeHistoryIntent = new Intent("android.intent.action.OFFERHISTORY");
        seeHistoryIntent.putExtra("offerId", this._offerIdAsString);
        startActivity(seeHistoryIntent);
    }

    private void resubmit() {
        showDialog(1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == this.EDIT_PRODUCT_REQUEST_SUCCESS && resultCode == -1) {
            startActivity(getIntent());
            finish();
        }
        if (requestCode == this.EDIT_CONTACT_REQUEST_SUCCESS && resultCode == -1) {
            startActivity(getIntent());
            finish();
        }
        if (requestCode == this.EDIT_OFFER_REQUEST_SUCCESS && resultCode == -1) {
            startActivity(getIntent());
            finish();
        }
    }
}
