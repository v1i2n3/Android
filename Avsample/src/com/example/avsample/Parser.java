package com.example.avsample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Parser {

	Products mContext;
	List<HashMap<String, String>> mDetails;

	public Parser(String data, Products products) {
		// TODO Auto-generated constructor stub
		mContext = products;
		mDetails = new ArrayList<HashMap<String, String>>();
		try {
			JSONObject jobject = new JSONObject(data);
			for (int i = 0; i < jobject.length(); i++) {
				HashMap<String, String> mHashMap = new HashMap<String, String>();
				String value = Integer.toString(i);
				System.out.println("integer" + value);
				JSONObject object1 = jobject.getJSONObject(value);

				String productname = object1.getString("productname");
				if (productname.equals("")) {
					mHashMap.put("productname", "Name is not yet updated");
				} else {
					mHashMap.put("productname",
							"product name"+": "+object1.getString("productname"));
				}

				String imageurl = object1.getString("imageurl");
				if (imageurl.equals("")) {
					mHashMap.put("url", "Image url is not yet updated");
				} else {
					mHashMap.put("url", object1.getString("imageurl"));
				}

				String producturl = object1.getString("producturl");
				if (producturl.equals("")) {
					mHashMap.put("producturl", "Product url is not yet updated");
				} else {
					mHashMap.put("producturl", "Product url"+": "+object1.getString("producturl"));
				}

				String price = object1.getString("price");
				if (price.equals("")) {
					mHashMap.put("price",
							"Price of the product is not yet updated");
				} else {
					mHashMap.put("price", "Price"+": "+object1.getString("price"));
				}

				String currency = object1.getString("currency");
				if (currency.equals("")) {
					mHashMap.put("currency",
							"Type of currency is not yet updated");
				} else {
					mHashMap.put("currency", "Currency"+ ": "+object1.getString("currency"));
				}

				String saleprice = object1.getString("saleprice");
				if (saleprice.equals("")) {
					mHashMap.put("saleprice", "Saleprice is not yet updated");
				} else {
					mHashMap.put("saleprice", "Sale price"+": "+object1.getString("saleprice"));
				}

				String storename = object1.getString("storename");
				System.out.println("Store name" +storename);
				if (storename.equals("")) {
					mHashMap.put("storename", "Store name is not yet updated");
				} else {
					mHashMap.put("storename", "Store name"+": "+object1.getString("storename"));
				}

				mDetails.add(mHashMap);
			}
			mContext.setList(mDetails);

		} catch (JSONException setter) {
			// TODO Auto-generated catch block
			setter.printStackTrace();
		}
	}

}
