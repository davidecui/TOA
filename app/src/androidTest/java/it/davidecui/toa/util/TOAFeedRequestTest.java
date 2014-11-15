package it.davidecui.toa.util;

import android.test.InstrumentationTestCase;

import junit.framework.Assert;

public class TOAFeedRequestTest extends InstrumentationTestCase {

    private static final String FEED_URL = "http://thoughtsofangel.com/feed/";

    private TOAFeedRequest mTarget;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mTarget = new TOAFeedRequest(FEED_URL);
    }

    public void testRequestTOAFeed() throws Exception {
        mTarget.requestTOAFeed();
        String result = mTarget.getContent();
        Assert.assertNotNull(result);
    }
}