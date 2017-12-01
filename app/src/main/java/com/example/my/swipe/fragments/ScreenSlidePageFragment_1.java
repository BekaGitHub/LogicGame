package com.example.my.swipe.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.my.swipe.R;

/**
 * Created by EmpaT on 01.11.2017.
 */

public class ScreenSlidePageFragment_1 extends Fragment {

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    ViewGroup rootView = (ViewGroup) inflater.inflate(
        R.layout.fragment_screen_slide_page_1, container, false);

    return rootView;

  }
}
