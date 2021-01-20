/**
 * Classe che si occupa della connessione con localhost della pressione prevista 
 * @author A.Goffi
 * @author G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Forecast.ForecastObject;
import it.univpm.ProgettoGoffiCorso.Filters.RangeFilters;
import it.univpm.ProgettoGoffiCorso.Stats.ForecastStats;

@RestController
public class ForecastController {

	public static ForecastObject F = new ForecastObject();

	/**
	 * Rotta che restituisce i metadati in formato json sulle previsioni
	 * 
	 * @param city -> nome della città
	 * @return ForecastObject
	 * @throws Exception
	 **/

	@RequestMapping("/MetaForecast")
	public ForecastObject metadati(@RequestParam String city) throws Exception {
		return it.univpm.ProgettoGoffiCorso.Service.Prevista.PressioneFutura(city);

	}

	/**
	 * Rotta che restituisce i dati in formato json sulle previsioni
	 * 
	 * @param city -> nome della città
	 * @return Vett
	 * @throws Exception
	 */
	@RequestMapping("/Forecast")
	public Vector<Integer> previsione(@RequestParam String city) throws Exception {
		F = it.univpm.ProgettoGoffiCorso.Service.Prevista.PressioneFutura(city);
		Vector<Integer> Vett = new Vector<Integer>();
		for (int i = 0; i < F.getList().size(); i++) {
			Vett.addElement(F.getList().get(i).getMain().getPressure());
		}
		return Vett;
	}

	/**
	 * Rotta che permette di filtrare le previsioni in base ad una soglia di errore
	 * in hPa
	 * 
	 * @param city   -> nome della città
	 * @param soglia -> soglia d'errore
	 * @return s -> Oggetto di tipo RangeFilter che contiene l'implementazione del
	 *         filtro
	 * @throws Exception
	 **/

	@RequestMapping("/Forecast/{nome}/{soglia}")
	@ResponseBody
	public RangeFilters filtroSoglia(@PathVariable String nome, @PathVariable int soglia) throws Exception {
		F = it.univpm.ProgettoGoffiCorso.Service.Prevista.PressioneFutura(nome);
		RangeFilters s = new RangeFilters(soglia, F);
		return s;

	}

	/**
	 * Rotta che restituisce le statistiche sulle previsioni
	 * 
	 * @param city -> nome della città
	 * @return f --> oggetto statistiche
	 * @throws Exception
	 */
	@RequestMapping("/Forecast/Stat")
	public ForecastStats StaPrev(@RequestParam String city) throws Exception {
		ForecastStats f = new ForecastStats(city);
		return f;
	}

	/**
	 * Gestione eccezioni nel caso di città non esistente
	 * 
	 * @param FileNotFoundException ex
	 * @return stringa
	 **/
	@ExceptionHandler(FileNotFoundException.class)
	public static String ErrorPage(FileNotFoundException ex) {
		return "Città non trovata!";
	}

	/**
	 * Gestione eccezioni nel caso di città o API key non inserita
	 * 
	 * @param IOException e
	 * @return stringa
	 **/
	@ExceptionHandler(IOException.class)
	public static String IOExManage(IOException e) {
		String S = "";
		if (e.getMessage().contains(" code: 400 "))
			S = "Città non inserita!";
		else
			S = "API_Key non inserita";
		return S;
	}

	/**
	 * Gestione eccezioni nel caso di soglia non valida
	 * 
	 * @param IllegalArgumentException ex
	 * @return stringa
	 **/

	@ExceptionHandler(IllegalArgumentException.class)
	public static String ErrorPage(IllegalArgumentException ex) {
		return "Soglia NON VALIDA!";
	}
}