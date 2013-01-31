
package com.example.avsample;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;


public class Products extends Activity implements ServerResponse{
	private ListView mListView;
	Parser mParser;
	Intent mIntent;
	String url;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product_list);
		mListView = (ListView)findViewById(R.id.list);
		mIntent = getIntent();
	    url = mIntent.getStringExtra("url");
		System.out.println("Url" +url);
		Download task = new Download(this,(com.example.avsample.ServerResponse)Products.this);
		task.execute(url);
		
	}

	public void setData(String data) {
		// TODO Auto-generated method stub
		mParser = new Parser(data,Products.this);
	}
	
	public void setList(List<HashMap<String, String>> data) {
		
		DataAdapter mAdapter = new DataAdapter(this,data);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				ImageView image = (ImageView)view.findViewById(R.id.image);
			}
		});
	}


}
