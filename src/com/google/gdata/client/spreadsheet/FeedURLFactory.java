package com.google.gdata.client.spreadsheet;

import com.google.gdata.util.common.base.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class FeedURLFactory {
    private static final String BASE_PATH = "feeds/";
    private static final String CELLS_PATH = "feeds/cells/";
    public static final String DEFAULT_SPREADSHEETS_URL = "https://spreadsheets.google.com";
    private static final String LIST_PATH = "feeds/list/";
    private static final String RECORD_PATH = "/records/";
    private static final String SPREADSHEETS_PATH = "feeds/spreadsheets/private/full";
    private static final String TABLE_PATH = "/tables/";
    private static final String WORKSHEETS_PATH = "feeds/worksheets/";
    private static final FeedURLFactory instance;
    private URL baseUrl;
    private URL feedCells;
    private URL feedList;
    private URL feedSpreadsheets;
    private URL feedWorksheets;

    static {
        instance = new FeedURLFactory();
    }

    public static FeedURLFactory getDefault() {
        return instance;
    }

    private FeedURLFactory() {
        try {
            init(DEFAULT_SPREADSHEETS_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unexpected malformed URL", e);
        }
    }

    public FeedURLFactory(String url) throws MalformedURLException {
        init(url);
    }

    private void init(String url) throws MalformedURLException {
        if (!url.endsWith("/")) {
            url = url + "/";
        }
        this.baseUrl = new URL(url);
        this.feedSpreadsheets = new URL(this.baseUrl, SPREADSHEETS_PATH);
        this.feedWorksheets = new URL(this.baseUrl, WORKSHEETS_PATH);
        this.feedList = new URL(this.baseUrl, LIST_PATH);
        this.feedCells = new URL(this.baseUrl, CELLS_PATH);
    }

    public URL getBaseUrl() {
        return this.baseUrl;
    }

    private String encode(String s) {
        try {
            return URLEncoder.encode(s, StringEncodings.UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 is not supported by the JVM", e);
        }
    }

    public URL getSpreadsheetsFeedUrl() {
        return this.feedSpreadsheets;
    }

    public URL getWorksheetFeedUrl(String spreadsheetKey, String visibility, String projection) throws MalformedURLException {
        if (spreadsheetKey != null) {
            return makeUrl(this.feedWorksheets, encode(spreadsheetKey), visibility, projection);
        }
        throw new NullPointerException("spreadsheetKey is null");
    }

    public URL getTableFeedUrl(String spreadsheetKey) throws MalformedURLException {
        if (spreadsheetKey != null) {
            return new URL(this.baseUrl, BASE_PATH + encode(spreadsheetKey) + TABLE_PATH);
        }
        throw new NullPointerException("spreadsheetKey is null");
    }

    public URL getRecordFeedUrl(String spreadsheetKey, String tableId) throws MalformedURLException {
        if (spreadsheetKey != null) {
            return new URL(this.baseUrl, BASE_PATH + encode(spreadsheetKey) + RECORD_PATH + tableId);
        }
        throw new NullPointerException("spreadsheetKey is null");
    }

    public URL getListFeedUrl(String spreadsheetKey, String worksheetId, String visibility, String projection) throws MalformedURLException {
        return makeUrl(this.feedList, spreadsheetKey, worksheetId, visibility, projection);
    }

    public URL getCellFeedUrl(String spreadsheetKey, String worksheetId, String visibility, String projection) throws MalformedURLException {
        return makeUrl(this.feedCells, spreadsheetKey, worksheetId, visibility, projection);
    }

    private URL makeUrl(URL url, String spreadsheetKey, String parentResourceId, String visibility, String projection) throws MalformedURLException {
        if (spreadsheetKey == null) {
            throw new NullPointerException("spreadsheetKey is null");
        } else if (parentResourceId != null) {
            return makeUrl(url, encode(spreadsheetKey) + "/" + encode(parentResourceId), visibility, projection);
        } else {
            throw new NullPointerException("worksheetId is null");
        }
    }

    private URL makeUrl(URL url, String path, String visibility, String projection) throws MalformedURLException {
        if (visibility == null) {
            throw new NullPointerException("visibility is null");
        } else if (projection != null) {
            return new URL(url, path + "/" + encode(visibility) + "/" + encode(projection));
        } else {
            throw new NullPointerException("projection is null");
        }
    }

    public static String getSpreadsheetKeyFromUrl(String url) throws IllegalArgumentException {
        String[] dottedParts;
        try {
            String query = new URL(url).getQuery();
            if (query != null) {
                String[] parts = query.split("&");
                int offset = -1;
                int numParts = 0;
                String keyOrId = StringUtil.EMPTY_STRING;
                String[] arr$ = parts;
                int len$ = arr$.length;
                int i$ = 0;
                while (i$ < len$) {
                    String part = arr$[i$];
                    if (part.startsWith("id=")) {
                        offset = "id=".length();
                        keyOrId = part.substring(offset);
                        numParts = 4;
                        break;
                    } else if (part.startsWith("key=")) {
                        offset = "key=".length();
                        keyOrId = part.substring(offset);
                        if (keyOrId.startsWith("p")) {
                            return keyOrId;
                        }
                        numParts = 2;
                    } else {
                        i$++;
                    }
                }
                if (offset > -1) {
                    dottedParts = keyOrId.split("\\.");
                    if (dottedParts.length == numParts) {
                        return dottedParts[0] + "." + dottedParts[1];
                    }
                }
            }
        } catch (MalformedURLException e) {
            dottedParts = url.split("\\.");
            if (dottedParts.length == 4 || dottedParts.length == 2) {
                return dottedParts[0] + "." + dottedParts[1];
            }
        }
        throw new IllegalArgumentException("Uknown URL format.");
    }
}
