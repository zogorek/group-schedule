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

import ui.activity.MainActivity;

public class LoginFragment  extends Fragment {

    private static final String TAG = HomeFragment.class.getName();

    private Button bLogin;
    private Intent intent;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        bLogin = (Button) rootView.findViewById(R.id.loginUserButton);

        addListeners();

        return rootView;
    }

    public static LoginFragment newInstance(FragmentFactory.FragmentName fn) {
        LoginFragment f = new LoginFragment();
        return f;
    }

    private void addListeners(){

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Login user button clicked");
                intent  = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

    }
}
