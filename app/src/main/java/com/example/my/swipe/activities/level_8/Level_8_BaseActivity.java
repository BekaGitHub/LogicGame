package com.example.my.swipe.activities.level_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.BaseActivity;
import com.example.my.swipe.activities.LevelDoneActivity;
import com.example.my.swipe.activities.level_7.InfoActivity_Level_7;
import com.example.my.swipe.utils.Evaluator;
import com.example.my.swipe.utils.Preferences;

public abstract class Level_8_BaseActivity extends BaseActivity
    implements View.OnClickListener {

  protected Button button_0;
  protected Button button_1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public Class getLevelInfoClass() {
    return InfoActivity_Level_8.class;
  }

  protected void handleClickedButton(Button clickedButton, String target,
                                     int aufgabeBeschreibungFuerNexteAufgabe,
                                     int iconFuerNexteAufgabe, boolean isLast)
  {
    Bundle bundle = new Bundle();
    if (clickedButton.getText().equals(target))
    {
      if (!isLast)
      {
        startInfoActivity(bundle, aufgabeBeschreibungFuerNexteAufgabe, iconFuerNexteAufgabe);
      } else
      {
        startLevelDoneActivity(bundle);
      }
    } else
    {
      bundle.putInt(Preferences.LEVEL, 8);
      bundle.putInt(Preferences.EXERCISE, 1);
      bundle.putString(Preferences.AUFGABE_BESCHREIBUNG, getString(R.string.logische_schaltungen_aufgabe_1_beschreibung));
      bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

      failed(clickedButton, bundle);
    }
  }

  private void startInfoActivity(Bundle bundle, int aufgabeBeschreibungFuerNexteAufgabe,
                                 int iconFuerNexteAufgabe)
  {
    int timePassedFromLastExercise = 0;
    Intent intent = new Intent(this, InfoActivity_Level_8.class);
    bundle.putBoolean(Preferences.EXERCISE_DONE, true);
    bundle.putInt(Preferences.EXERCISE, ++Preferences.EXERCISE_COUNTER);
    bundle.putString(Preferences.AUFGABE_BESCHREIBUNG, getString(aufgabeBeschreibungFuerNexteAufgabe));
    bundle.putInt(Preferences.IMAGE, iconFuerNexteAufgabe);

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

    int points = Evaluator.evaluate(Preferences.LEVEL_8_TOTAL_TIME_IN_SECONDS, timePassed);
    savePonts(Preferences.LEVEL_8_POINTS, points);
    bundle.putInt(Preferences.LEVEL_POINT, points);
    bundle.putSerializable(Preferences.NEXT_LEVEL, InfoActivity_Level_8.class); //Shecvale momdevno levelis infoActivitit
    intent.putExtra(Preferences.BUNDLE, bundle);
    startActivity(intent);
  }

  protected void startNextActivity(Button clickedButton, String target, Class nextActivity, boolean isLast)
  {
    Bundle bundle = new Bundle();
    int timePassedFromLastExercise = 0;
    if (clickedButton.getText().equals(target))
    {
      if (!isLast)
      {
        Intent intent = new Intent(this, nextActivity);
        stopExerciseTimer();

        if (getIntent().getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY) != null)
        {
          timePassedFromLastExercise = getIntent()
                  .getBundleExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY)
                  .getInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, 0);
        }

        timePassed = (int) (exerciseTimer.timePassed() / 1000 + timePassedFromLastExercise);
        bundle.putInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE, timePassed);
        intent.putExtra(Preferences.BUNDLE, bundle);
        startActivity(intent);
      } else
      {
        startLevelDoneActivity(bundle);
      }
    } else
    {
      bundle.putInt(Preferences.LEVEL, 8);
      bundle.putInt(Preferences.EXERCISE, 1);
      bundle.putString(Preferences.AUFGABE_BESCHREIBUNG, getString(R.string.logische_schaltungen_aufgabe_1_beschreibung));
      bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());

      failed(clickedButton, bundle);
    }
  }
}
