package com.capacitypp.tuttimetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.capacitypp.tuttimetable.table.OldClass;
import com.capacitypp.tuttimetable.table.OldTable;

import java.io.FileNotFoundException;

public class OldTimeTableActivity extends AppCompatActivity implements View.OnClickListener{
    private OldTable table;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.action_settings:
                intent = new Intent(getApplication(), SettingsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

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

        for (int i = 1; i <= 6; i++) {
            TableRow tr = (TableRow)vg.getChildAt(i);
            for (int j = 1; j <= 5; j++) {
                View v = tr.getChildAt(j);
                v.setClickable(true);
                v.setOnClickListener(this);
                v.setId(i * 10 + j);
            }
        }

        try {
            table = new OldTable("table.txt", this);
        } catch (FileNotFoundException e) {
            table = new OldTable();
            table.getTable()[0][0].setTitle("title");
            table.getTable()[0][0].setPlace("place");
            table.write(this);
        }

        setClassView();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        int i = id / 10 - 1;
        int j = (id % 10) - 1;
        Toast.makeText(this, "(" + i + ", " + j + ")", Toast.LENGTH_SHORT).show();
    }

    public void setClassView() {
        OldClass[][] classTable = table.getTable();
        for (int i = 0; i < classTable.length; i++) {
            OldClass[] row = classTable[i];
            for (int j = 0; j < row.length; j++) {
                OldClass _class = row[j];
                setClassView(i, j, _class);
            }
        }
    }

    private void setClassView(int i, int j, OldClass _class) {
        TableLayout tl = (TableLayout)findViewById(R.id.activity_old_time_table);
        TableRow tr = (TableRow)tl.getChildAt(i + 1);
        LinearLayout ll = (LinearLayout)tr.getChildAt(j + 1);
        TextView textView1 = (TextView)ll.getChildAt(0);
        TextView textView2 = (TextView)ll.getChildAt(1);
        textView1.setText(_class.getTitle());
        textView2.setText(_class.getPlace());
    }
}
