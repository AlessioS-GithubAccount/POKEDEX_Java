package a_POKEDEX_main.d_Pokemon.a_Pokemon.Prototypes_pokemon;

import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Random;

/** Sottoclasse di Pokemon per tipo specifico di pokemon da scoprire */
public class Jigglypuff extends Pokemon {

    public Jigglypuff(String nome, String tipo, boolean preferito) {
        super(nome, tipo, preferito);
    }

    @Override
    public void evoluzione(ArrayList<Pokemon> lista_pokemon_catturati, Pokemon pokemon) {
        System.out.print("Questo pokemon non ha evoluzioni.");
    }

    @Override
    public void attacca(Pokemon pokemon_villain) {
        Random rand = new Random();
        int pt_attack = rand.nextInt(5) + 10; // Genera un numero tra 10 e 14

        int nuoviPuntiVita = pokemon_villain.puntiVita - pt_attack;
        pokemon_villain.puntiVita = nuoviPuntiVita;

        System.out.print("\n    Jigglypuff_HP"+puntiVita+" usa Sing: " +
                "\n    " + pokemon_villain.nome + " perde " + pt_attack + " punti vita: puntiVita " + nuoviPuntiVita + ".");
    }

    @Override
    public void difende() {
        puntiVita += 5;
        System.out.print("\n    Jigglypuff_HP"+puntiVita+" si prepara a difendersi con una Melodia. " +
                "    Jigglypuff puntiVita: " + puntiVita + "\n");
    }

    @Override
    public void ripristina_puntiVita() {
        puntiVita = 100;
    }
}
