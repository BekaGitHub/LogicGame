package com.example.my.swipe.activities.level_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.activities.BaseActivity;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.activities.level_3.InfoActivity_Level_3;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.Preferences;

public abstract class Level_2_BaseActivity extends BaseActivity
    implements View.OnClickListener {

  protected Button button1;
  protected Button button2;
  protected Button button3;
  protected Button button4;
  protected TextView exerciseTextView;

  protected String jurgen;
  protected String andrea;
  protected String heidi;
  protected String kurt;
  String postS;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    jurgen = getString(R.string.jurgen);
    andrea = getString(R.string.andrea);
    heidi = getString(R.string.heidi);
    kurt = getString(R.string.kurt);
    postS = getString(R.string.postS);
  }

  protected void handleClickedButton(Button clickedButton, int targetID, int nextEtage, boolean isLast)
  {
    Bundle bundle = new Bundle();
    if (clickedButton.getId() == targetID)
    {
      if (!isLast)
      {
        startInfoActivity(bundle, nextEtage);
      } else
      {
        startLevelDoneActivity(bundle);
      }
    } else
    {
      bundle.putInt(Preferences.LEVEL, 2);
      bundle.putInt(Preferences.EXERCISE, 1);
      bundle.putString(Preferences.ETAGE, getString(R.string.second));
      bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

      failed(clickedButton, bundle);
    }
  }

  private void startInfoActivity(Bundle bundle, int nextEtage)
  {
    int timePassedFromLastExercise = 0;
    Intent intent = new Intent(this, InfoActivity_Level_2.class);
    bundle.putBoolean(Preferences.EXERCISE_DONE, true);
    bundle.putInt(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
    bundle.putString(Preferences.ETAGE, getString(nextEtage));
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

    int points = Evaluator.evaluate(Preferences.LEVEL_2_EXERCISE_TIME_IN_SECONDS, timePassed);
    savePonts(Preferences.LEVEL_2_POINTS, points);
    bundle.putInt(Preferences.LEVEL_POINT, points);
    bundle.putSerializable(Preferences.NEXT_LEVEL, InfoActivity_Level_3.class);
    intent.putExtra(Preferences.BUNDLE, bundle);
    startActivity(intent);
  }

  @Override
  public Class getLevelInfoClass() {
    return InfoActivity_Level_2.class;
  }
}
