package it.univpm.ProgettoGoffiCorso.Stats;

import java.util.Vector;

import Forecast.ForecastObject;

public class ForecastStats extends Stats{
	private static ForecastObject F ;
	private static Vector<Integer> v = new Vector<Integer>();
	

	public ForecastStats(String city) throws Exception {
		super();
		setV(city);
		super.setValMax(v);
		super.setValMin(v);
		super.setMedia(v);
		super.setValQM(v);
		super.setVar(v);	
	}



	public static void setV(String city) throws Exception {
		F = it.univpm.ProgettoGoffiCorso.Service.Prevista.PressioneFutura(city);
		for(int i =0; i<F.getList().size();i++) {
			v.addElement( F.getList().get(i).getMain().getPressure());
			}
	}

}
