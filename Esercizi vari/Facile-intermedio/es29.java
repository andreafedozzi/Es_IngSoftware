import java.util.*;

public class es29 {
    public static void main(String[] args) {
        ArrayList<Canzone> playlist = new ArrayList<>();

        playlist.add(new Canzone("In Radio", "Marra", 3));
        playlist.add(new Canzone("Ora", "Jovanotti", 3));
        playlist.add(new Canzone("The Nights", "Avicii", 4));

        double durataTotale = Canzone.calcolaDurataTotale(playlist);

        System.out.println("Durata totale della playlist: " + durataTotale + " minuti");
    }
}

class Canzone {
    private String titolo;
    private String artista;
    private double durata;

    public Canzone(String titolo, String artista, double durata) {
        this.titolo = titolo;
        this.artista = artista;
        this.durata = durata;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getArtista() {
        return artista;
    }

    public double getDurata() {
        return durata;
    }

    public static double calcolaDurataTotale(ArrayList<Canzone> playlist) {
        double totale = 0;
        for (Canzone canzone : playlist) {
            totale += canzone.getDurata();
        }
        return totale;
    }
}