package com.ghost.games.numberhero.menu;

import static com.ghost.games.numberhero.menu.MenuConstant.*;

import com.ghost.games.numberhero.activity.LoginActivity;
import com.ghost.games.numberhero.activity.NumberHeroActivity;
import com.ghost.games.numberhero.dialog.DialogManager;
import com.ghost.games.numberhero.util.MyApplication;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class NumberHeroMenuManager {
	public static void filterMenu(Menu menu,int...groupid){
		 menu.add(RESTART_GROUP, RESTART, 1, RESTART_TEXT);
		 menu.add(PROMPT_GROUP, PROMPT, 2, PROMPT_TEXT);
		 menu.add(3, 3, 3, "设置");
		 menu.add(ABOUT_GROUP, ABOUT, 4, ABOUT_TEXT);
		 menu.add(INDEX_GROUP, INDEX, 5, INDEX_TEXT);
		 menu.add(EXIT_GROUP, EXIT, 6, EXIT_TEXT);
		for (int i : groupid) {
			menu.setGroupVisible(i, false);
		}
	}
	
	public static void exitProcess(){
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(0);
	}
	
	public static void launchMenu(MenuItem item){
		if (item != null) {
			switch (item.getItemId()) {
			case ABOUT:
				break;
			}
		}
	}
	
	public static void launchMenu(MenuItem item,Activity activity){
		launchMenu(item);
		Intent intent=new Intent();
		if (activity!=null && item != null) {
			switch (item.getItemId()) {
			case RESTART:
				intent.setClass(activity, NumberHeroActivity.class);
				activity.startActivity(intent);
				break;
			case INDEX:
				intent.setClass(activity, LoginActivity.class);
				activity.startActivity(intent);
				break;
			case ABOUT:
				PackageManager manager = activity.getPackageManager();
				PackageInfo info;
				try {
					info = manager.getPackageInfo(activity.getPackageName(), 0);
					String version = info.versionName;
					Toast.makeText(activity, "版本号:" + version + "\n作者:幽灵小子",Toast.LENGTH_SHORT).show();
				} catch (NameNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Toast.makeText(activity, "未找到版本号",Toast.LENGTH_SHORT).show();
				}

				break;
			case EXIT:
				DialogManager.openExitDialog(activity);
				break;
			}
		}
	}
	public static void launchMenu(MenuItem item,Activity activity,Object result){
		launchMenu(item,activity);
		if (activity!=null && item!=null) {
			switch (item.getItemId()) {
			case PROMPT:
				Toast.makeText(activity, result.toString(),Toast.LENGTH_SHORT).show();
				break;
			}
		}
	}
}
