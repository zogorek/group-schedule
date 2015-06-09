package ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.groupscheduleapp.groupscheduleapp.R;

import java.util.ArrayList;
import java.util.List;

import ui.adapter.EventAdapter;
import ui.model.Event;

public class EventListFragment extends Fragment {

    private static final String TAG = EventListFragment.class.getName();

    private List<Event> eventList = new ArrayList<Event>();
    private EventAdapter aAdpt;
    private ListView lv;
    private Button buttonAddEvent;

    public EventListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_list, container, false);

        lv = (ListView) rootView.findViewById(R.id.event_list);
        buttonAddEvent = (Button) rootView.findViewById(R.id.buttonaddevent);

        aAdpt = new EventAdapter(eventList, getActivity());
        lv.setAdapter(aAdpt);

        initList();

        // add listener to button
        buttonAddEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Create custom dialog object
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                // Include dialog.xml file
                dialog.setContentView(R.layout.add_event_element_dialog);
                // Set dialog title
//                dialog.setTitle("Custom Dialog");

                final EditText nameField = (EditText) dialog.findViewById(R.id.nameField);
                final EditText descriptionField = (EditText) dialog.findViewById(R.id.descriptionField);
                final EditText dateField = (EditText) dialog.findViewById(R.id.dateField);

                dialog.show();

                Button declineButton = (Button) dialog.findViewById(R.id.declineButton);

                declineButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(nameField.getText().toString().equals("") || descriptionField.getText().toString().equals("") || dateField.getText().toString().equals("")){
                            Toast toast = Toast.makeText(getActivity(), "Fill all fields", Toast.LENGTH_SHORT);
                            toast.show();
                        }else{
                            eventList.add(new Event(nameField.getText().toString(), descriptionField.getText().toString(), dateField.getText().toString()));
                            aAdpt.notifyDataSetChanged();
                            dialog.dismiss();
                        }

                    }
                });


            }

        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Log.e(TAG, "item on pos: " + position);
                AlertDialog.Builder adb=new AlertDialog.Builder(getActivity());
                adb.setMessage("Are you sure you want to delete this event?");
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        eventList.remove(positionToRemove);
                        aAdpt.notifyDataSetChanged();
                    }});
                adb.show();
            }
        });

        return rootView;
    }

    private void initList() {
        eventList.add(new Event("Swieta...", "Opis jakiegos eventu", "22-12-20015"));
        eventList.add(new Event("Wakacje", "Jedziemy na marury bedziemy sie kapac w jeziorach", "11-06-2015"));
    }

    public static EventListFragment newInstance(FragmentFactory.FragmentName fn) {
        EventListFragment f = new EventListFragment();
        return f;
    }
}
