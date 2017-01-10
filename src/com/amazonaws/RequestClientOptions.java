package com.amazonaws;

import com.google.gdata.util.common.base.StringUtil;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public final class RequestClientOptions {
    private String clientMarker;

    private String createClientMarkerString(String str) {
        return this.clientMarker.contains(str) ? this.clientMarker : this.clientMarker + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str;
    }

    public void addClientMarker(String str) {
        if (this.clientMarker == null) {
            this.clientMarker = StringUtil.EMPTY_STRING;
        }
        this.clientMarker = createClientMarkerString(str);
    }

    public String getClientMarker() {
        return this.clientMarker;
    }
}
