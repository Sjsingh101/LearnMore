package com.example.simranjeet.learnmore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Stetho.initializeWithDefaults(this);

        ArrayList<String> CourseList = new ArrayList<>();

        MySqlHelper mySqlHelper = new MySqlHelper(this);
        mySqlHelper.setCourseList();
        CourseList=mySqlHelper.getCourseList();

        ListView lv = (ListView)findViewById(R.id.lv);

        lv.setAdapter(new CustomListAdapter(this, R.layout.content_list, CourseList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "List item was clicked at " + position, Toast.LENGTH_SHORT).show();
                }
        });

    }
}
