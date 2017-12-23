package com.example.my.swipe.activities.level_7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.utils.Preferences;

import java.util.Random;

public class Level_7b_Activity extends Level_7_BaseActivity {

  private Button buttonWith_9;
  private Button buttonWith_1;
  private Button buttonWith_7;
  private Button buttonWith_4;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 7;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_7b);

    buttonWith_9 = (Button) findViewById(R.id.button_with_9_level7b);
    buttonWith_1 = (Button) findViewById(R.id.button_with_1_level7b);
    buttonWith_7 = (Button) findViewById(R.id.button_with_7_level7b);
    buttonWith_4 = (Button) findViewById(R.id.button_with_4_level7b);
    exerciseImageView = (ImageView) findViewById(R.id.exercise_image_level_7b);

    Random random = new Random();
    int randomImage = random.nextInt(2);
    if(randomImage == 0)
    {
      exerciseImageView.setImageResource(R.drawable.level_7b_1);
      currentImage = 1;
    } else if (randomImage == 1)
    {
      exerciseImageView.setImageResource(R.drawable.level_7b_2);
      currentImage = 2;
    }

    timerTextView = (TextView) findViewById(R.id.timer_text_view_7b);
    failedImageView = (ImageView) findViewById(R.id.failed_image_7b);

    buttonWith_9.setOnClickListener(this);
    buttonWith_1.setOnClickListener(this);
    buttonWith_7.setOnClickListener(this);
    buttonWith_4.setOnClickListener(this);

    startExerciseTimer(Preferences.LEVEL_7b_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Button clickedButton = (Button) view;
    Bundle bundle = new Bundle();
    if (currentImage == 1 && clickedButton.getText().equals("1") ||
            currentImage == 2 && clickedButton.getText().equals("4"))
    {
      Intent intent = new Intent(this, Level_7c_Activity.class);
      stopExerciseTimer();

      int timePassedFromLastExercise = getIntent()
              .getBundleExtra(Preferences.BUNDLE)
              .getInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);

      timePassed = (int) (exerciseTimer.timePassed() / 1000 + timePassedFromLastExercise);
      bundle.putInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, timePassed);
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
