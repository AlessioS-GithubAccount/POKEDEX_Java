package a_POKEDEX_main.d_Pokemon.a_Pokemon;

import java.util.ArrayList;
/** Abstract class Pokemon: implementazione dei metodi in sottoclassi Package.d_Pokemon.a_Pokemon.Prototypes_pokemon */

public abstract class Pokemon {
    public String nome;
    public String tipo;
    public int puntiVita = 20;  // Tutti i pokemon di default partono con puntiVita e esperienza già preimpostati
    public int esperienza = 0;
    public boolean preferito;

    public Pokemon(String nome, String tipo, int puntiVita, int esperienza, boolean preferito) {
        this.nome = nome;
        this.tipo = tipo;
        this.puntiVita = puntiVita;
        this.esperienza = esperienza;
        this.preferito = preferito;
    }

    public Pokemon(String nome, String tipo, boolean preferito) {
        this.nome = nome;
        this.tipo = tipo;
        this.preferito = preferito;
    }


    public abstract void evoluzione(ArrayList<Pokemon> lista_pokemon_catturati, Pokemon pokemon);
    public abstract void attacca(Pokemon pokemon);
    public abstract void difende();
    public abstract void ripristina_puntiVita();
}

