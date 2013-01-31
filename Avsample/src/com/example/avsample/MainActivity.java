package com.example.avsample;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button mUserClick;
	EditText mScandata;
	String url = "http://www.searchupc.com/handlers/upcsearch.ashx?request_type=3&access_token=C6666367-D16B-49EB-85B1-B8ECD2346678&upc=";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mUserClick = (Button) findViewById(R.id.user_click);
		mScandata = (EditText) findViewById(R.id.user_text);

		mUserClick.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!(mScandata.getText().toString()).equals("")) {
					
					Intent mIntent = new Intent(MainActivity.this,
							Products.class);
					
					mIntent.putExtra("url", "http://www.searchupc.com/handlers/upcsearch.ashx?request_type=3&access_token=C6666367-D16B-49EB-85B1-B8ECD2346678&upc=" +mScandata.getText().toString());
					startActivity(mIntent);
					
				} else {
					Dialog mDialog = new Dialog(MainActivity.this);
					mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
					mDialog.setContentView(R.layout.dialog);
					TextView mTextView = (TextView) mDialog
							.findViewById(R.id.message);
					mTextView.setText("Please enter barcode of your product");
					mDialog.show();
					
					
				}

			}	
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
