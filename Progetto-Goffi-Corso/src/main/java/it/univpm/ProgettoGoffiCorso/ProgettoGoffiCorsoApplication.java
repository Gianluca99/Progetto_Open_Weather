package it.univpm.ProgettoGoffiCorso;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgettoGoffiCorsoApplication {
	public static Input i = new Input("", "");
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProgettoGoffiCorsoApplication.class, args);
		int scelta;
		System.out.println("Benvenuto!");
		do {
		System.out.println("MENU':\n1)Pressione corrente;\n2)Pressione futura;\n3)Dati storici;\n4)exit.");
		scelta = in.nextInt();
		switch(scelta) {
		case 1:
			in = new Scanner(System.in);
			System.out.println("Inserisci la città:");
			i.setNome(in.nextLine());
			it.univpm.ProgettoGoffiCorso.Service.Current.PressioneAttuale(i.getNome());
			break;
		
		case 2:
			in = new Scanner(System.in);
			System.out.println("Inserisci la città:");
			i.setNome(in.nextLine());
			it.univpm.ProgettoGoffiCorso.Service.Forecast.PressioneFutura(i.getNome());
			break;
		
		case 3:
			in = new Scanner(System.in);
			System.out.println("Inserisci la città:");
			i.setNome(in.nextLine());
			System.out.println("Inserisci la data nel formato: aaaa/mm/gg");
			i.setData(in.nextLine());
			it.univpm.ProgettoGoffiCorso.Service.Historical.Storico(i.getNome(), i.getData());
			break;
		
		case 4:
			System.out.println("Ciao!");
			break;
		
		default:
			System.out.println("Comando inesistente! Riprova: ");
		}
		}while(scelta!=4);
		in.close();
		}


}