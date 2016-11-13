package com.axaway.dom;

import java.io.File;
import java.io.IOException;

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
import org.xml.sax.SAXException;

public class CustomDOMParser {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		File file = new File("E:\\events\\events.xml");
		Document document =builder.newDocument();
		Element element = document.createElementNS("http://news.google.co.in1","persons");
		document.appendChild(element);
		Element elementNS = document.createElementNS("http://news.google.co.in", "test");
		elementNS.setTextContent("bhoopendra");
		element.appendChild(elementNS);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer  transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(file);
		transformer.transform(domSource, streamResult);
		System.out.println("Done creating result");
	}
}
