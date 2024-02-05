package a_POKEDEX_main.e_Battle_room;
import a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Allenatore;
import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/** Class Battle_room   */
public class Battle_room {

    /** Countdown battle fight ("3,2,1,fight!") */
        public static void countdown() throws InterruptedException {
            String[] numbers = {"\n\n     3", "\n\n     2", "\n\n     1"};
            for (int i = 0; i < numbers.length; i++) {
                System.out.println(numbers[i]);
                Thread.sleep(1500);
            }
            System.out.println("\n\n     F I G H T !");
        }


    /** Impostazione del player 2 sfidante "villain" */
    public Pokemon impostazione_player_sfidante(ArrayList<Allenatore> list_allenatore_villain) {
        System.out.print("\n    << Sfiderai il Team Rocket. >>");

        /** Estrae un pokemon a caso da lista_pokemon_catturati del team rocket sfidante */
        int min = 0;
        int max = list_allenatore_villain.get(0).lista_pokemon_catturati.size() - 1;
        int index_pokemon_fighter = min + (int) (Math.random() * (max - min + 1));
        Pokemon villain_pokemon_fighter = list_allenatore_villain.get(0).lista_pokemon_catturati.get(index_pokemon_fighter);

        /** Stampa pokemon lanciato da team rocket */
        System.out.print("\n\n    - Team Rocket lancia Pokeball:\n" +
                "    Ha scelto " + list_allenatore_villain.get(0).lista_pokemon_catturati.get(index_pokemon_fighter).nome);
        return list_allenatore_villain.get(0).lista_pokemon_catturati.get(index_pokemon_fighter);
    }

    /** Impostazione del player 1 protagonista */
    public Pokemon impostazioneProtagonista(ArrayList<Allenatore> list_allenatore_protagonista) {
        System.out.print("\n\n    << Hey " + list_allenatore_protagonista.get(0).nome + "!: >>" +
                "\n    Scegli un Pokémon dal tuo Pokédex personale per combattere: \n");

        /** Stampa i pokemon che il giocatore può lanciare in fight */
        list_allenatore_protagonista.get(0).stampa_pokemon_catturati(list_allenatore_protagonista);

        /** Apre scanner per acquisire nome pokemon da lanciare */
        Scanner myscanner0 = new Scanner(System.in);
        String str = "";

        while (true) {
            if (myscanner0.hasNext()) {
                str = myscanner0.next().toLowerCase();
                boolean pokemonTrovato = false;

                for (Pokemon pokemon : list_allenatore_protagonista.get(0).lista_pokemon_catturati) {
                    if (str.equalsIgnoreCase("esc")) {
                        return null; // Esci dalla funzione e torna al menu principale
                    } else if (str.equalsIgnoreCase(pokemon.nome)) {    //verifica pokemon digitato come scelta
                        System.out.println("\n  Hai scelto: " + pokemon.nome);
                        return pokemon;
                    }
                }

                if (!pokemonTrovato) {      //error message
                    System.out.print("\n        - Prof. Oak : \n" +
                            "<< Spiacente. Pokémon inesistente, scegli un nome dalla lista o digita 'esc' per tornare al menu principale: >>");
                }
            }
        }
    }

    public void cattura_pokemon(ArrayList<Allenatore> list_allenatore_protagonista, Pokemon pokemon1, Pokemon pokemon2) {
        System.out.print("\n__________________________________________________\n"); //horizontal rule
        System.out.print("\n    POKEBALL LANCIATA: \n"); //title

        boolean catturato = pokemon2.puntiVita <= 0; // Cattura solo se i punti vita sono <= 0

        if (catturato) {
            list_allenatore_protagonista.get(0).lista_pokemon_catturati.add(pokemon2); // Aggiungi il Pokémon alla lista_pokemon_catturati
            list_allenatore_protagonista.get(0).num_pokemon_catturati++; // Incrementa il contatore num_pokemon_catturati
            list_allenatore_protagonista.get(0).pt_esperienza += 10;
            pokemon1.esperienza += 10;

            System.out.println("    " + pokemon2.nome + " è stato catturato."); // Pokémon catturato
        } else {
            System.out.println("    " + pokemon2.nome + " si è liberato."); // Pokémon si è liberato
        }

        System.out.print("\n__________________________________________________\n"); //horizontal rule
    }



    /** Metodo pokemon_fight_round1 : prende un o pokemon dal protagonista e un pokemon dal villain e li fa combattere
 * @param pokemon1 (pokemon protagonista)
 * @param pokemon2 (pokemon villain) */
public void pokemon_fight_round1(ArrayList<Allenatore> list_allenatore_protagonista, Pokemon pokemon1, Pokemon pokemon2) {
    Scanner myscanner1 = new Scanner(System.in);

    // Giocatore sceglie un azione in fight
    System.out.print("\n    Scegli azione :\n    - 1. Attacca\n    - 2. Difendi\n    - 3. Lancia pokeball\n    - 4. Esci\n");

    /** switch dei comandi fight e casualità delle scelte del player sfidante */
    /**  @param pokemon1 (pokemon protagonista)
     **  @param pokemon2 (pokemon villain)     */

    int index = 0;
        if (myscanner1.hasNextInt()) {
            index = myscanner1.nextInt();
            switch (index) {
                case 1:
                pokemon1.attacca(pokemon2);     /** Player umano Scelta : Attacco */
/*

                    Random rand0 = new Random();    */
/** Tenta la cattura del pokemon2 se probabilitaCattura < 75 && pokemon2.puntiVita<35 *//*

                    int probabilitaCattura = rand0.nextInt(100);  // Genera un numero casuale tra 0 e 99
                    // Controlla se la probabilità di cattura è inferiore al 75%
                    if (probabilitaCattura < 75 && pokemon2.puntiVita<35) {
                        cattura_pokemon(list_allenatore_protagonista, pokemon1, pokemon2);
                    }
*/

                    Random rand = new Random();     /** Player villain Scelta : Attacc/difende */
                        int attack_defend1 = rand.nextInt(2)+1;
                        if (attack_defend1==1){pokemon2.attacca(pokemon1);}    // Pokemon villain controattacca o difende
                        else{pokemon2.difende();}
                    break;
                case 2:
                    pokemon1.difende();     /** Player umano Scelta : Difesa */
/*
                    Random rand3 = new Random();    */
                    /** Tenta la cattura del pokemon2 se probabilitaCattura < 75 && pokemon2.puntiVita<35 *//*

                    int probabilitaCattura0 = rand3.nextInt(100);  // Genera un numero casuale tra 0 e 99
                    // Controlla se la probabilità di cattura è inferiore al 75%
                    if (probabilitaCattura0 < 75 && pokemon2.puntiVita<35) {
                        cattura_pokemon(list_allenatore_protagonista, pokemon1, pokemon2);
                    }
*/

                    Random rand2 = new Random();        /** Player villain Scelta : Attacc/difende */
                        int attack_defend2 = rand2.nextInt(2)+1;
                        if (attack_defend2==1){pokemon2.attacca(pokemon1);}    // Pokemon villain controattacca odifende
                        else{pokemon2.difende();}
                    break;
                case 3:
                    cattura_pokemon(list_allenatore_protagonista, pokemon1, pokemon2);      //Tenta cattura pokemon
                    break;
                case 4:
                    System.out.print("\n    Hai abbandonato il duello.\n");
                    return;       //Esci
                default:
                    System.out.println("    Scelta non valida.");
            }
        }

    if (pokemon1.puntiVita <= 1) {      //valore bloccato a 1 perchè permette di eseguire l'istruzione println prima di uscire dal metodo
            System.out.println("\n    Il tuo Pokémon è stato sconfitto.");
            return; // Esce dalla funzione
        }

    if (pokemon2.puntiVita <= 0)
        cattura_pokemon(list_allenatore_protagonista, pokemon1, pokemon2);      //Tenta cattura pokemon
    }

    public void battle_room(Allenatore allenatore,
                            ArrayList<Allenatore> list_allenatori,
                            ArrayList<Allenatore> list_allenatore_villain,
                            ArrayList<Allenatore> list_allenatore_protagonista,
                            ArrayList<Pokemon> lista_catalogoPokemon,
                            ArrayList<Pokemon> lista_pokemon_catturati) {
        try {
            // Interfaccia grafica della BATTLE ROOM
            System.out.print("\n____________________________________________________________________" + // orizzontal rule
                    "\n\n    B A T T L E    R O O M \n"); // titolo

            /** Impostazione del player 2 sfidante "villain" */
            Pokemon pokemon2_villain = impostazione_player_sfidante(list_allenatore_villain);

            /** Impostazione del player 1 protagonista */
            Pokemon pokemon1_protagonista = impostazioneProtagonista(list_allenatore_protagonista);

            /** Countdown grafico pre-fight */
            try {
                countdown();
            } catch (InterruptedException e) {
                System.err.println("    Si è verificato un errore durante il countdown: " + e.getMessage());
            }

            /** Reitera il combattimento sino a quando uno dei due pokemon ha puntiVita <= 0 */
            while (pokemon1_protagonista.puntiVita > 0 && pokemon2_villain.puntiVita > 0) {
                pokemon_fight_round1(list_allenatore_protagonista, pokemon1_protagonista, pokemon2_villain);
            }

            /** ripristina punti vita del pokemon villain dopo la fight*/
            pokemon2_villain.ripristina_puntiVita();


        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n      - Prof. Oak : \n      << Nessun allenatore ancora scelto o nessun pokemon ancora catturato. >>");
        }
    }

}




/*[BACKUP]public void battle_room(Allenatore allenatore,
                       ArrayList<Allenatore> list_allenatori,
                       ArrayList<Allenatore> list_allenatore_villain,
                       ArrayList<Allenatore> list_allenatore_protagonista,
                       ArrayList<Pokemon> lista_catalogoPokemon,
                       ArrayList<Pokemon> lista_pokemon_catturati) {

        //apre scanner per acquisire input del giocatore
        Scanner myscanner = new Scanner(System.in);
        String str = "";

        do {            //reiterazione della battle room sino a uscita

            // Interfaccia grafica della BATTLE ROOM
            System.out.print("\n____________________________________________________________________"+ //horizzontal rule
                    "\n\n    B A T T L E    R O O M \n"); // title

            *//** Impostazione del player 2 sfidante villain *//*
            System.out.print("\n        Sfiderai il Team Rocket.");

            *//** Estrae un pokemon random da lista_pokemon_catturati dell'allenatore sfidante *//*
            int min = 1; int max = 2;
            int index_pokemon_fighter = min + (int) (Math.random() * (max - min + 1));

            //stampa pokemon scelto da player villain
            Pokemon villain_pokemon_fighter = list_allenatore_villain.get(0).lista_pokemon_catturati.get(index_pokemon_fighter);
            System.out.print("\n        - Team Rocket lancia Pokeball: \n" +
                    "       Ha scelto "+list_allenatore_villain.get(0).lista_pokemon_catturati.get(index_pokemon_fighter).nome);

            *//** Impostazione del player 1 protagonista *//*
            // messaggio di istruzioni funzionalità
            System.out.print("      Hey "+ list_allenatore_protagonista.get(0).nome +"! :"+
                    "\n     Scegli un pokemon dal tuo pokedex personale per combattere: ");

            *//** stampa lista pokemon del giocatore list_allenatore_protagonista.get(0) *//*
            list_allenatore_protagonista.get(0).stampa_pokemon_catturati(list_allenatore_protagonista);

            if (myscanner.hasNext()) {
                str = myscanner.next().toLowerCase();

                //scorre lista_pokemon_catturati per trovare il pokemon selezionato per fight
                for (Pokemon pokemon : list_allenatore_protagonista.get(0).lista_pokemon_catturati) {
                    if (str.equalsIgnoreCase("esc")) {
                        return; // Esci dalla funzione e torna a Menu_Principale

                    } else if (str.equalsIgnoreCase(pokemon.nome)) {   // seleziona pokemon da list_allenatore_protagonista.get(0).lista_pokemon_catturati
                        System.out.println("\n      Hai scelto: " + pokemon.nome);
                    } else {
                        System.out.print("\n        - Prof. Oak : \n" +
                                "<< Spiacente. Pokemon inesistente, scegli un nome dalla lista o digita s'esc' per tornare al menu principale: >>"); // error message
                    }
                }
            }
        } while (!(str.equalsIgnoreCase("esc") || lista_pokemon_catturati.contains(str)));
    }*/


