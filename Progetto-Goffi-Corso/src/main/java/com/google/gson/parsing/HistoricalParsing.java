/**
 * 
 */
package com.google.gson.parsing;

import java.util.ArrayList;
import java.util.Vector;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Historical.CoordinateGeografiche;



public class HistoricalParsing {
	static ArrayList <CoordinateGeografiche>  coordinate = new ArrayList <CoordinateGeografiche>();
	static double lat;
	static double lon;
	
	/**
	 * conversione da file json a ArrayList di tipo CoordinateGeografiche
	 * 
	 * @param dati	 --> sringa che contiene il json preso dalla chiamata API
	 * @param città  --> nome della città inserita dall'utente 
	 * 
	 * */
	public static void ParsingCoord (String dati, String città ){
		//il file scaricato è un JSONArrey e non un oggetto , bisogna fare parsing diverso
		
		 Type CoordinateList = new TypeToken<ArrayList<CoordinateGeografiche>>(){}.getType();
		 coordinate= new Gson().fromJson(dati, CoordinateList);
		 
	}
	
	public static double GetLat () {
		return  lat = coordinate.get(0).getLat();
				}
	public static double GetLon () {
		return  lon = coordinate.get(0).getLon();
	}
}