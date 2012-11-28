package no.nith.pj3100_13.snowflakes_of_doom.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ObjectSerializer {
	
	public static <T> T fromXML(String url) {
		URL xmlUrl = null;
		HttpURLConnection urlConnection = null;
		
		try {
			xmlUrl = new URL(url);
			urlConnection = (HttpURLConnection) xmlUrl.openConnection();
			InputStream inputStream = 
					new BufferedInputStream(urlConnection.getInputStream());
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new InputSource(
					new StringReader(readStream(inputStream))));
			
			doc.getDocumentElement().normalize();
			
			StringBuilder sb = new StringBuilder();
			
			NodeList nodeListP = doc.getElementsByTagName("p");
			
			//Får ut image url
			NodeList nodeListTitle = doc.getElementsByTagName("title");

			nodeListTitle = nodeListTitle.item(0).getChildNodes();
			System.out.println(((Node)nodeListTitle.item(0)).getNodeValue());
			
			
			//Får ut tekst
			for (int i = 2; i < nodeListP.getLength(); i++) {
				
				NodeList nodeList = nodeListP.item(i).getChildNodes();
				System.out.println(nodeList.getLength());
				
				
				for(int j = 0; j < nodeList.getLength(); j++) {
					
					//Sjekker om det er noen Childs som har en verdi
					if (((Node) nodeList.item(j)).getNodeValue() == null) {
	
						Element element = (Element) nodeList.item(j);
	
						NodeList noList = element.getChildNodes();
						
						if (noList.getLength() > 0 && 
								noList.item(0).getNodeValue() != null) {
							System.out.println(((Node) noList.item(0)).getNodeValue());
							sb.append(((Node) noList.item(0)).getNodeValue())
							.append("\n");
						}
						//Henter ut tekst under P taggen som ikke ligger 
						//under et barn
					} else if (((Node) nodeList.item(j)).getNodeValue() != null) {
						System.out.println(((Node) nodeList.item(j)).getNodeValue());
						sb.append(((Node) nodeList.item(j)).getNodeValue())
						.append("\n");
					}
				}
			}
			
			return (T) sb.toString();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} finally {
			if(urlConnection != null) {
				urlConnection.disconnect();
			}
			
		}
		
		return null;
	}
	
	private static String readStream(InputStream inputStream) {
		String line = null;
		try {
			BufferedReader r = 
					new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder total = new StringBuilder();
			while ((line = r.readLine()) != null) {
				total.append(line);
			}
			
			return total.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
