package com.ghost.games.numberhero.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

/**
 * @author 阎东鹏
 * @Title: main
 * @Description: TODO
 * @throws 2014-1-22上午12:07:19 
 */
public class ResultActivity extends Activity {
	private final static String TAG = "LifeCycleTest";
	private Button restartButton;
	private Chronometer chronometer2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		/**
		*onCreate
		*上午12:07:34
		*TODO
		*/
		 setContentView(R.layout.result);
		 Log.v(TAG, "ResultActivity -> onCreate");
		 Intent intent=getIntent();
		 Bundle bundle=intent.getExtras();
		 TextView result=(TextView)findViewById(R.id.result);
		 result.setText(bundle.getString("result"));
		 TextView resultList=(TextView)findViewById(R.id.resultList);
		 resultList.setText(bundle.getString("resultList"));
		 chronometer2=(Chronometer)findViewById(R.id.chronometer2);
		 chronometer2.setBase(bundle.getLong("times"));
		 restartButton=(Button)findViewById(R.id.restart);
		 restartButton.setOnClickListener(restartListener);
	}

	public OnClickListener restartListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setClass(ResultActivity.this, NumberHeroActivity.class);
			startActivity(intent);
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
		Log.v(TAG, "ResultActivity -> onDestroy");
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
		Log.v(TAG, "ResultActivity -> onPause");
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
		Log.v(TAG, "ResultActivity -> onRestart");
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
		Log.v(TAG, "ResultActivity -> onResume");
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
		Log.v(TAG, "ResultActivity -> onStart");
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
		Log.v(TAG, "ResultActivity -> onStop");
	}
}


