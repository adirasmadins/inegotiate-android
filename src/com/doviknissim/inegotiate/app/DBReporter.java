package com.doviknissim.inegotiate.app;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import java.sql.SQLException;

public class DBReporter {
    private DBAdapter db;

    public DBReporter(Context context) {
        this.db = null;
        this.db = new DBAdapter(context);
    }

    public void reportAllOffers() {
        try {
            this.db.open();
            Cursor c = this.db.getAllOffers();
            if (c == null || c.getCount() == 0) {
                Log.d("iNegotiate", "***********************************************");
                Log.d("iNegotiate", "*** There are No offers available!          ***");
                Log.d("iNegotiate", "***********************************************");
                return;
            }
            int count = c.getCount();
            Log.d("iNegotiate", "***********************************************");
            Log.d("iNegotiate", "*** There are " + count + " offers available! ***");
            Log.d("iNegotiate", "***********************************************");
            c.moveToFirst();
            while (!c.isAfterLast()) {
                Log.d("iNegotiate", "*** offer_id:  " + new Integer(c.getInt(0)).toString() + " ***");
                Log.d("iNegotiate", "*** product_id " + new Integer(c.getInt(1)).toString() + " ***");
                Log.d("iNegotiate", "*** contact_id " + new Integer(c.getInt(2)).toString() + " ***");
                Log.d("iNegotiate", "*** offer_date " + c.getString(3) + " ***");
                Log.d("iNegotiate", "*** offer_duedate " + c.getString(4) + " ***");
                Log.d("iNegotiate", "*** offer_amount " + c.getString(5) + " ***");
                Log.d("iNegotiate", "*** offer_status " + c.getString(6) + " ***");
                Log.d("iNegotiate", "*** offer_currency " + c.getString(7) + " ***");
                Log.d("iNegotiate", "*** offer_buyer_or_seler:  " + new Integer(c.getInt(8)).toString() + " ***");
                Log.d("iNegotiate", "*** offer_counterpart_id " + new Integer(c.getInt(9)).toString() + " ***");
                Log.d("iNegotiate", "***********************************************");
                c.moveToNext();
            }
            this.db.close();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] exception thrown: " + e.getMessage());
            this.db.close();
        }
    }

    public void reportAllProducts() {
        try {
            this.db.open();
            Cursor c = this.db.getAllProducts();
            if (c == null || c.getCount() == 0) {
                Log.d("iNegotiate", "***********************************************");
                Log.d("iNegotiate", "*** There are No products available!          ***");
                Log.d("iNegotiate", "***********************************************");
                return;
            }
            int count = c.getCount();
            Log.d("iNegotiate", "***********************************************");
            Log.d("iNegotiate", "*** There are " + count + " products available! ***");
            Log.d("iNegotiate", "***********************************************");
            c.moveToFirst();
            while (!c.isAfterLast()) {
                Log.d("iNegotiate", "*** product_id:  " + new Integer(c.getInt(0)).toString() + " ***");
                Log.d("iNegotiate", "*** product_name " + c.getString(1) + " ***");
                Log.d("iNegotiate", "*** product_description " + c.getString(2) + " ***");
                Log.d("iNegotiate", "*** product_picture " + c.getString(3) + " ***");
                Log.d("iNegotiate", "*** product_price " + c.getString(4) + " ***");
                Log.d("iNegotiate", "*** product_status " + c.getString(5) + " ***");
                Log.d("iNegotiate", "*** product_aws_bucketname " + c.getString(6) + " ***");
                Log.d("iNegotiate", "*** product_aws_picture " + c.getString(7) + " ***");
                Log.d("iNegotiate", "***********************************************");
                c.moveToNext();
            }
            this.db.close();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] exception thrown: " + e.getMessage());
            this.db.close();
        }
    }

    public void reportAllContacts() {
        try {
            this.db.open();
            Cursor c = this.db.getAllContacts();
            if (c == null || c.getCount() == 0) {
                Log.d("iNegotiate", "***********************************************");
                Log.d("iNegotiate", "*** There are No contacts available!          ***");
                Log.d("iNegotiate", "***********************************************");
                return;
            }
            int count = c.getCount();
            Log.d("iNegotiate", "***********************************************");
            Log.d("iNegotiate", "*** There are " + count + " contacts available! ***");
            Log.d("iNegotiate", "***********************************************");
            c.moveToFirst();
            while (!c.isAfterLast()) {
                Log.d("iNegotiate", "*** contact_id:  " + new Integer(c.getInt(0)).toString() + " ***");
                Log.d("iNegotiate", "*** contact_name " + c.getString(1) + " ***");
                Log.d("iNegotiate", "*** contact_description " + c.getString(2) + " ***");
                Log.d("iNegotiate", "*** contact_picture " + c.getString(3) + " ***");
                Log.d("iNegotiate", "*** contact_cell " + c.getString(4) + " ***");
                Log.d("iNegotiate", "*** contact_email " + c.getString(5) + " ***");
                Log.d("iNegotiate", "***********************************************");
                c.moveToNext();
            }
            this.db.close();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] exception thrown: " + e.getMessage());
            this.db.close();
        }
    }
}
