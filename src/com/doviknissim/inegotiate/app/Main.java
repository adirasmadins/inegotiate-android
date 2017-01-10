package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Bundle;
import android.util.Log;
import com.google.gdata.util.common.base.StringUtil;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

public class Main extends Activity {

    /* renamed from: com.doviknissim.inegotiate.app.Main.1 */
    class C01531 extends Thread {
        C01531() {
        }

        public void run() {
            for (int timer = 0; timer < 3000; timer += 100) {
                C01531.sleep(100);
            }
            try {
                Main.this.startingSequence();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Main.this.finish();
            }
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Main.2 */
    class C01542 implements OnClickListener {
        C01542() {
        }

        public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(268435456);
            Main.this.startActivity(intent);
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Main.3 */
    class C01553 implements OnClickListener {
        C01553() {
        }

        public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(268435456);
            Main.this.startActivity(intent);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.main);
        new C01531().start();
    }

    private void startingSequence() {
        Log.i("iNegotiate", "[INFO] *******************************************************");
        Log.i("iNegotiate", "[INFO] ***     \t\t    STARTING  iNegotiate               ***");
        Log.i("iNegotiate", "[INFO] *******************************************************");
        if (validateBasicSettings()) {
            Log.i("iNegotiate", "[INFO] Basic Settings are set and ready!");
            checkIfNFCIsEnabled();
            isNetworkAvailable();
            setStarFlag();
            startActivity(new Intent("android.intent.action.WINDOWS"));
            return;
        }
        Log.i("iNegotiate", "[INFO] Basic Settings are not in place, routing the settings page");
        startActivity(new Intent("android.intent.action.SETTINGS"));
    }

    private boolean validateBasicSettings() {
        SharedPreferences prefs = getSharedPreferences("bargain-preferences", 0);
        if (prefs.getString("INEGOTIATE_FIRSTNAME", StringUtil.EMPTY_STRING) == StringUtil.EMPTY_STRING || prefs.getString("INEGOTIATE_EMAIL", StringUtil.EMPTY_STRING) == StringUtil.EMPTY_STRING) {
            return false;
        }
        return true;
    }

    private void setStarFlag() {
        Editor editor = getSharedPreferences("bargain-preferences", 0).edit();
        editor.putString("INEGOTIATE_START", "true");
        editor.commit();
    }

    private void checkIfNFCIsEnabled() {
        NfcAdapter adapter = ((NfcManager) getSystemService("nfc")).getDefaultAdapter();
        if (adapter == null || !adapter.isEnabled()) {
            Log.i("iNegotiate", "[INFO] Please note that NFC is not enabled on this device. this application supports the use of NFC. please enable NFC via device settings.");
            showDialog(0);
            return;
        }
        Log.i("iNegotiate", "[INFO] NFC is enabled on this device");
    }

    public boolean isNetworkAvailable() {
        NetworkInfo networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            Log.i("iNegotiate", "[INFO] This device is NOT connected to the internet");
            showDialog(2);
            return false;
        }
        Log.i("iNegotiate", "[INFO] This device is connected to the internet");
        return true;
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Attention!").setMessage("Please note that NFC is not enabled on this device. this application supports the use of NFC. please enable NFC via device settings.").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Attention!").setMessage("Please note that this device is not connected to the internet. iNegotiate requires an active network connection to function properly. please launch iNegotiate after you connect your device to the internetNFC is not enabled on this device. this application supports the use of NFC. please enable NFC via device settings.").setPositiveButton("OK", new C01542()).create();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new Builder(this).setTitle("Attention!").setMessage("iNegotiate requires an active connection to the network. Unfortunately, this device does not have an active connection to the network. please ensure such a connection is available").setPositiveButton("OK", new C01553()).create();
            default:
                return null;
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("iNegotiate", "[DEBUG] Main onConfigurationChanged called");
        setContentView(C0185R.layout.main);
    }
}
