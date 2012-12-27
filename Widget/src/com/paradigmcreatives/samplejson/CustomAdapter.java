package com.paradigmcreatives.samplejson;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	private Context mContext;
	private List<Contacts> items;

	public CustomAdapter(MainActivity mainActivity,List<Contacts> contacts) {
		mContext = mainActivity;
		items=contacts;
		
	}
	public int getCount() {
		
		return items.size();
	}

	public Object getItem(int position) {

		return items.get(position);
	}

	public long getItemId(int position) {

		
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		System.out.println("position" +position);
		ViewHolder holder;
		LayoutInflater mInflater;

		if (convertView == null) {

			mInflater = LayoutInflater.from(mContext);
			convertView = mInflater.inflate(R.layout.adapter, null);
			holder = new ViewHolder();
			holder.id = (TextView) convertView.findViewById(R.id.id);
			holder.name = (TextView) convertView.findViewById(R.id.name);
			holder.email = (TextView) convertView.findViewById(R.id.email);
			holder.address = (TextView) convertView.findViewById(R.id.address);
			holder.gender = (TextView) convertView.findViewById(R.id.gender);
			holder.home = (TextView) convertView.findViewById(R.id.home);
			holder.mobile = (TextView) convertView.findViewById(R.id.mobile);
			holder.office = (TextView) convertView.findViewById(R.id.office);
			holder.mImageView = (ImageView) convertView
					.findViewById(R.id.image);
			convertView.setTag(holder);

		} else {

			holder = (ViewHolder) convertView.getTag();
		}

		holder.id.setText(items.get(position).getId());
		holder.email.setText(items.get(position).getEmail());
		holder.name.setText(items.get(position).getName());
		holder.address.setText(items.get(position).getAddress());
		holder.gender.setText(items.get(position).getGender());
		holder.home.setText(items.get(position).getHome());
		holder.mobile.setText(items.get(position).getMobile());
		holder.office.setText(items.get(position).getOffice());
		
		return convertView;
	}

}
