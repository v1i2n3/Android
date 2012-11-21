package com.paradigmcreatives.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener  {
	
	
	public void onCreate(Bundle savedInstanceState)   {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button game = (Button)findViewById(R.id.button1);
        game.setTextColor(getResources().getColor(R.color.blue));
        game.setOnClickListener(this);
        
        Button help = (Button)findViewById(R.id.button2);
        help.setTextColor(getResources().getColor(R.color.blue));
        help.setOnClickListener(this);
        
        Button score = (Button)findViewById(R.id.button4);
        score.setTextColor(getResources().getColor(R.color.blue));
        score.setOnClickListener(this);
        
        Button exit = (Button)findViewById(R.id.button5);
        exit.setTextColor(getResources().getColor(R.color.blue));
        exit.setOnClickListener(this);
        
        Button settings = (Button)findViewById(R.id.button3);
        settings.setTextColor(getResources().getColor(R.color.blue));
        settings.setOnClickListener(this);
    
	}
    
  
public void onClick(View v)   {
  
	Intent intent;
	
	switch (v.getId())   {
	
	case R.id.button1:
		intent=new Intent(this,RegisterActivity.class);
		startActivity(intent);
		
		break;
		
case R.id.button2:
		
	intent=new Intent(this,HelpActivity.class);
	startActivity(intent);
		break;
		
case R.id.button3:
	
	break;
	
case R.id.button4:
	
	break;
	
case R.id.button5:
	finish();
	break;

	
	}
	
}

   
    public boolean onCreateOptionsMenu(Menu menu) {
       
    	getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
        
    }
}
