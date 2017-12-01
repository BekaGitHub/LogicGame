package com.example.my.swipe.activities.level_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.activities.InfoBaseActivity;
import com.example.my.swipe.utils.Preferences;

public class InfoActivity_Level_3 extends InfoBaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info_level_3);

    levelCounterTextView = (TextView) findViewById(R.id.info_activity_level3_level_counter);
    exerciseCounterTextView = (TextView) findViewById(R.id.info_activity_level3_exercise_counter);
    exerciseExplanationTextView = (TextView) findViewById(R.id.info_activity_level3_exercise_explanation);

    Bundle bundle = getIntent().getBundleExtra(Preferences.BUNDLE);

    timePassedFromLastExercise = bundle.getInt(Preferences.TIME_PASSED, 0);

    levelIndex = bundle.getInt(Preferences.LEVEL, 3);
    exerciseIndex = bundle.getInt(Preferences.EXERCISE, 1);
    isLevelDone = bundle.getBoolean(Preferences.LEVEL_DONE, false);

    //aq gavcherdi 19.11.2017
    int figure1 = bundle.getInt(Preferences.FIGURE_1, R.string.first);
    int figure2 = bundle.getInt(Preferences.FIGURE_2, R.string.second);

    setInfoText();

    String exerciseCounterText = getString(R.string.exercise_counter, "" + exerciseIndex, "3");

    //Figuren, deren Gleichheit erraten werden muss, konnen folgende
    //Positionen annehmen: (1,2), (3,5), (2,4)
    String text1 = getString(figure1);
    String text2 = getString(figure2);
    exerciseExplanation = getString(R.string.common_figures_easy, text1, text2);

    levelCounterTextView.setText(infoText);
    exerciseCounterTextView.setText(exerciseCounterText);
    exerciseExplanationTextView.setText(exerciseExplanation);
  }

  public void handleClick(View view) {
    Intent intent = null;
    Bundle bundle = new Bundle();
    switch (exerciseIndex) {
      case 1:
        intent = new Intent(this, Level_3a_Activity.class);
        break;
      case 2:
        intent = new Intent(this, Level_3b_Activity.class);
        break;
      case 3:
        intent = new Intent(this, Level_3c_Activity.class);
        break;
    }

    bundle.putInt(Preferences.TIME_PASSED_FROM_LAST_EXERCISE,
        timePassedFromLastExercise);
    bundle.putString(Preferences.EXERCISE_INFO, exerciseExplanation);
    intent.putExtra(Preferences.BUNDLE_FROM_INFO_ACTIVITY, bundle);
    startActivity(intent);
  }
}
