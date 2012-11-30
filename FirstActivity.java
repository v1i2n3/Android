/**
 * 
 */
package com.example.tabdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class FirstActivity extends Activity{
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		TextView tv = (TextView)findViewById(R.id.text);
		tv.setText("Gallery is empty");
	}

}
