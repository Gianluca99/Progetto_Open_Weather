package org.json.simple;

import org.json.simple.JSONObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class JSONObject {
	
	public  JSONObject main;
	public String Cityname;
	public Double Pressione_Attuale;
	
	
	public JSONObject(String Result) {
		try {
		this.main = new JSONObject(Result);
		main.Cityname="";
		main.Pressione_Attuale= (double) 0;}
		catch(Exception e) {
			System.out.print(e);
		}
	}
	/**
	 * imposta il nome della città al file JSON
	 * 
	 * @param nome della città
	 *
	 * */
	public void SetCityname (String città) {
		main.Cityname = città;
	}
	
	/**
	 * 
	 * metodo per acquisire  la pressione attuale  alla città
	 * 
	 * @param pressione attuale
	 * */
	public void SetCurrentPressure (Double press) {
		main.Pressione_Attuale = press;
	}
	
	public String GetcityName () {
		return (String) main.Cityname;
	}
	
 	public Double GetCurrentPressure() {
		return (double) main.Pressione_Attuale;
	}
	
	
	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cityname == null) ? 0 : Cityname.hashCode());
		result = prime * result + ((Pressione_Attuale == null) ? 0 : Pressione_Attuale.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JSONObject other = (JSONObject) obj;
		if (Cityname == null) {
			if (other.Cityname != null)
				return false;
		} else if (!Cityname.equals(other.Cityname))
			return false;
		if (Pressione_Attuale == null) {
			if (other.Pressione_Attuale != null)
				return false;
		} else if (!Pressione_Attuale.equals(other.Pressione_Attuale))
			return false;
		return true;
	}
	public static JSONObject getMain() {
		return main;
	}
	public static void setMain(JSONObject main) {
		JSONObject.main = main;
	}
	
	*/
	
	
	
	
}
