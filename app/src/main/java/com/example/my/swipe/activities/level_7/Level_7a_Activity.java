package com.example.my.swipe.activities.level_7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.level_1.InfoActivity_Level_1;
import com.example.my.swipe.activities.level_1.Level_1_BaseActivity;
import com.example.my.swipe.utils.Preferences;

import java.util.Random;

public class Level_7a_Activity extends Level_7_BaseActivity {

  private Button buttonWith_2;
  private Button buttonWith_8;
  private Button buttonWith_4;
  private Button buttonWith_9;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 7;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_7a);

    buttonWith_2 = (Button) findViewById(R.id.button_with_2_level7a);
    buttonWith_8 = (Button) findViewById(R.id.button_with_8_level7a);
    buttonWith_4 = (Button) findViewById(R.id.button_with_4_level7a);
    buttonWith_9 = (Button) findViewById(R.id.button_with_9_level7a);
    exerciseImageView = (ImageView) findViewById(R.id.exercise_image_level_7a);

    Random random = new Random();
    int randomImage = random.nextInt(3);
    if(randomImage == 0)
    {
      exerciseImageView.setImageResource(R.drawable.level_7a_1);
      currentImage = 1;
    } else if (randomImage == 1)
    {
      exerciseImageView.setImageResource(R.drawable.level_7a_2);
      currentImage = 2;
    } else if (randomImage == 2)
    {
      exerciseImageView.setImageResource(R.drawable.level_7a_3);
      currentImage = 3;
    }

    timerTextView = (TextView) findViewById(R.id.timer_text_view_7a);
    failedImageView = (ImageView) findViewById(R.id.failed_image_7a);

    buttonWith_2.setOnClickListener(this);
    buttonWith_8.setOnClickListener(this);
    buttonWith_4.setOnClickListener(this);
    buttonWith_9.setOnClickListener(this);

    startExerciseTimer(Preferences.LEVEL_7a_EXERCISE_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Button clickedButton = (Button) view;
    Bundle bundle = new Bundle();
    if (currentImage == 1 && clickedButton.getText().equals("2") ||
            currentImage == 2 && clickedButton.getText().equals("8") ||
            currentImage == 3 && clickedButton.getText().equals("9"))
    {
      Intent intent = new Intent(this, Level_7b_Activity.class);
      stopExerciseTimer();
      timePassed = (int) (exerciseTimer.timePassed() / 1000);
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
