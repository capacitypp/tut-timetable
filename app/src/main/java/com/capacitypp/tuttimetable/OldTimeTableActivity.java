package com.capacitypp.tuttimetable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

public class OldTimeTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_time_table);

        ViewGroup vg = (ViewGroup)findViewById(R.id.activity_old_time_table);
        for (int i = 1; i <= 6; i++) {
            TableRow tr = (TableRow)vg.getChildAt(i);
            String str = Integer.toString(i) + "限";
            ((TextView)tr.getChildAt(0)).setText(str);
        }
    }
}
