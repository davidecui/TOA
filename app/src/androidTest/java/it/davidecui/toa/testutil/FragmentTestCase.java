package it.davidecui.toa.testutil;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.test.ActivityInstrumentationTestCase2;

import it.davidecui.toa.R;

public abstract class FragmentTestCase extends ActivityInstrumentationTestCase2<TestActivity>{

    private TestActivity mActivity;
    private final String tag = "tag";

    public FragmentTestCase() {
        this(TestActivity.class);
    }

    public FragmentTestCase(Class<TestActivity> activityClass) {
        super(activityClass);
    }

    public void setUp() throws Exception {
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        mActivity = getActivity();
    }

    protected Fragment startFragment(Fragment fragment) {
        FragmentTransaction transaction = mActivity.getFragmentManager().beginTransaction();
        transaction.add(R.id.empty, fragment, tag);
        transaction.commit();
        getInstrumentation().waitForIdleSync();
        return mActivity.getFragmentManager().findFragmentByTag(tag);
    }
}