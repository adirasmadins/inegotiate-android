package com.google.api.client.json.rpc2;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public class JsonRpcRequest extends GenericData {
    @Key
    public Object id;
    @Key
    public final String jsonrpc;
    @Key
    public String method;
    @Key
    public Object params;

    public JsonRpcRequest() {
        this.jsonrpc = "2.0";
    }
}
