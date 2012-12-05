package com.example.customswitcher;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class CustomSwitcher extends ViewSwitcher {

	private URL mImageUrl;
	private Bitmap mBitmap;
	private static String sTag = "CustomSwitcher";

	public CustomSwitcher(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//this.mContext = context;
	}

	public void setdata(String name, String image) {

		View mView = getCurrentView(); // Getting current views into mView
		TextView mText = (TextView) mView.findViewById(R.id.text); // getting
																	// text view
																	// from
																	// mView
		mText.setText(name); // setting text to textview
		ImageView mImage = (ImageView) mView.findViewById(R.id.image); // getting
																		// imageview
																		// from
																		// mView.

		try {
			mImageUrl = new URL(image);
			mBitmap = BitmapFactory.decodeStream(mImageUrl.openConnection()
					.getInputStream()); // Converting image url into bitmap.
			mImage.setImageBitmap(mBitmap); // setting bitmap to imageview.
		} catch (MalformedURLException setter) {
			// TODO Auto-generated catch block
			Log.i(sTag, "url exception"); // Displaying log message.
		} catch (IOException setter) {
			// TODO Auto-generated catch block
			Log.i(sTag, " converting to bitmap exception"); // Displaying log
															// message.
		}

	}

}
