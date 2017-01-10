package com.doviknissim.inegotiate.app;

import android.os.AsyncTask;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import java.io.File;
import java.util.Calendar;

public class AWSUploadAdapter {
    private static String IMAGE_NAME_PREFIX;
    private static String MY_ACCESS_KEY_ID;
    private static String MY_SECRET_KEY;
    private String bucketName;
    private File file;

    public class UploadFileToS3Task extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... unused) {
            AmazonS3Client s3Client = new AmazonS3Client(new BasicAWSCredentials(AWSUploadAdapter.MY_ACCESS_KEY_ID, AWSUploadAdapter.MY_SECRET_KEY));
            s3Client.createBucket(AWSUploadAdapter.this.getBucketName());
            PutObjectResult result = s3Client.putObject(new PutObjectRequest(AWSUploadAdapter.this.getBucketName(), AWSUploadAdapter.this.getFile().getName(), AWSUploadAdapter.this.getFile()));
            Calendar expirationDay = (Calendar) Calendar.getInstance().clone();
            expirationDay.add(6, 30);
            String amazonURLToImage = "URL not generated";
            amazonURLToImage = s3Client.generatePresignedUrl(AWSUploadAdapter.this.getBucketName(), AWSUploadAdapter.this.getFile().getName(), expirationDay.getTime(), HttpMethod.GET).toString();
            return null;
        }
    }

    static {
        MY_ACCESS_KEY_ID = "AKIAJEZUKWXOCQLOQBYQ";
        MY_SECRET_KEY = "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";
        IMAGE_NAME_PREFIX = "product_image_";
    }

    public AWSUploadAdapter(File file, String bucketName) {
        this.file = null;
        this.bucketName = null;
        this.file = file;
        this.bucketName = bucketName;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public void uploadImageToAmazonS3() {
        new UploadFileToS3Task().execute(new Void[0]);
    }
}
