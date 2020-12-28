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
		/*
		try {
			it.univpm.ProgettoGoffiCorso.model.Current.PressioneAttuale(CityName);
			}
			catch (Exception e) {
				System.out.print(e);
			}
		*/
		try {
			it.univpm.ProgettoGoffiCorso.model.Forecast.PressioneFutura(CityName);
		}catch (Exception e) {
			System.out.print(e);
		}
		/*
		System.out.println("Inserisci la data nel formato: aaaa/mm/gg");
		String Data = in.nextLine();
		try {
			it.univpm.ProgettoGoffiCorso.model.Historical.Storico(CityName, Data);
		}catch (Exception e) {
			System.out.println(e);
		}
		 */
			}

}
