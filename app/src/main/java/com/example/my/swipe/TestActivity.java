package com.example.my.swipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class TestActivity extends AppCompatActivity {
    TableRow tr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TableLayout tableLayout = (TableLayout) findViewById(R.id.table_layout);

        int i = 0;
        while (i < 15) {
            if (i % 3 == 0) {
                tr = new TableRow(this);
                tableLayout.addView(tr);
            }
            Button btn = new Button(this);
            btn.setText(i + "");
            btn.setId(i);
            tr.addView(btn);
            i++;
        }
    }
}
