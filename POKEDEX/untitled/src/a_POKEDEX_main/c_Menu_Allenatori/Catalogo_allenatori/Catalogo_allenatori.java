package a_POKEDEX_main.c_Menu_Allenatori.Catalogo_allenatori;

import a_POKEDEX_main.c_Menu_Allenatori.a_Allenatore.Allenatore;

import java.util.ArrayList;

/** Classe List_allenatori per istanza che accoglie le liste allenatori da cui attingere per le funzionalità di gioco :
 * ArrayList <Allenatore> list_allenatori = new ArrayList<>();
 * ArrayList <Allenatore> list_allenatore_protagonista = new ArrayList<>(); */
public class Catalogo_allenatori {
    ArrayList <Allenatore> list_allenatori = new ArrayList<>();     //accoglie tutti gli allenatori
    ArrayList <Allenatore> list_allenatore_protagonista = new ArrayList<>();        //accoglie solo il personaggi oselezionato per la partita
    ArrayList <Allenatore> list_allenatore_villain = new ArrayList<>();     //accoglie il villain

    public Catalogo_allenatori() {  //constructor
        this.list_allenatori =list_allenatori;
        this.list_allenatore_protagonista =list_allenatore_protagonista;
    }
}
