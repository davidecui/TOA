package it.davidecui.toa.model.rss;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;

import java.util.List;

/**
 * Created by davide on 30/09/2014.
 */
@NamespaceList({
        @Namespace(prefix = "content", reference = "http://purl.org/rss/1.0/modules/content/"),
        @Namespace(prefix = "wfw", reference = "http://wellformedweb.org/CommentAPI/"),
        @Namespace(prefix = "dc", reference = "http://purl.org/dc/elements/1.1/"),
        //@Namespace(reference = "http://purl.org/rss/1.0/modules/slash/", prefix = "slash")
})
public class Item {
    @Element(name = "title", required = false)
    public String title;

    @Element(name = "link")
    public String link;

    @Element(name = "guid")
    public String guid;

    @ElementList(entry = "comments", inline = true)
    public List<String> comments;

    @Element(name = "pubDate")
    public String pubDate;

    @ElementList(name = "category", inline = true)
    public List<Category> categories;

    @Element(name = "creator")
    public String creator;

    @Element(name = "description", required = false)
    public String description;

    @Element(name = "encoded", data = true, required = false)
    public String encoded;

    @Element(name = "commentRss")
    public String commentRss;

    @Override
    public String toString() {
        return title + "\n" + creator + "\n" + pubDate + "\n";
    }
}
