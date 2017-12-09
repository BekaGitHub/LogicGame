package com.example.my.swipe.activities.level_6;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.activities.level_1.InfoActivity_Level_1;
import com.example.my.swipe.activities.level_5.Level_5_BaseActivity;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.Preferences;
import com.example.my.swipe.utils.Util;

import java.util.Random;

public class Level_6_Activity extends Level_6_BaseActivity {

  int counter = 10;
  private int colorsSize;
  private Button redButton;
  private Button greenButton;
  private Button blackButton;
  private Button yellowButton;
  private Button blueButton;
  private Button magentaButton;

  private TextView changingText;

  private Random random;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 6;
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_6);

    redButton = (Button) findViewById(R.id.red_button_level6);
    greenButton = (Button) findViewById(R.id.green_button_level6);
    blackButton = (Button) findViewById(R.id.black_button_level6);
    yellowButton = (Button) findViewById(R.id.yellow_button_level6);
    blueButton = (Button) findViewById(R.id.blue_button_level6);
    magentaButton = (Button) findViewById(R.id.magenta_button_level6);
    changingText = (TextView) findViewById(R.id.changing_text_level_6);

    timerTextView = (TextView) findViewById(R.id.timer_text_view_6);
    failedImageView = (ImageView) findViewById(R.id.failed_image_level_6);


    redButton.setOnClickListener(this);
    greenButton.setOnClickListener(this);
    blackButton.setOnClickListener(this);
    yellowButton.setOnClickListener(this);
    blueButton.setOnClickListener(this);
    magentaButton.setOnClickListener(this);

    colorsSize = Preferences.COLORS.length;

    random = new Random();
    int randomColorIndex = random.nextInt(colorsSize);
    changingText.setText(getString(Preferences.COLOR_NAMES[randomColorIndex]));
    randomColorIndex = random.nextInt(colorsSize);
    changingText.setTextColor(Preferences.COLORS[randomColorIndex]);

    startExerciseTimer(Preferences.LEVEL_5_TOTAL_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Bundle bundle = new Bundle();
    Button clickedButton = (Button) view;
    String text = changingText.getText().toString();
    int textBedeutungInColor = Util.switchColor(text, this);
    int clickedButtonColor = ((ColorDrawable)clickedButton.getBackground()).getColor();

    if (counter >= 0) {
      if (textBedeutungInColor == clickedButtonColor) {
        int randomColorIndex = random.nextInt(colorsSize);
        changingText.setText(getString(Preferences.COLOR_NAMES[randomColorIndex]));
        randomColorIndex = random.nextInt(colorsSize);
        changingText.setTextColor(Preferences.COLORS[randomColorIndex]);
      } else
      {
          bundle.putInt(Preferences.LEVEL, 6);
          bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

          failed(clickedButton, bundle);
      }
    } else {
      timePassed = (int) (exerciseTimer.timePassed() / 1000);
      int points = Evaluator.evaluate(Preferences.LEVEL_5_TOTAL_TIME_IN_SECONDS, timePassed);
      savePonts(Preferences.LEVEL_6_POINTS, points);
      bundle.putInt(Preferences.LEVEL_POINT, points);
      Intent intent = new Intent(this, LevelDoneActivity.class);
      bundle.putSerializable(Preferences.NEXT_LEVEL, InfoActivity_Level_1.class);
      intent.putExtra(Preferences.BUNDLE, bundle);
      startActivity(intent);
    }

    counter--;

  }
}
