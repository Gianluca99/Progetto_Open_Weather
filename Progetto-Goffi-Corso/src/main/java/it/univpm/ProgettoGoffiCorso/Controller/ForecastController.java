/**
 * Classe che si occupa della connessione con localhost della pressione prevista 
 * @author A.Goffi, G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.Vector;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Forecast.ForecastObject;
import it.univpm.ProgettoGoffiCorso.Vettori;
import it.univpm.ProgettoGoffiCorso.Stats.ValoriStatistici;

@RestController
public class ForecastController {

	private static Vettori h = it.univpm.ProgettoGoffiCorso.ProgettoGoffiCorsoApplication.vett;
	private static ForecastObject F = new ForecastObject();
	@RequestMapping("/MetaForecast")
	public ForecastObject metadati(@RequestParam String city) throws Exception{
		F = it.univpm.ProgettoGoffiCorso.Service.Prevista.PressioneFutura(city);
		return F;
	}
	

	/**
	 * Metodo pre i dati sulla pressione prevista tramite la rotta forecast
	 * @param city
	 * @return Prev --> vettore contenente le previsioni
	 * */
	@RequestMapping("/Forecast")
	public Vector<Integer> previsione(@RequestParam String city) throws Exception {
		h.setNome(city);
		h.SetForecastVett();
		return h.GetForecastVett();
	}

	/**
	 * Metodo pre i dati sulle statistiche tramite la rotta stat
	 * @param city
	 * @return StaPre --> vettore contenente le varie statistiche
	 * */
	@RequestMapping("/Forecast/Stat")
	public ValoriStatistici StaPrev(@RequestParam String city) throws Exception {
		h.setNome(city);
		h.SetForecastVett();
		ValoriStatistici v = new ValoriStatistici(h.GetForecastVett());
		return v;
	}

	    @ExceptionHandler(Exception.class)
	    public static String ErrorPage(Exception ex) {
	        return "Città non inserita o non trovata!";
	    }
}