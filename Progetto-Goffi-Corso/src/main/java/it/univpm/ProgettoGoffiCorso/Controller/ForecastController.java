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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Forecast.ForecastObject;
import it.univpm.ProgettoGoffiCorso.Stats.ValoriStatistici;

@RestController
public class ForecastController {

	private static ForecastObject F = new ForecastObject();

	@RequestMapping("/MetaForecast")
	public ForecastObject metadati(@RequestParam String city) throws Exception {
		return it.univpm.ProgettoGoffiCorso.Service.Prevista.PressioneFutura(city);
	
	}

	/**
	 * Metodo pre i dati sulla pressione prevista tramite la rotta forecast
	 * 
	 * @param city
	 */
	@RequestMapping("/Forecast")
	public Vector<Integer> previsione(@RequestParam String city) throws Exception {
		F = it.univpm.ProgettoGoffiCorso.Service.Prevista.PressioneFutura(city);
		Vector<Integer> Vett = new Vector<Integer>();
		for(int i =0; i<F.getList().size();i++) {
		 Vett.addElement( F.getList().get(i).getMain().getPressure());
		}
		return Vett;
	}
	
	/**
	 * Metodo pre i dati sulle statistiche tramite la rotta stat
	 * 
	 * @param city
	 * @return StaPre --> vettore contenente le varie statistiche
	 */
	@RequestMapping("/Forecast/Stat")
	public ValoriStatistici StaPrev(@RequestParam String city) throws Exception {
		F = it.univpm.ProgettoGoffiCorso.Service.Prevista.PressioneFutura(city);
		Vector<Integer> ForecastVett = new Vector<Integer>();
		for(int i =0; i<F.getList().size();i++) {
		ForecastVett.addElement( F.getList().get(i).getMain().getPressure());
		}
		ValoriStatistici v = new ValoriStatistici(ForecastVett);
		return v;
	}

	@ExceptionHandler(FileNotFoundException.class)
	public static String ErrorPage(FileNotFoundException ex) {
		return "Città non trovata!";
	}

	@ExceptionHandler(IOException.class)
	public static String IOExManage(IOException e) {
		String S = "";
		if (e.getMessage().contains(" code: 400 "))
			S = "Città non inserita!";
		else
			S = "API_Key non inserita";
		return S;
	}
}