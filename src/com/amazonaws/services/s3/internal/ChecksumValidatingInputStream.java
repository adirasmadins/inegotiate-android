package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ChecksumValidatingInputStream extends FilterInputStream {
    private final DigestInputStream digestInputStream;
    private final byte[] expectedChecksum;
    private boolean hasReadAllContent;
    private final String sourceObject;

    public ChecksumValidatingInputStream(InputStream inputStream, byte[] bArr, String str) throws NoSuchAlgorithmException {
        super(new DigestInputStream(inputStream, MessageDigest.getInstance("MD5")));
        this.hasReadAllContent = false;
        this.expectedChecksum = bArr;
        this.sourceObject = str;
        this.digestInputStream = (DigestInputStream) this.in;
    }

    public void close() throws IOException {
        super.close();
        if (this.hasReadAllContent && !Arrays.equals(this.digestInputStream.getMessageDigest().digest(), this.expectedChecksum)) {
            throw new AmazonClientException("Unable to verify integrity of data download.  Client calculated content hash didn't match hash calculated by Amazon S3.  The data read from '" + this.sourceObject + "' may be corrupt.");
        }
    }

    public int read() throws IOException {
        int read = super.read();
        this.hasReadAllContent = read == -1;
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        int read = super.read(bArr);
        this.hasReadAllContent = read == 0;
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        this.hasReadAllContent = read == 0;
        return read;
    }
}
