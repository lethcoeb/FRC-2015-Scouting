package com.smithvillehighrobotics.android.frc2015scouting;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Scouting.db";
    public static final String COLUMN_TEAMNUMBER = "_TEAMNUMBER";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MATCHNUMBER = "_matchNumber";
    public static final String COLUMN_STACKNUMBER = "_stackNumber";
    public static final String COLUMN_TOTES = "_totes";
    public static final String COLUMN_CAN = "_can";
    public static final String COLUMN_NOODLE = "_noodle";
    public static final String COLUMN_NOTES = "_notes";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + "data" + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEAMNUMBER + " INT, " +
                COLUMN_MATCHNUMBER + " INT, " +
                //COLUMN_STACKNUMBER + " INT, " +
                COLUMN_TOTES + " INT, " +
                COLUMN_CAN + " INT, " +
                COLUMN_NOODLE + " INT " +
                ");";
        db.execSQL(query);


        String query2 = "CREATE TABLE IF NOT EXISTS " + "notes" + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEAMNUMBER + " INT, " +
                COLUMN_MATCHNUMBER + " INT, " +
                COLUMN_NOTES + " VARCHAR" +
                ");";
        db.execSQL(query2);

        Log.d("LOGCAT", "databases created bruh");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    //add new table?


    public void addTable(SQLiteDatabase db, String teamNum){

        String query = "CREATE TABLE " + "data " + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MATCHNUMBER + " INT, " +
                COLUMN_STACKNUMBER + " INT, " +
                COLUMN_TOTES + " INT, " +
                COLUMN_CAN + " INT, " +
                COLUMN_NOODLE + " INT " +
                ");";
        db.execSQL(query);

    }

    public void addStack(Stack stack, String teamNum){

        ContentValues values = new ContentValues();
        //values.put(COLUMN_ID, stack.get_id());
        values.put(COLUMN_TEAMNUMBER, stack.get_teamNumber());
        values.put(COLUMN_MATCHNUMBER, stack.get_matchNumber());
        //values.put(COLUMN_STACKNUMBER, stack.get_stackNumber());
        values.put(COLUMN_TOTES, stack.get_totes());
        values.put(COLUMN_CAN, stack.get_can());
        values.put(COLUMN_NOODLE, stack.get_noodle());
        SQLiteDatabase db = getWritableDatabase();
        db.insert("data", null, values);
        db.close();
        Log.i("LOGCAT", "stack added");
    }

    public void addNotes(String notes, String teamNum, String matchNum){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TEAMNUMBER, Integer.parseInt(teamNum));
        values.put(COLUMN_MATCHNUMBER, Integer.parseInt(matchNum));
        values.put(COLUMN_NOTES, notes);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("notes", null, values);
        db.close();
        Log.i("LOGCAT", "note added");
    }

    //delete stack
    public void deleteStack(String stackName, String teamNumber){
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL("DELETE FROM " + "data" + " WHERE " + COLUMN_ID + "=\"" + stackName + "\"") ;
    }
    public void deleteNote(String noteName, String teamNumber){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM notes WHERE "  + COLUMN_ID + "=\"" + noteName + "\"");
    }

}