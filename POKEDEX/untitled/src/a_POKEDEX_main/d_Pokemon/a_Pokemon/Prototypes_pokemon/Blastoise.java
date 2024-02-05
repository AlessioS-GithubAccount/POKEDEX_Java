package a_POKEDEX_main.d_Pokemon.a_Pokemon.Prototypes_pokemon;

import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;

import java.util.Random;

/** Evolution pokemon class */
public class Blastoise extends Squirtle{
    public int puntiVita = 200;


    public Blastoise(String nome, String tipo, boolean preferito) {
        super(nome, tipo,preferito);
    }  //constructor

    @Override
    public void attacca(Pokemon pokemon_villain) {
        Random rand = new Random();
        int pt_attack = rand.nextInt(7) + 14; // Genera un numero tra 14 e 20

        int nuoviPuntiVita = pokemon_villain.puntiVita - pt_attack;
        pokemon_villain.puntiVita = nuoviPuntiVita;   //aggiorna i punti vita del pokemon villain dopo attacco subito

        System.out.print("    Blastoise_HP"+puntiVita+" usa Hydro Pump: " +
                "\n    " + pokemon_villain.nome + " perde " + pt_attack + " punti vita: puntiVita " + nuoviPuntiVita + ".");
    }

    @Override
    public void difende() {
        puntiVita += 10;
        System.out.print("    Blastoise_HP"+puntiVita+" si prepara a difendersi con uno Scudo d'Acqua. " +
                "\n    Blastoise puntiVita: " + puntiVita + "");
    }

    @Override
    public void ripristina_puntiVita() {
        puntiVita = 200;
    }

}

