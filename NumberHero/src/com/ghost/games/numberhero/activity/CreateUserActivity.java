package com.ghost.games.numberhero.activity;

import com.ghost.games.numberhero.dao.UserDAO;
import com.ghost.games.numberhero.menu.MenuConstant;
import com.ghost.games.numberhero.menu.NumberHeroMenuManager;
import com.ghost.games.numberhero.util.MyApplication;
import com.ghost.games.numberhero.util.UserConfig;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CreateUserActivity extends Activity {
	
	private Button addUserButton;
	private Button selectExistUserButton;
	private TextView usernameView;
	private UserDAO userDAO = new UserDAO(this);
	private SharedPreferences pres;
	private Editor editor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		MyApplication.getInstance().addActivity(this);
		setContentView(R.layout.adduser);
		initView();
		addUserButton.setOnClickListener(buttonListener);
		selectExistUserButton.setOnClickListener(buttonListener);
		if (userDAO.getUserList().size()>0) {
			
			selectExistUserButton.setVisibility(View.VISIBLE);
		}else {
			selectExistUserButton.setVisibility(View.GONE);
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		NumberHeroMenuManager.filterMenu(menu, MenuConstant.PROMPT_GROUP,MenuConstant.RESTART);
		return true;
	}
	 



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		NumberHeroMenuManager.launchMenu(item,this);
		
		return super.onOptionsItemSelected(item);
	}
	 private OnClickListener buttonListener=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Button btn=(Button)v;
				switch (btn.getId()) {
				case R.id.button1:
					String name="";
					if (null!=usernameView.getText() && !"".equals(usernameView.getText().toString())) {
						name=usernameView.getText().toString();
						userDAO.addUser(name);
						editor.putInt(UserConfig.CURRENT_USER_POSITION, userDAO.getUserList().size()-1);
						editor.commit();
						Intent intent=new Intent();
						intent.putExtra("username", name);
						intent.setClass(CreateUserActivity.this, LoginActivity.class);
						startActivity(intent);
						
					}else {
						 Toast.makeText(CreateUserActivity.this, "亲~用户名不可以为空哦", Toast.LENGTH_LONG).show();
					}
					
					break;
				case R.id.selectExistUser:
					Intent intent=new Intent();
					intent.setClass(CreateUserActivity.this, LoginActivity.class);
					startActivity(intent);
					break;
				
				}
			}
		}; 
	public boolean onKeyDown(int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
			 if (keyCode == KeyEvent.KEYCODE_BACK) {
				return false;
			}
			return super.onKeyDown(keyCode, event);
	}
	 private void initView() {   
		 addUserButton=(Button)findViewById(R.id.button1); 
		 usernameView=(TextView)findViewById(R.id.editText1); 
		 pres = CreateUserActivity.this.getSharedPreferences(UserConfig.CONFIG_NAME, Context.MODE_PRIVATE);
		 editor=pres.edit();
		 selectExistUserButton=(Button)findViewById(R.id.selectExistUser);
	  }  
}
