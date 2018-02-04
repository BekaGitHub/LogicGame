package com.example.my.swipe.activities.level_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.activities.InfoBaseActivity;
import com.example.my.swipe.utils.Preferences;

public class InfoActivity_Level_1 extends InfoBaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info_level_1);

    TextView starGameTextView = (TextView) findViewById(R.id.start_game);
    blinkText(starGameTextView);

    levelCounterTextView = (TextView) findViewById(R.id.info_activity_level1_level_counter);
    exerciseCounterTextView = (TextView) findViewById(R.id.info_activity_level1_exercise_counter);
    exerciseExplanationTextView = (TextView) findViewById(R.id.info_activity_level1_exercise_explanation);
    imageViewFuerInfo = (ImageView) findViewById(R.id.info_activity_level1_symbol_image);

    Bundle bundle = getIntent().getBundleExtra(Preferences.BUNDLE);

    timePassedFromLastExercise = bundle.getInt(Preferences.TIME_PASSED, 0);

    levelIndex = bundle.getInt(Preferences.LEVEL, 1);
    exerciseIndex = bundle.getInt(Preferences.EXERCISE_INDEX, 1);
    int image = bundle.getInt(Preferences.SYMBOL_IMAGE, R.drawable.symbol_plus);
    isLevelDone = bundle.getBoolean(Preferences.EXERCISE_DONE, false);
    setInfoText();

    String exerciseCounterText = getString(R.string.exercise_counter, "" + exerciseIndex, "4");
    String exerciseInfo = getString(R.string.find_symbol );

    levelCounterTextView.setText(infoText);
    exerciseCounterTextView.setText(exerciseCounterText);
    exerciseExplanationTextView.setText(exerciseInfo);
    imageViewFuerInfo.setImageResource(image);
  }

  public void handleClick(View view) {
    Intent intent = null;
    Bundle bundle = new Bundle();
    switch (exerciseIndex) {
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
    bundle.putInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE,
        timePassedFromLastExercise);
    intent.putExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY, bundle);
    startActivity(intent);
  }
}
