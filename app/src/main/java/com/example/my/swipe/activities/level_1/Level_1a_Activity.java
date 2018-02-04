package com.example.my.swipe.activities.level_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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

    createTable(84, 7, 50, 50, 30, Color.WHITE, R.drawable.buttonshape, false);
    startExerciseTimer(Preferences.LEVEL_1_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Button clickedButton = (Button) view;
    handleButtonClick(clickedButton, 0);
  }
}
