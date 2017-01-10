package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.gdata.util.common.base.StringUtil;
import java.util.Random;
import java.util.regex.Pattern;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class Settings extends Activity {
    private static Pattern CELL_NUMBER_PATTERN;
    private static Pattern EMAIL_ADDRESS_PATTERN;
    private String _cell;
    private String _email;
    private String _fullName;
    private SharedPreferences prefs;

    /* renamed from: com.doviknissim.inegotiate.app.Settings.1 */
    class C02021 implements OnClickListener {
        C02021() {
        }

        public void onClick(View v) {
            Settings.this.moveOn();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Settings.2 */
    class C02032 implements OnClickListener {
        C02032() {
        }

        public void onClick(View v) {
            Settings.this.moveOn();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Settings.3 */
    class C02043 implements OnClickListener {
        C02043() {
        }

        public void onClick(View v) {
            Settings.this.saveData();
        }
    }

    public Settings() {
        this._fullName = null;
        this._email = null;
        this._cell = null;
    }

    static {
        CELL_NUMBER_PATTERN = Pattern.compile("^[0-9\\-]*$");
        EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.settings);
        ((Button) findViewById(C0185R.id.button1)).setOnClickListener(new C02021());
        ((ImageView) findViewById(C0185R.id.backImageButton)).setOnClickListener(new C02032());
        ((Button) findViewById(C0185R.id.button2)).setOnClickListener(new C02043());
        loadData();
    }

    private void moveOn() {
        startActivity(new Intent("android.intent.action.WINDOWS"));
    }

    private void saveData() {
        if (validateInput()) {
            loadAndSaveToSharedPreferences();
            Toast.makeText(getApplicationContext(), "information saved successfully!", 0).show();
            startActivity(new Intent("android.intent.action.INVITE"));
        }
    }

    private boolean validateInput() {
        EditText firstName = (EditText) findViewById(C0185R.id.editText1);
        if (firstName.getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(0);
            return false;
        }
        this._fullName = firstName.getText().toString();
        EditText email = (EditText) findViewById(C0185R.id.editText4);
        if (email.getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(2);
            return false;
        }
        this._email = email.getText().toString();
        EditText cell = (EditText) findViewById(C0185R.id.editText5);
        cell.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        if (cell.getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(3);
            return false;
        }
        this._cell = cell.getText().toString();
        return true;
    }

    private void loadData() {
        this.prefs = getSharedPreferences("bargain-preferences", 0);
        String firstName = this.prefs.getString("INEGOTIATE_FIRSTNAME", StringUtil.EMPTY_STRING);
        ((EditText) findViewById(C0185R.id.editText1)).setText(firstName);
        ((EditText) findViewById(C0185R.id.editText4)).setText(this.prefs.getString("INEGOTIATE_EMAIL", StringUtil.EMPTY_STRING));
        ((EditText) findViewById(C0185R.id.editText5)).setText(this.prefs.getString("INEGOTIATE_CELL", StringUtil.EMPTY_STRING));
        if (firstName.equals(StringUtil.EMPTY_STRING)) {
            new GoogleSpreadsheetAdapter(this.prefs).updateDownloadInformation();
            showDialog(5);
        }
    }

    private void loadAndSaveToSharedPreferences() {
        this.prefs = getSharedPreferences("bargain-preferences", 0);
        Editor editor = this.prefs.edit();
        editor.putString("INEGOTIATE_FIRSTNAME", this._fullName);
        editor.putString("INEGOTIATE_EMAIL", this._email);
        editor.putString("INEGOTIATE_CELL", this._cell);
        editor.putString("INEGOTIATE_BUCKETNAME", new Long((long) (new Random().nextInt(10000000) + 30000000)).toString());
        editor.commit();
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Missing required information").setMessage("Please enter a meaningful name").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Missing required information").setMessage("Please enter a meaningful name").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new Builder(this).setTitle("Missing required information").setMessage("Please enter a meaningful e-mail address").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return new Builder(this).setTitle("Missing required information").setMessage("Please enter a meaningful phone number number").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                return new Builder(this).setTitle("First thing...").setMessage("Negotiation requires communications. As first step, please define how should your negotiating partner communicate with you. To do that, please enter your name, your e-mail address, and your phone number.").setPositiveButton("OK", null).create();
            default:
                return null;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean isValidEmail(CharSequence target) {
        try {
            EMAIL_ADDRESS_PATTERN.matcher(target).matches();
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean isValidCell(CharSequence target) {
        try {
            CELL_NUMBER_PATTERN.matcher(target).matches();
            return true;
        } catch (NullPointerException e) {
            return false;
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
