package ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.groupscheduleapp.groupscheduleapp.R;

import home.HomeActivity;
import ui.activity.MainActivity;

public class MenuFragment extends Fragment {

    private static final String TAG = MenuFragment.class.getName();

    private Button groupListButton;
    private Button eventListButton;
    private Button buttonLogout;

    public MenuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        groupListButton = (Button) rootView.findViewById(R.id.groupListButton);
        eventListButton = (Button) rootView.findViewById(R.id.eventsListButton);
        buttonLogout = (Button) rootView.findViewById(R.id.buttonLogout);

        addListeners();

        return rootView;
    }

    public static MenuFragment newInstance(FragmentFactory.FragmentName fn) {
        MenuFragment f = new MenuFragment();
        return f;
    }

    private void addListeners(){

        groupListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "group List Button button clicked");

                FragmentFactory ff = new FragmentFactory(FragmentFactory.FragmentName.GROUP_LIST_FRAGMENT);
                Fragment fragment = ff.build();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, fragment)
                        .addToBackStack(TAG)
                        .commit();

            }
        });

        eventListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "event List Button button clicked");

                FragmentFactory ff = new FragmentFactory(FragmentFactory.FragmentName.EVENT_LIST_FRAGMENT);
                Fragment fragment = ff.build();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, fragment)
                        .addToBackStack(TAG)
                        .commit();

            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();

                Intent intent = new Intent(getActivity(), HomeActivity.class);
                getActivity().startActivity(intent);
            }
        });

    }
}
