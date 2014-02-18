package com.ghost.games.numberhero.activity;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.ghost.games.numberhero.dao.UserDAO;
import com.ghost.games.numberhero.model.User;
import com.ghost.games.numberhero.util.UserConfig;

public class LoginActivity extends Activity {
	 private Spinner nicknameSelect;  
	 private List<User> allItems;   
	 private ArrayAdapter<User> adapter;   
	 private static final String LOG="LoginActivity";
	 private UserDAO userDAO = new UserDAO(this);
	 private Button startgame;
	 private User currentUser;
	 private Button createNewUser;
	 private SharedPreferences pres;
	 private Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.login);
		initView();  
		Button button=(Button)findViewById(R.id.button1);
		button.setOnClickListener(buttonListener);
		 allItems = userDAO.getUserList();  
		 if (allItems.size()<=0) {
			   
			Intent intent=new Intent();
			intent.setClass(LoginActivity.this, CreateUserActivity.class);
			startActivity(intent);
		}
		 
		 adapter = new ArrayAdapter<User>(this,android.R.layout.simple_spinner_item, allItems);   
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);   
         nicknameSelect.setAdapter(adapter);
         if (pres.getInt(UserConfig.CURRENT_USER_POSITION, 0)>(nicknameSelect.getCount()-1)) {
        	nicknameSelect.setSelection(nicknameSelect.getCount()-1);
		}else {
			nicknameSelect.setSelection(pres.getInt(UserConfig.CURRENT_USER_POSITION, 0));
		}
         nicknameSelect.setPrompt("请选择一个可爱的昵称");
         nicknameSelect.setOnItemSelectedListener(spinnerOnClicklistener);
         startgame.setOnClickListener(buttonListener);
         createNewUser.setOnClickListener(buttonListener);
         
	}
	
	
	
	 @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		 if (keyCode == KeyEvent.KEYCODE_BACK) {
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 menu.add(0, 1, 1, "重新开始");
		 menu.add(0, 2, 2, "提示");
		 menu.add(0, 3, 3, "设置");
		 menu.add(0, 4, 4, "关于");
		 menu.add(0, 5, 5, "退出");
		 
		return true;
	}
	 



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Toast.makeText(this, item.getTitle(),Toast.LENGTH_SHORT).show();
		if (item.getItemId() == 5) {
			
		}
		
		return super.onOptionsItemSelected(item);
	}




	private OnClickListener buttonListener=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				Button btn=(Button)v;
				switch (btn.getId()) {
				case R.id.button1:
					userDAO.emptyAllUser();
					
					
					break;
				case R.id.startgame:
					
					editor.putInt(UserConfig.CURRENT_USER_ID , currentUser.getId());
					editor.commit();
					intent=new Intent();
					intent.setClass(LoginActivity.this, NumberHeroActivity.class);
					intent.putExtra("userid", currentUser.getId());
					startActivity(intent);
					break;
				case R.id.createNewUser:
					intent=new Intent();
					intent.setClass(LoginActivity.this, CreateUserActivity.class);
					startActivity(intent);
					break;
				}
				
			}
		}; 
		
		private OnItemSelectedListener spinnerOnClicklistener = new OnItemSelectedListener() {
			

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				/*TextView spinner=(TextView)view;
				Log.v(LOG,spinner.getText().toString());
				Log.v(LOG,new String(String.valueOf(id)));
				Log.v(LOG,new String(String.valueOf(position)));*/
				currentUser =(User)nicknameSelect.getSelectedItem();
				Log.v(LOG,new String(String.valueOf(currentUser.getId())));
				
				editor.putInt(UserConfig.CURRENT_USER_POSITION, position);
				editor.commit();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
			}
		};
		
		
	  private void initView() {   
		  nicknameSelect = (Spinner) findViewById(R.id.nicknameSelect); 
		  startgame=(Button)findViewById(R.id.startgame);
		  createNewUser=(Button)findViewById(R.id.createNewUser);
		  pres = LoginActivity.this.getSharedPreferences(UserConfig.CONFIG_NAME, Context.MODE_PRIVATE);
		  editor=pres.edit();
	  }  

}
