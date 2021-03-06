package com.example.my.swipe.activities.level_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.utils.Preferences;

public class Level_3a_Activity extends Level_3_BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer der aktuelle Aufgabe
    Preferences.EXERCISE_COUNTER = 1;
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 3;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_3a);

    colorButton = (Button) findViewById(R.id.button_color_level_3a);
    formButton = (Button) findViewById(R.id.button_form_level_3a);
    exerciseInfoTextView = (TextView) findViewById(R.id.exercise_info_level3);
    timerTextView = (TextView) findViewById(R.id.timer_text_view_3a);
    failedImageView = (ImageView) findViewById(R.id.failed_image_3a);

    exerciseInfoTextView.setText(getIntent()
        .getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY)
        .getString(Preferences.EXERCISE_INFO));

    colorButton.setOnClickListener(this);
    formButton.setOnClickListener(this);

    startExerciseTimer(Preferences.LEVEL_3_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    handleClicledButton((Button)view, formButton.getId(), R.string.third, R.string.fifth, false);
  }
}
