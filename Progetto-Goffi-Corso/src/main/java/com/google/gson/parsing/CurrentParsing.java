/**
 * Classe che si occupa del parsing del json relativo ai dati attuali 
 * @author A.Goffi, 
 * @author G.Corso
 * */
package com.google.gson.parsing;

import java.io.FileNotFoundException;

import com.google.gson.Gson;

import Current.CurrentObject;


public class CurrentParsing {
 public static CurrentObject PA ;
 
 /** Tramite il gson convertiamo la stringa json in un oggetto Java di tipo CurrentObject
  *  per poterlo gestire all'interno del programma.
   * 
   * @param str --> stringa che contiene il json preso dalla chiamata API.
   *
   * @return PA 
   */
	public static CurrentObject parsing(String str) throws FileNotFoundException {
		PA= new Gson().fromJson(str, CurrentObject.class);
		return PA;
	}
}
