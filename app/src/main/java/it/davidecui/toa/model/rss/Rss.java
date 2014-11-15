package it.davidecui.toa.model.rss;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by davide on 30/09/2014.
 */
@Root
public class Rss {
    @Element(name = "channel")
    public Channel mChannel;

    @Attribute
    public String version;
}