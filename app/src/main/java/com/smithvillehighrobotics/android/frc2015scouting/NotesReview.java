package com.smithvillehighrobotics.android.frc2015scouting;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class NotesReview extends AppCompatActivity {

    ListView lvNotez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_review);

        final DBHandler db = new DBHandler(this, null, null, 1);
        SQLiteDatabase base = db.getWritableDatabase();
        Cursor noteCursor = base.rawQuery("SELECT * FROM notes", null);
        NotesCursorAdapter noteAdapt = new NotesCursorAdapter(this, noteCursor, 0);
        lvNotez = (ListView) findViewById(R.id.notesreviewListView);
        lvNotez.setAdapter(noteAdapt);
        lvNotez.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                db.deleteNote(Long.toString(id), null);
                updateViews();
                return true;
            }
        });
    }

    private void updateViews(){

        DBHandler db = new DBHandler(this, null, null, 1);
        SQLiteDatabase base = db.getWritableDatabase();
        Cursor noteCursor = base.rawQuery("SELECT * FROM notes", null);
        NotesCursorAdapter noteAdapt = new NotesCursorAdapter(this, noteCursor, 0);
        noteAdapt.changeCursor(noteCursor);
        lvNotez.setAdapter(noteAdapt);

    }

}
