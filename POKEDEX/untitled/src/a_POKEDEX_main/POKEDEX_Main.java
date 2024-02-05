package a_POKEDEX_main;//import Menu_Principale.Welcome_messages;

import a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Prototypes_allenatori.AllenatoreCustom;
import a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Prototypes_allenatori.Hash;
import a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Allenatore;
import a_POKEDEX_main.b_Menu_Principale.Menu;
import a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Prototypes_allenatori.Team_Rocket;
import a_POKEDEX_main.d_Pokemon.Catalogo_Pokemon.Catalogo_pokemonList;
import a_POKEDEX_main.d_Pokemon.a_Pokemon.Prototypes_pokemon.*;
import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;
import a_POKEDEX_main.e_Battle_room.Battle_room;


import java.util.ArrayList;

/** MAIN CLASS: POKEDEX_**/
public class POKEDEX_Main {
    public static void main(String[] args) {

        /** SEZIONE ALLENATORI ****************************************************************************************/

        /** Si costruiscono 3 istanze type Allenatore per gli allenatori selezionabili dal "menu allenatori" :
         * 2 allenatori con proprietà già assegnate (hash,misty)
         * 1 allenatore personalizzabile(allenatoreCustom) */

        //ogni allenatore possiede proprietà : String Nome, int Età e ArrayList <Pokemon> lista_pokemon_catturati;
        ArrayList<Pokemon> lista_pokemon_catturati = new ArrayList<>();
        ArrayList <Pokemon> pokemon_fighter = new ArrayList<>();


        Allenatore hash = new Hash("Hash", 18, lista_pokemon_catturati);       // allenatori base
        Allenatore misty = new Hash("Misty", 16, lista_pokemon_catturati);
        Allenatore allenatoreCustom = new AllenatoreCustom("", 0, lista_pokemon_catturati);        //allenatore customizzabile tramite scanner
        Allenatore teamRocket = new Team_Rocket("Team Rocket", 30 , lista_pokemon_catturati, pokemon_fighter);    // istanza Allenatore sfidante in battle-mode ("villain") : Team_Rocket teamRocket

        /** Crea Arraylist <Allenatore> list_allenatori e list_allenatore_protagonista e aggiunge gli allenatori iniziali :
         * list_allenatori permetterà di scegliere un allenatore per Nuova partita. */

        /** Crea ArrayList<Allenatore> list_allenatori:
         * Contiene tutte le istanze type Allenatore (hash,misty) che potranno essere selezionate per "Nuova partita" da menù */
        ArrayList<Allenatore> list_allenatori = new ArrayList<>();      //aggiunti gli allenatori iniziali in list_allenatori
        list_allenatori.add(hash);
        list_allenatori.add(misty);
        // list_allenatori.add(teamRocket); //valutare l'inserimento del villain in questa list-menu

        /** Crea ArrayList<Allenatore> list_allenatore_protagonista per contenere il personaggio selezionato
         * Una volta scelto viene clonato in list_allenatore_protagonista che conterrà quindi l'allenatore protagonista
         * a cui riferire i metodi per le funzionalità di gioco */
        ArrayList<Allenatore> list_allenatore_protagonista = new ArrayList<>();

        /** Crea Arraylist <Allenatore>list_allenatore_villain che contiene il player sfidante nelle battle */
        ArrayList <Allenatore> list_allenatore_villain = new ArrayList<>();
        list_allenatore_villain.add(teamRocket);
        list_allenatore_villain.add(hash);
        list_allenatore_villain.add(misty);

        /** SEZIONE POKEMON *******************************************************************************************/

        /** Istanze dei 4 Pokemon base selezionabili per "Nuova partita" */
        Charmender charmander0 = new Charmender("Charmander", "Fuoco",false);
        Squirtle squirtle0 = new Squirtle("Squirtle", "Acqua",false);
        Bulbasaur bulbasaur0 = new Bulbasaur("Bulbasaur", "Erba",false);
        Pikachu pikachu0 = new Pikachu("Pikachu", "Elettro",false);

        /*** Istanze dei Pokemon da scoprire o per battle mode ***/
        Jigglypuff jigglypuff = new Jigglypuff("Jigglypuff","Normale/Folletto",false);
        Psyduck psyduck = new Psyduck("Psyduck","Acqua",false);
        Pidgey pidgey = new Pidgey("Pidgey","Aria volo",false);

        /** Aggiunge in lista_pokemon_catturati i pokemon degli allenatori sfidanti per battle mode*/
        /** teamRocket.lista_pokemon_catturati contiene i pokemon che può usare in battle-mode lo sfidante "villain" */
        teamRocket.lista_pokemon_catturati.add(jigglypuff);
        teamRocket.lista_pokemon_catturati.add(psyduck);
        teamRocket.lista_pokemon_catturati.add(pidgey);



        /*** Istanze di abstract Pokemon per le evoluzioni dei pokemon del gioco ***/
        Blastoise blastoise =new Blastoise("Blastoise","Acqua",false);
        Charizard charizard = new Charizard("Charizard","Fuoco",false);
        Venusaur venusaur = new Venusaur("Venusaur","Erba",false);
        Pidgeotto pidgeotto = new Pidgeotto("Pidgeotto","Aria volo",false);
        Pikachu_Fury pikachu_Fury = new Pikachu_Fury("Pikachu Fury","Aria volo",false);



        /** SEZIONE CATALOGO POKEMON **********************************************************************************/

        /** Istanza ArrayList listaPokemon per menu "Catalogo pokemon/Pokemon di base" e aggiunti i pokemon base */
        ArrayList<Pokemon> listaPokemon = new ArrayList<>();
        listaPokemon.add(charmander0);
        listaPokemon.add(squirtle0);
        listaPokemon.add(bulbasaur0);
        listaPokemon.add(pikachu0);

        /** Istanza ArrayList lista_pokemon_scoperti per menu "Catalogo pokemon/Pokemon scoperti */
        ArrayList<Pokemon> lista_pokemon_scoperti = new ArrayList<>();
        Catalogo_pokemonList catalogoPokemonList = new Catalogo_pokemonList(listaPokemon, lista_pokemon_scoperti);



        /** SEZIONE MAIN MENU *****************************************************************************************/

        /** Istanza menu per Main Menù */
        Battle_room battle_room = new Battle_room();

        Menu menu = new Menu();

        /* *Creazione di un thread per fase di avvio gioco, splash screen e welcome message presentati con un ritardo di n millisecondi*/
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                        menu.POKEDEX_TITLE();               /** Splash screen : titles author*/
                    Thread.sleep(3000);
                        menu.messaggio_benvenuto();         /** Welcome message */

                    Thread.sleep(4000);
                    menu.Oak_message_0();               /** Prof.OAk 0 : Introduzione testuale del Game master */
                    Thread.sleep(8000);
                    menu.Oak_message_1();               /** Prof.OAk 1 : Istruzioni uso Main Menu */
                    Thread.sleep(2000);

                    menu.Menu_Principale(list_allenatori, listaPokemon, allenatoreCustom,           /** Lancio del Main Menu */
                            lista_pokemon_scoperti, allenatoreCustom.lista_pokemon_catturati,
                            list_allenatore_protagonista, lista_pokemon_catturati, list_allenatore_villain);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Avvia il thread
        thread.start();
    }
}





