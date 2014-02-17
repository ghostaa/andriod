package com.ghost.games.numberhero.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.ghost.games.numberhero.dao.UserDAO;
import com.ghost.games.numberhero.model.User;

public class LoginActivity extends Activity {
	 private Spinner nicknameSelect;  
	 private List<User> allItems;   
	 private ArrayAdapter<User> adapter;   
	 private static final String LOG="LoginActivity";
	 private UserDAO userDAO = new UserDAO(this);;
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
         nicknameSelect.setPrompt("请选择一个可爱的昵称");
         nicknameSelect.setOnItemSelectedListener(spinnerOnClicklistener);
	}
	 private OnClickListener buttonListener=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Button btn=(Button)v;
				switch (btn.getId()) {
				case R.id.button1:
					userDAO.emptyAllUser();
					
					
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
				User user =(User)nicknameSelect.getSelectedItem();
				Log.v(LOG,new String(String.valueOf(user.getId())));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
			}
		};
	  private void initView() {   
		  nicknameSelect = (Spinner) findViewById(R.id.nicknameSelect);   
	  }  

}
