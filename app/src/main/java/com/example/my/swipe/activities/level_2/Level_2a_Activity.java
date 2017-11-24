package com.example.my.swipe.activities.level_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.utils.ExerciseTimer;
import com.example.my.swipe.utils.Preferences;

public class Level_2a_Activity extends Level_2_BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Nummer der aktuelle Aufgabe
        Preferences.EXERCISE_COUNTER = 1;
        //Nummer des aktuellen Level
        Preferences.LEVEL_COUNTER = 2;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_2a);

        timerTextView = (TextView) findViewById(R.id.timer_text_view_2a);
        failedImageView = (ImageView) findViewById(R.id.failed_image_2a);
        exerciseTextView = (TextView) findViewById(R.id.exercise_2a);

        String secondEtage = getString(R.string.second);
        String exercise = getString(R.string.exercise_level_2a,
                kurt, andrea + postS, kurt, heidi + postS, andrea, jurgen + postS, secondEtage);

        exerciseTextView.setText(exercise);

        button1 = (Button) findViewById(R.id.button_1_level_2a);
        button2 = (Button) findViewById(R.id.button_2_level_2a);
        button3 = (Button) findViewById(R.id.button_3_level_2a);
        button4 = (Button) findViewById(R.id.button_4_level_2a);

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
            Intent intent = new Intent(this, InfoActivity_Level_2.class);
            bundle = new Bundle();
            bundle.putBoolean(Preferences.GRATULATION, true);
            bundle.putInt(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
            bundle.putString(Preferences.ETAGE, getString(R.string.fourth));
            stopExerciseTimer();
            timePassed = (int) (exerciseTimer.timePassed()/1000);
            bundle.putInt(Preferences.TIME_PASSED, timePassed);
            intent.putExtra(Preferences.BUNDLE, bundle);
            startActivity(intent);
        }
    }
}
