/**
  * Classe che si occupa della connessione con localhost della pressione corrente tramite le rotta current
 * @author A.Goffi,
 * @author G.Corso
 * */

package it.univpm.ProgettoGoffiCorso.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

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
	
	@ExceptionHandler(FileNotFoundException.class)
	public static String ErrorPage(FileNotFoundException ex) {
		return "Città non trovata!";
	}

	@ExceptionHandler(IOException.class)
	public static String IOExManage(IOException e) {
		String S = "";
		if (e.getMessage().contains(" code: 400 "))
			S = "Città non inserita!";
		else
			S = "API_Key non inserita";
		return S;
	}
	
}
	