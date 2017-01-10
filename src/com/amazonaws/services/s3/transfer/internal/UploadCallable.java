package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3EncryptionClient;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.StorageClass;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerConfiguration;
import com.amazonaws.services.s3.transfer.model.UploadResult;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UploadCallable implements Callable<UploadResult> {
    private static final Log log;
    private final TransferManagerConfiguration configuration;
    private final List<Future<PartETag>> futures;
    private String multipartUploadId;
    private final ProgressListenerChain progressListenerChain;
    private final PutObjectRequest putObjectRequest;
    private final AmazonS3 s3;
    private final ExecutorService threadPool;
    private final UploadImpl upload;

    static {
        log = LogFactory.getLog(UploadCallable.class);
    }

    public UploadCallable(TransferManager transferManager, ExecutorService executorService, UploadImpl uploadImpl, PutObjectRequest putObjectRequest, ProgressListenerChain progressListenerChain) {
        this.futures = new ArrayList();
        this.s3 = transferManager.getAmazonS3Client();
        this.configuration = transferManager.getConfiguration();
        this.threadPool = executorService;
        this.putObjectRequest = putObjectRequest;
        this.progressListenerChain = progressListenerChain;
        this.upload = uploadImpl;
    }

    private void fireProgressEvent(int i) {
        if (this.progressListenerChain != null) {
            ProgressEvent progressEvent = new ProgressEvent(0);
            progressEvent.setEventCode(i);
            this.progressListenerChain.progressChanged(progressEvent);
        }
    }

    private long getOptimalPartSize(boolean z) {
        long calculateOptimalPartSize = TransferManagerUtils.calculateOptimalPartSize(this.putObjectRequest, this.configuration);
        if (z && calculateOptimalPartSize % 32 > 0) {
            calculateOptimalPartSize = (calculateOptimalPartSize - (calculateOptimalPartSize % 32)) + 32;
        }
        log.debug("Calculated optimal part size: " + calculateOptimalPartSize);
        return calculateOptimalPartSize;
    }

    private String initiateMultipartUpload(PutObjectRequest putObjectRequest) {
        InitiateMultipartUploadRequest withObjectMetadata = new InitiateMultipartUploadRequest(putObjectRequest.getBucketName(), putObjectRequest.getKey()).withCannedACL(putObjectRequest.getCannedAcl()).withObjectMetadata(putObjectRequest.getMetadata());
        if (putObjectRequest.getStorageClass() != null) {
            withObjectMetadata.setStorageClass(StorageClass.fromValue(putObjectRequest.getStorageClass()));
        }
        String uploadId = this.s3.initiateMultipartUpload(withObjectMetadata).getUploadId();
        log.debug("Initiated new multipart upload: " + uploadId);
        return uploadId;
    }

    private UploadResult uploadInOneChunk() {
        PutObjectResult putObject = this.s3.putObject(this.putObjectRequest);
        UploadResult uploadResult = new UploadResult();
        uploadResult.setBucketName(this.putObjectRequest.getBucketName());
        uploadResult.setKey(this.putObjectRequest.getKey());
        uploadResult.setETag(putObject.getETag());
        uploadResult.setVersionId(putObject.getVersionId());
        return uploadResult;
    }

    private UploadResult uploadInParts() throws Exception {
        String bucketName = this.putObjectRequest.getBucketName();
        String key = this.putObjectRequest.getKey();
        boolean z = this.s3 instanceof AmazonS3EncryptionClient;
        long optimalPartSize = getOptimalPartSize(z);
        this.multipartUploadId = initiateMultipartUpload(this.putObjectRequest);
        try {
            UploadResult uploadResult;
            UploadPartRequestFactory uploadPartRequestFactory = new UploadPartRequestFactory(this.putObjectRequest, this.multipartUploadId, optimalPartSize);
            if (TransferManagerUtils.isUploadParallelizable(this.putObjectRequest, z)) {
                uploadPartsInParallel(uploadPartRequestFactory);
                uploadResult = null;
                if (this.putObjectRequest.getInputStream() != null) {
                    try {
                        this.putObjectRequest.getInputStream().close();
                    } catch (Throwable e) {
                        log.warn("Unable to cleanly close input stream: " + e.getMessage(), e);
                    }
                }
            } else {
                uploadResult = uploadPartsInSeries(uploadPartRequestFactory);
                if (this.putObjectRequest.getInputStream() != null) {
                    try {
                        this.putObjectRequest.getInputStream().close();
                    } catch (Throwable e2) {
                        log.warn("Unable to cleanly close input stream: " + e2.getMessage(), e2);
                    }
                }
            }
            return uploadResult;
        } catch (Exception e3) {
            fireProgressEvent(4);
            try {
                this.s3.abortMultipartUpload(new AbortMultipartUploadRequest(bucketName, key, this.multipartUploadId));
            } catch (Throwable e22) {
                log.info("Unable to abort multipart upload, you may need to manually remove uploaded parts: " + e22.getMessage(), e22);
            }
            throw e3;
        } catch (Throwable th) {
            if (this.putObjectRequest.getInputStream() != null) {
                try {
                    this.putObjectRequest.getInputStream().close();
                } catch (Throwable e222) {
                    log.warn("Unable to cleanly close input stream: " + e222.getMessage(), e222);
                }
            }
        }
    }

    private void uploadPartsInParallel(UploadPartRequestFactory uploadPartRequestFactory) {
        while (uploadPartRequestFactory.hasMoreRequests()) {
            if (this.threadPool.isShutdown()) {
                throw new CancellationException("TransferManager has been shutdown");
            }
            this.futures.add(this.threadPool.submit(new UploadPartCallable(this.s3, uploadPartRequestFactory.getNextUploadPartRequest())));
        }
    }

    private UploadResult uploadPartsInSeries(UploadPartRequestFactory uploadPartRequestFactory) {
        List arrayList = new ArrayList();
        while (uploadPartRequestFactory.hasMoreRequests()) {
            if (this.threadPool.isShutdown()) {
                throw new CancellationException("TransferManager has been shutdown");
            }
            UploadPartRequest nextUploadPartRequest = uploadPartRequestFactory.getNextUploadPartRequest();
            InputStream inputStream = nextUploadPartRequest.getInputStream();
            if (inputStream != null && inputStream.markSupported()) {
                if (nextUploadPartRequest.getPartSize() >= 2147483647L) {
                    inputStream.mark(Integer.MAX_VALUE);
                } else {
                    inputStream.mark((int) nextUploadPartRequest.getPartSize());
                }
            }
            arrayList.add(this.s3.uploadPart(nextUploadPartRequest).getPartETag());
        }
        CompleteMultipartUploadResult completeMultipartUpload = this.s3.completeMultipartUpload(new CompleteMultipartUploadRequest(this.putObjectRequest.getBucketName(), this.putObjectRequest.getKey(), this.multipartUploadId, arrayList));
        fireProgressEvent(2);
        UploadResult uploadResult = new UploadResult();
        uploadResult.setBucketName(completeMultipartUpload.getBucketName());
        uploadResult.setKey(completeMultipartUpload.getKey());
        uploadResult.setETag(completeMultipartUpload.getETag());
        uploadResult.setVersionId(completeMultipartUpload.getVersionId());
        return uploadResult;
    }

    public UploadResult call() throws Exception {
        this.upload.setState(TransferState.InProgress);
        if (!isMultipartUpload()) {
            return uploadInOneChunk();
        }
        fireProgressEvent(1);
        return uploadInParts();
    }

    List<Future<PartETag>> getFutures() {
        return this.futures;
    }

    String getMultipartUploadId() {
        return this.multipartUploadId;
    }

    public boolean isMultipartUpload() {
        return TransferManagerUtils.shouldUseMultipartUpload(this.putObjectRequest, this.configuration);
    }
}
