/**
 * Classe che estende la superclasse Stats e genera le statistiche relative ai dati storici
 * @author A.Goffi
 * @author G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Stats;

import java.util.Vector;
import Historical.HistoricalObject;

public class HistoricalStats extends Stats{
	private static HistoricalObject H ;
	private static Vector<Integer> v = new Vector<Integer>();
	

	public HistoricalStats(String city, String data) throws Exception {
		super();
		setV(city, data);
		super.setValoreMax(v);
		super.setValoreMax(v);
		super.setMedia(v);
		super.setVarianza(v);
		super.setValoreQM(v);
	}

	/**
	 * Metodo che salva in un vettore v i dati relativi alla pressione storica dall'HistoricalObject.
	 * Tale vettore verrà poi passato ai metodi della superclasse che genera le statistiche.
	 * @param city
	 * @throws Exception
	 */

	public static void setV(String city, String data) throws Exception {
		H = it.univpm.ProgettoGoffiCorso.Service.Storica.Storico(city, data);
		for (int i = 0; i < H.getHourly().size(); i++) {
			v.addElement(H.getHourly().get(i).getPressure());
		}
	}



}
