package com.smithvillehighrobotics.android.frc2015scouting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Beck on 9/4/2015.
 */
public class scoutScreen extends AppCompatActivity{

//initialize variables

    int stackNum = 1;
    int numberTotes = 0;
    int hasNoodle = 0;
    int hasCan = 0;





    DBHandler db = new DBHandler(this, null, null, 1);


    //initialize views

    EditText matchNumber;
    EditText teamNumber;
    RadioGroup rgTotes;
    RadioGroup rgCan;
    RadioGroup rgNoodle;
    EditText notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scout_screen);
        rgTotes = (RadioGroup)findViewById(R.id.rgTotes);
        rgCan = (RadioGroup)findViewById(R.id.rgCan);
        rgNoodle = (RadioGroup)findViewById(R.id.rgNoodle);
        teamNumber = (EditText) findViewById(R.id.teamNumberET);
        matchNumber = (EditText) findViewById(R.id.matchNumberET);
        notes = (EditText) findViewById(R.id.notesET);
    }

    String teamNum = "";
    String matchNum = "";
    String noteString = "";


// handle radio button presses
    public void onRBChange(View view){
        boolean checked  = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.rbTotes0:
                numberTotes = 0;
                break;
            case R.id.rbTotes1:
                    numberTotes = 1;

                break;
            case R.id.rbTotes2:
                    numberTotes = 2;
                break;
            case R.id.rbTotes3:
                    numberTotes = 3;
                break;
            case R.id.rbTotes4:
                    numberTotes = 4;
                break;
            case R.id.rbTotes5:
                    numberTotes = 5;
                break;
            case R.id.rbTotes6:
                    numberTotes = 6;
                break;
            case R.id.rbCanNo:
                    hasCan = 0;
                break;
            case R.id.rbCanYes:
                    hasCan = 1;
                break;
            case R.id.rbNoodleNo:
                    hasNoodle = 0;
                break;
            case R.id.rbNoodleYes:
                    hasNoodle = 1;
                break;
        }
    }

    private void resetRBs(){
        hasNoodle = 0;
        hasCan = 0;
        numberTotes = 0;
        rgCan.check(R.id.rbCanNo);
        rgNoodle.check(R.id.rbNoodleNo);
        rgTotes.check(R.id.rbTotes0);

    }

    public void scored(View view){
        teamNum = teamNumber.getText().toString();
        matchNum = matchNumber.getText().toString();
        if(!teamNum.equals("")&&!matchNum.equals("")){
            Stack stack = new Stack(numberTotes, hasCan, hasNoodle, Integer.parseInt(matchNum), Integer.parseInt(teamNum));
            db.addStack(stack, teamNum);
            resetRBs();
            Toast.makeText(this, "Stack data saved!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "enter valid numbers pls", Toast.LENGTH_LONG).show();
        }
    }
   /*public void dropped(View view){
        teamNum = teamNumber.getText().toString();
        db.changeDropped(teamNum);
        resetRBs();

    }*/
    public void clear(View view){
        resetRBs();
    }
    public void exitScreen(View view){

        teamNum = teamNumber.getText().toString();

        if(noteString!=""){
            noteString = notes.getText().toString();
            db.addNotes(teamNum, noteString);
        }

        finish();
    }
}
