package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.Vector;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgettoGoffiCorso.Vettori;
import it.univpm.ProgettoGoffiCorso.Stats.ValoriStatistici;

@RestController
public class HistoricalController {

	private static Vettori h = it.univpm.ProgettoGoffiCorso.ProgettoGoffiCorsoApplication.vett;

	@RequestMapping("/historical")
	public Vector<String> storic(@RequestParam String city, @RequestParam String data) throws Exception {
		h.setNome(city);
		h.setData(data);
		h.SetHistoricalVett();
		Vector<String> storico = new Vector<String>();
		for (int i = 0; i < h.GetHistoricalVett().size(); i++) {
			storico.add("La pressione storica nella città di " + city + " a partire dall' 01:00 del giorno " + data
					+ " fino a 00:00 del giorno seguente valgono:" + h.GetHistoricalVett().get(i));
		}

		return storico;
	}

	@RequestMapping("/historical/stat")
	public Vector<String> StatSto(@RequestParam String city, @RequestParam String data) throws Exception {
		h.setNome(city);
		h.setData(data);
		h.SetHistoricalVett();
		ValoriStatistici v = new ValoriStatistici(h.GetHistoricalVett());
		Vector<String> StoSta = new Vector<String>();
			StoSta.add(0, "Il valor Medio dei dati storici è: " + v.getMedia());
			StoSta.add(1, "La varianza vale: "+ v.getVarianza() );
			StoSta.add(2, "la massima pressione registrata è stata di :" + v.getValoreMax() + " hPa");
			StoSta.add(3, "La minima registrata è stata di :" + v.getValoreMin() + " hPa");
		return StoSta;
	}
}