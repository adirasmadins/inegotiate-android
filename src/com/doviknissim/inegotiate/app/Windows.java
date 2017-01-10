package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import java.sql.SQLException;

public class Windows extends Activity {
    private String MY_ADMOB_PUBLISHER_ID;
    private AdView adView;

    /* renamed from: com.doviknissim.inegotiate.app.Windows.1 */
    class C02101 implements OnClickListener {
        C02101() {
        }

        public void onClick(View v) {
            Windows.this.startActivity(new Intent("android.intent.action.SETTINGS"));
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Windows.2 */
    class C02112 implements OnClickListener {
        C02112() {
        }

        public void onClick(View v) {
            Windows.this.startActivity(new Intent("android.intent.action.PRODUCT"));
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Windows.3 */
    class C02123 implements OnClickListener {
        C02123() {
        }

        public void onClick(View v) {
            Windows.this.startActivity(new Intent("android.intent.action.STATISTICS"));
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Windows.4 */
    class C02134 implements OnClickListener {
        C02134() {
        }

        public void onClick(View v) {
            Windows.this.startActivity(new Intent("android.intent.action.RECENT"));
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Windows.5 */
    class C02145 implements OnClickListener {
        C02145() {
        }

        public void onClick(View v) {
            Windows.this.startActivity(new Intent("android.intent.action.OFFERSEARCH"));
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Windows.6 */
    class C02156 implements OnClickListener {
        C02156() {
        }

        public void onClick(View v) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(268435456);
            Windows.this.startActivity(intent);
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Windows.7 */
    class C02167 implements OnClickListener {
        C02167() {
        }

        public void onClick(View v) {
            Windows.this.startActivity(new Intent("android.intent.action.STATISTICS"));
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Windows.8 */
    class C02178 implements OnClickListener {
        C02178() {
        }

        public void onClick(View v) {
            Windows.this.startActivity(new Intent("android.intent.action.INVITE"));
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Windows.9 */
    class C02189 implements OnClickListener {
        C02189() {
        }

        public void onClick(View v) {
            Windows.this.startActivity(new Intent("android.intent.action.INEGOTIATERULES"));
        }
    }

    public Windows() {
        this.MY_ADMOB_PUBLISHER_ID = "a150d9f5f8932ec";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.windows);
        this.adView = new AdView((Activity) this, AdSize.BANNER, this.MY_ADMOB_PUBLISHER_ID);
        RelativeLayout layout = (RelativeLayout) findViewById(C0185R.id.topRelativeLayout);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layout.addView(this.adView, layoutParams);
        this.adView.loadAd(new AdRequest());
        populateWindowsPage();
    }

    private void populateWindowsPage() {
        ((ImageView) findViewById(C0185R.id.imageView1)).setOnClickListener(new C02101());
        ((ImageView) findViewById(C0185R.id.imageView2)).setOnClickListener(new C02112());
        ((ImageView) findViewById(C0185R.id.imageView3)).setOnClickListener(new C02123());
        ((ImageView) findViewById(C0185R.id.imageView4)).setOnClickListener(new C02134());
        ((ImageView) findViewById(C0185R.id.imageView6)).setOnClickListener(new C02145());
        ((ImageView) findViewById(C0185R.id.imageView5)).setOnClickListener(new C02156());
        ((Button) findViewById(C0185R.id.summaryView)).setOnClickListener(new C02167());
        ((ImageView) findViewById(C0185R.id.imageView7)).setOnClickListener(new C02178());
        ((ImageView) findViewById(C0185R.id.imageView8)).setOnClickListener(new C02189());
        populateOfferTotals();
        toastContactIfNoDeals();
    }

    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    private void populateOfferTotals() {
        try {
            DBAdapter dbAdapter = new DBAdapter(this).open();
            int numOfSentNewOffers = dbAdapter.getOffersByStatus(OfferStatus.SENT_NEW_OFFER.getStatusDbCode()).getCount();
            int numOfSentIgnoredOffers = dbAdapter.getOffersByStatus(OfferStatus.SENT_AND_IGNORED_OFFER.getStatusDbCode()).getCount();
            int numOfSentPendingOffers = numOfSentNewOffers + numOfSentIgnoredOffers;
            int i = numOfSentNewOffers + numOfSentIgnoredOffers;
            int numOfSentOffers = (i + dbAdapter.getOffersByStatus(OfferStatus.SENT_AND_ACCEPTED_OFFER.getStatusDbCode()).getCount()) + dbAdapter.getOffersByStatus(OfferStatus.SENT_AND_REJECTED_OFFER.getStatusDbCode()).getCount();
            int numOfReceivedPendingOffers = dbAdapter.getOffersByStatus(OfferStatus.RECEIVED_NEW_OFFER.getStatusDbCode()).getCount();
            int numOfReceivedAcceptedOffers = dbAdapter.getOffersByStatus(OfferStatus.RECEIVED_AND_ACCEPTED_NEW_OFFER.getStatusDbCode()).getCount();
            int numOfReceivedOffers = ((numOfReceivedPendingOffers + dbAdapter.getOffersByStatus(OfferStatus.RECEIVED_AND_IGNORED_NEW_OFFER.getStatusDbCode()).getCount()) + numOfReceivedAcceptedOffers) + dbAdapter.getOffersByStatus(OfferStatus.RECEIVED_AND_REJECTED_NEW_OFFER.getStatusDbCode()).getCount();
            dbAdapter.close();
            String userName = getSharedPreferences("bargain-preferences", 0).getString("INEGOTIATE_FIRSTNAME", "User");
            Button summaryButton = (Button) findViewById(C0185R.id.summaryView);
            summaryButton.setTextSize(15.0f);
            summaryButton.setText("Dear " + userName + ",\n" + "Sent offers:" + "        " + numOfSentOffers + "\n" + "Received offers:" + "  " + numOfReceivedOffers);
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] While retreiving offer statistics, an SQL Exception was thrown:" + e.getMessage());
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(C0185R.layout.windows);
        populateWindowsPage();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void toastContactIfNoDeals() {
        /*
        r28 = this;
        r25 = "bargain-preferences";
        r26 = 0;
        r0 = r28;
        r1 = r25;
        r2 = r26;
        r14 = r0.getSharedPreferences(r1, r2);
        r25 = "INEGOTIATE_START";
        r26 = "";
        r0 = r25;
        r1 = r26;
        r19 = r14.getString(r0, r1);
        if (r19 == 0) goto L_0x0034;
    L_0x001c:
        r25 = "";
        r0 = r19;
        r1 = r25;
        r25 = r0.equals(r1);
        if (r25 != 0) goto L_0x0034;
    L_0x0028:
        r25 = "false";
        r0 = r19;
        r1 = r25;
        r25 = r0.equals(r1);
        if (r25 == 0) goto L_0x0035;
    L_0x0034:
        return;
    L_0x0035:
        r13 = r14.edit();
        r25 = "INEGOTIATE_START";
        r26 = "false";
        r0 = r25;
        r1 = r26;
        r13.putString(r0, r1);
        r10 = new com.doviknissim.inegotiate.app.DBAdapter;
        r0 = r28;
        r10.<init>(r0);
        r10.open();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r3 = r10.getAllOffers();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        if (r3 == 0) goto L_0x005a;
    L_0x0054:
        r25 = r3.getCount();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        if (r25 != 0) goto L_0x005e;
    L_0x005a:
        r10.close();
        goto L_0x0034;
    L_0x005e:
        r3.moveToFirst();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
    L_0x0061:
        r25 = r3.isAfterLast();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        if (r25 == 0) goto L_0x006b;
    L_0x0067:
        r10.close();
        goto L_0x0034;
    L_0x006b:
        r25 = 6;
        r0 = r25;
        r20 = r3.getString(r0);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        if (r20 == 0) goto L_0x0147;
    L_0x0075:
        r25 = com.doviknissim.inegotiate.app.OfferStatus.RECEIVED_AND_REJECTED_NEW_OFFER;	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r25 = r25.getStatusDbCode();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r0 = r20;
        r1 = r25;
        r25 = r0.equals(r1);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        if (r25 != 0) goto L_0x0095;
    L_0x0085:
        r25 = com.doviknissim.inegotiate.app.OfferStatus.RECEIVED_AND_IGNORED_NEW_OFFER;	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r25 = r25.getStatusDbCode();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r0 = r20;
        r1 = r25;
        r25 = r0.equals(r1);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        if (r25 == 0) goto L_0x0147;
    L_0x0095:
        r25 = 10;
        r0 = r25;
        r9 = r3.getString(r0);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        if (r9 == 0) goto L_0x0147;
    L_0x009f:
        r25 = "true";
        r0 = r25;
        r25 = r9.equals(r0);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        if (r25 == 0) goto L_0x0147;
    L_0x00a9:
        r24 = 0;
        r23 = 0;
        r18 = 0;
        r25 = 2;
        r0 = r25;
        r8 = r3.getString(r0);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r25 = java.lang.Long.valueOf(r8);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r6 = r25.longValue();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r4 = r10.getContact(r6);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        if (r4 == 0) goto L_0x0061;
    L_0x00c5:
        r25 = r4.getCount();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        if (r25 == 0) goto L_0x0061;
    L_0x00cb:
        r4.moveToFirst();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r25 = 1;
        r0 = r25;
        r24 = r4.getString(r0);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r25 = 5;
        r0 = r25;
        r23 = r4.getString(r0);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r25 = 1;
        r0 = r25;
        r17 = r3.getString(r0);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r25 = java.lang.Long.valueOf(r17);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r15 = r25.longValue();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r0 = r15;
        r5 = r10.getProduct(r0);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        if (r5 == 0) goto L_0x0061;
    L_0x00f5:
        r25 = r5.getCount();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        if (r25 == 0) goto L_0x0061;
    L_0x00fb:
        r5.moveToFirst();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r25 = 1;
        r0 = r25;
        r18 = r5.getString(r0);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r25 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r26 = "Reminder: contact ";
        r25.<init>(r26);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r0 = r25;
        r1 = r24;
        r25 = r0.append(r1);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r26 = " ( at ";
        r25 = r25.append(r26);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r0 = r25;
        r1 = r23;
        r25 = r0.append(r1);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r26 = ") ";
        r25 = r25.append(r26);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r26 = " regarding ";
        r25 = r25.append(r26);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r0 = r25;
        r1 = r18;
        r25 = r0.append(r1);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r22 = r25.toString();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r11 = 1;
        r0 = r28;
        r1 = r22;
        r21 = android.widget.Toast.makeText(r0, r1, r11);	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        r21.show();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
    L_0x0147:
        r3.moveToNext();	 Catch:{ SQLException -> 0x014c, Exception -> 0x016a }
        goto L_0x0061;
    L_0x014c:
        r12 = move-exception;
        r25 = "iNegotiate";
        r26 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0188 }
        r27 = "[ERROR] SQL Exception was thrown while toasting reminders: ";
        r26.<init>(r27);	 Catch:{ all -> 0x0188 }
        r27 = r12.getMessage();	 Catch:{ all -> 0x0188 }
        r26 = r26.append(r27);	 Catch:{ all -> 0x0188 }
        r26 = r26.toString();	 Catch:{ all -> 0x0188 }
        android.util.Log.e(r25, r26);	 Catch:{ all -> 0x0188 }
        r10.close();
        goto L_0x0034;
    L_0x016a:
        r12 = move-exception;
        r25 = "iNegotiate";
        r26 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0188 }
        r27 = "[ERROR] Exception was thrown while toasting reminders: ";
        r26.<init>(r27);	 Catch:{ all -> 0x0188 }
        r27 = r12.getMessage();	 Catch:{ all -> 0x0188 }
        r26 = r26.append(r27);	 Catch:{ all -> 0x0188 }
        r26 = r26.toString();	 Catch:{ all -> 0x0188 }
        android.util.Log.e(r25, r26);	 Catch:{ all -> 0x0188 }
        r10.close();
        goto L_0x0034;
    L_0x0188:
        r25 = move-exception;
        r10.close();
        throw r25;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doviknissim.inegotiate.app.Windows.toastContactIfNoDeals():void");
    }
}
