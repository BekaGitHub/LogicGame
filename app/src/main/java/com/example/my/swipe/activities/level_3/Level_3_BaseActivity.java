package com.example.my.swipe.activities.level_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.BaseActivity;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.activities.level_4.InfoActivity_Level_4;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.Preferences;

/**
 * Created by EmpaT on 18.11.2017.
 */

public abstract class Level_3_BaseActivity extends BaseActivity
    implements View.OnClickListener {

  protected Button colorButton;
  protected Button formButton;
  protected TextView exerciseInfoTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  protected void handleClicledButton(Button clickedButton, int target, int figureA, int figureB, boolean isLast)
  {
    Bundle bundle = new Bundle();
    if (clickedButton.getId() == target)
    {
      if (!isLast)
      {
        startInfoActivity(bundle, figureA, figureB);
      } else
      {
        startLevelDoneActivity(bundle);
      }
    } else
    {
      bundle.putInt(Preferences.LEVEL, 3);
      bundle.putInt(Preferences.EXERCISE, 1);
      bundle.putInt(Preferences.FIGURE_1, R.string.first);
      bundle.putInt(Preferences.FIGURE_2, R.string.second);
      bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

      failed(clickedButton, bundle);
    }
  }

  private void startInfoActivity(Bundle bundle, int figureA, int figureB)
  {
    int timePassedFromLastExercise = 0;
    Intent intent = new Intent(this, InfoActivity_Level_3.class);
    bundle.putBoolean(Preferences.EXERCISE_DONE, true);
    bundle.putInt(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
    bundle.putInt(Preferences.FIGURE_1, figureA);
    bundle.putInt(Preferences.FIGURE_2, figureB);
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
    int points = Evaluator.evaluate(Preferences.LEVEL_3_EXERCISE_TIME_IN_SECONDS, timePassed);
    savePonts(Preferences.LEVEL_3_POINTS, points);
    bundle.putInt(Preferences.LEVEL_POINT, points);
    bundle.putSerializable(Preferences.NEXT_LEVEL, InfoActivity_Level_4.class);
    intent.putExtra(Preferences.BUNDLE, bundle);
    startActivity(intent);


  }

  @Override
  public Class getLevelInfoClass() {
    return InfoActivity_Level_3.class;
  }
}
