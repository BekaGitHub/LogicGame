package com.example.my.swipe.activities.level_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.my.swipe.activities.BaseActivity;

public abstract class Level_2_BaseActivity extends BaseActivity
        implements View.OnClickListener{

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView exerciseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
