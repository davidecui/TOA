package it.davidecui.toa.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import it.davidecui.toa.activity.TOAActivity;

/**
* Created by davide on 15/11/2014.
*/
public class TOAUpdateServiceConnection implements ServiceConnection {
    private TOAActivity toaActivity;

    public TOAUpdateServiceConnection(TOAActivity toaActivity) {
        this.toaActivity = toaActivity;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        LocalBinder binder = (LocalBinder) service;
        TOAService toaService = (TOAService) binder.getService();
        toaActivity.updateContent(toaService.getContent());
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
