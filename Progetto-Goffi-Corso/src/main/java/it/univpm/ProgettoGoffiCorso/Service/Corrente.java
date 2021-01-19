/**
 * Classe che si occupa della gestione dei dati attuali 
 * @author A.Goffi, G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import Current.PressioneAttuale;

public class Corrente {
	public static String pressioneAttuale = "";

	/**
	 * metodo in cui chiamando il metodo "chiamataAPI" si crea il collegameneto con
	 * OpenWeather e si scaricano i dati relativi alla città inserita dall'utente
	 *
	 * i dati vengono convertiti e scritti come stringhe in un file di testo tale
	 * operazione viene effettuata dal metodo "ScritturaFile_current"
	 *
	 * @return pressioneattuale --> stringa contenente il json
	 *
	 * @exception Exception
	 */
	public static PressioneAttuale PressioneAttuale(String city) throws Exception {
		String api = "http://api.openweathermap.org/data/2.5/weather?q=" + city;
		PressioneAttuale PA = new PressioneAttuale();
		pressioneAttuale = it.univpm.ProgettoGoffiCorso.Controller.APIController.chiamataAPI(api);
		PA = com.google.gson.parsing.CurrentParsing.parsing(pressioneAttuale);

		ScritturaFileCurrent(city, PA);
		return PA;
	}

	/**
	 * 
	 * @return void
	 * 
	 * @exception IOException
	 */
	public static void ScritturaFileCurrent(String city, PressioneAttuale pa) {
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
