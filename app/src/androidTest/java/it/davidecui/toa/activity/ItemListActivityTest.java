package it.davidecui.toa.activity;

import android.test.ActivityInstrumentationTestCase2;

import it.davidecui.toa.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDisplayed;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

public class ItemListActivityTest extends ActivityInstrumentationTestCase2<ItemListActivity>{

    public ItemListActivityTest() {
        this(ItemListActivity.class);
    }

    public ItemListActivityTest(Class<ItemListActivity> activityClass) {
        super(activityClass);
    }

    public void setUp() throws Exception {
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        getActivity();
    }

    public void testEspresso() throws Exception {
        // if this test fails with message
        // "Waited for the root of the view hierarchy to have window focus and not be requesting layout for over 10 seconds."
        // try to disable all animations from device/emulator

        // this test actually fails on lollipop
        // https://code.google.com/p/android-test-kit/issues/detail?id=84
        onView(withId(R.id.item_list)).check(matches(isDisplayed()));
    }

    public void tearDown() throws Exception {

    }
}