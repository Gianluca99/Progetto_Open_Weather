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
            String url = "api.openweathermap.org/data/2.5/weather?q={Monsano}&appid={9749a54af40a5c60170358c708358ed}";
            URLConnection openConnection = new URL(url).openConnection();
            InputStream in = openConnection.getInputStream();
            //Risposta da parte del server
            String risposta = new Scanner(in).next();
            BufferedWriter dati = new BufferedWriter(new FileWriter ("dati.txt"));
            while(risposta.isEmpty() == false) {
                dati.write(risposta);}
            
                dati.close();
            
                //InputStreamReader inR = new InputStreamReader( in ); 
                //BufferedReader buf = new BufferedReader( writer );
                /*
                while((line = buf.readLine()) != null) {
                    data += line;
                    System.out.println(line);
                }*/
                in.close();
                
        
        }
        catch(IOException e) {
            System.out.println("Errore nella lettura.");
            System.out.println(e);
        }
        
        JSONObject obj = new JSONObject();
        System.out.println("OK");
        }
        
        
        }