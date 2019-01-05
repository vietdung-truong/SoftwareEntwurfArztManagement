package application.tools;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class XMLtest {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
			String xml = "<Leistungen> \r\n" + 
					"  <Leistung Leistungsname=\"Heilung 1\" Erläuterung=\"Test Heilung 1\" /> \r\n" + 
					"  <Leistung Leistungsname=\"Heilung 2\" Erläuterung=\"Test Heilung 2\" /> \r\n" + 
					"  <Leistung Leistungsname=\"Heilung 3\" Erläuterung=\"Test Heilung 3\" /> \r\n" + 
					"</Leistungen>";
			XMLParser parse = new XMLParser();
			Map<String,String> map =parse.getXML(xml);
			System.out.println(map.toString());
			String s = parse.setXML(map);
			System.out.println(s);
			
	}

}
