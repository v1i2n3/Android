package com.paradigmcreatives.revision;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class XmlParser {

	public static List<UserXml> parse(InputStream is) throws IOException {

		List<UserXml> data = null;

		try {
			XMLReader reader = SAXParserFactory.newInstance().newSAXParser()
					.getXMLReader();
			XmlHandler handler = new XmlHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(is));
			data = handler.getUsers();
			System.out.println("Data" + data);
		} catch (SAXException setter) {
			// TODO Auto-generated catch block
			setter.printStackTrace();
		} catch (ParserConfigurationException setter) {
			// TODO Auto-generated catch block
			setter.printStackTrace();
		}

		return data;
	}

}
