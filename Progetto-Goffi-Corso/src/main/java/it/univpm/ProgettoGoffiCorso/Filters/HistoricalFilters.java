/**
 * Classe che si occupa dei filtri sui dati storici 
 * @author A.Goffi
 * @author G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Filters;

import java.util.List;
import Annata.Anno;


public class HistoricalFilters{
	public List<Anno> annateList ;
	/**
	 * Filtra le annate all'interno di annateList in base all'anno
	 * @param anno
	 * 
	 * */
	public Anno getAnnateList(Integer anno) {
		return annateList.stream().filter(a -> a.getAnno().equals(anno)).findAny().get();
		
	}
	/**
	 * Filtra le annate all'interno di annateList in base all'anno e al nome della città
	 * @param name
	 * @param anno
	 * 
	 * 
	 * */
	
	public Anno getAnnateList(String name, Integer anno) {
		return annateList.stream().filter(a -> a.getName().equals(name) && a.getAnno().equals(anno)).findAny().get();
	}
}
