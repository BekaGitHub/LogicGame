package com.example.my.swipe.fragments;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.my.swipe.MainActivity;
import com.example.my.swipe.R;
import com.example.my.swipe.utils.ExerciseTimer;
import com.example.my.swipe.utils.Preferences;

/**
 * Created by EmpaT on 03.11.2017.
 */

public class BackDialog extends DialogFragment {

    private ExerciseTimer exerciseTimer;

    public BackDialog() {

    }

    public ExerciseTimer getExerciseTimer() {
        return exerciseTimer;
    }

    public void setExerciseTimer(ExerciseTimer exerciseTimer) {
        this.exerciseTimer = exerciseTimer;
    }

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        android.app.Dialog d = super.onCreateDialog(savedInstanceState);
        d.setTitle("dialog");
        return d;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View dialogView = View.inflate(getActivity(), R.layout.dialog_layout, container);

        Button play = (Button) dialogView.findViewById(R.id.play);
        Button main = (Button) dialogView.findViewById(R.id.main_menu);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exerciseTimer.resume();
                dismiss();
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
        return dialogView;
    }
}
