package it.davidecui.toa.util;

import android.test.InstrumentationTestCase;

import junit.framework.Assert;

public class TOAFeedRequestTest extends InstrumentationTestCase {

    private TOAFeedRequest mTarget;
    private String mUrl = "http://thoughtsofangel.com/feed/";

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mTarget = new TOAFeedRequest(mUrl);
    }

    public void testRequestTOAFeed() throws Exception {
        mTarget.requestTOAFeed();
        String result = mTarget.getContent();
        Assert.assertNotNull(result);
    }
}