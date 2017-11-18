package com.example.my.swipe.activities.level_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my.swipe.R;
import com.example.my.swipe.utils.ExerciseTimer;
import com.example.my.swipe.utils.Preferences;

public class Level_3b_Activity extends Level_3_BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Nummer der aktuelle Aufgabe
        Preferences.EXERCISE_COUNTER = 2;
        //Nummer des aktuellen Level
        Preferences.LEVEL_COUNTER = 3;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_3b);


        colorButton = (Button) findViewById(R.id.button_color_level_3b);
        formButton = (Button) findViewById(R.id.button_form_level_3b);
        nothingButton = (Button) findViewById(R.id.button_nothing_level_3b);
        exerciseInfoTextView = (TextView) findViewById(R.id.exercise_info_level_3b);
        timerTextView = (TextView) findViewById(R.id.timer_text_view_3b);
        failedImageView = (ImageView) findViewById(R.id.failed_image_3b);

        exerciseInfoTextView.setText(getIntent().getStringExtra(Preferences.EXERCISE_INFO));

        colorButton.setOnClickListener(this);
        formButton.setOnClickListener(this);

        exerciseTimer = new ExerciseTimer(10000, 1000, true);
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
    public void onClick(View view)
    {
        if (view.getId() == formButton.getId() ||
                view.getId() ==nothingButton.getId())
        {
            failed((Button) view);
        } else 
        {
            Toast.makeText(this, "sadsadas", Toast.LENGTH_SHORT).show();
        }
    }
}
