package it.univpm.ProgettoGoffiCorso.Controller;


import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgettoGoffiCorso.Vettori;

@RestController
public class HistoricalController {
	@Autowired
	private static Vettori h = new Vettori("","");
	
	@RequestMapping ("/historical")
	public Vector<String> storic(@RequestParam String city,@RequestParam String data) throws Exception  {
		h.setNome(city);
		h.setData(data);
		h.SetHistoricalVett();;
		return h.GetHistoricalVett();

	}
}
