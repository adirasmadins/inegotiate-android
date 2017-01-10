package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
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

public class Product extends Activity {
    private static final int CAMERA_PIC_REQUEST = 133;
    private static final int GALLERY_PIC_REQUEST = 135;
    private static String IMAGE_NAME_PREFIX;
    private static long _newProductID;
    private static String _productAWSBucketName;
    private static String _productAWSPicture;
    private static String _productDescription;
    private static String _productName;
    private static String _productPhotoPath;
    private final CharSequence[] _methodsToSelectPhotos;
    private int _selected;

    /* renamed from: com.doviknissim.inegotiate.app.Product.1 */
    class C01771 implements OnClickListener {
        C01771() {
        }

        public void onClick(View v) {
            Product.this.finish();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Product.2 */
    class C01782 implements OnClickListener {
        C01782() {
        }

        public void onClick(View v) {
            Product.this.next();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Product.3 */
    class C01793 implements OnClickListener {
        C01793() {
        }

        public void onClick(View arg0) {
            Product.this.searchProductByName();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Product.4 */
    class C01804 implements OnClickListener {
        C01804() {
        }

        public void onClick(View arg0) {
            if (Product.this.isCameraIntentAvailable(Product.this)) {
                Product.this.showDialog(3);
                return;
            }
            Log.e("iNegotiate", "[ERROR] A camera is not available on this device!");
            Product.this.startActivityForResult(new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI), Product.GALLERY_PIC_REQUEST);
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Product.5 */
    class C01815 implements DialogInterface.OnClickListener {
        C01815() {
        }

        public void onClick(DialogInterface dialog, int id) {
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Product.6 */
    class C01826 implements DialogInterface.OnClickListener {
        C01826() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Product.7 */
    class C01837 implements DialogInterface.OnClickListener {
        C01837() {
        }

        public void onClick(DialogInterface arg0, int arg1) {
        }
    }

    /* renamed from: com.doviknissim.inegotiate.app.Product.8 */
    class C01848 implements DialogInterface.OnClickListener {
        C01848() {
        }

        public void onClick(DialogInterface dialog, int which) {
            if (which == 0) {
                dialog.cancel();
                Product.this.startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), Product.CAMERA_PIC_REQUEST);
            } else if (which == 1) {
                dialog.cancel();
                Product.this.startActivityForResult(new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI), Product.GALLERY_PIC_REQUEST);
            }
        }
    }

    public Product() {
        this._methodsToSelectPhotos = new CharSequence[]{"Take a picture", "Select from gallery"};
        this._selected = 0;
    }

    static {
        _productName = null;
        _productDescription = null;
        _productPhotoPath = null;
        _newProductID = 0;
        _productAWSBucketName = StringUtil.EMPTY_STRING;
        _productAWSPicture = StringUtil.EMPTY_STRING;
        IMAGE_NAME_PREFIX = "product_image_";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0185R.layout.product);
        ((Button) findViewById(C0185R.id.button1)).setOnClickListener(new C01771());
        ((Button) findViewById(C0185R.id.button2)).setOnClickListener(new C01782());
        ((ImageButton) findViewById(C0185R.id.imageButton1)).setOnClickListener(new C01793());
        ImageView iv1 = (ImageView) findViewById(C0185R.id.imageView1);
        iv1.setImageBitmap(ImageUtilities.getRoundedCornerBitmap(((BitmapDrawable) iv1.getDrawable()).getBitmap(), 20));
        iv1.setOnClickListener(new C01804());
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = null;
        if (requestCode == GALLERY_PIC_REQUEST) {
            if (resultCode == -1) {
                String[] filePathColumn = new String[]{"_data"};
                Cursor cursor = getContentResolver().query(data.getData(), filePathColumn, null, null, null);
                cursor.moveToFirst();
                String picturePath = cursor.getString(cursor.getColumnIndex(filePathColumn[0]));
                cursor.close();
                bitmap = BitmapFactory.decodeFile(picturePath);
            } else if (resultCode == 0) {
                Log.i("iNegotiate", "[INFO] the user chose to cancel (resultCode == RESULT_CANCELED) the use of gsllery to select a picture of the product.");
                return;
            } else {
                Log.i("iNegotiate", "[INFO] the user chose to cancel (resultCode == Other reason) the use of gallery to select a  picture of the product.");
                return;
            }
        }
        if (requestCode == CAMERA_PIC_REQUEST) {
            if (resultCode == -1) {
                bitmap = (Bitmap) data.getExtras().get("data");
            } else if (resultCode == 0) {
                Log.i("iNegotiate", "[INFO] the user chose to cancel (resultCode == RESULT_CANCELED) the use of his camera to take a picture of the product.");
                return;
            } else {
                Log.i("iNegotiate", "[INFO] the user chose to cancel (resultCode == Other reason) the use of his camera to take a picture of the product.");
                return;
            }
        }
        try {
            ((ImageView) findViewById(C0185R.id.imageView1)).setImageBitmap(ImageUtilities.getRoundedCornerBitmap(Bitmap.createScaledBitmap(bitmap, 120, 120, false), 20));
            File file = new File(Environment.getExternalStorageDirectory().toString(), IMAGE_NAME_PREFIX + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".jpg");
            OutputStream fOut = new FileOutputStream(file);
            bitmap.compress(CompressFormat.JPEG, 85, fOut);
            fOut.flush();
            fOut.close();
            Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());
            _productPhotoPath = file.getAbsolutePath();
            SharedPreferences sharedPreferences = getSharedPreferences("bargain-preferences", 0);
            _productAWSBucketName = prefs.getString("INEGOTIATE_BUCKETNAME", StringUtil.EMPTY_STRING);
            _productAWSPicture = file.getName();
            new AWSUploadAdapter(file, _productAWSBucketName).uploadImageToAmazonS3();
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e("iNegotiate", "[ERROR] An exception was thrown: " + e.getMessage());
            } else {
                Log.e("iNegotiate", "[ERROR] An exception was thrown: " + e.toString());
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
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
                return new Builder(this).setTitle("Invalid input!").setMessage("Please enter a meaningful product name").setPositiveButton("Ok", new C01815()).create();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new Builder(this).setTitle("Error!").setMessage("A camera is not available on this device!").setPositiveButton("Ok", new C01826()).create();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new Builder(this).setTitle("Aw Snap!!").setMessage("An unexpected error occured, please try again!").setPositiveButton("Ok", new C01837()).create();
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return new Builder(this).setTitle("Offer submitted successfully!").setSingleChoiceItems(this._methodsToSelectPhotos, this._selected, new C01848()).create();
            default:
                return null;
        }
    }

    private void saveData() {
        DBAdapter db = new DBAdapter(this);
        try {
            db.open();
            _newProductID = db.doesThisProductExist(_productName);
            if (_newProductID != -1) {
                Log.i("iNegotiate", "[INFO] This product already exists, using the existing one, (id " + _newProductID + ").");
                db.close();
                return;
            }
            _newProductID = db.insertProduct(_productName, _productDescription, _productPhotoPath, 0.0d, null, _productAWSBucketName, _productAWSPicture);
            String productIdAsString = new Long(_newProductID).toString();
            db.close();
        } catch (SQLException e) {
            Log.e("DOVIK", "[ERROR] Exception Thrown: " + e.toString());
        }
    }

    private void moveOn() {
        Intent createContactIntent = new Intent("android.intent.action.CONTACT");
        createContactIntent.putExtra("productId", new Long(_newProductID).toString());
        startActivity(createContactIntent);
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
            Log.e("iNegotiate", "[ERROR] Exception thrown: " + e.getMessage());
        }
    }
}
