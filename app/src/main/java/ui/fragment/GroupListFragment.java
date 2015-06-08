package ui.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.groupscheduleapp.groupscheduleapp.R;

import java.util.ArrayList;
import java.util.List;

import ui.adapter.GroupAdapter;
import ui.model.Group;

public class GroupListFragment extends Fragment {


    private static final String TAG = GroupListFragment.class.getName();

    private List<Group> groupList = new ArrayList<Group>();
    private GroupAdapter aAdpt;
    private ListView lv;
    private Button buttonAddGroup;

    public GroupListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_group_list, container, false);

        initList();

       lv = (ListView) rootView.findViewById(R.id.group_list);
       buttonAddGroup = (Button) rootView.findViewById(R.id.buttonAddGroup);

        aAdpt = new GroupAdapter(groupList, getActivity());
        lv.setAdapter(aAdpt);

        // add listener to button
        buttonAddGroup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Create custom dialog object
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                // Include dialog.xml file
                dialog.setContentView(R.layout.add_group_element_dialog);
                // Set dialog title
//                dialog.setTitle("Custom Dialog");

                final EditText nameField = (EditText) dialog.findViewById(R.id.nameField);
                final EditText descriptionField = (EditText) dialog.findViewById(R.id.descriptionField);

                dialog.show();

                Button declineButton = (Button) dialog.findViewById(R.id.declineButton);

                declineButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Close dialog
                        if(nameField.getText().toString().equals("") || descriptionField.getText().toString().equals("")){
                            Toast toast = Toast.makeText(getActivity(), "Fill both filds", Toast.LENGTH_SHORT);
                            toast.show();
                        }else{
                            groupList.add(new Group(nameField.getText().toString(), descriptionField.getText().toString()));
                            aAdpt.notifyDataSetChanged();
                            dialog.dismiss();
                        }

                    }
                });


            }

        });

        return rootView;
    }

    private void initList() {
        groupList.add(new Group("Employees", "HAK Group 's employees"));
        groupList.add(new Group("Farmers", "Farmers from Malopolska province"));
    }

    public static GroupListFragment newInstance(FragmentFactory.FragmentName fn) {
        GroupListFragment f = new GroupListFragment();
        return f;
    }
}
