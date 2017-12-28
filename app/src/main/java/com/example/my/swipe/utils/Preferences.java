package com.example.my.swipe.utils;

import android.graphics.Color;
import com.example.my.swipe.R;
import com.example.my.swipe.activities.level_1.InfoActivity_Level_1;
import com.example.my.swipe.activities.level_2.InfoActivity_Level_2;
import com.example.my.swipe.activities.level_3.InfoActivity_Level_3;
import com.example.my.swipe.activities.level_4.InfoActivity_Level_4;
import com.example.my.swipe.activities.level_5.InfoActivity_Level_5;
import com.example.my.swipe.activities.level_6.InfoActivity_Level_6;
import com.example.my.swipe.activities.level_7.InfoActivity_Level_7;
import com.example.my.swipe.activities.level_8.InfoActivity_Level_8;
import com.example.my.swipe.activities.level_9.InfoActivity_Level_9;

/**
 * Created by EmpaT on 02.11.2017.
 */

public class Preferences {

  public static final String POSITION = "position";
  public static final String EXERCISE_DONE = "levelDone";
  public static final String EXERCISE = "exerciseExplanationTextView";
  public static final String SYMBOL = "symbol";
  public static final String SMILE = "smile";
  public static final String FROM = "from";
  public static final String LEVEL = "level";
  public static final String ETAGE = "etage";
  public static final String AUFGABE_BESCHREIBUNG = "aufgabeBeschreibung";
  public static final String IMAGE = "image";

  public static final String ERSTE = "erste";
  public static final String ZWEITE = "zweite";
  public static final String DRITTE = "dritte";
  public static final String VIERTE = "vierte";
  public static final String FUENFTE = "fuenfte";
  public static final String SECHSTE = "sechste";

  public static final String FIGURE_1 = "figure1";
  public static final String FIGURE_2 = "figure2";

  public static final String TIME_PASSED = "timePassed";
  public static final String TIME_PASSED_FROM_LAST_EXERCISE =
      "timePassedFromLastExercise";
  public static final String[] SYMBOLS = {"+", ":)", "<", "u"};
  public static final int[] LEVEL_NAMES = {R.string.level_1_titel,
      R.string.level_2_titel, R.string.level_3_titel,
      R.string.level_4_titel, R.string.level_5_titel, R.string.level_5_titel,
      R.string.level_7_titel, R.string.level_8_titel, R.string.level_9_titel};
  public static final int[] LEVEL_ICONS = {R.drawable.level_1_icon,
      R.drawable.level_2_icon, R.drawable.level_3_icon,
      R.drawable.level_4_icon, R.drawable.level_5_icon,
      R.drawable.level_6_icon, R.drawable.level_7_icon,
      R.drawable.level_8_icon, R.drawable.level_9_icon

  };
  public static final Class[] INFO_ACTIVITIES = {
      InfoActivity_Level_1.class,
      InfoActivity_Level_2.class,
      InfoActivity_Level_3.class,
      InfoActivity_Level_4.class,
      InfoActivity_Level_5.class,
      InfoActivity_Level_6.class,
      InfoActivity_Level_7.class,
      InfoActivity_Level_8.class,
      InfoActivity_Level_9.class
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

  public static final int LEVEL_7a_EXERCISE_TIME_IN_SECONDS = 15;
  public static final int LEVEL_7b_EXERCISE_TIME_IN_SECONDS = 30;
  public static final int LEVEL_7c_EXERCISE_TIME_IN_SECONDS = 60;
  public static final int LEVEL_7j_EXERCISE_TIME_IN_SECONDS = 60;
  public static final int LEVEL_7_TOTAL_TIME_IN_SECONDS =
          LEVEL_7a_EXERCISE_TIME_IN_SECONDS +
          LEVEL_7b_EXERCISE_TIME_IN_SECONDS +
          LEVEL_7c_EXERCISE_TIME_IN_SECONDS +
          LEVEL_7j_EXERCISE_TIME_IN_SECONDS;

  public static final int LEVEL_8a_EXERCISE_TIME_IN_SECONDS = 45;
  public static final int LEVEL_8b_EXERCISE_TIME_IN_SECONDS = 45;
  public static final int LEVEL_8c_EXERCISE_TIME_IN_SECONDS = 45;
  public static final int LEVEL_8d_EXERCISE_TIME_IN_SECONDS = 120;
  public static final int LEVEL_8_TOTAL_TIME_IN_SECONDS =
          LEVEL_8a_EXERCISE_TIME_IN_SECONDS +
                  LEVEL_8b_EXERCISE_TIME_IN_SECONDS +
                  LEVEL_8c_EXERCISE_TIME_IN_SECONDS +
                  LEVEL_8d_EXERCISE_TIME_IN_SECONDS;


  public static int TOTAL_BRAINS = 10;
  public static int LEVEL_TIME_SPENT = 0;
  public static int LEVEL_COUNTER = 1;
  public static int EXERCISE_COUNTER = 1;


  public static final String POINTS_PREF = "pointsPreference";
  public static final String LEVEL_1_POINTS = "level_1_Points";
  public static final String LEVEL_2_POINTS = "level_2_Points";
  public static final String LEVEL_3_POINTS = "level_3_Points";
  public static final String LEVEL_4_POINTS = "level_4_Points";
  public static final String LEVEL_5_POINTS = "level_5_Points";
  public static final String LEVEL_6_POINTS = "level_6_Points";
  public static final String LEVEL_7_POINTS = "level_7_Points";
  public static final String LEVEL_8_POINTS = "level_8_Points";
  public static final String LEVEL_9_POINTS = "level_9_Points";
  public static final String LEVEL_10_POINTS = "level_10_Points";
  public static final String LEVEL_11_POINTS = "level_11_Points";
  public static final String LEVEL_12_POINTS = "level_12_Points";
  public static final String LEVEL_13_POINTS = "level_13_Points";
  public static final String LEVEL_14_POINTS = "level_14_Points";
  public static final String LEVEL_15_POINTS = "level_15_Points";
  public static final String LEVEL_16_POINTS = "level_16_Points";
  public static final String LEVEL_17_POINTS = "level_17_Points";
  public static final String LEVEL_18_POINTS = "level_18_Points";
  public static final String LEVEL_19_POINTS = "level_19_Points";
  public static final String LEVEL_20_POINTS = "level_20_Points";
  public static final String LEVEL_21_POINTS = "level_21_Points";
  public static final String LEVEL_22_POINTS = "level_22_Points";
}
