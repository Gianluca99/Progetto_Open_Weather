/**
 * Classe che estende la superclasse Stats e genera le statistiche relative alle previsioni
 * @author A.Goffi
 * @author G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Stats;

import java.util.Vector;

import Forecast.ForecastObject;

public class ForecastStats extends Stats {
	private static ForecastObject F;
	private static Vector<Integer> v = new Vector<Integer>();

	public ForecastStats(String city) throws Exception {
		super();
		setV(city);
		super.setValoreMax(v);
		super.setValoreMin(v);
		super.setMedia(v);
		super.setVarianza(v);
		super.setValoreQM(v);
	}

	/**
	 * Metodo che salva in un vettore v i dati relativi alla pressione prevista dal
	 * ForecastObject. Tale vettore verrà poi passato ai metodi della superclasse
	 * che genera le statistiche.
	 * 
	 * @param city
	 * @return void
	 * @throws Exception
	 */

	public static void setV(String city) throws Exception {
		F = it.univpm.ProgettoGoffiCorso.Service.Prevista.PressioneFutura(city);
		for (int i = 0; i < F.getList().size(); i++) {
			v.addElement(F.getList().get(i).getMain().getPressure());
		}
	}

}
