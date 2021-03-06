package com.example.my.swipe.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.fragments.BackDialog;

/**
 * Created by EmpaT on 18.11.2017.
 */

public class InfoBaseActivity extends AppCompatActivity {

  protected TextView levelCounterTextView;
  protected TextView exerciseCounterTextView;
  protected TextView exerciseExplanationTextView;
  protected ImageView imageViewFuerInfo;

  protected int exerciseIndex;
  protected int levelIndex;
  protected int timePassedFromLastExercise;
  protected String exerciseExplanation = "";
  protected String infoText = "";
  protected boolean isLevelDone;

  @Override
  public void onBackPressed() {
    BackDialog dialog = new BackDialog();
    dialog.show(getFragmentManager(), "DialogTag");
  }

  public void setInfoText() {
    if (isLevelDone) {
      infoText = getString(R.string.exercise_done);
    } else {
      infoText = getString(R.string.level_counter, "" + levelIndex);
    }
  }

  public void blinkText(TextView textView)
  {
    Animation anim = new AlphaAnimation(0.0f, 1.0f);
    anim.setDuration(400); //You can manage the time of the blink with this parameter
    anim.setStartOffset(20);
    anim.setRepeatMode(Animation.REVERSE);
    anim.setRepeatCount(Animation.INFINITE);
    textView.startAnimation(anim);
  }
}
