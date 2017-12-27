package com.example.my.swipe.activities.level_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.utils.Preferences;

public class Level_8a_Activity extends Level_8_BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer der aktuelle Aufgabe
    Preferences.EXERCISE_COUNTER = 1;
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 8;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_8a);

    button_0 = (Button) findViewById(R.id.button_0_8a);
    button_1 = (Button) findViewById(R.id.button_1_8a);

    timerTextView = (TextView) findViewById(R.id.timer_text_view_8a);
    failedImageView = (ImageView) findViewById(R.id.failed_image_8a);

    button_0.setOnClickListener(this);
    button_1.setOnClickListener(this);

    startExerciseTimer(Preferences.LEVEL_8a_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Button clickedButton = (Button) view;
    Bundle bundle;
    if (clickedButton.getText().equals("0")) {
      Intent intent = new Intent(this, InfoActivity_Level_8.class);
      bundle = new Bundle();
      bundle.putBoolean(Preferences.EXERCISE_DONE, true);
      bundle.putInt(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
      bundle.putString(Preferences.AUFGABE_BESCHREIBUNG, getString(R.string.logische_schaltungen_aufgabe_2_beschreibung));
      bundle.putInt(Preferences.IMAGE, R.drawable.and_gate);

      stopExerciseTimer();
      timePassed = (int) (exerciseTimer.timePassed() / 1000);
      bundle.putInt(Preferences.TIME_PASSED, timePassed);
      intent.putExtra(Preferences.BUNDLE, bundle);
      startActivity(intent);
    } else {
      bundle = new Bundle();
      bundle.putInt(Preferences.LEVEL, 8);
      bundle.putInt(Preferences.EXERCISE, 1);
      bundle.putInt(Preferences.IMAGE, R.drawable.inverter);
      bundle.putString(Preferences.AUFGABE_BESCHREIBUNG, getString(R.string.logische_schaltungen_aufgabe_1_beschreibung));
      bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

      failed(clickedButton, bundle);
    }
  }
}
