package com.example.navbar.Pojo;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.navbar.AdaptorHelper.HomeAdaptor;

import java.util.ArrayList;

public class Database_GetData {

    public void displayName(Context context, ArrayList<String> name_list, ArrayList<String> price_list, boolean check){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        Cursor cursor = databaseHelper.getData();
        if (cursor.getCount() == 0){
            check = false;
        }
        else {
            while (cursor.moveToNext()){
                int name = cursor.getColumnIndex("ITEM_NAME");
                name_list.add(cursor.getString(name));
                int price = cursor.getColumnIndex("ITEM_PRICE");
                price_list.add(cursor.getString(price));

            }
        }

    }

    public void displayNameForCalander(Context context, ArrayList<String> name_list, ArrayList<String> price_list){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        Cursor cursor = databaseHelper.getData();
        if (cursor.getCount() == 0){
        }
        else {
            while (cursor.moveToNext()){
                int name = cursor.getColumnIndex("ITEM_NAME");
                name_list.add(cursor.getString(name));
                int price = cursor.getColumnIndex("ITEM_PRICE");
                price_list.add(cursor.getString(price));
            }
        }

    }

}
