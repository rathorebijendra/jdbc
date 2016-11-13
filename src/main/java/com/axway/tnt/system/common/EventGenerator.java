package com.axway.tnt.system.common;

import static com.axway.tnt.xml.DatatypeUtils.createXMLCalendar;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.axway.tnt.epedigree.EventFactory;
import com.axway.tnt.masterdata.DefaultBusinessStep;
import com.axway.tnt.masterdata.DefaultDisposition;
import com.axway.tnt.tools.generator.DocumentFactory;

import epcglobal.epcis.xsd._1.ActionType;
import epcglobal.epcis.xsd._1.EPCISDocumentType;
import epcglobal.epcis.xsd._1.EPCListType;
import epcglobal.epcis.xsd._1.ILMDType;
import epcglobal.epcis.xsd._1.ObjectEventExtensionType;
import epcglobal.epcis.xsd._1.ObjectEventType;
import epcglobal.epcis.xsd._1.ObjectFactory;
import epcglobal.xsd._1.EPC;

public class EventGenerator {
	private Document newDocument;
	private final DocumentFactory documentFactory = new DocumentFactory();
	private final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
			.newInstance();
	private final String outputDir;
	public EventGenerator(final String outputDir) throws Exception {
		this.outputDir = outputDir;
	}

	private File getFile(final String filename) throws Exception {
		File useCaseDir = new File(outputDir);
		if (!useCaseDir.exists()) {
			FileUtils.forceMkdir(useCaseDir);
		}
		return new File(useCaseDir, filename);
	}

	public List<String> createResourceFiles(final int numberOffiles) throws Exception {
		final EPC epc = new EPC();
		epc.setValue("urn:epc:id:sgtin:0614141.777201.1");
		List<EPC> casesEPCs = new ArrayList<EPC>();
		casesEPCs.add(epc);
		LocalDate date = LocalDate.of(2016, Month.OCTOBER, 10);
		LocalDateTime dateTime= LocalDateTime.of(2016, Month.OCTOBER, 10, 10, 10, 10, 10);
		int quantity = 100;
		List<String> listFileName = new ArrayList<String>();
		fileCreater(numberOffiles, casesEPCs, date, dateTime, quantity,
				listFileName);
		return listFileName;
	}

	private void fileCreater(final int numberOffiles, List<EPC> casesEPCs,
			LocalDate date, LocalDateTime dateTime, int quantity,
			List<String> listFileName) throws Exception {
		for(int i=0;i<numberOffiles;i++){
		generateObjectEvent(casesEPCs,date.plus(i,ChronoUnit.DAYS),dateTime.plus(i,ChronoUnit.MILLIS),quantity+i);
			listFileName.add((quantity+i)+"events.xml");		
		}
	}

	public void generateObjectEvent(List<EPC> casesEPCs,final LocalDate date,final LocalDateTime dateTime,final int quantity ) throws Exception {
		final EventFactory eventFactory = new EventFactory();

		final EPCListType epcListType = new EPCListType();
		for (int i = 0; i < 1; i++) {
			epcListType.getEpc().add(casesEPCs.get(i));
		}

		final SystemTestNodeBuilder nodeBuilder = new SystemTestNodeBuilder(documentBuilderFactory);
		
		nodeBuilder.addExpirationDate(date.toString());
		nodeBuilder.addLotNumber("LOT-"+quantity);
		
		nodeBuilder.addProductionDate(dateTime.toString());
	
		nodeBuilder.addQuantity(Integer.toString(quantity));
	
		nodeBuilder.addEXT1("EXT1");
		nodeBuilder.addEXT2("EXT2");
		nodeBuilder.addEXT3("EXT3");
		nodeBuilder.addEXT4("EXT4");
		nodeBuilder.addEXT5("EXT5");
		nodeBuilder.addEXT6("EXT6");
		nodeBuilder.addEXT7("EXT7");
		nodeBuilder.addEXT8("EXT8");
		nodeBuilder.addEXT9("EXT9");
		nodeBuilder.addEXT10("EXT10");
		nodeBuilder.addEXT11("EXT11");
		nodeBuilder.addEXT12("EXT12");
		nodeBuilder.addEXT13("EXT13");
		nodeBuilder.addEXT14("EXT14");
		nodeBuilder.addEXT15("EXT15");
		nodeBuilder.addEXT16("EXT16");
		
		final ObjectEventType objectEvent = eventFactory.generateObjectEvent(
				nodeBuilder.toNodeList(), new ArrayList<String>(),
				DefaultDisposition.ACTIVE);
		objectEvent.setBizStep(DefaultBusinessStep.SHIPPING.uri());
		objectEvent.setEpcList(epcListType);
		objectEvent.setAction(ActionType.ADD);
		objectEvent.setEventTime(createXMLCalendar(new SimpleDateFormat(
				"dd/MM/yyyy HH:mm").parse("06/10/2015 07:00")));
		
		final Element expirationDate = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:expirationDate");
		expirationDate.setTextContent(date.toString());
		expirationDate.setAttribute("type","xs:date");
		
		final Element lotNumber = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:lotNumber");
		lotNumber.setTextContent("LOT-"+quantity);

		final Element productionDate = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:productionDate");
		productionDate.setTextContent(dateTime.toString());
		productionDate.setAttribute("type", "xs:dateTime");
		
		final Element quantity1 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:quantity1");
		quantity1.setTextContent(Integer.toString(quantity));
		quantity1.setAttribute("type", "xs:integer");
		
		final Element EXT1 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT1");
		EXT1.setTextContent("GHI-38");
		
		final Element EXT2 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT2");
		EXT2.setTextContent("GHI-39");
		
		final Element EXT3 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT3");
		EXT3.setTextContent("GHI-40");
		
		final Element EXT4 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT4");
		EXT4.setTextContent("GHI-41");
		
		final Element EXT5 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT5");
		EXT5.setTextContent("GHI-42");
		
		final Element EXT6 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT6");
		EXT6.setTextContent("GHI-43");
		
		final Element EXT7 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT7");
		EXT7.setTextContent("GHI-44");
		
		final Element EXT8 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT8");
		EXT8.setTextContent("GHI-45");
		
		final Element EXT9 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT9");
		EXT9.setTextContent("GHI-46");
		
		final Element EXT10 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT10");
		EXT10.setTextContent("GHI-47");
		
		final Element EXT11 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT11");
		EXT11.setTextContent("GHI-50");
		
		final Element EXT12 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT12");
		EXT12.setTextContent("GHI-51");
		
		final Element EXT13 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT13");
		final Element EXT13Child = getDocument().createElementNS("http://epcis.axway.extension/sublabel", "e:EXT");
		EXT13Child.setTextContent("GHI-52");
		EXT13.appendChild(EXT13Child);
		
		final Element EXT14 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT14");
		final Element EXT14Child = getDocument().createElementNS("http://epcis.axway.extension/sublabel", "e:EXT");
		EXT14Child.setTextContent("GHI-53");
		EXT14.appendChild(EXT14Child);
		
		final Element EXT15 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT15");
		final Element EXT15Child = getDocument().createElementNS("http://epcis.axway.extension/sublabel", "e:EXT");
		EXT15Child.setTextContent("GHI-54");
		EXT15.appendChild(EXT15Child);
		
		final Element EXT16 = getDocument().createElementNS(
				"http://epcis.axway.com/extension", "e:EXT16");
		final Element EXT16Child = getDocument().createElementNS("http://epcis.axway.extension/sublabel", "e:EXT");
		EXT16Child.setTextContent("GHI-55");
		EXT16.appendChild(EXT16Child);
		ILMDType ilmd=new ILMDType();
		ilmd.getAny().add(expirationDate);
		ilmd.getAny().add(lotNumber);
		ilmd.getAny().add(quantity1);
		ilmd.getAny().add(productionDate);
		ilmd.getAny().add(EXT1);
		ilmd.getAny().add(EXT2);
		ilmd.getAny().add(EXT3);
		ilmd.getAny().add(EXT4);
		ilmd.getAny().add(EXT5);
		ilmd.getAny().add(EXT6);
		ilmd.getAny().add(EXT7);
		ilmd.getAny().add(EXT8);
		ilmd.getAny().add(EXT9);
		ilmd.getAny().add(EXT10);
		ilmd.getAny().add(EXT11);
		ilmd.getAny().add(EXT12);
		ilmd.getAny().add(EXT13);
		ilmd.getAny().add(EXT14);
		ilmd.getAny().add(EXT15);
		ilmd.getAny().add(EXT16);
		ObjectEventExtensionType ob=new ObjectEventExtensionType();
		ob.setIlmd(ilmd);
		objectEvent.setExtension(ob);
		final List<ObjectEventType> objectEventTypes = new ArrayList<>();
		for(int i=0;i<20;i++){
			objectEventTypes.add(objectEvent);
		}
		final File out = getFile(quantity+"events.xml");
		generateFile(objectEventTypes, out);
	}

	private Document getDocument() throws ParserConfigurationException {

		if (newDocument == null) {
			newDocument = documentBuilderFactory.newDocumentBuilder()
					.newDocument();
		}
		return newDocument;
	}

	private void generateFile(final List<ObjectEventType> objectEventTypes,
			final File file) throws JAXBException,
			DatatypeConfigurationException {
		final ObjectFactory objectFactory = new ObjectFactory();

		final EPCISDocumentType epcisDocumentType = documentFactory
				.createEPCISDocument();

		for (ObjectEventType objectEventType : objectEventTypes) {
			epcisDocumentType
					.getEPCISBody()
					.getEventList()
					.getObjectEventOrAggregationEventOrQuantityEvent()
					.add(objectFactory
							.createEventListTypeObjectEvent(objectEventType));
		}

		final javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext
				.newInstance(EPCISDocumentType.class.getPackage().getName());
		final javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
		marshaller
				.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
				Boolean.TRUE);
		marshaller.marshal(objectFactory.createEPCISDocument(epcisDocumentType), file);
		
	}
	
	public static void main(String[] args) throws Exception {
		LocalDateTime fromDateTime = LocalDateTime.now();
		new EventGenerator("E:\\events").createResourceFiles(1000);
		LocalDateTime toDateTime = LocalDateTime.now();
		new TimeDifference(fromDateTime, toDateTime);
		System.out.println("Files generated");
	}
	
}
