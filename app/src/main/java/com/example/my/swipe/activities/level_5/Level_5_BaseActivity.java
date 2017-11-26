package com.example.my.swipe.activities.level_5;

import android.os.Bundle;
import android.view.View;
import com.example.my.swipe.activities.BaseActivity;

public abstract class Level_5_BaseActivity extends BaseActivity
        implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Class getLevelInfoClass()
    {
        return InfoActivity_Level_5.class;
    }

}
