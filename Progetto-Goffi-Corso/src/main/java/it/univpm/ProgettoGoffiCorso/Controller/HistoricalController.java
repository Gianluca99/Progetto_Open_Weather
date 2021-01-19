/**
 * Classe che si occupa della connessione con localhost della pressione storica
 * @author A.Goffi, G.Corso
 * */

package it.univpm.ProgettoGoffiCorso.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Vector;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Historical.HistoricalObject;
import it.univpm.ProgettoGoffiCorso.Stats.HistoricalStats;


@RestController
public class HistoricalController {

	//private static AnnoList L = new AnnoList();
	private static HistoricalObject H ;

	@RequestMapping("/MetaHistorical")
	public HistoricalObject metadati(@RequestParam String city, @RequestParam String data) throws Exception {
		return it.univpm.ProgettoGoffiCorso.Service.Storica.Storico(city, data);
	}

	/**
	 * Metodo pre i dati sulla pressione storica tramite la rotta historical
	 * 
	 * @param city
	 * @param data
	 * @return storico --> vettore contenente i dati storici
	 */
	@RequestMapping("/Historical")
	public Vector<Integer> storic(@RequestParam String city, @RequestParam String data) throws Exception {
		H = it.univpm.ProgettoGoffiCorso.Service.Storica.Storico(city, data);
		 Vector<Integer> HistoricalVett = new Vector<Integer>();
		for (int i = 0; i < H.getHourly().size(); i++) {
			HistoricalVett.addElement(H.getHourly().get(i).getPressure());
		}
		return HistoricalVett;
	}

	/**
	 * Metodo pre i dati sulle statistiche tramite la rotta stat
	 * 
	 * @param city
	 * @param data
	 * @return Stosta --> vettore contenente le varie statistiche
	 */
	@RequestMapping("/Historical/Stat")
	public HistoricalStats StatSto(@RequestParam String city, @RequestParam String data) throws Exception {
		HistoricalStats stats = new HistoricalStats(city, data);
		return stats;
	}

	/*@RequestMapping("/Annate")
	public List<Anno> annate() {
		return L.getAnnateList();
	}

	@GetMapping("/Annate/{anno}")
	@ResponseBody
	public Anno filtroanno(@PathVariable Integer anno) {
		return L.getAnnateList(anno);
	}

	@RequestMapping("/Annate/{name}/{anno}")
	@ResponseBody
	public Anno filtronome(@PathVariable String name, @PathVariable Integer anno) {
		return L.getAnnateList(name, anno);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/Annate")
	public String addannate(@RequestBody Anno anno) {
		L.addAnnateList(anno);
		return "ok!";
	}*/

		
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public static String ErrorPage(IndexOutOfBoundsException ex) {
		return "Città non trovata!";
	}

	@ExceptionHandler(IOException.class)
	public static String IOExManage(IOException e) {
		String S = "";
		if (e.getMessage().contains(" code: 400 "))
			S = "Attenzione: Città o data non inserita, oppure controlla di aver inserito la data nel formato corretto (AAAA/MM/GG)\nricorda di inserire una data non più vecchia di 5 giorni da oggi!";
		else
			S = "API_Key non inserita";
		return S;
	}
	
}