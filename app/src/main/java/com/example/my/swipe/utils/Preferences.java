package com.example.my.swipe.utils;

import android.graphics.Color;
import com.example.my.swipe.R;
import com.example.my.swipe.activities.level_1.InfoActivity_Level_1;
import com.example.my.swipe.activities.level_2.InfoActivity_Level_2;
import com.example.my.swipe.activities.level_3.InfoActivity_Level_3;
import com.example.my.swipe.activities.level_4.InfoActivity_Level_4;
import com.example.my.swipe.activities.level_5.InfoActivity_Level_5;

/**
 * Created by EmpaT on 02.11.2017.
 */

public class Preferences {

  public static final String POSITION = "position";
  public static final String LEVEL_DONE = "levelDone";
  public static final String EXERCISE = "exerciseExplanationTextView";
  public static final String SYMBOL = "symbol";
  public static final String SMILE = "smile";
  public static final String FROM = "from";
  public static final String LEVEL = "level";
  public static final String ETAGE = "etage";

  public static final String ERSTE = "erste";
  public static final String ZWEITE = "zweite";
  public static final String DRITTE = "dritte";
  public static final String VIERTE = "vierte";
  public static final String FUENFTE = "fuenfte";
  public static final String SECHSTE = "sechste";

  public static final String FIGURE_1 = "figure1";
  public static final String FIGURE_2 = "figure2";

  public static final String PREFS = "preference";
  public static final String TIME_PASSED = "timePassed";
  public static final String TIME_PASSED_FROM_LAST_EXERCISE =
      "timePassedFromLastExercise";
  public static final String[] SYMBOLS = {"+", ":)", "<", "u", "d", "d", "ds", "sd"};
  public static final int[] LEVEL_NAMES = {R.string.level_1_titel,
      R.string.level_2_titel, R.string.level_3_titel,
      R.string.level_4_titel, R.string.level_5_titel};
  public static final int[] LEVEL_ICONS = {R.drawable.level_1_icon,
      R.drawable.level_2_icon, R.drawable.level_3_icon,
      R.drawable.level_4_icon, R.drawable.level_5_icon

  };
  public static final Class[] INFO_ACTIVITIES = {
      InfoActivity_Level_1.class,
      InfoActivity_Level_2.class,
      InfoActivity_Level_3.class,
      InfoActivity_Level_4.class,
      InfoActivity_Level_5.class
  };
  public static final String CLASS = "class";
  public static final String BUNDLE = "bundle";
  public static final String BUNDLE_FROM_INFO_ACTIVITY =
      "bundleFromInfoActivity";

  public static final String EXERCISE_INFO = "exerciseExplanation";
  public static final int[] COLOR_NAMES = {R.string.red, R.string.green,
      R.string.black, R.string.yellow,
      R.string.blue, R.string.magenta};
  public static final int[] COLORS = {Color.RED, Color.GREEN,
      Color.BLACK, Color.YELLOW, Color.BLUE,
      Color.MAGENTA};
  public static final String LEVEL_POINT = "levelPoint";

  public static final int LEVEL_1_EXERCISE_TIME_IN_SECONDS = 30;
  public static final int LEVEL_1_TOTAL_TIME_IN_SECONDS =
      LEVEL_1_EXERCISE_TIME_IN_SECONDS * 4;

  public static final int LEVEL_2_EXERCISE_TIME_IN_SECONDS = 90;
  public static final int LEVEL_2_TOTAL_TIME_IN_SECONDS =
      LEVEL_2_EXERCISE_TIME_IN_SECONDS * 3;

  public static final int LEVEL_3_EXERCISE_TIME_IN_SECONDS = 10;
  public static final int LEVEL_3_TOTAL_TIME_IN_SECONDS =
      LEVEL_3_EXERCISE_TIME_IN_SECONDS * 3;

  public static final int LEVEL_4_EXERCISE_TIME_IN_SECONDS = 45;
  public static final int LEVEL_4_TOTAL_TIME_IN_SECONDS =
          LEVEL_4_EXERCISE_TIME_IN_SECONDS * 4;

  public static final int LEVEL_5_TOTAL_TIME_IN_SECONDS = 25;
  public static final String NEXT_LEVEL = "nextLevel";

  public static int TOTAL_BRAINS = 10;
  public static int LEVEL_TIME_SPENT = 0;
  public static int LEVEL_COUNTER = 1;
  public static int EXERCISE_COUNTER = 1;

}
