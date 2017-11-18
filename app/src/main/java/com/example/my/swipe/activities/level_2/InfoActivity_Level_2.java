package com.example.my.swipe.activities.level_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.InfoBaseActivity;
import com.example.my.swipe.fragments.DialogBack;
import com.example.my.swipe.utils.Preferences;

public class InfoActivity_Level_2 extends InfoBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_level_2);

        TextView levelCounter = (TextView) findViewById(R.id.level_counter_level2);
        TextView exerciseCounter = (TextView) findViewById(R.id.exercise_counter_level2);
        TextView exercise = (TextView) findViewById(R.id.exercise_level2);

        timePassedFromLastExercise = getIntent().
                getIntExtra(Preferences.TIME_PASSED, 0);

        int levelNumber = getIntent().getIntExtra(Preferences.LEVEL, -1);
        exerciseNumber = getIntent().getIntExtra(Preferences.EXERCISE, -1);
        String etage = getString(getIntent().getIntExtra(Preferences.ETAGE, -1));
        boolean gratulation = getIntent().getBooleanExtra(Preferences.GRATULATION, false);

        String infoText = "";
        if(levelNumber != -1) {
            infoText = getString(R.string.level_counter, ""+ levelNumber);
        }

        if (gratulation)
            infoText = getString(R.string.exercise_done);

        String exerciseCounterText = getString(R.string.exercise_counter, "" + exerciseNumber, "3");
        String exerciseInfo = getString(R.string.who_lives_where, etage);

        levelCounter.setText(infoText);
        exerciseCounter.setText(exerciseCounterText);
        exercise.setText(exerciseInfo);
    }

    public void handleClick(View view) {
        Intent intent  = null;
        switch (exerciseNumber) {
            case 1:
                intent = new Intent(this, Level_2a_Activity.class);
                break;
            case 2:
                intent = new Intent(this, Level_2b_Activity.class);
                break;
            case 3:
                intent = new Intent(this, Level_2c_Activity.class);
                break;
        }
        intent.putExtra(Preferences.TIME_PASSED_FROM_LAST_EXERCISE,
                timePassedFromLastExercise);
        startActivity(intent);
    }
}
