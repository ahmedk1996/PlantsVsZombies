package Model;

import java.io.File;
import java.io.IOException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Controller.Controller;

public class Builder {

	private Game game;
	DocumentBuilderFactory dbFactory;
	org.w3c.dom.Document doc;
	DocumentBuilder dBuilder;
	public Builder() throws SAXException, IOException, ParserConfigurationException {
		
		readFile();
		game = new Game();
	}
	public void readFile() throws SAXException, IOException, ParserConfigurationException {
		
		File xmlFile = new File("src/custom.xml");
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("wave");
		
		for (int temp = 0 ; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("Current Element :" + nNode.getNodeName());
			
		/*	if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("Start Time : " + eElement.getElementsByTagName("startTime").item(0).getTextContent());
				System.out.println("zombie : " + eElement.getElementsByTagName("zombies").item(0).getTextContent());
				System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
			}*/
		}
		
	}
	
	
}
