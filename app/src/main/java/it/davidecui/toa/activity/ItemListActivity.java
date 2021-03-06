package it.davidecui.toa.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import it.davidecui.toa.R;
import it.davidecui.toa.fragment.ItemDetailFragment;
import it.davidecui.toa.fragment.ItemListFragment;
import it.davidecui.toa.fragment.TOAItemSelectionCallbacks;
import it.davidecui.toa.model.TOAContent;
import it.davidecui.toa.service.LocalBinder;
import it.davidecui.toa.service.TOAService;


/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link it.davidecui.toa.fragment.ItemListFragment} and the item details
 * (if present) is a {@link it.davidecui.toa.fragment.ItemDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link it.davidecui.toa.fragment.TOAItemSelectionCallbacks} interface
 * to listen for item selections.
 */
public class ItemListActivity extends TOAActivity implements TOAItemSelectionCallbacks{

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ItemListFragment) getFragmentManager()
                    .findFragmentById(R.id.item_list))
                    .setActivateOnItemClick(true);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(getUpdateServiceIntent());
    }

    /**
     * Callback method from {@link it.davidecui.toa.fragment.TOAItemSelectionCallbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    @Override
    public void updateContent(TOAContent data) {
        ((ItemListFragment) getFragmentManager()
                .findFragmentById(R.id.item_list))
                .setTOAContent(data);
    }
}
