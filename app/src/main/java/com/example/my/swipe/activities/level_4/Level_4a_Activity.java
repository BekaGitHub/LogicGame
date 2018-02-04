package com.example.my.swipe.activities.level_4;

import android.content.Intent;
import android.graphics.Color;
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

    createTable(84, 7, 50, 50, 30, Color.WHITE, R.drawable.buttonshape, true);
    startExerciseTimer(Preferences.LEVEL_4_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    handleClickedButton((SquareButton)view, targetSymbol, R.drawable.sad_emoji, false);
  }
}
