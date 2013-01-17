package com.paradigmcreatives.revision;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlHandler extends DefaultHandler {

	private List<UserXml> Users;
	private String tempVal;
	private UserXml tempuser;

	public XmlHandler() {

		Users = new ArrayList<UserXml>();
	}

	public List<UserXml> getUsers() {

		System.out.println("xmlHandler" + Users);
		return Users;
	}

	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("Document parsing started");
	}

	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("Document parsing completed");
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		tempVal = "";
		if (qName.equalsIgnoreCase("user")) {
			tempuser = new UserXml();
		}
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		super.endElement(uri, localName, qName);
		if (qName.equalsIgnoreCase("user")) {

			Users.add(tempuser);
		} else if (qName.equalsIgnoreCase("lastname")) {

			tempuser.setLastname(tempVal);
		} else if (qName.equalsIgnoreCase("firstname")) {

			tempuser.setFirstname(tempVal);
		}
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {

		super.characters(ch, start, length);
		tempVal = new String(ch, start, length);

	}
}
