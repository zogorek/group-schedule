package ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.groupscheduleapp.groupscheduleapp.R;

public class EventListFragment extends Fragment {
    private static final String TAG = GroupListFragment.class.getName();

    public EventListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_list, container, false);
        return rootView;
    }

    public static EventListFragment newInstance(FragmentFactory.FragmentName fn) {
        EventListFragment f = new EventListFragment();
        return f;
    }
}
