package com.capacitypp.tuttimetable.debug;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by capacitypp on 11/22/16.
 */

public class ErrorDialog {
    private static Activity static_activity = null;

    public static void show(String text, Activity activity) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle("error message");
        dialog.setMessage(text);
        static_activity = activity;
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                static_activity.finish();
            }
        });
        dialog.setCancelable(false);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }
}
