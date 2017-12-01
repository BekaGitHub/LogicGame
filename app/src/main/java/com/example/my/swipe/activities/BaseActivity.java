package com.example.my.swipe.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.fragments.BackDialog;
import com.example.my.swipe.utils.ExerciseTimer;
import com.example.my.swipe.utils.Preferences;
import com.example.my.swipe.utils.Util;

/**
 * Created by EmpaT on 12.11.2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

  protected TextView timerTextView;
  protected ImageView failedImageView;
  protected ExerciseTimer exerciseTimer;
  protected int timePassed = 0;

  @Override
  public void onBackPressed() {
    BackDialog dialog = new BackDialog();
    dialog.setExerciseTimer(exerciseTimer);
    dialog.show(getFragmentManager(), "DialogTag");

    if (exerciseTimer != null) {
      exerciseTimer.pause();
    }
  }

  protected void failed(Button clickedButton, final Bundle bundle) {
    clickedButton.setTextColor(Color.RED);
    exerciseTimer.cancel();
    Util.showFailureAnimation(this, failedImageView, R.mipmap.failure);
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        failedImageView.setVisibility(View.INVISIBLE);
        Util.showDialogFailure(BaseActivity.this, bundle);
      }
    }, 1500);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
  }

  protected void startExerciseTimer(int milliSeconds) {
    Bundle bundle = new Bundle();
    bundle.putSerializable(Preferences.CLASS, getLevelInfoClass());
    exerciseTimer = new ExerciseTimer(milliSeconds, 1000, true);
    exerciseTimer.setBundle(bundle);
    exerciseTimer.create();
    exerciseTimer.setTextView(timerTextView);
    exerciseTimer.setImageView(failedImageView);
    exerciseTimer.setContext(this);
    exerciseTimer.start();
  }

  protected void stopExerciseTimer() {
    exerciseTimer.pause();
    exerciseTimer.cancel();
  }


  public abstract Class getLevelInfoClass();
}
