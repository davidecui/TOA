package it.davidecui.toa.model;

/**
 * A dummy item representing a piece of content.
 */
public class TOAItem {
    private String id;

    private String content;

    public TOAItem(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return content;
    }
}
