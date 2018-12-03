
package Controller;

import java.io.File;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Model.Game;
import java.util.LinkedList;
/**
 * Reflections: This class was created for the latest milestone. This 
 * class has a unique responsibility to get information from the user 
 * and put it in an XML file. 
 * 
 * If we had more time, maybe another type of file or a more friendly
 * interface for the user to enter values.
 * 
 */
public class Builder implements Serializable {
	DocumentBuilderFactory dbFactory;
	org.w3c.dom.Document doc;
	DocumentBuilder dBuilder;
	int count = 0;
	Queue<Object> waveList;
	List<Object> wave;
	
	public Builder() throws SAXException, IOException, ParserConfigurationException {

		// readFile();
		// game = new Game();
		waveList = new LinkedList<Object>();
		wave = new ArrayList<Object>();
	}
	
	public boolean isEmpty() {
		if(waveList.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
		/*if(zombieType == null) {
			return false;
		}else return true;*/
	}
	public ArrayList<Object> getWave(){
		ArrayList<Object> poll = (ArrayList<Object>) waveList.poll();
		return poll;
	}
	
	public void readFile() throws SAXException, IOException, ParserConfigurationException {

		File xmlFile = new File("src/custom.xml");
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		NodeList nList = doc.getElementsByTagName("wave");
		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			 
			Integer time = Integer.parseInt(((Element)nList.item(0)).getElementsByTagName("startTime").item(0).getTextContent());
			wave.add(time);
			System.out.println(time);
			NodeList zombie = ((Element) nList.item(temp)).getElementsByTagName("zombie");
			
			for (int i = 0; i < zombie.getLength(); i++) {
				Node current = zombie.item(i);
				if (current.getNodeType() == Node.ELEMENT_NODE) {
			         String zomType = ((Element) current).getElementsByTagName("type").item(0).getTextContent();
			         if(!zomType.equals("")){
			        	 wave.add(zomType);
			        	 //zombieType.add(zomType);
			        	 System.out.println(zomType);
			         }
			         String zombCount = ((Element) current).getElementsByTagName("count").item(0).getTextContent();
			         if(!zombCount.equals("")){
				         int z = Integer.parseInt(zombCount);
				         wave.add(z);
				         System.out.println(zombCount);
				         }
			         }
				}
			 waveList.add(wave);
        	 this.wave = new ArrayList<Object>();
			}
		}


}
