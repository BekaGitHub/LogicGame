package com.example.my.swipe.activities.level_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.InfoBaseActivity;
import com.example.my.swipe.activities.level_2.Level_2a_Activity;
import com.example.my.swipe.activities.level_2.Level_2b_Activity;
import com.example.my.swipe.activities.level_2.Level_2c_Activity;
import com.example.my.swipe.utils.Preferences;

public class InfoActivity_Level_3 extends InfoBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_level_3);

        TextView levelCounter = (TextView) findViewById(R.id.level_counter_level3);
        TextView exerciseCounter = (TextView) findViewById(R.id.exercise_counter_level3);
        TextView exercise = (TextView) findViewById(R.id.exercise_level3);

        Bundle bundle = getIntent().getBundleExtra(Preferences.BUNDLE);

        timePassedFromLastExercise = bundle.getInt(Preferences.TIME_PASSED, 0);

        int levelNumber = bundle.getInt(Preferences.LEVEL, 3);
        exerciseNumber = bundle.getInt(Preferences.EXERCISE, 1);
        boolean gratulation = bundle.getBoolean(Preferences.GRATULATION, false);

        //aq gavcherdi 19.11.2017
        int figure1 = bundle.getInt(Preferences.FIGURE_1, R.string.first);
        int figure2 = bundle.getInt(Preferences.FIGURE_2, R.string.second);

        String infoText = "";
        infoText = getString(R.string.level_counter, ""+ levelNumber);
        if (gratulation)
            infoText = getString(R.string.exercise_done);

        String exerciseCounterText = getString(R.string.exercise_counter, "" + exerciseNumber, "3");

        //Figuren, deren Gleichheit erraten werden muss, konnen folgende
        //Positionen annehmen: (1,2), (3,5), (2,4)
        String text1 = getString(figure1);
        String text2 = getString(figure2);
        exerciseInfo = getString(R.string.common_figures_easy, text1, text2);

        levelCounter.setText(infoText);
        exerciseCounter.setText(exerciseCounterText);
        exercise.setText(exerciseInfo);
    }

    public void handleClick(View view) {
        Intent intent  = null;
        Bundle bundle = new Bundle();
        switch (exerciseNumber) {
            case 1:
                intent = new Intent(this, Level_3a_Activity.class);
                break;
            case 2:
                intent = new Intent(this, Level_3b_Activity.class);
                break;
            case 3:
                intent = new Intent(this, Level_3c_Activity.class);
                break;
        }

        bundle.putInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE,
                timePassedFromLastExercise);
        bundle.putString(Preferences.EXERCISE_INFO, exerciseInfo);
        intent.putExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY, bundle);
        startActivity(intent);
    }
}
