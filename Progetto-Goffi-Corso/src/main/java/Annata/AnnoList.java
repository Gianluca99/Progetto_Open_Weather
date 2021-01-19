package Annata;

import java.util.Arrays;
import java.util.List;

import it.univpm.ProgettoGoffiCorso.Filters.HistoricalFilters;

import java.util.ArrayList;

public class AnnoList extends HistoricalFilters{
	

	/** Crea l'oggetto Anno dove contiene i dai statistici storici di ogni mese 
	 * @param annateList
	 */
	public AnnoList() {
		super();
			Gennaio gen = new Gennaio(1025, 1000, 1012.75, 2.2);
			Febbraio feb = new Febbraio(1025, 1000, 1012.75, 2.2);
			Marzo mar = new Marzo(1025, 1000, 1012.75, 2.2);
			Aprile apr = new Aprile(1025, 1000, 1012.75, 2.2);
			Maggio mag = new Maggio(1025, 1000, 1012.75, 2.2);
			Giugno giu = new Giugno(1025, 1000, 1012.75, 2.2);
			Luglio lug = new Luglio(1025, 1000, 1012.75, 2.2);
			Agosto ago = new Agosto(1025, 1000, 1012.75, 2.2);
			Settembre sett = new Settembre(1025, 1000, 1012.75, 2.2);
			Ottobre ott = new Ottobre(1025, 1000, 1012.75, 2.2);
			Novembre nov = new Novembre(1025, 1000, 1012.75, 2.2);
			Dicembre dic = new Dicembre(1025, 1000, 1012.75, 2.2);
			Mesi mesi = new Mesi(gen, feb, mar, apr, mag, giu, lug, ago, sett, ott, nov, dic);
			annateList = new ArrayList<>(Arrays.asList( 
													new Anno(2020, "Ancona", mesi),
													new Anno(2019, "Ancona", mesi),
													new Anno(2019, "Jesi",   mesi)));	
	}
	/**
	 * @return the annateList
	 */
	public List<Anno> getAnnateList() {
		return annateList;
	}

	/**
	 * @param annateList the annateList to set
	 */
	public void addAnnateList(Anno s) {
		this.annateList.add(s);
	}


}
