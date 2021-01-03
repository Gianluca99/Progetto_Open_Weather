package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Forecast.ForecastObject;

@RestController
public class ForecastController {
	public static ForecastObject F;


	
	@RequestMapping("/forecast")
	public Vector<String> previsione(@RequestParam String city) throws Exception {
		F= it.univpm.ProgettoGoffiCorso.service.Forecast.PressioneFutura(city);
		Vector<String> R = new Vector<String>();
		for (int i =0; i<F.getList().size(); i++) {
			R.addElement("La pressione prevista a " + city + " tra " + ((i + 1) * 3) + " ore vale: "
					+ F.getList().get(i).getMain().getPressure()+" hPa");
		}
		return R;
	}
}
