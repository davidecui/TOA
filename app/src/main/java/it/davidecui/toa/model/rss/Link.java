package it.davidecui.toa.model.rss;

import org.simpleframework.xml.Attribute;

/**
 * Created by davide on 30/09/2014.
 */
public class Link {
    @Attribute(required = false)
    public String href;

    @Attribute(required = false)
    public String rel;

    @Attribute(required = false)
    public String type;

}
