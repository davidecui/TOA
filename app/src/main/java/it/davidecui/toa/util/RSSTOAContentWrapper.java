package it.davidecui.toa.util;

import it.davidecui.toa.model.TOAContent;
import it.davidecui.toa.model.TOAItem;
import it.davidecui.toa.model.rss.Item;
import it.davidecui.toa.model.rss.Rss;

/**
 * Created by davide on 12/11/2014.
 */
public class RSSTOAContentWrapper extends TOAContent {

    public void setRSSData(Rss serializedContent) {
        for (Item item : serializedContent.mChannel.items)
        {
            addItem(new TOAItem(item.guid, item.title), item.guid);
        }
    }
}
