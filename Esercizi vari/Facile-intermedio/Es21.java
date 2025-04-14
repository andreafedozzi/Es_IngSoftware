import java.util.*;

public class GestioneCinema {
    public static void main(String[] args) {
        Sala sala1 = new Sala("Sala 1", 100);
        Film film1 = new Film("Avengers");

        Prenotazione pren1 = new Prenotazione("Andrea", sala1, film1, 3);
        Prenotazione pren2 = new Prenotazione("Marco", sala1, film1, 5);

        sala1.prenotaPosti(pren1);
        sala1.prenotaPosti(pren2);

        System.out.println("Posti disponibili in " + sala1.getNome() + ": " + sala1.getPostiDisponibili());
    }
}

class Sala {
    private String nome;
    private int postiTotali;
    private int postiOccupati;

    public Sala(String nome, int postiTotali) {
        this.nome = nome;
        this.postiTotali = postiTotali;
        this.postiOccupati = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPostiDisponibili() {
        return postiTotali - postiOccupati;
    }

    public void prenotaPosti(Prenotazione prenotazione) {
        int postiRichiesti = prenotazione.getPosti();
        if (postiRichiesti <= getPostiDisponibili()) {
            postiOccupati += postiRichiesti;
            System.out.println("Prenotazione effettuata per " + postiRichiesti + " posti.");
        } else {
            System.out.println("Posti insufficienti!");
        }
    }
}

class Film {
    private String titolo;

    public Film(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }
}

class Prenotazione {
    private String cliente;
    private Sala sala;
    private Film film;
    private int posti;

    public Prenotazione(String cliente, Sala sala, Film film, int posti) {
        this.cliente = cliente;
        this.sala = sala;
        this.film = film;
        this.posti = posti;
    }

    public String getCliente() {
        return cliente;
    }

    public int getPosti() {
        return posti;
    }
}