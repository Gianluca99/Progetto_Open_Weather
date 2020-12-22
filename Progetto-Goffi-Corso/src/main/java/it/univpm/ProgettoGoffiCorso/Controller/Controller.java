package it.univpm.ProgettoGoffiCorso.Controller;
import org.json.*;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;
import jdk.internal.org.jline.reader.Parser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Scanner;



import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import org.apache.tomcat.util.json.JSONParser;
import org.json.*;

 
import org.json.ParseException.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
	@RestController
	public class Controller {
		private static URLConnection connessione;
		
		
		public static void chiamataAPI() throws Exception{
		
			String key = "f044a8c15896675617344a49813d1a16";
			String città = "Roma";
			
			
			// TODO Auto-generated method stub
			try {
				//StringBuilder result = new StringBuilder();
				String result = "";
				URL url = new URL ("http://api.openweathermap.org/data/2.5/weather?q="+ città + "&appid="+ key+"&main=pressure");
				connessione = url.openConnection();
				BufferedReader rd = new BufferedReader (new InputStreamReader(connessione.getInputStream()));
				String line;
				FileWriter writer = new FileWriter ("dati.txt");
				while((line = rd.readLine()) != null) {
					result += line;
					writer.write(result);
				}
				rd.close();
				writer.close();
				connessione.setConnectTimeout(1000);
				System.out.println("Dati correttamente salvati sul file dati.");
				
				JSONParser parser = new JSONParser(new FileReader("dati.txt"));
				Object API = parser.parse();
				JSONObject.obj = (JSONObject) API;
				//double pressure = (double)  JSONObject.obj.
				
				
				
				
				
				/*JSONParser jsonParser = new JSONParser(result);
				
				JSONObject.P = jsonParser.parse();
				System.out.println("JSONObject scaricato: "+ JSONObject.P);*/
			
				/*JSONObject json = new JSONObject(result);  
				System.out.println(json.toString());
				double Pressure = JSONObject.obj.*/
				
				/*Scanner file_input = new Scanner(new BufferedReader(new FileReader("dati.txt")));	  
				String str = file_input.nextLine();
				JSONParser parser = new JSONParser(str);  
				JSONObject.obj= (JSONObject) parser.parse();
				System.out.println("JSONObject letto: "+ JSONObject.obj);
				file_input.close();*/
				
				//for(int i=0; i<org.json.simple.JSONArray.getLunghezza(); i++) {
				//	JSONObject.obj=JSONArray.array.getJSONObject(i);
				//}
				
				
				
				
				
				
				//Conversione json
				//String Result= org.json.simple.JSONValue.parseWithException(result);
				//System.out.println("JSONObject scaricato: "+ Result);
				
				
				//JSONObject.P = (JSONObject) JSONValue.parseWithException(result);
				//System.out.println("JSONObject scaricato: "+ JSONObject.P);
				
				
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
	}
			
	

	

        
        

