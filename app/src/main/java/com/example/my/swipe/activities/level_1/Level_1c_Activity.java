package com.example.my.swipe.activities.level_1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.utils.Preferences;

public class Level_1c_Activity extends Level_1_BaseActivity implements View.OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer der aktuelle Aufgabe
    Preferences.EXERCISE_COUNTER = 3;
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 1;
    targetSymbol = "<";
    otherSymbol = ">";

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_1c);

    tableLayout = (TableLayout) findViewById(R.id.table_layout_level_1c);
    timerTextView = (TextView) findViewById(R.id.timer_text_view_1c);
    failedImageView = (ImageView) findViewById(R.id.failed_image_1c);

    createTable(84, 7, 50, 50, 30, Color.WHITE, R.drawable.buttonshape, false);
    startExerciseTimer(Preferences.LEVEL_1_EXERCISE_TIME_IN_SECONDS * 1000);
  }


  @Override
  public void onClick(View view) {
    Button clickedButton = (Button) view;
    handleButtonClick(clickedButton, 2);
  }
}
