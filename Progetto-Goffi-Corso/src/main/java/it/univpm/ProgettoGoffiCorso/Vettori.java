package it.univpm.ProgettoGoffiCorso;

import java.util.Vector;

import Forecast.ForecastObject;
import Historical.HistoricalObject;

public class Vettori extends Input {
	public Vector<String> ForecastVett = new Vector<String>();
	public Vector<String> HistoricalVett = new Vector<String>();
	public Vettori(String nome, String data) {
		super(nome, data);
		
	}
	public void SetForecastVett() throws Exception {
		ForecastObject F = it.univpm.ProgettoGoffiCorso.Service.Forecast.PressioneFutura(this.Nome);
		for (int i = 0; i < F.getList().size(); i++) {
			ForecastVett.addElement("La pressione prevista nella città di " + this.Nome + " tra " + ((i + 1) * 3) + " ore vale: "
					+ F.getList().get(i).getMain().getPressure()+" hPa");
		}
	}
	
	public Vector<String> GetForecastVett() {
		return this.ForecastVett;
	}
	
	public void SetHistoricalVett() throws Exception {
		HistoricalObject H = it.univpm.ProgettoGoffiCorso.Service.Historical.Storico(this.Nome, this.Data);
		for (int i = 0; i < H.getHourly().size(); i++) {
			this.HistoricalVett.addElement("La pressione storica nella città di  " + this.Nome + " a partire dall'01:00 del giorno "
					+ this.Data + " fino a 00:00 del giorno seguente valgono:" + H.getHourly().get(i).getPressure()
					+ " hPa");
		}
	}

	public Vector<String> GetHistoricalVett() {
		return this.HistoricalVett;
	}


}
