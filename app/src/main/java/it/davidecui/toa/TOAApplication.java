package it.davidecui.toa;

import android.app.Activity;
import android.app.Application;
import android.net.http.HttpResponseCache;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * Created by davide on 30/09/2014.
 */
public class TOAApplication extends Application implements Application.ActivityLifecycleCallbacks {

    private static final String TOA_TAG = "TOA";

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            File httpCacheDir = new File(getCacheDir(), "http");
            long httpCacheSize = 10 * 1024 * 1024;
            HttpResponseCache.install(httpCacheDir, httpCacheSize);
        } catch (IOException e) {
            Log.i(TOA_TAG, "HTTP response cache installation failed:" + e);
        }

        registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        HttpResponseCache cache = HttpResponseCache.getInstalled();
        if (cache != null) {
            cache.flush();
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}