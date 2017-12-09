package com.example.my.swipe.activities.level_5;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.activities.level_1.InfoActivity_Level_1;
import com.example.my.swipe.activities.level_6.InfoActivity_Level_6;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.Preferences;
import com.example.my.swipe.utils.Util;
import java.util.Random;

public class Level_5a_Activity extends Level_5_BaseActivity {

  int counter = 10;
  private Button yesButton;
  private Button noButton;
  private TextView textView;
  private Random random;
  private int colorsSize;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //Nummer des aktuellen Level
    Preferences.LEVEL_COUNTER = 5;
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_5a);

    yesButton = (Button) findViewById(R.id.yes_button_level_5a);
    noButton = (Button) findViewById(R.id.no_button_level_5a);
    timerTextView = (TextView) findViewById(R.id.timer_text_view_5a);
    failedImageView = (ImageView) findViewById(R.id.failed_image_5a);
    textView = (TextView) findViewById(R.id.color_text_view_level5a);
    Typeface font = Typeface.createFromAsset(getAssets(), "fonts/dancingscript_regular.otf");
    textView.setTypeface(font, Typeface.BOLD);

    yesButton.setOnClickListener(this);
    noButton.setOnClickListener(this);

    colorsSize = Preferences.COLORS.length;

    random = new Random();
    int randomColorIndex = random.nextInt(colorsSize);
    textView.setText(getString(Preferences.COLOR_NAMES[randomColorIndex]));
    randomColorIndex = random.nextInt(colorsSize);
    textView.setTextColor(Preferences.COLORS[randomColorIndex]);

    startExerciseTimer(Preferences.LEVEL_5_TOTAL_TIME_IN_SECONDS * 1000);
  }

  @Override
  public void onClick(View view) {
    Bundle bundle = new Bundle();
    Button clickedButton = (Button) view;
    String text = textView.getText().toString();
    int textColor = textView.getCurrentTextColor();

    if (counter >= 0) {
      if (clickedButton.getId() == yesButton.getId()) {
        if (textColor == Util.switchColor(text, this)) {
          int randomColorIndex = random.nextInt(colorsSize);
          textView.setText(getString(Preferences.COLOR_NAMES[randomColorIndex]));
          randomColorIndex = random.nextInt(colorsSize);
          textView.setTextColor(Preferences.COLORS[randomColorIndex]);
        } else {
          bundle.putInt(Preferences.LEVEL, 5);
          bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

          failed(clickedButton, bundle);
        }
      } else {
        if (textColor != Util.switchColor(text, this)) {
          int randomColorIndex = random.nextInt(colorsSize);
          textView.setText(getString(Preferences.COLOR_NAMES[randomColorIndex]));
          randomColorIndex = random.nextInt(colorsSize);
          textView.setTextColor(Preferences.COLORS[randomColorIndex]);
        } else {
          bundle.putInt(Preferences.LEVEL, 5);
          bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

          failed(clickedButton, bundle);
        }
      }
    } else {
      timePassed = (int) (exerciseTimer.timePassed() / 1000);
      int points = Evaluator.evaluate(Preferences.LEVEL_5_TOTAL_TIME_IN_SECONDS, timePassed);
      savePonts(Preferences.LEVEL_5_POINTS, points);
      bundle.putInt(Preferences.LEVEL_POINT, points);
      Intent intent = new Intent(this, LevelDoneActivity.class);
      bundle.putSerializable(Preferences.NEXT_LEVEL, InfoActivity_Level_6.class);
      intent.putExtra(Preferences.BUNDLE, bundle);
      startActivity(intent);
    }

    counter--;

  }
}
