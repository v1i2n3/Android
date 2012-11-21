package com.paradigmcreatives.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity{
	
	public static final int  REQUEST_CODE = 1;
	
	protected void onCreate(Bundle savedInstanceState)  {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_game);
		Button submit =(Button)findViewById(R.id.submit);
		submit.setOnClickListener(new OnClickListener()  {
			
			public void onClick(View v)  {
				 
				Intent intent = new Intent(getApplicationContext(),GameActivity.class);
				EditText username = (EditText)findViewById(R.id.useredit);
				String name = username.getText().toString();
				intent.putExtra("key", name);
				startActivityForResult(intent, REQUEST_CODE);
			
			}
		
		});
	
	}

	protected void onActivityResult(int requesCode, int resultCode, Intent data)  {
		//@Override
		super.onActivityResult(requesCode, resultCode, data);
		if(REQUEST_CODE == requesCode)   {
			
			finish();
		
		}
	
	}

}
