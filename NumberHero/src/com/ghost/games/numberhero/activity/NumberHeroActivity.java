package com.ghost.games.numberhero.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;

import com.ghost.games.numberhero.numberstring.NumberString;

public class NumberHeroActivity extends Activity {
	private String result=new NumberString().getNormalString();
	private Button btn1;
	private ImageButton number1;
	private ImageButton number2;
	private ImageButton number3;
	private ImageButton number4;
	private ImageButton number5;
	private ImageButton number6;
	private ImageButton number7;
	private ImageButton number8;
	private ImageButton number9;
	private EditText et1;
	private EditText et2;
	private EditText et3;
	private EditText et4;
	private static String TAG = "LifeCycleTest";
	private static String LOG = "log";
	private Chronometer chronometer1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //关闭键盘锁
      /*  KeyguardManager mKeyGuardManager = (KeyguardManager)getSystemService(KEYGUARD_SERVICE);
        KeyguardLock mLock = mKeyGuardManager.newKeyguardLock("NumberHeroActivity");
        mLock.disableKeyguard(); */
        
        
        setContentView(R.layout.main);
        btn1=(Button)findViewById(R.id.button1);
        btn1.setOnClickListener(buttonListener);
        number1=(ImageButton)findViewById(R.id.imageButton1);
        number1.setOnClickListener(imageButtonListener);
        number2=(ImageButton)findViewById(R.id.imageButton2);
        number2.setOnClickListener(imageButtonListener);
        number3=(ImageButton)findViewById(R.id.imageButton3);
        number3.setOnClickListener(imageButtonListener);
        number4=(ImageButton)findViewById(R.id.imageButton4);
        number4.setOnClickListener(imageButtonListener);
        number5=(ImageButton)findViewById(R.id.imageButton5);
        number5.setOnClickListener(imageButtonListener);
        number6=(ImageButton)findViewById(R.id.imageButton6);
        number6.setOnClickListener(imageButtonListener);
        number7=(ImageButton)findViewById(R.id.imageButton7);
        number7.setOnClickListener(imageButtonListener);
        number8=(ImageButton)findViewById(R.id.imageButton8);
        number8.setOnClickListener(imageButtonListener);
        number9=(ImageButton)findViewById(R.id.imageButton9);
        number9.setOnClickListener(imageButtonListener);
       
        et1= (EditText)findViewById(R.id.et1);
		et2= (EditText)findViewById(R.id.et2);
		et3= (EditText)findViewById(R.id.et3);
		et4= (EditText)findViewById(R.id.et4);
		//屏蔽软键盘
		et1.setInputType(InputType.TYPE_NULL);
		et2.setInputType(InputType.TYPE_NULL);
		et3.setInputType(InputType.TYPE_NULL);
		et4.setInputType(InputType.TYPE_NULL);
		
        Log.v("result", result);
        Log.v(TAG, "NumberHeroActivity -> onCreate");
        chronometer1=(Chronometer)findViewById(R.id.chronometer1);
        chronometer1.start();
        
    }
    private OnClickListener imageButtonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			ImageButton  btn=(ImageButton)v;
			// TODO Auto-generated method stub
			EditText et=(EditText)getCurrentFocus();
			switch (btn.getId()) {
			case R.id.imageButton1:
			     et.setText("1");
			     
				break;
			case R.id.imageButton2:
				et.setText("2");
				break;
			case R.id.imageButton3:
				et.setText("3");
				break;
			case R.id.imageButton4:
				et.setText("4");
				break;
			case R.id.imageButton5:
				et.setText("5");
				break;
			case R.id.imageButton6:
				et.setText("6");
				break;
			case R.id.imageButton7:
				et.setText("7");
				break;
			case R.id.imageButton8:
				et.setText("8");
				break;
			case R.id.imageButton9:
				et.setText("9");
				break;
			}
			
			switch (et.getId()) {
			case R.id.et1:
				et2.requestFocus();
				break;
			case R.id.et2:
				et3.requestFocus();
				break;
			case R.id.et3:
				et4.requestFocus();
				break;
			case R.id.et4:
				et1.requestFocus();
				break;

			
			}
		}
	};
		 
    private OnClickListener buttonListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			/**
			 *onClick
			 *下午06:36:50
			 *TODO
			 */
			Button btn=(Button)v;
			switch (btn.getId()) {
			case R.id.button1:

				
				List<String> list=new ArrayList<String>();
				list.add(et1.getText().toString());
				list.add(et2.getText().toString());
				list.add(et3.getText().toString());
				list.add(et4.getText().toString());
				EditText showResult= (EditText)findViewById(R.id.showResult);
				String submitString=joinString(list);
				String judgeResult=judgeString(submitString,result);
				showResult.setText(showResult.getText().toString()+submitString+"\t"+judgeResult+"\n");
				et1.setText("");
				et2.setText("");
				et3.setText("");
				et4.setText("");
				if ("4A0B".equals(judgeResult)) {
					
					Intent intent=new Intent();
					intent.setClass(NumberHeroActivity.this, ResultActivity.class);
					intent.putExtra("result", result);
					intent.putExtra("times", chronometer1.getBase());
					intent.putExtra("resultList", showResult.getText().toString());
					startActivity(intent);
				}
				break;
			
			}
			
			
		}

		
	}; 
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		/**
		*onDestroy
		*下午11:55:53
		*TODO
		*/
		Log.v(TAG, "NumberHeroActivity -> onDestroy");
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		/**
		*onPause
		*下午11:55:53
		*TODO
		*/
		Log.v(TAG, "NumberHeroActivity -> onPause");
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		/**
		*onRestart
		*下午11:55:53
		*TODO
		*/
		Log.v(TAG, "NumberHeroActivity -> onRestart");
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		/**
		*onResume
		*下午11:55:53
		*TODO
		*/
		Log.v(TAG, "NumberHeroActivity -> onResume");
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		/**
		*onStart
		*下午11:55:53
		*TODO
		*/
		Log.v(TAG, "NumberHeroActivity -> onStart");
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		/**
		*onStop
		*下午11:55:53
		*TODO
		*/
		Log.v(TAG, "NumberHeroActivity -> onStop");
	}
	private String judgeString(String submitString, String result) {
		int a=0;
		int b=0;
		if (submitString.length()==result.length()) {
			for (int i = 0; i < result.length(); i++) {
				Character submitChar=submitString.charAt(i);
				if(result.contains(submitChar.toString())){
					if (result.charAt(i)==submitString.charAt(i)) {
						a++;
					}else {
						b++;
					}
				}
				
			}
				
			
		}else {
			return "位数少";
		}
		
		return a+"A"+b+"B";
	}
	public String joinString(List<String> list){
		StringBuffer sb=new StringBuffer();
		Iterator<String> iterator=list.iterator();
		while (iterator.hasNext()) {
			String temp=iterator.next();
			if (temp.length()>1) {
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				sb.append(temp);
			}
		}
		return sb.toString();
	}
	
}