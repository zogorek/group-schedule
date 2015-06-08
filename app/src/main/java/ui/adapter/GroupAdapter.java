package ui.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.groupscheduleapp.groupscheduleapp.R;

import java.util.List;

import ui.model.Group;

public class GroupAdapter extends ArrayAdapter<Group> {

    private List<Group> planetList;
    private Context context;

    public GroupAdapter(List<Group> planetList, Context ctx) {
        super(ctx, R.layout.group_row_layout, planetList);
        this.planetList = planetList;
        this.context = ctx;
    }

    public int getCount() {
        return planetList.size();
    }

    public Group getItem(int position) {
        return planetList.get(position);
    }

    public long getItemId(int position) {
        return planetList.get(position).hashCode();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        GroupHolder holder = new GroupHolder();

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.group_row_layout, null);

            TextView tv = (TextView) v.findViewById(R.id.group_name);
            TextView distView = (TextView) v.findViewById(R.id.group_description);

            holder.groupName = tv;
            holder.groupDescription = distView;

            v.setTag(holder);
        }
        else
            holder = (GroupHolder) v.getTag();

        Group p = planetList.get(position);
        holder.groupName.setText(p.getName());
        holder.groupDescription.setText("" + p.getDescription());

        return v;
    }

    private static class GroupHolder {
        public TextView groupName;
        public TextView groupDescription;
    }


}
