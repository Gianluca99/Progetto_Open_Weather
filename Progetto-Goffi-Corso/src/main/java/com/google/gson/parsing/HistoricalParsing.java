/**
 * CLasse che si occupa del parsing del json dei dati storici e del json delle coordinate geografiche 
 * @author A.Goffi, G.Corso
 */
package com.google.gson.parsing;

import java.util.ArrayList;
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
	 * Serve per ottenere le coordinate geografiche.
	 * 
	 * @param dati --> sringa che contiene il json preso dalla chiamata API
	 * 
	 * @return void
	 */
	public static void ParsingCoord(String dati) {
		try {
		Type CoordinateList = new TypeToken<ArrayList<CoordinateGeografiche>>() {}.getType();
		coordinate = new Gson().fromJson(dati, CoordinateList);
		} catch (IndexOutOfBoundsException | NullPointerException e) {
			it.univpm.ProgettoGoffiCorso.Controller.HistoricalController.ErrorPage(e);
		}
	}

	/**
	 * Converte il json in un oggetto "HistoricalObject". Serve per ottenere i dati
	 * storici utili.
	 * 
	 * @param dati --> sringa che contiene il json preso dalla chiamata API
	 *
	 * @return historical
	 */
	public static HistoricalObject parsing(String dati) {
		try {
		historical = new Gson().fromJson(dati, HistoricalObject.class);
		} catch (Exception e) {
			it.univpm.ProgettoGoffiCorso.Controller.HistoricalController.ErrorPage(e);}
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