package a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Prototypes_allenatori;

import a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Allenatore;
import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;

import java.util.ArrayList;

/** Sottoclasse Team Rocket di Allenatore per istanziare allenatori "villain" */
public class Team_Rocket extends Allenatore {
    public ArrayList<Pokemon> pokemon_fighter;   //arraylist necessario ad accogliere i pokemon del villain che combattono in battle room

    public Team_Rocket(String nome, int età, ArrayList<Pokemon> lista_pokemon_catturati, ArrayList<Pokemon> pokemon_fighter) {
        super(nome, età, lista_pokemon_catturati); // Chiama il costruttore della classe madre Allenatore
        this.pokemon_fighter = pokemon_fighter;
    }


}


