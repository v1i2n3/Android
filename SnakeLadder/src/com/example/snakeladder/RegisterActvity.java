/**
 * 
 */
package com.example.snakeladder;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActvity extends Activity {
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		Button mButton = (Button)findViewById(R.id.submit);
		mButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Dialog mDialog = new Dialog(RegisterActvity.this);
				mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				mDialog.setContentView(R.layout.dialog);
				mDialog.show();
				
				Button mOk = (Button)mDialog.findViewById(R.id.ok);
				mOk.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent mIntent = new Intent(RegisterActvity.this,FacebookActivity.class);
						startActivity(mIntent);
						finish();
					}
					
				});
				
				Button mCancel = (Button)mDialog.findViewById(R.id.cancel);
				mCancel.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
					
						Dialog mCdialog = new Dialog(RegisterActvity.this);
						mCdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
						mCdialog.setContentView(R.layout.dialog1);
						mCdialog.setCancelable(true);
						mCdialog.show();
						
					}
				});
			
			}
			});
		
		
	}
	

}
