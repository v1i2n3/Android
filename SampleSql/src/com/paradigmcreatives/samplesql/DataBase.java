/**
 * 
 */
package com.paradigmcreatives.samplesql;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataBase {

	private SQLiteDatabase sqldatabase;

	private SqliteHelper helper;

	public DataBase(Context context) {

		helper = new SqliteHelper(context);
	}

	public void open() throws SQLException {
		if (sqldatabase == null) {

			sqldatabase = helper.getWritableDatabase();

		}

	}

	public void close() throws SQLException {
		if (sqldatabase != null) {

			helper.close();
		}
	}

	public Comment createComment(String name) {

		ContentValues values = new ContentValues();

		values.put(SqliteHelper.COLUMN_NAME, name);

		long insertId = sqldatabase.insert(SqliteHelper.TABLE_NAME, null, values);

		Cursor cursor = sqldatabase.query(SqliteHelper.TABLE_NAME, null,
				SqliteHelper.COLUMN_ID + "=" + insertId, null, null, null, null);

		cursor.moveToFirst();

		Comment nameComment = cursorToname(cursor);

		cursor.close();

		return nameComment;

	}

	public void deleteComment(Comment comment) {

		long id = comment.getId();

		sqldatabase.delete(SqliteHelper.TABLE_NAME, SqliteHelper.COLUMN_ID + " = " + id,
				null);

	}

	public List<Comment> getAllComments() {

		List<Comment> comments = new ArrayList<Comment>();

		Cursor cursor = sqldatabase.query(SqliteHelper.TABLE_NAME, null, null, null,
				null, null, null);

		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {

			Comment comment = cursorToname(cursor);

			comments.add(comment);

			cursor.moveToNext();

		}
		
		cursor.close();

		return comments;

	}

	private Comment cursorToname(Cursor cursor) {

		Comment comment = new Comment();

		comment.setId(cursor.getLong(0));

		comment.setName(cursor.getString(1));

		return comment;

	}
}
