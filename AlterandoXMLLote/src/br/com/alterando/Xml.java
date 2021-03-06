package br.com.alterando;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class Xml {

	private DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
	private DocumentBuilder docBuilder = null;
	private Document doc = null;
	
	
	public boolean alterarXml(String tahAbrir, String textoNovo, File filepath){
		
		try {
			docBuilder = dbf.newDocumentBuilder();
			doc = docBuilder.parse(filepath);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Element tag = doc.getDocumentElement();
		
		Element infNFe = (Element) tag.getElementsByTagName(tahAbrir).item(0);
		
		infNFe.setTextContent(textoNovo);
		
		XMLSerializer serializer;
		try {
			serializer = new XMLSerializer(new FileOutputStream(filepath), 
					new OutputFormat(doc, "iso-8859-1", true));
			serializer.serialize(doc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	
	
}
