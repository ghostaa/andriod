package com.ghost.games.numberhero.dao;

import java.util.ArrayList;
import java.util.List;

import com.ghost.games.numberhero.model.Record;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RecordDAO {
	private DBOpenHelper helper;
	private SQLiteDatabase db;
	private String Recrod_Table_name="record";
	
	public RecordDAO(Context context) {
		helper = new DBOpenHelper(context);
	}
	
	public void addRecord(Record record){
		db=helper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("times", record.getTimes());
		contentValues.put("user_id", record.getUserid());
		db.insert(Recrod_Table_name, "id", contentValues);
	}
	
	/**
	 * 获得当前user id的记录
	 * @param userid
	 * @return
	 */
	public List<Record> getRecordsByUserid(int userid){
		db=helper.getWritableDatabase();
		List<Record> records = new ArrayList<Record>();
		Cursor cursor = db.query(Recrod_Table_name, new String[]{"id","times","user_id"}, "user_id=?", new String[]{String.valueOf(userid)}, null, null, "times desc");
		while (cursor.moveToNext()) {
			records.add(new Record(cursor.getLong(1),cursor.getInt(2)));
		}
		return records;
	}
	
	public void emptyAllRecordsByUserid(int userid){
		db=helper.getWritableDatabase();
		db.delete(Recrod_Table_name, " user_id=?", new String[]{String.valueOf(userid)});
	}
	
}
