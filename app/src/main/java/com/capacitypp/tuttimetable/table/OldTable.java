package com.capacitypp.tuttimetable.table;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.capacitypp.tuttimetable.debug.ErrorDialog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by capacitypp on 11/22/16.
 */

public class OldTable {
    private OldClass[][] table;

    public OldTable() {
        allocate();
    }

    public OldTable(String fileName, Activity activity) throws FileNotFoundException {
        this();
        FileInputStream fis = activity.openFileInput(fileName);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        try {
            for (int i = 0; i < table.length; i++) {
                OldClass[] row = table[i];
                for (int j = 0; j < row.length; j++) {
                    OldClass _class = row[j];
                    _class.setTitle(in.readLine());
                    _class.setTeacher(in.readLine());
                    _class.setPlace(in.readLine());
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            ErrorDialog.show("時間割の読み込みに失敗しました", activity);
        }
    }

    public void write(Activity activity) {
        FileOutputStream fos = null;
        try {
            fos = activity.openFileOutput("table.txt", 0);
        } catch (FileNotFoundException e) {
            ErrorDialog.show("時間割ファイルのOpenに失敗しました", activity);
        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

        try {
            for (int i = 0; i < table.length; i++) {
                OldClass[] row = table[i];
                for (int j = 0; j < row.length; j++) {
                    OldClass _class = row[j];
                    out.write(_class.getTitle() + "\n");
                    out.write(_class.getTeacher() + "\n");
                    out.write(_class.getPlace() + "\n");
                }
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            ErrorDialog.show("時間割の書き込みに失敗しました", activity);
        }
    }

    public void allocate() {
        table = new OldClass[6][5];
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++)
                table[i][j] = new OldClass();
    }

    public OldClass[][] getTable() {
        return table;
    }

    public void setTable(OldClass[][] table) {
        this.table = table;
    }
}
