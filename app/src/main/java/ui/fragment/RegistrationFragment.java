package ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.groupscheduleapp.groupscheduleapp.R;

public class RegistrationFragment  extends Fragment {

    private static final String TAG = HomeFragment.class.getName();

    private Button bRegister;

    public RegistrationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_registration, container, false);

        bRegister = (Button) rootView.findViewById(R.id.registerUserButton);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Register button clicked");
            }
        });

        return rootView;
    }

    public static RegistrationFragment newInstance(FragmentFactory.FragmentName fn) {
        RegistrationFragment f = new RegistrationFragment();
        return f;
    }
}
