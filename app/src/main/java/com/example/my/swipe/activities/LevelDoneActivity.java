package com.example.my.swipe.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.utils.Preferences;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class LevelDoneActivity extends AppCompatActivity {

  Bundle bundle;
  private List<ImageView> imageViews;
  private int fadedImageCounter = 0;
  private int levelMindCounter = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_done);

    imageViews = new ArrayList<>();
    bundle = getIntent().getBundleExtra(Preferences.BUNDLE);
    levelMindCounter = bundle.getInt(Preferences.LEVEL_POINT, 0);

    ImageView done_image_1 = (ImageView) findViewById(R.id.done_image_1);
    ImageView done_image_2 = (ImageView) findViewById(R.id.done_image_2);
    ImageView done_image_3 = (ImageView) findViewById(R.id.done_image_3);
    ImageView done_image_4 = (ImageView) findViewById(R.id.done_image_4);
    final TextView mind_number = (TextView) findViewById(R.id.mind_number);

    imageViews.add(done_image_1);
    imageViews.add(done_image_2);
    imageViews.add(done_image_3);
    imageViews.add(done_image_4);

    Timer myTimer = new Timer();
    myTimer.schedule(new TimerTask() {
      @Override
      public void run() {
        //Views kann nur in UiThread aktualisiert werden
        runOnUiThread(new Runnable() {
          @Override
          public void run() {
            fadeImage(imageViews.get(fadedImageCounter));
            fadedImageCounter++;
            mind_number.setText("+" + fadedImageCounter);
            if (fadedImageCounter >= levelMindCounter) {
              cancel();
            }
          }
        });
      }
    }, 700, 700);

  }

  private void fadeImage(ImageView imageView) {
    Animation animation =
        AnimationUtils.loadAnimation(this,
            R.anim.fade);
    imageView.setImageResource(R.mipmap.enabled_mind);
    imageView.startAnimation(animation);
  }

  public void handleNextButton(View view) {
    Class nextActivity = (Class) bundle.getSerializable(Preferences.NEXT_LEVEL);
    Intent intent = new Intent(this, nextActivity);
    Bundle bundle = new Bundle();
    intent.putExtra(Preferences.BUNDLE, bundle);
    startActivity(intent);
  }
}
