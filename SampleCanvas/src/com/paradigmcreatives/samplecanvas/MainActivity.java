package com.paradigmcreatives.samplecanvas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity implements OnTouchListener{
	
	CustomView mView;
	Bitmap mBitmap;
	float x = 0,y = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = new CustomView(this);
        mView.setOnTouchListener(this);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        setContentView(mView);
        
    }
    
   
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	mView.pause();
    }
    
    
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	mView.resume();
    }
    

   public class CustomView extends SurfaceView implements Runnable{

	   Thread t = null;
	   SurfaceHolder holder;
	   boolean isConnected = false;
	
	public CustomView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		holder = getHolder();
	}

	
	public void pause() {
		// TODO Auto-generated method stub
		isConnected = false;
		while(true)  {
			try {
				t.join();
			} catch (InterruptedException setter) {
				// TODO Auto-generated catch block
				setter.printStackTrace();
			}
			t = null;
		}
		
	}

	public void resume() {
		// TODO Auto-generated method stub
	
		isConnected = true;
		t = new Thread(this);
		t.start();
		
	}


	public void run() {
		// TODO Auto-generated method stub
		while(isConnected)  {
			
			if(!holder.getSurface().isValid())  {
				
				continue ;
			}
			
			Canvas c = holder.lockCanvas();
			c.drawARGB(255, 130, 130, 40);
			c.drawBitmap(mBitmap, x - mBitmap.getWidth()/2, y - mBitmap.getHeight()/2, null);
			holder.unlockCanvasAndPost(c);
		}
	}
	   
   }
	
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE:
			
			x = event.getX();
			System.out.println("x" +x);
			y = event.getY();
			System.out.println("y" +y);
			
			break;

		default:
			break;
		}
		return true;
	}
}
