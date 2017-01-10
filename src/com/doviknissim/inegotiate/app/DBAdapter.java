package com.doviknissim.inegotiate.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.google.gdata.data.ILink.Rel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBAdapter {
    public static final String CATALOGS_CATALOG_CONTACT_ID = "cataog_contact_id";
    public static final String CATALOGS_CATALOG_KEY_ROW_ID = "catalog_id";
    public static final String CATALOGS_CATALOG_NAME = "catalog_name";
    public static final String CATALOGS_TABLE = "catalogs";
    public static final String CONTACTS_CONTACT_CELL = "contact_cell";
    public static final String CONTACTS_CONTACT_DESC = "contact_description";
    public static final String CONTACTS_CONTACT_EMAIL = "contact_email";
    public static final String CONTACTS_CONTACT_NAME = "contact_name";
    public static final String CONTACTS_CONTACT_PIC = "contact_picture";
    public static final String CONTACTS_KEY_ROW_ID = "contact_id";
    public static final String CONTACTS_TABLE = "contacts";
    public static final String CURRENCY = "currentcy";
    public static final String DATABASE_CREATE_CONTACTS_TABLE = "create table contacts (contact_id Integer primary key autoincrement, contact_name text not null, contact_description text, contact_picture text, contact_cell text, contact_email text);";
    public static final String DATABASE_CREATE_OFFERS_TABLE = "create table offers (offer_id Integer primary key autoincrement, product_id Integer, contact_id Integer, offer_date text not null, offer_duedate text, offer_amount text not null, offer_status text not null, offer_currency text not null, offer_buyer_or_seler Integer, offer_history Integer, offer_contact_me text);";
    public static final String DATABASE_CREATE_PRODUCTS_TABLE = "create table products (product_id Integer primary key autoincrement, product_name text not null, product_description text, product_picture text, product_price text not null, product_status text, product_aws_bucketname text, product_aws_picture text);";
    public static final String DATABASE_CREATE_RULES_TABLE = "create table rules (rule_id Integer primary key autoincrement, rule_type text not null, rule_product_id Integer, rule_contact_id Integer, rule_range_lower_limit Integer, rule_range_upper_limit Integer, rule_target_price text, rule_due_date text, rule_action text);";
    public static final String DATABASE_NAME = "INEGOTIATE_APP_DB";
    public static final String DATABASE_TABLE = "offers";
    public static final int DATABASE_VERSION = 2;
    public static final String DATE = "date";
    public static final String DUE_DATE = "due_date";
    public static final String OFFERS_CONTACT_ID = "contact_id";
    public static final String OFFERS_KEY_ROW_ID = "offer_id";
    public static final String OFFERS_OFFER_AMOUNT = "offer_amount";
    public static final String OFFERS_OFFER_BUYER_OR_SELLER = "offer_buyer_or_seler";
    public static final String OFFERS_OFFER_CONTACT_ME = "offer_contact_me";
    public static final String OFFERS_OFFER_CURRENCY = "offer_currency";
    public static final String OFFERS_OFFER_DATE = "offer_date";
    public static final String OFFERS_OFFER_DUEDATE = "offer_duedate";
    public static final String OFFERS_OFFER_HISTORY = "offer_history";
    public static final String OFFERS_OFFER_STATUS = "offer_status";
    public static final String OFFERS_PRODUCT_ID = "product_id";
    public static final String OFFERS_TABLE = "offers";
    public static final String PRICE = "price";
    public static final String PRODUCTS_KEY_ROW_ID = "product_id";
    public static final String PRODUCTS_PRODUCT_AWS_BUCKETNAME = "product_aws_bucketname";
    public static final String PRODUCTS_PRODUCT_AWS_PIC = "product_aws_picture";
    public static final String PRODUCTS_PRODUCT_DESC = "product_description";
    public static final String PRODUCTS_PRODUCT_NAME = "product_name";
    public static final String PRODUCTS_PRODUCT_PIC = "product_picture";
    public static final String PRODUCTS_PRODUCT_PRICE = "product_price";
    public static final String PRODUCTS_PRODUCT_STATUS = "product_status";
    public static final String PRODUCTS_TABLE = "products";
    public static final String PRODUCT_DESC = "product_description";
    public static final String PRODUCT_NAME = "product_name";
    public static final String PRODUCT_PIC = "product_picture";
    public static final String RULES_RULE_ACTION = "rule_action";
    public static final String RULES_RULE_CONTACT_ID = "rule_contact_id";
    public static final String RULES_RULE_DUE_DATE = "rule_due_date";
    public static final String RULES_RULE_KEY_ROW_ID = "rule_id";
    public static final String RULES_RULE_PRODUCT_ID = "rule_product_id";
    public static final String RULES_RULE_RANGE_LOWER_LIMIT = "rule_range_lower_limit";
    public static final String RULES_RULE_RANGE_UPPER_LIMIT = "rule_range_upper_limit";
    public static final String RULES_RULE_TARGET_PRICE = "rule_target_price";
    public static final String RULES_RULE_TYPE = "rule_type";
    public static final String RULES_TABLE = "rules";
    public static final String STATUS = "status";
    private DatabaseHelper DBHelper;
    private final Context context;
    private SQLiteDatabase db;

    public static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DBAdapter.DATABASE_NAME, null, DBAdapter.DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            if (DBAdapter.checkIfDataBaseExists()) {
                Log.d("iNegotiate", "[DEBUG] database exists!");
                db = getWritableDatabase();
            }
            Log.d("iNegotiate", "[INFO] Creating Tables");
            try {
                db.execSQL(DBAdapter.DATABASE_CREATE_OFFERS_TABLE);
                db.execSQL(DBAdapter.DATABASE_CREATE_PRODUCTS_TABLE);
                db.execSQL(DBAdapter.DATABASE_CREATE_CONTACTS_TABLE);
                db.execSQL(DBAdapter.DATABASE_CREATE_RULES_TABLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("iNegotiate", "[DEBUG] Upgrading database from version " + oldVersion + " to version" + newVersion + " which will erase all old data.");
            db.execSQL("DROP TABLE IF EXISTS offers");
            db.execSQL("DROP TABLE IF EXISTS products");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            try {
                db.execSQL(DBAdapter.DATABASE_CREATE_OFFERS_TABLE);
                db.execSQL(DBAdapter.DATABASE_CREATE_PRODUCTS_TABLE);
                db.execSQL(DBAdapter.DATABASE_CREATE_CONTACTS_TABLE);
                db.execSQL(DBAdapter.DATABASE_CREATE_RULES_TABLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("iNegotiate", "[INFO] Database upgrade was completed successfully!");
        }
    }

    public DBAdapter(Context ctxt) {
        this.context = ctxt;
        this.DBHelper = new DatabaseHelper(this.context);
    }

    public DBAdapter open() throws SQLException {
        this.db = this.DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.DBHelper.close();
    }

    public static boolean checkIfDataBaseExists() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase(DATABASE_NAME, null, 1);
            checkDB.close();
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            return true;
        }
        return false;
    }

    public long insertProduct(String name, String description, String pic, double price, String status, String awsBucketName, String awsPic) {
        ContentValues initVals = new ContentValues();
        initVals.put(PRODUCT_NAME, name);
        initVals.put(PRODUCT_DESC, description);
        initVals.put(PRODUCT_PIC, pic);
        initVals.put(PRODUCTS_PRODUCT_PRICE, Double.valueOf(price));
        initVals.put(PRODUCTS_PRODUCT_STATUS, status);
        initVals.put(PRODUCTS_PRODUCT_AWS_BUCKETNAME, awsBucketName);
        initVals.put(PRODUCTS_PRODUCT_AWS_PIC, awsPic);
        initVals.put(PRODUCTS_PRODUCT_STATUS, status);
        return this.db.insert(PRODUCTS_TABLE, null, initVals);
    }

    public boolean deleteProduct(long row_id) {
        return this.db.delete(PRODUCTS_TABLE, new StringBuilder("product_id=").append(row_id).toString(), null) > 0;
    }

    public Cursor getAllProducts() {
        return this.db.query(PRODUCTS_TABLE, new String[]{PRODUCTS_KEY_ROW_ID, PRODUCT_NAME, PRODUCT_DESC, PRODUCT_PIC, PRODUCTS_PRODUCT_PRICE, PRODUCTS_PRODUCT_STATUS, PRODUCTS_PRODUCT_AWS_BUCKETNAME, PRODUCTS_PRODUCT_AWS_PIC}, null, null, null, null, null, null);
    }

    public Cursor getProduct(long row_id) {
        Cursor mCursor = this.db.query(true, PRODUCTS_TABLE, new String[]{PRODUCTS_KEY_ROW_ID, PRODUCT_NAME, PRODUCT_DESC, PRODUCT_PIC, PRODUCTS_PRODUCT_PRICE, PRODUCTS_PRODUCT_STATUS, PRODUCTS_PRODUCT_AWS_BUCKETNAME, PRODUCTS_PRODUCT_AWS_PIC}, "product_id=" + row_id, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor getProductByName(String name) {
        Cursor mCursor = this.db.query(true, PRODUCTS_TABLE, new String[]{PRODUCTS_KEY_ROW_ID, PRODUCT_NAME, PRODUCT_DESC, PRODUCT_PIC, PRODUCTS_PRODUCT_PRICE, PRODUCTS_PRODUCT_STATUS, PRODUCTS_PRODUCT_AWS_BUCKETNAME, PRODUCTS_PRODUCT_AWS_PIC}, "product_name=?", new String[]{name}, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateProduct(long row_id, String name, String description, String pic, double price, String status, String awsBucketName, String awsPic) {
        ContentValues args = new ContentValues();
        args.put(PRODUCT_NAME, name);
        args.put(PRODUCT_DESC, description);
        args.put(PRODUCT_PIC, pic);
        args.put(PRODUCTS_PRODUCT_PRICE, Double.valueOf(price));
        args.put(PRODUCTS_PRODUCT_STATUS, status);
        args.put(PRODUCTS_PRODUCT_AWS_BUCKETNAME, awsBucketName);
        args.put(PRODUCTS_PRODUCT_AWS_PIC, awsPic);
        return this.db.update(PRODUCTS_TABLE, args, new StringBuilder("product_id=").append(row_id).toString(), null) > 0;
    }

    public Cursor searchProductsByName(String searchString) {
        return this.db.query(PRODUCTS_TABLE, new String[]{PRODUCTS_KEY_ROW_ID}, "product_name like '%" + searchString + "%'", null, null, null, null);
    }

    public long doesThisProductExist(String productName) {
        Cursor c = this.db.query(PRODUCTS_TABLE, new String[]{PRODUCTS_KEY_ROW_ID}, "product_name=?", new String[]{productName}, null, null, null);
        if (c == null || c.getCount() == 0) {
            return -1;
        }
        c.moveToFirst();
        return Long.valueOf(c.getString(0)).longValue();
    }

    public long insertOffer(long productId, long contactId, String date, String duedate, long amount, String status, String currency, long buyerOrSeller, String history, String contactMe) {
        ContentValues initVals = new ContentValues();
        initVals.put(PRODUCTS_KEY_ROW_ID, new Long(productId));
        initVals.put(OFFERS_CONTACT_ID, new Long(contactId));
        initVals.put(OFFERS_OFFER_DATE, date);
        initVals.put(OFFERS_OFFER_DUEDATE, duedate);
        initVals.put(OFFERS_OFFER_AMOUNT, new Long(amount));
        initVals.put(OFFERS_OFFER_STATUS, status);
        initVals.put(OFFERS_OFFER_CURRENCY, currency);
        initVals.put(OFFERS_OFFER_BUYER_OR_SELLER, new Long(buyerOrSeller));
        initVals.put(OFFERS_OFFER_HISTORY, history);
        initVals.put(OFFERS_OFFER_CONTACT_ME, contactMe);
        return this.db.insert(OFFERS_TABLE, null, initVals);
    }

    public boolean deleteOffer(long row_id) {
        return this.db.delete(OFFERS_TABLE, new StringBuilder("offer_id=").append(row_id).toString(), null) > 0;
    }

    public Cursor getAllOffers() {
        return this.db.query(OFFERS_TABLE, new String[]{OFFERS_KEY_ROW_ID, PRODUCTS_KEY_ROW_ID, OFFERS_CONTACT_ID, OFFERS_OFFER_DATE, OFFERS_OFFER_DUEDATE, OFFERS_OFFER_AMOUNT, OFFERS_OFFER_STATUS, OFFERS_OFFER_CURRENCY, OFFERS_OFFER_BUYER_OR_SELLER, OFFERS_OFFER_HISTORY, OFFERS_OFFER_CONTACT_ME}, null, null, null, null, null, null);
    }

    public Cursor getOffersByStatus(String status) {
        return this.db.query(OFFERS_TABLE, new String[]{OFFERS_KEY_ROW_ID, PRODUCTS_KEY_ROW_ID, OFFERS_CONTACT_ID, OFFERS_OFFER_DATE, OFFERS_OFFER_DUEDATE, OFFERS_OFFER_AMOUNT, OFFERS_OFFER_STATUS, OFFERS_OFFER_CURRENCY, OFFERS_OFFER_BUYER_OR_SELLER, OFFERS_OFFER_HISTORY, OFFERS_OFFER_CONTACT_ME}, "offer_status=?", new String[]{status}, null, null, null);
    }

    public Cursor getOfferByID(String id) {
        return this.db.query(OFFERS_TABLE, new String[]{OFFERS_KEY_ROW_ID, PRODUCTS_KEY_ROW_ID, OFFERS_CONTACT_ID, OFFERS_OFFER_DATE, OFFERS_OFFER_DUEDATE, OFFERS_OFFER_AMOUNT, OFFERS_OFFER_STATUS, OFFERS_OFFER_CURRENCY, OFFERS_OFFER_BUYER_OR_SELLER, OFFERS_OFFER_HISTORY, OFFERS_OFFER_CONTACT_ME}, "offer_id=?", new String[]{id}, null, null, null);
    }

    public Cursor getOffer(long row_id) {
        return this.db.query(true, OFFERS_TABLE, new String[]{OFFERS_KEY_ROW_ID, PRODUCTS_KEY_ROW_ID, OFFERS_CONTACT_ID, OFFERS_OFFER_DATE, OFFERS_OFFER_DUEDATE, OFFERS_OFFER_AMOUNT, OFFERS_OFFER_STATUS, OFFERS_OFFER_CURRENCY, OFFERS_OFFER_BUYER_OR_SELLER, OFFERS_OFFER_HISTORY, OFFERS_OFFER_CONTACT_ME}, "offer_id=" + row_id, null, null, null, null, null);
    }

    public boolean updateOffer(long row_id, String productId, String contactId, String date, String duedate, String amount, String status, String currency, long buyerOrSeller, long counterpartId, String contactMe) {
        ContentValues args = new ContentValues();
        args.put(PRODUCTS_KEY_ROW_ID, new Long(productId));
        args.put(OFFERS_CONTACT_ID, new Long(contactId));
        args.put(OFFERS_OFFER_DATE, date);
        args.put(OFFERS_OFFER_DUEDATE, duedate);
        args.put(OFFERS_OFFER_AMOUNT, new Integer(amount));
        args.put(OFFERS_OFFER_STATUS, status);
        args.put(OFFERS_OFFER_CURRENCY, currency);
        args.put(OFFERS_OFFER_BUYER_OR_SELLER, Long.valueOf(buyerOrSeller));
        args.put(OFFERS_OFFER_CONTACT_ME, contactMe);
        return this.db.update(OFFERS_TABLE, args, new StringBuilder("offer_id=").append(row_id).toString(), null) > 0;
    }

    public boolean updateOfferStatus(long row_id, String newStatus) {
        ContentValues args = new ContentValues();
        args.put(OFFERS_OFFER_STATUS, newStatus);
        return this.db.update(OFFERS_TABLE, args, new StringBuilder("offer_id=").append(row_id).toString(), null) > 0;
    }

    public boolean updateOfferHistory(long row_id, String newHistory) {
        ContentValues args = new ContentValues();
        args.put(OFFERS_OFFER_HISTORY, newHistory);
        return this.db.update(OFFERS_TABLE, args, new StringBuilder("offer_id=").append(row_id).toString(), null) > 0;
    }

    public Cursor getOffersByProductId(long productId) {
        return this.db.query(true, OFFERS_TABLE, new String[]{OFFERS_KEY_ROW_ID, PRODUCTS_KEY_ROW_ID, OFFERS_CONTACT_ID, OFFERS_OFFER_DATE, OFFERS_OFFER_DUEDATE, OFFERS_OFFER_AMOUNT, OFFERS_OFFER_STATUS, OFFERS_OFFER_CURRENCY, OFFERS_OFFER_BUYER_OR_SELLER, OFFERS_OFFER_HISTORY, OFFERS_OFFER_CONTACT_ME}, "product_id=" + productId, null, null, null, null, null);
    }

    public List<String> getOfferHistory(long offerId, String mode) {
        List<String> thisOffer = new ArrayList();
        thisOffer.add(new Long(offerId).toString());
        if (offerId == -1) {
            return thisOffer;
        }
        Cursor c = getOffer(offerId);
        if (c == null || c.getCount() == 0) {
            return thisOffer;
        }
        c.moveToFirst();
        String history = c.getString(9);
        if (history == null || history.length() == 0) {
            return thisOffer;
        }
        List<String> response = new ArrayList();
        String[] historyArr = history.split("|");
        long previousOfferId = Long.valueOf(historyArr[0]).longValue();
        long nextOfferId = Long.valueOf(historyArr[1]).longValue();
        if ((mode == null || mode.equalsIgnoreCase(Rel.PREVIOUS)) && previousOfferId != -1) {
            response.addAll(getOfferHistory(previousOfferId, Rel.PREVIOUS));
        }
        response.addAll(thisOffer);
        if ((mode == null || mode.equalsIgnoreCase(Rel.NEXT)) && nextOfferId != -1) {
            response.addAll(getOfferHistory(nextOfferId, Rel.NEXT));
        }
        return response;
    }

    public long insertContact(String name, String description, String pic, String cell, String email) {
        ContentValues initVals = new ContentValues();
        initVals.put(CONTACTS_CONTACT_NAME, name);
        initVals.put(CONTACTS_CONTACT_DESC, description);
        initVals.put(CONTACTS_CONTACT_PIC, pic);
        initVals.put(CONTACTS_CONTACT_CELL, cell);
        initVals.put(CONTACTS_CONTACT_EMAIL, email);
        return this.db.insert(CONTACTS_TABLE, null, initVals);
    }

    public boolean deleteContact(long row_id) {
        return this.db.delete(CONTACTS_TABLE, new StringBuilder("contact_id=").append(row_id).toString(), null) > 0;
    }

    public Cursor getAllContacts() {
        return this.db.query(CONTACTS_TABLE, new String[]{OFFERS_CONTACT_ID, CONTACTS_CONTACT_NAME, CONTACTS_CONTACT_DESC, CONTACTS_CONTACT_PIC, CONTACTS_CONTACT_CELL, CONTACTS_CONTACT_EMAIL}, null, null, null, null, null, null);
    }

    public Cursor getContact(long row_id) {
        Cursor mCursor = this.db.query(true, CONTACTS_TABLE, new String[]{OFFERS_CONTACT_ID, CONTACTS_CONTACT_NAME, CONTACTS_CONTACT_DESC, CONTACTS_CONTACT_PIC, CONTACTS_CONTACT_CELL, CONTACTS_CONTACT_EMAIL}, "contact_id=" + row_id, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateContact(long row_id, String name, String description, String pic, String cell, String email) {
        ContentValues args = new ContentValues();
        args.put(CONTACTS_CONTACT_NAME, name);
        args.put(CONTACTS_CONTACT_DESC, description);
        args.put(CONTACTS_CONTACT_PIC, pic);
        args.put(CONTACTS_CONTACT_CELL, cell);
        args.put(CONTACTS_CONTACT_EMAIL, email);
        return this.db.update(CONTACTS_TABLE, args, new StringBuilder("contact_id=").append(row_id).toString(), null) > 0;
    }

    public Cursor searchContactByName(String searchString) {
        return this.db.query(CONTACTS_TABLE, new String[]{CONTACTS_CONTACT_NAME, CONTACTS_CONTACT_EMAIL, CONTACTS_CONTACT_CELL}, "contact_name like '%" + searchString + "%'", null, null, null, null);
    }

    public Cursor searchContactByEmailAddress(String searchString) {
        return this.db.query(CONTACTS_TABLE, new String[]{CONTACTS_CONTACT_NAME, CONTACTS_CONTACT_EMAIL, CONTACTS_CONTACT_CELL}, "contact_email like '%" + searchString + "%'", null, null, null, null);
    }

    public long doesThisContactExist(String contactName) {
        Cursor c = this.db.query(CONTACTS_TABLE, new String[]{OFFERS_CONTACT_ID}, "contact_name=?", new String[]{contactName}, null, null, null);
        if (c == null || c.getCount() == 0) {
            return -1;
        }
        c.moveToFirst();
        return Long.valueOf(c.getString(0)).longValue();
    }

    public long insertCatalog(String name, long contactId) {
        ContentValues initVals = new ContentValues();
        initVals.put(CATALOGS_CATALOG_NAME, name);
        initVals.put(CATALOGS_CATALOG_CONTACT_ID, Long.valueOf(contactId));
        return this.db.insert(CATALOGS_TABLE, null, initVals);
    }

    public boolean deleteCatlog(long row_id) {
        return this.db.delete(CATALOGS_TABLE, new StringBuilder("catalog_id=").append(row_id).toString(), null) > 0;
    }

    public Cursor getAllCatalogs() {
        return this.db.query(CATALOGS_TABLE, new String[]{CATALOGS_CATALOG_KEY_ROW_ID, CATALOGS_CATALOG_NAME, CATALOGS_CATALOG_CONTACT_ID}, null, null, null, null, null, null);
    }

    public Cursor getCatalog(long row_id) {
        Cursor mCursor = this.db.query(true, CATALOGS_TABLE, new String[]{CATALOGS_CATALOG_KEY_ROW_ID, CATALOGS_CATALOG_NAME, CATALOGS_CATALOG_CONTACT_ID}, "catalog_id=" + row_id, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateCatalog(long row_id, String name, long contactId) {
        ContentValues args = new ContentValues();
        args.put(CATALOGS_CATALOG_NAME, name);
        args.put(CATALOGS_CATALOG_CONTACT_ID, Long.valueOf(contactId));
        return this.db.update(CATALOGS_TABLE, args, new StringBuilder("catalog_id=").append(row_id).toString(), null) > 0;
    }

    public long doesThisCatalogExist(String catalogName) {
        Cursor c = this.db.query(CATALOGS_TABLE, new String[]{CATALOGS_CATALOG_KEY_ROW_ID}, "catalog_name=?", new String[]{catalogName}, null, null, null);
        if (c == null || c.getCount() == 0) {
            return -1;
        }
        c.moveToFirst();
        return Long.valueOf(c.getString(0)).longValue();
    }

    public long insertRule(String type, long productId, long contactId, long ruleLowerLimit, long ruleUpperLimit, long targetPrice, String duedate, String action) {
        ContentValues initVals = new ContentValues();
        initVals.put(RULES_RULE_TYPE, type);
        initVals.put(RULES_RULE_PRODUCT_ID, Long.valueOf(productId));
        initVals.put(RULES_RULE_CONTACT_ID, Long.valueOf(contactId));
        initVals.put(RULES_RULE_RANGE_LOWER_LIMIT, Long.valueOf(ruleLowerLimit));
        initVals.put(RULES_RULE_RANGE_UPPER_LIMIT, Long.valueOf(ruleUpperLimit));
        initVals.put(RULES_RULE_TARGET_PRICE, Long.valueOf(targetPrice));
        initVals.put(RULES_RULE_DUE_DATE, duedate);
        initVals.put(RULES_RULE_ACTION, action);
        return this.db.insert(RULES_TABLE, null, initVals);
    }

    public boolean deleteRule(long row_id) {
        return this.db.delete(RULES_TABLE, new StringBuilder("rule_id=").append(row_id).toString(), null) > 0;
    }

    public Cursor getAllRules() {
        return this.db.query(RULES_TABLE, new String[]{RULES_RULE_KEY_ROW_ID, RULES_RULE_TYPE, RULES_RULE_PRODUCT_ID, RULES_RULE_CONTACT_ID, RULES_RULE_RANGE_LOWER_LIMIT, RULES_RULE_RANGE_UPPER_LIMIT, RULES_RULE_TARGET_PRICE, RULES_RULE_DUE_DATE, RULES_RULE_ACTION}, null, null, null, null, null, null);
    }

    public Cursor getRule(long row_id) {
        Cursor mCursor = this.db.query(true, RULES_TABLE, new String[]{RULES_RULE_KEY_ROW_ID, RULES_RULE_TYPE, RULES_RULE_PRODUCT_ID, RULES_RULE_CONTACT_ID, RULES_RULE_RANGE_LOWER_LIMIT, RULES_RULE_RANGE_UPPER_LIMIT, RULES_RULE_TARGET_PRICE, RULES_RULE_DUE_DATE, RULES_RULE_ACTION}, "rule_id=" + row_id, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateRule(long row_id, String type, long productId, long contactId, long ruleLowerLimit, long ruleUpperLimit, long targetPrice, String duedate, String action) {
        ContentValues args = new ContentValues();
        args.put(RULES_RULE_TYPE, type);
        args.put(RULES_RULE_PRODUCT_ID, Long.valueOf(productId));
        args.put(RULES_RULE_CONTACT_ID, Long.valueOf(contactId));
        args.put(RULES_RULE_RANGE_LOWER_LIMIT, Long.valueOf(ruleLowerLimit));
        args.put(RULES_RULE_RANGE_UPPER_LIMIT, Long.valueOf(ruleUpperLimit));
        args.put(RULES_RULE_TARGET_PRICE, Long.valueOf(targetPrice));
        args.put(RULES_RULE_DUE_DATE, duedate);
        args.put(RULES_RULE_ACTION, action);
        return this.db.update(RULES_TABLE, args, new StringBuilder("rule_id=").append(row_id).toString(), null) > 0;
    }
}
