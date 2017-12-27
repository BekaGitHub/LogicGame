package com.example.my.swipe.activities.level_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.InfoBaseActivity;
import com.example.my.swipe.activities.level_1.Level_1d_Activity;
import com.example.my.swipe.utils.Preferences;

public class InfoActivity_Level_8 extends InfoBaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info_level_8);

    levelCounterTextView = (TextView) findViewById(R.id.info_activity_level8_level_counter);
    exerciseCounterTextView = (TextView) findViewById(R.id.info_activity_level8_exercise_counter);
    exerciseExplanationTextView = (TextView) findViewById(R.id.info_activity_level8_exercise_explanation);
    imageViewFuerInfo = (ImageView) findViewById(R.id.logische_schaltung_image_view_info_activity_8);

    Bundle bundle = getIntent().getBundleExtra(Preferences.BUNDLE);

    timePassedFromLastExercise = bundle.getInt(Preferences.TIME_PASSED, 0);

    levelIndex = bundle.getInt(Preferences.LEVEL, 1);
    exerciseIndex = bundle.getInt(Preferences.EXERCISE, 1);
    String aufgabeBeschreibung = bundle.getString(Preferences.AUFGABE_BESCHREIBUNG, getString(R.string.logische_schaltungen_aufgabe_1_beschreibung));
    int image = bundle.getInt(Preferences.IMAGE, R.drawable.inverter);
    isLevelDone = bundle.getBoolean(Preferences.EXERCISE_DONE, false);
    setInfoText();

    String exerciseCounterText = getString(R.string.exercise_counter, "" + exerciseIndex, "4");

    levelCounterTextView.setText(infoText);
    exerciseCounterTextView.setText(exerciseCounterText);
    exerciseExplanationTextView.setText(aufgabeBeschreibung);
    imageViewFuerInfo.setImageResource(image);
  }

  public void handleClick(View view) {
    Intent intent = null;
    Bundle bundle = new Bundle();
    switch (exerciseIndex) {
      case 1:
        intent = new Intent(this, Level_8a_Activity.class);
        break;
      case 2:
        intent = new Intent(this, Level_8b_Activity.class);
        break;
      case 3:
        intent = new Intent(this, Level_8c_Activity.class);
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
