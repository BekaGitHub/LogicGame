package com.example.my.swipe.activities.level_4;

import android.view.View;
import com.example.my.swipe.activities.level_1.Level_1_BaseActivity;

public abstract class Level_4_BaseActivity extends Level_1_BaseActivity
    implements View.OnClickListener {

  @Override
  public Class getLevelInfoClass() {
    return InfoActivity_Level_4.class;
  }
}
