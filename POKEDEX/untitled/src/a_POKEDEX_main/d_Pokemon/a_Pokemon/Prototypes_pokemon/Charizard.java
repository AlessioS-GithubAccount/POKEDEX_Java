package a_POKEDEX_main.d_Pokemon.a_Pokemon.Prototypes_pokemon;

import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;

import java.util.Random;

/** Evolution pokemon class */
public class Charizard extends Charmender{
    public int puntiVita = 200;

    public Charizard(String nome, String tipo, boolean preferito) {
        super(nome, tipo, preferito);
    }

    @Override
    public void attacca(Pokemon pokemon_villain) {
        Random rand = new Random();
        int pt_attack = rand.nextInt(7) + 14; // Genera un numero tra 14 e 20

        int nuoviPuntiVita = pokemon_villain.puntiVita - pt_attack;
        pokemon_villain.puntiVita = nuoviPuntiVita; // Aggiorna i punti vita del Pokémon villain dopo l'attacco

        System.out.print("    Charizard_HP"+puntiVita+" usa Dragon Claw: " +
                "\n    " + pokemon_villain.nome + " perde " + pt_attack + " punti vita: puntiVita " + nuoviPuntiVita + ".");
    }

    @Override
    public void difende() {
        puntiVita += 10;
        System.out.print("    Charizard_HP"+puntiVita+" si prepara a difendersi con uno Scudo di Fuoco. " +
                "\n    CharizardpuntiVita: " + puntiVita + "");
    }

    @Override
    public void ripristina_puntiVita() {
        puntiVita = 200;
    }
}
