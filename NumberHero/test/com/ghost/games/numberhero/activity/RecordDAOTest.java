package com.ghost.games.numberhero.activity;

import java.util.List;

import com.ghost.games.numberhero.dao.RecordDAO;
import com.ghost.games.numberhero.model.Record;

import android.test.AndroidTestCase;
import android.util.Log;

public class RecordDAOTest extends AndroidTestCase {
	private final static String TAG = "RecordDAOTest";

	public void testAddRecord() {
		RecordDAO recordDAO = new RecordDAO(this.getContext());
		Record record = new Record(9l, 1);
		recordDAO.addRecord(record);
		Log.i(TAG, "add successed");
	}

	public void testGetRecordsByUserid() {
		RecordDAO recordDAO = new RecordDAO(this.getContext());
		List<Record> records= recordDAO.getRecordsByUserid(1);
		if ( null == records) {
			Log.i(TAG, "not find");
		} else {
			Log.i(TAG, ""+records.size());
			
		}
	}
	
	public void testEmptyAllRecordsByUserid(){
		RecordDAO recordDAO = new RecordDAO(this.getContext());
		recordDAO.emptyAllRecordsByUserid(1);
		assertEquals(0, recordDAO.getRecordsByUserid(1).size());
		
	}

}
