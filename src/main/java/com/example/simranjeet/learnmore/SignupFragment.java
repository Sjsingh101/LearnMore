package com.example.simranjeet.learnmore;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SignupFragment extends Fragment {
    Button btn1,btn2;
    EditText et1,et2,et3,et4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_signup, container, false);
        et1=(EditText) view.findViewById(R.id.name);
        et2=(EditText) view.findViewById(R.id.email);
        et3=(EditText) view.findViewById(R.id.repassword);
        et4=(EditText) view.findViewById(R.id.newpassword);
        btn1=(Button) view.findViewById(R.id.submitdetails);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et3.getText().toString().equals(et4.getText().toString())){
                    MySqlHelper mySqlHelper = new MySqlHelper(getContext());
                    Allitems allitems = new Allitems(et1.getText().toString(),et2.getText().toString(),et3.getText().toString());
                    mySqlHelper.insertData(allitems);
                    Toast.makeText(getContext(),"Entry done",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), DashboardActivity.class);
                    startActivity(intent);
                }

            }
        });


        return view;
    }


}
