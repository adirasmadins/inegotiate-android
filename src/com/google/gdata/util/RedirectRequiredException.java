package com.google.gdata.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;

public class RedirectRequiredException extends ServiceException {
    private static final String LOCATION = "Location";

    public RedirectRequiredException(int sc, String location) {
        super("Redirect Required");
        setHttpErrorCodeOverride(sc);
        getHttpHeaders().put(LOCATION, Collections.singletonList(location));
    }

    public RedirectRequiredException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        setHttpErrorCodeOverride(httpConn.getResponseCode());
    }

    public String getRedirectLocation() {
        List<String> location = getHttpHeader(LOCATION);
        if (location == null || location.size() <= 0) {
            return null;
        }
        return (String) location.get(0);
    }
}
