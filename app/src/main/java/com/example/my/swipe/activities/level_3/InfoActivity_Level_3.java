package com.example.my.swipe.activities.level_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.level_2.Level_2a_Activity;
import com.example.my.swipe.activities.level_2.Level_2b_Activity;
import com.example.my.swipe.activities.level_2.Level_2c_Activity;
import com.example.my.swipe.utils.Preferences;

public class InfoActivity_Level_3 extends AppCompatActivity {

    private int levelNumber;
    private int exerciseNumber;
    private int timePassedFromLastExercise;
    String exerciseInfo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_level_3);

        TextView levelCounter = (TextView) findViewById(R.id.level_counter_level3);
        TextView exerciseCounter = (TextView) findViewById(R.id.exercise_counter_level3);
        TextView exercise = (TextView) findViewById(R.id.exercise_level3);

        timePassedFromLastExercise = getIntent().
                getIntExtra(Preferences.TIME_PASSED, 0);

        levelNumber = getIntent().getIntExtra(Preferences.LEVEL, -1);
        exerciseNumber = getIntent().getIntExtra(Preferences.EXERCISE, -1);
        boolean gratulation = getIntent().getBooleanExtra(Preferences.GRATULATION, false);
        int figureNumber_1 = getIntent().getIntExtra(Preferences.ERSTE, 0);
        int figureNumber_2 = getIntent().getIntExtra(Preferences.ZWEITE, 0);
        int figureNumber_3 = getIntent().getIntExtra(Preferences.DRITTE, 0);
        int figureNumber_4 = getIntent().getIntExtra(Preferences.VIERTE, 0);
        int figureNumber_5 = getIntent().getIntExtra(Preferences.FUENFTE, 0);

        String infoText = "";
        if(levelNumber != -1) {
            infoText = getString(R.string.level_counter, ""+ levelNumber);
        }

        if (gratulation)
            infoText = getString(R.string.exercise_done);

        String exerciseCounterText = getString(R.string.exercise_counter, "" + exerciseNumber, "3");

        //Figuren, deren Gleichheit erraten werden muss, konnen folgende
        //Positionen annehmen: (1,2), (3,5), (2,4)
        if (figureNumber_1 != 0 && figureNumber_2 != 0)
        {
            String first = getString(figureNumber_1);
            String second = getString(figureNumber_2);
            exerciseInfo = getString(R.string.common_figures_easy, first, second);
        } else if (figureNumber_3 != 0 && figureNumber_5 != 0)
        {
            String third = getString(figureNumber_3);
            String fifth = getString(figureNumber_5);
            exerciseInfo = getString(R.string.common_figures_easy, third, fifth);
        } else if (figureNumber_2 != 0 && figureNumber_4 != 0)
        {
            String second = getString(figureNumber_2);
            String fourth = getString(figureNumber_4);
            exerciseInfo = getString(R.string.common_figures_easy, second, fourth);
        }

        levelCounter.setText(infoText);
        exerciseCounter.setText(exerciseCounterText);
        exercise.setText(exerciseInfo);
    }

    public void handleClick(View view) {
        Intent intent  = null;
        switch (exerciseNumber) {
            case 1:
                intent = new Intent(this, Level_3a_Activity.class);
                intent.putExtra(Preferences.EXERCISE_INFO, exerciseInfo);
                break;
            case 2:
                intent = new Intent(this, Level_3b_Activity.class);
                break;
            case 3:
//                intent = new Intent(this, Level_2c_Activity.class);
                break;
        }
        intent.putExtra(Preferences.TIME_PASSED_FROM_LAST_EXERCISE,
                timePassedFromLastExercise);
        startActivity(intent);
    }
}
