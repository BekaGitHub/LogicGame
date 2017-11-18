package com.example.my.swipe.activities;

import android.support.v7.app.AppCompatActivity;

import com.example.my.swipe.fragments.DialogBack;

/**
 * Created by EmpaT on 18.11.2017.
 */

public class InfoBaseActivity extends AppCompatActivity
{
    protected int exerciseNumber;
    protected int timePassedFromLastExercise;
    protected String exerciseInfo = "";

    @Override
    public void onBackPressed()
    {
        DialogBack dialog = new DialogBack();
        dialog.show(getFragmentManager(), "DialogTag");
    }
}
