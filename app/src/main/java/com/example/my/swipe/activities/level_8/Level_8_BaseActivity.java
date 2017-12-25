package com.example.my.swipe.activities.level_8;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.my.swipe.activities.BaseActivity;
import com.example.my.swipe.activities.level_7.InfoActivity_Level_7;

public abstract class Level_8_BaseActivity extends BaseActivity
    implements View.OnClickListener {

  protected Button button_0;
  protected Button button_1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public Class getLevelInfoClass() {
    return InfoActivity_Level_8.class;
  }
}
