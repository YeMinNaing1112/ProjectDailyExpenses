package com.example.navbar.Pojo;

import android.content.Context;
import android.database.Cursor;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Database_GetDataFromNote {

    public boolean displayDate(Context context){

        DatabaseHelperForNote databaseHelper = new DatabaseHelperForNote(context);
        Cursor cursor = databaseHelper.getDataFromNote();

        // if data doesn't exist pass false to fragment
        if (cursor.getCount() == 0){
            return false;
        }
        // if data exist, add it to the array list and pass it to the fragment
        else {
            return true;
        }
    }

    public void GetDataForChildAdaptor(Context context, ArrayList<String> name_list, ArrayList<String> price_list, String date_list){

        DatabaseHelperForNote databaseHelper = new DatabaseHelperForNote(context);
        Cursor cursor = databaseHelper.checkDate(date_list);

        // if data doesn't exist pass false to fragment
        if (cursor.getCount() == 0){
        }
        // if data exist, add it to the array list and pass it to the fragment
        else {
            while (cursor.moveToNext()){
                int name = cursor.getColumnIndex("ITEM_NAME");
                name_list.add(cursor.getString(name));
                int price = cursor.getColumnIndex("ITEM_PRICE");
                price_list.add(cursor.getString(price));
            }
        }

    }




    public boolean checkData(Context context, String date_check){
        DatabaseHelperForNote databaseHelper = new DatabaseHelperForNote(context);
        Cursor cursor = databaseHelper.getDataFromNote();
        if (cursor.getCount() == 0){

        }
        else {
            while (cursor.moveToNext()){
                //check if data from calendar exist in DATE column
                int date = cursor.getColumnIndex("DATE");
                if (cursor.getString(date).equals(date_check)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkName(Context context, String name_check, String date){
        DatabaseHelperForNote databaseHelper = new DatabaseHelperForNote(context);
        Cursor cursor = databaseHelper.getNameFromNote(date);
        if (cursor.getCount() == 0){


        }
        else {
            while (cursor.moveToNext()){
                //check if data from calendar exist in DATE column
                int item_name = cursor.getColumnIndex("ITEM_NAME");
                if (cursor.getString(item_name).equals(name_check)){
                    return true;
                }
            }
        }
        return false;

    }

}
