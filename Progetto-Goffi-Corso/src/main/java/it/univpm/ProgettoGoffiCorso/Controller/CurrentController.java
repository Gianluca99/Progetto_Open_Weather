/**
 * Classe che si occupa della connessione con localhost della pressione corrente tramite le rotta current
 * @author A.Goffi, G.Corso
 * */

package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgettoGoffiCorso.Service.Current;


@RestController
public class CurrentController {

	@RequestMapping ("/Welcome")
	public String Start() {
	return"Benvenuto nella stazione \"UnderPressure\"!!!\nInserisci il nome della città che vuoi e poi seleziona: 1) Per conoscere il valore della Pressione Attuale;\n2) Per conoscere le previsioni sulla pressione;\n3) Per conoscere i valori passati, inserisci una data fino a 5 giorni antecedenti ad oggi!\n4) Per Uscire dalla Stazione!\n\n";
	}
	
	
	@RequestMapping ("/current") 
	public String current (@RequestParam String city) throws Exception {
		String pa ="" ;
		String R="";
		    pa = Current.PressioneAttuale(city);
		    Map<String, Object> APImap = com.google.gson.parsing.CurrentParsing.jsonToMap(pa.toString());
			Map<String, Object> MainMap = com.google.gson.parsing.CurrentParsing.jsonToMap(APImap.get("main").toString());
			R = "La pressione attuale nella città di "+city+" vale: "+MainMap.get("pressure")+"hPa";
		return R;
				}
	
	
}
	