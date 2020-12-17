package it.univpm.ProgettoGoffiCorso.model;



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

public class current{{

	
		try {
		String url = "api.openweathermap.org/data/2.5/weather?q={city name}&appid=f044a8c15896675617344a49813d1a16";
		URLConnection openConnection = new URL(url).openConnection();
	}
		catch(Exception e) {
			System.out.println("Errore.");
		}
	}
}
			

			
			
