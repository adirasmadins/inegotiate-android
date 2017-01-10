package com.google.gdata.client.authn.oauth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

public class OAuthHttpClient {
    public String getResponse(URL url) throws OAuthException {
        return getResponse(url, null);
    }

    public String getResponse(URL url, Map<String, String> headers) throws OAuthException {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (headers != null) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    connection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            connection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            while (true) {
                String inputLine = in.readLine();
                if (inputLine != null) {
                    response.append(inputLine);
                } else {
                    in.close();
                    return response.toString();
                }
            }
        } catch (IOException e) {
            throw new OAuthException("Error getting HTTP response", e);
        }
    }
}
