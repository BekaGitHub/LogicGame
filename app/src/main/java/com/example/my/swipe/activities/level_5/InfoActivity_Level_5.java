package com.example.my.swipe.activities.level_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.InfoBaseActivity;
import com.example.my.swipe.activities.level_1.Level_1a_Activity;
import com.example.my.swipe.activities.level_1.Level_1b_Activity;
import com.example.my.swipe.activities.level_1.Level_1c_Activity;
import com.example.my.swipe.activities.level_1.Level_1d_Activity;
import com.example.my.swipe.utils.Preferences;

public class InfoActivity_Level_5 extends InfoBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_level_5);

        TextView levelCounter = (TextView) findViewById(R.id.level_counter_level5);

        Bundle bundle = getIntent().getBundleExtra(Preferences.BUNDLE);

        timePassedFromLastExercise = bundle.getInt(Preferences.TIME_PASSED, 0);

        int levelNumber = bundle.getInt(Preferences.LEVEL, 5);
        String level = getString(R.string.level_counter, ""+ levelNumber);
        levelCounter.setText(level);
    }

    public void handleClick(View view) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, Level_5a_Activity.class);
        bundle.putInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE,
                timePassedFromLastExercise);
        intent.putExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY, bundle);
        startActivity(intent);
    }
}
