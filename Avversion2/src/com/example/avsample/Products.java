package com.example.avsample;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Products extends Activity implements ServerResponse {
   
	ListView mListView;
	Parser mParser;
	Intent mIntent;
	String url;
	ConnectivityManager mCmgr;
	NetworkInfo netInfo;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product_list);
		mCmgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		netInfo = mCmgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		mListView = (ListView) findViewById(R.id.list);
		mIntent = getIntent();
		url = mIntent.getStringExtra("url");
		System.out.println("Url" + url);
		if (netInfo.isConnected()) {
			Download task = new Download(this,
					(com.example.avsample.ServerResponse) Products.this);
			task.execute(url);
		} else {
			Toast.makeText(this, getResources().getString(R.string.netinfo),
					Toast.LENGTH_LONG).show();
		}

	}

	public void setData(String data) {
		// TODO Auto-generated method stub
		mParser = new Parser(data, Products.this);
	}

	public void setList(List<HashMap<String, String>> data) {

		DataAdapter mAdapter = new DataAdapter(this, data);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String productname = ((TextView) view
						.findViewById(R.id.productname)).getText().toString();
				String imageur = ((TextView) view.findViewById(R.id.imageurl))
						.getText().toString();
				String price = ((TextView) view.findViewById(R.id.price))
						.getText().toString();
				String currency = ((TextView) view.findViewById(R.id.currency))
						.getText().toString();
				String saleprice = ((TextView) view
						.findViewById(R.id.saleprice)).getText().toString();
				String storename = ((TextView) view
						.findViewById(R.id.storename)).getText().toString();
				String producturl = ((TextView) view
						.findViewById(R.id.producturl)).getText().toString();

				if(netInfo.isConnected()) {
					
					Intent mIntent = new Intent(getApplicationContext(),
							Details.class);

					mIntent.putExtra("Url", imageur);
					mIntent.putExtra("productname", productname);
					mIntent.putExtra("price", price);
					mIntent.putExtra("currency", currency);
					mIntent.putExtra("saleprice", saleprice);
					mIntent.putExtra("storename", storename);
					mIntent.putExtra("producturl", producturl);

					startActivity(mIntent);
				
				}else {
					
					Toast.makeText(Products.this, getResources().getString(R.string.netinfo),
							Toast.LENGTH_LONG).show();
				}
				
			}
		});
	}

}
