/**
 * 
 */
package com.example.snakeladder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GameActivity extends Activity{
	

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);	
		
	}

	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent mIntent = new Intent(GameActivity.this,MainActivity.class);
		startActivity(mIntent);
		
		
	}
}
