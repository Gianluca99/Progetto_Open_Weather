# Progetto_Open_Weather
![WhatsApp Image 2021-01-20 at 17 19 36](https://user-images.githubusercontent.com/75131126/105203795-cd494680-5b43-11eb-8246-2640be8a7c72.jpeg)
# Introduzione
OpenWeather è un servizio online che fornisce dati globali relativi al meteo, includendo meteo corrente, previsioni e dati storici.
Le specifiche di progetto assegnate prevedevano la realizzazione di un'applicazione web in grado di prelevare i dati sulla pressione atmosferica dai servizi di OpenWeather e rielaborarli consentendo all'utente di visualizzarli per intero,  filtrarli o visualizzarne le statistiche.
# Modalità d'uso
Avviata la SpringBoot Application, è possibile raggiungere le varie rotte (vedi <b>Richieste web</b>) contattando la porta 8081 del localhost.<br>
<i>ATTENZIONE:</i> Purtroppo, per convertire la data inserita dall'utente nel formato AAAA/MM/GG in formato UNIX(riconosciuto da OpenWeather), è stata utilizzata un' API con numero di chiamate limitato.
# Diagrammi UML
<b>Diagramma dei casi d'uso</b>
![UseCase](https://user-images.githubusercontent.com/76054341/105207337-b147a400-5b47-11eb-97fb-9a3bcf883508.jpg)
<br>Come si evince dal diagramma, l'utente ha la possibilità di scegliere di visualizzare tre tipologie di dati: attuali, previsti e storici.<br>
Inserendo il nome della città e, per i dati storici, la data è possibile ottenere i meta dati, i dati reletivi alla pressione atmosferica.<br> 
E', inoltre, possibile selezionare parte dei dati o generare statistiche.<br>
<b>Diagrammi delle classi</b><br>
![image](https://user-images.githubusercontent.com/76054341/105208793-62027300-5b49-11eb-944c-ed439c71f927.png)
<br>All'interno del package <b>Controller</b> si trovano le classi dedicate alle chiamate API e alle richieste web.<br>
In particolare:<br> 
<i>APIController</i>: si occupa delle chiamate API di OpenWeather, della richiesta di tipo GET /Welcome la quale presenta un menù contenente tutte le possibili rotte con relative spiegazioni e della richiesta di tipo POST per inserire la API key di OpenWeather;<br>
<i>CurrentController</i>: si occupa delle richieste web di tipo GET per la visualizzazione dei dati attuali;<br>
<i>ForecastController</i>: si occupa delle richieste web di tipo GET per la visualizzazione delle previsioni (fino a 5 giorni) e delle relative statistiche con possibilità di filtraggio;<br>
<i>HistoricalController</i>: si occupa delle richieste web di tipo GET per la visualizzazione dei dati storici (I dati storici gratuiti forniti da OpenWeather si riferiscono soltanto al giorno precedente a quello inserito) e delle relative statistiche. E' possibile inoltre visualizzare un database con statistiche relative agli anni precedenti (inventati a scopo didattico) e, tramite richiesta di tipo POST, aggiornare il database.<br>
![image](https://user-images.githubusercontent.com/76054341/105212271-88c2a880-5b4d-11eb-95fa-b92830682fad.png)
<br>All'interno del package <b>Service</b> si trovano le classi che richiamano i metodi per scaricare i dati in formato Json da OpenWeather e i metodi per effettuarne il parsing. Infine i dati ottenuti possono essere scritti su un file di testo tramite i metodi <i>ScritturaFile</i>.<br>
![image](https://user-images.githubusercontent.com/76054341/105211971-28336b80-5b4d-11eb-86d2-90284b134d08.png)
<br>All'interno del package <b>parsing</b> si trovano le classi dedicate al parsing del Json. Tale operazione è stata effettuata utilizzando la libreria Gson che consente, attraverso il metodo <i>.fromJson</i>, di convertire un file Json in un oggetto Java che rispecchi la sua struttura (vedi package <b>Current, Forecast, Historical</b>).<br>
![package](https://user-images.githubusercontent.com/76054341/105214496-5e261f00-5b50-11eb-9e9d-f333280c3a75.png)
<br>
![Stats classDiagramm](https://user-images.githubusercontent.com/76054341/105214759-b3fac700-5b50-11eb-9b5c-a1dcfb2ca265.jpg)
<br>All'interno del package <b>Stats</b> si trovano le classi dedicate alla gestione delle statistiche.<br>
In particolare:<br>
<i>stats</i>: è la super classe che contiene tutti i metodi per il calcolo delle statistiche quali valore massimo, valore minimo, media, valore quadratico medio e varianza;<br>
<i>ForecastStats</i>: si occupa di creare il ForecastObject e, selezionando i dati relativi alle previsioni sulla pressione, genera le statistiche ereditando i metodi dalla super classe;<br>
<i>HistoricalStats</i>: si occupa di creare l' HistoricalObject e, selezionando i dati storici sulla pressione, genera le statistiche ereditando i metodi dalla super classe.<br>
![Filters classDiagramm](https://user-images.githubusercontent.com/76054341/105214815-cb39b480-5b50-11eb-9c2f-650f8e593d86.jpg)
<br>All'interno del package <b>Filters</b> si trovano le classi dedicate alla gestione dei filtri.<br>
In particolare:<br>
<i>HistoricalFilter</i>: si occupa di filtrare il database contenente le statistiche mensili della pressione sugli anni precedenti in base all'anno e al nome della città seguito dall'anno. Tale classe viene estesa dalla classe <i>AnnoList</i> contenuta all'interno del package <b>Annata</b>.<br>
<i>RangeFilter</i>: si occupa di filtrare le previsioni sulla pressione in base ad una soglia di errore in hPa. Per fare ciò è stato salvato in un file di testo, un set di previsioni relative alla città di Ancona per 5 giorni e confrontato quotidianamente con i dati attuali fornendo una stima di accuratezza delle previsioni. Ovviamente per ottenere una stima più accurata si sarebbe dovuto ripetere più volte tale processo.<br>
<b>Diagrammi delle sequenze</b>
![Chiamata Dati Pressione Sequence ](https://user-images.githubusercontent.com/76054341/105214909-e3113880-5b50-11eb-88e8-a31da930bad7.jpg)
<br>Tale diagramma illustra la gerarchia di chiamate ai metodi che consente di ottenere i dati relativi alla pressione prevista. Molto simile sarebbero quelli riferiti alla pressione corrente e a quella storica.<br>
![Chiamata Stat Sequence](https://user-images.githubusercontent.com/76054341/105214912-e3a9cf00-5b50-11eb-8744-7b5aca23e182.jpg)
<br>Tale diagramma illustra la gerarchia di chiamate ai metodi che consente di ottenere le statistiche relative alla pressione prevista. Molto simile sarebbe quello riferito  alla pressione storica.<br>
![Filters Sequence](https://user-images.githubusercontent.com/76054341/105214906-e278a200-5b50-11eb-8b8a-4b6b0bce1c13.jpg)
<br>Tale diagramma illustra la gerarchia di chiamate ai metodi che consente di ottenere i dati filtrati relativi alla pressione prevista. Molto simile sarebbe quello riferito  alla pressione storica.<br>
<b>Richieste web</b>
![tabella rotte](https://user-images.githubusercontent.com/76054341/105220124-91b87780-5b57-11eb-8bcf-a1ceb20f446f.jpg)
<b>Autori</b><br>
L'applicazione è stata svolta da: Corso Gianluca e Goffi Alessandro.
