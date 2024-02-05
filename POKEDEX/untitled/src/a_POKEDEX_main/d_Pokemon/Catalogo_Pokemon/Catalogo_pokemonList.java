package a_POKEDEX_main.d_Pokemon.Catalogo_Pokemon;

import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;

import java.util.ArrayList;
/** Classe Catalogo_pokemonList. Le sue istanze contengono :
 * public ArrayList <Pokemon> lista_catalogoPokemon;
 * public ArrayList <Pokemon> lista_pokemon_scoperti;*/
public class Catalogo_pokemonList {
    public ArrayList <Pokemon> lista_catalogoPokemon;
    public ArrayList <Pokemon> lista_pokemon_scoperti;


    public Catalogo_pokemonList(ArrayList<Pokemon> lista_catalogoPokemon,ArrayList<Pokemon> lista_pokemon_scoperti) {
        this.lista_catalogoPokemon = lista_catalogoPokemon;
        this.lista_pokemon_scoperti=lista_pokemon_scoperti;

    }

    public void stampa_lista_catalogoPokemon(ArrayList<Pokemon> lista_catalogoPokemon){
        System.out.println("\nPokemon scoperti: ");
        for (Pokemon pokemon : lista_catalogoPokemon){
            System.out.println(""+pokemon.nome);
        }
    }
}


