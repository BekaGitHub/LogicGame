package com.example.my.swipe.activities.level_7;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.BaseActivity;
import com.example.my.swipe.activities.level_1.InfoActivity_Level_1;
import com.example.my.swipe.style.MyBounceInterpolator;
import com.example.my.swipe.style.SquareButton;

import java.util.ArrayList;
import java.util.Random;

public abstract class Level_7_BaseActivity extends BaseActivity
    implements View.OnClickListener {

  protected ImageView exerciseImageView;
  protected int currentImage = -1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public Class getLevelInfoClass() {
    return InfoActivity_Level_7.class;
  }
}
