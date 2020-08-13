package com.trivago.magazine.ui.actions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Validations {

    private static final Logger log = LogManager.getLogger(Validations.class);

    /**
     * This method verify if exists any broken link.
     * Return true if all links are working, otherwise false
     */
    public static boolean areLinksWorking(HashSet<String> links )  {
        HttpURLConnection httpConnection = null;

        log.info("Number of links found:" + links.size());
        List<String> brokenLinks = new ArrayList<>();
        for (String link : links) {
            try {
                System.out.println(link);
                httpConnection = getHttpConnection(link.trim());
                httpConnection.setRequestMethod("HEAD");
                httpConnection.connect();
                int responseCode = httpConnection.getResponseCode();

                // Verify if its a client error or server error
                if (responseCode > 400) {
                    brokenLinks.add(link);
                    log.error(String.format("Broken Link:%s\tStatus Code:%d", link, responseCode));
                }
            } catch (MalformedURLException m) {
                log.error("Malformed URL:" + link);
                m.printStackTrace();
            } catch (IOException e) {
                log.error("IOExpection:" + link);
                e.printStackTrace();
            }
        }

        return brokenLinks.isEmpty();
    }

    /**
     * Create Http connection.
     *
     * @param url connect to URL
     * @return http connection
     */
    public static HttpURLConnection getHttpConnection(String url) {
        HttpURLConnection httpConnection = null;
        try {
            httpConnection = (HttpURLConnection)(new URL(url.trim()).openConnection());
            httpConnection.setConnectTimeout(10 * 1000);
            httpConnection.setReadTimeout(10 * 1000);

        } catch (MalformedURLException m) {
            log.error("Malformed URL: " + url);
            m.printStackTrace();

        } catch (IOException e) {
            log.error("IOExpection: " + url);
            e.printStackTrace();
        }

        return httpConnection;
    }
}
