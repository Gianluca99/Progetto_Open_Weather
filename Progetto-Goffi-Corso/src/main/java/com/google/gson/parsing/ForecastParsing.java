package com.google.gson.parsing;

import Forecast.*;
import com.google.gson.Gson;

public class ForecastParsing {
	public static ForecastObject forecast;
	
	public static ForecastObject parsing (String dati) {
	 forecast = new Gson().fromJson(dati, ForecastObject.class);//Parsing dei dati Json a tipo Forecast//
	 return forecast;
	}
 }

