package a_POKEDEX_main.d_Pokemon.a_Pokemon.Prototypes_pokemon;

import a_POKEDEX_main.d_Pokemon.a_Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Random;

/** Sottoclasse di Pokemon per tipo specifico di pokemon da scoprire */
public class Pidgey extends Pokemon {

    public Pidgey(String nome, String tipo, boolean preferito) {
        super(nome, tipo, preferito);
    }


    @Override
    public void evoluzione(ArrayList<Pokemon> lista_pokemon_catturati, Pokemon pokemon) {
        Pidgeotto pidgeotto = new Pidgeotto("Pidgeotto","Aria-volo",false);
        lista_pokemon_catturati.add(pidgeotto);
        lista_pokemon_catturati.remove(pokemon);
        System.out.println(pokemon.nome + " si è evoluto in Pidgeotto. Esperienza: "+esperienza);
    }

    @Override
    public void attacca(Pokemon pokemon_villain) {
        Random rand = new Random();
        int pt_attack = rand.nextInt(5) + 10; // Genera un numero tra 10 e 14

        int nuoviPuntiVita = pokemon_villain.puntiVita - pt_attack;
        pokemon_villain.puntiVita = nuoviPuntiVita;

        System.out.print("\n    Pidgey_HP"+puntiVita+" usa Gust: " +
                "\n    " + pokemon_villain.nome + " perde " + pt_attack + " punti vita: puntiVita " + nuoviPuntiVita + ".\n");
    }

    @Override
    public void difende() {
        puntiVita += 5;
        System.out.print("\n    Pidgey_HP"+puntiVita+" si prepara a difendersi con una Raffica. " +
                "\n     Pidgey puntiVita: " + puntiVita + "\n");
    }

    @Override
    public void ripristina_puntiVita() {
        puntiVita = 100;
    }



        /*public void evoluzione(ArrayList<Pokemon> lista_pokemon_catturati){
        System.out.print("\n__________________________________________________\n");
        System.out.print("EVOLUTION TEMPLE.\n\nScegli un pokemon dal pokedex, Se i suoi punti esperienza sono > 100" +
                " il pokemon può evolvere.\nUsa Rock evolution su pokemon: \n" +
                "[Esc torna indietro]");

        for (Pokemon pokemon:
                lista_pokemon_catturati) {
            System.out.print("\n" + pokemon.nome + " - punti +exp : " + esperienza);
        }

        Pidgeotto pidgeotto = new Pidgeotto("Pidgeotto","Aria-volo",false);

        Scanner myscanner = new Scanner(System.in);
        String str = myscanner.next();

        for (Pokemon pokemon : lista_pokemon_catturati) {
            if (str.equalsIgnoreCase(pokemon.nome) && esperienza>100) {
                lista_pokemon_catturati.add(pidgeotto);
                lista_pokemon_catturati.remove(pokemon);
                System.out.println(pokemon.nome + " si è evoluto in Pidgeotto. Esperienza: "+esperienza);
                break; // Esci dal ciclo una volta che hai trovato il pokemon
            }else {
                System.out.print("Questo pokemon non può ancora evolvere.");
            }

            if (str.equalsIgnoreCase("Esc")) {return;}

            if (lista_pokemon_catturati.isEmpty()) {System.out.println("Pokedex: vuoto\nNon hai pokemon nel tuo pokedex.");}
        }
    }*/
}
