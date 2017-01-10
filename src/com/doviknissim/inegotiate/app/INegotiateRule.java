package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import com.google.common.net.HttpHeaders;
import com.google.gdata.util.common.base.StringUtil;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

public class INegotiateRule extends Activity {
    private long _LONG_VALUE_UNUSED;
    private boolean _RULE_EDIT_MODE;
    private long _RULE_ID;
    private String _STRING_VALUE_UNUSED;
    private Map<String, String> _contactIdToNameMap;
    private Map<String, Long> _contactNameToIdMap;
    private Map<String, String> _productIdToNameMap;
    private Map<String, Long> _productNameToIdMap;
    private String[] _ruleActions;
    private String[] _ruleContactNames;
    private String[] _ruleProductNames;
    private String[] _ruleTypes;

    /* renamed from: com.doviknissim.inegotiate.app.INegotiateRule.1 */
    class C01441 implements OnClickListener {
        C01441() {
        }

        public void onClick(View v) {
            INegotiateRule.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.INegotiateRule.2 */
    class C01452 implements OnClickListener {
        C01452() {
        }

        public void onClick(View v) {
            if (INegotiateRule.this._RULE_EDIT_MODE) {
                INegotiateRule.this.deleteRule(INegotiateRule.this._RULE_ID);
                INegotiateRule.this.setResult(-1);
                INegotiateRule.this.finish();
                return;
            }
            INegotiateRule.this.setResult(0);
            INegotiateRule.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.INegotiateRule.3 */
    class C01463 implements OnClickListener {
        C01463() {
        }

        public void onClick(View v) {
            INegotiateRule.this.addRule();
        }
    }

    public INegotiateRule() {
        this._ruleTypes = new String[]{HttpHeaders.RANGE, "Product/Contact"};
        this._ruleActions = new String[]{HttpHeaders.ACCEPT, "Reject", "Ignore"};
        this._ruleProductNames = null;
        this._productNameToIdMap = null;
        this._productIdToNameMap = null;
        this._ruleContactNames = null;
        this._contactNameToIdMap = null;
        this._contactIdToNameMap = null;
        this._STRING_VALUE_UNUSED = StringUtil.EMPTY_STRING;
        this._LONG_VALUE_UNUSED = 0;
        this._RULE_EDIT_MODE = false;
        this._RULE_ID = -1;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.rule);
        ((ImageView) findViewById(C0185R.id.backImageButton)).setOnClickListener(new C01441());
        ((Button) findViewById(C0185R.id.cancelButton)).setOnClickListener(new C01452());
        ((Button) findViewById(C0185R.id.saveButton)).setOnClickListener(new C01463());
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            this._RULE_EDIT_MODE = false;
            this._RULE_ID = -1;
        } else {
            String ruleIdAsString = extras.getString("ruleId");
            Log.d("iNegotiate", "[DEBUG] found rule Id " + ruleIdAsString);
            if (ruleIdAsString == null || ruleIdAsString.equals(StringUtil.EMPTY_STRING)) {
                this._RULE_EDIT_MODE = false;
                this._RULE_ID = -1;
            } else {
                this._RULE_EDIT_MODE = true;
                this._RULE_ID = Long.parseLong(ruleIdAsString);
            }
        }
        populate();
    }

    private void populate() {
        Spinner typesSpinner = (Spinner) findViewById(C0185R.id.typeSpinner);
        ArrayAdapter<String> typesDataAdapter = new ArrayAdapter(this, 17367048, this._ruleTypes);
        typesDataAdapter.setDropDownViewResource(17367049);
        typesSpinner.setAdapter(typesDataAdapter);
        Spinner actionSpinner = (Spinner) findViewById(C0185R.id.actionSpinner);
        ArrayAdapter<String> actionDataAdapter = new ArrayAdapter(this, 17367048, this._ruleActions);
        actionDataAdapter.setDropDownViewResource(17367049);
        actionSpinner.setAdapter(actionDataAdapter);
        populateProducts();
        populateContacts();
        if (this._RULE_EDIT_MODE) {
            populateEditRule(this._RULE_ID);
        }
    }

    private void populateProducts() {
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            Cursor c = db.getAllProducts();
            if (c == null || c.getCount() == 0) {
                this._ruleProductNames = new String[]{"No available products"};
                this._productNameToIdMap = new HashMap();
                this._productIdToNameMap = new HashMap();
                this._ruleProductNames[0] = "All products";
                this._productNameToIdMap.put("All products", new Long(0));
                this._productIdToNameMap.put("0", "All products");
                return;
            }
            this._ruleProductNames = new String[(c.getCount() + 1)];
            this._productNameToIdMap = new HashMap();
            this._productIdToNameMap = new HashMap();
            this._ruleProductNames[0] = "All products";
            this._productNameToIdMap.put("All products", new Long(0));
            this._productIdToNameMap.put("0", "All products");
            c.moveToFirst();
            int i = 1;
            while (!c.isAfterLast()) {
                this._ruleProductNames[i] = c.getString(1);
                this._productNameToIdMap.put(c.getString(1), new Long((long) c.getInt(0)));
                this._productIdToNameMap.put(c.getInt(0), c.getString(1));
                c.moveToNext();
                i++;
            }
            Spinner productSpinner = (Spinner) findViewById(C0185R.id.productSpinner);
            ArrayAdapter<String> productDataAdapter = new ArrayAdapter(this, 17367048, this._ruleProductNames);
            productDataAdapter.setDropDownViewResource(17367049);
            productSpinner.setAdapter(productDataAdapter);
            db.close();
        } catch (SQLException e) {
            Log.e(StringUtil.EMPTY_STRING, "[ERROR] A database exception was thrown while populating products: " + e.getMessage());
        } finally {
            db.close();
        }
    }

    private void populateContacts() {
        Log.d("iNegotiate", "[DEBUG] Populate Contacts  called");
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            Cursor c = db.getAllContacts();
            if (c == null || c.getCount() == 0) {
                this._ruleContactNames = new String[]{"No available contacts"};
                this._contactNameToIdMap = new HashMap();
                this._contactIdToNameMap = new HashMap();
                this._ruleContactNames[0] = "All Contacts";
                this._contactNameToIdMap.put("All Contacts", new Long(0));
                this._contactIdToNameMap.put("0", "All Contacts");
                return;
            }
            this._ruleContactNames = new String[(c.getCount() + 1)];
            this._contactNameToIdMap = new HashMap();
            this._contactIdToNameMap = new HashMap();
            this._ruleContactNames[0] = "All Contacts";
            this._contactNameToIdMap.put("All Contacts", new Long(0));
            this._contactIdToNameMap.put("0", "All Contacts");
            c.moveToFirst();
            int i = 1;
            while (!c.isAfterLast()) {
                this._ruleContactNames[i] = c.getString(1);
                this._contactNameToIdMap.put(c.getString(1), new Long((long) c.getInt(0)));
                this._contactIdToNameMap.put(c.getInt(0), c.getString(1));
                c.moveToNext();
                i++;
            }
            Spinner contactSpinner = (Spinner) findViewById(C0185R.id.contactSpinner);
            ArrayAdapter<String> contactDataAdapter = new ArrayAdapter(this, 17367048, this._ruleContactNames);
            contactDataAdapter.setDropDownViewResource(17367049);
            contactSpinner.setAdapter(contactDataAdapter);
            db.close();
        } catch (SQLException e) {
            Log.e(StringUtil.EMPTY_STRING, "[ERROR] A database exception was thrown while populating contacts: " + e.getMessage());
        } finally {
            db.close();
        }
    }

    private void addRule() {
        if (validate()) {
            saveData();
            moveOn();
        }
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Missing required information!").setMessage("Please enter meaningful (lower and upper) range limitations.").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Missing required information!").setMessage("The range's upper limit must be greater than its lower limit").setPositiveButton("OK", null).create();
            default:
                return null;
        }
    }

    private boolean validate() {
        EditText fromET = (EditText) findViewById(C0185R.id.fromEditText);
        if (fromET.getText() == null || fromET.getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(0);
            return false;
        }
        EditText toET = (EditText) findViewById(C0185R.id.toEditText);
        if (toET.getText() == null || toET.getText().equals(StringUtil.EMPTY_STRING)) {
            showDialog(0);
            return false;
        } else if (Integer.valueOf(fromET.getText().toString()).intValue() <= Integer.valueOf(toET.getText().toString()).intValue()) {
            return true;
        } else {
            showDialog(0);
            return false;
        }
    }

    private void saveData() {
        String type = ((Spinner) findViewById(C0185R.id.typeSpinner)).getSelectedItem().toString();
        Long productId = (Long) this._productNameToIdMap.get(((Spinner) findViewById(C0185R.id.productSpinner)).getSelectedItem().toString());
        Long contactId = (Long) this._contactNameToIdMap.get(((Spinner) findViewById(C0185R.id.contactSpinner)).getSelectedItem().toString());
        long lower = Long.valueOf(((EditText) findViewById(C0185R.id.fromEditText)).getText().toString()).longValue();
        long upper = Long.valueOf(((EditText) findViewById(C0185R.id.toEditText)).getText().toString()).longValue();
        String action = ((Spinner) findViewById(C0185R.id.actionSpinner)).getSelectedItem().toString();
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            long id;
            if (this._RULE_EDIT_MODE) {
                db.updateRule(this._RULE_ID, type, productId.longValue(), contactId.longValue(), lower, upper, this._LONG_VALUE_UNUSED, this._STRING_VALUE_UNUSED, action);
                id = this._RULE_ID;
            } else {
                DBAdapter dBAdapter = db;
                id = dBAdapter.insertRule(type, productId.longValue(), contactId.longValue(), lower, upper, this._LONG_VALUE_UNUSED, this._STRING_VALUE_UNUSED, action);
            }
            db.close();
            setResult(-1);
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] Failed to insert rule to the database. Exception: " + e.getMessage());
        }
    }

    private void moveOn() {
        Log.d("iNegotiate", "[DEBUG] Calling move on ");
        finish();
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateEditRule(long r27) {
        /*
        r26 = this;
        r10 = new com.doviknissim.inegotiate.app.DBAdapter;
        r0 = r26;
        r10.<init>(r0);
        r10.open();	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r0 = r27;
        r5 = r10.getRule(r0);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        if (r5 == 0) goto L_0x0018;
    L_0x0012:
        r25 = r5.getCount();	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        if (r25 != 0) goto L_0x001c;
    L_0x0018:
        r10.close();
    L_0x001b:
        return;
    L_0x001c:
        r5.moveToFirst();	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = 2131230743; // 0x7f080017 float:1.8077547E38 double:1.0529678935E-314;
        r0 = r26;
        r1 = r25;
        r20 = r0.findViewById(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r20 = (android.widget.TextView) r20;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = "Edit Rule";
        r0 = r20;
        r1 = r25;
        r0.setText(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = 1;
        r0 = r25;
        r19 = r5.getString(r0);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = 2131230775; // 0x7f080037 float:1.8077612E38 double:1.0529679093E-314;
        r0 = r26;
        r1 = r25;
        r23 = r0.findViewById(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r23 = (android.widget.Spinner) r23;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r0 = r26;
        r0 = r0._ruleTypes;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = r0;
        r25 = java.util.Arrays.asList(r25);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r0 = r25;
        r1 = r19;
        r22 = r0.indexOf(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = -1;
        r0 = r22;
        r1 = r25;
        if (r0 == r1) goto L_0x006b;
    L_0x0064:
        r0 = r23;
        r1 = r22;
        r0.setSelection(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
    L_0x006b:
        r25 = 2;
        r0 = r25;
        r15 = r5.getString(r0);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r0 = r26;
        r0 = r0._productIdToNameMap;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = r0;
        r0 = r25;
        r16 = r0.get(r15);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r16 = (java.lang.String) r16;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = 2131230776; // 0x7f080038 float:1.8077614E38 double:1.05296791E-314;
        r0 = r26;
        r1 = r25;
        r18 = r0.findViewById(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r18 = (android.widget.Spinner) r18;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r0 = r26;
        r0 = r0._ruleProductNames;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = r0;
        r25 = java.util.Arrays.asList(r25);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r0 = r25;
        r1 = r16;
        r17 = r0.indexOf(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = -1;
        r0 = r17;
        r1 = r25;
        if (r0 == r1) goto L_0x00af;
    L_0x00a8:
        r0 = r18;
        r1 = r17;
        r0.setSelection(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
    L_0x00af:
        r25 = 3;
        r0 = r25;
        r6 = r5.getString(r0);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r0 = r26;
        r0 = r0._contactIdToNameMap;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = r0;
        r0 = r25;
        r7 = r0.get(r6);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r7 = (java.lang.String) r7;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = 2131230777; // 0x7f080039 float:1.8077616E38 double:1.0529679103E-314;
        r0 = r26;
        r1 = r25;
        r9 = r0.findViewById(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r9 = (android.widget.Spinner) r9;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r0 = r26;
        r0 = r0._ruleContactNames;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = r0;
        r25 = java.util.Arrays.asList(r25);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r0 = r25;
        r8 = r0.indexOf(r7);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = -1;
        r0 = r25;
        if (r8 == r0) goto L_0x00eb;
    L_0x00e8:
        r9.setSelection(r8);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
    L_0x00eb:
        r25 = 2131230778; // 0x7f08003a float:1.8077618E38 double:1.052967911E-314;
        r0 = r26;
        r1 = r25;
        r13 = r0.findViewById(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r13 = (android.widget.EditText) r13;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = 4;
        r0 = r25;
        r14 = r5.getString(r0);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r13.setText(r14);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = 2131230779; // 0x7f08003b float:1.807762E38 double:1.0529679113E-314;
        r0 = r26;
        r1 = r25;
        r21 = r0.findViewById(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r21 = (android.widget.EditText) r21;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = 5;
        r0 = r25;
        r24 = r5.getString(r0);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r0 = r21;
        r1 = r24;
        r0.setText(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = 8;
        r0 = r25;
        r2 = r5.getString(r0);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = 2131230780; // 0x7f08003c float:1.8077622E38 double:1.052967912E-314;
        r0 = r26;
        r1 = r25;
        r4 = r0.findViewById(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r4 = (android.widget.Spinner) r4;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r0 = r26;
        r0 = r0._ruleActions;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = r0;
        r25 = java.util.Arrays.asList(r25);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r0 = r25;
        r3 = r0.indexOf(r2);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = -1;
        r0 = r25;
        if (r3 == r0) goto L_0x014d;
    L_0x014a:
        r4.setSelection(r3);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
    L_0x014d:
        r25 = 2131230781; // 0x7f08003d float:1.8077624E38 double:1.0529679123E-314;
        r0 = r26;
        r1 = r25;
        r11 = r0.findViewById(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r11 = (android.widget.Button) r11;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = "Delete";
        r0 = r25;
        r11.setText(r0);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = 2131230782; // 0x7f08003e float:1.8077626E38 double:1.0529679127E-314;
        r0 = r26;
        r1 = r25;
        r12 = r0.findViewById(r1);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r12 = (android.widget.Button) r12;	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r25 = "Edit";
        r0 = r25;
        r12.setText(r0);	 Catch:{ SQLException -> 0x017a, all -> 0x0180 }
        r10.close();
        goto L_0x001b;
    L_0x017a:
        r25 = move-exception;
        r10.close();
        goto L_0x001b;
    L_0x0180:
        r25 = move-exception;
        r10.close();
        throw r25;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doviknissim.inegotiate.app.INegotiateRule.populateEditRule(long):void");
    }

    private void deleteRule(long ruleId) {
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            db.deleteRule(ruleId);
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] Failed to delete rule. ( rule Id " + ruleId + " Exception is: " + e.getMessage());
        } finally {
            db.close();
        }
    }
}
