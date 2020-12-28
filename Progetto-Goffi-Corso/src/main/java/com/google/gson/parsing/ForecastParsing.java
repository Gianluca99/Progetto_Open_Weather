/**
 * CLasse che si occupa del parsing del json relativo ai dati predetti
 * @author A.Goffi, G.Corso
 * */
package com.google.gson.parsing;

import Forecast.*;
import com.google.gson.Gson;

public class ForecastParsing {
	public static ForecastObject forecast;

	/**
	 * conversione del file json in oggetto "ForecastObject" dove contiene i dati
	 * utili. Serve per ottenere i dati delle previsioni meteo di una determinate
	 * città.
	 * 
	 * @param dati --> sringa che contiene il json preso dalla chiamata API
	 * 
	 * @return forecast
	 */
	public static ForecastObject parsing(String dati) {
		forecast = new Gson().fromJson(dati, ForecastObject.class);// Parsing dei dati Json a tipo Forecast//
		return forecast;
	}
}
