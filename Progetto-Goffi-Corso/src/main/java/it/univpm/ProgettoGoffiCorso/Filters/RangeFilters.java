package it.univpm.ProgettoGoffiCorso.Filters;

import java.util.Vector;

import Forecast.ForecastObject;


public class RangeFilters {
	Vector<Integer> v = new Vector<Integer>();
	public RangeFilters(int soglia, ForecastObject f) {
		v.clear();
		setForecastFilters(soglia, f);
	}

	public void setForecastFilters(int soglia, ForecastObject f) {
		if(soglia<=0) {
			throw new IllegalArgumentException(); 
		}
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
	public Vector <Integer> getForecastFilters() {
		return v;
	}
}
