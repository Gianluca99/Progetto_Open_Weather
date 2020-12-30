package it.univpm.ProgettoGoffiCorso;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgettoGoffiCorsoApplication {
	public static Citta c = new Citta();
	public static Data d = new Data();
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProgettoGoffiCorsoApplication.class, args);
		Scanner in = new Scanner(System.in);
		

		System.out.println("Inserisci la Città:");
		c.setNome(in.nextLine());
		System.out.println("Inserisci la data nel formato: aaaa/mm/gg");
		d.setData(in.nextLine());
		//it.univpm.ProgettoGoffiCorso.model.Current.PressioneAttuale(c.getNome());
		
		//it.univpm.ProgettoGoffiCorso.model.Forecast.PressioneFutura(c.getNome());
		
		it.univpm.ProgettoGoffiCorso.model.Historical.Storico(c.getNome(), d.getData());
	in.close();
	}

}
