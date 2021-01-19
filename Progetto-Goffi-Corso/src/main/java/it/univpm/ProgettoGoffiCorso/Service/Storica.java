/**
 * CLasse che si occupa della gestione dei dati storici 
 * @author A.Goffi, G.Corso
 */
package it.univpm.ProgettoGoffiCorso.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import Historical.HistoricalObject;

public class Storica {
	public static HistoricalObject H;


	/*
	 * static double lat(String City) throws Exception { double lat = 0; return lat;
	 * }
	 */

	/**
	 * viene richiamato il metodo per fornire le coordinate della città scelta
	 * dall'utente e quello per la conversione della data in unità UNIIX entrambi
	 * necessari per effettuare la chiamata all'API che fornisce i dati storici
	 * 
	 * @param cityName
	 * @param data     --> data temporale da cui far partire lo storico dei dati
	 * 
	 * @return H --> oggetto di tipo historicalobject
	 */
	public static HistoricalObject Storico(String cityName, String data) throws Exception {
		String dt = "";
		String coord_API = "";
		double[] coord = new double[2];

			coord_API = it.univpm.ProgettoGoffiCorso.Controller.APIController.Coordinate(cityName);
			com.google.gson.parsing.HistoricalParsing.ParsingCoord(coord_API);
			coord[0] = com.google.gson.parsing.HistoricalParsing.GetLat();
			coord[1] = com.google.gson.parsing.HistoricalParsing.GetLon();
			dt = it.univpm.ProgettoGoffiCorso.Controller.APIController.Conversione_UNIX(data);
			String API = "https://api.openweathermap.org/data/2.5/onecall/timemachine?lat=" + coord[0] + "&lon="
					+ coord[1] + "&dt=" + dt;
			String datiStorici = it.univpm.ProgettoGoffiCorso.Controller.APIController.chiamataAPI(API);
			H = com.google.gson.parsing.HistoricalParsing.parsing(datiStorici);
			ScritturaFileHistorical(cityName, data);

		return H;
	}

	/**
	 * Scrive in un file di testo i dati storici della pressione atmosferica
	 * relativi alla città definita
	 * 
	 * @param City --> nome della città
	 * @param Data --> data da cui inziare a scaricare i dati storici
	 * 
	 * @return void
	 */
	public static void ScritturaFileHistorical(String City, String Data) {
		File writer = new File("DatiStorici.txt");// Scrittura delle previsioni all'interno del file//
		try {
			if (!writer.exists()) {
				System.out.println("Nuovo file creato.");
				writer.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(writer, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("\n\nLa pressione storica nella città di " + City
					+ " a partire dall' 01:00 del giorno " + Data + " fino a 00:00 del giorno seguente valgono:");
			for (int i = 0; i < H.getHourly().size(); i++) {
				bufferedWriter.write("\n " + H.getHourly().get(i).getPressure() + " hPa");
			}
			bufferedWriter.close();
			System.out.println("Dati storici aggiunti al file!");

		} catch (IOException e) {
			System.out.println("Errore.");
		}
	}
	}
