package com.example.my.swipe.activities.level_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.utils.ExerciseTimer;
import com.example.my.swipe.utils.Preferences;

import java.util.ArrayList;

public class Level_1b_Activity extends Level_1_BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Nummer der aktuelle Aufgabe
        Preferences.EXERCISE_COUNTER = 2;
        //Nummer des aktuellen Level
        Preferences.LEVEL_COUNTER = 1;
        targetSymbol = ":)";
        otherSymbol = ":|";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1b);

        tableLayout = (TableLayout) findViewById(R.id.table_layout_level_1b);
        timerTextView = (TextView) findViewById(R.id.timer_text_view_1b);
        failedImageView = (ImageView) findViewById(R.id.failed_image_1b);

        buttons = new ArrayList<>();

        createTable(84, 7);

        exerciseTimer = new ExerciseTimer(30000, 1000, true);
        exerciseTimer.create();
        exerciseTimer.setTextView(timerTextView);
        exerciseTimer.setImageView(failedImageView);
        exerciseTimer.setContext(this);
        exerciseTimer.start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        if (clickedButton.getText().equals(Preferences.SYMBOLS[1])) {
            Intent intent = new Intent(this, InfoActivity_Level_1.class);
            intent.putExtra(Preferences.GRATULATION, true);
            intent.putExtra(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
            intent.putExtra(Preferences.SYMBOL, Preferences.SYMBOLS[2]);
            exerciseTimer.pause();
            exerciseTimer.cancel();
            int timePassedFromLastExercise = getIntent()
                    .getIntExtra(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);
            timePassed = (int) (exerciseTimer.timePassed()/1000 + timePassedFromLastExercise);
            intent.putExtra(Preferences.TIME_PASSED, timePassed);
            startActivity(intent);
        } else {
            failed(clickedButton);
        }
    }
}
