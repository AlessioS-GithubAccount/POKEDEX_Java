package a_POKEDEX_main.d_Pokemon.a_Pokemon.Prototypes_pokemon;

import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Random;

/** Sottoclasse di Pokemon per tipo specifico di pokemon base */
public class Charmender extends Pokemon {

    public Charmender(String nome, String tipo, boolean preferito) {
        super(nome, tipo, preferito);
    }

    @Override
    public void evoluzione(ArrayList<Pokemon> lista_pokemon_catturati, Pokemon pokemon) {
        Charizard charizard = new Charizard("Charizard","Fuoco",false);
        lista_pokemon_catturati.add(charizard);
        lista_pokemon_catturati.remove(pokemon);
        System.out.println(pokemon.nome + " si è evoluto in Charizard. Esperienza: "+esperienza);
    }

    @Override
    public void attacca(Pokemon pokemon_villain) {
        Random rand = new Random();
        int pt_attack = rand.nextInt(5) + 10; // Genera un numero tra 10 e 14

        int nuoviPuntiVita = pokemon_villain.puntiVita - pt_attack; // Aggiorna i punti vita del Pokémon villain dopo l'attacco
        pokemon_villain.puntiVita = nuoviPuntiVita;

        System.out.print("    Charmander_HP"+puntiVita+" usa Ember: " +
                "\n    " + pokemon_villain.nome + " perde " + pt_attack + " punti vita: puntiVita " + nuoviPuntiVita + ".");
    }

    @Override
    public void difende() {
        puntiVita += 5;
        System.out.print("    Charmander_HP"+puntiVita+" si prepara a difendersi con una Scaglia Infuocata. " +
                "\n    Charmander puntiVita: " + puntiVita + "");
    }

    @Override
    public void ripristina_puntiVita() {
        puntiVita = 100; // Imposta puntiVita a 100
    }
}
