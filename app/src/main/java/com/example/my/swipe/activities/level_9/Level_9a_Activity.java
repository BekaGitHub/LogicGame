package com.example.my.swipe.activities.level_9;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.level_1.Level_1_BaseActivity;
import com.example.my.swipe.utils.Preferences;

import java.util.PriorityQueue;
import java.util.Random;

public class Level_9a_Activity extends Level_9_BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer der aktuelle Aufgabe
    Preferences.EXERCISE_COUNTER = 1;
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 9;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_9a);

    //Tabelle für Buttons
    tableLayout = (TableLayout) findViewById(R.id.table_layout_level_9a);
    timerTextView = (TextView) findViewById(R.id.timer_text_view_9a);
    failedImageView = (ImageView) findViewById(R.id.failed_image_9a);


    tableRow1 = new TableRow(this);

    for (int i = 1; i < 31; i++)
    {
      numbersList.add(i);
    }

    numbersQueue = new PriorityQueue<>(numbersList);

    Random random = new Random();

    for (int i = 0; i<30; i++)
    {
      if (i % 5 == 0)
      {
        tableRow1 = new TableRow(this);
        tableRow1.setGravity(Gravity.CENTER_HORIZONTAL);
        tableLayout.addView(tableRow1);
      }

      int randomNumber = random.nextInt(numbersList.size());
      String buttonText = "" + numbersList.get(randomNumber);
      numbersList.remove(randomNumber);

      Button btn = createButton(buttonText, 100, 75,
              40, Color.WHITE, R.drawable.buttonshape);
      btn.setOnClickListener(this);

      tableRow1.addView(btn);
    }
    startExerciseTimer(Preferences.LEVEL_9a_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Button clickedButton = (Button) view;
    handleButtonClick(clickedButton, numbersQueue.poll().toString(), "30", false);
  }
}
