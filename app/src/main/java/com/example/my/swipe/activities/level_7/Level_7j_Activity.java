package com.example.my.swipe.activities.level_7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.activities.level_2.InfoActivity_Level_2;
import com.example.my.swipe.activities.level_8.InfoActivity_Level_8;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.Preferences;

import java.util.Random;

public class Level_7j_Activity extends Level_7_BaseActivity {

  private Button buttonWith_5;
  private Button buttonWith_8;
  private Button buttonWith_4;
  private Button buttonWith_9;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 7;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_7j);

    buttonWith_5 = (Button) findViewById(R.id.button_with_5_level7j);
    buttonWith_8 = (Button) findViewById(R.id.button_with_8_level7j);
    buttonWith_4 = (Button) findViewById(R.id.button_with_4_level7j);
    buttonWith_9 = (Button) findViewById(R.id.button_with_9_level7j);
    exerciseImageView = (ImageView) findViewById(R.id.exercise_image_level_7j);

    Random random = new Random();
    int randomImage = random.nextInt(2);
    if(randomImage == 0)
    {
      exerciseImageView.setImageResource(R.drawable.level_7j_1);
      currentImage = 1;
    } else if (randomImage == 1)
    {
      exerciseImageView.setImageResource(R.drawable.level_7j_2);
      currentImage = 2;
    }

    timerTextView = (TextView) findViewById(R.id.timer_text_view_7j);
    failedImageView = (ImageView) findViewById(R.id.failed_image_7j);

    buttonWith_5.setOnClickListener(this);
    buttonWith_8.setOnClickListener(this);
    buttonWith_4.setOnClickListener(this);
    buttonWith_9.setOnClickListener(this);

    startExerciseTimer(Preferences.LEVEL_7j_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Button clickedButton = (Button) view;
    Bundle bundle = new Bundle();
    if (currentImage == 1 && clickedButton.getText().equals("8") ||
            currentImage == 2 && clickedButton.getText().equals("4"))
    {
      Intent intent = new Intent(this, LevelDoneActivity.class);
      stopExerciseTimer();

      int timePassedFromLastExercise = getIntent()
              .getBundleExtra(Preferences.BUNDLE)
              .getInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);

      timePassed = (int) (exerciseTimer.timePassed() / 1000 + timePassedFromLastExercise);
      int points = Evaluator.evaluate(Preferences.LEVEL_7_TOTAL_TIME_IN_SECONDS, timePassed);
      savePonts(Preferences.LEVEL_7_POINTS, points);
      bundle.putInt(Preferences.LEVEL_POINT, points);
      bundle.putSerializable(Preferences.NEXT_LEVEL, InfoActivity_Level_8.class); //Shecvale momdevno levelis infoActivitit
      intent.putExtra(Preferences.BUNDLE, bundle);
      startActivity(intent);
    } else
      {
      bundle.putInt(Preferences.LEVEL, 7);
      bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

      failed(clickedButton, bundle);
    }
  }
}
