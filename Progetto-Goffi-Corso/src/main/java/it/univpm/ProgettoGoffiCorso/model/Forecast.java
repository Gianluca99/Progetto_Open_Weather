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
	public static ForecastObject F;
	
	public static void  PressioneFutura(String città) throws Exception{
		String api ="http://api.openweathermap.org/data/2.5/forecast?q="+città;
		String forecast ="";
		try {
			forecast = it.univpm.ProgettoGoffiCorso.Controller.Controller.chiamataAPI(api);
		} catch (Exception e) {
			e.printStackTrace();
		}
		F= com.google.gson.parsing.ForecastParsing.parsing(forecast);
		
		ScritturaFileForecast(città);
	}
	
	
	public static void ScritturaFileForecast(String Città) {
		
		File writer = new File("dati.txt");//Scrittura delle previsioni all'interno del file//
		try{
			  if(!writer.exists()){
			           System.out.println("Nuovo file creato.");
			           writer.createNewFile();
			       }

			       FileWriter fileWriter = new FileWriter(writer, true);
			       BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);	
			       for(int i=0; i<40; i++) {
			       bufferedWriter.write("\nLa pressione prevista a "+Città+" tra "+((i+1)*3)+" ore vale: "+F.getList().get(i).getMain().getPressure());
			       }
			       bufferedWriter.close();
			       System.out.println("Previsioni aggiunte al file!");
			     
			} catch(IOException e) {
			       System.out.println("Errore.");
			}
	}
}

	
	
	

