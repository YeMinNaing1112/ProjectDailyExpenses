package com.example.navbar.Pojo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "something.db";
    private static final String TABLE_NAME = "students";
    private static final String ITEM_NAME = "ITEM_NAME";
    private static final String ITEM_PRICE = "ITEM_PRICE";
    private static final String ID = "ID";
    private static final String PROCESS_DATE = "PROCESS_DATE";
    private static final int DATABASE_VERSION = 1;

    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ITEM_NAME + " TEXT,"
                + ITEM_PRICE + " INTEGER" + ");";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }



    // add data to SQLite database
    public void insertCategory(String item_name, String item_price){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ITEM_NAME, item_name);
        values.put(ITEM_PRICE, item_price);
        db.insert(TABLE_NAME, null, values);
    }

    public void update(String  originalName,String item_name,String item_price){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ITEM_NAME, item_name);
        values.put(ITEM_PRICE, item_price);

        db.update(TABLE_NAME,values,"ITEM_NAME=?", new String[]{originalName});
        db.close();

    }

    // return data from SQLite database
    public Cursor getData(){
        db = this.getReadableDatabase();
        String[] column = new String[]{ID,ITEM_NAME,ITEM_PRICE};

        Cursor cursor = db.query(TABLE_NAME,column,null,null,null,null,null);

        return cursor;

    }
    //delete Data
    public void deleteItem(String name){
      SQLiteDatabase  db=this.getWritableDatabase();
        db.delete(TABLE_NAME, "ITEM_NAME=?", new String[]{name});
        db.close();
    }

}
