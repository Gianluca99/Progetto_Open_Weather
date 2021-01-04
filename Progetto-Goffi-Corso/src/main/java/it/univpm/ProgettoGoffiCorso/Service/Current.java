/**
 * Classe che si occupa della gestione dei dati attuali 
 * @author A.Goffi, G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Service;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class Current {
	public static String pressioneAttuale = "";
	/**
	 * metodo in cui chiamanto il metoto "chiamataAPI" si crea il collegamneto con
	 * OpenWeather e si scaricano i dati relativi alla città inserita dall'utente
	 *
	 * i dati vengono convertiti e scritti come stringhe in un file di testo tale
	 * operazione viene effettuata dal metodo "ScritturaFile_current"
	 *
	 * @return void
	 *
	 * @exception Exception
	 */
	public static String PressioneAttuale(String city) throws Exception {
		String api = "http://api.openweathermap.org/data/2.5/weather?q=" + city;
		Scanner in = new Scanner(System.in);
		try {
			// prendo la string result dove ho tutti i dati dalla chiamata API
			// pressioneAttuale == result
			pressioneAttuale = it.univpm.ProgettoGoffiCorso.Controller.Controller.chiamataAPI(api);
			CurrentMapping( pressioneAttuale,city);

		} catch (Exception e) {
			System.out.println("Città non trovata!\nInserisci una città valida: ");
			it.univpm.ProgettoGoffiCorso.ProgettoGoffiCorsoApplication.i.setNome(in.nextLine());
			PressioneAttuale(it.univpm.ProgettoGoffiCorso.ProgettoGoffiCorsoApplication.i.getNome());
		}
		return pressioneAttuale;
	}
	public static Map<String, Object> CurrentMapping (String PressioneAttuale, String city) {
		// vado a selezionare il JSONObject "main" dove ho la pressione attuale
		Map<String, Object> APImap = com.google.gson.parsing.CurrentParsing.jsonToMap(pressioneAttuale.toString());
		Map<String, Object> MainMap = com.google.gson.parsing.CurrentParsing.jsonToMap(APImap.get("main").toString());
		// double Pressure = (double) MainMap.get("pressure"); //dovrei avere il valore
		// della pressione
		ScritturaFileCurrent(pressioneAttuale, APImap, MainMap, city);
		return MainMap;
	}

	/**
	 * Genera un file dove viene salvato il nome della città con la pressione
	 * attuale ad ogni chiamata aggiunge le nuove informazioni sensa sovrascrivere
	 * il file generato precedentemente
	 * 
	 * @param dati  --> stringa che contiene i dati da salvare
	 * @param JsonT --> JSONObject completo dato dal sito
	 * @param main  --> JSONObject che contiene solo il main dove si trova la
	 *              pressione
	 * 
	 * @return void
	 * 
	 * @exception IOException
	 */
	public static void ScritturaFileCurrent(String dati, Map<String, Object> JsonT, Map<String, Object> main,
			String city) {
		File writer = new File("dati.txt");
		try {
			if (!writer.exists()) {
				System.out.println("Nuovo file creato.");
				writer.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(writer, true);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("\nLa pressione attuale nella città di " + city + " vale: " + main.get("pressure") + " hPa\n");
			bufferedWriter.close();
			System.out.println("Pressione aggiunta al file!");

		} catch (IOException e) {
			System.out.println("Errore.");
		}
	}

}
