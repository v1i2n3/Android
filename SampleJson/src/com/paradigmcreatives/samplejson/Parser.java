package com.paradigmcreatives.samplejson;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class Parser {
	Contacts mContact = new Contacts();
    List<Contacts> items;
    private MainActivity mContext;
	public Parser(String response,MainActivity context) {
		
		mContext = context;
		items = new ArrayList<Contacts>();
		try {
			JSONObject jsonobject = new JSONObject(response);
			JSONArray jsArray = jsonobject.getJSONArray("contacts");
			for (int i = 0; i < jsArray.length(); i++) {
				JSONObject object1 = jsArray.getJSONObject(i);
				//System.out.println("id" + object1.getString("id"));
				mContact.setId(object1.getString("id"));
				//System.out.println("name" +object1.getString("name"));
				mContact.setName(object1.getString("name"));
				//System.out.println("email" +object1.getString("email"));
				mContact.setEmail(object1.getString("email"));
				//System.out.println("address"+object1.getString("address"));
				mContact.setAddress(object1.getString("address"));
				//System.out.println("gender"+object1.getString("gender"));
				mContact.setGender(object1.getString("gender"));
				JSONObject object2 = object1.getJSONObject("phone");
				//System.out.println("mobile"+object2.getString("mobile"));
				mContact.setMobile(object2.getString("mobile"));
				//System.out.println("home"+object2.getString("home"));
				mContact.setHome(object2.getString("home"));
				//System.out.println("office"+object2.getString("office"));
				mContact.setOffice(object2.getString("office"));
				items.add(mContact);
				
			}
			mContext.setList(items);

		} catch (JSONException setter) {
			// TODO Auto-generated catch block
			setter.printStackTrace();
		}
	}

}
