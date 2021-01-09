package it.univpm.ProgettoGoffiCorso;

import java.util.Vector;

import Forecast.ForecastObject;
import Historical.HistoricalObject;

public class Vettori extends Input {
	public Vector<Integer> ForecastVett = new Vector<Integer>();
	public Vector<Integer> HistoricalVett = new Vector<Integer>();
	
	
	public Vettori(String nome, String data) {
		super(nome, data);
		
	}
	public void SetForecastVett() throws Exception {
		ForecastObject F = it.univpm.ProgettoGoffiCorso.Service.Prevista.PressioneFutura(this.Nome);
		for (int i = 0; i < F.getList().size(); i++) {
			ForecastVett.addElement(F.getList().get(i).getMain().getPressure());
		}
	}
	
	public Vector<Integer> GetForecastVett() {
		return this.ForecastVett;
	}
	
	public void SetHistoricalVett() throws Exception {
		HistoricalObject H = it.univpm.ProgettoGoffiCorso.Service.Storica.Storico(this.Nome, this.Data);
		for (int i = 0; i < H.getHourly().size(); i++) {
			this.HistoricalVett.addElement( H.getHourly().get(i).getPressure());
		}
	}

	public Vector<Integer> GetHistoricalVett() {
		return this.HistoricalVett;
	}


}
