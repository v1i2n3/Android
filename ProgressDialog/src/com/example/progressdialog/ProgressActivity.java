package com.paradigmcreatives.progressdialog;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;

public class ProgressActivity extends Activity {

	private  ProgressDialog progress;
	private ImageView mImage;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        progress = new ProgressDialog(this);
        progress.setMessage(getResources().getString(R.string.message));
       progress.setTitle(getResources().getString(R.string.title));
         mImage = (ImageView)findViewById(R.id.image);
        Download task = new Download(this);
        task.execute(new String[] { "http://t3.gstatic.com/images?q=tbn:ANd9GcT-GAUPQRHTSKPNNQtLXQBpQsakHrRM7ApjervJdeYMFfu3Y6anFQ" });
        
    }
   private class Download extends AsyncTask<String , Void, Bitmap> {

		
		private Context mContext;
		private URL mImageUrl;
		private Bitmap mBitmap;
		public Download(Context context) {
			// TODO Auto-generated constructor stub
			mContext = context;
		}
		
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progress.show();
		}
		
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if(progress!=null){
				progress.dismiss();
			}
			
			mImage.setImageBitmap(result);
			
			
		}

		protected Bitmap doInBackground(String... image) {
			
			try {
				mImageUrl = new URL(image[0]);
				mBitmap = BitmapFactory.decodeStream(mImageUrl.openConnection()
						.getInputStream()); 
				return mBitmap; 
			} catch (MalformedURLException setter) {
				// TODO Auto-generated catch block
				Log.i("tag", "url exception"); 
			} catch (IOException setter) {
				// TODO Auto-generated catch block
				Log.i("Tag", " converting to bitmap exception"); 
			}
			
			return null;
		}
    	
    }
 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_progress, menu);
        return true;
    }
}
