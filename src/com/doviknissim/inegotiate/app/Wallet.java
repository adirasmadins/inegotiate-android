package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Wallet extends Activity {

    /* renamed from: com.doviknissim.inegotiate.app.Wallet.1 */
    class C02081 implements OnClickListener {
        C02081() {
        }

        public void onClick(View v) {
            Wallet.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Wallet.2 */
    class C02092 implements OnClickListener {
        C02092() {
        }

        public void onClick(View v) {
            Wallet.this.next();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.wallet);
        ((Button) findViewById(C0185R.id.button1)).setOnClickListener(new C02081());
        ((Button) findViewById(C0185R.id.button2)).setOnClickListener(new C02092());
    }

    private void next() {
        startActivity(new Intent("android.intent.action.WINDOWS"));
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }
}
