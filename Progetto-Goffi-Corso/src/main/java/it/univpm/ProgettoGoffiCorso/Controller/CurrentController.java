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

import Current.CurrentObject;

@RestController
public class CurrentController {
	/**
	 * Rotta che restituisce i metadati in formato json sulla pressione corrente
	 * 
	 * @param city -> nome della città
	 * @return CurrentObject
	 * @throws Exception
	 **/
	@RequestMapping("/MetaCurrent")
	public CurrentObject metadati(@RequestParam String city) throws Exception {
		return it.univpm.ProgettoGoffiCorso.Service.Corrente.PressioneAttuale(city);
	}

	/**
	 * Rotta che restituisce i dati in formato json sulla pressione corrente
	 * 
	 * @param city -> nome della città
	 * @return pressione
	 * @throws Exception
	 **/

	@RequestMapping("/Current")
	public Integer current(@RequestParam String city) throws Exception {
		return it.univpm.ProgettoGoffiCorso.Service.Corrente.PressioneAttuale(city).getMain().getPressure();
	}

	/**
	 * Gestione delle eccezioni nel caso di città non esistente.
	 * 
	 * @param FileNotFoundException ex
	 * @return stringa
	 **/
	@ExceptionHandler(FileNotFoundException.class)
	public static String ErrorPage(FileNotFoundException ex) {
		return "Città non trovata!";
	}

	/**
	 * Gestione delle eccezioni nel caso di città o API key non inserita.
	 * 
	 * @param IOException e
	 * @return stringa
	 **/
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
