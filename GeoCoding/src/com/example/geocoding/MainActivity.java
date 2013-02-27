package com.parasdigmcreatives.geocoding;

import java.io.IOException;
import java.util.List;
import java.util.Locale;



import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private LocationManager lm;
	private String provider;
	private Location mLocation;
	private String latitude, longitude;
	private List<Address> data;
	
	private Button submit;
	EditText lat;
	EditText lang;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		// provider = LocationManager.NETWORK_PROVIDER;
		// mLocation = lm.getLastKnownLocation(provider);
      /*  Geocoder gc = new Geocoder(this);
        try {
			List<Address>add = gc.getFromLocationName("Hyderabad",5);
			System.out.println("add"+add.get(0).getCountryName());
		} catch (IOException setter1) {
			// TODO Auto-generated catch block
			setter1.printStackTrace();
		}*/
        
		lat = (EditText) findViewById(R.id.lat);
		//lang = (EditText) findViewById(R.id.lang);

		submit = (Button) findViewById(R.id.submit);
		submit.setText("Submit");
		submit.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				latitude = lat.getText().toString();
				//longitude = lang.getText().toString();
				//System.out.println(longitude);
				//System.out.println(latitude);
				 Geocoder gc = new Geocoder(MainActivity.this,Locale.getDefault());
				try {
					data = gc.getFromLocationName(latitude, 3);
					TextView text = (TextView) findViewById(R.id.address);
					System.out.println(data);
					double str =  data.get(0).getLatitude();
					double str1 = data.get(0).getLongitude();
					StringBuilder sb = new StringBuilder();
					sb.append(str);
					sb.append(str1);
					text.setText(sb);
					
				} catch (NumberFormatException setter) {
					// TODO Auto-generated catch block
					setter.printStackTrace();
				} catch (IOException setter) {
					// TODO Auto-generated catch block
					setter.printStackTrace();
				}
				 
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
