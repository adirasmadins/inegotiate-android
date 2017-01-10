package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManagerConfiguration;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class TransferManagerUtils {

    /* renamed from: com.amazonaws.services.s3.transfer.internal.TransferManagerUtils.1 */
    static class C00691 implements ThreadFactory {
        private int threadCount;

        C00691() {
            this.threadCount = 1;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            StringBuilder append = new StringBuilder().append("s3-transfer-manager-worker-");
            int i = this.threadCount;
            this.threadCount = i + 1;
            thread.setName(append.append(i).toString());
            return thread;
        }
    }

    public static long calculateOptimalPartSize(PutObjectRequest putObjectRequest, TransferManagerConfiguration transferManagerConfiguration) {
        return (long) Math.max(Math.ceil(((double) getContentLength(putObjectRequest)) / 10000.0d), (double) transferManagerConfiguration.getMinimumUploadPartSize());
    }

    public static ThreadPoolExecutor createDefaultExecutorService() {
        return (ThreadPoolExecutor) Executors.newFixedThreadPool(10, new C00691());
    }

    public static long getContentLength(PutObjectRequest putObjectRequest) {
        File requestFile = getRequestFile(putObjectRequest);
        return requestFile != null ? requestFile.length() : (putObjectRequest.getInputStream() == null || putObjectRequest.getMetadata().getContentLength() <= 0) ? -1 : putObjectRequest.getMetadata().getContentLength();
    }

    public static File getRequestFile(PutObjectRequest putObjectRequest) {
        return putObjectRequest.getFile() != null ? putObjectRequest.getFile() : null;
    }

    public static boolean isUploadParallelizable(PutObjectRequest putObjectRequest, boolean z) {
        return (z || getRequestFile(putObjectRequest) == null) ? false : true;
    }

    public static boolean shouldUseMultipartUpload(PutObjectRequest putObjectRequest, TransferManagerConfiguration transferManagerConfiguration) {
        return getContentLength(putObjectRequest) > transferManagerConfiguration.getMultipartUploadThreshold();
    }
}
