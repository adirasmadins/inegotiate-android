package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerConfiguration;
import com.amazonaws.services.s3.transfer.model.UploadResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UploadMonitor implements Callable<UploadResult>, TransferMonitor {
    private static final Log log;
    private final TransferManagerConfiguration configuration;
    private final List<Future<PartETag>> futures;
    private boolean isUploadDone;
    private final UploadCallable multipartUploadCallable;
    private Future<UploadResult> nextFuture;
    private int pollInterval;
    private final ProgressListenerChain progressListenerChain;
    private final PutObjectRequest putObjectRequest;
    private final AmazonS3 s3;
    private final ExecutorService threadPool;
    private ScheduledExecutorService timedThreadPool;
    private final UploadImpl transfer;
    private String uploadId;

    /* renamed from: com.amazonaws.services.s3.transfer.internal.UploadMonitor.1 */
    class C00701 implements Callable<UploadResult> {
        C00701() {
        }

        public UploadResult call() throws Exception {
            UploadMonitor.this.setNextFuture(UploadMonitor.this.threadPool.submit(UploadMonitor.this));
            return null;
        }
    }

    static {
        log = LogFactory.getLog(UploadMonitor.class);
    }

    public UploadMonitor(TransferManager transferManager, UploadImpl uploadImpl, ExecutorService executorService, UploadCallable uploadCallable, PutObjectRequest putObjectRequest, ProgressListenerChain progressListenerChain) {
        this.futures = new ArrayList();
        this.isUploadDone = false;
        this.pollInterval = 5000;
        this.s3 = transferManager.getAmazonS3Client();
        this.configuration = transferManager.getConfiguration();
        this.multipartUploadCallable = uploadCallable;
        this.threadPool = executorService;
        this.putObjectRequest = putObjectRequest;
        this.progressListenerChain = progressListenerChain;
        this.transfer = uploadImpl;
        setNextFuture(executorService.submit(this));
    }

    private List<PartETag> collectPartETags() {
        List<PartETag> arrayList = new ArrayList(this.futures.size());
        for (Future future : this.futures) {
            try {
                arrayList.add(future.get());
            } catch (Exception e) {
                throw new AmazonClientException("Unable to upload part: " + e.getCause().getMessage(), e.getCause());
            }
        }
        return arrayList;
    }

    private UploadResult completeMultipartUpload() {
        CompleteMultipartUploadResult completeMultipartUpload = this.s3.completeMultipartUpload(new CompleteMultipartUploadRequest(this.putObjectRequest.getBucketName(), this.putObjectRequest.getKey(), this.uploadId, collectPartETags()));
        uploadComplete();
        UploadResult uploadResult = new UploadResult();
        uploadResult.setBucketName(completeMultipartUpload.getBucketName());
        uploadResult.setKey(completeMultipartUpload.getKey());
        uploadResult.setETag(completeMultipartUpload.getETag());
        uploadResult.setVersionId(completeMultipartUpload.getVersionId());
        return uploadResult;
    }

    private void fireProgressEvent(int i) {
        if (this.progressListenerChain != null) {
            ProgressEvent progressEvent = new ProgressEvent(0);
            progressEvent.setEventCode(i);
            this.progressListenerChain.progressChanged(progressEvent);
        }
    }

    private synchronized void markAllDone() {
        this.isUploadDone = true;
    }

    private UploadResult poll() throws InterruptedException {
        for (Future isDone : this.futures) {
            if (!isDone.isDone()) {
                reschedule();
                return null;
            }
        }
        for (Future isDone2 : this.futures) {
            if (isDone2.isCancelled()) {
                throw new CancellationException();
            }
        }
        return completeMultipartUpload();
    }

    private void reschedule() {
        setNextFuture(this.timedThreadPool.schedule(new C00701(), (long) this.pollInterval, TimeUnit.MILLISECONDS));
    }

    private synchronized void setNextFuture(Future<UploadResult> future) {
        this.nextFuture = future;
    }

    private UploadResult upload() throws Exception, InterruptedException {
        UploadResult call = this.multipartUploadCallable.call();
        if (call != null) {
            uploadComplete();
        } else {
            this.uploadId = this.multipartUploadCallable.getMultipartUploadId();
            this.futures.addAll(this.multipartUploadCallable.getFutures());
            reschedule();
        }
        return call;
    }

    private void uploadComplete() {
        markAllDone();
        this.transfer.setState(TransferState.Completed);
        if (this.multipartUploadCallable.isMultipartUpload()) {
            fireProgressEvent(2);
        }
    }

    public UploadResult call() throws Exception {
        try {
            return this.uploadId == null ? upload() : poll();
        } catch (CancellationException e) {
            this.transfer.setState(TransferState.Canceled);
            fireProgressEvent(8);
            throw new AmazonClientException("Upload canceled");
        } catch (Exception e2) {
            this.transfer.setState(TransferState.Failed);
            fireProgressEvent(4);
            throw e2;
        }
    }

    public synchronized Future<UploadResult> getFuture() {
        return this.nextFuture;
    }

    public synchronized boolean isDone() {
        return this.isUploadDone;
    }

    public void setTimedThreadPool(ScheduledExecutorService scheduledExecutorService) {
        this.timedThreadPool = scheduledExecutorService;
    }
}
