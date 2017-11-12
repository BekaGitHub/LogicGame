package com.example.my.swipe.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.my.swipe.R;
import com.example.my.swipe.activities.level_1.InfoActivity_Level_1;
import com.example.my.swipe.activities.level_2.InfoActivity_Level_2;
import com.example.my.swipe.model.Image;
import com.example.my.swipe.model.Preferences;

/**
 * Created by EmpaT on 01.11.2017.
 */

public class ScreenSlidePageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        ImageView displayImageView = (ImageView) rootView
                .findViewById(R.id.display_image_view);

        //Bundle wird aus ScreenSlidePagerActivity geliefert
        Bundle bundle = getArguments();
        int position = bundle.getInt(Preferences.POSITION);

        if (Image.IMAGES.length <= position)
            position = position - 1;

        displayImageView.setImageResource(Image.IMAGES[position]);

        final int fragmentPosition = position;
        displayImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                switch (fragmentPosition)
                {
                    case 0:
                        intent = new Intent(getActivity(), InfoActivity_Level_1.class);
                        intent.putExtra(Preferences.SYMBOL, Preferences.SYMBOLS[0]);
                        break;
                    case 1:
                        intent = new Intent(getActivity(), InfoActivity_Level_2.class);
                        intent.putExtra(Preferences.ETAGE, R.string.second);
                }
                intent.putExtra(Preferences.LEVEL,
                        Preferences.LEVEL_COUNTER + fragmentPosition);
                intent.putExtra(Preferences.EXERCISE, Preferences.EXERCISE_COUNTER);
                startActivity(intent);
            }
        });
        return rootView;

    }
}
