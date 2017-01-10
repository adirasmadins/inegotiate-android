package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gdata.util.common.base.StringUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class OffersAdapter extends ArrayAdapter<OfferObject> {
    private Activity context;
    private ArrayList<OfferObject> offersDataItems;

    public OffersAdapter(Activity context, int textViewResourceId, ArrayList<OfferObject> offersDataItems) {
        super(context, textViewResourceId, offersDataItems);
        this.context = context;
        this.offersDataItems = offersDataItems;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C0185R.layout.list_item, null);
        }
        OfferObject offer = (OfferObject) this.offersDataItems.get(position);
        if (offer != null) {
            int buyerOrSeller = offer.getBuyerOrSeller();
            TextView amountTextView = (TextView) view.findViewById(C0185R.id.middletext);
            if (buyerOrSeller == 0) {
                amountTextView.setText("Received offer:  " + offer.getAmount() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + offer.getCurrency());
                amountTextView.setTextColor(Color.parseColor("#ff9900"));
            } else {
                amountTextView.setText("Sent offer:  " + offer.getAmount() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + offer.getCurrency());
            }
            TextView nameTextView = (TextView) view.findViewById(C0185R.id.toptext);
            if (buyerOrSeller == 0) {
                nameTextView.setText("Item:  " + offer.getProduct());
                nameTextView.setTextColor(Color.parseColor("#ff9900"));
            } else {
                nameTextView.setText("Item:  " + offer.getProduct());
            }
            TextView contactTextView = (TextView) view.findViewById(C0185R.id.bottomtext);
            if (offer.getBuyerOrSeller() == 1) {
                contactTextView.setText("Recipient:  " + offer.getContact());
            } else {
                contactTextView.setText("Sender:  " + offer.getContact());
                contactTextView.setTextColor(Color.parseColor("#ff9900"));
            }
            String url = offer.getPicturePath();
            if (!(url == null || url.equals(StringUtil.EMPTY_STRING))) {
                File imgFile = new File(url);
                if (imgFile.exists()) {
                    ImageUtilities iu = new ImageUtilities(decodeSampledBitmapFromFile(imgFile.getAbsolutePath(), 65, 65), 20);
                    iu.getRoundedCornerBitmap();
                    ((ImageView) view.findViewById(C0185R.id.icon)).setImageBitmap(iu.getOutput());
                }
            }
        }
        return view;
    }

    public void sort() {
        if (this.offersDataItems != null && this.offersDataItems.size() != 0 && this.offersDataItems.size() != 1) {
            Collections.sort(this.offersDataItems);
        }
    }

    public static Bitmap decodeSampledBitmapFromFile(String filePath, int reqWidth, int reqHeight) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    public static int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        if (height <= reqHeight && width <= reqWidth) {
            return 1;
        }
        if (width > height) {
            return Math.round(((float) height) / ((float) reqHeight));
        }
        return Math.round(((float) width) / ((float) reqWidth));
    }
}
