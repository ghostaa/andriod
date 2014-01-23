package com.ghost.games.numberhero.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;

import com.ghost.games.numberhero.numberstring.NumberString;

public class NumberHeroActivity extends Activity {
	private String result=new NumberString().getNormalString();
	private Button btn1;
	private static String TAG = "LifeCycleTest";
	private Chronometer chronometer1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn1=(Button)findViewById(R.id.button1);
        btn1.setOnClickListener(listener);
        Log.v("result", result);
        Log.v(TAG, "NumberHeroActivity -> onCreate");
        chronometer1=(Chronometer)findViewById(R.id.chronometer1);
        chronometer1.start();
    }
    
    private OnClickListener listener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			/**
			 *onClick
			 *下午06:36:50
			 *TODO
			 */
			
			
			EditText et1= (EditText)findViewById(R.id.et1);
			EditText et2= (EditText)findViewById(R.id.et2);
			EditText et3= (EditText)findViewById(R.id.et3);
			EditText et4= (EditText)findViewById(R.id.et4);
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
	private String joinString(List<String> list){
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