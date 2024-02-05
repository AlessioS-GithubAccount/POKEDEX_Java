package a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Prototypes_allenatori;

import a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Allenatore;
import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;

import java.util.ArrayList;

/** Sottoclasse Misty di Allenatore default */
public class Misty extends Allenatore {
    public Misty(String nome, int età, ArrayList<Pokemon> lista_pokemon_catturati) {
        super(nome, età, lista_pokemon_catturati);
    }
}
