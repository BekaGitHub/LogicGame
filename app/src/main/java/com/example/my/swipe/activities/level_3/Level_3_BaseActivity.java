package com.example.my.swipe.activities.level_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.my.swipe.activities.BaseActivity;

/**
 * Created by EmpaT on 18.11.2017.
 */

public abstract class Level_3_BaseActivity extends BaseActivity
        implements View.OnClickListener
{
    protected Button colorButton;
    protected Button formButton;
    protected Button nothingButton;
    protected TextView exerciseInfoTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
