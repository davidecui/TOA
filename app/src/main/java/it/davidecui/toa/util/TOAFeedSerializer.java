package it.davidecui.toa.util;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import it.davidecui.toa.model.rss.Rss;

/**
 * Created by davide on 28/09/2014.
 */
public class TOAFeedSerializer {
    private Rss serializedContent;

    public void serializeFeed(TOAFeedRequest request) throws Exception {
        String content = request.getContent();
        Serializer serializer = new Persister();
        serializedContent = serializer.read(Rss.class, content);
    }

    public Rss getSerializedContent() {
        return serializedContent;
    }
}
