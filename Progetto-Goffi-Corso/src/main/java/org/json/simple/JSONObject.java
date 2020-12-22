package org.json.simple;
import java.util.LinkedHashMap;
import org.json.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class JSONObject{

	
	
	
	public static JSONObject obj;
	public JSONObject(String dati) {
		try {
		this.obj = new JSONObject(dati);
		
			}
		catch(Exception e) {
			System.out.println(e);
	}
	
				
			}
}


