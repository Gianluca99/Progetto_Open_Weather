package it.univpm.ProgettoGoffiCorso.Stats;

import java.util.Vector;

public class Stats {
	private int ValoreMax;
	private int ValoreMin;
	private double Media;
	private double Varianza;
	private double ValoreQM;
	
	public Stats() {
	ValoreMax = 0;
	ValoreMin = 0;
	ValoreQM = .0;
	Media = .0;
	Varianza = .0;
	}
		
		
	public void setValMax(Vector <Integer> v) {
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



	public int getValMax() {
		return ValoreMax;
	}



	public void setValMin(Vector <Integer> v) {
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



	public int getValMin() {
		return ValoreMin;
	}


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


	public void setValQM(Vector <Integer> v) {
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



	public double getValQM() {
		return ValoreQM;
	}


	public void setVar(Vector <Integer> v) {
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


	public double getVar() {
		// TODO Auto-generated method stub
		return Varianza;
	}

}

