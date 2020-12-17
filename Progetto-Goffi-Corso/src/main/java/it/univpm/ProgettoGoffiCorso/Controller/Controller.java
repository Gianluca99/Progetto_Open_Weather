package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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
	public class Controller {{
		//Creo richiesta di tipo http per PREVISIONI ATTUALI
		try {

			String url = "api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}";
			URLConnection openConnection = new URL(url).openConnection();
			InputStream in = openConnection.getInputStream();
			//Risposta da parte del server
			
			
			String data = "";
			String line = "";
			
				
				InputStreamReader inR = new InputStreamReader( in ); 
				BufferedReader buf = new BufferedReader( inR );
				while((line = buf.readLine()) != null) {
					data += line;
					System.out.println(line);
				
			}}
		finally {
			in.close();
		}
			}}

