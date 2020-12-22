package it.univpm.ProgettoGoffiCorso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.ProgettoGoffiCorso.Controller.Controller;

@SpringBootApplication
public class ProgettoGoffiCorsoApplication {

	public static void main(String[] args) throws Exception{
		String nomeCittà;
		//System.out.println("Inserisci la città:");
		SpringApplication.run(ProgettoGoffiCorsoApplication.class, args);
		
		it.univpm.ProgettoGoffiCorso.Controller.Controller.chiamataAPI();
	}

}
