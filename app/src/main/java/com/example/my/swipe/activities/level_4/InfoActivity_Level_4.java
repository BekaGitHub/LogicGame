package com.example.my.swipe.activities.level_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.InfoBaseActivity;
import com.example.my.swipe.activities.level_1.Level_1a_Activity;
import com.example.my.swipe.activities.level_1.Level_1b_Activity;
import com.example.my.swipe.activities.level_1.Level_1c_Activity;
import com.example.my.swipe.activities.level_1.Level_1d_Activity;
import com.example.my.swipe.utils.Preferences;

public class InfoActivity_Level_4 extends InfoBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_level_4);

        TextView levelCounter = (TextView) findViewById(R.id.level_counter_level4);
        TextView exerciseCounter = (TextView) findViewById(R.id.exercise_counter_level4);
        TextView exercise = (TextView) findViewById(R.id.exercise_level4);
        ImageView smileImageView = (ImageView) findViewById(R.id.smile_image_view);

        Bundle bundle = getIntent().getBundleExtra(Preferences.BUNDLE);

        timePassedFromLastExercise = bundle.getInt(Preferences.TIME_PASSED, 0);

        int levelNumber = bundle.getInt(Preferences.LEVEL, 4);
        exerciseNumber = bundle.getInt(Preferences.EXERCISE, 1);
        int smile = bundle.getInt(Preferences.SMILE, R.drawable.smile_emoji);
        boolean gratulation = bundle.getBoolean(Preferences.GRATULATION, false);

        String infoText = "";
        infoText = getString(R.string.level_counter, ""+ levelNumber);
        if (gratulation)
            infoText = getString(R.string.exercise_done);

        String exerciseCounterText = getString(R.string.exercise_counter, "" + exerciseNumber, "4");

        levelCounter.setText(infoText);
        exerciseCounter.setText(exerciseCounterText);
        smileImageView.setImageResource(smile);
    }

    public void handleClick(View view) {
        Intent intent  = null;
        Bundle bundle = new Bundle();
        switch (exerciseNumber) {
            case 1:
                intent = new Intent(this, Level_4a_Activity.class);
                break;
            case 2:
                intent = new Intent(this, Level_4b_Activity.class);
                break;
            case 3:
                intent = new Intent(this, Level_4c_Activity.class);
                break;
            case 4:
                intent = new Intent(this, Level_4d_Activity.class);
                break;
        }
        bundle.putInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE,
                timePassedFromLastExercise);
        intent.putExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY, bundle);
        startActivity(intent);
    }
}
