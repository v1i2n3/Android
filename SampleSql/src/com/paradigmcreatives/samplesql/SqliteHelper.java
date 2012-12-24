/**
 * 
 */
package com.paradigmcreatives.samplesql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "employee.db";
	
	public static final String TABLE_NAME = "employee";
	
	private static final int DATABASE_VERSION = 1;
	
	public static final String COLUMN_ID = "_id";
	
	public static final String COLUMN_NAME = "name";
	
	private static final String DATABASE_CREATE = "create table " + TABLE_NAME
			+ "("  + COLUMN_ID +  " integer primary key autoincrement, "
			+ COLUMN_NAME + " text not null"  +  ")";

	
	public SqliteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	public void onCreate(SQLiteDatabase db) {

		db.execSQL(DATABASE_CREATE);
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

		db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
		onCreate(db);
	}

}
