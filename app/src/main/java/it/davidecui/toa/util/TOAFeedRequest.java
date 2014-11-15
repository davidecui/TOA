package it.davidecui.toa.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by davide on 28/09/2014.
 */
public class TOAFeedRequest {
    private String feedUrl;
    private String content;

    public TOAFeedRequest(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public void requestTOAFeed() {
        try {
            URL url = new URL(feedUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setUseCaches(true);
            InputStream input = connection.getInputStream();
            content = IOUtils.toString(input, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getContent() {
        return content;
    }
}
