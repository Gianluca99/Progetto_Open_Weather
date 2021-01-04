package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;

import it.univpm.ProgettoGoffiCorso.Service.Current;


@RestController
public class CurrentController {
	
	@Autowired 
	private static  it.univpm.ProgettoGoffiCorso.Service.Current Pattuale;

	@RequestMapping ("/Welcome")
	public String Start() {
	return"Benvenuto nella stazione \"UnderPressure\"!!!\nInserisci il nome della città che vuoi e poi seleziona: 1) Per conoscere il valore della Pressione Attuale;\n2) Per conoscere le previsioni sulla pressione;\n3) Per conoscere i valori passati, inserisci una data fino a 5 giorni antecedenti ad oggi!\n4) Per Uscire dalla Stazione!\n\n";
	}
	
	
	@RequestMapping ("/current") 
	public String current (@RequestParam String city) {
		String pa ="" ;
		String R="";
		try {
		    pa = Current.PressioneAttuale(city);
		    Map<String, Object> APImap = com.google.gson.parsing.CurrentParsing.jsonToMap(pa.toString());
			Map<String, Object> MainMap = com.google.gson.parsing.CurrentParsing.jsonToMap(APImap.get("main").toString());
			R = "La pressione attuale nella città di "+city+" vale: "+MainMap.get("pressure")+"hPa";
		} catch (Exception e) {
			//return "Città non trovata, Ritenta!";
		}
		return R;
				}
	
	
}
	