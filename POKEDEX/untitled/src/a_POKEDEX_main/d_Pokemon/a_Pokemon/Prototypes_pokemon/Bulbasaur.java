package a_POKEDEX_main.d_Pokemon.a_Pokemon.Prototypes_pokemon;

import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Random;

/** Sottoclasse di Pokemon per tipo specifico di pokemon base */
public class Bulbasaur extends Pokemon {
    public Bulbasaur(String nome, String tipo, boolean preferito) {
        super(nome, tipo, preferito);
    }

    @Override
    public void evoluzione(ArrayList<Pokemon> lista_pokemon_catturati, Pokemon pokemon) {
        Venusaur venusaur = new Venusaur("Venusaur","Aria-volo",false);
        lista_pokemon_catturati.add(venusaur);
        lista_pokemon_catturati.remove(pokemon);
        System.out.println(pokemon.nome + " si è evoluto in Venusaur. Esperienza: EXP+"+esperienza);
    }

    @Override
    public void attacca(Pokemon pokemon_villain) {
        Random rand = new Random();
        int pt_attack = rand.nextInt(5) + 10; // Genera un numero tra 10 e 14

        int nuoviPuntiVita = pokemon_villain.puntiVita - pt_attack;
        pokemon_villain.puntiVita = nuoviPuntiVita;

        System.out.print("    Bulbasaur_HP"+puntiVita+" usa Sing: " +
                "\n    " + pokemon_villain.nome + " perde " + pt_attack + " punti vita: puntiVita " + nuoviPuntiVita + ".");
    }

    @Override
    public void difende() {
        puntiVita += 5;
        System.out.print("    Bulbasaur_HP"+puntiVita+" si prepara a difendersi con un Ballo. " +
                "\n    Bulbasaur puntiVita: " + puntiVita + "");
    }

    @Override
    public void ripristina_puntiVita() {
        puntiVita = 100; // Aggiorna puntiVita a 200
    }
}


