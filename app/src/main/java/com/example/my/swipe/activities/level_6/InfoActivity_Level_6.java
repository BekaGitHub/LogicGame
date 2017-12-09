package com.example.my.swipe.activities.level_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.InfoBaseActivity;
import com.example.my.swipe.activities.level_5.Level_5a_Activity;
import com.example.my.swipe.utils.Preferences;

public class InfoActivity_Level_6 extends InfoBaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info_level_6);

    levelCounterTextView = (TextView) findViewById(R.id.info_activity_level6_level_counter);

    Bundle bundle = getIntent().getBundleExtra(Preferences.BUNDLE);

    timePassedFromLastExercise = bundle.getInt(Preferences.TIME_PASSED, 0);

    levelIndex = bundle.getInt(Preferences.LEVEL, 6);
    String level = getString(R.string.level_counter, "" + levelIndex);
    levelCounterTextView.setText(level);
  }

  public void handleClick(View view) {
    Bundle bundle = new Bundle();
    Intent intent = new Intent(this, Level_6_Activity.class);
    bundle.putInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, timePassedFromLastExercise);
    intent.putExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY, bundle);
    startActivity(intent);
  }
}
