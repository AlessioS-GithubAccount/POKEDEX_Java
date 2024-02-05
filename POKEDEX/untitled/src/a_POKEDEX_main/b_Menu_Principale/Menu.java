package a_POKEDEX_main.b_Menu_Principale;
import a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Prototypes_allenatori.AllenatoreCustom;
import a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Allenatore;
import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;
import a_POKEDEX_main.e_Battle_room.Battle_room;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/** Class Menu . Permette di avviare e far girare il gioco tramite interfacce grafiche formate da elenchi di metodi */
public class Menu {
    public void POKEDEX_TITLE() {       /** Funzione POKEDEX_TITLE() Main Title */
        System.out.println("\n_____________________________________________________________________________" +//horizontal rule
                "\n\n\n\n\n\n    P O K E D E X   B Y   A. S. \n\n\n\n\n\n\n\n\n\n" +
                "\n_____________________________________________________________________________");//horizontal rule
    }


    public void messaggio_benvenuto() {      /** Funzione messaggio_benvenuto() :  - mostra lo splash screen di avvio gioco */
        System.out.println("\n_____________________________________________________________________________");//horizontal rule
        System.out.println("\n    Benvenuto in POKEDEX !" +
                           "\n\n    Gotta Catch 'Em All!");
        System.out.println("\n_____________________________________________________________________________");//horizontal rule
    }


    public void Oak_message_0() {           /** Prof.OAk 0 : Introduzione testuale del Game master come guida del gioco */
        System.out.println("    \n- Prof. Oak: \n" +
                            "    << Sono lieto di conoscerti! io sono il prof. Oak .\n" +
                            "    Ti guiderò nell'uso del tuo Pokedex !\n" +
                            "    Posso aiutarti nella scelta dei pokemon , degli allenatori \n" +
                            "    e ti darò utili informazioni\n" +
                            "    per quest'avventura. >>");
        System.out.println("\n_____________________________________________________________________________");//horizontal rule
    }

    public void Oak_message_1() {           /** Prof.OAk 1 : Istruzioni uso Main Menu */
        System.out.println("    \n- Prof. Oak: \n" +
                          "    << Muoviti nel Menu Pokedex digitando un numero per effettuare una scelta. >>");
        System.out.println("\n_____________________________________________________________________________");//horizontal rule
    }



    /** MENU PRINCIPALE (Main Menu ) **/
    /** Il Menu_Principale() resta aperto in loop, funge da interfaccia grafica base del gioco */
    public void Menu_Principale(ArrayList<Allenatore> list_allenatori, ArrayList<Pokemon> lista_catalogoPokemon, Allenatore allenatore, ArrayList<Pokemon> lista_pokemon_scoperti, ArrayList<Pokemon> pokemon_catturati, ArrayList<Allenatore> list_allenatore_protagonista, ArrayList<Pokemon> lista_pokemon_catturati, ArrayList<Allenatore> list_allenatore_villain) {
        Scanner myScanner = new Scanner(System.in);
        int index;

        while (true) {     /** Il Menu_Principale() resta aperto in loop, ogni volta che viene eseguita una funzionalità
         si ritorna al Main Menu (ha funzione di interfaccia grafica di base base del gioco) */

        /** Innterfaccia Main Menu */
            System.out.println("\n    P O K E D E X     M E N U   \n\n" +

                            "    1.  ○ Nuova partita\n" +
                            "    2.  ○ Apri Pokedex \n" +
                            "    3.  ○ Allenatori\n" +
                            "    4.  ○ Clinica dei pokemon\n" +
                            "    5.  ○ Temple Evolution\n" +
                            "    6.  ○ Battle room\n" +
                            "    7.  ○ Esci      ");

            try {           /** Select form del Main Menu : utente utilizza il menu digitando comandi numerici da 1 a 7.
                            */
                index = myScanner.nextInt();

               /** creazione istanza di Battle_room per aprire una sezione menu per la funzionalità battle room */
                Battle_room battle_room = new Battle_room();

                /** Comandi per select del menu principale */
                switch (index) {
                    case 1:
                        Inizia_partita(allenatore, list_allenatori, list_allenatore_protagonista, lista_catalogoPokemon, lista_pokemon_catturati);
                        break;
                    case 2:
                        apri_Pokedex(lista_catalogoPokemon,allenatore,lista_pokemon_scoperti,pokemon_catturati, pokemon_catturati, list_allenatore_protagonista);
                    break;
                    case 3:
                        menu_Allenatori(list_allenatori, list_allenatore_protagonista, lista_catalogoPokemon);
                        break;
                    case 4:
                        allenatore.cura_pokemon(list_allenatore_protagonista);
                        break;
                    case 5:
                        Temple_Evolution(list_allenatore_protagonista);
                        break;
                    case 6:
                        battle_room.battle_room(allenatore,
                                list_allenatori,
                                list_allenatore_villain,
                                list_allenatore_protagonista,
                                lista_catalogoPokemon,
                                lista_pokemon_catturati);
                        break;
                    case 7:
                        return; // Esci dal metodo se l'utente sceglie di uscire
                    default:
                        System.out.println("\n    - Prof Oak : \n    Input non valido. Inserisci un numero dalla lista menu. >>"); //error message
                }
            } catch (InputMismatchException e) {            // Gestione di InputMismatchException (Inserisci un numero intero)
                System.out.println("\n    - Prof Oak : \n    Input non valido. Inserisci un numero dalla lista menu. >>");        //  Error message di richiesta reinserimento dato corretto
                myScanner.nextLine(); // Pulisci la nuova riga per evitare loop infiniti
            }
        }
    }



    /** 1. INIZIA PARTITA **/
    /** Attraverso questa funzionalità il giocatore può impostare un allenatore, un pokemon iniziale e avviare una partita:
     * si compone di due funzionalità:  vedi .1 e .2 in commento successivo */
    public void Inizia_partita(Allenatore allenatore, ArrayList<Allenatore> list_allenatori, ArrayList<Allenatore> list_allenatore_protagonista, ArrayList<Pokemon> lista_catalogoPokemon, ArrayList<Pokemon> lista_pokemon_catturati){
        System.out.println("\n____________________________________________________________________" +   //horizontal rule
                            "   \n\n    N U O V A     P A R T I T A");         // Title Menu con horizontal rule

        scegli_allenatore(list_allenatori, list_allenatore_protagonista, lista_pokemon_catturati);     /** 1. scegli un allenatore dal catalogo */
        allenatore.scegli_pokemon_iniziale(lista_catalogoPokemon, list_allenatore_protagonista);       /** 2. crea un allenatore customizzato */
    }


    /** 2. MENU APRI POKEDEX **/
    /** Menu che raccoglie le funzionalità e i dati relativi ai pokemon */
        public void apri_Pokedex(ArrayList<Pokemon> lista_catalogoPokemon, Allenatore allenatore, ArrayList<Pokemon> lista_pokemon_scoperti, ArrayList<Pokemon> lista_pokemon_catturati, ArrayList<Pokemon> pokemon_catturati, ArrayList<Allenatore> list_allenatore_protagonista) {

        Scanner myScanner = new Scanner(System.in);     // apre acquisizione da runtime
        int index;
        boolean open_close_menu;

        /** Interfaccia grafica menu pokedex */
        while (open_close_menu= true) { // Ciclo infinito per continuare a mostrare il menu
        System.out.println("\n\n\n    C A T A L O G O     P O K E D E X \n\n" +
                "    1.  ○ Pokemon di base\n" +
                "    2.  ○ Pokemon scoperti\n" +
                "    3.  ○ Pokemon catturati\n" +
                "    4.  ○ Libera pokemon da pokedex\n" +
                "    5.  ○ Imposta pokemon preferito\n" +
                "    6.  ○ Visualizza pokemon preferito\n" +
                "    7.  ○ Indietro\n");

            /** comandi da runtime per utilizzo funzionalità menu pokedex*/
            try {
                index = myScanner.nextInt();

                switch (index) {
                    case 1:
                        stampa_pokemon_base(lista_catalogoPokemon);
                        break;
                    case 2:
                        stampa_pokemon_scoperti(lista_pokemon_scoperti);
                        break;
                    case 3:
                        allenatore.stampa_pokemon_catturati(list_allenatore_protagonista);
                        break;
                    case 4:
                        allenatore.libera_pokemon(list_allenatore_protagonista);
                        break;
                    case 5:
                        allenatore.scegli_pokemon_preferito(list_allenatore_protagonista);
                        break;
                    case 6:
                        allenatore.stampa_pokemon_preferito(list_allenatore_protagonista);
                        break;
                    case 7:
                        return;// Esci dal menu se l'utente sceglie di uscire
                    default:
                        System.out.println("\n    - Prof Oak : \n    Input non valido. Inserisci un numero dalla lista menu. >>");// error message
                }
            } catch (InputMismatchException e) {
                System.out.println("\n    - Prof Oak : \n    Input non valido. Inserisci un numero dalla lista menu. >>");// error message
                myScanner.nextLine(); // Pulisci la nuova riga per evitare loop infiniti
            }
        }
    }


    /** Stampa dettagli dei 4 pokemon base in arraylist lista_catalogoPokemon */
    public void stampa_pokemon_base(ArrayList<Pokemon> lista_catalogoPokemon){
        System.out.print("\n__________________________________________________\n"); //horizontal rule
        System.out.print("\n    POKEMON DI BASE\n\n    - Prof. Oak : \n    <<I pokemon di base, sono i pokemon che puoi scegliere per iniziare una nuova avventura.>>\n");      //title
        for (Pokemon pokemon : lista_catalogoPokemon) {
            System.out.println("\n      Nome: " + pokemon.nome+"\n      Tipo: "+pokemon.tipo+"" +
                    "\n      Punti vita: "+pokemon.puntiVita+"\n      Esperienza: "+pokemon.esperienza+"\n");
        }
        System.out.print("\n__________________________________________________\n"); //horizontal rule
    }


    /** Stampa i pokemon scoperti in arraylist lista_pokemon_scoperti */
    public void stampa_pokemon_scoperti(ArrayList<Pokemon> lista_pokemon_scoperti){
        System.out.print("\n__________________________________________________\n");//horizontal rule
        System.out.print("\n    LISTA POKEMON SCOPERTI\n");     //title
        for (Pokemon pokemon : lista_pokemon_scoperti) {
            System.out.println("    Nome: " + pokemon.nome+". Tipo: "+pokemon.tipo+". Punti vita: "+pokemon.puntiVita+"\n");
        }
        if (lista_pokemon_scoperti.isEmpty()) {
            System.out.println("    Pokemon scoperti:\n    Non hai ancora scoperto nuovi pokemon.");  // messaggio lista ancora vuota
        }
        System.out.print("\n__________________________________________________\n");//horizontal rule
    }


    /** 3. MENU ALLENATORI **/
    /** Permette di visualizzare i dati di tutti gli allenatori o solo del proprio allenatore customizzato */
    public void menu_Allenatori(ArrayList <Allenatore> list_allenatori, ArrayList<Allenatore> list_allenatore_protagonista, ArrayList<Pokemon> pokemon_catturati){
        Scanner myScanner = new Scanner(System.in);
        int index;

        while (true) { // Ciclo infinito per continuare a mostrare il menu
            System.out.println("\n    MENU ALLENATORI.\n" +
                    "    1.  ○ Lista allenatori palestra Stadium\n" +
                    "    2.  ○ Il tuo allenatore\n" +
                    "    3.  ○ Esci ");

            /** comandi da runtime per utilizzo funzionalità menu allenatori */
            try {
                index = myScanner.nextInt();

                switch (index) {
                    case 1:
                        stampa_catalogo_allenatori(list_allenatori, list_allenatore_protagonista);
                        break;
                    case 2:
                        stampa_Il_tuo_allenatore(list_allenatore_protagonista, pokemon_catturati);
                        break;
                    case 3:
                        return; // Esci dal metodo se l'utente sceglie di uscire
                    default:
                        System.out.println("    - Prof Oak : \n    Input non valido. Inserisci un numero intero dalla lista menu. >>");
                }
            } catch (InputMismatchException e) {            //gestione errore - Inserisci un numero intero.
                System.out.println("    - Prof Oak : \n    Input non valido. Inserisci un numero intero. >>");
                myScanner.nextLine(); // Pulisci la nuova riga per evitare loop infiniti
            }
        }}


    /** Permette al giocatore di selezionare un allenatore preimpostato o customizzabile */
    public void scegli_allenatore(ArrayList <Allenatore> list_allenatori, ArrayList <Allenatore> list_allenatore_protagonista, ArrayList<Pokemon> lista_pokemon_catturati){
        Scanner myscanner = new Scanner(System.in); // Apre scanner stringa
        String str = "";
        do {
            // Interfaccia grafica menu scegli allenatore
            System.out.println("\n\n\n    SCEGLI ALLENATORE                    [digita Esc per tornare indietro]" +
                    "\n\n    - Prof Oak : " +
                    "\n    << Scegli Hash o Misty dagli allenatori della palestra\n" +
                    "    o digita 'Crea' per creare il tuo allenatore personalizzato. >>" +
                    "    \n\n    Inserisci:\n\n\t    · Hash\n\n\t    · Misty\n\n\t    · Crea\n\n\t    ·   Esc\n\n\t   Scegli:     \n\t    ");

            if (myscanner.hasNext()) {      // analisi dati inseriti in scanner
                str = myscanner.next().toLowerCase();  //standardcase per dato acquisito: dovrebbe diminuire possibilità di errori in inserimento dati

                if (str.equals("esc")) {
                    return; // comando Esci dalla funzione e torna a Menu_Principale

                    /** acquisisce il nome digitato e se corrisponde a quelli in lista scelta, lo seleziona come protagonista
                     * copiandolo in Arraylist<Allenatore> list_allenatore_protagonista */
                } else if (str.equalsIgnoreCase("hash") || str.equals("misty")) {   // seleziona allenatore preimpostato

                    //stampa allenatore selezionato dalla lista allenatori
                    for (Allenatore allenatore : list_allenatori) {
                        if (str.equals(allenatore.nome.toLowerCase())) {
                            System.out.println("\n   Hai scelto: " + allenatore.nome);
                            list_allenatore_protagonista.add(allenatore);
                            System.out.println("\n__________________________________________________\n");//horizontal rule
                            return;
                        }
                    }
                    /** se acquisisce il comando 'crea' apre la funzionalità per selezionare un allenatore
                     * customizzabile per nome e età */
                } else if (str.equals("crea")) {    // seleziona allenatore custom
                    System.out.println("\n   Hai scelto di creare un allenatore personalizzato.");
                    AllenatoreCustom allenatoreCustom = new AllenatoreCustom("", 0, lista_pokemon_catturati);
                    allenatoreCustom.crea_allenatore(list_allenatori, list_allenatore_protagonista); /** Richiama la funzione crea_allenatore */
                    System.out.println("\n__________________________________________________\n");//horizontal rule
                    return;
                } else {
                    System.out.print("\n   - Prof. Oak : \n" +
                            "   << Spiacente. Allenatore inesistente, scegli un nome dalla lista o digita s'esc' per tornare al menu principale: >>"); // error message
                }
            }
        } while (!(str.equals("hash") || str.equals("misty")));
    }

    /** Stampa dati degli allenatori in catalogo e del protagonista */
    public static void stampa_catalogo_allenatori(ArrayList<Allenatore> list_allenatori, ArrayList<Allenatore> list_allenatore_protagonista) {
        System.out.print("\n__________________________________________________\n");//horizontal rule
        System.out.print("\n    CATALOGO ALLENATORI\n");  // title

        // Stampa dati degli allenatori in catalogo
        System.out.println("\n    Allenatori della palestra Stadium :\n");
        for (int i = 0; i < list_allenatori.size(); i++) {
            Allenatore allenatore = list_allenatori.get(i);
            System.out.println("    Nome: " + allenatore.nome);
            System.out.println("    Età: " + allenatore.età);
            System.out.println("    Punti Esperienza: " + allenatore.pt_esperienza);
            System.out.println("    Numero di Pokémon Catturati: " + allenatore.num_pokemon_catturati);
            System.out.println("    --------------------------");//horizontal rule
        }

        //stampa dati allenatore protagonista
        if (!list_allenatore_protagonista.isEmpty())
            System.out.print("\n    IL TUO ALLENATORE\n");
            for (int i = 0; i < list_allenatore_protagonista.size(); i++) {
                System.out.println("    Nome: " + list_allenatore_protagonista.get(i).nome);
                System.out.println("    Età: " + list_allenatore_protagonista.get(i).età);
                System.out.println("    Punti Esperienza: " + list_allenatore_protagonista.get(i).pt_esperienza);
                System.out.println("    Numero di Pokémon Catturati: " + list_allenatore_protagonista.get(i).num_pokemon_catturati);

                //stampa lista pokemon catturati dell'allenatore protagonista
                if (!list_allenatore_protagonista.get(0).lista_pokemon_catturati.isEmpty())
                    System.out.println("    Lista pokemon catturati: ");

                for (int k=0; k<list_allenatore_protagonista.get(i).lista_pokemon_catturati.size(); k++){
                    System.out.println("    ··· pokemon ···  "+list_allenatore_protagonista.get(i).lista_pokemon_catturati.get(k).nome);
                }
            System.out.print("\n__________________________________________________\n");//horizontal rule
        }
    }


    /** Stampa dati dell'allenatore protagonista */
    public static void stampa_Il_tuo_allenatore(ArrayList<Allenatore> list_allenatore_protagonista,ArrayList <Pokemon> pokemon_catturati) {
        System.out.print("\n__________________________________________________\n");//horizontal rule
        System.out.print("\n    IL TUO ALLENATORE\n");  //Title
        try {
            if (list_allenatore_protagonista.isEmpty()) {
                System.out.print("\n    Non hai ancora scelto o creato un allenatore.");  // messaggio in caso di allenatore ancora non selezionato
                System.out.print("\n__________________________________________________\n");//horizontal rule
            }else{
                for (int i = 0; i < list_allenatore_protagonista.size(); i++) {  // stampa dati protagonista
                    // Allenatore allenatore = list_allenatore_protagonista.get(i);
                    System.out.println("    Nome: " + list_allenatore_protagonista.get(i).nome);
                    System.out.println("    Età: " + list_allenatore_protagonista.get(i).età);
                    System.out.println("    Punti Esperienza: " + list_allenatore_protagonista.get(i).pt_esperienza);
                    System.out.println("    Numero di Pokémon Catturati: " + list_allenatore_protagonista.get(i).num_pokemon_catturati);

                    System.out.println("    Lista pokemon catturati: ");  // stampa lista pokemon catturati protagonista
                    for (int k = 0; k < list_allenatore_protagonista.get(i).lista_pokemon_catturati.size(); k++) {
                        System.out.println(    "··· pokemon ···  " + list_allenatore_protagonista.get(i).lista_pokemon_catturati.get(k).nome);
                    }
                    System.out.print("\n__________________________________________________\n");//horizontal rule
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("    -Prof. Oak : \n    " +
                    "<< Non hai ancora selezionato un allenatore.\n" +
                    "    Procedi dal menu Nuova Partita. >>"); //
            System.out.print("\n__________________________________________________\n");//horizontal rule
        }
    }


    /** 5. TEMPLE EVOLUTION **/
    /** Funzionalità che permette l'evoluzione dei pokemon se hanno EXP+ > 100 punti */
    public void Temple_Evolution(ArrayList<Allenatore> list_allenatore_protagonista) {
        System.out.print("\n__________________________________________________\n");//horizontal rule
        System.out.print("    EVOLUTION TEMPLE.                    [digita Esc per tornare indietro]\n\n" +
                "    - Prof Oak : \n    << Scegli un pokemon dal pokedex, Se i suoi punti esperienza superano 100EXP+" +
                " \n    il pokemon può evolvere. Usa Rock evolution su pokemon: >>\n");
        try {
            list_allenatore_protagonista.get(0).stampa_pokemon_catturati(list_allenatore_protagonista);

            Scanner myScanner = new Scanner(System.in);
            String str = myScanner.next();

            for (Allenatore allenatoreK : list_allenatore_protagonista) {
                for (Pokemon pokemon : allenatoreK.lista_pokemon_catturati) {
                    if (str.equalsIgnoreCase(pokemon.nome) && pokemon.esperienza > 100) {
                        pokemon.evoluzione(allenatoreK.lista_pokemon_catturati, pokemon);
                    } else if (str.equalsIgnoreCase("Esc")) {
                        return;
                    } else {
                        System.out.print("\n    - Prof. Oak : " +
                                "    << Questo pokemon non può ancora evolvere. >>");
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n    - Prof. Oak : \n    << Nessun allenatore ancora scelto o nessun pokemon ancora catturato. >>");
        }

        System.out.print("\n__________________________________________________\n");//horizontal rule
    }

}

