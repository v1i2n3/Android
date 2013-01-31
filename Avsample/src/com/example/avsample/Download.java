package com.example.avsample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class Download extends AsyncTask<String, Void, String> {

	private InputStream is;
	ProgressDialog progress;
	StringBuilder sb;
	Context mContext;
	ServerResponse mResponse;

	public Download(Products products, ServerResponse serverResponse) {
		// TODO Auto-generated constructor stub
		mContext = products;
		mResponse = serverResponse;
	}

	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		progress = new ProgressDialog(mContext);
		progress.setMessage("Please wait while data is loading...");
		progress.show();
	}

	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub

		try {
			DefaultHttpClient client = new DefaultHttpClient();
			//HttpGet get = new HttpGet(
					//"http://www.searchupc.com/handlers/upcsearch.ashx?request_type=3&access_token=C6666367-D16B-49EB-85B1-B8ECD2346678&upc=036000305593");
			HttpGet get = new HttpGet(params[0]);
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			if (entity != null) {

				is = entity.getContent();
			}
		} catch (ClientProtocolException setter) {
			// TODO Auto-generated catch block
			setter.printStackTrace();
		} catch (IOException setter) {
			// TODO Auto-generated catch block
			setter.printStackTrace();
		}

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			sb = new StringBuilder();
			String line = null;
			if ((line = br.readLine()) != null) {

				sb.append(line + "\n");
			}
		} catch (IOException setter) {
			// TODO Auto-generated catch block
			setter.printStackTrace();
		}

		return sb.toString();
	}

	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (progress != null) {

			progress.cancel();
		}
		if(result != null) {
			
			mResponse.setData(result);
		}

	}	

}
