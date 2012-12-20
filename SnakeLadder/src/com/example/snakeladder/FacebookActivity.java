
package com.example.snakeladder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;


public class FacebookActivity extends Activity {
	
	private Facebook mFacebook;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.facebook);
		mFacebook = new Facebook("250823521707781");
		ImageButton mLogin = (ImageButton)findViewById(R.id.facebook);
		mLogin.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				authorize();
			}
		});
		
	}
	public void authorize()  {
		
		if(mFacebook.getAccessToken() == null)  {
			
			
			mFacebook.authorize(FacebookActivity.this, new DialogListener() {
				
				public void onFacebookError(FacebookError e) {
					// TODO Auto-generated method stub
					
				}
				
				public void onError(DialogError e) {
					// TODO Auto-generated method stub
					
				}
				
				public void onComplete(Bundle values) {
					// TODO Auto-generated method stub
					Intent mIntent = new Intent(FacebookActivity.this,GameActivity.class);
					startActivity(mIntent);
				}
				
				public void onCancel() {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
	}

}
