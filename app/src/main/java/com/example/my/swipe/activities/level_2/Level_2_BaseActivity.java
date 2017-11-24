package com.example.my.swipe.activities.level_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.BaseActivity;
import com.example.my.swipe.activities.level_1.InfoActivity_Level_1;

public abstract class Level_2_BaseActivity extends BaseActivity
        implements View.OnClickListener{

    protected Button button1;
    protected Button button2;
    protected Button button3;
    protected Button button4;
    protected TextView exerciseTextView;

    protected String jurgen;
    protected String andrea;
    protected String heidi;
    protected String kurt;
    String postS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jurgen = getString(R.string.jurgen);
        andrea = getString(R.string.andrea);
        heidi = getString(R.string.heidi);
        kurt = getString(R.string.kurt);
        postS = getString(R.string.postS);
    }

    @Override
    public Class getLevelInfoClass()
    {
        return InfoActivity_Level_2.class;
    }
}
