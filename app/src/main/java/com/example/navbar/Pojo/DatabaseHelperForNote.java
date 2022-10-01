package com.example.navbar.Pojo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperForNote extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ddd.db";
    private static final String TABLE_NAME = "fffdd";
    private static final String ITEM_NAME = "ITEM_NAME";
    private static final String ITEM_PRICE = "ITEM_PRICE";
    private static final String ID = "ID";
    private static final String DATE_ID = "DATE_ID";
    private static final String DATE = "DATE";
    private static final String PROCESS_DATE = "PROCESS_DATE";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelperForNote(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ITEM_NAME + " TEXT,"
                + ITEM_PRICE + " INTEGER,"
                + DATE_ID + " INTEGER,"
                + DATE + " DATE " + ");";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // add data to note SQLite database
    public void insertDataToNote(String item_name, String item_price, String date, String date_id) {
        // insert data into table
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ITEM_NAME, item_name);
        values.put(ITEM_PRICE, item_price);
        values.put(DATE_ID, date_id);
        values.put(DATE, date);
        db.insert(TABLE_NAME, null, values);
    }

    public String getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{ID, ITEM_NAME, ITEM_PRICE, DATE_ID, DATE};
        Cursor cursor = db.query(TABLE_NAME, column, null, null, null, null, null);
        int iTemPrice = cursor.getColumnIndex(ITEM_PRICE);
 int total=0;
    String result = "";
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
             result= String.valueOf(cursor.getInt(iTemPrice));
            total+=Integer.parseInt(result);
        }
        db.close();
        return String.valueOf(total);
    }

    public Cursor getDataFromNote() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{ID, ITEM_NAME, ITEM_PRICE, DATE};

        // return data from note database numerically in order by date
        Cursor cursor = db.query(TABLE_NAME, column, null, null, null, null, "cast(" + DATE + " as REAL) " + " ASC");

        return cursor;

    }

    public Cursor getNameFromNote(String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{ID, ITEM_NAME, ITEM_PRICE, DATE};

        // return data from table where DATE is equal to input
        Cursor cursor = db.query(TABLE_NAME, column, "DATE=?", new String[]{date}, null, null, "cast(" + DATE + " as REAL) " + " ASC");

        return cursor;

    }

    public Cursor checkDate(String date) {
        SQLiteDatabase db = this.getReadableDatabase();
//        String[] column = new String[]{ID,ITEM_NAME, DATE_ID, ITEM_PRICE,DATE};

        // return data from table where DATE is equal to input
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE DATE=?", new String[]{date});
        System.out.println(date);
        return cursor;

    }

    public Cursor checkPrice(String price) {
        SQLiteDatabase db = this.getReadableDatabase();
//        String[] column = new String[]{ID,ITEM_NAME, DATE_ID, ITEM_PRICE,DATE};

        // return data from table where DATE is equal to input
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ITEM_PRICE=?", new String[Integer.parseInt(price)]);
        System.out.println(price);
        return cursor;
    }

    public int deleteData(String name, String date) {

        // Delete data from table where ITEM_NAME and DATE are equal to input
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_NAME, "ITEM_NAME=? AND DATE=?", new String[]{name, date});
        return i;

    }

}
