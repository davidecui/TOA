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
        @Namespace(reference = "http://www.w3.org/2005/Atom", prefix = "atom"),
        @Namespace(reference = "http://purl.org/rss/1.0/modules/syndication/", prefix = "sy")
})
public class Channel {
    @Element(name = "title")
    public String title;

    @ElementList(entry = "link", inline = true, required = false)
    public List<Link> links;

    @Element(name = "description")
    public String description;

    @Element(name = "lastBuildDate")
    public String lastBuildDate;

    @Element(name = "language", required = true)
    public String language;

    @Element(name = "updatePeriod")
    public String updatePeriod;

    @Element(name = "updateFrequency")
    public int updateFrequency;

    @Element(name = "generator")
    public String generator;

    @ElementList(name = "item", required = true, inline = true)
    public List<Item> items;
}
