package com.example.my.swipe.activities.level_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.activities.InfoBaseActivity;
import com.example.my.swipe.utils.Preferences;

public class InfoActivity_Level_2 extends InfoBaseActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info_level_2);

    TextView starGameTextView = (TextView) findViewById(R.id.start_game);
    blinkText(starGameTextView);

    levelCounterTextView = (TextView) findViewById(R.id.info_activity_level2_level_counter);
    exerciseCounterTextView = (TextView) findViewById(R.id.info_activity_level2_exercise_counter);
    exerciseExplanationTextView = (TextView) findViewById(R.id.info_activity_level2_exercise_explanation);

    Bundle bundle = getIntent().getBundleExtra(Preferences.BUNDLE);

    timePassedFromLastExercise = bundle.getInt(Preferences.TIME_PASSED, 0);

    levelIndex = bundle.getInt(Preferences.LEVEL, 2);
    exerciseIndex = bundle.getInt(Preferences.EXERCISE, 1);
    String etage = bundle.getString(Preferences.ETAGE, getString(R.string.second));
    isLevelDone = bundle.getBoolean(Preferences.EXERCISE_DONE, false);

    setInfoText();

    String exerciseCounterText = getString(R.string.exercise_counter, "" + exerciseIndex, "3");
    String exerciseInfo = getString(R.string.who_lives_where, etage);

    levelCounterTextView.setText(infoText);
    exerciseCounterTextView.setText(exerciseCounterText);
    exerciseExplanationTextView.setText(exerciseInfo);
  }

  public void handleClick(View view) {
    Intent intent = null;
    Bundle bundle = new Bundle();
    switch (exerciseIndex) {
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
    bundle.putInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE,
        timePassedFromLastExercise);
    intent.putExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY, bundle);
    startActivity(intent);
  }
}
