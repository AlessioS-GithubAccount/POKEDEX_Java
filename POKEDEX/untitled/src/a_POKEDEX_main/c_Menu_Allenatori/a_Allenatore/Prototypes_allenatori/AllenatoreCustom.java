package a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Prototypes_allenatori;

import a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Allenatore;
import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;

import java.util.ArrayList;
/** Classe AllenatoreCustom per la creazione di allenatori customizzati */
public class AllenatoreCustom extends Allenatore{
    public AllenatoreCustom(String nome, int età, ArrayList<Pokemon> lista_pokemon_catturati) {   //constructor
        super(nome, età, lista_pokemon_catturati);
    }
}
