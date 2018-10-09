package com.example.simranjeet.learnmore;




import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.stetho.Stetho;


public class MainActivity extends FragmentActivity{
    SharedPreferences sharedPreferences;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Stetho.initializeWithDefaults(this);
        sharedPreferences = getApplicationContext().getSharedPreferences("LoginDetails", getApplicationContext().MODE_PRIVATE);

            Auth auth=new Auth(getApplicationContext());
            boolean bool = auth.getAuth();
            Toast.makeText(getApplicationContext(),Boolean.toString(bool),Toast.LENGTH_LONG).show();




            if(bool) {

                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
            }

        }
}
