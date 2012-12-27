package com.paradigmcreatives.samplejson;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements ServerResponse {

	private Parser mParser;
	private ListView mListView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView = (ListView) findViewById(R.id.list);
		DownloadTask mDownload = new DownloadTask(
				MainActivity.this,
				(com.paradigmcreatives.samplejson.ServerResponse) MainActivity.this);
		mDownload.execute();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void setdata(String data) {
		
		mParser = new Parser(data, MainActivity.this);
	}

	public void setList(List<Contacts> values) {
		
		CustomAdapter mCustom = new CustomAdapter(this,values);
		
		mListView.setAdapter(mCustom);
		
	}

}
