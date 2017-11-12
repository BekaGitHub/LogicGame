package com.example.my.swipe.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.fragments.DialogBack;
import com.example.my.swipe.utils.ExerciseTimer;
import com.example.my.swipe.utils.Util;

/**
 * Created by EmpaT on 12.11.2017.
 */

public class BaseActivity extends AppCompatActivity
{
    protected TextView timerTextView;
    protected ImageView failedImageView;
    protected ExerciseTimer exerciseTimer;

    @Override
    public void onBackPressed()
    {
        DialogBack dialog = new DialogBack();
        dialog.show(getFragmentManager(), "DialogTag");

        if (exerciseTimer != null)
            exerciseTimer.cancel();
    }

    protected void failed(Button clickedButton)
    {
        final Context context = this;
        clickedButton.setTextColor(Color.RED);
        exerciseTimer.cancel();
        Util.showFailureAnimation(context, failedImageView, R.mipmap.failure);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                failedImageView.setVisibility(View.INVISIBLE);
                Util.showDialogFailure(context);
            }
        }, 1500);
    }
}
