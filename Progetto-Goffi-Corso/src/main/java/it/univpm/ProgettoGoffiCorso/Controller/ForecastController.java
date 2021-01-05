package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgettoGoffiCorso.Vettori;
@RestController
public class ForecastController {
	
	private Vettori v=it.univpm.ProgettoGoffiCorso.ProgettoGoffiCorsoApplication.vett;
	@RequestMapping("/forecast")
	public Vector<String> previsione(@RequestParam String city) throws Exception {
		v.setNome(city);
		v.SetForecastVett();
		Vector<String> previsione = new Vector<String>();
		for(int i=0;i<v.GetForecastVett().size();i++) {
			previsione.add("La pressione prevista nella città di " + city + " tra " + ((i + 1) * 3) + " ore vale: "
						+ v.GetForecastVett().get(i) +" hPa");
		}
		
		return previsione;
	}
	@RequestMapping("/so")
	public Vector<Integer> so() {
		return v.GetForecastVett();
	}
}