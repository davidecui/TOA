package it.davidecui.toa.service;

import android.app.Service;
import android.os.Binder;

/**
 * Created by davide on 15/11/2014.
 */
public class LocalBinder extends Binder {
    private Service mService;

    public Service getService() {
        return mService;
    }

    public void setService(Service service) {
        mService = service;
    }
}
