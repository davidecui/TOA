package it.davidecui.toa.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import it.davidecui.toa.R;
import it.davidecui.toa.model.TOAContent;
import it.davidecui.toa.model.TOAItem;
import it.davidecui.toa.service.TOAUpdateServiceConnection;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link it.davidecui.toa.activity.ItemListActivity}
 * in two-pane mode (on tablets) or a {@link it.davidecui.toa.activity.ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private String mKey;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
        mKey = "";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mKey = getArguments().getString(ARG_ITEM_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_detail, container, false);
    }

    public void setTOAContent(TOAContent data) {
        TOAItem item = data.getItem(mKey);

        // Show the dummy content as text in a TextView.
        View view = getView();
        if (view != null && item != null) {
            ((TextView) view.findViewById(R.id.item_detail)).setText(item.getContent());
        }
    }
}
