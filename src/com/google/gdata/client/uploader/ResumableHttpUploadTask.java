package com.google.gdata.client.uploader;

import com.google.common.net.HttpHeaders;
import com.google.gdata.client.uploader.ResumableHttpFileUploader.ResponseMessage;
import com.google.gdata.client.uploader.ResumableHttpFileUploader.UploadState;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ResumableHttpUploadTask implements Callable<ResponseMessage> {
    private static final String CONTENT_LENGTH_HEADER_NAME = "Content-Length";
    private static final String CONTENT_RANGE_HEADER_NAME = "Content-Range";
    private final boolean resume;
    private final ResumableHttpFileUploader uploader;
    private final UrlConnectionFactory urlConnectionFactory;

    class ServerException extends Exception {
        ServerException() {
        }
    }

    public ResumableHttpUploadTask(UrlConnectionFactory urlConnectionFactory, ResumableHttpFileUploader uploader, boolean resume) {
        this.urlConnectionFactory = urlConnectionFactory;
        this.uploader = uploader;
        this.resume = resume;
    }

    public ResponseMessage call() throws Exception {
        return upload();
    }

    private long getNextStartByteFromServer() throws IOException {
        HttpURLConnection connection = this.urlConnectionFactory.create(this.uploader.getUrl());
        connection.setRequestMethod(this.uploader.getHttpRequestMethod().toString());
        connection.setRequestProperty(CONTENT_LENGTH_HEADER_NAME, "0");
        connection.connect();
        if (connection.getResponseCode() != 308) {
            return 0;
        }
        return getNextByteIndexFromRangeHeader(connection.getHeaderField(HttpHeaders.RANGE));
    }

    private long getNextByteIndexFromRangeHeader(String rangeHeader) {
        if (rangeHeader == null || rangeHeader.indexOf(45) == -1) {
            return 0;
        }
        Matcher rangeMatcher = Pattern.compile("[0-9]+-[0-9]+").matcher(rangeHeader);
        if (!rangeMatcher.find(1)) {
            return 0;
        }
        try {
            String[] rangeParts = rangeMatcher.group().split("-");
            if (Long.parseLong(rangeParts[0]) != 0) {
                return 0;
            }
            long lastByteIndex = Long.parseLong(rangeParts[1]);
            this.uploader.setNumBytesUploaded(lastByteIndex + 1);
            return lastByteIndex + 1;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void setHeaders(HttpURLConnection conn, long start, long length) {
        String str;
        long fileSize = this.uploader.getData().length();
        conn.setRequestProperty(CONTENT_LENGTH_HEADER_NAME, String.valueOf(length));
        StringBuilder append = new StringBuilder().append("bytes ");
        if (fileSize == 0) {
            str = "*/0";
        } else {
            str = start + "-" + ((start + length) - 1) + "/" + String.valueOf(fileSize);
        }
        conn.setRequestProperty(CONTENT_RANGE_HEADER_NAME, append.append(str).toString());
        for (Entry<String, String> header : this.uploader.getHeaders().entrySet()) {
            conn.setRequestProperty((String) header.getKey(), (String) header.getValue());
        }
    }

    private ResponseMessage upload() throws IOException {
        long start = this.resume ? getNextStartByteFromServer() : 0;
        while (this.uploader.getUploadState().equals(UploadState.IN_PROGRESS)) {
            long length = Math.min(this.uploader.getData().length() - start, this.uploader.getChunkSize());
            HttpURLConnection connection = this.urlConnectionFactory.create(this.uploader.getUrl());
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod(this.uploader.getHttpRequestMethod().toString());
            setHeaders(connection, start, length);
            OutputStream out = connection.getOutputStream();
            try {
                writeSlice(start, length, out);
                out.close();
                switch (connection.getResponseCode()) {
                    case 308:
                        String range = connection.getHeaderField(HttpHeaders.RANGE);
                        if (range != null) {
                            start = getNextByteIndexFromRangeHeader(range);
                        } else {
                            start += length;
                        }
                        String location = connection.getHeaderField(HttpHeaders.LOCATION);
                        if (location != null) {
                            this.uploader.setUrl(new URL(location));
                        }
                        this.uploader.getBackoffPolicy().reset();
                        break;
                    case 503:
                        if (!this.uploader.isPaused()) {
                            start = getNextStartByteFromServer();
                            this.uploader.addNumBytesUploaded(-length);
                            try {
                                long backoffMs = this.uploader.getBackoffPolicy().getNextBackoffMs();
                                if (backoffMs != -1) {
                                    Thread.sleep(backoffMs);
                                    break;
                                }
                                this.uploader.pause();
                                break;
                            } catch (InterruptedException e) {
                                break;
                            }
                        }
                        break;
                    default:
                        this.uploader.setUploadState(UploadState.COMPLETE);
                        this.uploader.sendCompletionNotification();
                        this.uploader.getBackoffPolicy().reset();
                        return new ResponseMessage(connection.getContentLength(), connection.getInputStream());
                }
            } catch (ServerException e2) {
                if (!this.uploader.isPaused()) {
                    start = getNextStartByteFromServer();
                }
            } catch (IOException e3) {
                this.uploader.setUploadState(UploadState.CLIENT_ERROR);
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void writeSlice(long r10, long r12, java.io.OutputStream r14) throws java.io.IOException, com.google.gdata.client.uploader.ResumableHttpUploadTask.ServerException {
        /*
        r9 = this;
        r2 = 0;
        r3 = r12;
        r6 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r0 = new byte[r6];
        r6 = r9.uploader;
        r5 = r6.getData();
        r5.setPosition(r10);
        monitor-enter(r5);
    L_0x0010:
        r6 = r9.uploader;	 Catch:{ all -> 0x005c }
        r6 = r6.isPaused();	 Catch:{ all -> 0x005c }
        if (r6 != 0) goto L_0x0036;
    L_0x0018:
        r6 = r0.length;	 Catch:{ all -> 0x005c }
        r6 = (long) r6;	 Catch:{ all -> 0x005c }
        r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r6 >= 0) goto L_0x0038;
    L_0x001e:
        r6 = 0;
        r7 = (int) r3;	 Catch:{ all -> 0x005c }
        r2 = r5.read(r0, r6, r7);	 Catch:{ all -> 0x005c }
    L_0x0024:
        if (r2 >= 0) goto L_0x003f;
    L_0x0026:
        r6 = 0;
        r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x0036;
    L_0x002c:
        r14.flush();	 Catch:{ IOException -> 0x0055 }
        r6 = r9.uploader;	 Catch:{ IOException -> 0x0055 }
        r7 = com.google.gdata.client.uploader.ResumableHttpFileUploader.UploadState.CLIENT_ERROR;	 Catch:{ IOException -> 0x0055 }
        r6.setUploadState(r7);	 Catch:{ IOException -> 0x0055 }
    L_0x0036:
        monitor-exit(r5);	 Catch:{ all -> 0x005c }
        return;
    L_0x0038:
        r6 = 0;
        r7 = r0.length;	 Catch:{ all -> 0x005c }
        r2 = r5.read(r0, r6, r7);	 Catch:{ all -> 0x005c }
        goto L_0x0024;
    L_0x003f:
        r6 = 0;
        r14.write(r0, r6, r2);	 Catch:{ IOException -> 0x0055 }
        r14.flush();	 Catch:{ IOException -> 0x0055 }
        r6 = (long) r2;	 Catch:{ IOException -> 0x0055 }
        r3 = r3 - r6;
        r6 = r9.uploader;	 Catch:{ IOException -> 0x0055 }
        r7 = (long) r2;	 Catch:{ IOException -> 0x0055 }
        r6.addNumBytesUploaded(r7);	 Catch:{ IOException -> 0x0055 }
        r6 = 0;
        r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r6 != 0) goto L_0x0010;
    L_0x0054:
        goto L_0x0036;
    L_0x0055:
        r1 = move-exception;
        r6 = new com.google.gdata.client.uploader.ResumableHttpUploadTask$ServerException;	 Catch:{ all -> 0x005c }
        r6.<init>();	 Catch:{ all -> 0x005c }
        throw r6;	 Catch:{ all -> 0x005c }
    L_0x005c:
        r6 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x005c }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gdata.client.uploader.ResumableHttpUploadTask.writeSlice(long, long, java.io.OutputStream):void");
    }
}
