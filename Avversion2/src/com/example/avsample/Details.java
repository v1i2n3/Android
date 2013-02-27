package com.example.avsample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends Activity {

	ImageView mImageView;
	TextView producturl;
	TextView productname;
	TextView price;
	TextView saleprice;
	TextView storename;
	TextView currency;
	Button mDetails;

	ImageLoader imageloader;
	Intent mIntent;
	ConnectivityManager cMgr;
	NetworkInfo nInfo;

	String url;
	String productul;
	String productnam;
	String pric;
	String salepric;
	String storenam;
	String currenc;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		
		cMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		nInfo = cMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

		mImageView = (ImageView) findViewById(R.id.image);
		producturl = (TextView) findViewById(R.id.producturl);
		productname = (TextView) findViewById(R.id.productname);
		price = (TextView) findViewById(R.id.price);
		saleprice = (TextView) findViewById(R.id.saleprice);
		storename = (TextView) findViewById(R.id.storename);
		currency = (TextView) findViewById(R.id.currency);
		mDetails = (Button)findViewById(R.id.more_details);

		mIntent = getIntent();

		url = mIntent.getStringExtra("Url");
		productnam = mIntent.getStringExtra("productname");
		productul = mIntent.getStringExtra("producturl");
		pric = mIntent.getStringExtra("price");
		salepric = mIntent.getStringExtra("saleprice");
		storenam = mIntent.getStringExtra("storename");
		currenc = mIntent.getStringExtra("currency");

		imageloader = new ImageLoader(this);
		
		imageloader.DisplayImage(url, mImageView);
	
		
		if (productnam.equals("")) {

			productname.setText("Product Name" + "    :   "
					+ "Product name is not updated");

		} else {

			productname.setText(productnam);

		}

		if (productul.equals("")) {

			producturl.setText("Product url" + "    :   "
					+ "Product url is not updated");

		} else {

			producturl.setText( "Product Url"+" : "+productul);

		}

		if (pric.equals("")) {

			price.setText("Price" + "    :   " + "Price is not updated");

		} else {

			price.setText(pric);

		}

		if (salepric.equals("")) {

			saleprice.setText("Saleprice" + "    :   "
					+ "Saleprice is not updated");

		} else {

			saleprice.setText(salepric);

		}

		if (storenam.equals("")) {

			storename.setText("Store Name" + "    :   "
					+ "Store name is not updated");

		} else {

			storename.setText(storenam);

		}

		if (currenc.equals("")) {

			currency.setText("Currency" + "    :   "
					+ "Currency typre is not updated");

		} else {

			currency.setText(currenc);

		}
		mDetails.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(!(nInfo.isConnected())) {
					Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(productul));
					System.out.println(productul);
					startActivity(mIntent);
				}else {
					Toast.makeText(Details.this, getResources().getString(R.string.netinfo),
							Toast.LENGTH_LONG).show();
				}
				
			}
		});

	}

}
