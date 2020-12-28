/**
 * 
 */
package it.univpm.ProgettoGoffiCorso.model;

import com.google.gson.Gson;

import Forecast.Forecast__;

public class Historical {
	
	static double lat (String città) throws Exception {
		double lat=0;
	
		return lat;
	}
	
	
/**
 * viene richiamato il metodo per fornire le coordinate della città scelta dall'utente, quello per la conversione della data in unità UNIIX
 * entrambi necessari per effettuare la chiamata all'API che fornisce i dati storici 
 * 
 *  @param cityName 
 *  @param data --> data temporale da cui far partire lo storico dei dati
 * 
 */
	public static void Storico(String cityName, String data) {
		String  dt="";
		String coord_API ="";
		double[] coord = new double[2];
		try {
		 coord_API = it.univpm.ProgettoGoffiCorso.Controller.Controller.Coordinate(cityName);
		 com.google.gson.parsing.HistoricalParsing.ParsingCoord(coord_API, cityName);
		 coord[0]=com.google.gson.parsing.HistoricalParsing.GetLat();
		 coord[1]=com.google.gson.parsing.HistoricalParsing.GetLon();
		 dt=it.univpm.ProgettoGoffiCorso.Controller.Controller.Conversione_UNIX(data);
					
		String API ="https://api.openweathermap.org/data/2.5/onecall/timemachine?lat="+coord[0]+"&lon="+coord[1]+"&dt="+dt;
		String datiStorici = it.univpm.ProgettoGoffiCorso.Controller.Controller.chiamataAPI(API);
		System.out.println(datiStorici);
	}catch (Exception e) {
		e.printStackTrace();
	}
		
	}

}
