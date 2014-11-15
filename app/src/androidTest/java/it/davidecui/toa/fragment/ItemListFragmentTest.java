package it.davidecui.toa.fragment;


import android.app.Fragment;

/**
 * Created by davide on 12/10/2014.
 */
public class ItemListFragmentTest extends FragmentTestCase {

    private Fragment mTarget;

    public ItemListFragmentTest() {
        super();
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mTarget = startFragment(new ItemListFragment());
    }

    public void testFragment() {
        assertNotNull(mTarget);
    }

}
