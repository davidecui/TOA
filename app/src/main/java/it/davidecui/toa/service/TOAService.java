package it.davidecui.toa.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.Loader;

import it.davidecui.toa.loader.TOAContentLoader;
import it.davidecui.toa.model.TOAContent;

/**
 * Created by davide on 15/11/2014.
 */
public class TOAService extends Service implements Loader.OnLoadCompleteListener<TOAContent> {
    public static final String CONTENT_UPDATE_EVENT = "it.davidecui.toa.service.TOAService.contentUpdate";

    private static final int LOADER_ID = 0;
    private TOAContent content;
    private LocalBinder localBinder;
    private TOAContentLoader loader;

    public TOAService() {
        this(new TOAContent(), new LocalBinder());
    }

    public TOAService(TOAContent content, LocalBinder localBinder) {
        this.content = content;
        this.localBinder = localBinder;
    }

    @Override
    public IBinder onBind(Intent intent) {
        localBinder.setService(this);
        return localBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        loader = new TOAContentLoader(this);
        loader.registerListener(LOADER_ID, this);
        loader.startLoading();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        // Stop the cursor loader
        if (loader != null) {
            loader.unregisterListener(this);
            loader.cancelLoad();
            loader.stopLoading();
        }
    }

    @Override
    public void onLoadComplete(Loader<TOAContent> loader, TOAContent data) {
        content = data;
        sendBroadcast(new Intent(CONTENT_UPDATE_EVENT));
    }

    public TOAContent getContent() {
        return content;
    }
}
