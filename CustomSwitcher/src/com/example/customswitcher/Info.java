package com.example.customswitcher;

public class Info {

	String mName;
	String mUrl;

	public String getName() { // getting name
		return mName;
	}

	public void setName(String name) { // setting name
		this.mName = name;
	}

	public String getUrl() { // getting url strin
		return mUrl;
	}

	public void setUrl(String url) { // setting url string
		this.mUrl = url;
	}

	public Info(String name, String url) {
		// TODO Auto-generated constructor stub
		this.mName = name; // assigning value to the mName.
		this.mUrl = url; // assigning value to the mUrl
	}

}
