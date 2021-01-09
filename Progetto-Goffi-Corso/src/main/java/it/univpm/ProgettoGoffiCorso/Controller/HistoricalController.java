/**
 * Classe che si occupa della connessione con localhost della pressione storica
 * @author A.Goffi, G.Corso
 * */

package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import Annata.Anno;
import Annata.AnnoList;
import Historical.HistoricalObject;
import it.univpm.ProgettoGoffiCorso.Vettori;
import it.univpm.ProgettoGoffiCorso.Stats.ValoriStatistici;

@RestController
public class HistoricalController {
	//@Autowired
	private static AnnoList L= new AnnoList();
	
	private static Vettori h = it.univpm.ProgettoGoffiCorso.ProgettoGoffiCorsoApplication.vett;
	
	@RequestMapping("/metaHistorical")
	public HistoricalObject metadati(@RequestParam String city, @RequestParam String data) throws Exception {
		return	it.univpm.ProgettoGoffiCorso.Service.Historical.Storico(city, data);
	}
	
	/**
	 * Metodo pre i dati sulla pressione storica tramite la rotta historical
	 * @param city
	 * @param data
	 * @return storico --> vettore contenente i dati storici
	 * */
	@RequestMapping("/Historical")
	public Vector<Integer> storic(@RequestParam String city, @RequestParam String data) throws Exception {
		h.setNome(city);
		h.setData(data);
		h.SetHistoricalVett();
		return h.GetHistoricalVett();
	}

	/**
	 * Metodo pre i dati sulle statistiche tramite la rotta stat
	 * @param city
	 * @param data
	 * @return Stosta --> vettore contenente le varie statistiche
	 * */
	@RequestMapping("/historical/stat")
	public ValoriStatistici StatSto(@RequestParam String city, @RequestParam String data) throws Exception {
		h.setNome(city);
		h.setData(data);
		h.SetHistoricalVett();
		ValoriStatistici v = new ValoriStatistici(h.GetHistoricalVett());
		return v;
	}
	
	@RequestMapping("/annate")
	public List<Anno> annate(){
		return L.getAnnateList();
	}
	@GetMapping("/annate/{anno}")
	@ResponseBody
	public Anno filtroanno(@PathVariable Integer anno){
		return L.getAnnateList(anno);
	}
	
	@RequestMapping("/annate/{name}")
	@ResponseBody
	public Anno filtronome(@PathVariable String name){
		return L.getAnnateList(name);
	}
	@RequestMapping(method = RequestMethod.POST, value ="/annate")
	public String addannate(@RequestBody Anno anno){
		L.addAnnateList(anno);
		return "ok!";
	}
	}