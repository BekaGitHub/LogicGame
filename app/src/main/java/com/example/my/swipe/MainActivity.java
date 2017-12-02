package com.example.my.swipe;

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

    Bitmap headerBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.haus);

    Palette.from(headerBitmap).generate(new Palette.PaletteAsyncListener() {
      @Override
      public void onGenerated(Palette palette) {
        col.setContentScrimColor(palette.getDominantColor(1));
      }
    });

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    //RecyclerView-s schirdeba layoutmanager, rom mixvdes rogor daxatos itemebi
    //gridis saxit tu listis saxit
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(linearLayoutManager);

    List<LevelModel> levelModels = new ArrayList<>();

    int brains = Preferences.TOTAL_BRAINS;
    for (int i = 0; i < Preferences.LEVEL_NAMES.length; i++) {
      LevelModel levelModel = new LevelModel();
      levelModel.setLevelName(getString(Preferences.LEVEL_NAMES[i]));
      levelModel.setImage(Preferences.LEVEL_ICONS[i]);

      if(brains / 4 > 0) {
        levelModel.setBrains(4);
        brains -= 4;
      }
      else if (brains != 0){
        levelModel.setBrains(brains % 4);
        brains = 0;

      }

      levelModels.add(levelModel);
    }

    String totalBrains = getString(R.string.total_brains, "" + Preferences.TOTAL_BRAINS);
    totalBrainsTextView.setText(totalBrains);

    MyRecyclerAdapter adapter = new MyRecyclerAdapter(this, levelModels);
    recyclerView.setAdapter(adapter);

  }

  @Override
  public void onBackPressed() {
    moveTaskToBack(true);
  }

}
