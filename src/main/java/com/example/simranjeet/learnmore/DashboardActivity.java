package com.example.simranjeet.learnmore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    TextView tv,tv1;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intent = getIntent();
        String coursename = intent.getStringExtra("CourseName");
        tv =(TextView)findViewById(R.id.name);
        btn = findViewById(R.id.add);
        tv1 =(TextView)findViewById(R.id.coursename);
        tv1.setText(coursename);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

    }
}
