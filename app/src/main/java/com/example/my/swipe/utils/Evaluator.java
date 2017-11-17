package com.example.my.swipe.utils;

/**
 * Created by EmpaT on 17.11.2017.
 */

public class Evaluator
{
    private Evaluator()
    {
    }

    public static int evaluate(int totalTimeInSeconds, int passedTimeInSeconds)
    {
        int prozent = (passedTimeInSeconds/totalTimeInSeconds) * 100;
        if (prozent <= 25)
            return 4;
        else if (prozent <= 50 && prozent > 25)
            return 3;
        else if (prozent <= 75 && prozent > 50)
            return 2;
        else if (prozent < 100 && prozent > 75)
            return 1;

        return 0;
    }
}
