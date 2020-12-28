package com.google.gson.parsing;

import Forecast.*;
import com.google.gson.Gson;

public class ForecastParsing {
	public static Forecast__ forecast;
	
	/**
	 * conversione da file json in un oggetto Forecast__
	 * 
	 * @param dati --> sringa che contiene il json preso dalla chiamata API
	 * @param città --> nome della città inserita dall'utente
	 * 
	 * @return forecast --> oggetto di tipo Forecast__ in cui ci sono i dati utili
	 * */
	public static Forecast__ parsing (String dati, String città) {
	 forecast = new Gson().fromJson(dati, Forecast__.class);//Parsing dei dati Json a tipo Forecast//
	 return forecast;
	}
 }

