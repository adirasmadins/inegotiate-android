package com.doviknissim.inegotiate.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;

public class ImageUtilities {
    private Bitmap _bitmap;
    private Bitmap _output;
    private int _pixels;

    public class ImageRoundCornersTask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... unused) {
            ImageUtilities.this._output = Bitmap.createBitmap(ImageUtilities.this._bitmap.getWidth(), ImageUtilities.this._bitmap.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(ImageUtilities.this._output);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, ImageUtilities.this._bitmap.getWidth(), ImageUtilities.this._bitmap.getHeight());
            RectF rectF = new RectF(rect);
            float roundPx = (float) ImageUtilities.this._pixels;
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            canvas.drawBitmap(ImageUtilities.this._bitmap, rect, rect, paint);
            return null;
        }
    }

    public ImageUtilities(Bitmap b, int pixels) {
        this._bitmap = null;
        this._pixels = 0;
        this._output = null;
        this._bitmap = b;
        this._pixels = pixels;
    }

    public Bitmap getOutput() {
        while (0 < 10) {
            try {
                if (this._output != null) {
                    break;
                }
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }
        }
        return this._output;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float roundPx = (float) pixels;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public void getRoundedCornerBitmap() {
        new ImageRoundCornersTask().execute(new Void[0]);
    }
}
