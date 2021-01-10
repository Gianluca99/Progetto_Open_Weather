/**
 * Classe che si occupa delle varie chiamate API 
 *		*Connessione con OpenWeather 
 *		*Conversione della data da AAAA/MM/GG a UNIX
 *		*Cordinate Geografiche di un'Indirizzo/Città 
 * @author A.Goffi, G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Controller;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {
	private static URLConnection connessione;

	/**
	 * stabilisce una connessione con il sito fornito dall'API i dati vengono
	 * inseriti in una stringa "result"
	 * 
	 * @param API
	 * @param cityName
	 * 
	 * @return String result
	 * @throws MalformedURLException
	 * 
	 */
	public static String chiamataAPI(String API) throws Exception {

		String key = "f044a8c15896675617344a49813d1a16";
		String result = "";
		try {
			URL url = new URL(API + "&appid=" + key);
			connessione = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			String line;
			connessione.setConnectTimeout(1000);
			while ((line = rd.readLine()) != null) {
				result += line;
			}
			rd.close();
		} catch (MalformedURLException e) {
			System.out.println("Errore di connessione! :(");
		}

		return result;
	}

	/**
	 * Restituisce una stringa con la codifica della data inserita in formato UNIX
	 * 
	 * @param data --> AAAA/MM/GG
	 * 
	 * @return UNIX_Data
	 * @exception MalformedURLException
	 */
	public static String Conversione_UNIX(String data) throws Exception {
		String UNIX_Data = "";
		try {
			URL url = new URL("https://showcase.api.linx.twenty57.net/UnixTime/tounix?date=" + data);
			connessione = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			String line;
			connessione.setConnectTimeout(1000);
			while ((line = rd.readLine()) != null) {
				UNIX_Data += line;
			}
			rd.close();

		} catch (MalformedURLException e) {
			System.out.println("Errore di connessione! :(");
		}
		return UNIX_Data;
	}

	/**
	 * inserendo un indirizzo fornisce le coordinate geografiche e la traduzone in
	 * varie lingue (vedere classe oggetto)
	 * 
	 * 
	 * @param Città --> nome della città / indirizzo di cui si vuole conoscere le
	 *              coordinate
	 * 
	 * @return coord
	 * @exception MalformedURLException
	 */
	public static String Coordinate(String City) throws Exception {
		String key = "f044a8c15896675617344a49813d1a16";
		String coord = "";
		try {
			URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q=" + City + "&limit=1&appid=" + key);
			connessione = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			String line;
			connessione.setConnectTimeout(1000);
			while ((line = rd.readLine()) != null) {
				coord += line;
			}
			rd.close();
		} catch (MalformedURLException e) {
			System.out.println("Errore di connessione! :(");
		}
		// System.out.println("file scaricato per le coordinate :"+coord);

		return coord;
	}
	
	@RequestMapping("/Welcome")
	public Vector<String> Benvenuto() {
		Vector<String> vettore = new Vector<String>(); 	
		 vettore.add(0, "Benvenuto!");
		 vettore.add(1, "/MetaCurrent?city= -> Per conoscere i metadati relativi al meteo corrente(parametro città);");
		 vettore.add(2, "/Current?city= -> Per conoscere il dato sulla pressione corrente(parametro città);");
		 vettore.add(3, "/MetaForecast?city= -> Per conoscere i metadati relativi alle previsioni per i prossimi 5 giorni(parametro città);");
		 vettore.add(4, "/Forecast?city= -> Per conoscere i dati relativi alla pressione prevista per i prossimi 5 giorni(parametro città);");
		 vettore.add(5, "/Forecast/Stat?city= -> Per conoscere le statistiche relative alla pressione prevista per i prossimi 5 giorni(parametro città);");
		 vettore.add(6,	"/MetaHistorical?city=&data= -> Per conoscere i metadati relativi al meteo del giorno precedente fino ad un massimo di 5 giorni passati(parametri città e data:aaaa/mm/gg);");
		 vettore.add(7,	"/Historical?city=&data= -> Per conoscere i dati relativi alla pressione del giorni precedente fino ad un massimo di 5 giorni passati(parametri città e data:aaaa/mm/gg);");
		 vettore.add(8,	"/Historical/Stat?city=&data= -> Per conoscere le statistiche relative alla pressione del giorno precedente fino ad un massimo di 5 giorni passati(parametri città e data:aaaa/mm/gg);");
		 vettore.add(9,	"/Annate -> Per conoscere le statistiche relative alla pressione degli anni precedenti;");
		 vettore.add(10,"/Annate/anno) -> Per filtrare gli anni precedenti in base all'anno;");
		 vettore.add(11,"/Annate/città/anno -> Per filtrare gli anni precedenti in base alla città e l'anno.");
			 	return vettore;
				
	}
	
}
