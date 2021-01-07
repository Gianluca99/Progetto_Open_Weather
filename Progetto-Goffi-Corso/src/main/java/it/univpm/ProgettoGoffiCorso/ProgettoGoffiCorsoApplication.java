package it.univpm.ProgettoGoffiCorso;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import it.univpm.ProgettoGoffiCorso.Stats.ValoriStatistici;

@SpringBootApplication
public class ProgettoGoffiCorsoApplication {
	public static Scanner in = new Scanner(System.in);
	public static Vettori vett = new Vettori("","");
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProgettoGoffiCorsoApplication.class, args);
		int scelta;
		System.out.println("Benvenuto!");
		do {
		System.out.println("MENU':\n1)Pressione corrente;\n2)Pressione futura;\n3)Dati storici;\n4)Dati statistici;\n5)Esci;");
		scelta = in.nextInt();
		switch(scelta) {
		case 1:
			in = new Scanner(System.in);
			System.out.println("Inserisci la città:");
			vett.setNome(in.nextLine());
			it.univpm.ProgettoGoffiCorso.Service.Current.PressioneAttuale(vett.getNome());
			break;
		
		case 2:
			in = new Scanner(System.in);
			System.out.println("Inserisci la città:");
			vett.setNome(in.nextLine());
			it.univpm.ProgettoGoffiCorso.Service.Forecast.PressioneFutura(vett.getNome());
			break;
		
		case 3:
			in = new Scanner(System.in);
			System.out.println("Inserisci la città:");
			vett.setNome(in.nextLine());
			System.out.println("Inserisci la data nel formato: aaaa/mm/gg");
			vett.setData(in.nextLine());
			it.univpm.ProgettoGoffiCorso.Service.Historical.Storico(vett.getNome(), vett.getData());
			break;
			
		case 4:
			in = new Scanner(System.in);
			System.out.println("Inserisci la città:");
			vett.setNome(in.nextLine());
			System.out.println("Inserisci la data nel formato: aaaa/mm/gg");
			vett.setData(in.nextLine());
			vett.SetHistoricalVett();
			vett.SetForecastVett();
			
			ValoriStatistici statF = new ValoriStatistici(vett.GetForecastVett());
			ValoriStatistici statS = new ValoriStatistici(vett.GetHistoricalVett());
						
			System.out.println("Il valore minimo previsto vale: "+ statF.getValoreMin());
			System.out.println("Il valore minimo storico vale: "+ statS.getValoreMin());
			System.out.println("La media storica vale: "+ statS.getMedia());
			System.out.println("La media prevista vale: "+ statF.getMedia());
			System.out.println("La varianza storica vale: "+ statS.getVarianza());
			System.out.println("La varianza prevista vale: "+ statF.getVarianza());
			break;
			
		case 5:
			System.out.println("Ciao!");
			break;
		
		default:
			System.out.println("Comando inesistente! Riprova: ");
		}
		}while(scelta!=5);
		in.close();
		}


}