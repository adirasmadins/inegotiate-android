package com.amazonaws.services.s3.transfer;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.MultipartUpload;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ProgressListener;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazonaws.services.s3.transfer.internal.DownloadImpl;
import com.amazonaws.services.s3.transfer.internal.DownloadMonitor;
import com.amazonaws.services.s3.transfer.internal.MultipleFileDownloadImpl;
import com.amazonaws.services.s3.transfer.internal.MultipleFileTransfer;
import com.amazonaws.services.s3.transfer.internal.MultipleFileTransferMonitor;
import com.amazonaws.services.s3.transfer.internal.MultipleFileUploadImpl;
import com.amazonaws.services.s3.transfer.internal.ProgressListenerChain;
import com.amazonaws.services.s3.transfer.internal.TransferManagerUtils;
import com.amazonaws.services.s3.transfer.internal.TransferMonitor;
import com.amazonaws.services.s3.transfer.internal.TransferProgressImpl;
import com.amazonaws.services.s3.transfer.internal.TransferProgressUpdatingListener;
import com.amazonaws.services.s3.transfer.internal.TransferStateChangeListener;
import com.amazonaws.services.s3.transfer.internal.UploadCallable;
import com.amazonaws.services.s3.transfer.internal.UploadImpl;
import com.amazonaws.services.s3.transfer.internal.UploadMonitor;
import com.amazonaws.util.VersionInfoUtils;
import com.google.gdata.util.common.base.StringUtil;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TransferManager {
    private static final String DEFAULT_DELIMITER = "/";
    private static final String USER_AGENT;
    private static final Log log;
    private TransferManagerConfiguration configuration;
    private AmazonS3 s3;
    private ThreadPoolExecutor threadPool;
    private ScheduledExecutorService timedThreadPool;

    /* renamed from: com.amazonaws.services.s3.transfer.TransferManager.1 */
    class C00661 implements Callable<Object> {
        final /* synthetic */ DownloadImpl val$download;
        final /* synthetic */ File val$file;
        final /* synthetic */ GetObjectRequest val$getObjectRequest;
        final /* synthetic */ StartDownloadLock val$startDownloadLock;

        C00661(StartDownloadLock startDownloadLock, DownloadImpl downloadImpl, GetObjectRequest getObjectRequest, File file) {
            this.val$startDownloadLock = startDownloadLock;
            this.val$download = downloadImpl;
            this.val$getObjectRequest = getObjectRequest;
            this.val$file = file;
        }

        public Object call() throws Exception {
            boolean z = true;
            try {
                synchronized (this.val$startDownloadLock) {
                    if (!this.val$startDownloadLock.downloadReady) {
                        try {
                            this.val$startDownloadLock.wait();
                        } catch (InterruptedException e) {
                            throw new AmazonClientException("Couldn't wait for setting future into the monitor");
                        }
                    }
                }
                this.val$download.setState(TransferState.InProgress);
                S3Object object = TransferManager.this.s3.getObject(this.val$getObjectRequest);
                this.val$download.setS3Object(object);
                if (object == null) {
                    this.val$download.setState(TransferState.Canceled);
                    this.val$download.setMonitor(new DownloadMonitor(this.val$download, null));
                    return this.val$download;
                }
                File file = this.val$file;
                if (this.val$getObjectRequest.getRange() != null) {
                    z = false;
                }
                ServiceUtils.downloadObjectToFile(object, file, z);
                this.val$download.setState(TransferState.Completed);
                return Boolean.valueOf(true);
            } catch (Exception e2) {
                if (this.val$download.getState() != TransferState.Canceled) {
                    this.val$download.setState(TransferState.Failed);
                }
                throw e2;
            }
        }
    }

    private static final class AllDownloadsQueuedLock {
        private volatile boolean allQueued;

        private AllDownloadsQueuedLock() {
            this.allQueued = false;
        }
    }

    private static final class MultipleFileTransferStateChangeListener implements TransferStateChangeListener {
        private final AllDownloadsQueuedLock allTransfersQueuedLock;
        private final MultipleFileTransfer multipleFileTransfer;

        public MultipleFileTransferStateChangeListener(AllDownloadsQueuedLock allDownloadsQueuedLock, MultipleFileTransfer multipleFileTransfer) {
            this.allTransfersQueuedLock = allDownloadsQueuedLock;
            this.multipleFileTransfer = multipleFileTransfer;
        }

        public void transferStateChanged(Transfer transfer, TransferState transferState) {
            synchronized (this.allTransfersQueuedLock) {
                if (!this.allTransfersQueuedLock.allQueued) {
                    try {
                        this.allTransfersQueuedLock.wait();
                    } catch (InterruptedException e) {
                        throw new AmazonClientException("Couldn't wait for all downloads to be queued");
                    }
                }
            }
            synchronized (this.multipleFileTransfer) {
                if (this.multipleFileTransfer.getState() == transferState || this.multipleFileTransfer.isDone()) {
                    return;
                }
                if (transferState == TransferState.InProgress) {
                    this.multipleFileTransfer.setState(transferState);
                } else if (this.multipleFileTransfer.getMonitor().isDone()) {
                    this.multipleFileTransfer.collateFinalState();
                } else {
                    this.multipleFileTransfer.setState(TransferState.InProgress);
                }
            }
        }
    }

    private static final class StartDownloadLock {
        private volatile boolean downloadReady;

        private StartDownloadLock() {
            this.downloadReady = false;
        }
    }

    static {
        log = LogFactory.getLog(TransferManager.class);
        USER_AGENT = TransferManager.class.getName() + DEFAULT_DELIMITER + VersionInfoUtils.getVersion();
    }

    public TransferManager(AWSCredentials aWSCredentials) {
        this(new AmazonS3Client(aWSCredentials));
    }

    public TransferManager(AmazonS3 amazonS3) {
        this(amazonS3, TransferManagerUtils.createDefaultExecutorService());
    }

    public TransferManager(AmazonS3 amazonS3, ThreadPoolExecutor threadPoolExecutor) {
        this.timedThreadPool = new ScheduledThreadPoolExecutor(1);
        this.s3 = amazonS3;
        this.threadPool = threadPoolExecutor;
        this.configuration = new TransferManagerConfiguration();
    }

    private Download download(GetObjectRequest getObjectRequest, File file, TransferStateChangeListener transferStateChangeListener) {
        appendUserAgent(getObjectRequest, USER_AGENT);
        String str = "Downloading from " + getObjectRequest.getBucketName() + DEFAULT_DELIMITER + getObjectRequest.getKey();
        TransferProgress transferProgressImpl = new TransferProgressImpl();
        Object progressListenerChain = new ProgressListenerChain(new TransferProgressUpdatingListener(transferProgressImpl), getObjectRequest.getProgressListener());
        getObjectRequest.setProgressListener(progressListenerChain);
        ObjectMetadata objectMetadata = this.s3.getObjectMetadata(getObjectRequest.getBucketName(), getObjectRequest.getKey());
        StartDownloadLock startDownloadLock = new StartDownloadLock();
        Download downloadImpl = new DownloadImpl(str, transferProgressImpl, progressListenerChain, null, transferStateChangeListener);
        long contentLength = objectMetadata.getContentLength();
        if (getObjectRequest.getRange() != null && getObjectRequest.getRange().length == 2) {
            contentLength = getObjectRequest.getRange()[1] - getObjectRequest.getRange()[0];
        }
        transferProgressImpl.setTotalBytesToTransfer(contentLength);
        downloadImpl.setMonitor(new DownloadMonitor(downloadImpl, this.threadPool.submit(new C00661(startDownloadLock, downloadImpl, getObjectRequest, file))));
        synchronized (startDownloadLock) {
            startDownloadLock.downloadReady = true;
            startDownloadLock.notify();
        }
        return downloadImpl;
    }

    private void listFiles(File file, List<File> list, boolean z) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    list.add(file2);
                } else if (z) {
                    listFiles(file2, list, z);
                }
            }
        }
    }

    private Upload upload(PutObjectRequest putObjectRequest, TransferStateChangeListener transferStateChangeListener) throws AmazonServiceException, AmazonClientException {
        appendUserAgent(putObjectRequest, USER_AGENT);
        if (putObjectRequest.getMetadata() == null) {
            putObjectRequest.setMetadata(new ObjectMetadata());
        }
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        if (TransferManagerUtils.getRequestFile(putObjectRequest) != null) {
            File requestFile = TransferManagerUtils.getRequestFile(putObjectRequest);
            metadata.setContentLength(requestFile.length());
            if (metadata.getContentType() == null) {
                metadata.setContentType(Mimetypes.getInstance().getMimetype(requestFile));
            }
        }
        String str = "Uploading to " + putObjectRequest.getBucketName() + DEFAULT_DELIMITER + putObjectRequest.getKey();
        TransferProgressImpl transferProgressImpl = new TransferProgressImpl();
        transferProgressImpl.setTotalBytesToTransfer(TransferManagerUtils.getContentLength(putObjectRequest));
        ProgressListenerChain progressListenerChain = new ProgressListenerChain(new TransferProgressUpdatingListener(transferProgressImpl), putObjectRequest.getProgressListener());
        putObjectRequest.setProgressListener(progressListenerChain);
        Upload uploadImpl = new UploadImpl(str, transferProgressImpl, progressListenerChain, transferStateChangeListener);
        Upload upload = uploadImpl;
        TransferMonitor uploadMonitor = new UploadMonitor(this, upload, this.threadPool, new UploadCallable(this, this.threadPool, uploadImpl, putObjectRequest, progressListenerChain), putObjectRequest, progressListenerChain);
        uploadMonitor.setTimedThreadPool(this.timedThreadPool);
        uploadImpl.setMonitor(uploadMonitor);
        return uploadImpl;
    }

    public void abortMultipartUploads(String str, Date date) throws AmazonServiceException, AmazonClientException {
        MultipartUploadListing listMultipartUploads = this.s3.listMultipartUploads((ListMultipartUploadsRequest) appendUserAgent(new ListMultipartUploadsRequest(str), USER_AGENT));
        while (true) {
            for (MultipartUpload multipartUpload : listMultipartUploads.getMultipartUploads()) {
                if (multipartUpload.getInitiated().compareTo(date) < 0) {
                    this.s3.abortMultipartUpload((AbortMultipartUploadRequest) appendUserAgent(new AbortMultipartUploadRequest(str, multipartUpload.getKey(), multipartUpload.getUploadId()), USER_AGENT));
                }
            }
            MultipartUploadListing listMultipartUploads2 = this.s3.listMultipartUploads((ListMultipartUploadsRequest) appendUserAgent(new ListMultipartUploadsRequest(str).withUploadIdMarker(listMultipartUploads.getNextUploadIdMarker()).withKeyMarker(listMultipartUploads.getNextKeyMarker()), USER_AGENT));
            if (listMultipartUploads2.isTruncated()) {
                listMultipartUploads = listMultipartUploads2;
            } else {
                return;
            }
        }
    }

    public <X extends AmazonWebServiceRequest> X appendUserAgent(X x, String str) {
        x.getRequestClientOptions().addClientMarker(USER_AGENT);
        return x;
    }

    public Download download(GetObjectRequest getObjectRequest, File file) {
        return download(getObjectRequest, file, null);
    }

    public Download download(String str, String str2, File file) {
        return download(new GetObjectRequest(str, str2), file);
    }

    public MultipleFileDownload downloadDirectory(String str, String str2, File file) {
        long j;
        String str3 = str2 == null ? StringUtil.EMPTY_STRING : str2;
        List<S3ObjectSummary> linkedList = new LinkedList();
        Stack stack = new Stack();
        stack.add(str3);
        long j2 = 0;
        while (true) {
            String str4 = (String) stack.pop();
            j = j2;
            ObjectListing objectListing = null;
            do {
                objectListing = objectListing == null ? this.s3.listObjects(new ListObjectsRequest().withBucketName(str).withDelimiter(DEFAULT_DELIMITER).withPrefix(str4)) : this.s3.listNextBatchOfObjects(objectListing);
                for (S3ObjectSummary s3ObjectSummary : objectListing.getObjectSummaries()) {
                    if (s3ObjectSummary.getKey().equals(str4) || objectListing.getCommonPrefixes().contains(s3ObjectSummary.getKey() + DEFAULT_DELIMITER)) {
                        log.debug("Skipping download for object " + s3ObjectSummary.getKey() + " since it is also a virtual directory");
                    } else {
                        linkedList.add(s3ObjectSummary);
                        j += s3ObjectSummary.getSize();
                    }
                }
                stack.addAll(objectListing.getCommonPrefixes());
            } while (objectListing.isTruncated());
            if (stack.isEmpty()) {
                break;
            }
            j2 = j;
        }
        TransferProgress transferProgressImpl = new TransferProgressImpl();
        transferProgressImpl.setTotalBytesToTransfer(j);
        ProgressListener transferProgressUpdatingListener = new TransferProgressUpdatingListener(transferProgressImpl);
        List arrayList = new ArrayList();
        Object multipleFileDownloadImpl = new MultipleFileDownloadImpl("Downloading from " + str + DEFAULT_DELIMITER + str3, transferProgressImpl, new ProgressListenerChain(transferProgressUpdatingListener), str3, str, arrayList);
        multipleFileDownloadImpl.setMonitor(new MultipleFileTransferMonitor(multipleFileDownloadImpl, arrayList));
        AllDownloadsQueuedLock allDownloadsQueuedLock = new AllDownloadsQueuedLock();
        TransferStateChangeListener multipleFileTransferStateChangeListener = new MultipleFileTransferStateChangeListener(allDownloadsQueuedLock, multipleFileDownloadImpl);
        for (S3ObjectSummary s3ObjectSummary2 : linkedList) {
            File file2 = new File(file, s3ObjectSummary2.getKey());
            File parentFile = file2.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                arrayList.add((DownloadImpl) download(new GetObjectRequest(s3ObjectSummary2.getBucketName(), s3ObjectSummary2.getKey()).withProgressListener(transferProgressUpdatingListener), file2, multipleFileTransferStateChangeListener));
            } else {
                throw new RuntimeException("Couldn't create parent directories for " + file2.getAbsolutePath());
            }
        }
        if (arrayList.isEmpty()) {
            multipleFileDownloadImpl.setState(TransferState.Completed);
        } else {
            synchronized (allDownloadsQueuedLock) {
                allDownloadsQueuedLock.allQueued = true;
                allDownloadsQueuedLock.notifyAll();
            }
        }
        return multipleFileDownloadImpl;
    }

    public AmazonS3 getAmazonS3Client() {
        return this.s3;
    }

    public TransferManagerConfiguration getConfiguration() {
        return this.configuration;
    }

    public void setConfiguration(TransferManagerConfiguration transferManagerConfiguration) {
        this.configuration = transferManagerConfiguration;
    }

    public void shutdownNow() {
        this.threadPool.shutdownNow();
        this.timedThreadPool.shutdownNow();
        if (this.s3 instanceof AmazonS3Client) {
            ((AmazonS3Client) this.s3).shutdown();
        }
    }

    public Upload upload(PutObjectRequest putObjectRequest) throws AmazonServiceException, AmazonClientException {
        return upload(putObjectRequest, null);
    }

    public Upload upload(String str, String str2, File file) throws AmazonServiceException, AmazonClientException {
        return upload(new PutObjectRequest(str, str2, file));
    }

    public Upload upload(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) throws AmazonServiceException, AmazonClientException {
        return upload(new PutObjectRequest(str, str2, inputStream, objectMetadata));
    }

    public MultipleFileUpload uploadDirectory(String str, String str2, File file, boolean z) {
        if (file != null && file.exists() && file.isDirectory()) {
            String str3;
            if (str2 == null || str2.length() == 0) {
                str3 = StringUtil.EMPTY_STRING;
            } else {
                str3 = !str2.endsWith(DEFAULT_DELIMITER) ? str2 + DEFAULT_DELIMITER : str2;
            }
            TransferProgress transferProgressImpl = new TransferProgressImpl();
            ProgressListener transferProgressUpdatingListener = new TransferProgressUpdatingListener(transferProgressImpl);
            Object linkedList = new LinkedList();
            Object multipleFileUploadImpl = new MultipleFileUploadImpl("Uploading etc", transferProgressImpl, null, str3, str, linkedList);
            multipleFileUploadImpl.setMonitor(new MultipleFileTransferMonitor(multipleFileUploadImpl, linkedList));
            AllDownloadsQueuedLock allDownloadsQueuedLock = new AllDownloadsQueuedLock();
            TransferStateChangeListener multipleFileTransferStateChangeListener = new MultipleFileTransferStateChangeListener(allDownloadsQueuedLock, multipleFileUploadImpl);
            long j = 0;
            List<File> linkedList2 = new LinkedList();
            listFiles(file, linkedList2, z);
            if (linkedList2.isEmpty()) {
                multipleFileUploadImpl.setState(TransferState.Completed);
            }
            for (File file2 : linkedList2) {
                j += file2.length();
                String str4 = str;
                linkedList.add((UploadImpl) upload(new PutObjectRequest(str4, str3 + file2.getAbsolutePath().substring(file.getAbsolutePath().length() + 1).replaceAll("\\\\", DEFAULT_DELIMITER), file2).withProgressListener(transferProgressUpdatingListener), multipleFileTransferStateChangeListener));
            }
            transferProgressImpl.setTotalBytesToTransfer(j);
            synchronized (allDownloadsQueuedLock) {
                allDownloadsQueuedLock.allQueued = true;
                allDownloadsQueuedLock.notifyAll();
            }
            return multipleFileUploadImpl;
        }
        throw new IllegalArgumentException("Must provide a directory to upload");
    }
}
