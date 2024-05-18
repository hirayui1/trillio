package com.semanticsquare.thrillio.util;

import java.io.IOException;
import java.net.*;

public class HttpConnect {
    public static String download (String sourceUrl) throws MalformedURLException, URISyntaxException {
        System.out.println("Downloading: " + sourceUrl);
        URL url = new URI(sourceUrl).toURL();

        try {
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            int responseCode = con.getResponseCode();
            System.out.println("responseCode: " + responseCode);
            if (responseCode >= 200 && responseCode < 300) {
                return IOUtil.read(con.getInputStream());
            } else  if (responseCode == HttpURLConnection.HTTP_MOVED_PERM) { // 301
                String newUrl = con.getHeaderField("Location");
                System.out.println("New URL: " + newUrl);
                // Swap connections and get new Response
                con.disconnect(); // Disconnect the current connection
                url = new URL(newUrl); // Create a new URL object with the new URL
                con = (HttpURLConnection) url.openConnection(); // Open a new connection with the new URL
                responseCode = con.getResponseCode(); // Get the response code for the new connection

                // continue processing the response as before
                System.out.println("New responseCode: " + responseCode);
                if (responseCode >= 200 && responseCode < 300) {
                    // If the response code is in the success range, read and return the response body
                    return IOUtil.read(con.getInputStream());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
