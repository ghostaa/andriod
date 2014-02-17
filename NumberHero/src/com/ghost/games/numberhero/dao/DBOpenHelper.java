package com.ghost.games.numberhero.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBOpenHelper extends SQLiteOpenHelper {

	private static final int VERSION = 1;
	private static final String DBNAME = "user.db";
	private static final String USER = "user";
	private static final String RECORD = "record";

	public DBOpenHelper(Context context) {
		super(context, DBNAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table " + USER
				+ " (  id integer NOT NULL PRIMARY KEY AUTOINCREMENT ,  "
				+ "name varchar )");
		db.execSQL("create table " + RECORD
				+ " (    id integer NOT NULL PRIMARY KEY AUTOINCREMENT ,"
				+ "  times long ,  " + "  user_id integer)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i("StudentDAOTest", "UpGrade!");
	}

}
