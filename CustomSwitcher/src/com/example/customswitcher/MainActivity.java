package com.example.customswitcher;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	private CustomSwitcher mCustom;
	private static int s = 0;
	Info[] mInfo = new Info[] {
			new Info(
					"Skoda",
					"http://t3.gstatic.com/images?q=tbn:ANd9GcSSXw3JMNGboVpooLndGdS7Vg7lFxJnkBp_fC4AoUHf1wbRbtTlYw"),
			new Info(
					"Squ-car japanese",
					"http://t2.gstatic.com/images?q=tbn:ANd9GcQq9nRuNznjBQ3FtjUYBgAiQURtUPf1lHtRHcsAyPNehR9vM34bMg"),
			new Info(
					"Lexus",
					"http://t1.gstatic.com/images?q=tbn:ANd9GcRtXi42cJFrgu3I1GltgquzGAJcP4sdcNSoZ9IEuvrjU8rN0MFj"),
			new Info(
					"Logo",
					"http://t2.gstatic.com/images?q=tbn:ANd9GcR9TNvv_z_dMfTYxEX7YO_o7VPrLC1tvcuNyCFhfN6maFj7-Cnm"),
			new Info(
					"Mercedes mclauren",
					"http://t2.gstatic.com/images?q=tbn:ANd9GcT_iHCvObIBmqUakVZFkl50TpHvsYRaXlEHkKo027usY1JEOic2") };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mCustom = (CustomSwitcher) findViewById(R.id.customswitcher); // getting
																		// customswitcher
																		// from
																		// main.xml
																		// layout.
		mCustom.setFactory(new MycustomSwitcher()); // giving view to the
													// customswitcher.
		Button mNext = (Button) findViewById(R.id.next);
		mNext.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					mCustom.setdata(mInfo[s].getName(), mInfo[s].getUrl()); // Setting
																			// data
																			// to
																			// the
																			// CustomSwitcher.
					s++;
				} catch (Exception e) {

				}

			}
		});

		Button mPrevious = (Button) findViewById(R.id.previous);
		mPrevious.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					--s;
					mCustom.setdata(mInfo[s].getName(), mInfo[s].getUrl()); // Setting
																			// data
																			// to
																			// the
																			// Customswitcher.

				} catch (Exception e) {

				}
			}
		});

	}

	public class MycustomSwitcher implements ViewFactory {

		public View makeView() {
			// TODO Auto-generated method stub
			LayoutInflater mInflater = getLayoutInflater();
			View mView = mInflater.inflate(R.layout.cutom_view, null);
			return mView;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
