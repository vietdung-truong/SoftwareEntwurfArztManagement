package application.tools;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import application.Leistung;
import javafx.collections.ObservableList;

public class XMLtest {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
			String xml = "<Leistungen> \r\n" + 
					"  <Leistung Leistungsname=\"Heilung 1\" Erläuterung=\"Test Heilung 1\" /> \r\n" + 
					"  <Leistung Leistungsname=\"Heilung 2\" Erläuterung=\"Test Heilung 2\" /> \r\n" + 
					"  <Leistung Leistungsname=\"Heilung 3\" Erläuterung=\"Test Heilung 3\" /> \r\n" + 
					"</Leistungen>";
			XMLParser parse = new XMLParser();
			ObservableList<Leistung> leistungen =parse.getXML(xml); 
			System.out.println(leistungen.iterator().next().getErlauterung() + leistungen.iterator().next().getLeistungsname() );
			String s = parse.setXML(leistungen);
			System.out.println(s);
			
	}

}
