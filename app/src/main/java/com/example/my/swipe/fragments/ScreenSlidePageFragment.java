package com.example.my.swipe.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.model.Image;
import com.example.my.swipe.utils.Preferences;

/**
 * Created by EmpaT on 01.11.2017.
 */

public class ScreenSlidePageFragment extends Fragment {

  @Nullable
  @Override
  public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    ViewGroup rootView = (ViewGroup) inflater.inflate(
        R.layout.fragment_screen_slide_page, container, false);

    ImageView displayImageView = (ImageView) rootView
        .findViewById(R.id.display_image_view);
    TextView totalMindsNumberTextView = (TextView) rootView.findViewById(R.id.total_mind_number);
    SharedPreferences prefs = getActivity()
        .getSharedPreferences(Preferences.PREFS, Context.MODE_PRIVATE);
    int a = prefs.getInt("name", -1);
    totalMindsNumberTextView.setText("" + a);
    //Bundle wird aus ScreenSlidePagerActivity geliefert
    Bundle bundle = getArguments();
    int position = bundle.getInt(Preferences.POSITION);

    if (Image.IMAGES.length <= position) {
      position = position - 1;
    }

    displayImageView.setImageResource(Image.IMAGES[position]);

    final int fragmentPosition = position;
    displayImageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Bundle defaultBundle = new Bundle();
        defaultBundle.putInt(Preferences.LEVEL,
            Preferences.LEVEL_COUNTER + fragmentPosition);
        defaultBundle.putInt(Preferences.EXERCISE,
            Preferences.EXERCISE_COUNTER);

        Class infoActivityClass = Preferences.INFO_ACTIVITIES[fragmentPosition];

        Intent intent = new Intent(getActivity(), infoActivityClass);
        intent.putExtra(Preferences.BUNDLE, defaultBundle);
        startActivity(intent);
      }
    });
    return rootView;

  }
}
