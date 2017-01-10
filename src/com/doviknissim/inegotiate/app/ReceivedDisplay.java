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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.google.common.net.HttpHeaders;
import com.google.gdata.util.common.base.StringUtil;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

public class ReceivedDisplay extends Activity {
    public static String ACTION_ACCEPT;
    public static String ACTION_IGNORE;
    public static String ACTION_REJECT;
    private static long _offerId;
    private int DATABASEDOTCOM_AMOUNT;
    private String DATABASEDOTCOM_CURRENCY;
    private String DATABASEDOTCOM_DATE;
    private String DATABASEDOTCOM_DEALNAME;
    private String DATABASEDOTCOM_IMAGE;
    private String DATABASEDOTCOM_USER1BUCKET;
    private int DATABASEDOTCOM_USER1BUYERORSELLER;
    private String DATABASEDOTCOM_USER1CELL;
    private String DATABASEDOTCOM_USER1EMAIL;
    private String DATABASEDOTCOM_USER1NAME;
    private String DATABASEDOTCOM_USER2BUCKET;
    private int DATABASEDOTCOM_USER2BUYERORSELLER;
    private String DATABASEDOTCOM_USER2CELL;
    private String DATABASEDOTCOM_USER2EMAIL;
    private String DATABASEDOTCOM_USER2NAME;
    private int EMAIL_REQUEST;
    private int _contactId;
    private SharedPreferences prefs;

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedDisplay.1 */
    class C01861 implements OnClickListener {
        C01861() {
        }

        public void onClick(View v) {
            ReceivedDisplay.this.ignore();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedDisplay.2 */
    class C01872 implements OnClickListener {
        C01872() {
        }

        public void onClick(View v) {
            ReceivedDisplay.this.reject();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedDisplay.3 */
    class C01883 implements OnClickListener {
        C01883() {
        }

        public void onClick(View v) {
            ReceivedDisplay.this.accept();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedDisplay.4 */
    class C01894 implements OnClickListener {
        C01894() {
        }

        public void onClick(View v) {
            ReceivedDisplay.this.counter();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedDisplay.5 */
    class C01905 implements OnClickListener {
        C01905() {
        }

        public void onClick(View v) {
            ReceivedDisplay.this.goBack();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedDisplay.6 */
    class C01916 implements DialogInterface.OnClickListener {
        C01916() {
        }

        public void onClick(DialogInterface dialog, int which) {
            String offerId = StringUtil.EMPTY_STRING;
            DBAdapter dbAdapter = new DBAdapter(ReceivedDisplay.this);
            try {
                offerId = ReceivedDisplay.this.getActiveOfferId();
                dbAdapter = dbAdapter.open();
                dbAdapter.updateOfferStatus(new Long(offerId).longValue(), OfferStatus.RECEIVED_AND_IGNORED_NEW_OFFER.getStatusDbCode());
                dbAdapter.close();
                Toast.makeText(ReceivedDisplay.this.getApplicationContext(), "Offer was ignored!", 0).show();
                ReceivedDisplay.this.startActivity(new Intent("android.intent.action.WINDOWS"));
            } catch (SQLException e) {
                Log.e("iNegotiate", "[ERROR] Failed to update offer status, offer Id is: " + offerId);
                dbAdapter.close();
            }
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedDisplay.7 */
    class C01927 implements DialogInterface.OnClickListener {
        C01927() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedDisplay.8 */
    class C01938 implements DialogInterface.OnClickListener {
        C01938() {
        }

        public void onClick(DialogInterface dialog, int which) {
            String offerId = ReceivedDisplay.this.getActiveOfferId();
            DBAdapter dbAdapter = new DBAdapter(ReceivedDisplay.this);
            try {
                dbAdapter = dbAdapter.open();
                dbAdapter.updateOfferStatus(new Long(offerId).longValue(), OfferStatus.RECEIVED_AND_REJECTED_NEW_OFFER.getStatusDbCode());
                dbAdapter.close();
                Toast.makeText(ReceivedDisplay.this.getApplicationContext(), "Offer was rejected!", 0).show();
                ReceivedDisplay.this.startActivity(new Intent("android.intent.action.WINDOWS"));
            } catch (SQLException e) {
                Log.e("iNegotiate", "[ERROR] Failed to update offer status to rejected, offer Id is: " + offerId);
                dbAdapter.close();
            }
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.ReceivedDisplay.9 */
    class C01949 implements DialogInterface.OnClickListener {
        C01949() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    }

    public ReceivedDisplay() {
        this._contactId = 0;
        this.EMAIL_REQUEST = 773;
        this.DATABASEDOTCOM_DEALNAME = StringUtil.EMPTY_STRING;
        this.DATABASEDOTCOM_AMOUNT = 0;
        this.DATABASEDOTCOM_CURRENCY = StringUtil.EMPTY_STRING;
        this.DATABASEDOTCOM_DATE = StringUtil.EMPTY_STRING;
        this.DATABASEDOTCOM_IMAGE = StringUtil.EMPTY_STRING;
        this.DATABASEDOTCOM_USER1NAME = StringUtil.EMPTY_STRING;
        this.DATABASEDOTCOM_USER1EMAIL = StringUtil.EMPTY_STRING;
        this.DATABASEDOTCOM_USER1CELL = StringUtil.EMPTY_STRING;
        this.DATABASEDOTCOM_USER1BUYERORSELLER = 0;
        this.DATABASEDOTCOM_USER1BUCKET = StringUtil.EMPTY_STRING;
        this.DATABASEDOTCOM_USER2NAME = StringUtil.EMPTY_STRING;
        this.DATABASEDOTCOM_USER2EMAIL = StringUtil.EMPTY_STRING;
        this.DATABASEDOTCOM_USER2CELL = StringUtil.EMPTY_STRING;
        this.DATABASEDOTCOM_USER2BUYERORSELLER = 0;
        this.DATABASEDOTCOM_USER2BUCKET = StringUtil.EMPTY_STRING;
    }

    static {
        _offerId = 0;
        ACTION_ACCEPT = HttpHeaders.ACCEPT;
        ACTION_REJECT = "Reject";
        ACTION_IGNORE = "Ignore";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.received_display);
        populate();
        ((Button) findViewById(C0185R.id.button3)).setOnClickListener(new C01861());
        ((Button) findViewById(C0185R.id.button1)).setOnClickListener(new C01872());
        ((Button) findViewById(C0185R.id.button2)).setOnClickListener(new C01883());
        ((Button) findViewById(C0185R.id.button4)).setOnClickListener(new C01894());
        ((ImageView) findViewById(C0185R.id.backImageButton)).setOnClickListener(new C01905());
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populate() {
        /*
        r33 = this;
        r4 = r33.getIntent();
        r20 = r4.getExtras();
        r4 = "offerId";
        r0 = r20;
        r21 = r0.getString(r4);
        r4 = "bargain-preferences";
        r5 = 0;
        r0 = r33;
        r4 = r0.getSharedPreferences(r4, r5);
        r0 = r33;
        r0.prefs = r4;
        r12 = new com.doviknissim.inegotiate.app.DBAdapter;
        r0 = r33;
        r12.<init>(r0);
        r12.open();	 Catch:{ SQLException -> 0x0207 }
        r0 = r21;
        r16 = r12.getOfferByID(r0);	 Catch:{ SQLException -> 0x0207 }
        r16.moveToFirst();	 Catch:{ SQLException -> 0x0207 }
        r4 = 2;
        r0 = r16;
        r4 = r0.getInt(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0._contactId = r4;	 Catch:{ SQLException -> 0x0207 }
        r4 = 1;
        r0 = r16;
        r24 = r0.getInt(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r24;
        r4 = (long) r0;	 Catch:{ SQLException -> 0x0207 }
        r17 = r12.getProduct(r4);	 Catch:{ SQLException -> 0x0207 }
        r17.moveToFirst();	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r4 = r0._contactId;	 Catch:{ SQLException -> 0x0207 }
        r4 = (long) r4;	 Catch:{ SQLException -> 0x0207 }
        r15 = r12.getContact(r4);	 Catch:{ SQLException -> 0x0207 }
        r15.moveToFirst();	 Catch:{ SQLException -> 0x0207 }
        r4 = new java.lang.Integer;	 Catch:{ SQLException -> 0x0207 }
        r5 = 0;
        r0 = r16;
        r5 = r0.getInt(r5);	 Catch:{ SQLException -> 0x0207 }
        r4.<init>(r5);	 Catch:{ SQLException -> 0x0207 }
        r22 = r4.toString();	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r1 = r22;
        r0.setActiveOfferId(r1);	 Catch:{ SQLException -> 0x0207 }
        r4 = 2131230766; // 0x7f08002e float:1.8077594E38 double:1.052967905E-314;
        r0 = r33;
        r29 = r0.findViewById(r4);	 Catch:{ SQLException -> 0x0207 }
        r29 = (android.widget.TextView) r29;	 Catch:{ SQLException -> 0x0207 }
        r4 = 1;
        r4 = r15.getString(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r29;
        r0.setText(r4);	 Catch:{ SQLException -> 0x0207 }
        r4 = 2131230768; // 0x7f080030 float:1.8077598E38 double:1.052967906E-314;
        r0 = r33;
        r30 = r0.findViewById(r4);	 Catch:{ SQLException -> 0x0207 }
        r30 = (android.widget.TextView) r30;	 Catch:{ SQLException -> 0x0207 }
        r4 = 1;
        r0 = r17;
        r4 = r0.getString(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r30;
        r0.setText(r4);	 Catch:{ SQLException -> 0x0207 }
        r4 = 2131230770; // 0x7f080032 float:1.8077602E38 double:1.052967907E-314;
        r0 = r33;
        r31 = r0.findViewById(r4);	 Catch:{ SQLException -> 0x0207 }
        r31 = (android.widget.TextView) r31;	 Catch:{ SQLException -> 0x0207 }
        r4 = 5;
        r0 = r16;
        r4 = r0.getString(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r31;
        r0.setText(r4);	 Catch:{ SQLException -> 0x0207 }
        r4 = 2131230771; // 0x7f080033 float:1.8077604E38 double:1.0529679073E-314;
        r0 = r33;
        r32 = r0.findViewById(r4);	 Catch:{ SQLException -> 0x0207 }
        r32 = (android.widget.TextView) r32;	 Catch:{ SQLException -> 0x0207 }
        r4 = 7;
        r0 = r16;
        r4 = r0.getString(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r32;
        r0.setText(r4);	 Catch:{ SQLException -> 0x0207 }
        r4 = 3;
        r0 = r17;
        r25 = r0.getString(r4);	 Catch:{ SQLException -> 0x0207 }
        if (r25 == 0) goto L_0x00fe;
    L_0x00d2:
        r4 = r25.length();	 Catch:{ SQLException -> 0x0207 }
        if (r4 <= 0) goto L_0x00fe;
    L_0x00d8:
        r14 = android.graphics.BitmapFactory.decodeFile(r25);	 Catch:{ SQLException -> 0x0207 }
        r4 = 20;
        r26 = com.doviknissim.inegotiate.app.ImageUtilities.getRoundedCornerBitmap(r14, r4);	 Catch:{ SQLException -> 0x0207 }
        r4 = 75;
        r5 = 75;
        r6 = 1;
        r0 = r26;
        android.graphics.Bitmap.createScaledBitmap(r0, r4, r5, r6);	 Catch:{ SQLException -> 0x0207 }
        r4 = 2131230721; // 0x7f080001 float:1.8077503E38 double:1.0529678826E-314;
        r0 = r33;
        r23 = r0.findViewById(r4);	 Catch:{ SQLException -> 0x0207 }
        r23 = (android.widget.ImageView) r23;	 Catch:{ SQLException -> 0x0207 }
        r0 = r23;
        r1 = r26;
        r0.setImageBitmap(r1);	 Catch:{ SQLException -> 0x0207 }
    L_0x00fe:
        r4 = 1;
        r0 = r17;
        r4 = r0.getString(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_DEALNAME = r4;	 Catch:{ SQLException -> 0x0207 }
        r4 = 5;
        r0 = r16;
        r4 = r0.getInt(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_AMOUNT = r4;	 Catch:{ SQLException -> 0x0207 }
        r4 = 7;
        r0 = r16;
        r4 = r0.getString(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_CURRENCY = r4;	 Catch:{ SQLException -> 0x0207 }
        r4 = 3;
        r0 = r16;
        r4 = r0.getString(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_DATE = r4;	 Catch:{ SQLException -> 0x0207 }
        r0 = r25;
        r1 = r33;
        r1.DATABASEDOTCOM_IMAGE = r0;	 Catch:{ SQLException -> 0x0207 }
        r4 = 1;
        r4 = r15.getString(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_USER1NAME = r4;	 Catch:{ SQLException -> 0x0207 }
        r4 = 5;
        r4 = r15.getString(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_USER1EMAIL = r4;	 Catch:{ SQLException -> 0x0207 }
        r4 = 4;
        r4 = r15.getString(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_USER1CELL = r4;	 Catch:{ SQLException -> 0x0207 }
        r4 = 8;
        r0 = r16;
        r4 = r0.getInt(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_USER1BUYERORSELLER = r4;	 Catch:{ SQLException -> 0x0207 }
        r4 = 6;
        r0 = r17;
        r4 = r0.getString(r4);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_USER1BUCKET = r4;	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r4 = r0.prefs;	 Catch:{ SQLException -> 0x0207 }
        r5 = "INEGOTIATE_FIRSTNAME";
        r6 = "";
        r4 = r4.getString(r5, r6);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_USER2NAME = r4;	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r4 = r0.prefs;	 Catch:{ SQLException -> 0x0207 }
        r5 = "INEGOTIATE_EMAIL";
        r6 = "";
        r4 = r4.getString(r5, r6);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_USER2EMAIL = r4;	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r4 = r0.prefs;	 Catch:{ SQLException -> 0x0207 }
        r5 = "INEGOTIATE_CELL";
        r6 = "";
        r4 = r4.getString(r5, r6);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_USER2CELL = r4;	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r4 = r0.DATABASEDOTCOM_USER1BUYERORSELLER;	 Catch:{ SQLException -> 0x0207 }
        r4 = 1 - r4;
        r0 = r33;
        r0.DATABASEDOTCOM_USER2BUYERORSELLER = r4;	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r4 = r0.prefs;	 Catch:{ SQLException -> 0x0207 }
        r5 = "INEGOTIATE_BUCKETNAME";
        r6 = "";
        r4 = r4.getString(r5, r6);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r0.DATABASEDOTCOM_USER2BUCKET = r4;	 Catch:{ SQLException -> 0x0207 }
        r3 = new com.doviknissim.inegotiate.app.RuleEnforcer;	 Catch:{ SQLException -> 0x0207 }
        r4 = _offerId;	 Catch:{ SQLException -> 0x0207 }
        r6 = 0;
        r0 = r17;
        r6 = r0.getLong(r6);	 Catch:{ SQLException -> 0x0207 }
        r0 = r33;
        r8 = r0._contactId;	 Catch:{ SQLException -> 0x0207 }
        r8 = (long) r8;	 Catch:{ SQLException -> 0x0207 }
        r10 = 5;
        r0 = r16;
        r10 = r0.getLong(r10);	 Catch:{ SQLException -> 0x0207 }
        r3.<init>(r4, r6, r8, r10, r12);	 Catch:{ SQLException -> 0x0207 }
        r13 = r3.validateIfAnyRuleAppliesAndGetAction();	 Catch:{ SQLException -> 0x0207 }
        r4 = ACTION_ACCEPT;	 Catch:{ SQLException -> 0x0207 }
        r4 = r13.equals(r4);	 Catch:{ SQLException -> 0x0207 }
        if (r4 == 0) goto L_0x01ea;
    L_0x01d2:
        r27 = "Found rules that apply, accepting...";
        r18 = 0;
        r0 = r33;
        r1 = r27;
        r2 = r18;
        r28 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ SQLException -> 0x0207 }
        r28.show();	 Catch:{ SQLException -> 0x0207 }
        r33.performAccept();	 Catch:{ SQLException -> 0x0207 }
    L_0x01e6:
        r12.close();
    L_0x01e9:
        return;
    L_0x01ea:
        r4 = ACTION_REJECT;	 Catch:{ SQLException -> 0x0207 }
        r4 = r13.equals(r4);	 Catch:{ SQLException -> 0x0207 }
        if (r4 == 0) goto L_0x0224;
    L_0x01f2:
        r27 = "Found rules that apply, rejecting...";
        r18 = 0;
        r0 = r33;
        r1 = r27;
        r2 = r18;
        r28 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ SQLException -> 0x0207 }
        r28.show();	 Catch:{ SQLException -> 0x0207 }
        r33.rejectFastLane();	 Catch:{ SQLException -> 0x0207 }
        goto L_0x01e6;
    L_0x0207:
        r19 = move-exception;
        r4 = "iNegotiate";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0241 }
        r6 = "Exception was thrown: ";
        r5.<init>(r6);	 Catch:{ all -> 0x0241 }
        r6 = r19.getMessage();	 Catch:{ all -> 0x0241 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x0241 }
        r5 = r5.toString();	 Catch:{ all -> 0x0241 }
        android.util.Log.e(r4, r5);	 Catch:{ all -> 0x0241 }
        r12.close();
        goto L_0x01e9;
    L_0x0224:
        r4 = ACTION_IGNORE;	 Catch:{ SQLException -> 0x0207 }
        r4 = r13.equals(r4);	 Catch:{ SQLException -> 0x0207 }
        if (r4 == 0) goto L_0x01e6;
    L_0x022c:
        r27 = "Found rules that apply, ignoring...";
        r18 = 0;
        r0 = r33;
        r1 = r27;
        r2 = r18;
        r28 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ SQLException -> 0x0207 }
        r28.show();	 Catch:{ SQLException -> 0x0207 }
        r33.ignoreFastLane();	 Catch:{ SQLException -> 0x0207 }
        goto L_0x01e6;
    L_0x0241:
        r4 = move-exception;
        r12.close();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doviknissim.inegotiate.app.ReceivedDisplay.populate():void");
    }

    private void ignore() {
        showDialog(1);
        notifySubmitterOfThResult(OfferStatus.RECEIVED_AND_IGNORED_NEW_OFFER.getStatusDbCode());
    }

    private void reject() {
        String idAsString = getActiveOfferId();
        showDialog(2);
        notifySubmitterOfThResult(OfferStatus.RECEIVED_AND_REJECTED_NEW_OFFER.getStatusDbCode());
    }

    private void rejectFastLane() {
        String offerId = getActiveOfferId();
        DBAdapter dbAdapter = new DBAdapter(this);
        try {
            dbAdapter = dbAdapter.open();
            dbAdapter.updateOfferStatus(new Long(offerId).longValue(), OfferStatus.RECEIVED_AND_REJECTED_NEW_OFFER.getStatusDbCode());
            dbAdapter.close();
            Toast.makeText(getApplicationContext(), "Offer was rejected!", 0).show();
            startActivity(new Intent("android.intent.action.WINDOWS"));
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] Failed to update offer status to rejected, offer Id is: " + offerId);
            dbAdapter.close();
        }
    }

    private void ignoreFastLane() {
        String offerId = StringUtil.EMPTY_STRING;
        DBAdapter dbAdapter = new DBAdapter(this);
        try {
            offerId = getActiveOfferId();
            dbAdapter = dbAdapter.open();
            dbAdapter.updateOfferStatus(new Long(offerId).longValue(), OfferStatus.RECEIVED_AND_IGNORED_NEW_OFFER.getStatusDbCode());
            dbAdapter.close();
            Toast.makeText(getApplicationContext(), "Offer was ignored!", 0).show();
            startActivity(new Intent("android.intent.action.WINDOWS"));
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] Failed to update offer status, offer Id is: " + offerId);
            dbAdapter.close();
        }
    }

    private void accept() {
        showDialog(3);
    }

    private void counter() {
        showDialog(4);
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Aww Snap!").setMessage("Received an invalid offer!").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Please confirm").setMessage("Are you sure you would like to ignore this offer?").setPositiveButton("YES", new C01916()).setNegativeButton("NO", new C01927()).create();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new Builder(this).setTitle("Please confirm").setMessage("Are you sure you would like to reject this offer?").setPositiveButton("YES", new C01938()).setNegativeButton("NO", new C01949()).create();
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return new Builder(this).setTitle("Please confirm").setMessage("Are you sure you would like to accept this offer?").setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ReceivedDisplay.this.performAccept();
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create();
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                return new Builder(this).setTitle("please confirm").setMessage("Are you sure you would like to counter this offer?").setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ReceivedDisplay.this.performCounter();
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create();
            default:
                return null;
        }
    }

    private String getActiveOfferId() {
        this.prefs = getSharedPreferences("bargain-preferences", 0);
        String offerId = this.prefs.getString("ActiveOfferId", null);
        _offerId = new Long(offerId).longValue();
        return offerId;
    }

    private void setActiveOfferId(String id) {
        this.prefs = getSharedPreferences("bargain-preferences", 0);
        Editor editor = this.prefs.edit();
        editor.putString("ActiveOfferId", id);
        editor.commit();
    }

    private void notifySubmitterOfThResult(String status) {
    }

    private void moveOn() {
        Intent moveToPaymentIntent = new Intent("android.intent.action.CONGRATS");
        moveToPaymentIntent.putExtra("currency", this.DATABASEDOTCOM_CURRENCY);
        moveToPaymentIntent.putExtra("amount", Integer.toString(this.DATABASEDOTCOM_AMOUNT));
        moveToPaymentIntent.putExtra("recipient", this.DATABASEDOTCOM_USER2EMAIL);
        startActivity(moveToPaymentIntent);
    }

    private void performAccept() {
        String offerId = getActiveOfferId();
        try {
            DBAdapter dbAdapter = new DBAdapter(this).open();
            dbAdapter.updateOfferStatus(new Long(offerId).longValue(), OfferStatus.RECEIVED_AND_ACCEPTED_NEW_OFFER.getStatusDbCode());
            startActivity(new Intent("android.intent.action.WINDOWS"));
            dbAdapter.close();
            updateMasterSpreadsheet();
            sendAccepttanceEmail();
            moveOn();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] Failed to update offer status to accepted, offer Id is: " + offerId);
        }
    }

    private void performCounter() {
        String idAsString = getActiveOfferId();
        Intent createCounterIntent = new Intent("android.intent.action.COUNTER");
        createCounterIntent.putExtra("offerId", idAsString);
        startActivity(createCounterIntent);
    }

    private void goBack() {
        finish();
    }

    private void sendAccepttanceEmail() {
        try {
            if (this._contactId == 0) {
                Log.e("iNegotiate", "[ERROR] Could not send the offer acceptance email because the contact (recipient) Id was invalid.");
                return;
            }
            DBAdapter db = new DBAdapter(this);
            db.open();
            Cursor c = db.getContact((long) this._contactId);
            if (c == null) {
                Log.e("iNegotiate", "[ERROR] Could not send the offer acceptance email because of failure to retrieve contact (recipient) Id was invalid.");
                return;
            }
            c.moveToFirst();
            String contactEmail = c.getString(5);
            String contactName = c.getString(1);
            db.close();
            SharedPreferences prefs = getSharedPreferences("bargain-preferences", 0);
            String senderEMail = prefs.getString("INEGOTIATE_EMAIL", StringUtil.EMPTY_STRING);
            String senderName = prefs.getString("INEGOTIATE_FIRSTNAME", StringUtil.EMPTY_STRING);
            Intent emailIntent = new Intent("android.intent.action.SEND");
            emailIntent.putExtra("android.intent.extra.EMAIL", new String[]{contactEmail});
            emailIntent.putExtra("android.intent.extra.SUBJECT", "Congratulations - you're iNegotiate offer was accepted");
            emailIntent.setType(Mimetypes.MIMETYPE_HTML);
            emailIntent.putExtra("android.intent.extra.TEXT", Html.fromHtml("<!DOCTYPE html><html><body><br>Dear " + contactName + ",<br>" + "Congratulations! <br><br>" + senderName + " has accepted the offer you sent via iNegotiate <br>" + "For more details, " + "<a href=\"inegotiate://" + "\">click here</a>" + "<br><br>Warm regards,<br>The iNegotiate Team" + "</body></html>"));
            startActivityForResult(emailIntent, this.EMAIL_REQUEST);
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] Could not send the offer acceptance email because of a database failure: " + e.getMessage());
        }
    }

    private void updateMasterSpreadsheet() {
        Map<String, String> row = new HashMap();
        row.put("id", "0");
        row.put("product", this.DATABASEDOTCOM_DEALNAME);
        row.put("amount", Integer.toString(this.DATABASEDOTCOM_AMOUNT));
        row.put("currency", this.DATABASEDOTCOM_CURRENCY);
        row.put(DBAdapter.DATE, this.DATABASEDOTCOM_DATE);
        row.put("image", this.DATABASEDOTCOM_IMAGE);
        row.put("user1bucket", this.DATABASEDOTCOM_USER1BUCKET);
        row.put("user1name", this.DATABASEDOTCOM_USER1NAME);
        row.put("user1email", this.DATABASEDOTCOM_USER1EMAIL);
        row.put("user1cell", this.DATABASEDOTCOM_USER1CELL);
        row.put("user1buyerseller", Integer.toString(this.DATABASEDOTCOM_USER1BUYERORSELLER));
        row.put("user2bucket", this.DATABASEDOTCOM_USER2BUCKET);
        row.put("user2name", this.DATABASEDOTCOM_USER2NAME);
        row.put("user2email", this.DATABASEDOTCOM_USER2EMAIL);
        row.put("user2cell", this.DATABASEDOTCOM_USER2CELL);
        row.put("user2buyerseller", Integer.toString(this.DATABASEDOTCOM_USER2BUYERORSELLER));
        row.put("cut", Double.toString(((double) this.DATABASEDOTCOM_AMOUNT) * 0.01d));
        this.prefs = getSharedPreferences("bargain-preferences", 0);
        new GoogleSpreadsheetAdapter(row, this.prefs).updateMasterSpreadsheet();
    }
}
