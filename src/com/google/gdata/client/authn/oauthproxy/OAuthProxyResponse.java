package com.google.gdata.client.authn.oauthproxy;

import com.google.common.collect.Lists;
import com.google.gdata.client.authn.oauthproxy.OAuthProxyProtocol.Header;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OAuthProxyResponse extends HashMap<String, String> {
    public OAuthProxyResponse(Map<String, List<String>> headers) {
        List<String> responseHeaders = Lists.newArrayList(Header.X_OAUTH_APPROVAL_URL, Header.X_OAUTH_ERROR, Header.X_OAUTH_ERROR_TEXT, Header.X_OAUTH_STATE);
        for (Entry<String, List<String>> entry : headers.entrySet()) {
            if (responseHeaders.contains(entry.getKey())) {
                put(entry.getKey(), ((List) entry.getValue()).get(0));
            }
        }
    }

    public String getApprovalUrl() {
        return (String) get(Header.X_OAUTH_APPROVAL_URL);
    }

    public void setApprovalUrl(String value) {
        put(Header.X_OAUTH_APPROVAL_URL, value);
    }

    public String getError() {
        return (String) get(Header.X_OAUTH_ERROR);
    }

    public void setError(String value) {
        put(Header.X_OAUTH_ERROR, value);
    }

    public String getErrorText() {
        return (String) get(Header.X_OAUTH_ERROR_TEXT);
    }

    public void setErrorText(String value) {
        put(Header.X_OAUTH_ERROR_TEXT, value);
    }

    public String getState() {
        return (String) get(Header.X_OAUTH_STATE);
    }

    public void setState(String value) {
        put(Header.X_OAUTH_STATE, value);
    }
}
