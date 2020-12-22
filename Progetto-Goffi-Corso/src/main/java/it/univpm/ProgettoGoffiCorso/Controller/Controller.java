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
	
	public static Map<String, Object> jsonToMap(String str){
		Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>()  {}.getType());
		return map;	
		}
	
	public static void chiamataAPI() throws Exception {

		String key = "f044a8c15896675617344a49813d1a16";
		String città = "Roma";

		// TODO Auto-generated method stub
		 String result ="";
		try {
			// StringBuilder result = new StringBuilder();
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + città + "&appid=" + key + "&main=pressure");
			connessione = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			String line;
			//FileWriter writer = new FileWriter("dati.txt");
			while ((line = rd.readLine()) != null) {
				result += line;
				//writer.write(result.get(line));;
			}
			rd.close();
			System.out.println(result);
			//writer.close();
			connessione.setConnectTimeout(1000);
			//System.out.println("Dati correttamente salvati sul file dati.");
			Map<String, Object> APImap = jsonToMap(result.toString());
			Map<String, Object> MainMap = jsonToMap(APImap.get("main").toString());
			System.out.println("Città:"+ APImap.get("name")+"Pressione corrente: "+ MainMap.get("pressure"));

			
		} catch (MalformedURLException e) {
			System.out.println(e);
		}
	}

}
