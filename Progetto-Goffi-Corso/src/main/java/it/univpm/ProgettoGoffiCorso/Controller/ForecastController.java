package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.univpm.ProgettoGoffiCorso.*;

@RestController
public class ForecastController {
	@Autowired
	private static Vettori f = new Vettori("", "");

	@RequestMapping("/forecast")
	public Vector<String> previsione(@RequestParam String city) throws Exception {
		f.setNome(city);
		f.SetForecastVett();
		return f.GetForecastVett();
	}
}