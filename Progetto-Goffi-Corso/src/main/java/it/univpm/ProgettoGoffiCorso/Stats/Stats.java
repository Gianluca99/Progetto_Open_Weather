/**
 * Superclasse che contiene tutti i metodi per il calcolo delle statistiche
 * @author A.Goffi
 * @author G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Stats;

import java.util.Vector;

public class Stats {
	private int ValoreMax;
	private int ValoreMin;
	private double Media;
	private double Varianza;
	private double ValoreQM;
	
	/**
	 * Costruttore in cui vengono inizializzate le statistiche
	 */
	public Stats() {
	ValoreMax = 0;
	ValoreMin = 0;
	ValoreQM = .0;
	Media = .0;
	Varianza = .0;
	}
		
	/**
	 * Metodo che calcola il valore massimo
	 * @param v 
	 */
	public void setValoreMax(Vector <Integer> v) {
		if(v == null) {
			throw new IllegalArgumentException();
		}
		else {
		ValoreMax = v.get(0);
		for(int i=1; i<v.size(); i++) {
			if(v.get(i)>=ValoreMax) {
				ValoreMax = v.get(i);
			}
		}
		}
		
	}



	public int getValoreMax() {
		return ValoreMax;
	}


	/**
	 * Metodo che calcola il valore minimo
	 * @param v 
	 */
	public void setValoreMin(Vector <Integer> v) {
		if(v == null) {
			throw new IllegalArgumentException();
		}
		else {
		ValoreMin = v.get(0);
		for(int i=1; i<v.size(); i++) {
			if(v.get(i)<=ValoreMin) {
				ValoreMin = v.get(i);
			}
		}	
		}
		
	}



	public int getValoreMin() {
		return ValoreMin;
	}

	/**
	 * Metodo che calcola la media
	 * @param v 
	 */
	public void setMedia(Vector <Integer> v) {
		int somma=0;
		if(v == null) {
			throw new IllegalArgumentException();
		}
		else {
		for(int i=0;i<v.size();i++) {	
			somma += v.get(i);		
		}
		this.Media=somma/v.size();
		}	
	}
	
	

	public double getMedia() {
		return Media;
	}

	/**
	 * Metodo che calcola il valore quadratico medio necessario per il calcolo della varianza
	 * @param  v 
	 */
	public void setValoreQM(Vector <Integer> v) {
		int somma=0;
		if(v == null) {
			throw new IllegalArgumentException();
		}
		else {
		for(int i=0;i<v.size();i++) {
			somma += Math.pow(v.get(i), 2);
		}
		this.ValoreQM=Math.sqrt(somma/v.size());
		}
	}



	public double getValoreQM() {
		return ValoreQM;
	}

	/**
	 * Metodo che calcola la varianza
	 * @param v 
	 */
	public void setVarianza(Vector <Integer> v) {
		int somma=0;
		if(v == null) {
			throw new IllegalArgumentException();
		}
		else {
		for(int i=0;i<v.size();i++) {
		somma +=Math.pow((v.get(i)-getMedia()), 2); 
			}
		Varianza = somma/(v.size()-1);
		}
		
	}


	public double getVarianza() {
		return Varianza;
	}

}

