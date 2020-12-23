package it.univpm.ProgettoGoffiCorso.Controller;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;


import jdk.internal.org.jline.reader.Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.*;
import com.google.gson.reflect.*;
@RestController
public class Controller {
	private static URLConnection connessione;
		
	/**stabilesce una connessione con il sito fornito dall'API
	 * i dati vengono inseriti in una stringa "result" 
	 * 
	 * @param API  
	 * @param cityName
	 * 
	 * @return String result 
	 */
	public static  String chiamataAPI(String API, String cityName) throws Exception {

		String key = "f044a8c15896675617344a49813d1a16";
		 String result ="";
		try {
				URL url = new URL(API + cityName + "&appid=" + key);
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
}
