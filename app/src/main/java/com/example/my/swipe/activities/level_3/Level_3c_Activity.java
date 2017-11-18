package com.example.my.swipe.activities.level_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.Preferences;

public class Level_3c_Activity extends Level_3_BaseActivity
{
    protected Button bothButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Nummer der aktuelle Aufgabe
        Preferences.EXERCISE_COUNTER = 3;
        //Nummer des aktuellen Level
        Preferences.LEVEL_COUNTER = 3;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_3c);


        colorButton = (Button) findViewById(R.id.button_color_level_3c);
        formButton = (Button) findViewById(R.id.button_form_level_3c);
        bothButton = (Button) findViewById(R.id.button_both_level_3c);
        exerciseInfoTextView = (TextView) findViewById(R.id.exercise_info_level_3c);
        timerTextView = (TextView) findViewById(R.id.timer_text_view_3c);
        failedImageView = (ImageView) findViewById(R.id.failed_image_3c);

        exerciseInfoTextView.setText(getIntent().getStringExtra(Preferences.EXERCISE_INFO));

        colorButton.setOnClickListener(this);
        formButton.setOnClickListener(this);
        bothButton.setOnClickListener(this);

        startExerciseTimer(10000);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == formButton.getId() ||
                view.getId() ==colorButton.getId())
        {
            failed((Button) view);
        } else 
        {
            Intent intent = new Intent(this, LevelDoneActivity.class);
            stopExerciseTimer();
            int timePassedFromLastExercise = getIntent()
                    .getIntExtra(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);
            timePassed = (int) (exerciseTimer.timePassed()/1000 + timePassedFromLastExercise);
            int points = Evaluator.evaluate(Preferences.LEVEL_3_TOTAL_TIME_IN_SECONDS, timePassed);
            intent.putExtra(Preferences.LEVEL_POINT, points);
            startActivity(intent);
        }
    }
}
