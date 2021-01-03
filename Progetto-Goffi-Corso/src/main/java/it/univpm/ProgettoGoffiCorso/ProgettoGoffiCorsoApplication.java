package it.univpm.ProgettoGoffiCorso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgettoGoffiCorsoApplication {
	public static Citta c = new Citta();
	public static Data d = new Data();

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProgettoGoffiCorsoApplication.class, args);
	}
}