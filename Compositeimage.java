package com.paradigmcreatives.revision;

import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class RevisionActivity extends Activity implements OnClickListener {

	static final int PICKED_ONE = 0;
	static final int PICKED_TWO = 1;
	boolean onePicked = false;
	boolean twoPicked = false;
	Button choosePicture1;
	Button choosePicture2;
	ImageView compositeImageView;
	Bitmap bmp1;
	Bitmap bmp2;
	Canvas canvas;
	Paint paint;
 

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_revision);

		choosePicture1 = (Button) findViewById(R.id.image1);
		choosePicture2 = (Button) findViewById(R.id.image2);
		compositeImageView = (ImageView) findViewById(R.id.composite);

		choosePicture1.setOnClickListener(this);
		choosePicture2.setOnClickListener(this);

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		int which = -1;
		if (v == choosePicture1) {

			which = PICKED_ONE;

		} else if (v == choosePicture2) {

			which = PICKED_TWO;

		}

		Intent chooseIntent = new Intent(Intent.ACTION_PICK,
				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		startActivityForResult(chooseIntent, which);

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {

			Uri imageFileUri = data.getData();
			if (requestCode == PICKED_ONE) {

				bmp1 = loadBitmap(imageFileUri);
				onePicked = true;

			} else if (requestCode == PICKED_TWO) {

				bmp2 = loadBitmap(imageFileUri);
				twoPicked = true;
			}
			if(onePicked && twoPicked) {
				
				Bitmap drawingBitmap = Bitmap.createBitmap(bmp1.getWidth(),
						bmp1.getHeight(), bmp1.getConfig());
				canvas = new Canvas(drawingBitmap);
				paint = new Paint();
				canvas.drawBitmap(bmp1, 0, 0, paint);
				paint.setXfermode(new PorterDuffXfermode(android.graphics.
				PorterDuff.Mode.MULTIPLY));
				canvas.drawBitmap(bmp2, 0, 0, paint);
				compositeImageView.setImageBitmap(drawingBitmap);


			}
		}
	}

	private Bitmap loadBitmap(Uri imageFileUri) {
		Display currentDisplay = getWindowManager().getDefaultDisplay();
		float dw = currentDisplay.getWidth();
		float dh = currentDisplay.getHeight();
		Bitmap returnBmp = Bitmap.createBitmap((int) dw, (int) dh,
				Bitmap.Config.ARGB_4444);
		try {
			BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
			bmpFactoryOptions.inJustDecodeBounds = true;
			returnBmp = BitmapFactory.decodeStream(getContentResolver()
					.openInputStream(imageFileUri), null, bmpFactoryOptions);
			int heightRatio = (int) Math.ceil(bmpFactoryOptions.outHeight / dh);
			int widthRatio = (int) Math.ceil(bmpFactoryOptions.outWidth / dw);

			if (heightRatio > 1 && widthRatio > 1) {

				if (heightRatio > widthRatio) {

					bmpFactoryOptions.inSampleSize = heightRatio;

				}

				else {

					bmpFactoryOptions.inSampleSize = widthRatio;

				}

			}

			bmpFactoryOptions.inJustDecodeBounds = false;

			returnBmp = BitmapFactory.decodeStream(getContentResolver().

			openInputStream(imageFileUri), null, bmpFactoryOptions);

		}

		catch (FileNotFoundException e) {

			Log.v("ERROR", e.toString());

		}

		return returnBmp;

	}

}
