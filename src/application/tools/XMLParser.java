package application.tools;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
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

import application.Behandlungsuche_Behandlungsdaten;
import application.Leistung;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class XMLParser {

	public static ObservableList<Leistung> getXML(String Leistung)
			throws SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource (new StringReader(Leistung)));

		doc.getDocumentElement().normalize();

		// System.out.println("Root element: " +
		// doc.getDocumentElement().getNodeName());
		//comment

		NodeList nList = doc.getElementsByTagName("Leistung");
		ObservableList<Leistung> leistungsdaten = FXCollections.observableArrayList();


		// Parsed Liste aus Leistungen
		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);

			System.out.println("\nCurrent Element: " + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element elem = (Element) nNode;

				// Lädt Attribute aus XML

				String name = elem.getAttribute("Leistungsname");

				String erläuterung = elem.getAttribute("Erläuterung");
				
				Leistung leistung = new Leistung(name, erläuterung);

				leistungsdaten.add(leistung);

				System.out.printf("Leistungname: %s%n", name);
				System.out.printf("Leistung Erläuterung: %s%n", erläuterung);
			}
		}
		return leistungsdaten;
	}

	public static String setXML(ObservableList<Leistung> liste) throws ParserConfigurationException,
    TransformerException  {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        
        Element root = doc.createElement("Leistungen");
        doc.appendChild(root);

        for (Leistung entry : liste)
        {
        	 root.appendChild(createUser(doc, entry.getLeistungsname().get(), entry.getErlauterung().get()));
            
        }
        // für commit
       

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf = transformerFactory.newTransformer();
        StringWriter writer = new StringWriter();
        
        transf.transform(new DOMSource (doc), new StreamResult (writer));
        String s = writer.getBuffer().toString();
        

        return s;
		
	}
	  private static Node createUser(Document doc, String Leistungsname, String Erläuterung) {
	        
	        Element user = doc.createElement("Leistung");

	        user.setAttribute("Leistungsname", Leistungsname);
	        user.setAttribute("Erläuterung", Erläuterung);
	      

	        return user;
	    }
	
	 
	 
	 
	 
	 
}
