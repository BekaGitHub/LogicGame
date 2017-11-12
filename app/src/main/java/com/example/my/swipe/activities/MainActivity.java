package com.example.my.swipe.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.my.swipe.R;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UUID uuid = UUID.randomUUID();
        ID = uuid.toString();

        Button button = (Button) findViewById(R.id.test);

        //TESTING///////////////
        Button testButton = (Button) findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LevelDoneActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScreenSlidePagerActivity.class);
                startActivity(intent);
            }
        });



    }

    public static String getID() {
        return ID;
    }
}
