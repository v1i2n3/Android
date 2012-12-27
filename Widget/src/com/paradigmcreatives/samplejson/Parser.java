package com.paradigmcreatives.samplejson;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Parser {
	List<Contacts> items;
	private MainActivity mContext;

	public Parser(String response, MainActivity context) {

		mContext = context;
		items = new ArrayList<Contacts>();
		try {
			JSONObject jsonobject = new JSONObject(response);
			JSONArray jsArray = jsonobject.getJSONArray("contacts");

			for (int i = 0; i < jsArray.length(); i++) {

				Contacts mContact = new Contacts();
				JSONObject object1 = jsArray.getJSONObject(i);
				mContact.setId(object1.getString("id"));
				mContact.setName(object1.getString("name"));
				mContact.setEmail(object1.getString("email"));
				mContact.setAddress(object1.getString("address"));
				mContact.setGender(object1.getString("gender"));
				JSONObject object2 = object1.getJSONObject("phone");
				mContact.setMobile(object2.getString("mobile"));
				mContact.setHome(object2.getString("home"));
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
