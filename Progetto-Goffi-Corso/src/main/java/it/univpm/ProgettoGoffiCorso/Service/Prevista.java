/**
 * CLasse che si occupa della gestione dei dati predetti 
 * @author A.Goffi, G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import Forecast.*;

public class Prevista {
	public static ForecastObject F;

	/**
	 * metodo in cui vengono richiamati i metodi per aprire la connessione con API,
	 * per fare il parsing del file json scaricato e per scrivere su un file di
	 * testo i dati relativi alle previsioni sulla pressione atmosferica.
	 * 
	 * @param City
	 * @return F --> oggetto di tipo ForecastObject
	 * @throws Exception
	 */
	public static ForecastObject PressioneFutura(String City) throws Exception {
		String api = "http://api.openweathermap.org/data/2.5/forecast?q=" + City;
		String forecast = "";

		forecast = it.univpm.ProgettoGoffiCorso.Controller.APIController.chiamataAPI(api);
		F = com.google.gson.parsing.ForecastParsing.parsing(forecast);
		// ScritturaFileForecast(City);
		return F;
	}

	/**
	 * Metodo per salvare i dati relativi alle previsioni su un file di testo
	 * 
	 * @param City
	 * @return void
	 */
	public static void ScritturaFileForecast(String City) {
		File writer = new File("DatiPrevisti.txt"); // Scrittura delle previsioni all'interno del file//
		try {
			if (!writer.exists()) {
				System.out.println("Nuovo file creato.");
				writer.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(writer, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < F.getList().size(); i++) {
				bufferedWriter.write("\nLa pressione prevista nella città di " + City + " tra " + ((i + 1) * 3)
						+ " ore vale: " + F.getList().get(i).getMain().getPressure() + " hPa");
			}
			bufferedWriter.close();
			System.out.println("Previsioni aggiunte al file!");
		} catch (IOException e) {
			System.out.println("Errore.");
		}
	}
}
