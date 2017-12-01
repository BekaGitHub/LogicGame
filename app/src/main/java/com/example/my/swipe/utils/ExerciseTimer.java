package com.example.my.swipe.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.my.swipe.R;
import java.util.concurrent.TimeUnit;

/**
 * Created by EmpaT on 03.11.2017.
 */

public class ExerciseTimer extends CountDownTimer {

  private static final String FORMAT = "%02d:%02d";
  private static final int MSG = 1;
  private TextView textView;
  private ImageView imageView;
  //////////////////////////////////////////////////
  private Context context;
  /**
   * Millis since boot when alarm should stop.
   */
  private long mStopTimeInFuture;
  /**
   * Real time remaining until timer completes
   */
  private long mMillisInFuture;
  /**
   * Total time on timer at start
   */
  private long mTotalCountdown;
  /**
   * The interval in millis that the user receives callbacks
   */
  private long mCountdownInterval;
  /**
   * The time remaining on the timer when it was paused, if it is currently paused; 0 otherwise.
   */
  private long mPauseTimeRemaining;
  /**
   * True if timer was started running, false if not.
   */
  private boolean mRunAtStart;
  private Bundle bundle;
  // handles counting down
  private Handler mHandler = new Handler() {

    @Override
    public void handleMessage(Message msg) {

      synchronized (ExerciseTimer.this) {
        long millisLeft = timeLeft();

        if (millisLeft <= 0) {
          cancel();
          onFinish();
        } else if (millisLeft < mCountdownInterval) {
          // no tick, just delay until done
          sendMessageDelayed(obtainMessage(MSG), millisLeft);
        } else {
          long lastTickStart = SystemClock.elapsedRealtime();
          onTick(millisLeft);

          // take into account user's onTick taking time to execute
          long delay = mCountdownInterval - (SystemClock.elapsedRealtime() - lastTickStart);

          // special case: user's onTick took more than mCountdownInterval to
          // complete, skip to next interval
          while (delay < 0) {
            delay += mCountdownInterval;
          }

          sendMessageDelayed(obtainMessage(MSG), delay);
        }
      }
    }
  };

  public ExerciseTimer(long millisInFuture, long countDownInterval) {
    super(millisInFuture, countDownInterval);
  }

  public ExerciseTimer(long millisOnTimer, long countDownInterval, boolean runAtStart) {
    super(millisOnTimer, countDownInterval);
    mMillisInFuture = millisOnTimer;
    mTotalCountdown = mMillisInFuture;
    mCountdownInterval = countDownInterval;
    mRunAtStart = runAtStart;
  }

  /**
   * Create the timer object.
   */
  public synchronized final ExerciseTimer create() {
    if (mMillisInFuture <= 0) {
      onFinish();
    } else {
      mPauseTimeRemaining = mMillisInFuture;
    }

    if (mRunAtStart) {
      resume();
    }

    return this;
  }

  /**
   * Pauses the counter.
   */
  public void pause() {
    if (isRunning()) {
      mPauseTimeRemaining = timeLeft();
      cancel();
    }
  }

  /**
   * Resumes the counter.
   */
  public void resume() {
    if (isPaused()) {
      mMillisInFuture = mPauseTimeRemaining;
      mStopTimeInFuture = SystemClock.elapsedRealtime() + mMillisInFuture;
      mHandler.sendMessage(mHandler.obtainMessage(MSG));
      mPauseTimeRemaining = 0;
    }
  }

  /**
   * Tests whether the timer is paused.
   *
   * @return true if the timer is currently paused, false otherwise.
   */
  public boolean isPaused() {
    return (mPauseTimeRemaining > 0);
  }

  /**
   * Tests whether the timer is running. (Performs logical negation on {@link #isPaused()})
   *
   * @return true if the timer is currently running, false otherwise.
   */
  public boolean isRunning() {
    return (!isPaused());
  }

  /**
   * Returns the number of milliseconds remaining until the timer is finished
   *
   * @return number of milliseconds remaining until the timer is finished
   */
  public long timeLeft() {
    long millisUntilFinished;
    if (isPaused()) {
      millisUntilFinished = mPauseTimeRemaining;
    } else {
      millisUntilFinished = mStopTimeInFuture - SystemClock.elapsedRealtime();
      if (millisUntilFinished < 0) {
        millisUntilFinished = 0;
      }
    }
    return millisUntilFinished;
  }

  /**
   * Returns the number of milliseconds in total that the timer was set to run
   *
   * @return number of milliseconds timer was set to run
   */
  public long totalCountdown() {
    return mTotalCountdown;
  }

  /**
   * Returns the number of milliseconds that have elapsed on the timer.
   *
   * @return the number of milliseconds that have elapsed on the timer.
   */
  public long timePassed() {
    return mTotalCountdown - timeLeft();
  }

  /**
   * Returns true if the timer has been started, false otherwise.
   *
   * @return true if the timer has been started, false otherwise.
   */
  public boolean hasBeenStarted() {
    return (mPauseTimeRemaining <= mMillisInFuture);
  }

  @Override
  public void onTick(long millisUntilFinished) {
    Preferences.LEVEL_TIME_SPENT++;
    textView.setText("" + String.format(FORMAT,
        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
            TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
  }

  public Bundle getBundle() {
    return bundle;
  }

  public void setBundle(Bundle bundle) {
    this.bundle = bundle;
  }

  @Override
  public void onFinish() {
    Util.showFailureAnimation(context, imageView, R.mipmap.failure);

    //Pausiere mit 2 Sekunden
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        imageView.setVisibility(View.INVISIBLE);
        Util.showDialogFailure(context, bundle);
      }
    }, 1500);

  }

  public TextView getTextView() {
    return textView;
  }

  public void setTextView(TextView textView) {
    this.textView = textView;
  }

  public ImageView getImageView() {
    return imageView;
  }

  public void setImageView(ImageView imageView) {
    this.imageView = imageView;
  }

  public Context getContext() {
    return context;
  }

  public void setContext(Context context) {
    this.context = context;
  }
}