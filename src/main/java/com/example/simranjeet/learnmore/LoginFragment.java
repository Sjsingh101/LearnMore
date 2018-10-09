package com.example.simranjeet.learnmore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginFragment extends Fragment {
Button purple,btn2;
TextView textView,tv2;
    EditText et1,et2,et3;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment

View view = inflater.inflate(R.layout.fragment_login, container, false);
        purple =(Button)view.findViewById(R.id.signupbtn);
        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SignupFragment();

                FragmentManager fragmentManager = getFragmentManager();

                fragmentManager.beginTransaction().replace(R.id.fragmentlogin, fragment).addToBackStack(fragment.getTag()).commit();
            }
        });
        textView =(TextView)view.findViewById(R.id.skip);
        et1=(EditText) view.findViewById(R.id.password);
        et2=(EditText) view.findViewById(R.id.email);
        btn2=(Button) view.findViewById(R.id.loginbtn);
        tv2 =(TextView)view.findViewById(R.id.tv2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySqlHelper mySqlHelper = new MySqlHelper(getContext());
                Allitems allitems = new Allitems();
                String email =  et1.getText().toString();
                allitems=mySqlHelper.getItemDetail(email);
                Toast.makeText(getContext(),allitems.getChecked().toString(),Toast.LENGTH_SHORT).show();
                if(!allitems.getChecked()) {

                    if ((et3.getText().toString()).equals(allitems.getPassword())) {

                         sharedPreferences.edit().putBoolean("User",true).commit();
                        Intent intent = new Intent(getActivity(), DashboardActivity.class);
                        startActivity(intent);
                    }
                }
                else{
                    tv2.setVisibility(View.VISIBLE);
                    et1.setText("");
                }




            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}
