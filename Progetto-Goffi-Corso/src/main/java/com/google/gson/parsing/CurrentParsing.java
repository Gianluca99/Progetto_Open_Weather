/**
 * Classe che si occupa del parsing del json relativo ai dati attuali 
 * @author A.Goffi, G.Corso
 * */
package com.google.gson.parsing;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CurrentParsing {

	/**
	 * conversione da file json a Map : key-->value. Serve per ottenere i dati meteo
	 * attuali di una particolare città.
	 * 
	 * @param str --> sringa che contiene il json preso dalla chiamata API.
	 * 
	 * @return map
	 * 
	 */
	public static Map<String, Object> jsonToMap(String str) {
		Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
		}.getType());
		return map;
	}
}
