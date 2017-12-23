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

public class Level_7c_Activity extends Level_7_BaseActivity {

  private Button buttonWith_12;
  private Button buttonWith_15;
  private Button buttonWith_8;
  private Button buttonWith_9;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 7;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_7c);

    buttonWith_12 = (Button) findViewById(R.id.button_with_12_level7c);
    buttonWith_15 = (Button) findViewById(R.id.button_with_15_level7c);
    buttonWith_8 = (Button) findViewById(R.id.button_with_8_level7c);
    buttonWith_9 = (Button) findViewById(R.id.button_with_9_level7c);
    exerciseImageView = (ImageView) findViewById(R.id.exercise_image_level_7c);

    Random random = new Random();
    int randomImage = random.nextInt(2);
    if(randomImage == 0)
    {
      exerciseImageView.setImageResource(R.drawable.level_7c_1);
      currentImage = 1;
    } else if (randomImage == 1)
    {
      exerciseImageView.setImageResource(R.drawable.level_7c_2);
      currentImage = 2;
    }

    timerTextView = (TextView) findViewById(R.id.timer_text_view_7c);
    failedImageView = (ImageView) findViewById(R.id.failed_image_7c);

    buttonWith_12.setOnClickListener(this);
    buttonWith_15.setOnClickListener(this);
    buttonWith_8.setOnClickListener(this);
    buttonWith_9.setOnClickListener(this);

    startExerciseTimer(Preferences.LEVEL_7c_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Button clickedButton = (Button) view;
    Bundle bundle = new Bundle();
    if (currentImage == 1 && clickedButton.getText().equals("9") ||
            currentImage == 2 && clickedButton.getText().equals("15"))
    {
      Intent intent = new Intent(this, Level_7j_Activity.class);
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
