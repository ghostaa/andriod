package com.ghost.games.numberhero.dao;

import com.ghost.games.numberhero.model.User;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {
	private DBOpenHelper helper;
	private SQLiteDatabase db;

	public UserDAO(Context context) {
		helper = new DBOpenHelper(context);
	}

	/**
	 * 查找用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User find(int id) {
		db = helper.getWritableDatabase();
		Cursor cursor = db.query("user", new String[] { "id", "name" }, "id=?",
				new String[] { String.valueOf(id) }, null, null, null);
		if (cursor.moveToNext()) {
			return new User(cursor.getInt(0), cursor.getString(1));
		}
		return null;
	}
}
