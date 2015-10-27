package com.smithvillehighrobotics.android.frc2015scouting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class HomeScreen extends AppCompatActivity {



    static final String folder_main = "Scouting2015";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);



        //Create PUBLIC scouting folder

        File f = new File(Environment.getExternalStorageDirectory(),
                folder_main);
        if (!f.exists()) {
            f.mkdirs();
        }

    }






    private void exportDB(String database){
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();
        FileChannel source=null;
        FileChannel destination=null;
        String currentDBPath = "/data/"+ "com.smithvillehighrobotics.android.frc2015scouting" +"/databases/"+database;
        String backupDBPath = database;
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd+"/"+folder_main, backupDBPath);
        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
            Toast.makeText(this, "Database Exported!", Toast.LENGTH_SHORT).show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void exportData(View view){
        exportDB("Scouting.db");
    }

    public void scoutScreen(View view){
        Intent i = new Intent(getApplicationContext(), com.smithvillehighrobotics.android.frc2015scouting.scoutScreen.class);
        startActivity(i);
    }
    public void reviewScreen(View view){
        Intent i = new Intent(getApplicationContext(), com.smithvillehighrobotics.android.frc2015scouting.ReviewScreen.class);
        startActivity(i);
    }
    public void instructions(View view){
        Intent i = new Intent(getApplicationContext(), com.smithvillehighrobotics.android.frc2015scouting.Instructions.class);
        startActivity(i);
    }
}
