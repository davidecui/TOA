package it.davidecui.toa.testutil;

/**
 * Created by davide on 30/09/2014.
 *
 * Test strings used for model parsing
 */
public class TestStrings {
    public String getValidRssWithOneItem() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<rss version=\"2.0\"\n" +
                "\txmlns:content=\"http://purl.org/rss/1.0/modules/content/\"\n" +
                "\txmlns:wfw=\"http://wellformedweb.org/CommentAPI/\"\n" +
                "\txmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n" +
                "\txmlns:atom=\"http://www.w3.org/2005/Atom\"\n" +
                "\txmlns:sy=\"http://purl.org/rss/1.0/modules/syndication/\"\n" +
                "\txmlns:slash=\"http://purl.org/rss/1.0/modules/slash/\"\n" +
                "\t>\n" +
                "\n" +
                "<channel>\n" +
                "\t<title>Thoughts Of Angel</title>\n" +
                "\t<atom:link href=\"http://thoughtsofangel.com/feed/\" rel=\"self\" type=\"application/rss+xml\" />\n" +
                "\t<link>http://thoughtsofangel.com</link>\n" +
                "\t<description>Your daily dose of fun, laughter and thought...</description>\n" +
                "\t<lastBuildDate>Sun, 28 Sep 2014 06:31:16 +0000</lastBuildDate>\n" +
                "\t<language>en-US</language>\n" +
                "\t\t<sy:updatePeriod>hourly</sy:updatePeriod>\n" +
                "\t\t<sy:updateFrequency>1</sy:updateFrequency>\n" +
                "\t<generator>http://wordpress.org/?v=3.9.2</generator>\n" +
                "\t<item>\n" +
                "\t\t<title>Sometimes I like to play God and just ignore everyone that speaks to me!</title>\n" +
                "\t\t<link>http://thoughtsofangel.com/2014/09/28/sometimes-i-like-to-play-god-and-just-ignore-everyone-that-speaks-to-me/?utm_source=rss&#038;utm_medium=rss&#038;utm_campaign=sometimes-i-like-to-play-god-and-just-ignore-everyone-that-speaks-to-me</link>\n" +
                "\t\t<comments>http://thoughtsofangel.com/2014/09/28/sometimes-i-like-to-play-god-and-just-ignore-everyone-that-speaks-to-me/#comments</comments>\n" +
                "\t\t<pubDate>Sun, 28 Sep 2014 06:31:16 +0000</pubDate>\n" +
                "\t\t<dc:creator><![CDATA[Darobsta]]></dc:creator>\n" +
                "\t\t\t\t<category><![CDATA[Uncategorized]]></category>\n" +
                "\n" +
                "\t\t<guid isPermaLink=\"false\">http://thoughtsofangel.com/?p=2944</guid>\n" +
                "\t\t<description><![CDATA[]]></description>\n" +
                "\t\t\t\t<content:encoded><![CDATA[<p><a href=\"http://thoughtsofangel.com/wp-content/uploads/2014/09/wpid-IMG_20140362_edit.jpg\"><img title=\"IMG_20140362_edit.jpg\" class=\"alignnone size-full\" alt=\"image\" src=\"http://thoughtsofangel.com/wp-content/uploads/2014/09/wpid-IMG_20140362_edit.jpg\" /></a></p>\n" +
                "]]></content:encoded>\n" +
                "\t\t\t<wfw:commentRss>http://thoughtsofangel.com/2014/09/28/sometimes-i-like-to-play-god-and-just-ignore-everyone-that-speaks-to-me/feed/</wfw:commentRss>\n" +
                "\t\t<slash:comments>0</slash:comments>\n" +
                "\t\t</item>\n" +
                "\t</channel>\n" +
                "</rss>\n";
    }

    public String getRssWithNoItems() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<rss version=\"2.0\"\n" +
                "\txmlns:content=\"http://purl.org/rss/1.0/modules/content/\"\n" +
                "\txmlns:wfw=\"http://wellformedweb.org/CommentAPI/\"\n" +
                "\txmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n" +
                "\txmlns:atom=\"http://www.w3.org/2005/Atom\"\n" +
                "\txmlns:sy=\"http://purl.org/rss/1.0/modules/syndication/\"\n" +
                "\txmlns:slash=\"http://purl.org/rss/1.0/modules/slash/\"\n" +
                "\t>\n" +
                "\n" +
                "<channel>\n" +
                "\t<title>Thoughts Of Angel</title>\n" +
                "\t<atom:link href=\"http://thoughtsofangel.com/feed/\" rel=\"self\" type=\"application/rss+xml\" />\n" +
                "\t<link>http://thoughtsofangel.com</link>\n" +
                "\t<description>Your daily dose of fun, laughter and thought...</description>\n" +
                "\t<lastBuildDate>Sun, 28 Sep 2014 06:31:16 +0000</lastBuildDate>\n" +
                "\t<language>en-US</language>\n" +
                "\t\t<sy:updatePeriod>hourly</sy:updatePeriod>\n" +
                "\t\t<sy:updateFrequency>1</sy:updateFrequency>\n" +
                "\t<generator>http://wordpress.org/?v=3.9.2</generator>\n" +
                "\t</channel>\n" +
                "</rss>\n";
    }
}
