
package com.example.avsample;

import java.util.HashMap;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DataAdapter extends BaseAdapter{

	private List<HashMap<String, String>> items;
	Products mProducts;
	ImageLoader imageLoader;
	
	public DataAdapter(Products products, List<HashMap<String, String>> data) {
		// TODO Auto-generated constructor stub
		mProducts = products;
		items = data;
		imageLoader = new ImageLoader(products);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		LayoutInflater mInflater;
		if(convertView == null) {
			mInflater = LayoutInflater.from(mProducts);
			convertView = mInflater.inflate(R.layout.inflating, null);
			holder = new ViewHolder();
			holder.mImageView = (ImageView)convertView.findViewById(R.id.image);
			holder.productname = (TextView)convertView.findViewById(R.id.productname);
			holder.producturl = (TextView)convertView.findViewById(R.id.producturl);
			holder.price = (TextView)convertView.findViewById(R.id.price);
			holder.currency = (TextView)convertView.findViewById(R.id.currency);
			holder.saleprice = (TextView)convertView.findViewById(R.id.saleprice);
			holder.storename = (TextView)convertView.findViewById(R.id.storename);
			
			convertView.setTag(holder);	
		}else {
			
			holder = (ViewHolder)convertView.getTag();
		}
		
		HashMap<String, String> hashView = new HashMap<String, String>();
		hashView = items.get(position);
		holder.productname.setText(hashView.get("productname"));
	    imageLoader.DisplayImage(hashView.get("url"),holder.mImageView);
	    holder.price.setText(hashView.get("price"));
	    holder.producturl.setText(hashView.get("producturl"));
	    holder.currency.setText(hashView.get("currency"));
	    holder.saleprice.setText(hashView.get("saleprice"));
	    holder.storename.setText(hashView.get("storename"));
		
		return convertView;
	}

	class ViewHolder {
		
		TextView productname;
		TextView producturl;
		TextView price;
		TextView currency;
		TextView saleprice;
		TextView storename;
		ImageView mImageView;
	}
	
}
