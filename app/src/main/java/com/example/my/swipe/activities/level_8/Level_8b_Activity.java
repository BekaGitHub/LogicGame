package com.example.my.swipe.activities.level_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.utils.Preferences;

public class Level_8b_Activity extends Level_8_BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer der aktuelle Aufgabe
    Preferences.EXERCISE_COUNTER = 2;
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 8;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_8b);

    button_0 = (Button) findViewById(R.id.button_0_8b);
    button_1 = (Button) findViewById(R.id.button_1_8b);

    timerTextView = (TextView) findViewById(R.id.timer_text_view_8b);
    failedImageView = (ImageView) findViewById(R.id.failed_image_8b);

    button_0.setOnClickListener(this);
    button_1.setOnClickListener(this);

    startExerciseTimer(Preferences.LEVEL_8b_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    handleClickedButton((Button) view, "0",
            R.string.logische_schaltungen_aufgabe_3_beschreibung,
            R.drawable.or_gate, false);
  }
}
