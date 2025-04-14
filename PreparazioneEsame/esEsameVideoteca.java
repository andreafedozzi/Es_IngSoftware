import java.util.*;

public class esEsameVideoteca {
    public static void main(String[] args) {
        LibreriaVideogiochi lib = new LibreriaVideogiochi();

        Videogioco v1 = new Videogioco("Fortnite", "Sparatutto", "tutte", 0);
        Videogioco v2 = new Videogioco("Minecraft", "Sandbox", "tutte", 50);

        Utente u1 = new Utente("ABC123","Andrea","andrea@gmail.com");
        Utente u2 = new Utente("DEF456", "Mario", "mario@abcdefg.it");

        Bibliotecario b = new Bibliotecario("Villager", "vill1111");

        b.aggiungiVideogioco(v1, lib);
        b.aggiungiVideogioco(v2, lib);
        
        lib.visualizzaVideogiochi();

        u1.noleggiaVideogioco(v2);

        lib.visualizzaVideogiochiNoleggiatiDaUtente(u1);
        
        u1.restituisciVideogioco(v2);
        lib.visualizzaVideogiochiNoleggiatiDaUtente(u1);

        lib.visualizzaVideogiochi();
    }
}

class Videogioco{
    private String titolo, genere, piattaforma;
    private boolean disponibile;
    private int prezzo;

    public Videogioco(String titolo, String genere, String piattaforma, int prezzo){
        this.titolo = titolo;
        this.genere = genere;
        this.piattaforma = piattaforma;
        this.prezzo = prezzo;
        this.disponibile = true;
    }

    public void setDisponibile(boolean disp){
        this.disponibile = disp;
    }

    public String toString(){
        return this.titolo + " " + this.genere + " " + this.piattaforma + " " + this.prezzo + " " + this.disponibile;
    }

    public boolean isDisponibile(){
        return this.disponibile;
    }

}

class Utente{
    private String idUtente, nome, email;
    private List<Videogioco> videogiochiNoleggiati;

    public Utente(String id, String nome, String email){
        this.idUtente = id;
        this.nome = nome;
        this.email = email;
        videogiochiNoleggiati = new ArrayList<>();
    }

    public void noleggiaVideogioco(Videogioco v){
        if(v.isDisponibile()){
            videogiochiNoleggiati.add(v);
            v.setDisponibile(false); 
        }
    }
    public void restituisciVideogioco(Videogioco v){
        videogiochiNoleggiati.remove(v);
        v.setDisponibile(true);
    }

    public void visualizzaVideogiochi(){
        for(Videogioco v : videogiochiNoleggiati){
            System.out.println(v.toString());
        }
    }

}

class Bibliotecario{
    private String nome, idBibliotecario;

    public Bibliotecario(String nome, String idBibliotecario){
        this.nome = nome;
        this.idBibliotecario = idBibliotecario;
    }

    public void aggiungiVideogioco(Videogioco v, LibreriaVideogiochi l){
        l.aggiungiVideogioco(v);
    }
    public void rimuoviVideogioco(Videogioco v, LibreriaVideogiochi l){
        l.aggiungiVideogioco(v);
    }
}

class LibreriaVideogiochi{
    private List<Videogioco> videogiochidisponibili;
    private List<Utente> utenti;

    public LibreriaVideogiochi(){
        videogiochidisponibili = new ArrayList<>();
        utenti = new ArrayList<>();
    }

    public void aggiungiUtente(Utente u){
        utenti.add(u);
    }
    public void rimuoviUtente(Utente u){
        utenti.remove(u);
    }
    public void aggiungiVideogioco(Videogioco v){
        videogiochidisponibili.add(v);
    }
    public void rimuoviVideogioco(Videogioco v){
        videogiochidisponibili.remove(v);
    }

    public void visualizzaVideogiochi(){
        for(Videogioco v : videogiochidisponibili){
            System.out.println(v.toString());
        }
    }

    public void visualizzaVideogiochiNoleggiatiDaUtente(Utente u){

        u.visualizzaVideogiochi();

    }

}
