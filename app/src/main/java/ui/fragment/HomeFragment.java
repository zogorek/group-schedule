package ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ui.fragment.FragmentFactory.FragmentName;

import com.groupscheduleapp.groupscheduleapp.R;


public class HomeFragment  extends Fragment {

    private static final String TAG = HomeFragment.class.getName();

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }

    public static HomeFragment newInstance(FragmentName fn) {
        HomeFragment f = new HomeFragment();
        return f;
    }
}
