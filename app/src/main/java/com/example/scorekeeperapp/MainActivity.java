package com.example.scorekeeperapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView team1;
    TextView team2;
    int team1Score=0;
    int team2Score=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        team1= findViewById(R.id.score1);
        team2= findViewById(R.id.score2);
    }
    public void Increase(View view){

        ImageButton b= (ImageButton) view;
        if(b.getId()==R.id.increaseTeam1){
            ++team1Score;
            team1.setText(""+team1Score);

        }
        if(b.getId()==R.id.increaseTeam2){
            ++team2Score;
            team2.setText(""+team2Score);
        }

    }
    public void  Decrease(View view){
        ImageButton b= (ImageButton) view;
        if(b.getId()==R.id.decreaseTeam1){
            --team1Score;
            team1.setText(""+team1Score);

        }
        if(b.getId()==R.id.decreaseTeam2){
            --team2Score;
            team2.setText(""+team2Score);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.side_menu,menu);
        int nightMode= AppCompatDelegate.getDefaultNightMode();
        if(nightMode==AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);


        }else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.night_mode){
            int nightMode= AppCompatDelegate.getDefaultNightMode();
            if(nightMode==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        recreate();


        return super.onOptionsItemSelected(item);
    }
}
