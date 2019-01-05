package application.tools;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collection;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class XMLTestClass {
	
	/**
	 * Diese Klasse dient zum Testen. Wenn dieses Klaase nicht mehr genötigt wird, sollte sie gelöscht werden.
	 * @param args
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	

	
	public static void main(String[] args)throws SAXException,
    IOException, ParserConfigurationException {
	
	String example = ""
				//+ "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Leistungen> \r\n" + 
				"  <Leistung Leistungsname=\"Heilung 1\" Erlauterung=\"Test Heilung 1\" /> \r\n" + 
				"  <Leistung Leistungsname=\"Heilung 2\" Erlauterung=\"Test Heilung 2\" /> \r\n" + 
				"  <Leistung Leistungsname=\"Heilung 3\" Erlauterung=\"Test Heilung 3\" /> \r\n" + 
				"</Leistungen>";

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = factory.newDocumentBuilder();
    Document doc = dBuilder.parse(new InputSource(new StringReader(example)));
    
     
    
    doc.getDocumentElement().normalize();
    
    System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

    NodeList nList = doc.getElementsByTagName("Leistung");

    for (int i = 0; i < nList.getLength(); i++) {

        Node nNode = nList.item(i);

        System.out.println("\nCurrent Element: " + nNode.getNodeName());
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element elem = (Element) nNode;

            String name = elem.getAttribute("Leistungsname");
            String erleuterung = elem.getAttribute("Erlauterung");
            System.out.printf("Leistungsname : %s%n", name);
            System.out.printf("Erläuterung: %s%n", erleuterung);
        	}
    	}
	}	
	
}
