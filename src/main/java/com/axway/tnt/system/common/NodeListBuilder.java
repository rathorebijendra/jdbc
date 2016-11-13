/*
 * Copyright (c) 2013 by Axway Software All brand or product names are
 * trademarks or registered trademarks of their respective holders. This
 * document and the software described in this document are the property of
 * Axway Software and are protected as Axway Software trade secrets. No part of
 * this work may be reproduced or disseminated in any form or by any means,
 * without the prior written permission of Axway Software.
 */
package com.axway.tnt.system.common;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public abstract class NodeListBuilder {

	private final DocumentBuilderFactory documentBuilderFactory;

	private Document document;
	private Element currentElement;

	public NodeListBuilder(final DocumentBuilderFactory documentBuilderFactory) {
		this.documentBuilderFactory = documentBuilderFactory;
	}

	public final NodeList toNodeList() throws ParserConfigurationException {
		return getDocument().getDocumentElement().getChildNodes();
	}

	protected final void setTextContent(final String value)
			throws DOMException, ParserConfigurationException {
		getCurrentElement().setTextContent(value);
	}

	protected final void setAttribute(final String name, final String value)
			throws DOMException, ParserConfigurationException {
		getCurrentElement().setAttribute(name, value);
	}

	protected final void startElement(final QName qName) throws DOMException,
			ParserConfigurationException {
		final String prefix = StringUtils.isEmpty(qName.getPrefix()) ? "e"
				: qName.getPrefix();
		final String qualifiedName = prefix + ":" + qName.getLocalPart();
		final Element element = getDocument().createElementNS(
				qName.getNamespaceURI(), qualifiedName);
		getCurrentElement().appendChild(element);
		setCurrentElement(element);
	}

	protected final void startElementComplex(final QName qName)
			throws DOMException, ParserConfigurationException {
		final String prefix = StringUtils.isEmpty(qName.getPrefix()) ? "e"
				: qName.getPrefix();
		final String qualifiedName = prefix + ":" + qName.getLocalPart();
		final Element element = getDocument().createElementNS(
				qName.getNamespaceURI(), qualifiedName);
		getCurrentElement().appendChild(element);
		//setCurrentElement(element);
		final Element childElement = getDocument().createElementNS("http://epcis.axway.com", "e:EXT");
		element.appendChild(childElement);
		setCurrentElement(childElement);
	}

	protected final void endElement() throws ParserConfigurationException {
		setCurrentElement((Element) getCurrentElement().getParentNode());
	}
	
	protected final void endElementComplex() throws ParserConfigurationException {
		setCurrentElement((Element) getCurrentElement().getParentNode().getParentNode());
	}


	private Element getCurrentElement() throws ParserConfigurationException {
		if (currentElement == null) {
			currentElement = getDocument().getDocumentElement();
		}
		return currentElement;
	}

	private void setCurrentElement(final Element currentElement) {
		this.currentElement = currentElement;
	}

	private Document getDocument() throws ParserConfigurationException {
		if (document == null) {
			document = documentBuilderFactory.newDocumentBuilder()
					.newDocument();
			document.appendChild(document.createElement("root"));
		}
		return document;
	}
}
