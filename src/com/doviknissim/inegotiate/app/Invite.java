package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.google.gdata.util.common.base.StringUtil;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class Invite extends Activity {
    private int EMAIL_REQUEST;
    private String[] _recipients;
    private String _recipientsAsString;

    /* renamed from: com.doviknissim.inegotiate.app.Invite.1 */
    class C01501 implements OnClickListener {
        C01501() {
        }

        public void onClick(View v) {
            Invite.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Invite.2 */
    class C01512 implements OnClickListener {
        C01512() {
        }

        public void onClick(View v) {
            Invite.this.startActivity(new Intent("android.intent.action.WINDOWS"));
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Invite.3 */
    class C01523 implements OnClickListener {
        C01523() {
        }

        public void onClick(View v) {
            Invite.this.invite();
        }
    }

    public Invite() {
        this._recipients = null;
        this._recipientsAsString = StringUtil.EMPTY_STRING;
        this.EMAIL_REQUEST = 173;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.invite);
        ((ImageView) findViewById(C0185R.id.backImageButton)).setOnClickListener(new C01501());
        ((Button) findViewById(C0185R.id.notnowButton)).setOnClickListener(new C01512());
        ((Button) findViewById(C0185R.id.inviteButton)).setOnClickListener(new C01523());
    }

    private void invite() {
        validateInput();
        sendInvites();
    }

    private boolean validateInput() {
        String recipientsAsString = ((EditText) findViewById(C0185R.id.editText1)).getText().toString();
        if (recipientsAsString == null || recipientsAsString.equals(StringUtil.EMPTY_STRING)) {
            showDialog(0);
            return false;
        }
        try {
            this._recipients = recipientsAsString.split(",");
            return true;
        } catch (Exception e) {
            showDialog(0);
            return false;
        }
    }

    private void sendInvites() {
        String senderName = getSharedPreferences("bargain-preferences", 0).getString("INEGOTIATE_FIRSTNAME", StringUtil.EMPTY_STRING);
        Intent emailIntent = new Intent("android.intent.action.SEND");
        emailIntent.putExtra("android.intent.extra.EMAIL", this._recipients);
        emailIntent.putExtra("android.intent.extra.SUBJECT", "You've been invited to use iNegotiate!");
        emailIntent.setType(Mimetypes.MIMETYPE_HTML);
        emailIntent.putExtra("android.intent.extra.TEXT", Html.fromHtml("<!DOCTYPE html><html><body><br>Hi, <br>" + senderName + " would like to invite you to use " + "<a href=\"https://play.google.com/store/apps/details?id=com.doviknissim.inegotiate.app/" + "\">" + "iNegotiate </a> " + "- an Android Application that provides an advanced platform for a buyer and a seller to negotiate the price of a product, a service, or an experience  in a convenient and a discrete manner. <br>" + "Please " + "<a href=\"https://play.google.com/store/apps/details?id=com.doviknissim.inegotiate.app/" + "\">" + " click here</a> to download iNegotiate from Google Play <br><br>" + "We hope you find iNegotiate helpful and fun to use." + "<br><br>Warm regards,<br>" + "<a href=\"http://inegotiate.blogspot.com" + "\">" + "The iNegotiate team</a>" + "</body></html>"));
        startActivityForResult(emailIntent, this.EMAIL_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == this.EMAIL_REQUEST) {
            Toast.makeText(getApplicationContext(), "Invites sent successfully!", 0).show();
            startActivity(new Intent("android.intent.action.WINDOWS"));
        }
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Missing required information").setMessage("Please enter a list of email adresseses separated by commas representing negotiating partners that you'd like to invite").setPositiveButton("OK", null).create();
            default:
                return null;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
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
