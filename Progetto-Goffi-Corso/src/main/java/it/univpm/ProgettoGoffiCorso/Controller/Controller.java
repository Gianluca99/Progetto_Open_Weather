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
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + città + "&appid=" + key);
			connessione = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			String line;
			File writer = new File("dati.txt");
			connessione.setConnectTimeout(1000);
			while ((line = rd.readLine()) != null) {
				result += line;
				Map<String, Object> APImap = jsonToMap(result.toString());
				Map<String, Object> MainMap = jsonToMap(APImap.get("main").toString());
				//writer.write("Città:"+ APImap.get("name")+"\nPressione corrente: "+ MainMap.get("pressure"));
				try{
				       if(!writer.exists()){
				           System.out.println("Nuovo file creato.");
				           writer.createNewFile();
				       }

				       FileWriter fileWriter = new FileWriter(writer, true);

				       BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);	
				       bufferedWriter.write("\nCittà:"+ APImap.get("name")+"\nPressione corrente: "+ MainMap.get("pressure")+"\n");
				       bufferedWriter.close();

				       System.out.println("Pressione aggiunta al file!");
				} catch(IOException e) {
				       System.out.println("Errore.");
				}
			}
			rd.close();
			//writer.close();
			//System.out.println(result);
			//System.out.println("Città:"+ APImap.get("name")+"Pressione corrente: \n"+ MainMap.get("pressure"));
			System.out.println("Dati salvati nel file dati.");
		} catch (MalformedURLException e) {
			System.out.println(e);
		}
	}

    	      

}
