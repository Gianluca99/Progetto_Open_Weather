package it.univpm.ProgettoGoffiCorso.Filters;

import java.util.List;
import Annata.Anno;


public class HistoricalFilters{
	public List<Anno> annateList ;
	/**
	 * Filtra le annate all'interno di annateList in base all'anno e ritorna la prima trovata 
	 * 
	 * 
	 * */
	public Anno getAnnateList(Integer anno) {
		return annateList.stream().filter(a -> a.getAnno().equals(anno)).findAny().get();
		
	}
	
	public Anno getAnnateList(String name, Integer anno) {
		return annateList.stream().filter(a -> a.getName().equals(name) && a.getAnno().equals(anno)).findAny().get();
	}
}
