package it.univpm.ProgettoGoffiCorso.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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

//acquisizione dati della pressione attuale
public class current {
	String url = "api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}";
	HttpURLConnection OpenConnection = HttpURLConnection new URL(url).OpenCOnnection());
	

}
