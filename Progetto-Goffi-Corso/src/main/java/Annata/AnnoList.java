package Annata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.google.gson.Gson;

@Service
public class AnnoList extends Anno{
	private List<Anno> annateList ;

	/**
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
	 * Filtra le annate all'interno di annateList in base all'anno e ritorna la prima trovata 
	 * 
	 * 
	 * */
	public Anno getAnnateList(Integer anno) {
		return annateList.stream().filter(a -> a.getAnno().equals(anno)).findFirst().get();
	}
	
	public Anno getAnnateList(String name) {
		//String nome = name;
		return annateList.stream().filter(a -> a.getName().equals(name)).findFirst().get();
	}
	/**
	 * @param annateList the annateList to set
	 */
	public void addAnnateList(Anno s) {
		this.annateList.add(s);
	}


}
