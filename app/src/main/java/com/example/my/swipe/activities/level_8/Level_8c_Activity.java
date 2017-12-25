package com.example.my.swipe.activities.level_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.utils.Preferences;

public class Level_8c_Activity extends Level_8_BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer der aktuelle Aufgabe
    Preferences.EXERCISE_COUNTER = 3;
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 8;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_8c);

    button_0 = (Button) findViewById(R.id.button_0_8c);
    button_1 = (Button) findViewById(R.id.button_1_8c);

    timerTextView = (TextView) findViewById(R.id.timer_text_view_8c);
    failedImageView = (ImageView) findViewById(R.id.failed_image_8c);

    button_0.setOnClickListener(this);
    button_1.setOnClickListener(this);

    startExerciseTimer(Preferences.LEVEL_8c_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Button clickedButton = (Button) view;
    Bundle bundle;
    if (clickedButton.getText().equals("1")) {
      Intent intent = new Intent(this, Level_8b_Activity.class);
      bundle = new Bundle();
      bundle.putBoolean(Preferences.LEVEL_DONE, true);
      bundle.putInt(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
      bundle.putString(Preferences.AUFGABE_BESCHREIBUNG, getString(R.string.logische_schaltungen_aufgabe_3_beschreibung));
      bundle.putInt(Preferences.IMAGE, R.drawable.or_gate);
      stopExerciseTimer();

      int timePassedFromLastExercise = getIntent()
              .getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY)
              .getInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);

      timePassed = (int) (exerciseTimer.timePassed() / 1000 + timePassedFromLastExercise);
      bundle.putInt(Preferences.TIME_PASSED, timePassed);
      intent.putExtra(Preferences.BUNDLE, bundle);
      startActivity(intent);
    } else {
      bundle = new Bundle();
      bundle.putInt(Preferences.LEVEL, 8);
      bundle.putInt(Preferences.EXERCISE, 1);
      bundle.putString(Preferences.AUFGABE_BESCHREIBUNG, getString(R.string.logische_schaltungen_aufgabe_1_beschreibung));
      bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

      failed(clickedButton, bundle);
    }
  }
}
