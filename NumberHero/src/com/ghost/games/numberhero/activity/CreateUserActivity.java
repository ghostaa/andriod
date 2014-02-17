package com.ghost.games.numberhero.activity;

import com.ghost.games.numberhero.dao.UserDAO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CreateUserActivity extends Activity {
	
	private Button addUserButton;
	private TextView usernameView;
	private UserDAO userDAO = new UserDAO(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.adduser);
		initView();
		addUserButton.setOnClickListener(buttonListener);
		
		
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
						Intent intent=new Intent();
						intent.setClass(CreateUserActivity.this, LoginActivity.class);
						startActivity(intent);
					}else {
						 Toast.makeText(CreateUserActivity.this, "亲~用户名不可以为空哦", Toast.LENGTH_LONG).show();
					}
					
					break;
				
				}
			}
		}; 
	 private void initView() {   
		 addUserButton=(Button)findViewById(R.id.button1); 
		 usernameView=(TextView)findViewById(R.id.editText1); 
	  }  
}
