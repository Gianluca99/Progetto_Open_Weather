/**
 * CLasse che si occupa della gestione dei dati predetti 
 * @author A.Goffi, G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import Forecast.*;
@Service
public class Forecast {
	public static ForecastObject F;
	/**
	 * metodo in cui viene richiamati i metodi per aprire la connessione con API,
	 * per fare il parsing del file json scaricato e per scrivere su un file di
	 * testo i dati relativi alle previsioni della pressione atmosferica.
	 * 
	 * @param città
	 * 
	 * @return void
	 * 
	 * @exception Exception
	 */
	public static ForecastObject PressioneFutura(String City) throws Exception {
		String api = "http://api.openweathermap.org/data/2.5/forecast?q=" + City;
		String forecast = "";
		try {
			forecast = it.univpm.ProgettoGoffiCorso.Controller.Controller.chiamataAPI(api);
		F = com.google.gson.parsing.ForecastParsing.parsing(forecast);
		/*for (int i = 0; i < F.getList().size(); i++) {
			System.out.println("\nLa pressione prevista nella città di " + City + " tra " + ((i + 1) * 3) + " ore vale: "
					+ F.getList().get(i).getMain().getPressure()+" hPa");
		}*/
		//ScritturaFileForecast(City);
		} catch (Exception e) {
			Scanner in = new Scanner(System.in);
			System.out.println("Città non trovata!\nInserisci una città valida: ");
			it.univpm.ProgettoGoffiCorso.ProgettoGoffiCorsoApplication.vett.setNome(in.nextLine());
			it.univpm.ProgettoGoffiCorso.Service.Forecast.PressioneFutura(it.univpm.ProgettoGoffiCorso.ProgettoGoffiCorsoApplication.vett.getNome());
		}
		return F;
	}

	/**
	 * inserisce nel file Dati.txt i dati delle previsioni della pressione relativa
	 * alla città inserita
	 * 
	 * @param City
	 * 
	 * @exception IOEXception
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
				bufferedWriter.write("\nLa pressione prevista nella città di " + City + " tra " + ((i + 1) * 3) + " ore vale: "
						+ F.getList().get(i).getMain().getPressure()+" hPa");
			}
			bufferedWriter.close();
			System.out.println("Previsioni aggiunte al file!");
		} catch (IOException e) {
			System.out.println("Errore.");
		}
	}
}
