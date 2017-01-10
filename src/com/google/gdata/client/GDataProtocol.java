package com.google.gdata.client;

public class GDataProtocol {

    public interface Error {
        public static final int UNPROCESSABLE_ENTITY = 422;
    }

    public interface Header {
        public static final String ACCEPT_LANGUAGE = "Accept-Language";
        public static final String CACHE_CONTROL = "Cache-Control";
        public static final String ETAG = "ETag";
        public static final String IF_MATCH = "If-Match";
        public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
        public static final String IF_NONE_MATCH = "If-None-Match";
        public static final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
        public static final String LAST_MODIFIED = "Last-Modified";
        public static final String METHOD_OVERRIDE = "X-HTTP-Method-Override";
        public static final String VERSION = "GData-Version";
        public static final String X_UPLOAD_CONTENT_LENGTH = "X-Upload-Content-Length";
        public static final String X_UPLOAD_CONTENT_TYPE = "X-Upload-Content-Type";
    }

    public interface Method {
        public static final String PATCH = "PATCH";
    }

    public interface Parameter {
        public static final String ALT = "alt";
        public static final String CALLBACK = "callback";
        public static final String CONTEXT = "context";
        public static final String FIELDS = "fields";
        public static final String LANGUAGE = "hl";
        public static final String PRETTYPRINT = "prettyprint";
        public static final String REQID = "reqid";
        public static final String STRICT = "strict";
        public static final String VERSION = "v";
        public static final String XOAUTH_REQUESTOR_ID = "xoauth_requestor_id";
    }

    public interface Query extends Parameter {
        public static final String AUTHOR = "author";
        public static final String CATEGORY = "category";
        public static final String FULL_TEXT = "q";
        public static final String MAX_RESULTS = "max-results";
        public static final String PUBLISHED_MAX = "published-max";
        public static final String PUBLISHED_MIN = "published-min";
        public static final String START_INDEX = "start-index";
        public static final String START_TOKEN = "start-token";
        public static final String UPDATED_MAX = "updated-max";
        public static final String UPDATED_MIN = "updated-min";
    }

    private GDataProtocol() {
    }

    public static boolean isWeakEtag(String etag) {
        return etag != null && etag.startsWith("W/");
    }
}
