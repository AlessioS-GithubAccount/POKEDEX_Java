package a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore;
import java.util.ArrayList;

import a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Prototypes_allenatori.AllenatoreCustom;
import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;
import java.util.Scanner;

public abstract class Allenatore {
    public String nome;
    public int età;
    public int pt_esperienza;
    public int num_pokemon_catturati;
    public ArrayList <Pokemon> lista_pokemon_catturati;

    public Allenatore(String nome, int età, ArrayList <Pokemon> lista_pokemon_catturati) {       //constructor Allenatore
        this.nome=nome;
        this.età=età;
        this.lista_pokemon_catturati = new ArrayList<>();
    }

    /** Metodo crea allenatore customizzato per menu Nuova Partita.scegli allenatore */
    public void crea_allenatore(ArrayList <Allenatore> list_allenatori, ArrayList <Allenatore> list_allenatore_protagonista) {        // crea un allenatore tramite acquisizione da runtime
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n__________________________________________________\n");//horizontal rule
        System.out.print("\nNUOVO ALLENATORE \n"); // title

        System.out.print("\nInserisci il nome dell'allenatore: "); //acquisizione nome e età allenatore custom
        this.nome = scanner.nextLine();

        System.out.print("\nInserisci l'età dell'allenatore: ");
        this.età = scanner.nextInt();

        /** Crea un istanza di AllenatoreCustom con dati acquisiti */
        AllenatoreCustom allenatoreCustom = new AllenatoreCustom(this.nome, this.età,this.lista_pokemon_catturati);
        allenatoreCustom.nome = this.nome;
        allenatoreCustom.età = this.età;
        allenatoreCustom.lista_pokemon_catturati = lista_pokemon_catturati;

        /** Aggiungi il nuovoAllenatore all'ArrayList list_allenatore_protagonista e lo rimuove dal catalogo allenatori */
        list_allenatore_protagonista.add(allenatoreCustom);
        list_allenatori.remove(allenatoreCustom);  // rimuove istanza default di AllenatoreCustom creata in main POKEDEX.class

        System.out.println("\nIl tuo allenatore è : "+this.nome);       //stampa nome allenatore creato
    }


    /** Metodo che stampa i dati dell' allenatore ricercato nel catalogo */
    public void stampa_dati_allenatore(ArrayList <Allenatore> list_allenatori, ArrayList <Pokemon> pokemon_catturati, ArrayList<Allenatore> list_allenatore_protagonista){      //stampa tutti i dati del proprio allenatore
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il nome dell'allenatore da cercare: ");
        String nomeAllenatore = scanner.nextLine();

        for (int k=0; k<list_allenatori.size(); k++){       //ricerca e stampa dati dell'allenatore inserito
            if (list_allenatori.get(k).nome.equals(nomeAllenatore)) {
            System.out.println("Nome: "+list_allenatori.get(k).nome);
            System.out.println("Età: "+list_allenatori.get(k).età);
            }
            stampa_pokemon_catturati(list_allenatore_protagonista);  //stampa pokemon_catturati
        }
    }       //stampa dati allenatore


    /** Metodo che stampa i dati dei pokemon catturati */
    public void stampa_pokemon_catturati(ArrayList<Allenatore> list_allenatore_protagonista) {
        System.out.print("\n____________________________________________________________________\n");//horizontal rule
        System.out.print("\n    I TUOI POKEMON\n");  //title
        System.out.println("\n    Pokemon catturati: ");

        try {
            ArrayList<Pokemon> listaPokemon = list_allenatore_protagonista.get(0).lista_pokemon_catturati;

            if (listaPokemon.isEmpty()) {
                System.out.println("    -Prof Oak : \n    <<Non hai ancora catturato nuovi pokemon.>>"); //message lista vuota
            } else {  //stampa dati pokemon catturati
                for (Pokemon pokemon : listaPokemon) {
                    System.out.println("\n    Nome: " + pokemon.nome + ". Tipo: " + pokemon.tipo + ". Punti vita: " + pokemon.puntiVita+". Esperienza: "+pokemon.esperienza+"\n");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("    -Prof Oak : \n    <<Nessun allenatore scelto o nessun pokemon ancora catturato.>>"); //error message
        }
        System.out.print("____________________________________________________________________\n");//horizontal rule
    }


    /** Metodo per catturare un pokemon se ha puntiVita <= 0 */
    public void cattura_pokemon(ArrayList<Allenatore> list_allenatore_protagonista, Pokemon pokemon2){     //cattura pokemon2 sfidante villain in list lista_pokemon_catturati
        System.out.print("\n__________________________________________________\n");     //horizontal rule
        System.out.print("\nPOKEBALL LANCIATA: \n");    //title
        if (pokemon2.puntiVita <= 0) {
            lista_pokemon_catturati.add(pokemon2);       //aggiunge il pokemon alla lista_pokemon_catturati
            num_pokemon_catturati++;        //incrementa il counter del campo istanza num_pokemon_catturati
            list_allenatore_protagonista.get(0).pt_esperienza += 10;    //incrementa +10pt Exp all'allenatore
            //l'esperienza del pokemon viene invece incrementata nella battle dentro il metodo pokemon_fight_round1()
            System.out.println(pokemon2.nome+" è stato catturato.");  // pokemon catturato
        } else {
            System.out.println(pokemon2.nome+" si è liberato."); // pokemon si è liberato
        }
        System.out.print("\n__________________________________________________\n");   //horizontal rule
    }


    /** Metodo per liberare-cancellare un pokemon dalla lista_pokemon_catturati  */
    public void libera_pokemon(ArrayList<Allenatore> list_allenatore_protagonista) {
        System.out.print("\n__________________________________________________\n");//horizontal rule
        System.out.print("\n    LIBERA POKEMON                                     [digita Esc per tornare indietro]\n");   //title

        try{
        // richiama il primo e unico allenatore dalla lista protagonista
        Allenatore protagonista = list_allenatore_protagonista.get(0);

        /* if (protagonista.lista_pokemon_catturati.isEmpty()) {
            System.out.println("Pokedex: vuoto\nNon hai pokemon nel tuo pokedex.");
            return; // Esci dal metodo se il pokedex è vuoto
        } */

        // Stampa la lista dei pokemon catturati che il giocatore può liberare
        System.out.println("    Pokedex: pokemon catturati :");
        for (Pokemon pokemon : protagonista.lista_pokemon_catturati) {
            System.out.println("    Nome: " + pokemon.nome);
        }


        System.out.print("\n    - Prof OAk : << Vuoi liberare un pokemon dal Pokedex?" +
                "\n    Digita il nome corrispondente per eliminarlo dal Pokedex : >>");

        Scanner myScanner = new Scanner(System.in); //apre acquisizione scanner runtime
        String str = myScanner.next();

        /** Cerca e rimuove il pokemon dalla lista */
        for (Pokemon pokemon : protagonista.lista_pokemon_catturati) {
            if (str.equalsIgnoreCase(pokemon.nome)) {
                protagonista.lista_pokemon_catturati.remove(pokemon);
                System.out.println("    "+pokemon.nome + " è stato liberato.");
                break; // Esci dal ciclo una volta che hai trovato il pokemon
            }
        }
        if (str.equalsIgnoreCase("Esc")) {  // digita esc per uscire
            return;}

        if (protagonista.lista_pokemon_catturati.isEmpty()) {
            System.out.println("    - Prof OAk : \n    << Pokedex: vuoto. Non hai pokemon nel tuo pokedex.>>");
        }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("    - Prof OAk : \n    <<Nessun allenatore scelto o nessun pokemon ancora catturato.>>");
            System.out.print("\n__________________________________________________\n");     //horizontal rule
        }
    }


    /** Metodo per impostare un pokemon preferito: guadagna 50% punti esperienza 'EXP+' per ogni battaglia vinta*/
    public void scegli_pokemon_preferito(ArrayList<Allenatore> list_allenatore_protagonista) {
        System.out.print("\n__________________________________________________________________________\n"); // horizontal rule
        System.out.print("\n        IMPOSTA UN POKEMON PREFERITO\n"); // title
        System.out.println("\n        Scegli dalla lista pokemon catturati un pokemon preferito.\n" +
                "        Guadagnerà +50% punti esperienza per ogni battaglia vinta.\n");

        try {
            Scanner myScanner = new Scanner(System.in);
            String str = "";

            // Stampa lista pokemon catturati dal protagonista per permettere di selezionare il pokemon preferito
            System.out.println("        Scegli il tuo pokemon preferito:");

            for (Pokemon pokemon : list_allenatore_protagonista.get(0).lista_pokemon_catturati) {
                System.out.println("        Nome: " + pokemon.nome);
            }

            if (myScanner.hasNext()) {
                str = myScanner.next();

                for (Pokemon pokemon : list_allenatore_protagonista.get(0).lista_pokemon_catturati) {
                    if (str.equalsIgnoreCase(pokemon.nome)) {
                        pokemon.preferito = true;
                        System.out.println("        "+pokemon.nome + " è il tuo pokemon preferito.");
                    }
                }
            }

            System.out.print("\n__________________________________________________________________________\n"); // horizontal rule
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n        - Prof. Oak :        \n<< Nessun allenatore scelto o nessun pokemon ancora catturato. >>");
            System.out.print("\n__________________________________________________________________________\n"); // horizontal rule
        }
    }

    public void stampa_pokemon_preferito(ArrayList<Allenatore> list_allenatore_protagonista) {
        System.out.print("\n____________________________________________________________________\n");//horizontal rule
        System.out.print("\n    IL TUO POKEMON PREFERITO\n");  //title
        System.out.println("\n    Pokemon preferito: ");

        try {
            ArrayList<Pokemon> listaPokemon = list_allenatore_protagonista.get(0).lista_pokemon_catturati;
            boolean Preferito = false;  // flag Pokémon preferito

            if (listaPokemon.isEmpty()) {
                System.out.println("    Non hai ancora catturato nuovi Pokémon preferiti."); //message lista vuota
            } else {  //stampa dati dei Pokémon preferiti
                for (Pokemon pokemon : listaPokemon) {
                    if (pokemon.preferito) {
                        Preferito = true;
                        System.out.println("\n    Nome: " + pokemon.nome + ". Tipo: " + pokemon.tipo + ". Punti vita: " + pokemon.puntiVita + ". Esperienza: " + pokemon.esperienza + "\n");
                    }
                }
                if (!Preferito) {
                    System.out.println("    Nessun Pokémon preferito catturato.");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n    - Prof. Oak :    \n<< Nessun allenatore scelto o nessun pokemon ancora catturato. >>");
        }
        System.out.print("____________________________________________________________________\n");//horizontal rule
    }


    /** Metodo per selezionare un pokemon base con cui iniziare il gioco */
    public static void scegli_pokemon_iniziale(ArrayList<Pokemon> lista_catalogoPokemon, ArrayList<Allenatore> list_allenatore_protagonista) {
        Scanner myscanner = new Scanner(System.in);  // Apre l'acquisizione dello scanner runtime
        String str = "";

        do {
            System.out.print("        SCEGLI POKEMON INIZIALE\n");      // Titolo
            System.out.print("\n        Scegli un Pokémon iniziale:\n\n\tSquirtle\n\tCharmander\n\tBulbasaur\n\tPikachu\n\n\tEsc\n\n   Nome: ");

            if (myscanner.hasNextLine()) { // Utilizza nextLine() invece di next() per leggere l'intera linea
                str = myscanner.nextLine().trim(); // Utilizza trim() per rimuovere spazi extra

                if (str.equalsIgnoreCase("esc")) {
                    System.out.println("\n    Hai abbandonato la scelta del Pokémon iniziale.");
                    return; // Esci dalla funzione
                }

                // Controlla il nome inserito e visualizza un messaggio di errore se è errato
                if (!str.equalsIgnoreCase("Squirtle") && !str.equalsIgnoreCase("Charmander") && !str.equalsIgnoreCase("Bulbasaur") && !str.equalsIgnoreCase("Pikachu")) {
                    System.out.println("\n      - Prof. Oak :        \n<< Spiacente, nome Pokémon inserito errato.\n        Reinserisci : >>"); // Messaggio di errore
                } else {
                    // Aggiunge il Pokémon scelto alla lista dei Pokémon catturati dell'allenatore, incrementa di 1 num_pokemon_catturati e ne stampa il nome
                    for (Allenatore allenatore : list_allenatore_protagonista) {
                        for (Pokemon pokemon : lista_catalogoPokemon) {
                            if (str.equalsIgnoreCase(pokemon.nome)) {
                                allenatore.lista_pokemon_catturati.add(pokemon);
                                System.out.println("\n        - Prof. Oak : <<Hai scelto: " + pokemon.nome + "." +
                                        "        \n        Ora puoi accedere alla Battle Room dal menu principale e combattere.\n" +
                                        "\n        Recati nel menu '2. Apri Pokedex' e seleziona il tuo Pokémon preferito, " +
                                        "\n        ti garantirà un bonus +50% in esperienza nelle battaglie.>>"); // Stampa il Pokémon iniziale selezionato
                                allenatore.num_pokemon_catturati++;
                                break; // Esce dal ciclo interno una volta trovato il Pokémon corrispondente
                            }
                        }
                    }
                }
                System.out.print("\n__________________________________________________\n"); // Riga orizzontale
            }
        }while (!str.equalsIgnoreCase("Squirtle") && !str.equalsIgnoreCase("Charmander")
                && !str.equalsIgnoreCase("Bulbasaur") && !str.equalsIgnoreCase("Pikachu")
                && !str.equalsIgnoreCase("esc")); // Ripete il metodo fino all'inserimento del nome Pokémon corretto
    }




    /** Metodo per curare i pokemon da menu CLINICA DEI POKEMON in main menu (ripristina pokemon.puntiVita) */
    public void cura_pokemon(ArrayList<Allenatore> list_allenatore_protagonista) {
        System.out.print("\n__________________________________________________\n");//horizontal rule
        System.out.print("\n    CLINICA DEI POKEMON                      [digita Esc per tornare indietro]\n\n        " +
                "Lista pokemon catturati: \n");  //title

        /** controlli nel caso di allenatore o pokemon non ancora non selezionati */
        if (list_allenatore_protagonista.isEmpty()) {
            System.out.println("\n    Non hai ancora selezionato o creato un allenatore."); //error message , allenatore non ancora selezionato
            System.out.print("\n__________________________________________________\n");//horizontal rule
        }else if (list_allenatore_protagonista.get(0).lista_pokemon_catturati.isEmpty()) {
            System.out.println("\n    Non hai ancora catturato nessun pokemon.");   //error message , pokemon non ancora selezionato-catturato
        }else {

            // Stampa i punti vita dei pokemon in lista_pokemon_catturati che puoi curare
                for (Pokemon pokemon : list_allenatore_protagonista.get(0).lista_pokemon_catturati) {
                    System.out.println("\n    Nome: " + pokemon.nome + ". \n    Punti vita: " + pokemon.puntiVita+"\n");
                }

            System.out.println("\n    Digita il nome del pokemon che vuoi curare: \n"); //giocatore inserisce nome pokemon da curare
            Scanner myScanner = new Scanner(System.in);
            String str = "";

            if (myScanner.hasNext()) {
                str = myScanner.next();
                for (Allenatore allenatore : list_allenatore_protagonista) {
                    for (Pokemon pokemon : allenatore.lista_pokemon_catturati) {
                        if (str.equalsIgnoreCase(pokemon.nome)) {
                            pokemon.ripristina_puntiVita();
                            System.out.println("-    Infermiera Joy : \n    << Ciao "+ allenatore.nome + ".\n"+"         Ho curato " + pokemon.nome + ". Punti vita: " + pokemon.puntiVita+" .>>");
                        }
                    }
                }
            }
            System.out.print("\n__________________________________________________\n"); //horizontal rule
        }
    }

    /* TODO valutare un metodo schiera_pokemon() in caso di group battle ;*/
}






