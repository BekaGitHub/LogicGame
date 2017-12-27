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

public class Level_4c_Activity extends Level_4_BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer der aktuelle Aufgabe
    Preferences.EXERCISE_COUNTER = 3;
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 4;
    targetSymbol = Integer.toString(R.drawable.neut_emoji);
    otherSymbol = Integer.toString(R.drawable.smile_emoji);

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_4c);

    //Tabelle für Buttons
    tableLayout = (TableLayout) findViewById(R.id.table_layout_level_4c);
    timerTextView = (TextView) findViewById(R.id.timer_text_view_4c);
    failedImageView = (ImageView) findViewById(R.id.failed_image_4c);

    createTable(84, 7, true);
    startExerciseTimer(Preferences.LEVEL_4_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    handleClickedButton((SquareButton)view, targetSymbol, R.drawable.sad_emoji, false);
  }
}
