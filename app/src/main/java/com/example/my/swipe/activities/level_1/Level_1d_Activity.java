package com.example.my.swipe.activities.level_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.ExerciseTimer;
import com.example.my.swipe.utils.Preferences;

import java.util.ArrayList;

public class Level_1d_Activity extends Level_1_BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Nummer der aktuelle Aufgabe
        Preferences.EXERCISE_COUNTER = 4;
        //Nummer des aktuellen Level
        Preferences.LEVEL_COUNTER = 1;
        targetSymbol = "u";
        otherSymbol = "v";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1d);

        tableLayout = (TableLayout) findViewById(R.id.table_layout_level_1d);
        timerTextView = (TextView) findViewById(R.id.timer_text_view_1d);
        failedImageView = (ImageView) findViewById(R.id.failed_image_1d);

        createTable(84, 7, false);
        startExerciseTimer(30000);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        Bundle bundle;
        if (clickedButton.getText().equals(Preferences.SYMBOLS[3])) {
            Intent intent = new Intent(this, LevelDoneActivity.class);
            bundle = new Bundle();
            stopExerciseTimer();
            int timePassedFromLastExercise = getIntent()
                    .getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY)
                    .getInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);

            timePassed = (int) (exerciseTimer.timePassed()/1000 + timePassedFromLastExercise);

            int points = Evaluator.evaluate(Preferences.LEVEL_1_TOTAL_TIME_IN_SECONDS, timePassed);
            bundle.putInt(Preferences.LEVEL_POINT, points);
            intent.putExtra(Preferences.BUNDLE, bundle);
            startActivity(intent);
        } else {
            bundle = new Bundle();
            bundle.putInt(Preferences.LEVEL, 1);
            bundle.putInt(Preferences.EXERCISE, 1);
            bundle.putString(Preferences.SYMBOL, Preferences.SYMBOLS[0]);
            bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());
            failed(clickedButton, bundle);
        }
    }
}
