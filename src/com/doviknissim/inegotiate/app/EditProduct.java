package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
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

public class EditProduct extends Activity {
    private static final int CAMERA_PIC_REQUEST = 133;
    private static String IMAGE_NAME_PREFIX;
    private static long _offerId;
    private static String _productDescription;
    private static long _productID;
    private static String _productName;
    private static String _productPhotoPath;
    private int EDIT_PRODUCT_REQUEST_SUCCESS;

    /* renamed from: com.doviknissim.inegotiate.app.EditProduct.1 */
    class C01351 implements OnClickListener {
        C01351() {
        }

        public void onClick(View v) {
            EditProduct.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.EditProduct.2 */
    class C01362 implements OnClickListener {
        C01362() {
        }

        public void onClick(View v) {
            EditProduct.this.edit();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.EditProduct.3 */
    class C01373 implements OnClickListener {
        C01373() {
        }

        public void onClick(View arg0) {
            EditProduct.this.searchProductByName();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.EditProduct.4 */
    class C01384 implements OnClickListener {
        C01384() {
        }

        public void onClick(View arg0) {
            if (EditProduct.this.isCameraIntentAvailable(EditProduct.this)) {
                EditProduct.this.startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), EditProduct.CAMERA_PIC_REQUEST);
                return;
            }
            Log.e("Dovik", "[ERROR] A camera is not available on this device!");
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.EditProduct.5 */
    class C01395 implements DialogInterface.OnClickListener {
        C01395() {
        }

        public void onClick(DialogInterface dialog, int id) {
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.EditProduct.6 */
    class C01406 implements DialogInterface.OnClickListener {
        C01406() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.EditProduct.7 */
    class C01417 implements DialogInterface.OnClickListener {
        C01417() {
        }

        public void onClick(DialogInterface arg0, int arg1) {
        }
    }

    public EditProduct() {
        this.EDIT_PRODUCT_REQUEST_SUCCESS = 173;
    }

    static {
        _productName = null;
        _productDescription = null;
        _productPhotoPath = null;
        _productID = 0;
        _offerId = 0;
        IMAGE_NAME_PREFIX = "product_image_";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.editproduct);
        ((Button) findViewById(C0185R.id.button1)).setOnClickListener(new C01351());
        ((Button) findViewById(C0185R.id.button2)).setOnClickListener(new C01362());
        ((ImageButton) findViewById(C0185R.id.imageButton1)).setOnClickListener(new C01373());
        ((ImageView) findViewById(C0185R.id.imageView1)).setOnClickListener(new C01384());
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
            String productIdAsString = cOffer.getString(1);
            _productID = Long.valueOf(productIdAsString).longValue();
            if (productIdAsString == null || productIdAsString.length() == 0) {
                Log.e("iNegotiate", "[EROR] Failed to find a valid product Id in the offer");
                showDialog(0);
                db.close();
                return;
            }
            Cursor cProduct = db.getProduct(Long.valueOf(productIdAsString).longValue());
            if (cProduct == null || cProduct.getCount() == 0) {
                Log.e("iNegotiate", "[ERROR] Failed to find the product object  in the database");
                showDialog(0);
                db.close();
                return;
            }
            cProduct.moveToFirst();
            String productName = cProduct.getString(1);
            if (productName == null || productName.length() == 0) {
                productName = StringUtil.EMPTY_STRING;
            }
            ((TextView) findViewById(C0185R.id.editText1)).setText(productName);
            String description = cProduct.getString(2);
            if (description == null || description.length() == 0) {
                description = StringUtil.EMPTY_STRING;
            }
            ((TextView) findViewById(C0185R.id.editText4)).setText(description);
            String url = cProduct.getString(3);
            _productPhotoPath = url;
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
                    _productPhotoPath = file.getAbsolutePath();
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
        EditText productName = (EditText) findViewById(C0185R.id.editText1);
        if (productName.getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(0);
            return false;
        }
        _productName = productName.getText().toString();
        _productDescription = ((EditText) findViewById(C0185R.id.editText4)).getText().toString();
        return true;
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return new Builder(this).setTitle("Aw Snap!!").setMessage("Please enter a meaningful product name").setPositiveButton("Ok", new C01395()).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Error!").setMessage("A camera is not available on this device!").setPositiveButton("Ok", new C01406()).create();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new Builder(this).setTitle("Aw Snap!").setMessage("An unexpected error occured, please try again!").setPositiveButton("Ok", new C01417()).create();
            default:
                return null;
        }
    }

    private void saveData() {
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            db.updateProduct(_productID, _productName, _productDescription, _productPhotoPath, 0.0d, null, StringUtil.EMPTY_STRING, StringUtil.EMPTY_STRING);
            setResult(-1);
            db.close();
        } catch (SQLException e) {
            Log.e("DOVIK", "[ERROR] Exception Thrown: " + e.toString());
            setResult(0);
            db.close();
        }
    }

    private void moveOn() {
        setResult(-1);
        finish();
    }

    private boolean isCameraIntentAvailable(Context context) {
        return context.getPackageManager().queryIntentActivities(new Intent("android.media.action.IMAGE_CAPTURE"), 65536).size() > 0;
    }

    private void searchProductByName() {
        EditText typedName = (EditText) findViewById(C0185R.id.editText1);
        if (typedName.getText().toString().equals(StringUtil.EMPTY_STRING)) {
            showDialog(0);
            return;
        }
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            Cursor c = db.getProductByName(typedName.getText().toString());
            if (c == null || c.getCount() == 0) {
                typedName.setHint("No product was found.");
                db.close();
                return;
            }
            c.moveToFirst();
            String searchResultName = c.getString(1);
            if (searchResultName != null) {
                typedName.setText(searchResultName);
            }
            String searchResultDesc = c.getString(2);
            if (searchResultDesc != null) {
                ((EditText) findViewById(C0185R.id.editText4)).setText(searchResultDesc);
            }
            db.close();
        } catch (SQLException e) {
            Log.e("iNegotiate", "[ERROR] Exception thrown: " + e.getStackTrace().toString());
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
