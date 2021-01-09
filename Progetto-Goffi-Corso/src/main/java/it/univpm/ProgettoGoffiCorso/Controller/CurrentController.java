/**
 * Classe che si occupa della connessione con localhost della pressione corrente tramite le rotta current
 * @author A.Goffi, G.Corso
 * */

package it.univpm.ProgettoGoffiCorso.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Current.PressioneAttuale;



@RestController
public class CurrentController {	
	@RequestMapping ("/metaCurrent") 
	public PressioneAttuale metadati (@RequestParam String city) throws Exception {
		return it.univpm.ProgettoGoffiCorso.Service.Current.PressioneAttuale(city);
				}
	@RequestMapping ("/Current") 
	public Integer current (@RequestParam String city) throws Exception {
		return it.univpm.ProgettoGoffiCorso.Service.Current.PressioneAttuale(city).getMain().getPressure();
		
				}
	
	
	
}
	