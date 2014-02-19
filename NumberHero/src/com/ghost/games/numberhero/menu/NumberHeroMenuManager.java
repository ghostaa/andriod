package com.ghost.games.numberhero.menu;

import static com.ghost.games.numberhero.menu.MenuConstant.*;

import com.ghost.games.numberhero.activity.LoginActivity;
import com.ghost.games.numberhero.activity.NumberHeroActivity;
import com.ghost.games.numberhero.util.MyApplication;


import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class NumberHeroMenuManager {
	public static void filterMenu(Menu menu,int...groupid){
		 menu.add(RESTART_GROUP, RESTART, 1, RESTART_TEXT);
		 menu.add(PROMPT_GROUP, PROMPT, 2, PROMPT_TEXT);
		 menu.add(3, 3, 3, "设置");
		 menu.add(ABOUT_GROUP, ABOUT, 4, ABOUT_TEXT);
		 menu.add(EXIT_GROUP, EXIT, 5, EXIT_TEXT);
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
		if (activity!=null && item != null) {
			switch (item.getItemId()) {
			case RESTART:
				Intent intent=new Intent();
				intent.setClass(activity, NumberHeroActivity.class);
				activity.startActivity(intent);
				break;
			case ABOUT:
				Toast.makeText(activity, "版本号 1.0.4.140219",Toast.LENGTH_SHORT).show();
				break;
			case EXIT:
				MyApplication.getInstance().exit();
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
