package com.example.my.swipe;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.my.swipe.adapters.MyRecyclerAdapter;
import com.example.my.swipe.fragments.BackDialog;
import com.example.my.swipe.model.LevelModel;
import com.example.my.swipe.utils.Preferences;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  CoordinatorLayout coordinatorLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView totalBrainsTextView = (TextView) findViewById(R.id.total_brains);

    coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
    final CollapsingToolbarLayout col = (CollapsingToolbarLayout) findViewById(
        R.id.collapsingToolbar);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    Bitmap headerBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.level_4_icon);

    Palette.from(headerBitmap).generate(new Palette.PaletteAsyncListener() {
      @Override
      public void onGenerated(Palette palette) {
        col.setContentScrimColor(palette.getMutedColor(1));
      }
    });

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    //RecyclerView-s schirdeba layoutmanager, rom mixvdes rogor daxatos itemebi
    //gridis saxit tu listis saxit
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(linearLayoutManager);

    List<LevelModel> levelModels = new ArrayList<>();

    int totalPoints = 0;
    for (int i = 0; i < Preferences.LEVEL_NAMES.length; i++) {
      LevelModel levelModel = new LevelModel();
      levelModel.setLevelName(getString(Preferences.LEVEL_NAMES[i]));
      levelModel.setImage(Preferences.LEVEL_ICONS[i]);
      //level_x_Points
      String pointKey = "level_" + (i+1) + "_Points";
      int levelPoint = getPoints(pointKey);
      if (levelPoint != -1) {
        levelModel.setBrains(levelPoint);
        totalPoints += levelPoint;
      }

      levelModels.add(levelModel);
    }

    String totalBrains = getString(R.string.total_brains, "" + totalPoints);
    totalBrainsTextView.setText(totalBrains);

    MyRecyclerAdapter adapter = new MyRecyclerAdapter(this, levelModels);
    recyclerView.setAdapter(adapter);
  }

  @Override
  public void onBackPressed() {
    moveTaskToBack(true);
  }

  //Pointebis chawera xdeba levelis bolo davalebashi
  private int getPoints(String level) {
    SharedPreferences pointsPref = getSharedPreferences(Preferences.POINTS_PREF, MODE_PRIVATE);
    int point = pointsPref.getInt(level, -1);
    return point;
  }

}
