/**
 * Classe che si occupa dei filtri sulle previsioni 
 * @author A.Goffi
 * @author G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Filters;

import java.util.Vector;

import Forecast.ForecastObject;

public class RangeFilters {
	private Vector<Integer> v = new Vector<Integer>();

	public RangeFilters(int soglia, ForecastObject f) {
		v.clear();
		setForecastFilters(soglia, f);
	}

	/**
	 * Metodo che filtra le previsioni in base ad una soglia di errore in hPa e
	 * restituisce soltanto le previsioni del giorno seguente nel caso di soglia
	 * uguale a 1; solo quelle tra 1,2 e 4 giorni nel caso di soglia uguale a 2;
	 * solo quelle tra 1,2,4,5 giorni nel caso di soglia >= 3 e < 6; tutte nel caso
	 * di soglia >= 6.(Per fare ciò abbiamo salvato dati correnti e previsioni su
	 * dei file di testo e li abbiamo confrontati stimando l'accuratezza delle
	 * previsioni di OpenWeather.)
	 * 
	 * @param soglia
	 * @param f
	 * @return void
	 */
	public void setForecastFilters(int soglia, ForecastObject f) {
		if (soglia <= 0) {
			throw new IllegalArgumentException();
		}
		if (soglia == 1) {
			v.addElement(f.getList().get(7).getMain().getPressure());
		}
		if (soglia == 2) {
			v.addElement(f.getList().get(7).getMain().getPressure());
			v.addElement(f.getList().get(15).getMain().getPressure());
			v.addElement(f.getList().get(31).getMain().getPressure());
		}
		if (soglia >= 3 && soglia < 6) {
			v.addElement(f.getList().get(7).getMain().getPressure());
			v.addElement(f.getList().get(15).getMain().getPressure());
			v.addElement(f.getList().get(31).getMain().getPressure());
			v.addElement(f.getList().get(39).getMain().getPressure());
		}
		if (soglia >= 6) {
			v.addElement(f.getList().get(7).getMain().getPressure());
			v.addElement(f.getList().get(15).getMain().getPressure());
			v.addElement(f.getList().get(23).getMain().getPressure());
			v.addElement(f.getList().get(31).getMain().getPressure());
			v.addElement(f.getList().get(39).getMain().getPressure());
		}
	}

	/**
	 * Metodo che restituisce il vettore con le previsioni filtrate
	 * 
	 * @return v
	 */
	public Vector<Integer> getForecastFilters() {
		return v;
	}
}
