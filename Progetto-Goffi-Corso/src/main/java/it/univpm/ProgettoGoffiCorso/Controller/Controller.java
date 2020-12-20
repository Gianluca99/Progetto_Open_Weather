package it.univpm.ProgettoGoffiCorso.Controller;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Scanner;



import java.io.*;
import java.io.BufferedReader;
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

 
import org.json.ParseException.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
	@RestController
	public class Controller {
		private static URLConnection connessione;
		
		
		public static /*JSONObject*/void chiamataAPI() throws Exception{
		//public static void main(String[] args) {
		
			String key = "f044a8c15896675617344a49813d1a16";
			String città = "Ancona";
			// TODO Auto-generated method stub
			try {
				//StringBuilder result = new StringBuilder();
				String result = "";
				
				URL url = new URL ("api.openweathermap.org/data/2.5/weather?q="+ città + "&appid="+ key);
				connessione = url.openConnection();
				int tempo = connessione.getConnectTimeout();
				System.out.println(tempo);
				BufferedReader rd = new BufferedReader (new InputStreamReader(connessione.getInputStream()));
				String line;
				while((line = rd.readLine()) != null) {
					result += line;
				}
				rd.close();
				System.out.println("Dati scaricati:" +result);
				//int lung = connessione.getContentLength();
				//int tempo= connessione.getConnectTimeout();
				//System.out.println(tempo);
				JSONObject.P = (JSONObject) JSONValue.parseWithException(result);
				System.out.println("JSONObject scaricato: "+ JSONObject.P);
				

			} catch(Exception e) {
				System.out.println("Errore"+e);
			}
			//return JSONObject.P.toString();
			}
			
			

		}
		/*@GetMapping("/valore")
		public ResponseEntity <Object> getPressure(@RequestParam String cityName) {
			return new JSONObject.P;}
		}*/
		
	

	

        
        

