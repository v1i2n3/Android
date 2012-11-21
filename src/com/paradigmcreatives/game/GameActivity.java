package com.paradigmcreatives.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Arrays;

public class GameActivity extends Activity{
	
	private static final int RESULT_CODE = 1;
	public static final String GAME_PREFERENCE  = "name";
	public static final String SCORE_PREFERENCE  = "score";
	SharedPreferences mpreferences;
	Editor meditor;
	String musername;
	int count,score1 = 0,score2 = 0;  
	int[][] win = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};  
	int[] player1 = new int[5];  
	int xcount,ocount;  
	int[] player2 = new int[5]; 
       
        @Override
	protected void onCreate(Bundle savedInstanceState)   {
		
                // TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		preferences = getSharedPreferences(GAME_PREFERENCE, Context.MODE_PRIVATE);
		setContentView(R.layout.activity_game);
		start();
		Intent intent = getIntent();
		musername = intent.getStringExtra("key");
		meditor = preferences.edit();
		meditor.putString(GAME_PREFERENCE, musername);
		meditor.commit();
	    this.setResult(RESULT_CODE,intent);
	
	}
	
        //Getting layout views and providing OnClickListener class object
	public void start()  {  
		
       count  = 0;  
       xcount = 0;  
       ocount = 0;   
       ImageButton image = (ImageButton) this.findViewById(R.id.btn1);  
        image.setOnClickListener(listener);  
        
        image = (ImageButton) this.findViewById(R.id.btn2);  
        image.setOnClickListener(listener);  
        
        image = (ImageButton) this.findViewById(R.id.btn3);  
        image.setOnClickListener(listener);  
        
        image = (ImageButton) this.findViewById(R.id.btn4);  
        image.setOnClickListener(listener);  
        
        image = (ImageButton) this.findViewById(R.id.btn5);  
        image.setOnClickListener(listener);  
        
        image = (ImageButton) this.findViewById(R.id.btn6);  
        image.setOnClickListener(listener);  
        
        image = (ImageButton) this.findViewById(R.id.btn7);  
        image.setOnClickListener(listener);  
        
        image = (ImageButton) this.findViewById(R.id.btn8);  
        image.setOnClickListener(listener);  
        
        image = (ImageButton) this.findViewById(R.id.btn9);  
        image.setOnClickListener(listener);  
       
	}  
	
          //All the button views setClickable state is making false
	  public void stop()    {
		  
		  
	        ImageButton image = (ImageButton) this.findViewById(R.id.btn1);  
	        image.setClickable(false);  
	        
	        image = (ImageButton) this.findViewById(R.id.btn2);  
	        image.setClickable(false);  
	        
	        image = (ImageButton) this.findViewById(R.id.btn3);  
	        image.setClickable(false);  
	        
	        image = (ImageButton) this.findViewById(R.id.btn4);  
	        image.setClickable(false);  
	        
	        image = (ImageButton) this.findViewById(R.id.btn5);  
	        image.setClickable(false);  
	        
	        image = (ImageButton) this.findViewById(R.id.btn6);  
	        image.setClickable(false);  
	        
	        image = (ImageButton) this.findViewById(R.id.btn7);  
	        image.setClickable(false);  
	        
	        image = (ImageButton) this.findViewById(R.id.btn8);  
	        image.setClickable(false);  
	        
	        image = (ImageButton) this.findViewById(R.id.btn9);  
	        image.setClickable(false);  
	       
	  
	  }  
		
private OnClickListener listener = new OnClickListener()    {
	
        
        public void onClick(View v)   {
        	
         ImageButton button = (ImageButton) v;  
         TextView display = (TextView)findViewById(R.id.subtitle); 
         
         //Giving chance to player1 
         if(count%2 == 0)   {  
         
             button.setBackgroundResource(R.drawable.x);  
             player1[xcount] = Integer.parseInt((String)button.getTag());  
             button.setClickable(false);  
             display.setText(getResources().getString(R.string.choice2));  
             count++;
             score1 = score1+5;
             xcount++; 
              //Cheking player1 won the game or not
          if(xcount >= 3)   {  
         
        	  for(int i = 0;i < 8; i++)  {  
         
        		  if(Arrays.toString(player1).contains(String.valueOf(win[i][0]))&&Arrays.toString(player1).contains(String.valueOf(win[i][1]))&&Arrays.toString(player1).contains(String.valueOf(win[i][2])))   {  
    
        			stop();  
                    display.setText(getResources().getString(R.string.declaring1)); 
                    Editor  editor = preferences.edit();
                    editor.putInt(SCORE_PREFERENCE, score1);
                    editor.commit();
           
        		  }  
         
        	  }  
          
          }  
         
         }  
            //Giving chance to player2
         else   {
        	 
          button.setBackgroundResource(R.drawable.o);  
          player2[ocount] = Integer.parseInt((String)b.getTag());  
          button.setClickable(false);  
          display.setText(getResources().getString(R.string.choice1));  
          count++;
          score2 = score2 + 5 ;
          ocount++;
            //Cheking player2 won the game or not
          if(ocount >= 3)  {  
             
        	  for(int i = 0; i < 8; i++)   {  
             
        		  if(Arrays.toString(player2).contains(String.valueOf(win[i][0]))&&Arrays.toString(player2).contains(String.valueOf(win[i][1]))&&Arrays.toString(player2).contains(String.valueOf(win[i][2])))  {                   
        			  
        			  stop();
                      display.setText(getResources().getString(R.string.declaring2));  
                      Editor  editor = preferences.edit();
                      editor.putInt(SCORE_PREFERENCE, score2);
                      editor.commit();     
        		  
        		  }  
             
        	  }  
              
          }  
         
         }  
       
        }  
    
};  
    //Moving to game menu
    public void close(View v)    {
    	
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
       
    }  
       //Restart game
       public void restart(View v)  {
        
    	   setContentView(R.layout.activity_game);  
           start();  
           
       } 		
	
}


