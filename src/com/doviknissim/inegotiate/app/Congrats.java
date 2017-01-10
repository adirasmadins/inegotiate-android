package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import org.codehaus.jackson.io.CharacterEscapes;

public class Congrats extends Activity {
    private final CharSequence[] _paymentMethods;
    private int _selected;

    /* renamed from: com.doviknissim.inegotiate.app.Congrats.1 */
    class C01131 implements OnClickListener {
        C01131() {
        }

        public void onClick(View v) {
            Congrats.this.payNow();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Congrats.2 */
    class C01142 implements OnClickListener {
        C01142() {
        }

        public void onClick(View v) {
            Congrats.this.payLater();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Congrats.3 */
    class C01153 implements DialogInterface.OnClickListener {
        C01153() {
        }

        public void onClick(DialogInterface dialog, int which) {
            if (which == 0) {
                Bundle extras = Congrats.this.getIntent().getExtras();
                Intent paypalIntent = new Intent("android.intent.action.INEGOTIATEPAYPAL");
                paypalIntent.putExtra("currency", extras.getString("currency"));
                paypalIntent.putExtra("amount", extras.getString("amount"));
                paypalIntent.putExtra("recipient", extras.getString("recipient"));
                Congrats.this.startActivity(paypalIntent);
                return;
            }
            dialog.cancel();
        }
    }

    public Congrats() {
        this._paymentMethods = new CharSequence[]{"PayPal", "Cancel"};
        this._selected = 0;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.congrats);
        ((Button) findViewById(C0185R.id.button1)).setOnClickListener(new C01131());
        ((Button) findViewById(C0185R.id.button2)).setOnClickListener(new C01142());
    }

    private void payNow() {
        showDialog(0);
    }

    private void payLater() {
        Toast.makeText(getApplicationContext(), "Congratulations, the offer was accepted, payment will take place later on", 0).show();
        startActivity(new Intent("android.intent.action.WINDOWS"));
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Select a payment method").setSingleChoiceItems(this._paymentMethods, this._selected, new C01153()).create();
            default:
                return null;
        }
    }
}
