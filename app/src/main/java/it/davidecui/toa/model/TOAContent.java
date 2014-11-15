package it.davidecui.toa.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class TOAContent {

    /**
     * An array of sample (dummy) items.
     */
    private List<TOAItem> mItems = new ArrayList<TOAItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    private Map<String, TOAItem> mItemMap = new HashMap<String, TOAItem>();

    public TOAContent() {
        this(new ArrayList<TOAItem>(), new HashMap<String, TOAItem>());
    }

    public TOAContent(List<TOAItem> mItems, Map<String, TOAItem> itemMap) {
        this.mItems = mItems;
        this.mItemMap = itemMap;
    }

    public List<TOAItem> getItems() {
        return mItems;
    }

    public TOAItem getItem(String itemKey) {
        TOAItem itemToReturn = null;

        if (mItems.size() > 0)
        {
            itemToReturn = mItems.get(0);
        }

        if (mItemMap.containsKey(itemKey))
        {
            itemToReturn = mItemMap.get(itemKey);
        }

        return itemToReturn;
    }

    public void addItem(TOAItem item, String key)
    {
        mItems.add(item);
        mItemMap.put(key, item);
    }
}