package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.Vector;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.univpm.ProgettoGoffiCorso.Vettori;
import it.univpm.ProgettoGoffiCorso.Stats.ValoriStatistici;

@RestController
public class ForecastController {

	private static Vettori h = it.univpm.ProgettoGoffiCorso.ProgettoGoffiCorsoApplication.vett;

	@RequestMapping("/forecast")
	public Vector<String> previsione(@RequestParam String city) throws Exception {
		h.setNome(city);
		h.SetForecastVett();
		Vector<String> Prev = new Vector<String>();
		for (int i = 0; i < h.GetForecastVett().size(); i++) {
			Prev.add("La pressione prevista nella città di " + city + " tra " + ((i + 1) * 3) + " ore vale: "
					+ h.GetForecastVett().get(i) + " hPa");
		}
		return Prev;
	}

	@RequestMapping("/forecast/stat")
	public Vector<String> StaPrev(@RequestParam String city) throws Exception {
		h.setNome(city);
		h.SetForecastVett();
		ValoriStatistici v = new ValoriStatistici(h.GetForecastVett());
		Vector<String> StaPre = new Vector<String>();
		StaPre.add(0, "Il valor Medio dei dati predetti è: " + v.getMedia());
		StaPre.add(1, "La varianza vale: "+ v.getVarianza() );
		StaPre.add(2, "la massima pressione futura è di :" + v.getValoreMax() + " hPa");
		StaPre.add(3, "La minima futura è  di :" + v.getValoreMin() + " hPa");
		return StaPre;
	}
}