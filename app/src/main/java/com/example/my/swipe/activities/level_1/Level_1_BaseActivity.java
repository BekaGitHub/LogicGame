package com.example.my.swipe.activities.level_1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.example.my.swipe.R;
import com.example.my.swipe.activities.BaseActivity;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.activities.level_2.InfoActivity_Level_2;
import com.example.my.swipe.style.MyBounceInterpolator;
import com.example.my.swipe.style.SquareButton;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.Preferences;

import java.util.ArrayList;
import java.util.Random;

public abstract class Level_1_BaseActivity extends BaseActivity
    implements View.OnClickListener {

  protected static String targetSymbol;
  protected static String otherSymbol;
  protected TableRow tableRow;
  protected TableLayout tableLayout;
  protected ArrayList<Button> buttons;
  protected int targetPosition;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    buttons = new ArrayList<>();
  }

  protected Button createButton(String text) {

    DisplayMetrics dm = getResources().getDisplayMetrics();
    float dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, dm);

    SquareButton button = new SquareButton(this, (int) dpInPx, (int) dpInPx);
    button.setAllCaps(false);
    button.setText(text);
    button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
    button.setTextColor(ContextCompat.getColor(this, R.color.button_text_color));
    button.setBackgroundResource(R.drawable.buttonshape);
    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
    layoutParams.setMargins(7, 7, 7, 7);
    button.setLayoutParams(layoutParams);

    return button;
  }

  protected Button createRotateButtonWithImage(String targetImage) {

    DisplayMetrics dm = getResources().getDisplayMetrics();
    float dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, dm);

    SquareButton button = new SquareButton(this, (int) dpInPx, (int) dpInPx);
    button.setAllCaps(false);
    button.setBackgroundResource(Integer.parseInt(targetImage));
    button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
    button.setTextColor(ContextCompat.getColor(this, R.color.button_text_color));

    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
    layoutParams.setMargins(7, 7, 7, 7);
    button.setLayoutParams(layoutParams);

    Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_around_center_point);
    button.startAnimation(animation);

    return button;
  }

  @Override
  protected void failed(Button clickedButton, Bundle bundle) {
    final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
    // Use bounce interpolator with amplitude 0.2 and frequency 20
    MyBounceInterpolator interpolator = new MyBounceInterpolator(0.4, 50);
    myAnim.setInterpolator(interpolator);

    for (Button button : buttons) {
      button.startAnimation(myAnim);
    }
    buttons.get(targetPosition).setTextColor(Color.GREEN);

    super.failed(clickedButton, bundle);
  }

  protected void createTable(int buttonNumber, int columnNumer, boolean isCircle) {
    Random random = new Random();
    int randomNumber = random.nextInt(buttonNumber);
    int i = 0;
    while (i < buttonNumber) {
      if (i % columnNumer == 0) {
        tableRow = new TableRow(this);
        tableRow.setGravity(Gravity.CENTER);
        tableLayout.addView(tableRow);
      }
      Button btn;
      if (i == randomNumber) {
        if (isCircle) {
          btn = createRotateButtonWithImage(targetSymbol);
        } else {
          btn = createButton(targetSymbol);
          btn.setTextColor(Color.GREEN);
        }
        targetPosition = randomNumber;
      } else {
        if (isCircle) {
          btn = createRotateButtonWithImage(otherSymbol);
        } else {
          btn = createButton(otherSymbol);
        }
      }
      buttons.add(btn);
      btn.setOnClickListener(this);
      tableRow.addView(btn);
      i++;
    }
  }

  protected void handleButtonClick(Button clickedButton, int symbolIndex)
  {
    Bundle bundle = new Bundle();
    if (clickedButton.getText().equals(Preferences.SYMBOLS[symbolIndex]))
    {
      if (symbolIndex != Preferences.SYMBOLS.length - 1) //Wenn symbolIndex, kein index vom letzten Symbol ist
      {
        startInfoActivity(symbolIndex, bundle);
      }else
      {
        startLevelDoneActivity(bundle);
      }
    } else
    {
      bundle.putInt(Preferences.LEVEL, 1);
      bundle.putInt(Preferences.EXERCISE, 1);
      bundle.putString(Preferences.SYMBOL, Preferences.SYMBOLS[0]);
      bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());
      failed(clickedButton, bundle);
    }
  }

  private void startInfoActivity(int symbolIndex, Bundle bundle)
  {
    int timePassedFromLastExercise = 0;
    Intent intent = new Intent(this, InfoActivity_Level_1.class);
    bundle.putBoolean(Preferences.EXERCISE_DONE, true);
    bundle.putInt(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
    bundle.putString(Preferences.SYMBOL, Preferences.SYMBOLS[symbolIndex + 1]);
    stopExerciseTimer();

    if (getIntent().getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY) != null)
    {
      timePassedFromLastExercise = getIntent()
              .getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY)
              .getInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);
    }

    timePassed = (int) (exerciseTimer.timePassed() / 1000 + timePassedFromLastExercise);
    bundle.putInt(Preferences.TIME_PASSED, timePassed);
    intent.putExtra(Preferences.BUNDLE, bundle);
    startActivity(intent);
  }

  private void startLevelDoneActivity(Bundle bundle)
  {
    int timePassedFromLastExercise = 0;
    Intent intent = new Intent(this, LevelDoneActivity.class);
    stopExerciseTimer();

    if (getIntent().getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY) != null)
    {
      timePassedFromLastExercise = getIntent()
              .getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY)
              .getInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);
    }

    timePassed = (int) (exerciseTimer.timePassed() / 1000 + timePassedFromLastExercise);
    int points = Evaluator.evaluate(Preferences.LEVEL_1_EXERCISE_TIME_IN_SECONDS, timePassed);
    savePonts(Preferences.LEVEL_1_POINTS, points);
    bundle.putInt(Preferences.LEVEL_POINT, points);
    bundle.putSerializable(Preferences.NEXT_LEVEL, InfoActivity_Level_2.class);
    intent.putExtra(Preferences.BUNDLE, bundle);
    startActivity(intent);
  }



  @Override
  public Class getLevelInfoClass() {
    return InfoActivity_Level_1.class;
  }
}
