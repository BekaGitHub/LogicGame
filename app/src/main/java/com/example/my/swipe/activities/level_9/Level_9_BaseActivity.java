package com.example.my.swipe.activities.level_9;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.BaseActivity;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.activities.level_1.Level_1_BaseActivity;
import com.example.my.swipe.activities.level_2.InfoActivity_Level_2;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public abstract class Level_9_BaseActivity  extends BaseActivity
    implements View.OnClickListener {

  protected ImageView exerciseImageView;
  protected int currentImage = -1;
  protected TableLayout tableLayout;

  protected TableRow tableRow1;

  protected List<Integer> numbersList = new ArrayList<>();
  protected PriorityQueue<Integer> numbersQueue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public Class getLevelInfoClass() {
    return InfoActivity_Level_9.class;
  }

  protected void handleButtonClick(Button clickedButton, String targetButtonText, String lastNumber, boolean isLastExercise)
  {
    Bundle bundle = new Bundle();
    if (clickedButton.getText().equals(targetButtonText))
    {
      if (clickedButton.getText().equals(lastNumber))
      {
        if (isLastExercise)
          startLevelDoneActivity(bundle);
        else
          startInfoActivity(bundle);
      } else
      {
        clickedButton.setBackgroundResource(R.drawable.buttonshape_green);
        clickedButton.setEnabled(false);
      }
    } else
    {
      bundle.putInt(Preferences.LEVEL, 9);
      bundle.putInt(Preferences.EXERCISE_INDEX, 1);
      bundle.putInt(Preferences.AUFGABE_BESCHREIBUNG, Preferences.LEVEL_9_AUFGABE_TEXTS[0]);
      bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());
      failed(clickedButton, bundle);
    }
  }

  private void startInfoActivity(Bundle bundle)
  {
    int timePassedFromLastExercise = 0;
    Intent intent = new Intent(this, InfoActivity_Level_9.class);
    bundle.putBoolean(Preferences.EXERCISE_DONE, true);
    bundle.putInt(Preferences.EXERCISE_INDEX, ++Preferences.EXERCISE_COUNTER);
    bundle.putInt(Preferences.AUFGABE_BESCHREIBUNG, Preferences.LEVEL_9_AUFGABE_TEXTS[Preferences.EXERCISE_COUNTER - 1]);
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
}
