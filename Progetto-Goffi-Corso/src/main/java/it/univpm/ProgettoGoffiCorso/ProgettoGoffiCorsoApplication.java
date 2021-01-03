package it.univpm.ProgettoGoffiCorso;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgettoGoffiCorsoApplication {
	public static Input i = new Input("", "");

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProgettoGoffiCorsoApplication.class, args);
		int scelta;
		System.out.println("Benvenuto!");
		do {
		Scanner in = new Scanner(System.in);
		System.out.println("\nInserisci la città:");
		i.setNome(in.nextLine());
		Scanner in2 = new Scanner(System.in);
		System.out.println("Inserisci la data nel formato: aaaa/mm/gg");
		i.setData(in2.nextLine());
		System.out.println("MENU':\n1)Pressione corrente;\n2)Pressione futura;\n3)Dati storici;\n4)exit.");
		scelta = in.nextInt();
		switch(scelta) {
		case 1:
			it.univpm.ProgettoGoffiCorso.service.Current.PressioneAttuale(i.getNome());
			break;
		
		case 2:
			it.univpm.ProgettoGoffiCorso.service.Forecast.PressioneFutura(i.getNome());
			break;
		
		case 3:
			it.univpm.ProgettoGoffiCorso.service.Historical.Storico(i.getNome(), i.getData());
			break;
		
		case 4:
			System.out.println("Ciao!");
			break;
		
		default:
			System.out.println("Comando inesistente! Riprova: ");
		}
		}while(scelta!=4);
		}

}