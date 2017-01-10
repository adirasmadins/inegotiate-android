package com.amazonaws.handlers;

import com.amazonaws.AmazonClientException;
import com.google.gdata.util.common.base.StringUtil;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HandlerChainFactory {
    public List<RequestHandler> newRequestHandlerChain(String str) {
        List<RequestHandler> arrayList = new ArrayList();
        try {
            InputStream resourceAsStream = getClass().getResourceAsStream(str);
            if (resourceAsStream == null) {
                return arrayList;
            }
            String trim;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return arrayList;
                }
                trim = readLine.trim();
                if (!trim.equals(StringUtil.EMPTY_STRING)) {
                    Object newInstance = getClass().getClassLoader().loadClass(trim).newInstance();
                    if (!(newInstance instanceof RequestHandler)) {
                        break;
                    }
                    arrayList.add((RequestHandler) newInstance);
                }
            }
            throw new AmazonClientException("Unable to instantiate request handler chain for client.  Listed request handler ('" + trim + "') " + "does not implement the RequestHandler interface.");
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to instantiate request handler chain for client: " + e.getMessage(), e);
        }
    }
}
