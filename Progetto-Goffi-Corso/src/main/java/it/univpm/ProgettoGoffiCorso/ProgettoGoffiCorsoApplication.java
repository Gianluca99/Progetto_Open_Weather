package it.univpm.ProgettoGoffiCorso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.ProgettoGoffiCorso.Controller.Controller;

@SpringBootApplication
public class ProgettoGoffiCorsoApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(ProgettoGoffiCorsoApplication.class, args);
		it.univpm.ProgettoGoffiCorso.Controller.Controller.chiamataAPI();
	}

}
