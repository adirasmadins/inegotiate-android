package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gdata.util.common.base.StringUtil;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

public class ReceivedEmailHome extends Activity {
    private String _OfferAmount;
    private String _OfferBuyerOrSeller;
    private String _OfferContactMe;
    private String _OfferCurrency;
    private String _OfferDate;
    private String _OfferDueDate;
    private String _OfferHistory;
    private String _OfferIdForNegotiatingPartner;
    private String _contactCell;
    private String _contactEmail;
    private long _contactId;
    private String _contactName;
    private long _offerId;
    private SharedPreferences _prefs;
    private String _productAWSBucket;
    private String _productAWSPicture;
    private String _productDescription;
    private long _productId;
    private String _productName;
    private String _productPictureAbsolutePath;

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedEmailHome.1 */
    class C01951 implements OnClickListener {
        C01951() {
        }

        public void onClick(View v) {
            ReceivedEmailHome.this.ignore();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedEmailHome.2 */
    class C01962 implements OnClickListener {
        C01962() {
        }

        public void onClick(View v) {
            ReceivedEmailHome.this.next();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedEmailHome.3 */
    class C01973 implements OnClickListener {
        C01973() {
        }

        public void onClick(View v) {
            ReceivedEmailHome.this.goBack();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedEmailHome.4 */
    class C01984 implements DialogInterface.OnClickListener {
        C01984() {
        }

        public void onClick(DialogInterface dialog, int which) {
            String offerId = ReceivedEmailHome.this.getActiveOfferId();
            try {
                DBAdapter dbAdapter = new DBAdapter(ReceivedEmailHome.this).open();
                dbAdapter.updateOfferStatus(new Long(offerId).longValue(), OfferStatus.RECEIVED_AND_IGNORED_NEW_OFFER.getStatusDbCode());
                dbAdapter.close();
                Toast.makeText(ReceivedEmailHome.this.getApplicationContext(), "Offer was ignored!", 0).show();
                ReceivedEmailHome.this.startActivity(new Intent("android.intent.action.WINDOWS"));
            } catch (SQLException e) {
                Log.e("iNegotiate", "[ERROR] Failed to update offer status to Offer Ignored, offer Id is: " + offerId);
            }
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedEmailHome.5 */
    class C01995 implements DialogInterface.OnClickListener {
        C01995() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    }

    public ReceivedEmailHome() {
        this._offerId = 0;
        this._productId = 0;
        this._contactId = 0;
        this._contactName = StringUtil.EMPTY_STRING;
        this._contactEmail = StringUtil.EMPTY_STRING;
        this._contactCell = StringUtil.EMPTY_STRING;
        this._OfferIdForNegotiatingPartner = StringUtil.EMPTY_STRING;
        this._OfferDate = StringUtil.EMPTY_STRING;
        this._OfferDueDate = StringUtil.EMPTY_STRING;
        this._OfferAmount = StringUtil.EMPTY_STRING;
        this._OfferCurrency = StringUtil.EMPTY_STRING;
        this._OfferBuyerOrSeller = StringUtil.EMPTY_STRING;
        this._OfferContactMe = StringUtil.EMPTY_STRING;
        this._OfferHistory = StringUtil.EMPTY_STRING;
        this._productName = StringUtil.EMPTY_STRING;
        this._productDescription = StringUtil.EMPTY_STRING;
        this._productPictureAbsolutePath = StringUtil.EMPTY_STRING;
        this._productAWSBucket = StringUtil.EMPTY_STRING;
        this._productAWSPicture = StringUtil.EMPTY_STRING;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.received_home);
        ((Button) findViewById(C0185R.id.button1)).setOnClickListener(new C01951());
        ((Button) findViewById(C0185R.id.button2)).setOnClickListener(new C01962());
        ((ImageView) findViewById(C0185R.id.backImageButton)).setOnClickListener(new C01973());
        resolveIncomingOffer();
    }

    private void goBack() {
        startActivity(new Intent("android.intent.action.WINDOWS"));
    }

    private void resolveIncomingOffer() {
        Uri data = getIntent().getData();
        String scheme = data.getScheme();
        String host = data.getHost();
        String path = data.getPath();
        List<String> params = data.getPathSegments();
        this._contactName = getValueFromKeyValuePair((String) params.get(2));
        this._contactEmail = getValueFromKeyValuePair((String) params.get(3));
        this._contactCell = getValueFromKeyValuePair((String) params.get(4));
        this._OfferIdForNegotiatingPartner = getValueFromKeyValuePair((String) params.get(5));
        this._OfferDate = getValueFromKeyValuePair((String) params.get(6));
        this._OfferDueDate = getValueFromKeyValuePair((String) params.get(7));
        this._OfferAmount = getValueFromKeyValuePair((String) params.get(8));
        this._OfferCurrency = getValueFromKeyValuePair((String) params.get(9));
        this._OfferBuyerOrSeller = getValueFromKeyValuePair((String) params.get(10));
        this._OfferContactMe = getValueFromKeyValuePair((String) params.get(11));
        this._OfferHistory = getValueFromKeyValuePair((String) params.get(12));
        this._productName = getValueFromKeyValuePair((String) params.get(13));
        this._productDescription = getValueFromKeyValuePair((String) params.get(14));
        this._productAWSBucket = getValueFromKeyValuePair((String) params.get(15));
        this._productAWSPicture = getValueFromKeyValuePair((String) params.get(16));
        this._productPictureAbsolutePath = StringUtil.EMPTY_STRING;
        if (this._productAWSBucket != null && this._productAWSBucket.length() > 0) {
            downloadAWSImage(this._productAWSBucket, this._productAWSPicture);
        }
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            this._productId = db.doesThisProductExist(this._productName);
            if (this._productId == -1) {
                this._productId = db.insertProduct(this._productName, this._productDescription, this._productPictureAbsolutePath, -1.0d, StringUtil.EMPTY_STRING, this._productAWSBucket, this._productAWSPicture);
            }
            long _contactId = db.doesThisContactExist(this._contactName);
            if (_contactId == -1) {
                _contactId = db.insertContact(this._contactName, StringUtil.EMPTY_STRING, "contactPic", this._contactCell, this._contactEmail);
            }
            this._offerId = db.insertOffer(this._productId, _contactId, this._OfferDate, this._OfferDueDate, new Long(this._OfferAmount).longValue(), OfferStatus.RECEIVED_NEW_OFFER.getStatusDbCode(), this._OfferCurrency, new Long(this._OfferBuyerOrSeller).longValue(), constructHistoryForNewOffer(this._OfferHistory, this._OfferIdForNegotiatingPartner), this._OfferContactMe);
            setActiveOfferId(new Long(this._offerId).toString());
            if (new RuleEnforcer(this._offerId, this._productId, _contactId, Long.valueOf(this._OfferAmount).longValue(), db).validateIfAnyRuleApplies()) {
                Intent intent = new Intent("android.intent.action.RECEIVEDDISPLAY");
                intent = intent;
                intent.putExtra("offerId", new Long(this._offerId).toString());
                startActivity(intent);
            }
            ((TextView) findViewById(C0185R.id.TextView01)).setText(this._contactName);
            ((TextView) findViewById(C0185R.id.TextView02)).setText(new String("Would like to negotiate for:"));
            TextView textView = (TextView) findViewById(C0185R.id.TextView03);
            tv3.setText(new String(this._productName));
            ((TextView) findViewById(C0185R.id.TextView04)).setText("Would you like to learn more?");
            db.close();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] An exception was thrown while inserting Data to database: " + e.getStackTrace());
            db.close();
            showDialog(1);
        } catch (NumberFormatException e2) {
            Log.e("iNegotiate", "[ERROR] A NumberFormat Exceptions was thrown while inserting Data to database: " + e2.getStackTrace());
            db.close();
            showDialog(1);
        }
    }

    private void downloadAWSImage(String awsBucket, String awsPicture) {
        AWSDownloadAdapter awsDownloadAdapter = new AWSDownloadAdapter(this, awsBucket, awsPicture);
        awsDownloadAdapter.downloadImageFromAmazonS3();
        this._productPictureAbsolutePath = awsDownloadAdapter.getResult();
        int i = 0;
        while (i < 20 && (this._productPictureAbsolutePath == null || this._productPictureAbsolutePath.equals(StringUtil.EMPTY_STRING))) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            i++;
            this._productPictureAbsolutePath = awsDownloadAdapter.getResult();
            i++;
        }
        if (i != 20) {
            ImageView iv1 = (ImageView) findViewById(C0185R.id.imageView1);
            Bitmap roundedBitmap = ImageUtilities.getRoundedCornerBitmap(BitmapFactory.decodeFile(this._productPictureAbsolutePath), 20);
            Bitmap.createScaledBitmap(roundedBitmap, 75, 75, true);
            iv1.setImageBitmap(roundedBitmap);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void next() {
        Intent receivedOfferIntent = new Intent("android.intent.action.RECEIVEDDISPLAY");
        receivedOfferIntent.putExtra("offerId", new Long(this._offerId).toString());
        startActivity(receivedOfferIntent);
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Oh Snap!").setMessage("Received an invalid offer!").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Ohhhh Snap!").setMessage("iNegotiate received an invalid NFC Tag").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new Builder(this).setTitle("Verification").setMessage("Are you sure you would like to ignore this offer?").setPositiveButton("YES", new C01984()).setNegativeButton("NO", new C01995()).create();
            default:
                return null;
        }
    }

    private String getActiveOfferId() {
        this._prefs = getSharedPreferences("bargain-preferences", 0);
        return this._prefs.getString("ActiveOfferId", null);
    }

    private void setActiveOfferId(String id) {
        this._prefs = getSharedPreferences("bargain-preferences", 0);
        Editor editor = this._prefs.edit();
        editor.putString("ActiveOfferId", id);
        editor.commit();
    }

    public void onResume() {
        super.onResume();
    }

    public void onNewIntent(Intent intent) {
        setIntent(intent);
    }

    protected void onPause() {
        super.onPause();
    }

    private String constructHistoryForNewOffer(String history, String counterpartId) {
        if (counterpartId == null || counterpartId.length() == 0) {
            return "-1/-1/-1";
        }
        if (history == null || history.length() == 0) {
            return "-1/-1/" + counterpartId;
        }
        return new StringBuilder(String.valueOf(history.split("|")[2])).append("|").append("-1").append("|").append(counterpartId).toString();
    }

    public static HashMap<String, String> parseStringToHashMap(String s) {
        boolean more;
        HashMap<String, String> map = new HashMap();
        int kpos = 0;
        int eqpos = s.indexOf(61);
        if (eqpos > 0) {
            more = true;
        } else {
            more = false;
        }
        while (more) {
            int cmpos = s.indexOf(44, eqpos + 1);
            String key = s.substring(kpos, eqpos).trim();
            if (cmpos > 0) {
                map.put(key, s.substring(eqpos + 1, cmpos).trim());
                eqpos = s.indexOf(61, cmpos + 1);
                if (eqpos > 0) {
                    more = true;
                } else {
                    more = false;
                }
                if (more) {
                    kpos = cmpos + 1;
                }
            } else {
                map.put(key, s.substring(eqpos + 1).trim());
                more = false;
            }
        }
        return map;
    }

    private String getValueFromKeyValuePair(String keyValuePair) {
        if (keyValuePair == null || keyValuePair.length() == 0) {
            return StringUtil.EMPTY_STRING;
        }
        String[] keyValueArr = keyValuePair.split("=");
        if (keyValueArr == null || keyValueArr.length == 0 || keyValueArr.length == 1) {
            return StringUtil.EMPTY_STRING;
        }
        return keyValueArr[1];
    }

    private void ignore() {
        String idAsString = getActiveOfferId();
        showDialog(2);
        notifySubmitterOfThResult(OfferStatus.RECEIVED_AND_IGNORED_NEW_OFFER.toString());
    }

    private void notifySubmitterOfThResult(String status) {
    }
}
