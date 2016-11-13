package com.axway.tnt.system.common;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeDifference {
	public TimeDifference(LocalDateTime fromDateTime,LocalDateTime toDateTime) {
		LocalDateTime tempDateTime = LocalDateTime.from( fromDateTime );

		long years = tempDateTime.until( toDateTime, ChronoUnit.YEARS);
		tempDateTime = tempDateTime.plusYears( years );

		long months = tempDateTime.until( toDateTime, ChronoUnit.MONTHS);
		tempDateTime = tempDateTime.plusMonths( months );

		long days = tempDateTime.until( toDateTime, ChronoUnit.DAYS);
		tempDateTime = tempDateTime.plusDays( days );


		long hours = tempDateTime.until( toDateTime, ChronoUnit.HOURS);
		tempDateTime = tempDateTime.plusHours( hours );

		long minutes = tempDateTime.until( toDateTime, ChronoUnit.MINUTES);
		tempDateTime = tempDateTime.plusMinutes( minutes );

		long seconds = tempDateTime.until( toDateTime, ChronoUnit.SECONDS);
		
		long miliSeconds = tempDateTime.until( toDateTime, ChronoUnit.MILLIS);
		
		long microSeconds = tempDateTime.until( toDateTime, ChronoUnit.MICROS);
		
		long nanoSeconds = tempDateTime.until( toDateTime, ChronoUnit.NANOS);

		System.out.println(  " years " + years+ 
		        "\n months " +  months +
		         "\n days " + days +
		         "\n hours " +hours +
		         "\n minutes " + minutes +
		         "\n seconds  " + seconds +
		         "\n MiliSeconds " +miliSeconds +
		        "\n microseconds " +microSeconds +
		         "\n nanoSeconds "+nanoSeconds 
				);
	}

}
