package com.example.toby.my_journal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.View;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;



public class DBHelper extends SQLiteOpenHelper {

    // DEFINE THE DATABASE AND TABLE
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "journal.db";
    private static final String TABLE_NAME = "journal_table";

    // DEFINE THE COLUMN NAMES FOR THE TABLE
    private static final String KEY_TASK_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";
    private static final String KEY_LOCATION = "location";

    private static final String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;
    private static final String DROP_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

    // 6 columns table
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( "
            + KEY_TASK_ID + " INTEGER AUTOINCREMENT, "
            + KEY_TITLE + " STRING, "
            + KEY_CONTENT + " TEXT, "
            + KEY_DATE + " STRING PRIMARY KEY, "
            + KEY_TIME + " STRING, "
            + KEY_LOCATION + " STRING)";



    public DBHelper (Context context) {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) { database.execSQL(CREATE_TABLE); }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        // DROP OLDER TABLE IF EXISTS
        database.execSQL(DROP_QUERY);

        // CREATE TABLE AGAIN
        database.execSQL(CREATE_TABLE);
    }


    public String loadHelper() {
        String result = "";
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    public void addData(Journal entry) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_TASK_ID, entry.getID());                     // id
        values.put(KEY_TITLE, entry.getTitle());                    // title
        values.put(KEY_CONTENT, entry.getContent());                // content
        values.put(KEY_DATE, entry.getDate());                      // date
        values.put(KEY_TIME, entry.getTime());                      // time
        values.put(KEY_LOCATION, entry.getLocation());              // location

        db.insert(TABLE_NAME, null, values);
        db.close();
    }



    // get all data
    public List<Journal> getAllData() {
            List<Journal> dataList = new ArrayList<Journal>();
            // select all
        String selectQR = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQR, null);

        if (cursor.moveToFirst()) {
            do {


                Journal journal = new Journal();
                journal.setID(Integer.parseInt(cursor.getString(0)));
                journal.setTitle(cursor.getString(1));
                journal.setContent(cursor.getString(2));
                journal.setDate(cursor.getString(3));
                journal.setTime(cursor.getString(4));
                journal.setLocation(cursor.getString(5));

                dataList.add(journal);
            } while (cursor.moveToNext());
        }
        return dataList;

    }



    // find filter entries and date
    public Journal findEntry(String date) {
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + KEY_DATE + " = " + "'" + date + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Journal entry = new Journal();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            entry.setID(Integer.parseInt(cursor.getString(0)));
            entry.setDate(cursor.getString(1));
            cursor.close();
        } else {
            entry = null;
        }
        db.close();
        return entry;
    }








}
