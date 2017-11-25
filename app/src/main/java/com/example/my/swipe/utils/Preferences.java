package com.example.my.swipe.utils;

import com.example.my.swipe.activities.level_1.InfoActivity_Level_1;
import com.example.my.swipe.activities.level_2.InfoActivity_Level_2;
import com.example.my.swipe.activities.level_3.InfoActivity_Level_3;
import com.example.my.swipe.activities.level_4.InfoActivity_Level_4;

/**
 * Created by EmpaT on 02.11.2017.
 */

public class Preferences {
    public static final String POSITION = "position";
    public static final String GRATULATION = "gratulation";
    public static final String EXERCISE = "exercise";
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
    public static final String PREF_MIND_NUMBER_LEVEL_1 = "prefMindNumberLevel1";

    public static int TOTAL_MIND_NUMBER = 10;
    public static int LEVEL_1_MIND_NUMBER = 0;
    public static int LEVEL_TIME_SPENT = 0;

    public static final String TIME_PASSED = "timePassed";
    public static final String TIME_PASSED_FROM_LAST_EXERCISE =
            "timePassedFromLastExercise";

    public static final String[] SYMBOLS = {"+", ":)", "<", "u"};
    public static final Class[] INFO_ACTIVITIES = {
            InfoActivity_Level_1.class,
            InfoActivity_Level_2.class,
            InfoActivity_Level_3.class,
            InfoActivity_Level_4.class
    };

    public static final String CLASS = "class";
    public static final String BUNDLE = "bundle";
    public static final String BUNDLE_FROM_INFO_ACTIVITY =
            "bundleFromInfoActivity";

    public static int LEVEL_COUNTER = 1;
    public static int EXERCISE_COUNTER = 1;

    public static final String EXERCISE_INFO = "exerciseInfo";

    public static final String LEVEL_POINT = "levelPoint";
    private static final int LEVEL_1_EXERCISE_TIME_IN_SECONDS = 30;
    private static final int LEVEL_2_EXERCISE_TIME_IN_SECONDS = 90;
    private static final int LEVEL_3_EXERCISE_TIME_IN_SECONDS = 10;
    public static final int LEVEL_4_EXERCISE_TIME_IN_SECONDS = 45;
    public static final int LEVEL_1_TOTAL_TIME_IN_SECONDS =
            LEVEL_1_EXERCISE_TIME_IN_SECONDS * 4;
    public static final int LEVEL_2_TOTAL_TIME_IN_SECONDS =
            LEVEL_2_EXERCISE_TIME_IN_SECONDS * 3;
    public static final int LEVEL_3_TOTAL_TIME_IN_SECONDS =
            LEVEL_3_EXERCISE_TIME_IN_SECONDS * 3;
    public static final int LEVEL_4_TOTAL_TIME_IN_SECONDS =
            LEVEL_4_EXERCISE_TIME_IN_SECONDS * 4;

}
