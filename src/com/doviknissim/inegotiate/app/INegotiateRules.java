package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gdata.util.common.base.StringUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class INegotiateRules extends Activity {
    private int RULE_ADDED_SUCCESSFULLY;
    private ArrayList<RuleObject> rulesItem;

    /* renamed from: com.doviknissim.inegotiate.app.INegotiateRules.1 */
    class C01471 implements OnClickListener {
        C01471() {
        }

        public void onClick(View v) {
            INegotiateRules.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.INegotiateRules.2 */
    class C01482 implements OnClickListener {
        C01482() {
        }

        public void onClick(View v) {
            INegotiateRules.this.goToAddRule();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.INegotiateRules.3 */
    class C01493 implements OnItemClickListener {
        private final /* synthetic */ ListView val$lv;

        C01493(ListView listView) {
            this.val$lv = listView;
        }

        public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long id) {
            long ruleId = ((RuleObject) this.val$lv.getItemAtPosition(position)).getRuleId();
            Intent ruleIntent = new Intent("android.intent.action.INEGOTIATERULE");
            ruleIntent.putExtra("ruleId", Long.toString(ruleId));
            INegotiateRules.this.startActivityForResult(ruleIntent, INegotiateRules.this.RULE_ADDED_SUCCESSFULLY);
        }
    }

    public INegotiateRules() {
        this.RULE_ADDED_SUCCESSFULLY = 1;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.rules);
        ((ImageView) findViewById(C0185R.id.backImageButton)).setOnClickListener(new C01471());
        ((TextView) findViewById(C0185R.id.addRuleTextView)).setOnClickListener(new C01482());
        populateRules();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void goToAddRule() {
        startActivityForResult(new Intent("android.intent.action.INEGOTIATERULE"), this.RULE_ADDED_SUCCESSFULLY);
    }

    private void populateRules() {
        DBAdapter dBAdapter = new DBAdapter(this);
        try {
            dBAdapter.open();
            Cursor cRules = dBAdapter.getAllRules();
            if (cRules == null || cRules.getCount() == 0) {
                ((TextView) findViewById(C0185R.id.empty)).setText("No rules were found.");
                ((ListView) findViewById(C0185R.id.listView1)).setVisibility(8);
                findViewById(C0185R.id.empty).setVisibility(0);
                return;
            }
            this.rulesItem = new ArrayList();
            cRules.moveToFirst();
            for (int i = 0; i < cRules.getCount(); i++) {
                int rId = cRules.getInt(0);
                String rType = cRules.getString(1);
                int productId = cRules.getInt(2);
                int contactId = cRules.getInt(3);
                int rLower = cRules.getInt(4);
                int rUpper = cRules.getInt(5);
                int rPrice = cRules.getInt(6);
                RuleObject ro = new RuleObject((long) rId, rType, (long) productId, (long) contactId, (long) rLower, (long) rUpper, (long) rPrice, cRules.getString(7), cRules.getString(8));
                ro.setProductName(getProductName((long) productId));
                ro.setContactName(getContactName((long) contactId));
                ro.setPicturePath(getProductPic((long) productId));
                this.rulesItem.add(ro);
                cRules.moveToNext();
            }
            findViewById(C0185R.id.empty).setVisibility(8);
            ListView lv = (ListView) findViewById(C0185R.id.listView1);
            lv.setVisibility(0);
            lv.setOnItemClickListener(new C01493(lv));
            lv.setAdapter(new RulesAdapter(this, 0, this.rulesItem));
            dBAdapter.close();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] a Database exception was thrown while populating rules: " + e.getMessage());
        } finally {
            dBAdapter.close();
        }
    }

    private String getProductName(long productId) {
        String name = StringUtil.EMPTY_STRING;
        DBAdapter db = new DBAdapter(this);
        if (productId < 0) {
            db.close();
            return name;
        }
        if (productId == 0) {
            try {
                name = "All products";
            } catch (SQLException e) {
                Log.e("iNegotiate", "[ERROR] Failed to bring product name for product id: " + productId + ".");
            } finally {
                db.close();
            }
        } else {
            db.open();
            Cursor c = db.getProduct(productId);
            if (c == null || c.getCount() == 0) {
                db.close();
                return name;
            }
            c.moveToFirst();
            name = c.getString(1);
            db.close();
            return name;
        }
        return name;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getProductPic(long r9) {
        /*
        r8 = this;
        r3 = "";
        r1 = new com.doviknissim.inegotiate.app.DBAdapter;
        r1.<init>(r8);
        r5 = 0;
        r5 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r5 > 0) goto L_0x0012;
    L_0x000d:
        r1.close();
        r4 = r3;
    L_0x0011:
        return r4;
    L_0x0012:
        r1.open();	 Catch:{ SQLException -> 0x0033 }
        r0 = r1.getProduct(r9);	 Catch:{ SQLException -> 0x0033 }
        if (r0 == 0) goto L_0x0021;
    L_0x001b:
        r5 = r0.getCount();	 Catch:{ SQLException -> 0x0033 }
        if (r5 != 0) goto L_0x0026;
    L_0x0021:
        r1.close();
        r4 = r3;
        goto L_0x0011;
    L_0x0026:
        r0.moveToFirst();	 Catch:{ SQLException -> 0x0033 }
        r5 = 3;
        r3 = r0.getString(r5);	 Catch:{ SQLException -> 0x0033 }
        r1.close();
    L_0x0031:
        r4 = r3;
        goto L_0x0011;
    L_0x0033:
        r2 = move-exception;
        r5 = "iNegotiate";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0052 }
        r7 = "[ERROR] Failed to bring product pic for product id: ";
        r6.<init>(r7);	 Catch:{ all -> 0x0052 }
        r6 = r6.append(r9);	 Catch:{ all -> 0x0052 }
        r7 = ".";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0052 }
        r6 = r6.toString();	 Catch:{ all -> 0x0052 }
        android.util.Log.e(r5, r6);	 Catch:{ all -> 0x0052 }
        r1.close();
        goto L_0x0031;
    L_0x0052:
        r5 = move-exception;
        r1.close();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doviknissim.inegotiate.app.INegotiateRules.getProductPic(long):java.lang.String");
    }

    private String getContactName(long contactId) {
        String name = StringUtil.EMPTY_STRING;
        DBAdapter db = new DBAdapter(this);
        if (contactId < 0) {
            db.close();
            return name;
        }
        if (contactId == 0) {
            try {
                name = "All contacts";
            } catch (SQLException e) {
                Log.e("iNegotiate", "[ERROR] Failed to bring contact name for contact id: " + contactId + ".");
            } finally {
                db.close();
            }
        } else {
            db.open();
            Cursor c = db.getContact(contactId);
            if (c == null || c.getCount() == 0) {
                db.close();
                return name;
            }
            c.moveToFirst();
            name = c.getString(1);
            db.close();
            return name;
        }
        return name;
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Invalid input!").setMessage("Please enter a search string").setPositiveButton("OK", null).create();
            default:
                return null;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("iNegotiate", "[DEBUG] Call back function back from add rule");
        if (requestCode == this.RULE_ADDED_SUCCESSFULLY && resultCode == -1) {
            populateRules();
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
            Log.d("Activity", "Touch event " + event.getRawX() + "," + event.getRawY() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + x + "," + y + " rect " + w.getLeft() + "," + w.getTop() + "," + w.getRight() + "," + w.getBottom() + " coords " + scrcoords[0] + "," + scrcoords[1]);
            if (event.getAction() == 1 && (x < ((float) w.getLeft()) || x >= ((float) w.getRight()) || y < ((float) w.getTop()) || y > ((float) w.getBottom()))) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
    }
}
