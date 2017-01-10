package com.google.gdata.client.uploader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ResumableHttpFileUploader {
    public static long DEFAULT_MAX_CHUNK_SIZE = 0;
    public static final long DEFAULT_PROGRESS_INTERVAL_MS = 100;
    public static final String METHOD_OVERRIDE = "X-HTTP-Method-Override";
    private final BackoffPolicy backoffPolicy;
    private final long chunkSize;
    private final UploadData data;
    private final ExecutorService executor;
    private Map<String, String> headers;
    private RequestMethod httpRequestMethod;
    private long numBytesUploaded;
    private final long progressIntervalMillis;
    private final ProgressListener progressListener;
    private Timer progressNotifier;
    private Future<ResponseMessage> uploadResultFuture;
    private UploadState uploadState;
    private URL url;
    private final UrlConnectionFactory urlConnectionFactory;

    public static class Builder {
        private BackoffPolicy backoffPolicy;
        private long chunkSize;
        private UploadData data;
        private ExecutorService executor;
        private long progressIntervalMillis;
        private ProgressListener progressListener;
        private RequestMethod requestMethod;
        private URL url;
        private UrlConnectionFactory urlConnectionFactory;

        public Builder() {
            this.urlConnectionFactory = UrlConnectionFactory.DEFAULT;
            this.chunkSize = ResumableHttpFileUploader.DEFAULT_MAX_CHUNK_SIZE;
            this.progressIntervalMillis = ResumableHttpFileUploader.DEFAULT_PROGRESS_INTERVAL_MS;
            this.requestMethod = RequestMethod.PUT;
            this.backoffPolicy = BackoffPolicy.DEFAULT;
        }

        public Builder setUrl(URL url) {
            this.url = url;
            return this;
        }

        public Builder setFile(File file) throws IOException {
            if (file != null && file.exists() && file.canRead()) {
                this.data = new FileUploadData(file);
                return this;
            }
            throw new IOException("The file must exist and be readable.");
        }

        public Builder setData(UploadData data) {
            this.data = data;
            return this;
        }

        public Builder setExecutorService(ExecutorService executor) {
            this.executor = executor;
            return this;
        }

        public Builder setUrlConnectionFactory(UrlConnectionFactory urlConnectionFactory) {
            this.urlConnectionFactory = urlConnectionFactory;
            return this;
        }

        public Builder setProgressListener(ProgressListener progressListener) {
            this.progressListener = progressListener;
            return this;
        }

        public Builder setChunkSize(long chunkSize) {
            this.chunkSize = chunkSize;
            return this;
        }

        public Builder setProgressIntervalMillis(long progressIntervalMillis) {
            this.progressIntervalMillis = progressIntervalMillis;
            return this;
        }

        public Builder setRequestMethod(RequestMethod requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }

        public Builder setBackoffPolicy(BackoffPolicy backoffPolicy) {
            this.backoffPolicy = backoffPolicy;
            return this;
        }

        public ResumableHttpFileUploader build() throws IOException {
            return new ResumableHttpFileUploader(this);
        }
    }

    private class NotificationTask extends TimerTask {
        private final ResumableHttpFileUploader fileUploader;
        private final ProgressListener listener;
        private final Timer timer;

        public NotificationTask(ResumableHttpFileUploader fileUploader, ProgressListener listener, Timer timer) {
            this.fileUploader = fileUploader;
            this.listener = listener;
            this.timer = timer;
        }

        public void run() {
            if (!this.fileUploader.getUploadState().equals(UploadState.IN_PROGRESS)) {
                this.timer.cancel();
            }
            this.listener.progressChanged(this.fileUploader);
        }
    }

    public enum RequestMethod {
        POST,
        PUT
    }

    public static class ResponseMessage {
        private final int contentLength;
        private final InputStream inputStream;

        /* renamed from: com.google.gdata.client.uploader.ResumableHttpFileUploader.ResponseMessage.1 */
        class C07151 implements Callable<String> {
            C07151() throws InterruptedException, IOException {
            }

            public String call() throws Exception {
                int received = 0;
                StringBuilder message = new StringBuilder();
                while (received < ResponseMessage.this.contentLength) {
                    int avail = ResponseMessage.this.inputStream.available();
                    if (avail > 0) {
                        byte[] buf = new byte[avail];
                        received += ResponseMessage.this.inputStream.read(buf, 0, avail);
                        message.append(new String(buf));
                    } else {
                        Thread.sleep(10);
                    }
                }
                return message.toString();
            }
        }

        public ResponseMessage(int contentLength, InputStream inputStream) {
            this.contentLength = contentLength;
            this.inputStream = inputStream;
        }

        public int getContentLength() {
            return this.contentLength;
        }

        public InputStream getInputStream() {
            return this.inputStream;
        }

        public String receiveMessage(long timeoutMs) throws InterruptedException, ExecutionException, TimeoutException {
            return (String) Executors.newSingleThreadExecutor().submit(new C07151()).get(timeoutMs, TimeUnit.MILLISECONDS);
        }
    }

    public enum UploadState {
        COMPLETE,
        CLIENT_ERROR,
        IN_PROGRESS,
        NOT_STARTED,
        PAUSED
    }

    static {
        DEFAULT_MAX_CHUNK_SIZE = 10485760;
    }

    @Deprecated
    public ResumableHttpFileUploader(URL url, File file, ExecutorService executor, ProgressListener progressListener, long progressIntervalMillis) throws IOException {
        this(new Builder().setUrl(url).setFile(file).setExecutorService(executor).setProgressListener(progressListener).setProgressIntervalMillis(progressIntervalMillis));
    }

    @Deprecated
    public ResumableHttpFileUploader(URL url, File file, ExecutorService executor, ProgressListener progressListener, long chunkSize, long progressIntervalMillis) throws IOException {
        this(new Builder().setUrl(url).setFile(file).setExecutorService(executor).setProgressListener(progressListener).setChunkSize(chunkSize).setProgressIntervalMillis(progressIntervalMillis));
    }

    ResumableHttpFileUploader(Builder builder) throws IOException {
        boolean z = true;
        this.numBytesUploaded = 0;
        this.uploadState = UploadState.NOT_STARTED;
        this.headers = new HashMap();
        this.url = builder.url;
        this.data = builder.data;
        this.executor = builder.executor;
        this.urlConnectionFactory = builder.urlConnectionFactory;
        this.progressListener = builder.progressListener;
        this.progressIntervalMillis = Math.max(0, builder.progressIntervalMillis);
        this.chunkSize = builder.chunkSize;
        this.httpRequestMethod = builder.requestMethod;
        this.backoffPolicy = builder.backoffPolicy;
        boolean z2 = (this.url == null || this.url.getHost() == null || this.url.getHost().length() <= 0 || this.url.getPath() == null || this.url.getPath().length() <= 0) ? false : true;
        checkArgument(z2, "The url must be non null and have a non-empty host and path.");
        if (this.executor != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        checkArgument(z2, "Must provide a non-null executor service.");
        if (this.urlConnectionFactory == null) {
            z = false;
        }
        checkArgument(z, "Factories must be non-null.");
        if (RequestMethod.POST.equals(this.httpRequestMethod)) {
            addHeader(METHOD_OVERRIDE, RequestMethod.PUT.toString());
        }
    }

    @Deprecated
    public void setHttpRequestMethod(RequestMethod requestMethod) {
        this.httpRequestMethod = requestMethod;
        if (RequestMethod.POST.equals(requestMethod)) {
            addHeader(METHOD_OVERRIDE, RequestMethod.PUT.toString());
        }
    }

    public RequestMethod getHttpRequestMethod() {
        return this.httpRequestMethod;
    }

    public String addHeader(String key, String value) {
        return (String) this.headers.put(key, value);
    }

    Map<String, String> getHeaders() {
        return this.headers;
    }

    BackoffPolicy getBackoffPolicy() {
        return this.backoffPolicy;
    }

    public synchronized long getNumBytesUploaded() {
        return this.numBytesUploaded;
    }

    public double getProgress() {
        long fileLength = this.data.length();
        if (fileLength == 0) {
            return this.uploadState.equals(UploadState.COMPLETE) ? 1.0d : 0.0d;
        } else {
            return ((double) getNumBytesUploaded()) / ((double) fileLength);
        }
    }

    public ResponseMessage getResponse() {
        if (this.uploadResultFuture != null && this.uploadResultFuture.isDone()) {
            try {
                return (ResponseMessage) this.uploadResultFuture.get();
            } catch (ExecutionException e) {
                setUploadState(UploadState.CLIENT_ERROR);
            } catch (InterruptedException e2) {
                setUploadState(UploadState.CLIENT_ERROR);
                throw new IllegalStateException("InterruptedException even though upload is done (should never get here).");
            }
        }
        return null;
    }

    public synchronized UploadState getUploadState() {
        return this.uploadState;
    }

    public synchronized boolean isPaused() {
        return this.uploadState.equals(UploadState.PAUSED);
    }

    public synchronized void pause() {
        setUploadState(UploadState.PAUSED);
        if (this.progressNotifier != null) {
            this.progressNotifier.cancel();
        }
    }

    public void resume() {
        if (this.uploadState.equals(UploadState.PAUSED) || this.uploadState.equals(UploadState.NOT_STARTED)) {
            upload(true);
        }
    }

    public Future<ResponseMessage> start() {
        upload(false);
        return this.uploadResultFuture;
    }

    public synchronized boolean isDone() {
        boolean z;
        z = this.uploadResultFuture != null && this.uploadResultFuture.isDone();
        return z;
    }

    synchronized void addNumBytesUploaded(long numBytes) {
        this.numBytesUploaded += numBytes;
    }

    public UploadData getData() {
        return this.data;
    }

    URL getUrl() {
        return this.url;
    }

    void setUrl(URL url) {
        this.url = url;
    }

    long getChunkSize() {
        return this.chunkSize;
    }

    void sendCompletionNotification() {
        if (this.progressListener != null) {
            new NotificationTask(this, this.progressListener, this.progressNotifier).run();
        }
    }

    synchronized void setNumBytesUploaded(long numBytes) {
        this.numBytesUploaded = numBytes;
    }

    synchronized void setUploadState(UploadState state) {
        this.uploadState = state;
    }

    private void checkArgument(boolean condition, String errorMsg) {
        if (!condition) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    private void upload(boolean resume) {
        setUploadState(UploadState.IN_PROGRESS);
        ResumableHttpUploadTask task = new ResumableHttpUploadTask(this.urlConnectionFactory, this, resume);
        if (this.progressListener != null) {
            this.progressNotifier = new Timer();
            this.progressNotifier.schedule(new NotificationTask(this, this.progressListener, this.progressNotifier), 0, this.progressIntervalMillis);
        }
        this.uploadResultFuture = this.executor.submit(task);
    }
}
