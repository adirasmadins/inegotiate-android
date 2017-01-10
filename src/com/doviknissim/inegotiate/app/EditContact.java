package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gdata.util.common.base.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class EditContact extends Activity {
    private static final int CAMERA_PIC_REQUEST = 134;
    private static String IMAGE_NAME_PREFIX;
    private static String _contactCell;
    private static String _contactDescription;
    private static String _contactEmail;
    private static long _contactId;
    private static String _contactName;
    private static String _contactPic;
    private static long _newContactId;
    private static long _offerId;
    private int EDIT_CONTACT_REQUEST_SUCCESS;

    /* renamed from: com.doviknissim.inegotiate.app.EditContact.1 */
    class C01271 implements OnClickListener {
        C01271() {
        }

        public void onClick(View v) {
            EditContact.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.EditContact.2 */
    class C01282 implements OnClickListener {
        C01282() {
        }

        public void onClick(View v) {
            EditContact.this.edit();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.EditContact.3 */
    class C01293 implements OnClickListener {
        C01293() {
        }

        public void onClick(View arg0) {
            EditContact.this.searchContactByName();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.EditContact.4 */
    class C01304 implements OnClickListener {
        C01304() {
        }

        public void onClick(View arg0) {
            EditContact.this.searchContactByEmailAddress();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.EditContact.5 */
    class C01315 implements OnClickListener {
        C01315() {
        }

        public void onClick(View arg0) {
            if (EditContact.this.isCameraIntentAvailable(EditContact.this)) {
                EditContact.this.startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), EditContact.CAMERA_PIC_REQUEST);
                return;
            }
            Log.e("Dovik", "[ERROR] A camera is not available on this device!");
        }
    }

    public EditContact() {
        this.EDIT_CONTACT_REQUEST_SUCCESS = 373;
    }

    static {
        _contactName = null;
        _contactEmail = null;
        _contactDescription = null;
        _contactCell = null;
        _contactPic = null;
        _newContactId = 0;
        _offerId = 0;
        _contactId = 0;
        IMAGE_NAME_PREFIX = "contact_image_";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.editcontact);
        ((Button) findViewById(C0185R.id.button1)).setOnClickListener(new C01271());
        ((Button) findViewById(C0185R.id.button2)).setOnClickListener(new C01282());
        ((ImageButton) findViewById(C0185R.id.imageButton1)).setOnClickListener(new C01293());
        ((ImageButton) findViewById(C0185R.id.imageButton2)).setOnClickListener(new C01304());
        ((ImageView) findViewById(C0185R.id.imageView1)).setOnClickListener(new C01315());
        String offerIdAsString = getIntent().getExtras().getString("offerId");
        if (offerIdAsString == null || offerIdAsString.length() == 0) {
            showDialog(2);
            return;
        }
        _offerId = Long.valueOf(offerIdAsString).longValue();
        populate(offerIdAsString);
    }

    private void populate(String offerIdAsString) {
        if (offerIdAsString == null || offerIdAsString.length() == 0) {
            Log.i("iNegotiate", "[INFO] Failed to find a valid offer Id");
            showDialog(0);
            return;
        }
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            Cursor cOffer = db.getOffer(Long.valueOf(_offerId).longValue());
            if (cOffer == null || cOffer.getCount() == 0) {
                Log.e("iNegotiate", "[ERROR] Failed to find the offer object in the database");
                showDialog(0);
                db.close();
                return;
            }
            cOffer.moveToFirst();
            String contactIdAsString = cOffer.getString(2);
            _contactId = Long.valueOf(contactIdAsString).longValue();
            if (contactIdAsString == null || contactIdAsString.length() == 0) {
                Log.e("iNegotiate", "[EROR] Failed to find a valid product Id in the offer");
                showDialog(0);
                db.close();
                return;
            }
            _contactId = Long.valueOf(contactIdAsString).longValue();
            Cursor cContact = db.getContact(_contactId);
            if (cContact == null || cContact.getCount() == 0) {
                Log.e("iNegotiate", "[ERROR] Failed to find the contact object  in the database");
                showDialog(0);
                db.close();
                return;
            }
            cContact.moveToFirst();
            String contactName = cContact.getString(1);
            if (contactName == null || contactName.length() == 0) {
                contactName = StringUtil.EMPTY_STRING;
            }
            ((TextView) findViewById(C0185R.id.editText11)).setText(contactName);
            String email = cContact.getString(5);
            if (email == null || email.length() == 0) {
                email = StringUtil.EMPTY_STRING;
            }
            ((TextView) findViewById(C0185R.id.editText13)).setText(email);
            String cell = cContact.getString(4);
            if (cell == null || cell.length() == 0) {
                cell = StringUtil.EMPTY_STRING;
            }
            ((TextView) findViewById(C0185R.id.editText14)).setText(cell);
            String url = cContact.getString(3);
            _contactPic = url;
            if (!(url == null || url.equals(StringUtil.EMPTY_STRING))) {
                File imgFile = new File(url);
                if (imgFile.exists()) {
                    ((ImageView) findViewById(C0185R.id.imageView1)).setImageBitmap(BitmapFactory.decodeFile(imgFile.getAbsolutePath()));
                }
            }
            db.close();
        } catch (SQLException e) {
            db.close();
            Log.e("iNegotiate", "[ERROR] exception thrown: " + e.getStackTrace().toString());
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

    private void edit() {
        if (validateInput()) {
            saveData();
            moveOn();
        }
    }

    private boolean validateInput() {
        EditText contactName = (EditText) findViewById(C0185R.id.editText11);
        if (contactName.getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(0);
            return false;
        }
        EditText contactEmail = (EditText) findViewById(C0185R.id.editText13);
        if (contactEmail.getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(1);
            return false;
        } else if (isEmailValid(contactEmail.getText().toString())) {
            _contactName = contactName.getText().toString();
            _contactEmail = contactEmail.getText().toString();
            _contactCell = ((EditText) findViewById(C0185R.id.editText14)).getText().toString();
            return true;
        } else {
            showDialog(2);
            return false;
        }
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Invalid input!").setMessage("Please enter a meaningful Contact Name").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Invalid input!").setMessage("Please enter a meaningful Email Address for the contact").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new Builder(this).setTitle("Invalid input!").setMessage("Please enter a valid Email Address for the contact").setPositiveButton("OK", null).create();
            default:
                return null;
        }
    }

    private void saveData() {
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            if (_contactPic == null) {
                _contactPic = StringUtil.EMPTY_STRING;
            }
            db.updateContact(_contactId, _contactName, _contactDescription, _contactPic, _contactCell, _contactEmail);
            Log.i("iNegotiate", "[INFO] Saved new Contact, id: " + _newContactId + ".");
            db.close();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] Exception Thrown: " + e.toString());
        }
    }

    private void moveOn() {
        setResult(-1);
        finish();
    }

    private boolean isEmailValid(CharSequence target) {
        try {
            return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        } catch (NullPointerException e) {
            return false;
        }
    }

    private void searchContactByEmailAddress() {
        EditText typedEmailAddress = (EditText) findViewById(C0185R.id.editText13);
        if (typedEmailAddress.getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(1);
            return;
        }
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            Cursor c = db.searchContactByEmailAddress(typedEmailAddress.getText().toString());
            if (c == null || c.getCount() == 0) {
                typedEmailAddress.setHint("No contact that matches the search string was found.");
                db.close();
                return;
            }
            c.moveToFirst();
            String searchResultName = c.getString(0);
            if (searchResultName != null) {
                ((EditText) findViewById(C0185R.id.editText11)).setText(searchResultName);
            }
            String searchResultEmail = c.getString(1);
            if (searchResultEmail != null) {
                typedEmailAddress.setText(searchResultEmail);
            }
            String searchResultCell = c.getString(2);
            if (searchResultCell != null) {
                ((EditText) findViewById(C0185R.id.editText14)).setText(searchResultCell);
            }
            db.close();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] Exception thrown: " + e.getStackTrace().toString());
        }
    }

    private void searchContactByName() {
        EditText typedName = (EditText) findViewById(C0185R.id.editText11);
        if (typedName.getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(0);
            return;
        }
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            Cursor c = db.searchContactByName(typedName.getText().toString());
            if (c == null || c.getCount() == 0) {
                typedName.setHint("No contact that matches the search string was found.");
                db.close();
                return;
            }
            c.moveToFirst();
            String searchResultName = c.getString(0);
            if (searchResultName != null) {
                typedName.setText(searchResultName);
            }
            String searchResultEmail = c.getString(1);
            if (searchResultEmail != null) {
                ((EditText) findViewById(C0185R.id.editText13)).setText(searchResultEmail);
            }
            String searchResultCell = c.getString(2);
            if (searchResultCell != null) {
                ((EditText) findViewById(C0185R.id.editText14)).setText(searchResultCell);
            }
            db.close();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] Exception thrown: " + e.getStackTrace().toString());
        }
    }

    private boolean isCameraIntentAvailable(Context context) {
        return context.getPackageManager().queryIntentActivities(new Intent("android.media.action.IMAGE_CAPTURE"), 65536).size() > 0;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Exception e;
        if (requestCode == CAMERA_PIC_REQUEST) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ((ImageView) findViewById(C0185R.id.imageView1)).setImageBitmap(Bitmap.createScaledBitmap(bitmap, 120, 120, false));
            File file = new File(Environment.getExternalStorageDirectory().toString(), IMAGE_NAME_PREFIX + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".jpg");
            try {
                OutputStream fOut = new FileOutputStream(file);
                try {
                    bitmap.compress(CompressFormat.JPEG, 85, fOut);
                    fOut.flush();
                    fOut.close();
                    Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());
                    _contactPic = file.getAbsolutePath();
                } catch (Exception e2) {
                    e = e2;
                    OutputStream outputStream = fOut;
                }
            } catch (Exception e3) {
                e = e3;
                Log.e("DOVIK", "[ERROR] An exception was thrown: " + e.getStackTrace().toString());
            }
        }
    }
}
