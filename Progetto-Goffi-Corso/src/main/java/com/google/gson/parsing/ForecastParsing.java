package com.google.gson.parsing;

import Forecast.*;
import com.google.gson.Gson;

public class ForecastParsing {
	public static Forecast__ forecast;
	
	public static Forecast__ parsing (String dati, String città) {
	 forecast = new Gson().fromJson(dati, Forecast__.class);//Parsing dei dati Json a tipo Forecast//
	 return forecast;
	}
 }

