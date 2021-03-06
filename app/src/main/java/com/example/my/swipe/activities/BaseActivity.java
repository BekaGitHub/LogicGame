package com.example.my.swipe.activities;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.fragments.BackDialog;
import com.example.my.swipe.style.SquareButton;
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

  public void savePonts(String key, int value) {
    SharedPreferences pointsPref = getSharedPreferences(Preferences.POINTS_PREF, MODE_PRIVATE);
    SharedPreferences.Editor editor = pointsPref.edit();
    //chaiwere qula mxolod mashin, tu aktualuri qula metia
    //wina cdaze dagrovil qulaze an key ar arsebobs, anu qula
    //konkretuli levelistvis jer ar chawerila
    int pointsFromLastTry = pointsPref.getInt(key, -1);
    if(pointsFromLastTry == -1 || pointsFromLastTry < value) {
      editor.putInt(key, value);
      editor.commit();
    }

    editor.putInt(key, value);

  }

  public Button createButton(String text, int buttonWidth, int buttonHeight,
                             int textSize, int textColor, int backgroundResource) {

    DisplayMetrics dm = getResources().getDisplayMetrics();
    float width_dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, buttonWidth, dm);
    float height_dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, buttonHeight, dm);

    SquareButton button = new SquareButton(this, (int) height_dpInPx, (int) width_dpInPx);
    button.setAllCaps(false);
    button.setText(text);
    button.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
    button.setTextColor(textColor);
    if (backgroundResource == -1)
      button.setBackgroundResource(R.drawable.buttonshape);
    else
      button.setBackgroundResource(backgroundResource);
    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
    layoutParams.setMargins(7, 7, 7, 7);
    button.setLayoutParams(layoutParams);

    return button;
  }

  public abstract Class getLevelInfoClass();
}
