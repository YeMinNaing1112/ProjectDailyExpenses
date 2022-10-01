package com.example.navbar.Pojo;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;

public class Database_GetDataFromDate {

    public void displayDateFromDB(Context context, ArrayList<String> date_list) {
        DataBaseDate databaseHelper = new DataBaseDate(context);
        Cursor cursor = databaseHelper.getDataFromNote();
        if (cursor.getCount() == 0){
        }
        else {
            while (cursor.moveToNext()){
                int id = cursor.getColumnIndex("DATE");
                date_list.add(cursor.getString(id));
            }
        }
    }

    public void Checking_NotewithDateID(Context context, ArrayList<String> date_ID){
        DataBaseDate databaseHelper = new DataBaseDate(context);
        Cursor cursor = databaseHelper.getDataFromNote();
        if (cursor.getCount() == 0){
        }
        else {
            while (cursor.moveToNext()){
                int id = cursor.getColumnIndex("ID");
                date_ID.add(cursor.getString(id));
            }
        }
    }

    public boolean checkDateFromDatabase(Context context, String date){
        DataBaseDate databaseHelper = new DataBaseDate(context);
        Cursor cursor = databaseHelper.displayDataFromNote(date);
        if (cursor.getCount() == 0){
            Toast.makeText(context, "empty", Toast.LENGTH_SHORT).show();
        }
        else {

            ArrayList<String> date_list = new ArrayList<>();

            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
                int dt = cursor.getColumnIndex("DATE");
                date_list.add(cursor.getString(dt));
            }

            if (date_list.contains(date)){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
