package com.example.my.swipe.activities.level_6;

import android.os.Bundle;
import android.view.View;

import com.example.my.swipe.activities.BaseActivity;
import com.example.my.swipe.activities.level_5.InfoActivity_Level_5;

public abstract class Level_6_BaseActivity extends BaseActivity
    implements View.OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public Class getLevelInfoClass() {
    return InfoActivity_Level_6.class;
  }

}
