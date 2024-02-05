package a_POKEDEX_main.d_Pokemon.a_Pokemon.Prototypes_pokemon;

import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Random;

/** Sottoclasse di Pokemon per tipo specifico di pokemon base */
public class Squirtle extends Pokemon {

    public Squirtle(String nome, String tipo, boolean preferito) {
        super(nome, tipo, preferito);
    }

    public void evoluzione(ArrayList<Pokemon> lista_pokemon_catturati, Pokemon pokemon) {
        Blastoise blastoise = new Blastoise("Blastoise", "Elettro", false);
        lista_pokemon_catturati.add(blastoise);
        lista_pokemon_catturati.remove(pokemon);
        System.out.println(pokemon.nome + " si è evoluto in Blastoise. Esperienza: " + esperienza);
    }

    @Override
    public void attacca(Pokemon pokemon_villain) {
        Random rand = new Random();
        int pt_attack = rand.nextInt(5) + 10; // Genera un numero tra 10 e 14

        int nuoviPuntiVita = pokemon_villain.puntiVita - pt_attack;
        pokemon_villain.puntiVita = nuoviPuntiVita;

        System.out.print("    Squirtle_HP"+puntiVita+" usa Water Gun: " +
                "\n    " + pokemon_villain.nome + " perde " + pt_attack + " punti vita: puntiVita " + nuoviPuntiVita + ".");
    }

    @Override
    public void difende() {
        puntiVita += 5;
        System.out.print("    Squirtl_HP"+puntiVita+"e si prepara a difendersi con uno Scudo d'Acqua. " +
                "\n    Squirtle puntiVita: " + puntiVita + "");
    }

    @Override
    public void ripristina_puntiVita() {
        puntiVita = 100;
    }
}
