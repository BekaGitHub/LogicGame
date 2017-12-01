package com.example.my.swipe.activities.level_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.activities.level_3.InfoActivity_Level_3;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.ExerciseTimer;
import com.example.my.swipe.utils.Preferences;

public class Level_2c_Activity extends Level_2_BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Nummer der aktuelle Aufgabe
        Preferences.EXERCISE_COUNTER = 3;
        //Nummer des aktuellen Level
        Preferences.LEVEL_COUNTER = 2;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_2c);

        timerTextView = (TextView) findViewById(R.id.timer_text_view_2c);
        failedImageView = (ImageView) findViewById(R.id.failed_image_2c);
        exerciseTextView = (TextView) findViewById(R.id.exercise_2c);

        String thirdEtage = getString(R.string.third);
        String exercise = getString(R.string.exercise_level_2c,
                andrea, heidi + postS,
                jurgen, andrea + postS,
                jurgen, kurt + postS,
                thirdEtage);

        exerciseTextView.setText(exercise);

        button1 = (Button) findViewById(R.id.button_1_level_2c);
        button2 = (Button) findViewById(R.id.button_2_level_2c);
        button3 = (Button) findViewById(R.id.button_3_level_2c);
        button4 = (Button) findViewById(R.id.button_4_level_2c);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        startExerciseTimer(90000);
    }

    @Override
    public void onClick(View view) {
        Bundle bundle;
        if (view.getId() == button1.getId() ||
                view.getId() == button3.getId() ||
                view.getId() == button4.getId())
        {
            bundle = new Bundle();
            bundle.putInt(Preferences.LEVEL, 2);
            bundle.putInt(Preferences.EXERCISE, 1);
            bundle.putString(Preferences.ETAGE, getString(R.string.second));
            bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

            failed((Button) view, bundle);
        } else
        {
            Intent intent = new Intent(Level_2c_Activity.this, LevelDoneActivity.class);
            bundle = new Bundle();
            stopExerciseTimer();

            int timePassedFromLastExercise = getIntent()
                    .getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY)
                    .getInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);

            timePassed = (int) (exerciseTimer.timePassed()/1000 + timePassedFromLastExercise);

            int points = Evaluator.evaluate(Preferences.LEVEL_2_TOTAL_TIME_IN_SECONDS, timePassed);
            bundle.putInt(Preferences.LEVEL_POINT, points);
            bundle.putSerializable(Preferences.NEXT_LEVEL, InfoActivity_Level_3.class);
            intent.putExtra(Preferences.BUNDLE, bundle);
            startActivity(intent);
        }
    }
}