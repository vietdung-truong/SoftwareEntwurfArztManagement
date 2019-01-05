package application.tools;

import java.io.File;
import java.io.IOException;
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
import org.xml.sax.SAXException;

public class XMLParser {

	public static void getXML(String Leistung) throws SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(Leistung);

		doc.getDocumentElement().normalize();

//		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("Leistung");
		Map <String,String> map = new HashMap<>();
		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);

			System.out.println("\nCurrent Element: " + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element elem = (Element) nNode;

				String name = elem.getAttribute("name");
				String erläuterung = elem.getAttribute("erläuterung");

//				Node node1 = elem.getElementsByTagName("firstname").item(0);
//				String erläuterung = node1.getTextContent();
//
//				Node node2 = elem.getElementsByTagName("lastname").item(0);
//				String lname = node2.getTextContent();
//
//				Node node3 = elem.getElementsByTagName("occupation").item(0);
//				String occup = node3.getTextContent();

				System.out.printf("Leistungname: %s%n", name);
				System.out.printf("Leistung Erläuterung: %s%n", erläuterung);
			}
		}
	}

	public static void setXML(String Leistung) {

		try {
			String filepath = "c:\\file.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			Node company = doc.getFirstChild();

			// Get the staff element , it may not working if tag has spaces, or
			// whatever weird characters in front...it's better to use
			// getElementsByTagName() to get it directly.
			// Node staff = company.getFirstChild();

			// Get the staff element by tag name directly
			Node staff = doc.getElementsByTagName("staff").item(0);

			// update staff attribute
			NamedNodeMap attr = staff.getAttributes();
			Node nodeAttr = attr.getNamedItem("id");
			nodeAttr.setTextContent("2");

			// append a new node to staff
			Element age = doc.createElement("age");
			age.appendChild(doc.createTextNode("28"));
			staff.appendChild(age);

			// loop the staff child node
			NodeList list = staff.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {

				Node node = list.item(i);

				// get the salary element, and update the value
				if ("salary".equals(node.getNodeName())) {
					node.setTextContent("2000000");
				}

				// remove firstname
				if ("firstname".equals(node.getNodeName())) {
					staff.removeChild(node);
				}

			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);

			System.out.println("Done");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}
}
