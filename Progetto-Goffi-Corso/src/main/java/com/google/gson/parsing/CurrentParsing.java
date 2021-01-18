/**
 * Classe che si occupa del parsing del json relativo ai dati attuali 
 * @author A.Goffi, 
 * @author G.Corso
 * */
package com.google.gson.parsing;

import java.io.FileNotFoundException;
import com.google.gson.Gson;
import Current.PressioneAttuale;

public class CurrentParsing {
 public static PressioneAttuale PA ;
 
 /**
   * 
   *  @param str --> sringa che contiene il json preso dalla chiamata API.
   *
   * @return PA 
   */
	public static PressioneAttuale parsing(String str) throws FileNotFoundException {
		PA= new Gson().fromJson(str, PressioneAttuale.class);
		
		return PA;
	}
}
