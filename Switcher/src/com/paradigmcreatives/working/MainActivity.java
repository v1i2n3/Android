package com.paradigmcreatives.working;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	private TextSwitcher text;
	private ImageSwitcher image;
	private Button next;

	private String[] message;
	private Integer[] imag;
	static int i = 0;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		 * AlertDialog.Builder mDialog = new AlertDialog.Builder(this);
		 * mDialog.create(); mDialog.setTitle("Warning");
		 * mDialog.setMessage("Don't shout....."); mDialog.show();
		 */

		/*
		 * Dialog mdialog = new Dialog(this);
		 * mdialog.setContentView(R.layout.custom_activity);
		 * mdialog.setTitle("Alert"); TextView tv =
		 * (TextView)findViewById(R.id.text); ImageView image
		 * =(ImageView)mdialog.findViewById(R.id.image);
		 * image.setImageResource(R.drawable.ic_launcher);
		 * mdialog.setCancelable(true); mdialog.show();
		 */
		/*
		 * RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);
		 * TextView tv = new TextView(this); tv.setText("hi how r u");
		 * layout.addView(tv);
		 */

		// DatePickerDialog dialog = new DatePickerDialog(context, datelistener,
		// year, monthOfYear, dayOfMonth);
		message = new String[] { "How are you", "what are you doing",
				"What about your work" };
		imag = new Integer[] { R.drawable.ic_launcher, R.drawable.o,
				R.drawable.one };
		text = (TextSwitcher) findViewById(R.id.textswitcher);
		text.setFactory(new Mytextswitcher());
		// text.setCurrentText("Hi,how are you");
		image = (ImageSwitcher) findViewById(R.id.imageswitcher);
		image.setFactory(new MyImageSwitcher());
		next = (Button) findViewById(R.id.next);
		next.setText("Next");
		next.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (i <= message.length) {
					try {
						text.setText(message[i]);
						image.setImageResource(imag[i]);
						i++;
					} catch (Exception e) {

					}
				} else {
					next.setClickable(false);
				}

			}
		});
		Button previous = (Button) findViewById(R.id.previous);
		previous.setText("Previous");
		previous.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				try {
					--i;
					text.setText(message[i]);
					image.setImageResource(imag[i]);
				} catch (Exception e) {

				}

			}
		});

	}

	public class Mytextswitcher implements ViewFactory {

		public View makeView() {
			// TODO Auto-generated method stub
			TextView tv = new TextView(MainActivity.this);
			tv.setTextSize(20);
			return tv;
		}

	}

	public class MyImageSwitcher implements ViewFactory {

		public View makeView() {
			// TODO Auto-generated method stub
			ImageView iv = new ImageView(MainActivity.this);
			iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
			return iv;
		}

	}

}
