package it.davidecui.toa.testutil;

import android.app.Activity;
import android.os.Bundle;

import it.davidecui.toa.R;
import it.davidecui.toa.fragment.TOADataCallbacks;
import it.davidecui.toa.fragment.TOAItemSelectionCallbacks;
import it.davidecui.toa.model.TOAContent;


public class TestActivity extends Activity implements TOAItemSelectionCallbacks, TOADataCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty);
    }

    @Override
    public void onItemSelected(String id) {

    }

    @Override
    public TOAContent getTOAContent() {
        return new TOAContent();
    }
}
