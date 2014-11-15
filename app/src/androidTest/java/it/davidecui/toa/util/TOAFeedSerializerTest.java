package it.davidecui.toa.util;

import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import org.mockito.Mockito;
import org.simpleframework.xml.core.ValueRequiredException;

import it.davidecui.toa.model.rss.Rss;
import it.davidecui.toa.testutil.TestStrings;

import static org.mockito.Mockito.when;

public class TOAFeedSerializerTest extends InstrumentationTestCase {
    TestStrings testStrings = new TestStrings();
    private TOAFeedSerializer target;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        target = new TOAFeedSerializer();
    }

    public void testSerializeFeed() throws Exception {
        String testString = testStrings.getValidRssWithOneItem();
        TOAFeedRequest mockRequest = Mockito.mock(TOAFeedRequest.class);
        when(mockRequest.getContent()).thenReturn(testString);
        target.serializeFeed(mockRequest);
        Rss serializedContent = target.getSerializedContent();
        Assert.assertNotNull(serializedContent);

        Mockito.verify(mockRequest).getContent();
        Mockito.verifyNoMoreInteractions(mockRequest);
    }


    public void testSerializeEmptyFeed() throws Exception {
        String testString = testStrings.getRssWithNoItems();
        TOAFeedRequest mockRequest = Mockito.mock(TOAFeedRequest.class);
        when(mockRequest.getContent()).thenReturn(testString);

        try {
            target.serializeFeed(mockRequest);
            Rss serializedContent = target.getSerializedContent();
            fail("ValueRequiredException not thrown");
        } catch (ValueRequiredException expected) {
        }
        Mockito.verify(mockRequest).getContent();
        Mockito.verifyNoMoreInteractions(mockRequest);
    }
}