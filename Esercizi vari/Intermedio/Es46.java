import java.util.*;

public class Es46 {
    public static void main(String[] args){
        GestorePrenotazioni gestore = new GestorePrenotazioni();
        Volo volo = new Volo("Bologna-Londra", "RA192");
        Hotel hotel = new Hotel("Hotel", "londra");

        gestore.prenota(volo);
        gestore.prenota(hotel);

        gestore.cancella(volo);
        gestore.cancella(hotel);
    }
}

interface Prenotabile {
    void prenota();
    void cancella();
}

class Volo implements Prenotabile {
    private String tratta;
    private String codice;

    public Volo(String tratta, String codice){
        this.tratta = tratta;
        this.codice = codice;
    }

    public void prenota(){
        System.out.println("Prenotato volo " + codice + " sulla tratta " + tratta);
    }

    public void cancella(){
        System.out.println("Cancellata prenotazione volo " + codice);
    }
}

class Hotel implements Prenotabile {
    private String nome;
    private String citta;

    public Hotel(String nome, String citta){
        this.nome = nome;
        this.citta = citta;
    }

    public void prenota(){
        System.out.println("Prenotata camera presso " + nome + " a " + citta);
    }

    public void cancella(){
        System.out.println("Cancellata prenotazione presso " + nome);
    }
}

class GestorePrenotazioni {
    private List<Prenotabile> prenotazioni;

    public GestorePrenotazioni(){
        prenotazioni = new ArrayList<>();
    }

    public void prenota(Prenotabile p){
        prenotazioni.add(p);
        p.prenota();
    }

    public void cancella(Prenotabile p){
        prenotazioni.remove(p);
        p.cancella();
    }
}