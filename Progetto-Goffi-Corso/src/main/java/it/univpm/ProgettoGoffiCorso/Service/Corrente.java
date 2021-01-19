/**
 * Classe che si occupa della gestione dei dati attuali
 * @author A.Goffi, G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import Current.CurrentObject;

public class Corrente {
	public static String pressioneAttuale = "";

	/**
	 * metodo in cui, chiamando il metodo "chiamataAPI" , si crea il collegameneto
	 * con OpenWeather e si scaricano i dati relativi alla città inserita
	 * dall'utente
	 *
	 * i dati vengono convertiti tramite il parsing e scritti come stringhe in un
	 * file di testo tale operazione viene effettuata dal metodo
	 * "ScritturaFile_current"
	 *
	 * @return PA --> Oggetto Java contenente i dati
	 *
	 * @exception Exception
	 */
	public static CurrentObject PressioneAttuale(String city) throws Exception {
		String api = "http://api.openweathermap.org/data/2.5/weather?q=" + city;
		CurrentObject PA = new CurrentObject();
		pressioneAttuale = it.univpm.ProgettoGoffiCorso.Controller.APIController.chiamataAPI(api);
		PA = com.google.gson.parsing.CurrentParsing.parsing(pressioneAttuale);

		ScritturaFileCurrent(city, PA);
		return PA;
	}

	/**
	 * Metodo per la scrittura dei dati su un file di testo
	 * 
	 * @return void
	 *
	 * @exception IOException
	 */
	public static void ScritturaFileCurrent(String city, CurrentObject pa) {
		File writer = new File("DatiAttuali.txt");
		try {
			if (!writer.exists()) {
				System.out.println("Nuovo file creato.");
				writer.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(writer, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("\nLa pressione attuale nella città di " + city + " vale: "
					+ pa.getMain().getPressure() + " hPa\n");
			bufferedWriter.close();
			System.out.println("Pressione aggiunta al file!");

		} catch (IOException e) {
			System.out.println("Errore.");
		}
	}

}
