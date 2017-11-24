package com.example.my.swipe.activities.level_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.utils.Preferences;

public class Level_3a_Activity extends Level_3_BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Nummer der aktuelle Aufgabe
        Preferences.EXERCISE_COUNTER = 1;
        //Nummer des aktuellen Level
        Preferences.LEVEL_COUNTER = 3;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_3a);

        colorButton = (Button) findViewById(R.id.button_color_level_3a);
        formButton = (Button) findViewById(R.id.button_form_level_3a);
        exerciseInfoTextView = (TextView) findViewById(R.id.exercise_info_level3);
        timerTextView = (TextView) findViewById(R.id.timer_text_view_3a);
        failedImageView = (ImageView) findViewById(R.id.failed_image_3a);

        exerciseInfoTextView.setText(getIntent()
                .getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY)
                .getString(Preferences.EXERCISE_INFO));

        colorButton.setOnClickListener(this);
        formButton.setOnClickListener(this);

        startExerciseTimer(10000);
    }

    @Override
    public void onClick(View view)
    {
        Bundle bundle;
        if (view.getId() == colorButton.getId())
        {
            bundle = new Bundle();
            bundle.putInt(Preferences.LEVEL, 3);
            bundle.putInt(Preferences.EXERCISE, 1);
            bundle.putInt(Preferences.FIGURE_1, R.string.first);
            bundle.putInt(Preferences.FIGURE_2, R.string.second);
            bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

            failed((Button) view, bundle);
        } else 
        {
            Intent intent = new Intent(this, InfoActivity_Level_3.class);
            bundle = new Bundle();
            bundle.putBoolean(Preferences.GRATULATION, true);
            bundle.putInt(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
            bundle.putInt(Preferences.FIGURE_1, R.string.third);
            bundle.putInt(Preferences.FIGURE_2, R.string.fifth);
            stopExerciseTimer();
            timePassed = (int) (exerciseTimer.timePassed()/1000);
            bundle.putInt(Preferences.TIME_PASSED, timePassed);
            intent.putExtra(Preferences.BUNDLE, bundle);
            startActivity(intent);
        }
    }
}
