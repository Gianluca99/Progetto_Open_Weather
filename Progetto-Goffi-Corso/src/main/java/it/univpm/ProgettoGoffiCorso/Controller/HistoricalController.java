/**
 * Classe che si occupa della connessione con localhost della pressione storica
 * @author A.Goffi, G.Corso
 * */

package it.univpm.ProgettoGoffiCorso.Controller;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
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
import Annata.Anno;
import Annata.AnnoList;
import Historical.HistoricalObject;
import it.univpm.ProgettoGoffiCorso.Stats.HistoricalStats;

@RestController
public class HistoricalController {

	private static AnnoList L = new AnnoList();
	private static HistoricalObject H;

	/**
	 * Rotta che restituisce i metadati in formato json sulla pressione storica
	 * 
	 * @param city -> nome della città
	 * @param data
	 * @return HistoricalObject
	 * @throws Exception
	 **/
	@RequestMapping("/MetaHistorical")
	public HistoricalObject metadati(@RequestParam String city, @RequestParam String data) throws Exception {
		return it.univpm.ProgettoGoffiCorso.Service.Storica.Storico(city, data);
	}

	/**
	 * Rotta che restituisce i dati sulla pressione storica
	 * 
	 * @param city
	 * @param data
	 * @return HistoricalVett --> vettore contenente i dati storici
	 * @throws Exception
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
	 * Rotta che resituisce le statistiche sui dati storici
	 * 
	 * @param city
	 * @param data
	 * @return stats --> vettore contenente le varie statistiche
	 * @throws Exception
	 */
	@RequestMapping("/Historical/Stat")
	public HistoricalStats StatSto(@RequestParam String city, @RequestParam String data) throws Exception {
		HistoricalStats stats = new HistoricalStats(city, data);
		return stats;
	}

	/**
	 * Rotta che restituisce i dati relativi alla pressione degli anni precedenti
	 * 
	 * @return lista anni
	 **/

	@RequestMapping("/Annate")
	public List<Anno> annate() {
		return L.getAnnateList();
	}

	/**
	 * Rotta che permette di filtrare i dati degli anni precedenti in base all'anno
	 * 
	 * @param anno
	 * @return Anno
	 * @throws NoSuchElementException
	 **/

	@GetMapping("/Annate/{anno}")
	@ResponseBody
	public Anno filtroanno(@PathVariable Integer anno) throws NoSuchElementException {
		return L.getAnnateList(anno);
	}

	/**
	 * Rotta che permette di filtrare i dati degli anni precedenti in base al nome
	 * della città e all'anno
	 * 
	 * @param name
	 * @param anno
	 * @return Anno
	 * @throws NoSuchElementException
	 **/
	@RequestMapping("/Annate/{name}/{anno}")
	@ResponseBody
	public Anno filtronome(@PathVariable String name, @PathVariable Integer anno) throws NoSuchElementException {
		return L.getAnnateList(name, anno);
	}

	/**
	 * Metodo che consente di aggiungere annate precedenti all'interno del data base
	 * 
	 * @return stringa
	 **/
	@RequestMapping(method = RequestMethod.POST, value = "/Annate")
	public String addannate(@RequestBody Anno anno) {
		L.addAnnateList(anno);
		return "ok!";
	}

	/**
	 * Gestione eccezioni nel caso di città o anno non esistente
	 * 
	 * @param NoSuchElementException ex
	 * @return stringa
	 **/

	@ExceptionHandler(NoSuchElementException.class)
	public static String ErrorPage(NoSuchElementException ex) {
		return "Dato inesistente!";
	}

	/**
	 * Gestione eccezioni nel caso di città non esistente
	 * 
	 * @param IndexOutOfBoundException ex
	 * @return stringa
	 **/

	@ExceptionHandler(IndexOutOfBoundsException.class)
	public static String ErrorPage(IndexOutOfBoundsException ex) {
		return "Città non trovata!";
	}

	/**
	 * Gestione eccezioni nel caso di città, data o API key non inserita.
	 * 
	 * @param IOException ex
	 * @return stringa
	 **/

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