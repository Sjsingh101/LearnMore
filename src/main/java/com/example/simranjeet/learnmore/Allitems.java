package com.example.simranjeet.learnmore;

import android.support.annotation.NonNull;

import java.io.Serializable;


public class Allitems implements Serializable {

    private String Name;
    private String Email;
    private String Password;

    private Boolean checked;

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Allitems(){
        checked=Boolean.FALSE;
    }
    public Allitems(String Name, String Email, String Password){
        this.Name=Name;
        this.Email=Email;
        this.Password=Password;
        checked=Boolean.FALSE;


    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Boolean getChecked() {
        return checked;
    }
}
