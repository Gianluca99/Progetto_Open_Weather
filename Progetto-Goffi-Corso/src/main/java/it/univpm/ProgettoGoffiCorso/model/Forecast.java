package it.univpm.ProgettoGoffiCorso.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.parsing.*;

import Forecast.*;

public class Forecast {
	public static void  PressioneFutura(String città) throws Exception{
		String api ="http://api.openweathermap.org/data/2.5/forecast?q="+città;
		String forecast ="";
		try {
			//prendo la string result dove ho tutti i dati dalla chiamata API
			//forecast == result
			forecast = it.univpm.ProgettoGoffiCorso.Controller.Controller.chiamataAPI(api);
		} catch (Exception e) {
			e.printStackTrace();
		}
		com.google.gson.parsing.ForecastParsing.parsing(forecast, città);
	}
}

	
	
	

