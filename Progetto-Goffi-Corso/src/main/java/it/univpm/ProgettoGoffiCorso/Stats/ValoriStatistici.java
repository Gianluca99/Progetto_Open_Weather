/**
 * Classe che si occupa delle statistiche
 * @author A.Goffi, G.Corso
 */
package it.univpm.ProgettoGoffiCorso.Stats;

import java.util.Vector;


public class ValoriStatistici {
	private int ValoreMax;
	private int ValoreMin;
	private double Media;
	private double Varianza;
	private double ValoreQM;
	
	/**
	 *Chiamando il costruttore il vettore passato viene automaticamente
	 *preso come input dai metodi set che generano le statistiche
	 * @param vett --> vettore che conterrà o i dati relativi alle previsioni o quelli storici
	 */
	
	
	public ValoriStatistici(Vector<Integer> vett) {
		super();
		setValoreMax(vett);
		setValoreMin(vett);
		setMedia(vett);
		setVarianza(vett);
		setValoreQuadraticoMedio(vett);
	}
	public double getValoreQM() {
		return ValoreQM;
	}
	public void setValoreQuadraticoMedio(Vector<Integer> vett) {
		int somma=0;
		for(int i=0;i<vett.size();i++) {
			somma += Math.pow(vett.get(i), 2);
		}
		this.ValoreQM=Math.sqrt(somma/vett.size());
	}
	public int getValoreMax() {
		return ValoreMax;
	}
	public void setValoreMax(Vector<Integer> vett) {
		ValoreMax = vett.get(0);
		for(int i=1; i<vett.size(); i++) {
			if(vett.get(i)>=ValoreMax) {
				ValoreMax = vett.get(i);
			}
		}
	}
	public int getValoreMin() {
		return ValoreMin;
	}
	public void setValoreMin(Vector<Integer> vett) {
		ValoreMin = vett.get(0);
		for(int i=1; i<vett.size(); i++) {
			if(vett.get(i)<=ValoreMin) {
				ValoreMin = vett.get(i);
			}
		}	
	}
	public double getMedia() {
		return Media;
	}
	public void setMedia(Vector<Integer> vett) {
		int somma=0;
		for(int i=0;i<vett.size();i++) {
			somma += vett.get(i);
		}
		this.Media=somma/vett.size();
	}
	
	public double getVarianza() {
		return Varianza;
	}
	public void setVarianza(Vector<Integer> vett) {
		int somma=0;
		for(int i=0;i<vett.size();i++) {
		somma +=Math.pow((vett.get(i)-getMedia()), 2); 
	}
		Varianza = somma/(vett.size()-1);
}
}
