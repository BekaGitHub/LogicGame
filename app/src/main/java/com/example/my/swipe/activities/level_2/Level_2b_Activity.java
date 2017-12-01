package com.example.my.swipe.activities.level_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.utils.Preferences;

public class Level_2b_Activity extends Level_2_BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer der aktuelle Aufgabe
    Preferences.EXERCISE_COUNTER = 2;
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 2;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_2b);

    timerTextView = (TextView) findViewById(R.id.timer_text_view_2b);
    failedImageView = (ImageView) findViewById(R.id.failed_image_2b);
    exerciseTextView = (TextView) findViewById(R.id.exercise_2b);

    String fourthEtage = getString(R.string.fourth);
    String exercise = getString(R.string.exercise_level_2b,
        andrea, kurt + postS,
        kurt, heidi + postS,
        heidi, jurgen + postS,
        fourthEtage);

    exerciseTextView.setText(exercise);

    button1 = (Button) findViewById(R.id.button_1_level_2b);
    button2 = (Button) findViewById(R.id.button_2_level_2b);
    button3 = (Button) findViewById(R.id.button_3_level_2b);
    button4 = (Button) findViewById(R.id.button_4_level_2b);

    button1.setOnClickListener(this);
    button2.setOnClickListener(this);
    button3.setOnClickListener(this);
    button4.setOnClickListener(this);

    startExerciseTimer(Preferences.LEVEL_2_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Bundle bundle;
    if (view.getId() == button1.getId() ||
        view.getId() == button2.getId() ||
        view.getId() == button3.getId()) {
      bundle = new Bundle();
      bundle.putInt(Preferences.LEVEL, 2);
      bundle.putInt(Preferences.EXERCISE, 1);
      bundle.putString(Preferences.ETAGE, getString(R.string.second));
      bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

      failed((Button) view, bundle);
    } else {
      Intent intent = new Intent(this, InfoActivity_Level_2.class);
      bundle = new Bundle();
      bundle.putBoolean(Preferences.LEVEL_DONE, true);
      bundle.putInt(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
      bundle.putString(Preferences.ETAGE, getString(R.string.third));
      stopExerciseTimer();

      int timePassedFromLastExercise = getIntent()
          .getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY)
          .getInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);

      timePassed = (int) (exerciseTimer.timePassed() / 1000 + timePassedFromLastExercise);
      bundle.putInt(Preferences.TIME_PASSED, timePassed);
      intent.putExtra(Preferences.BUNDLE, bundle);
      startActivity(intent);
    }
  }
}