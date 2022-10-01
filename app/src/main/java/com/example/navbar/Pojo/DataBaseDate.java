package com.example.navbar.Pojo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseDate extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dddd.db";
    private static final String TABLE_NAME = "date";
//    private static final String ITEM_NAME = "ITEM_NAME";
//    private static final String ITEM_PRICE = "ITEM_PRICE";
    private static final String ID = "ID";
    private static final String DATE = "DATE";
    private static final String PROCESS_DATE = "PROCESS_DATE";
    private static final int DATABASE_VERSION = 1;

    public DataBaseDate(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DATE + " DATE " + ");";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertDataToDate(String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DATE, date);
        db.insert(TABLE_NAME, null, values);
    }

    public Cursor getDataFromNote(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{ID,DATE};

        // return data from note database numerically in order by date
        Cursor cursor = db.query(TABLE_NAME,column,null,null,null,null,null);

        return cursor;
    }

    public Cursor displayDataFromNote(String date){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{ID,DATE};

        // return data from note database numerically in order by date
        Cursor cursor = db.query(TABLE_NAME,column,null,null,null,null,null);

        return cursor;
    }

}
