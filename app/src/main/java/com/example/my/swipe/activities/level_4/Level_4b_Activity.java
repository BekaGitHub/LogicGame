package com.example.my.swipe.activities.level_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.style.SquareButton;
import com.example.my.swipe.utils.Preferences;

public class Level_4b_Activity extends Level_4_BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer der aktuelle Aufgabe
    Preferences.EXERCISE_COUNTER = 2;
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 4;
    targetSymbol = Integer.toString(R.drawable.sad_emoji);
    otherSymbol = Integer.toString(R.drawable.smile_emoji);

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_4b);

    //Tabelle für Buttons
    tableLayout = (TableLayout) findViewById(R.id.table_layout_level_4b);
    timerTextView = (TextView) findViewById(R.id.timer_text_view_4b);
    failedImageView = (ImageView) findViewById(R.id.failed_image_4b);

    createTable(84, 7, true);
    startExerciseTimer(Preferences.LEVEL_4_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    handleClickedButton((SquareButton)view, targetSymbol, R.drawable.neut_emoji, false);
  }
}
