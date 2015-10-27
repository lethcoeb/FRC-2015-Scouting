package com.smithvillehighrobotics.android.frc2015scouting;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Beck on 10/21/2015.
 */
public class StackCursorAdapter extends CursorAdapter {

    public StackCursorAdapter(Context context, Cursor cursor, int flags){
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return LayoutInflater.from(context).inflate(R.layout.stack_entry, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor){

        TextView tvBody = (TextView) view.findViewById(R.id.stackidREV);
        TextView tvMatchNum = (TextView) view.findViewById(R.id.matchNumberREV);
        TextView tvTeamNum = (TextView) view.findViewById(R.id.teamNumberREV);
        TextView tvTotes = (TextView) view.findViewById(R.id.totesREV);
        TextView tvCan = (TextView) view.findViewById(R.id.canREV);
        TextView tvNoodle = (TextView) view.findViewById(R.id.noodleREV);

        int body = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        int teamNum = cursor.getInt(cursor.getColumnIndexOrThrow("_TEAMNUMBER"));
        int matchNum = cursor.getInt(cursor.getColumnIndexOrThrow("_matchNumber"));
        int totes = cursor.getInt(cursor.getColumnIndexOrThrow("_totes"));
        int can = cursor.getInt(cursor.getColumnIndexOrThrow("_can"));
        int noodle = cursor.getInt(cursor.getColumnIndexOrThrow("_noodle"));

        tvBody.setText(""+body);
        tvTeamNum.setText(""+teamNum);
        tvMatchNum.setText(""+matchNum);
        tvTotes.setText(""+totes);
        //tvCan.setText(""+can);
        //tvNoodle.setText(""+noodle);


        if(can==1){
            tvCan.setText("Yes");
        }
        if(can==0){
            tvCan.setText("No");
        }
        if(noodle==1){
            tvNoodle.setText("Yes");
        }
        if(noodle==0){
            tvNoodle.setText("No");
        }

    }

}
