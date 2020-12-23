package it.univpm.ProgettoGoffiCorso;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.ProgettoGoffiCorso.Controller.Controller;

@SpringBootApplication
public class ProgettoGoffiCorsoApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(ProgettoGoffiCorsoApplication.class, args);
		Scanner in = new Scanner (System.in);
	
		
		System.out.println("Inserisci la Città:");
		String CityName = in.nextLine();
		//in.close();
		try {
		it.univpm.ProgettoGoffiCorso.model.Current.PressioneAttuale(CityName);
		}
		catch (Exception e) {
			System.out.print(e);
		}
			}

}
