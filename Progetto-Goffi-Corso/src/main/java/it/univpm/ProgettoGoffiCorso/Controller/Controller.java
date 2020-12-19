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

 

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
	@RestController
	public class Controller {
		private static URLConnection connessione;
		
		
		public static void main(String[] args) {
		
			String key = "f044a8c15896675617344a49813d1a16";
			String città = "Ancona";
			// TODO Auto-generated method stub
			try {
				StringBuilder result = new StringBuilder();
				URL url = new URL ("api.openweathermap.org/data/2.5/weather?q="+ città + "&appid="+ key);
				connessione = url.openConnection();
				BufferedReader rd = new BufferedReader (new InputStreamReader(connessione.getInputStream()));
				String line;
				while((line = rd.readLine()) != null) {
					result.append(line);
				}
				rd.close();
				System.out.println(result);
				//int lung = connessione.getContentLength();
				int tempo= connessione.getConnectTimeout();
				System.out.println(tempo);
			} catch(IOException e) {
				e.printStackTrace();
			}

		}}

	

        
        

