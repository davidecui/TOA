package it.davidecui.toa;

import android.test.InstrumentationTestCase;

import it.davidecui.toa.util.TOAFeedRequest;
import it.davidecui.toa.util.TOAFeedSerializer;

/**
 * Created by davide on 28/09/2014.
 *
 */
public class ServerRequestEndToEndTest extends InstrumentationTestCase {

    private TOAFeedRequest mRequest;
    private TOAFeedSerializer mSerializer = new TOAFeedSerializer();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mRequest = new TOAFeedRequest(getInstrumentation().getTargetContext().getString(R.string.feed_url));
    }

    public void testGetFeedAndSerialize() throws Exception {
        mRequest.requestTOAFeed();
        mSerializer.serializeFeed(mRequest);
        mSerializer.getSerializedContent();
    }
}
