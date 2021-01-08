/**
 * Classe che si occupa della connessione con localhost della pressione storica
 * @author A.Goffi, G.Corso
 * */

package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.Vector;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgettoGoffiCorso.Vettori;
import it.univpm.ProgettoGoffiCorso.Stats.ValoriStatistici;

@RestController
public class HistoricalController {

	private static Vettori h = it.univpm.ProgettoGoffiCorso.ProgettoGoffiCorsoApplication.vett;
	/**
	 * Metodo pre i dati sulla pressione storica tramite la rotta historical
	 * @param city
	 * @param data
	 * @return storico --> vettore contenente i dati storici
	 * */
	@RequestMapping("/historical")
	public Vector<String> storic(@RequestParam String city, @RequestParam String data) throws Exception {
		h.setNome(city);
		h.setData(data);
		h.SetHistoricalVett();
		Vector<String> storico = new Vector<String>();
		for (int i = 0; i < h.GetHistoricalVett().size(); i++) {
			storico.add("La pressione storica nella città di " + city + " a partire dall' 01:00 del giorno " + data
					+ " fino a 00:00 del giorno seguente valgono:" + h.GetHistoricalVett().get(i));
		}

		return storico;
	}

	/**
	 * Metodo pre i dati sulle statistiche tramite la rotta stat
	 * @param city
	 * @param data
	 * @return Stosta --> vettore contenente le varie statistiche
	 * */
	@RequestMapping("/historical/stat")
	public Vector<String> StatSto(@RequestParam String city, @RequestParam String data) throws Exception {
		h.setNome(city);
		h.setData(data);
		h.SetHistoricalVett();
		ValoriStatistici v = new ValoriStatistici(h.GetHistoricalVett());
		Vector<String> StoSta = new Vector<String>();
			StoSta.add(0, "Il valor medio dei dati storici vale: " + v.getMedia());
			StoSta.add(1, "La varianza vale: "+ v.getVarianza() );
			StoSta.add(2, "la massima pressione registrata vale:" + v.getValoreMax() + " hPa");
			StoSta.add(3, "La minima registrata vale:" + v.getValoreMin() + " hPa");
		return StoSta;
	}
}