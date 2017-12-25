package com.example.my.swipe.activities.level_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.Preferences;

public class Level_8d_Activity extends Level_8_BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer der aktuelle Aufgabe
    Preferences.EXERCISE_COUNTER = 4;
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 8;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_8d);

    button_0 = (Button) findViewById(R.id.button_0_8d);
    button_1 = (Button) findViewById(R.id.button_1_8d);

    timerTextView = (TextView) findViewById(R.id.timer_text_view_8d);
    failedImageView = (ImageView) findViewById(R.id.failed_image_8d);

    button_0.setOnClickListener(this);
    button_1.setOnClickListener(this);

    startExerciseTimer(Preferences.LEVEL_8d_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Button clickedButton = (Button) view;
    Bundle bundle = new Bundle();
    if (clickedButton.getText().equals("0")) {
      Intent intent = new Intent(this, LevelDoneActivity.class);
      stopExerciseTimer();

      int timePassedFromLastExercise = getIntent()
              .getBundleExtra(Preferences.BUNDLE)
              .getInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);

      timePassed = (int) (exerciseTimer.timePassed() / 1000 + timePassedFromLastExercise);
      int points = Evaluator.evaluate(Preferences.LEVEL_8_TOTAL_TIME_IN_SECONDS, timePassed);
      savePonts(Preferences.LEVEL_8_POINTS, points);
      bundle.putInt(Preferences.LEVEL_POINT, points);
      bundle.putSerializable(Preferences.NEXT_LEVEL, InfoActivity_Level_8.class); //Shecvale momdevno levelis infoActivitit
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
