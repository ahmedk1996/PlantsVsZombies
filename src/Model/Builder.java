package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Controller.Controller;

public class Builder {

	private Game game;
	DocumentBuilderFactory dbFactory;
	org.w3c.dom.Document doc;
	DocumentBuilder dBuilder;
	int count = 0;
	List<String> zombieType;
	List<Integer>zombieCount;
	public Builder() throws SAXException, IOException, ParserConfigurationException {

		// readFile();
		// game = new Game();
		zombieType = new ArrayList<String>();
		zombieCount = new ArrayList<Integer>();
	}

	public void readFile() throws SAXException, IOException, ParserConfigurationException {

		File xmlFile = new File("src/custom.xml");
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("wave");

		for (int temp = 0; temp < nList.getLength(); temp++) {
			 String time = ((Element)nList.item(0)).getElementsByTagName("startTime").item(0).getTextContent();
			  System.out.println(time);
			NodeList zombie = ((Element) nList.item(temp)).getElementsByTagName("zombie");
			for (int i = 0; i < zombie.getLength(); i++) {
				Node current = zombie.item(i);
				if (current.getNodeType() == Node.ELEMENT_NODE) {
					
			         String zomType = ((Element) current).getElementsByTagName("type").item(0).getTextContent();
			         zombieType.add(zomType);
			         System.out.println(zomType);
			         String zombCount = ((Element) current).getElementsByTagName("count").item(0).getTextContent();
			         int count = Integer.parseInt(zombCount);
			         zombieCount.add(count);
			         System.out.println(count);
				}
			}

		}

	}

}
