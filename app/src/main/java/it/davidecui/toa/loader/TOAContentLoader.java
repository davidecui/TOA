package it.davidecui.toa.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import it.davidecui.toa.R;
import it.davidecui.toa.model.TOAContent;
import it.davidecui.toa.model.rss.Rss;
import it.davidecui.toa.util.RSSTOAContentWrapper;
import it.davidecui.toa.util.TOAFeedRequest;
import it.davidecui.toa.util.TOAFeedSerializer;

/**
 * Created by davide on 01/11/2014.
 */
public class TOAContentLoader extends AsyncTaskLoader<TOAContent> {
    private TOAFeedRequest mRequest;
    private TOAFeedSerializer mSerializer;
    private final RSSTOAContentWrapper adapter;

    /**
     * Stores away the application context associated with context.
     * Since Loaders can be used across multiple activities it's dangerous to
     * store the context directly; always use {@link #getContext()} to retrieve
     * the Loader's Context, don't use the constructor argument directly.
     * The Context returned by {@link #getContext} is safe to use across
     * Activity instances.
     *
     * @param context used to retrieve the application context.
     */
    public TOAContentLoader(Context context) {
        this(context, new TOAFeedRequest(context.getString(R.string.feed_url)), new TOAFeedSerializer(), new RSSTOAContentWrapper());
    }

    public TOAContentLoader(Context context, TOAFeedRequest toaFeedRequest, TOAFeedSerializer toaFeedSerializer, RSSTOAContentWrapper adapter) {
        super(context);
        mRequest = toaFeedRequest;
        mSerializer = toaFeedSerializer;
        this.adapter = adapter;
    }

    @Override
    public TOAContent loadInBackground() {
        TOAContent content = null;

        if (adapter.getItems().size() == 0) {
            mRequest.requestTOAFeed();
            try {
                mSerializer.serializeFeed(mRequest);
                Rss rssSerializedContent = mSerializer.getSerializedContent();
                adapter.setRSSData(rssSerializedContent);
                content = adapter;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return content;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }
}
