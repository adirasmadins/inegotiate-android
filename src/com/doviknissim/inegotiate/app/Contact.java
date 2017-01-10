package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import com.google.gdata.util.common.base.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class Contact extends Activity {
    private static final int CAMERA_PIC_REQUEST = 134;
    private static String IMAGE_NAME_PREFIX;
    private static String _contactCell;
    private static String _contactDescription;
    private static String _contactEmail;
    private static String _contactName;
    private static String _contactPic;
    private static long _newContactId;
    private HashMap<String, String[]> _contactNameToObjectMap;
    private String[] _contactNames;

    /* renamed from: com.doviknissim.inegotiate.app.Contact.1 */
    class C01161 implements OnClickListener {
        C01161() {
        }

        public void onClick(View v) {
            Contact.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Contact.2 */
    class C01172 implements OnClickListener {
        C01172() {
        }

        public void onClick(View v) {
            Contact.this.next();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Contact.3 */
    class C01183 implements OnItemSelectedListener {
        C01183() {
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String itemName = (String) parent.getItemAtPosition(position);
            if (itemName == null || itemName.equals(StringUtil.EMPTY_STRING) || position == 0) {
                ((EditText) Contact.this.findViewById(C0185R.id.editText11)).requestFocus();
                return;
            }
            String[] itemObj = (String[]) Contact.this._contactNameToObjectMap.get(itemName);
            ((EditText) Contact.this.findViewById(C0185R.id.editText11)).setText(itemObj[0]);
            ((EditText) Contact.this.findViewById(C0185R.id.editText13)).setText(itemObj[1]);
            ((EditText) Contact.this.findViewById(C0185R.id.editText14)).setText(itemObj[2]);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Contact.4 */
    class C01194 implements OnClickListener {
        C01194() {
        }

        public void onClick(View arg0) {
            Contact.this.searchContactByName();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Contact.5 */
    class C01205 implements OnClickListener {
        C01205() {
        }

        public void onClick(View arg0) {
            Contact.this.searchContactByEmailAddress();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Contact.6 */
    class C01216 implements OnClickListener {
        C01216() {
        }

        public void onClick(View arg0) {
            if (Contact.this.isCameraIntentAvailable(Contact.this)) {
                Contact.this.startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), Contact.CAMERA_PIC_REQUEST);
                return;
            }
            Log.e("Dovik", "[ERROR] A camera is not available on this device!");
        }
    }

    public Contact() {
        this._contactNames = null;
        this._contactNameToObjectMap = null;
    }

    static {
        _contactName = null;
        _contactEmail = null;
        _contactDescription = null;
        _contactCell = null;
        _contactPic = null;
        _newContactId = 0;
        IMAGE_NAME_PREFIX = "contact_image_";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.contact);
        ((Button) findViewById(C0185R.id.button1)).setOnClickListener(new C01161());
        ((Button) findViewById(C0185R.id.button2)).setOnClickListener(new C01172());
        populateExistingContacts();
        Spinner spinner = (Spinner) findViewById(C0185R.id.spinner1);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter(this, 17367048, this._contactNames);
        dataAdapter.setDropDownViewResource(17367049);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new C01183());
        spinner.setFocusable(true);
        spinner.requestFocus();
        ((ImageButton) findViewById(C0185R.id.imageButton1)).setOnClickListener(new C01194());
        ((ImageButton) findViewById(C0185R.id.imageButton2)).setOnClickListener(new C01205());
        ImageView iv1 = (ImageView) findViewById(C0185R.id.imageView1);
        iv1.setImageBitmap(ImageUtilities.getRoundedCornerBitmap(((BitmapDrawable) iv1.getDrawable()).getBitmap(), 20));
        iv1.setOnClickListener(new C01216());
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

    private void next() {
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

    private void populateExistingContacts() {
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            Cursor c = db.getAllContacts();
            if (c == null || c.getCount() == 0) {
                this._contactNames = new String[]{"No available contacts"};
                this._contactNameToObjectMap = new HashMap();
                return;
            }
            int contactsCount = c.getCount() + 1;
            c.moveToFirst();
            this._contactNames = new String[contactsCount];
            this._contactNameToObjectMap = new HashMap();
            this._contactNames[0] = "Touch to view contacts";
            this._contactNameToObjectMap.put("Select from existing contacts", new String[0]);
            int i = 1;
            while (!c.isAfterLast()) {
                String contName = c.getString(1);
                this._contactNames[i] = contName;
                this._contactNameToObjectMap.put(contName, new String[]{contName, c.getString(5), c.getString(4)});
                i++;
                c.moveToNext();
            }
            db.close();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] While populating the contact list, failed to open SQLite database. Error message is: " + e.getMessage());
            this._contactNames = new String[]{"Failed to retreive contacts"};
            this._contactNameToObjectMap = new HashMap();
        }
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Missing required input!").setMessage("Please enter a meaningful Contact Name").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Missing required input!").setMessage("Please enter a meaningful Email Address for the contact").setPositiveButton("OK", null).create();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new Builder(this).setTitle("Missing required input!").setMessage("Please enter a valid Email Address for the contact").setPositiveButton("OK", null).create();
            default:
                return null;
        }
    }

    private void saveData() {
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            _newContactId = db.doesThisContactExist(_contactName);
            if (_newContactId != -1) {
                Log.i("iNegotiate", "[INFO] This contact already exists, using the existing one, (id " + _newContactId + ").");
                db.close();
                return;
            }
            if (_contactPic == null) {
                _contactPic = StringUtil.EMPTY_STRING;
            }
            _newContactId = db.insertContact(_contactName, _contactDescription, _contactPic, _contactCell, _contactEmail);
            Log.i("iNegotiate", "[INFO] Saved new Contact, id: " + _newContactId + ".");
            db.close();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] Exception Thrown: " + e.toString());
        }
    }

    private void moveOn() {
        Intent createOfferIntent = new Intent("android.intent.action.OFFER");
        createOfferIntent.putExtra("productId", getIntent().getExtras().getString("productId"));
        createOfferIntent.putExtra("contactId", new Long(_newContactId).toString());
        startActivity(createOfferIntent);
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
        if (requestCode != CAMERA_PIC_REQUEST) {
            return;
        }
        if (resultCode == -1) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ((ImageView) findViewById(C0185R.id.imageView1)).setImageBitmap(ImageUtilities.getRoundedCornerBitmap(Bitmap.createScaledBitmap(bitmap, 120, 120, false), 20));
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
                Log.e("iNegotiate", "[ERROR] An exception was thrown: " + e.getMessage());
            }
        } else if (resultCode == 0) {
            Log.i("iNegotiate", "[INFO] the user chose to cancel (resultCode == RESULT_CANCELED) the use of his camera to take a picture of the contact.");
        } else {
            Log.i("iNegotiate", "[INFO] the user chose to cancel (resultCode == Other reason) the use of his camera to take a picture of the contact.");
        }
    }
}
