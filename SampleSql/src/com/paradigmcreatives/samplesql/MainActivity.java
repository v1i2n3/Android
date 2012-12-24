package com.paradigmcreatives.samplesql;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private DataBase database;
	private EditText mUsername;
	private ListView mList;
	private Button mSubmit;
	private Button mDelete;
	private ArrayAdapter<Comment> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mUsername = (EditText) findViewById(R.id.edit_user);
		
		mList = (ListView) findViewById(R.id.datalist);
		mSubmit = (Button) findViewById(R.id.submit);
		mDelete = (Button) findViewById(R.id.delete);
		database = new DataBase(getApplicationContext());
		database.open();
		List<Comment> values = database.getAllComments();
		adapter = new ArrayAdapter<Comment>(getApplicationContext(),
				android.R.layout.simple_list_item_1, values);
		mList.setAdapter(adapter);

	}

	public void onClick(View view) {
		// ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) ;
		Comment comment = null;
		switch (view.getId()) {
		case R.id.submit:
			String msg = mUsername.getText().toString();
			mUsername.setText("");
			// Save the new comment to the database
			comment = database.createComment(msg);
			adapter.add(comment);
			break;
		case R.id.delete:
			if (adapter.getCount() > 0) {
				comment = (Comment) adapter.getItem(0);
				System.out.println(comment.toString());
				database.deleteComment(comment);
				adapter.remove(comment);
			}
			break;
		}
		adapter.notifyDataSetChanged();
	}

	@Override
	protected void onResume() {
		database.open();
		super.onResume();
	}

	@Override
	protected void onPause() {
		database.close();
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
