package it.univpm.ProgettoGoffiCorso.Stats;

import java.util.Vector;
import Historical.HistoricalObject;

public class HistoricalStats extends Stats{
	private static HistoricalObject H ;
	private static Vector<Integer> v = new Vector<Integer>();
	

	public HistoricalStats(String city, String data) throws Exception {
		super();
		setV(city, data);
		super.setValMax(v);
		super.setValMax(v);
		super.setMedia(v);
		super.setVar(v);
		super.setValQM(v);
	}



	public static void setV(String city, String data) throws Exception {
		H = it.univpm.ProgettoGoffiCorso.Service.Storica.Storico(city, data);
		for (int i = 0; i < H.getHourly().size(); i++) {
			v.addElement(H.getHourly().get(i).getPressure());
		}
	}



}
