package com.doviknissim.inegotiate.app;

import android.database.Cursor;
import com.google.common.net.HttpHeaders;

public class RuleEnforcer {
    public static String ACTION_ACCEPT;
    public static String ACTION_IGNORE;
    public static String ACTION_REJECT;
    public static String RANGE_RULE;
    private long _amount;
    private long _contactId;
    private DBAdapter _db;
    private long _offerId;
    private long _productId;

    public java.lang.String validateIfAnyRuleAppliesAndGetAction() {
        /* JADX: method processing error */
/*
        Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r5 = this;
        r3 = r5._db;	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
        r3.open();	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
        r3 = r5._db;	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
        r0 = r3.getAllRules();	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
        if (r0 == 0) goto L_0x0013;	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
    L_0x000d:
        r3 = r0.getCount();	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
        if (r3 != 0) goto L_0x001b;
    L_0x0013:
        r3 = r5._db;
        r3.close();
        r3 = "";
    L_0x001a:
        return r3;
    L_0x001b:
        r0.moveToFirst();	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
    L_0x001e:
        r3 = r0.isAfterLast();	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
        if (r3 == 0) goto L_0x002c;
    L_0x0024:
        r3 = r5._db;
        r3.close();
        r3 = "";
        goto L_0x001a;
    L_0x002c:
        r2 = r5.validateIfRuleApplies(r0);	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
        if (r2 != 0) goto L_0x0046;	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
    L_0x0032:
        r0.moveToNext();	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
        goto L_0x001e;
    L_0x0036:
        r1 = move-exception;
        r3 = "iNegotiate";	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
        r4 = "[ERROR] an SQL Exception was thrown while retreiving rules from the database";	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
        android.util.Log.e(r3, r4);	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
        r3 = r5._db;
        r3.close();
        r3 = "";
        goto L_0x001a;
    L_0x0046:
        r3 = 8;
        r3 = r0.getString(r3);	 Catch:{ SQLException -> 0x0036, all -> 0x0052 }
        r4 = r5._db;
        r4.close();
        goto L_0x001a;
    L_0x0052:
        r3 = move-exception;
        r4 = r5._db;
        r4.close();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doviknissim.inegotiate.app.RuleEnforcer.validateIfAnyRuleAppliesAndGetAction():java.lang.String");
    }

    static {
        RANGE_RULE = HttpHeaders.RANGE;
        ACTION_ACCEPT = HttpHeaders.ACCEPT;
        ACTION_REJECT = "Reject";
        ACTION_IGNORE = "Ignore";
    }

    public RuleEnforcer(long offerId, long productId, long contactId, long amount, DBAdapter db) {
        this._offerId = -1;
        this._productId = -1;
        this._contactId = -1;
        this._amount = -1;
        this._db = null;
        this._offerId = offerId;
        this._productId = productId;
        this._contactId = contactId;
        this._amount = amount;
        this._db = db;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enforceRules() {
        /*
        r6 = this;
        r3 = r6._db;	 Catch:{ SQLException -> 0x0050 }
        r3.open();	 Catch:{ SQLException -> 0x0050 }
        r3 = r6._db;	 Catch:{ SQLException -> 0x0050 }
        r0 = r3.getAllRules();	 Catch:{ SQLException -> 0x0050 }
        r3 = "iNegotiate";
        r4 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x0050 }
        r5 = "[DEBUG] retrieved ";
        r4.<init>(r5);	 Catch:{ SQLException -> 0x0050 }
        r5 = r0.getCount();	 Catch:{ SQLException -> 0x0050 }
        r4 = r4.append(r5);	 Catch:{ SQLException -> 0x0050 }
        r5 = " rules";
        r4 = r4.append(r5);	 Catch:{ SQLException -> 0x0050 }
        r4 = r4.toString();	 Catch:{ SQLException -> 0x0050 }
        android.util.Log.d(r3, r4);	 Catch:{ SQLException -> 0x0050 }
        if (r0 == 0) goto L_0x0031;
    L_0x002b:
        r3 = r0.getCount();	 Catch:{ SQLException -> 0x0050 }
        if (r3 != 0) goto L_0x0037;
    L_0x0031:
        r3 = r6._db;
        r3.close();
    L_0x0036:
        return;
    L_0x0037:
        r0.moveToFirst();	 Catch:{ SQLException -> 0x0050 }
    L_0x003a:
        r3 = r0.isAfterLast();	 Catch:{ SQLException -> 0x0050 }
        if (r3 == 0) goto L_0x0046;
    L_0x0040:
        r3 = r6._db;
        r3.close();
        goto L_0x0036;
    L_0x0046:
        r2 = r6.validateIfRuleApplies(r0);	 Catch:{ SQLException -> 0x0050 }
        if (r2 != 0) goto L_0x005e;
    L_0x004c:
        r0.moveToNext();	 Catch:{ SQLException -> 0x0050 }
        goto L_0x003a;
    L_0x0050:
        r1 = move-exception;
        r3 = "iNegotiate";
        r4 = "[ERROR] an SQL Exception was thrown while retreiving rules from the database";
        android.util.Log.e(r3, r4);	 Catch:{ all -> 0x0064 }
        r3 = r6._db;
        r3.close();
        goto L_0x0036;
    L_0x005e:
        r3 = r6._db;
        r3.close();
        goto L_0x0036;
    L_0x0064:
        r3 = move-exception;
        r4 = r6._db;
        r4.close();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doviknissim.inegotiate.app.RuleEnforcer.enforceRules():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean validateIfAnyRuleApplies() {
        /*
        r6 = this;
        r3 = 0;
        r4 = r6._db;	 Catch:{ SQLException -> 0x0033 }
        r4.open();	 Catch:{ SQLException -> 0x0033 }
        r4 = r6._db;	 Catch:{ SQLException -> 0x0033 }
        r0 = r4.getAllRules();	 Catch:{ SQLException -> 0x0033 }
        if (r0 == 0) goto L_0x0014;
    L_0x000e:
        r4 = r0.getCount();	 Catch:{ SQLException -> 0x0033 }
        if (r4 != 0) goto L_0x001a;
    L_0x0014:
        r4 = r6._db;
        r4.close();
    L_0x0019:
        return r3;
    L_0x001a:
        r0.moveToFirst();	 Catch:{ SQLException -> 0x0033 }
    L_0x001d:
        r4 = r0.isAfterLast();	 Catch:{ SQLException -> 0x0033 }
        if (r4 == 0) goto L_0x0029;
    L_0x0023:
        r4 = r6._db;
        r4.close();
        goto L_0x0019;
    L_0x0029:
        r2 = r6.validateIfRuleApplies(r0);	 Catch:{ SQLException -> 0x0033 }
        if (r2 != 0) goto L_0x0041;
    L_0x002f:
        r0.moveToNext();	 Catch:{ SQLException -> 0x0033 }
        goto L_0x001d;
    L_0x0033:
        r1 = move-exception;
        r4 = "iNegotiate";
        r5 = "[ERROR] an SQL Exception was thrown while retreiving rules from the database";
        android.util.Log.e(r4, r5);	 Catch:{ all -> 0x0048 }
        r4 = r6._db;
        r4.close();
        goto L_0x0019;
    L_0x0041:
        r3 = r6._db;
        r3.close();
        r3 = 1;
        goto L_0x0019;
    L_0x0048:
        r3 = move-exception;
        r4 = r6._db;
        r4.close();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doviknissim.inegotiate.app.RuleEnforcer.validateIfAnyRuleApplies():boolean");
    }

    private boolean validateIfRuleApplies(Cursor c) {
        if (!c.getString(1).equals(RANGE_RULE)) {
            return false;
        }
        long productId = c.getLong(2);
        if (productId != this._productId && productId > 0) {
            return false;
        }
        long contactId = c.getLong(3);
        if (contactId != this._contactId && contactId > 0) {
            return false;
        }
        long lowerLimit = c.getLong(4);
        long upperLimit = c.getLong(5);
        if (this._amount < lowerLimit || this._amount > upperLimit) {
            return false;
        }
        return true;
    }
}
