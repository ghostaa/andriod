package com.ghost.games.numberhero.dao;

import java.util.ArrayList;
import java.util.List;

import com.ghost.games.numberhero.model.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {
	private DBOpenHelper helper;
	private SQLiteDatabase db;
	private String User_Table_name="user";
	
	public UserDAO(Context context) {
		helper = new DBOpenHelper(context);
	}

	/**
	 * 更具用户id查找用户信息
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
	/**
	 * 查询所有用户
	 * @return 所有用户列表
	 */
	public List<User> getUserList(){
		db = helper.getWritableDatabase();
		Cursor cursor = db.query("user", new String[] { "id", "name" }, null,
				null, null, null, null);
		List<User> userList=new ArrayList<User>();
		while (cursor.moveToNext()) {
			User user=new User(cursor.getInt(0), cursor.getString(1));
			userList.add(user);
		}
		return userList;
	}
	/**
	 * 清楚所有用户信息
	 */
	public void emptyAllUser(){
		db=helper.getWritableDatabase();
		db.delete(User_Table_name, null, null);
		//需要继续删除record表，未完成
	}
	/**
	 * 添加用户
	 * @param name
	 */
	public void addUser(String name){
		db=helper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", name);
		db.insert(User_Table_name, "id", contentValues);
	}
}
