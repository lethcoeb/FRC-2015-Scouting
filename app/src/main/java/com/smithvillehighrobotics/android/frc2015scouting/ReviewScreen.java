package com.smithvillehighrobotics.android.frc2015scouting;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Beck on 10/20/2015.
 */
public class ReviewScreen extends AppCompatActivity {

    ListView lvStax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DBHandler db = new DBHandler(this, null, null, 1);
        SQLiteDatabase base = db.getWritableDatabase();
        Cursor stackCursor = base.rawQuery("SELECT * FROM data", null);
        StackCursorAdapter stackAdapt = new StackCursorAdapter(this, stackCursor, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviewscreen);
        lvStax = (ListView) findViewById(R.id.reviewListView);
        lvStax.setAdapter(stackAdapt);
        lvStax.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                db.deleteStack(Long.toString(id), null);
                updateViews();
            return true;
            }
        });



    }


    private void updateViews(){

        //update da data
        DBHandler db = new DBHandler(this, null, null, 1);
        SQLiteDatabase base = db.getWritableDatabase();
        Cursor stackCursor = base.rawQuery("SELECT * FROM data", null);
        StackCursorAdapter stackAdapt = new StackCursorAdapter(this, stackCursor, 0);
        stackAdapt.changeCursor(stackCursor);
        lvStax.setAdapter(stackAdapt);

    }







}
