package org.json.simple;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class JSONObject {
	private JSONObject P = null;
	
	public JSONObject() {
		this.P = new JSONObject();
	}
	
	public void chiamataAPI(String url) throws Exception{
		try {
			URLConnection openConnection = new URL(url).openConnection();
			InputStream in = openConnection.getInputStream();
			
			String data = "";
			String line = "";
			try {
			   InputStreamReader inR = new InputStreamReader( in );
			   BufferedReader buf = new BufferedReader( inR );
			  
			   while ( ( line = buf.readLine() ) != null ) {
				   data+= line;
			   }
			} finally {
			   in.close();
			}
			//System.out.println("Dati scaricati: "+data);
		
				this.P = (JSONObject) JSONValue.parseWithException(data);	 //parse JSON Object
				System.out.println("JSONObject scaricato: "+ this.P);
		
				}catch (Exception e){
					System.out.println("Errore\n"+e);
				}
					{
					
				}
			}

	public void CaricaDati (JSONObject d) {
		
	}
	

	
	
	
}