package com.example.my.swipe.activities.level_4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.style.SquareButton;
import com.example.my.swipe.utils.Preferences;

public class Level_4a_Activity extends Level_4_BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer der aktuelle Aufgabe
    Preferences.EXERCISE_COUNTER = 1;
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 4;
    targetSymbol = Integer.toString(R.drawable.smile_emoji);
    otherSymbol = Integer.toString(R.drawable.sad_emoji);

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_4a);

    //Tabelle für Buttons
    tableLayout = (TableLayout) findViewById(R.id.table_layout_level_4a);
    timerTextView = (TextView) findViewById(R.id.timer_text_view_4a);
    failedImageView = (ImageView) findViewById(R.id.failed_image_4a);

    createTable(84, 7, true);
    startExerciseTimer(Preferences.LEVEL_4_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    SquareButton clickedButton = (SquareButton) view;
    Bundle bundle;
    if (clickedButton.getBackgroundID() == Integer.parseInt(targetSymbol)) {
      Intent intent = new Intent(this, InfoActivity_Level_4.class);
      bundle = new Bundle();
      bundle.putBoolean(Preferences.LEVEL_DONE, true);
      bundle.putInt(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
      bundle.putInt(Preferences.SMILE, R.drawable.sad_emoji);

      stopExerciseTimer();
      timePassed = (int) (exerciseTimer.timePassed() / 1000);
      bundle.putInt(Preferences.TIME_PASSED, timePassed);
      intent.putExtra(Preferences.BUNDLE, bundle);
      startActivity(intent);
    } else {
      bundle = new Bundle();
      bundle.putInt(Preferences.LEVEL, 4);
      bundle.putInt(Preferences.EXERCISE, 1);
      bundle.putInt(Preferences.SMILE, R.drawable.smile_emoji);
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
