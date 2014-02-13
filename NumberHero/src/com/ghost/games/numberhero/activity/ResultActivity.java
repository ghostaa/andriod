package com.ghost.games.numberhero.activity;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.ghost.games.numberhero.dao.RecordDAO;
import com.ghost.games.numberhero.model.Record;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.LinearLayout;
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
	private Button emptyAndRestart;
	private Chronometer chronometer2;
	private RecordDAO recordDAO = new RecordDAO(this);;
	
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
		 recordDAO.addRecord(new Record(bundle.getLong("times"), 1));
		 restartButton=(Button)findViewById(R.id.restart);
		 restartButton.setOnClickListener(buttonListener);
		 emptyAndRestart=(Button)findViewById(R.id.emptyAndRestart);
		 emptyAndRestart.setOnClickListener(buttonListener);
		 List<Record> records=recordDAO.getRecordsByUserid(1);
		 Iterator<Record> iterator=records.iterator();
		 final LinearLayout lin = (LinearLayout) findViewById(R.id.recordLinearlayout);  
		 
		 while (iterator.hasNext()) {
			 Chronometer chronometer=new Chronometer(this);  
			 chronometer.setBase(iterator.next().getTimes());
			 lin.addView(chronometer);
		}
		 

		 
	}

	public OnClickListener buttonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Button btn=(Button)v;
			switch (btn.getId()) {
			case R.id.restart:
				
				break;
			case R.id.emptyAndRestart:
				recordDAO.emptyAllRecordsByUserid(1);
				break;
			}
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


