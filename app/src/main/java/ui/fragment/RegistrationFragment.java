package ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.groupscheduleapp.groupscheduleapp.R;

public class RegistrationFragment  extends Fragment {

    private static final String TAG = HomeFragment.class.getName();

    private Button bRegister;
    private EditText registrationUsernameField;
    private EditText registrationEmailField;
    private EditText registrationPassword1Field;
    private EditText registrationPassword2Field;

    public RegistrationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_registration, container, false);

        bRegister = (Button) rootView.findViewById(R.id.registerUserButton);
        registrationUsernameField = (EditText) rootView.findViewById(R.id.registrationUsernameField);
        registrationEmailField = (EditText) rootView.findViewById(R.id.registrationEmailField);
        registrationPassword1Field = (EditText) rootView.findViewById(R.id.registrationPassword1Field);
        registrationPassword2Field = (EditText) rootView.findViewById(R.id.registrationPassword2Field);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Register button clicked");
                if(registrationUsernameField.getText().toString().equals("") ||
                        registrationEmailField.getText().toString().equals("") ||
                        registrationPassword1Field.getText().toString().equals("") ||
                        registrationPassword2Field.getText().toString().equals("")) {

                    Toast toast = Toast.makeText(getActivity(), "Fill all fields", Toast.LENGTH_SHORT);
                    toast.show();

                }else{
                    Toast toast = Toast.makeText(getActivity(), "Account registered.", Toast.LENGTH_SHORT);
                    toast.show();
                    getActivity().onBackPressed();
                }

            }
        });

        return rootView;
    }

    public static RegistrationFragment newInstance(FragmentFactory.FragmentName fn) {
        RegistrationFragment f = new RegistrationFragment();
        return f;
    }
}
