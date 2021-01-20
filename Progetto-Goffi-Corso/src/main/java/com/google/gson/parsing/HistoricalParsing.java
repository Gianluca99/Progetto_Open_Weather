/**
 * CLasse che si occupa del parsing del json dei dati storici e del json delle coordinate geografiche 
 * @author A.Goffi
 * @author G.Corso
 */
package com.google.gson.parsing;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import Historical.CoordinateGeografiche;
import Historical.HistoricalObject;

public class HistoricalParsing {
	static ArrayList<CoordinateGeografiche> coordinate = new ArrayList<CoordinateGeografiche>();
	static double lat;
	static double lon;
	public static HistoricalObject historical;

	/**
	 * Converte il file json in un ArrayList di tipo CoordinateGeografiche.
	 * 
	 * @param dati --> stringa che contiene il json preso dalla chiamata API
	 * 
	 * @return void
	 */
	public static void ParsingCoord(String dati) throws FileNotFoundException {
		try {
			Type CoordinateList = new TypeToken<ArrayList<CoordinateGeografiche>>() {
			}.getType();
			coordinate = new Gson().fromJson(dati, CoordinateList);
		} catch (IndexOutOfBoundsException e) {
			it.univpm.ProgettoGoffiCorso.Controller.HistoricalController.ErrorPage(e);
		}
	}

	/**
	 * Tramite il gson convertiamo la stringa json in un oggetto Java di tipo
	 * HistoricalObject per poterlo gestire all'interno del programma.
	 * 
	 * @param dati --> stringa che contiene il json preso dalla chiamata API
	 *
	 * @return historical
	 */
	public static HistoricalObject parsing(String dati) throws IndexOutOfBoundsException {
		historical = new Gson().fromJson(dati, HistoricalObject.class);
		return historical;
	}

	/**
	 * fornisce la latitudine
	 * 
	 * @return lat
	 */
	public static double GetLat() {
		return lat = coordinate.get(0).getLat();
	}

	/**
	 * fornisce la longitudite
	 * 
	 * @return lon
	 */
	public static double GetLon() {
		return lon = coordinate.get(0).getLon();
	}
}