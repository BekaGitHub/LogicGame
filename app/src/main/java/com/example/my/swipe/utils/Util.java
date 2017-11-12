package com.example.my.swipe.utils;

import android.app.Activity;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.my.swipe.R;
import com.example.my.swipe.fragments.DialogFailure;

/**
 * Created by EmpaT on 10.11.2017.
 */

public class Util
{
    private Util()
    {

    }

    public static void showFailureAnimation(Context context, ImageView imageView, int image)
    {
        Animation animation =
                AnimationUtils.loadAnimation(context,
                        R.anim.fade);
        imageView.setImageResource(R.mipmap.failure);
        imageView.bringToFront();
        imageView.startAnimation(animation);
    }

    public static void showDialogFailure(Context context)
    {
        DialogFailure dialogFailure = new DialogFailure();
        dialogFailure.setCancelable(false);
        Activity activity = (Activity) context;
        dialogFailure.show(activity.getFragmentManager(), "TAG");
    }

//    public int evaluateLevel(int timeSpent, int levelDuration)
//    {
//
//    }

}
