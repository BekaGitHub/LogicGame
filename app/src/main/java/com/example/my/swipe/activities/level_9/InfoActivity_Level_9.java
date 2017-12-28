package com.example.my.swipe.activities.level_9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.InfoBaseActivity;
import com.example.my.swipe.activities.level_4.Level_4a_Activity;
import com.example.my.swipe.activities.level_4.Level_4b_Activity;
import com.example.my.swipe.activities.level_4.Level_4c_Activity;
import com.example.my.swipe.activities.level_4.Level_4d_Activity;
import com.example.my.swipe.utils.Preferences;

public class InfoActivity_Level_9 extends InfoBaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info_level_9);

    TextView starGameTextView = (TextView) findViewById(R.id.start_game);
    blinkText(starGameTextView);

    levelCounterTextView = (TextView) findViewById(R.id.info_activity_level9_level_counter);
    exerciseCounterTextView = (TextView) findViewById(R.id.info_activity_level9_exercise_counter);
    exerciseExplanationTextView = (TextView) findViewById(R.id.exercise_level9);

    Bundle bundle = getIntent().getBundleExtra(Preferences.BUNDLE);

    timePassedFromLastExercise = bundle.getInt(Preferences.TIME_PASSED, 0);

    levelIndex = bundle.getInt(Preferences.LEVEL, 4);
    exerciseIndex = bundle.getInt(Preferences.EXERCISE, 1);
    isLevelDone = bundle.getBoolean(Preferences.EXERCISE_DONE, false);

    setInfoText();

    String exerciseCounterText = getString(R.string.exercise_counter, "" + exerciseIndex, "4");

    levelCounterTextView.setText(infoText);
    exerciseCounterTextView.setText(exerciseCounterText);
  }

  public void handleClick(View view) {
    Intent intent = null;
    Bundle bundle = new Bundle();
    switch (exerciseIndex) {
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
