package com.example.my.swipe.activities.level_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.activities.level_1.Level_1_BaseActivity;
import com.example.my.swipe.activities.level_5.InfoActivity_Level_5;
import com.example.my.swipe.style.SquareButton;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.Preferences;

public abstract class Level_4_BaseActivity extends Level_1_BaseActivity
    implements View.OnClickListener {

  protected void handleClickedButton(SquareButton clickedButton, String targetSymbol, int nextEmoji, boolean isLast)
  {
    Bundle bundle = new Bundle();
    if (clickedButton.getBackgroundID() == Integer.parseInt(targetSymbol))
    {
      if (!isLast)
      {
        startInfoActivity(bundle, nextEmoji);
      } else
      {
        startLevelDoneActivity(bundle);
      }
    } else
    {
      bundle = new Bundle();
      bundle.putInt(Preferences.LEVEL, 4);
      bundle.putInt(Preferences.EXERCISE_INDEX, 1);
      bundle.putInt(Preferences.SMILE, R.drawable.smile_emoji);
      bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

      failed(clickedButton, bundle);
    }
  }

  private void startInfoActivity(Bundle bundle, int nextEmojy)
  {
    int timePassedFromLastExercise = 0;
    Intent intent = new Intent(this, InfoActivity_Level_4.class);
    bundle.putBoolean(Preferences.EXERCISE_DONE, true);
    bundle.putInt(Preferences.EXERCISE_INDEX, ++Preferences.EXERCISE_COUNTER);
    bundle.putInt(Preferences.SMILE, nextEmojy);

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

    int points = Evaluator.evaluate(Preferences.LEVEL_4_EXERCISE_TIME_IN_SECONDS, timePassed);
    savePonts(Preferences.LEVEL_4_POINTS, points);
    bundle.putInt(Preferences.LEVEL_POINT, points);
    bundle.putSerializable(Preferences.NEXT_LEVEL, InfoActivity_Level_5.class);
    intent.putExtra(Preferences.BUNDLE, bundle);
    startActivity(intent);
  }

  @Override
  public Class getLevelInfoClass() {
    return InfoActivity_Level_4.class;
  }
}
