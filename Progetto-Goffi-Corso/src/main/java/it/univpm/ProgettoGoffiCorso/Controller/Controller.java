package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jdk.internal.org.jline.reader.Parser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Scanner;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;
import org.json.ParseException.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

@RestController
public class Controller {
	private static URLConnection connessione;

	public static void chiamataAPI() throws Exception {

		String key = "f044a8c15896675617344a49813d1a16";
		String città = "Ancona";

		// TODO Auto-generated method stub
		String result = "";
		try {
			// StringBuilder result = new StringBuilder();
			URL url = new URL(
					"http://api.openweathermap.org/data/2.5/weather?q=" + città + "&appid=" + key + "&main=pressure");
			connessione = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			String line;
			FileWriter writer = new FileWriter("dati.txt");
			while ((line = rd.readLine()) != null) {
				result += line;
				writer.write(result);
			}
			rd.close();
			writer.close();
			connessione.setConnectTimeout(1000);
			System.out.println("Dati correttamente salvati sul file dati.");
		} catch (MalformedURLException e) {
			System.out.println(e);
		}

		try {
			ObjectMapper obj = new ObjectMapper();
			result = obj.writeValueAsString(result);
			System.out.println(result);

		} catch (Exception e1) {
			System.out.println("Porco Dio");
		}
	}
}
