package com.example.simranjeet.learnmore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<String> {
    private int layout;
    Context context;
    private List<String> mObjects;
    public CustomListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        mObjects = objects;
        this.context=context;
        layout = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder mainViewholder = null;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.textview1);
            viewHolder.button = (Button) convertView.findViewById(R.id.applybtn);
            convertView.setTag(viewHolder);
        }
        mainViewholder = (ViewHolder) convertView.getTag();
        mainViewholder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Button was clicked for list item " + position, Toast.LENGTH_SHORT).show();
                ArrayList<String> CourseList = new ArrayList<>();
                MySqlHelper mySqlHelper1= new MySqlHelper(context);
                CourseList = mySqlHelper1.getCourseList();
                String[] CourseArray = CourseList.toArray(new String[CourseList.size()]);
                Intent intent = new Intent(context, DashboardActivity.class);
                intent.putExtra("CourseName",CourseArray[position]);
                Toast.makeText(context,CourseArray[position] , Toast.LENGTH_SHORT).show();
                getContext().startActivity(intent);
            }
        });
        mainViewholder.title.setText(getItem(position));

        return convertView;
    }
}
class ViewHolder {

    TextView title;
    Button button;
}

