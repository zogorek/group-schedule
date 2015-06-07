package ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.groupscheduleapp.groupscheduleapp.R;

public class GroupListFragment extends Fragment {


    private static final String TAG = GroupListFragment.class.getName();

    public GroupListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_group_list, container, false);
        return rootView;
    }

    public static GroupListFragment newInstance(FragmentFactory.FragmentName fn) {
        GroupListFragment f = new GroupListFragment();
        return f;
    }
}
