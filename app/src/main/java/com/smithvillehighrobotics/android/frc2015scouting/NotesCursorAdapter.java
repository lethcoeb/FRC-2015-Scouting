package com.smithvillehighrobotics.android.frc2015scouting;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by lethcoet16 on 10/27/2015.
 */
public class NotesCursorAdapter extends CursorAdapter {

    public NotesCursorAdapter(Context context, Cursor cursor, int flags){
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.notes_entry, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView idTV = (TextView) view.findViewById(R.id.idBruh);
        TextView note = (TextView) view.findViewById(R.id.notesTV);
        TextView tvMatchNum = (TextView) view.findViewById(R.id.matchNumberNotesRev);
        TextView tvTeamNum = (TextView) view.findViewById(R.id.teamNumberNotesRev);

        int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        int teamNum = cursor.getInt(cursor.getColumnIndexOrThrow("_TEAMNUMBER"));
        int matchNum = cursor.getInt(cursor.getColumnIndexOrThrow("_matchNumber"));
        String noteGet = cursor.getString(cursor.getColumnIndexOrThrow("_notes"));

        idTV.setText(""+id);
        note.setText(""+noteGet);
        tvMatchNum.setText(""+matchNum);
        tvTeamNum.setText(""+teamNum);


    }
}
