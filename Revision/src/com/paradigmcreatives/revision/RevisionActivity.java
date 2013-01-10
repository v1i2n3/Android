package com.paradigmcreatives.revision;

import java.io.File;
import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

public class RevisionActivity extends Activity {

	private ImageView mImageView;
	String filepath;
	Uri mUri;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_revision);
		mImageView = (ImageView) findViewById(R.id.image);
		filepath = Environment.getExternalStorageDirectory().getAbsolutePath()
				+ "/Myimage.jpg";
		File mFile = new File(filepath);
		mUri = Uri.fromFile(mFile);
		Intent mIntent = new Intent(
				android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		mIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mUri);
		startActivityForResult(mIntent, 0);

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		Bitmap bmp;
		BitmapFactory.Options bmpOptions;
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK && requestCode == 0) {

			int dw = getWindowManager().getDefaultDisplay().getWidth();
			int dh = getWindowManager().getDefaultDisplay().getHeight();

			bmpOptions = new BitmapFactory.Options();
			bmpOptions.inJustDecodeBounds = true;
			bmp = BitmapFactory.decodeFile(filepath, bmpOptions);

			int width = (int) Math.ceil(bmpOptions.outWidth / (float) dw);
			int height = (int) Math.ceil(bmpOptions.outHeight / (float) dh);

			if (width > 1 && height > 1) {

				if (width > height) {

					bmpOptions.inSampleSize = width;

				} else {
					bmpOptions.inSampleSize = height;
				}

			}
			bmpOptions.inJustDecodeBounds = false;
			try {
				bmp = BitmapFactory.decodeStream(getContentResolver()
						.openInputStream(mUri), null, bmpOptions);
				mImageView.setImageBitmap(bmp);
			} catch (FileNotFoundException setter) {
				// TODO Auto-generated catch block
				setter.printStackTrace();
			}

		}
	}

}
