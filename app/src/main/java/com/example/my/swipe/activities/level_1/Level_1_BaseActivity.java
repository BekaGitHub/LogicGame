package com.example.my.swipe.activities.level_1;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.BaseActivity;
import com.example.my.swipe.style.MyBounceInterpolator;
import com.example.my.swipe.style.SquareButton;
import com.example.my.swipe.utils.ExerciseTimer;

import java.util.ArrayList;
import java.util.Random;

public abstract class Level_1_BaseActivity extends BaseActivity
        implements View.OnClickListener{

    protected TableRow tableRow;
    protected TableLayout tableLayout;
    protected ArrayList<Button> buttons;

    protected int targetPosition;
    protected static String targetSymbol;
    protected static String otherSymbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buttons = new ArrayList<>();
    }

    protected Button createButton(String text) {

        DisplayMetrics dm = getResources().getDisplayMetrics();
        float dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, dm);

        SquareButton button = new SquareButton(this, (int)dpInPx, (int)dpInPx);
        button.setAllCaps(false);
        button.setText(text);
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        button.setTextColor(ContextCompat.getColor(this, R.color.button_text_color));
        button.setBackgroundResource(R.drawable.buttonshape);

        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
        layoutParams.setMargins(7, 7, 7, 7);
        button.setLayoutParams(layoutParams);

        return button;
    }

    @Override
    protected void failed(Button clickedButton)
    {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.4, 50);
        myAnim.setInterpolator(interpolator);

        for (Button button : buttons)
        {
            button.startAnimation(myAnim);
        }
        buttons.get(targetPosition).setTextColor(Color.GREEN);

        super.failed(clickedButton);
    }

    protected void createTable(int buttonNumber, int columnNumer)
    {
        Random random = new Random();
        int randomNumber = random.nextInt(buttonNumber);
        int i = 0;
        while (i < buttonNumber) {
            if (i % columnNumer == 0) {
                tableRow = new TableRow(this);
                tableRow.setGravity(Gravity.CENTER);
                tableLayout.addView(tableRow);
            }
            Button btn;
            if(i == randomNumber) {
                btn = createButton(targetSymbol);
                targetPosition = randomNumber;
            } else {
                btn = createButton(otherSymbol);
            }
            buttons.add(btn);
            btn.setOnClickListener(this);
            tableRow.addView(btn);
            i++;
        }
    }
}
