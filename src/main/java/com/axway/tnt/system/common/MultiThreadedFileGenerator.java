package com.axway.tnt.system.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import epcglobal.xsd._1.EPC;

public class MultiThreadedFileGenerator {

	private static EventGenerator eventGenerator; 
	LocalDate date = LocalDate.of(2016, Month.OCTOBER, 10);
	LocalDateTime dateTime= LocalDateTime.of(2016, Month.OCTOBER, 10, 10, 10, 10, 10);
	int quantity = 100;
	List<String> listFileName = new ArrayList<String>();
	List<EPC> casesEPCs = new ArrayList<EPC>();
	public MultiThreadedFileGenerator() throws Exception {
		eventGenerator = new EventGenerator("E:\\events");
		final EPC epc = new EPC();
		epc.setValue("urn:epc:id:sgtin:0614141.777201.1");
		casesEPCs.add(epc);
		
	}
	public static void main(String[] args) throws Exception {
		MultiThreadedFileGenerator fileGenerator = new MultiThreadedFileGenerator();
		int numberOffiles =1000;
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		LocalDateTime fromDateTime = LocalDateTime.now();
		for(int i=0;i<numberOffiles;i++){
			executorService.execute(fileGenerator.worker);
			//fileGenerator.listFileName.add((quantity+i)+"events.xml");		
		}
		executorService.shutdown();
		boolean finshed = executorService.awaitTermination(120, TimeUnit.DAYS);
 		if(finshed){
			LocalDateTime toDateTime = LocalDateTime.now();
			new TimeDifference(fromDateTime, toDateTime);
			System.out.println("File Creation Finished!");
		}
		
		
	}
	
	Runnable worker = new Runnable() {
		volatile int i =-1;
		@Override
		public void run() {
			i++;
			try {
				eventGenerator.generateObjectEvent(casesEPCs,date.plus(i,ChronoUnit.DAYS),dateTime.plus(i,ChronoUnit.MILLIS),quantity+i);
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}
	};
	
	
}
