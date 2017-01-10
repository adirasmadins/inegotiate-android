package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import java.sql.SQLException;

public class Statistics extends Activity {

    /* renamed from: com.doviknissim.inegotiate.app.Statistics.1 */
    class C02051 implements OnClickListener {
        C02051() {
        }

        public void onClick(View v) {
            Statistics.this.finish();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        DBAdapter dbAdapter;
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.statistics);
        ((ImageView) findViewById(C0185R.id.backImageButton)).setOnClickListener(new C02051());
        GridView sentGridView = (GridView) findViewById(C0185R.id.gridView1);
        int numOfSentAcceptedOffers = 0;
        int numOfSentrejectedOffers = 0;
        int numOfSentPendingOffers = 0;
        int numOfSentOffers = 0;
        DBAdapter dBAdapter = new DBAdapter(this);
        try {
            dbAdapter = dBAdapter.open();
            int numOfSentNewOffers = dbAdapter.getOffersByStatus(OfferStatus.SENT_NEW_OFFER.getStatusDbCode()).getCount();
            int numOfSentIgnoredOffers = dbAdapter.getOffersByStatus(OfferStatus.SENT_AND_IGNORED_OFFER.getStatusDbCode()).getCount();
            numOfSentPendingOffers = numOfSentNewOffers + numOfSentIgnoredOffers;
            numOfSentrejectedOffers = dbAdapter.getOffersByStatus(OfferStatus.SENT_AND_REJECTED_OFFER.getStatusDbCode()).getCount();
            numOfSentAcceptedOffers = dbAdapter.getOffersByStatus(OfferStatus.SENT_AND_ACCEPTED_OFFER.getStatusDbCode()).getCount();
            numOfSentOffers = ((numOfSentNewOffers + numOfSentIgnoredOffers) + numOfSentAcceptedOffers) + numOfSentrejectedOffers;
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] While retreiving offer statistics, an SQL Exception was thrown:" + e.getMessage());
        }
        sentGridView.setAdapter(new ArrayAdapter(this, C0185R.layout.dovik_simple_list_item_1, new String[]{"Offers", "Accepted", "Rejected", "Pending", new Integer(numOfSentOffers).toString(), new Integer(numOfSentAcceptedOffers).toString(), new Integer(numOfSentrejectedOffers).toString(), new Integer(numOfSentPendingOffers).toString()}));
        GridView receivedGridView = (GridView) findViewById(C0185R.id.gridView2);
        int numOfReceivedPendingOffers = dbAdapter.getOffersByStatus(OfferStatus.RECEIVED_NEW_OFFER.getStatusDbCode()).getCount();
        int numOfReceivedAcceptedOffers = dbAdapter.getOffersByStatus(OfferStatus.RECEIVED_AND_ACCEPTED_NEW_OFFER.getStatusDbCode()).getCount();
        int numOfReceivedRejectedOffers = dbAdapter.getOffersByStatus(OfferStatus.RECEIVED_AND_REJECTED_NEW_OFFER.getStatusDbCode()).getCount();
        numOfReceivedPendingOffers += dbAdapter.getOffersByStatus(OfferStatus.RECEIVED_AND_IGNORED_NEW_OFFER.getStatusDbCode()).getCount();
        int numOfReceivedOffers = (numOfReceivedPendingOffers + numOfReceivedAcceptedOffers) + numOfReceivedRejectedOffers;
        dbAdapter.close();
        receivedGridView.setAdapter(new ArrayAdapter(this, C0185R.layout.dovik_simple_list_item_1, new String[]{"Offers", "Accepted", "Rejected", "Pending", new Integer(numOfReceivedOffers).toString(), new Integer(numOfReceivedAcceptedOffers).toString(), new Integer(numOfReceivedRejectedOffers).toString(), new Integer(numOfReceivedPendingOffers).toString()}));
        int totalNumOfOffers = numOfReceivedOffers + numOfSentOffers;
        int totalNumOfPendingOffers = numOfReceivedPendingOffers + numOfSentPendingOffers;
        int totalNumOfAcceptedOffers = numOfReceivedAcceptedOffers + numOfSentAcceptedOffers;
        int totalNumOfRejectedOffers = numOfReceivedRejectedOffers + numOfSentrejectedOffers;
        ((GridView) findViewById(C0185R.id.gridView3)).setAdapter(new ArrayAdapter(this, C0185R.layout.dovik_simple_list_item_1, new String[]{"Offers", "Accepted", "Rejected", "Pending", new Integer(totalNumOfOffers).toString(), new Integer(totalNumOfAcceptedOffers).toString(), new Integer(totalNumOfRejectedOffers).toString(), new Integer(totalNumOfPendingOffers).toString()}));
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void next() {
        startActivity(new Intent("android.intent.action.WINDOWS"));
    }
}
