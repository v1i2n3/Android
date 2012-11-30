package com.example.tabdemo;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TabHost mhost = (TabHost) findViewById(android.R.id.tabhost); //Getting tab host by id.
		
		TabSpec mspec = mhost.newTabSpec(getResources().getString(R.string.name1)); //Creating a tab
		mspec.setIndicator(getResources().getString(R.string.indicator1),getResources().getDrawable(R.drawable.ic_launcher)).setContent(
				new Intent(this, FirstActivity.class));  //Providing content to the tab

		mhost.addTab(mspec); //adding tab to the tabhost
		
        mspec = mhost.newTabSpec(getResources().getString(R.string.name2)); //Creating a tab
		mspec.setIndicator(getResources().getString(R.string.indicator2),getResources().getDrawable(R.drawable.ic_launcher)).setContent(
				new Intent(this, FirstActivity.class));   //Providing content to the tab

		mhost.addTab(mspec);    //adding tab to the tabhost

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
