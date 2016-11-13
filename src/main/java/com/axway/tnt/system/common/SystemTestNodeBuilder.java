package com.axway.tnt.system.common;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;

import com.axway.tnt.system.common.NodeListBuilder;

public class SystemTestNodeBuilder extends NodeListBuilder{


	public SystemTestNodeBuilder(final DocumentBuilderFactory documentBuilderFactory) {
		super(documentBuilderFactory);
	}

	public SystemTestNodeBuilder addExpirationDate(
			final String expirationDate) throws DOMException,
			ParserConfigurationException {
		if (expirationDate != null) {
			startElement(SystemTestExtension.EXPIRATIONDATE);
			setTextContent(expirationDate);
			endElement();
		}
		return this;
	}

	public SystemTestNodeBuilder addLotNumber(final String lotNumber)
			throws DOMException, ParserConfigurationException {
		if (lotNumber != null) {
			startElement(SystemTestExtension.LOTNUMBER);
			setTextContent(lotNumber);
			endElement();
		}
		return this;
	}

	public SystemTestNodeBuilder addProductionDate(
			final String productionDate) throws DOMException,
			ParserConfigurationException {
		if (productionDate != null) {
			startElement(SystemTestExtension.PRODUCTIONDATE);
			setTextContent(productionDate);
			endElement();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addQuantity(
			final String quantity) throws DOMException,
			ParserConfigurationException {
		if (quantity != null) {
			startElement(SystemTestExtension.QUANTITY);
			setTextContent(quantity);
			endElement();
		}
		return this;
	}

	public SystemTestNodeBuilder addEXT16(
			final String shipTo) throws DOMException,
			ParserConfigurationException {
		if (shipTo != null) {
			startElementComplex(SystemTestExtension.EXT16);
			setTextContent(shipTo);
			endElementComplex();
		}
		return this;
	}

	public SystemTestNodeBuilder addEXT1(
			final String addEXT1) throws DOMException,
			ParserConfigurationException {
		if (addEXT1 != null) {
			startElement(SystemTestExtension.EXT1);
			setTextContent(addEXT1);
			endElement();
		}
		return this;
	}

	public SystemTestNodeBuilder addEXT2(
			final String EXT2) throws DOMException,
			ParserConfigurationException {
		if (EXT2 != null) {
			startElement(SystemTestExtension.EXT2);
			setTextContent(EXT2);
			endElement();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT3(
			final String EXT3) throws DOMException,
			ParserConfigurationException {
		if (EXT3 != null) {
			startElement(SystemTestExtension.EXT3);
			setTextContent(EXT3);
			endElement();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT4(
			final String EXT4) throws DOMException,
			ParserConfigurationException {
		if (EXT4 != null) {
			startElement(SystemTestExtension.EXT4);
			setTextContent(EXT4);
			endElement();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT5(
			final String EXT5) throws DOMException,
			ParserConfigurationException {
		if (EXT5 != null) {
			startElement(SystemTestExtension.EXT5);
			setTextContent(EXT5);
			endElement();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT6(
			final String EXT6) throws DOMException,
			ParserConfigurationException {
		if (EXT6 != null) {
			startElement(SystemTestExtension.EXT6);
			setTextContent(EXT6);
			endElement();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT7(
			final String EXT7) throws DOMException,
			ParserConfigurationException {
		if (EXT7 != null) {
			startElement(SystemTestExtension.EXT7);
			setTextContent(EXT7);
			endElement();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT8(
			final String EXT8) throws DOMException,
			ParserConfigurationException {
		if (EXT8 != null) {
			startElement(SystemTestExtension.EXT8);
			setTextContent(EXT8);
			endElement();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT9(
			final String EXT9) throws DOMException,
			ParserConfigurationException {
		if (EXT9 != null) {
			startElement(SystemTestExtension.EXT9);
			setTextContent(EXT9);
			endElement();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT10(
			final String EXT10) throws DOMException,
			ParserConfigurationException {
		if (EXT10 != null) {
			startElement(SystemTestExtension.EXT10);
			setTextContent(EXT10);
			endElement();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT11(
			final String EXT11) throws DOMException,
			ParserConfigurationException {
		if (EXT11 != null) {
			startElement(SystemTestExtension.EXT11);
			setTextContent(EXT11);
			endElement();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT12(
			final String EXT12) throws DOMException,
			ParserConfigurationException {
		if (EXT12 != null) {
			startElement(SystemTestExtension.EXT12);
			setTextContent(EXT12);
			endElement();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT13(
			final String EXT13) throws DOMException,
			ParserConfigurationException {
		if (EXT13 != null) {
			startElementComplex(SystemTestExtension.EXT13);
			setTextContent(EXT13);
			endElementComplex();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT14(
			final String EXT14) throws DOMException,
			ParserConfigurationException {
		if (EXT14 != null) {
			startElementComplex(SystemTestExtension.EXT14);
			setTextContent(EXT14);
			endElementComplex();
		}
		return this;
	}
	
	public SystemTestNodeBuilder addEXT15(
			final String EXT15) throws DOMException,
			ParserConfigurationException {
		if (EXT15 != null) {
			startElementComplex(SystemTestExtension.EXT15);
			setTextContent(EXT15);
			endElementComplex();
		}
		return this;
	}
	
	private void startElement(final SystemTestExtension extension)
			throws DOMException, ParserConfigurationException {
		startElement(extension.qualifiedName());
	}
	
	private void startElementComplex(final SystemTestExtension extension)
			throws DOMException, ParserConfigurationException {
		startElementComplex(extension.qualifiedName());
	}

}
