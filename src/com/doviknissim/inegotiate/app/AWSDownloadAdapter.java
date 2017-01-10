package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.S3Object;
import com.google.gdata.util.common.base.StringUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AWSDownloadAdapter {
    private static String IMAGE_NAME_PREFIX;
    private static String MY_ACCESS_KEY_ID;
    private static String MY_SECRET_KEY;
    private String _result;
    private Activity activity;
    private String bucketName;
    private String fileName;

    public class DownloadFileToS3Task extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... unused) {
            String imageAbsolutePath = StringUtil.EMPTY_STRING;
            try {
                S3Object object = new AmazonS3Client(new BasicAWSCredentials(AWSDownloadAdapter.MY_ACCESS_KEY_ID, AWSDownloadAdapter.MY_SECRET_KEY)).getObject(AWSDownloadAdapter.this.getBucketName(), AWSDownloadAdapter.this.getFileName());
                long fileSize = object.getObjectMetadata().getContentLength();
                byte[] readingBuffer = new byte[ProgressEvent.PART_STARTED_EVENT_CODE];
                InputStream is = new BufferedInputStream(object.getObjectContent());
                File file = new File(Environment.getExternalStorageDirectory().toString(), AWSDownloadAdapter.this.fileName);
                FileOutputStream fout = new FileOutputStream(file);
                int numberOfBytesReadToBuffer = 0;
                int TotalFileSizeInBytes = 0;
                while (numberOfBytesReadToBuffer != -1) {
                    TotalFileSizeInBytes += numberOfBytesReadToBuffer;
                    numberOfBytesReadToBuffer = is.read(readingBuffer);
                    if (numberOfBytesReadToBuffer != -1) {
                        fout.write(readingBuffer, 0, numberOfBytesReadToBuffer);
                    }
                }
                fout.flush();
                fout.close();
                imageAbsolutePath = file.getAbsolutePath();
                AWSDownloadAdapter.this._result = file.getAbsolutePath();
            } catch (FileNotFoundException e) {
                Log.e("iNegotiate", "[ERROR] An exception was thrown, the message is:\t" + e.getMessage());
            } catch (IOException e2) {
                Log.e("iNegotiate", "[ERROR] An exception was thrown, the message is:\t" + e2.getMessage());
            }
            return null;
        }
    }

    static {
        MY_ACCESS_KEY_ID = "AKIAJEZUKWXOCQLOQBYQ";
        MY_SECRET_KEY = "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";
        IMAGE_NAME_PREFIX = "product_image_";
    }

    public AWSDownloadAdapter(Activity activity, String bucketName, String fileName) {
        this.activity = null;
        this.bucketName = null;
        this.fileName = null;
        this._result = null;
        this.activity = activity;
        this.bucketName = bucketName;
        this.fileName = fileName;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void downloadImageFromAmazonS3() {
        new DownloadFileToS3Task().execute(new Void[0]);
    }

    public String getResult() {
        return this._result;
    }
}
