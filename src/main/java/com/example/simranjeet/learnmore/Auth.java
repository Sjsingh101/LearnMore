package com.example.simranjeet.learnmore;

import android.content.Context;
import android.content.SharedPreferences;

public class Auth {
    Context context;
    SharedPreferences sharedPreferences;
    Auth(Context context ){

        this.context=context;
    }

    boolean getAuth(){
        sharedPreferences = context.getSharedPreferences("LoginDetails", context.MODE_PRIVATE);

        boolean decider=false;

        if(sharedPreferences.getBoolean("User",false)==true)
        {
            decider=true;
        }


        return decider;
    }

}
