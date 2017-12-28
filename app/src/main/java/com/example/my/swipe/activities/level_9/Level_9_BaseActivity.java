package com.example.my.swipe.activities.level_9;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.my.swipe.activities.BaseActivity;
import com.example.my.swipe.activities.level_1.Level_1_BaseActivity;
import com.example.my.swipe.activities.level_7.InfoActivity_Level_7;
import com.example.my.swipe.activities.level_8.InfoActivity_Level_8;

public abstract class Level_9_BaseActivity  extends Level_1_BaseActivity
    implements View.OnClickListener {

  protected ImageView exerciseImageView;
  protected int currentImage = -1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public Class getLevelInfoClass() {
    return InfoActivity_Level_9.class;
  }
}
