package com.example.my.swipe.activities.level_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.utils.Preferences;

public class Level_1a_Activity extends Level_1_BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer der aktuelle Aufgabe
    Preferences.EXERCISE_COUNTER = 1;
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 1;
    targetSymbol = "+";
    otherSymbol = "x";

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_1a);

    //Tabelle für Buttons
    tableLayout = (TableLayout) findViewById(R.id.table_layout_level_1a);
    timerTextView = (TextView) findViewById(R.id.timer_text_view_1a);
    failedImageView = (ImageView) findViewById(R.id.failed_image_1a);

    createTable(84, 7, false);
    startExerciseTimer(Preferences.LEVEL_1_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Button clickedButton = (Button) view;
    Bundle bundle;
    if (clickedButton.getText().equals(Preferences.SYMBOLS[0])) {
      Intent intent = new Intent(this, InfoActivity_Level_1.class);
      bundle = new Bundle();
      bundle.putBoolean(Preferences.LEVEL_DONE, true);
      bundle.putInt(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
      bundle.putString(Preferences.SYMBOL, Preferences.SYMBOLS[1]);

      stopExerciseTimer();
      timePassed = (int) (exerciseTimer.timePassed() / 1000);
      bundle.putInt(Preferences.TIME_PASSED, timePassed);
      intent.putExtra(Preferences.BUNDLE, bundle);
      startActivity(intent);
    } else {
      bundle = new Bundle();
      bundle.putInt(Preferences.LEVEL, 1);
      bundle.putInt(Preferences.EXERCISE, 1);
      bundle.putString(Preferences.SYMBOL, Preferences.SYMBOLS[0]);
      bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

      failed(clickedButton, bundle);
    }
  }

  private void saveMindNumber(int number) {
    SharedPreferences.Editor editor =
        getSharedPreferences(Preferences.PREFS, MODE_PRIVATE).edit();
    editor.putInt("name", 4);
    editor.apply();
  }
}
