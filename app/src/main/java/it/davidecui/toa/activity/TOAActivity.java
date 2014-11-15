package it.davidecui.toa.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import it.davidecui.toa.model.TOAContent;
import it.davidecui.toa.service.TOAService;
import it.davidecui.toa.service.TOAUpdateServiceConnection;

/**
 * Created by davide on 15/11/2014.
 */
public abstract class TOAActivity extends Activity {

    private BroadcastReceiver mTOAUpdateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            bindService(getUpdateServiceIntent(), new TOAUpdateServiceConnection(TOAActivity.this), Context.BIND_AUTO_CREATE);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mTOAUpdateReceiver, new IntentFilter(TOAService.CONTENT_UPDATE_EVENT));
    }

    @Override
    protected void onPause() {
        unregisterReceiver(mTOAUpdateReceiver);
        super.onPause();
    }

    protected Intent getUpdateServiceIntent() {
        return new Intent(this, TOAService.class);
    }

    public abstract void updateContent(TOAContent data);

}
