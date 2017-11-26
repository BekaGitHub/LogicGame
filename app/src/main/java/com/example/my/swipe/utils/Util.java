package com.example.my.swipe.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.level_1.Level_1_BaseActivity;
import com.example.my.swipe.activities.level_2.Level_2_BaseActivity;
import com.example.my.swipe.activities.level_3.Level_3_BaseActivity;
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

    public static void showDialogFailure(Context context, Bundle bundle)
    {
        DialogFailure dialogFailure = new DialogFailure();
        dialogFailure.setCancelable(false);
        dialogFailure.setArguments(bundle);

        dialogFailure.show(((Activity)context).getFragmentManager(), "TAG");
    }

    public static int switchColor(String colorName, Context context)
    {
        Resources res = context.getResources();

        if (colorName.equals(res.getString(R.string.red)))
            return Color.RED;
        else if (colorName.equals(res.getString(R.string.green)))
            return Color.GREEN;
        else if (colorName.equals(res.getString(R.string.black)))
            return Color.BLACK;
        else if (colorName.equals(res.getString(R.string.yellow)))
            return Color.YELLOW;
        else if (colorName.equals(res.getString(R.string.black)))
            return Color.BLUE;
        else if (colorName.equals(res.getString(R.string.magenta)))
            return Color.MAGENTA;

        return -1;
    }

//    public int evaluateLevel(int timeSpent, int levelDuration)
//    {
//
//    }

}
