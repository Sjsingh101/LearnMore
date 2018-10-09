package com.example.simranjeet.learnmore;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class MySqlHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myDatabase";    // Database Name
           static final String TABLE_NAME = "CourseContent";   // Table Name
    static final String TABLE_NAME_1 = "StudentDetails";
      private static final int DATABASE_Version = 1;    // Database Version
    static final String NAME="Name";
    static final String EMAIL="Email";
    static final String PASSWORD="Password";

    private Context context;


    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+NAME+" VARCHAR(255)"+")";
    private static final String CREATE_TABLE_1 = "CREATE TABLE "+TABLE_NAME_1+"("+NAME+" VARCHAR(255) ,"+EMAIL+" VARCHAR(255) ,"+PASSWORD+" VARCHAR(255)"+")";

    public MySqlHelper(Context context) {
        super(context,DATABASE_NAME, null,DATABASE_Version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE_1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }




    public ArrayList<String> getCourseList() {
        ArrayList<String> allitemsList = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase dbb = this.getReadableDatabase();
        Cursor cursor = dbb.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                allitemsList.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        // return contact list
        return allitemsList;
    }

    public void setCourseList(){
        SQLiteDatabase dbb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String rray[] ={"AAA", "BBB", "CCC", "DDD"};
        for(int i=0;i<4;i++) {
            contentValues.put(MySqlHelper.NAME,rray[i]);
            dbb.insert(MySqlHelper.TABLE_NAME, null , contentValues);
        }
    }

    public long insertData(Allitems allitems){
        SQLiteDatabase dbb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySqlHelper.NAME, allitems.getName());
        contentValues.put(MySqlHelper.EMAIL, allitems.getEmail());
        contentValues.put(MySqlHelper.PASSWORD, allitems.getPassword());
        allitems.setChecked(Boolean.TRUE);
        long id = dbb.insert(MySqlHelper.TABLE_NAME_1, null , contentValues);
        return id;
    }

    public Allitems getItemDetail(String Email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Allitems contact=new Allitems();
        Cursor cursor = db.query(TABLE_NAME_1, new String[] {NAME,EMAIL,PASSWORD}, EMAIL + "=?",
                new String[] {Email}, null, null, null, null);

        if (cursor != null&& cursor.moveToFirst()) {
            //Toast.makeText(context,"data entered"+cursor.getString(1),Toast.LENGTH_SHORT).show();
          contact.setEmail(cursor.getString(1));
          contact.setPassword(cursor.getString(2));
          contact.setName(cursor.getString(0));
            contact.setChecked(Boolean.TRUE);
        }

        // return contact
        return contact;
    }




}
