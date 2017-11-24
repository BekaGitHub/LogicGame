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

public class Level_1c_Activity extends Level_1_BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Nummer der aktuelle Aufgabe
        Preferences.EXERCISE_COUNTER = 3;
        //Nummer des aktuellen Level
        Preferences.LEVEL_COUNTER = 1;
        targetSymbol = "<";
        otherSymbol = ">";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1c);

        tableLayout = (TableLayout) findViewById(R.id.table_layout_level_1c);
        timerTextView = (TextView) findViewById(R.id.timer_text_view_1c);
        failedImageView = (ImageView) findViewById(R.id.failed_image_1c);

        createTable(84, 7, false);
        startExerciseTimer(30000);
    }


    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        Bundle bundle;
        if (clickedButton.getText().equals(Preferences.SYMBOLS[2])) {
            Intent intent = new Intent(this, InfoActivity_Level_1.class);
            bundle = new Bundle();
            bundle.putBoolean(Preferences.GRATULATION, true);
            bundle.putInt(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
            bundle.putString(Preferences.SYMBOL, Preferences.SYMBOLS[3]);
            stopExerciseTimer();

            int timePassedFromLastExercise = getIntent()
                    .getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY)
                    .getInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);

            timePassed = (int) (exerciseTimer.timePassed()/1000 + timePassedFromLastExercise);
            bundle.putInt(Preferences.TIME_PASSED, timePassed);
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
