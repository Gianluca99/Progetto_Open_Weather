/**
 * Classe che si occupa della connessione con localhost della pressione corrente tramite le rotta current
 * @author A.Goffi, G.Corso
 * */

package it.univpm.ProgettoGoffiCorso.Controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Current.PressioneAttuale;



@RestController
public class CurrentController {	
	
	@RequestMapping ("/MetaCurrent") 
	public PressioneAttuale metadati (@RequestParam String city) throws Exception {
		 return it.univpm.ProgettoGoffiCorso.Service.Corrente.PressioneAttuale(city);
	}
	
	@RequestMapping ("/Current") 
	public Integer current (@RequestParam String city) throws Exception {
		return it.univpm.ProgettoGoffiCorso.Service.Corrente.PressioneAttuale(city).getMain().getPressure();
		
				}
	
	@ExceptionHandler(Exception.class)
    public static String ErrorPage(Exception ex) {
        return "Città non inserita o non trovata!";
    }
	
}
	