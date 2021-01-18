package it.univpm.ProgettoGoffiCorso.Stats;

import java.util.Vector;

import Forecast.ForecastObject;


public class Soglia {
	private static Vector <Integer> v;
	
	public Soglia(int soglia, ForecastObject f) {
		setFiltro(soglia, f);
	}

	public void setFiltro(int soglia, ForecastObject f) {
		if(soglia == 1) {
			v.addElement(f.getList().get(7).getMain().getPressure());
			}
		if(soglia == 2) {
			v.addElement(f.getList().get(7).getMain().getPressure());
			v.addElement(f.getList().get(15).getMain().getPressure());
			v.addElement(f.getList().get(31).getMain().getPressure());
			}
		if(soglia >= 3 && soglia<6) {
			v.addElement(f.getList().get(7).getMain().getPressure());
			v.addElement(f.getList().get(15).getMain().getPressure());
			v.addElement(f.getList().get(31).getMain().getPressure());
			v.addElement(f.getList().get(39).getMain().getPressure());
			}
		if(soglia >= 6) {
			v.addElement(f.getList().get(7).getMain().getPressure());
			v.addElement(f.getList().get(15).getMain().getPressure());
			v.addElement(f.getList().get(23).getMain().getPressure());
			v.addElement(f.getList().get(31).getMain().getPressure());
			v.addElement(f.getList().get(39).getMain().getPressure());
			}
	}
	public Vector <Integer> getFiltro() {
		return v;
	}
}
