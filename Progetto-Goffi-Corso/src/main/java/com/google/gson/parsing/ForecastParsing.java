package com.google.gson.parsing;
import Forecast.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class ForecastParsing {
	public static Forecast forecast;
	public static void mapping(String dati, String città) {
	Forecast forecast = new Gson().fromJson(dati, Forecast.class);//Parsing dei dati Json a tipo Forecast//
	File writer = new File("dati.txt");//Scrittura delle previsioni all'interno del file//
	try{
		  if(!writer.exists()){
		           System.out.println("Nuovo file creato.");
		           writer.createNewFile();
		       }

		       FileWriter fileWriter = new FileWriter(writer, true);
		       BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);	
		       for(int i=0; i<40; i++) {
		       bufferedWriter.write("\nLa pressione prevista a "+città+" tra "+((i+1)*3)+" ore vale: "+forecast.getList().get(i).getMain().getPressure());
		       }
		       bufferedWriter.close();
		       System.out.println("Previsioni aggiunte al file!");
		     
		} catch(IOException e) {
		       System.out.println("Errore.");
		}
	}
}
