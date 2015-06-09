package ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.groupscheduleapp.groupscheduleapp.R;

import java.util.List;

import ui.model.Event;

public class EventAdapter extends ArrayAdapter<Event>  {

    private List<Event> eventList;
    private Context context;

    public EventAdapter(List<Event> eventList, Context ctx) {
        super(ctx, R.layout.event_row_layout, eventList);
        this.eventList = eventList;
        this.context = ctx;
    }

    public int getCount() {
        return eventList.size();
    }

    public Event getItem(int position) {
        return eventList.get(position);
    }

    public long getItemId(int position) {
        return eventList.get(position).hashCode();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        EventHolder holder = new EventHolder();

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.event_row_layout, null);

            TextView tv = (TextView) v.findViewById(R.id.event_name);
            TextView distView = (TextView) v.findViewById(R.id.event_description);
            TextView date = (TextView) v.findViewById(R.id.event_date);

            holder.eventName = tv;
            holder.eventDescription = distView;
            holder.eventDate = date;

            v.setTag(holder);
        }
        else
            holder = (EventHolder) v.getTag();

        Event p = eventList.get(position);
        holder.eventName.setText(p.getName());
        holder.eventDescription.setText("" + p.getDescription());
        holder.eventDate.setText(p.getDate());

        return v;
    }

    private static class EventHolder {
        public TextView eventName;
        public TextView eventDescription;
        public TextView eventDate;
    }

}
