package com.example.my.swipe.fragments;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.MainActivity;
import com.example.my.swipe.activities.level_1.InfoActivity_Level_1;
import com.example.my.swipe.activities.level_2.InfoActivity_Level_2;
import com.example.my.swipe.utils.Preferences;
import com.example.my.swipe.utils.Level;

/**
 * Created by EmpaT on 03.11.2017.
 */

public class DialogFailure extends DialogFragment {

    private int levelNumber = -1;
    private String symbol = "";
    private int etage = -1;
    private Level level;

    public DialogFailure() {

    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        android.app.Dialog d = super.onCreateDialog(savedInstanceState);
        d.setTitle("dialog");
        return d;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View dialogView = View.inflate(getActivity(), R.layout.dialog_failure_layout, container);

        Button restart = (Button) dialogView.findViewById(R.id.restart);
        Button main = (Button) dialogView.findViewById(R.id.main_menu);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), switchLevel(level));

                if (levelNumber != -1)
                    intent.putExtra(Preferences.LEVEL, levelNumber);
                if (!symbol.equals(""))
                    intent.putExtra(Preferences.SYMBOL, symbol);
                if (etage != -1)
                    intent.putExtra(Preferences.ETAGE, etage);

                intent.putExtra(Preferences.EXERCISE, 1);
                startActivity(intent);
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                Preferences.EXERCISE_COUNTER = 1;
                startActivity(intent);
            }
        });
        return  dialogView;
    }

    private Class switchLevel(Level level)
    {
        switch (level)
        {
            case EINS:
                levelNumber = 1;
                symbol = "+";
                return InfoActivity_Level_1.class;
            case ZWEI:
                levelNumber = 2;
                etage = R.string.second;
                return InfoActivity_Level_2.class;
        }

        return null;
    }
}
