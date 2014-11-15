package it.davidecui.toa.fragment;

/**
 * A dummy implementation of the {@link TOAItemSelectionCallbacks} interface that does
 * nothing. Used only when this fragment is not attached to an activity.
 */
class NullTOAItemSelectionCallbacks implements TOAItemSelectionCallbacks {
    @Override
    public void onItemSelected(String id) {
    }
}
