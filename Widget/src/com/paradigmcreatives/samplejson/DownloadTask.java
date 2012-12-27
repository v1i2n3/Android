package com.paradigmcreatives.samplejson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class DownloadTask extends AsyncTask<Void, Void, String> {

	private ProgressDialog mProgressDialog;
	private Context mContext;
	InputStream is;
	ServerResponse mResponse;

	public DownloadTask(Context context, ServerResponse response) {

		mContext = context;
		mResponse = response;
	}

	protected void onPreExecute() {

		super.onPreExecute();
		mProgressDialog = new ProgressDialog(mContext);
		mProgressDialog.setMessage("please wait, while data is loading...");
		mProgressDialog.show();

	}

	protected String doInBackground(Void... params) {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://api.androidhive.info/contacts/");
		try {
			HttpResponse response = client.execute(post);
			HttpEntity httpEntity = response.getEntity();

			if (httpEntity != null) {

				is = response.getEntity().getContent();

			}

		} catch (ClientProtocolException setter) {

			setter.printStackTrace();

		} catch (IOException setter) {

			setter.printStackTrace();
		}

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			StringBuilder sb = new StringBuilder();

			String line = null;

			while ((line = br.readLine()) != null) {

				sb.append(line + "\n");

			}

			is.close();

			return sb.toString();

		} catch (IOException setter) {
			// TODO Auto-generated catch block

			setter.printStackTrace();

		}

		return null;

	}

	protected void onPostExecute(String result) {

		if (mProgressDialog != null) {
			mProgressDialog.dismiss();
		}

		if (result != null) {
			mResponse.setdata(result);
		}

	}
}
