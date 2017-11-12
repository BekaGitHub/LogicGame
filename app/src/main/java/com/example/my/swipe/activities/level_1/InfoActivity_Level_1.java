package com.example.my.swipe.activities.level_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my.swipe.R;
import com.example.my.swipe.fragments.DialogBack;
import com.example.my.swipe.utils.Preferences;

public class InfoActivity_Level_1 extends AppCompatActivity {

    private int levelNumber;
    private int exerciseNumber;
    int timePassedFromLastExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_level_1);

        TextView levelCounter = (TextView) findViewById(R.id.level_counter_level1);
        TextView exerciseCounter = (TextView) findViewById(R.id.exercise_counter_level1);
        TextView exercise = (TextView) findViewById(R.id.exercise_level1);

        timePassedFromLastExercise = getIntent().
                getIntExtra(Preferences.TIME_PASSED, -1);

        levelNumber = getIntent().getIntExtra(Preferences.LEVEL, -1);
        exerciseNumber = getIntent().getIntExtra(Preferences.EXERCISE, -1);
        String symbol = getIntent().getStringExtra(Preferences.SYMBOL);
        boolean gratulation = getIntent().getBooleanExtra(Preferences.GRATULATION, false);

        String infoText = "";
        if(this.levelNumber != -1) {
            infoText = getString(R.string.level_counter, ""+ this.levelNumber);
        }

        if (gratulation)
            infoText = getString(R.string.exercise_done);

        String exerciseCounterText = getString(R.string.exercise_counter, "" + exerciseNumber, "4");
        String exerciseInfo = getString(R.string.find_symbol, symbol);

        levelCounter.setText(infoText);
        exerciseCounter.setText(exerciseCounterText);
        exercise.setText(exerciseInfo);
    }

    public void handleClick(View view) {
        Intent intent  = null;
        switch (exerciseNumber) {
            case 1:
                intent = new Intent(this, Level_1a_Activity.class);
                break;
            case 2:
                intent = new Intent(this, Level_1b_Activity.class);
                break;
            case 3:
                intent = new Intent(this, Level_1c_Activity.class);
                break;
            case 4:
                intent = new Intent(this, Level_1d_Activity.class);
                break;
        }
        intent.putExtra(Preferences.TIME_PASSED_FROM_LAST_EXERCISE,
                timePassedFromLastExercise);
        startActivity(intent);
    }

    @Override
    public void onBackPressed()
    {
        DialogBack dialog = new DialogBack();
        dialog.show(getFragmentManager(), "DialogTag");
    }
}
