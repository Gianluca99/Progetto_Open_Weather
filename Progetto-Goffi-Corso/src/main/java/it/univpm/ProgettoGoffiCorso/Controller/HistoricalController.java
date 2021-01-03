package it.univpm.ProgettoGoffiCorso.Controller;


import java.util.Vector;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Historical.HistoricalObject;
import it.univpm.ProgettoGoffiCorso.service.Historical;

@RestController
public class HistoricalController {

	
	
	@RequestMapping ("/historical")
	public Vector<String> storic(@RequestParam String city,@RequestParam String data)  {
		Vector <String> R = new Vector<String>();
		HistoricalObject H = null;
		try {
			H = it.univpm.ProgettoGoffiCorso.service.Historical.Storico(city, data);
		} catch (Exception e) {

		}
		for (int i=0; i<H.getHourly().size();i++) {
			R.addElement("I dati storici sulla pressione a " + city + " a partire dal giorno " + data + " valgono:"+H.getHourly().get(i).getPressure());
		}
		return R;

	}
}
