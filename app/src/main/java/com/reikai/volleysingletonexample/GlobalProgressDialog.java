package com.reikai.volleysingletonexample;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ProgressBar;

public class GlobalProgressDialog {
   public static ProgressDialog showProgressDialog(Context context, String message) {
       ProgressDialog mDialog = new ProgressDialog(context);
       mDialog.setMessage(message);
       mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
       mDialog.setCancelable(false);
       mDialog.show();
       return mDialog;
   }
}
