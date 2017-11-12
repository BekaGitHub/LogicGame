package com.example.my.swipe.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.model.Preferences;
import com.example.my.swipe.utils.Util;

import java.util.concurrent.TimeUnit;

/**
 * Created by EmpaT on 03.11.2017.
 */

public class ExerciseTimer extends CountDownTimer {

    private TextView textView;
    private ImageView imageView;
    private Context context;

    private static final String FORMAT = "%02d:%02d";

    public ExerciseTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        Preferences.LEVEL_TIME_SPENT ++;
        textView.setText(""+String.format(FORMAT,
                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
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
                Util.showDialogFailure(context);
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