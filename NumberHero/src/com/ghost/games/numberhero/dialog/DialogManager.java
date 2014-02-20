package com.ghost.games.numberhero.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.ghost.games.numberhero.util.MyApplication;

public class DialogManager {
	public static void openExitDialog(Activity activity) {
		// TODO Auto-generated method stub
		
		AlertDialog.Builder builder= new AlertDialog.Builder(activity);
		builder.setTitle("数字英雄").setMessage("是否要退出数字英雄");
		builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				MyApplication.getInstance().exit();
			}
		});
		builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				dialog.cancel();
			}
		});
		builder.create().show();
	}
}
