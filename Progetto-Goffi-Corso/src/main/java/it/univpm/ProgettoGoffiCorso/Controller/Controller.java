/**
 * Classe che si occupa delle varie chiamate API 
 *		*Connessione con OpenWeather 
 *		*Conversione della data da AAAA/MM/GG a UNIX
 *		*Cordinate Geografiche di un'Indirizzo/Città 
 * @author A.Goffi, G.Corso
 * */
package it.univpm.ProgettoGoffiCorso.Controller;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Controller {
	private static URLConnection connessione;
		
	/**stabilesce una connessione con il sito fornito dall'API
	 * i dati vengono inseriti in una stringa "result" 
	 * 
	 * @param API  
	 * @param cityName
	 * 
	 * @return String result 
	 * @throws MalformedURLException
	 * 
	 */
	public static  String chiamataAPI(String API) throws Exception {

		String key = "f044a8c15896675617344a49813d1a16";
		 String result ="";
		try {
				URL url = new URL(API + "&appid=" + key);
				connessione = url.openConnection();
				BufferedReader rd = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
				String line;
				connessione.setConnectTimeout(1000);
				while ((line = rd.readLine()) != null) {
					result += line;
					}
				rd.close();
			} catch (MalformedURLException e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	/**
	 * Restituisce una stringa con la codifica della data inserita in formato UNIX
	 * 
	 * @param data --> AAAA/MM/GG
	 * 
	 * @return UNIX_Data 
	 * @exception MalformedURLException
	 * */
	public static String Conversione_UNIX (String data) throws Exception{

		String UNIX_Data="";
		try {
			URL url = new URL("https://showcase.api.linx.twenty57.net/UnixTime/tounix?date="+data);
			connessione = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			String line;
			connessione.setConnectTimeout(1000);
			while ((line = rd.readLine()) != null) {
				UNIX_Data += line;
				}
			rd.close();
			
		}catch (MalformedURLException e) {
			System.out.println(e);
		}
		return UNIX_Data;
	}
	
	/**
	 * inserendo un indirizzo fornisce le coordinate geografiche e la traduzone in varie lingue (vedere classe oggetto)
	 * 																						
	 * 									
	 * @param Città --> nome della città / indirizzo di cui si vuole conoscere le coordinate
	 * 
	 * @return coord
	 * */
	public static String Coordinate (String City) throws Exception {
		String key = "f044a8c15896675617344a49813d1a16";
		 String coord ="";
		try {
				URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q=" +City+ "&limit=1&appid=" + key);
				connessione = url.openConnection();
				BufferedReader rd = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
				String line;
				connessione.setConnectTimeout(1000);
				while ((line = rd.readLine()) != null) {
						coord += line;
					}
				rd.close();
			} catch (MalformedURLException e) {
			System.out.println(e);
		}
		//System.out.println("file scaricato per le coordinate :"+coord);
		
		return coord;
	}
}
